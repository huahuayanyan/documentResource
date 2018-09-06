/**
 * 
 */
package com.huateng.scf.bas.cnt.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
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
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.cnt.dao.IBCntBuyInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotDealInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.cnt.model.ThreeProtocolVO;
import com.huateng.scf.bas.cnt.service.IThreeProtocolService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample.Criteria;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 担保提货协议操作
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
@Service("ThreeProtocolServiceImpl")
public class ThreeProtocolServiceImpl implements IThreeProtocolService {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.cnt.service.IThreeProtocolService#
	 * queryThreeProtocolListByPage(int, int,
	 * com.huateng.scf.bas.cnt.model.DeliveryQryVO)
	 */
	@Override
	public Page queryThreeProtocolListByPage(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO) throws ScubeBizException {
		Map<String, String> map = new HashMap<String, String>();
		Page scfPage = new Page();
		scfPage.setPageNo(pageNo);
		scfPage.setPageSize(pageSize);
		if (null != deliveryQryVO) {
			String sellerNm = deliveryQryVO.getSellerNm();// 买方名称
			String state = deliveryQryVO.getState();// 协议状态
			String fouName = deliveryQryVO.getFouName();// 担保方名称
			String protocolNo = deliveryQryVO.getProtocolNo();// 协议号
			String coreNm = deliveryQryVO.getCoreNm();// 卖方名称
			String productId = deliveryQryVO.getProductId();//业务类型
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
			if (StringUtil.isStrNotEmpty(productId) ) {
				 map.put(PRODUCTID, productId);
				if(productId.equals(ScfBasConstant.PRODUCT_TYPE_XPHH)){//如果是先票/款后货
					map.put(STATE, ScfBasConstant.PROTOCOL_STATE_EFFECTIVE);//添加控制：协议状态必须为有效
				}else{
					map.put(PROTOCOLTYPE, ScfBasConstant.MUTI_PROTOCOL_THREEWH);
				}
			}
		}
		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		map.put(ROLEBACKCORE, ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);
		Page resultPage = bCntMprotBaseInfoDAO.queryThreeProtocolList(scfPage, map, true);// 分页查询
		if (null != resultPage) {
			log.info("=====================TotalPage>>>" + resultPage.getTotalPage());
			log.info("=====================TotalRecord>>>" + resultPage.getTotalRecord());
		}
		return resultPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.cnt.service.IThreeProtocolService#
	 * queryThreeProtocolForOneObject(com.huateng.scf.bas.cnt.model.
	 * ThreeProtocolVO)
	 */
	@Override
	public ThreeProtocolVO queryThreeProtocolForOneObject(ThreeProtocolVO threeProtocolVO) throws ScubeBizException {
		Map<String, String> map = new HashMap<String, String>();
		if (null != threeProtocolVO) {
			String sellerNm = threeProtocolVO.getSellerNm();// 买方名称
			String state = threeProtocolVO.getState();// 协议状态
			String fouName = threeProtocolVO.getFouName();// 担保方名称
			String protocolNo = threeProtocolVO.getProtocolNo();// 协议号
			String coreNm = threeProtocolVO.getCoreNm();// 卖方名称
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
		}
		map.put(PROTOCOLTYPE, ScfBasConstant.MUTI_PROTOCOL_THREEWH);
		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		map.put(ROLEBACKCORE, ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);
		ThreeProtocolVO reThreeProtocolVO = new ThreeProtocolVO();
		com.huateng.scf.bas.cnt.dao.model.ThreeProtocolVO daoThreeProtocolVO = new com.huateng.scf.bas.cnt.dao.model.ThreeProtocolVO();
		Page resultPage = bCntMprotBaseInfoDAO.queryThreeProtocolList(null, map, false);// 不分页查询
		if (null != resultPage) {
			List<com.huateng.scf.bas.cnt.dao.model.ThreeProtocolVO> threeProtocolVOList = resultPage.getRecords();
			if (null != threeProtocolVOList && threeProtocolVOList.size() > 0) {
				daoThreeProtocolVO = threeProtocolVOList.get(0);
			}
			BeanUtils.copyProperties(daoThreeProtocolVO, reThreeProtocolVO);
			String dutyAssumeType = daoThreeProtocolVO.getDutyAssumeType();
			if (StringUtil.isStrNotEmpty(dutyAssumeType)) {
				dutyAssumeType = StringUtil.reCheckBoxValue(dutyAssumeType);
			}
			String loanWay = daoThreeProtocolVO.getLoanWay();
			if (StringUtil.isStrNotEmpty(loanWay)) {
				loanWay = StringUtil.reCheckBoxValue(loanWay);
			}
			reThreeProtocolVO.setDutyAssumeType(dutyAssumeType);
			reThreeProtocolVO.setLoanWay(loanWay);
			if (StringUtil.isStrNotEmpty(reThreeProtocolVO.getTlrno())) {
				UserInfo userInfo = scubeUserService.selectUserByTlrNo(reThreeProtocolVO.getTlrno(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				if (userInfo != null) {
					reThreeProtocolVO.setTlrName(userInfo.getTlrName());
				}
			}
			if (StringUtil.isStrNotEmpty(reThreeProtocolVO.getBrcode())) {
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(reThreeProtocolVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				List<BctlVO> listBctl = new ArrayList<BctlVO>();
				listBctl.add(bctlVO);
				reThreeProtocolVO.setListBctl(listBctl);
			}

			reThreeProtocolVO.setCooperationBrcode(reThreeProtocolVO.getCooperationBrcode());
			if (StringUtil.isStrNotEmpty(reThreeProtocolVO.getCooperationBrcode())) {
				BctlVO brName = scubeUserService.selectBctlByBrNo(reThreeProtocolVO.getCooperationBrcode(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));
				reThreeProtocolVO.setCooperationBrcodeNm(brName.getBrName());
			}
			// reThreeProtocolVO=this.setPageUserOrg(reThreeProtocolVO);//设置用户及机构信息
		}
		return reThreeProtocolVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.cnt.service.IThreeProtocolService#threeProtocolAdd(
	 * com.huateng.scf.bas.cnt.model.ThreeProtocolVO)
	 */
	@Override
	@Transactional
	public void threeProtocolAdd(ThreeProtocolVO threeProtocolVO) throws ScubeBizException {
		// 1.校验客户
		if (null == threeProtocolVO) {
			log.error("threeProtocolVO参数对象不能为空！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20002), BCntErrorConstant.SCF_BAS_CNT_20002);
		}
		if (null != threeProtocolVO.getCustcd() && threeProtocolVO.getCustcd().equals(threeProtocolVO.getCoreCustcd())) {
			log.error("买卖双方不能为一个客户！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20000), BCntErrorConstant.SCF_BAS_CNT_20000);
		}
		if (null != threeProtocolVO.getCustcd() && threeProtocolVO.getCustcd().equals(threeProtocolVO.getFouCd())) {
			log.error("买方和担保方不能为一个客户！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20001), BCntErrorConstant.SCF_BAS_CNT_20001);
		}
		// 校验买方，卖方，承担方是否 存在名称与客户号不对应的情况
		this.checkthreeProCname(threeProtocolVO);
		String loanWay = threeProtocolVO.getLoanWay();// 出账方式
		String dutyAssumeType = threeProtocolVO.getDutyAssumeType();// 卖方责任承担方式
		threeProtocolVO.setLoanWay(StringUtil.formatCheckBoxValue(loanWay));// 格式化出账方式，去掉[]，去掉""
		threeProtocolVO.setDutyAssumeType(StringUtil.formatCheckBoxValue(dutyAssumeType));// 格式化出账方式，去掉[]，去掉""
		ScfGlobalInfo scfGlobalInfo = ScfBaseData.getScfGlobalInfoData();
		// 2.保存多方协议基础表B_CNT_MPROT_BASE_INFO
		BCntMprotBaseInfo tBaseInfo = new BCntMprotBaseInfo();
		BeanUtils.copyProperties(threeProtocolVO, tBaseInfo);
		tBaseInfo.setProductId(threeProtocolVO.getProductId());// 三方产品Id
		tBaseInfo.setProtocolType(ScfBasConstant.MUTI_PROTOCOL_THREEWH);// 协议类型:07-三方保兑仓协议
		tBaseInfo.setProtocolNo(bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_THREE_PROTOCOL_NO));// 担保提货流水号
		threeProtocolVO.setProtocolNo(tBaseInfo.getProtocolNo());
		tBaseInfo.setSignDate(scfGlobalInfo.getTxnDate());
		tBaseInfo.setSignIn(threeProtocolVO.getSignIn());
		// tBaseInfo.setState(ScfBasConstant.PROTOCOL_STATE_EFFECTIVE);//协议状态1-生效
		tBaseInfo.setState(threeProtocolVO.getState());
		tBaseInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 机构号
		tBaseInfo.setCurcd(threeProtocolVO.getCurcd());// 币种
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
		tBaseInfo.setOtherDes(tBaseInfo.getOtherDes());
		tBaseInfo.setCooperationBrcode(tBaseInfo.getCooperationBrcode());
		bCntMprotBaseInfoDAO.insertSelective(tBaseInfo);// 保存B_CNT_MPROT_BASE_INFO多方协议基础表
		// 3.保存预付款协议表扩展B_CNT_MPROT_DEAL_INFO
		BCntMprotDealInfo tblMutiProtDealInfo = new BCntMprotDealInfo();
		BeanUtils.copyProperties(threeProtocolVO, tblMutiProtDealInfo);
		bCntMprotDealInfoDAO.insertSelective(tblMutiProtDealInfo);// 保存预付款协议表扩展B_CNT_MPROT_DEAL_INFO
		// 4.保存多方协议参与者信息表B_CNT_MPROT_PART_INFO
		// 4.1保存授信客户/经销商
		BCntMprotPartInfo tPartInfosec = new BCntMprotPartInfo();
		tPartInfosec.setId(UUIDGeneratorUtil.generate());
		tPartInfosec.setProtocolNo(threeProtocolVO.getProtocolNo());
		tPartInfosec.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		tPartInfosec.setCustcd(threeProtocolVO.getCustcd());
		tPartInfosec.setActno(threeProtocolVO.getBalanceAccount());
		tPartInfosec.setBailActno(threeProtocolVO.getBailAccount());
		tPartInfosec.setCname(threeProtocolVO.getSellerNm());
		tPartInfosec.setAddress(threeProtocolVO.getSellerRegAddr());
		tPartInfosec.setAttn(threeProtocolVO.getSellerContactName());
		bCntMprotPartInfoDAO.insertSelective(tPartInfosec);
		// 4.2保存核心厂商
		BCntMprotPartInfo tPartInfofir = new BCntMprotPartInfo();
		tPartInfofir.setId(UUIDGeneratorUtil.generate());
		tPartInfofir.setProtocolNo(threeProtocolVO.getProtocolNo());
		tPartInfofir.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		tPartInfofir.setCustcd(threeProtocolVO.getCoreCustcd());
		tPartInfofir.setActno(threeProtocolVO.getCoreAccount());
		tPartInfofir.setCname(threeProtocolVO.getCoreNm());
		tPartInfofir.setAddress(threeProtocolVO.getCoreRegAddr());
		tPartInfofir.setAttn(threeProtocolVO.getCoreContactName());
		bCntMprotPartInfoDAO.insertSelective(tPartInfofir);
		// 4.3回购厂商/承担方
		BCntMprotPartInfo tPartInfofour = new BCntMprotPartInfo();
		tPartInfofour.setId(UUIDGeneratorUtil.generate());
		tPartInfofour.setProtocolNo(threeProtocolVO.getProtocolNo());
		tPartInfofour.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);
		tPartInfofour.setCustcd(threeProtocolVO.getFouCd());
		tPartInfofour.setCname(threeProtocolVO.getFouName());
		tPartInfofour.setActno(threeProtocolVO.getRefundAccount());
		bCntMprotPartInfoDAO.insertSelective(tPartInfofour);
		// 4.4保存经办机构
		BCntMprotPartInfo tPartInfobnk = new BCntMprotPartInfo();
		tPartInfobnk.setId(UUIDGeneratorUtil.generate());
		tPartInfobnk.setProtocolNo(threeProtocolVO.getProtocolNo());
		tPartInfobnk.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_BANK);
		tPartInfobnk.setCustcd(threeProtocolVO.getBrcode());
		tPartInfobnk.setCname(threeProtocolVO.getInputorgname());
		bCntMprotPartInfoDAO.insertSelective(tPartInfobnk);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.cnt.service.IThreeProtocolService#threeProtocolModify
	 * (com.huateng.scf.bas.cnt.model.ThreeProtocolVO)
	 */
	@Override
	@Transactional
	public void threeProtocolModify(ThreeProtocolVO threeProtocolVO) throws ScubeBizException {
		// 1.参数对象判断
		if (null == threeProtocolVO) {
			log.error("threeProtocolVO参数对象不能为空！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20002), BCntErrorConstant.SCF_BAS_CNT_20002);
		}
		// 校验买方，卖方，承担方是否 存在名称与客户号不对应的情况
		this.checkthreeProCname(threeProtocolVO);
		/** 2.判断是否有出账start **/
		// TODO 待补充业务校验
		List<BCntBuyInfo> list = bCntBuyInfoDAO.selectByProtocolNo(threeProtocolVO.getProtocolNo());
		boolean flag = true;
		if (list != null && list.size() > 0) {
			for (BCntBuyInfo info : list) {
				if (info.getTotAmt().compareTo(BigDecimal.ZERO) > 0) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				log.error("协议项下有出账业务，不能修改！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20007),
						BCntErrorConstant.SCF_BAS_CNT_20007);
			}
		}
		// List<TblContBuyInfo>
		// list=(List<TblContBuyInfo>)SCFDAOUtils.getTblContBuyInfoDAO().findByProtocolNo(threeProtocolVO.getProtocolNo());
		// boolean flag=true;
		// for(TblContBuyInfo tbi:list){
		// if(tbi.getTotAmt().compareTo(BigDecimal.ZERO)>0){
		// flag=false;
		// break;
		// }
		// }
		// if(!flag){
		// ExceptionUtil.throwCommonException("协议项下有出账，不能修改！",SCFErrorCode.ERROR_CODE_CANNOT_UPDATE);
		// }

		/** 2.判断是否有出账end **/
		// 3.校验客户
		if (null != threeProtocolVO.getCustcd() && threeProtocolVO.getCustcd().equals(threeProtocolVO.getCoreCustcd())) {
			log.error("买卖双方不能为一个客户！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20000), BCntErrorConstant.SCF_BAS_CNT_20000);
		}
		if (null != threeProtocolVO.getCustcd() && threeProtocolVO.getCustcd().equals(threeProtocolVO.getFouCd())) {
			log.error("买方和担保方不能为一个客户！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20001), BCntErrorConstant.SCF_BAS_CNT_20001);
		}
		String loanWay = threeProtocolVO.getLoanWay();// 出账方式
		String dutyAssumeType = threeProtocolVO.getDutyAssumeType();// 卖方责任承担方式
		threeProtocolVO.setLoanWay(StringUtil.formatCheckBoxValue(loanWay));// 格式化出账方式，去掉[]，去掉""
		threeProtocolVO.setDutyAssumeType(StringUtil.formatCheckBoxValue(dutyAssumeType));// 格式化出账方式，去掉[]，去掉""
		ScfGlobalInfo scfGlobalInfo = ScfBaseData.getScfGlobalInfoData();
		// 4.修改多方协议基础表B_CNT_MPROT_BASE_INFO
		BCntMprotBaseInfo tBaseInfo = new BCntMprotBaseInfo();
		// 4.1根据协议号查询多方协议基础信息
		tBaseInfo = bCntMprotBaseInfoDAO.selectByPrimaryKey(threeProtocolVO.getProtocolNo());
		tBaseInfo.setSignDate(scfGlobalInfo.getTxnDate());
		tBaseInfo.setSignIn(threeProtocolVO.getSignIn());
		tBaseInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 机构号
		tBaseInfo.setTlrno(ContextHolder.getUserInfo().getTlrNo());// 操作员号
		// TODO 这里的日期得取工作日
		tBaseInfo.setUpdateDate(new Date());
		tBaseInfo.setCooperationBrcode(threeProtocolVO.getCooperationBrcode());// 合作机构
		tBaseInfo.setStartDate(threeProtocolVO.getStartDate());
		tBaseInfo.setEndDate(threeProtocolVO.getEndDate());
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

		tBaseInfo.setOtherDes(threeProtocolVO.getOtherDes());
		tBaseInfo.setCurcd(threeProtocolVO.getCurcd());
		// 4.2修改多方协议基础信息
		bCntMprotBaseInfoDAO.updateByPrimaryKeySelective(tBaseInfo);
		// 5.修改预付款协议表扩展B_CNT_MPROT_DEAL_INFO
		BCntMprotDealInfo tblMutiProtDealInfo = new BCntMprotDealInfo();
		tblMutiProtDealInfo = bCntMprotDealInfoDAO.selectByPrimaryKey(threeProtocolVO.getProtocolNo());
		tblMutiProtDealInfo.setFirstBailRatio(threeProtocolVO.getFirstBailRatio());
		tblMutiProtDealInfo.setFirstBailType(threeProtocolVO.getFirstBailType());
		tblMutiProtDealInfo.setLoanDays(threeProtocolVO.getLoanDays());
		tblMutiProtDealInfo.setLoanWay(threeProtocolVO.getLoanWay());
		tblMutiProtDealInfo.setTakeMode(threeProtocolVO.getTakeMode());
		tblMutiProtDealInfo.setGoodsNm(threeProtocolVO.getGoodsNm());
		tblMutiProtDealInfo.setDutyAssumeType(threeProtocolVO.getDutyAssumeType());
		tblMutiProtDealInfo.setOtherCustName(threeProtocolVO.getOtherCustName());
		bCntMprotDealInfoDAO.updateByPrimaryKeySelective(tblMutiProtDealInfo);
		// 6.修改核心厂商
		BCntMprotPartInfo tPartInfofir = new BCntMprotPartInfo();
		BCntMprotPartInfoExample tPartInfofirEp = new BCntMprotPartInfoExample();
		BCntMprotPartInfoExample.Criteria criteria = tPartInfofirEp.createCriteria();
		if (null != threeProtocolVO.getProtocolNo()) {
			criteria.andProtocolNoEqualTo(threeProtocolVO.getProtocolNo());
		}
		criteria.andRoleEqualTo(ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		List<BCntMprotPartInfo> bCntMprotPartInfoList = bCntMprotPartInfoDAO.selectByExample(tPartInfofirEp);
		if (null != bCntMprotPartInfoList && bCntMprotPartInfoList.size() > 0) {
			tPartInfofir = (BCntMprotPartInfo) bCntMprotPartInfoList.get(0);
		}
		tPartInfofir.setActno(threeProtocolVO.getCoreAccount());
		tPartInfofir.setCustcd(threeProtocolVO.getCoreCustcd());
		tPartInfofir.setCname(threeProtocolVO.getCoreNm());
		bCntMprotPartInfoDAO.updateByPrimaryKeySelective(tPartInfofir);
		// 7.修改授信客户/经销商
		BCntMprotPartInfo tPartInfosec = new BCntMprotPartInfo();
		BCntMprotPartInfoExample tPartInfofirEp2 = new BCntMprotPartInfoExample();
		BCntMprotPartInfoExample.Criteria criteria2 = tPartInfofirEp2.createCriteria();
		if (null != threeProtocolVO.getProtocolNo()) {
			criteria2.andProtocolNoEqualTo(threeProtocolVO.getProtocolNo());
		}
		criteria2.andRoleEqualTo(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		List<BCntMprotPartInfo> tPartInfosecList = bCntMprotPartInfoDAO.selectByExample(tPartInfofirEp2);
		if (null != tPartInfosecList && tPartInfosecList.size() > 0) {
			tPartInfosec = (BCntMprotPartInfo) tPartInfosecList.get(0);
		}
		tPartInfosec.setActno(threeProtocolVO.getBalanceAccount());
		tPartInfosec.setBailActno(threeProtocolVO.getBailAccount());
		tPartInfosec.setCustcd(threeProtocolVO.getCustcd());
		tPartInfosec.setCname(threeProtocolVO.getSellerNm());
		bCntMprotPartInfoDAO.updateByPrimaryKeySelective(tPartInfosec);
		// 8.回购厂商
		BCntMprotPartInfo tPartInfofour = new BCntMprotPartInfo();
		BCntMprotPartInfoExample tPartInfofirEp3 = new BCntMprotPartInfoExample();
		BCntMprotPartInfoExample.Criteria criteria3 = tPartInfofirEp3.createCriteria();
		if (null != threeProtocolVO.getProtocolNo()) {
			criteria3.andProtocolNoEqualTo(threeProtocolVO.getProtocolNo());
		}
		criteria3.andRoleEqualTo(ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);
		List<BCntMprotPartInfo> tPartInfofourList = bCntMprotPartInfoDAO.selectByExample(tPartInfofirEp3);
		if (null != tPartInfofourList && tPartInfofourList.size() > 0) {
			tPartInfofour = (BCntMprotPartInfo) tPartInfofourList.get(0);
		}
		tPartInfofour.setActno(threeProtocolVO.getRefundAccount());
		tPartInfofour.setCustcd(threeProtocolVO.getFouCd());
		tPartInfofour.setCname(threeProtocolVO.getFouName());
		bCntMprotPartInfoDAO.updateByPrimaryKeySelective(tPartInfofour);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.cnt.service.IThreeProtocolService#threeProtocolDelete
	 * (com.huateng.scf.bas.cnt.model.ThreeProtocolVO)
	 */
	@Transactional
	@Override
	public void threeProtocolDelete(ThreeProtocolVO threeProtocolVO) throws ScubeBizException {
		String protocolNo = threeProtocolVO.getProtocolNo();
		// 1.判断协议号是否存在
		if (StringUtil.isEmpty(protocolNo)) {
			log.error("协议号丢失!");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20004), BCntErrorConstant.SCF_BAS_CNT_20004);
		}
		// 2.查询多方协议信息，无记录抛错
		BCntMprotBaseInfo tBaseInfo = bCntMprotBaseInfoDAO.selectByPrimaryKey(protocolNo);
		if (null == tBaseInfo) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKeyParams(BCntErrorConstant.SCF_BAS_CNT_20005, new Object[] { protocolNo }),
					BCntErrorConstant.SCF_BAS_CNT_20005);
		}
		// 3.查询协议扩展信息，无记录抛错
		BCntMprotDealInfo tblMutiProtDealInfo = bCntMprotDealInfoDAO.selectByPrimaryKey(protocolNo);
		if (null == tblMutiProtDealInfo) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKeyParams(BCntErrorConstant.SCF_BAS_CNT_20005, new Object[] { protocolNo }),
					BCntErrorConstant.SCF_BAS_CNT_20005);
		}
		// TODO 4.校验业务合同
		BCrrLnConExample example = new BCrrLnConExample();
		Criteria criteria = example.createCriteria();
		criteria.andVidNoEqualTo(protocolNo);
		List<BCrrLnCon> list = bCrrLnConDAO.selectByExample(example);
		if (list != null && list.size() > 0) {
			log.error("已有信贷合同关联该担保提货协议，不允许进行删除操作！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20006), BCntErrorConstant.SCF_BAS_CNT_20006);
		}
		// 校验购销合同是否 关联协议(担保提货协议/先票(款)后货协议)号
		BCntBuyInfoExample buyExample = new BCntBuyInfoExample();
		com.huateng.scf.bas.cnt.dao.model.BCntBuyInfoExample.Criteria cri = buyExample.createCriteria();
		cri.andProtocolNoEqualTo(protocolNo);
		List<BCntBuyInfo> buyList = bCntBuyInfoDAO.selectByExample(buyExample);
		if (buyList != null && buyList.size() > 0) {
			log.error("已有购销合同关联该担保提货协议，不允许进行删除操作！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20008), BCntErrorConstant.SCF_BAS_CNT_20008);
		}
		// TblContBaseInfo contBaseInfo =
		// SCFDAOUtils.getTblContBaseInfoDAO().getMastContByBusinessNo(protocolNo);
		// if(!SCFDataFormat.isNull(contBaseInfo)){
		// ExceptionUtil.throwCommonException("已有信贷合同关联改担保提货协议，不允许进行删除操作！",
		// SCFErrorCode.ERROR_CODE_CANNOT_DEL);
		// }
		// 5.删除操作
		// 删除协议基本信息
		int deltBaseInfoCount = bCntMprotBaseInfoDAO.deleteByPrimaryKey(tBaseInfo.getProtocolNo());
		log.info("-------------------------删除协议基本信息记录deltBaseInfoCount:" + deltBaseInfoCount);
		// 删除扩展信息
		int mutiProtDealInfoCount = bCntMprotDealInfoDAO.deleteByPrimaryKey(tblMutiProtDealInfo.getProtocolNo());
		log.info("-------------------------删除协议扩展信息记录mutiProtDealInfoCount:" + mutiProtDealInfoCount);
		// 删除协议多方信息
		BCntMprotPartInfoExample tPartInfofirEp = new BCntMprotPartInfoExample();
		if (null != threeProtocolVO.getProtocolNo()) {
			tPartInfofirEp.createCriteria().andProtocolNoEqualTo(protocolNo);
		}
		List<BCntMprotPartInfo> bCntMprotPartInfoList = bCntMprotPartInfoDAO.selectByExample(tPartInfofirEp);
		if (null != bCntMprotPartInfoList && bCntMprotPartInfoList.size() > 0) {
			for (int i = 0; i < bCntMprotPartInfoList.size(); i++) {
				BCntMprotPartInfo tPartInfofir = (BCntMprotPartInfo) bCntMprotPartInfoList.get(i);
				bCntMprotPartInfoDAO.deleteByPrimaryKey(tPartInfofir.getId());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.cnt.service.IThreeProtocolService#initPageUserOrg()
	 */
	@Override
	public ThreeProtocolVO initPageUserOrg() throws ScubeBizException {
		ThreeProtocolVO threeProtocolVO = new ThreeProtocolVO();
		threeProtocolVO = this.setPageUserOrg(threeProtocolVO);
		return threeProtocolVO;
	}

	/**
	 * 设置用户及机构 信息
	 * 
	 * @param threeProtocolVO
	 * @return
	 * @throws ScubeBizException
	 */
	public ThreeProtocolVO setPageUserOrg(ThreeProtocolVO threeProtocolVO) throws ScubeBizException {
		// 获取机构信息
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		threeProtocolVO.setBrcode(bctlVO.getBrNo());
		threeProtocolVO.setInputorgname(bctlVO.getBrName());
		UserInfo user = ContextHolder.getUserInfo();
		threeProtocolVO.setTlrno(user.getTlrNo());
		threeProtocolVO.setTlrName(user.getTlrName());
		List<BctlVO> listBctl = new ArrayList<BctlVO>();
		listBctl.add(bctlVO);
		threeProtocolVO.setListBctl(listBctl);
		return threeProtocolVO;
	}

	/**
	 * 校验担保提货：买方名称,卖方名称,承担方名称 是否是手动输入的，而不是
	 * 
	 * @param threeProtocolVO
	 */
	@Transactional
	public void checkthreeProCname(ThreeProtocolVO threeProtocolVO) {
		if (StringUtil.isEmpty(threeProtocolVO.getSellerNm()) || StringUtil.isEmpty(threeProtocolVO.getCoreNm())
				|| StringUtil.isEmpty(threeProtocolVO.getFouName())) {
			throw new ScubeBizException("前台所传数据无效!");
		}

		// 前台客户名称检验（是否是客户手输的，不是通过下拉菜单选择的。）
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		bCrmBaseInfo.setCname(threeProtocolVO.getSellerNm());
		bCrmBaseInfo.setCustcd(threeProtocolVO.getCustcd());
		int checkCustomerForSelect = bCrmBaseInfoService.checkCustomerForSelect(bCrmBaseInfo);
		if (checkCustomerForSelect != 1) {
			throw new ScubeBizException("买方名称与买方客户号不对应，请通过对应的查询按钮选择买方!");
		}
		BCrmBaseInfo coreCd = new BCrmBaseInfo();
		coreCd.setCname(threeProtocolVO.getCoreNm());
		coreCd.setCustcd(threeProtocolVO.getCoreCustcd());
		int checkcoreCdForSelect = bCrmBaseInfoService.checkCustomerForSelect(coreCd);
		if (checkcoreCdForSelect != 1) {
			throw new ScubeBizException("卖方名称与卖方客户号不对应，请通过对应的查询按钮选择卖方!");
		}
		// 承担方
		BCrmBaseInfo fouCd = new BCrmBaseInfo();
		fouCd.setCname(threeProtocolVO.getFouName());
		fouCd.setCustcd(threeProtocolVO.getFouCd());
		int checkCoreCustForSelect = bCrmBaseInfoService.checkCustomerForSelect(fouCd);
		if (checkCoreCustForSelect != 1) {
			throw new ScubeBizException("承担方名称与承担方客户号不对应，请通过对应的查询按钮选择承担方!");
		}
	}

}
