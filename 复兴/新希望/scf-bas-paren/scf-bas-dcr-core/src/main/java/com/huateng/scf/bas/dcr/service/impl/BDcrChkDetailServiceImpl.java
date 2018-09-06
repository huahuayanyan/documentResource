package com.huateng.scf.bas.dcr.service.impl;

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
import com.huateng.scf.bas.dcr.dao.BDcrChkDetailDAO;
import com.huateng.scf.bas.dcr.model.BDcrChkDetail;
import com.huateng.scf.bas.dcr.model.BDcrChkDetailExample;
import com.huateng.scf.bas.dcr.model.BDcrChkDetailExample.Criteria;
import com.huateng.scf.bas.dcr.service.IbDcrChkDetailService;
import com.huateng.scf.bas.dcr.vo.VbDcrChkDetail;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * BDcrLinTypr接口实现类
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
public class BDcrChkDetailServiceImpl implements IbDcrChkDetailService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BDcrChkDetailDAO")
	BDcrChkDetailDAO bDcrChkDetailDAO;

	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	
	@Override
	@Transactional
	public void add(VbDcrChkDetail vbDcrChkDetail) {
		// TODO Auto-generated method stub
		// VO转PO 展现层对象转换DAO层对象
		BDcrChkDetail bDcrChkDetail = new BDcrChkDetail();
		try {
			BeanUtils.copyProperties(vbDcrChkDetail, bDcrChkDetail);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}
		
		String  chkDetailId=ibSysSerialNoService.genSerialNo("CHK_DETAIL_NO");		
		bDcrChkDetail.setChkDetailId(chkDetailId);
		try {
			bDcrChkDetailDAO.insertSelective(bDcrChkDetail);
		} catch (Exception e) {
			log.warn("插入异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50001),BSysErrorConstant.SCF_BAS_DCR_50001);
		}
	
	}

	@Override
	@Transactional
	public int update(VbDcrChkDetail vbDcrChkDetail) {

		// TODO Auto-generated method stub
		// VO转PO 展现层对象转换DAO层对象
		BDcrChkDetail bDcrChkDetail = new BDcrChkDetail();
		try {
			BeanUtils.copyProperties(vbDcrChkDetail, bDcrChkDetail);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		int i;
		try {
			i = bDcrChkDetailDAO.updateByPrimaryKeySelective(bDcrChkDetail);
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
			i = bDcrChkDetailDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.warn("删除异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50003),BSysErrorConstant.SCF_BAS_DCR_50003);
		}

		return i;
	}

	@Override
	public Page findObjectConditionByPage(int pageNo,int pageSize,VbDcrChkDetail vbDcrChkDetail) {
		Page p = new Page(pageSize, pageNo,0);
		BDcrChkDetailExample example = new BDcrChkDetailExample();
	    Criteria cri = example.createCriteria();
		if(StringUtils.isBlank(vbDcrChkDetail.getChkDirId())){
			cri.andChkDirIdEqualTo("0");//为空默认0
		}else{
		cri.andChkDirIdEqualTo(vbDcrChkDetail.getChkDirId());
		}
		bDcrChkDetailDAO.selectByPage(example, p);
		log.debug("totalPage=" + p.getTotalPage());
		log.debug("totalRecord=" + p.getTotalRecord());
		log.debug("current=" + p.getCurrent());
		return p;
	}

	@Override
	public VbDcrChkDetail findVbDcrChkDetailByKey(String key) {
		// TODO Auto-generated method stub
		// PO转VO DAO层对象转换 展现层对象
		log.debug("findVbDcrChkDetailByKey传递参数,key="+key);
		if(StringUtils.isBlank(key)){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004),BSysErrorConstant.SCF_BAS_DCR_50004);		
		}
		BDcrChkDetail bDcrChkDetail = bDcrChkDetailDAO.selectByPrimaryKey(key);
		VbDcrChkDetail vbDcrChkDetail = new VbDcrChkDetail();
		try {
		   BeanUtils.copyProperties(bDcrChkDetail, vbDcrChkDetail);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		return vbDcrChkDetail;
	}

}
