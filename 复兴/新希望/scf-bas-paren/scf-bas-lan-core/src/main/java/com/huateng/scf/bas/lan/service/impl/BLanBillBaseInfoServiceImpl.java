/**
 * 
 */
package com.huateng.scf.bas.lan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.lan.dao.IBLanBillBaseInfoDAO;
import com.huateng.scf.bas.lan.model.BLanBillBaseInfo;
import com.huateng.scf.bas.lan.service.IBLanBillBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月14日下午4:40:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月14日下午4:40:20	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BLanBillBaseInfoServiceImpl")
public class BLanBillBaseInfoServiceImpl implements IBLanBillBaseInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BLanBillBaseInfoDAO")
	IBLanBillBaseInfoDAO bLanBillBaseInfoDAO;
	/**
	 * 
     * 根据主键ID查询借据基本信息
     */
	
	@Override
	public BLanBillBaseInfo findBLanBillBaseInfoByKey(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		BLanBillBaseInfo bLanBillBaseInfo = new BLanBillBaseInfo();
		com.huateng.scf.bas.lan.dao.model.BLanBillBaseInfo bLanBillBaseInfodal = 
				new com.huateng.scf.bas.lan.dao.model.BLanBillBaseInfo();
		bLanBillBaseInfodal= bLanBillBaseInfoDAO.selectByPrimaryKey(key);
		BeanUtils.copyProperties(bLanBillBaseInfodal, bLanBillBaseInfo);
		return bLanBillBaseInfo;
	}
   /**
    * 根据借据号查询借据基本信息
    */
	@Override
	public List<BLanBillBaseInfo> findBLanBillInfoByDebetNo(String debetNo) throws ScubeBizException {
		List<BLanBillBaseInfo> list =  new ArrayList<BLanBillBaseInfo>(); 
		BLanBillBaseInfo bLanBillBaseInfo = new BLanBillBaseInfo();
		List<com.huateng.scf.bas.lan.dao.model.BLanBillBaseInfo> listdal=  bLanBillBaseInfoDAO.findBLanBillInfoByDebetNo(debetNo);
		for(com.huateng.scf.bas.lan.dao.model.BLanBillBaseInfo info:listdal){
			BeanUtils.copyProperties(info, bLanBillBaseInfo);
			list.add(bLanBillBaseInfo);
		}
		return list;
	}

}
