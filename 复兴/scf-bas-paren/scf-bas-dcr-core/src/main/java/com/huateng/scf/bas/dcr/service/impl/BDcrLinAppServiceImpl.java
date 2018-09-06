package com.huateng.scf.bas.dcr.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.huateng.scf.bas.dcr.dao.BDcrLinAppDAO;
import com.huateng.scf.bas.dcr.dao.ext.ExtBDcrLinTypDAO;
import com.huateng.scf.bas.dcr.model.BDcrLinApp;
import com.huateng.scf.bas.dcr.model.BDcrLinAppExample;
import com.huateng.scf.bas.dcr.model.BDcrLinInf;
import com.huateng.scf.bas.dcr.model.BDcrLinAppExample.Criteria;
import com.huateng.scf.bas.dcr.service.IbDcrLinAppService;
import com.huateng.scf.bas.dcr.service.IbDcrLinInfService;
import com.huateng.scf.bas.dcr.vo.VbDcrLinApp;
import com.huateng.scf.bas.dcr.vo.VbDcrLinInf;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * IbDcrLinAppService接口实现类
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
@Service
public class BDcrLinAppServiceImpl implements IbDcrLinAppService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BDcrLinAppDAO")
	BDcrLinAppDAO bDcrLinAppDAO;
	
	@Resource(name = "extBDcrLinTypDAOImpl")
	ExtBDcrLinTypDAO  extBDcrLinTypDAO;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Resource(name = "BDcrLinInfServiceImpl")		
	IbDcrLinInfService  ibDcrLinInfService;
		
	@Override
	@Transactional
	public String add(VbDcrLinApp vbDcrLinApp) {		
		UserInfo  userInfo=ContextHolder.getUserInfo();
		BctlVO  bctlVO=	ContextHolder.getOrgInfo();
		// TODO Auto-generated method stub
		// VO转PO 展现层对象转换DAO层对象
		BDcrLinApp bDcrLinApp = new BDcrLinApp();
		try {
			BeanUtils.copyProperties(vbDcrLinApp, bDcrLinApp);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}
		
		String  appCrId=ibSysSerialNoService.genSerialNo("CR_APP_NO");
		bDcrLinApp.setAppCrId(appCrId);		
		String  todayDate=ScfDateUtil.formatDate(new Date());
		bDcrLinApp.setInputDt(todayDate);
		bDcrLinApp.setLstUpdDt(todayDate);
		bDcrLinApp.setLstUpdTlr(userInfo.getTlrNo());
		bDcrLinApp.setLstUpdTlrNm(userInfo.getTlrName());
		bDcrLinApp.setLstUpdBrCd(userInfo.getBrNo());
		bDcrLinApp.setLstUpdBrNm(bctlVO.getBrName());
		bDcrLinApp.setTlrNm(userInfo.getTlrName());
		bDcrLinApp.setTlrNo(userInfo.getTlrNo());
		bDcrLinApp.setBrCd(userInfo.getBrNo());	
		bDcrLinApp.setBrNm(bctlVO.getBrName());
		bDcrLinApp.setAprvStat(WorkflowConstant.APPLI_STATUS_DTL_WRITING);
		try {
			bDcrLinAppDAO.insertSelective(bDcrLinApp);
		} catch (Exception e) {
			log.warn("插入异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50001),BSysErrorConstant.SCF_BAS_DCR_50001);
		}
		return  appCrId;
	}

	@Override
	@Transactional
	public String update(VbDcrLinApp vbDcrLinApp) {
		// TODO Auto-generated method stub
		// VO转PO 展现层对象转换DAO层对象
		BDcrLinApp bDcrLinApp = new BDcrLinApp();
		try {
			BeanUtils.copyProperties(vbDcrLinApp, bDcrLinApp);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		UserInfo  userInfo=ContextHolder.getUserInfo();
		BctlVO  bctlVO=	ContextHolder.getOrgInfo();
		String  todayDate=ScfDateUtil.formatDate(new Date());
		bDcrLinApp.setLstUpdDt(todayDate);
		bDcrLinApp.setLstUpdTlr(userInfo.getTlrNo());
		bDcrLinApp.setLstUpdTlrNm(userInfo.getTlrName());
		bDcrLinApp.setLstUpdBrCd(userInfo.getBrNo());
		bDcrLinApp.setLstUpdBrNm(bctlVO.getBrName());	
		BDcrLinApp	selectBDcrLinApp=bDcrLinAppDAO.selectByPrimaryKey(vbDcrLinApp.getAppCrId());
		String rootId= selectBDcrLinApp.getParentId();
		if(StringUtils.isBlank(rootId)){
			//rootId为空初始化授信额度信息表根节点信息
			VbDcrLinInf  vbDcrLinInf=new  VbDcrLinInf();
			vbDcrLinInf.setCircFlag(bDcrLinApp.getCircFlag());
			vbDcrLinInf.setCrAmt(bDcrLinApp.getCrAmt());
			vbDcrLinInf.setCurcd(bDcrLinApp.getCurcd());
			vbDcrLinInf.setParentId("0");
			vbDcrLinInf.setRiskAmt(bDcrLinApp.getRiskAmt());	
			vbDcrLinInf.setLinLvl(new BigDecimal("1") );
			vbDcrLinInf.setLinTyp("0");
			vbDcrLinInf.setBusNm(bDcrLinApp.getCrNm());
			rootId=ibDcrLinInfService.add(vbDcrLinInf);	
			bDcrLinApp.setParentId(rootId);
		} else {
			//rootId有值，已经存在根节点信息，更新节点信息
			VbDcrLinInf  vbDcrLinInf=new  VbDcrLinInf();
			vbDcrLinInf.setCircFlag(bDcrLinApp.getCircFlag());
			vbDcrLinInf.setCrAmt(bDcrLinApp.getCrAmt());
			vbDcrLinInf.setCurcd(bDcrLinApp.getCurcd());
			vbDcrLinInf.setRiskAmt(bDcrLinApp.getRiskAmt());	
			vbDcrLinInf.setLinId(rootId);			
			ibDcrLinInfService.update(vbDcrLinInf);
		}
		int i;
		try {
			i = bDcrLinAppDAO.updateByPrimaryKeySelective(bDcrLinApp);
		} catch (Exception e) {
			log.warn("更新异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50005),BSysErrorConstant.SCF_BAS_DCR_50005);

		}
		return rootId;
	}

	@Override
	@Transactional
	public int delete(String key) {
		// TODO Auto-generated method stub
		log.debug("delete传递参数,key="+key);
		int i;
		try {
			i = bDcrLinAppDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.warn("删除异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50003),BSysErrorConstant.SCF_BAS_DCR_50003);
		}

		return i;
	}
	
	
	@Override
	@Transactional
	public void deleteBdcrLinApp(String key) {		
		log.debug("deleteBdcrLinApp传递参数,key="+key);
		if(StringUtils.isBlank(key)){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004),BSysErrorConstant.SCF_BAS_DCR_50004);		
		}
		BDcrLinApp bDcrLinApp = bDcrLinAppDAO.selectByPrimaryKey(key);
        if(bDcrLinApp==null){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50003),BSysErrorConstant.SCF_BAS_DCR_50003);
        }
       delete(key);       
       String rootid=bDcrLinApp.getParentId();
   	   if(!StringUtils.isBlank(rootid)){
		   List<BDcrLinInf>  bDcrLinInflist=ibDcrLinInfService.selectTreePoByRootId(rootid);
			for(BDcrLinInf bDcrLinInf:bDcrLinInflist){
				ibDcrLinInfService.delete(bDcrLinInf.getLinId());
			}
     	} 
		
	}	
	
	
	
	

	@Override
	public Page findObjectConditionByPage(int pageNo, int pageSize,VbDcrLinApp vbDcrLinApp) {
		Page p = new Page(pageSize, pageNo,0);
		BDcrLinAppExample example = new BDcrLinAppExample();
		example.setOrderByClause("APP_CR_ID  desc");
	    Criteria cri = example.createCriteria();
		if (vbDcrLinApp != null) {
			if (vbDcrLinApp.getAppCrId() != null && vbDcrLinApp.getAppCrId().length() > 0) {
				cri.andAppCrIdEqualTo(vbDcrLinApp.getAppCrId().trim());

			}
			if (vbDcrLinApp.getCustNm() != null &&vbDcrLinApp.getCustNm().length() > 0) {
				cri.andCustNmLike("%" + vbDcrLinApp.getCustNm().trim() + "%");

			}
		}

		bDcrLinAppDAO.selectByPage(example, p);
		log.debug("totalPage=" + p.getTotalPage());
		log.debug("totalRecord=" + p.getTotalRecord());
		log.debug("current=" + p.getCurrent());
		return p;
	}

	@Override
	public List queryCrNmSource() {
		Map  omap=new HashMap(); 
		omap.put("stat", "1");//1:有效
		 List	 bDcrLinTypList =extBDcrLinTypDAO.queryCrNmSource(omap);
		return bDcrLinTypList;
	}

	@Override
	public Page queryCustSource(int pageNo, int pageSize,Map value) {
		log.debug("queryCustSource传递参数,value="+value);
		Page p = new Page(pageSize, pageNo,0);
		Map  omap=new HashMap(); 
		if(value!=null&&value.get("custcd")!=null&&value.get("cname")!=null){
			omap.put("custcd",value.get("custcd").toString().trim());
			omap.put("cname", value.get("cname").toString().trim());
		}

		extBDcrLinTypDAO.queryCustList(omap,p);
		return p;
	}

	@Override
	public VbDcrLinApp findVbDcrLinAppByKey(String key) {
		// TODO Auto-generated method stub
		// PO转VO DAO层对象转换 展现层对象
		log.debug("findVbDcrLinAppByKey传递参数,key="+key);
		if(StringUtils.isBlank(key)){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004),BSysErrorConstant.SCF_BAS_DCR_50004);		
		}
		BDcrLinApp bDcrLinApp = bDcrLinAppDAO.selectByPrimaryKey(key);
		VbDcrLinApp vbDcrLinApp = new VbDcrLinApp();
		try {
		   BeanUtils.copyProperties(bDcrLinApp, vbDcrLinApp);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		return vbDcrLinApp;
	}

	@Override
	@Transactional
	public int updateBDcrLinApp(VbDcrLinApp vbDcrLinApp) {
		// TODO Auto-generated method stub
		// VO转PO 展现层对象转换DAO层对象
		BDcrLinApp bDcrLinApp = new BDcrLinApp();
		try {
			BeanUtils.copyProperties(vbDcrLinApp, bDcrLinApp);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		
		int i;
		try {
			UserInfo  userInfo=ContextHolder.getUserInfo();
			BctlVO  bctlVO=	ContextHolder.getOrgInfo();
			String  todayDate=ScfDateUtil.formatDate(new Date());
			bDcrLinApp.setLstUpdDt(todayDate);
			bDcrLinApp.setLstUpdTlr(userInfo.getTlrNo());
			bDcrLinApp.setLstUpdTlrNm(userInfo.getTlrName());
			bDcrLinApp.setLstUpdBrCd(userInfo.getBrNo());
			bDcrLinApp.setLstUpdBrNm(bctlVO.getBrName());	
			i = bDcrLinAppDAO.updateByPrimaryKeySelective(bDcrLinApp);
		} catch (Exception e) {
			log.warn("更新异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50005),BSysErrorConstant.SCF_BAS_DCR_50005);

		}
		return i;	
		
	}

	@Override
	@Transactional
	public void submitFlowForBDcrLinAppStat(String key) {
		// TODO Auto-generated method stub		
		VbDcrLinApp vbDcrLinApp=new  VbDcrLinApp();		
		vbDcrLinApp.setAppCrId(key);
		//已提交
		vbDcrLinApp.setAprvStat(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
		updateBDcrLinApp(vbDcrLinApp);
		
	}
	

}
