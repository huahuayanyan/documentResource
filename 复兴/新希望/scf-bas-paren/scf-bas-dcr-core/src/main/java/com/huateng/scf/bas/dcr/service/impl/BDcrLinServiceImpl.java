package com.huateng.scf.bas.dcr.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.dcr.dao.BDcrLinDAO;
import com.huateng.scf.bas.dcr.model.BDcrLin;
import com.huateng.scf.bas.dcr.model.BDcrLinExample;
import com.huateng.scf.bas.dcr.model.BDcrLinExample.Criteria;
import com.huateng.scf.bas.dcr.service.IbDcrLinAppService;
import com.huateng.scf.bas.dcr.service.IbDcrLinService;
import com.huateng.scf.bas.dcr.vo.VbDcrLin;
import com.huateng.scf.bas.dcr.vo.VbDcrLinApp;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * IbDcrLinService接口实现类
 *
 * @author huateng
 * @date 2016年7月6日
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=================
 * Modifier			date			Content
 * huateng			2016年7月6日			新增
 *
 *            </pre>
 */
@ScubeService
@Service("BDcrLinServiceImpl")
public class BDcrLinServiceImpl implements IbDcrLinService,DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BDcrLinDAO")
	BDcrLinDAO bDcrLinDAO;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Resource(name = "BDcrLinAppServiceImpl")		
	IbDcrLinAppService  ibDcrLinAppService;
	
	@Resource(name = "BDcrLinInfServiceImpl")		
	BDcrLinInfServiceImpl  bDcrLinInfService;
	
	

	@Override
	@Transactional
	public String add(VbDcrLin vbDcrLin) {
		// TODO Auto-generated method stub	
		// VO转PO 展现层对象转换DAO层对象
		BDcrLin bDcrLin = new BDcrLin();
		try {
			BeanUtils.copyProperties(vbDcrLin, bDcrLin);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}
		String  bcCrId=ibSysSerialNoService.genSerialNo("CR_BC_NO");		
		bDcrLin.setBcCrId(bcCrId);
		String  todayDate=ScfDateUtil.formatDate(new Date());		
		UserInfo  userInfo=ContextHolder.getUserInfo();
		BctlVO  bctlVO=	ContextHolder.getOrgInfo();
		bDcrLin.setLstUpdDt(todayDate);
		bDcrLin.setLstUpdTlr(userInfo.getTlrNo());
		bDcrLin.setLstUpdTlrNm(userInfo.getTlrName());
		bDcrLin.setLstUpdBrCd(userInfo.getBrNo());
		bDcrLin.setLstUpdBrNm(bctlVO.getBrName());	
		bDcrLin.setEffectDt(todayDate);
		bDcrLin.setStat(LinStatEnum.VALID.getValue());//有效
		
		try {
			bDcrLinDAO.insertSelective(bDcrLin);
		} catch (Exception e) {
			log.warn("插入异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50001),BSysErrorConstant.SCF_BAS_DCR_50001);
		}
		return bcCrId;
	}

	@Override
	public Page findObjectConditionByPage(int pageNo, int pageSize, VbDcrLin vbDcrLin) {
		// TODO Auto-generated method stub
		Page p = new Page(pageSize, pageNo,0);
		BDcrLinExample example = new BDcrLinExample();
	    Criteria cri = example.createCriteria();
		example.setOrderByClause("EFFECT_DT");
		if (vbDcrLin != null) {
			if(StringUtils.isNotBlank(vbDcrLin.getCustNm())){
				cri.andCustNmLike("%" +vbDcrLin.getCustNm()+"%" );
			}
			
			if(StringUtils.isNotBlank(vbDcrLin.getBcCrId())){
				cri.andBcCrIdEqualTo(vbDcrLin.getBcCrId());
			}	
			
			if(StringUtils.isNotBlank(vbDcrLin.getStat())){
				cri.andStatEqualTo(vbDcrLin.getStat());
			}	

		}
		bDcrLinDAO.selectByPage(example, p);
		log.debug("totalPage=" + p.getTotalPage());
		log.debug("totalRecord=" + p.getTotalRecord());
		log.debug("current=" + p.getCurrent());
		return p;
	}

	@Override
	public VbDcrLin findVbDcrLinByKey(String key) {
		// TODO Auto-generated method stub
		// PO转VO DAO层对象转换 展现层对象
		log.debug("findVbDcrLinByKey传递参数,key="+key);
		if(StringUtils.isBlank(key)){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004),BSysErrorConstant.SCF_BAS_DCR_50004);		
		}
		BDcrLin bDcrLin = bDcrLinDAO.selectByPrimaryKey(key);
		VbDcrLin vbDcrLin = new VbDcrLin();
		try {
		   BeanUtils.copyProperties(bDcrLin, vbDcrLin);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		return vbDcrLin;
	}

	@Override
	@Transactional
	public String approveBDcrLin(String key) {
		// TODO Auto-generated method stub
		VbDcrLinApp vbDcrLinApp=ibDcrLinAppService.findVbDcrLinAppByKey(key);
		VbDcrLin vbDcrLin=new   VbDcrLin();		
		try {
			   BeanUtils.copyProperties(vbDcrLinApp, vbDcrLin);
			} catch (BeansException e) {
				log.warn("转换异常", e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

			}
		String bcCrId= add(vbDcrLin);
		bDcrLinInfService.updateBcCrIdForPass(vbDcrLin.getParentId(), bcCrId);
		vbDcrLinApp.setAprvStat(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		ibDcrLinAppService.updateBDcrLinApp(vbDcrLinApp) ;
		return vbDcrLin.getBcCrId();
	}

	

	@Transactional
	public int update(BDcrLin bDcrLin ) {

		int i;
		try {
			i = bDcrLinDAO.updateByPrimaryKeySelective(bDcrLin);
		} catch (Exception e) {
			log.warn("更新异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50005),BSysErrorConstant.SCF_BAS_DCR_50005);

		}

		return i;
	}

	
	
	@Override
	@Transactional
	public void freezeVbDcrLinByKey(String key) {
		// TODO Auto-generated method stub
//		0	冻结
//		1	有效
		BDcrLin bDcrLin =  new  BDcrLin();
		bDcrLin.setBcCrId(key);
		bDcrLin.setStat(LinStatEnum.FREEZE.getValue());
		update(bDcrLin);
	}

	@Override
	@Transactional
	public void unfreezeVbDcrLinByKey(String key) {
		// TODO Auto-generated method stub
//		0	冻结
//		1	有效
		BDcrLin bDcrLin =  new  BDcrLin();
		bDcrLin.setBcCrId(key);
		bDcrLin.setStat(LinStatEnum.VALID.getValue());
		update(bDcrLin);
		
	}

	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// TODO Auto-generated method stub
		VbDcrLinApp vbDcrLinApp=ibDcrLinAppService.findVbDcrLinAppByKey(appNo);
		VbDcrLin vbDcrLin=new   VbDcrLin();		
		try {
			   BeanUtils.copyProperties(vbDcrLinApp, vbDcrLin);
			} catch (BeansException e) {
				log.warn("转换异常", e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

			}
		String bcCrId= add(vbDcrLin);
		bDcrLinInfService.updateBcCrIdForPass(vbDcrLin.getParentId(), bcCrId);
		vbDcrLinApp.setAprvStat(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		ibDcrLinAppService.updateBDcrLinApp(vbDcrLinApp) ;
		
	}

	@Override
	@Transactional
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub
		VbDcrLinApp vbDcrLinApp=ibDcrLinAppService.findVbDcrLinAppByKey(appNo);
		vbDcrLinApp.setAprvStat(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		ibDcrLinAppService.updateBDcrLinApp(vbDcrLinApp) ;	
	}
	
	
	public List findBDcrLinList(VbDcrLin vbDcrLin) {
		// TODO Auto-generated method stub
		BDcrLinExample example = new BDcrLinExample();
	    Criteria cri = example.createCriteria();
		if (vbDcrLin != null) {
			if(StringUtils.isNotBlank(vbDcrLin.getCustId())){
				cri.andCustIdEqualTo(vbDcrLin.getCustId());
			}
			
			if(StringUtils.isNotBlank(vbDcrLin.getStat())){
				cri.andStatEqualTo(vbDcrLin.getStat());
			}	
			if(StringUtils.isNotBlank(vbDcrLin.getCrId())){
				cri.andCrIdEqualTo(vbDcrLin.getCrId());
			}	
		}
	    List<BDcrLin>  bDcrLinList=bDcrLinDAO.selectByExample(example);

		return bDcrLinList;
	}

	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub
		
	}

}
