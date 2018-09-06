package com.huateng.scf.bas.sys.service.impl;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.BSysChkCnfgDAO;
import com.huateng.scf.bas.sys.dao.model.BSysChkCnfg;
import com.huateng.scf.bas.sys.dao.model.BSysChkCnfgExample;
import com.huateng.scf.bas.sys.dao.model.BSysChkCnfgExample.Criteria;
import com.huateng.scf.bas.sys.service.IBSysChkCnfgService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.server.annotation.ScubeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huateng.base.cache.CacheService;


/**
 * @author HTRAD0055
 *	拦截项配置实现类
 */
@ScubeService
@Service("BSysChkCnfgServiceImpl")
public class BSysChkCnfgServiceImpl implements IBSysChkCnfgService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name="BSysChkCnfgDAO")
	BSysChkCnfgDAO bSysChkCnfgDAO;
	
	@Autowired
	private CacheService cacheService;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;

	@Override
	public String add(BSysChkCnfg record) {
		String  chkItId=ibSysSerialNoService.genSerialNo("INT_CNFG");
		record.setChkItId(chkItId);	
		return bSysChkCnfgDAO.insert(record);
	}

	@Transactional
	@Override
	public int update(BSysChkCnfg record) {
		return bSysChkCnfgDAO.updateByPrimaryKey(record);
	}

	@Transactional
	@Override
	public int delete(String key) {
		return bSysChkCnfgDAO.deleteByPrimaryKey(key);
	}

	@Override
	public Page findBSysChkCnfgByPage(int pageNo, int pageSize, BSysChkCnfg record) {
		int total = bSysChkCnfgDAO.countByExample(new BSysChkCnfgExample());
		Page p = new Page(pageSize, pageNo, total);

		BSysChkCnfgExample example = new BSysChkCnfgExample();
		Criteria cri = example.createCriteria();
		if (record != null) {
			if (record.getChkItId() != null&&record.getChkItId().length()>0) {
				cri.andChkItIdEqualTo(record.getChkItId());
			}
			if (record.getClazz() != null&&record.getClazz().length()>0) {
				cri.andClazzLike("%"+record.getClazz()+"%");
			}
			if (record.getRem() != null&&record.getRem().length()>0) {
				cri.andRemLike("%"+record.getRem()+"%");
			}
		}
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		example.setOrderByClause("CHK_IT_ID DESC");
		p.setRecords(bSysChkCnfgDAO.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}

	@Override
	public BSysChkCnfg findBSysChkCnfgByKey(String key) {
		return bSysChkCnfgDAO.selectByPrimaryKey(key);
	}

	
	public List<BSysChkCnfg> findAllBSysChkCnfgList(){
		List<BSysChkCnfg> list = bSysChkCnfgDAO.findAllList();
		return list;
	}
	
	public List<String> findBSysChkCnfgChkItIds() {
		List<String> list = bSysChkCnfgDAO.findListByColumnName("CHK_IT_ID");
		return list;
	}
	
	
	public Map<String,String> findBSysChkCnfgChkItIdMap() {
		List<String> list = bSysChkCnfgDAO.findListByColumnName("CHK_IT_ID");
		Map<String, String> chkItIdMap = new HashMap<String, String>();
		for(int i= 0;i<list.size();i++){
			chkItIdMap.put(String.valueOf(i+1), list.get(i));
		}
		Object json = JSONArray.toJSON(chkItIdMap);
		/*JSON map = JSON.;*/
		return chkItIdMap;
	}




}
