package com.huateng.scf.bas.lan.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.model.BLanLnciBuyBiz;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>借据基本信息接口</p>
 *
 * @author 	liph
 * @date 	2016年12月14日.上午11:13:52
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月14日.上午11:13:52	     新增
 *
 * </pre>
 */

public interface IBLanLnciBuyBizService {
	public static final String BEAN_ID = "bLanLnciBuyBizService";
	/**
	 * @param value
	 * @return
	 */
	public Page findBLanLnciBuyBizByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("value") BLanLnciBuyBiz bLanLnciBuyBiz) throws ScubeBizException;
	
	/**
	 * @param key
	 * @return
	 */
	public BLanLnciBuyBiz findBLanLnciBuyBizByKey(@ScubeParam("bLanLnciBuyBiz") BLanLnciBuyBiz bLanLnciBuyBiz) throws ScubeBizException;
	
	
	/**
	 * @param bLanLnciBuyBiz
	 * @return
	 */
	public String add(@ScubeParam("buyinfoArray") List<BLanLnciBuyBiz> list,@ScubeParam("appno") String appno,@ScubeParam("drawbackTerm") String drawbackTerm);
	
	/**
	 * @param id
	 * @return
	 */
	public String delete(@ScubeParam("id") String id);
	
	/**
	 * @param bLanLnciBuyBiz
	 * @return
	 */
	public int updateBLanLnciBuyBiz(@ScubeParam("bLanLnciBuyBiz") BLanLnciBuyBiz bLanLnciBuyBiz) throws ScubeBizException;
	/**
	 * 新增
	 * @param bLanLnciBuyBiz
	 * @throws ScubeBizException
	 */
	public void addBLanLnciBuyBiz(@ScubeParam("bLanLnciBuyBiz") BLanLnciBuyBiz bLanLnciBuyBiz) throws ScubeBizException;
	
	
	//ext
	
	/**
	 * 根据条件查询放款申请购销合同流水信息
	 * @param bLanLnciBuyBiz
	 * @return
	 */
	public List<BLanLnciBuyBiz> findBLanLnciBuyBizByCondition(@ScubeParam("bLanLnciBuyBiz") BLanLnciBuyBiz bLanLnciBuyBiz) throws ScubeBizException;
	
	
}
