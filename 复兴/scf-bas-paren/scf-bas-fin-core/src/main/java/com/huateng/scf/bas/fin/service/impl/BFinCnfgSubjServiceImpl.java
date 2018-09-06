package com.huateng.scf.bas.fin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scf.bas.fin.dao.IBFinCnfgClDAO;
import com.huateng.scf.bas.fin.dao.IBFinCnfgDefDAO;
import com.huateng.scf.bas.fin.dao.IBFinCnfgSubjDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgClExample;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgSubjExample;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgSubjExample.Criteria;
import com.huateng.scf.bas.fin.model.BFinCnfgSubj;
import com.huateng.scf.bas.fin.service.IBFinCnfgSubjService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.bas.fin.dao.ext.ExtBFinCnfgSubjDAO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * <p>BFinCnfgSubj接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午2:16:23
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午2:16:23	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BFinCnfgSubjServiceImpl")
public class BFinCnfgSubjServiceImpl implements IBFinCnfgSubjService{
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBFinCnfgSubjDAO")
	IBFinCnfgSubjDAO bfincnfgsubjdao;
	
	@Resource(name = "IBFinCnfgDefDAO")
	IBFinCnfgDefDAO bfincnfgdefdao;
	
	@Resource(name = "IBFinCnfgClDAO")
	IBFinCnfgClDAO bfincnfgcldao;
	
	@Resource(name = "ExtBFinCnfgSubjDAO")
	ExtBFinCnfgSubjDAO extbfincnfgsubjdao;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Override
	public BFinCnfgSubj findBFinCnfgSubjByName(String subjNm) {
		log.info(subjNm);
		com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj bfincnfgsubjdal = bfincnfgsubjdao.selectBySubjNm(subjNm);
		// VO转PO 展现层对象转换DAO层对象
		BFinCnfgSubj bfincnfgsubj = new BFinCnfgSubj();
		try
		{
			BeanUtils.copyProperties(bfincnfgsubjdal, bfincnfgsubj);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		return bfincnfgsubj;
	}

	@Override
	@Transactional
	public String add(BFinCnfgSubj bFinCnfgSubj) {
		if(StringUtils.isEmpty(bFinCnfgSubj.getSubjId()))
		{
			String subjId = ibSysSerialNoService.genSerialNo("SUBJ_NO");
			bFinCnfgSubj.setSubjId(subjId);
		}
		else
		{
			com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj cnfgSubj = 
					bfincnfgsubjdao.selectByPrimaryKey(bFinCnfgSubj.getSubjId());
			if(cnfgSubj!=null)
			{
				throw new ScubeBizException("科目编号已存在，请重新填写或清空！");
			}
		}
		String flag = this.checkSubj(bFinCnfgSubj);
		if(flag.equals("false"))
		{
			throw new ScubeBizException("科目编号已存在，请重新填写！");
		}
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj bFinCnfgSubjdal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj();
		try
		{
			BeanUtils.copyProperties(bFinCnfgSubj, bFinCnfgSubjdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		String i;
		try
		{
			i = bfincnfgsubjdao.insert(bFinCnfgSubjdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int update(BFinCnfgSubj bFinCnfgSubj) {
		String flag = this.checkSubj(bFinCnfgSubj);
		if(flag.equals("false"))
		{
			throw new ScubeBizException("科目名称已存在，请重新填写！");
		}
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj bFinCnfgSubjdal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj();
		try
		{
			BeanUtils.copyProperties(bFinCnfgSubj, bFinCnfgSubjdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		try
		{
			i = bfincnfgsubjdao.updateByPrimaryKey(bFinCnfgSubjdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	public Page findBFinCnfgSubjByPage(int pageNo, int pageSize, BFinCnfgSubj bFincnfgSubj) {
		
		BFinCnfgSubjExample example = new BFinCnfgSubjExample();
		Criteria cri = example.createCriteria();
		
		if (bFincnfgSubj != null) {
			//精确查询
			if (bFincnfgSubj.getSubjNm() != null&&bFincnfgSubj.getSubjNm().length()>0) {
				cri.andSubjNmLike("%"+bFincnfgSubj.getSubjNm()+"%");
			}
			if(bFincnfgSubj.getSubjId()!=null&&bFincnfgSubj.getSubjId().length()>0){
				cri.andSubjIdLike("%"+bFincnfgSubj.getSubjId()+"%");
			}
			if(bFincnfgSubj.getDelFlg()!=null&&bFincnfgSubj.getDelFlg().length()>0){
				cri.andDelFlgLike("%"+bFincnfgSubj.getDelFlg()+"%");
			}
		}
		example.setOrderByClause("SUBJ_ID ASC");
		
		int total = bfincnfgsubjdao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		p.setRecords(bfincnfgsubjdao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	@Override
	public List<BFinCnfgSubj> selectForSelect(BFinCnfgSubj bFinCnfgSubj) {
		BFinCnfgSubjExample example = new BFinCnfgSubjExample();
		Criteria cri = example.createCriteria();
		cri.andDelFlgEqualTo("0");
		List<com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj> listdal = bfincnfgsubjdao.selectByExample(example);
		List<BFinCnfgSubj> list = new ArrayList<BFinCnfgSubj>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj bFinCnfgSubjdal:listdal)
			{
				// VO转PO 展现层对象转换DAO层对象
				BFinCnfgSubj bfinsubj = new BFinCnfgSubj();
				try
				{
					BeanUtils.copyProperties(bFinCnfgSubjdal, bfinsubj);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				bfinsubj.setSubj(bfinsubj.getSubjNm()+","+bfinsubj.getSubjId());
				list.add(bfinsubj);
			}
		}
		return list;
	}
	
	@Override
	public BFinCnfgSubj findBFinCnfgSubjBysubjId(String subjId) {
		log.info(subjId);
		try
		{
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		// VO转PO 展现层对象转换DAO层对象
		BFinCnfgSubj bfincnfgsubj = new BFinCnfgSubj();
		com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj bFinCnfgSubjdal = bfincnfgsubjdao.selectByPrimaryKey(subjId);
		try
		{
			BeanUtils.copyProperties(bFinCnfgSubjdal, bfincnfgsubj);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		return bfincnfgsubj;
	}

	@Override
	public String getString(String s) {
		log.info(s);
		return "财务报表科目"+s;
	}

	@Override
	@Transactional
	public int delete(String subjId) {
		int i;
		try
		{
			i = bfincnfgsubjdao.deleteByPrimaryKey(subjId);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("删除异常");
		}
		return i;
	}
	/**
	 * 批量删除信息
	 */
	@Override
	@Transactional
	public int batchDelete(String subjIds)
	{
		int i=0;
		String[] subjIdArr = subjIds.split(",");
		for(String subjId:subjIdArr)
		{
			i += delete(subjId);
		}
		return i;
	}

	/**
	 * 科目名称相同，编号不同
	 * @param bFinCnfgSubj
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月17日下午4:39:14
	 */
	public String checkSubj(BFinCnfgSubj bFinCnfgSubj) {
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj bFinCnfgSubjdal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj();
		try
		{
			BeanUtils.copyProperties(bFinCnfgSubj, bFinCnfgSubjdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		List<com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj> list = bfincnfgsubjdao.selectBySubj(bFinCnfgSubjdal);
    	if(list.size()>0)
    	{
    		return "false";
    	}
    	return "";
	}
	
	@Override
	public Page querySubjSource(int pageNo, int pageSize,Map<String, String> value) {
		log.debug("传递参数,value="+value);
		Page p = new Page(pageSize, pageNo,0);
		Map<String, String>  omap = new HashMap<String, String>(); 
		if(value!=null&&value.get("subjId")!=null&&value.get("subjNm")!=null){
			omap.put("subjId",value.get("subjId").toString().trim());
			omap.put("subjNm", value.get("subjNm").toString().trim());
		}
		extbfincnfgsubjdao.querySubjList(omap,p);
		return p;
	}
	
	@Override
	public List<TreeModel> changeBFinCnfgSubjToTree (HashMap<String, String> value)
	{
		//模型列表
		List<BFinCnfgCl> cllist = bfincnfgcldao.selectByExample(new BFinCnfgClExample());
		//科目列表
		List<com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj> list = 
				bfincnfgsubjdao.selectByExample(new BFinCnfgSubjExample());
		//初始化树状
		List<TreeModel> treeList = new ArrayList<TreeModel>();
		if(value!=null&&value.get("mdlId")!=null&&value.get("mdlNm")!=null)
		{
			TreeModel treeModel = new TreeModel();
			treeModel.setTreeId(value.get("mdlId").toString().trim());
			treeModel.setTreeName(value.get("mdlNm").toString().trim());
			treeModel.setTreeLevel("1");
			treeModel.setTreeParentId("0");
			treeList.add(treeModel);
		}
		else
		{
			for(BFinCnfgCl bfincl:cllist)
			{
				TreeModel treeModel = new TreeModel();
				treeModel.setTreeId(bfincl.getMdlId());
				treeModel.setTreeName(bfincl.getMdlNm());
				treeModel.setTreeLevel("1");
				treeModel.setTreeParentId("0");
				treeList.add(treeModel);
			}
		}
		if(list.size()>0)
		{
			for(BFinCnfgCl bfincl:cllist)
			{
				String mdlId = bfincl.getMdlId();
				for (com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj bfinsubj : list) 
				{
					String subjId = bfinsubj.getSubjId();
					String index = subjId.substring(0, mdlId.length());
					if(mdlId.equals(index))
					{
						TreeModel treeModel = new TreeModel();
						treeModel.setTreeId(subjId);
						treeModel.setTreeName(bfinsubj.getSubjNm());
						treeModel.setTreeLevel("2");
						treeModel.setTreeParentId(mdlId);
						treeList.add(treeModel);
					}
				}
				
			}
		}
		return treeList;
	}
}
