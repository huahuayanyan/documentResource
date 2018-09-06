/**
 * 
 */
package com.huateng.scf.bas.icr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.OrgService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.adv.bcp.service.IABcpAppliImprestBussService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CreditOptFieldMap;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.icr.constant.BIcrConstant;
import com.huateng.scf.bas.icr.constant.BIcrErrorConstant;
import com.huateng.scf.bas.icr.dao.IBIcrAppliInfoDAO;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrInfoExample;
import com.huateng.scf.bas.icr.dao.model.BIcrInfoExample.Criteria;
import com.huateng.scf.bas.icr.model.BIcrAppliBrcodeList;
import com.huateng.scf.bas.icr.model.BIcrAppliInfo;
import com.huateng.scf.bas.icr.model.BIcrBrcodeList;
import com.huateng.scf.bas.icr.model.BIcrDtl;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.BIcrType;
import com.huateng.scf.bas.icr.model.CommonCreditProcessBussAmtVO;
import com.huateng.scf.bas.icr.model.CreditInterParamBean;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.bas.icr.service.IBIcrAppliBrcodeListService;
import com.huateng.scf.bas.icr.service.IBIcrAppliInfoService;
import com.huateng.scf.bas.icr.service.IBIcrBrcodeListService;
import com.huateng.scf.bas.icr.service.IBIcrDtlService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.icr.service.IBIcrTypeService;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.service.IBPrdCreditBindService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月3日下午4:48:23
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月3日下午4:48:23	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BIcrInfoServiceImpl")
public class BIcrInfoServiceImpl implements IBIcrInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BIcrInfoDAO")
	IBIcrInfoDAO iBIcrInfoDAO;
	@Resource(name = "BSysSerialNoServiceImpl")
	private  IBSysSerialNoService bSysSerialNoService;
	@Resource(name = "orgService")
	OrgService orgService;
	/*@Resource(name = "userService")
	UserService userService;*/
	@Resource(name = "BIcrTypeServiceImpl")
	private IBIcrTypeService  bIcrTypeService;
	
	@Resource(name = "BIcrAppliInfoSrviceImpl")
	private IBIcrAppliInfoService  bIcrAppliInfoService;
	
	@Resource(name = "BCrmBaseInfoServiceImpl")
	private IBCrmBaseInfoService  bCrmBaseInfoService;
	@Resource(name = "BIcrAppliInfoDAO")
	IBIcrAppliInfoDAO bIcrAppliInfoDAO;
	
	@Resource(name = "BIcrAppliBrcodeListServiceImpl")
	IBIcrAppliBrcodeListService bIcrAppliBrcodeListService;
	@Resource(name = "BIcrBrcodeListServiceImpl")
	IBIcrBrcodeListService bIcrBrcodeListService;
	@Resource(name = "BIcrDtlServiceImpl")
	IBIcrDtlService bBIcrDtlService;
	
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	
	
	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;//业务申请表
	@Resource(name = IBLanLnciBaseService.BEAN_ID)
	IBLanLnciBaseService bLanLnciBaseService; //借据基本信息
	@Resource(name = IABcpAppliImprestBussService.BEAN_ID)
	IABcpAppliImprestBussService aBcpAppliImprestBussService;
	
	@Resource(name = "BPrdCreditBindServiceImpl")
	private IBPrdCreditBindService  bPrdCreditBindService;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO bLanAppliLnciBaseDAO;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	private static final String CUSTCD = "custcd"; 
	private static final String CREDITTYPE="creditType";
	private static final String STATUS="status";
	private static final String OTHERCUSTCD = "otherCustcd"; 

	@Override
	@Transactional
	public void addBIcrInfo(BIcrInfo bicrInfo) throws ScubeBizException {
		ScfCommonUtil.setCommonField(bicrInfo);//设置公共字段 a
		// 获取机构信息
		BctlVO BctlVO = ContextHolder.getOrgInfo();
		String brcode = BctlVO.getBrNo();
		bicrInfo.setBrcode(brcode);
		com.huateng.scf.bas.icr.dao.model.BIcrInfo bIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		try {
			BeanUtils.copyProperties(bicrInfo, bIcrInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		try {
			iBIcrInfoDAO.insert(bIcrInfodal);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("保存额度信息失败！");
			throw new ScubeBizException("保存额度信息失败！",BSysErrorConstant.SCF_BAS_ICR_40000);
		}
		
	}
	@Override
	@Transactional
	public int updateBIcrInfo(BIcrInfo bicrInfo) throws ScubeBizException{
		com.huateng.scf.bas.icr.dao.model.BIcrInfo bIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		try {
			BeanUtils.copyProperties(bicrInfo, bIcrInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		int i=0;
		try {
			i= iBIcrInfoDAO.updateByPrimaryKeySelective(bIcrInfodal);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("更新额度信息失败！");
			throw new ScubeBizException("更新额度信息失败！",e);
		}
		return i;
	}
	@Override
	@Transactional
	public int deleteBIcrInfo(String key) throws ScubeBizException{
		int i=0;		
		try {
			i= iBIcrInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("删除额度信息失败！");
			throw new ScubeBizException("删除额度信息失败！",e);
		}
		return i;
	}
	@Override
	@Transactional
	public int deleteByBIcrInfo(BIcrInfo bicrInfo) throws ScubeBizException {
		BIcrInfoExample example = new BIcrInfoExample();
		int i=0;
		if (bicrInfo != null) {
			Criteria criteria = example.createCriteria();
			//节点信息（）
			if(bicrInfo.getNodeType()!=null){
				criteria.andNodeTypeEqualTo(bicrInfo.getNodeType());
			}
			//上级额度编号分项额度列表
			if(bicrInfo.getUpCreditNo()!=null){
				criteria.andUpCreditNoEqualTo(bicrInfo.getUpCreditNo());
			}
			try {
				i= iBIcrInfoDAO.deleteByExample(example);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("删除额度信息失败！");
				throw new ScubeBizException("删除额度信息失败！",e);
			}
		}
		return i;
	}
	
	@Override
	public Page findBIcrInfoByPage(int pageNo, int pageSize, BIcrInfo bicrInfo) throws ScubeBizException{
		BIcrInfoExample example = new BIcrInfoExample();
		Page p = new Page(pageSize, pageNo, 0);
		//查询条件
		if (bicrInfo != null) {
			Criteria criteria = example.createCriteria();
			if(bicrInfo.getCname()!=null){ //客户名称
				
			}
			if (bicrInfo.getApprovalNo() != null) {
				criteria.andApprovalNoLike("%"+bicrInfo.getApprovalNo()+"%");
			}
			if(bicrInfo.getStatus()!=null){
				criteria.andStatusEqualTo(bicrInfo.getStatus());
			}
			//节点信息（额度列表，分项额度列表）
			if(bicrInfo.getNodeType()!=null){
				criteria.andNodeTypeEqualTo(bicrInfo.getNodeType());
			}
			//上级额度编号分项额度列表
			if(bicrInfo.getUpCreditNo()!=null){
				criteria.andUpCreditNoEqualTo(bicrInfo.getUpCreditNo());
			}
			
			
			//额度编号
			if(bicrInfo.getCreditNo()!=null){
				criteria.andCreditNoEqualTo(bicrInfo.getCreditNo());
			}
			//额度类型
			if(bicrInfo.getCreditClass()!=null){
				criteria.andCreditClassEqualTo(bicrInfo.getCreditClass());
			}
			//额度种类
			if(bicrInfo.getCreditType()!=null){
				criteria.andCreditTypeEqualTo(bicrInfo.getCreditType());
			}
			//买方
			if(bicrInfo.getCustcd()!=null){
				criteria.andCustcdEqualTo(bicrInfo.getCustcd());
			}
			//
			if(bicrInfo.getOtherCustcd()!=null){
				criteria.andOtherCustcdEqualTo(bicrInfo.getOtherCustcd());
			}
           if(bicrInfo.getStartDate()!=null){ //<=
        	   criteria.andStartDateLessThanOrEqualTo(bicrInfo.getStartDate());
           }
           if(bicrInfo.getEndDate()!=null){ //>=
        	   criteria.andEndDateGreaterThanOrEqualTo(bicrInfo.getEndDate());
           }
			
		p.setRecords(iBIcrInfoDAO.selectByPage(example, p));
		
		}
		return p;
	}
	@Override
	public BIcrInfo findBIcrInfoByKey(String key) throws ScubeBizException{
		// TODO Auto-generated method stub
		BIcrInfo bIcrInfo = new BIcrInfo();
		com.huateng.scf.bas.icr.dao.model.BIcrInfo  bIcrInfoDal = iBIcrInfoDAO.selectByPrimaryKey(key);
		if(bIcrInfoDal!=null){
			BeanUtils.copyProperties(bIcrInfoDal, bIcrInfo);	
		}
		return bIcrInfo;
	}
	
	@Override
	/**
	 * 查询额度列表
	 */
	public Page findBIcrInfoListByPage(int pageNo, int pageSize, BIcrInfo bicrInfo)throws ScubeBizException{
		bicrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_ROOT);
		Page page = new Page(pageSize, pageNo, 0);
		com.huateng.scf.bas.icr.dao.model.BIcrInfo bIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		try {
			BeanUtils.copyProperties(bicrInfo, bIcrInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		try {
			page.setRecords(iBIcrInfoDAO.selectListByPage(bIcrInfodal,page));	
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询额度信息异常！");
			throw new ScubeBizException("查询额度信息异常", e);
		}
		
		return page;
	}
	
	/**
	 * 获得新增额度信息的初始化信息
	 */
	@Override
	public BIcrInfo initBIcrInfo() throws ScubeBizException{
		// TODO Auto-generated method stub
		BIcrInfo bicrInfo = new BIcrInfo();
		 // 获取当前用户  
	    // UserInfo user = ContextHolder.getUserInfo(); 
	     //获取机构信息
	     BctlVO bctlVO = ContextHolder.getOrgInfo(); 
	     bicrInfo.setBrcode(bctlVO.getBrNo());
	     bicrInfo.setBrcodeName(bctlVO.getBrName());
	     //生成额度编号
	     String creditNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_INDIRECT_CREDIT_NO); 
	     bicrInfo.setUpCreditNo(creditNo);      
	     //获得机构集
	     List<BctlVO> listBctl = orgService.selectByExample(bctlVO);   
	     bicrInfo.setListBctl(listBctl);
		return bicrInfo;
	}
	/**
	 * 已领用生效额度列表
	 * @param pageNo
	 * @param pageSize
	 * @param creditNo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findBIcrDrawInfoByPage(int pageNo, int pageSize, String creditNo)throws ScubeBizException {
		// TODO Auto-generated method stub
		BIcrInfo bicrInfo = new BIcrInfo();
		bicrInfo.setUpCreditNo(creditNo);
		
		bicrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_SUB_LEAF);
		bicrInfo.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL);
		Page p = new Page(pageSize, pageNo, 0);
		if (bicrInfo != null) {
			com.huateng.scf.bas.icr.dao.model.BIcrInfo bicrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
			BeanUtils.copyProperties(bicrInfo, bicrInfodal);
			p.setRecords(iBIcrInfoDAO.selectDrawInfoListByCreditNo(bicrInfodal, p));	
		}
		return p;
		
	}
	
	/**
	 * 分项额度查询
	 */
	public Page findBIcrSubInfoByPage(int pageNo, int pageSize, String creditNo)throws ScubeBizException {
		// TODO Auto-generated method stub
		BIcrInfo bicrInfo = new BIcrInfo();
		bicrInfo.setUpCreditNo(creditNo);
		bicrInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
		bicrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
		Page p = new Page(pageSize, pageNo, 0);
		if (bicrInfo != null) {
			com.huateng.scf.bas.icr.dao.model.BIcrInfo bicrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
			BeanUtils.copyProperties(bicrInfo, bicrInfodal);
			p.setRecords(iBIcrInfoDAO.selectSubInfoList(bicrInfodal, p));
			//处理适用机构的名称
			if(p!=null&&p.getTotalRecord()>0){
				Iterator<?> iter=p.getRecords().iterator();
				List<BIcrInfo> creditList=new ArrayList<BIcrInfo>();
				while(iter.hasNext()){
					com.huateng.scf.bas.icr.dao.model.BIcrInfo row =(com.huateng.scf.bas.icr.dao.model.BIcrInfo) iter.next();
					BIcrInfo bIcrInfoVo = new BIcrInfo();
					BeanUtils.copyProperties(row, bIcrInfoVo);
					String suitbrName =getSuitBrNameBySuitBrcode(bIcrInfoVo.getSuitBrcode());
					bIcrInfoVo.setSuitbrName(suitbrName);
					creditList.add(bIcrInfoVo);
				}
				p.setRecords(creditList);
			}
			
		}
		return p;
		
	}
	@Override
	public BIcrInfo findBIcrInfoByCreditNo(String creditNo) throws ScubeBizException {
		com.huateng.scf.bas.icr.dao.model.BIcrInfo bicrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		bicrInfodal=iBIcrInfoDAO.selectByPrimaryKey(creditNo);
		BIcrInfo  bicrInfo = new BIcrInfo();
		BeanUtils.copyProperties(bicrInfodal, bicrInfo);
		 // 获取当前用户  
	     //UserInfo user = ContextHolder.getUserInfo(); 
	     //获取机构信息
	     BctlVO bctlVO = ContextHolder.getOrgInfo(); 
	     //间接额度编号
	     bicrInfo.setUpCreditNo(bicrInfo.getCreditNo());
	     bicrInfo.setBrcode(bctlVO.getBrNo());
	     bicrInfo.setBrcodeName(bctlVO.getBrName());
	     bicrInfo.setUpCreditAmount(bicrInfo.getCreditAmount());//间接额度总金额
	     bicrInfo.setUpCreditUsableAmount(bicrInfo.getCreditUsableAmount()); //可用余额
	     bicrInfo.setUpRemark(bicrInfo.getRemark()); //备注
	     String  custcd=  bicrInfo.getCustcd();
	     BCrmBaseInfo bCrmBaseInfo = new  BCrmBaseInfo();
	     bCrmBaseInfo.setCustcd(custcd);
	     bCrmBaseInfo =bCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
	     bicrInfo.setCname(bCrmBaseInfo.getCname());
	     //获得机构集
	     List<BctlVO> listBctl = orgService.selectByExample(bctlVO);
	     bicrInfo.setListBctl(listBctl); 
		return bicrInfo;
	}
	

	/**
	 * 间接额度新增保存
	 */
	@Transactional
	public BIcrInfo saveAddInfo(BIcrInfo bicrInfo, List<BIcrInfo> subBIcrInfoList) throws ScubeBizException {
		bicrInfo.setCreditNo(bicrInfo.getUpCreditNo());
		bicrInfo.setCreditAmount(bicrInfo.getUpCreditAmount());
		bicrInfo.setCreditUsableAmount(bicrInfo.getUpCreditUsableAmount()==null?new BigDecimal("0"):bicrInfo.getUpCreditUsableAmount());
		bicrInfo.setRemark(bicrInfo.getUpRemark());
		//校验间接额度-不允许同一个间接额度客户同一日期区间存在多个有效的额度	
		//checkBIcrInfoValidDate(null,bicrInfo.getCustcd(),bicrInfo.getStartDate(),bicrInfo.getEndDate());
		checkBIcrInfoValidDate(bicrInfo.getCreditNo(),bicrInfo.getCustcd(),bicrInfo.getStartDate(),bicrInfo.getEndDate());
		//TODO保存基本申请信息B_PBC_APPLI_BASE_INFO 获得 appno
		String appno= BInfoBaseApplySaveUpdate(bicrInfo);
		bicrInfo.setAppno(appno);
		//保存额度及分项额度的申请信息B_ICR_APPLI_INFO
		BIcrInfoApplySaveUpdate(bicrInfo,subBIcrInfoList);
		
		//TODO 流程审批完成之后才保存间接额度信息，分项额度信息 （由申请信息表中到额度信息表）
		bicrInfo.setCreditUsableAmount(bicrInfo.getCreditUsableAmount());
		bicrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_ROOT);
		bicrInfo.setValidDate(BSysConstant.WORKDATE);
		bicrInfo.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL); //额度状态
		bicrInfo.setUpCreditNo(""); //上级额度编号
		bicrInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT); //额度类型
		//String creditType = bSysSerialNoService.genSerialNo(BIcrConstant.CREDIT_TYPE_NO);
		//bicrInfo.setCreditType(creditType);//额度种类编号
		//金额的处理
		BigDecimal creditAmount =bicrInfo.getCreditAmount()==null?new BigDecimal("0"):bicrInfo.getCreditAmount();
		BigDecimal creditUsableAmount =bicrInfo.getCreditUsableAmount()==null?new BigDecimal("0"):bicrInfo.getCreditUsableAmount();
		BigDecimal preUsedAmount =bicrInfo.getPreUsedAmount()==null?new BigDecimal("0"):bicrInfo.getPreUsedAmount();
		BigDecimal usedAmount =bicrInfo.getUsedAmount()==null?new BigDecimal("0"):bicrInfo.getUsedAmount();
		BigDecimal frzAmount =bicrInfo.getFrzAmount()==null?new BigDecimal("0"):bicrInfo.getFrzAmount();
		bicrInfo.setCreditAmount(creditAmount);
		bicrInfo.setCreditUsableAmount(creditUsableAmount);
		bicrInfo.setPreUsedAmount(preUsedAmount);
		bicrInfo.setUsedAmount(usedAmount);//0
		bicrInfo.setFrzAmount(frzAmount);
		//bicrInfo.setAppno(appno);
		//保存间接额度信息
		addBIcrInfo(bicrInfo);
		//保存间接分项额度	
		BIcrInfo suBIcrInfo = new BIcrInfo();
	  if(subBIcrInfoList!=null&&subBIcrInfoList.size()>0){
		  for(int i=0;i<subBIcrInfoList.size();i++){
				suBIcrInfo=subBIcrInfoList.get(i);
				suBIcrInfo.setUpCreditNo(bicrInfo.getCreditNo());
				suBIcrInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT); //额度类型
				suBIcrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
				suBIcrInfo.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL);

				//分项额度总额
				//BigDecimal subCreditAmount=(bicrInfo.getCreditAmount()==null?new BigDecimal("0"):bicrInfo.getCreditAmount());
				BigDecimal subCreditAmount=(suBIcrInfo.getCreditAmount()==null?new BigDecimal("0"):suBIcrInfo.getCreditAmount());
				//分项额度冻结金额
				BigDecimal subFrzAmount=(suBIcrInfo.getFrzAmount()==null?new BigDecimal("0"):suBIcrInfo.getFrzAmount());
				//分项额度已领用金额
				BigDecimal subUsedAmount=(suBIcrInfo.getUsedAmount()==null?new BigDecimal("0"):suBIcrInfo.getUsedAmount());
				//分项额度预领用金额
				BigDecimal subPreUsedAmount=(suBIcrInfo.getPreUsedAmount()==null?new BigDecimal("0"):suBIcrInfo.getPreUsedAmount());
				
				BigDecimal subcreditUsableAmount=(suBIcrInfo.getCreditUsableAmount()==null?new BigDecimal("0"):suBIcrInfo.getCreditUsableAmount());

				//校验额度：间接额度总额必须大于等于申请每一分项额度
				if(bicrInfo.getCreditAmount().compareTo(subCreditAmount)<0){
					throw new ScubeBizException("间接额度总额【"+bicrInfo.getCreditAmount()+"】小于编号为【"+suBIcrInfo.getCreditNo()+"】分项额度【"+suBIcrInfo.getCreditAmount()+"】，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
				}

				//分项额度总额>=分项额度冻结金额+分项额度已领用金额+分项额度预领用金额
				if(subCreditAmount.compareTo(subFrzAmount.add(subUsedAmount).add(subPreUsedAmount))<0){
					throw new ScubeBizException("编号为"+suBIcrInfo.getCreditNo()+"分项额度总额不能小于分项冻结金额、分项预领用金额、分项已领用金额之和，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
				}
				if((suBIcrInfo.getStartDate().compareTo(bicrInfo.getStartDate())<0)||(suBIcrInfo.getStartDate().compareTo(bicrInfo.getEndDate())>0)){
					throw new ScubeBizException("编号为"+suBIcrInfo.getCreditNo()+"的分项额度生效日【"+suBIcrInfo.getStartDate()+"】不在间接额度生效日与到期日之间，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
				}
				if(ScfDateUtil.compareDateSequence(suBIcrInfo.getStartDate(), bicrInfo.getStartDate())<0||ScfDateUtil.compareDateSequence(suBIcrInfo.getEndDate(), bicrInfo.getEndDate())>0){
					throw new ScubeBizException("编号为"+suBIcrInfo.getCreditNo()+"的分项额度到期【"+suBIcrInfo.getEndDate()+"】不在间接额度生效日与到期日之间，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
				}
				suBIcrInfo.setCreditAmount(subCreditAmount);
				suBIcrInfo.setFrzAmount(subFrzAmount);
				suBIcrInfo.setUsedAmount(subUsedAmount);
				suBIcrInfo.setPreUsedAmount(subPreUsedAmount);
				suBIcrInfo.setCreditUsableAmount(subcreditUsableAmount);
				addBIcrInfo(suBIcrInfo);
				String suitBrcode=suBIcrInfo.getSuitBrcode();
				//保存流水信息
				savebIcrDtlInfo(suBIcrInfo,BIcrConstant.CREDIT_TRADE_TYPE_INPUT);
				//保存分项额度适用机构关联信息
				saveOrModifybicrBrcodeListInfo(suBIcrInfo.getCreditNo(),suitBrcode);
			}		
	  }
			
		return bicrInfo;
	}
	/**
	 * 校验日期-不允许同一个间接额度客户同一日期区间存在多个有效的额度
	 * @param creditNo
	 * @param custcd
	 * @param startDate
	 * @param endDate
	 * @throws ScubeBizException
	 */
	public void checkBIcrInfoValidDate(String creditNo,String custcd,String startDate,String endDate) throws ScubeBizException {
		BCrmBaseInfo bCrmBaseInfo =new BCrmBaseInfo();
		bCrmBaseInfo.setCustcd(custcd);
	    bCrmBaseInfo =bCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
		String custName=bCrmBaseInfo.getCname();
		com.huateng.scf.bas.icr.dao.model.BIcrInfo bIcrInfodal=new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		bIcrInfodal.setCustcd(custcd);
		bIcrInfodal.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL);
		bIcrInfodal.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_ROOT);
		Page page =new Page();
		List<com.huateng.scf.bas.icr.dao.model.BIcrInfo>  list=iBIcrInfoDAO.selectListByPage(bIcrInfodal, page);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				com.huateng.scf.bas.icr.dao.model.BIcrInfo bIcrInfo=list.get(i);
				String sDate=bIcrInfo.getStartDate();
				String eDate=bIcrInfo.getEndDate();

				if(!bIcrInfo.getCreditNo().equalsIgnoreCase(creditNo)){
					if(ScfDateUtil.compareDateSequence(startDate,sDate)>-1&&ScfDateUtil.compareDateSequence(startDate, eDate)<1//起始日在区间中
							||ScfDateUtil.compareDateSequence(endDate,sDate)>-1&&ScfDateUtil.compareDateSequence(endDate, eDate)<1 //到期日在区间中
							||ScfDateUtil.compareDateSequence(startDate,sDate)<=0&&ScfDateUtil.compareDateSequence(endDate, eDate)>=0){//区间在起始日与到日期之间
						
						throw new ScubeBizException("新增客户【"+custName+"】间接额度在日期区间【"+startDate+","+endDate+"】存在多个有效或未提交的额度", BSysErrorConstant.RECORD_HAS_EXIST);
						
					}
				}
			}
		}
	}
	/**
	 *
	 * @Description: 校验间接总额度金额必须大于等于任何一个已生效的分项额度金额
	 * @author wenkui.xu
	 * @Created 2013年8月2日上午11:40:44
	 * @param creditNo	        间接额度编号
	 * @param creditAmount 间接额度总额
	 * @throws ScubeBizException
	 */
	public void  checkParentCredit(String creditNo,BigDecimal creditAmount)throws ScubeBizException {
		com.huateng.scf.bas.icr.dao.model.BIcrInfo bIcrInfodal=new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		bIcrInfodal.setUpCreditNo(creditNo);
//		creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
		bIcrInfodal.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
		bIcrInfodal.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
		Page page = new Page();
		//当前额度下的分项额度
		List<com.huateng.scf.bas.icr.dao.model.BIcrInfo> list=iBIcrInfoDAO.selectSubInfoList(bIcrInfodal, page);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				com.huateng.scf.bas.icr.dao.model.BIcrInfo subbIcrInfodal =list.get(i);
				String subCreditNo=subbIcrInfodal.getCreditNo();
				BigDecimal subCreditAmount=(subbIcrInfodal.getCreditAmount()!=null?subbIcrInfodal.getCreditAmount():new BigDecimal("0"));
				if(creditAmount.compareTo(subCreditAmount)<0){
						throw new ScubeBizException("间接总额度小于编号为【"+subCreditNo+"】的分项额度，请重新输入", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
				}
			}
		}
	}
	/**
	 * 保存业务业务申请额度适用机构映射
	 * @param appno
	 * @param creditNo
	 * @param suitBrcode
	 */
	@Transactional
	private void saveOrModifybicrAppliBrcodeListInfo(String appno, String creditNo, String suitBrcode) throws ScubeBizException{
		//先删除，后添加
		
		if(suitBrcode!=null&&suitBrcode.length()>1){
			suitBrcode =suitBrcode.replaceAll("\"","");
			if(suitBrcode.startsWith("[")&&suitBrcode.endsWith("]")){
				suitBrcode=suitBrcode.substring(1, suitBrcode.length()-1);
			}

			BIcrAppliBrcodeList bIcrAppliBrcodeList = new BIcrAppliBrcodeList();
			bIcrAppliBrcodeList.setAppno(appno);
			bIcrAppliBrcodeList.setCreditNo(creditNo);
			bIcrAppliBrcodeListService.deleteAppliBrcodeListByNo(bIcrAppliBrcodeList);
			if(!suitBrcode.contains(",")){//不包含‘,’则作为单项机构保存
				bIcrAppliBrcodeList.setBrcode(suitBrcode);
				bIcrAppliBrcodeListService.addAppliBrcodeList(bIcrAppliBrcodeList);
			}else{
				String []suitBrcodeList=suitBrcode.split(",");
				for(int i=0;i<suitBrcodeList.length;i++){
					String brcode=suitBrcodeList[i];
					bIcrAppliBrcodeList.setBrcode(brcode);
					bIcrAppliBrcodeListService.addAppliBrcodeList(bIcrAppliBrcodeList);
				}
			}
		}
		
	}
	
	
	
	/**
	 * 保存分项额度适用机构关联信息
	 * @param appno
	 * @param creditNo
	 * @param suitBrcode
	 */
	@Transactional
	private void saveOrModifybicrBrcodeListInfo(String creditNo, String suitBrcode) throws ScubeBizException{
		//先删除，后添加
		
		if(suitBrcode!=null&&suitBrcode.length()>1){
			suitBrcode =suitBrcode.replaceAll("\"","");
			if(suitBrcode.startsWith("[")&&suitBrcode.endsWith("]")){
				suitBrcode=suitBrcode.substring(1, suitBrcode.length()-1);
			}
		}
		BIcrBrcodeList bIcrBrcodeList = new BIcrBrcodeList();
		bIcrBrcodeList.setCreditNo(creditNo);
		bIcrBrcodeListService.deleteBrcodeListByNo(bIcrBrcodeList);
		if(!suitBrcode.contains(",")){//不包含‘,’则作为单项机构保存
			bIcrBrcodeList.setBrcode(suitBrcode);
			bIcrBrcodeListService.addBrcodeList(bIcrBrcodeList);
		}else{
			String[] suitBrcodeList=suitBrcode.split(",");
			for(int i=0;i<suitBrcodeList.length;i++){
				String brcode=suitBrcodeList[i];
				bIcrBrcodeList.setBrcode(brcode);
				bIcrBrcodeListService.addBrcodeList(bIcrBrcodeList);
			}
		}
	}
/**间接额度维护及分项额度申请信息新增保存
 * 
 * @param bIcrInfo
 * @return
 * @throws ScubeBizException
 */
@Transactional
public void  BIcrInfoApplySaveUpdate(BIcrInfo bicrInfo,  List<BIcrInfo> subBIcrInfoList)throws ScubeBizException{
	//保存额度申请信息TBL_APPLI_CREDIT_INFO
	BIcrAppliInfo bIcrAppliInfo = new BIcrAppliInfo();
	BeanUtils.copyProperties(bicrInfo, bIcrAppliInfo);

	bIcrAppliInfo.setCreditUsableAmount(bicrInfo.getCreditAmount());
	bIcrAppliInfo.setPreUsedAmount(new BigDecimal("0"));
	bIcrAppliInfo.setUsedAmount(new BigDecimal("0"));
	bIcrAppliInfo.setFrzAmount(new BigDecimal("0"));
	bIcrAppliInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
	bIcrAppliInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_ROOT);
	bIcrAppliInfo.setStatus(BIcrConstant.CREDIT_STATUS_TERMINATE); //审批通过后的处理
	//bIcrAppliInfo.setId(UUIDGeneratorUtil.generate());
	bIcrAppliInfo.setAppno(bicrInfo.getAppno());
	bIcrAppliInfoService.addCreditAppliInfo(bIcrAppliInfo);
	//保存间接分项额度申请信息
	if(subBIcrInfoList!=null&&subBIcrInfoList.size()>0){
		for(int i=0;i<subBIcrInfoList.size();i++){
			BIcrInfo subbicrInfo =(BIcrInfo)subBIcrInfoList.get(i);
			subbicrInfo.setAppno(bIcrAppliInfo.getAppno());

			//分项额度总额
			BigDecimal subCreditAmount=(bicrInfo.getCreditAmount()==null?new BigDecimal("0"):bicrInfo.getCreditAmount());
			//分项额度冻结金额
			BigDecimal subFrzAmount=(subbicrInfo.getFrzAmount()==null?new BigDecimal("0"):subbicrInfo.getFrzAmount());
			//分项额度已领用金额
			BigDecimal subUsedAmount=(subbicrInfo.getUsedAmount()==null?new BigDecimal("0"):subbicrInfo.getUsedAmount());
			//分项额度预领用金额
			BigDecimal subPreUsedAmount=(subbicrInfo.getPreUsedAmount()==null?new BigDecimal("0"):subbicrInfo.getPreUsedAmount());

			//校验额度：间接额度总额必须大于等于申请每一分项额度
			if(bIcrAppliInfo.getCreditAmount().compareTo(subCreditAmount)<0){
				throw new ScubeBizException("间接额度总额【"+bIcrAppliInfo.getCreditAmount()+"】小于编号为【"+subbicrInfo.getCreditNo()+"】分项额度【"+subbicrInfo.getCreditAmount()+"】，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}

			//分项额度总额>=分项额度冻结金额+分项额度已领用金额+分项额度预领用金额
			if(subCreditAmount.compareTo(subFrzAmount.add(subUsedAmount).add(subPreUsedAmount))<0){
				throw new ScubeBizException("编号为"+subbicrInfo.getCreditNo()+"分项额度总额不能小于分项冻结金额、分项预领用金额、分项已领用金额之和，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			if((subbicrInfo.getStartDate().compareTo(bIcrAppliInfo.getStartDate())<0)||(subbicrInfo.getStartDate().compareTo(bIcrAppliInfo.getEndDate())>0)){
				throw new ScubeBizException("编号为"+subbicrInfo.getCreditNo()+"的分项额度生效日【"+subbicrInfo.getStartDate()+"】不在间接额度生效日与到期日之间，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			if(ScfDateUtil.compareDateSequence(subbicrInfo.getStartDate(), bIcrAppliInfo.getStartDate())<0||ScfDateUtil.compareDateSequence(subbicrInfo.getEndDate(), bIcrAppliInfo.getEndDate())>0){
				throw new ScubeBizException("编号为"+subbicrInfo.getCreditNo()+"的分项额度到期【"+subbicrInfo.getEndDate()+"】不在间接额度生效日与到期日之间，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			
			BIcrAppliInfo subbIcrAppliInfo=new BIcrAppliInfo();
			BeanUtils.copyProperties(subbicrInfo, subbIcrAppliInfo);
			subbIcrAppliInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
			subbIcrAppliInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
			subbIcrAppliInfo.setCustcd(bIcrAppliInfo.getCustcd());
			subbIcrAppliInfo.setCreditUsableAmount(subbicrInfo.getCreditAmount());
			subbIcrAppliInfo.setBrcode(bIcrAppliInfo.getBrcode());
			subbIcrAppliInfo.setControlType(bIcrAppliInfo.getControlType());
			subbIcrAppliInfo.setIsNeedAudit(bIcrAppliInfo.getIsNeedAudit());
			subbIcrAppliInfo.setApproveType(bIcrAppliInfo.getApproveType());
			//subbIcrAppliInfo.setId(UUIDGeneratorUtil.generate());
			bIcrAppliInfoService.addCreditAppliInfo(subbIcrAppliInfo);
			//保存业务申请额度适用机构映射
			saveOrModifybicrAppliBrcodeListInfo(bicrInfo.getAppno(),subbicrInfo.getCreditNo(),subbicrInfo.getSuitBrcode());
		}
	}

}
	//额度申请基本信息新增
	@Transactional
	public String  BInfoBaseApplySaveUpdate(BIcrInfo bicrInfo)throws ScubeBizException{
		String appno=bicrInfo.getAppno();
		if(bicrInfo.getAppno()==null ||"".equals(bicrInfo.getAppno())){//申请编号不存在则新增
			/*BIcrAppliInfo bIcrAppliInfo = new BIcrAppliInfo();
			BeanUtils.copyProperties(bIcrInfo, bIcrAppliInfo);
			bIcrAppliInfo.setId(UUIDGeneratorUtil.generate());*/
		    appno =bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_INDIRECT_CREDIT_NO); 
		  //bIcrAppliInfo.setAppno(appno);
			//bIcrAppliInfoService.addCreditAppliInfo(bIcrAppliInfo);
		}else{//申请编号存在则修改
			
		}
		return appno;
	}
	
	//额度申请信息修改
	@Transactional
	public String updateAppliInfo(BIcrInfo bIcrInfo)throws ScubeBizException{
		BIcrAppliInfo bIcrAppliInfo = new BIcrAppliInfo();
		BeanUtils.copyProperties(bIcrInfo, bIcrAppliInfo);
		bIcrAppliInfoService.updateCreditAppliInfo(bIcrAppliInfo);
		return bIcrInfo.getAppno();
	}
	

	
	/**
	 * 间接额度修改保存
	 */
	@Transactional
	public BIcrInfo saveUpdateInfo(BIcrInfo bicrInfo, String delCreditNos,List<BIcrInfo> subBIcrInfoList)throws ScubeBizException {
		
		//间接额度信息bIcrInfo
		String upCreditNo =bicrInfo.getUpCreditNo();
		bicrInfo.setCreditNo(upCreditNo);
		bicrInfo.setCreditAmount(bicrInfo.getUpCreditAmount());
		bicrInfo.setCreditUsableAmount(bicrInfo.getUpCreditUsableAmount());
		bicrInfo.setUpCreditNo(""); //上级额度编号

		//校验间接额度-不允许同一个间接额度客户同一日期区间存在多个有效的额度	
		checkBIcrInfoValidDate(bicrInfo.getCreditNo(),bicrInfo.getCustcd(),bicrInfo.getStartDate(),bicrInfo.getEndDate());
		//TODO保存基本申请信息B_PBC_APPLI_BASE_INFO 获得 appno
		String appno= BInfoBaseApplySaveUpdate(bicrInfo);
		bicrInfo.setAppno(appno);
		//更新额度及分项额度的申请信息B_ICR_APPLI_INFO
		updateBIcrInfoApplySaveUpdate(bicrInfo,subBIcrInfoList);	
		//更新间接额度信息
		updateBIcrInfo(bicrInfo);
		//保存间接分项额度	
		//TODO 流程审批完成之后才保存间接额度信息，分项额度信息 （由申请信息表中到额度信息表）
		//TODO 是否可以删除
		//删除分项额度
		
		delCreditNos =delCreditNos.replaceAll("\"","");
		if(!"".equals(delCreditNos)){
			if(delCreditNos.startsWith("[")&&delCreditNos.endsWith("]")){
				delCreditNos=delCreditNos.substring(1, delCreditNos.length()-1);
			}
			
			String[] delCreditNoArr = delCreditNos.split(",");
			if(!"".equals(delCreditNoArr[0])){
				for(String delCreditNo:delCreditNoArr){
				 BIcrInfo deleteBIcrInfo = new BIcrInfo();
				 deleteBIcrInfo.setCreditNo(delCreditNo);
				 deleteBIcrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
				 deleteByBIcrInfo(deleteBIcrInfo);	
				}
			}
		}
		
	  if(subBIcrInfoList!=null&&subBIcrInfoList.size()>0){
		  for(int i=0;i<subBIcrInfoList.size();i++){
			   BIcrInfo subBIcrInfo=subBIcrInfoList.get(i);
			   com.huateng.scf.bas.icr.dao.model.BIcrInfo  ibIcrInfodal =iBIcrInfoDAO.selectByPrimaryKey(subBIcrInfo.getCreditNo());
			   if(ibIcrInfodal!=null){ //存在修改
				   BIcrInfo  ibIcrInfo = new BIcrInfo();
				   BeanUtils.copyProperties(ibIcrInfodal, ibIcrInfo);
				   ibIcrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
				   ibIcrInfo.setCustcd(bicrInfo.getCustcd());
				   ibIcrInfo.setCreditAmount(subBIcrInfo.getCreditAmount());
				   ibIcrInfo.setFrzAmount(subBIcrInfo.getFrzAmount());
				   ibIcrInfo.setCreditUsableAmount(subBIcrInfo.getCreditUsableAmount());
				   ibIcrInfo.setBrcode(bicrInfo.getBrcode());
				   ibIcrInfo.setControlType(bicrInfo.getControlType());
				   ibIcrInfo.setIsNeedAudit(bicrInfo.getIsNeedAudit());
				   ibIcrInfo.setApproveType(bicrInfo.getApproveType());
				   ibIcrInfo.setStartDate(subBIcrInfo.getStartDate());
				   ibIcrInfo.setEndDate(subBIcrInfo.getEndDate());
				   ibIcrInfo.setRemark(subBIcrInfo.getRemark());
				   updateBIcrInfo(ibIcrInfo);
			   }else{ //不存在新增
				   subBIcrInfo.setUpCreditNo(bicrInfo.getCreditNo());
				   subBIcrInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT); //额度类型
				   subBIcrInfo.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL);
				   subBIcrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
				   subBIcrInfo.setCustcd(bicrInfo.getCustcd());
				   subBIcrInfo.setBrcode(bicrInfo.getBrcode());
				   subBIcrInfo.setControlType(bicrInfo.getControlType());
				   subBIcrInfo.setIsNeedAudit(bicrInfo.getIsNeedAudit());
				   subBIcrInfo.setApproveType(bicrInfo.getApproveType());
				    addBIcrInfo(subBIcrInfo);
			   }
			    //保存流水信息
				savebIcrDtlInfo(subBIcrInfo,BIcrConstant.CREDIT_TRADE_TYPE_INPUT);
				 //保存分项额度适用机构申请信息
				saveOrModifybicrBrcodeListInfo(subBIcrInfo.getCreditNo(),subBIcrInfo.getSuitBrcode());
				
				
			}		
	  }else{ //删除 间接额度下的分项额度信息
		  BIcrInfo delBIcrInfo = new BIcrInfo();
		  delBIcrInfo.setUpCreditNo(upCreditNo);
		  delBIcrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
		  deleteByBIcrInfo(delBIcrInfo);
		  
	  }
		return bicrInfo;
	}
	
	
	/**
	 * 修改间接额度及分项额度(修改申请)
	 * @param bicrInfo
	 * @param subBIcrInfoList
	 * @throws ScubeBizException
	 */
	public void updateBIcrInfoApplySaveUpdate(BIcrInfo bicrInfo,List<BIcrInfo> list)throws ScubeBizException {
		//校验额度：间接额度必须大于已生效每一分项额度
		checkParentCredit(bicrInfo.getCreditNo(),bicrInfo.getCreditAmount());
		//保存间接额度申请信息
		BIcrAppliInfo bIcrAppliInfo = new BIcrAppliInfo();
		BeanUtils.copyProperties(bicrInfo, bIcrAppliInfo);
	
		BigDecimal chiefCreditAmount=(bicrInfo.getCreditAmount()==null?new BigDecimal(0):bicrInfo.getCreditAmount());
		BigDecimal chiefUsedAmount=(bicrInfo.getUsedAmount()==null?new BigDecimal(0):bicrInfo.getUsedAmount());
		BigDecimal chiefPreUsedAmount=(bicrInfo.getPreUsedAmount()==null?new BigDecimal(0):bicrInfo.getPreUsedAmount());
		if(chiefCreditAmount.compareTo(chiefUsedAmount.add(chiefPreUsedAmount))<0){
			throw new ScubeBizException("间接额度总金额小于预领用金额与已领用金额之和，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
		}
		bIcrAppliInfo.setCreditUsableAmount(bicrInfo.getCreditAmount().subtract(bicrInfo.getUsedAmount()));
		bIcrAppliInfo.setControlType(bicrInfo.getControlType());
		bIcrAppliInfoService.updateCreditAppliInfo(bIcrAppliInfo);


		//查询已存在分项额度申请信息
		BIcrAppliInfo subBIcrAppliInfo=new BIcrAppliInfo();
		subBIcrAppliInfo.setAppno(bIcrAppliInfo.getAppno());
		subBIcrAppliInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
		subBIcrAppliInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
		
		Page page=bIcrAppliInfoService.queryCreditAppliInfoByPage(0, 0, subBIcrAppliInfo);
		
		List subBIcrAppliInfoList=page.getRecords();

		//保存间接分项额度
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				BIcrInfo subBIcrInfo=(BIcrInfo)list.get(i);
				subBIcrInfo.setAppno(bIcrAppliInfo.getAppno());
				//分项额度总额
				BigDecimal subCreditAmount=(bicrInfo.getCreditAmount()==null?new BigDecimal("0"):bicrInfo.getCreditAmount());
				//分项额度冻结金额
				BigDecimal subFrzAmount=(subBIcrInfo.getFrzAmount()==null?new BigDecimal("0"):subBIcrInfo.getFrzAmount());
				//分项额度已领用金额
				BigDecimal subUsedAmount=(subBIcrInfo.getUsedAmount()==null?new BigDecimal("0"):subBIcrInfo.getUsedAmount());
				//分项额度预领用金额
				BigDecimal subPreUsedAmount=(subBIcrInfo.getPreUsedAmount()==null?new BigDecimal("0"):subBIcrInfo.getPreUsedAmount());

				//校验额度：间接额度总额必须大于等于申请每一分项额度
				if(bIcrAppliInfo.getCreditAmount().compareTo(subCreditAmount)<0){
					throw new ScubeBizException("间接额度总额【"+bIcrAppliInfo.getCreditAmount()+"】小于编号为【"+subBIcrInfo.getCreditNo()+"】分项额度【"+subBIcrInfo.getCreditAmount()+"】，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
				}

				//分项额度总额>=分项额度冻结金额+分项额度已领用金额+分项额度预领用金额
				if(subCreditAmount.compareTo(subFrzAmount.add(subUsedAmount).add(subPreUsedAmount))<0){
					throw new ScubeBizException("编号为"+subBIcrInfo.getCreditNo()+"分项额度总额不能小于分项冻结金额、分项预领用金额、分项已领用金额之和，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
				}
				
				if(ScfDateUtil.compareDateSequence(subBIcrInfo.getStartDate(), bIcrAppliInfo.getStartDate())<0||ScfDateUtil.compareDateSequence(subBIcrInfo.getStartDate(), bIcrAppliInfo.getEndDate())>0){
					throw new ScubeBizException("编号为"+subBIcrInfo.getCreditNo()+"的分项额度生效日【"+subBIcrInfo.getStartDate()+"】不在间接额度生效日与到期日之间，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
				}
				if(ScfDateUtil.compareDateSequence(subBIcrInfo.getEndDate(), bIcrAppliInfo.getStartDate())<0||ScfDateUtil.compareDateSequence(subBIcrInfo.getEndDate(), bIcrAppliInfo.getEndDate())>0){
					throw new ScubeBizException("编号为"+subBIcrInfo.getCreditNo()+"的分项额度到期【"+subBIcrInfo.getEndDate()+"】不在间接额度生效日与到期日之间，请重新输入！", BSysErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
				}
				//查询该额度申请信息是否存在
				BIcrAppliInfo appliInfo=new BIcrAppliInfo();
				appliInfo.setCreditNo(subBIcrInfo.getCreditNo());
				BIcrAppliInfo subAppliInfo=bIcrAppliInfoService.queryBIcrAppliInfoByCreditNo(appliInfo);
				
				if(subAppliInfo != null){//修改已存在分项额度
					subAppliInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
					subAppliInfo.setCustcd(bIcrAppliInfo.getCustcd());
					subAppliInfo.setCreditAmount(subBIcrInfo.getCreditAmount());
					subAppliInfo.setFrzAmount(subFrzAmount);  //?
					subAppliInfo.setCreditUsableAmount(subBIcrInfo.getCreditUsableAmount());
					subAppliInfo.setBrcode(bIcrAppliInfo.getBrcode());
					subAppliInfo.setControlType(bIcrAppliInfo.getControlType());
					subAppliInfo.setIsNeedAudit(bIcrAppliInfo.getIsNeedAudit());
					subAppliInfo.setApproveType(bIcrAppliInfo.getApproveType());
					subAppliInfo.setStartDate(subBIcrInfo.getStartDate());
					subAppliInfo.setEndDate(subBIcrInfo.getEndDate());
					subAppliInfo.setRemark(subBIcrInfo.getRemark());
					bIcrAppliInfoService.updateCreditAppliInfo(subAppliInfo);
					
					/*//获得业务机构映射关系
					String suitBrcode="";
					BIcrAppliBrcodeList bIcrAppliBrcodeList = new BIcrAppliBrcodeList();
					bIcrAppliBrcodeList.setCreditNo(subBIcrInfo.getCreditNo());
					List<BIcrAppliBrcodeList> appliBrcodelist=bIcrAppliBrcodeListService.queryBIcrAppliBrcodeByCreditNo(bIcrAppliBrcodeList);
					if(appliBrcodelist!=null&&appliBrcodelist.size()>0){
						for(i=0;i<appliBrcodelist.size();i++){
							suitBrcode=appliBrcodelist.get(i).getBrcode()+",";
						}
						if(suitBrcode.length()>1){
							suitBrcode=suitBrcode.substring(0, suitBrcode.length()-1);
						}
					}
					subBIcrInfo.setSuitBrcode(suitBrcode);*/
				}else{//保存新增间接分项额度
					subAppliInfo = new BIcrAppliInfo();
					BeanUtils.copyProperties(subBIcrInfo, subAppliInfo);
					subAppliInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);
					subAppliInfo.setCustcd(bIcrAppliInfo.getCustcd());
					subAppliInfo.setCreditAmount(subBIcrInfo.getCreditAmount());
					subAppliInfo.setFrzAmount(subBIcrInfo.getFrzAmount());
					subAppliInfo.setCreditUsableAmount(subBIcrInfo.getCreditUsableAmount());
					subAppliInfo.setBrcode(bIcrAppliInfo.getBrcode());
					subAppliInfo.setControlType(bIcrAppliInfo.getControlType());
					subAppliInfo.setIsNeedAudit(bIcrAppliInfo.getIsNeedAudit());
					subAppliInfo.setApproveType(bIcrAppliInfo.getApproveType());
					bIcrAppliInfoService.addCreditAppliInfo(subAppliInfo);
				}
				
				
				//保存分项额度适用机构申请信息
				saveOrModifybicrAppliBrcodeListInfo(bicrInfo.getAppno(),subBIcrInfo.getCreditNo(),subBIcrInfo.getSuitBrcode());
			}
			//删除分项申请额度信息 比较后台的分项额度编号是否在前台的分项额度信息额度编号中，不在的删除前台已删除的数据
			for(int i=0;i<subBIcrAppliInfoList.size();i++){
				BIcrAppliInfo subTblAppliCreditInfo=(BIcrAppliInfo)subBIcrAppliInfoList.get(i);
				int k=0;
				for(int j=0;j<list.size();j++){
					BIcrInfo subVO=(BIcrInfo)list.get(j);
					if(subTblAppliCreditInfo.getCreditNo().equalsIgnoreCase(subVO.getCreditNo())){
						k++;
					}
				}
				if(k==0){
					bIcrAppliInfoService.deleteByBIcrAppliInfo(subTblAppliCreditInfo);
				}
			}

		}else{//删除所有分项申请额度信息
			for(int i=0;i<subBIcrAppliInfoList.size();i++){
				BIcrAppliInfo subTblAppliCreditInfo=(BIcrAppliInfo)subBIcrAppliInfoList.get(i);
				bIcrAppliInfoService.deleteByBIcrAppliInfo(subTblAppliCreditInfo);
			}
		}
	}
	@Override
	/**
	 * 通过额度编号获得分项额度信息及额度信息
	 */
	public BIcrInfo findBIcrInfoOrUpByCreditNo(String creditNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		BIcrInfo  bicrInfo = new BIcrInfo();
		com.huateng.scf.bas.icr.dao.model.BIcrInfo bicrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		bicrInfodal.setCreditNo(creditNo);
		bicrInfodal =iBIcrInfoDAO.selectInfoOrUpByCreditNo(bicrInfodal);
		try {
			BeanUtils.copyProperties(bicrInfodal, bicrInfo);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		String suitbrName =getSuitBrNameBySuitBrcode(bicrInfodal.getSuitBrcode());
		bicrInfo.setSuitbrName(suitbrName);
		BctlVO bctlVO = new BctlVO();
		if(bicrInfo.getBrcode()==null){
			// 获取机构信息
			bctlVO = ContextHolder.getOrgInfo();
			bicrInfo.setBrcode(bctlVO.getBrNo());
			bicrInfo.setBrcodeName(bctlVO.getBrName());
		}
		   //获得机构集
	     List<BctlVO> listBctl = orgService.selectByExample(bctlVO);   
	     bicrInfo.setListBctl(listBctl);
	     bicrInfo.setTxtDate(BSysConstant.WORKDATE);
		return bicrInfo;
	}
	@Override
	@Transactional
	/**
	 * 额度终止：根据额度编号更新额度状态和分项额度状态,领用额度状态
	 */
	public void updateBIcrInfoStatus(String creditNos) throws ScubeBizException {
		String[] creditNoArr = creditNos.split(",");
		for (String creditNo : creditNoArr) {
			if ("".equals(creditNo)) {
				log.error("参数丢失");
				throw new ScubeBizException("参数丢失");
			}
			BIcrInfo bicrInfo = this.findBIcrInfoByKey(creditNo);
			bicrInfo.setStatus(BIcrConstant.CREDIT_STATUS_TERMINATE);
			String operType = "";
			if (ScfBasConstant.CREDIT_STATUS_NORMAL.equals(bicrInfo.getStatus())) {
				operType = ScfBasConstant.CREDIT_TRADE_TYPE_INPUT;
			}
			if (ScfBasConstant.CREDIT_STATUS_TERMINATE.equals(bicrInfo.getStatus())) {
				operType = ScfBasConstant.CREDIT_TRADE_TYPE_END;
			}	
			// 间接额度终止
			this.updateBIcrInfo(bicrInfo);

			// 增加父额度流水
			this.savebIcrDtlInfo(bicrInfo, operType);
			// 分项额度终止
			// 获得分项额度
			BIcrInfoExample example = new BIcrInfoExample();
			if (bicrInfo != null) {
				Criteria criteria = example.createCriteria();
				// 分项额度列表
				if (bicrInfo.getCreditNo() != null) {
					criteria.andUpCreditNoEqualTo(bicrInfo.getCreditNo());
				}
				List<com.huateng.scf.bas.icr.dao.model.BIcrInfo> list = iBIcrInfoDAO.selectByExample(example);

				if (list != null && list.size() > 0) {
					for (com.huateng.scf.bas.icr.dao.model.BIcrInfo Info : list) {
						BIcrInfo subInfo = new BIcrInfo();
						BeanUtils.copyProperties(Info, subInfo);
						subInfo.setStatus(BIcrConstant.CREDIT_STATUS_TERMINATE);
						this.updateBIcrInfo(subInfo);
						// 增加子额度流水
						this.savebIcrDtlInfo(subInfo, operType);
						BIcrInfoExample subexample = new BIcrInfoExample();
						if (subInfo != null) {
							Criteria subcriteria = subexample.createCriteria();
							if (subInfo.getCreditNo() != null) {
								subcriteria.andUpCreditNoEqualTo(subInfo.getCreditNo());
							}
							List<com.huateng.scf.bas.icr.dao.model.BIcrInfo> subLeafList = iBIcrInfoDAO
									.selectByExample(subexample);
							for (com.huateng.scf.bas.icr.dao.model.BIcrInfo info : subLeafList) {
								BIcrInfo subLeafInfo = new BIcrInfo();
								BeanUtils.copyProperties(info, subLeafInfo);
								// 领用额度终止
								subLeafInfo.setStatus(BIcrConstant.CREDIT_STATUS_TERMINATE);
								this.updateBIcrInfo(subLeafInfo);
								// 增加子子额度流水
								this.savebIcrDtlInfo(subLeafInfo, operType);

							}
						}
					}
				}
			}
		}

	}
	@Override
	/**
	 * 机构选择
	 */
	public Page findOrgByPage(int pageNo, int pageSize, BctlVO bctlVO) throws ScubeBizException {
		// TODO Auto-generated method stub
		Page page = new Page(pageNo);
		//page= orgService.selectByPage(pageNo, pageSize, bctlVO);
		List<BctlVO> list =orgService.getBrManagerList();
		//orgService.getBrNo(bctlVO); //获得总行的信息
		page.setRecords(list);
		return page;
	}
	/**
	 * 根据适用机构号获得适用机构名称
	 * @param suitBrcode
	 * @return
	 * @throws ScubeBizException
	 */
	public String getSuitBrNameBySuitBrcode(String suitBrcode) throws ScubeBizException{
//		String brManagerId = ContextHolder.getOrgInfo().getBrManagerId();
		String suitbrName = "";
		if(suitBrcode!=null&&suitBrcode!=""){
			String []suitBrcodeList=suitBrcode.split(",");
			for(int i=0;i<suitBrcodeList.length;i++){
				String brcode=suitBrcodeList[i];
				BctlVO suitbctlVO = new BctlVO();
				suitbctlVO.setBrNo(brcode);
				List<BctlVO> bctlVOList = orgService.selectByExample(suitbctlVO);
				if(bctlVOList!=null&&bctlVOList.size()==1){
					BctlVO suitBctlVO = bctlVOList.get(0);
//					String suitBrManagerId = suitBctlVO.getBrManagerId();
//					if(!brManagerId.equals(suitBrManagerId))
//					{
//						throw new ScubeBizException("当前用户所属机构不是该间接额度的适用机构");
//					}
					suitbrName+=suitBctlVO.getBrName()+",";
				} 
			}if(suitbrName.length()>1){
				suitbrName=suitbrName.substring(0, suitbrName.length()-1);
			}
			
		}
		return suitbrName;
	}
	/****************** 领用查询 begin ***********************/
	@Override
	/**
	 * 可以领用间接额度查询
	 */
	public Page findBIcrInfoDrawByPage(int pageNo, int pageSize, BIcrInfo bicrInfo) throws ScubeBizException {
		bicrInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);//额度类型
		bicrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);//分项额度
		bicrInfo.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL); //额度状态
		Page p = new Page(pageSize, pageNo, 0);
		if (bicrInfo != null) {
			com.huateng.scf.bas.icr.dao.model.BIcrInfo bIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
			BeanUtils.copyProperties(bicrInfo, bIcrInfodal);
			p.setRecords(iBIcrInfoDAO.findBIcrInfoDrawByPage(bIcrInfodal, p));	
		}
		return p;
	}
	/**
	 * 根据额度编号获得额度相关的信息
	 */
	public BIcrInfo findBIcrInfoMainByCreditNo(String creditNo) throws ScubeBizException {
		BIcrInfo bicrInfo = new BIcrInfo();
		// 间接额度编号
		bicrInfo.setCreditNo(creditNo);
		bicrInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);// 额度类型
		//bicrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_LEAF);// 分项额度
		//bicrInfo.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL); // 额度状态
		com.huateng.scf.bas.icr.dao.model.BIcrInfo bicrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		BeanUtils.copyProperties(bicrInfo, bicrInfodal);
		
		bicrInfodal=iBIcrInfoDAO.selectInfoMainByCreditNo(bicrInfodal);
		BeanUtils.copyProperties(bicrInfodal, bicrInfo);
		/**间接额度领用，回收 适用机构，申请机构，领用机构，领用日期，回收日期**/
		String suitbrName =getSuitBrNameBySuitBrcode(bicrInfodal.getSuitBrcode());
		bicrInfo.setSuitbrName(suitbrName);
		BctlVO bctlVO = new BctlVO();
		if(!StringUtil.isEmpty(bicrInfo.getBrcode())){
			// 获取机构信息
			bctlVO = ContextHolder.getOrgInfo();
			bicrInfo.setBrcode(bctlVO.getBrNo());
			bicrInfo.setBrcodeName(bctlVO.getBrName());
		}
		//获得机构集
		List<BctlVO> listBctl = orgService.selectByExample(bctlVO);   
		bicrInfo.setListBctl(listBctl);
	    bicrInfo.setTxtDate(BSysConstant.WORKDATE);
		return bicrInfo;
	}
	
	/**
	 * 额度领用（不审批） 保存
	 */
	@Override
	@Transactional
	public void BIcrInfoDrawSaveUpdate(BIcrInfo bicrInfo) throws ScubeBizException {
		//额度编号,客户号,交易对手号  金额
		String creditNo =bicrInfo.getCreditNo();
		BigDecimal amount =bicrInfo.getAmount(); //本次申请额度
		String txtDate = bicrInfo.getTxtDate(); //领用日期
		String drawEndDate = bicrInfo.getDrawEndDate();//领用到期日期
		String otherCustcd = bicrInfo.getOtherCustcd();//授信客户号
		bicrInfo.setStartDate(txtDate);
		bicrInfo.setCreditAmount(amount);
		bicrInfo.setEndDate(drawEndDate);
		//通过额度编号获得分项额度信息
	
		com.huateng.scf.bas.icr.dao.model.BIcrInfo upbIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		upbIcrInfodal =iBIcrInfoDAO.selectByPrimaryKey(creditNo);	
		//判断本次领用额度与未分配分项额度总额
		if(amount.compareTo(upbIcrInfodal.getCreditUsableAmount())>0){
			throw new ScubeBizException("本次领用额度不能大于分项额度可用余额", BSysErrorConstant.SCF_BAS_ICR_40001);
		}
		//获得上级额度信息
		String upCreditNo=upbIcrInfodal.getUpCreditNo();
		com.huateng.scf.bas.icr.dao.model.BIcrInfo parentbIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		parentbIcrInfodal =iBIcrInfoDAO.selectByPrimaryKey(upCreditNo);

		//判断本次领用额度与间接额度总额
		if(amount.compareTo(parentbIcrInfodal.getCreditUsableAmount())>0){
			throw new ScubeBizException("本次领用额度不能大于间接总额度可用余额", BSysErrorConstant.SCF_BAS_ICR_40001);
		}
		//修改分项额度[可用可用额度 = 可用额度-本次申请额度，已占额度 = 额度总额+本次申请额度]
		upbIcrInfodal.setCreditUsableAmount(upbIcrInfodal.getCreditUsableAmount().subtract(amount));
		upbIcrInfodal.setUsedAmount(upbIcrInfodal.getUsedAmount().add(amount));
		iBIcrInfoDAO.updateByPrimaryKey(upbIcrInfodal);
		BIcrInfo  upbIcrInfo = new BIcrInfo();
		BeanUtils.copyProperties(upbIcrInfodal, upbIcrInfo);
		//增加分项额度变更流水
		savebIcrDtlInfo(upbIcrInfo,BIcrConstant.CREDIT_TRADE_TYPE_CHANGE);//变更
		
		//修改总额度[可用可用额度 = 可用额度-本次申请额度，已占额度 =  已占额度+本次申请额度]
		parentbIcrInfodal.setCreditUsableAmount(parentbIcrInfodal.getCreditUsableAmount().subtract(amount));
		parentbIcrInfodal.setUsedAmount(parentbIcrInfodal.getUsedAmount().add(amount));
		iBIcrInfoDAO.updateByPrimaryKey(parentbIcrInfodal);
		//增加总额度流水
		BIcrInfo  parentbIcrInfo = new BIcrInfo();
		BeanUtils.copyProperties(parentbIcrInfodal, parentbIcrInfo);
		savebIcrDtlInfo(parentbIcrInfo,BIcrConstant.CREDIT_TRADE_TYPE_CHANGE);//变更
		//已生效额度
		Page page = new Page();
		page=findBIcrDrawInfoListByPage(page.getPageNo(),page.getPageSize(),upbIcrInfo);
		List list = page.getRecords();
		//存在
		if(list!=null&&list.size()>0){
			BIcrInfo bIcrInfoTemp1=(BIcrInfo)list.get(0);
			BigDecimal creditAmountTemp1=(bIcrInfoTemp1.getCreditAmount()!=null?bIcrInfoTemp1.getCreditAmount():new BigDecimal("0"));
			bIcrInfoTemp1.setCreditAmount(creditAmountTemp1.add(amount));
			bIcrInfoTemp1.setCreditUsableAmount(bIcrInfoTemp1.getCreditUsableAmount().add(amount));
			/*bIcrInfoTemp1.setStartDate(txtDate);
			bIcrInfoTemp1.setEndDate(drawEndDate);*/
			com.huateng.scf.bas.icr.dao.model.BIcrInfo  bIcrInfoTemp1dal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
			BeanUtils.copyProperties(bIcrInfoTemp1, bIcrInfoTemp1dal);
			//更新已领用额度
			iBIcrInfoDAO.updateByPrimaryKey(bIcrInfoTemp1dal);
			//保存领用额度流水
			savebIcrDtlInfo(bIcrInfoTemp1,BIcrConstant.CREDIT_TRADE_TYPE_CHANGE);
		}else{
			BIcrInfo bIcrInfoTemp2=new BIcrInfo();
			BeanUtils.copyProperties(bicrInfo,bIcrInfoTemp2);
			/*bIcrInfoTemp2.setStartDate(txtDate);
			bIcrInfoTemp2.setEndDate(drawEndDate);*/
			bIcrInfoTemp2.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
			bIcrInfoTemp2.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_SUB_LEAF);
			bIcrInfoTemp2.setUpCreditNo(upbIcrInfo.getCreditNo());
			bIcrInfoTemp2.setControlType(BIcrConstant.CREDIT_CLASS_CYCLE);
			bIcrInfoTemp2.setCreditUsableAmount(amount);
			if(bIcrInfoTemp2.getPreUsedAmount()==null){
				bIcrInfoTemp2.setPreUsedAmount(new BigDecimal("0"));
			}
			if(bIcrInfoTemp2.getFrzAmount()==null){
				bIcrInfoTemp2.setFrzAmount(new BigDecimal("0"));
			}
			if(bIcrInfoTemp2.getUsedAmount()==null){
				bIcrInfoTemp2.setUsedAmount(new BigDecimal("0"));
			}
			bIcrInfoTemp2.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL);
			//tblCreditInfoTemp2.setTerm("");期限
			bIcrInfoTemp2.setValidDate(BSysConstant.WORKDATE);

			bIcrInfoTemp2.setCreditNo(bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_INDIRECT_CREDIT_NO));
			addBIcrInfo(bIcrInfoTemp2); //新增一条已领用额度
			//更新已领用额度
			savebIcrDtlInfo(bIcrInfoTemp2,BIcrConstant.CREDIT_TRADE_TYPE_INPUT);
		}
	}
	@Transactional
	public void savebIcrDtlInfo (BIcrInfo upbIcrInfo,String operType){
		if(upbIcrInfo!=null){
			BIcrDtl bicrDtl = new BIcrDtl();
			BeanUtils.copyProperties(upbIcrInfo, bicrDtl);
			bicrDtl.setTxdate(BSysConstant.WORKDATE);
			bicrDtl.setTxtime(new Date());
			bicrDtl.setAppno(upbIcrInfo.getCreditNo());
			bicrDtl.setRelaType(BIcrConstant.CREDIT_RELA_TYPE_CUST);//客户维度维护额度
			bicrDtl.setBusinessno(upbIcrInfo.getCreditNo());
			bicrDtl.setOperType(operType);//额度类型 变更
			bicrDtl.setAmount(upbIcrInfo.getCreditAmount());
			bicrDtl.setCommonAmount(upbIcrInfo.getCreditAmount());
			bicrDtl.setCommonDate(BSysConstant.WORKDATE);
			bicrDtl.setStatus(BIcrConstant.CREDIT_STATUS_TERMINATE);//额度流水结束
			bBIcrDtlService.add(bicrDtl);
		}
		
	}
	/**
	 * 已领用间接额度查询(包括总额度，分项额度，子额度)
	 * @param pageNo
	 * @param pageSize
	 * @param creditNo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findBIcrDrawInfoListByPage(int pageNo, int pageSize, BIcrInfo bicrInfo)throws ScubeBizException {
		// TODO Auto-generated method stub
		bicrInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
		bicrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_SUB_LEAF);
		
		Page p = new Page(pageSize, pageNo, 0);
		if (bicrInfo != null) {
			com.huateng.scf.bas.icr.dao.model.BIcrInfo bIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
			BeanUtils.copyProperties(bicrInfo, bIcrInfodal);
			p.setRecords(iBIcrInfoDAO.selectDrawInfoList(bIcrInfodal, p));	
		}
		return p;		
	}
	/*************间接额度回收 Recover***************/
	//可以领用间接额度查询(领用额度)
	public Page findBIcrInfoRecoverByPage(int pageNo, int pageSize, BIcrInfo bicrInfo) throws ScubeBizException {
 		bicrInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);//额度类型
		bicrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_SUB_LEAF);//领用额度
		bicrInfo.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL); //额度状态
		Page p = new Page(pageSize, pageNo, 0);
		if (bicrInfo != null) {
			com.huateng.scf.bas.icr.dao.model.BIcrInfo bIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
			BeanUtils.copyProperties(bicrInfo, bIcrInfodal);
			p.setRecords(iBIcrInfoDAO.findBIcrInfoRecoverByPage(bIcrInfodal, p));	
		}
		return p;
	}
	
	/**
	 * 额度回收信息保存
	 */
	@Override
	@Transactional
	public void BIcrInfoRecoverSaveUpdate(BIcrInfo bicrInfo) throws ScubeBizException {
		// TODO 申请相关的未处理
		//额度编号,客户号,交易对手号  金额
		String creditNo =bicrInfo.getCreditNo();
		BigDecimal amount =bicrInfo.getAmount(); //本次申请额度
		//获得本次的领用额度信息
		com.huateng.scf.bas.icr.dao.model.BIcrInfo subbIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		subbIcrInfodal =iBIcrInfoDAO.selectByPrimaryKey(creditNo);	
		//判断本次回收额度与额度可用余额 
		if(amount.compareTo(subbIcrInfodal.getCreditUsableAmount())>0){
			throw new ScubeBizException("本次回收额度不能大于剩余可用额度", BSysErrorConstant.SCF_BAS_ICR_40001);
		}
		// TODO 申请信息保存
		String appno=BIcrInfoRecoverApplySaveUpdate(bicrInfo);
		
		/** 1、领用额度变更 **/
		//修改领用额度 [领用可用额度 = 剩余可用额度 - 回收额度, 领用总额度 =领用总额度 - 回收额度]
		subbIcrInfodal.setCreditUsableAmount(subbIcrInfodal.getCreditUsableAmount().subtract(amount));
	
		subbIcrInfodal.setCreditAmount(subbIcrInfodal.getCreditAmount().subtract(amount));
		iBIcrInfoDAO.updateByPrimaryKey(subbIcrInfodal);
		//增加领用额度变更流水
		BIcrInfo  subbIcrInfo = new BIcrInfo();
		BeanUtils.copyProperties(subbIcrInfodal, subbIcrInfo);
		savebIcrDtlInfo(subbIcrInfo,BIcrConstant.CREDIT_TRADE_TYPE_CHANGE);//变更
	
		/** 2、分项额度变更 **/
		com.huateng.scf.bas.icr.dao.model.BIcrInfo upbIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		upbIcrInfodal =iBIcrInfoDAO.selectByPrimaryKey(subbIcrInfo.getUpCreditNo());
		
		BIcrInfo  upbIcrInfo = new BIcrInfo();
		BeanUtils.copyProperties(upbIcrInfodal, upbIcrInfo);
	
		//修改分项额度 [分项可用额度 = 分项可用额度 + 回收额度, 分项已用额度 = 分项已使用额度 - 回收额度]
		upbIcrInfodal.setCreditUsableAmount(upbIcrInfodal.getCreditUsableAmount().add(amount));
		upbIcrInfodal.setUsedAmount(upbIcrInfodal.getUsedAmount().subtract(amount));
		iBIcrInfoDAO.updateByPrimaryKey(upbIcrInfodal);
		
		/** 3、间接额度总额变更 **/
		com.huateng.scf.bas.icr.dao.model.BIcrInfo parentbIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
		parentbIcrInfodal =iBIcrInfoDAO.selectByPrimaryKey(upbIcrInfodal.getUpCreditNo());
		//修改分项额度 [分项可用额度 = 分项可用额度 + 回收额度,分项已用额度 = 分项已使用额度 - 回收额度]
		parentbIcrInfodal.setCreditUsableAmount(parentbIcrInfodal.getCreditUsableAmount().add(amount));
		parentbIcrInfodal.setUsedAmount(parentbIcrInfodal.getUsedAmount().subtract(amount));
		iBIcrInfoDAO.updateByPrimaryKey(parentbIcrInfodal);
		
	}
	/**
	 * 额度回收信息申请信息相关的保存
	 * @param bIcrInfo
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	public String BIcrInfoRecoverApplySaveUpdate (BIcrInfo bicrInfo) throws ScubeBizException{
		//TODO 暂无申请
	   //校验同一（授信客户、间接额度客户、额度种类），只允许存在一笔额度回收操作在审批过程中。
		//TODO保存申请基本信息  
		//保存间接额度申请信息	
		BIcrAppliInfo bicrAppliInfo = new BIcrAppliInfo();
		BeanUtils.copyProperties(bicrInfo, bicrAppliInfo);
		//bicrAppliInfo.setId(UUIDGeneratorUtil.generate());
		//生成申请编号
	    String appno =bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_INDIRECT_CREDIT_NO); 
		bicrAppliInfo.setAppno(appno);	
		bicrAppliInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
		bicrAppliInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_SUB_LEAF);
		bicrAppliInfo.setControlType(BIcrConstant.CREDIT_CLASS_CYCLE);
		bicrAppliInfo.setPreUsedAmount(new BigDecimal("0"));
		bicrAppliInfo.setFrzAmount(new BigDecimal("0"));
		bicrAppliInfo.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL);
		bicrAppliInfo.setStatus(BIcrConstant.CREDIT_STATUS_TERMINATE);//流程结束审批通过更新状态
		bIcrAppliInfoService.addCreditAppliInfo(bicrAppliInfo);
		return appno;
		
	}
	/******************间接额度使用流水查询**************************/
	public Page findBIcrInfoFlowQryByPage(int pageNo, int pageSize, BIcrInfo bicrInfo) throws ScubeBizException {
		bicrInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
		Page p = new Page(pageSize, pageNo, 0);
		if (bicrInfo != null) {
			com.huateng.scf.bas.icr.dao.model.BIcrInfo bIcrInfodal = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
			BeanUtils.copyProperties(bicrInfo, bIcrInfodal);
			p.setRecords(iBIcrInfoDAO.findBIcrInfoFlowQryByPage(bIcrInfodal, p));	
		}
		return p;		
	}

	/**
	 *
	 * @Description: 间接额度通用处理
	 * @param appno	        申请编号
	 * @param debitNo  借据编号
	 * @param operType 操作类型
	 * 		    常量定义BIcrConstant:
	 *        00-生效(录入);01-预占用;02-占用(预占用转占用);03-恢复释放（占用恢复）;04-冻结;05-解冻;06-变更;07-终止;08-预占用恢复（释放）;09-直接占用
	 * @param amount  敞口金额
	 * @throws ScubeBizException
	 */
	public void indirectCreditAppliCommonProcess(String appno,String debitNo,String operType,BigDecimal amt) throws ScubeBizException{
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		boolean breakFlag=false;
		String appliType=bPbcAppliBaseInfo.getAppliType();//申请业务类型
		if(StringUtil.isEmpty(appno)){
			log.error("申请号丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10000),BIcrErrorConstant.SCF_BAS_ICR_10000);
		}
		String productId=bPbcAppliBaseInfo.getSupplyChainPdId();//产品编号
		if(StringUtil.isEmpty(productId)){
			log.error("产品编号丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10001),BIcrErrorConstant.SCF_BAS_ICR_10001);
		}

		String businessno="";//关联业务号
		String relaType=BIcrConstant.CREDIT_RELA_TYPE_LNCI;//额度业务关联类型:借据
		String custcd = "";//客户号
		String otherCustcd = "";//交易对手,额度占用方
		String creditPhase="";//额度阶段
		String creditOprType="";//额度操作
		String releaseFlag=ScfBasConstant.FLAG_OFF;//是否放款退回：默认：否
		BLanAppliLnciBase bLanAppliLnciBase = new BLanAppliLnciBase();
//			String  midProductId=DAOUtils.getTblProductInfoDAO().getParentIdById(productId);
		List<CreditInterParamBean> creditOpList=null;


		//担保提货 提货
		if(WorkflowConstant.APPLI_TYPE_THREE_DELIVERYAPPLY.equalsIgnoreCase(appliType)){// 担保提货提货申请
			creditPhase=BIcrConstant.CREDIT_PHASE_THREE_FINANCING_DELIVERY;
			creditOprType=BIcrConstant.CREDIT_OPR_TYPE_RELEASE;
			relaType=BIcrConstant.CREDIT_RELA_TYPE_LNCI;
			String bebetNo=bPbcAppliBaseInfo.getExt1();
			BLanLnciBase  bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(bebetNo);
			businessno=bLanLnciBase.getDebetId();
			ABcpAppliImprestBuss aBcpAppliImprestBuss = aBcpAppliImprestBussService.findABcpAppliImprestBussByAppno(appno);
			custcd = aBcpAppliImprestBuss.getUpCustcd();//卖方
			otherCustcd = aBcpAppliImprestBuss.getCustcd();//买方


			creditOpList=new ArrayList<CreditInterParamBean>();
			CreditInterParamBean creditInterParam = new CreditInterParamBean();
			creditInterParam.setProductId(productId);
			creditInterParam.setRelaType(relaType);
			creditInterParam.setCreditPhase(creditPhase);
			creditInterParam.setCreditOperType(creditOprType);
			String hasIndirectCredit=bLanLnciBase.getHasIndirectCredit();
			if(BIcrConstant.HAS_INDIRECT_CREDIT_TRUE.equals(hasIndirectCredit)){
				creditInterParam.setAmount(amt);
				creditInterParam.setBusinessno(businessno);
				creditInterParam.setCustcd(custcd);
				creditInterParam.setOtherCustcd(otherCustcd);
				creditOpList.add(creditInterParam);
			}else{
				breakFlag=true;
			}
		}
		
		//额度处理
		if(creditOpList!=null&&creditOpList.size()>0){
				for(int k=0;k<creditOpList.size();k++){
					CreditInterParamBean creditInterParamTemp=(CreditInterParamBean)creditOpList.get(k);
					String creditProductId=creditInterParamTemp.getProductId();
					BigDecimal creditAmt=creditInterParamTemp.getAmount();
					String creditBusinessno=creditInterParamTemp.getBusinessno();
					String creditCustcd=creditInterParamTemp.getCustcd();
					String creditOtherCustcd=creditInterParamTemp.getOtherCustcd();

					//根据产品Id及操作类型  获取当前业务阶段的额度设定列表
					//设置查询条件
					BPrdCreditBind  bPrdCreditBind = new BPrdCreditBind();
					bPrdCreditBind.setProductId(creditProductId); // 产品Id
					bPrdCreditBind.setCreditPhase(creditPhase);
					bPrdCreditBind.setOprType(creditOprType);
					//依据产品Id和操作类型查询
					List<BPrdCreditBind> creditBindList = bPrdCreditBindService.findBPrdCreditBindBPrd(bPrdCreditBind);

					if(creditBindList==null||creditBindList.size()==0){
						log.error("产品与额度类型关联信息丢失！");
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10002),BIcrErrorConstant.SCF_BAS_ICR_10002);
					}

					CommonCreditProcessBussAmtVO bussAmtVO=new CommonCreditProcessBussAmtVO();
					bussAmtVO.setRiskAmount(creditAmt);

					//循环当前业务阶段的额度设定列表,依次处理额度列表中的各种额度
					//B_ICR_TYPE
					for(int i=0; i<creditBindList.size(); i++){
						BigDecimal amount = null;  // 操作金额

						//获取产品额度绑定信息
						BPrdCreditBind creditBind = creditBindList.get(i);
						String creditType = creditBind.getCreditType();  // 额度类型
						String oprField = creditBind.getOprField(); // 额度操作金额

						BIcrType  bIcrTypeQryVO  = new BIcrType();
						bIcrTypeQryVO.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
						bIcrTypeQryVO.setCreditType(creditType);
						
						Page  page=bIcrTypeService.findBIcrTypeByPage(1, Integer.MAX_VALUE, bIcrTypeQryVO);
						if(page.getRecords()!=null&&page.getTotalRecord()>0){
							//获取额度操作的金额
							String oprFieldName = CreditOptFieldMap.fieldMap.get(oprField);
							try {
								String amountStr = org.apache.commons.beanutils.BeanUtils.getProperty(bussAmtVO, oprFieldName);
								if(StringUtil.isEmpty(amountStr)){
									log.error("额度操作金额配置错误！");
									throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10003),BIcrErrorConstant.SCF_BAS_ICR_10003);
								}
								amount = new BigDecimal(amountStr);
								if(amount.compareTo(new BigDecimal("0")) == 0){ // 如果操作金额为等于0则不进行处理
									continue;
								}
							} catch (Throwable te) {
								te.printStackTrace();
								log.error("额度操作金额配置错误！");
								throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10003),BIcrErrorConstant.SCF_BAS_ICR_10003);
							}

							// 设置额度处理参数
							CreditInterParamBean creditInterParam = new CreditInterParamBean();
							creditInterParam.setApplyType(appliType);
							creditInterParam.setBusinessno(creditBusinessno);
							creditInterParam.setRelaType(relaType);
							creditInterParam.setAppno(appno);

							indirectCreditDealWith(creditInterParam, creditCustcd, creditOtherCustcd, creditType, operType, amount,releaseFlag);
						}
					}
				}
		}else if(!breakFlag&&!StringUtil.isEmpty(productId)&&!StringUtil.isEmpty(creditPhase)&&!StringUtil.isEmpty(creditOprType)){
			//根据产品Id及操作类型  获取当前业务阶段的额度设定列表
			//设置查询条件
			BPrdCreditBind  bPrdCreditBind = new BPrdCreditBind();
			bPrdCreditBind.setProductId(productId); // 产品Id
			bPrdCreditBind.setCreditPhase(creditPhase);
			bPrdCreditBind.setOprType(creditOprType);
			//依据产品Id和操作类型查询
			List<BPrdCreditBind> creditBindList = bPrdCreditBindService.findBPrdCreditBindBPrd(bPrdCreditBind);

			if(creditBindList==null||creditBindList.size()==0){
				log.error("产品与额度类型关联信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10002),BIcrErrorConstant.SCF_BAS_ICR_10002);
			}

			CommonCreditProcessBussAmtVO bussAmtVO=new CommonCreditProcessBussAmtVO();
			bussAmtVO.setRiskAmount(amt);

			//循环当前业务阶段的额度设定列表,依次处理额度列表中的各种额度
			for(int i=0; i<creditBindList.size(); i++){
				BigDecimal amount = null;  // 操作金额

				//获取产品额度绑定信息
				BPrdCreditBind creditBind = creditBindList.get(i);
				String creditType = creditBind.getCreditType();  // 额度类型
				String oprField = creditBind.getOprField(); // 额度操作金额


				BIcrType  bIcrTypeQryVO  = new BIcrType();
				bIcrTypeQryVO.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
				bIcrTypeQryVO.setCreditType(creditType);
				Page  page=bIcrTypeService.findBIcrTypeByPage(1, Integer.MAX_VALUE, bIcrTypeQryVO);
				if(page.getRecords()!=null&&page.getTotalRecord()>0){
					//获取额度操作的金额
					String oprFieldName = CreditOptFieldMap.fieldMap.get(oprField);
					try {
						String amountStr = org.apache.commons.beanutils.BeanUtils.getProperty(bussAmtVO, oprFieldName);
						if(StringUtil.isEmpty(amountStr)){
							log.error("额度操作金额配置错误！");
							throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10003),BIcrErrorConstant.SCF_BAS_ICR_10003);
						}
						amount = new BigDecimal(amountStr);
						if(amount.compareTo(new BigDecimal("0")) == 0){ // 如果操作金额为等于0则不进行处理
							continue;
						}
					} catch (Throwable te) {
						te.printStackTrace();
						log.error("额度操作金额配置错误！");
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10003),BIcrErrorConstant.SCF_BAS_ICR_10003);
					}

					// 设置额度处理参数
					CreditInterParamBean creditInterParam = new CreditInterParamBean();
					creditInterParam.setApplyType(appliType);
					creditInterParam.setBusinessno(businessno);
					creditInterParam.setRelaType(relaType);
					creditInterParam.setAppno(appno);

					indirectCreditDealWith(creditInterParam, custcd, otherCustcd, creditType, operType, amount,releaseFlag);
				}
			}
		}else if(breakFlag){
			//间接额度不处理
		}else{
			log.error("额度阶段或操作类型操作类型未配置，请配置后再操作！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10004),BIcrErrorConstant.SCF_BAS_ICR_10004);
		}

	}
	/**
	 *
	 * @Description: 间接额度操作方法
	 * @param custcd 客户号
	 * @param otherCustcd 交易对手客户号
	 * @param creditType 额度种类
	  * @param operType 操作类型
	 * 		    常量定义BIcrConstant:
	 *        00-生效(录入);01-预占用;02-占用(预占用转占用);03-恢复释放（占用恢复）;04-冻结;05-解冻;06-变更;07-终止;08-预占用恢复（释放）;09-直接占用
	 * @param amt 操作金额
	 * @throws ScubeBizException
	 */
	public void indirectCreditDealWith(CreditInterParamBean creditInterParam,String custcd,String otherCustcd,String creditType,String operType,BigDecimal amt,String releaseFlag) throws ScubeBizException{

		if(StringUtil.isEmpty(custcd)){
			log.error("客户信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10005),BIcrErrorConstant.SCF_BAS_ICR_10005);
		}
		if(StringUtil.isEmpty(otherCustcd)){
			log.error("交易对手信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10006),BIcrErrorConstant.SCF_BAS_ICR_10006);
		}
		if(StringUtil.isEmpty(creditType)){
			log.error("间接额度种类信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10007),BIcrErrorConstant.SCF_BAS_ICR_10007);
		}
		if(StringUtil.isEmpty(operType)){
			log.error("间接额度操作类型丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10004),BIcrErrorConstant.SCF_BAS_ICR_10004);
		}
		if(!BIcrConstant.CREDIT_TRADE_TYPE_END.equalsIgnoreCase(operType)){
			if(amt==null){
				log.error("间接额度操作金额信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10008),BIcrErrorConstant.SCF_BAS_ICR_10008);
			}
		}

		BIcrInfo  bIcrInfoQryVO  = new BIcrInfo();
		bIcrInfoQryVO.setCreditClass(BIcrConstant.CREDIT_CLASS_INDIRECT);
		bIcrInfoQryVO.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_SUB_LEAF);
		bIcrInfoQryVO.setCustcd(custcd);
		bIcrInfoQryVO.setOtherCustcd(otherCustcd);
		bIcrInfoQryVO.setCreditType(creditType);
		bIcrInfoQryVO.setStartDate(BSysConstant.WORKDATE);
		bIcrInfoQryVO.setEndDate(BSysConstant.WORKDATE); //?
		//直接占用
		if(BIcrConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)){
			bIcrInfoQryVO.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL);
			Page pageQueryResult=this.findBIcrInfoByPage(1,Integer.MAX_VALUE,bIcrInfoQryVO);
			List subLeafCreditInfoList=pageQueryResult.getRecords();
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (subLeafCreditInfoList==null||subLeafCreditInfoList.size()==0) {
				log.error("间接领用额度信息丢失,不可占用额度！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10009),BIcrErrorConstant.SCF_BAS_ICR_10009);
			}

			//获取领用额度
			BIcrInfo subBIcrInfo =(BIcrInfo)subLeafCreditInfoList.get(0);
			//操作金额必须小于领用额度可用余额
			if(amt.compareTo(subBIcrInfo.getCreditUsableAmount())>0){
				log.error("占用额度必须小于等于当前领用额度的可用余额！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10010),BIcrErrorConstant.SCF_BAS_ICR_10010);
			}
			this.addCreditDetail(creditInterParam,custcd,otherCustcd,creditType,operType,amt,subBIcrInfo);
			// 更新额度信息
			BigDecimal creditUsableAmount=subBIcrInfo.getCreditUsableAmount();
			BigDecimal usedAmount=subBIcrInfo.getUsedAmount();
		 	//额度余额 = 前额度余额 – 交易金额
			subBIcrInfo.setCreditUsableAmount(creditUsableAmount.subtract(amt));
			//实占用额度 = 前实占用额度 + 交易金额
			subBIcrInfo.setUsedAmount(usedAmount.add(amt));
			this.updateBIcrInfo(subBIcrInfo);

			//begin 占用额度时，把占用的额度编号记录到借据申请表中
			BLanAppliLnciBase  bLanAppliLnciBase = bLanAppliLnciBaseDAO.selectByAppno(creditInterParam.getAppno());
			if (bLanAppliLnciBase != null){
				bLanAppliLnciBase.setCreditNo(subBIcrInfo.getCreditNo());
				bLanAppliLnciBaseDAO.updateByPrimaryKeySelective(bLanAppliLnciBase);
			}else{ //商票贴现、商票质押 没有申请表，只有正式表
				BLanLnciBase  bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByDebtId(creditInterParam.getBusinessno());
				if (bLanLnciBase != null){
					bLanLnciBase.setCreditNo(subBIcrInfo.getCreditNo());
					bLanLnciBaseService.updateBLanLnciBase(bLanLnciBase);
				}
			}
			//end 占用额度时，把占用的额度编号记录到借据申请表中
		}
		//占用恢复
		if(BIcrConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)){
//				PageQueryResult pageQueryResult=tblCreditInfoDAO.getCurrenyEffectiveTblCreditInfoByCreditQryVO(creditQryVO);
//				List subLeafCreditInfoList=pageQueryResult.getQueryResult();
//				// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
//				if (subLeafCreditInfoList==null||subLeafCreditInfoList.size()==0) {
//					throwScubeBizException("间接领用额度信息丢失,不可释放额度！",RBcpErrorConstant.RECORD_NOT_EXIST);
//				}
//				//获取领用额度
//				TblCreditInfo subLeafCreditInfo =(TblCreditInfo)subLeafCreditInfoList.get(0);
			// begin 恢复占用额度时，根据借据表的额度编号查询到相关的额度信息，进行恢复
			BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseDAO.findBLanAppliLnciBaseByDebtId(creditInterParam.getBusinessno());
			if (bLanAppliLnciBase == null){
				log.error("借据信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10011),BIcrErrorConstant.SCF_BAS_ICR_10011);
			}
			//获取领用额度
			BIcrInfo subBIcrInfo = this.findBIcrInfoByCreditNo(bLanAppliLnciBase.getCreditNo());
			if (subBIcrInfo == null){
				log.error("间接领用额度信息丢失,不可释放额度！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10012),BIcrErrorConstant.SCF_BAS_ICR_10012);
			}
			//end 恢复占用额度时，根据借据表的额度编号查询到相关的额度信息，进行恢复
			String controlType=subBIcrInfo.getControlType();
			//循环时恢复释放额度 非循环时不作处理
			if(BIcrConstant.CREDIT_CLASS_CYCLE.equalsIgnoreCase(controlType)|ScfBasConstant.FLAG_ON.equalsIgnoreCase(releaseFlag)){
				// 恢复(释放)额度不可大于占用额度 当大于恢复额度大于占用额度的时候 直接恢复已占用额度
				if(amt.compareTo(subBIcrInfo.getUsedAmount())>0){
					amt=subBIcrInfo.getUsedAmount();
				}
				// 记录流水
				this.addCreditDetail(creditInterParam,custcd,otherCustcd,creditType,operType,amt,subBIcrInfo);

				// 更新额度信息
				BigDecimal creditUsableAmount=subBIcrInfo.getCreditUsableAmount();
				BigDecimal usedAmount=subBIcrInfo.getUsedAmount();
				//额度余额 = 前额度余额 + 交易金额
				subBIcrInfo.setCreditUsableAmount(creditUsableAmount.add(amt));
				//实占用额度 = 前实占用额度 - 交易金额
				subBIcrInfo.setUsedAmount(usedAmount.subtract(amt));
				this.updateBIcrInfo(subBIcrInfo);
			}
		}
	}

	/**
	 * @Description: 额度接口操作-记录融资额度流水
	 * @param obj
	 * @param type 交易操作类型
	 * @param amount 交易金额
	 * @throws ScubeBizException
	 */
	public void addCreditDetail(CreditInterParamBean creditInterParamBean,
			String custcd, String otherCustcd, String creditType, String type,
			BigDecimal amount, BIcrInfo orgTblCreditInfo) throws ScubeBizException {
		BIcrDtl bIcrDtl = new BIcrDtl();
		BeanUtils.copyProperties(creditInterParamBean,bIcrDtl);
		bIcrDtl.setCustcd(custcd);
		bIcrDtl.setOperType(type);
		bIcrDtl.setCreditAmount(amount);
		bIcrDtl.setPreUsedAmount(new BigDecimal("0"));
		bIcrDtl.setUsedAmount(new BigDecimal("0"));
		bIcrDtl.setFrzAmount(new BigDecimal("0"));
		bIcrDtl.setCreditUsableAmount(new BigDecimal("0"));
		bIcrDtl.setCommonAmount(amount);

		if(bIcrDtl.getCreditNo()==null){
			BIcrInfo bIcrInfo = null;
			if (orgTblCreditInfo == null){
				List list=this.checkCredit(custcd, otherCustcd, creditType);
				if(list!=null&&list.size()>0){
					bIcrInfo=(BIcrInfo) list.get(0);
				}
			}else{
				bIcrInfo = orgTblCreditInfo;
			}
			bIcrDtl.setCreditNo(bIcrInfo.getCreditNo());
			bIcrDtl.setCreditAmount(bIcrInfo.getCreditAmount());
			bIcrDtl.setPreUsedAmount(bIcrInfo.getPreUsedAmount());
			bIcrDtl.setUsedAmount(bIcrInfo.getUsedAmount());
			bIcrDtl.setFrzAmount(bIcrInfo.getFrzAmount());
			bIcrDtl.setCreditUsableAmount(bIcrInfo.getCreditUsableAmount());
			BigDecimal creditAmount=(bIcrDtl.getCreditAmount()==null?new BigDecimal("0"):bIcrDtl.getCreditAmount());
			BigDecimal creditUsableAmount=(bIcrDtl.getCreditUsableAmount()==null?new BigDecimal("0"):bIcrDtl.getCreditUsableAmount());
			if(BIcrConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(type)){//预占用
				bIcrDtl.setCommonAmount(creditAmount.subtract(amount));
			}
			if(BIcrConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(type)){//预占用恢复（释放）
				bIcrDtl.setCommonAmount(creditUsableAmount.add(amount));
			}
			if(BIcrConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(type)){//占用
				bIcrDtl.setCommonAmount(creditUsableAmount);
			}
			if(BIcrConstant.CREDIT_TRADE_TYPE_RELEASE.equals(type)){//占用恢复（释放）
				bIcrDtl.setCommonAmount(creditUsableAmount.add(amount));
			}
			if(BIcrConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(type)){//直接占用
				bIcrDtl.setCommonAmount(creditUsableAmount.subtract(amount));
			}
			if(BIcrConstant.CREDIT_TRADE_TYPE_CHANGE.equals(type)){//变更
				bIcrDtl.setCommonAmount(amount);
			}
			if(BIcrConstant.CREDIT_TRADE_TYPE_FREEZE.equals(type)){//冻结
				bIcrDtl.setCommonAmount(creditUsableAmount.subtract(amount));
			}
			if(BIcrConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(type)){//解冻
				bIcrDtl.setCommonAmount(creditUsableAmount.add(amount));
			}
		}

		bIcrDtl.setCommonDate(BSysConstant.WORKDATE);
		bIcrDtl.setAmount(amount);
		bIcrDtl.setTxdate(BSysConstant.WORKDATE);
		bIcrDtl.setTxtime(new Date());
		bIcrDtl.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL);
		bBIcrDtlService.add(bIcrDtl);

	}
	
	/**
	 * 
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BIcrInfo> checkCredit(String custcd,String otherCustcd, String creditType) throws ScubeBizException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(CUSTCD, custcd);
		map.put(OTHERCUSTCD, otherCustcd);
		map.put(CREDITTYPE, creditType);
		map.put(STATUS, BIcrConstant.CREDIT_STATUS_NORMAL);
		List<BIcrInfo> list =  new ArrayList<BIcrInfo>(); 
		BIcrInfo bIcrInfo = new BIcrInfo();
		List<com.huateng.scf.bas.icr.dao.model.BIcrInfo> listdal=  iBIcrInfoDAO.checkCredit(map);
		for(com.huateng.scf.bas.icr.dao.model.BIcrInfo info:listdal){
			BeanUtils.copyProperties(info, bIcrInfo);
			list.add(bIcrInfo);
		}
		return list;
	}
	

	/**
	 *
	 * @Description: 获取买方信用限额编号
	 * @author wenkui.xu
	 * @Created 2013-6-28下午05:15:11
	 * @return
	 * @throws CommonException
	 */
	@Override
	public String getCreditNoOfLimitBuyer() throws ScubeBizException {
		String creditNo =bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_INDIRECT_CREDIT_NO); 
		if(StringUtil.isEmpty(creditNo))
		{
			throw new ScubeBizException("买方信用限额编号生成出错", RBcpErrorConstant.ERROR_CODE_UNKNOWN);
		}
		return creditNo;
	}
	
	/**
	 * 当前日期所在区间额度查询
	 * @param creditQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午4:12:40
	 */
	@Override
	public Page getCurrenyEffectiveTblCreditInfoByCreditQryVO(CreditQryVO creditQryVO)throws ScubeBizException
	{
		BIcrInfoExample example = new BIcrInfoExample();
		BIcrInfoExample.Criteria cri = example.createCriteria();
		if(!StringUtil.isEmpty(creditQryVO.getCreditClass_Q()))
		{
			cri.andCreditClassEqualTo(creditQryVO.getCreditClass_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getNodeType_Q()))
		{
			cri.andNodeTypeEqualTo(creditQryVO.getNodeType_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getCustcd()))
		{
			cri.andCustcdEqualTo(creditQryVO.getCustcd());
		}
		if(!StringUtil.isEmpty(creditQryVO.getOtherCustcd_Q()))
		{
			cri.andOtherCustcdEqualTo(creditQryVO.getOtherCustcd_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getApprovalNo_Q()))
		{
			cri.andApprovalNoEqualTo(creditQryVO.getApprovalNo_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getStatus_Q()))
		{
			cri.andStatusEqualTo(creditQryVO.getStatus_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getCreditNo_Q()))
		{
			cri.andCreditNoEqualTo(creditQryVO.getCreditNo_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getUpCreditNo_Q()))
		{
			cri.andUpCreditNoEqualTo(creditQryVO.getUpCreditNo_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getCreditType_Q()))
		{
			cri.andCreditTypeEqualTo(creditQryVO.getCreditType_Q());
		}
		cri.andStartDateLessThanOrEqualTo(ScfDateUtil.getStringDate(new Date()));
		cri.andEndDateGreaterThanOrEqualTo(ScfDateUtil.getStringDate(new Date()));
		example.setOrderByClause("CREDIT_NO desc");
		
		int total = iBIcrInfoDAO.countByExample(example);
		Page page = new Page(creditQryVO.getPageSize(), creditQryVO.getPageIndex(), total);
		page.setRecords(iBIcrInfoDAO.selectByPage(example, page));
		return page;
	}

	/**
	 * 检查额度操作时数据正确性
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param amount
	 * @param type
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午3:44:27
	 */
	@Override
	public void checkCreditOpInfo(String custcd,String otherCustcd,String creditType,BigDecimal amount,String type) throws ScubeBizException
	{
		BIcrInfo tblCreditInfo = new BIcrInfo();
		tblCreditInfo.setCustcd(custcd);
		tblCreditInfo.setOtherCustcd(otherCustcd);
		tblCreditInfo.setCreditType(creditType);
		List<BIcrInfo> list = this.checkCredit(tblCreditInfo.getCustcd(),tblCreditInfo.getOtherCustcd(),tblCreditInfo.getCreditType());


		String custName="";
		String errString="";
		if(!StringUtil.isEmpty(custcd)){
			com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo tblCustBaseInfo = bcrmbaseinfodao.selectById(custcd);
			custName=tblCustBaseInfo.getCname();
			errString+="客户为【"+custName+"】";
		}

		String otherCustcdName="";
		if(!StringUtil.isEmpty(otherCustcd)){
			com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo tblCustBaseInfo = bcrmbaseinfodao.selectById(otherCustcd);
			otherCustcdName=tblCustBaseInfo.getCname();
			errString+="，交易对手为【"+otherCustcdName+"】";
		}

		String creditTypeName="";
		if(!StringUtil.isEmpty(creditType)){
			BIcrType tblCreditType= bIcrTypeService.getTblCreditTypeByCreditType(creditType);
			creditTypeName=tblCreditType.getCreditName();
			errString+="，额度类型为【"+creditTypeName+"】";
		}

		if(list!=null && list.size()>0){
			for(BIcrInfo tblCreditInfoIt:list)
			{
				BigDecimal usedAmounts = amount==null?new BigDecimal("0"):amount;
				BigDecimal usedAmount = tblCreditInfoIt.getUsedAmount()==null?new BigDecimal("0"):tblCreditInfoIt.getUsedAmount();//实占金额
				BigDecimal creditUsableAmount = tblCreditInfoIt.getCreditUsableAmount()==null?new BigDecimal("0"):tblCreditInfoIt.getCreditUsableAmount();//可用额度
				BigDecimal frzAmount = tblCreditInfoIt.getFrzAmount()==null?new BigDecimal("0"):tblCreditInfoIt.getFrzAmount();//冻结金额
				BigDecimal preUsedAmount = tblCreditInfoIt.getPreUsedAmount()==null?new BigDecimal("0"):tblCreditInfoIt.getPreUsedAmount();//冻结金额
				if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(type)){//预占用
					if(usedAmounts.compareTo(creditUsableAmount)==1){
						throw new ScubeBizException(errString+"的额度预占用时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
					}
				}else if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(type)){//预占用恢复
					if(usedAmounts.compareTo(preUsedAmount)==1){
						throw new ScubeBizException(errString+"的额度恢复时操作金额大于预占用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
					}
				}else if(ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(type)){//占用
					if(usedAmounts.compareTo(preUsedAmount)==1){
						throw new ScubeBizException(errString+"的额度占用时操作金额大于预占用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
					}
				}else if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(type)){//直接占用
					if(usedAmounts.compareTo(creditUsableAmount)==1){
						throw new ScubeBizException(errString+"的额度变更时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
					}
				}else if(ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(type)){//变更
					if(usedAmounts.compareTo(creditUsableAmount)==1){
						throw new ScubeBizException(errString+"的额度变更时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
					}
				}else if(ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(type)){//冻结
					if(usedAmounts.compareTo(creditUsableAmount)==1){
						throw new ScubeBizException(errString+"的额度冻结时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
					}
				}else if(ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(type)){//解冻
					if(usedAmounts.compareTo(frzAmount)==1){
						throw new ScubeBizException(errString+"的额度解冻时操作金额大于冻结金额，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
					}
				}else if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(type)){//直接占用
					if(usedAmounts.compareTo(creditUsableAmount)==1){
						throw new ScubeBizException(errString+"的额度直接占用时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
					}
				else if (ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(type)){//恢复
					if(usedAmounts.compareTo(usedAmount)==1){
						throw new ScubeBizException(errString+"的额度恢复时操作金额大于实占额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
					}
				}
				}
			}
		}
	}
	
	/**
	 * 额度操作接口-增加额度信息
	 * @param creditInterParamBean
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param type
	 * @param amount
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午4:06:21
	 */
	@Override
	public void addCreditInfo(CreditInterParamBean creditInterParamBean,String custcd,
			String otherCustcd,String creditType,String type,BigDecimal amount) throws ScubeBizException
	{
		BIcrInfo tblCreditInfo = new BIcrInfo();
		try {
			BeanUtils.copyProperties(creditInterParamBean, tblCreditInfo);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		tblCreditInfo.setCustcd(custcd);
		tblCreditInfo.setOtherCustcd(otherCustcd);
		tblCreditInfo.setCreditType(creditType);
		tblCreditInfo.setCreditAmount(amount);
		tblCreditInfo.setCreditUsableAmount(amount);
		tblCreditInfo.setFrzAmount(new BigDecimal("0"));
		tblCreditInfo.setPreUsedAmount(new BigDecimal("0"));
		tblCreditInfo.setNodeType(StringUtil.isEmpty(otherCustcd)?ScfBasConstant.CREDIT_NODE_TYPE_ROOT:ScfBasConstant.CREDIT_NODE_TYPE_LEAF);
		tblCreditInfo.setTerm(ScfDateUtil.getTenOr(ScfDateUtil.numberToDate(tblCreditInfo.getStartDate()),ScfDateUtil.numberToDate(tblCreditInfo.getEndDate())));
		tblCreditInfo.setValidDate(ScfDateUtil.getStringDate(new Date()));

		tblCreditInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		tblCreditInfo.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);
		tblCreditInfo.setLastUpdTime(new Date());
		tblCreditInfo.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		this.addBIcrInfo(tblCreditInfo);
	}

	/**
	 * 额度接口操作-修改融资额度信息
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param type
	 * @param amount
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午4:15:04
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void modifyCreditInfo(String custcd,String otherCustcd,String creditType,String type,BigDecimal amount)
			throws ScubeBizException
	{
		List<BIcrInfo> list = this.checkCredit(custcd, otherCustcd, creditType);
		if(list!=null && list.size()>0)
		{
			for(BIcrInfo bIcrInfo:list){
				com.huateng.scf.bas.icr.dao.model.BIcrInfo tblCreditInfoTmp = iBIcrInfoDAO.selectByPrimaryKey(bIcrInfo.getCreditNo());
				//交易金额
				BigDecimal usedAmount =( amount==null?new BigDecimal("0"):amount);
				//已使用额度
				BigDecimal usedAmounts= (tblCreditInfoTmp.getUsedAmount()==null?new BigDecimal("0"):tblCreditInfoTmp.getUsedAmount());
				//可使用金额
				BigDecimal creditUsableAmount = tblCreditInfoTmp.getCreditUsableAmount()==null?new BigDecimal("0"):tblCreditInfoTmp.getCreditUsableAmount();
				//预占用金额
				BigDecimal preUsedAmount= tblCreditInfoTmp.getPreUsedAmount()==null?new BigDecimal("0"):tblCreditInfoTmp.getPreUsedAmount();
				//冻结金额
				BigDecimal frzAmount= tblCreditInfoTmp.getFrzAmount()==null?new BigDecimal("0"):tblCreditInfoTmp.getFrzAmount();
				if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(type))//预占用
				{
				 	//可用额度 = 前可用额度 – 交易金额
					tblCreditInfoTmp.setCreditUsableAmount(creditUsableAmount.subtract(usedAmount));//可用金额减少
				 	//预占用额度 = 前预占用额度 + 交易金额
					tblCreditInfoTmp.setPreUsedAmount(preUsedAmount.add(usedAmount));
				}
				if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(type))//预占用恢复（释放）
				{
				 	//可用额度 = 前可用额度 + 交易金额
					tblCreditInfoTmp.setCreditUsableAmount(creditUsableAmount.add(usedAmount));
					//预占用额度 = 前预占用额度 - 交易金额
					tblCreditInfoTmp.setPreUsedAmount(preUsedAmount.subtract(usedAmount));
				}
				if(ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(type))//占用
				{
				 	//额度余额 = 前额度余额 – 交易金额
					//tblCreditInfoTmp.setCreditUsableAmount(creditUsableAmount.subtract(usedAmount));
					//预占用额度 = 前预占用额度 - 交易金额
					tblCreditInfoTmp.setPreUsedAmount(preUsedAmount.subtract(usedAmount));
					//实占用额度 = 前实占用额度 + 交易金额
					tblCreditInfoTmp.setUsedAmount(usedAmounts.add(usedAmount));
				}

				if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(type))//占用恢复（释放）
				{
					//额度余额 = 前额度余额 + 交易金额
					tblCreditInfoTmp.setCreditUsableAmount(creditUsableAmount.add(usedAmount));
					//实占用额度 = 前实占用额度 - 交易金额
					tblCreditInfoTmp.setUsedAmount(usedAmounts.subtract(usedAmount));
				}

				if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(type))//直接占用
				{
				 	//额度余额 = 前额度余额 – 交易金额
					tblCreditInfoTmp.setCreditUsableAmount(creditUsableAmount.subtract(usedAmount));
					//实占用额度 = 前实占用额度 + 交易金额
					tblCreditInfoTmp.setUsedAmount(usedAmounts.add(usedAmount));
				}

				if(ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(type))//变更
				{
					//额度总额=交易金额
					tblCreditInfoTmp.setCreditAmount(usedAmount);
					//可用额度=交易金额-已使用余额
					tblCreditInfoTmp.setCreditUsableAmount(usedAmount.subtract(usedAmounts));

				}
				if(ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(type))//冻结
				{
					//额度余额 = 前额度余额 - 交易金额
					tblCreditInfoTmp.setCreditUsableAmount(creditUsableAmount.subtract(usedAmount));
					//冻结金额 = 前冻结金额 + 交易金额
					tblCreditInfoTmp.setFrzAmount(frzAmount.add(usedAmount));
				}
				if(ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(type))//解冻
				{
					//额度余额 = 前额度余额 + 交易金额
					tblCreditInfoTmp.setCreditUsableAmount(creditUsableAmount.add(usedAmount));
					//冻结金额 = 前冻结金额 - 交易金额
					tblCreditInfoTmp.setFrzAmount(frzAmount.subtract(usedAmount));
				}
				if(ScfBasConstant.CREDIT_TRADE_TYPE_END.equals(type))//终止
				{
					tblCreditInfoTmp.setStatus(ScfBasConstant.CREDIT_STATUS_TERMINATE);
					//查询是否有子额度，存在时，将子额度全部置为终止状态
					String creditNo=tblCreditInfoTmp.getCreditNo();
					List leafList=this.getSubCreditInfoByCreditNo(creditNo);
					for(int k=0;k<leafList.size();k++){
						com.huateng.scf.bas.icr.dao.model.BIcrInfo tblCreditInfoLeaf = 
								(com.huateng.scf.bas.icr.dao.model.BIcrInfo) leafList.get(k);
						tblCreditInfoLeaf.setStatus(ScfBasConstant.CREDIT_STATUS_TERMINATE);
						iBIcrInfoDAO.updateByPrimaryKeySelective(tblCreditInfoLeaf);
					}
				}
				tblCreditInfoTmp.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
				tblCreditInfoTmp.setLastUpdTime(new Date());
				tblCreditInfoTmp.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
				iBIcrInfoDAO.updateByPrimaryKeySelective(tblCreditInfoTmp);
			}
		}else{
			throw new ScubeBizException("获取额度信息失败！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
	}
	

	/**
	 *
	 * @Description: 根据额度编号查询子额度信息列表
	 * @author wenkui.xu
	 * @Created 2012-9-5上午11:10:45
	 * @param creditNo
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("rawtypes")
	public List getSubCreditInfoByCreditNo(String creditNo)throws ScubeBizException 
	{
//		StringBuffer hql=new StringBuffer("select tci from TblCreditInfo tci where 1=2 ");
//		hql.append(" or tci.upCreditNo='"+creditNo+"'");
//		hql.append(" and tci.status='"+ScfBasConstant.CREDIT_STATUS_NORMAL+"' ");
//		List list =this.find(hql.toString());
		List list = new ArrayList();
		return list;
	}
}



