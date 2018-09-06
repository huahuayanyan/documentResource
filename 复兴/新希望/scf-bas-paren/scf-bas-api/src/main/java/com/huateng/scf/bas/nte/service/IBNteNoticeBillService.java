/**
 * 
 */
package com.huateng.scf.bas.nte.service;

import java.util.List;

import com.huateng.scf.bas.nte.model.BNteNoticeBill;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>通知书票据信息</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月15日.上午9:21:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月15日.上午9:21:27	     新增
 *
 * </pre>
 */

public interface IBNteNoticeBillService {
	public static final String BEAN_ID = "bNteNoticeBillService";

	public void addBNteNoticeBill(@ScubeParam("bNteNoticeBill") BNteNoticeBill bNteNoticeBill) throws ScubeBizException;
	/**
	 * @param bNteNoticeBill
	 * @return
	 */
	public int updateBNteNoticeBill(@ScubeParam("bNteNoticeBill") BNteNoticeBill bNteNoticeBill) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public int deleteBNteNoticeBill(@ScubeParam("key") String key)throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public BNteNoticeBill findBNteNoticeBillByKey(@ScubeParam("key") String key) throws ScubeBizException;
	
	/**
	 * 通过APPNO查找通知书票据信息
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BNteNoticeBill> findBNteNoticeBillByAppno(@ScubeParam("appno") String appno)throws ScubeBizException;
}
