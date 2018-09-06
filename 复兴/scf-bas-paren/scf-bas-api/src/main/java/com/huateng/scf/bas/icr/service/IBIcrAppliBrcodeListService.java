/**
 * 
 */
package com.huateng.scf.bas.icr.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.model.BIcrAppliBrcodeList;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>业务申请额度适用机构映射接口</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月14日.下午2:41:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月14日.下午2:41:35	     新增
 *
 * </pre>
 */

public interface IBIcrAppliBrcodeListService {
	/**
	 * 新增业务申请额度适用机构映射
	 * @param bIcrAppliBrcodeList
	 * 		BIcrAppliBrcodeList对象
	 * @return
	 */
	public void addAppliBrcodeList(@ScubeParam("bIcrAppliBrcodeList") BIcrAppliBrcodeList bIcrAppliBrcodeList)throws ScubeBizException;
	/**
	 * 修改业务申请额度适用机构映射
	 * @param bIcrAppliBrcodeList
	 * 		BIcrAppliBrcodeList对象
	 * @return
	 */
	public int updateAppliBrcodeList(@ScubeParam("bIcrAppliBrcodeList") BIcrAppliBrcodeList bIcrAppliBrcodeList)throws ScubeBizException;
	/**
	 * 根据ID删除业务申请额度适用机构映射
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key)throws ScubeBizException;
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrAppliBrcodeList
	 * @return Page对象
	 */
	public Page queryAppliBrcodeListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bIcrAppliBrcodeList") BIcrAppliBrcodeList bIcrAppliBrcodeList)throws ScubeBizException;
	/**
	 * 根据ID查询业务申请额度适用机构映射信息
	 * @param key
	 * @return
	 */
	public BIcrAppliBrcodeList queryAppliBrcodeListKey(@ScubeParam("key") String key)throws ScubeBizException;
	
	
	
	public void deleteAppliBrcodeListByNo(@ScubeParam("bIcrAppliBrcodeList") BIcrAppliBrcodeList bIcrAppliBrcodeList)throws ScubeBizException;
	
	/**
	 * 根据额度编号查询额度申请业务申请机构映射信息
	 * @param bIcrAppliInfo
	 * @return
	 */
	public List<BIcrAppliBrcodeList> queryBIcrAppliBrcodeByCreditNo(@ScubeParam("bIcrAppliBrcodeList") BIcrAppliBrcodeList bIcrAppliBrcodeList);

}
