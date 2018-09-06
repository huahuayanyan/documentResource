package com.huateng.scf.bas.dcr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.dcr.dao.BDcrLinInfDAO;
import com.huateng.scf.bas.dcr.dao.ext.ExtBDcrLinInfDAO;
import com.huateng.scf.bas.dcr.model.BDcrLinExample;
import com.huateng.scf.bas.dcr.model.BDcrLinInf;
import com.huateng.scf.bas.dcr.model.BDcrLinExample.Criteria;
import com.huateng.scf.bas.dcr.service.IbDcrLinInfService;
import com.huateng.scf.bas.dcr.vo.VbDcrLin;
import com.huateng.scf.bas.dcr.vo.VbDcrLinInf;
import com.huateng.scf.bas.dcr.vo.VbDcrLinInfTree;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * IbDcrLinInfService接口实现类
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
public class BDcrLinInfServiceImpl implements IbDcrLinInfService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BDcrLinInfDAO")
	BDcrLinInfDAO  bDcrLinInfDAO;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
    @Resource(name = "extBDcrLinInfDAOImpl")		
	ExtBDcrLinInfDAO  extBDcrLinInfDAO;

	@Override
	@Transactional
	public String add(VbDcrLinInf vbDcrLinInf) {
		// TODO Auto-generated method stub
		// VO转PO 展现层对象转换DAO层对象
		BDcrLinInf bDcrLinInf = new BDcrLinInf();
		try {
			BeanUtils.copyProperties(vbDcrLinInf, bDcrLinInf);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}
		String  linId=ibSysSerialNoService.genSerialNo("CR_LIN_NO");
		bDcrLinInf.setLinId(linId);		
		
		try {
			bDcrLinInfDAO.insertSelective(bDcrLinInf);
		} catch (Exception e) {
			log.warn("插入异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50001),BSysErrorConstant.SCF_BAS_DCR_50001);
		}
		
         return  linId;
	}

	@Override
	@Transactional
	public int update(VbDcrLinInf vbDcrLinInf) {
		// TODO Auto-generated method stub
		// VO转PO 展现层对象转换DAO层对象
		BDcrLinInf bDcrLinInf = new BDcrLinInf();
		try {
			BeanUtils.copyProperties(vbDcrLinInf, bDcrLinInf);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		int i;
		try {
			i = bDcrLinInfDAO.updateByPrimaryKeySelective(bDcrLinInf);
		} catch (Exception e) {
			log.warn("更新异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50005),BSysErrorConstant.SCF_BAS_DCR_50005);

		}
		return i;
	}

	@Override
	@Transactional
	public int delete(String key) {
		// TODO Auto-generated method stub
		
		log.debug("delete传递参数,key="+key);
		int i;
		try {
			i = bDcrLinInfDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.warn("删除异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50003),BSysErrorConstant.SCF_BAS_DCR_50003);
		}

		return i;
	}


	@Override
	public VbDcrLinInf findVbDcrLinInfByKey(String key) {
		// TODO Auto-generated method stub
		// PO转VO DAO层对象转换 展现层对象
		log.debug("findVbDcrLinAppByKey传递参数,key="+key);
		if(StringUtils.isBlank(key)){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004),BSysErrorConstant.SCF_BAS_DCR_50004);		
		}
		BDcrLinInf bDcrLinInf = bDcrLinInfDAO.selectByPrimaryKey(key);
		VbDcrLinInf vbDcrLinInf = new VbDcrLinInf();
		try {
		   BeanUtils.copyProperties(bDcrLinInf, vbDcrLinInf);
		   
		   vbDcrLinInf.setUsedNum(vbDcrLinInf.getUsedNum()==null?new BigDecimal("0"):vbDcrLinInf.getUsedNum());
		   vbDcrLinInf.setAbleNum((vbDcrLinInf.getCrAmt()==null?new BigDecimal("0"):vbDcrLinInf.getCrAmt()).subtract(vbDcrLinInf.getUsedNum()));
		   
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		return vbDcrLinInf;
	}

	@Override
	public List selectTreeByRootId(String key) {
		// TODO Auto-generated method stub
	    List<BDcrLinInf>  bDcrLinInfList=extBDcrLinInfDAO.selectTreeByRootId(key);
	    List<VbDcrLinInfTree>     vbDcrLinInfTreeList=new  ArrayList<VbDcrLinInfTree>();
	    for(BDcrLinInf bDcrLinInf: bDcrLinInfList){
	    	   VbDcrLinInfTree  vbDcrLinInfTree=new  VbDcrLinInfTree();
			   BeanUtils.copyProperties(bDcrLinInf, vbDcrLinInfTree);
			   vbDcrLinInfTree.setTreeId(vbDcrLinInfTree.getLinId());
			   vbDcrLinInfTree.setTreeParentId(vbDcrLinInfTree.getParentId());
			   vbDcrLinInfTree.setTreeLevel(Integer.toString(vbDcrLinInfTree.getLinLvl().intValue()));
			   vbDcrLinInfTree.setUsedNum(vbDcrLinInfTree.getUsedNum()==null?new BigDecimal("0"):vbDcrLinInfTree.getUsedNum());
			   vbDcrLinInfTree.setAbleNum((vbDcrLinInfTree.getCrAmt()==null?new BigDecimal("0"):vbDcrLinInfTree.getCrAmt()).subtract(vbDcrLinInfTree.getUsedNum()));
			   vbDcrLinInfTreeList.add(vbDcrLinInfTree);
	    }
	    
		return vbDcrLinInfTreeList;
	}
	
	
	@Override
	public List selectTreePoByRootId(String key) {
		// TODO Auto-generated method stub
	    List<BDcrLinInf>  bDcrLinInfList=extBDcrLinInfDAO.selectTreeByRootId(key);
		return bDcrLinInfList;
	}
	

	@Transactional
	public void  updateBcCrIdForPass(String key,String bcCrId) {
		// TODO Auto-generated method stub
	      List<BDcrLinInf>  bDcrLinInfList=selectTreePoByRootId(key);
		try {
			    for(BDcrLinInf bDcrLinInf:bDcrLinInfList){
			    	    bDcrLinInf.setBcCrId(bcCrId);
						bDcrLinInfDAO.updateByPrimaryKeySelective(bDcrLinInf);
			      }
		} catch (Exception e) {
			log.warn("更新异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50005),BSysErrorConstant.SCF_BAS_DCR_50005);

		}
	}
	
	
	@Override
	public Page queryCusBDcrLinInf(int pageNo,int pageSize,String custId,String prdId) {
		// TODO Auto-generated method stub
		Page p = new Page(pageSize, pageNo,0);
		extBDcrLinInfDAO.queryCusBDcrLinInf(custId,prdId,InfTypeEnum.LEAF.getValue(),LinStatEnum.VALID.getValue(),p);
		log.debug("totalPage=" + p.getTotalPage());
		log.debug("totalRecord=" + p.getTotalRecord());
		log.debug("current=" + p.getCurrent());
		return p;
	}
	
	}



