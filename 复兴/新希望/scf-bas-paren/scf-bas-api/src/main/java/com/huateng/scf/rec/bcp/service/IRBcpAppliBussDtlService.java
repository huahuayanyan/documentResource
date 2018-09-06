/**
 * 
 */
package com.huateng.scf.rec.bcp.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月25日下午2:10:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月25日下午2:10:43	      新增
 *
 *            </pre>
 */
public interface IRBcpAppliBussDtlService {
	public static final String BEAN_ID = "rBcpAppliBussDtlService";

	public int deleteRBcpAppliBussDtl(@ScubeParam("rBcpAppliBussDtl") RBcpAppliBussDtl rBcpAppliBussDtl);

	public RBcpAppliBussDtl findRBcpAppliBussDtl(@ScubeParam("rBcpAppliBussDtl") RBcpAppliBussDtl rBcpAppliBussDtl);

	public List<RBcpAppliBussDtl> findRBcpAppliBussDtlByAppno(
			@ScubeParam("rBcpAppliBussDtl") RBcpAppliBussDtl rBcpAppliBussDtl);

	public Page findRBcpAppliBussDtlPageByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpAppliBussDtl rBcpAppliBussDtl);

	/**
	 * @param value
	 *            pageno pagesize
	 */
	public Page findBcpAppliBussdtlByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBussDtl rBcpDebtBussDtl) throws ScubeBizException;

	/**
	 * 配备了deadline字段的返回对象
	 * 
	 */
	public Page findBcpAppliBussdtlByPage2(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBussDtl rBcpDebtBussDtl) throws ScubeBizException;

	/**
	 * @param id
	 */
	public void delete(@ScubeParam("id") String id);

	// public List queryAppliBussDetailByAppno(@ScubeParam("appno") String
	// appno);

	public List<String> findBillsBySallerBuyerAndContno(@ScubeParam("parameters") Map<String, Object> parameters);

	public void saveDebtPressingBackToModifyBussDetails(@ScubeParam("insertList") List<DebtBillsInfoVO> insertList,
			@ScubeParam("appno") java.lang.String appno);

	public List<RBcpAppliBussDtl> queryAppliBussDetailByAppno(@ScubeParam("appno") java.lang.String appno,
			@ScubeParam("bussType") java.lang.String bussType);

	/**
	 * 应收账款回购/反转让，回购发票信息
	 * 
	 * @param insertList
	 *            List对象
	 * @param appno
	 *            String-业务流水号
	 * @param debtId
	 *            String-应收账款单据表主键
	 * @throws ScubeBizException
	 */
	public void saveDebtBackApplyBussDetail(@ScubeParam("insertList") List<RBcpDebtBaseInfo> insertList,
			@ScubeParam("appno") String appno, @ScubeParam("debtId") String debtId) throws ScubeBizException;

	/**
	 * 应收 保存前先清掉APPNO查询到记录
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 */
	public void appliBussDetailUpdate(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 
	 * @param insertList
	 * @param appno
	 * @throws ScubeBizException
	 */
	public void updateAppliBussDetall(@ScubeParam("insertList") List<RBcpDebtBaseInfo> insertList,
			@ScubeParam("appno") String appno) throws ScubeBizException;

	public List<AppliBussDetailVO> getTblAppliBussDetail(@ScubeParam("appno") String appno,
			@ScubeParam("bussType") String bussType) throws ScubeBizException;

	/**
	 * 添加承购发票 【业务申请业务明细表】 updateAppliBussDetall
	 * 
	 * @param list
	 * @param appno
	 */
	void updateAppliBussDetail(@ScubeParam("insertList") List<DebtBillsInfoVO> list, @ScubeParam("appno") String appno);
	
	/****
	 * 根据appno查询rBcpAppliBussDtl ID返回应收账款的主键即rBcpAppliBussDtl中的debtId
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpAppliBussDtl
	 * @return
	 */
	public Page findRBcpAppliBussDtlPageByAppno(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpAppliBussDtl rBcpAppliBussDtl);

	public void save(@ScubeParam("tblAppliBussDetail") RBcpAppliBussDtl tblAppliBussDetail) throws ScubeBizException;
	/**
	 * 
	 * @param appno
	 * @return
	 */
	public List<RBcpAppliBussDtl> findByProperty(@ScubeParam("appno") String appno);
	/**
	 * 
	 * @param bcpAppliBussDtl
	 * @throws ScubeBizException
	 */
	public void delete(@ScubeParam("bcpAppliBussDtl") RBcpAppliBussDtl bcpAppliBussDtl) throws ScubeBizException;

}
