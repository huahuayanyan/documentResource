package com.huateng.scf.bas.crr.service.impl;

import java.util.HashMap;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.IBCrrLcInfoDAO;
import com.huateng.scf.bas.crr.model.BCrrLcInfo;
import com.huateng.scf.bas.crr.service.IBCrrLcInfoService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrLcInfo接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:58:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:58:12	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrLcInfoServiceImpl")
public class BCrrLcInfoServiceImpl implements IBCrrLcInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrLcInfoDAO")
	IBCrrLcInfoDAO bcrrlcinfodao;
	
	@Override
	@Transactional
	public BCrrLcInfo add(BCrrLcInfo bCrrLcInfo) {
		log.info("新增信用证信息");
		bCrrLcInfo.setLcId(bCrrLcInfo.getId());
		bCrrLcInfo.setBillId(bCrrLcInfo.getLcId());
		bCrrLcInfo.setBillNo(bCrrLcInfo.getLcNo());
		BCrrModelCommonUtil.setAddField(bCrrLcInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrLcInfo bCrrLcInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrLcInfo();
		try
		{
			BeanUtils.copyProperties(bCrrLcInfo, bCrrLcInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcrrlcinfodao.insertSelective(bCrrLcInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return bCrrLcInfo;
	}

	@Override
	@Transactional
	public int update(BCrrLcInfo bCrrLcInfo) {
		log.info("更新保函信息");
		bCrrLcInfo.setBillId(bCrrLcInfo.getLcId());
		bCrrLcInfo.setBillNo(bCrrLcInfo.getLcNo());
		BCrrModelCommonUtil.setUpdateField(bCrrLcInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrLcInfo bCrrLcInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrLcInfo();
		try
		{
			BeanUtils.copyProperties(bCrrLcInfo, bCrrLcInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		try
		{
			i = bcrrlcinfodao.updateByPrimaryKeySelective(bCrrLcInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(String lcId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int batchDelete(String lcIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page findbCrrLcInfoByPage(int pageNo, int pageSize, BCrrLcInfo bCrrLcInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HashMap<String, BCrrLcInfo> findBCrrLcInfoById(String id)
	{
		String flag = "";
		HashMap<String, BCrrLcInfo> map = new HashMap<String, BCrrLcInfo>();
		BCrrLcInfo bCrrLcInfo = new BCrrLcInfo();
		com.huateng.scf.bas.crr.dao.model.BCrrLcInfo bCrrLcInfodal = bcrrlcinfodao.selectByPrimaryKey(id);
		if(bCrrLcInfodal!=null)
		{
			flag = "update";
			try
			{
				BeanUtils.copyProperties(bCrrLcInfodal, bCrrLcInfo);
				bCrrLcInfo.setBillId(id);
				bCrrLcInfo.setBillNo(bCrrLcInfo.getLcNo());
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
		BCrrLcInfo bcrrlcinfo = new BCrrLcInfo();
		bcrrlcinfo.setRelaNo(flag);
		map.put("flag", bcrrlcinfo);
		//map的第二个键值对
		map.put("record", bCrrLcInfo);
		return map;
	}

}
