/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 应收账款反转让接口
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月28日 下午4:09:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月28日下午4:09:17             新增
 *
 *            </pre>
 */
public interface INFactoringDebtBackService {
	public static final String BEAN_ID = "nfactoringDebtBackService";
	/**
	 * 应收账款反转让申请保存
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日下午3:08:05
	 */
	public String DebtBackApplySaveUpdate(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList) throws ScubeBizException;
	/**
	 * 应收账款反转让申请提交
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日下午3:07:57
	 */
	public void DebtBackWriteSubmitUpdate(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList) throws ScubeBizException;
	/**
	 * 应收账款回购申请流程回执
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日下午3:07:50
	 */
	public void DebtBackApplyReceiptUpdate(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList) throws ScubeBizException;
	/**
	 * 获取该合同下的所有的融资信息
	 * @param pageNo
	 * @param pageSize
	 * @param appliBussInfo
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午9:12:30
	 */
	public Page getLanLnciInfoByContno(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("appliBussInfo") RBcpAppliBussInfo appliBussInfo);
	/**
	 * 应收账款反转让使用 获得业务申请业务明细表
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpAppliBussInfo
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日下午3:07:41
	 */
	public Page getRBcpDebtBussDtl(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpAppliBussInfo) throws ScubeBizException;
	/**
	 * 点击申请反转让按钮，根据已有信息查询基本信息及反转让信息
	 * @param debtBussInfoVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日下午3:07:38
	 */
	public DebtBussInfoVO getDebtBussInfo(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO) throws ScubeBizException;
	/**
	 * 点击新增按钮查询列表
	 * @param pageNo
	 * @param pageSize
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日下午3:07:33
	 */
	public Page InvoiceDebtBackAddQryGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,
			@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO,@ScubeParam("list") List<RBcpAppliBussDtl> list) throws ScubeBizException;
	/**
	 * 获取任务信息
	 * @param appno
	 * @return
	 */
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno,@ScubeParam("factType") String factType);
	
	/**
	 * 列表提交按钮提交，需通过appNo获取业务申请基本信息及明细信息
	 * @param appNo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月15日上午9:55:36
	 */
	public void submit(@ScubeParam("appNo") String appNo) throws ScubeBizException;

}
