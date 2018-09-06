/**
 * 
 */
package com.huateng.scf.rec.bcp.service;

import java.util.ArrayList;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月7日上午9:58:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月7日上午9:58:43              新增
 *
 *            </pre>
 */
public interface IRBcpDebtBaseInfoService {
	public static final String BEAN_ID = "rBcpDebtBaseInfoService";

	public String addRBcpDebtBaseInfo(@ScubeParam("rBcpDebtBaseInfo") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	// 批量新增应收账款信息
	public ArrayList<RBcpDebtBaseInfo> batchAddRBcpDebtBaseInfo(@ScubeParam("value") ArrayList<RBcpDebtBaseInfo> ds);

	public int deleteRBcpDebtBaseInfo(@ScubeParam("id") String id);

	public int updateRBcpDebtBaseInfo(@ScubeParam("rBcpDebtBaseInfo") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	public RBcpDebtBaseInfo findRBcpDebtBaseInfoByKey(@ScubeParam("rBcpDebtBaseInfo") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	public int countRBcpDebtBaseInfoByKey(@ScubeParam("rBcpDebtBaseInfo") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	public Page findRBcpDebtBaseInfoPageByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	// 应收类转让单据添加单据
	public Page findRBcpDebtBaseInfoPageForTransfer(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBaseInfo rBcpDebtBaseInfo, @ScubeParam("bcpDatasource") List<RBcpDebtBaseInfo> insertDebtList)
					throws ScubeBizException;

	// 应收账款信息批量查询，去除重复数据（根据凭证编号）
	public ArrayList<RBcpDebtBaseInfo> findRBcpDebtBaseInfoByKey2(@ScubeParam("value") ArrayList<RBcpDebtBaseInfo> ds);

	// 应收账款管理并转让(1.保存，2.返回保存好的数据给页面)
	public ArrayList<RBcpDebtBaseInfo> saveAndTransferRBcpDebtBaseInfo(@ScubeParam("value") ArrayList<RBcpDebtBaseInfo> ds);

	// 池融资纠解除，选择纠纷凭证信息
	public Page findRBcpDebtBaseInfoForPDRemove(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBaseInfo rBcpDebtBaseInfo, @ScubeParam("bcpDatasource") List<RBcpDebtBaseInfo> insertDebtList);

	// 池融资纠解除，选择纠纷凭证信息
	public Page findRBcpDebtBaseInfoForPDRemove2(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	// 池融资纠登记，选择纠纷凭证信息
	public Page findRBcpDebtBaseInfoForPRegister(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBaseInfo rBcpDebtBaseInfo, @ScubeParam("bcpDatasource") List<RBcpDebtBaseInfo> insertDebtList)
					throws ScubeBizException;

	// 流贷--应收融资让款申请
	public Page selectRBcpDebtBaseInfo(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	// 流贷--应收融资让款申请
	public Page selectRBcpDebtBaseInfoForPay(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	public Page findInovListByCommonQueryVO(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("rBcpDebtBaseInfo") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	/**
	 * 发票入池
	 * 
	 * @param rBcpAppliBussDtlList
	 * @param debtVO
	 */
	public void invoiceInpoolAddSave(@ScubeParam("rBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> rBcpAppliBussDtlList,
			@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtVO) throws ScubeBizException;

	/**
	 * 锁定应收账款单据
	 * 
	 * @param debtId
	 *            String-应收账款单据编号
	 * @param appno
	 *            String-业务申请号
	 */
	public void lockDebtBaseInfo(@ScubeParam("debtId") String debtId, @ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 应收账款发票解锁
	 * 
	 * @param debtId
	 *            String-应收账款单据编号
	 * @throws ScubeBizException
	 */
	public void releaseDebtBaseInfo(@ScubeParam("debtId") String debtId) throws ScubeBizException;;

	/**
	 * 查询未核销的应收账款
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public List<RBcpDebtBaseInfo> queryValidDebtBaseInfo(@ScubeParam("commonQueryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

	/**
	 * 出池发票出池保存
	 * 
	 * @param insertDebtList
	 * @param debtVO
	 */
	void invoiceOutPoolAddSave(@ScubeParam("insertDebtList") List<DebtBillsInfoVO> insertDebtList, @ScubeParam("debtVO") DebtBussInfoVO debtVO);

	public Page findCancelRBcpDebtBaseInfoPageByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	@SuppressWarnings("rawtypes")
	public void invoiceOutpoolAddSave(@ScubeParam("insertDebtList") List insertDebtList, @ScubeParam("debtVO") DebtBussInfoVO debtVO);

	RBcpDebtBaseInfo get(@ScubeParam("id") String id);

	/** 池应收账款 */
	public Page getDebtInfoQuery(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("mastContno") String mastContno);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public RBcpDebtBaseInfo findRBcpDebtBaseInfoByPrimaryKey(@ScubeParam("id") String id);

	/**
	 * 
	 * @param insertDebtList
	 * @param tblDebtBussInfo
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	public List factoringDebtBackAddApply(@ScubeParam("insertDebtList") List<RBcpDebtBaseInfo> insertDebtList,
			@ScubeParam("tblDebtBussInfo") RBcpDebtBussInfo tblDebtBussInfo) throws ScubeBizException;

	/**
	 * 
	 * @param insertDebtList
	 * @param debtBaseVO
	 * @throws ScubeBizException
	 */
	public void saveDebtBussInfoWhenCanceled(@ScubeParam("insertDebtList") List<DebtBillsInfoVO> insertDebtList,
			@ScubeParam("debtBaseVO") DebtBussInfoVO debtBaseVO) throws ScubeBizException;

	public Page invoiceBuyerPayList(@ScubeParam("commonQryVO") DebtCommonQryVO commonQryVO);

	public Page getInvoiceSelectedQuery(@ScubeParam("commonQryVO") DebtCommonQryVO commonQryVO);

	public Page getDebtBackActImpInfoQuery(@ScubeParam("commonQryVO") DebtCommonQryVO commonQueryVO, @ScubeParam("page") Page page);

	/**
	 * 
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 */
	public void invoiceInpoolAddSave(@ScubeParam("insertDebtList") List<RBcpDebtBaseInfo> insertDebtList, @ScubeParam("debtVO") DebtBussInfoVO debtVO)
			throws ScubeBizException;

	/**
	 * 核销申请审批通过
	 * 
	 * @param insertDebtList
	 * @param tblDebtBussInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public void factoringChargeOffAddSave(@ScubeParam("insertDebtList") List<RBcpDebtBaseInfo> insertDebtList,
			@ScubeParam("tblDebtBussInfo") RBcpDebtBussInfo tblDebtBussInfo) throws ScubeBizException;

	public Page getDebtInfoByPerson(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO);

	// 减值页面的单据信息回显(根据申请号)
	public Page findRBcpDebtBaseInfoForImpair(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBaseInfo rBcpDebtBaseInfo);

	// 减值单据弹出页面
	public Page findRBcpDebtBaseForImpair(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBaseInfo rBcpDebtBaseInfo);
}
