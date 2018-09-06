/**
 * 
 */
package com.huateng.scf.bas.lan.service;

import java.util.List;

import com.huateng.scf.bas.lan.model.BLanBillBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>票据基本信息接口</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月14日.下午4:33:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月14日.下午4:33:17	     新增
 *
 * </pre>
 */

public interface IBLanBillBaseInfoService {
	public static final String BEAN_ID = "bLanBillBaseInfoService";
	/**
	 * 根据主键查询基本信息
	 * @param key
	 * @return
	 * @throws ScubeBizException
	 */
	public BLanBillBaseInfo findBLanBillBaseInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;
	
	/**
	 * 根据借据号获得票据基本信息
	 * @param debetNo
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BLanBillBaseInfo> findBLanBillInfoByDebetNo(@ScubeParam("debetNo") String debetNo)throws ScubeBizException;
}
