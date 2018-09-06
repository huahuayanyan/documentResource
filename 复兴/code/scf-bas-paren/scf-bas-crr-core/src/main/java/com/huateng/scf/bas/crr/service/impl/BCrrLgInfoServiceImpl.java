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
import com.huateng.scf.bas.crr.dao.IBCrrLgInfoDAO;
import com.huateng.scf.bas.crr.model.BCrrLgInfo;
import com.huateng.scf.bas.crr.service.IBCrrLgInfoService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrLgInfo接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月15日上午8:58:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月15日上午8:58:07	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrLgInfoServiceImpl")
public class BCrrLgInfoServiceImpl implements IBCrrLgInfoService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrLgInfoDAO")
	IBCrrLgInfoDAO bcrrlginfodao;
	
	@Override
	@Transactional
	public BCrrLgInfo add(BCrrLgInfo bCrrLgInfo) {
		log.info("新增保函信息");
		bCrrLgInfo.setLgId(bCrrLgInfo.getId());
		bCrrLgInfo.setBillId(bCrrLgInfo.getLgId());
		bCrrLgInfo.setBillNo(bCrrLgInfo.getLgNo());
		BCrrModelCommonUtil.setAddField(bCrrLgInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrLgInfo bCrrLgInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrLgInfo();
		try
		{
			BeanUtils.copyProperties(bCrrLgInfo, bCrrLgInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcrrlginfodao.insertSelective(bCrrLgInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return bCrrLgInfo;
	}

	@Override
	@Transactional
	public int update(BCrrLgInfo bCrrLgInfo) {
		log.info("更新保函信息");
		bCrrLgInfo.setBillId(bCrrLgInfo.getLgId());
		bCrrLgInfo.setBillNo(bCrrLgInfo.getLgNo());
		BCrrModelCommonUtil.setUpdateField(bCrrLgInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrLgInfo bCrrLgInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrLgInfo();
		try
		{
			BeanUtils.copyProperties(bCrrLgInfo, bCrrLgInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		try
		{
			i = bcrrlginfodao.updateByPrimaryKeySelective(bCrrLgInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(String lgId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int batchDelete(String lgIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page findbCrrLgInfoByPage(int pageNo, int pageSize, BCrrLgInfo bCrrLgInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HashMap<String, BCrrLgInfo> findBCrrLgInfoById(String id)
	{
		String flag = "";
		HashMap<String, BCrrLgInfo> map = new HashMap<String, BCrrLgInfo>();
		BCrrLgInfo bCrrLgInfo = new BCrrLgInfo();
		com.huateng.scf.bas.crr.dao.model.BCrrLgInfo bCrrLgInfodal = bcrrlginfodao.selectByPrimaryKey(id);
		if(bCrrLgInfodal!=null)
		{
			flag = "update";
			try
			{
				BeanUtils.copyProperties(bCrrLgInfodal, bCrrLgInfo);
				bCrrLgInfo.setBillId(id);
				bCrrLgInfo.setBillNo(bCrrLgInfo.getLgNo());
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
		BCrrLgInfo bcrrlginfo = new BCrrLgInfo();
		bcrrlginfo.setRelaNo(flag);
		map.put("flag", bcrrlginfo);
		//map的第二个键值对
		map.put("record", bCrrLgInfo);
		return map;
	}

}
