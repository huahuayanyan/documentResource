package com.huateng.scf.nrec.bcp.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.model.RBcpDuebillAppVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>应收类放款业务	接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月23日上午10:18:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月23日上午10:18:14	     新增
 *
 * </pre>
 */
public interface IRBcpDuebillAppService {

	/**
	 * 放款申请列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDuebillAppVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午3:06:38
	 */
	public Page queryRBcpDuebillAppByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("rBcpDuebillAppVO") RBcpDuebillAppVO rBcpDuebillAppVO);

	/**
	 * 查询融资客户授信额度信息
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午5:30:22
	 */
	public Page queryCustBDcrLinInf(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, Object> value);
	
	/**
	 * 根据业务编号获取业务合同信息
	 * @param mastContno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午4:23:10
	 */
	public RBcpDuebillAppVO findBCntBcpInfoByMastContno(@ScubeParam("rBcpDuebillAppVO") RBcpDuebillAppVO rBcpDuebillAppVO,@ScubeParam("appno") String appno);

	/**
	 * 保存修改放款信息
	 * @param rBcpDuebillAppVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午7:31:30
	 */
	public String DebtFinancingApplySaveUpdate(@ScubeParam("rBcpDuebillAppVO") RBcpDuebillAppVO rBcpDuebillAppVO,@ScubeParam("debtList") List<RBcpAppliBussDtl> debtList);

	/**
	 * 应收账款列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午2:19:16
	 */
	public Page InvoiceFinancingDebtQueryGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO);

	/**
	 * 页面列表提交按钮
	 * @param rBcpDuebillAppVO
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午2:55:43
	 */
	public void submit(@ScubeParam("rBcpDuebillAppVO") RBcpDuebillAppVO rBcpDuebillAppVO);

	/**
	 * 详情页提交按钮
	 * @param rBcpDuebillAppVO
	 * @param debtList
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午3:02:01
	 */
	public void DebtFinancingApplySubmitUpdate(@ScubeParam("rBcpDuebillAppVO") RBcpDuebillAppVO rBcpDuebillAppVO,@ScubeParam("debtList") List<RBcpAppliBussDtl> debtList);

	/**
	 * 发票融资申请发票添加
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午4:24:43
	 */
	public Page InvoiceFinancingAddQryGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,
			@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO,@ScubeParam("list") List<RBcpAppliBussDtl> list);

	/**
	 * 根据主键删除信息
	 * @param appno
	 * @author 	mengjiajia
	 * @date 	2017年5月25日上午11:07:31
	 */
	public void delete(@ScubeParam("appno") String appno);

	/**
	 * 应收账款单据查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月25日下午8:29:22
	 */
	public Page DebtFindGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO);

	/**
	 * 通过利率定价模型获取利率信息
	 * @param productId
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月20日上午10:01:47
	 */
	public BigDecimal CheckActInt(@ScubeParam("productId") String productId);
}
