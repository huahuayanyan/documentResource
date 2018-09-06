package com.huateng.scf.bas.dcr.service.impl;

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
import com.huateng.scf.bas.dcr.dao.BDcrChkDirDAO;
import com.huateng.scf.bas.dcr.model.BDcrChkDir;
import com.huateng.scf.bas.dcr.model.BDcrChkDirExample;
import com.huateng.scf.bas.dcr.model.BDcrLinInf;
import com.huateng.scf.bas.dcr.model.BDcrChkDirExample.Criteria;
import com.huateng.scf.bas.dcr.service.IbDcrChkDirService;
import com.huateng.scf.bas.dcr.vo.VbDcrChkDir;
import com.huateng.scf.bas.dcr.vo.VbDcrChkDirTree;
import com.huateng.scf.bas.dcr.vo.VbDcrLinInfTree;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * BDcrChkDirServiceImpl接口实现类
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
public class BDcrChkDirServiceImpl implements IbDcrChkDirService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BDcrChkDirDAO")
	BDcrChkDirDAO bDcrChkDirDAO;

	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	
	@Override
	@Transactional
	public void add(VbDcrChkDir vbDcrChkDir) {
		// TODO Auto-generated method stub
		// VO转PO 展现层对象转换DAO层对象
		BDcrChkDir bDcrChkDir = new BDcrChkDir();
		try {
			BeanUtils.copyProperties(vbDcrChkDir, bDcrChkDir);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}
		
		String  chkDirId=ibSysSerialNoService.genSerialNo("CHK_DIR_NO");
		bDcrChkDir.setChkDirId(chkDirId);
		try {
			bDcrChkDirDAO.insertSelective(bDcrChkDir);
		} catch (Exception e) {
			log.warn("插入异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50001),BSysErrorConstant.SCF_BAS_DCR_50001);
		}
	
	}

	@Override
	@Transactional
	public int update(VbDcrChkDir vbDcrChkDir) {

		// TODO Auto-generated method stub
		// VO转PO 展现层对象转换DAO层对象
		BDcrChkDir bDcrChkDir = new BDcrChkDir();
		try {
			BeanUtils.copyProperties(vbDcrChkDir, bDcrChkDir);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		int i;
		try {
			i = bDcrChkDirDAO.updateByPrimaryKeySelective(bDcrChkDir);
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
			i = bDcrChkDirDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.warn("删除异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50003),BSysErrorConstant.SCF_BAS_DCR_50003);
		}

		return i;
	}

	@Override
	public Page findObjectConditionByPage(int pageNo,int pageSize,VbDcrChkDir vbDcrChkDir) {
		Page p = new Page(pageSize, pageNo,0);
		BDcrChkDirExample example = new BDcrChkDirExample();
	    Criteria cri = example.createCriteria();
		if (vbDcrChkDir != null) {

		}
		bDcrChkDirDAO.selectByPage(example, p);
		log.debug("totalPage=" + p.getTotalPage());
		log.debug("totalRecord=" + p.getTotalRecord());
		log.debug("current=" + p.getCurrent());
		return p;
	}

	@Override
	public VbDcrChkDir  findVbDcrChkDirByKey(String key) {
		// TODO Auto-generated method stub
		// PO转VO DAO层对象转换 展现层对象
		log.debug("findVbDcrChkDirByKey传递参数,key="+key);
		if(StringUtils.isBlank(key)){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004),BSysErrorConstant.SCF_BAS_DCR_50004);		
		}
		BDcrChkDir bDcrChkDir = bDcrChkDirDAO.selectByPrimaryKey(key);
		VbDcrChkDir vbDcrChkDir = new VbDcrChkDir();
		try {
		   BeanUtils.copyProperties(bDcrChkDir, vbDcrChkDir);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		return vbDcrChkDir;
	}

	@Override
	public List selectTreeByRootId(String key) {
		// TODO Auto-generated method stub
		log.info("selectTreePoByRootId传递参数,key="+key);
		if(StringUtils.isBlank(key)){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004),BSysErrorConstant.SCF_BAS_DCR_50004);		
		}
		BDcrChkDirExample example = new BDcrChkDirExample();
	    Criteria cri = example.createCriteria();
		cri.andLinIdEqualTo(key);
		 List<BDcrChkDir> 	bDcrChkDirList=bDcrChkDirDAO.selectByExample(example);
		    List<VbDcrChkDirTree>     vbDcrChkDirTreeList=new  ArrayList<VbDcrChkDirTree>();
		    for(BDcrChkDir bDcrChkDir: bDcrChkDirList){
		    	  VbDcrChkDirTree  vbDcrChkDirTree=new  VbDcrChkDirTree();
				   BeanUtils.copyProperties(bDcrChkDir, vbDcrChkDirTree);
				   vbDcrChkDirTree.setTreeId(vbDcrChkDirTree.getChkDirId());
				   vbDcrChkDirTree.setTreeParentId("0");
				   vbDcrChkDirTree.setTreeLevel(Integer.toString(1));	  
				   vbDcrChkDirTreeList.add(vbDcrChkDirTree);
		    }
		
		return vbDcrChkDirTreeList;
	}

}
