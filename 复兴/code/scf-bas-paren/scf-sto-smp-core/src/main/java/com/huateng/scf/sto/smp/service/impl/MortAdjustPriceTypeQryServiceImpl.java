package com.huateng.scf.sto.smp.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample.Criteria;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfoExample;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.IBPrdMortDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.prd.dao.model.BPrdMort;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.service.IBSysCommonService;
import com.huateng.scf.sto.smp.dao.IMortAdjustPriceTypeQryDAO;
import com.huateng.scf.sto.smp.model.BCrrGntyConResultVO;
import com.huateng.scf.sto.smp.service.IMortAdjustPriceTypeQryService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("MortAdjustPriceTypeQryServiceImpl")
public class MortAdjustPriceTypeQryServiceImpl implements IMortAdjustPriceTypeQryService {
	
	@Resource(name="mortAdjustPriceTypeQryDAO")
	IMortAdjustPriceTypeQryDAO mortAdjustPriceTypeQryDAO;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name="bSysCommonService")
	IBSysCommonService bSysCommonService;
	
	@Resource(name="bPbcMtgClassService")
	IBPbcMtgClassService bPbcMtgClassService;
	
	@Resource(name="userService")
	UserService userService;
	
	@Resource(name="bPrdInfoService")
	IBPrdInfoService bPrdInfoService;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@Resource(name="BLanLnciBaseDAO")
	IBLanLnciBaseDAO iBLanLnciBaseDAO;
	
	@Resource(name="BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO iBPbcAppliBaseInfoDAO;
	
	@Resource(name = "amountService")
	IAmountService amountService; //金额
	//押品信息
	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bPbcMtgBaseInfoService;
	
	@Resource(name="IBPrdMortDAO")
	IBPrdMortDAO iBPrdMortDAO;
	
	@Resource(name="BPrdInfoDAO")
	IBPrdInfoDAO iBPrdInfoDAO;

	@Override
	public Page getAdjustPriceTypeList(int pageNo,int pageSize,Map<String, Object> param) {
		Page page = new Page(pageSize, pageNo, 0);
		
		Object conId = param.get("slaveContno");
		Object dateFrom = param.get("dateFrom");
		Object dateTo = param.get("dateTo");
		if(!StringUtil.isEmpty(conId)){
			param.put("slaveContno", conId.toString().toLowerCase());
		}
		if(!StringUtil.isEmpty(dateFrom)) {
			try {
				param.put("dateFrom", ScfDateUtil.toDate(dateFrom.toString(), "yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(!StringUtil.isEmpty(dateTo)) {
			try {
				param.put("dateTo", ScfDateUtil.toDate(dateTo.toString(), "yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if(param.get("brCode") != null && param.get("brName") != null){
			BctlVO bctlVO = new BctlVO();
			bctlVO.setBrNo(param.get("brCode") == null ? null : param.get("brCode").toString());
			bctlVO.setBrName(param.get("brName") == null ? null : param.get("brName").toString());
			Page cooperationBrcodeInfo = bSysCommonService.selectBranchInfo(1, 10, bctlVO);
			List records = cooperationBrcodeInfo.getRecords();
			if (records == null || records.size() != 1) {
				throw new ScubeBizException("经办机构名称与经办机构号不对应,请通过查询按钮选择[经办机构]！");
			}
		}
		
		String productId = bPrdInfoService.getProductIdByFlag(param.get("flag").toString());
		param.put("productId", productId);
		
		if(param.containsKey("One")) bPbcMtgClassService.checkMtgInfo(param.get("One"), param.get("oneName"), "请通过查询按钮选择[押品一级]！");
		if(param.containsKey("Two")) bPbcMtgClassService.checkMtgInfo(param.get("Two"), param.get("twoName"), "请通过查询按钮选择[押品二级]！");
		if(param.containsKey("Three")) bPbcMtgClassService.checkMtgInfo(param.get("Three"), param.get("threeName"), "请通过查询按钮选择[押品三级]！");
		
		mortAdjustPriceTypeQryDAO.selectByPage(param, page);
		Iterator<Map<String, Object>> it = page.getRecords().iterator();
		while(it.hasNext()){
			Map<String, Object> map = it.next();
			
			Object brcode = map.get("BR_CD");
			if(!StringUtil.isEmpty(brcode)){
				BctlVO bctl = scubeUserService.selectBctlByBrNo(brcode.toString(),ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(null!=bctl){
					map.put("BRNAME", bctl.getBrName());// 将查询结果赋值于页面创建人代码。
				}
			}
			
			//查询客户经理
			Object tlrCd = map.get("TLR_NO");
			if(!StringUtil.isEmpty(tlrCd)){
				UserInfo userInfo2 = new UserInfo();
				userInfo2.setTlrNo(tlrCd.toString());
				List<TlrInfoVO> userList2 = userService.selectByExample(userInfo2);
				if (userList2 != null && userList2.size() == 1) {
					map.put("TLR_NM", userList2.get(0).getTlrName());
				}
			}
		}
		return page;
	}

	@Override
	public Page integratedLedgersQry(int pageNo, int pageSize, Map<String, Object> param) {
		Page scfPage = new Page(pageSize, pageNo, 0);
		List listNew = new ArrayList();
		try {
			List<BCrrGntyCon> list = bcrrgntycondao.getSlaveContList2(param, scfPage);// 分页查询
			for (BCrrGntyCon bCrrGntyCon : list) {
				BCrrGntyConResultVO vo = new BCrrGntyConResultVO();
				BeanUtils.copyProperties(bCrrGntyCon, vo);
				//计算敞口
				AmountVO amountVO=new AmountVO();
				amountVO.setProductId(bCrrGntyCon.getVidPrdId());
				amountVO.setSlaveContno(bCrrGntyCon.getConId());
				BigDecimal openAmount=amountService.getPant(amountVO)==null?BigDecimal.ZERO:amountService.getPant(amountVO);
				vo.setOpenAmount(openAmount);//敞口
				Map<String,String > mapLnci = new HashMap<String, String>();
				mapLnci.put("slaveContno", bCrrGntyCon.getConId());
				mapLnci.put("state", ScfBasConstant.FLAG_ON);

				BigDecimal totalLnciAmt=iBLanLnciBaseDAO.queryLnciAmtBySlaveContno(mapLnci);
				
				//获取在库押品价值
				BigDecimal sendMortAmountSum = BigDecimal.ZERO;
				HashMap<String, Object> mapSumprice = new HashMap<String, Object>();
				mapSumprice.put("slaveContno", bCrrGntyCon.getConId());
				sendMortAmountSum =  bPbcMtgBaseInfoService.getMortgageSumPriceByParam(mapSumprice);
				vo.setMortgageAmount(sendMortAmountSum);
				vo.setTotalLnciAmt(totalLnciAmt);
				vo.setDeliveryAmt(sendMortAmountSum.subtract(bCrrGntyCon.getLowPriceNew()==null?BigDecimal.ZERO:bCrrGntyCon.getLowPriceNew()));
				BPrdMort bPrdMort=iBPrdMortDAO.selectByPrimaryKey(bCrrGntyCon.getVidPrdId());
				if((null!=bPrdMort)&&(ScfBasConstant.MONI_MODEL_STATIC.equals(bPrdMort.getMoniType()))){//动产静态·
					if(null!=bCrrGntyCon.getRation()&&(bCrrGntyCon.getRation().compareTo(BigDecimal.ZERO)>0)){
						vo.setLowPriceNew(openAmount.multiply(new BigDecimal(100)).divide(bCrrGntyCon.getRation(),2,BigDecimal.ROUND_HALF_UP));
						vo.setDeliveryAmt(sendMortAmountSum.subtract(vo.getLowPriceNew()==null?BigDecimal.ZERO:vo.getLowPriceNew()));
					}
				}
				BPrdInfo bPrdInfo =iBPrdInfoDAO.selectByPrimaryKey(bCrrGntyCon.getVidPrdId());
				if((null!=bPrdInfo)&&
						((ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(bPrdInfo.getParentId())||(ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(bPrdInfo.getParentId()))))){
					//汽车货押 或者四方
					if(null!=bCrrGntyCon.getRation()&&(bCrrGntyCon.getRation().compareTo(BigDecimal.ZERO)>0)){
						vo.setLowPriceNew(openAmount.multiply(new BigDecimal(100)).divide(bCrrGntyCon.getRation(),2,BigDecimal.ROUND_HALF_UP));
						vo.setDeliveryAmt(sendMortAmountSum.subtract(vo.getLowPriceNew()==null?BigDecimal.ZERO:vo.getLowPriceNew()));
					}
				}

				//通过质押合同号去查询是否存在有审批中的放款。
				vo.setCheckFlag("0");
				
				BLanLnciBaseExample example = new BLanLnciBaseExample();
				Criteria c = example.createCriteria();
				if(bCrrGntyCon.getConId()!=null && !StringUtil.isEmpty(bCrrGntyCon.getConId()))
					c.andSlaveContnoEqualTo(bCrrGntyCon.getConId());
				List listTemp = iBLanLnciBaseDAO.selectByExample(example);
				if(listTemp !=null && listTemp.size() > 0)
				{
					vo.setCheckFlag("1");
				}
				
				BPbcAppliBaseInfoExample example2 = new BPbcAppliBaseInfoExample();
				com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfoExample.Criteria c2 = example2.createCriteria();
				if(bCrrGntyCon.getConId()!=null && !StringUtil.isEmpty(bCrrGntyCon.getConId()))
					c.andSlaveContnoEqualTo(bCrrGntyCon.getConId());
				List listTemp1 = iBPbcAppliBaseInfoDAO.selectByExample(example2);
				if(listTemp1 !=null && listTemp1.size() >0)
				{
					vo.setCheckFlag("1");
				}

				listNew.add(vo);

			}
			
			scfPage.setRecords(listNew);
		} catch (Exception e) {
			throw new ScubeBizException("综合台帐查询失败!");
		}
		return scfPage;
	}
	
}
