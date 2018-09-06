/**
 * 
 */
package com.huateng.scf.bas.icr.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.model.BIcrBrcodeList;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>额度适用机构关联接口</p>
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

public interface IBIcrBrcodeListService {
	/**
	 * 新增额度适用机构关联
	 * @param bIcrBrcodeList
	 * 		BIcrBrcodeList对象
	 * @return
	 */
	public void addBrcodeList(@ScubeParam("bIcrBrcodeList") BIcrBrcodeList bIcrBrcodeList)throws ScubeBizException;
	/**
	 * 修改额度适用机构关联
	 * @param bIcrBrcodeList
	 * 		BIcrBrcodeList对象
	 * @return
	 */
	public int updateBrcodeList(@ScubeParam("bIcrBrcodeList") BIcrBrcodeList bIcrBrcodeList)throws ScubeBizException;
	/**
	 * 根据ID删除额度适用机构关联
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key)throws ScubeBizException;
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrBrcodeList
	 * @return Page对象
	 */
	public Page queryBrcodeListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bIcrBrcodeList") BIcrBrcodeList bIcrBrcodeList)throws ScubeBizException;
	/**
	 * 根据ID查询额度适用机构关联信息
	 * @param key
	 * @return
	 */
	public BIcrBrcodeList queryBrcodeListKey(@ScubeParam("key") String key)throws ScubeBizException;
	
	
	
	public void deleteBrcodeListByNo(@ScubeParam("bIcrBrcodeList") BIcrBrcodeList bIcrBrcodeList)throws ScubeBizException;

}
