package com.huateng.scf.bas.icr.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.model.BIcrType;
import com.huateng.scf.bas.icr.model.CreditTypeQryVO;
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
public interface IBIcrTypeService {
	public void add(@ScubeParam("bIcrType") BIcrType bIcrType) throws ScubeBizException;
	/**
	 * @param bIcrType
	 * @return
	 */
	public int update(@ScubeParam("bIcrType") BIcrType bIcrType) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key)throws ScubeBizException;
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrType
	 * @return
	 */
	public Page findBIcrTypeByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bIcrType") BIcrType bIcrType)throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public BIcrType findBIcrTypeByKey(@ScubeParam("key") String key) throws ScubeBizException;
	
	
	//批量删除
	public int batchDelete(@ScubeParam("voList") List<Map<String, Object>>bIcrTypeList)throws ScubeBizException;
	/**
	 * 额度种类筛选
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrType
	 * @return
	 * @throws ScubeBizException
	 */
	public Page selectBIcrType(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") BIcrType bIcrType)throws ScubeBizException;
	/**
	 * 
	 * @param creditTypeQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BIcrType> getCreditTypeInfoByCreditTypeQryVO(@ScubeParam("creditTypeQryVO") CreditTypeQryVO creditTypeQryVO) throws ScubeBizException;
	/**
	 * 
	 * @param creditType
	 * @return
	 * @throws ScubeBizException
	 */
	public BIcrType getTblCreditTypeByCreditType(@ScubeParam("creditType") String creditType) throws ScubeBizException;
}
