/**
 * 
 */
package com.huateng.scf.bas.cnt.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotCmInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.ext.ExtIBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import com.huateng.scf.bas.cnt.dao.model.ext.DataItems;
import com.huateng.scf.bas.cnt.dao.model.ext.MonitorProtocolInfo;
import com.huateng.scf.bas.cnt.model.DataItemsDO;
import com.huateng.scf.bas.cnt.model.DataItemsVO;
import com.huateng.scf.bas.cnt.model.MonitorProtocolDO;
import com.huateng.scf.bas.cnt.model.MonitorProtocolVO;
import com.huateng.scf.bas.cnt.service.IMonitorProtocolService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.model.BCrmMoniEntInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crm.service.IBCrmEntInfoService;
import com.huateng.scf.bas.crm.service.IBCrmMoniEntInfoService;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConExample;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.prd.dao.model.BPrdInfoExample;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月22日下午4:53:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日下午4:53:26              新增
 *
 *            </pre>
 */
@ScubeService
@Service("MonitorProtocolServiceImpl")
public class MonitorProtocolServiceImpl implements IMonitorProtocolService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private static final String PROTOCOLCODE = "protocolCode";
	private static final String SECNAME = "secName";
	private static final String THRNAME = "thrName";
	private static final String SUPPPRODUCTNAME = "suppProductName";
	private static final String PARENTID = "parentId";
	private static final String ROLEBANK = "roleBank";
	private static final String ROLEMONI = "roleMoni";
	private static final String ROLECREDIT = "roleCredit";
	private static final String PROTOCOLTYPE = "protocolType";


	@Resource(name = "ExtBCntMprotBaseInfoDAO")
	ExtIBCntMprotBaseInfoDAO extIBCntMprotBaseInfoDAO;

	@Resource(name = "BSysSerialNoServiceImpl")
	private IBSysSerialNoService bSysSerialNoService;// 流水号生成服务

	@Resource(name = "BCntMprotBaseInfoDAO")
	private IBCntMprotBaseInfoDAO bCntMprotBaseInfoDAO;

	@Resource(name = "BCntMprotPartInfoDAO")
	private IBCntMprotPartInfoDAO bCntMprotPartInfoDAO;

	@Resource(name = "BCntMprotCmInfoDAO")
	private IBCntMprotCmInfoDAO bCntMprotCmInfoDAO;

	@Resource(name = "BPrdInfoDAO")
	private IBPrdInfoDAO bPrdInfoDAO;

	@Resource(name = "BCrmBaseInfoServiceImpl")
	private IBCrmBaseInfoService bCrmBaseInfoService;

	@Resource(name = "BCrmEntInfoServiceImpl")
	private IBCrmEntInfoService bCrmEntInfoService;

	@Resource(name = "IBCrmMoniEntInfoServiceImpl")
	private IBCrmMoniEntInfoService bCrmMoniEntInfoService;

	@Resource(name = "BLanLnciBaseDAO")
	private IBLanLnciBaseDAO bLanLnciBaseDAO;
	
	@Resource(name="IBCrrGntyConDAO")
	private IBCrrGntyConDAO iBCrrGntyConDAO;

	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name="BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO iBCntMprotBaseInfoDAO;


	@Resource(name="ContractServiceImpl")
	private IContractService ContractServiceImpl;
	
	@SuppressWarnings("unchecked")
	@Override
	public Page queryMonitorProtocolListByPage(int pageNo, int pageSize, MonitorProtocolDO monitorProtocol, String parentId)
			throws ScubeBizException {
		log.info("protocolCode" + monitorProtocol.getProtocolCode());
		Map<String, String> map = new HashMap<String, String>();
		Page scfPage = new Page();
		scfPage.setPageNo(pageNo);
		scfPage.setPageSize(pageSize);
		if (null != monitorProtocol) {
			String protocolCode = monitorProtocol.getProtocolCode();// 监管合同号
			String secName = monitorProtocol.getSecName();// 出质人名称
			String thrName = monitorProtocol.getThrName();// 监管公司名称
			String suppProductName = monitorProtocol.getProductId();// 业务品种
			if (StringUtil.isStrNotEmpty(protocolCode)) {
				map.put(PROTOCOLCODE, protocolCode);
			}
			if (StringUtil.isStrNotEmpty(secName)) {
				map.put(SECNAME, secName);
			}
			if (StringUtil.isStrNotEmpty(thrName)) {
				map.put(THRNAME, thrName);
			}
			if (StringUtil.isStrNotEmpty(suppProductName)) {
				map.put(SUPPPRODUCTNAME, suppProductName);
			}
		}
		if (null != parentId)
			map.put(PARENTID, parentId);

		map.put(ROLEBANK, ScfBasConstant.PROTOCOL_PART_ROLE_BANK);
		map.put(ROLEMONI, ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		map.put(PROTOCOLTYPE, ScfBasConstant.MUTI_PROTOCOL_MONI);//协议类型，监管协议
		Page resultPage = extIBCntMprotBaseInfoDAO.queryMonitorProtocolList(scfPage, map, true);// 分页查询
		List<MonitorProtocolInfo> MonitorProtocolInfo = resultPage.getRecords();
		List<MonitorProtocolInfo> response = new ArrayList<MonitorProtocolInfo>();
		for (MonitorProtocolInfo info : MonitorProtocolInfo) {
			if (StringUtil.isStrNotEmpty(info.getBrcode())) {
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(info.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				info.setCooperationBrcodeNm(bctlVO.getBrName());
				BctlVO brcode = scubeUserService.selectBctlByBrNo(info.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				info.setBrcodeNm(brcode.getBrName());
			}

			UserInfo userInfo = scubeUserService.selectUserByTlrNo(info.getTlrNo(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			info.setTlrName(userInfo.getTlrName());
			info.setBrcode(info.getBrcode());
			response.add(info);
		}
		resultPage.setRecords(response);
		if (null != resultPage) {
			log.info("=====================TotalPage>>>" + resultPage.getTotalPage());
			log.info("=====================TotalRecord>>>" + resultPage.getTotalRecord());
		}

		return resultPage;

	}

	@Override
	@Transactional
	public void monitorProtocolAdd(MonitorProtocolVO monitorProtocolVO) throws ScubeBizException {

		// 1.校验客户
		if (null == monitorProtocolVO) {
			log.error("monitorProtocolVO参数对象不能为空！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20002), BCntErrorConstant.SCF_BAS_CNT_20002);
		}
		// if (ToolUtil.stringCheck(monitorProtocolVO.getPriceDropRate())) {
		// if (monitorProtocolVO.getPriceDropRate()) {
		// throw new ScubeBizException(ErrorMsgConstant.ICCS_CU_10010167);
		// } else if (!ToolUtil.isMec(param.getReason())) {
		// throw new ScubeBizException(ErrorMsgConstant.ICCS_CU_10010167);
		// }
		// }
		if (null == monitorProtocolVO.getSecCd()) {
			log.error("出质人号为空！");
			throw new ScubeBizException("出质人不存在!");
		}
		if (null == monitorProtocolVO.getThrCode()) {
			log.error("监管公司号为空！");
			throw new ScubeBizException("监管公司不存在!");
		}
		
		//校验该先票款后货协议是否已经关联监管合同号
		if(!StringUtil.isEmpty(monitorProtocolVO.getOtherprotocolNo())){
			BCntMprotBaseInfoExample example = new BCntMprotBaseInfoExample();
			com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample.Criteria cri = example.createCriteria();
			cri.andOtherprotocolNoEqualTo(monitorProtocolVO.getOtherprotocolNo());
			cri.andProtocolTypeEqualTo(ScfBasConstant.MUTI_PROTOCOL_MONI);
			cri.andStateEqualTo(ScfBasConstant.STATE_VALID);
			List<BCntMprotBaseInfo> list = iBCntMprotBaseInfoDAO.selectByExample(example);
			if(list != null && list.size()>0){
				log.error("先票款/后货协议已关联过监管合同");
				throw new ScubeBizException("此先票款/后货协议已关联过监管合同！");
			}
		}
		
		// if(null!=monitorProtocolVO.getCooperationBrcode()){
		// log.error("合作机构号为空！");
		// throw new ScubeBizException("合作机构不存在!");
		// }
		/*
		 * ScfGlobalInfo scfGlobalInfoResult =
		 * ScfBaseData.getScfGlobalInfoData();// 获得当前系统信息
		 */
		UserInfo userInfo = ContextHolder.getUserInfo();
		// 2.保存多方协议基础表B_CNT_MPROT_BASE_INFO
		BCntMprotBaseInfo tBaseInfo = new BCntMprotBaseInfo();
		// BeanUtils.copyProperties(tBaseInfo, monitorProtocolVO);

		String protocolNo = "";
		if (ScfBasConstant.PRODUCT_TYPE_PLDY.equals(monitorProtocolVO.getProductId()))
			protocolNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_PROTOCOL_CODE_JGDT);// 现货动态
		else if (ScfBasConstant.PRODUCT_TYPE_XPHH.equals(monitorProtocolVO.getProductId()))
			protocolNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_PROTOCOL_CODE_JGXPHH);// 先票款后货
		else if (ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL.equals(monitorProtocolVO.getProductId()))
			protocolNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_PROTOCOL_CODE_JGFBC);// 普通非标准仓单
		else if(ScfBasConstant.PRODUCT_TYPE_PLSY.equals(monitorProtocolVO.getProductId()))
			protocolNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_PROTOCOL_CODE_JGJT);
		tBaseInfo.setProductId(monitorProtocolVO.getProductId());// 业务品种
		tBaseInfo.setProtocolNo(protocolNo);
		tBaseInfo.setProtocolCode(protocolNo);
		tBaseInfo.setOtherprotocolNo(monitorProtocolVO.getOtherprotocolNo());
		tBaseInfo.setCurcd(monitorProtocolVO.getCurcdNm());
		tBaseInfo.setState(ScfBasConstant.PROTOCOL_STATE_EFFECTIVE);// 协议状态1-生效
		tBaseInfo.setUpdateDate(new Date());
		tBaseInfo.setUpdateState(ScfBasConstant.UPDATESTATE_VALID);
		tBaseInfo.setTlrno(userInfo.getTlrNo());
		tBaseInfo.setBrcode(userInfo.getBrNo());
		tBaseInfo.setSignDate(ScfDateUtil.formatDate(new Date()));
		tBaseInfo.setProtocolType(ScfBasConstant.MUTI_PROTOCOL_MONI);// 多方协议类型
		tBaseInfo.setMoniType(monitorProtocolVO.getMoniType());
		tBaseInfo.setSellOffFlag(monitorProtocolVO.getSellOffFlag());
		tBaseInfo.setPriceDropRate(monitorProtocolVO.getPriceDropRate());
		tBaseInfo.setOtherDes(monitorProtocolVO.getOtherDes());
		Date startDate = null;
		Date endDate = null;
		try {
			if (StringUtil.isStrNotEmpty(monitorProtocolVO.getStartDate())) {
				startDate = ScfDateUtil.toDate(monitorProtocolVO.getStartDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
			}
			if (StringUtil.isStrNotEmpty(monitorProtocolVO.getEndDate())) {
				endDate = ScfDateUtil.toDate(monitorProtocolVO.getEndDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
			}

		} catch (ParseException e) {
			log.error("保存多方协议，日期转换错误" + e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20003), BCntErrorConstant.SCF_BAS_CNT_20003);
		}
		tBaseInfo.setStartDate(monitorProtocolVO.getStartDate());
		tBaseInfo.setEndDate(monitorProtocolVO.getEndDate());
		tBaseInfo.setTenor(ScfDateUtil.getTenOr(startDate, endDate));// 期限
		tBaseInfo.setCurcd(monitorProtocolVO.getCurcdNm());
		tBaseInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 机构号
		tBaseInfo.setTlrno(ContextHolder.getUserInfo().getTlrNo());// 操作员号
		tBaseInfo.setCooperationBrcode(monitorProtocolVO.getCooperationBrcode());
		bCntMprotBaseInfoDAO.insertSelective(tBaseInfo);// 保存B_CNT_MPROT_BASE_INFO多方协议基础表
		// 3.保存多方协议参与者信息表B_CNT_MPROT_PART_INFO
		// 3.1保存授信客户/银行
		BCntMprotPartInfo tInfofir = new BCntMprotPartInfo();
		tInfofir.setId(UUIDGeneratorUtil.generate());
		tInfofir.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_BANK);// 银行
		tInfofir.setProtocolNo(protocolNo);
		tInfofir.setCustcd(userInfo.getBrNo());
		tInfofir.setCname(monitorProtocolVO.getSecName());
		// 根据机构号查询机构名称
		BctlVO bctlVO = scubeUserService.selectBctlByBrNo(userInfo.getBrNo(), ScfCommonUtil.getBrManagerNo(scubeUserService));
		tInfofir.setCname(bctlVO.getBrName());
		bCntMprotPartInfoDAO.insertSelective(tInfofir);

		// 3.2保存授信客户/经销商
		BCntMprotPartInfo tInfosec = new BCntMprotPartInfo();
		tInfosec.setId(UUIDGeneratorUtil.generate());
		tInfosec.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);// 经销商
		tInfosec.setProtocolNo(protocolNo);
		tInfosec.setCustcd(monitorProtocolVO.getSecCd());// 出质人编号
		tInfosec.setCname(monitorProtocolVO.getSecName());
		bCntMprotPartInfoDAO.insertSelective(tInfosec);

		// 3.3保存授信客户/监管公司
		BCntMprotPartInfo tInfothr = new BCntMprotPartInfo();
		tInfothr.setId(UUIDGeneratorUtil.generate());
		tInfothr.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_MONI);// 监管公司
		tInfothr.setProtocolNo(protocolNo);
		tInfothr.setCustcd(monitorProtocolVO.getThrCode());
		tInfothr.setCname(monitorProtocolVO.getThrName());
		bCntMprotPartInfoDAO.insertSelective(tInfothr);

		// //4.保存预付款协议表扩展B_CNT_MPROT_DEAL_INFO

		BCntMprotCmInfo cmInfo = new BCntMprotCmInfo();

		cmInfo.setProtocolNo(protocolNo);
		// cmInfo.setMoniOfCustcd(monitorProtocolVO.getThrCd());
		// cmInfo.setMoniProtocolType(monitorProtocolVO.getMoniProtocolType());//监管协议类型
		// cmInfo.setLowPriceNew(monitorProtocolVO.getLowPriceNew());//监管底线

		// cmInfo =
		// SCFDAOUtils.getTblMutiProtCmInfoDAO().findByProtocolNoException(protocolNo,"监管协议扩展信息表不存在！");
		cmInfo.setMoniOfCustcd(monitorProtocolVO.getThrCode());
		cmInfo.setIsPledge(monitorProtocolVO.getIsPledge());
		cmInfo.setWarehouseType(monitorProtocolVO.getWarehouseType());
		cmInfo.setLogisticsMoniCondition(monitorProtocolVO.getLogisticsMoniCondition());
		bCntMprotCmInfoDAO.insertSelective(cmInfo);

	}

	@Override
	public List<DataItemsVO> getProductId(DataItemsDO dataItemsDO) throws ScubeBizException {
		List<DataItemsVO> dataItemsList = new ArrayList<DataItemsVO>();
		String parentId = dataItemsDO.getParentId();
		String productId = dataItemsDO.getProductId();
		BPrdInfoExample example = new BPrdInfoExample();
		BPrdInfoExample.Criteria e = example.createCriteria();
		if (parentId != null) {
			e.andParentIdEqualTo(parentId);
		}
		if (productId != null) {
			e.andProductIdEqualTo(productId);
		}
		List<BPrdInfo> code = bPrdInfoDAO.selectByExample(example);
		for (BPrdInfo info : code) {
			DataItemsVO dataItems = new DataItemsVO();
			dataItems.setCodeName(info.getProductName());
			dataItems.setCode(info.getProductId());
			dataItemsList.add(dataItems);
		}
		return dataItemsList;
	}

	@Override
	public Page getSecNamebyProtocol(int pageNo, int pageSize, MonitorProtocolVO value) throws ScubeBizException {

		Page resultPage = new Page();
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		bCrmBaseInfo.setCname(value.getSecName());
		bCrmBaseInfo.setCustType("1");
		bCrmBaseInfo.setCustStatus("01");
		bCrmBaseInfo.setCreditFlag("1");
		List<BCrmBaseInfo> cbi = bCrmBaseInfoService.findBCrmBaseInfoByBCrm(bCrmBaseInfo);
		BCrmEntInfo bCrmEntInfo = new BCrmEntInfo();
		List<BCrmEntInfo> cei = bCrmEntInfoService.findBCrmEntInfoByBCrm(bCrmEntInfo);
		List<DataItems> di = new ArrayList<DataItems>();
		for (int i = 0; i < cbi.size(); i++) {
			for (int j = 0; j < cei.size(); j++) {
				if (cbi.get(i).getCustcd().equals(cei.get(j).getCustcd())) {
					DataItems e = new DataItems();
					e.setCode(cbi.get(i).getCustcd());
					e.setCodeName(cbi.get(i).getCname());
					di.add(e);
				}
			}
		}
		List<DataItems> dis = new ArrayList<DataItems>();
		int index = (pageNo - 1) * pageSize;
		int toIndex = 0;
		if (di.size() > index) {
			toIndex = (index + 10) <= di.size() ? (index + 10) : di.size();
			dis = di.subList(index, toIndex);
		} else {
			return resultPage;
		}
		resultPage.setRecords(dis);
		resultPage.setTotalRecord(di.size());
		return resultPage;
	}

	@Override
	public Page getThrNamebyProtocol(int pageNo, int pageSize, MonitorProtocolVO value) throws ScubeBizException {
		log.info("value=" + value);
		Page resultPage = new Page();
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		bCrmBaseInfo.setCname(value.getThrName());
		bCrmBaseInfo.setCustType("1");
		bCrmBaseInfo.setCustStatus("01");
		bCrmBaseInfo.setMoniFlag("1");
		List<BCrmBaseInfo> cbi = bCrmBaseInfoService.findBCrmBaseInfoByBCrm(bCrmBaseInfo);
		List<DataItems> di = new ArrayList<DataItems>();
		for (int i = 0; i < cbi.size(); i++) {
			DataItems e = new DataItems();
			e.setCode(cbi.get(i).getCustcd());
			e.setCodeName(cbi.get(i).getCname());
			di.add(e);
		}
		int index = (pageNo - 1) * pageSize;
		int toIndex = 0;
		if (di.size() - index > 10) {
			toIndex = index + 10;
		} else {
			toIndex = di.size();
		}
		List<DataItems> dis = di.subList(index, toIndex);
		resultPage.setRecords(dis);
		resultPage.setTotalRecord(di.size());
		return resultPage;
	}

	@Override
	public MonitorProtocolVO monitorProtocolQuery(String protocolCode) throws ScubeBizException {
		MonitorProtocolVO response = new MonitorProtocolVO();
		MonitorProtocolInfo info = new MonitorProtocolInfo();
		info = extIBCntMprotBaseInfoDAO.queryMonitorProtocolInfo(protocolCode);
		response.setOtherprotocolNo(info.getOtherprotocolNo());
		response.setProtocolCode(info.getProtocolCode());
		response.setProductId(info.getProductId());
		response.setMoniType(info.getMoniType());
		response.setCurcdNm(info.getCurcdNm());
		response.setSecCd(info.getSecCd());
		response.setSecName(info.getSecName());
		response.setThrCode(info.getThrCode());
		BCrmBaseInfo e = new BCrmBaseInfo();
		e.setCustno(info.getThrCode());
		BCrmBaseInfo bCrmBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoByKey(e);
		response.setThrName(bCrmBaseInfo.getCname());
		response.setThrCode(info.getThrCode());
		response.setSellOffFlag(info.getSellOffFlag());
		response.setIsPledge(info.getIsPledge());
		response.setStartDate(info.getStartDate());
		response.setEndDate(info.getEndDate());
		response.setState(info.getState());
		response.setCooperationBrcode(info.getCooperationBrcode());
		if (StringUtil.isStrNotEmpty(info.getCooperationBrcode())) {
			BctlVO bctlVO = scubeUserService.selectBctlByBrNo(info.getCooperationBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			response.setCooperationBrcodeNm(bctlVO.getBrName());
		}
		UserInfo userInfo = scubeUserService.selectUserByTlrNo(info.getTlrNo(), ScfCommonUtil.getBrManagerNo(scubeUserService));
		response.setTlrName(userInfo.getTlrName());
		response.setBrcode(info.getBrcode());
		if (StringUtil.isStrNotEmpty(info.getBrcode())) {
			BctlVO brcode = scubeUserService.selectBctlByBrNo(info.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			response.setBrcodeNm(brcode.getBrName());
		}
		response.setWarehouseType(info.getWarehouseType());
		response.setPriceDropRate(info.getPriceDropRate());
		response.setLogisticsMoniCondition(info.getLogisticsMoniCondition());
		response.setOtherDes(info.getOtherDes());
		return response;
	}

	@Override
	public MonitorProtocolVO getThrNamebycustCd(String key) throws ScubeBizException {
		MonitorProtocolVO response = new MonitorProtocolVO();
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		bCrmBaseInfo.setCustcd(key);
		BCrmBaseInfo cbi = bCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
		BCrmMoniEntInfo bCrmMoniEntInfo = new BCrmMoniEntInfo();
		bCrmMoniEntInfo.setCustcd(key);
		BCrmMoniEntInfo cmei = bCrmMoniEntInfoService.findBCrmMoniEntInfoByKey(bCrmMoniEntInfo);
		response.setThrName(cbi.getCname());
		response.setLevels(cmei.getLevels());
		response.setMonitorArea(cmei.getMonitorArea());
		response.setMonitortype(StringUtil.reCheckBoxValue(cmei.getMonitortype()));
		response.setDetailMonitorArea(cmei.getDetailMonitorArea());
		response.setLimitSum(cmei.getLimitSum());
		response.setMonitorStatus(cmei.getMonitorStatus());
		response.setLevelCogniDate(cmei.getLevelCogniDate());
		response.setLevelEndDate(cmei.getLevelEndDate());

		// MonitorProtocolInfo monitorProtocolInfo =
		// extIBCntMprotBaseInfoDAO.getThrNamebycustCd(key);
		// response.setThrName(monitorProtocolInfo.getThrName());
		// response.setLevels(monitorProtocolInfo.getLevels());
		// response.setMonitorArea(monitorProtocolInfo.getMonitorArea());
		// response.setMonitortype(StringUtil.reCheckBoxValue(monitorProtocolInfo.getMonitortype()));
		// response.setDetailMonitorArea(monitorProtocolInfo.getDetailMonitorArea());
		// response.setLimitSum(monitorProtocolInfo.getLimitSum());
		// response.setMonitorStatus(monitorProtocolInfo.getMonitorStatus());
		// response.setLevelCogniDate(monitorProtocolInfo.getLevelCogniDate());
		// response.setLevelEndDate(monitorProtocolInfo.getLevelEndDate());
		return response;
	}

	@Override
	@Transactional
	public void monitorProtocolUpdate(MonitorProtocolVO monitorProtocolVO) throws ScubeBizException {
		// 1.参数对象判断
		if (null == monitorProtocolVO) {
			log.error("monitorProtocolVO参数对象不能为空！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20002), BCntErrorConstant.SCF_BAS_CNT_20002);
		}
		
		//校验该先票款后货协议是否已经关联监管合同号
		if(!StringUtil.isEmpty(monitorProtocolVO.getOtherprotocolNo())){
			BCntMprotBaseInfoExample example = new BCntMprotBaseInfoExample();
			com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample.Criteria cri = example.createCriteria();
			cri.andOtherprotocolNoEqualTo(monitorProtocolVO.getOtherprotocolNo());
			cri.andProtocolTypeEqualTo(ScfBasConstant.MUTI_PROTOCOL_MONI);
			cri.andStateEqualTo(ScfBasConstant.STATE_VALID);
			cri.andProtocolCodeNotEqualTo(monitorProtocolVO.getProtocolCode());
			List<BCntMprotBaseInfo> list = iBCntMprotBaseInfoDAO.selectByExample(example);
			if(list != null && list.size()>0){
				log.error("先票款/后货协议已关联过监管合同");
				throw new ScubeBizException("此先票款/后货协议已关联过监管合同！");
			}
		}
		
		// 2.修改多方协议基础表B_CNT_MPROT_BASE_INFO
		BCntMprotBaseInfo tBaseInfo = new BCntMprotBaseInfo();
		// 2.1根据协议号查询多方协议基础信息
		tBaseInfo = bCntMprotBaseInfoDAO.selectByPrimaryKey(monitorProtocolVO.getProtocolCode());
		// TODO 这里的日期得取工作日
		// tBaseInfo.setSignDate(ScfDateUtil.getStringDate(new Date()));
		// tBaseInfo.setSignIn(monitorProtocolVO.getSignIn());
		// tBaseInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());//机构号
		// tBaseInfo.setTlrno(ContextHolder.getUserInfo().getTlrNo());//操作员号
		// TODO 这里的日期得取工作日
		// tBaseInfo.setUpdateDate(new Date());
		// tBaseInfo.setCooperationBrcode(monitorProtocolVO.getCooperationBrcode());//合作机构
		tBaseInfo.setStartDate(monitorProtocolVO.getStartDate());
		tBaseInfo.setEndDate(monitorProtocolVO.getEndDate());
		tBaseInfo.setPriceDropRate(monitorProtocolVO.getPriceDropRate());
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = ScfDateUtil.toDate(tBaseInfo.getStartDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
			endDate = ScfDateUtil.toDate(tBaseInfo.getEndDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
		} catch (ParseException e) {
			log.error("保存多方协议，日期转换错误" + e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20003), BCntErrorConstant.SCF_BAS_CNT_20003);
		}
		tBaseInfo.setTenor(ScfDateUtil.getTenOr(startDate, endDate));// 期限
		tBaseInfo.setOtherDes(monitorProtocolVO.getOtherDes());
		tBaseInfo.setCurcd(monitorProtocolVO.getCurcdNm());
		tBaseInfo.setSellOffFlag(monitorProtocolVO.getSellOffFlag());
		tBaseInfo.setCooperationBrcode(monitorProtocolVO.getCooperationBrcode());
		tBaseInfo.setOtherprotocolNo(monitorProtocolVO.getOtherprotocolNo());
		bCntMprotBaseInfoDAO.updateByPrimaryKeySelective(tBaseInfo);
		// 3修改多方协议信息
		// 3.1修改授信客户/银行
		// BCntMprotPartInfo tPartInfofir = new BCntMprotPartInfo();
		// BCntMprotPartInfoExample tPartInfofirEp=new
		// BCntMprotPartInfoExample();
		// if(null!=monitorProtocolVO.getProtocolNo()){
		// tPartInfofirEp.createCriteria().andProtocolNoEqualTo(monitorProtocolVO.getProtocolNo());
		// }
		// tPartInfofirEp.createCriteria().andRoleEqualTo(ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		// List<BCntMprotPartInfo>
		// bCntMprotPartInfoList=bCntMprotPartInfoDAO.selectByExample(tPartInfofirEp);
		// if(null!=bCntMprotPartInfoList&&bCntMprotPartInfoList.size()>0){
		// tPartInfofir=(BCntMprotPartInfo)bCntMprotPartInfoList.get(0);
		// }
		// tPartInfofir.setCustcd(monitorProtocolVO.getCoreCustcd());
		// tPartInfofir.setCname(monitorProtocolVO.getCoreNm());
		// bCntMprotPartInfoDAO.updateByPrimaryKeySelective(tPartInfofir);
		// 3.2修改授信客户/经销商
		// BCntMprotPartInfo tPartInfosec = new BCntMprotPartInfo();
		// tPartInfofirEp.createCriteria().andRoleEqualTo(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		// List<BCntMprotPartInfo>
		// tPartInfosecList=bCntMprotPartInfoDAO.selectByExample(tPartInfofirEp);
		// if(null!=tPartInfosecList && tPartInfosecList.size()>0){
		// tPartInfosec=(BCntMprotPartInfo)tPartInfosecList.get(0);
		// }
		// tPartInfosec.setActno(monitorProtocolVO.getBalanceAccount());
		// tPartInfosec.setBailActno(monitorProtocolVO.getBailAccount());
		// tPartInfosec.setCustcd(monitorProtocolVO.getCustcd());
		// tPartInfosec.setCname(monitorProtocolVO.getSellerNm());
		// bCntMprotPartInfoDAO.updateByPrimaryKeySelective(tPartInfosec);
		// 3.3修改授信客户/监管公司
		// BCntMprotPartInfo tPartInfofour = new BCntMprotPartInfo();
		// tPartInfofirEp.createCriteria().andRoleEqualTo(ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);
		// List<BCntMprotPartInfo>
		// tPartInfofourList=bCntMprotPartInfoDAO.selectByExample(tPartInfofirEp);
		// if(null!=tPartInfofourList && tPartInfofourList.size()>0){
		// tPartInfofour=(BCntMprotPartInfo)tPartInfofourList.get(0);
		// }
		// tPartInfofour.setActno(monitorProtocolVO.getRefundAccount());
		// tPartInfofour.setCustcd(monitorProtocolVO.getFouCd());
		// tPartInfofour.setCname(monitorProtocolVO.getFouName());
		// bCntMprotPartInfoDAO.updateByPrimaryKeySelective(tPartInfofour);

		// 4.
		BCntMprotCmInfo cmInfo = new BCntMprotCmInfo();
		cmInfo.setProtocolNo(monitorProtocolVO.getProtocolCode());
		cmInfo.setIsPledge(monitorProtocolVO.getIsPledge());
		cmInfo.setWarehouseType(monitorProtocolVO.getWarehouseType());
		cmInfo.setLogisticsMoniCondition(monitorProtocolVO.getLogisticsMoniCondition());
		bCntMprotCmInfoDAO.updateByPrimaryKeySelective(cmInfo);
	}
	
	@Override
	@Transactional
	public void monitorProtocolChangeUpdate(MonitorProtocolVO monitorProtocolVO) throws ScubeBizException {
		/*MortProtocolVO contractVO = (MortProtocolVO) context.getAttribute(IN_PARAM);
		// 查询系统规则开关
		TblSysParam id = new TblSysParam();
		id.setParamId(SCFConstants.RULE_PARAMID);
		id.setParamIndex(SCFConstants.RULE_PARAMINDEX);
		String ruleFlag = new String();
		TblSysParam tblSysParam = SysParamMgrService.getInstance().getTblSysParam(id);
		if (tblSysParam == null) {
			ExceptionUtil.throwCommonException("系统参数表中不存在规则开关，请检查数据！", SCFErrorCode.RECORD_NOT_EXIST);
		} else {
			ruleFlag = tblSysParam.getParamValue();
		}
		*/
		// 点击保存后的操作
		String protocolNo = ContractServiceImpl.saveChgMutiProt(monitorProtocolVO);

	}

	@Override
	@Transactional
	public void monitorProtocolDelete(List<MonitorProtocolVO> monitorProtocolVO) throws ScubeBizException {

		List<String> values = new ArrayList<String>();
		for (MonitorProtocolVO info : monitorProtocolVO) {
			log.info("protocolNo=" + info.getProtocolNo());
			String key = info.getProtocolNo();
			values.add(key);
		}
		//1、检查监管合同是否可以删除 判断是否已关联抵质押合同
		BCrrGntyConExample gntyExample = new BCrrGntyConExample();
		BCrrGntyConExample.Criteria gntyCriteria = gntyExample.createCriteria();
		gntyCriteria.andPrtclNoIn(values);
		List<BCrrGntyCon> gntyList = iBCrrGntyConDAO.selectByExample(gntyExample);
		if(gntyList !=null && gntyList.size()>0){
			throw new ScubeBizException("该监管合同已关联抵/质押合同，不能进行删除操作");
		}

		// //2.查询多方协议信息，无记录抛错
		// BCntMprotBaseInfo
		// tBaseInfo=bCntMprotBaseInfoDAO.selectByPrimaryKey(protocolNo);
		// if(null==tBaseInfo){
		// throw new
		// ScubeBizException(ScfMessageUtil.transErrMsgByKeyParams(BCntErrorConstant.SCF_BAS_CNT_20005,
		// new Object[] { protocolNo }), BCntErrorConstant.SCF_BAS_CNT_20005);
		// }
		// 5.删除操作
		// 删除协议基本信息
		BCntMprotBaseInfoExample baseExample = new BCntMprotBaseInfoExample();
		BCntMprotBaseInfoExample.Criteria baseCriteria = baseExample.createCriteria();
		baseCriteria.andProtocolNoIn(values);
		int deltBaseInfoCount = bCntMprotBaseInfoDAO.deleteByExample(baseExample);
		log.info("-------------------------删除协议基本信息记录deltBaseInfoCount:" + deltBaseInfoCount);

		// 删除协议多方信息
		BCntMprotPartInfoExample partExample = new BCntMprotPartInfoExample();
		BCntMprotPartInfoExample.Criteria partCriteria = partExample.createCriteria();
		partCriteria.andProtocolNoIn(values);
		for (String example : values) {
			BCntMprotPartInfoExample e = new BCntMprotPartInfoExample();
			e.createCriteria().andProtocolNoEqualTo(example);
			List<BCntMprotPartInfo> bCntMprotPartInfoList = bCntMprotPartInfoDAO.selectByExample(e);
			if (null != bCntMprotPartInfoList && bCntMprotPartInfoList.size() > 0) {
				for (int i = 0; i < bCntMprotPartInfoList.size(); i++) {
					BCntMprotPartInfo tPartInfofir = (BCntMprotPartInfo) bCntMprotPartInfoList.get(i);
					bCntMprotPartInfoDAO.deleteByPrimaryKey(tPartInfofir.getId());
				}
			}
		}

		// 删除协议基本信息
		BCntMprotCmInfoExample cmExample = new BCntMprotCmInfoExample();
		BCntMprotCmInfoExample.Criteria cmCriteria = cmExample.createCriteria();
		cmCriteria.andProtocolNoIn(values);
		int deltCmInfoCount = bCntMprotCmInfoDAO.deleteByExample(cmExample);
		log.info("-------------------------删除协议基本信息记录deltBaseInfoCount:" + deltCmInfoCount);
	}

	@Override
	public MonitorProtocolVO initPageUserOrg() throws ScubeBizException {
		MonitorProtocolVO monitorProtocolVO = new MonitorProtocolVO();
		monitorProtocolVO = this.setPageUserOrg(monitorProtocolVO);
		return monitorProtocolVO;
	}

	/**
	 * 设置用户及机构 信息
	 * 
	 * @param threeProtocolVO
	 * @return
	 * @throws ScubeBizException
	 */
	public MonitorProtocolVO setPageUserOrg(MonitorProtocolVO monitorProtocolVO) throws ScubeBizException {
		// 获取机构信息
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		monitorProtocolVO.setBrcode(bctlVO.getBrNo());
		monitorProtocolVO.setBrcodeNm(bctlVO.getBrName());
		UserInfo user = ContextHolder.getUserInfo();
		monitorProtocolVO.setTlrNo(user.getTlrNo());
		monitorProtocolVO.setTlrName(user.getTlrName());
		// List<BctlVO> listBctl=new ArrayList<BctlVO>();
		// listBctl.add(bctlVO);
		// monitorProtocolVO.setListBctl(listBctl);
		return monitorProtocolVO;
	}

}
