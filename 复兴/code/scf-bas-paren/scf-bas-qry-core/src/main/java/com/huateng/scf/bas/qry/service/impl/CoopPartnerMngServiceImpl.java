/**
 * 
 */
package com.huateng.scf.bas.qry.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.qry.model.CooperPartnerInfo;
import com.huateng.scf.bas.qry.model.CustAnalysisInfo;
import com.huateng.scf.bas.qry.service.ICoopPartnerMngService;
import com.huateng.scf.ods.dao.IOCooperPartnerDAO;
import com.huateng.scf.ods.dao.IOCrmInfoAnalysisDAO;
import com.huateng.scf.ods.dao.ext.ExtOdsDAO;
import com.huateng.scf.ods.dao.model.OCooperPartner;
import com.huateng.scf.ods.dao.model.OCooperPartnerExample;
import com.huateng.scf.ods.dao.model.OCrmInfoAnalysis;
import com.huateng.scf.ods.dao.model.OCrmInfoAnalysisExample;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年7月7日上午9:40:25
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年7月7日上午9:40:25              新增
 *
 * </pre>
 */
@ScubeService
@Service(ICoopPartnerMngService.BEAN_ID)
public class CoopPartnerMngServiceImpl implements ICoopPartnerMngService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "OCooperPartnerDAO")
	IOCooperPartnerDAO oCooperPartnerDAO;
	
	@Resource(name = "ExtOdsDAO")
	ExtOdsDAO extOdsDAO;

	@Resource(name = "OCrmInfoAnalysisDAO") //客户信息分析
	IOCrmInfoAnalysisDAO oCrmInfoAnalysisDAO;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.qry.service.ICoopPartnerMngService#
	 * addCooperPartnerInfo(com.huateng.scf.bas.qry.model.CooperPartnerInfo)
	 */
	@Override
	public void addCooperPartnerInfo(CooperPartnerInfo cooperPartnerInfo) throws ScubeBizException {
		try {
			if (cooperPartnerInfo == null) {
				throw new ScubeBizException("新增合作伙伴失败,前台所传数据无效！");
			}
			cooperPartnerInfo.setId(UUIDGeneratorUtil.generate());
//			UserInfo user = ContextHolder.getUserInfo();
//			BctlVO BctlVO = ContextHolder.getOrgInfo();
//			String brcode = BctlVO.getBrNo();
			cooperPartnerInfo.setCustcd(cooperPartnerInfo.getCustcd());
			OCooperPartner cooperPartnerInfodal = new OCooperPartner();
			BeanUtils.copyProperties(cooperPartnerInfo, cooperPartnerInfodal);
			oCooperPartnerDAO.insert(cooperPartnerInfodal);
		} catch (Exception e) {
			log.error("新增合作伙伴失败！");
			throw new ScubeBizException("新增合作伙伴失败！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.qry.service.ICoopPartnerMngService#
	 * updateCooperPartnerInfo(com.huateng.scf.bas.qry.model.CooperPartnerInfo)
	 */
	@Override
	public void updateCooperPartnerInfo(CooperPartnerInfo cooperPartnerInfo) throws ScubeBizException {
		try {
			if (cooperPartnerInfo == null) {
				throw new ScubeBizException("修改合作伙伴失败,前台所传数据无效！");
			}
//			UserInfo user = ContextHolder.getUserInfo();
//			BctlVO BctlVO = ContextHolder.getOrgInfo();
//			String brcode = BctlVO.getBrNo();
			// cooperPartnerInfo.setLastUpdTlrcd(user.getTlrNo());
			// cooperPartnerInfo.setLastUpdTime(new Date());
			// cooperPartnerInfo.setLastUpdBrcode(brcode);
			OCooperPartner cooperPartnerInfodal = new OCooperPartner();
			BeanUtils.copyProperties(cooperPartnerInfo, cooperPartnerInfodal);
			oCooperPartnerDAO.updateByPrimaryKeySelective(cooperPartnerInfodal);
		} catch (Exception e) {
			log.error("修改合作伙伴失败！");
			throw new ScubeBizException("修改合作伙伴失败！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.qry.service.ICoopPartnerMngService#
	 * deleteCooperPartnerInfo(java.lang.String)
	 */
	@Override
	public void deleteCooperPartnerInfo(String key) throws ScubeBizException {
		try {
			if (StringUtils.isEmpty(key)) {
				throw new ScubeBizException("删除合作伙伴失败,前台所传数据无效！");
			}
			oCooperPartnerDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.error("删除合作伙伴失败！");
			throw new ScubeBizException("删除合作伙伴失败！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.qry.service.ICoopPartnerMngService#
	 * findCooperPartnerInfoByPage(int, int,
	 * com.huateng.scf.bas.qry.model.CooperPartnerInfo)
	 */
	@Override
	public Page findCooperPartnerInfoByPage(int pageNo, int pageSize, CooperPartnerInfo cooperPartnerInfo)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		try {
			List<CooperPartnerInfo> list = new ArrayList<CooperPartnerInfo>();
			if (cooperPartnerInfo != null) {
				OCooperPartnerExample example = new OCooperPartnerExample();
				OCooperPartnerExample.Criteria creteria = example.createCriteria();
				if (StringUtils.isNotEmpty(cooperPartnerInfo.getCustcd())) {
					creteria.andCustcdEqualTo(cooperPartnerInfo.getCustcd());
				}
				if (StringUtils.isNotEmpty(cooperPartnerInfo.getId())) {
					creteria.andIdEqualTo(cooperPartnerInfo.getId());
				}
				// if (StringUtils.isNotEmpty(cooperPartnerInfo.getTagCode())) {
				// creteria.andTagCodeEqualTo(cooperPartnerInfo.getTagCode());
				// }
				// 分页查询
				//example.setOrderByClause(" LAST_UPD_TIME desc");
				List<OCooperPartner> listdal = oCooperPartnerDAO.selectByPage(example, page);
				for (OCooperPartner info : listdal) {
					CooperPartnerInfo cooperInfo = new CooperPartnerInfo();
					BeanUtils.copyProperties(info, cooperInfo);
					list.add(cooperInfo);
				}
			}
			page.setRecords(list);
		} catch (Exception e) {
			log.error("条件分页查询客户信息失败！");
			throw new ScubeBizException("条件分页查询客户信息失败！", e);
		}
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.qry.service.ICoopPartnerMngService#
	 * findCooperPartnerInfoByKey(java.lang.String)
	 */
	@Override
	public CooperPartnerInfo findCooperPartnerInfoByKey(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		return null;
	}
	// 是否存在客户及合作伙伴的同种类型数据
	public Boolean findCoopInfoIsExist(CooperPartnerInfo cooperPartnerInfo) {
		Boolean flag = false;
		try {
			OCooperPartnerExample example = new OCooperPartnerExample();
			OCooperPartnerExample.Criteria creteria = example.createCriteria();
			String custcd = cooperPartnerInfo.getCustcd();
			String coopCustcd = cooperPartnerInfo.getCoopCustcd();
			String type = cooperPartnerInfo.getType();
			String belongYear = cooperPartnerInfo.getBelongYear();
			String belongMonth = cooperPartnerInfo.getBelongMonth();
			if (StringUtils.isEmpty(custcd) || StringUtils.isEmpty(coopCustcd) || StringUtils.isEmpty(type)) {
				throw new ScubeBizException("参数错误！");
			}
			if (StringUtils.isNotEmpty(custcd)) {
				creteria.andCustcdEqualTo(custcd);
			}
			if (StringUtils.isNotEmpty(coopCustcd)) {
				creteria.andCoopCustcdEqualTo(coopCustcd);
			}
			if (StringUtils.isNotEmpty(type)) {
				creteria.andTypeEqualTo(type);
			}
//			if (StringUtils.isNotEmpty(belongYear)) {
//				creteria.andBelongYearEqualTo(belongYear);
//			}
//			if (StringUtils.isNotEmpty(belongMonth)) {
//				creteria.andBelongMonthEqualTo(belongMonth);
//			}
			List<OCooperPartner> list = oCooperPartnerDAO.selectByExample(example);
			if (null != list && list.size() > 0) {
				flag = true;
			}
			return flag;
		} catch (Exception e) {
			log.error("查询客户合作伙伴信息失败！");
			throw new ScubeBizException("查询客户合作伙伴信息失败！", e);
		}
	}
	/**
	 *  查询客户的合作类型及其合作伙伴
	 */
	@Override
	public Page findCoopTypeListByPage(int pageNo, int pageSize, CooperPartnerInfo cooperPartnerInfo)
			throws ScubeBizException {
		Map<String, Object> omap = new HashMap<String, Object>();
		if(cooperPartnerInfo!=null){
		
			if(StringUtil.isStrNotEmpty(cooperPartnerInfo.getCname())){
				omap.put("cname",cooperPartnerInfo.getCname());
			}
			if(StringUtil.isStrNotEmpty(cooperPartnerInfo.getType())){
				omap.put("type",cooperPartnerInfo.getType());
			}
		}
		int total = extOdsDAO.countqueryCoopTypeList(omap);
		Page page = new Page(pageSize, pageNo, total);
		
		page.setRecords(extOdsDAO.queryCoopTypeList(omap, page));
		page.setTotalRecord(total);
		return page;
	}
	/**
	 *  查询客户的合作类型及其合作伙伴的明细信息
	 */
	@Override
	public List<CooperPartnerInfo> findCoopTypeDtlList(CooperPartnerInfo cooperPartnerInfo)
			throws ScubeBizException {
	List<CooperPartnerInfo> list = new ArrayList<CooperPartnerInfo>();
	 if(cooperPartnerInfo!=null){
			Map<String, Object> omap = new HashMap<String, Object>();
			if(StringUtil.isStrNotEmpty(cooperPartnerInfo.getCustcd())){
				omap.put("custcd",cooperPartnerInfo.getCustcd());
			}
			if(StringUtil.isStrNotEmpty(cooperPartnerInfo.getType())){
				omap.put("type",cooperPartnerInfo.getType());
			}
			if(StringUtil.isStrNotEmpty(cooperPartnerInfo.getCoopCustcd())){
				omap.put("coopCustcd",cooperPartnerInfo.getCoopCustcd());
			}

			List<com.huateng.scf.ods.dao.model.CooperPartnerInfo> listR =extOdsDAO.queryCoopTypeDtlList(omap);
			if(null!=listR&&listR.size()>0){
				for(com.huateng.scf.ods.dao.model.CooperPartnerInfo info:listR){
					CooperPartnerInfo VO = new CooperPartnerInfo();
					BeanUtils.copyProperties(info, VO);
					list.add(VO);
				}
			}
		}
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.ICoopPartnerMngService#addCustRelCoop(com.huateng.scf.bas.qry.model.CooperPartnerInfo, java.util.List)
	 */
	@Override
	public void addCustRelCoop(CooperPartnerInfo cooperPartnerInfo, List<CooperPartnerInfo> list)
			throws ScubeBizException {
		// TODO Auto-generated method stub
		Boolean flag = findCoopInfoIsExist(cooperPartnerInfo);

		if (flag) {
			throw new ScubeBizException("已存在客户及合作伙伴的同种类型的数据，不可再次关联！");
		}
		if(null!=list&&list.size()>0){
			for(CooperPartnerInfo info:list){
				info.setCustcd(cooperPartnerInfo.getCustcd());
				info.setCoopCustcd(cooperPartnerInfo.getCoopCustcd());
				info.setType(cooperPartnerInfo.getType());
				this.addCooperPartnerInfo(info);
			}
			
		}
	}

	/**
	 * 删除客户关联合作伙伴的相关信息
	 */
	@Transactional
	@Override
	public void deleteCustRelCoop(CooperPartnerInfo cooperPartnerInfo) throws ScubeBizException {
		// TODO Auto-generated method stub
		OCooperPartnerExample example = new OCooperPartnerExample();
		OCooperPartnerExample.Criteria creteria = example.createCriteria();
		//oCooperPartnerDAO.deleteByExample(example);
		if(cooperPartnerInfo!=null){
			String custcd = cooperPartnerInfo.getCustcd();
			String coopCustcd = cooperPartnerInfo.getCoopCustcd();
			String type = cooperPartnerInfo.getType();
			if (StringUtils.isNotEmpty(custcd)) {
				creteria.andCustcdEqualTo(custcd);
			}
			if (StringUtils.isNotEmpty(coopCustcd)) {
				creteria.andCoopCustcdEqualTo(coopCustcd);
			}
			if (StringUtils.isNotEmpty(type)) {
				creteria.andTypeEqualTo(type);
			}
			try {
				oCooperPartnerDAO.deleteByExample(example);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("除关联异常！"+e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException("删除关联异常!"+e);
			}
		}
		
		
	}
	
	/**
	 * 查询客户信息分析
	 */
	@Override
	public Page findCrmAnalyListByPage(int pageNo, int pageSize,CustAnalysisInfo custAnalysisInfo)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		try {
			List<CustAnalysisInfo> list = new ArrayList<CustAnalysisInfo>();
			if (custAnalysisInfo != null) {
				OCrmInfoAnalysisExample example = new OCrmInfoAnalysisExample();
				OCrmInfoAnalysisExample.Criteria creteria = example.createCriteria();
				if (StringUtils.isNotEmpty(custAnalysisInfo.getCustcd())) {
					creteria.andCustcdEqualTo(custAnalysisInfo.getCustcd());
				}
				if (StringUtils.isNotEmpty(custAnalysisInfo.getCname())) {
					creteria.andCnameLike("%"+custAnalysisInfo.getCname()+"%");
				}
				
				// if (StringUtils.isNotEmpty(cooperPartnerInfo.getTagCode())) {
				// creteria.andTagCodeEqualTo(cooperPartnerInfo.getTagCode());
				// }
				// 分页查询
				example.setOrderByClause(" CUSTCD desc");
				List<OCrmInfoAnalysis> listdal = oCrmInfoAnalysisDAO.selectByPage(example, page);
				for (OCrmInfoAnalysis info : listdal) {
					CustAnalysisInfo cooperInfo = new CustAnalysisInfo();
					BeanUtils.copyProperties(info, cooperInfo);
					list.add(cooperInfo);
				}
			}
			page.setRecords(list);
		} catch (Exception e) {
			log.error("条件分页查询客户信息失败！");
			throw new ScubeBizException("条件分页查询客户信息失败！", e);
		}
		return page;
	}

	/**
	 * 客户关联客户信息分析
	 * @param custAnalysisInfo
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void addCustRelCrmAnaly(CustAnalysisInfo custAnalysisInfo) throws ScubeBizException {
		// TODO Auto-generated method stub
		OCrmInfoAnalysis dalinfo = new OCrmInfoAnalysis();
		Boolean flag = findCrmAnalyInfoIsExist(custAnalysisInfo);

		if (flag) {
			throw new ScubeBizException("该客户的客户分析信息已存在，不可再次关联！");
		}
		if(null!=custAnalysisInfo){
			BeanUtils.copyProperties(custAnalysisInfo, dalinfo);
			dalinfo.setId(UUIDGeneratorUtil.generate());
			try {
				oCrmInfoAnalysisDAO.insert(dalinfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("关联客户信息分析信息失败！");
				throw new ScubeBizException("关联客户信息分析信息失败！", e);
			}
		}
		
		
	}
	
	// 是否存在客户的客户分析信息
	public Boolean findCrmAnalyInfoIsExist(CustAnalysisInfo info) {
		Boolean flag = false;
		try {
			OCrmInfoAnalysisExample example = new OCrmInfoAnalysisExample();
			OCrmInfoAnalysisExample.Criteria creteria = example.createCriteria();
			String custcd = info.getCustcd();
		
			if (StringUtils.isEmpty(custcd)) {
				throw new ScubeBizException("参数丢失！");
			}
			if (StringUtils.isNotEmpty(custcd)) {
				creteria.andCustcdEqualTo(custcd);
			}
			
			List<OCrmInfoAnalysis> list = oCrmInfoAnalysisDAO.selectByExample(example);
			if (null != list && list.size() > 0) {
				flag = true;
			}
			return flag;
		} catch (Exception e) {
			log.error("查询客户合作伙伴信息失败！");
			throw new ScubeBizException("查询客户合作伙伴信息失败！", e);
		}
	}

	/**
	 * 删除客户关联客户分析信息
	 * @param custAnalysisInfo
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void deleteCustRelCrmAnaly(CustAnalysisInfo custAnalysisInfo) throws ScubeBizException {
		// TODO Auto-generated method stub
		OCrmInfoAnalysisExample example = new OCrmInfoAnalysisExample();
		OCrmInfoAnalysisExample.Criteria creteria = example.createCriteria();
		//oCooperPartnerDAO.deleteByExample(example);
		if(custAnalysisInfo!=null){
			String custcd = custAnalysisInfo.getCustcd();
			
			if (StringUtils.isNotEmpty(custcd)) {
				creteria.andCustcdEqualTo(custcd);
			}
			try {
				oCrmInfoAnalysisDAO.deleteByExample(example);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("除关联异常！"+e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException("删除关联异常!"+e);
			}
		}
	}
}

