package com.huateng.scf.bas.icr.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.model.BIcrAppliInfo;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>额度申请服务接口</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月09日 上午11:24:29
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月09日 上午11:24:29	     新增
 *
 * </pre>
 */
public interface IBIcrAppliInfoService { 
	public static final String BEAN_ID = "bIcrAppliInfoService";
	/**
	 * 新增额度申请
	 * @param bIcrAppliInfo
	 * 		BIcrAppliInfo对象
	 * @return
	 */
	public void addCreditAppliInfo(@ScubeParam("bIcrAppliInfo") BIcrAppliInfo bIcrAppliInfo);
	/**
	 * 修改额度申请
	 * @param bIcrAppliInfo
	 * 		BIcrAppliInfo对象
	 * @return
	 */
	public int updateCreditAppliInfo(@ScubeParam("bIcrAppliInfo") BIcrAppliInfo bIcrAppliInfo);
	/**
	 * 根据ID删除额度申请
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrAppliInfo
	 * @return Page对象
	 */
	public Page queryCreditAppliInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bIcrAppliInfo") BIcrAppliInfo bIcrAppliInfo);
	
	/**
	 * 额度领用信息查询
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrAppliInfo
	 * @return
	 */
	public Page findBIcrAppliInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("creditNo") String  creditNo);
	
	/**
	 * 根据ID查询额度申请信息
	 * @param key
	 * @return
	 */
	public BIcrAppliInfo queryCreditAppliInfoKey(@ScubeParam("key") String key);
	/**
	 * 根据额度申请信息删除删除额度申请
	 * @param bIcrAppliInfo
	 * @return
	 */
	public int deleteByBIcrAppliInfo(@ScubeParam("bIcrAppliInfo") BIcrAppliInfo bIcrAppliInfo);
	
	/**
	 * 根据额度编号查询额度申请信息
	 * @param bIcrAppliInfo
	 * @return
	 */
	public BIcrAppliInfo queryBIcrAppliInfoByCreditNo(@ScubeParam("bIcrAppliInfo") BIcrAppliInfo bIcrAppliInfo);
}
