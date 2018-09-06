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
import com.huateng.scf.bas.crr.dao.IBCrrInvInfoDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrInvInfoExample;
import com.huateng.scf.bas.crr.dao.model.BCrrInvInfoExample.Criteria;
import com.huateng.scf.bas.crr.model.BCrrInvInfo;
import com.huateng.scf.bas.crr.service.IBCrrInvInfoService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrInvInfo接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:55:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:55:57	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrInvInfoServiceImpl")
public class BCrrInvInfoServiceImpl implements IBCrrInvInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrInvInfoDAO")
	IBCrrInvInfoDAO bcrrinvinfodao;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Override
	@Transactional
	public BCrrInvInfo add(BCrrInvInfo bCrrInvInfo) {
		log.info("新增发票信息");
		String invId = ibSysSerialNoService.genSerialNo("INV_NO");
		bCrrInvInfo.setInvId(invId);
		bCrrInvInfo.setBillId(bCrrInvInfo.getInvId());
		bCrrInvInfo.setBillNo(bCrrInvInfo.getInvNo());
		BCrrModelCommonUtil.setAddField(bCrrInvInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrInvInfo bCrrInvInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrInvInfo();
		try
		{
			BeanUtils.copyProperties(bCrrInvInfo, bCrrInvInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcrrinvinfodao.insertSelective(bCrrInvInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return bCrrInvInfo;
	}

	@Override
	@Transactional
	public int update(BCrrInvInfo bCrrInvInfo) {
		log.info("更新发票信息");
		bCrrInvInfo.setBillId(bCrrInvInfo.getInvId());
		bCrrInvInfo.setBillNo(bCrrInvInfo.getInvNo());
		BCrrModelCommonUtil.setUpdateField(bCrrInvInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrInvInfo bCrrInvInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrInvInfo();
		try
		{
			BeanUtils.copyProperties(bCrrInvInfo, bCrrInvInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		try
		{
			i = bcrrinvinfodao.updateByPrimaryKeySelective(bCrrInvInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(BCrrInvInfo bCrrInvInfo) {
		String invId = bCrrInvInfo.getInvId();
		int i;
		try
		{
			i = bcrrinvinfodao.deleteByPrimaryKey(invId);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("删除异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(List<BCrrInvInfo> list) {
		int rows = 0;
		if(list.size()>0)
		{
			for(BCrrInvInfo bCrrInvInfo : list)
			{
				rows += delete(bCrrInvInfo);
			}
		}
		return rows;
	}

	@Override
	public Page findbCrrInvInfoByPage(int pageNo, int pageSize, BCrrInvInfo bCrrInvInfo) {
		BCrrInvInfoExample example = new BCrrInvInfoExample();
		Criteria cri = example.createCriteria();
		
		if(bCrrInvInfo!=null)
		{
			if(bCrrInvInfo.getExtId()!=null&&bCrrInvInfo.getExtId().length()>0)
			{
				cri.andExtIdEqualTo(bCrrInvInfo.getExtId());
			}
		}
		example.setOrderByClause("INP_DT");
		
		int total = bcrrinvinfodao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		List<com.huateng.scf.bas.crr.dao.model.BCrrInvInfo> list = bcrrinvinfodao.selectByPage(example, p);
		List<com.huateng.scf.bas.crr.dao.model.BCrrInvInfo> listdal = 
				new ArrayList<com.huateng.scf.bas.crr.dao.model.BCrrInvInfo>();
		if(list.size()>0)
		{
			for(com.huateng.scf.bas.crr.dao.model.BCrrInvInfo bcrrinvinfo:list)
			{
				bcrrinvinfo.setBillId(bcrrinvinfo.getInvId());
				bcrrinvinfo.setBillNo(bcrrinvinfo.getInvNo());
				listdal.add(bcrrinvinfo);
			}
		}
		
		p.setRecords(listdal);
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	@Override
	public HashMap<String, BCrrInvInfo> findBCrrInvInfoById(String id)
	{
		String flag = "";
		HashMap<String, BCrrInvInfo> map = new HashMap<String, BCrrInvInfo>();
		BCrrInvInfo bCrrInvInfo = new BCrrInvInfo();
		com.huateng.scf.bas.crr.dao.model.BCrrInvInfo bCrrInvInfodal = bcrrinvinfodao.selectByPrimaryKey(id);
		if(bCrrInvInfodal!=null)
		{
			flag = "update";
			try
			{
				BeanUtils.copyProperties(bCrrInvInfodal, bCrrInvInfo);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("转换异常");
			}
		}
		else
		{
			flag = "add";
		}
		//map的第一个键值对
		BCrrInvInfo bcrrinvinfo = new BCrrInvInfo();
		bcrrinvinfo.setRelaNo(flag);
		map.put("flag", bcrrinvinfo);
		//map的第二个键值对
		map.put("record", bCrrInvInfo);
		return map;
	}
	
}
