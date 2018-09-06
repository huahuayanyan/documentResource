/**
 * 
 */
package com.huateng.scf.rec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>应收账款催收</p>
 *
 * @author 	shangxiujuan
 * @date 2017年1月12日下午4:33:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年1月12日下午4:33:21              新增
 *
 * </pre>
 */
public interface IRDebtPressService {
	public static final String BEAN_ID = "rDebtPressService";

	/**
	 * 催收待添加发票查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getDebtInvoiceInfoPressing(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;
	
	/**
	 * 根据申请编号获得应收账款列表
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpAppliBussInfo
	 * @return
	 * @throws ScubeBizException
	 */
		public Page getInvoiceAppList(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO)
				throws ScubeBizException;
	/**
	 * 应收账款催收申请保存
	 * @param debtBussInfoVO
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 */
	public String saveDebtPressWriteApply(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("debtBillsInfoVOList") List<DebtBillsInfoVO> list) throws ScubeBizException;
	/**
	 * 应收账款催收申请提交
	 * @param debtBussInfoVO
	 * @param list
	 * @throws ScubeBizException
	 */
	public void saveDebtPressWriteSubmit(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("debtBillsInfoVOList") List<DebtBillsInfoVO> list) throws ScubeBizException;


}
