package com.huateng.scf.bas.fin.service.impl;

import java.util.ArrayList;
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
import com.huateng.scf.bas.fin.dao.IBFinCnfgClDAO;
import com.huateng.scf.bas.fin.dao.IBFinCnfgDefDAO;
import com.huateng.scf.bas.fin.dao.ext.ExtBFinCnfgSubjDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgClExample;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgClExample.Criteria;
import com.huateng.scf.bas.fin.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.service.IBFinCnfgClService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>BFinCnfgCl接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午2:14:47
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午2:14:47	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BFinCnfgClServiceImpl")
public class BFinCnfgClServiceImpl implements IBFinCnfgClService{
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBFinCnfgClDAO")
	IBFinCnfgClDAO bfincnfgcldao;
	
	@Resource(name = "IBFinCnfgDefDAO")
	IBFinCnfgDefDAO bfincnfgdefdao;
	
	@Resource(name = "ExtBFinCnfgSubjDAO")
	ExtBFinCnfgSubjDAO extbfincnfgsubjdao;
	
	@Override
	@Transactional
	public String add(BFinCnfgCl bFinCnfgCl) {
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgCl bFinCnfgCldal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgCl();
		try 
		{
			BeanUtils.copyProperties(bFinCnfgCl, bFinCnfgCldal);
		} 
		catch (BeansException e) {
			throw new ScubeBizException("转换异常", e);
		}
		String s ;
		try 
		{
			s = bfincnfgcldao.insert(bFinCnfgCldal);
		} 
		catch (Exception e) {
			throw new ScubeBizException("插入异常", e);
		}
		return s;
	}

	@Override
	@Transactional
	public int delete(String mdlId) {
		int i ;
		try 
		{
			bfincnfgdefdao.deleteByMdlId(mdlId);
			i = bfincnfgcldao.deleteByPrimaryKey(mdlId);
		} 
		catch (BeansException e) {
			throw new ScubeBizException("删除异常", e);
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(String mdlIds) {
		int i=0 ;
		String[] mdlIdArr = mdlIds.split(",");
		for(String mdlId:mdlIdArr)
		{
			i += delete(mdlId);
		}
		return i;
	}

	@Override
	@Transactional
	public int update(BFinCnfgCl bFinCnfgCl) {
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgCl bFinCnfgCldal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgCl();
		try
		{
			BeanUtils.copyProperties(bFinCnfgCl, bFinCnfgCldal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i ;
		try
		{
			i = bfincnfgcldao.updateByPrimaryKey(bFinCnfgCldal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	public BFinCnfgCl findBFinCnfgClByMdlId(String mdlId) {
		log.info(mdlId);
		com.huateng.scf.bas.fin.dao.model.BFinCnfgCl bFinCnfgCldal = bfincnfgcldao.selectByPrimaryKey(mdlId);
		// VO转PO 展现层对象转换DAO层对象
		BFinCnfgCl bFinCnfgCl = new BFinCnfgCl();
		try
		{
			BeanUtils.copyProperties(bFinCnfgCldal, bFinCnfgCl);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		return bFinCnfgCl;
	}

	@Override
	public Page findBFinCnfgClByPage(int pageNo, int pageSize, BFinCnfgCl bFinCnfgCl) {
		int total = bfincnfgcldao.countByExample(new BFinCnfgClExample());
		Page p = new Page(pageSize, pageNo, total);
		
		BFinCnfgClExample example = new BFinCnfgClExample();
		Criteria cri = example.createCriteria();
		
		if(bFinCnfgCl != null)
		{
			if(bFinCnfgCl.getMdlId()!=null&&bFinCnfgCl.getMdlId().length()>0)
			{
				cri.andMdlIdLike("%"+bFinCnfgCl.getMdlId()+"%");
			}
			if(bFinCnfgCl.getMdlNm()!=null&&bFinCnfgCl.getMdlNm().length()>0)
			{
				cri.andMdlNmLike("%"+bFinCnfgCl.getMdlNm()+"%");
			}
			if(bFinCnfgCl.getMdlCl()!=null&&bFinCnfgCl.getMdlCl().length()>0)
			{
				cri.andMdlClEqualTo(bFinCnfgCl.getMdlCl());
			}
			if(bFinCnfgCl.getMdlTyp()!=null&&bFinCnfgCl.getMdlTyp().length()>0)
			{
				cri.andMdlTypEqualTo(bFinCnfgCl.getMdlTyp());
			}
			if(bFinCnfgCl.getCol()!=null&&!bFinCnfgCl.getCol().equals(""))
			{
				cri.andColEqualTo(bFinCnfgCl.getCol());
			}
		}
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bfincnfgcldao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	/**
	 * 用于页面select标签
	 */
	@Override
	public List<BFinCnfgCl> selectForSelect(BFinCnfgCl bFinCnfgCl) {
		BFinCnfgClExample example = new BFinCnfgClExample();
		Criteria cri = example.createCriteria();
		cri.andDelFlgEqualTo("0");
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgClExample exampledal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgClExample();
		try
		{
			BeanUtils.copyProperties(example, exampledal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		List<com.huateng.scf.bas.fin.dao.model.BFinCnfgCl> listdal = bfincnfgcldao.selectByExample(exampledal);
		List<BFinCnfgCl> list = new ArrayList<BFinCnfgCl>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.fin.dao.model.BFinCnfgCl bFinCnfgCldal:listdal)
			{
				// VO转PO 展现层对象转换DAO层对象
				BFinCnfgCl bfincl = new BFinCnfgCl();
				try
				{
					BeanUtils.copyProperties(bFinCnfgCldal, bfincl);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				list.add(bfincl);
			}
		}
		return list;
	}

	@Override
	public String checkMdlId(String mdlId) {
		com.huateng.scf.bas.fin.dao.model.BFinCnfgCl _mdlId = bfincnfgcldao.selectByPrimaryKey(mdlId);
    	if(_mdlId!=null)
    	{
    		return mdlId;
    	}
    	return "";
	}
	
	@Override
	public String checkMdlNm(String mdlNm)
	{
		com.huateng.scf.bas.fin.dao.model.BFinCnfgCl _mdlNm = bfincnfgcldao.selectByMdlNm(mdlNm);
    	if(_mdlNm!=null)
    	{
    		return mdlNm;
    	}
    	return "";
	}

	@Override
	public String checkMdl(BFinCnfgCl bFinCnfgCl) {
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgCl bFinCnfgCldal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgCl();
		try
		{
			BeanUtils.copyProperties(bFinCnfgCl, bFinCnfgCldal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		List<com.huateng.scf.bas.fin.dao.model.BFinCnfgCl> _mdl = bfincnfgcldao.selectByMdl(bFinCnfgCldal);
    	if(_mdl.size()>0)
    	{
    		return "false";
    	}
    	return "";
	}
	
	@Override
	public String checkMdlTyp(BFinCnfgCl bFinCnfgCl)
	{
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgCl bFinCnfgCldal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgCl();
		try
		{
			BeanUtils.copyProperties(bFinCnfgCl, bFinCnfgCldal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		List<com.huateng.scf.bas.fin.dao.model.BFinCnfgCl> _mdl = bfincnfgcldao.selectByMdlTyp(bFinCnfgCldal);
    	if(_mdl.size()>0)
    	{
    		return "false";
    	}
    	return "";
	}
	
	@Override
	public String checkMdlTypById(BFinCnfgCl bFinCnfgCl)
	{
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgCl bFinCnfgCldal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgCl();
		try
		{
			BeanUtils.copyProperties(bFinCnfgCl, bFinCnfgCldal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		List<com.huateng.scf.bas.fin.dao.model.BFinCnfgCl> _mdl = bfincnfgcldao.selectByMdlTypById(bFinCnfgCldal);
    	if(_mdl.size()>0)
    	{
    		return "false";
    	}
    	return "";
	}
	
	@Override
	public List<BFinCnfgCl> queryMdlByMdlId(HashMap<String, String> map) 
	{
		Page page = new Page();
		page.setPageNo(1);
		page.setPageSize(10);
		HashMap<String, String> omap = new HashMap<String, String>();
		if(map!=null&&map.get("mdlId")!=null&&map.get("mdlNm")!=null)
		{
			omap.put("mdlId", map.get("mdlId").toString());
			omap.put("mdlNm", map.get("mdlNm").toString());
		}
		List<com.huateng.scf.bas.fin.dao.model.BFinCnfgCl> listdal = extbfincnfgsubjdao.queryMdlByMdlId(omap, page);
		List<BFinCnfgCl> list = new ArrayList<BFinCnfgCl>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.fin.dao.model.BFinCnfgCl cl:listdal)
			{
				BFinCnfgCl bFinCnfgCl = new BFinCnfgCl();
				BeanUtils.copyProperties(cl, bFinCnfgCl);
				list.add(bFinCnfgCl);
			}
		}
		return list;
	}
}
