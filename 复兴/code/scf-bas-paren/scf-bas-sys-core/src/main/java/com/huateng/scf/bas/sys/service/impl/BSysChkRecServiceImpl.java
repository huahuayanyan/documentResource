package com.huateng.scf.bas.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.cache.CacheService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.BSysChkRecDAO;
import com.huateng.scf.bas.sys.dao.model.BSysChkRec;
import com.huateng.scf.bas.sys.dao.model.BSysChkRecExample;
import com.huateng.scf.bas.sys.dao.model.BSysChkRecExample.Criteria;
import com.huateng.scf.bas.sys.service.IBSysChkRecService;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BSysChkRecServiceImpl")
public class BSysChkRecServiceImpl implements IBSysChkRecService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="BSysChkRecDAO")
	BSysChkRecDAO bSysChkRecDAO;
	
	@Autowired
	private CacheService cacheService;

	@Override
	public String add(BSysChkRec record) {
		return bSysChkRecDAO.insert(record);
	}

	@Transactional
	@Override
	public int update(BSysChkRec record) {
		return bSysChkRecDAO.updateByPrimaryKey(record);
	}

	@Transactional
	@Override
	public int delete(String key) {
		return bSysChkRecDAO.deleteByPrimaryKey(key);
	}

	@Override
	public Page findBSysChkRecByPage(int pageNo, int pageSize, BSysChkRec record) {
		int total = bSysChkRecDAO.countByExample(new BSysChkRecExample());
		Page p = new Page(pageSize, pageNo, total);
		BSysChkRecExample example = new BSysChkRecExample();
		Criteria criteria = example.createCriteria();
		if(record.getRecId()!=null&&record.getRecId().length()>0){
			criteria.andRecIdEqualTo(record.getRecId());
		}
		if(record.getRltNo()!=null&&record.getRltNo().length()>0){
			criteria.andRltNoEqualTo(record.getRecId());
		}
		
		if(record.getChkPlId()!=null&&record.getChkPlId().length()>0){
			criteria.andChkPlIdEqualTo(record.getChkPlId());
		}
		
		if(record.getChkItId()!=null&&record.getChkItId().length()>0){
			criteria.andChkItIdEqualTo(record.getChkItId());
		}
		
		if(record.getNm()!=null&&record.getNm().length()>0){
			criteria.andNmLike("%"+record.getNm()+"%");
		}	

		if(record.getOrd()!=null){
			criteria.andOrdEqualTo(record.getOrd());
		}
		if(record.getDeal()!=null&&record.getDeal().length()>0){
			criteria.andDealLike("%"+record.getDeal()+"%");
		}	
		if(record.getRem()!=null&&record.getRem().length()>0){
			criteria.andRemLike("%"+record.getRem()+"%");
		}	
		
		if(record.getStat()!=null&&record.getStat().length()>0){
			criteria.andStatLike("%"+record.getStat()+"%");
		}
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bSysChkRecDAO.selectByPage(example, p));
		return p;
	}

	@Override
	public BSysChkRec findBSysChkRecByKey(String key) {
		return bSysChkRecDAO.selectByPrimaryKey(key);
	}

	@Override
	public List<BSysChkRec> findAllBsysChkRecList() {
		return bSysChkRecDAO.findAllBSysChkRecs();
	}

}
