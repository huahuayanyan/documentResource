package com.huateng.scf.adv.fcs.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.fcs.dao.IBPbcMtgChkStockDtlDAO;
import com.huateng.scf.adv.fcs.dao.IInspectWhseMngDAO;
import com.huateng.scf.adv.fcs.model.BPbcMtgChkStockDtl;
import com.huateng.scf.adv.fcs.model.BPbcWhseInspectVo;
import com.huateng.scf.adv.fcs.service.IinspectWhseMngService;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmMoniEntInfo;
import com.huateng.scf.bas.crm.service.IBCrmMoniEntInfoService;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.pbc.dao.IBPbcWhseInspectDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcWhseInspect;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("inspectWhseMngServiceImpl")
public class InspectWhseMngServiceImpl implements IinspectWhseMngService {
	
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "inspectWhseMngDAO")
	private IInspectWhseMngDAO inspectWhseMngDAO;
	
	@Resource(name = "bCntMprotPartInfoService")
	private IBCntMprotPartInfoService bCntMprotPartInfoService;
	
	@Resource(name = "bCntMprotBaseInfoService")
	private IBCntMprotBaseInfoService bCntMprotBaseInfoService;
	
	@Resource(name = "bCrmMoniEntInfoService")
	private IBCrmMoniEntInfoService bCrmMoniEntInfoService;
	
	@Resource(name = "bCrrGntyConService")
	private IBCrrGntyConService bCrrGntyConService;
	
	@Resource(name = "amountService")
	private IAmountService amountService;
	
	@Autowired
	private IBPbcWhseInspectDAO bPbcWhseInspectDAO;
	
	@Resource(name = "BSysSerialNoServiceImpl")
	private IBSysSerialNoService bSysSerialNoService;// 流水号生成服务
	
	@Resource(name = "BNteNoticeBaseDAO")
	private IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	
	@Resource(name = "BPbcMtgChkStockDtlDAO")
	private IBPbcMtgChkStockDtlDAO bPbcMtgChkStockDtlDAO;
	
	@Resource(name = "bPrdInfoService")
	private IBPrdInfoService bPrdInfoService;
	
	
	@Override
	public Page queryCheckStockByPage(int pageNo, int pageSize, Map<String,Object> param) {
		Object conId = param.get("protNo");
		Object dateFrom = param.get("dateFrom");
		Object dateTo = param.get("dateTo");
		Object prdId = param.get("prdId");
		if(!StringUtil.isEmpty(conId)) {
			param.put("protNo", conId.toString().toLowerCase());
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
		
		String productId = bPrdInfoService.getProductIdByFlag(param.get("flag").toString());
		if(!StringUtil.isEmpty(prdId) && !productId.equals(prdId)){
			param.put("productId", "-1");
		}else{
			param.put("productId", productId);
		}
		
		Page page = new Page(pageSize, pageNo, 0);
		inspectWhseMngDAO.queryCheckStockByPage(param, page);
		
		List<Map<String,Object>> list = page.getRecords();
		for (int i = 0; i < list.size(); i++) {
			Map<String,Object> map = list.get(i);
			if(map.get("APP_DATE") != null){
				map.put("APP_DATE", ScfCommonUtil.dateForm(map.get("APP_DATE").toString()));
			}
			
			//查询机构名称
			Object brcode = list.get(i).get("BRCODE");
			if(!StringUtil.isEmpty(brcode)){
				BctlVO bctl = scubeUserService.selectBctlByBrNo(brcode.toString(),ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(null!=bctl){
					map.put("BRNAME", bctl.getBrName());// 将查询结果赋值于页面创建人代码。
				}
			}
			
			//查询客户经理
			Object tlrCd = map.get("TLRCD");
			if(!StringUtil.isEmpty(tlrCd)){
				UserInfo userInfo2 = new UserInfo();
				userInfo2.setTlrNo(tlrCd.toString());
				List<TlrInfoVO> userList2 = userService.selectByExample(userInfo2);
				if (userList2 != null && userList2.size() == 1) {
					map.put("TLRNAME", userList2.get(0).getTlrName());
				}
			}
		}
		return page;
	}

	@Override
	public Page queryPclInfoByPage(int pageNo, int pageSize, Map<String, Object> param) {
		Object conId = param.get("conId");
		if(!StringUtil.isEmpty(conId)) {
			param.put("conId", conId.toString().toLowerCase());
		}
		
		String productId = bPrdInfoService.getProductIdByFlag(param.get("flag").toString());
		param.put("productId", productId);
		
		Page page = new Page(pageSize, pageNo, 0);
		inspectWhseMngDAO.queryPclInfoByPage(param, page);
		
		List<Map<String,Object>> list = page.getRecords();
		for (int i = 0; i < list.size(); i++) {
			Map<String,Object> map = list.get(i);
			if(map.get("START_DATE") != null){
				map.put("START_DATE", ScfCommonUtil.dateForm(map.get("START_DATE").toString()));
			}
			if(map.get("END_DATE") != null){
				map.put("END_DATE", ScfCommonUtil.dateForm(map.get("END_DATE").toString()));
			}
			//查询机构名称
			Object brcode = list.get(i).get("BRCODE");
			if(!StringUtil.isEmpty(brcode)){
				BctlVO bctl = scubeUserService.selectBctlByBrNo(brcode.toString(),ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(null!=bctl){
					map.put("BRNAME", bctl.getBrName());// 将查询结果赋值于页面创建人代码。
				}
			}
			//查询客户经理
			Object tlrNo = map.get("TLRNO");
			if(!StringUtil.isEmpty(tlrNo)){
				UserInfo userInfo2 = new UserInfo();
				userInfo2.setTlrNo(tlrNo.toString());
				List<TlrInfoVO> userList2 = userService.selectByExample(userInfo2);
				if (userList2 != null && userList2.size() == 1) {
					map.put("TLRNAME", userList2.get(0).getTlrName());
				}
			}
		}
		return page;
	}

	@Override
	public Page queryCekStkDetailById(Map<String, Object> param) {
		Page page = new Page(10, 1, 0);
		BCntMprotPartInfo bPartInfo = bCntMprotPartInfoService.findCoreorCustByProtocolNo(param.get("prtclNo").toString(), ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		BCrmMoniEntInfo bCrmMoniEntInfo = new BCrmMoniEntInfo();
		bCrmMoniEntInfo.setCustcd(bPartInfo.getCustcd());
		bCrmMoniEntInfo = bCrmMoniEntInfoService.findBCrmMoniEntInfoByKey(bCrmMoniEntInfo);
		
		if(param.containsKey("id")){
			List<Map<String, Object>> list = inspectWhseMngDAO.queryCekStkDetailById(param, page);
			BPbcWhseInspectVo bPbcWhseInspectVo = (BPbcWhseInspectVo)list.get(0);
			if(bCrmMoniEntInfo != null)bPbcWhseInspectVo.setMoniWarehouseType(bCrmMoniEntInfo.getMonitortype());
			
			if(!param.containsKey("view")){//修改时
				UserInfo userInfo = ContextHolder.getUserInfo();
				bPbcWhseInspectVo.setTlrcd(userInfo.getTlrNo());	// 登记人
				bPbcWhseInspectVo.setTlrName(userInfo.getTlrName());	// 登记人姓名
				BctlVO bctlVO = ContextHolder.getOrgInfo();
				bPbcWhseInspectVo.setBrcode(bctlVO.getBrNo());
				bPbcWhseInspectVo.setBrName(bctlVO.getBrName());
			}
		}else{
			List<BPbcWhseInspectVo> list = new ArrayList<BPbcWhseInspectVo>();
			BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(param.get("conId").toString());
			BCntMprotBaseInfo bBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(param.get("prtclNo").toString());
			BPbcWhseInspectVo bPbcWhseInspect = new BPbcWhseInspectVo();
			bPbcWhseInspect.setProductId(bBaseInfo.getProductId());
			bPbcWhseInspect.setProtocolNo(bBaseInfo.getProtocolNo());
			
			BctlVO bctlVO = ContextHolder.getOrgInfo();
			
			bPbcWhseInspect.setBrcode(bctlVO.getBrNo());
			if(!StringUtil.isStrEmpty(bctlVO.getBrNo())){
				BctlVO bctl = scubeUserService.selectBctlByBrNo(bctlVO.getBrNo(),ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(null!=bctl){
					bPbcWhseInspect.setBrName(bctl.getBrName());// 登记机构名称
				}
			}
			bPbcWhseInspect.setCustCd(bPartInfo.getCustcd());	//	监管公司ID
			
			//监管模式
			if(bCrmMoniEntInfo != null) bPbcWhseInspect.setMoniWarehouseType(bCrmMoniEntInfo.getMonitortype());
			
			bPbcWhseInspect.getMoniWarehouseType();
			
//			bPbcWhseInspect.setAppDate(ScfCommonUtil.dateForm(ScfBaseData.getScfGlobalInfo().getTxnDate()));	// 登记时间
			bPbcWhseInspect.setAppDate(ScfBaseData.getScfGlobalInfo().getTxnDate());	// 登记时间
			UserInfo UserInfo = ContextHolder.getUserInfo();
			bPbcWhseInspect.setTlrcd(UserInfo.getTlrNo());	// 登记人
			bPbcWhseInspect.setTlrName(UserInfo.getTlrName());	// 登记人姓名
			bPbcWhseInspect.setInspectElement22(bCrrGntyCon.getGutId());	//	授信企业id
			bPbcWhseInspect.setInspectElement27(bCrrGntyCon.getLowPriceNew() == null ? "0.00" : bCrrGntyCon.getLowPriceNew().toString());	//	授信企业名称
			//计算敞口
			AmountVO amountVo = new AmountVO();
			amountVo.setProductId(bCrrGntyCon.getVidPrdId());
			amountVo.setSlaveContno(bCrrGntyCon.getConId());
			BigDecimal debtAmount = amountService.getPant(amountVo);
			bPbcWhseInspect.setInspectElement28(debtAmount);
			bPbcWhseInspect.setInspectElement23(bCrrGntyCon.getMoniMd());	//质押模式
			//如果监管模式为动态的，需要显示最低控价值
			if(ScfBasConstant.MONI_MODEL_DYNAMIC.equals(bCrrGntyCon.getMoniMd())){
				if(!StringUtil.isEmpty(bCrrGntyCon.getLowPriceNew()))
					bPbcWhseInspect.setInspectElement24(bCrrGntyCon.getLowPriceNew().toString());  //最低控货价值
			}
			
			Map<String, Object> param2 = new HashMap<String, Object>();
			param2.put("slaveContno", param.get("conId").toString());
			Map<String, Object> result = inspectWhseMngDAO.getMortgageSumCountPriceByParam(param2);
			bPbcWhseInspect.setTotalPrice(result.get("SUMPRICE") == null ? BigDecimal.ZERO : (BigDecimal)result.get("SUMPRICE"));
//			bPbcWhseInspect.setInspectElement25((BigDecimal)result.get("SUMAMOUNT"));
//			bPbcWhseInspect.setInspectElement26(bPbcWhseInspect.getTotalPrice());
			//新增时默认为0
			bPbcWhseInspect.setInspectElement25(BigDecimal.ZERO);
			bPbcWhseInspect.setInspectElement26(BigDecimal.ZERO);
			bPbcWhseInspect.setInspectElement31(param.get("conId").toString());
			
			if(!StringUtil.isEmpty(bCrrGntyCon.getRation()))
				bPbcWhseInspect.setInspectElement29(bCrrGntyCon.getRation().toString());
			
			list.add(bPbcWhseInspect);
			page.setRecords(list);
		}
		return page;
	}

	@Override
	@Transactional
	public void addWhseInspectDetail(BPbcWhseInspectVo bPbcWhseInspectVo)throws ScubeBizException{
		BPbcWhseInspect bPbcWhseInspect = new BPbcWhseInspect();
		
		BeanUtils.copyProperties(bPbcWhseInspectVo, bPbcWhseInspect);
		bPbcWhseInspect.setOperType(ScfBasConstant.OPER_TYPE_INSPECT);
		
		bPbcWhseInspect.setAppDate(bPbcWhseInspect.getAppDate().replaceAll("-", ""));
		
		//删除押品信息
		if(!StringUtil.isEmpty(bPbcWhseInspectVo.getId()))
			bPbcMtgChkStockDtlDAO.deleteByTblId(bPbcWhseInspectVo.getId());
		
		//修改监管模式
		BCntMprotPartInfo bPartInfo = bCntMprotPartInfoService.findCoreorCustByProtocolNo(bPbcWhseInspectVo.getProtocolNo(), ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		BCrmMoniEntInfo bCrmMoniEntInfo = new BCrmMoniEntInfo();
		bCrmMoniEntInfo.setCustcd(bPartInfo.getCustcd());
		bCrmMoniEntInfo.setMonitortype(bPbcWhseInspectVo.getMoniWarehouseType());
		int bCrmMoniEntInfoResultCount = bCrmMoniEntInfoService.update(bCrmMoniEntInfo);
		
		if(StringUtil.isStrEmpty(bPbcWhseInspect.getId())){
			//巡库信息保存
			bPbcWhseInspect.setInspectElement31(bPbcWhseInspectVo.getConId());
			
			String inspectReportNo = bSysSerialNoService.genSerialNo(ScfBasConstant.VALUE_INDEX_INSPECT_REPORT_NO);
			bPbcWhseInspect.setInspectReportNo(inspectReportNo);
			bPbcWhseInspect.setId(UUIDGeneratorUtil.generate());
			bPbcWhseInspectVo.setId(bPbcWhseInspect.getId());
			bPbcWhseInspectDAO.insertSelective(bPbcWhseInspect);
			
			
			//巡库通知书保存
			String slaveContno = bPbcWhseInspect.getInspectElement31();
			BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(slaveContno);
			BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
			bNteNoticeBase.setId(UUIDGeneratorUtil.generate());
			bNteNoticeBase.setAppno(bSysSerialNoService.genSerialNo(ScfBasConstant.VALUE_INDEX_APP_NO));
			bNteNoticeBase.setMonitorProtocolNo(bCrrGntyCon.getPrtclNo());
			bNteNoticeBase.setProtocolCode(null);
			bNteNoticeBase.setSlaveContno(slaveContno);
			bNteNoticeBase.setSlaveContcode(bCrrGntyCon.getConId());
			bNteNoticeBase.setCustcd(bCrrGntyCon.getTlrNo());
			bNteNoticeBase.setMoniOfCustcd(bPbcWhseInspect.getCustCd());
			bNteNoticeBase.setNoticeType("73");//NOTICE_TYPE_73
			bNteNoticeBase.setMoniOfDate(null);
			bNteNoticeBase.setAppliDate(ScfBaseData.getScfGlobalInfo().getTxnDate());
			bNteNoticeBase.setMoniOfName(null);
			bNteNoticeBase.setStatus("00");//NOTICE_BASE_STATUS_UNCONFIRM
			bNteNoticeBase.setPledgeMode(bCrrGntyCon.getMoniMd());
			bNteNoticeBase.setExt1(inspectReportNo);//巡库编号
			bNteNoticeBase.setBrcode(ScfBaseData.getScfGlobalInfo().getBrCode());
			bNteNoticeBase.setTlrn(ScfBaseData.getScfGlobalInfo().getTlrNo());
//			bNteNoticeBaseDAO.insertSelective(bNteNoticeBase);
		}else{
			//巡库信息修改
			bPbcWhseInspectDAO.updateByPrimaryKeySelective(bPbcWhseInspect);
		}
		
		//巡库押品信息保存
		List<Map<String, Object>> mtgBaseList = bPbcWhseInspectVo.getMtgBaseList();
		
		if(mtgBaseList != null && mtgBaseList.size() > 0){
			for(int i =0; i< mtgBaseList.size(); i++){
				Map<String, Object> map = mtgBaseList.get(i);
				BPbcMtgChkStockDtl bPbcMtgChkStockDtl = new BPbcMtgChkStockDtl();
				bPbcMtgChkStockDtl.setId(UUIDGeneratorUtil.generate());
				bPbcMtgChkStockDtl.setTblId(bPbcWhseInspectVo.getId());
				if(!StringUtil.isEmpty(map.get("QUANTITY"))){
					String quantity = map.get("QUANTITY").toString();
					bPbcMtgChkStockDtl.setEntityQuantity(BigDecimal.valueOf(Double.valueOf(quantity)));
					bPbcMtgChkStockDtl.setStockQuantity(BigDecimal.valueOf(Double.valueOf(quantity)));
				}
				bPbcMtgChkStockDtl.setType(ScfBasConstant.CHK_STOCK_DTL_TYPE_INSPECT);
				
				if(!StringUtil.isEmpty(map.get("MORTGAGE_NO")))bPbcMtgChkStockDtl.setMortgageNo(map.get("MORTGAGE_NO").toString());
				if(!StringUtil.isEmpty(map.get("MORTGAGE_CLASS_NO")))bPbcMtgChkStockDtl.setMortgageClassNo(map.get("MORTGAGE_CLASS_NO").toString());
				if(!StringUtil.isEmpty(map.get("MORTGAGE_MODEL")))bPbcMtgChkStockDtl.setMortgageModel(map.get("MORTGAGE_MODEL").toString());
				if(!StringUtil.isEmpty(map.get("CONFIRM_PRICE")))bPbcMtgChkStockDtl.setConfirmPrice(BigDecimal.valueOf(Double.valueOf(map.get("CONFIRM_PRICE").toString())));
				if(!StringUtil.isEmpty(map.get("TOT_PRICE")))bPbcMtgChkStockDtl.setTotPrice(BigDecimal.valueOf(Double.valueOf(map.get("TOT_PRICE").toString())));
				if(!StringUtil.isEmpty(map.get("MORTGAGE_LEVEL_ONE")))bPbcMtgChkStockDtl.setMortgageLevelOne(map.get("MORTGAGE_LEVEL_ONE").toString());
				if(!StringUtil.isEmpty(map.get("MORTGAGE_LEVEL_TWO")))bPbcMtgChkStockDtl.setMortgageLevelTwo(map.get("MORTGAGE_LEVEL_TWO").toString());
				if(!StringUtil.isEmpty(map.get("MORTGAGE_UNITS")))bPbcMtgChkStockDtl.setMortgageUnits(map.get("MORTGAGE_UNITS").toString());
				if(!StringUtil.isEmpty(map.get("PRODUCT_AREA")))bPbcMtgChkStockDtl.setProductArea(map.get("PRODUCT_AREA").toString());
				if(!StringUtil.isEmpty(map.get("VENDER")))bPbcMtgChkStockDtl.setVender(map.get("VENDER").toString());
				if(!StringUtil.isEmpty(map.get("WAREHOUSE_ADDRESS")))bPbcMtgChkStockDtl.setWarehouseAddress(map.get("WAREHOUSE_ADDRESS").toString());
				
				if(!StringUtil.isEmpty(map.get("WEIGHT_UNITS")))bPbcMtgChkStockDtl.setQuantityunit(map.get("WEIGHT_UNITS").toString());
				
				bPbcMtgChkStockDtlDAO.insert(bPbcMtgChkStockDtl);
			}
		}
		
	}

	@Override
	public Page queryMortInfo(int pageNo, int pageSize, Map<String, Object> param) {
		Page page = new Page(pageSize, pageNo, 0);
		inspectWhseMngDAO.queryMortInfo(param, page);
		return page;
	}
	
	@Override
	public Page queryInspectMortInfo(int pageNo, int pageSize, Map<String, Object> param) {
		Page page = new Page(pageSize, pageNo, 0);
		inspectWhseMngDAO.queryInspectMortInfo(param, page);
		return page;
	}
}
