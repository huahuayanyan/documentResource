/**
 * 
 */
package com.huateng.scf.bas.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.data.dto.BdDataDictDto;
import com.huateng.data.dto.DataItem;
import com.huateng.data.model.BdDataDictionary;
import com.huateng.data.model.BdDataDictionaryExample;
import com.huateng.data.service.BdDataDictService;
import com.huateng.data.util.BDDataUtil;
import com.huateng.scf.bas.acc.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.service.IBAccAccountInfoService;
import com.huateng.scf.bas.brp.model.BBrpIndustryTypes;
import com.huateng.scf.bas.brp.service.IBBrpIndustryTypesService;
import com.huateng.scf.bas.cnt.dao.IBCntDebtExtInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.constant.BCrmBaseConstants;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample.Criteria;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmBaseInfoAndEntInfo;
import com.huateng.scf.bas.crm.model.BCrmBrInfo;
import com.huateng.scf.bas.crm.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.service.IBCrmAnalInfoService;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crm.service.IBCrmEntInfoService;
import com.huateng.scf.bas.crm.service.IBCrmMoniEntInfoService;
import com.huateng.scf.bas.crm.service.IBCrmUpanddownRelService;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConExample;
import com.huateng.scf.bas.sys.model.BSysRegion;
import com.huateng.scf.bas.sys.service.IBSysRegionService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月1日下午4:47:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年11月1日下午4:47:51	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCrmBaseInfoServiceImpl")
public class BCrmBaseInfoServiceImpl implements IBCrmBaseInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "bdDataDictService")
	BdDataDictService bdDataDictService;
	@Resource(name = "orgService")
	OrgService orgService;
	@Resource(name = "userService")
	UserService userService;
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;
	@Resource(name = "BCrmEntInfoServiceImpl")
	IBCrmEntInfoService iBCrmEntInfoService;
	@Resource(name = "IBAccAccountInfoServiceImpl")
	IBAccAccountInfoService bAccAccountInfoService;
	@Resource(name = "BBrpIndustryTypesServiceImpl")
	IBBrpIndustryTypesService bBrpIndustryTypesService;
	@Resource(name = "IBSysRegionServiceImpl")
	IBSysRegionService bSysRegionService;
	@Resource(name = "BCntMprotPartInfoDAO")
	IBCntMprotPartInfoDAO iBCntMprotPartInfoDAO;
	// 预付类（担保提货）
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;
	@Resource(name = "BCntDebtExtInfoDAO")
	IBCntDebtExtInfoDAO iBCntDebtExtInfoDAO;
	@Autowired
	BDDataUtil bDDataUtil;
	@Resource(name = "IBCrmAnalInfoServiceImpl")
	IBCrmAnalInfoService bCrmAnalInfoService;
	@Resource(name = "IBCrmUpanddownRelServiceImpl")
	IBCrmUpanddownRelService bCrmUpanddownRelService;
	@Resource(name = "IBCrmMoniEntInfoServiceImpl")
	IBCrmMoniEntInfoService bCrmMoniEntInfoService;

	
	/**
	 * 
	 */
	public BCrmBaseInfo findBCrmBaseInfoObjectByKey(String custcd) throws ScubeBizException {
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		try {
			com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfoDal = iBCrmBaseInfoDAO.selectById(custcd);
			BeanUtils.copyProperties(bCrmBaseInfoDal, bCrmBaseInfo);
		} catch (Exception e) {
			throw new ScubeBizException("查询客户信息失败");
		}
		return bCrmBaseInfo;
	}

	// 页面经办机构转译
	@Override
	public BCrmBrInfo findBCrmBrInfo(BCrmBrInfo bCrmBrInfo) {
		BCrmBrInfo bCrmBrInfo2 = new BCrmBrInfo();
		BctlVO BctlVO = ContextHolder.getOrgInfo();
		UserInfo UserInfo = ContextHolder.getUserInfo();
		bCrmBrInfo2.setBrNo(BctlVO.getBrNo());
		bCrmBrInfo2.setBrName(BctlVO.getBrName());
		bCrmBrInfo2.setBrManagerNo(BctlVO.getBrManagerNo());
		bCrmBrInfo2.setBrManagerName(BctlVO.getBrManagerName());
		bCrmBrInfo2.setTxnDate(ScfBaseData.getScfGlobalInfoData().getTxnDate());
		bCrmBrInfo2.setSysDate(ScfBaseData.getScfGlobalInfoData().getSysDate());
		return bCrmBrInfo2;
	}

	// 客户基本信息新增或者保存前的前台数据国际行业和省份，直辖市地区信息校验
	@Override
	public BCrmBaseInfoAndEntInfo checkBeforeAddOrSaveBCrmBrInfo(BCrmBaseInfoAndEntInfo bCrmBaseInfoAndEntInfo) {
		String errorMessage = "";
		// 1.如果页面并没有输入国际行业代码和省份地区则直接赋值对应字段为空
		// 这里要考虑到在用户手动输入信息，没有用查选按钮选择过选项导致有对应的名称信息而没有对应的代码信息的情况
		if (bCrmBaseInfoAndEntInfo.getIndustryTypeName() == null || "".equals(bCrmBaseInfoAndEntInfo.getIndustryTypeName())) {
			bCrmBaseInfoAndEntInfo.setIndustryType(null);
		} else if (bCrmBaseInfoAndEntInfo.getIndustryType() == null) {
			throw new ScubeBizException("国际行业分类数据有误，请通过对应的查询按钮选择国际行业分类！");
		}
		if (bCrmBaseInfoAndEntInfo.getAreaName() == null || "".equals(bCrmBaseInfoAndEntInfo.getAreaName())) {
			bCrmBaseInfoAndEntInfo.setArea(null);
		} else if (bCrmBaseInfoAndEntInfo.getArea() == null) {
			throw new ScubeBizException("省份、直辖市、自治区信息有误，请通过对应的查询按钮选择地区信息！");
		}

		// 2.如果有对应值，就查询后台观察是否code与name一致对应
		// 国际行业代码校验
		if (bCrmBaseInfoAndEntInfo.getIndustryType() != null) {
			try {
				BBrpIndustryTypes bBrpIndustryTypes = new BBrpIndustryTypes();
				bBrpIndustryTypes.setIndustryCode(bCrmBaseInfoAndEntInfo.getIndustryType());
				BBrpIndustryTypes bBrpIndustryTypes2 = bBrpIndustryTypesService.findBBrpIndustryTypesByKey(bBrpIndustryTypes);
				if (bBrpIndustryTypes2 != null && !bBrpIndustryTypes2.getIndustryName().equals(bCrmBaseInfoAndEntInfo.getIndustryTypeName())) {
					errorMessage = "国际行业分类数据有误，请通过对应的查询按钮选择国际行业分类！";
					throw new ScubeBizException("国际行业代码数据不一致！");
				}
			} catch (Exception e) {
				if (!errorMessage.equals("")) {
					throw new ScubeBizException(errorMessage);
				} else {
					throw new ScubeBizException("前台国际行业代码检验失败！");
				}
			}
		}

		if (bCrmBaseInfoAndEntInfo.getArea() != null) {
			// 地区信息
			try {
				BSysRegion bSysRegion = new BSysRegion();
				bSysRegion.setRegionCode(bCrmBaseInfoAndEntInfo.getArea());
				List<BSysRegion> bSysRegionList = bSysRegionService.findBSysRegionByBCrm(bSysRegion);
				if (bSysRegionList != null && bSysRegionList.size() == 1) {
					if (!bSysRegionList.get(0).getRegionName().equals(bCrmBaseInfoAndEntInfo.getAreaName())) {
						errorMessage = "省份、直辖市、自治区信息有误，请通过对应的查询按钮选择地区信息！";
						throw new ScubeBizException("省份、直辖市、自治区信息不一致！");
					}
				}
			} catch (Exception e) {
				if (!errorMessage.equals("")) {
					throw new ScubeBizException(errorMessage);
				} else {
					throw new ScubeBizException("前台省份、直辖市、自治区信息检验失败！");
				}
			}
		}

		return bCrmBaseInfoAndEntInfo;
	}

	// 1.新增客户信息（默认客户状态为有效，客户类型为法人，同时新增企业信息）
	@Override
	@Transactional
	public BCrmBaseInfoAndEntInfo addBcrmBaseInfo(BCrmBaseInfoAndEntInfo bCrmBaseInfoAndEntInfo2) {
		// 1.校验前台所传数据
		if (bCrmBaseInfoAndEntInfo2 == null || "".equals(bCrmBaseInfoAndEntInfo2)) {
			throw new ScubeBizException("新增客户信息失败,前台所传数据无效！");
		}

		BCrmBaseInfoAndEntInfo bCrmBaseInfoAndEntInfo = this.checkBeforeAddOrSaveBCrmBrInfo(bCrmBaseInfoAndEntInfo2);

		// 2.查重(有客户号的才查)
		if (bCrmBaseInfoAndEntInfo.getCustcd() != null && !"".equals(bCrmBaseInfoAndEntInfo.getCustcd()))
			try {
				BCrmBaseInfo bCrmBaseInfo1 = new BCrmBaseInfo();
				bCrmBaseInfo1.setCustcd(bCrmBaseInfoAndEntInfo.getCustcd());
				BCrmBaseInfo bCrmBaseInfo3 = this.findBCrmBaseInfoByKey(bCrmBaseInfo1);
				if (bCrmBaseInfo3 != null && !"".equals(bCrmBaseInfo3)) {
					throw new ScubeBizException("新增客户信息失败,新增的数据已存在！");
				}
			} catch (Exception e) {
				throw new ScubeBizException("新增客户信息失败,查询重复数据失败！");
			}

		// 3.新增客户信息
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		BeanUtils.copyProperties(bCrmBaseInfoAndEntInfo, bCrmBaseInfo);
		ScfCommonUtil.setCommonField(bCrmBaseInfo);// 设置公共字段创建人，最后更新人，创建时间，最后更新时间，最后更新机构
		bCrmBaseInfoAndEntInfo.setTlrcd(bCrmBaseInfo.getTlrcd());
		bCrmBaseInfoAndEntInfo.setLastUpdTlrcd(bCrmBaseInfo.getLastUpdTlrcd());
		bCrmBaseInfoAndEntInfo.setCrtTime(bCrmBaseInfo.getCrtTime());
		bCrmBaseInfoAndEntInfo.setLastUpdTime(bCrmBaseInfo.getLastUpdTime());
		bCrmBaseInfoAndEntInfo.setBrcode(bCrmBaseInfo.getLastUpdBrcode());
		bCrmBaseInfoAndEntInfo.setLastUpdBrcode(bCrmBaseInfo.getLastUpdBrcode());
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo();
		BeanUtils.copyProperties(bCrmBaseInfo, bCrmBaseInfo2);
		bCrmBaseInfo2.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 设置经办机构信息
		String custcd = bSysSerialNoService.genSerialNo(BCrmBaseConstants.BAS_CUST_CD);// 客户流水号
		bCrmBaseInfo2.setCustcd(custcd);// 核心客户号与客户号先设置为一样
		bCrmBaseInfo2.setCustno(custcd);
		bCrmBaseInfo2.setCustStatus(BCrmBaseConstants.CUST_STATUS_VALID);// 客户状态默认设置为01
		bCrmBaseInfo2.setCustType(BCrmBaseConstants.CUST_TYPE_CORP);// 客户类型为法人
		try {
			iBCrmBaseInfoDAO.insert(bCrmBaseInfo2);
		} catch (Exception e) {
			log.error("新增客户信息失败！");
			throw new ScubeBizException("新增客户信息失败！", e);
		}

		// 4.新增企业信息
		BCrmEntInfo bCrmEntInfo = new BCrmEntInfo();
		bCrmBaseInfoAndEntInfo.setCustcd(custcd);
		bCrmBaseInfoAndEntInfo.setCustno(custcd);
		bCrmBaseInfoAndEntInfo.setCustStatus(BCrmBaseConstants.CUST_STATUS_VALID);
		bCrmBaseInfoAndEntInfo.setCustType(BCrmBaseConstants.CUST_TYPE_CORP);// 设定客户状态为1
		BeanUtils.copyProperties(bCrmBaseInfoAndEntInfo, bCrmEntInfo);
		try {
			iBCrmEntInfoService.add(bCrmEntInfo);
		} catch (Exception e) {
			throw new ScubeBizException("新增客户信息失败,新增对应企业信息失败！", e);
		}
		return bCrmBaseInfoAndEntInfo;
	}

	// 2.批量删除客户信息（应该是多表级联删除，但是现在先只做两个表的）
	@Override
	@Transactional
	public int batchDelete(List custcdList) {
		Iterator<Map<String, Object>> it = custcdList.iterator();
		List<String> custcd2List = new ArrayList<String>();
		while (it.hasNext()) {
			Map<String, Object> row = it.next();
			String custcd = row.get("custcd") == null ? "0" : row.get("custcd").toString();
			custcd2List.add(custcd);
		}
		try {
			return iBCrmBaseInfoDAO.batchDelete(custcd2List);
		} catch (Exception e) {
			log.error("删除客户信息失败！");
			throw new ScubeBizException("删除客户信息失败！", e);
		}
	}

	// 页面删除客户信息（考虑到既是授信，核心，监管，共有两个身份的情况）
	@Override
	@Transactional
	public int deleteBCrmBaseInfoAndRelated(BCrmBaseInfo bCrmBaseInfo) {
		// 1.校验数据
		if (bCrmBaseInfo == null || "".equals(bCrmBaseInfo)) {
			throw new ScubeBizException("删除客户信息失败，前台所传数据无效！");
		}
		String custcd = "";
		if (bCrmBaseInfo.getCustcd() == null || "".equals(bCrmBaseInfo.getCustcd())) {
			throw new ScubeBizException("删除客户信息失败，前台所传数据无效！");
		} else {
			custcd = bCrmBaseInfo.getCustcd();
		}
		
		String coreFlag="0";
		String creditFlag="0";
		String moniFlag="0";
		if(StringUtils.isNotEmpty(bCrmBaseInfo.getCoreFlag())){
			coreFlag = bCrmBaseInfo.getCoreFlag();
		}
		if(StringUtils.isNotEmpty(bCrmBaseInfo.getCreditFlag())){
			creditFlag = bCrmBaseInfo.getCreditFlag();
		}
		if(StringUtils.isNotEmpty(bCrmBaseInfo.getMoniFlag())){
			moniFlag = bCrmBaseInfo.getMoniFlag();
		}
		// deleteFlag为1是授信客户删除，2是核心厂商删除，3是监管公司删除
		// 1.如果是授信客户删除，并且同时是核心或者监管公司则只是改变coreFlag为0，并且删除对应的客户情况分析
		if (("1").equals(bCrmBaseInfo.getDeleteFlag())) {
			if (coreFlag.equals("1") || moniFlag.equals("1")) {
				BCrmBaseInfoExample bCrmBaseInfoExample = new BCrmBaseInfoExample();
				bCrmBaseInfoExample.createCriteria().andCustcdEqualTo(custcd);
				bCrmBaseInfo.setCreditFlag(null);
				bCrmBaseInfo.setImportantFlag(null);// 是否贸融重点客户
				bCrmBaseInfo.setIsIntl(null);// 是否国际保理客户
				com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo();
				BeanUtils.copyProperties(bCrmBaseInfo, bCrmBaseInfo2);
				// 修改为非授信客户,客户情况分析删除
				try {
					iBCrmBaseInfoDAO.updateByExample(bCrmBaseInfo2, bCrmBaseInfoExample);
					bCrmAnalInfoService.deleteByCustcd(custcd);
				} catch (Exception e) {
					throw new ScubeBizException("删除客户信息失败！");
				}
			} else {// 如果仅是单个客户身份，直接删除
				deleteBCrmBaseInfoCompletely(bCrmBaseInfo);
				bCrmAnalInfoService.deleteByCustcd(custcd);
			}
		}
		// 2.如果是核心厂商删除
		if (("2").equals(bCrmBaseInfo.getDeleteFlag())) {
			if (creditFlag.equals("1") || moniFlag.equals("1")) {
				BCrmBaseInfoExample bCrmBaseInfoExample = new BCrmBaseInfoExample();
				bCrmBaseInfoExample.createCriteria().andCustcdEqualTo(custcd);
				bCrmBaseInfo.setCoreFlag(null);
				bCrmBaseInfo.setCustStatus(BCrmBaseConstants.CUST_STATUS_VALID);// 有效客户状态
				com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo();
				BeanUtils.copyProperties(bCrmBaseInfo, bCrmBaseInfo2);
				BCrmEntInfo bCrmEntInfo = new BCrmEntInfo();
				bCrmEntInfo.setCustcd(custcd);
				// 修改为非授信客户,删除上下游关系信息
				try {
					BCrmEntInfo findBCrmEntInfoByKey = iBCrmEntInfoService.findBCrmEntInfoByKey(bCrmEntInfo);
					findBCrmEntInfoByKey.setSupplyPosition(null);// 修改公司所处供应链位置为空
					iBCrmEntInfoService.update(findBCrmEntInfoByKey);
					iBCrmBaseInfoDAO.updateByExample(bCrmBaseInfo2, bCrmBaseInfoExample);
					bCrmUpanddownRelService.deleteByCustcd(custcd);
				} catch (Exception e) {
					throw new ScubeBizException("删除客户信息失败！");
				}
			} else {// 如果不是两个客户身份，直接删除三个表
				deleteBCrmBaseInfoCompletely(bCrmBaseInfo);
				bCrmUpanddownRelService.deleteByCustcd(custcd);
			}
		}
		// 3.如果是监管公司
		if (("3").equals(bCrmBaseInfo.getDeleteFlag())) {
			if (creditFlag.equals("1") || coreFlag.equals("1")) {
				BCrmBaseInfoExample bCrmBaseInfoExample = new BCrmBaseInfoExample();
				bCrmBaseInfoExample.createCriteria().andCustcdEqualTo(custcd);
				bCrmBaseInfo.setMoniFlag(null);
				com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo();
				BeanUtils.copyProperties(bCrmBaseInfo, bCrmBaseInfo2);
				// 修改为非授信客户,删除监管公司对应信息
				try {
					iBCrmBaseInfoDAO.updateByExample(bCrmBaseInfo2, bCrmBaseInfoExample);
					bCrmMoniEntInfoService.deleteMoniRelatedByCustcd(custcd);
				} catch (Exception e) {
					throw new ScubeBizException("删除客户信息失败！");
				}
			} else {
				deleteBCrmBaseInfoCompletely(bCrmBaseInfo);
				bCrmMoniEntInfoService.deleteMoniRelatedByCustcd(custcd);
			}
		}
		return 0;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.crm.service.IBCrmBaseInfoService#
	 * deleteBCrmBaseInfoCompletely(com.huateng.scf.bas.crm.model.BCrmBaseInfo)
	 */
	@Override
	@Transactional
	public int deleteBCrmBaseInfoCompletely(BCrmBaseInfo bCrmBaseInfo) {
		// 2.删除账户信息表 'bAccAccountInfoService/batchDeleteBAccAccountInfoByCustcd
		String custcd = bCrmBaseInfo.getCustcd();
		BAccAccountInfo bAccAccountInfo = new BAccAccountInfo();
		bAccAccountInfo.setCustcd(custcd);
		try {
			bAccAccountInfoService.batchDeleteBAccAccountInfoByCustcd(bAccAccountInfo);
		} catch (Exception e) {
			throw new ScubeBizException("删除客户信息，删除账户信息失败！");
		}
		// 3.删除企业信息 bCrmEntInfoService/delete
		try {
			iBCrmEntInfoService.delete(custcd);
		} catch (Exception e) {
			throw new ScubeBizException("删除客户信息，删除企业信息失败！");
		}
		// 4.删除客户信息
		BCrmBaseInfoExample bCrmBaseInfoExample = new BCrmBaseInfoExample();
		bCrmBaseInfoExample.createCriteria().andCustcdEqualTo(custcd);
		try {
			return iBCrmBaseInfoDAO.deleteByExample(bCrmBaseInfoExample);
		} catch (Exception e) {
			throw new ScubeBizException("删除客户信息失败！");
		}
	}

	// 3.修改客户信息(需要同时修改两个表)
	@Override
	@Transactional
	public int update(BCrmBaseInfoAndEntInfo bCrmBaseInfoAndEntInfo2) {
		// 1.校验前台数据
		if (bCrmBaseInfoAndEntInfo2 == null || "".equals(bCrmBaseInfoAndEntInfo2)) {
			throw new ScubeBizException("修改客户信息失败,前台所传数据无效！");
		}
		// 2.校验前台国际行业和地区信息

		BCrmBaseInfoAndEntInfo bCrmBaseInfoAndEntInfo = this.checkBeforeAddOrSaveBCrmBrInfo(bCrmBaseInfoAndEntInfo2);

		// 2.修改客户信息
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo();
		BeanUtils.copyProperties(bCrmBaseInfoAndEntInfo, bCrmBaseInfo2);
		BCrmBaseInfoExample bbie = new BCrmBaseInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample.Criteria cri = bbie.createCriteria();
		if (bCrmBaseInfoAndEntInfo.getCustcd() != null && bCrmBaseInfoAndEntInfo.getCustcd().length() > 0) {
			cri.andCustcdEqualTo(bCrmBaseInfoAndEntInfo.getCustcd());
		}
		UserInfo user = ContextHolder.getUserInfo();
		String userId = user.getTlrNo();
		bCrmBaseInfo2.setLastUpdTlrcd(userId); // 最后更新人
		bCrmBaseInfo2.setLastUpdTime(new Date());// 最后更新时间
		BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
		String brcode = bctlVO.getBrNo();
		bCrmBaseInfo2.setLastUpdBrcode(brcode);// 设置最后更新机构
		try {
			iBCrmBaseInfoDAO.updateByExample(bCrmBaseInfo2, bbie);
		} catch (Exception e) {
			log.error("修改客户信息失败！");
			throw new ScubeBizException("修改客户信息失败！", e);
		}
		// 3.修改企业信息
		BCrmEntInfo bCrmEntInfo = new BCrmEntInfo();
		BeanUtils.copyProperties(bCrmBaseInfoAndEntInfo, bCrmEntInfo);
		try {
			return iBCrmEntInfoService.update(bCrmEntInfo);
		} catch (Exception e) {
			throw new ScubeBizException("修改客户信息失败,修改对应的企业信息失败！");
		}

	}

	// 4.条件查询客户信息，返回单个对象！（无条件查询，返回空值。）
	@Override
	public BCrmBaseInfo findBCrmBaseInfoByKey(BCrmBaseInfo bCrmBaseInfo) {
		BCrmBaseInfoExample bbie = new BCrmBaseInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample.Criteria criteria = bbie.createCriteria();
		if (bCrmBaseInfo != null && !"".equals(bCrmBaseInfo)) {
			// 根据客户号查询 custcd
			if (bCrmBaseInfo.getCustcd() != null && !"".equals(bCrmBaseInfo.getCustcd())) {
				criteria.andCustcdEqualTo(bCrmBaseInfo.getCustcd());
			}
			// 根据核心客户号查询custno
			if (bCrmBaseInfo.getCustno() != null && !"".equals(bCrmBaseInfo.getCustno())) {
				criteria.andCustnoEqualTo(bCrmBaseInfo.getCustno());
			}
			// 根据客户名称查询
			if (bCrmBaseInfo.getCname() != null && !"".equals(bCrmBaseInfo.getCname())) {
				criteria.andCnameLike("%" + bCrmBaseInfo.getCname() + "%");
			}
			// 组织机构代码orgCode
			if (bCrmBaseInfo.getOrgCode() != null && !"".equals(bCrmBaseInfo.getOrgCode())) {
				criteria.andOrgCodeEqualTo(bCrmBaseInfo.getOrgCode());
			}
			// 管户员(mgrno)
			if (bCrmBaseInfo.getMgrno() != null && !"".equals(bCrmBaseInfo.getMgrno())) {
				criteria.andMgrnoEqualTo(bCrmBaseInfo.getMgrno());
			}
			BCrmBaseInfo bCrmBaseInfo2 = new BCrmBaseInfo();

			try {
				List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> bCrmBaseInfos = iBCrmBaseInfoDAO.selectByExample(bbie);
				if (bCrmBaseInfos != null && bCrmBaseInfos.size() == 1) {
					com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo1 = bCrmBaseInfos.get(0);
					BeanUtils.copyProperties(bCrmBaseInfo1, bCrmBaseInfo2);
				} else {
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("条件查询客户基本信息失败！");
			}
			if (bCrmBaseInfo2 != null && !"".equals(bCrmBaseInfo2)) {
				// 翻译，创建人tlrcd，最后更新操作员lastUpdTlrcd，经办机构brcode，最后更新经办机构lastUpdBrcode
				UserInfo userInfo1 = new UserInfo();
				userInfo1.setTlrNo(bCrmBaseInfo2.getTlrcd());// 搜索创建人对应的名称。
				List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
				if (userList != null && userList.size() == 1) {
					bCrmBaseInfo2.setTlrName(userList.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
				} else {
					throw new ScubeBizException("客户号为" + bCrmBaseInfo2.getCustcd() + " 的客户信息经办人信息有误！");
				}

				// 最后更新操作员lastUpdTlrName
				UserInfo userInfo2 = new UserInfo();
				userInfo2.setTlrNo(bCrmBaseInfo2.getLastUpdTlrcd());
				// 搜索最后更新操作员对应的名称。
				List<TlrInfoVO> userList2 = userService.selectByExample(userInfo2);
				if (userList2 != null && userList2.size() == 1) {
					bCrmBaseInfo2.setLastUpdTlrName(userList2.get(0).getTlrName());
					// 将查询结果赋值于页面创建人代码。
				} else {
					throw new ScubeBizException("客户号为" + bCrmBaseInfo2.getCustcd() + " 的客户信息最后更新经办人信息有误！");
				}

				// 经办机构brName
				BctlVO bctlVO = new BctlVO();
				bctlVO.setBrNo(bCrmBaseInfo2.getBrcode());
				List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
				if (bctlVOList != null && bctlVOList.size() == 1) {
					bCrmBaseInfo2.setBrName(bctlVOList.get(0).getBrName());
				} else {
					throw new ScubeBizException("客户号为" + bCrmBaseInfo2.getCustcd() + "的客户信息经办机构信息有误！");
				}

				// 最后更新经办机构lastUpdBrName
				BctlVO bctlVO2 = new BctlVO();
				bctlVO2.setBrNo(bCrmBaseInfo2.getLastUpdBrcode());
				List<BctlVO> bctlVOList2 = orgService.selectByExample(bctlVO2);
				if (bctlVOList2 != null && bctlVOList2.size() == 1) {
					bCrmBaseInfo2.setLastUpdBrName(bctlVOList2.get(0).getBrName());
				} else {
					throw new ScubeBizException("客户号为" + bCrmBaseInfo2.getCustcd() + "的客户信息最后更新机构信息有误！");
				}
			}

			return bCrmBaseInfo2;

		} else {// 当传过来的对象就是null的时候，就返回null，与其他两个查询方法区别下。
			return null;
		}
	}

	// 用于客户新增页面，返回同时拥有两个表字段内容
	@Override
	public BCrmBaseInfoAndEntInfo findBCrmBaseInfoByKey2(BCrmBaseInfoAndEntInfo bCrmBaseInfoAndEntInfo) {
		// 1.前台数据
		if (bCrmBaseInfoAndEntInfo == null || "".equals(bCrmBaseInfoAndEntInfo)) {
			throw new ScubeBizException("客户信息查询，所传数据无效！");
		}
		BCrmBaseInfoAndEntInfo info = new BCrmBaseInfoAndEntInfo();
		BCrmBaseInfoExample bbie = new BCrmBaseInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample.Criteria criteria = bbie.createCriteria();
		// 根据客户号查询 custcd
		if (bCrmBaseInfoAndEntInfo.getCustcd() != null && !"".equals(bCrmBaseInfoAndEntInfo.getCustcd())) {
			criteria.andCustcdEqualTo(bCrmBaseInfoAndEntInfo.getCustcd());
		}
		// 组织机构代码orgCode
		if (bCrmBaseInfoAndEntInfo.getOrgCode() != null && !"".equals(bCrmBaseInfoAndEntInfo.getOrgCode())) {
			criteria.andOrgCodeEqualTo(bCrmBaseInfoAndEntInfo.getOrgCode());
		}
		// 管户员(mgrno)
		if (bCrmBaseInfoAndEntInfo.getMgrno() != null && !"".equals(bCrmBaseInfoAndEntInfo.getMgrno())) {
			criteria.andMgrnoEqualTo(bCrmBaseInfoAndEntInfo.getMgrno());
		}
		BCrmBaseInfo bCrmBaseInfo2 = new BCrmBaseInfo();
		BCrmEntInfo bCrmEntInfo2 = new BCrmEntInfo();
		// 2.查询客户信息
		try {
			List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> bCrmBaseInfos = iBCrmBaseInfoDAO.selectByExample(bbie);
			if (bCrmBaseInfos != null && bCrmBaseInfos.size() == 1) {
				com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo1 = bCrmBaseInfos.get(0);
				BeanUtils.copyProperties(bCrmBaseInfo1, bCrmBaseInfo2);
				// 对应企业信息查询
				BCrmEntInfo bCrmEntInfo = new BCrmEntInfo();
				bCrmEntInfo.setCustcd(bCrmBaseInfo2.getCustcd());
				BCrmEntInfo entInfo = iBCrmEntInfoService.findBCrmEntInfoByKey(bCrmEntInfo);
				if (entInfo != null) {
					BeanUtils.copyProperties(entInfo, bCrmEntInfo2);
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new ScubeBizException("条件查询客户基本信息失败！");
		}
		// 3.转译对应机构,经办人信息
		if (bCrmBaseInfo2 != null && !"".equals(bCrmBaseInfo2)) {
			// 翻译，创建人tlrcd，最后更新操作员lastUpdTlrcd，经办机构brcode，最后更新经办机构lastUpdBrcode
			UserInfo userInfo1 = new UserInfo();
			userInfo1.setTlrNo(bCrmBaseInfo2.getTlrcd());// 搜索创建人对应的名称。
			List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
			if (userList != null && userList.size() == 1) {
				bCrmBaseInfo2.setTlrName(userList.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
			} else {
				throw new ScubeBizException("客户号为" + bCrmBaseInfo2.getCustcd() + " 的客户信息经办人信息有误！");
			}

			// 最后更新操作员lastUpdTlrName
			UserInfo userInfo2 = new UserInfo();
			userInfo2.setTlrNo(bCrmBaseInfo2.getLastUpdTlrcd());
			// 搜索最后更新操作员对应的名称。
			List<TlrInfoVO> userList2 = userService.selectByExample(userInfo2);
			if (userList2 != null && userList2.size() == 1) {
				bCrmBaseInfo2.setLastUpdTlrName(userList2.get(0).getTlrName());
				// 将查询结果赋值于页面创建人代码。
			} else {
				throw new ScubeBizException("客户号为" + bCrmBaseInfo2.getCustcd() + " 的客户信息最后更新经办人信息有误！");
			}

			// 经办机构brName
			BctlVO bctlVO = new BctlVO();
			bctlVO.setBrNo(bCrmBaseInfo2.getBrcode());
			List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
			if (bctlVOList != null && bctlVOList.size() == 1) {
				bCrmBaseInfo2.setBrName(bctlVOList.get(0).getBrName());
			} else {
				throw new ScubeBizException("客户号为" + bCrmBaseInfo2.getCustcd() + "的客户信息经办机构信息有误！");
			}

			// 最后更新经办机构lastUpdBrName
			BctlVO bctlVO2 = new BctlVO();
			bctlVO2.setBrNo(bCrmBaseInfo2.getLastUpdBrcode());
			List<BctlVO> bctlVOList2 = orgService.selectByExample(bctlVO2);
			if (bctlVOList2 != null && bctlVOList2.size() == 1) {
				bCrmBaseInfo2.setLastUpdBrName(bctlVOList2.get(0).getBrName());
			} else {
				throw new ScubeBizException("客户号为" + bCrmBaseInfo2.getCustcd() + "的客户信息最后更新机构信息有误！");
			}
			try {
				BeanUtils.copyProperties(bCrmBaseInfo2, info);
				BeanUtils.copyProperties(bCrmEntInfo2, info);
			} catch (Exception e) {
				throw new ScubeBizException("查询具体客户信息，数据拷贝错误！");
			}
			return info;
		} else {
			return null;
		}

	}

	// 条件查询客户信息字查询客户信息，返回客户信息对象集合！（当传过来空值时，返回所有对象。）
	@Override
	public List<BCrmBaseInfo> findBCrmBaseInfoByBCrm(BCrmBaseInfo bCrmBaseInfo) {
		BCrmBaseInfoExample example = new BCrmBaseInfoExample();
		Criteria criteria = example.createCriteria();
		if (bCrmBaseInfo != null) {
			// 开户日期(openDate)，核心开户日期(coreOpenDate)，管户员(mgrno)只有这三个没有查询
			// 这里只有涉及名称和经办机构是用的模糊查询，但凡查询的日期都没有用between查询。如果有其他需要在更改。
			// 根据客户号查询custcd
			if (bCrmBaseInfo.getCustcd() != null && !"".equals(bCrmBaseInfo.getCustcd())) {
				criteria.andCustcdEqualTo(bCrmBaseInfo.getCustcd());
			}
			// 根据核心客户号查询custno
			if (bCrmBaseInfo.getCustno() != null && !"".equals(bCrmBaseInfo.getCustno())) {
				criteria.andCustnoEqualTo(bCrmBaseInfo.getCustno());
			}
			// 根据客户名称查询cname
			if (bCrmBaseInfo.getCname() != null && !"".equals(bCrmBaseInfo.getCname())) {
				criteria.andCnameLike("%" + bCrmBaseInfo.getCname() + "%");
			}
			// 根据客户类型查询custType
			if (bCrmBaseInfo.getCustType() != null && !"".equals(bCrmBaseInfo.getCustType())) {
				criteria.andCustTypeEqualTo(bCrmBaseInfo.getCustType());
			}
			// 证件类型 idtype
			if (bCrmBaseInfo.getIdtype() != null && !"".equals(bCrmBaseInfo.getIdtype())) {
				criteria.andIdtypeEqualTo(bCrmBaseInfo.getIdtype());
			}
			// 根据证件号码查询idno
			if (bCrmBaseInfo.getIdno() != null && !"".equals(bCrmBaseInfo.getIdno())) {
				criteria.andIdnoEqualTo(bCrmBaseInfo.getIdno());
			}
			// 客户英文名ename
			if (bCrmBaseInfo.getEname() != null && !"".equals(bCrmBaseInfo.getEname())) {
				criteria.andEnameLike("%" + bCrmBaseInfo.getEname() + "%");
			}

			// 客户别名aliasName
			if (bCrmBaseInfo.getAliasName() != null && !"".equals(bCrmBaseInfo.getAliasName())) {
				criteria.andAliasNameLike("%" + bCrmBaseInfo.getAliasName() + "%");
			}
			// 组织机构代码orgCode
			if (bCrmBaseInfo.getOrgCode() != null && !"".equals(bCrmBaseInfo.getOrgCode())) {
				criteria.andOrgCodeEqualTo(bCrmBaseInfo.getOrgCode());
			}
			// 社会信用代码socCreditNo
			if (bCrmBaseInfo.getSocCreditNo() != null && !"".equals(bCrmBaseInfo.getSocCreditNo())) {
				criteria.andSocCreditNoEqualTo(bCrmBaseInfo.getSocCreditNo());
			}
			// 营业执照注册号licenseNo
			if (bCrmBaseInfo.getLicenseNo() != null && !"".equals(bCrmBaseInfo.getLicenseNo())) {
				criteria.andLicenseNoEqualTo(bCrmBaseInfo.getLicenseNo());
			}
			// 营业执照到期日licenseDate
			if (bCrmBaseInfo.getLicenseDate() != null && !"".equals(bCrmBaseInfo.getLicenseDate())) {
				criteria.andLicenseDateEqualTo(bCrmBaseInfo.getLicenseDate());
			}
			// 客户状态custStatus
			if (bCrmBaseInfo.getCustStatus() != null && !"".equals(bCrmBaseInfo.getCustStatus())) {
				criteria.andCustStatusEqualTo(bCrmBaseInfo.getCustStatus());
			}
			// 是否核心厂商coreFlag
			if (bCrmBaseInfo.getCoreFlag() != null && !"".equals(bCrmBaseInfo.getCoreFlag())) {
				criteria.andCoreFlagEqualTo(bCrmBaseInfo.getCoreFlag());
			}
			// 根据是否是监管客户查询moniFlag
			if (bCrmBaseInfo.getMoniFlag() != null && !"".equals(bCrmBaseInfo.getMoniFlag())) {
				criteria.andMoniFlagEqualTo(bCrmBaseInfo.getMoniFlag());
			}
			// 是否期货经纪公司futuresFlag
			if (bCrmBaseInfo.getFuturesFlag() != null && !"".equals(bCrmBaseInfo.getFuturesFlag())) {
				criteria.andFuturesFlagEqualTo(bCrmBaseInfo.getFuturesFlag());
			}
			// 是否金融租赁公司flcFlag
			if (bCrmBaseInfo.getFlcFlag() != null && !"".equals(bCrmBaseInfo.getFlcFlag())) {
				criteria.andFlcFlagEqualTo(bCrmBaseInfo.getFlcFlag());
			}
			// 建档日期 createDate
			if (bCrmBaseInfo.getCreateDate() != null && !"".equals(bCrmBaseInfo.getCreateDate())) {
				criteria.andCreateDateEqualTo(bCrmBaseInfo.getCreateDate());
			}
			// 授信客户标识creditFlag
			if (bCrmBaseInfo.getCreditFlag() != null && !"".equals(bCrmBaseInfo.getCreditFlag())) {
				criteria.andCreditFlagEqualTo(bCrmBaseInfo.getCreditFlag());
			}
			// 黑名单标识blackFlag
			if (bCrmBaseInfo.getBlackFlag() != null && !"".equals(bCrmBaseInfo.getBlackFlag())) {
				criteria.andBlackFlagEqualTo(bCrmBaseInfo.getBlackFlag());
			}
			// 是否保险公司insureFlag
			if (bCrmBaseInfo.getInsureFlag() != null && !"".equals(bCrmBaseInfo.getInsureFlag())) {
				criteria.andInsureFlagEqualTo(bCrmBaseInfo.getInsureFlag());
			}
			// 根据是否是保理商查询factorFlag
			if (bCrmBaseInfo.getFactorFlag() != null && !"".equals(bCrmBaseInfo.getFactorFlag())) {
				criteria.andFactorFlagEqualTo(bCrmBaseInfo.getFactorFlag());
			}
			// 信贷客户号ccmsCustcd
			if (bCrmBaseInfo.getCcmsCustcd() != null && !"".equals(bCrmBaseInfo.getCcmsCustcd())) {
				criteria.andCcmsCustcdEqualTo(bCrmBaseInfo.getCcmsCustcd());
			}
			// 是否贸融重点客户importantFlag
			if (bCrmBaseInfo.getImportantFlag() != null && !"".equals(bCrmBaseInfo.getImportantFlag())) {
				criteria.andImportantFlagEqualTo(bCrmBaseInfo.getImportantFlag());
			}
			// 是否贸易对手commercialFalg
			if (bCrmBaseInfo.getCommercialFalg() != null && !"".equals(bCrmBaseInfo.getCommercialFalg())) {
				criteria.andCommercialFalgEqualTo(bCrmBaseInfo.getCommercialFalg());
			}
			// 是否境外overseasFlag
			if (bCrmBaseInfo.getOverseasFlag() != null && !"".equals(bCrmBaseInfo.getOverseasFlag())) {
				criteria.andOverseasFlagEqualTo(bCrmBaseInfo.getOverseasFlag());
			}
			// 是否是本行客户banksCustFlag
			if (bCrmBaseInfo.getBanksCustFlag() != null && !"".equals(bCrmBaseInfo.getBanksCustFlag())) {
				criteria.andBanksCustFlagEqualTo(bCrmBaseInfo.getBanksCustFlag());
			}
			// 是否是EF进口商efBuyerFlag
			if (bCrmBaseInfo.getEfBuyerFlag() != null && !"".equals(bCrmBaseInfo.getEfBuyerFlag())) {
				criteria.andEfBuyerFlagEqualTo(bCrmBaseInfo.getEfBuyerFlag());
			}
			// 是否是IF出口商ifSellerFlag
			if (bCrmBaseInfo.getIfSellerFlag() != null && !"".equals(bCrmBaseInfo.getIfSellerFlag())) {
				criteria.andIfSellerFlagEqualTo(bCrmBaseInfo.getIfSellerFlag());
			}
			// 是否是银行 isBank
			if (bCrmBaseInfo.getIsBank() != null && !"".equals(bCrmBaseInfo.getIsBank())) {
				criteria.andIsBankEqualTo(bCrmBaseInfo.getIsBank());
			}
			// FCI代号 fciCode
			if (bCrmBaseInfo.getFciCode() != null && !"".equals(bCrmBaseInfo.getFciCode())) {
				criteria.andFciCodeEqualTo(bCrmBaseInfo.getFciCode());
			}
			// 是否国际保理客户isIntl
			if (bCrmBaseInfo.getIsIntl() != null && !"".equals(bCrmBaseInfo.getIsIntl())) {
				criteria.andIsIntlEqualTo(bCrmBaseInfo.getIsIntl());
			}
			// 经办机构brcode
			if (bCrmBaseInfo.getBrcode() != null && !"".equals(bCrmBaseInfo.getBrcode())) {
				criteria.andBrcodeLike("%" + bCrmBaseInfo.getBrcode() + "%");
			}
			// 创建人tlrcd
			if (bCrmBaseInfo.getTlrcd() != null && !"".equals(bCrmBaseInfo.getTlrcd())) {
				criteria.andTlrcdEqualTo(bCrmBaseInfo.getTlrcd());
			}
			// 创建时间 crtTime
			if (bCrmBaseInfo.getCrtTime() != null && !"".equals(bCrmBaseInfo.getCrtTime())) {
				criteria.andCrtTimeEqualTo(bCrmBaseInfo.getCrtTime());
			}
			// 最后更新操作员 lastUpdTlrcd
			if (bCrmBaseInfo.getLastUpdTlrcd() != null && !"".equals(bCrmBaseInfo.getLastUpdTlrcd())) {
				criteria.andLastUpdTlrcdEqualTo(bCrmBaseInfo.getLastUpdTlrcd());
			}
			// 最后更新时间 lastUpdTime
			if (bCrmBaseInfo.getLastUpdTime() != null && !"".equals(bCrmBaseInfo.getLastUpdTime())) {
				criteria.andLastUpdTimeEqualTo(bCrmBaseInfo.getLastUpdTime());
			}
			// 管户员(mgrno)
			if (bCrmBaseInfo.getMgrno() != null && !"".equals(bCrmBaseInfo.getMgrno())) {
				criteria.andMgrnoEqualTo(bCrmBaseInfo.getMgrno());
			}
		}
		try {
			List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> listdal = iBCrmBaseInfoDAO.selectByExample(example);
			List<BCrmBaseInfo> list = new ArrayList<BCrmBaseInfo>();
			if (listdal != null && listdal.size() > 0) {
				for (com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfodal : listdal) {
					BCrmBaseInfo bCrmBaseInfo2 = new BCrmBaseInfo();
					BeanUtils.copyProperties(bCrmBaseInfodal, bCrmBaseInfo2);
					list.add(bCrmBaseInfo2);
				}
			}
			return list;
		} catch (Exception e) {
			throw new ScubeBizException("条件查询客户基本信息集合失败！");
		}
	}

	// 条件查询客户信息，返回分页对象！
	@Override
	public Page findBCrmBaseInfoByPage(int pageNo, int pageSize, BCrmBaseInfo bCrmBaseInfo) {
		Page p = new Page(pageSize, pageNo, 0);
		BCrmBaseInfoExample example = new BCrmBaseInfoExample();
		if (bCrmBaseInfo != null) {
			com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample.Criteria criteria = example.createCriteria();
			// 开户日期(openDate)，核心开户日期(coreOpenDate)，管户员(mgrno)只有这三个没有查询
			// 这里只有涉及名称和经办机构是用的模糊查询，但凡查询的日期都没有用between查询。如果有其他需要在更改。
			// 根据客户号查询custcd
			if (bCrmBaseInfo.getCustcd() != null && !"".equals(bCrmBaseInfo.getCustcd())) {
				criteria.andCustcdLike("%" + bCrmBaseInfo.getCustcd() + "%");
			}
			// 根据核心客户号查询custno
			if (bCrmBaseInfo.getCustno() != null && !"".equals(bCrmBaseInfo.getCustno())) {
				criteria.andCustnoEqualTo(bCrmBaseInfo.getCustno());
			}
			// 根据客户名称查询cname
			if (bCrmBaseInfo.getCname() != null && !"".equals(bCrmBaseInfo.getCname())) {
				criteria.andCnameLike("%" + bCrmBaseInfo.getCname() + "%");
			}
			// 根据客户类型查询custType
			if (bCrmBaseInfo.getCustType() != null && !"".equals(bCrmBaseInfo.getCustType())) {
				criteria.andCustTypeEqualTo(bCrmBaseInfo.getCustType());
			}
			// 证件类型 idtype
			if (bCrmBaseInfo.getIdtype() != null && !"".equals(bCrmBaseInfo.getIdtype())) {
				criteria.andIdtypeEqualTo(bCrmBaseInfo.getIdtype());
			}
			// 根据证件号码查询idno
			if (bCrmBaseInfo.getIdno() != null && !"".equals(bCrmBaseInfo.getIdno())) {
				criteria.andIdnoEqualTo(bCrmBaseInfo.getIdno());
			}
			// 客户英文名ename
			if (bCrmBaseInfo.getEname() != null && !"".equals(bCrmBaseInfo.getEname())) {
				criteria.andEnameLike("%" + bCrmBaseInfo.getEname() + "%");
			}
			// 客户别名aliasName
			if (bCrmBaseInfo.getAliasName() != null && !"".equals(bCrmBaseInfo.getAliasName())) {
				criteria.andAliasNameLike("%" + bCrmBaseInfo.getAliasName() + "%");
			}
			// 组织机构代码orgCode
			if (bCrmBaseInfo.getOrgCode() != null && !"".equals(bCrmBaseInfo.getOrgCode())) {
				criteria.andOrgCodeEqualTo(bCrmBaseInfo.getOrgCode());
			}
			// 社会信用代码socCreditNo
			if (bCrmBaseInfo.getSocCreditNo() != null && !"".equals(bCrmBaseInfo.getSocCreditNo())) {
				criteria.andSocCreditNoEqualTo(bCrmBaseInfo.getSocCreditNo());
			}
			// 营业执照注册号licenseNo
			if (bCrmBaseInfo.getLicenseNo() != null && !"".equals(bCrmBaseInfo.getLicenseNo())) {
				criteria.andLicenseNoEqualTo(bCrmBaseInfo.getLicenseNo());
			}
			// 营业执照到期日licenseDate
			if (bCrmBaseInfo.getLicenseDate() != null && !"".equals(bCrmBaseInfo.getLicenseDate())) {
				criteria.andLicenseDateEqualTo(bCrmBaseInfo.getLicenseDate());
			}
			// 客户状态custStatus
			if (bCrmBaseInfo.getCustStatus() != null && !"".equals(bCrmBaseInfo.getCustStatus())) {
				criteria.andCustStatusEqualTo(bCrmBaseInfo.getCustStatus());
			}
			// 是否核心厂商coreFlag
			if (bCrmBaseInfo.getCoreFlag() != null && !"".equals(bCrmBaseInfo.getCoreFlag())) {
				criteria.andCoreFlagEqualTo(bCrmBaseInfo.getCoreFlag());
			}
			// 根据是否是监管客户查询moniFlag
			if (bCrmBaseInfo.getMoniFlag() != null && !"".equals(bCrmBaseInfo.getMoniFlag())) {
				criteria.andMoniFlagEqualTo(bCrmBaseInfo.getMoniFlag());
			}
			// 是否期货经纪公司futuresFlag
			if (bCrmBaseInfo.getFuturesFlag() != null && !"".equals(bCrmBaseInfo.getFuturesFlag())) {
				criteria.andFuturesFlagEqualTo(bCrmBaseInfo.getFuturesFlag());
			}
			// 是否金融租赁公司flcFlag
			if (bCrmBaseInfo.getFlcFlag() != null && !"".equals(bCrmBaseInfo.getFlcFlag())) {
				criteria.andFlcFlagEqualTo(bCrmBaseInfo.getFlcFlag());
			}
			// 建档日期 createDate
			if (bCrmBaseInfo.getCreateDate() != null && !"".equals(bCrmBaseInfo.getCreateDate())) {
				criteria.andCreateDateEqualTo(bCrmBaseInfo.getCreateDate());
			}
			// 授信客户标识creditFlag
			if (bCrmBaseInfo.getCreditFlag() != null && !"".equals(bCrmBaseInfo.getCreditFlag())) {
				criteria.andCreditFlagEqualTo(bCrmBaseInfo.getCreditFlag());
			}
			// 黑名单标识blackFlag
			if (bCrmBaseInfo.getBlackFlag() != null && !"".equals(bCrmBaseInfo.getBlackFlag())) {
				criteria.andBlackFlagEqualTo(bCrmBaseInfo.getBlackFlag());
			}
			// 是否保险公司insureFlag
			if (bCrmBaseInfo.getInsureFlag() != null && !"".equals(bCrmBaseInfo.getInsureFlag())) {
				criteria.andInsureFlagEqualTo(bCrmBaseInfo.getInsureFlag());
			}
			// 根据是否是保理商查询factorFlag
			if (bCrmBaseInfo.getFactorFlag() != null && !"".equals(bCrmBaseInfo.getFactorFlag())) {
				criteria.andFactorFlagEqualTo(bCrmBaseInfo.getFactorFlag());
			}
			// 信贷客户号ccmsCustcd
			if (bCrmBaseInfo.getCcmsCustcd() != null && !"".equals(bCrmBaseInfo.getCcmsCustcd())) {
				criteria.andCcmsCustcdEqualTo(bCrmBaseInfo.getCcmsCustcd());
			}
			// 是否贸融重点客户importantFlag
			if (bCrmBaseInfo.getImportantFlag() != null && !"".equals(bCrmBaseInfo.getImportantFlag())) {
				criteria.andImportantFlagEqualTo(bCrmBaseInfo.getImportantFlag());
			}
			// 是否贸易对手commercialFalg
			if (bCrmBaseInfo.getCommercialFalg() != null && !"".equals(bCrmBaseInfo.getCommercialFalg())) {
				criteria.andCommercialFalgEqualTo(bCrmBaseInfo.getCommercialFalg());
			}
			// 是否境外overseasFlag
			if (bCrmBaseInfo.getOverseasFlag() != null && !"".equals(bCrmBaseInfo.getOverseasFlag())) {
				criteria.andOverseasFlagEqualTo(bCrmBaseInfo.getOverseasFlag());
			}
			// 是否是本行客户banksCustFlag
			if (bCrmBaseInfo.getBanksCustFlag() != null && !"".equals(bCrmBaseInfo.getBanksCustFlag())) {
				criteria.andBanksCustFlagEqualTo(bCrmBaseInfo.getBanksCustFlag());
			}
			// 是否是EF进口商efBuyerFlag
			if (bCrmBaseInfo.getEfBuyerFlag() != null && !"".equals(bCrmBaseInfo.getEfBuyerFlag())) {
				criteria.andEfBuyerFlagEqualTo(bCrmBaseInfo.getEfBuyerFlag());
			}
			// 是否是IF出口商ifSellerFlag
			if (bCrmBaseInfo.getIfSellerFlag() != null && !"".equals(bCrmBaseInfo.getIfSellerFlag())) {
				criteria.andIfSellerFlagEqualTo(bCrmBaseInfo.getIfSellerFlag());
			}
			// 是否是银行 isBank
			if (bCrmBaseInfo.getIsBank() != null && !"".equals(bCrmBaseInfo.getIsBank())) {
				criteria.andIsBankEqualTo(bCrmBaseInfo.getIsBank());
			}
			// FCI代号 fciCode
			if (bCrmBaseInfo.getFciCode() != null && !"".equals(bCrmBaseInfo.getFciCode())) {
				criteria.andFciCodeEqualTo(bCrmBaseInfo.getFciCode());
			}
			// 是否国际保理客户isIntl
			if (bCrmBaseInfo.getIsIntl() != null && !"".equals(bCrmBaseInfo.getIsIntl())) {
				criteria.andIsIntlEqualTo(bCrmBaseInfo.getIsIntl());
			}
			// 经办机构brcode
			if (bCrmBaseInfo.getBrcode() != null && !"".equals(bCrmBaseInfo.getBrcode())) {
				criteria.andBrcodeLike("%" + bCrmBaseInfo.getBrcode() + "%");
			}
			// 创建人tlrcd
			if (bCrmBaseInfo.getTlrcd() != null && !"".equals(bCrmBaseInfo.getTlrcd())) {
				criteria.andTlrcdEqualTo(bCrmBaseInfo.getTlrcd());
			}
			// 创建时间 crtTime
			if (bCrmBaseInfo.getCrtTime() != null && !"".equals(bCrmBaseInfo.getCrtTime())) {
				criteria.andCrtTimeEqualTo(bCrmBaseInfo.getCrtTime());
			}
			// 最后更新操作员 lastUpdTlrcd
			if (bCrmBaseInfo.getLastUpdTlrcd() != null && !"".equals(bCrmBaseInfo.getLastUpdTlrcd())) {
				criteria.andLastUpdTlrcdEqualTo(bCrmBaseInfo.getLastUpdTlrcd());
			}
			// 最后更新时间 lastUpdTime
			if (bCrmBaseInfo.getLastUpdTime() != null && !"".equals(bCrmBaseInfo.getLastUpdTime())) {
				criteria.andLastUpdTimeEqualTo(bCrmBaseInfo.getLastUpdTime());
			}
			// 管户员(mgrno)
			if (bCrmBaseInfo.getMgrno() != null && !"".equals(bCrmBaseInfo.getMgrno())) {
				criteria.andMgrnoEqualTo(bCrmBaseInfo.getMgrno());
			}
		}
		// 1.分页条件查询
		List<BCrmBaseInfo> list = new ArrayList<BCrmBaseInfo>();
		try {
			example.setOrderByClause(" LAST_UPD_TIME desc");
			List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> listdal = iBCrmBaseInfoDAO.selectByPage(example, p);
			for (com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfodal : listdal) {
				BCrmBaseInfo bCrmBaseInfo2 = new BCrmBaseInfo();
				BeanUtils.copyProperties(bCrmBaseInfodal, bCrmBaseInfo2);
				list.add(bCrmBaseInfo2);
			}
		} catch (Exception e) {
			log.error("条件分页查询客户信息失败！");
			throw new ScubeBizException("条件分页查询客户信息失败！", e);
		}
		// 2.转译页面信息
		List<BCrmBaseInfo> list2 = new ArrayList<BCrmBaseInfo>();
		for (com.huateng.scf.bas.crm.model.BCrmBaseInfo bCrmBaseInfodal2 : list) {
			// 翻译，创建人tlrcd，最后更新操作员lastUpdTlrcd，经办机构brcode，最后更新经办机构lastUpdBrcode
			UserInfo userInfo1 = new UserInfo();
			userInfo1.setTlrNo(bCrmBaseInfodal2.getTlrcd());// 搜索创建人对应的名称。
			List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
			if (userList != null && userList.size() == 1) {
				bCrmBaseInfodal2.setTlrName(userList.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
			} else {
				throw new ScubeBizException("客户号为" + bCrmBaseInfodal2.getCustcd() + " 的客户信息经办人信息有误！");
			}

			// 最后更新操作员lastUpdTlrName
			UserInfo userInfo2 = new UserInfo();
			userInfo2.setTlrNo(bCrmBaseInfodal2.getLastUpdTlrcd());
			// 搜索最后更新操作员对应的名称。
			List<TlrInfoVO> userList2 = userService.selectByExample(userInfo2);
			if (userList2 != null && userList2.size() == 1) {
				bCrmBaseInfodal2.setLastUpdTlrName(userList2.get(0).getTlrName());
				// 将查询结果赋值于页面创建人代码。
			} else {
				throw new ScubeBizException("客户号为" + bCrmBaseInfodal2.getCustcd() + " 的客户信息最后更新经办人信息有误！");
			}

			// 经办机构brName
			BctlVO bctlVO = new BctlVO();
			bctlVO.setBrNo(bCrmBaseInfodal2.getBrcode());
			List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
			if (bctlVOList != null && bctlVOList.size() == 1) {
				bCrmBaseInfodal2.setBrName(bctlVOList.get(0).getBrName());
			} else {
				throw new ScubeBizException("客户号为" + bCrmBaseInfodal2.getCustcd() + "的客户信息经办机构信息有误！");
			}

			// 最后更新经办机构lastUpdBrName
			BctlVO bctlVO2 = new BctlVO();
			bctlVO2.setBrNo(bCrmBaseInfodal2.getLastUpdBrcode());
			List<BctlVO> bctlVOList2 = orgService.selectByExample(bctlVO2);
			if (bctlVOList2 != null && bctlVOList2.size() == 1) {
				bCrmBaseInfodal2.setLastUpdBrName(bctlVOList2.get(0).getBrName());
			} else {
				throw new ScubeBizException("客户号为" + bCrmBaseInfodal2.getCustcd() + "的客户信息最后更新机构信息有误！");
			}

			list2.add(bCrmBaseInfodal2);
		}
		p.setRecords(list2);
		return p;

	}

	// 专门用于页面下拉框的条件查询客户信息，返回分页对象！
	@Override
	public Page selectBCrmBaseInfoByPage(int pageNo, int pageSize, BCrmBaseInfo bCrmBaseInfo) {
		Page p = new Page(pageSize, pageNo, 0);

		BCrmBaseInfoExample example = new BCrmBaseInfoExample();
		if (bCrmBaseInfo != null && !"".equals(bCrmBaseInfo)) {
			com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample.Criteria criteria = example.createCriteria();
			// 开户日期(openDate)，核心开户日期(coreOpenDate)，管户员(mgrno)只有这三个没有查询
			// 这里只有涉及名称和经办机构是用的模糊查询，但凡查询的日期都没有用between查询。如果有其他需要在更改。
			// 根据客户号查询custcd
			if (bCrmBaseInfo.getCustcd() != null && !"".equals(bCrmBaseInfo.getCustcd())) {
				criteria.andCustcdEqualTo(bCrmBaseInfo.getCustcd());
			}
			// 根据核心客户号查询custno
			if (bCrmBaseInfo.getCustno() != null && !"".equals(bCrmBaseInfo.getCustno())) {
				criteria.andCustnoEqualTo(bCrmBaseInfo.getCustno());
			}
			// 根据客户名称查询cname
			if (bCrmBaseInfo.getCname() != null && !"".equals(bCrmBaseInfo.getCname())) {
				criteria.andCnameLike("%" + bCrmBaseInfo.getCname() + "%");
			}
			// 根据客户类型查询custType
			if (bCrmBaseInfo.getCustType() != null && !"".equals(bCrmBaseInfo.getCustType())) {
				criteria.andCustTypeEqualTo(bCrmBaseInfo.getCustType());
			}
			// 证件类型 idtype
			if (bCrmBaseInfo.getIdtype() != null && !"".equals(bCrmBaseInfo.getIdtype())) {
				criteria.andIdtypeEqualTo(bCrmBaseInfo.getIdtype());
			}
			// 根据证件号码查询idno
			if (bCrmBaseInfo.getIdno() != null && !"".equals(bCrmBaseInfo.getIdno())) {
				criteria.andIdnoEqualTo(bCrmBaseInfo.getIdno());
			}
			// 客户英文名ename
			if (bCrmBaseInfo.getEname() != null && !"".equals(bCrmBaseInfo.getEname())) {
				criteria.andEnameLike("%" + bCrmBaseInfo.getEname() + "%");
			}
			// 客户别名aliasName
			if (bCrmBaseInfo.getAliasName() != null && !"".equals(bCrmBaseInfo.getAliasName())) {
				criteria.andAliasNameLike("%" + bCrmBaseInfo.getAliasName() + "%");
			}
			// 组织机构代码orgCode
			if (bCrmBaseInfo.getOrgCode() != null && !"".equals(bCrmBaseInfo.getOrgCode())) {
				criteria.andOrgCodeEqualTo(bCrmBaseInfo.getOrgCode());
			}
			// 社会信用代码socCreditNo
			if (bCrmBaseInfo.getSocCreditNo() != null && !"".equals(bCrmBaseInfo.getSocCreditNo())) {
				criteria.andSocCreditNoEqualTo(bCrmBaseInfo.getSocCreditNo());
			}
			// 营业执照注册号licenseNo
			if (bCrmBaseInfo.getLicenseNo() != null && !"".equals(bCrmBaseInfo.getLicenseNo())) {
				criteria.andLicenseNoEqualTo(bCrmBaseInfo.getLicenseNo());
			}
			// 营业执照到期日licenseDate
			if (bCrmBaseInfo.getLicenseDate() != null && !"".equals(bCrmBaseInfo.getLicenseDate())) {
				criteria.andLicenseDateEqualTo(bCrmBaseInfo.getLicenseDate());
			}
			// 客户状态custStatus
			if (bCrmBaseInfo.getCustStatus() != null && !"".equals(bCrmBaseInfo.getCustStatus())) {
				criteria.andCustStatusEqualTo(bCrmBaseInfo.getCustStatus());
			}
			// 是否核心厂商coreFlag
			if (bCrmBaseInfo.getCoreFlag() != null && !"".equals(bCrmBaseInfo.getCoreFlag())) {
				criteria.andCoreFlagEqualTo(bCrmBaseInfo.getCoreFlag());
			}
			// 根据是否是监管客户查询moniFlag
			if (bCrmBaseInfo.getMoniFlag() != null && !"".equals(bCrmBaseInfo.getMoniFlag())) {
				criteria.andMoniFlagEqualTo(bCrmBaseInfo.getMoniFlag());
			}
			// 是否期货经纪公司futuresFlag
			if (bCrmBaseInfo.getFuturesFlag() != null && !"".equals(bCrmBaseInfo.getFuturesFlag())) {
				criteria.andFuturesFlagEqualTo(bCrmBaseInfo.getFuturesFlag());
			}
			// 是否金融租赁公司flcFlag
			if (bCrmBaseInfo.getFlcFlag() != null && !"".equals(bCrmBaseInfo.getFlcFlag())) {
				criteria.andFlcFlagEqualTo(bCrmBaseInfo.getFlcFlag());
			}
			// 建档日期 createDate
			if (bCrmBaseInfo.getCreateDate() != null && !"".equals(bCrmBaseInfo.getCreateDate())) {
				criteria.andCreateDateEqualTo(bCrmBaseInfo.getCreateDate());
			}
			// 授信客户标识creditFlag
			if (bCrmBaseInfo.getCreditFlag() != null && !"".equals(bCrmBaseInfo.getCreditFlag())) {
				criteria.andCreditFlagEqualTo(bCrmBaseInfo.getCreditFlag());
			}
			// 黑名单标识blackFlag
			if (bCrmBaseInfo.getBlackFlag() != null && !"".equals(bCrmBaseInfo.getBlackFlag())) {
				criteria.andBlackFlagEqualTo(bCrmBaseInfo.getBlackFlag());
			}
			// 是否保险公司insureFlag
			if (bCrmBaseInfo.getInsureFlag() != null && !"".equals(bCrmBaseInfo.getInsureFlag())) {
				criteria.andInsureFlagEqualTo(bCrmBaseInfo.getInsureFlag());
			}
			// 根据是否是保理商查询factorFlag
			if (bCrmBaseInfo.getFactorFlag() != null && !"".equals(bCrmBaseInfo.getFactorFlag())) {
				criteria.andFactorFlagEqualTo(bCrmBaseInfo.getFactorFlag());
			}
			// 信贷客户号ccmsCustcd
			if (bCrmBaseInfo.getCcmsCustcd() != null && !"".equals(bCrmBaseInfo.getCcmsCustcd())) {
				criteria.andCcmsCustcdEqualTo(bCrmBaseInfo.getCcmsCustcd());
			}
			// 是否贸融重点客户importantFlag
			if (bCrmBaseInfo.getImportantFlag() != null && !"".equals(bCrmBaseInfo.getImportantFlag())) {
				criteria.andImportantFlagEqualTo(bCrmBaseInfo.getImportantFlag());
			}
			// 是否贸易对手commercialFalg
			if (bCrmBaseInfo.getCommercialFalg() != null && !"".equals(bCrmBaseInfo.getCommercialFalg())) {
				criteria.andCommercialFalgEqualTo(bCrmBaseInfo.getCommercialFalg());
			}
			// 是否境外overseasFlag
			if (bCrmBaseInfo.getOverseasFlag() != null && !"".equals(bCrmBaseInfo.getOverseasFlag())) {
				criteria.andOverseasFlagEqualTo(bCrmBaseInfo.getOverseasFlag());
			}
			// 是否是本行客户banksCustFlag
			if (bCrmBaseInfo.getBanksCustFlag() != null && !"".equals(bCrmBaseInfo.getBanksCustFlag())) {
				criteria.andBanksCustFlagEqualTo(bCrmBaseInfo.getBanksCustFlag());
			}
			// 是否是EF进口商efBuyerFlag
			if (bCrmBaseInfo.getEfBuyerFlag() != null && !"".equals(bCrmBaseInfo.getEfBuyerFlag())) {
				criteria.andEfBuyerFlagEqualTo(bCrmBaseInfo.getEfBuyerFlag());
			}
			// 是否是IF出口商ifSellerFlag
			if (bCrmBaseInfo.getIfSellerFlag() != null && !"".equals(bCrmBaseInfo.getIfSellerFlag())) {
				criteria.andIfSellerFlagEqualTo(bCrmBaseInfo.getIfSellerFlag());
			}
			// 是否是银行 isBank
			if (bCrmBaseInfo.getIsBank() != null && !"".equals(bCrmBaseInfo.getIsBank())) {
				criteria.andIsBankEqualTo(bCrmBaseInfo.getIsBank());
			}
			// FCI代号 fciCode
			if (bCrmBaseInfo.getFciCode() != null && !"".equals(bCrmBaseInfo.getFciCode())) {
				criteria.andFciCodeEqualTo(bCrmBaseInfo.getFciCode());
			}
			// 是否国际保理客户isIntl
			if (bCrmBaseInfo.getIsIntl() != null && !"".equals(bCrmBaseInfo.getIsIntl())) {
				criteria.andIsIntlEqualTo(bCrmBaseInfo.getIsIntl());
			}
			// 经办机构brcode
			if (bCrmBaseInfo.getBrcode() != null && !"".equals(bCrmBaseInfo.getBrcode())) {
				criteria.andBrcodeLike("%" + bCrmBaseInfo.getBrcode() + "%");
			}
			// 创建人tlrcd
			if (bCrmBaseInfo.getTlrcd() != null && !"".equals(bCrmBaseInfo.getTlrcd())) {
				criteria.andTlrcdEqualTo(bCrmBaseInfo.getTlrcd());
			}
			// 创建时间 crtTime
			if (bCrmBaseInfo.getCrtTime() != null && !"".equals(bCrmBaseInfo.getCrtTime())) {
				criteria.andCrtTimeEqualTo(bCrmBaseInfo.getCrtTime());
			}
			// 最后更新操作员 lastUpdTlrcd
			if (bCrmBaseInfo.getLastUpdTlrcd() != null && !"".equals(bCrmBaseInfo.getLastUpdTlrcd())) {
				criteria.andLastUpdTlrcdEqualTo(bCrmBaseInfo.getLastUpdTlrcd());
			}
			// 最后更新时间 lastUpdTime
			if (bCrmBaseInfo.getLastUpdTime() != null && !"".equals(bCrmBaseInfo.getLastUpdTime())) {
				criteria.andLastUpdTimeEqualTo(bCrmBaseInfo.getLastUpdTime());
			}
			// 管户员(mgrno)
			if (bCrmBaseInfo.getMgrno() != null && !"".equals(bCrmBaseInfo.getMgrno())) {
				criteria.andMgrnoEqualTo(bCrmBaseInfo.getMgrno());
			}
		}
		try {
			p.setRecords(iBCrmBaseInfoDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("（下拉框）条件分页查询客户信息失败！");
			throw new ScubeBizException("（下拉框）条件分页查询客户信息失败！", e);
		}
	}

	// 变更核心厂商状态
	@Override
	@Transactional
	public int updataCoreCustStatus(BCrmBaseInfo value) {
		// 这里，只要有对应的合同记录，就不可以将对应的核心厂商状态修改为无效。先不考虑有无效的合同的状况。
		// 1.校验数据
		if (value == null || "".equals(value)) {
			throw new ScubeBizException("前台页面所传数据无效！");
		}
		String custcd = value.getCustcd();
		if (custcd == null || "".equals(custcd)) {
			throw new ScubeBizException("前台页面所传数据无效！");
		}
		Boolean flag = true;
		// 存货类 对应字段是 gutId 担保人编号
		BCrrGntyConExample bCrrGntyConExample = new BCrrGntyConExample();
		bCrrGntyConExample.createCriteria().andGutIdEqualTo(custcd);
		try {
			List<BCrrGntyCon> bCrrGntyConList = bcrrgntycondao.selectByExample(bCrrGntyConExample);
			if (bCrrGntyConList != null && bCrrGntyConList.size() > 0) {
				flag = false;
			}
		} catch (Exception e) {
			throw new ScubeBizException("变更核心厂商状态失败！");
		}

		// 预付类
		if (flag) {
			BCntMprotPartInfoExample bCntMprotPartInfoExample = new BCntMprotPartInfoExample();
			bCntMprotPartInfoExample.createCriteria().andCustcdEqualTo(custcd);
			try {
				List<BCntMprotPartInfo> bCntMprotBaseInfoList = iBCntMprotPartInfoDAO.selectByExample(bCntMprotPartInfoExample);
				if (bCntMprotBaseInfoList != null && bCntMprotBaseInfoList.size() > 0) {
					flag = false;
				}
			} catch (Exception e) {
				throw new ScubeBizException("变更核心厂商状态失败！");
			}
		}

		// 应收类这里要区分买方，卖方，这里实际上要查两张边iBCntDebtInfoDAO, iBCntDebtExtInfoDAO
		if (flag) {
			BCntDebtInfoExample bCntDebtInfoExample = new BCntDebtInfoExample();
			bCntDebtInfoExample.createCriteria().andCustcdEqualTo(custcd);
			try {
				List<com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo> list1 = iBCntDebtInfoDAO.selectByExample(bCntDebtInfoExample);
				if (list1 != null && list1.size() > 0) {
					flag = false;
				}
				if (flag) {
					BCntDebtExtInfoExample bCntDebtExtInfoExample = new BCntDebtExtInfoExample();
					bCntDebtExtInfoExample.createCriteria().andBuyerCustcdEqualTo(custcd);
					List<BCntDebtExtInfo> bCntDebtExtInfoList = iBCntDebtExtInfoDAO.selectByExample(bCntDebtExtInfoExample);
					if (bCntDebtExtInfoList != null && bCntDebtExtInfoList.size() > 0) {
						flag = false;
					}
				}
			} catch (Exception e) {
				throw new ScubeBizException("变更核心厂商状态失败！");
			}
		}

		if (flag) {// 如果是都查询不到，就修改对应的状态为无效
			value.setCustStatus("00");// 客户状态设置为无效
			try {
				this.updataBCrmO(value);
			} catch (Exception e) {
				throw new ScubeBizException("变更核心厂商状态失败！");
			}
			return 1;
		} else {
			throw new ScubeBizException("此核心厂商已涉及业务，不可改为无效状态！");
		}

	}

	// 只保存修改的BCrmBaseInfo信息，不保存对应的企业信息
	@Override
	@Transactional
	public void updataBCrmO(BCrmBaseInfo value) {
		// 1.校验前台数据
		if (value == null || "".equals(value)) {
			throw new ScubeBizException("前台所传数据无效！");
		}
		// 2.修改客户信息
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo();
		BeanUtils.copyProperties(value, bCrmBaseInfo2);
		BCrmBaseInfoExample bbie = new BCrmBaseInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample.Criteria cri = bbie.createCriteria();
		if (bCrmBaseInfo2.getCustcd() != null && !"".equals(bCrmBaseInfo2.getCustcd())) {
			cri.andCustcdEqualTo(bCrmBaseInfo2.getCustcd());
		} else {
			throw new ScubeBizException("变更核心厂商状态失败！");
		}
		UserInfo user = ContextHolder.getUserInfo();
		String userId = user.getTlrNo();
		bCrmBaseInfo2.setLastUpdTlrcd(userId); // 最后更新人
		bCrmBaseInfo2.setLastUpdTime(new Date());// 最后更新时间
		BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
		String brcode = bctlVO.getBrNo();
		bCrmBaseInfo2.setLastUpdBrcode(brcode);// 设置最后更新机构
		try {
			iBCrmBaseInfoDAO.updateByExample(bCrmBaseInfo2, bbie);
		} catch (Exception e) {
			throw new ScubeBizException("变更核心厂商状态失败！");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.crm.service.IBCrmBaseInfoService#checkCustomerSelect(
	 * com.huateng.scf.bas.crm.model.BCrmBaseInfo)
	 */
	@Override
	public int checkCustomerForSelect(BCrmBaseInfo value) {
		BCrmBaseInfoExample example = new BCrmBaseInfoExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCnameEqualTo(value.getCname());
		createCriteria.andCustcdEqualTo(value.getCustcd());
		int x = 0;
		try {
			List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> bCrmBaseInfoList = iBCrmBaseInfoDAO.selectByExample(example);
			if (bCrmBaseInfoList != null && bCrmBaseInfoList.size() == 1) {
				x = 1;
			}
		} catch (Exception e) {
			throw new ScubeBizException("条件查询具体客户失败！");
		}
		return x;

	}

	@Override
	public List<BCrmBaseInfo> queryByCondition(String mgrno) {
		BCrmBaseInfoExample example = new BCrmBaseInfoExample();
		BCrmBaseInfoExample.Criteria cri = example.createCriteria();
		cri.andMgrnoEqualTo(mgrno);
		List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> list = iBCrmBaseInfoDAO.selectByExample(example);
		List<BCrmBaseInfo> result = new ArrayList<BCrmBaseInfo>();
		if (list.size() > 0) {
			for (com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo baseInfo : list) {
				BCrmBaseInfo crmBaseInfo = new BCrmBaseInfo();
				BeanUtils.copyProperties(baseInfo, crmBaseInfo);
				result.add(crmBaseInfo);
			}
		}
		return result;
	}

	/*
	 * 根据客户号查询客户信息
	 */
	@Override
	public BCrmBaseInfo findBCrmBaseInfoByCustcd(String custcd) throws ScubeBizException {
		if (StringUtil.isEmpty(custcd)) {
			return null;
		}
		BCrmBaseInfoExample bCrmBaseInfoExample = new BCrmBaseInfoExample();
		BCrmBaseInfoExample.Criteria crea = bCrmBaseInfoExample.createCriteria();
		crea.andCustcdEqualTo(custcd);
		BCrmBaseInfo bCrmBaseInfo2 = new BCrmBaseInfo();
		List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> bCrmBaseInfoList = iBCrmBaseInfoDAO.selectByExample(bCrmBaseInfoExample);
		if (bCrmBaseInfoList != null && bCrmBaseInfoList.size() == 1) {
			BeanUtils.copyProperties(bCrmBaseInfoList.get(0), bCrmBaseInfo2);
		} else {
			return null;
		}
		return bCrmBaseInfo2;
	}

	/*@SuppressWarnings("unused")
	@Override
	public Page findBCrmTabByPage(int pageNo, int pageSize, BdDataDictionary bdDataDictionary) {
		//Page p = new Page(pageSize, pageNo, 0);
		bdDataDictionary.setSysCode("default");
		bdDataDictionary.setTeamCode("999");
		bdDataDictionary.setDictCode("custTagType");
		BdDataDictionaryExample example = new BdDataDictionaryExample();
		com.huateng.data.model.BdDataDictionaryExample.Criteria cri = example.createCriteria();
		
		if(bdDataDictionary != null && !"".equals(bdDataDictionary)){
			if(StringUtils.isNotEmpty(bdDataDictionary.getDataTrsVal())){
				cri.andDataTrsValLike("%"+bdDataDictionary.getDataTrsVal()+"%");
			}
		}
		Page p = null;
	    try {
	    p = bdDataDictService.findByPage(pageNo, pageSize, bdDataDictionary);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ScubeBizException("条件查询客户标签失败！",e);
		}
		return p;
	}*/

	@SuppressWarnings("unused")
	@Override
	public Page findBCrmTabByPage(int pageNo, int pageSize, String sysCode, String teamCode, String dictCode) {
		Page page = new Page(pageSize, pageNo, 0);
		sysCode = "default";
		teamCode = "999";
		dictCode = "custTagType";
		List<BdDataDictDto> list=bdDataDictService.getDataBySysTeamDictCode(sysCode, teamCode, dictCode);
		List<DataItem> dataItems = null;
		for (BdDataDictDto bdDataDictDto : list) {
			dataItems = bdDataDictDto.getDataItems();
		}
		page.setRecords(dataItems);
		return page;
	}

}
