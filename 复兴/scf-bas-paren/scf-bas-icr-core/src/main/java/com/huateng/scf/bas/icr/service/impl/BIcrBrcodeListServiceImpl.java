/**
 * 
 */
package com.huateng.scf.bas.icr.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.icr.dao.IBIcrBrcodeListDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrBrcodeListExample;
import com.huateng.scf.bas.icr.dao.model.BIcrBrcodeListExample.Criteria;
import com.huateng.scf.bas.icr.model.BIcrBrcodeList;
import com.huateng.scf.bas.icr.service.IBIcrBrcodeListService;
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
@Service("BIcrBrcodeListServiceImpl")
public class BIcrBrcodeListServiceImpl implements IBIcrBrcodeListService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BIcrBrcodeListDAO")
	IBIcrBrcodeListDAO bIcrBrcodeListDAO;
	@Override
	@Transactional
	public void addBrcodeList(BIcrBrcodeList bIcrBrcodeList) {
		com.huateng.scf.bas.icr.dao.model.BIcrBrcodeList bIcrBrcodeListDal = new com.huateng.scf.bas.icr.dao.model.BIcrBrcodeList();
		try {
			BeanUtils.copyProperties(bIcrBrcodeList, bIcrBrcodeListDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常");
			throw new ScubeBizException("转换异常",e);
		}
		try {
			bIcrBrcodeListDal.setId(UUIDGeneratorUtil.generate());
			bIcrBrcodeListDAO.insert(bIcrBrcodeListDal);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("额度适用机构关联新增失败");
			throw new ScubeBizException("额度适用机构关联新增失败",e);
		}
	}

	@Transactional
	public int updateBrcodeList(BIcrBrcodeList bIcrBrcodeList) {
		com.huateng.scf.bas.icr.dao.model.BIcrBrcodeList bIcrBrcodeListDal = new com.huateng.scf.bas.icr.dao.model.BIcrBrcodeList();
		try {
			BeanUtils.copyProperties(bIcrBrcodeList, bIcrBrcodeListDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常");
			throw new ScubeBizException("转换异常",e);
		}
		int i=0;
		try {
			i= bIcrBrcodeListDAO.updateByPrimaryKey(bIcrBrcodeListDal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("额度适用机构关联修改失败");
			throw new ScubeBizException("额度适用机构关联修改失败",e);
		}
		return i;
	}

	@Transactional
	public int delete(String key) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			i= bIcrBrcodeListDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("额度适用机构关联删除失败");
			throw new ScubeBizException("额度适用机构关联删除失败",e);
		}
		return i;
	}

	public Page queryBrcodeListByPage(int pageNo, int pageSize, BIcrBrcodeList bIcrBrcodeList) {
		Page p = new Page(pageSize, pageNo, 0);
		
		BIcrBrcodeListExample example  = new BIcrBrcodeListExample();
		Criteria criteria =example.createCriteria();
		if(bIcrBrcodeList!=null){
			
		}
		p.setRecords(bIcrBrcodeListDAO.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}

	public BIcrBrcodeList queryBrcodeListKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}
//ext
	
	@Transactional
	public void deleteBrcodeListByNo(BIcrBrcodeList bIcrBrcodeList) {
		com.huateng.scf.bas.icr.dao.model.BIcrBrcodeList bIcrBrcodeListDal = new com.huateng.scf.bas.icr.dao.model.BIcrBrcodeList();
		try {
			BeanUtils.copyProperties(bIcrBrcodeList, bIcrBrcodeListDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常");
			throw new ScubeBizException("转换异常",e);
		}
		try {
			 bIcrBrcodeListDAO.deleteBrcodeListByNo(bIcrBrcodeListDal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("额度适用机构关联删除失败");
			throw new ScubeBizException("额度适用机构关联删除失败",e);
		}
	}
}
