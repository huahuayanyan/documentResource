/**
 * 
 */
package com.huateng.scf.bas.cnt.service.impl;

import java.text.ParseException;
import java.util.Date;
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
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.cnt.dao.IBCntBuyInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotDealInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample.Criteria;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.cnt.model.FourProtocolVO;
import com.huateng.scf.bas.cnt.service.IFourProtocolService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.dao.ext.ICommonQueryDAO;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.sys.service.IBSysCommonService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 先票/款后货协议
 * </p>
 *
 * @author lihao
 * @date 2016年11月22日下午4:53:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * lihao		   2016年11月22日下午4:53:26              新增
 *
 *            </pre>
 */
@ScubeService
@Service("FourProtocolServiceImpl")
public class FourProtocolServiceImpl implements IFourProtocolService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private static final String SELLERNM = "sellerNm";
	private static final String STATE = "state";
	private static final String FOUNAME = "fouName";
	private static final String PROTOCOLNO = "protocolNo";
	private static final String CORENM = "coreNm";
	private static final String PROTOCOLTYPE = "protocolType";
	private static final String ROLECREDIT = "roleCredit";
	private static final String ROLECORE = "roleCore";
	private static final String ROLEBACKCORE = "roleBackcore";
	private static final String ROLEMONI = "roleMoni";
	private static final String PRODUCTID = "productId";
	// private static final String MGRNO = "mgrno";

	@Resource(name = "BCntMprotBaseInfoDAO")
	private IBCntMprotBaseInfoDAO bCntMprotBaseInfoDAO;

	@Resource(name = "BCntMprotDealInfoDAO")
	private IBCntMprotDealInfoDAO bCntMprotDealInfoDAO;

	@Resource(name = "BCntMprotPartInfoDAO")
	private IBCntMprotPartInfoDAO bCntMprotPartInfoDAO;

	@Resource(name = "BSysSerialNoServiceImpl")
	private IBSysSerialNoService bSysSerialNoService;// 流水号生成服务

	@Autowired
	ScubeUserService scubeUserService;

	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO bCrrLnConDAO;
	@Resource(name = "bCrmBaseInfoService")
	IBCrmBaseInfoService bCrmBaseInfoService;

	@Resource(name = "BCntBuyInfoDAO")
	IBCntBuyInfoDAO bCntBuyInfoDAO;
	// 机构
	@Resource(name = "BSysCommonServiceImpl")
	IBSysCommonService bSysCommonService;
	
	@Resource(name = "commonQueryDAO")
	private ICommonQueryDAO commonQueryDAO;

	/*
	 * 页面有查询按钮下拉菜单的数据校验
	 * 
	 */
	@Override
	public void checkSelectForfranchiserProtocol(FourProtocolVO fourProtocolVO) throws ScubeBizException {
		// 页面客户校验 买方，卖方，回款方，监管方，合作机构
		// 1.买方
		BCrmBaseInfo sellerBaseIfo = new BCrmBaseInfo();
		sellerBaseIfo.setCustcd(fourProtocolVO.getCustcd());
		sellerBaseIfo.setCname(fourProtocolVO.getSellerNm());
		int sellerBaseInfoNum = bCrmBaseInfoService.checkCustomerForSelect(sellerBaseIfo);
		if (sellerBaseInfoNum != 1) {
			throw new ScubeBizException("买方名称与买方客户号不对应,请通过查询按钮选择[买方名称]！");

		}
		// 2.卖方
		BCrmBaseInfo coreBaseIfo = new BCrmBaseInfo();
		coreBaseIfo.setCustcd(fourProtocolVO.getCoreCustcd());
		coreBaseIfo.setCname(fourProtocolVO.getCoreNm());
		int coreBaseInfoNum = bCrmBaseInfoService.checkCustomerForSelect(coreBaseIfo);
		if (coreBaseInfoNum != 1) {
			throw new ScubeBizException("卖方名称与卖方客户号不对应,请通过查询按钮选择[卖方名称]！");
		}
		// 3.承担方
		BCrmBaseInfo fouBaseIfo = new BCrmBaseInfo();
		fouBaseIfo.setCustcd(fourProtocolVO.getFouCd());
		fouBaseIfo.setCname(fourProtocolVO.getFouName());
		int fouBaseInfoNum = bCrmBaseInfoService.checkCustomerForSelect(fouBaseIfo);
		if (fouBaseInfoNum != 1) {
			throw new ScubeBizException("承担方名称与承担方客户号不对应,请通过查询按钮选择[承担方名称]！");
		}
		// 4.监管方
		BCrmBaseInfo moniBaseIfo = new BCrmBaseInfo();
		moniBaseIfo.setCustcd(fourProtocolVO.getMoniCustcd());
		moniBaseIfo.setCname(fourProtocolVO.getMoniNm());
		int moniBaseInfoNum = bCrmBaseInfoService.checkCustomerForSelect(moniBaseIfo);
		if (moniBaseInfoNum != 1) {
			throw new ScubeBizException("监管公司名称与监管公司客户号不对应,请通过查询按钮选择[监管公司名称]！");
		}
		// 5.合作机构 bSysCommonService/selectBranchInfo
		if ("".equals(fourProtocolVO.getCooperationBrcode())) {
			fourProtocolVO.setCooperationBrcode(null);
			fourProtocolVO.setCooperationBrcodeNm(null);
		}
		if (fourProtocolVO.getCooperationBrcodeNm() != null && fourProtocolVO.getCooperationBrcode() != null) {
			BctlVO bctlVO = new BctlVO();
			bctlVO.setBrNo(fourProtocolVO.getCooperationBrcode());
			bctlVO.setBrName(fourProtocolVO.getCooperationBrcodeNm());
			Page cooperationBrcodeInfo = bSysCommonService.selectCooperationBranch(1, 10, bctlVO);
			List records = cooperationBrcodeInfo.getRecords();
			if (records == null || records.size() != 1) {
				throw new ScubeBizException("合作机构名称与合作机构机构号不对应,请通过查询按钮选择[合作机构]！");
			}
		}

	}

	/*
	 * 新增先票/款后货协议
	 */
	@Override
	@Transactional
	public void franchiserProtocolAdd(FourProtocolVO fourProtocolVO) throws ScubeBizException {
		// 1. 校验数据
		if (fourProtocolVO == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20002), BCntErrorConstant.SCF_BAS_CNT_20002);
		}
		// 2. 页面客户校验 买方，卖方，回款方，监管方，合作机构
		checkSelectForfranchiserProtocol(fourProtocolVO);

		// 3.新增数据
		ScfGlobalInfo scfGlobalInfo = ScfBaseData.getScfGlobalInfoData();
		String loanWay = fourProtocolVO.getLoanWay();// 出账方式
		String dutyAssumeType = fourProtocolVO.getDutyAssumeType();// 卖方责任承担方式
		fourProtocolVO.setLoanWay(StringUtil.formatCheckBoxValue(loanWay));// 格式化出账方式，去掉[]，去掉""
		fourProtocolVO.setDutyAssumeType(StringUtil.formatCheckBoxValue(dutyAssumeType));// 格式化出账方式，去掉[]，去掉""
		fourProtocolVO.setProtocolType(ScfBasConstant.MUTI_PROTOCOL_FOURWH);// 多方协议表协议类型：四方保兑仓
		if (StringUtil.isStrEmpty(fourProtocolVO.getCircleLoanFlag())) {// 是否循环走款
			fourProtocolVO.setCircleLoanFlag("");
		}
		if (StringUtil.isStrEmpty(fourProtocolVO.getTripleProtocolType())) {// 大小三方
			fourProtocolVO.setTripleProtocolType("");
		}
		// 先票/款后货协议号
		String protocolNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_PROTOCOL_CODE_XP);
		fourProtocolVO.setProtocolNo(protocolNo);
		fourProtocolVO.setState(ScfBasConstant.PROTOCOL_STATE_EFFECTIVE);
		if (("1").equals(fourProtocolVO.getDeliveryMode())) {
			// 一一对应模式下 首笔保证金提货模式 默认设为 首笔保证金在后期按比例提货
			fourProtocolVO.setFirstBailType(ScfBasConstant.TRI_DELIVERY_RULE_NONE);
		}
		// 3.1 保存多方协议基础表B_CNT_MPROT_BASE_INFO
		BCntMprotBaseInfo tBaseInfo = new BCntMprotBaseInfo();
		BeanUtils.copyProperties(fourProtocolVO, tBaseInfo);
		tBaseInfo.setSignDate(scfGlobalInfo.getTxnDate());
		tBaseInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 机构号
		tBaseInfo.setTlrno(ContextHolder.getUserInfo().getTlrNo());// 操作员号
		tBaseInfo.setUpdateDate(new Date());
		Date startDate = null;
		Date endDate = null;
		try {
			if (StringUtil.isStrNotEmpty(tBaseInfo.getStartDate())) {
				startDate = ScfDateUtil.toDate(tBaseInfo.getStartDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
			}
			if (StringUtil.isStrNotEmpty(tBaseInfo.getEndDate())) {
				endDate = ScfDateUtil.toDate(tBaseInfo.getEndDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
			}

		} catch (ParseException e) {
			log.error("保存多方协议，日期转换错误" + e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20003), BCntErrorConstant.SCF_BAS_CNT_20003);
		}
		tBaseInfo.setTenor(ScfDateUtil.getTenOr(startDate, endDate));// 期限
		tBaseInfo.setProtocolCode(tBaseInfo.getProtocolNo());
		try {
			bCntMprotBaseInfoDAO.insert(tBaseInfo);
		} catch (Exception e) {// SCF_BAS_CNT_40005
			log.error(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40005), BCntErrorConstant.SCF_BAS_CNT_40005);

		}
		// 3.2 保存预付款协议表扩展B_CNT_MPROT_DEAL_INFO
		// protocolNo firstBailRatio firstBailType goodsNm
		// isInsurance condignee trasportationMode deliveryPoints dutyAssumeType
		// consignmentDays otherCustName
		BCntMprotDealInfo tblMutiProtDealInfo = new BCntMprotDealInfo();
		BeanUtils.copyProperties(fourProtocolVO, tblMutiProtDealInfo);
		try {
			bCntMprotDealInfoDAO.insert(tblMutiProtDealInfo);// 保存预付款协议表扩展B_CNT_MPROT_DEAL_INFO
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40005), BCntErrorConstant.SCF_BAS_CNT_40005);
		}
		// 3.3保存多方协议参与者信息表B_CNT_MPROT_PART_INFO
		try {
			// 1.保存授信客户/经销商（买方）
			BCntMprotPartInfo tPartInfosec = new BCntMprotPartInfo();
			tPartInfosec.setId(UUIDGeneratorUtil.generate());
			tPartInfosec.setProtocolNo(fourProtocolVO.getProtocolNo());
			tPartInfosec.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
			tPartInfosec.setCustcd(fourProtocolVO.getCustcd());
			tPartInfosec.setActno(fourProtocolVO.getBalanceAccount());
			tPartInfosec.setBailActno(fourProtocolVO.getBailAccount());
			tPartInfosec.setCname(fourProtocolVO.getSellerNm());
			tPartInfosec.setAddress(fourProtocolVO.getSellerRegAddr());
			tPartInfosec.setAttn(fourProtocolVO.getSellerContactName());
			bCntMprotPartInfoDAO.insertSelective(tPartInfosec);
			// 2.保存核心厂商
			BCntMprotPartInfo tPartInfofir = new BCntMprotPartInfo();
			tPartInfofir.setId(UUIDGeneratorUtil.generate());
			tPartInfofir.setProtocolNo(fourProtocolVO.getProtocolNo());
			tPartInfofir.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
			tPartInfofir.setCustcd(fourProtocolVO.getCoreCustcd());
			tPartInfofir.setActno(fourProtocolVO.getCoreAccount());
			tPartInfofir.setCname(fourProtocolVO.getCoreNm());
			tPartInfofir.setAddress(fourProtocolVO.getCoreRegAddr());
			tPartInfofir.setAttn(fourProtocolVO.getCoreContactName());
			bCntMprotPartInfoDAO.insertSelective(tPartInfofir);
			// 3.回购厂商/承担方
			BCntMprotPartInfo tPartInfofour = new BCntMprotPartInfo();
			tPartInfofour.setId(UUIDGeneratorUtil.generate());
			tPartInfofour.setProtocolNo(fourProtocolVO.getProtocolNo());
			tPartInfofour.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);
			tPartInfofour.setCustcd(fourProtocolVO.getFouCd());
			tPartInfofour.setCname(fourProtocolVO.getFouName());
			tPartInfofour.setActno(fourProtocolVO.getRefundAccount());
			bCntMprotPartInfoDAO.insertSelective(tPartInfofour);
			// 4.保存经办机构
			BCntMprotPartInfo tPartInfobnk = new BCntMprotPartInfo();
			tPartInfobnk.setId(UUIDGeneratorUtil.generate());
			tPartInfobnk.setProtocolNo(fourProtocolVO.getProtocolNo());
			tPartInfobnk.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_BANK);
			tPartInfobnk.setCustcd(fourProtocolVO.getBrcode());
			tPartInfobnk.setCname(fourProtocolVO.getInputorgname());
			bCntMprotPartInfoDAO.insertSelective(tPartInfobnk);
			// 5. 监管方
			BCntMprotPartInfo moniPartInfofour = new BCntMprotPartInfo();
			moniPartInfofour.setId(UUIDGeneratorUtil.generate());
			moniPartInfofour.setProtocolNo(fourProtocolVO.getProtocolNo());
			moniPartInfofour.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
			moniPartInfofour.setCustcd(fourProtocolVO.getMoniCustcd());
			moniPartInfofour.setCname(fourProtocolVO.getMoniNm());
			bCntMprotPartInfoDAO.insertSelective(moniPartInfofour);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40005), BCntErrorConstant.SCF_BAS_CNT_40005);
		}

		return;
	}

	/*
	 * 修改先票/款后货协议
	 */
	@Override
	@Transactional
	public void franchiserProtocolModify(FourProtocolVO fourProtocolVO) throws ScubeBizException {
		// 1. 校验数据
		if (fourProtocolVO == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20002), BCntErrorConstant.SCF_BAS_CNT_20002);
		}

		// 2. 页面客户校验 买方，卖方，回款方，监管方，合作机构
		checkSelectForfranchiserProtocol(fourProtocolVO);

		// 4. 修改数据
		String loanWay = fourProtocolVO.getLoanWay();// 出账方式
		String dutyAssumeType = fourProtocolVO.getDutyAssumeType();// 卖方责任承担方式
		fourProtocolVO.setLoanWay(StringUtil.formatCheckBoxValue(loanWay));// 格式化出账方式，去掉[]，去掉""
		fourProtocolVO.setDutyAssumeType(StringUtil.formatCheckBoxValue(dutyAssumeType));// 格式化出账方式，去掉[]，去掉""
		ScfGlobalInfo scfGlobalInfo = ScfBaseData.getScfGlobalInfoData();
		BCntMprotBaseInfo tBaseInfo = new BCntMprotBaseInfo();
		// 4.1修改多方协议基础信息
		tBaseInfo = bCntMprotBaseInfoDAO.selectByPrimaryKey(fourProtocolVO.getProtocolNo());
		tBaseInfo.setSignDate(scfGlobalInfo.getTxnDate());
		tBaseInfo.setSignIn(fourProtocolVO.getSignIn());
		tBaseInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 机构号
		tBaseInfo.setTlrno(ContextHolder.getUserInfo().getTlrNo());// 操作员号
		// TODO 这里的日期得取工作日
		tBaseInfo.setUpdateDate(new Date());
		tBaseInfo.setCooperationBrcode(fourProtocolVO.getCooperationBrcode());// 合作机构
		tBaseInfo.setStartDate(fourProtocolVO.getStartDate());
		tBaseInfo.setEndDate(fourProtocolVO.getEndDate());
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
		tBaseInfo.setDeliveryMode(fourProtocolVO.getDeliveryMode());
		tBaseInfo.setTenor(ScfDateUtil.getTenOr(startDate, endDate));// 期限
		tBaseInfo.setOtherDes(fourProtocolVO.getOtherDes());
		tBaseInfo.setCurcd(fourProtocolVO.getCurcd());
		tBaseInfo.setCooperationBrcode(fourProtocolVO.getCooperationBrcode());
		try {
			bCntMprotBaseInfoDAO.updateByPrimaryKey(tBaseInfo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40006), BCntErrorConstant.SCF_BAS_CNT_40006);

		}

		// 4.2修改预付款协议表扩展B_CNT_MPROT_DEAL_INFO
		BCntMprotDealInfo tblMutiProtDealInfo = new BCntMprotDealInfo();
		BeanUtils.copyProperties(fourProtocolVO, tblMutiProtDealInfo);
		if (("1").equals(fourProtocolVO.getDeliveryMode())) {
			// 一一对应模式下 首笔保证金提货模式 默认设为 首笔保证金在后期按比例提货
			tblMutiProtDealInfo.setFirstBailType(ScfBasConstant.TRI_DELIVERY_RULE_NONE);
		}
		try {
			bCntMprotDealInfoDAO.updateByPrimaryKey(tblMutiProtDealInfo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40006), BCntErrorConstant.SCF_BAS_CNT_40006);
		}
		// 页面的买方卖方都已经钉死，不可能修改数据
		try {
			// 4.3 修改监管公司
			BCntMprotPartInfoExample moniMprotPartInfoExample = new BCntMprotPartInfoExample();
			Criteria monicreateCriteria = moniMprotPartInfoExample.createCriteria();
			monicreateCriteria.andProtocolNoEqualTo(fourProtocolVO.getProtocolNo());
			monicreateCriteria.andRoleEqualTo(ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
			List<BCntMprotPartInfo> moniMprotPartInfoList = bCntMprotPartInfoDAO.selectByExample(moniMprotPartInfoExample);
			if (moniMprotPartInfoList != null && moniMprotPartInfoList.size() == 1) {
				BCntMprotPartInfo moniMprotPartInfo = moniMprotPartInfoList.get(0);
				moniMprotPartInfo.setCname(fourProtocolVO.getMoniNm());
				moniMprotPartInfo.setCustcd(fourProtocolVO.getMoniCustcd());
				bCntMprotPartInfoDAO.updateByPrimaryKey(moniMprotPartInfo);
			}
			// 4.4 修改承担公司
			BCntMprotPartInfoExample fouMprotPartInfoExample = new BCntMprotPartInfoExample();
			Criteria foucreateCriteria = fouMprotPartInfoExample.createCriteria();
			foucreateCriteria.andProtocolNoEqualTo(fourProtocolVO.getProtocolNo());
			foucreateCriteria.andRoleEqualTo(ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);
			List<BCntMprotPartInfo> fouMprotPartInfoList = bCntMprotPartInfoDAO.selectByExample(fouMprotPartInfoExample);
			if (fouMprotPartInfoList != null && fouMprotPartInfoList.size() == 1) {
				BCntMprotPartInfo fouMprotPartInfo = fouMprotPartInfoList.get(0);
				fouMprotPartInfo.setCname(fourProtocolVO.getFouName());
				fouMprotPartInfo.setCustcd(fourProtocolVO.getFouCd());
				bCntMprotPartInfoDAO.updateByPrimaryKey(fouMprotPartInfo);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40006), BCntErrorConstant.SCF_BAS_CNT_40006);
		}

		return;
	}

	/*
	 * 先票/款后货协议页面查询
	 *
	 */
	@Override
	public Page getFranchiserProtocolQuery(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO) throws ScubeBizException {
		Map<String, String> map = new HashMap<String, String>();
		Page scfPage = new Page(pageSize, pageNo, 0);
		if (null != deliveryQryVO) {
			String sellerNm = deliveryQryVO.getSellerNm();// 买方名称
			String state = deliveryQryVO.getState();// 协议状态
			String fouName = deliveryQryVO.getFouName();// 担保方名称
			String protocolNo = deliveryQryVO.getProtocolNo();// 协议号
			String coreNm = deliveryQryVO.getCoreNm();// 卖方名称
			String productId = deliveryQryVO.getProductId();// 业务品种
			String protocolType = deliveryQryVO.getProtocolType();// 协议类型
			if (StringUtil.isStrNotEmpty(sellerNm)) {
				map.put(SELLERNM, sellerNm);
			}
			if (StringUtil.isStrNotEmpty(state)) {
				map.put(STATE, state);
			}
			if (StringUtil.isStrNotEmpty(fouName)) {
				map.put(FOUNAME, fouName);
			}
			if (StringUtil.isStrNotEmpty(protocolNo)) {
				map.put(PROTOCOLNO, protocolNo);
			}
			if (StringUtil.isStrNotEmpty(coreNm)) {
				map.put(CORENM, coreNm);
			}
			if (StringUtil.isStrNotEmpty(productId)) {
				map.put(PRODUCTID, productId);
			}
			if (StringUtil.isStrNotEmpty(protocolType)) {
				map.put(PROTOCOLTYPE, protocolType);// 先票/款后货
			}
		}

		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);// 经销商
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);// 核心厂商
		map.put(ROLEBACKCORE, ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);// 回购厂商
		map.put(ROLEMONI, ScfBasConstant.PROTOCOL_PART_ROLE_MONI);// 监管公司
		bCntMprotBaseInfoDAO.getFourAgreementQuery(map, scfPage);// 分页查询
		// PageQueryResult pageQueryResult =
		// fourServiceDAO.getFourAgreementQuery(fourQryVO);
		// 台账查询使用 老代码 FourService.java getFranchiserProtocolQuery 方法
		return scfPage;
	}
	
	@Override
	public Page getFranchiserProtocolQueryCETK(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO) throws ScubeBizException {
		Map<String, Object> map = new HashMap<String, Object>();
		Page scfPage = new Page(pageSize, pageNo, 0);
		if (null != deliveryQryVO) {
			String sellerNm = deliveryQryVO.getSellerNm();// 买方名称
			String state = deliveryQryVO.getState();// 协议状态
			String fouName = deliveryQryVO.getFouName();// 担保方名称
			String protocolNo = deliveryQryVO.getProtocolNo();// 协议号
			String coreNm = deliveryQryVO.getCoreNm();// 卖方名称
			String productId = deliveryQryVO.getProductId();// 业务品种
			String protocolType = deliveryQryVO.getProtocolType();// 协议类型
			if (StringUtil.isStrNotEmpty(sellerNm)) {
				map.put(SELLERNM, sellerNm);
			}
			if (StringUtil.isStrNotEmpty(state)) {
				map.put(STATE, state);
			}
			if (StringUtil.isStrNotEmpty(fouName)) {
				map.put(FOUNAME, fouName);
			}
			if (StringUtil.isStrNotEmpty(protocolNo)) {
				map.put(PROTOCOLNO, protocolNo);
			}
			if (StringUtil.isStrNotEmpty(coreNm)) {
				map.put(CORENM, coreNm);
			}
			if (StringUtil.isStrNotEmpty(productId)) {
				map.put(PRODUCTID, productId);
			}
			if (StringUtil.isStrNotEmpty(protocolType)) {
				map.put(PROTOCOLTYPE, protocolType);// 先票/款后货
			}
		}

		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);// 经销商
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);// 核心厂商
		map.put(ROLEBACKCORE, ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);// 回购厂商
		map.put(ROLEMONI, ScfBasConstant.PROTOCOL_PART_ROLE_MONI);// 监管公司
		commonQueryDAO.selectByPage("EXT_B_CNT_MPROT_PART_INFO.getFourAgreementQueryCETK", map, scfPage);
		// PageQueryResult pageQueryResult =
		// fourServiceDAO.getFourAgreementQuery(fourQryVO);
		// 台账查询使用 老代码 FourService.java getFranchiserProtocolQuery 方法
		return scfPage;
	}
	
	@Override
	public Page getFranchiserProtocolQueryByMap(int pageNo, int pageSize, HashMap<String, String> value) {
		Page scfPage = new Page(pageSize, pageNo, 0);
		value.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);// 经销商
		value.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);// 核心厂商
		value.put(ROLEBACKCORE, ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);// 回购厂商
		value.put(ROLEMONI, ScfBasConstant.PROTOCOL_PART_ROLE_MONI);// 监管公司
		bCntMprotBaseInfoDAO.getFourAgreementQuery(value, scfPage);// 分页查询
		return scfPage;
	}

}
