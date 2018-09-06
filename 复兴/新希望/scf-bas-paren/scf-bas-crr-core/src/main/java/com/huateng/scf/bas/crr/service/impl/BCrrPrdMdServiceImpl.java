package com.huateng.scf.bas.crr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.IBCrrPrdMdDAO;
import com.huateng.scf.bas.crr.dao.ext.ExtBCrrDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMdExample;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMdExample.Criteria;
import com.huateng.scf.bas.crr.model.BCrrPrdMd;
import com.huateng.scf.bas.crr.service.IBCrrPrdMdService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrPrdMd接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月28日下午5:12:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月28日下午5:12:35	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrPrdMdServiceImpl")
public class BCrrPrdMdServiceImpl implements IBCrrPrdMdService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCrrPrdMdDAO")
	IBCrrPrdMdDAO bcrrprdmddao;

	@Resource(name = "ExtBCrrDAO")
	ExtBCrrDAO extbcrrdao;

	@Override
	@Transactional
	public void add(BCrrPrdMd bCrrPrdMd) {
		log.info("新增产品配置信息");
		BCrrModelCommonUtil.setAddField(bCrrPrdMd);
		com.huateng.scf.bas.crr.dao.model.BCrrPrdMd bCrrPrdMddal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrPrdMd(); 
		try 
		{
			BeanUtils.copyProperties(bCrrPrdMd, bCrrPrdMddal);
		} 
		catch (BeansException e) 
		{
			throw new ScubeBizException("转换异常");
		}
		try 
		{
			bcrrprdmddao.insertSelective(bCrrPrdMddal);
		} 
		catch (BeansException e) 
		{
			throw new ScubeBizException("插入异常");
		}
	}

	@Override
	@Transactional
	public int update(BCrrPrdMd bCrrPrdMd) {
		log.info("产品配置编辑");
		BCrrModelCommonUtil.setUpdateField(bCrrPrdMd);
		com.huateng.scf.bas.crr.dao.model.BCrrPrdMd bCrrPrdMddal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrPrdMd(); 
		try 
		{
			BeanUtils.copyProperties(bCrrPrdMd, bCrrPrdMddal);
		} 
		catch (BeansException e) 
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		try 
		{
			i = bcrrprdmddao.updateByPrimaryKey(bCrrPrdMddal);
		} 
		catch (BeansException e) 
		{
			throw new ScubeBizException("插入异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(BCrrPrdMd bCrrPrdMd) {
		String prdId = bCrrPrdMd.getPrdId();
		int i;
		try 
		{
			i = bcrrprdmddao.deleteByPrimaryKey(prdId);
		} 
		catch (BeansException e) 
		{
			throw new ScubeBizException("删除异常");
		}
		return i;
	}
	
	@Override
	@Transactional
	public int batchDelete(List<BCrrPrdMd> list) {
		int rows = 0;
		if(list.size()>0)
		{
			for(BCrrPrdMd bCrrPrdMd: list)
			{
				rows += delete(bCrrPrdMd);
			}
		}
		return rows;
	}

	@Override
	public Page findBCrrPrdMdByPage(int pageNo, int pageSize, BCrrPrdMd bCrrPrdMd) {
		int total = bcrrprdmddao.countByExample(new BCrrPrdMdExample());
		Page p = new Page(pageSize, pageNo, total);
		
		BCrrPrdMdExample example = new BCrrPrdMdExample();
		Criteria cri = example.createCriteria();
		
		if(bCrrPrdMd!=null)
		{
			if(bCrrPrdMd.getPrdId()!=null&&bCrrPrdMd.getPrdId().length()>0)
			{
				cri.andPrdIdLike("%"+bCrrPrdMd.getPrdId()+"%");
			}
			if(bCrrPrdMd.getPrdNm()!=null&&bCrrPrdMd.getPrdNm().length()>0)
			{
				cri.andPrdNmLike("%"+bCrrPrdMd.getPrdNm()+"%");
			}
			if(bCrrPrdMd.getStat()!=null&&bCrrPrdMd.getStat().length()>0)
			{
				cri.andStatEqualTo(bCrrPrdMd.getStat());
			}
		}
		example.setOrderByClause("PRD_ID");
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bcrrprdmddao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	@Override
	public BCrrPrdMd findBCrrPrdMdByPrdId(String prdId)
	{
		com.huateng.scf.bas.crr.dao.model.BCrrPrdMd bCrrPrdMddal = bcrrprdmddao.selectByPrimaryKey(prdId);
		// VO转PO 展现层对象转换DAO层对象
		BCrrPrdMd bCrrPrdMd = new BCrrPrdMd();
	    try
	    {
	    	BeanUtils.copyProperties(bCrrPrdMddal, bCrrPrdMd);
	    }
	    catch(BeansException e)
	    {
	    	throw new ScubeBizException("转换异常");
	    }
	    return bCrrPrdMd;
	}

	/**
	 * 验证产品编号是否重复
	 */
	@Override
	public String checkPrdId(String prdId) {
		com.huateng.scf.bas.crr.dao.model.BCrrPrdMd bCrrPrdMddal = bcrrprdmddao.selectByPrimaryKey(prdId);
    	if(bCrrPrdMddal!=null)
    	{
    		return prdId;
    	}
    	return "";
	}
	
	/**
	 * 验证产品名称是否重复
	 */
	@Override
	public String checkPrdNm(String prdNm)
	{
		com.huateng.scf.bas.crr.dao.model.BCrrPrdMd bCrrPrdMddal = bcrrprdmddao.selectByPrdNm(prdNm);
    	if(bCrrPrdMddal!=null)
    	{
    		return prdNm;
    	}
    	return "";
	}

	@Override
	public String checkPrdMd(BCrrPrdMd bCrrPrdMd) {
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrPrdMd bCrrPrdMddal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrPrdMd();
		try
		{
			BeanUtils.copyProperties(bCrrPrdMd, bCrrPrdMddal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		List<com.huateng.scf.bas.crr.dao.model.BCrrPrdMd> list = bcrrprdmddao.selectByPrdMd(bCrrPrdMddal);
    	if(list.size()>0)
    	{
    		return "false";
    	}
    	return "";
	}
	
	@Override
	public Page queryPrdMdSource(int pageNo, int pageSize,Map<String, String> value) {
		log.debug("传递参数,value="+value);
		Page p = new Page(pageSize, pageNo,0);
		Map<String, String>  omap = new HashMap<String, String>(); 
		if(value!=null&&value.get("prdId")!=null&&value.get("prdNm")!=null){
			omap.put("prdId",value.get("prdId").toString().trim());
			omap.put("prdNm", value.get("prdNm").toString().trim());
		}
		omap.put("statu", "1");
		extbcrrdao.queryPrdMdSource(omap,p);
		return p;
	}
}
