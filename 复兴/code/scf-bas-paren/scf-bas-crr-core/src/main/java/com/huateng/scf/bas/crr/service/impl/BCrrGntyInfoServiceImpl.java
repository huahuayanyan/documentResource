package com.huateng.scf.bas.crr.service.impl;

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
import com.huateng.data.dto.BdDataDictDto;
import com.huateng.data.dto.DataItem;
import com.huateng.data.service.BdDataDictService;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scf.bas.crr.dao.IBCrrGntyInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyRelaDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyInfoExample;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyInfoExample.Criteria;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyRela;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrGntyInfo;
import com.huateng.scf.bas.crr.service.IBCrrGntyInfoService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrGntyInfo接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:36:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:36:11	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrGntyInfoServiceImpl")
public class BCrrGntyInfoServiceImpl implements IBCrrGntyInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrGntyInfoDAO")
	IBCrrGntyInfoDAO bcrrgntyinfodao;
	
	@Resource(name = "IBCrrGntyRelaDAO")
	IBCrrGntyRelaDAO bcrrgntyreladao;
	
	@Resource(name = "bdDataDictService")
	BdDataDictService bdDataDictService;
	
	@Override
	@Transactional
	public void add(BCrrGntyInfo bCrrGntyInfo) {
		log.debug("开始插入担保物信息");
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrGntyInfo bCrrGntyInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrGntyInfo();
		try
		{
			BeanUtils.copyProperties(bCrrGntyInfo, bCrrGntyInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcrrgntyinfodao.insertSelective(bCrrGntyInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		BCrrGntyRela bCrrGntyReladal = new BCrrGntyRela();
		try
		{
			BeanUtils.copyProperties(bCrrGntyInfo, bCrrGntyReladal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}

		bCrrGntyReladal.setRltTyp("03");
		bCrrGntyReladal.setConNo(bCrrGntyInfo.getSerialno());
		try
		{
			bcrrgntyreladao.insertSelective(bCrrGntyReladal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("关联信息插入异常");
		}
	}

	@Override
	@Transactional
	public int update(BCrrGntyInfo bCrrGntyInfo) {
		log.debug("开始修改担保物信息");
		BCrrModelCommonUtil.setUpdateField(bCrrGntyInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrGntyInfo bCrrGntyInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrGntyInfo();
		try
		{
			BeanUtils.copyProperties(bCrrGntyInfo, bCrrGntyInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		try
		{
			i = bcrrgntyinfodao.updateByPrimaryKeySelective(bCrrGntyInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(List<BCrrGntyInfo> list) {
		int rows = 0;
		if(list.size()>0)
		{
			for(BCrrGntyInfo bCrrGntyInfo:list)
			{
				String gntyId = bCrrGntyInfo.getGntyId();
				try
				{
					bcrrgntyreladao.deleteByRltNo(gntyId);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("担保物关联信息删除异常");
				}
				try
				{
					rows += bcrrgntyinfodao.deleteByPrimaryKey(gntyId);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("担保物信息删除异常");
				}
				
			}
		}
		return rows;
	}

	@Override
	public Page findBCrrGntyInfoByPage(int pageNo, int pageSize, BCrrGntyInfo bCrrGntyInfo) {
		BCrrGntyInfoExample example = new BCrrGntyInfoExample();
		Criteria cri = example.createCriteria();
		if(bCrrGntyInfo!=null)
		{
			//业务申请主键
			if(bCrrGntyInfo.getConId()!=null&&bCrrGntyInfo.getConId().length()>0)
			{
				List<String> gntyIdList = new ArrayList<String>();
				String conId = bCrrGntyInfo.getConId();
				List<BCrrGntyRela> relalist = bcrrgntyreladao.selectBySerialno(conId);
				if(relalist.size()>0)
				{
					for(BCrrGntyRela rela : relalist)
					{
						String gntyId = rela.getRltNo();
						gntyIdList.add(gntyId);
					}
					cri.andGntyIdIn(gntyIdList);
				}
				else
				{
					cri.andGntyIdIsNull();
				}
			}
		}
		example.setOrderByClause("INP_DT DESC");
		
		int total = bcrrgntyinfodao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		p.setRecords(bcrrgntyinfodao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}

	@Override
	public Page findBCrrGntyInfoByPageAndConId(int pageNo, int pageSize, List<BCrrGntyCon> list) {
		BCrrGntyInfoExample example = new BCrrGntyInfoExample();
		Criteria cri = example.createCriteria();
		
		if(list.size()>0)
		{
			List<String> gntyIdList = new ArrayList<String>();
			for(BCrrGntyCon bCrrGntyCon:list)
			{
				if(bCrrGntyCon.getConId()!=null&&bCrrGntyCon.getConId().length()>0)
				{
					String conId = bCrrGntyCon.getConId();
					List<BCrrGntyRela> relalist = bcrrgntyreladao.selectBySerialno(conId);
					if(relalist.size()>0)
					{
						for(BCrrGntyRela rela : relalist)
						{
							String gntyId = rela.getRltNo();
							gntyIdList.add(gntyId);
						}
					}
				}
			}
			//业务申请主键
			if(gntyIdList.size()>0)
			{
				cri.andGntyIdIn(gntyIdList);
			}
			else
			{
				cri.andGntyIdIsNull();
			}
		}
		else
		{
			cri.andGntyIdIsNull();
		}
		example.setOrderByClause("INP_DT DESC");
		
		int total = bcrrgntyinfodao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		p.setRecords(bcrrgntyinfodao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}

	@Override
	public List<TreeModel> changeGuarantyListToTree (HashMap<String, String> value)
	{
		List<BdDataDictDto> list = new ArrayList<BdDataDictDto>();
		String dataVal = "";
		String dictCode = "";
		if(value!=null&&value.get("dictCode")!=null&&value.get("dataVal")!=null)
		{
			list = bdDataDictService.getConfigDictData(value.get("dictCode").trim());
			dataVal = value.get("dataVal").trim();
			dictCode = value.get("dictCode").trim();
		}
		List<TreeModel> treeList = new ArrayList<TreeModel>();
		if(list.size()>0)
		{
			for (BdDataDictDto bddata : list) 
			{
				if(bddata.getDictCode().equals(dictCode))
				{
					List<DataItem> dataItems = bddata.getDataItems();
					for(DataItem item : dataItems)
					{
						String level = "";
						String parentId = "";
						TreeModel treeModel = new TreeModel();
						treeModel.setTreeId(item.getDataVal());
						treeModel.setTreeName(item.getDataTrsVal());
						String itemDataVal = item.getDataVal().trim();
						if(itemDataVal.length()>=3)
						{
							//判断是否所需数据字典项
							String index = itemDataVal.substring(0, 3);
							if(index.equals(dataVal))
							{
								if(itemDataVal.length()<6)
								{
									level = "1";
									parentId = "0";
								}
								else if(itemDataVal.length()==6)
								{
									level = "2";
									parentId = index;
								}
								else
								{
									index = itemDataVal.substring(0, 6);
									level = "3";
									parentId = index;
								}
								treeModel.setTreeLevel(level);
								treeModel.setTreeParentId(parentId);
								treeList.add(treeModel);
							}
						}
					}
				}
			}
		}
		return treeList;
	}
}
