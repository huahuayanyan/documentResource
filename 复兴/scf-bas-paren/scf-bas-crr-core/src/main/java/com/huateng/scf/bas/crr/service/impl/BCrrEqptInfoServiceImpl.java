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
import com.huateng.scf.bas.crr.dao.IBCrrEqptInfoDAO;
import com.huateng.scf.bas.crr.model.BCrrEqptInfo;
import com.huateng.scf.bas.crr.service.IBCrrEqptInfoService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrEqptInfo接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月15日上午8:53:06
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月15日上午8:53:06	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrEqptInfoServiceImpl")
public class BCrrEqptInfoServiceImpl implements IBCrrEqptInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrEqptInfoDAO")
	IBCrrEqptInfoDAO bcrreqptinfodao;
	
	@Override
	@Transactional
	public BCrrEqptInfo add(BCrrEqptInfo bCrrEqptInfo) {
		log.info("新增设备信息");
		bCrrEqptInfo.setEqptId(bCrrEqptInfo.getId());
		bCrrEqptInfo.setBillId(bCrrEqptInfo.getEqptId());
		bCrrEqptInfo.setBillNo(bCrrEqptInfo.getEqptNm());
		BCrrModelCommonUtil.setAddField(bCrrEqptInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrEqptInfo bCrrEqptInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrEqptInfo();
		try
		{
			BeanUtils.copyProperties(bCrrEqptInfo, bCrrEqptInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcrreqptinfodao.insertSelective(bCrrEqptInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return bCrrEqptInfo;
	}

	@Override
	@Transactional
	public int update(BCrrEqptInfo bCrrEqptInfo) {
		log.info("更新设备信息");
		bCrrEqptInfo.setBillId(bCrrEqptInfo.getEqptId());
		bCrrEqptInfo.setBillNo(bCrrEqptInfo.getEqptNm());
		BCrrModelCommonUtil.setUpdateField(bCrrEqptInfo);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrEqptInfo bCrrEqptInfodal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrEqptInfo();
		try
		{
			BeanUtils.copyProperties(bCrrEqptInfo, bCrrEqptInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		try
		{
			i = bcrreqptinfodao.updateByPrimaryKeySelective(bCrrEqptInfodal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(String eqptId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int batchDelete(String eqptIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page findbCrrEqptInfoByPage(int pageNo, int pageSize, BCrrEqptInfo bCrrEqptInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HashMap<String, BCrrEqptInfo> findBCrrEqptInfoById(String id)
	{
		String flag = "";
		HashMap<String, BCrrEqptInfo> map = new HashMap<String, BCrrEqptInfo>();
		BCrrEqptInfo bCrrEqptInfo = new BCrrEqptInfo();
		com.huateng.scf.bas.crr.dao.model.BCrrEqptInfo bCrrEqptInfodal = bcrreqptinfodao.selectByPrimaryKey(id);
		if(bCrrEqptInfodal!=null)
		{
			flag = "update";
			try
			{
				BeanUtils.copyProperties(bCrrEqptInfodal, bCrrEqptInfo);
				bCrrEqptInfo.setBillId(id);
				bCrrEqptInfo.setBillNo(bCrrEqptInfo.getEqptNm());
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
		BCrrEqptInfo bcrreqptinfo = new BCrrEqptInfo();
		bcrreqptinfo.setRelaNo(flag);
		map.put("flag", bcrreqptinfo);
		//map的第二个键值对
		map.put("record", bCrrEqptInfo);
		return map;
	}

}
