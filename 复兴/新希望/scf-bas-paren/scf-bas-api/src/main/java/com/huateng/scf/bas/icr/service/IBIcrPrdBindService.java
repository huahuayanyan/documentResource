package com.huateng.scf.bas.icr.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.model.BIcrPrdBind;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>额度种类接口</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年10月31日.下午2:00:49
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年10月31日.下午2:00:49	     新增
 *
 * </pre>
 */
public interface IBIcrPrdBindService {
	public void addBIcrPrdBind(@ScubeParam("bIcrPrdBind") BIcrPrdBind bIcrPrdBind);
	/**
	 * @param bIcrPrdBind
	 * @return
	 */
	public int updateBIcrPrdBind(@ScubeParam("bIcrPrdBind") BIcrPrdBind bIcrPrdBind);
	/**
	 * @param key
	 * @return
	 */
	public int deleteBIcrPrdBind(@ScubeParam("key") String key);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrPrdBind
	 * @return
	 */
	public Page findBIcrPrdBindByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bIcrPrdBind") BIcrPrdBind bIcrPrdBind);
	/**
	 * @param key
	 * @return
	 */
	public BIcrPrdBind findBIcrPrdBindByKey(@ScubeParam("key") String key);
	
	//ext
	/**
	 * 额度品种与产品的绑定列表
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrType
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findBIcrTypePrdBind(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bIcrPrdBind") BIcrPrdBind bIcrPrdBind)throws ScubeBizException;
	/**
	 * 额度品种与产品的绑定的保存
	 * @param bIcrPrdBindList
	 * @param creditType
	 * @throws ScubeBizException
	 */
	public void saveBIcrTypePrdBind(@ScubeParam("bIcrPrdBindList")  List<BIcrPrdBind> bIcrPrdBindList,@ScubeParam("creditType") String creditType)throws ScubeBizException;
	
}
