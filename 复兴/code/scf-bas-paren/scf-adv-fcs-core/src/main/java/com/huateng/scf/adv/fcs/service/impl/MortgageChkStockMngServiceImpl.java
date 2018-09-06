package com.huateng.scf.adv.fcs.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.huateng.scf.adv.fcs.dao.IMortgageChkStockMngDAO;
import com.huateng.scf.adv.fcs.model.BPbcWhseInspectVo;
import com.huateng.scf.adv.fcs.service.ImortgageChkStockMngService;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.MonitorProtocolVO;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.cnt.service.IMonitorProtocolService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmMoniEntInfo;
import com.huateng.scf.bas.crm.service.IBCrmMoniEntInfoService;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.pbc.dao.IBPbcWhseInspectDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcWhseInspect;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.server.annotation.ScubeService;
import com.ibatis.common.logging.Log;
import com.ibatis.common.logging.LogFactory;

@ScubeService
@Service("mortgageChkStockMngServiceImpl")
public class MortgageChkStockMngServiceImpl implements ImortgageChkStockMngService {
	
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "mortgageChkStockMngDAO")
	private IMortgageChkStockMngDAO mortgageChkStockMngDAO;
	
	@Resource(name = "bCntMprotPartInfoService")
	private IBCntMprotPartInfoService bCntMprotPartInfoService;
	
	@Resource(name = "bCntMprotBaseInfoService")
	private IBCntMprotBaseInfoService bCntMprotBaseInfoService;
	
	@Resource(name = "bCrmMoniEntInfoService")
	private IBCrmMoniEntInfoService bCrmMoniEntInfoService;
	
	@Resource(name = "bCrrGntyConService")
	private IBCrrGntyConService bCrrGntyConService;
	
	@Resource(name = "AmountServiceImpl")
	private IAmountService amountService;
	
	@Autowired
	private IBPbcWhseInspectDAO bPbcWhseInspectDAO;
	
	@Resource(name = "BSysSerialNoServiceImpl")
	private IBSysSerialNoService bSysSerialNoService;// 流水号生成服务
	
	@Resource(name = "BNteNoticeBaseDAO")
	private IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	
	@Resource(name = "bPrdInfoService")
	private IBPrdInfoService bPrdInfoService;
	
	@Resource(name = "bCrrLnConService")
	private IBCrrLnConService bCrrLnConService;
	
	@Resource(name = "monitorProtocolService")
	private IMonitorProtocolService monitorProtocolService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
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
		mortgageChkStockMngDAO.queryCheckStockByPage(param, page);
		
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
		mortgageChkStockMngDAO.queryPclInfoByPage(param, page);
		
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
		if(param.containsKey("id")){
			List<Map<String, Object>> list = mortgageChkStockMngDAO.queryCekStkDetailById(param, page);
			BPbcWhseInspectVo bPbcWhseInspectVo = (BPbcWhseInspectVo)list.get(0);
			
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
			BCntMprotPartInfo bPartInfo = bCntMprotPartInfoService.findCoreorCustByProtocolNo(param.get("prtclNo").toString(), ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
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
			
			BCrmMoniEntInfo bCrmMoniEntInfo = new BCrmMoniEntInfo();
			bCrmMoniEntInfo.setCustcd(bPartInfo.getCustcd());
			bCrmMoniEntInfo = bCrmMoniEntInfoService.findBCrmMoniEntInfoByKey(bCrmMoniEntInfo);
			//监管模式
			if(bCrmMoniEntInfo != null)bPbcWhseInspect.setMoniWarehouseType(bCrmMoniEntInfo.getMonitortype());
			
			bPbcWhseInspect.setAppDate(ScfCommonUtil.dateForm(ScfBaseData.getScfGlobalInfo().getTxnDate()));	// 登记时间
			UserInfo UserInfo = ContextHolder.getUserInfo();
			bPbcWhseInspect.setTlrcd(UserInfo.getTlrNo());	// 登记人
			bPbcWhseInspect.setTlrName(UserInfo.getTlrName());	// 登记人姓名
			bPbcWhseInspect.setInspectElement22(bCrrGntyCon.getGutId());	//	授信企业id
			bPbcWhseInspect.setInspectElement27(bCrrGntyCon.getLowPriceNew() == null ? "0.00" : bCrrGntyCon.getLowPriceNew().toString());	//	授信企业名称
			//计算敞口
			AmountVO amountVo = new AmountVO();
			amountVo.setProductId(bCrrGntyCon.getVidPrdId());
			String conId = bCrrGntyCon.getConId();
			if(!conId.startsWith("GYCON")){//获取业务申请时获得的抵质押合同号
				MonitorProtocolVO m = monitorProtocolService.monitorProtocolQuery(bCrrGntyCon.getPrtclNo());
				BCrrLnCon bCrrLnCon = new BCrrLnCon();
				bCrrLnCon.setVidNo(m.getOtherprotocolNo());
				Page p = bCrrLnConService.findBCrrLnConByPage(1, 10, bCrrLnCon);
				try{
					Object o = p.getRecords().get(0);
					String b = ((Map<String, Object>)o).get("appId").toString();
					BCrrGntyCon bc = new BCrrGntyCon();
					bc.setAppId(b);
					p = bCrrGntyConService.findConBCrrGntyConByPage(1, 10, bc);
					o = p.getRecords().get(0);
					conId = ((Map<String, Object>)o).get("conId").toString();
				}catch (IndexOutOfBoundsException e){
					e.printStackTrace();
					log.info("根据协议号: " + m.getOtherprotocolNo() + " 找不到对应的业务流水号！");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			amountVo.setSlaveContno(conId);
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
			Map<String, Object> result = mortgageChkStockMngDAO.getMortgageSumCountPriceByParam(param2);
			bPbcWhseInspect.setTotalPrice(result.get("SUMPRICE") == null ? BigDecimal.ZERO : (BigDecimal)result.get("SUMPRICE"));
			bPbcWhseInspect.setInspectElement25((BigDecimal)result.get("SUMAMOUNT"));
			bPbcWhseInspect.setInspectElement26(bPbcWhseInspect.getTotalPrice());
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
	public void addWhseInspectDetail(BPbcWhseInspectVo bPbcWhseInspectVo) {
		BPbcWhseInspect bPbcWhseInspect = new BPbcWhseInspect();
		
		BeanUtils.copyProperties(bPbcWhseInspectVo, bPbcWhseInspect);
		bPbcWhseInspect.setOperType(ScfBasConstant.OPER_TYPE_CHECK);
		
		bPbcWhseInspect.setAppDate(bPbcWhseInspect.getAppDate().replaceAll("-", ""));
		
		if(StringUtil.isStrEmpty(bPbcWhseInspect.getId())){
			//核库信息保存
			bPbcWhseInspect.setInspectElement31(bPbcWhseInspectVo.getConId());
			
			String checkReportNo = bSysSerialNoService.genSerialNo(ScfBasConstant.VALUE_INDEX_CHECK_REPORT_NO);
			bPbcWhseInspect.setInspectReportNo(checkReportNo);
			bPbcWhseInspect.setId(UUIDGeneratorUtil.generate());
			bPbcWhseInspectDAO.insertSelective(bPbcWhseInspect);
			
			
			//核库通知书保存
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
			bNteNoticeBase.setExt1(checkReportNo);//核库编号
			bNteNoticeBase.setBrcode(ScfBaseData.getScfGlobalInfo().getBrCode());
			bNteNoticeBase.setTlrn(ScfBaseData.getScfGlobalInfo().getTlrNo());
			bNteNoticeBaseDAO.insertSelective(bNteNoticeBase);
		}else{
			//核库信息修改
			bPbcWhseInspectDAO.updateByPrimaryKeySelective(bPbcWhseInspect);
		}
	}

	@Override
	public Page queryMortInfo(int pageNo, int pageSize, Map<String, Object> param) {
		Page page = new Page(pageSize, pageNo, 0);
		mortgageChkStockMngDAO.queryMortInfo(param, page);
		return page;
	}
}
