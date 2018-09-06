package com.huateng.scf.bas.cnt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.ext.ExtIBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.ICustomerService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.mrn.vo.ProtocolQryVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BCntMprotBaseInfoServiceImpl")
public class BCntMprotBaseInfoServiceImpl implements IBCntMprotBaseInfoService {
	Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO iBCntMprotBaseInfoDAO;

	@Resource(name = "CustomerServiceImpl")
	ICustomerService customerservice;

	@Resource(name = "ExtBCntMprotBaseInfoDAO")
	ExtIBCntMprotBaseInfoDAO extibcntmprotbaseinfodao;

	// 业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	
	private static final String PROTOCOLNO = "protocolNo";
	private static final String PROTOCOLTYPE = "protocolType";
	private static final String ROLEMONI = "roleMoni";

	@Transactional
	@Override
	public BCntMprotBaseInfo addBCntMprotBaseInfo(BCntMprotBaseInfo bCntMprotBaseInfo) throws ScubeBizException {
		com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo bCntMprotBaseInfoDal = new com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo();
		try {
			BeanUtils.copyProperties(bCntMprotBaseInfo, bCntMprotBaseInfoDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		iBCntMprotBaseInfoDAO.insert(bCntMprotBaseInfoDal);
		return bCntMprotBaseInfo;
	}

	@Transactional
	@Override
	public int updateBCntMprotBaseInfo(BCntMprotBaseInfo bCntMprotBaseInfo) throws ScubeBizException {
		com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo bCntMprotBaseInfoDal = new com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo();
		try {
			BeanUtils.copyProperties(bCntMprotBaseInfo, bCntMprotBaseInfoDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		int i = 0;
		try {
			i = iBCntMprotBaseInfoDAO.updateByPrimaryKey(bCntMprotBaseInfoDal);
		} catch (Exception e) {
			log.error("更新购销合同信息失败！");
			throw new ScubeBizException("更新购销合同信息失败！", e);
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteBCntMprotBaseInfo(String key) throws ScubeBizException {
		int i = 0;

		try {
			i = iBCntMprotBaseInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.error("删除购销合同信息失败！");
			throw new ScubeBizException("删除购销合同信息失败！", e);
		}
		return i;
	}

	@Override
	public BCntMprotBaseInfo findBCntMprotBaseInfoByKey(String key) throws ScubeBizException {
		BCntMprotBaseInfo bCntMprotBaseInfo = null;
		com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo bCntMprotBaseInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo();
		bCntMprotBaseInfodal = iBCntMprotBaseInfoDAO.selectByPrimaryKey(key);
		if(bCntMprotBaseInfodal!=null){
			bCntMprotBaseInfo =  new BCntMprotBaseInfo();
			BeanUtils.copyProperties(bCntMprotBaseInfodal, bCntMprotBaseInfo);
		}
		return bCntMprotBaseInfo;
	}

	@Override
	public Page findBCntMprotBaseInfoByPage(int pageNo, int pageSize, BCntMprotBaseInfo bCntMprotBaseInfo) throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);

		if (bCntMprotBaseInfo != null) {
			BCntMprotBaseInfoExample example = new BCntMprotBaseInfoExample();

			com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample.Criteria criteria = example.createCriteria();

			if (bCntMprotBaseInfo.getArrivedManageMode() != null) {
				criteria.andArrivedManageModeLike("%" + bCntMprotBaseInfo.getArrivedManageMode() + "%");
			}

			if (bCntMprotBaseInfo.getBrcode() != null) {
				criteria.andBrcodeEqualTo(bCntMprotBaseInfo.getBrcode());
			}
			if (bCntMprotBaseInfo.getCircleLoanFlag() != null) {
				criteria.andCircleLoanFlagEqualTo(bCntMprotBaseInfo.getCircleLoanFlag());
			}
			if (bCntMprotBaseInfo.getCooperationBrcode() != null) {
				criteria.andCooperationBrcodeEqualTo(bCntMprotBaseInfo.getCooperationBrcode());
			}
			if (bCntMprotBaseInfo.getCurcd() != null) {
				criteria.andCurcdEqualTo(bCntMprotBaseInfo.getCurcd());
			}
			if (bCntMprotBaseInfo.getDeliveryMode() != null) {
				criteria.andDeliveryModeEqualTo(bCntMprotBaseInfo.getDeliveryMode());
			}
			if (bCntMprotBaseInfo.getEndDate() != null) {
				criteria.andEndDateEqualTo(bCntMprotBaseInfo.getEndDate());
			}
			if (bCntMprotBaseInfo.getLoanPercent() != null) {
				criteria.andLoanPercentEqualTo(bCntMprotBaseInfo.getLoanPercent());
			}
			if (bCntMprotBaseInfo.getLowPriceNew() != null) {
				criteria.andLowPriceNewEqualTo(bCntMprotBaseInfo.getLowPriceNew());
			}
			if (bCntMprotBaseInfo.getMoniType() != null) {
				criteria.andMoniTypeEqualTo(bCntMprotBaseInfo.getMoniType());
			}
			if (bCntMprotBaseInfo.getOtherDes() != null) {
				criteria.andLowPriceNewEqualTo(bCntMprotBaseInfo.getLowPriceNew());
			}

			if (bCntMprotBaseInfo.getOtherDes() != null) {
				criteria.andOtherDesLike("%" + bCntMprotBaseInfo.getOtherDes() + "%");
			}

			if (bCntMprotBaseInfo.getOtherprotocolNo() != null) {
				criteria.andOtherprotocolNoEqualTo(bCntMprotBaseInfo.getOtherprotocolNo());
			}

			if (bCntMprotBaseInfo.getPriceDropRate() != null) {
				criteria.andPriceDropRateEqualTo(bCntMprotBaseInfo.getPriceDropRate());
			}
			if (bCntMprotBaseInfo.getProductId() != null) {
				criteria.andProductIdEqualTo(bCntMprotBaseInfo.getProductId());
			}
			if (bCntMprotBaseInfo.getProtAmt() != null) {
				criteria.andProtAmtEqualTo(bCntMprotBaseInfo.getProtAmt());
			}
			if (bCntMprotBaseInfo.getProtocolCode() != null) {
				criteria.andProtocolCodeEqualTo(bCntMprotBaseInfo.getProtocolCode());
			}

			if (bCntMprotBaseInfo.getProtocolNo() != null) {
				criteria.andProtocolNoEqualTo(bCntMprotBaseInfo.getProtocolNo());
			}
			if (bCntMprotBaseInfo.getProtocolType() != null) {
				criteria.andProtocolTypeEqualTo(bCntMprotBaseInfo.getProtocolType());
			}

			if (bCntMprotBaseInfo.getSellOffFlag() != null) {
				criteria.andSellOffFlagEqualTo(bCntMprotBaseInfo.getSellOffFlag());
			}

			if (bCntMprotBaseInfo.getSignDate() != null) {
				criteria.andSignDateEqualTo(bCntMprotBaseInfo.getSignDate());
			}

			if (bCntMprotBaseInfo.getSignIn() != null) {
				criteria.andSignInLike("%" + bCntMprotBaseInfo.getSignIn() + "%");
			}

			if (bCntMprotBaseInfo.getStartDate() != null) {
				criteria.andStartDateEqualTo(bCntMprotBaseInfo.getStartDate());
			}

			if (bCntMprotBaseInfo.getState() != null) {
				criteria.andStateEqualTo(bCntMprotBaseInfo.getState());
			}

			if (bCntMprotBaseInfo.getStatus() != null) {
				criteria.andStatusEqualTo(bCntMprotBaseInfo.getStatus());
			}

			if (bCntMprotBaseInfo.getTenor() != null) {
				criteria.andTenorEqualTo(bCntMprotBaseInfo.getTenor());
			}

			if (bCntMprotBaseInfo.getTripleProtocolType() != null) {
				criteria.andTripleProtocolTypeEqualTo(bCntMprotBaseInfo.getTripleProtocolType());
			}

			if (bCntMprotBaseInfo.getUpdateDate() != null) {
				criteria.andUpdateDateEqualTo(bCntMprotBaseInfo.getUpdateDate());
			}

			if (bCntMprotBaseInfo.getUpdateState() != null) {
				criteria.andUpdateStateEqualTo(bCntMprotBaseInfo.getUpdateState());
			}

			iBCntMprotBaseInfoDAO.selectByPage(example, p);

		}

		return p;
	}

	public Page selectBCntMprotBaseInfoByPage(int pageNo, int pageSize, BCntMprotBaseInfo bCntMprotBaseInfo) throws ScubeBizException {
		return findBCntMprotBaseInfoByPage(pageNo, pageSize, bCntMprotBaseInfo);
	}

	/*
	 * @Override public List<BCntMprotBaseInfo>
	 * selectBCntMprotBaseInfoByExample(BCntMprotBaseInfoExample example) throws
	 * ScubeBizException { List<BCntMprotBaseInfo> list = null;
	 * 
	 * try { if (example != null) { list =
	 * iBCntMprotBaseInfoDAO.selectByExample(example); } } catch (Exception e) {
	 * log.error("查询购销合同信息失败！"); throw new ScubeBizException("查询购销合同信息失败！", e);
	 * }
	 * 
	 * return list; }
	 */

	/**
	 * 根据关联协议查询监管协议
	 */
	@Override
	public List<BCntMprotBaseInfo> getProtocolByOtherProtocol(String otherProtocolNo, String protocolType) throws ScubeBizException {
		// TODO Auto-generated method stub
		BCntMprotBaseInfoExample example = new BCntMprotBaseInfoExample();
		BCntMprotBaseInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isStrNotEmpty(otherProtocolNo)) {
			criteria.andOtherprotocolNoEqualTo(otherProtocolNo);
		}
		if (StringUtil.isStrNotEmpty(protocolType)) {
			criteria.andProtocolTypeEqualTo(protocolType);
		}
		criteria.andStateEqualTo(ScfBasConstant.STATE_VALID);
		List<com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo> listdal = iBCntMprotBaseInfoDAO.selectByExample(example);
		List<BCntMprotBaseInfo> list = new ArrayList<BCntMprotBaseInfo>();
		BCntMprotBaseInfo bCntMprotBaseInfo = new BCntMprotBaseInfo();
		if (listdal != null && listdal.size() > 0) {
			for (com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo info : listdal) {
				BeanUtils.copyProperties(info, bCntMprotBaseInfo);
				list.add(bCntMprotBaseInfo);
			}
		}

		return list;
	}
	
	/**
	 * 根据监管协议号查询监管公司客户号
	 */
	@Transactional
	@Override
	public String getMoniCustcdByMoniProtocolNo(String protocolNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		String moniCustcd = "";
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(StringUtil.isStrEmpty(protocolNo)){
			log.error("监管协议缺失，无法查询监管公司信息  ！");
			throw new ScubeBizException("监管协议缺失，无法查询监管公司信息！");
		}
		omap.put(PROTOCOLNO, protocolNo);
		omap.put(PROTOCOLTYPE, ScfBasConstant.MUTI_PROTOCOL_MONI);
		omap.put(ROLEMONI, ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		List list = extibcntmprotbaseinfodao.getMoniCustcdByMoniProtocolNo(omap);
		if(list!=null&&list.size()>0){
			HashMap map = (HashMap) list.get(0);
			moniCustcd = map.get("custcd")==null?"":map.get("custcd").toString();
			
		}

		return moniCustcd;
	}

	/**
	 *
	 * @Description: 监管协议号下拉
	 * @author mengjiajia
	 * @Created 2012-7-27下午3:48:58
	 * @param protocolQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getMutiProtDropDownInfo(ProtocolQryVO protocolQryVO) throws ScubeBizException {

		HashMap<String, Object> omap = new HashMap<String, Object>();
		List<String> protocolType = new ArrayList<String>();
		protocolType.add(ScfBasConstant.MUTI_PROTOCOL_MONI);
		protocolType.add(ScfBasConstant.MUTI_PROTOCOL_PLDEGE);
		omap.put("protocolType", protocolType);
		omap.put("role", ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		omap.put("state", ScfBasConstant.STATE_VALID);

		/* add by kangbyron 20130425 增加权限控制 */
		// hql.append(CustomerService.getInstance().getCustcdsQueryCondition("mppi.custcd",
		// ScfBasConstant.QUERY_TYPE_MAG_ALL,
		// ContextHolder.getUserInfo().getTlrNo()));
		List<String> custcd = customerservice.getCustcdsQueryCondition("mppi.custcd", ScfBasConstant.QUERY_TYPE_MAG_ALL,
				ContextHolder.getUserInfo().getTlrNo());
		if (custcd.size() > 0) {
			omap.put("custcd", custcd);
		}
		if (!StringUtil.isEmpty(protocolQryVO.getProtocolCode())) {
			omap.put("protocolCode", protocolQryVO.getProtocolCode());
		}
		// 增加产品类型和监管模式
		if (!StringUtil.isEmpty(protocolQryVO.getProductId_Q())) {
			omap.put("productId", protocolQryVO.getProductId_Q());
		}
		if (!StringUtil.isEmpty(protocolQryVO.getMoniType_Q())) {
			omap.put("moniType", protocolQryVO.getMoniType_Q());
		}
		if (!StringUtil.isEmpty(protocolQryVO.getCustcd())) {
			omap.put("custcd2", protocolQryVO.getCustcd());
			omap.put("role2", ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		}
		Page page = new Page(protocolQryVO.getPageSize(), protocolQryVO.getPageIndex(), 0);
		page.setRecords(extibcntmprotbaseinfodao.getMutiProtDropDownInfo(omap, page));
		page.setTotalRecord(extibcntmprotbaseinfodao.countMutiProtDropDownInfo(omap));
		return page;
	}

	/**
	 * 通过从合同号或者申请编号、协议类型获取协议号
	 * 
	 * @param slaveContno
	 * @param appno
	 * @param protocolType
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月19日上午10:32:14
	 */
	@Override
	public String getMonitorProtocolNoBySlaveContnoAppnoPt(String slaveContno, String appno, String protocolType) throws ScubeBizException {
		String monitorProtocolNo = ""; // 协议号

		// 若从合同号为空，通过申请编号去主申请表查
		if (StringUtil.isEmpty(slaveContno)) { // 从合同号
			if (!StringUtil.isEmpty(appno)) { // 申请编号
				BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
				slaveContno = tblAppliBaseInfo.getBusinessno();
			} else
				return "";
		}

		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("protocolType", protocolType);
		omap.put("slaveContno", slaveContno);
		omap.put("state", "1");
		omap.put("status", "1");
		List<com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo> list = extibcntmprotbaseinfodao.getMonitorProtocolNoBySlaveContnoAppnoPt(omap);
		if (list.size() > 0) {
			monitorProtocolNo = list.get(0).getProtocolNo();
		}
		return monitorProtocolNo;
	}
	
	/**
	 * 四方保兑：根据经销商核心厂商客户查询抵质押合同
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午4:05:05
	 */
	@Override
	public Page getContSlaveByCustcdAndCore(ContSlaveQryVO contSlaveQryVO) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("role1", ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		omap.put("role2", ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		if(!StringUtil.isEmpty(contSlaveQryVO.getCustcd()))
		{
			omap.put("custcd1", contSlaveQryVO.getCustcd());//经销商过滤
		}
		if(!StringUtil.isEmpty(contSlaveQryVO.getCoreCustcd_Q()))
		{
			omap.put("custcd2", contSlaveQryVO.getCoreCustcd_Q());//核心厂商过滤
		}
		if(!StringUtil.isEmpty(contSlaveQryVO.getProtocolNo()))
		{
			omap.put("otherprotocolNo", contSlaveQryVO.getProtocolNo());//四方协议
		}
		if(!StringUtil.isEmpty(contSlaveQryVO.getSlaveContCode()))
		{
			omap.put("slaveContcode", contSlaveQryVO.getSlaveContCode());//抵质押合同
		}

		int total = extibcntmprotbaseinfodao.countContSlaveByCustcdAndCore(omap);
		Page page = new Page(contSlaveQryVO.getPageSize(), contSlaveQryVO.getPageIndex(), total);
		page.setRecords(extibcntmprotbaseinfodao.getContSlaveByCustcdAndCore(omap,page));
		List<BCrrGntyCon> resultList = new ArrayList<BCrrGntyCon>();
		BCrrGntyCon tblContSlaveInfo = null;
		for(int i=0;i<page.getRecords().size();i++) 
		{
			tblContSlaveInfo = (BCrrGntyCon) page.getRecords().get(i);
			// 源对象取值
			resultList.add(tblContSlaveInfo);
		}
		page.setRecords(resultList);
		return page;
	}

}
