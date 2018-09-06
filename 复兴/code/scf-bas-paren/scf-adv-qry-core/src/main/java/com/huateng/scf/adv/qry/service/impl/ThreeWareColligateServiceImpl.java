package com.huateng.scf.adv.qry.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.qry.dao.IThreeWareColligateDAO;
import com.huateng.scf.adv.qry.dao.model.ThreeWareVO;
import com.huateng.scf.adv.qry.model.ContBaseResultVO;
import com.huateng.scf.adv.qry.service.IThreeWareColligateService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.qry.dao.IDebtPoolGenerateDAO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
@ScubeService
@Service("ThreeWareColligateServiceImpl")
public class ThreeWareColligateServiceImpl implements IThreeWareColligateService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = IThreeWareColligateService.BEAN_ID)
	IThreeWareColligateService threeWareColligateService; 
	 
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@Resource(name = "amountService")
	IAmountService amountService;  
	@Resource(name = "ThreeWareColligateDAO")
	private IThreeWareColligateDAO threeWareColligateDAO;
	@Resource(name="IBCrrLnConDAO")
	IBCrrLnConDAO bcrrlncondao;
	@Resource(name="DebtPoolGenerateDAO")
	IDebtPoolGenerateDAO debtPoolGenerateDAO;
	@Resource(name="BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO bLanAppliLnciBaseDAO;
	@Resource(name="BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;
	
	 
	@SuppressWarnings("unchecked")
	@Override
	public Page queryColligateByPage(int pageNo, int pageSize, Map<String, Object> param) throws ScubeBizException {
		log.info("台帐综合查询");
		Page page = new Page(pageSize, pageNo, 0);
		 //数据权限控制：1、默认查询出当前登录人机构及其以下机构信息 2、查询条件已经选了机构的,根据已选择的查询信息
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
	    ArrayList<String> arrBr = new ArrayList<String>();
		if(param.get("brcode")!=null){
			arrBr.add(param.get("brcode").toString());
 		}else{
			List<BctlVO> bctList = scubeUserService.getBrListByBrNo(brCode,ScfCommonUtil.getBrManagerNo(scubeUserService));
			for(BctlVO bctlVO : bctList){
				String brNo = bctlVO.getBrNo();
				arrBr.add(brNo);
			}
		}
		param.put("arrBr", arrBr);
		threeWareColligateDAO.selectByPage(param, page);
		List<ThreeWareVO> list = page.getRecords();
		List<ThreeWareVO> response = new ArrayList<ThreeWareVO>();
		if(list!=null&&list.size()>0){
			Iterator<?> iter=list.iterator();
			while(iter.hasNext()){
				ThreeWareVO temp = (ThreeWareVO) iter.next();
				
				if(StringUtil.isStrNotEmpty(temp.getBrcode())){
					BctlVO bctl = scubeUserService.selectBctlByBrNo(temp.getBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					if(null!=bctl){
						temp.setBrcode(bctl.getBrName());
					}
				}
				if(StringUtil.isStrNotEmpty(temp.getTlrno())){
					UserInfo userInfo = scubeUserService.selectUserByTlrNo(temp.getTlrno(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					if(null!=userInfo){
						temp.setTlrno(userInfo.getTlrName());
					}
				}
				response.add(temp);
			}
		}
		
		page.setRecords(response);
		return page;
	}

	@Override
	public com.huateng.scf.adv.qry.model.ThreeWareVO getColligateInfo(String protocolNo) throws ScubeBizException {
		if(StringUtil.isEmpty(protocolNo)){
			throw new ScubeBizException("参数不存在",RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		com.huateng.scf.adv.qry.model.ThreeWareVO Vo = new com.huateng.scf.adv.qry.model.ThreeWareVO();
		//融资金额
		Map<String,Object> lnciAmtMap = threeWareColligateDAO.getLnciAmtByProtocolNo(protocolNo);
		if(null!=lnciAmtMap){
			Vo.setLnciAmt(null==lnciAmtMap.get("LNCIAMT")?BigDecimal.ZERO:new BigDecimal(lnciAmtMap.get("LNCIAMT").toString()));
		}
		//融资余额
		Map<String,Object> lnciBalMap = threeWareColligateDAO.getLnciBalByProtocolNo(protocolNo);
		if(null!=lnciBalMap){
			Vo.setLnciBal(null==lnciBalMap.get("LNCIBAL")?BigDecimal.ZERO:new BigDecimal(lnciBalMap.get("LNCIBAL").toString()));
		}
		//保证金金额汇总
		Map<String,Object> bailAmountMap = threeWareColligateDAO.getBailAmountByProtocolNo(protocolNo);
		if(null!=bailAmountMap){
			Vo.setBailAmount(null==bailAmountMap.get("BAILAMOUNT")?BigDecimal.ZERO:new BigDecimal(bailAmountMap.get("BAILAMOUNT").toString()));
		}
		//现金等价物金额
		Map<String,Object> cashEqtAmountMap = threeWareColligateDAO.getCashEqtAmountByProtocolNo(protocolNo);
		if(null!=cashEqtAmountMap){
			Vo.setCashEqtAmt(null==cashEqtAmountMap.get("CASHEQTAMT")?BigDecimal.ZERO:new BigDecimal(cashEqtAmountMap.get("CASHEQTAMT").toString()));
		}
		//剩余可提货金额
		Map<String,Object> AmountInMap = threeWareColligateDAO.getAmountInByProtocolNo(protocolNo);
		if(null!=AmountInMap){
			Vo.setAmountIn(null==AmountInMap.get("AMOUNTIN")?BigDecimal.ZERO:new BigDecimal(AmountInMap.get("AMOUNTIN").toString()));
		}
		//累计已提货金额
		Map<String,Object> AmountOutMap = threeWareColligateDAO.getAmountOutByProtocolNo(protocolNo);
		if(null!=AmountOutMap){
			Vo.setAmountOut(null==AmountOutMap.get("AMOUNTOUT")?BigDecimal.ZERO:new BigDecimal(AmountOutMap.get("AMOUNTOUT").toString()));
		}
		 
		 return Vo;
	}

	@Override
	public Page getContBaseInfoListBySlaveContno(int pageNo, int pageSize,String protocolNo) throws ScubeBizException {
		log.info("台账查询信贷合同信息");
		if(StringUtil.isEmpty(protocolNo)){
			throw new ScubeBizException("参数不存在",RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		Page page = new Page(pageSize, pageNo, 0);
		List<ContBaseResultVO> list = new ArrayList<ContBaseResultVO>();
		BCrrLnConExample example = new BCrrLnConExample();
		com.huateng.scf.bas.crr.dao.model.BCrrLnConExample.Criteria cri = example.createCriteria();
		if(protocolNo!=null&&!"".equals(protocolNo))
		{
			cri.andVidNoEqualTo(protocolNo);
		}
		List<BCrrLnCon> crrLnList = bcrrlncondao.selectByPage(example,page);
		for(BCrrLnCon crrLn : crrLnList){
			ContBaseResultVO contBaseResultVO=new ContBaseResultVO();
			BeanUtils.copyProperties(crrLn, contBaseResultVO);
			Map<String,String> param = new HashMap<String,String>();
			param.put("protocolNo", protocolNo); 
			param.put("mastContNo", crrLn.getAppId());
			List<Map<String, String>> sumList = debtPoolGenerateDAO.getFourProtocolTotalLnciAmtByProtocolNo(param);
			if(null!=sumList&&sumList.size()>0){
				Object bailAmount = sumList.get(0).get("BAILAMOUNT");
				Object cashEqtAmt = sumList.get(0).get("EQTAMT");

				contBaseResultVO.setBailAmount(bailAmount ==null?BigDecimal.ZERO:new BigDecimal(bailAmount.toString())); //信贷合同下借据保证金金额汇总
				contBaseResultVO.setCashEqtAmt(cashEqtAmt==null?BigDecimal.ZERO:new BigDecimal(cashEqtAmt.toString())); //信贷合同下现金等价物价值总计
			}
			//TODO BCrrLnCon表没有cycle字段，先用循环-1 替代
			BigDecimal contRistAmtTemp = amountService.getContRiskAmtByCycle(crrLn.getAppId(),"1");
			BigDecimal riskAmt= crrLn.getLnAmt();//TODO  BCrrLnCon表没有riskAmt字段
	    	contBaseResultVO.setAvaliableRiskAmt(riskAmt.subtract(contRistAmtTemp));
			
			list.add(contBaseResultVO);
		}
		page.setRecords(list);
		return page;
	}

	@Override
	public Page getThreeWareLnciList(int pageNo, int pageSize, String protocolNo) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		List<ThreeWareVO> list = new ArrayList<ThreeWareVO>();
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		if(protocolNo!=null&&!"".equals(protocolNo))
		{
			cri.andProtocolNoEqualTo(protocolNo);
		}
		cri.andStateEqualTo(ScfBasConstant.FLAG_OFF);
		List<BLanLnciBase> lnciList = bLanLnciBaseDAO.selectByPage(example,page);
		for(BLanLnciBase lnci : lnciList){
			ThreeWareVO threeWareVO = new ThreeWareVO();
			BeanUtils.copyProperties(lnci, threeWareVO);
			BigDecimal bailAmount = lnci.getBailAmount()==null?BigDecimal.ZERO:lnci.getBailAmount();
			BigDecimal addBailAmount = lnci.getAddBailAmount()==null?BigDecimal.ZERO:lnci.getAddBailAmount();
			BigDecimal initCashEqtAmt = lnci.getInitCashEqtAmt()==null?BigDecimal.ZERO:lnci.getInitCashEqtAmt();
			BigDecimal addCashEqtAmt = lnci.getAddCashEqtAmt()==null?BigDecimal.ZERO:lnci.getAddCashEqtAmt();
			//应收欠息
			BigDecimal receivableInt=lnci.getReceivableInt()==null?BigDecimal.ZERO:lnci.getReceivableInt();
			BigDecimal receivablePunishInt=lnci.getReceivablePunishInt()==null?BigDecimal.ZERO:lnci.getReceivablePunishInt();
			//催收欠息
			BigDecimal collectionInt=lnci.getCollectionInt()==null?BigDecimal.ZERO:lnci.getCollectionInt();
			BigDecimal	collectionPunishInt=lnci.getCollectionPunishInt()==null?BigDecimal.ZERO:lnci.getCollectionPunishInt();
			BigDecimal compoundInt=lnci.getCompoundInt()==null?BigDecimal.ZERO:lnci.getCompoundInt();
			//表内欠息
			BigDecimal tabIntAmt=receivableInt.add(receivablePunishInt);
			//表外欠息
			BigDecimal tabOutAmt=collectionInt.add(collectionPunishInt).add(compoundInt);

			threeWareVO.setCommonDate(lnci.getCommonDate());
			threeWareVO.setBailAmount(bailAmount.add(addBailAmount));
			threeWareVO.setCashEqtAmt(initCashEqtAmt.add(addCashEqtAmt));
			threeWareVO.setTotalRateRemainAmount(tabIntAmt.add(tabOutAmt));//欠息总额
			
			list.add(threeWareVO);
		}
		page.setRecords(list);
		return page;
	}

	
	 
}
