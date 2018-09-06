package com.huateng.scf.bas.crr.service.impl;

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
import com.huateng.scf.bas.crr.dao.IBCrrBillInfoDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrBillInfoExample;
import com.huateng.scf.bas.crr.dao.model.BCrrBillInfoExample.Criteria;
import com.huateng.scf.bas.crr.model.BCrrBillInfo;
import com.huateng.scf.bas.crr.service.IBCrrBillInfoService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrBillInfo接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午7:59:59
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午7:59:59	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrBillInfoServiceImpl")
public class BCrrBillInfoServiceImpl implements IBCrrBillInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrBillInfoDAO")
	IBCrrBillInfoDAO bcrrbillinfodao;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Override
	@Transactional
	public BCrrBillInfo add(BCrrBillInfo bCrrBillInfo) {
		log.info("新增票据信息");
		String billId = ibSysSerialNoService.genSerialNo("INV_NO");
		bCrrBillInfo.setBillId(billId);
		bCrrBillInfo.setExtId(bCrrBillInfo.getExtId());
		BCrrModelCommonUtil.setAddField(bCrrBillInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrBillInfo bCrrBillInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrBillInfo();
		try
		{
			BeanUtils.copyProperties(bCrrBillInfo, bCrrBillInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcrrbillinfodao.insertSelective(bCrrBillInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return bCrrBillInfo;
	}

	@Override
	@Transactional
	public int update(BCrrBillInfo bCrrBillInfo) {
		log.info("更新票据信息");
		BCrrModelCommonUtil.setUpdateField(bCrrBillInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrBillInfo bCrrBillInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrBillInfo();
		try
		{
			BeanUtils.copyProperties(bCrrBillInfo, bCrrBillInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		try
		{
			i = bcrrbillinfodao.updateByPrimaryKeySelective(bCrrBillInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(BCrrBillInfo bCrrBillInfo) {
		int i;
		String billId = bCrrBillInfo.getBillId();
		try
		{
			i = bcrrbillinfodao.deleteByPrimaryKey(billId);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("删除异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(List<BCrrBillInfo> list) {
		int rows = 0;
		if(list.size()>0)
		{
			for(BCrrBillInfo bCrrBillInfo : list)
			{
				rows += delete(bCrrBillInfo);
			}
		}
		return rows;
	}

	@Override
	public Page findBCrrBillInfoByPage(int pageNo, int pageSize, BCrrBillInfo bCrrBillInfo) {
		BCrrBillInfoExample example = new BCrrBillInfoExample();
		Criteria cri = example.createCriteria();
		
		if(bCrrBillInfo!=null)
		{
			if(bCrrBillInfo.getExtId()!=null&&bCrrBillInfo.getExtId().length()>0)
			{
				cri.andExtIdEqualTo(bCrrBillInfo.getExtId());
			}
		}
		example.setOrderByClause("INP_DT");
		
		int total = bcrrbillinfodao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bcrrbillinfodao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	@Override
	public Page findBCrrBillInfoByPageExt(int pageNo, int pageSize, HashMap<String, String> value) {
		BCrrBillInfoExample example = new BCrrBillInfoExample();
		Criteria cri = example.createCriteria();
		
		if(value!=null&&value.get("extId")!=null)
		{
			cri.andExtIdEqualTo(value.get("extId"));
			if(value.get("billNo")!=null)
			{
				cri.andBillNoEqualTo(value.get("billNo"));
			}
		}
		example.setOrderByClause("INP_DT");
		
		int total = bcrrbillinfodao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
				
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bcrrbillinfodao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	@Override
	public HashMap<String, BCrrBillInfo> findBCrrBillInfoById(String id)
	{
		String flag = "";
		com.huateng.scf.bas.crr.dao.model.BCrrBillInfo bCrrBillInfodal = bcrrbillinfodao.selectByPrimaryKey(id);
		HashMap<String, BCrrBillInfo> map = new HashMap<String, BCrrBillInfo>();
		BCrrBillInfo bCrrBillInfo = new BCrrBillInfo();
		if(bCrrBillInfodal!=null)
		{
			flag = "update";
			try
			{
				BeanUtils.copyProperties(bCrrBillInfodal, bCrrBillInfo);
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
		BCrrBillInfo bcrrbillinfo = new BCrrBillInfo();
		bcrrbillinfo.setRelaNo(flag);
		map.put("flag", bcrrbillinfo);
		//map的第二个键值对
		map.put("record", bCrrBillInfo);
		return map;
	}

}
