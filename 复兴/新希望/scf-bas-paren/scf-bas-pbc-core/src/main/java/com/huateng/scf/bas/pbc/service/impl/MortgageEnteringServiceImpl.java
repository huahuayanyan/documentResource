/**
 * 
 */
package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DataItemsDO;
import com.huateng.scf.bas.cnt.model.DataItemsVO;
import com.huateng.scf.bas.cnt.model.MonitorProtocolVO;
import com.huateng.scf.bas.cnt.service.IMonitorProtocolService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgClassDAO;
import com.huateng.scf.bas.pbc.dao.ext.ExtIBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClassExample;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoDO;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcMtgClassVO;
import com.huateng.scf.bas.pbc.model.MortgageEnterDO;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.pbc.service.IMortgageEnteringService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
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
@Service("MortgageEnteringServiceImpl")
public class MortgageEnteringServiceImpl implements IMortgageEnteringService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private static final String CNAME = "cname";
	private static final String MONICNAME = "moniCname";
	private static final String SLAVECONTCODE = "slaveContcode";
	private static final String MORTGAGELEVELONENAME = "mortgageLevelOneName";
	private static final String MORTGAGELEVELTWONAME = "mortgageLevelTwoName";
	private static final String MORTGAGENAME = "mortgageName";
	private static final String SUPPPRODUCTNAME = "suppProductName";
	private static final String MONITORTYPE = "monitorType";
	private static final String ISLOCKED = "isLocked";
	private static final String STOCKSTATUS = "stockStatus";
	private static final String GUTID = "gutId";
	private static final String SLAVECONTNO = "slaveContno";

	@Resource(name = "BPbcMtgClassDAO")
	IBPbcMtgClassDAO bPbcMtgClassDAO;

	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;

	@Resource(name = "ExtBPbcMtgBaseInfoDAO")
	ExtIBPbcMtgBaseInfoDAO extIBPbcMtgBaseInfoDAO;

	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO bPbcMtgBaseInfoDAO;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService bSysSerialNoService;// 流水号生成服务

	@Resource(name = "monitorProtocolService")
	IMonitorProtocolService monitorProtocolService;

	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;

	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bCrrGntyConService;

	@Resource(name = "BPbcMtgClassServiceImpl")
	IBPbcMtgClassService bPbcMtgClassService;

	@Autowired
	ScubeUserService scubeUserService;

	@SuppressWarnings("unchecked")
	@Override
	public Page queryMortgageEnteringListByPage(int pageNo, int pageSize, MortgageEnterDO mortgageEnter) {
		Map<String, String> map = new HashMap<String, String>();
		Page scfPage = new Page(pageSize, pageNo, 0);
		if (null != mortgageEnter) {
			String cname = mortgageEnter.getCname();// 出质人名称
			String moniCname = mortgageEnter.getMoniCname();// 监管公司名称
			String slaveContcode = mortgageEnter.getSlaveContcode();// 抵/质押合同号
			String mortgageLevelOneName = mortgageEnter.getMortgageLevelOneName();// 押品一级
			String mortgageLevelTwoName = mortgageEnter.getMortgageLevelTwoName();// 押品二级
			String mortgageName = mortgageEnter.getMortgageName();// 押品名称
			String suppProductName = mortgageEnter.getSuppProductName();// 业务品种
			String monitorType = mortgageEnter.getMonitorType();// 监管模式
			String isLocked = mortgageEnter.getIsLocked();// 是否锁定
			String stockStatus = mortgageEnter.getStockStatus();// 库存状态
			String gutId = mortgageEnter.getCustcd();// 出质人id
			String slaveContno = mortgageEnter.getSlaveContno();
			if (StringUtil.isStrNotEmpty(cname)) {
				map.put(CNAME, cname);
			}
			if (StringUtil.isStrNotEmpty(moniCname)) {
				map.put(MONICNAME, moniCname);
			}
			if (StringUtil.isStrNotEmpty(slaveContcode)) {
				map.put(SLAVECONTCODE, slaveContcode);
			}
			if (StringUtil.isStrNotEmpty(mortgageLevelOneName)) {
				map.put(MORTGAGELEVELONENAME, mortgageLevelOneName);
			}
			if (StringUtil.isStrNotEmpty(mortgageLevelTwoName)) {
				map.put(MORTGAGELEVELTWONAME, mortgageLevelTwoName);
			}
			if (StringUtil.isStrNotEmpty(mortgageName)) {
				map.put(MORTGAGENAME, mortgageName);
			}
			if (StringUtil.isStrNotEmpty(suppProductName)) {
				map.put(SUPPPRODUCTNAME, suppProductName);
			}
			if (StringUtil.isStrNotEmpty(monitorType)) {
				map.put(MONITORTYPE, monitorType);
			}
			if (StringUtil.isStrNotEmpty(isLocked)) {
				map.put(ISLOCKED, isLocked);
			}
			if (StringUtil.isStrNotEmpty(stockStatus)) {
				map.put(STOCKSTATUS, stockStatus);
			}
			if (StringUtil.isStrNotEmpty(gutId)) {
				map.put(GUTID, gutId);
			}
			if (StringUtil.isStrNotEmpty(slaveContno)) {
				map.put(SLAVECONTNO, slaveContno);
			}
		}
		extIBPbcMtgBaseInfoDAO.queryMortgageEnteringList(scfPage, map);// 分页查询
		return scfPage;
	}

	/*
	 * 入库押品管理列表查询2 当押品状态为已出质的时候，页面的数量重量字段要重新写入取quantity字段填充到invQuantity
	 */
	@Override
	public Page queryMortgageEnteringListByPageForManage(int pageNo, int pageSize, MortgageEnterDO mortgageEnter) throws ScubeBizException {
		Map<String, String> map = new HashMap<String, String>();
		Page scfPage = new Page(pageSize, pageNo, 0);
		if (null != mortgageEnter) {
			String cname = mortgageEnter.getCname();// 出质人名称
			String moniCname = mortgageEnter.getMoniCname();// 监管公司名称
			String slaveContcode = mortgageEnter.getSlaveContcode();// 抵/质押合同号
			String mortgageLevelOneName = mortgageEnter.getMortgageLevelOneName();// 押品一级
			String mortgageLevelTwoName = mortgageEnter.getMortgageLevelTwoName();// 押品二级
			String mortgageName = mortgageEnter.getMortgageName();// 押品名称
			String suppProductName = mortgageEnter.getSuppProductName();// 业务品种
			String monitorType = mortgageEnter.getMonitorType();// 监管模式
			String isLocked = mortgageEnter.getIsLocked();// 是否锁定
			String stockStatus = mortgageEnter.getStockStatus();// 库存状态
			String gutId = mortgageEnter.getCustcd();// 出质人id
			String slaveContno = mortgageEnter.getSlaveContno();
			if (StringUtil.isStrNotEmpty(cname)) {
				map.put(CNAME, cname);
			}
			if (StringUtil.isStrNotEmpty(moniCname)) {
				map.put(MONICNAME, moniCname);
			}
			if (StringUtil.isStrNotEmpty(slaveContcode)) {
				map.put(SLAVECONTCODE, slaveContcode);
			}
			if (StringUtil.isStrNotEmpty(mortgageLevelOneName)) {
				map.put(MORTGAGELEVELONENAME, mortgageLevelOneName);
			}
			if (StringUtil.isStrNotEmpty(mortgageLevelTwoName)) {
				map.put(MORTGAGELEVELTWONAME, mortgageLevelTwoName);
			}
			if (StringUtil.isStrNotEmpty(mortgageName)) {
				map.put(MORTGAGENAME, mortgageName);
			}
			if (StringUtil.isStrNotEmpty(suppProductName)) {
				map.put(SUPPPRODUCTNAME, suppProductName);
			}
			if (StringUtil.isStrNotEmpty(monitorType)) {
				map.put(MONITORTYPE, monitorType);
			}
			if (StringUtil.isStrNotEmpty(isLocked)) {
				map.put(ISLOCKED, isLocked);
			}
			if (StringUtil.isStrNotEmpty(stockStatus)) {
				map.put(STOCKSTATUS, stockStatus);
			}
			if (StringUtil.isStrNotEmpty(gutId)) {
				map.put(GUTID, gutId);
			}
			if (StringUtil.isStrNotEmpty(slaveContno)) {
				map.put(SLAVECONTNO, slaveContno);
			}
		}
		List<BPbcMtgBaseInfo> bPbcMtgBaseInfoList = extIBPbcMtgBaseInfoDAO.queryMortgageEnteringList(scfPage, map);// 分页查询
		// 因为已经出质的时候invQuantity已经为零而页面需要显示为quantity这里需要再填充
		if (bPbcMtgBaseInfoList != null && bPbcMtgBaseInfoList.size() > 0) {
			for (BPbcMtgBaseInfo bPbcMtgBaseInfo : bPbcMtgBaseInfoList) {
				BigDecimal allQuantity = bPbcMtgBaseInfo.getInvQuantity()==null? BigDecimal.ZERO:bPbcMtgBaseInfo.getInvQuantity();
				allQuantity = allQuantity.add(bPbcMtgBaseInfo.getQuantity() == null?BigDecimal.ZERO:bPbcMtgBaseInfo.getQuantity());
				bPbcMtgBaseInfo.setInvQuantity(allQuantity);
			}
			scfPage.setRecords(bPbcMtgBaseInfoList);
		}
		return scfPage;
	}

	@Override
	public List<DataItemsVO> getMortgageLevel(DataItemsDO dataItemsDO) {
		List<DataItemsVO> response = new ArrayList<DataItemsVO>();
		BPbcMtgClassExample bPbcMtgClassExample = new BPbcMtgClassExample();
		BPbcMtgClassExample.Criteria criteria = bPbcMtgClassExample.createCriteria();
		if (dataItemsDO.getLevels() != null) {
			criteria.andLevelsEqualTo(dataItemsDO.getLevels());
		}
		if (dataItemsDO.getMortgageCode() != null) {
			criteria.andParentCodeEqualTo(new BigDecimal(dataItemsDO.getMortgageCode()));
		}
		if(dataItemsDO.getMortgageCodeList() !=null && dataItemsDO.getMortgageCodeList().size()>0){
			criteria.andMortgageCodeIn(dataItemsDO.getMortgageCodeList());
		}
		List<BPbcMtgClass> data = bPbcMtgClassDAO.selectByExample(bPbcMtgClassExample);
		for (BPbcMtgClass info : data) {
			DataItemsVO e = new DataItemsVO();
			e.setCodeName(info.getMortgageName());
			e.setCode(info.getMortgageCode().toString());
			response.add(e);
		}
		return response;
	}

	@Override
	public Page getSlaveContcode(int pageNo, int pageSize, DataItemsDO value) {
		String custcd = value.getCustcd();
		String productId = value.getProductId();
		BCrrGntyCon bCrrGntyCon = new BCrrGntyCon();
		bCrrGntyCon.setGutId(custcd);
		bCrrGntyCon.setVidPrdId(productId);
		bCrrGntyCon.setConId(value.getSlaveContcode());
		Page p = bCrrGntyConService.findBCrrGntyConByPage(pageNo, pageSize, bCrrGntyCon);
		return p;
	}

	@Override
	@Transactional
	public void saveMortgageEnteringList(MortgageEnterDO mortgageInfo, List<BPbcMtgBaseInfoDO> mortgageInfoList) {
		for (int i = 0; i < mortgageInfoList.size(); i++) {
			String mortgageNo = bSysSerialNoService.genSerialNo(ScfBasConstant.MORTGAGE_NO);// 押品编号
			BPbcMtgBaseInfo e = new BPbcMtgBaseInfo();
			e.setMortgageNo(mortgageNo);// 押品编号
			e.setCustcd(mortgageInfo.getCustcd());// 出质人客户号
			e.setSlaveContno(mortgageInfo.getSlaveContcode());// 抵/质押合同号
			e.setMoniOfCustcd(mortgageInfo.getMoniOfCustcd());// 监管公司客户号
			e.setMonitorProtocolNo(mortgageInfo.getProtocolCode());// 监管合同号
			e.setSupplyChainPdId(mortgageInfo.getProductId());// 业务品种
			// e.setMoniModel();//货押模式
			e.setMortgageName(mortgageInfoList.get(i).getMortgageName());// 押品名称
			e.setMortgageModel(mortgageInfoList.get(i).getMortgageModel());// 规格/型号
			e.setManufacturer(mortgageInfoList.get(i).getManufacturer());// 生产厂家
			e.setManufactureDate(mortgageInfoList.get(i).getManufactureDate());// 出厂日期
			e.setMortgageUnits(mortgageInfoList.get(i).getMortgageUnits());// 单位
			// e.setQuantity(mortgageInfoList.get(i).getQuantity());
			e.setWeightAll(mortgageInfoList.get(i).getWeightAll());// 数量/重量
			e.setCurcd(mortgageInfoList.get(i).getCurcd());// 币种
			e.setOriginalPrice(mortgageInfoList.get(i).getOriginalPrice());// 买入单价
			e.setMortgageLevelOne(mortgageInfoList.get(i).getMortgageLevelOne());// 押品一级
			e.setMortgageLevelTwo(mortgageInfoList.get(i).getMortgageLevelTwo());// 押品二级
			e.setMortgageLevelThree(mortgageInfoList.get(i).getMortgageLevelThree());// 押品三级
			e.setDescription(mortgageInfoList.get(i).getDescription());// 押品其他描述
			e.setWarehouse(mortgageInfoList.get(i).getWarehouse());// 仓库名称
			e.setWarehouseAddress(mortgageInfoList.get(i).getWarehouseAddress());// 仓库地址
			e.setMoniWarehouseType(mortgageInfoList.get(i).getMoniWarehouseType());// 监管模式
			e.setFreightarea(mortgageInfoList.get(i).getFreightarea());// 货区号
			e.setFreightlot(mortgageInfoList.get(i).getFreightlot());// 货位号
			e.setDocumentNo(mortgageInfoList.get(i).getDocumentNo());// 提货凭证号
			e.setJoinBatch(mortgageInfoList.get(i).getJoinBatch());// 是否参与核定价格批量调整
			e.setMemo(mortgageInfoList.get(i).getMemo());// 备注
			e.setTotPrice(mortgageInfoList.get(i).getTotPrice());// 总价
			e.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL);
			e.setIsLocked(ScfBasConstant.UNLOCKED);
			bPbcMtgBaseInfoDAO.insertSelective(e);
		}
	}

	/*
	 * 静态
	 */
	@Override
	@Transactional
	public ArrayList<com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO> mortgageEnteringQryAdd(MortgageEnterDO mortgageInfo,
			List<BPbcMtgBaseInfoDO> mortgageInfoList) throws ScubeBizException {
		if (mortgageInfo == null || mortgageInfoList == null || mortgageInfoList.size() == 0) {
			throw new ScubeBizException("前台所传参数无效！");
		}
		ArrayList<com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO> arrayList = new ArrayList<com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO>();
		for (int i = 0; i < mortgageInfoList.size(); i++) {
			String mortgageNo = bSysSerialNoService.genSerialNo(ScfBasConstant.MORTGAGE_NO);// 押品编号
			BPbcMtgBaseInfo e = new BPbcMtgBaseInfo();
			e.setMortgageNo(mortgageNo);// 押品编号
			e.setCustcd(mortgageInfo.getCustcd());// 出质人客户号
			e.setSlaveContno(mortgageInfo.getSlaveContcode());// 抵/质押合同号
			e.setMoniOfCustcd(mortgageInfo.getMoniOfCustcd());// 监管公司客户号
			e.setMonitorProtocolNo(mortgageInfo.getProtocolCode());// 监管合同号
			e.setSupplyChainPdId(mortgageInfo.getProductId());// 业务品种
			e.setMortgageName(mortgageInfoList.get(i).getMortgageName());// 押品名称
			e.setMortgageModel(mortgageInfoList.get(i).getMortgageModel());// 规格/型号
			e.setManufacturer(mortgageInfoList.get(i).getManufacturer());// 生产厂家
			e.setManufactureDate(mortgageInfoList.get(i).getManufactureDate());// 出厂日期
			e.setMortgageUnits(mortgageInfoList.get(i).getMortgageUnits());// 单位
			e.setInvQuantity(mortgageInfoList.get(i).getInvQuantity());// 已录入未出质数量/重量
			e.setQuantity(new BigDecimal(0));// 已出质数量/重量
			e.setWeightAll(new BigDecimal(0));// 总重量
			e.setCurcd(mortgageInfoList.get(i).getCurcd());// 币种
			e.setOriginalPrice(mortgageInfoList.get(i).getPrice());// 原始买入单价
			e.setPrice(mortgageInfoList.get(i).getPrice());// 单价
			e.setMortgageLevelOne(mortgageInfoList.get(i).getMortgageLevelOne());// 押品一级
			e.setMortgageLevelTwo(mortgageInfoList.get(i).getMortgageLevelTwo());// 押品二级
			e.setMortgageLevelThree(mortgageInfoList.get(i).getMortgageLevelThree());// 押品三级
			e.setDescription(mortgageInfoList.get(i).getDescription());// 押品其他描述
			e.setWarehouse(mortgageInfoList.get(i).getWarehouse());// 仓库名称
			e.setWarehouseAddress(mortgageInfoList.get(i).getWarehouseAddress());// 仓库地址
			e.setMoniWarehouseType(mortgageInfoList.get(i).getMoniWarehouseType());// 监管模式
			e.setFreightarea(mortgageInfoList.get(i).getFreightarea());// 货区号
			e.setFreightlot(mortgageInfoList.get(i).getFreightlot());// 货位号
			e.setDocumentNo(mortgageInfoList.get(i).getDocumentNo());// 提货凭证号
			if (StringUtil.isEmpty(mortgageInfoList.get(i).getJoinBatch())) {
				e.setJoinBatch("1");// 是否参与核定价格批量调整
			} else {
				e.setJoinBatch(mortgageInfoList.get(i).getJoinBatch());// 是否参与核定价格批量调整
			}
			if (!StringUtil.isEmpty(mortgageInfoList.get(i).getExt1())) {
				e.setExt1(mortgageInfoList.get(i).getExt1());
			}
			if (!StringUtil.isEmpty(mortgageInfoList.get(i).getMemo())) {
				e.setMemo(mortgageInfoList.get(i).getMemo());// 备注
			}
			e.setExt3(ScfBasConstant.MORT_STATUS_ENTRY);// 已录入未出质
			e.setTotPrice(new BigDecimal(0));// 总价
			e.setMarketPrice(new BigDecimal(0));
			e.setConfirmPrice(new BigDecimal(0));
			e.setUpDownMoney(new BigDecimal(0));
			e.setBillQuantity(new BigDecimal(0));
			e.setOriginalTotPrice(mortgageInfoList.get(i).getOriginalTotPrice());// 原始总价
			// e.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL);
			e.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);// 供应链
			e.setLastUpdTime(new Date());
			e.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
			e.setIsLocked(ScfBasConstant.UNLOCKED);
			bPbcMtgBaseInfoDAO.insertSelective(e);

			com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO bPbcMtgBaseInfo = new com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO();
			BeanUtils.copyProperties(e, bPbcMtgBaseInfo);
			if (StringUtils.isNotEmpty(bPbcMtgBaseInfo.getMortgageLevelOne())) {
				com.huateng.scf.bas.pbc.model.BPbcMtgClass bPbcMtgClassOne = bPbcMtgClassService
						.translateMortgageNameByCode(bPbcMtgBaseInfo.getMortgageLevelOne());
				bPbcMtgBaseInfo.setMortgageLevelOneName(bPbcMtgClassOne.getMortgageName());
			}
			if (StringUtils.isNotEmpty(bPbcMtgBaseInfo.getMortgageLevelTwo())) {
				com.huateng.scf.bas.pbc.model.BPbcMtgClass bPbcMtgClassTwo = bPbcMtgClassService
						.translateMortgageNameByCode(bPbcMtgBaseInfo.getMortgageLevelTwo());
				bPbcMtgBaseInfo.setMortgageLevelTwoName(bPbcMtgClassTwo.getMortgageName());
			}
			arrayList.add(bPbcMtgBaseInfo);
		}
		return arrayList;
	}

	@Override
	public MonitorProtocolVO getMonitorProtocolInfoByConId(String conId) {
		MonitorProtocolVO response = new MonitorProtocolVO();
		// BCrrGntyCon bCrrGntyCon = bCrrGntyConDAO.selectByPrimaryKey(conId);
		BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(conId);
		String protocolCode = bCrrGntyCon.getPrtclNo();
		if (protocolCode == null) {
			throw new ScubeBizException("监管合同信息不存在!");
		}
		response = monitorProtocolService.monitorProtocolQuery(protocolCode);
		String custcd = response.getThrCode();
		BCrmBaseInfo example = new BCrmBaseInfo();
		example.setCustcd(custcd);
		BCrmBaseInfo bCrmBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoByKey(example);
		response.setThrName(bCrmBaseInfo.getCname());
		response.setSecCd(bCrrGntyCon.getGutId());// 出质人编号
		return response;
	}

	@Override
	public BPbcMtgClassVO getMortgageName(BigDecimal mortgageCode) {
		BPbcMtgClassVO response = new BPbcMtgClassVO();
		BPbcMtgClass info = bPbcMtgClassDAO.selectByPrimaryKey(mortgageCode);
		response.setMortgageName(info.getMortgageName());
		return response;
	}

	@Override
	public BPbcMtgBaseInfoVO bPbcMtgBaseInfoQuery(String mortgageNo) {
		BPbcMtgBaseInfoVO response = new BPbcMtgBaseInfoVO();
		BPbcMtgBaseInfo bPbcMtgBaseInfo = bPbcMtgBaseInfoDAO.selectByPrimaryKey(mortgageNo);
		BeanUtils.copyProperties(bPbcMtgBaseInfo, response);
		BPbcMtgClass info1 = bPbcMtgClassDAO.selectByPrimaryKey(new BigDecimal(bPbcMtgBaseInfo.getMortgageLevelOne()));
		response.setMortgageLevelOneName(info1.getMortgageName());
		BPbcMtgClass info2 = bPbcMtgClassDAO.selectByPrimaryKey(new BigDecimal(bPbcMtgBaseInfo.getMortgageLevelTwo()));
		response.setMortgageLevelTwoName(info2.getMortgageName());
		if (bPbcMtgBaseInfo.getMortgageLevelThree() != null) {
			BPbcMtgClass info3 = bPbcMtgClassDAO.selectByPrimaryKey(new BigDecimal(bPbcMtgBaseInfo.getMortgageLevelThree()));
			response.setMortgageLevelThreeName(info3.getMortgageName());
		}
		return response;
	}

	@Override
	@Transactional
	public void bPbcMtgBaseInfoUpdate(BPbcMtgBaseInfoDO bPbcMtgBaseInfoDO) {
		BPbcMtgBaseInfo info = new BPbcMtgBaseInfo();
		info.setMortgageNo(bPbcMtgBaseInfoDO.getMortgageNo());
		info.setMortgageName(bPbcMtgBaseInfoDO.getMortgageName());// 押品名称
		info.setMortgageModel(bPbcMtgBaseInfoDO.getMortgageModel());// 规格/型号
		info.setManufacturer(bPbcMtgBaseInfoDO.getManufacturer());// 生产厂家
		info.setManufactureDate(bPbcMtgBaseInfoDO.getManufactureDate());// 出厂日期
		info.setMortgageUnits(bPbcMtgBaseInfoDO.getMortgageUnits());// 单位
		info.setQuantity(bPbcMtgBaseInfoDO.getQuantity());// 数量/重量
		info.setCurcd(bPbcMtgBaseInfoDO.getCurcd());// 币种
		info.setOriginalPrice(bPbcMtgBaseInfoDO.getOriginalPrice());// 买入单价
		info.setMortgageLevelOne(bPbcMtgBaseInfoDO.getMortgageLevelOne());// 押品一级
		info.setMortgageLevelTwo(bPbcMtgBaseInfoDO.getMortgageLevelTwo());// 押品二级
		info.setMortgageLevelThree(bPbcMtgBaseInfoDO.getMortgageLevelThree());// 押品三级
		info.setDescription(bPbcMtgBaseInfoDO.getDescription());// 押品其他描述
		info.setWarehouse(bPbcMtgBaseInfoDO.getWarehouse());// 仓库名称
		info.setWarehouseAddress(bPbcMtgBaseInfoDO.getWarehouseAddress());// 仓库地址
		info.setMoniWarehouseType(bPbcMtgBaseInfoDO.getMoniWarehouseType());// 监管模式
		info.setFreightarea(bPbcMtgBaseInfoDO.getFreightarea());// 货区号
		info.setFreightlot(bPbcMtgBaseInfoDO.getFreightlot());// 货位号
		info.setDocumentNo(bPbcMtgBaseInfoDO.getDocumentNo());// 提货凭证号
		info.setJoinBatch(bPbcMtgBaseInfoDO.getJoinBatch());// 是否参与核定价格批量调整
		info.setMemo(bPbcMtgBaseInfoDO.getMemo());// 备注
		info.setIsLocked(bPbcMtgBaseInfoDO.getIsLocked());// 是否锁定
		bPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(info);

	}

	@Override
	@Transactional
	public void bPbcMtgBaseInfoDelete(List<BPbcMtgBaseInfoDO> bPbcMtgBaseInfoDO) {
		for (int i = 0; i < bPbcMtgBaseInfoDO.size(); i++) {
			String key = bPbcMtgBaseInfoDO.get(i).getMortgageNo();
			bPbcMtgBaseInfoDAO.deleteByPrimaryKey(key);
		}
	}

	@Override
	@Transactional
	public void bPbcMtgBaseInfoUpdateSelective(com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo bPbcMtgBaseInfo) throws ScubeBizException {
		BPbcMtgBaseInfo bPbcMtgBaseInfo2 = new com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo();
		BeanUtils.copyProperties(bPbcMtgBaseInfo, bPbcMtgBaseInfo2);
		bPbcMtgBaseInfo2.setLastUpdTime(new Date());
		bPbcMtgBaseInfo2.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		bPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(bPbcMtgBaseInfo2);
	}

}
