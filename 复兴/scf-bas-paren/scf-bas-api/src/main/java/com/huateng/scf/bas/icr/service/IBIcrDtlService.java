/**
 * 
 */
package com.huateng.scf.bas.icr.service;

import java.math.BigDecimal;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.CreditInterParamVO;
import com.huateng.scf.bas.icr.model.BIcrDtl;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.CreditInterParamBean;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>额度流水接口</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月9日.下午12:55:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月9日.下午12:55:11	     新增
 *
 * </pre>
 */

public interface IBIcrDtlService {
	/**
	 * 新增额度使用流水
	 * @param bIcrDtl
	 * 		BIcrDtl对象
	 * @return
	 */
	public void add(@ScubeParam("bIcrDtl") BIcrDtl bIcrDtl) throws ScubeBizException;;
	/**
	 * 修改额度使用流水
	 * @param bIcrDtl
	 * 		BIcrDtl对象
	 * @return
	 */
	public int update(@ScubeParam("bIcrDtl") BIcrDtl bIcrDtl) throws ScubeBizException;;
	/**
	 * 根据ID删除额度使用流水
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key)throws ScubeBizException;;
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrDtl
	 * @return Page对象
	 */
	public Page queryBIcrDtlByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bIcrDtl") BIcrDtl bIcrDtl)throws ScubeBizException;
	/**
	 * 根据ID查询额度使用流水信息
	 * @param key
	 * @return
	 */
	public BIcrDtl queryBIcrDtlgKey(@ScubeParam("key") String key)throws ScubeBizException;
	/**
	 * 记录额度流水
	 * @param creditInterParamBean
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param type
	 * @param amount
	 * @param orgTblCreditInfo
	 * @throws ScubeBizException
	 */
	public void addCreditDetail(@ScubeParam("creditInterParamBean") CreditInterParamVO creditInterParamBean,
			@ScubeParam("custcd") String custcd, @ScubeParam("otherCustcd") String otherCustcd,
			@ScubeParam("creditType") String creditType, @ScubeParam("type") String type,
			@ScubeParam("amount") BigDecimal amount, @ScubeParam("orgTblCreditInfo") BIcrInfo orgTblCreditInfo)
					throws ScubeBizException;
	/**
	 *  额度接口操作-记录融资额度流水
	 * @param creditInterParamBean
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param type
	 * @param amount
	 * @param orgTblCreditInfo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午3:56:01
	 */
	public void addCreditDetail(@ScubeParam("creditInterParamBean") CreditInterParamBean creditInterParamBean,
			@ScubeParam("custcd") String custcd,@ScubeParam("otherCustcd") String otherCustcd,
			@ScubeParam("creditType") String creditType,@ScubeParam("type") String type,
			@ScubeParam("amount") BigDecimal amount,@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	

	/**
	 * @Description: 额度接口操作-记录融资额度流水
	 * @author wenkui.xu
	 * @Created 2012-9-10下午03:50:47
	 * @param obj
	 * @param type 交易操作类型
	 * @param amount 交易金额
	 * @throws CommonException
	 */
	public void addCreditDetailChg(@ScubeParam("creditInterParamBean")CreditInterParamBean creditInterParamBean,
			@ScubeParam("custcd")String custcd, @ScubeParam("otherCustcd")String otherCustcd, @ScubeParam("creditType")String creditType, @ScubeParam("type")String type,
			@ScubeParam("amount")BigDecimal amount, @ScubeParam("orgTblCreditInfo")BIcrInfo orgTblCreditInfo);
	
	/**
	 * 新增额度流水信息（用于应收类放款申请）
	 * @param creditInterParamBean
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param type
	 * @param amount
	 * @param bIcrInfo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年8月3日下午4:27:30
	 */
	public void addCreditDetailForDuebill(@ScubeParam("creditInterParamVO") CreditInterParamVO creditInterParamVO,
			@ScubeParam("custcd") String custcd, @ScubeParam("otherCustcd") String otherCustcd,
			@ScubeParam("creditType") String creditType, @ScubeParam("type") String type,
			@ScubeParam("amount") BigDecimal amount, @ScubeParam("orgTblCreditInfo") BIcrInfo orgTblCreditInfo)
					throws ScubeBizException;
}
