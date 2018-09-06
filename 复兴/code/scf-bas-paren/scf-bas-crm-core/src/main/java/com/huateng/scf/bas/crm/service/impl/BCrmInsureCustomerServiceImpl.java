package com.huateng.scf.bas.crm.service.impl;

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
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.acc.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.service.IBAccAccountInfoService;
import com.huateng.scf.bas.brp.dao.IBBrpIndustryTypesDAO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.crm.constant.BCrmBaseConstants;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.IBCrmEntInfoDAO;
import com.huateng.scf.bas.crm.dao.IBCrmInsureCustomerDAO;
import com.huateng.scf.bas.crm.dao.IBCrmMoniEntInfoDAO;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfoExample;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample.Criteria;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmInsureInfo;
import com.huateng.scf.bas.crm.model.CustomerQryVO;
import com.huateng.scf.bas.crm.model.CustomerVO;
import com.huateng.scf.bas.crm.service.IBCrmInsureCustomerService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BCrmInsureCustomerServiceImpl")
public class BCrmInsureCustomerServiceImpl implements IBCrmInsureCustomerService {
	
	@Resource(name="IBCrmInsureCustomerDAO")
	IBCrmInsureCustomerDAO bCrmInsureCustomerDAO;
		
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "bSysSerialNoService")
	IBSysSerialNoService bSysSerialNoService;
	
	@Resource(name = "IBCrmEntInfoDAO")
	IBCrmEntInfoDAO bCrmEntInfoDAO;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bCrmBaseInfoDAO;
	
	@Resource(name = "IBCrmMoniEntInfoDAO")
	IBCrmMoniEntInfoDAO bCrmMoniEntInfoDAO;
	
	@Autowired
	ScubeUserService scubeUserService;
		
	@Resource(name="IBAccAccountInfoServiceImpl")
	IBAccAccountInfoService bAccAccountInfoService;
	
	@Resource(name="BBrpIndustryTypesDAO")
	IBBrpIndustryTypesDAO bBrpIndustryTypesDAO;
	 

	@Override
	public Page findInsureCustomerByPage(CustomerQryVO customerQryVO,int pageNo,int pageSize)throws ScubeBizException {
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotEmpty(customerQryVO.getCustType_Q())){
//			params.put("custType", ScfBasConstant.CUST_TYPE_CORP);
			params.put("custType", customerQryVO.getCustType_Q());
		}
		
		if(StringUtils.isNotEmpty(customerQryVO.getInsureFlag_Q())){
//			params.put("insureFlag", ScfBasConstant.FLAG_ON);
			params.put("insureFlag", customerQryVO.getInsureFlag_Q());
		}
		
		if(StringUtils.isNotEmpty(customerQryVO.getFactorFlag_Q())){
			params.put("factorFlag", customerQryVO.getFactorFlag_Q());
		}
		
		if(StringUtils.isNotEmpty(customerQryVO.getOverseasFlag_Q())){
			params.put("overseasFlag", customerQryVO.getOverseasFlag_Q());
		}
		
		if(StringUtils.isNotEmpty(customerQryVO.getCustno_Q())){
			params.put("custno", customerQryVO.getCustno_Q());
		}
		if(StringUtils.isNotEmpty(customerQryVO.getCname_Q())){
			params.put("cname", customerQryVO.getCname_Q());
		}
		if(StringUtils.isNotEmpty(customerQryVO.getCustStatus_Q())){
			params.put("custStatus", customerQryVO.getCustStatus_Q());
		}
		
		Page pageResult = new Page();
		
		try {
			List<BCrmInsureInfo> list = bCrmInsureCustomerDAO.queryInsureCustomerByParams(params, pageNo, pageSize);
			int totalRecord = bCrmInsureCustomerDAO.queryInsureCustomerCount(params);
			List<BCrmInsureInfo> responses = new ArrayList<BCrmInsureInfo>();
			BCrmInsureInfo respElement = null;
			for(BCrmInsureInfo insureInfo:list){
				respElement = new BCrmInsureInfo();
				BeanUtils.copyProperties(insureInfo, respElement);
				com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes industryTypes = bBrpIndustryTypesDAO.selectByPrimaryKey(respElement.getIndustryType());
				String industryTypeName=industryTypes.getIndustryName();
				respElement.setIndustryTypeName(industryTypeName);
				responses.add(respElement);
			}
			pageResult.setPageNo(pageNo);
			pageResult.setPageSize(pageSize);
			pageResult.setRecords(responses);
			pageResult.setTotalRecord(totalRecord);
		} catch (Exception e) {
			String errormsg="保险公司列表信息查询失败";
			log.error(errormsg);
			throw new  ScubeBizException(errormsg,e);
		}
		return pageResult;
	}
	
	
	/**
	 * @return 生成16为数
	 */
	@Override
	public String generateCcmsCustcd() throws ScubeBizException{
		String ccmsCustcd =bSysSerialNoService.genSerialNo(BCrmBaseConstants.CCMS_CUSTCD);
//		String format = "yyyyMMddHHmmss";//14位
//		String ccmsCustcd = ScfDateUtil.formatDate(new Date(), format)+RandomUtils.nextLong(10, 99);
		return ccmsCustcd;
	}
	
	
	/**
	 * @param customerVO
	 * @return
	 */
	@Transactional
	@Override
	public CustomerVO addOrUpdateCustomer(CustomerVO customerVO) throws ScubeBizException {
		
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo tblCustBaseInfo = new com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo();
		com.huateng.scf.bas.crm.dao.model.BCrmEntInfo tblCustEntInfo = new com.huateng.scf.bas.crm.dao.model.BCrmEntInfo();
		com.huateng.authority.entity.UserInfo  gb =ContextHolder.getUserInfo();		
		
		//新增客户信息
		if(StringUtils.isEmpty(customerVO.getCustcd())){
			
			BeanUtils.copyProperties(customerVO, tblCustBaseInfo);
			BeanUtils.copyProperties(customerVO, tblCustEntInfo);

			if(StringUtils.isNotEmpty(customerVO.getOrgCode())){
				if(checkOrgCodeIsExist(customerVO.getOrgCode())){
					String message ="组织机构代码【"+ customerVO.getOrgCode() + "】已经存在，请重新输入！";
					log.error(message);
					throw new ScubeBizException(message);
				}
			}
			if(StringUtils.isNotEmpty(customerVO.getCustno())){
				if(checkCustnoIsExist(customerVO.getCustno())){
					String message ="客户号【"+ customerVO.getCustno() + "】已经存在，请重新输入！";
					log.error(message);
					throw new ScubeBizException(message);
				}
			}
			
			String custcd = bSysSerialNoService.genSerialNo(BCrmBaseConstants.BAS_CUST_CD);// 客户流水号
			tblCustBaseInfo.setCustcd(custcd);
			tblCustEntInfo.setCustcd(custcd);
			customerVO.setCustcd(custcd);
			
			tblCustBaseInfo.setCustStatus(ScfBasConstant.CUST_STATUS_VALID);
			tblCustBaseInfo.setCustType(ScfBasConstant.CUST_TYPE_CORP);
			tblCustBaseInfo.setCreateDate(ScfDateUtil.formatDate(new Date()));
			tblCustBaseInfo.setTlrcd(gb.getTlrNo());
			tblCustBaseInfo.setCrtTime(new Date());
			tblCustBaseInfo.setBrcode(gb.getBrNo());//所属机构
			tblCustBaseInfo.setLastUpdTime(new Date());
			tblCustBaseInfo.setLastUpdTlrcd(gb.getTlrNo());
			tblCustBaseInfo.setLastUpdBrcode(gb.getBrNo());//所属机构
			
			if(StringUtils.isEmpty(customerVO.getFeature1()) && "common".equals(customerVO.getFeature1())){
				tblCustBaseInfo.setCreditFlag(ScfBasConstant.FLAG_ON);//授信客户
			}
			//若是核心厂商
			if(StringUtils.isEmpty(customerVO.getFeature1()) && "core".equals(customerVO.getFeature1())){
				tblCustBaseInfo.setCoreFlag(ScfBasConstant.FLAG_ON);//核心厂商
			}
			//若是贸易对手
			if(StringUtils.isEmpty(customerVO.getFeature1()) && "Commercial".equals(customerVO.getFeature1())){
				tblCustBaseInfo.setCommercialFalg(ScfBasConstant.FLAG_ON);//交易对手
			}
			//add by huabin.zhong 如果核心客户号CUSTNO为空，则赋CUSTCD begin
			if (StringUtils.isEmpty(tblCustBaseInfo.getCustno())){
				tblCustBaseInfo.setCustno(tblCustBaseInfo.getCustcd());
			}

			bCrmBaseInfoDAO.insertSelective(tblCustBaseInfo);
			bCrmEntInfoDAO.insertSelective(tblCustEntInfo);
		
		} else{
			String custcd =customerVO.getCustcd();
			tblCustBaseInfo = bCrmBaseInfoDAO.selectById(custcd);
			if(tblCustBaseInfo!=null){				
				BeanUtils.copyProperties(customerVO, tblCustBaseInfo);
				tblCustBaseInfo.setBrcode(tblCustBaseInfo.getBrcode());
				tblCustBaseInfo.setMgrno(tblCustBaseInfo.getMgrno());
				tblCustBaseInfo.setLastUpdTlrcd(gb.getTlrNo());
				tblCustBaseInfo.setLastUpdTime(new Date());
				tblCustBaseInfo.setCustStatus(ScfBasConstant.CUST_STATUS_VALID); //客户状态：01-有效
				tblCustBaseInfo.setCustType(ScfBasConstant.CUST_TYPE_CORP); //法人
				//监管公司信息处理：不是监管公司时删除监管公司独有信息
				if(ScfBasConstant.FLAG_OFF.equals(customerVO.getMoniFlag())){
					tblCustBaseInfo.setCreateDate(null);//建档日期
				}
				//期货经纪公司处理：不是期货经纪公司时删除期货经纪公司独有信息
				if(ScfBasConstant.FLAG_OFF.equals(customerVO.getFuturesFlag())){
					tblCustBaseInfo.setLicenseDate(null);//营业执照到期日
					tblCustBaseInfo.setOpenDate(null);//开户日期
					tblCustBaseInfo.setCoreOpenDate(null);//核心开户日期
				}
				BCrmBaseInfoExample example = new BCrmBaseInfoExample();
				Criteria criteria = example.createCriteria();
				criteria.andCustcdEqualTo(custcd);
				bCrmBaseInfoDAO.updateByExampleSelective(tblCustBaseInfo, example);
				
				tblCustEntInfo= bCrmEntInfoDAO.selectByPrimaryKey(customerVO.getCustcd());
				if(tblCustEntInfo!=null){
					BeanUtils.copyProperties(customerVO,tblCustEntInfo);
					//监管公司信息处理：不是监管公司时删除监管公司独有信息
					if(ScfBasConstant.FLAG_OFF.equals(customerVO.getMoniFlag())){
						tblCustEntInfo.setDescription(null);
					}
					//期货经纪公司处理：不是期货经纪公司时删除期货经纪公司独有信息
					if(ScfBasConstant.FLAG_OFF.equals(customerVO.getFuturesFlag())){
						tblCustEntInfo.setEnterpriseType(null);//企业类型
						tblCustEntInfo.setLegal(null);//法定代表人
						tblCustEntInfo.setPostCode(null);//注册地址邮政编码
						//tblCustEntInfo.setContactName(null);//联系人
						tblCustEntInfo.setBaseActBank(null);//基本帐户开户行
						tblCustEntInfo.setBaseActno(null);//基本帐户帐号
					}
					
					BCrmEntInfoExample bCrmEntInfoExample =new BCrmEntInfoExample();
					com.huateng.scf.bas.crm.dao.model.BCrmEntInfoExample.Criteria bCrmEntInfoCriteria = bCrmEntInfoExample.createCriteria();
					bCrmEntInfoCriteria.andCustcdEqualTo(custcd);
					bCrmEntInfoDAO.updateByExampleSelective(tblCustEntInfo, bCrmEntInfoExample);
				}
			}
		}
		return customerVO;
		
	}
	
	@Override
	public CustomerVO findCustomerInfoDetails(CustomerQryVO customerQryVO){
		String custcd=customerQryVO.getCustcd();
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo = null;
		if(StringUtils.isNotBlank(custcd)){			
			bCrmBaseInfo = bCrmBaseInfoDAO.selectById(custcd);
		}
		BCrmEntInfo bCrmEntInfo = null;
		if(bCrmBaseInfo!=null){
			bCrmEntInfo = bCrmEntInfoDAO.selectByPrimaryKey(custcd);
		}
		
		CustomerVO customerVO = new CustomerVO();
		if(StringUtils.isNotEmpty(bCrmBaseInfo.getBrcode())){
			BctlVO bctlvo =scubeUserService.selectBctlByBrNo(bCrmBaseInfo.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			String brName = bctlvo.getBrName();
			bCrmBaseInfo.setBrName(brName);
		}
		
		if(StringUtils.isNotEmpty(bCrmBaseInfo.getTlrcd())){
			UserInfo userinfo =scubeUserService.selectUserByTlrNo(bCrmBaseInfo.getTlrcd(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			String tlrName = userinfo.getTlrName();
			bCrmBaseInfo.setTlrName(tlrName);
		}
		
		if(bCrmBaseInfo!=null){			
			BeanUtils.copyProperties(bCrmBaseInfo, customerVO);
		}

		if(bCrmEntInfo!=null){
			BeanUtils.copyProperties(bCrmEntInfo, customerVO);
		}
		
		com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes industryTypes = null;
		if(StringUtils.isNotBlank(bCrmEntInfo.getIndustryType())){			
			 industryTypes =bBrpIndustryTypesDAO.selectByPrimaryKey(customerVO.getIndustryType());
		}
		customerVO.setIndustryTypeName(industryTypes.getIndustryName());
		return customerVO;
	}

	
	public boolean checkOrgCodeIsExist(String orgCode){
		BCrmBaseInfoExample example = new BCrmBaseInfoExample();
		Criteria creteria = example.createCriteria();
		creteria.andOrgCodeEqualTo(orgCode);
		List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> list = bCrmBaseInfoDAO.selectByExample(example);
		
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	
	public boolean checkCustnoIsExist(String custno){
		BCrmBaseInfoExample example = new BCrmBaseInfoExample();
		Criteria creteria = example.createCriteria();
		creteria.andCustnoEqualTo(custno);
		List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> list = bCrmBaseInfoDAO.selectByExample(example);
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public BCrmBaseInfo findBCrmBaseInfoByKey(com.huateng.scf.bas.crm.model.BCrmBaseInfo bCrmBaseInfo) {
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
				List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> bCrmBaseInfos = bCrmBaseInfoDAO
						.selectByExample(bbie);
				if (bCrmBaseInfos != null && bCrmBaseInfos.size() == 1) {
					com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo1 = bCrmBaseInfos.get(0);
					BeanUtils.copyProperties(bCrmBaseInfo1, bCrmBaseInfo2);
				} else {
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("条件查询客户基本信息失败！");
			}
//			if (bCrmBaseInfo2 != null && !"".equals(bCrmBaseInfo2)) {
//				// 翻译，创建人tlrcd，最后更新操作员lastUpdTlrcd，经办机构brcode，最后更新经办机构lastUpdBrcode				
//				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(bCrmBaseInfo2.getBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
//				UserInfo userInfo = scubeUserService.selectUserByTlrNo(bCrmBaseInfo2.getTlrcd(),ScfCommonUtil.getBrManagerNo(scubeUserService));
//
//				if(userInfo!=null&&StringUtils.isNotEmpty(userInfo.getTlrName())){
//					bCrmBaseInfo2.setTlrName(userInfo.getTlrName());
//					// 最后更新操作员lastUpdTlrName
//					bCrmBaseInfo2.setLastUpdTlrName(userInfo.getTlrName());
//				}
//				
//				if(bctlVO!=null&&StringUtils.isNotEmpty(bctlVO.getBrName())){
//					// 经办机构brName
//					bCrmBaseInfo2.setBrName(bctlVO.getBrName());
//					// 最后更新经办机构lastUpdBrName
//					bCrmBaseInfo2.setLastUpdBrName(bctlVO.getBrName());;
//				}
//				
//			}
			return bCrmBaseInfo2;

		} else {// 当传过来的对象就是null的时候，就返回null，与其他两个查询方法区别下。
			return null;
		}
	}
	
	public BCrmInsureInfo findBCrmInsureInfoByKey(){
		return null;
	}

	
	@Override
	public BAccAccountInfo findBAccAccountInfo() {
		BAccAccountInfo bAccAccountInfoReps = new BAccAccountInfo();

		BctlVO BctlVO = ContextHolder.getOrgInfo();
		UserInfo UserInfo = ContextHolder.getUserInfo();
		BctlVO bctlVOOther = scubeUserService.selectBctlByBrNo(BctlVO.getBrNo(),ScfCommonUtil.getBrManagerNo(scubeUserService));
		UserInfo userInfoOther = scubeUserService.selectUserByTlrNo(UserInfo.getTlrNo(),ScfCommonUtil.getBrManagerNo(scubeUserService));
		
		bAccAccountInfoReps.setBrcode(bctlVOOther.getBrNo());
		bAccAccountInfoReps.setTlrcd(userInfoOther.getTlrNo());
		bAccAccountInfoReps.setMgrno(userInfoOther.getTlrNo());
		
		bAccAccountInfoReps.setBrName(bctlVOOther.getBrName());
		bAccAccountInfoReps.setTlrName(userInfoOther.getTlrName());	
		bAccAccountInfoReps.setMgrName(userInfoOther.getTlrName());
		
		

		return bAccAccountInfoReps;
	}

	@Override
	public CustomerVO findCustomerInfoByKey(BCrmBaseInfo bCrmBaseInfo) {
		BCrmBaseInfo bCrmBaseInfoResult = this.findBCrmBaseInfoByKey(bCrmBaseInfo);
		CustomerVO  customerVO = null;
		com.huateng.authority.entity.UserInfo  gb =ContextHolder.getUserInfo();	
		if(bCrmBaseInfoResult!=null){			
			String custcd = bCrmBaseInfoResult.getCustcd();
			CustomerQryVO customerQryVO = new CustomerQryVO();
			
			if(StringUtils.isNotEmpty(custcd)){			
				customerQryVO.setCustcd(custcd);
				customerVO=this.findCustomerInfoDetails(customerQryVO);
			}
		}else{
			customerVO = new CustomerVO();
			String tlrNo = gb.getTlrNo();
			String brNo = gb.getBrNo();
			BctlVO bctlVO = scubeUserService.selectBctlByBrNo(brNo, ScfCommonUtil.getBrManagerNo(scubeUserService));
			UserInfo userInfo=scubeUserService.selectUserByTlrNo(tlrNo, ScfCommonUtil.getBrManagerNo(scubeUserService));
			customerVO.setTlrName(userInfo.getTlrName());
			customerVO.setBrName(bctlVO.getBrName());
			customerVO.setCcmsCustcd(this.generateCcmsCustcd());
		}
		return customerVO;
	}

	@Override
	public String addOrUpdateBaccAcct(BAccAccountInfo acctInfo){		
		String acctNo ="";
		BAccAccountInfo bAccAccountInfo =bAccAccountInfoService.findBAccAccountInfoByKey(acctInfo);
		if(bAccAccountInfo!=null){
			acctNo = bAccAccountInfo.getAccountNo();
		}
		if(StringUtils.isNotEmpty(acctNo)){
//			BAccAccountInfoExample example = new BAccAccountInfoExample();
//			com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample.Criteria criteria = example.createCriteria();
//			criteria.andAccountNoEqualTo(acctInfo.getAccountNo());
//			bAccAccountInfoDAO.updateByExampleSelective(acctInfo, example);
			bAccAccountInfoService.update(acctInfo);
			acctNo =acctInfo.getAccountNo();
		}else{
			acctNo = bAccAccountInfoService.add(acctInfo);
		}
		return acctNo;
		
	}

}
