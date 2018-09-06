package com.huateng.scf.bas.crg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.base.cache.CacheService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crg.dao.BCrgEvalDtlDAO;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalDtl;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalDtlExample;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalDtlExample.Criteria;
import com.huateng.scf.bas.crg.service.IBCrgEvalDtlService;
import com.huateng.scube.server.annotation.ScubeService;
@ScubeService
@Service("BCrgEvalDtlServiceImpl")
public class BCrgEvalDtlServiceImpl implements IBCrgEvalDtlService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BCrgEvalDtlDAO")
	BCrgEvalDtlDAO bCrgEvalDtlDAO;

	@Autowired
	private CacheService cacheService;
	@Override
	public String add(BCrgEvalDtl record) {
		return bCrgEvalDtlDAO.insert(record);
	}

	/* 
	 * 
	 */
	@Override
	public int update(BCrgEvalDtl record) {
		return bCrgEvalDtlDAO.updateByPrimaryKey(record);
	}

	@Override
	public int delete(String evalId) {
		return bCrgEvalDtlDAO.deleteByPrimaryKey(evalId);
	}

	@Override
	public Page findCrgEvalDtlByPage(int pageNo, int pageSize, BCrgEvalDtl record) {
		int total = bCrgEvalDtlDAO.countByExample(new BCrgEvalDtlExample());
		Page p = new Page(pageSize, pageNo, total);

		BCrgEvalDtlExample example = new BCrgEvalDtlExample();
		Criteria cri = example.createCriteria();
		if (record != null) {
			if (record.getEvalDtlId() != null && record.getEvalDtlId().length() > 0) {
				cri.andRltIdEqualTo( record.getEvalDtlId());
			}
			
			if (record.getEvalId() != null && record.getEvalId().length() > 0) {
				cri.andEvalIdEqualTo(record.getEvalId());
			}
			
			if (record.getRltTyp() != null && record.getRltTyp().length() > 0) {
				cri.andRltTypLike("%" + record.getRltTyp() + "%");
			}
			if (record.getRltId() != null && record.getRltId().length() > 0) {
				cri.andRltIdEqualTo(record.getRltId());
			}

			if (record.getItNo() != null && record.getItNo().length() > 0) {
				cri.andItNoEqualTo(record.getItNo());
			}			
			
			if (record.getItVal() != null && record.getItVal().length() > 0) {
				cri.andItValEqualTo("%" + record.getItVal() + "%");
			}
			
			if (record.getChgVal() != null ) {
				cri.andChgValEqualTo(record.getChgVal());
			}
		}
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());
		List<BCrgEvalDtl> records = bCrgEvalDtlDAO.selectByPage(example, p);
		p.setRecords(records);
		log.info("p.toString()=" + p.toString());
		return p;
	}

	@Override
	public BCrgEvalDtl findCrgEvalDtlByKey(String evalId) {

		return bCrgEvalDtlDAO.selectByPrimaryKey(evalId);
	}

	@Override
	public List<BCrgEvalDtl> selectByExample(BCrgEvalDtlExample example) {

		return bCrgEvalDtlDAO.selectByExample(example);
	}

	@Override
	public String getString(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Test
//	public void test(){
//		BCrgEvalDtlServiceImpl crgEvalDtlService = new BCrgEvalDtlServiceImpl();
//		BCrgEvalDtl bCrgEvalDtl=new BCrgEvalDtl();
//		crgEvalDtlService.add(bCrgEvalDtl);
//		
//	}

}
