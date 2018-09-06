package com.huateng.scf.bas.sys.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.dao.ext.ExtBCrrDAO;
import com.huateng.scf.bas.sys.dao.IBSysLnCdDAO;
import com.huateng.scf.bas.sys.dao.IBSysLnValDAO;
import com.huateng.scf.bas.sys.dao.model.BSysLnVal;
import com.huateng.scf.bas.sys.model.BSysLnCd;
import com.huateng.scf.bas.sys.service.IBSysLnCdService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>BSysLnCd接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月12日上午11:19:10
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月12日上午11:19:10	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BSysLnCdServiceImpl")
public class BSysLnCdServiceImpl implements IBSysLnCdService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBSysLnCdDAO")
	IBSysLnCdDAO bsyslncddao;
	
	@Resource(name = "IBSysLnValDAO")
	IBSysLnValDAO bsyslnvaldao;
	
	@Resource(name = "ExtBCrrDAO")
	ExtBCrrDAO extbcrrdao;
	
	@Override
	@Transactional
	public BSysLnCd add(BSysLnCd bSysLnCd) {
		log.debug("开始新增……");
		String id = UUIDGeneratorUtil.generate();
		bSysLnCd.setId(id);
		com.huateng.scf.bas.sys.dao.model.BSysLnCd bSysLnCddal = 
				new com.huateng.scf.bas.sys.dao.model.BSysLnCd();
		try
		{
			BeanUtils.copyProperties(bSysLnCd, bSysLnCddal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bsyslncddao.insertSelective(bSysLnCddal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		String valId = UUIDGeneratorUtil.generate();
		BSysLnVal bSysLnVal = new BSysLnVal();
		bSysLnVal.setId(valId);
		bSysLnVal.setRateid(id);
		bSysLnVal.setCurcd(bSysLnCd.getCurcd());
		bSysLnVal.setUnit(bSysLnCd.getUnit());
		bSysLnVal.setRateval(bSysLnCd.getRateval());
		bSysLnVal.setStartDate(bSysLnCd.getStartDate());
		bSysLnVal.setEndDate(bSysLnCd.getEndDate());
		bSysLnVal.setState(bSysLnCd.getValStat());
		bSysLnVal.setTerm(bSysLnCd.getTerm());
		bSysLnVal.setRatevalYear(bSysLnCd.getRatevalYear());
		bsyslnvaldao.insertSelective(bSysLnVal);
		return bSysLnCd;
	}

	@Override
	@Transactional
	public int update(BSysLnCd bSysLnCd) {
		com.huateng.scf.bas.sys.dao.model.BSysLnCd bSysLnCddal = 
				new com.huateng.scf.bas.sys.dao.model.BSysLnCd();
		try
		{
			BeanUtils.copyProperties(bSysLnCd, bSysLnCddal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		try
		{
			i = bsyslncddao.updateByPrimaryKeySelective(bSysLnCddal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(BSysLnCd bSysLnCd) {
		int row;
		String id = bSysLnCd.getId();
		String valId = bSysLnCd.getValId();
		try
		{
			bsyslnvaldao.deleteByPrimaryKey(valId);
			row = bsyslncddao.deleteByPrimaryKey(id);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("删除异常");
		}
		return row;
	}
	
	@Override
	@Transactional
	public int batchDelete(List<BSysLnCd> list) {
		int rows = 0;
		if(list.size()>0)
		{
			for(BSysLnCd bSysLnCd:list)
			{
				rows += delete(bSysLnCd);
			}
		}
		return rows;
	}
	
	@Override
	public Page findBSysLnCdByPage(int pageNo, int pageSize, BSysLnCd bSysLnCd) {
		HashMap<String, String>  omap = new HashMap<String, String>(); 
		if(bSysLnCd!=null)
		{
			if(bSysLnCd.getRatecode()!=null&&bSysLnCd.getRatecode().length()>0)
			{
				omap.put("ratecode",bSysLnCd.getRatecode().trim());
			}
			if(bSysLnCd.getRatename()!=null&&bSysLnCd.getRatename().length()>0)
			{
				omap.put("ratename",bSysLnCd.getRatename().trim());
			}
			if(bSysLnCd.getCurcd()!=null&&bSysLnCd.getCurcd().length()>0)
			{
				omap.put("curcd",bSysLnCd.getCurcd().trim());
			}
		}
		
		int total = bsyslncddao.countByExtExample(omap);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bsyslncddao.selectByExtExample(omap,p));
		log.info("p.toString()="+p.toString());
		return p;
	}

	@Override
	public String checkRatecode(String ratecode) {
		com.huateng.scf.bas.sys.dao.model.BSysLnCd bSysLnCddal = bsyslncddao.selectByRatecode(ratecode);
		if(bSysLnCddal!=null)
		{
			return ratecode;
		}
		return "";
	}

	@Override
	public String checkRatename(String ratename) {
		com.huateng.scf.bas.sys.dao.model.BSysLnCd bSysLnCddal = bsyslncddao.selectByRatename(ratename);
    	if(bSysLnCddal!=null)
    	{
    		return ratename;
    	}
    	return "";
	}

	@Override
	public String checkLnCd(BSysLnCd bSysLnCd) {
		com.huateng.scf.bas.sys.dao.model.BSysLnCd bSysLnCddal = 
				new com.huateng.scf.bas.sys.dao.model.BSysLnCd();
		try
		{
			BeanUtils.copyProperties(bSysLnCd, bSysLnCddal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		List<com.huateng.scf.bas.sys.dao.model.BSysLnCd> list = bsyslncddao.selectByLnCd(bSysLnCddal);
    	if(list.size()>0)
    	{
    		return "false";
    	}
    	return "";
	}

	@Override
	public BSysLnCd findBSysLnCdByRatecode(String ratecode) 
	{
		log.debug("传递参数,ratecode="+ratecode);
		BSysLnCd bSysLnCd = new BSysLnCd();
		if(!StringUtil.isEmpty(ratecode))
		{
			com.huateng.scf.bas.sys.dao.model.BSysLnCd bSysLnCddal = bsyslncddao.selectByRatecode(ratecode);
			String rateid = bSysLnCddal.getId();
			BSysLnVal bSysLnValdal = bsyslnvaldao.selectByRateid(rateid);
			bSysLnCd.setRatecode(ratecode);
			bSysLnCd.setRatename(bSysLnCddal.getRatename());
			bSysLnCd.setRateval(bSysLnValdal.getRateval());
		}
		return bSysLnCd;
	}
}
