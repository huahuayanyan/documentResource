/**
 * 
 */
package com.huateng.scf.bas.sys.service;


import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.model.BSysInfoPublishMng;
import com.huateng.scf.bas.sys.model.PublishInfoQryVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年7月15日上午11:38:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年7月15日上午11:38:21              新增
 *
 * </pre>
 */
public interface IBSysInfoPublishMngService {
	
	public static final String BEAN_ID = "iBSysInfoPublishMngService";

	public String addBSysInfoPublishMng(@ScubeParam("bSysInfoPublishMng") BSysInfoPublishMng bSysInfoPublishMng) throws ScubeBizException;

	/**
	 * @param bSysInfoPublishMng
	 * @return
	 */
	public int updateBSysInfoPublishMng(@ScubeParam("bSysInfoPublishMng") BSysInfoPublishMng bSysInfoPublishMng) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBSysInfoPublishMng(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public BSysInfoPublishMng findBSysInfoPublishMngByKey(@ScubeParam("key") String key) throws ScubeBizException;
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param publishInfoQryVO
	 * @return
	 */
	public Page findBSysInfoPublishMngByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("publishInfoQryVO") PublishInfoQryVO publishInfoQryVO);
	
	
	/**
	 * 信息发布新增
	 * @param bSysInfoPublishMng
	 * @return
	 * @throws ScubeBizException
	 */
	public String addInfoPublish(@ScubeParam("bSysInfoPublishMng") BSysInfoPublishMng bSysInfoPublishMng) throws ScubeBizException;
	/**
	 * 信息发布更新
	 * @param bSysInfoPublishMng
	 * @return
	 * @throws ScubeBizException
	 */
	public String updateInfoPublish(@ScubeParam("bSysInfoPublishMng") BSysInfoPublishMng bSysInfoPublishMng) throws ScubeBizException;
	
	/**
	 * 信息发布删除
	 * @param bSysInfoPublishMng
	 * @throws ScubeBizException
	 * @return 
	 */
	public List<String> deleteInfoPublish(@ScubeParam("bSysInfoPublishMng") BSysInfoPublishMng bSysInfoPublishMng) throws ScubeBizException;

}
