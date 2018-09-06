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
import com.huateng.scf.adv.qry.dao.IFourServiceDAO;
import com.huateng.scf.adv.qry.service.IFranchiserProtocolMngService;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.FourProtocolVO;
import com.huateng.scf.bas.cnt.model.FourWareLoanVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.qry.dao.IDebtPoolGenerateDAO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("FranchiserProtocolMngServiceImpl")
public class FranchiserProtocolMngServiceImpl implements IFranchiserProtocolMngService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = IFranchiserProtocolMngService.BEAN_ID)
	IFranchiserProtocolMngService franchiserProtocolMngService; 
	 
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@Resource(name = "BCntMprotBaseInfoDAO")
	private IBCntMprotBaseInfoDAO bCntMprotBaseInfoDAO;   
	@Resource(name = "FourServiceDAO")
	private IFourServiceDAO fourServiceDAO;
	@Resource(name="IBCrrLnConDAO")
	IBCrrLnConDAO bcrrlncondao;
	@Resource(name="DebtPoolGenerateDAO")
	IDebtPoolGenerateDAO debtPoolGenerateDAO;
	@Resource(name="BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO bLanAppliLnciBaseDAO;
	@Resource(name="BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;
	@Resource(name = "amountService")
	IAmountService amountService;
	
//	private static final String SELLERNM = "sellerNm";
//	private static final String STATE = "state";
//	private static final String FOUNAME = "fouName";
//	private static final String PROTOCOLNO = "protocolNo";
//	private static final String CORENM = "coreNm";
//	private static final String PROTOCOLTYPE = "protocolType";
	private static final String ROLECREDIT = "roleCredit";
	private static final String ROLECORE = "roleCore";
	private static final String ROLEBACKCORE = "roleBackcore";
	private static final String ROLEMONI = "roleMoni";
//	private static final String PRODUCTID = "productId";
	
	@SuppressWarnings("unchecked")
	@Override
	public Page queryFranchiserProtocolByPage(int pageNo, int pageSize, Map<String, Object> param) throws ScubeBizException {
		log.info("先票/款后货：台帐综合查询");
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
		
		param.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);// 经销商
		param.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);// 核心厂商
		param.put(ROLEBACKCORE, ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);// 回购厂商
		param.put(ROLEMONI, ScfBasConstant.PROTOCOL_PART_ROLE_MONI);// 监管公司
		bCntMprotBaseInfoDAO.getFourAgreementQuery(param, page);// 分页查询
		List<FourProtocolVO> list = page.getRecords();
		List<FourProtocolVO> response = new ArrayList<FourProtocolVO>();
		if(list!=null&&list.size()>0){
			Iterator<?> iter=list.iterator();
			while(iter.hasNext()){
				FourProtocolVO temp = (FourProtocolVO) iter.next();
				
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
	public FourWareLoanVO getFourProtocolInfo(String protocolNo) throws ScubeBizException {
		if(StringUtil.isEmpty(protocolNo)){
			throw new ScubeBizException("参数不存在",RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		FourWareLoanVO fourWareLoanVO = new FourWareLoanVO();
		BigDecimal amountIn=BigDecimal.ZERO;//剩余提货（出账）金额
		BigDecimal amountOut=BigDecimal.ZERO;//累计提货金额（向监管）
		BigDecimal amountUpOut=BigDecimal.ZERO;//向核心厂商累计提货金额
		BigDecimal loanAmt=BigDecimal.ZERO;//累计出账金额
		BigDecimal pledgeAmt=BigDecimal.ZERO;//累计已出质金额
		BigDecimal amount =BigDecimal.ZERO;//可提货金额
		BigDecimal totAmt =BigDecimal.ZERO;//在押货物总价值
		BigDecimal sumBailAmount=BigDecimal.ZERO;//保证金及现金等价物汇总金额
		Map<String,Object> sumMap = fourServiceDAO.getKindsOfSum(protocolNo);
		if(null!=sumMap){
			loanAmt=sumMap.get("LOANAMT")!=null?(BigDecimal)sumMap.get("LOANAMT"):BigDecimal.ZERO;
			pledgeAmt=sumMap.get("PLEDGEAMT")!=null?(BigDecimal)sumMap.get("PLEDGEAMT"):BigDecimal.ZERO;
			amountIn=sumMap.get("AMOUNTIN")!=null?(BigDecimal)sumMap.get("AMOUNTIN"):BigDecimal.ZERO;
			amountOut=sumMap.get("AMOUNTOUT")!=null?(BigDecimal)sumMap.get("AMOUNTOUT"):BigDecimal.ZERO;
			amountUpOut=sumMap.get("AMOUNTUPOUT")!=null?(BigDecimal)sumMap.get("AMOUNTUPOUT"):BigDecimal.ZERO;
		}
		totAmt = fourServiceDAO.getSumPriceByParam(protocolNo);
		fourWareLoanVO.setAmount(amount);
		fourWareLoanVO.setTotAmt(totAmt);
		fourWareLoanVO.setLnciAmt(loanAmt);
		fourWareLoanVO.setLnciBal(pledgeAmt);
		fourWareLoanVO.setAmountIn(amountIn);
		fourWareLoanVO.setAmountOut(amountOut);
		fourWareLoanVO.setAmountUpOut(amountUpOut);
		fourWareLoanVO.setSumBailAmount(sumBailAmount);   
		//台账综合查询增加：收款总金额、已发货金额、未发货金额
		Map<String,Object> amtMap = fourServiceDAO.getFourWareDeliveryAmt(protocolNo);
		if(null!=amtMap){
			fourWareLoanVO.setLoanAmt(amtMap.get("LOANAMT")==null?BigDecimal.ZERO:(BigDecimal)amtMap.get("LOANAMT"));
			fourWareLoanVO.setUndeliveryAmt(amtMap.get("BALSENDAMT")==null?BigDecimal.ZERO:(BigDecimal)amtMap.get("BALSENDAMT"));
			fourWareLoanVO.setAmountOut(amtMap.get("ACCUSENDAMT")==null?BigDecimal.ZERO:(BigDecimal)amtMap.get("ACCUSENDAMT"));
//			tblMutiProtDealInfo.setAmountOut(amtObjs[2]==null?BigDecimal.ZERO:(BigDecimal)amtObjs[2]);
		}
		//台账综合查询增加：融资金额、融资余额、保证金金额总计、现金等价物金额总计
		Map<String,Object> amtResult = fourServiceDAO.getFourProtocolTotalLnciAmtByProtocolNo(protocolNo);
		if(null!=amtResult){
			fourWareLoanVO.setTotLnciAmt(amtResult.get("LNCIAMT")==null?BigDecimal.ZERO:(BigDecimal)amtResult.get("LNCIAMT")); //融资金额
			fourWareLoanVO.setTotLnciBal(amtResult.get("LNCIBAL")==null?BigDecimal.ZERO:(BigDecimal)amtResult.get("LNCIBAL")); //融资余额
			fourWareLoanVO.setTotBailAmount(amtResult.get("BAILADDAMT")==null?BigDecimal.ZERO:((BigDecimal)amtResult.get("BAILADDAMT"))); //保证金金额总计
			fourWareLoanVO.setTotCashEqtAmt(amtResult.get("INITADDAMT")==null?BigDecimal.ZERO:((BigDecimal)amtResult.get("INITADDAMT"))); //现金等价物金额总计
		}
		return fourWareLoanVO;
	}

	@Override
	public Page getFourMastContInfoByParam(int pageNo, int pageSize, String protocolNo) throws ScubeBizException {
		log.info("台账查询信贷合同信息");
		if(StringUtil.isEmpty(protocolNo)){
			throw new ScubeBizException("参数不存在",RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		Page page = new Page(pageSize, pageNo, 0);
		List<FourWareLoanVO> list = new ArrayList<FourWareLoanVO>();
		BCrrLnConExample example = new BCrrLnConExample();
		com.huateng.scf.bas.crr.dao.model.BCrrLnConExample.Criteria cri = example.createCriteria();
		if(protocolNo!=null&&!"".equals(protocolNo))
		{
			cri.andVidNoEqualTo(protocolNo);
		}
		List<BCrrLnCon> crrLnList = bcrrlncondao.selectByPage(example,page);
		for(BCrrLnCon crrLn : crrLnList){
			FourWareLoanVO vo = new FourWareLoanVO();
			vo.setMastContcode(crrLn.getAppId()==null?"":(String)crrLn.getAppId()); //信贷合同文本编号
			vo.setContAmount(crrLn.getLnAmt()==null?BigDecimal.ZERO:(BigDecimal)crrLn.getLnAmt()); //信贷合同金额
			vo.setRiskAmt(crrLn.getLnAmt()==null?BigDecimal.ZERO:(BigDecimal)crrLn.getLnAmt()); //信贷合同总敞口---TODO暂时没这个字段，用合同金额替代
			vo.setAvaliableRiskAmt(crrLn.getLnSum()==null?BigDecimal.ZERO:(BigDecimal)crrLn.getLnSum());	//信贷合同可用敞口
			vo.setStartDate(crrLn.getLnStrtDt()==null?null:crrLn.getLnStrtDt()); //合同生效日
			vo.setEndDate(crrLn.getLnEndDt()==null?null:crrLn.getLnEndDt()); //合同到期日
			vo.setMastContno(crrLn.getAppId()==null?"":crrLn.getAppId()); //信贷合同号
			Map<String,String> param = new HashMap<String,String>();
			param.put("protocolNo", protocolNo); 
			param.put("mastContno", crrLn.getAppId());
			List<Map<String, String>> sumList = debtPoolGenerateDAO.getFourProtocolTotalLnciAmtByProtocolNo(param);
			if(null!=sumList&&sumList.size()>0){
				vo.setTotBailAmount(sumList.get(0).get("bailamount")==null?BigDecimal.ZERO:new BigDecimal(sumList.get(0).get("bailamount"))); //信贷合同下借据保证金金额汇总
				vo.setTotCashEqtAmt(sumList.get(0).get("eqtamt")==null?BigDecimal.ZERO:new BigDecimal(sumList.get(0).get("eqtamt"))); //信贷合同下现金等价物价值总计
			}
			//TODO BCrrLnCon表没有cycle字段，先用循环-1 替代
			BigDecimal contRistAmtTemp = amountService.getContRiskAmtByCycle(crrLn.getAppId(),"1");
			BigDecimal riskAmt= crrLn.getLnAmt();//TODO  BCrrLnCon表没有riskAmt字段
			vo.setAvaliableRiskAmt(riskAmt.subtract(contRistAmtTemp));
			list.add(vo);
		}
		page.setRecords(list);
		return page;
	}

	@Override
	public Page getFourProtocolLnciList(int pageNo, int pageSize, String protocolNo) throws ScubeBizException {
		log.info("台账查询-借据信息");
		if(StringUtil.isEmpty(protocolNo)){
			throw new ScubeBizException("参数不存在",RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("protocolNo",protocolNo);
		Page page = new Page(pageSize, pageNo, 0);
		List<FourWareLoanVO> list = new ArrayList<FourWareLoanVO>();
		List<BLanLnciBase> lnciList = bLanLnciBaseDAO.getFourLnciInfoListPageByParams(params, page);
		for(BLanLnciBase lnci : lnciList){
			FourWareLoanVO fourVO = new FourWareLoanVO();
			BeanUtils.copyProperties(lnci, fourVO);
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

			fourVO.setCommonDate(lnci.getCommonDate());
			fourVO.setTotBailAmount(bailAmount.add(addBailAmount));
			fourVO.setTotCashEqtAmt(initCashEqtAmt.add(addCashEqtAmt));
			fourVO.setTotalRateRemainAmount(tabIntAmt.add(tabOutAmt));//欠息总额
			
			list.add(fourVO);
		}
		page.setRecords(list);
		return page;
	}
	
}