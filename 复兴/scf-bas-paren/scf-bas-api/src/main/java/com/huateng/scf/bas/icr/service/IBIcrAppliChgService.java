package com.huateng.scf.bas.icr.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.model.BIcrAppliChg;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>额度变更申请服务接口</p>
 *
 * @author 	huangshuidan
 * @date 	2016年10月31日 下午1:46:29
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年10月31日 下午1:46:29	     新增
 *
 * </pre>
 */
public interface IBIcrAppliChgService { 
	/**
	 * 新增额度变更申请
	 * @param bIcrAppliChg
	 * 		BIcrAppliChg对象
	 * @return
	 */
	public void addCreditAppliChg(@ScubeParam("bIcrAppliChg") BIcrAppliChg bIcrAppliChg);
	/**
	 * 修改额度变更申请
	 * @param bIcrAppliChg
	 * 		BIcrAppliChg对象
	 * @return
	 */
	public int updateCreditAppliChg(@ScubeParam("bIcrAppliChg") BIcrAppliChg bIcrAppliChg);
	/**
	 * 根据ID删除额度变更申请
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrAppliChg
	 * @return Page对象
	 */
	public Page queryCreditAppliChgByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bIcrAppliChg") BIcrAppliChg bIcrAppliChg);
	/**
	 * 根据ID查询额度变更申请信息
	 * @param key
	 * @return
	 */
	public BIcrAppliChg queryCreditAppliChgKey(@ScubeParam("key") String key);
}
