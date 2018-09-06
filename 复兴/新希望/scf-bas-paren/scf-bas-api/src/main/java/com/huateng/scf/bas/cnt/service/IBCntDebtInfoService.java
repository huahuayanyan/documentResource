/**
 * 
 */
package com.huateng.scf.bas.cnt.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntCostInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * XXX
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年11月28日.下午4:51:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月28日.下午4:51:24	     新增
 *
 *            </pre>
 */

public interface IBCntDebtInfoService {
	public static final String BEAN_ID = "bCntDebtInfoService";

	public BCntDebtInfo addBCntDebtInfo(@ScubeParam("bCntDebtInfo") BCntDebtInfo bCntDebtInfo) throws ScubeBizException;

	/**
	 * @param bCntDebtInfo
	 * @return
	 */
	public int updateBCntDebtInfo(@ScubeParam("bCntDebtInfo") BCntDebtInfo bCntDebtInfo) throws ScubeBizException;

	/**
	 * @param 合同号
	 * @return
	 */
	public int deleteBCntDebtInfo(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCntDebtInfo
	 * @return
	 */
	public Page findBCntDebtInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCntDebtInfo") BCntDebtInfo bCntDebtInfo) throws ScubeBizException;

	/**
	 * @param 根据合同号查询（翻译了业务品种）
	 * @return
	 */
	public BCntDebtInfo findBCntDebtInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 
	 * @param example
	 * @return
	 */
	public int deleteByBCntDebtInfo(@ScubeParam("bCntDebtInfo") BCntDebtInfo bCntDebtInfo) throws ScubeBizException;

	// ext
	/***
	 * 应收账款合同列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page queryBCntDebtInfoListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;

	/**
	 * 应收账款合同新增初始化
	 * 
	 * @return
	 * @throws ScubeBizException
	 */
	BCntDebtInfo initBCntDebtInfo() throws ScubeBizException;

	/**
	 * 应收账款合同新增保存
	 * 
	 * @param bCntDebtInfo
	 * @param costInfoList
	 * @param debtExtInfoList
	 * @throws ScubeBizException
	 */
	public void saveCntDebtInfoAdd(@ScubeParam("debtContVO") DebtContVO debtContVO, @ScubeParam("costInfoList") List<BCntCostInfo> costInfoList,
			@ScubeParam("debtExtInfoList") List<BCntDebtExtInfo> debtExtInfoList) throws ScubeBizException;

	/**
	 * 根据合同编号查询合同信息
	 * 
	 * @param debtContVO
	 * @return
	 * @throws ScubeBizException
	 */
	public DebtContVO queryBCntDebtInfoByContno(@ScubeParam("debtContVO") DebtContVO debtContVO) throws ScubeBizException;

	/**
	 * 根据合同编号查询交易对手基本信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param debtContVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page queryBCntDebtExtInfoByContno(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("debtContVO") DebtContVO debtContVO) throws ScubeBizException;

	/**
	 * 交易对手买方名称的选择列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCrmBaseInfo
	 * @return
	 */

	Page findBCrmBaseInfoListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") Map<String, String> value,@ScubeParam("list") List<BCntDebtExtInfo> list);

	/**
	 * 根据业务品种获得费用信息
	 * 
	 * @param value
	 * @return
	 */
	public Page findCostInfoByProduct(@ScubeParam("value") Map<String, String> value);

	/**
	 * 根据合同编号获得费用信息list
	 * 
	 * @param debtContVO
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BCntCostInfo> findCostInfoListByContno(@ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;

	/**
	 * 根据合同编号获得费用信息
	 * 
	 * @param mastContQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public BCntCostInfo findCostInfoByContno(@ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;

	/**
	 * 应收账款合同修改保存
	 * 
	 * @param bCntDebtInfo
	 * @param costInfoList
	 * @param debtExtInfoList
	 * @throws ScubeBizException
	 */
	void saveCntDebtInfoModify(@ScubeParam("debtContVO") DebtContVO debtContVO, @ScubeParam("costInfoList") List<BCntCostInfo> costInfoList,
			@ScubeParam("debtExtInfoList") List<BCntDebtExtInfo> debtExtInfoList) throws ScubeBizException;

	/**
	 * 应收账款合同删除，更改为无效
	 * 
	 * @param debtContVO
	 * @throws ScubeBizException
	 */
	public void saveCntDebtInfoDelete(@ScubeParam("debtContVOList") List<DebtContVO> debtContVOList) throws ScubeBizException;

	// 页面下拉菜单查询使用（根据客户号和业务合同号查询）
	public Page selectBCntDebtInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntDebtInfo bCntDebtInfo) throws ScubeBizException;

	// 信贷合同管理（关联合同号功能）
	public Page selectContNoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntDebtInfo bCntDebtInfo);

	public List findBCntDebtInfoByPage(@ScubeParam("map") Map<String, Object> map, @ScubeParam("p") Page p);

	public DebtContVO queryContInfoByMastContno(@ScubeParam("mastContno") String mastContno);

	/**
	 * 应收账款转让根据合同编号查询合同信息和业务品种信息
	 * 
	 * @param commonQueryVO
	 *            DebtCommonQryVO对象
	 * @return DebtBussInfoVO
	 * @throws ScubeBizException
	 */
	public DebtBussInfoVO queryContDebtInfoByMastContno(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO) throws ScubeBizException;

	/**
	 * 查询合同列表
	 * 
	 * @param bCntDebtInfo
	 * @return
	 */
	public List<BCntDebtInfo> findBcntDebtInfoList(@ScubeParam("bCntDebtInfo") BCntDebtInfo bCntDebtInfo);

	/**
	 * 查询合同列表(商业纠纷使用)
	 * 
	 * @param bCntDebtInfo
	 * @return
	 */
	public Page queryBCntDebtInfoListForDispute(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;
	/**
	 * 根据指定条件查询保理合同信息列表
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getTblContDebtInfoList(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO) throws ScubeBizException;
}
