/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月17日下午3:43:39
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月17日下午3:43:39              新增
 *
 *            </pre>
 */
public interface INRBcpDebtBussInfoService {
	public static final String BEAN_ID = "rBcpDebtBussInfoService";

	// 新增应收账款单据基本信息，同时也新增应收账款单据明细信息
	public void addRBcpDebtBussInfo(@ScubeParam("rBcpDebtBussInfo") RBcpDebtBussInfo rBcpDebtBussInfo);

	// 删除应收账款单据基本信息，不会去级联删除应收账款单据明细信息
	public int deleteRBcpDebtBussInfo(@ScubeParam("id") String id);

	// 修改应收账款单据基本信息，也会新增应收账款基本信息明细
	public int updateRBcpDebtBussInfo(@ScubeParam("rBcpDebtBussInfo") RBcpDebtBussInfo rBcpDebtBussInfo);

	public RBcpDebtBussInfo findRBcpDebtBussInfoByKey(@ScubeParam("rBcpDebtBussInfo") RBcpDebtBussInfo rBcpDebtBussInfo);

	public Page findRBcpDebtBussInfoPageByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBussInfo rBcpDebtBussInfo);

	@SuppressWarnings("rawtypes")
	public void invoiceOutpoolAddSave(@ScubeParam("insertDebtList") List insertDebtList, @ScubeParam("debtVO") DebtBussInfoVO debtVO);

	public RBcpDebtBussInfo debtBussInfoAdd(@ScubeParam("debtVO") DebtBussInfoVO debtVO);

	public RBcpDebtBussInfo saveDebtOutPoolInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO, @ScubeParam("applyTypeOutPool") String applyTypeOutPool);

	/**
	 * 
	 * @param debtVO
	 * @param applyType
	 * @throws ScubeBizException
	 */
	public void updateInpoolInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO, @ScubeParam("applyType") String applyType) throws ScubeBizException;

	/**
	 * @param commonQueryVO
	 * @param page
	 * @return
	 */
	public Page queryDebtRepaymentInfo(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("pageNo") int pageNo);

}
