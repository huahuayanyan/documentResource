package com.huateng.scf.bas.cnt.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.cnt.dao.IBCntBuyInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfoExample.Criteria;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyRepayInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotInfoExample;
import com.huateng.scf.bas.cnt.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotInfo;
import com.huateng.scf.bas.cnt.model.ThreeProtocolVO;
import com.huateng.scf.bas.cnt.service.IBCntBuyInfoService;
import com.huateng.scf.bas.cnt.service.IThreeProtocolService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.lan.model.ApplyBuyContVO;
import com.huateng.scf.bas.lan.model.BLanLnciBuyBiz;
import com.huateng.scf.bas.lan.service.IBLanLnciBuyBizService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BCntBuyInfoServiceImpl")
public class BCntBuyInfoServiceImpl implements IBCntBuyInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BCntBuyInfoDAO")
	IBCntBuyInfoDAO bCntBuyInfoDAO;

	@Resource(name = "BCntMprotInfoDAO")
	IBCntMprotInfoDAO bCntMprotInfoDAO;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;

	@Resource(name = "bCrmBaseInfoService")
	IBCrmBaseInfoService bCrmBaseInfoService;

	@Resource(name = "ThreeProtocolServiceImpl")
	IThreeProtocolService threeProtocolService;

	@Resource(name = "BCntMprotBaseInfoDAO")
	private IBCntMprotBaseInfoDAO bCntMprotBaseInfoDAO;
	@Resource(name = IBLanLnciBuyBizService.BEAN_ID)
	private IBLanLnciBuyBizService bLanLnciBuyBizService;

	private static final String CUSTCD = "custcd";
	private static final String CORECUSTCD = "coreCustcd";
	private static final String PROTOCOLNO = "protocolNo";
	private static final String PROTOCOLTYPE = "protocolType";
	private static final String ROLECREDIT = "roleCredit";
	private static final String ROLECORE = "roleCore";
	private static final String STATE = "state";
	private static final String TRADECONTCODE = "tradeContcode";
	private static final String CUSTNAME = "custName";
	private static final String CORECUSTNAME = "coreCustName";

	// private static final String FLAG = "flag";
	@Transactional
	@Override
	public BCntBuyInfo addBCntBuyInfo(BCntBuyInfo bCntBuyInfo, List<BCntMprotInfo> insertList) throws ScubeBizException {
		// 1 校验购销合同号是否已存在
		if (bCntBuyInfo != null) {

			String tradeContcode = bCntBuyInfo.getTradeContcode();
			if (StringUtil.isStrNotEmpty(tradeContcode)) {
				BCntBuyInfoExample example = new BCntBuyInfoExample();
				Criteria criteria = example.createCriteria();
				criteria.andTradeContcodeEqualTo(tradeContcode);
				List<com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo> list = bCntBuyInfoDAO.selectByExample(example);
				if (list != null && list.size() > 0) {
					log.error("购销合同号已存在，不允许重复！");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40000),
							BCntErrorConstant.SCF_BAS_CNT_40000);
				}
			}
		}
		// 校验筛选框TODO
		// this.checkInputExtent(bCntBuyInfo);
		// 设置用户
		UserInfo userInfo = ContextHolder.getUserInfo();
		String brcode = userInfo.getBrNo();
		String tlrno = userInfo.getTlrNo();

		com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo bCntBuyInfoDal = new com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo();

		try {
			BeanUtils.copyProperties(bCntBuyInfo, bCntBuyInfoDal);

		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}

		bCntBuyInfoDal.setStatus(ScfBasConstant.FLAG_VALID);
		bCntBuyInfoDal.setBrcode(brcode);
		bCntBuyInfoDal.setTlrno(tlrno);

		if (org.apache.commons.lang3.StringUtils.isBlank(bCntBuyInfo.getTradeContno())) {
			String uuid = UUIDGeneratorUtil.generate(bCntBuyInfo).substring(0, 20);
			bCntBuyInfoDal.setTradeContno(uuid);
		}

		bCntBuyInfoDal.setTlrcd(userInfo.getTlrName());

		bCntBuyInfoDal.setBrcode(userInfo.getBrNo());
		// 设置创建时间
		Date today = new Date();
		bCntBuyInfoDal.setCrtTime(today);
		try {
			bCntBuyInfoDAO.insert(bCntBuyInfoDal);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("保存新增信息失败！");
			throw new ScubeBizException("保存新增信息失败！", e);
		}

		for (int i = 0; i < insertList.size(); i++) {
			BCntMprotInfo bCntMprotInfo = insertList.get(i);
			com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo bCntMprotInfoDal = new com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo();
			BeanUtils.copyProperties(bCntMprotInfo, bCntMprotInfoDal);
			bCntMprotInfoDal.setBalAmount(bCntMprotInfoDal.getTotPrice());// 剩余总额
			bCntMprotInfoDal.setBalQuantity(bCntMprotInfoDal.getQuantity());// 剩余数量
			if (StringUtil.isEmpty(bCntMprotInfoDal.getMortgageNo())) {
				String serilaNo = ibSysSerialNoService.genSerialNo("MORTGAGE_NO");
				bCntMprotInfoDal.setMortgageNo(serilaNo);
			}
			bCntMprotInfoDal.setTradeContno(bCntBuyInfoDal.getTradeContno());
			// bCntMprotInfoDal.setProtocolNo(bCntBuyInfo.getProtocolNo());
			bCntMprotInfoDAO.insert(bCntMprotInfoDal);
		}

		return bCntBuyInfo;
	}

	@Transactional
	@Override
	public int updateBCntBuyInfoObject(BCntBuyInfo bCntBuyInfo) throws ScubeBizException {

		int i = 0;

		if (!StringUtil.isEmpty(bCntBuyInfo)) {
			com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo bCntBuyInfoDal = new com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo();
			try {
				BeanUtils.copyProperties(bCntBuyInfo, bCntBuyInfoDal);
			} catch (BeansException e) {
				e.printStackTrace();
				log.error("转换异常！");
				throw new ScubeBizException("转换异常", e);
			}

			try {
				i = bCntBuyInfoDAO.updateByPrimaryKey(bCntBuyInfoDal);
			} catch (Exception e) {
				// e.printStackTrace();
				log.error("更新购销合同信息失败！");
				throw new ScubeBizException("更新购销合同信息失败！", e);
			}

		}

		return i;
	}

	@Transactional
	@Override
	public int deleteByPrimaryKey(String key) throws ScubeBizException {
		int index = 0;

		try {
			index = bCntBuyInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("删除购销合同信息失败！");
			throw new ScubeBizException("删除购销合同信息失败！", e);
		}
		return index;
	}

	@Override
	public BCntBuyInfo findBCntBuyInfoByKey(String key) throws ScubeBizException {
		BCntBuyInfo bCntBuyInfo = new BCntBuyInfo();
		com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo bCntBuyInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo();
		bCntBuyInfodal = bCntBuyInfoDAO.selectByPrimaryKey(key);
		BeanUtils.copyProperties(bCntBuyInfodal, bCntBuyInfo);
		return bCntBuyInfo;
	}

	@Override
	public Page findBCntBuyInfoByPage(int pageNo, int pageSize, BCntBuyInfo bCntBuyInfo) throws ScubeBizException {
		BCntBuyInfoExample example = new BCntBuyInfoExample();
		Page p = new Page(pageSize, pageNo, 0);
		// 查询条件
		if (bCntBuyInfo != null) {
			Criteria criteria = example.createCriteria();

			if (!StringUtil.isEmpty(bCntBuyInfo.getCname())) {
				criteria.andCnameLike("%" + bCntBuyInfo.getCname() + "%");
			}

			if (!StringUtil.isEmpty(bCntBuyInfo.getSecCname())) {
				criteria.andSecCnameLike("%" + bCntBuyInfo.getSecCname() + "%");
			}

			if (!StringUtil.isEmpty(bCntBuyInfo.getTradeContno())) {
				criteria.andTradeContnoEqualTo(bCntBuyInfo.getTradeContno());
			}
			if (!StringUtil.isEmpty(bCntBuyInfo.getTradeContcode())) {
				criteria.andTradeContcodeLike("%" + bCntBuyInfo.getTradeContcode() + "%");
			}
			if (!StringUtil.isEmpty(bCntBuyInfo.getProtocolNo())) { // 模糊查詢
				// criteria.andProtocolNoEqualTo(bCntBuyInfo.getProtocolNo());
				criteria.andProtocolNoLike("%" + bCntBuyInfo.getProtocolNo() + "%");
			}

			example.setOrderByClause("CRT_TIME desc"); // 排序
			p.setRecords(bCntBuyInfoDAO.selectByPage(example, p));
		}
		return p;
	}

	/*
	 * @Override public List<BCntBuyInfo>
	 * selectBCntBuyInfoByExample(BCntBuyInfoExample example) throws
	 * ScubeBizException { BCntBuyInfoExample bCntBuyInfoExample = new
	 * BCntBuyInfoExample();
	 * 
	 * try { BeanUtils.copyProperties(example, bCntBuyInfoExample); } catch
	 * (BeansException e) { e.printStackTrace(); log.error("转换异常！"); throw new
	 * ScubeBizException("转换异常", e); }
	 * 
	 * List<BCntBuyInfo> list =
	 * bCntBuyInfoDAO.selectByExample(bCntBuyInfoExample);
	 * 
	 * return list; }
	 */

	@Transactional
	@Override
	public int deleteByVO(BCntBuyInfo bCntBuyInfo) throws ScubeBizException {

		int i = 0;
		if (bCntBuyInfo != null) {
			// add校验
			// 已关联业务的购销合同不允许删除
			BLanLnciBuyBiz bizQuery = new BLanLnciBuyBiz();
			bizQuery.setTradeContno(bCntBuyInfo.getTradeContno());
			List<BLanLnciBuyBiz> buyList = bLanLnciBuyBizService.findBLanLnciBuyBizByCondition(bizQuery);
			if (buyList != null && buyList.size() > 0) {
				log.error("已关联业务的购销合同不允许删除！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40003),
						BCntErrorConstant.SCF_BAS_CNT_40003);
			}
			com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo buyInfo = bCntBuyInfoDAO.selectByPrimaryKey(bCntBuyInfo.getTradeContno());
			// 已有累计出账金额或审批中出账金额的购销合同不允许删除 changhao.huang
			BigDecimal totAmt = buyInfo.getTotAmt() == null ? BigDecimal.ZERO : buyInfo.getTotAmt();
			BigDecimal remainAmt = buyInfo.getRemainAmt() == null ? BigDecimal.ZERO : buyInfo.getRemainAmt();
			if (totAmt.compareTo(BigDecimal.ZERO) > 0 || remainAmt.compareTo(BigDecimal.ZERO) > 0) {
				log.error("已有累计出账金额或审批中出账金额的购销合同不允许删除！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40001),
						BCntErrorConstant.SCF_BAS_CNT_40001);
			}

			// 删除此条购销合同
			String key = bCntBuyInfo.getTradeContno();

			if (!StringUtil.isEmpty(key)) {

				i = bCntBuyInfoDAO.deleteByPrimaryKey(key);
			}

			// 删除与此条购销合同相关的质押品信息

			BCntMprotInfoExample example = new BCntMprotInfoExample();

			com.huateng.scf.bas.cnt.dao.model.BCntMprotInfoExample.Criteria criteria = example.createCriteria();

			criteria.andTradeContnoEqualTo(key);

			List<com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo> list = bCntMprotInfoDAO.selectByExample(example);

			for (com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo mprotInfo : list) {
				bCntMprotInfoDAO.deleteByPrimaryKey(mprotInfo.getMortgageNo());
			}

		}

		return i;
	}

	@Transactional
	@Override
	public int updateBCntBuyInfo(BCntBuyInfo bCntBuyInfo, List<BCntMprotInfo> insertList, List<BCntMprotInfo> deleteList) throws ScubeBizException {
		// 校验筛选框 TODO
		// this.checkInputExtent(bCntBuyInfo);

		int index = 0;
		if (!StringUtil.isEmpty(bCntBuyInfo)) {
			// add校验
			// 已关联业务的购销合同不允许修改
			BLanLnciBuyBiz bizQuery = new BLanLnciBuyBiz();
			bizQuery.setTradeContno(bCntBuyInfo.getTradeContno());
			List<BLanLnciBuyBiz> buyList = bLanLnciBuyBizService.findBLanLnciBuyBizByCondition(bizQuery);
			if (buyList != null && buyList.size() > 0) {
				log.error("已关联业务的购销合同不允许修改！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40004),
						BCntErrorConstant.SCF_BAS_CNT_40004);
			}
			com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo buyInfo = bCntBuyInfoDAO.selectByPrimaryKey(bCntBuyInfo.getTradeContno());
			// 已有累计出账金额或审批中出账金额的购销合同不允许删除 changhao.huang
			BigDecimal totAmt = buyInfo.getTotAmt() == null ? BigDecimal.ZERO : buyInfo.getTotAmt();
			BigDecimal remainAmt = buyInfo.getRemainAmt() == null ? BigDecimal.ZERO : buyInfo.getRemainAmt();
			if (totAmt.compareTo(BigDecimal.ZERO) > 0 || remainAmt.compareTo(BigDecimal.ZERO) > 0) {
				log.error("已有累计出账金额或审批中出账金额的购销合同不允许修改！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_40002),
						BCntErrorConstant.SCF_BAS_CNT_40002);
			}

			com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo bCntBuyInfoDal = new com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo();
			try {
				BeanUtils.copyProperties(bCntBuyInfo, bCntBuyInfoDal);
			} catch (BeansException e) {
				e.printStackTrace();
				log.error("转换异常！");
				throw new ScubeBizException("转换异常", e);
			}

			try {
				index = bCntBuyInfoDAO.updateByPrimaryKey(bCntBuyInfoDal);
			} catch (Exception e) {
				// e.printStackTrace();
				log.error("更新购销合同信息失败！");
				throw new ScubeBizException("更新购销合同信息失败！", e);
			}

		}

		if (deleteList != null && deleteList.size() > 0) {
			for (int j = 0; j < deleteList.size(); j++) {
				BCntMprotInfo bCntMprotInfo = deleteList.get(j);
				com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo bCntMprotInfoDel = new com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo();
				BeanUtils.copyProperties(bCntMprotInfo, bCntMprotInfoDel);
				if (org.apache.commons.lang3.StringUtils.isNotBlank(bCntMprotInfoDel.getMortgageNo())) {
					bCntMprotInfoDAO.deleteByObject(bCntMprotInfoDel);
				}

			}
		}

		for (int i = 0; i < insertList.size(); i++) {
			BCntMprotInfo bCntMprotInfo = insertList.get(i);
			com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo bCntMprotInfoDal = new com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo();
			BeanUtils.copyProperties(bCntMprotInfo, bCntMprotInfoDal);
			if (org.apache.commons.lang3.StringUtils.isBlank(bCntMprotInfoDal.getMortgageNo())) {

				if (StringUtil.isEmpty(bCntMprotInfoDal.getMortgageNo())) {
					String serilaNo = ibSysSerialNoService.genSerialNo("MORTGAGE_NO");
					bCntMprotInfoDal.setMortgageNo(serilaNo);
				}
				bCntMprotInfoDal.setTradeContno(bCntBuyInfo.getTradeContno());
				bCntMprotInfoDal.setProtocolNo(bCntBuyInfo.getProtocolNo());
				bCntMprotInfoDAO.insert(bCntMprotInfoDal);

			} else {
				bCntMprotInfoDal.setTradeContno(bCntBuyInfo.getTradeContno());
				bCntMprotInfoDal.setProtocolNo(bCntBuyInfo.getProtocolNo());
				bCntMprotInfoDAO.updateByPrimaryKey(bCntMprotInfoDal);
			}

		}

		return index;

	}

	/**
	 * @author liph 供应链补录购销合同添加
	 */
	@Override
	public Page selectBCntBuyInfo(int pageNo, int pageSize, BCntBuyInfo bCntBuyInfo, List list) throws ScubeBizException {
		BCntBuyInfoExample example = new BCntBuyInfoExample();
		Criteria cri = example.createCriteria();
		List<String> tradeContcodeList = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, String> map = (Map<String, String>) list.get(i);
				String tradeContcode = map.get("tradeContcode").toString();
				tradeContcodeList.add(tradeContcode);
			}
		}
		if (bCntBuyInfo != null) {
			if (bCntBuyInfo.getProtocolNo() != null && bCntBuyInfo.getProtocolNo().length() > 0) {
				cri.andProtocolNoEqualTo(bCntBuyInfo.getProtocolNo());
			}
			if (bCntBuyInfo.getStatus() != null && bCntBuyInfo.getStatus().length() > 0) {
				cri.andStatusEqualTo(bCntBuyInfo.getStatus());
			}
		}
		if (tradeContcodeList != null && tradeContcodeList.size() > 0) {
			cri.andTradeContcodeNotIn(tradeContcodeList);
		}
		example.setOrderByClause("CRT_TIME DESC");

		int total = bCntBuyInfoDAO.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());
		List<com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo> buyinfolist = bCntBuyInfoDAO.selectByPage(example, p);
		List<BCntBuyRepayInfo> repayInfo = new ArrayList<BCntBuyRepayInfo>();
		for (int i = 0; i < buyinfolist.size(); i++) {
			com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo buyInfo = buyinfolist.get(i);
			BCntBuyRepayInfo bCntBuyRepayInfo = new BCntBuyRepayInfo();
			bCntBuyRepayInfo.setTradeContno(buyInfo.getTradeContno());
			bCntBuyRepayInfo.setTradeContcode(buyInfo.getTradeContcode());
			bCntBuyRepayInfo.setCname(buyInfo.getCname());
			bCntBuyRepayInfo.setSecCname(buyInfo.getSecCname());
			bCntBuyRepayInfo.setCurcd(buyInfo.getCurcd());
			bCntBuyRepayInfo.setContAmt(buyInfo.getAmt() == null ? "0" : buyInfo.getAmt().toString());
			bCntBuyRepayInfo.setStartDate(buyInfo.getStartDate());
			bCntBuyRepayInfo.setEndDate(buyInfo.getEndDate());
			bCntBuyRepayInfo.setAccuLoanAmt(buyInfo.getTotAmt() == null ? "0" : buyInfo.getTotAmt().toString());
			repayInfo.add(bCntBuyRepayInfo);
		}
		p.setRecords(repayInfo);
		log.info("p.toString()=" + p.toString());
		return p;
	}

	/**
	 * 保兑仓协议筛选
	 */
	@Override
	public Page selectThreeProtocolList(int pageNo, int pageSize, Map<String, String> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		Page p = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		if (value != null && StringUtil.isEmpty(value.get("custcd"))) { // 买方
			throw new ScubeBizException("请先选择买方名称");
		}
		if (value != null && StringUtil.isStrNotEmpty(value.get("protocolNo"))) { // 协议号
			map.put(PROTOCOLNO, value.get("protocolNo").toString().trim());
		}
		if (value != null && StringUtil.isStrNotEmpty(value.get("protocolType"))) { // 协议类型
			map.put(PROTOCOLTYPE, value.get("protocolType").toString().trim());
		}
		if (value != null && StringUtil.isStrNotEmpty(value.get("custcd"))) { // 买方
			map.put(CUSTCD, value.get("custcd").toString().trim());
			map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		}
		// 购销合同卖方只读
		if (value != null && StringUtil.isStrNotEmpty(value.get("coreCustcd"))) { // 卖方
			map.put(CORECUSTCD, value.get("coreCustcd").toString().trim());
			map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE); // 授信客户
		}
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE); // 授信客户/经销商
		// map.put(PROTOCOLTYPE, ScfBasConstant.MUTI_PROTOCOL_THREEWH); //
		// 三方保兑仓协议
		map.put(STATE, ScfBasConstant.STATE_VALID); // 监管协议状态
		bCntBuyInfoDAO.selectThreeProtocolList(map, p);
		return p;
	}

	/**
	 * 校验筛选框的值是否手动输入，系统中不存在
	 * 
	 * @param threeProtocolVO
	 */
	@Transactional
	public void checkInputExtent(BCntBuyInfo VO) {
		if (StringUtil.isEmpty(VO.getCustcd()) || // 买方
				StringUtil.isEmpty(VO.getProtocolNo())) {
			throw new ScubeBizException("输入买方名称或是担保提货协议无效!");
		}

		// 前台客户名称检验（是否是客户手输的，不是通过下拉菜单选择的。）
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		bCrmBaseInfo.setCname(VO.getCname());
		bCrmBaseInfo.setCustcd(VO.getCustcd());
		int checkCustomerForSelect = bCrmBaseInfoService.checkCustomerForSelect(bCrmBaseInfo);
		if (checkCustomerForSelect != 1) {
			throw new ScubeBizException("买方名称与买方客户号不对应，请通过对应的查询按钮选择买方!");
		}
		// 校验担保提货协议是否是当前买方下的有效协议
		ThreeProtocolVO threeProtocolVO = new ThreeProtocolVO();
		threeProtocolVO.setCoreCustcd(VO.getSecCustcd()); // TODO
		threeProtocolVO.setProtocolNo(VO.getProtocolNo());
		threeProtocolVO.setState(ScfBasConstant.STATE_VALID);
		// TODO
		ThreeProtocolVO protocolVO = threeProtocolService.queryThreeProtocolForOneObject(threeProtocolVO);
		if (StringUtil.isEmpty(protocolVO.getProtocolNo()) || !(protocolVO.getProtocolNo().equals(VO.getProtocolNo()))) {
			log.error("该协议号并非选择的买方下的有效协议！");
			throw new ScubeBizException("该协议号并非选择的买方下的有效协议！");
		}
	}

	/***
	 * 购销合同列表查询
	 */
	@Override
	public Page queryBCntBuyInfoListByPage(int pageNo, int pageSize, Map<String, String> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != value) {
			if (value != null && StringUtil.isStrNotEmpty(value.get("protocolType"))) { // 协议类型
				map.put(PROTOCOLTYPE, value.get("protocolType").toString().trim());
			}

			if (value != null && StringUtil.isStrNotEmpty(value.get("custcd"))) { // 买方
				map.put(CUSTCD, value.get("custcd").toString().trim());
			}
			// 购销合同卖方
			if (value != null && StringUtil.isStrNotEmpty(value.get("coreCustcd"))) { // 卖方
				map.put(CORECUSTCD, value.get("coreCustcd").toString().trim());
			}
			if (value != null && StringUtil.isStrNotEmpty(value.get("cname"))) { // 买方
				map.put(CUSTNAME, value.get("cname").toString().trim());
			}
			// 购销合同卖方
			if (value != null && StringUtil.isStrNotEmpty(value.get("secCname"))) { // 卖方
				map.put(CORECUSTNAME, value.get("secCname").toString().trim());
			}
			if (value != null && StringUtil.isStrNotEmpty(value.get("tradeContcode"))) { // 购销合同号
				map.put(TRADECONTCODE, value.get("tradeContcode").toString().trim());
			}
			if (value != null && StringUtil.isStrNotEmpty(value.get("protocolNo"))) { // 协议号
				map.put(PROTOCOLNO, value.get("protocolNo").toString().trim());
			}
		}
		map.put(STATE, ScfBasConstant.STATE_VALID); // 监管协议状态
		// fourWareLoanQryVO.setFlag_Q(SCFConstants.QUERY_TYPE_SELF);//客户经理隶属范围
		// TODO权限
		bCntBuyInfoDAO.queryBCntBuyInfoListByPage(map, page);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.cnt.service.IBCntBuyInfoService#getBuyContAdd(int,
	 * int, com.huateng.scf.bas.cnt.model.BCntBuyInfo, java.util.List)
	 */
	@Override
	public Page getBuyContAdd(int pageNo, int pageSize, BCntBuyInfo bCntBuyInfo, List list) throws ScubeBizException {
		// TODO Auto-generated method stub
		BCntBuyInfoExample example = new BCntBuyInfoExample();
		Criteria cri = example.createCriteria();
		List<String> tradeContcodeList = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, String> map = (Map<String, String>) list.get(i);
				String tradeContcode = map.get("tradeContcode").toString();
				tradeContcodeList.add(tradeContcode);
			}
		}
		if (bCntBuyInfo != null) {
			if (StringUtil.isStrNotEmpty(bCntBuyInfo.getSupplyChainPdId())) { // 产品ID
				cri.andSupplyChainPdIdEqualTo(bCntBuyInfo.getSupplyChainPdId());
			}
			if (StringUtil.isStrNotEmpty(bCntBuyInfo.getProtocolNo())) {
				cri.andProtocolNoEqualTo(bCntBuyInfo.getProtocolNo());
			}
			/*
			 * if(StringUtil.isStrNotEmpty(bCntBuyInfo.getStatus())){
			 * cri.andStatusEqualTo(bCntBuyInfo.getStatus()); }
			 */
			if (StringUtil.isStrNotEmpty(bCntBuyInfo.getTradeContno())) { // 产品ID
				cri.andTradeContnoEqualTo(bCntBuyInfo.getTradeContno());
			}
		}
		if (tradeContcodeList != null && tradeContcodeList.size() > 0) {
			cri.andTradeContcodeNotIn(tradeContcodeList);
		}
		example.setOrderByClause("CRT_TIME DESC");

		int total = bCntBuyInfoDAO.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);

		List<com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo> buyinfolist = bCntBuyInfoDAO.selectByPage(example, p);
		List<ApplyBuyContVO> listVO = new ArrayList<ApplyBuyContVO>();
		for (int i = 0; i < buyinfolist.size(); i++) {
			com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo buyInfo = buyinfolist.get(i);
			ApplyBuyContVO VO = new ApplyBuyContVO();
			BeanUtils.copyProperties(buyInfo, VO);

			VO.setContAmt(buyInfo.getAmt() == null ? BigDecimal.ZERO : buyInfo.getAmt());
			VO.setAccuLoanAmt(buyInfo.getTotAmt() == null ? BigDecimal.ZERO : buyInfo.getTotAmt());
			listVO.add(VO);
		}
		p.setRecords(listVO);
		log.info("p.toString()=" + p.toString());
		return p;
	}

	/****
	 * 获取购销合同押品信息表下的信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param 购销合同号
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getDeliveryNotifyBuycontInfo(int pageNo, int pageSize, String tradeContno) throws ScubeBizException {
		if (tradeContno == null || "".equals(tradeContno)) {
			return null;
		}
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tradeContno", tradeContno);
		bCntBuyInfoDAO.getDeliveryNotifyBuycontInfo(map, page);
		return page;
	}

	/**
	 * 根据协议号查询购销合同
	 * @param protocolNo
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public List<BCntBuyInfo> findByProtocolNo(String protocolNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		BCntBuyInfoExample example = new BCntBuyInfoExample();
		Criteria cri = example.createCriteria();
		if(StringUtil.isStrNotEmpty(protocolNo)){
			cri.andProtocolNoEqualTo(protocolNo);
		}
		example.setOrderByClause("TRADE_CONTNO DESC");
		List<com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo> buyinfolist = bCntBuyInfoDAO.selectByExample(example);
		List<BCntBuyInfo> list = new ArrayList<BCntBuyInfo>();
		if(buyinfolist!=null&&buyinfolist.size()>0){
			for(com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo info:buyinfolist){
				BCntBuyInfo buyInfo = new BCntBuyInfo();
				BeanUtils.copyProperties(info, buyInfo);
				list.add(buyInfo);
			}
		}
		return list;
	}

}
