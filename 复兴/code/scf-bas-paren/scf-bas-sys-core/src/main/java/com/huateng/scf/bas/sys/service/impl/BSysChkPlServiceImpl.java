package com.huateng.scf.bas.sys.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.BSysChkPlDAO;
import com.huateng.scf.bas.sys.dao.model.BSysChkPl;
import com.huateng.scf.bas.sys.dao.model.BSysChkPlExample;
import com.huateng.scf.bas.sys.dao.model.BSysChkPlExample.Criteria;
import com.huateng.scf.bas.sys.service.IBSysChkPlService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * @author HTRAD0055
 *	拦截方案实现类
 */
@ScubeService
@Service("BSysChkPlServiceImpl")
public class BSysChkPlServiceImpl implements IBSysChkPlService {
	
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="BSysChkPlDAO")
	BSysChkPlDAO bSysChkPlDAO;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Override
	@Transactional
	public String add(BSysChkPl record) {
		String  chkPlId=ibSysSerialNoService.genSerialNo("INT_PL");
		record.setChkPlId(chkPlId);
		return bSysChkPlDAO.insert(record);
	}

	@Transactional
	@Override
	public int update(BSysChkPl record) {
		return bSysChkPlDAO.updateByPrimaryKey(record);
	}

	@Transactional
	@Override
	public int delete(String key) {
		return bSysChkPlDAO.deleteByPrimaryKey(key);
	}

	@Override
	public Page findBSysChkPlByPage(int pageNo, int pageSize, BSysChkPl record) {
		BSysChkPlExample example = new BSysChkPlExample();
		Criteria criteria = example.createCriteria();
		if(record.getChkPlId()!=null&&record.getChkPlId().length()>0){
			criteria.andChkItIdEqualTo(record.getChkPlId());
		}
		if(record.getChkItId()!=null&&record.getChkItId().length()>0){
			criteria.andChkPlIdEqualTo(record.getChkPlId());
		}
		if(record.getNm()!=null&&record.getNm().length()>0){
			criteria.andNmLike("%"+record.getNm()+"%");
		}	

		if(record.getMdlId()!=null&&record.getMdlId().length()>0){
			criteria.andMdlIdEqualTo(record.getMdlId());
		}

		if(record.getOrd()!=null){
			criteria.andOrdEqualTo(record.getOrd());
		}
		if(record.getDeal()!=null&&record.getDeal().length()>0){
			criteria.andDealLike("%"+record.getDeal()+"%");
		}	
		if(record.getStat()!=null&&record.getStat().length()>0){
			criteria.andStatLike("%"+record.getStat()+"%");
		}
		
		int total = bSysChkPlDAO.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bSysChkPlDAO.selectByPage(example, p));
		return p;
	}

	@Override
	public BSysChkPl findBSysChkPlByKey(String key) {
		return bSysChkPlDAO.selectByPrimaryKey(key);
	}

}
