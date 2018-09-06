/**
 * 
 */
package com.huateng.scf.bas.icr.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CreditInterParamVO;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.icr.dao.IBIcrDtlDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrDtlExample;
import com.huateng.scf.bas.icr.dao.model.BIcrDtlExample.Criteria;
import com.huateng.scf.bas.icr.model.BIcrDtl;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.CreditInterParamBean;
import com.huateng.scf.bas.icr.service.IBIcrDtlService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月9日下午1:00:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月9日下午1:00:11	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BIcrDtlServiceImpl")
public class BIcrDtlServiceImpl implements IBIcrDtlService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BIcrDtlDAO")
	IBIcrDtlDAO bIcrDtlDao;
	@Resource(name = IBIcrInfoService.BEAN_ID)
	IBIcrInfoService bIcrInfoService;  //额度信息
	@Override
	@Transactional
	public void add(BIcrDtl bIcrDtl) throws ScubeBizException {
		ScfCommonUtil.setCommonField(bIcrDtl);//设置公共字段 add by huangshuidan 2016-11-11
		bIcrDtl.setId(UUIDGeneratorUtil.generate()); //id
		// 获取机构信息
		BctlVO BctlVO = ContextHolder.getOrgInfo();
		String brcode = BctlVO.getBrNo();
		bIcrDtl.setBrcode(brcode);//经办机构
		com.huateng.scf.bas.icr.dao.model.BIcrDtl bIcrDtlDal = new com.huateng.scf.bas.icr.dao.model.BIcrDtl();
		try {
			BeanUtils.copyProperties(bIcrDtl, bIcrDtlDal);
		} catch (BeansException e) {
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_ICR_40002),BSysErrorConstant.SCF_BAS_ICR_40002);
		}
		try {
			bIcrDtlDao.insert(bIcrDtlDal);
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_ICR_40003),BSysErrorConstant.SCF_BAS_ICR_40003);
		}
	}

	@Override
	@Transactional
	public int update(BIcrDtl bIcrDtl) throws ScubeBizException{
		// TODO Auto-generated method stub
		com.huateng.scf.bas.icr.dao.model.BIcrDtl bIcrDtlDal = new com.huateng.scf.bas.icr.dao.model.BIcrDtl();
		BeanUtils.copyProperties(bIcrDtl, bIcrDtlDal);
		return bIcrDtlDao.updateByPrimaryKey(bIcrDtlDal);
	}

	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException{
		// TODO Auto-generated method stub
		log.info("BIcrDtlServiceImpl delete  id:"+id);
		return bIcrDtlDao.deleteByPrimaryKey(id);
	}

	@Override
	public Page queryBIcrDtlByPage(int pageNo, int pageSize, BIcrDtl bIcrDtl)throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);

		BIcrDtlExample example = new BIcrDtlExample();
		Criteria cri = example.createCriteria();
		if (bIcrDtl != null) {
			if (bIcrDtl.getAppno() != null&&bIcrDtl.getAppno().length()>0) {
				cri.andAppnoEqualTo(bIcrDtl.getAppno());
			}
			if(bIcrDtl.getCreditNo()!=null&&bIcrDtl.getCreditNo().length()>0){
				cri.andCreditNoEqualTo(bIcrDtl.getCreditNo());
			}
			
		}
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bIcrDtlDao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}

	@Override
	public BIcrDtl queryBIcrDtlgKey(String key) throws ScubeBizException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.icr.service.IBIcrDtlService#addCreditDetail(com.huateng.scf.bas.common.model.CreditInterParamVO, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.math.BigDecimal, com.huateng.scf.bas.icr.model.BIcrInfo)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void addCreditDetail(CreditInterParamVO creditInterParamBean, String custcd, String otherCustcd,
			String creditType, String type, BigDecimal amount, BIcrInfo bIcrInfo) throws ScubeBizException {
		BIcrDtl bIcrDtl = new BIcrDtl();
		if(null!=creditInterParamBean){
			try {
				BeanUtils.copyProperties(creditInterParamBean,bIcrDtl);
			} catch (BeansException e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_ICR_40002),BSysErrorConstant.SCF_BAS_ICR_40002);
			}
		}
		
		bIcrDtl.setCustcd(custcd);
		bIcrDtl.setOperType(type);
		bIcrDtl.setCreditAmount(amount);
		bIcrDtl.setPreUsedAmount(new BigDecimal("0"));
		bIcrDtl.setUsedAmount(new BigDecimal("0"));
		bIcrDtl.setFrzAmount(new BigDecimal("0"));
		bIcrDtl.setCreditUsableAmount(new BigDecimal("0"));
		bIcrDtl.setCommonAmount(amount);

		if(bIcrDtl.getCreditNo()==null){
			BIcrInfo icrInfo=null;
			if (bIcrInfo == null){
				List list=bIcrInfoService.checkCredit(custcd, otherCustcd, creditType);
				if(list!=null&&list.size()>0){
					icrInfo=(BIcrInfo) list.get(0);
				}
			}else{
				icrInfo = bIcrInfo;
			}
			bIcrDtl.setCreditNo(icrInfo.getCreditNo());
			bIcrDtl.setCreditAmount(icrInfo.getCreditAmount());
			bIcrDtl.setPreUsedAmount(icrInfo.getPreUsedAmount());
			bIcrDtl.setUsedAmount(icrInfo.getUsedAmount());
			bIcrDtl.setFrzAmount(icrInfo.getFrzAmount());
			bIcrDtl.setCreditUsableAmount(icrInfo.getCreditUsableAmount());
			BigDecimal creditAmount=(bIcrDtl.getCreditAmount()==null?new BigDecimal("0"):bIcrDtl.getCreditAmount());
			BigDecimal creditUsableAmount=(bIcrDtl.getCreditUsableAmount()==null?new BigDecimal("0"):bIcrDtl.getCreditUsableAmount());
			if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(type)){//预占用
				bIcrDtl.setCommonAmount(creditAmount.subtract(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(type)){//预占用恢复（释放）
				bIcrDtl.setCommonAmount(creditUsableAmount.add(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(type)){//占用
				bIcrDtl.setCommonAmount(creditUsableAmount);
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(type)){//占用恢复（释放）
				bIcrDtl.setCommonAmount(creditUsableAmount.add(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(type)){//直接占用
				bIcrDtl.setCommonAmount(creditUsableAmount.subtract(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(type)){//变更
				bIcrDtl.setCommonAmount(amount);
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(type)){//冻结
				bIcrDtl.setCommonAmount(creditUsableAmount.subtract(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(type)){//解冻
				bIcrDtl.setCommonAmount(creditUsableAmount.add(amount));
			}
		}
		ScfGlobalInfo scfGlobalInfo = ScfBaseData.getScfGlobalInfoData();
		bIcrDtl.setCommonDate(scfGlobalInfo.getTxnDate());
		bIcrDtl.setAmount(amount);
		bIcrDtl.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		bIcrDtl.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		bIcrDtl.setLastUpdTime(new Date());
		bIcrDtl.setTxdate(scfGlobalInfo.getTxnDate());
		bIcrDtl.setTxtime(new Date());
		bIcrDtl.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);
		bIcrDtl.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.bas.icr.dao.model.BIcrDtl bIcrDtlDal = new com.huateng.scf.bas.icr.dao.model.BIcrDtl();
		try {
			BeanUtils.copyProperties(bIcrDtl, bIcrDtlDal);
		} catch (BeansException e) {
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_ICR_40002),BSysErrorConstant.SCF_BAS_ICR_40002);
		}
		bIcrDtlDao.insertSelective(bIcrDtlDal);

	}

	/**
	 *  额度接口操作-记录融资额度流水
	 * @param creditInterParamBean
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param type
	 * @param amount
	 * @param bIcrInfo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午3:55:50
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addCreditDetail(CreditInterParamBean creditInterParamBean,
			String custcd, String otherCustcd, String creditType, String type,
			BigDecimal amount, BIcrInfo bIcrInfo) throws ScubeBizException
	{
		BIcrDtl tblCreditDetail = new BIcrDtl();
		BeanUtils.copyProperties(creditInterParamBean, tblCreditDetail);
		tblCreditDetail.setCustcd(custcd);
		tblCreditDetail.setOperType(type);
		tblCreditDetail.setCreditAmount(amount);
		tblCreditDetail.setPreUsedAmount(new BigDecimal("0"));
		tblCreditDetail.setUsedAmount(new BigDecimal("0"));
		tblCreditDetail.setFrzAmount(new BigDecimal("0"));
		tblCreditDetail.setCreditUsableAmount(new BigDecimal("0"));
		tblCreditDetail.setCommonAmount(amount);

		if(tblCreditDetail.getCreditNo()==null){
			BIcrInfo tblCreditInfo = null;
			if (bIcrInfo == null){
				List<BIcrInfo> list = bIcrInfoService.checkCredit(custcd, otherCustcd, creditType);
				if(list!=null&&list.size()>0){
					tblCreditInfo=(BIcrInfo) list.get(0);
				}
			}else{
				tblCreditInfo = bIcrInfo;
			}
			tblCreditDetail.setCreditNo(tblCreditInfo.getCreditNo());
			tblCreditDetail.setCreditAmount(tblCreditInfo.getCreditAmount());
			tblCreditDetail.setPreUsedAmount(tblCreditInfo.getPreUsedAmount());
			tblCreditDetail.setUsedAmount(tblCreditInfo.getUsedAmount());
			tblCreditDetail.setFrzAmount(tblCreditInfo.getFrzAmount());
			tblCreditDetail.setCreditUsableAmount(tblCreditInfo.getCreditUsableAmount());
			BigDecimal creditAmount=(tblCreditDetail.getCreditAmount()==null?new BigDecimal("0"):tblCreditDetail.getCreditAmount());
			BigDecimal creditUsableAmount=(tblCreditDetail.getCreditUsableAmount()==null?new BigDecimal("0"):tblCreditDetail.getCreditUsableAmount());
			if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(type)){//预占用
				tblCreditDetail.setCommonAmount(creditAmount.subtract(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(type)){//预占用恢复（释放）
				tblCreditDetail.setCommonAmount(creditUsableAmount.add(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(type)){//占用
				tblCreditDetail.setCommonAmount(creditUsableAmount);
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(type)){//占用恢复（释放）
				tblCreditDetail.setCommonAmount(creditUsableAmount.add(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(type)){//直接占用
				tblCreditDetail.setCommonAmount(creditUsableAmount.subtract(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(type)){//变更
				tblCreditDetail.setCommonAmount(amount);
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(type)){//冻结
				tblCreditDetail.setCommonAmount(creditUsableAmount.subtract(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(type)){//解冻
				tblCreditDetail.setCommonAmount(creditUsableAmount.add(amount));
			}
		}

		tblCreditDetail.setCommonDate(ScfDateUtil.getStringDate(new Date()));
		tblCreditDetail.setAmount(amount);
		tblCreditDetail.setLastUpdTime(new Date());
		tblCreditDetail.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		tblCreditDetail.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		tblCreditDetail.setTxdate(ScfDateUtil.getStringDate(new Date()));
		tblCreditDetail.setTxtime(new Date());
		tblCreditDetail.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);
		tblCreditDetail.setId(null);
		this.add(tblCreditDetail);

	}


	/**
	 * @Description: 额度接口操作-记录融资额度流水
	 * @author wenkui.xu
	 * @Created 2012-9-10下午03:50:47
	 * @param obj
	 * @param type 交易操作类型
	 * @param amount 交易金额
	 * @throws CommonException
	 */
	public void addCreditDetailChg(CreditInterParamBean creditInterParamBean,
			String custcd, String otherCustcd, String creditType, String type,
			BigDecimal amount, BIcrInfo orgTblCreditInfo){
		BIcrDtl tblCreditDetail = new BIcrDtl();
		BeanUtils.copyProperties(creditInterParamBean, tblCreditDetail);
		tblCreditDetail.setCustcd(custcd);
		tblCreditDetail.setOperType(type);
		tblCreditDetail.setCreditAmount(orgTblCreditInfo.getCreditAmount());
		tblCreditDetail.setPreUsedAmount(new BigDecimal("0"));
		tblCreditDetail.setUsedAmount(new BigDecimal("0"));
		tblCreditDetail.setFrzAmount(new BigDecimal("0"));
		tblCreditDetail.setCreditUsableAmount(new BigDecimal("0"));
		tblCreditDetail.setCommonAmount(amount);

		BIcrInfo tblCreditInfo = null;
				tblCreditInfo = orgTblCreditInfo;
			tblCreditDetail.setCreditNo(tblCreditInfo.getCreditNo());
			tblCreditDetail.setCreditAmount(tblCreditInfo.getCreditAmount());
			tblCreditDetail.setPreUsedAmount(tblCreditInfo.getPreUsedAmount());
			tblCreditDetail.setUsedAmount(tblCreditInfo.getUsedAmount());
			tblCreditDetail.setFrzAmount(tblCreditInfo.getFrzAmount());
			tblCreditDetail.setCreditUsableAmount(tblCreditInfo.getCreditUsableAmount());
			BigDecimal creditAmount=(tblCreditDetail.getCreditAmount()==null?new BigDecimal("0"):tblCreditDetail.getCreditAmount());
			BigDecimal creditUsableAmount=(tblCreditDetail.getCreditUsableAmount()==null?new BigDecimal("0"):tblCreditDetail.getCreditUsableAmount());
			if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(type)){//预占用
				tblCreditDetail.setCommonAmount(creditAmount.subtract(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(type)){//预占用恢复（释放）
				tblCreditDetail.setCommonAmount(creditUsableAmount.add(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(type)){//占用
				tblCreditDetail.setCommonAmount(creditUsableAmount);
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(type)){//占用恢复（释放）
				tblCreditDetail.setCommonAmount(creditUsableAmount.add(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(type)){//直接占用
				tblCreditDetail.setCommonAmount(creditUsableAmount.subtract(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(type)){//变更
				tblCreditDetail.setCommonAmount(amount);
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(type)){//冻结
				tblCreditDetail.setCommonAmount(creditUsableAmount.subtract(amount));
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(type)){//解冻
				tblCreditDetail.setCommonAmount(creditUsableAmount.add(amount));
			}

		tblCreditDetail.setCommonDate(BSysConstant.WORKDATE);
		tblCreditDetail.setAmount(amount);
		tblCreditDetail.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		tblCreditDetail.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		tblCreditDetail.setLastUpdTime(new Date());
		tblCreditDetail.setTxdate(BSysConstant.WORKDATE);
		tblCreditDetail.setTxtime(new Date());
		tblCreditDetail.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);
		tblCreditDetail.setId(null);
		this.add(tblCreditDetail);

	}
	
	/**
	 * 新增额度流水信息（用于应收类放款申请）
	 * @param creditInterParamBean
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param type
	 * @param amount
	 * @param bIcrInfo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年8月3日下午4:26:47
	 */
	@Override
	@Transactional
	public void addCreditDetailForDuebill(CreditInterParamVO creditInterParamVO, String custcd, String otherCustcd,
			String creditType, String type, BigDecimal amount, BIcrInfo bIcrInfo) throws ScubeBizException {
		BIcrDtl bIcrDtl = new BIcrDtl();
		if(null!=creditInterParamVO){
			try {
				BeanUtils.copyProperties(creditInterParamVO,bIcrDtl);
			} catch (BeansException e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_ICR_40002),BSysErrorConstant.SCF_BAS_ICR_40002);
			}
		}
		
		bIcrDtl.setCustcd(custcd);
		bIcrDtl.setOperType(type);
		bIcrDtl.setCreditNo(bIcrInfo.getCreditNo());
		bIcrDtl.setCreditAmount(bIcrInfo.getCreditAmount());
		bIcrDtl.setPreUsedAmount(bIcrInfo.getPreUsedAmount());
		bIcrDtl.setUsedAmount(bIcrInfo.getUsedAmount());
		bIcrDtl.setFrzAmount(bIcrInfo.getFrzAmount());
		bIcrDtl.setCreditUsableAmount(bIcrInfo.getCreditUsableAmount());
		bIcrDtl.setCommonAmount(bIcrInfo.getCreditUsableAmount());
		
		ScfGlobalInfo scfGlobalInfo = ScfBaseData.getScfGlobalInfoData();
		bIcrDtl.setCommonDate(scfGlobalInfo.getTxnDate());
		bIcrDtl.setAmount(amount);
		bIcrDtl.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		bIcrDtl.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		bIcrDtl.setLastUpdTime(new Date());
		bIcrDtl.setTxdate(scfGlobalInfo.getTxnDate());
		bIcrDtl.setTxtime(new Date());
		bIcrDtl.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);
		bIcrDtl.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.bas.icr.dao.model.BIcrDtl bIcrDtlDal = new com.huateng.scf.bas.icr.dao.model.BIcrDtl();
		try {
			BeanUtils.copyProperties(bIcrDtl, bIcrDtlDal);
		} catch (BeansException e) {
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_ICR_40002),BSysErrorConstant.SCF_BAS_ICR_40002);
		}
		bIcrDtlDao.insertSelective(bIcrDtlDal);
	}
}
