/**
 * 
 */
package com.huateng.scf.bas.icr.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.icr.dao.IBIcrAppliBrcodeListDAO;
import com.huateng.scf.bas.icr.dao.IBIcrAppliChgDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeListExample;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeListExample.Criteria;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliChgExample;
import com.huateng.scf.bas.icr.model.BIcrAppliBrcodeList;
import com.huateng.scf.bas.icr.model.BIcrAppliInfo;
import com.huateng.scf.bas.icr.service.IBIcrAppliBrcodeListService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月14日下午2:48:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月14日下午2:48:46	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BIcrAppliBrcodeListServiceImpl")
public class BIcrAppliBrcodeListServiceImpl implements IBIcrAppliBrcodeListService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BIcrAppliBrcodeListDAO")
	IBIcrAppliBrcodeListDAO bIcrAppliBrcodeListDAO;
	@Override
	@Transactional
	public void addAppliBrcodeList(BIcrAppliBrcodeList bIcrAppliBrcodeList) {
		com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList bIcrAppliBrcodeListDal = new com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList();
		try {
			BeanUtils.copyProperties(bIcrAppliBrcodeList, bIcrAppliBrcodeListDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常");
			throw new ScubeBizException("转换异常",e);
		}
		try {
			bIcrAppliBrcodeListDal.setId(UUIDGeneratorUtil.generate());
			bIcrAppliBrcodeListDAO.insert(bIcrAppliBrcodeListDal);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("业务申请额度适用机构映射新增失败");
			throw new ScubeBizException("业务申请额度适用机构映射新增失败",e);
		}
	}

	@Override
	@Transactional
	public int updateAppliBrcodeList(BIcrAppliBrcodeList bIcrAppliBrcodeList) {
		com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList bIcrAppliBrcodeListDal = new com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList();
		try {
			BeanUtils.copyProperties(bIcrAppliBrcodeList, bIcrAppliBrcodeListDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常");
			throw new ScubeBizException("转换异常",e);
		}
		int i=0;
		try {
			i= bIcrAppliBrcodeListDAO.updateByPrimaryKey(bIcrAppliBrcodeListDal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("业务申请额度适用机构映射修改失败");
			throw new ScubeBizException("业务申请额度适用机构映射修改失败",e);
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(String key) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			i= bIcrAppliBrcodeListDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("业务申请额度适用机构映射删除失败");
			throw new ScubeBizException("业务申请额度适用机构映射删除失败",e);
		}
		return i;
	}

	@Override
	public Page queryAppliBrcodeListByPage(int pageNo, int pageSize, BIcrAppliBrcodeList bIcrAppliBrcodeList) {
		Page p = new Page(pageSize, pageNo, 0);
		
		BIcrAppliBrcodeListExample example  = new BIcrAppliBrcodeListExample();
		Criteria criteria =example.createCriteria();
		if(bIcrAppliBrcodeList!=null){
			
		}
		p.setRecords(bIcrAppliBrcodeListDAO.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}

	@Override
	public BIcrAppliBrcodeList queryAppliBrcodeListKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}
//ext
	
	@Transactional
	public void deleteAppliBrcodeListByNo(BIcrAppliBrcodeList bIcrAppliBrcodeList) {
		com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList bIcrAppliBrcodeListDal = new com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList();
		try {
			BeanUtils.copyProperties(bIcrAppliBrcodeList, bIcrAppliBrcodeListDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常");
			throw new ScubeBizException("转换异常",e);
		}
		try {
			 bIcrAppliBrcodeListDAO.deleteAppliBrcodeListByNo(bIcrAppliBrcodeListDal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("业务申请额度适用机构映射删除失败");
			throw new ScubeBizException("业务申请额度适用机构映射删除失败",e);
		}
	}
   /**
    * 根据额度编号查询额度申请信息
    */
	@Override
	public List<BIcrAppliBrcodeList> queryBIcrAppliBrcodeByCreditNo(BIcrAppliBrcodeList bIcrAppliBrcodeList) {
		com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList bIcrAppliBrcodeDal = new com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList();
		BeanUtils.copyProperties(bIcrAppliBrcodeList, bIcrAppliBrcodeDal);
		List<com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList> listdal =bIcrAppliBrcodeListDAO.queryBIcrAppliBrcodeListByCreditNo(bIcrAppliBrcodeDal);
		List<com.huateng.scf.bas.icr.model.BIcrAppliBrcodeList> list  = new ArrayList<BIcrAppliBrcodeList>();
		BeanUtils.copyProperties(listdal, list);
		return list;
	}
}
