package com.huateng.scf.bas.lan.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.model.LoanApplyQryVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.sto.nwr.vo.BillCommonQryVO;
import com.huateng.scf.sto.nwr.vo.BillLnciBaseInfoVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>非标仓单放款审批</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月20日下午2:35:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月20日下午2:35:42	     新增
 *
 * </pre>
 */
public interface IBillNormalLoanApplyService {

	/**
	 * 获得放款申请列表
	 * @param pageNo
	 * @param pageSize
	 * @param loanApplyQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午3:26:03
	 */
	public Page getBillNormalLoanApplyList(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("loanApplyQryVO") LoanApplyQryVO loanApplyQryVO);

	public BillLnciBaseInfoVO BillNormalLoanApplyBaseInfoGetter(@ScubeParam("billCommonQryVO") BillCommonQryVO billCommonQryVO);

	/**
	 * 业务管理-押品清单查询
	 * @param pageNo
	 * @param pageSize
	 * @param billNormalVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月24日上午10:13:54
	 */
	public Page ApplyBillNormalListGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("billNormalVO") BillNormalVO billNormalVO);

	/**
	 * 任务基本信息
	 * @param appno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月24日上午10:36:55
	 */
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno);

	/**
	 * 查询核库列表信息
	 * @param pageNo
	 * @param pageSize
	 * @param billCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午2:37:05
	 */
	public Page BillMortgageChkStockInfoGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("billCommonQryVO") BillCommonQryVO billCommonQryVO);

	/**
	 * 放款申请的公用的保存方法(供应链补录)
	 * @param billLnciBaseInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午4:17:20
	 */
	public void BillNormalLoanApplySaveUpdate(@ScubeParam("billLnciBaseInfoVO") BillLnciBaseInfoVO billLnciBaseInfoVO);

	/**
	 * 动产融资放款申请填写岗信息录入提交
	 * @param billLnciBaseInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午4:16:52
	 */
	public void BillNormalLoanApplyWriteSubmitUpdater(@ScubeParam("billLnciBaseInfoVO") BillLnciBaseInfoVO billLnciBaseInfoVO);

	/**
	 * 普通仓单融资放款申请审批拒绝
	 * @param billLnciBaseInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午3:13:44
	 */
	public void BillNormalLoanApplyRefuseSubmitUpdater(@ScubeParam("billLnciBaseInfoVO") BillLnciBaseInfoVO billLnciBaseInfoVO);
}
