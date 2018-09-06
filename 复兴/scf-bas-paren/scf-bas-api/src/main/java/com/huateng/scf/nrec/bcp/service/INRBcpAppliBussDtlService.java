/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
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
public interface INRBcpAppliBussDtlService {

	public Page findBcpAppliBussDtlByAppno(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("key") String appno)
			throws ScubeBizException;

	public void deleteBcpAppliBussDtlByAppno(@ScubeParam("key") String appno) throws ScubeBizException;

	/**
	 * 应收 保存前先清掉APPNO查询到记录
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日上午9:59:55
	 */
	public void appliBussDetailUpdate(@ScubeParam("appno") String appno) throws ScubeBizException;

	// 新增申请明细信息，锁定对应单据信息
	public void addRBcpAppliBussDtlAndLockedDebt(@ScubeParam("key") String appno, @ScubeParam("list") List<RBcpAppliBussDtl> ds)
			throws ScubeBizException;

	// 删除原有明细信息，解锁对应单据信息
	public void deleteRBcpAppliBussDtlAndReleaseDebt(@ScubeParam("key") String appno) throws ScubeBizException;

	// 转让新增对应申请明细信息，需要校验查重
	public void addRBcpAppliBussDtlForTransfer(@ScubeParam("key") String appno, @ScubeParam("list") List<RBcpAppliBussDtl> ds)
			throws ScubeBizException;

	/**
	 * 根据appno与业务品种获取明细信息
	 * 
	 * @param appno
	 * @param bussType
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月24日上午10:06:55
	 */
	public List<RBcpAppliBussDtl> queryAppliBussDetailByAppno(@ScubeParam("appno") String appno, @ScubeParam("bussType") String bussType);
	/**
	 * 转让申请页面通过申请号查询对应申请明细信息
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author 	lihao
	 * @date 	2017年7月24日下午2:22:25
	 */
	public List<RBcpAppliBussDtl> queryAppliBussDetailByAppnoForTransfer(@ScubeParam("appno") String appno)throws ScubeBizException;

	/**
	 * 保存明细信息
	 * 
	 * @param appliBussDtl
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日上午10:11:17
	 */
	public void save(@ScubeParam("appliBussDtl") RBcpAppliBussDtl appliBussDtl) throws ScubeBizException;

	/**
	 * 根据appno获取明细信息
	 * 
	 * @param appno
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月31日下午3:17:38
	 */
	public List<RBcpAppliBussDtl> queryRBcpAppliBussDtlByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 保存催收管理申请流程发票信息
	 * 
	 * @param billList
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月31日上午10:32:06
	 */
	public void saveDebtPressingBussDetails(@ScubeParam("billList") List<NDebtBillsInfoVO> billList, @ScubeParam("appno") String appno)
			throws ScubeBizException;

	/**
	 * 应收账款回购/反转让，回购发票信息
	 * 
	 * @param insertList
	 * @param appno
	 * @param debtId
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月1日上午11:02:45
	 */
	public void saveDebtBackApplyBussDetail(@ScubeParam("insertList") List<NDebtBillsInfoVO> insertList, @ScubeParam("appno") String appno,
			@ScubeParam("debtId") String debtId) throws ScubeBizException;

	/**
	 * 获得业务申请业务明细表
	 * 
	 * @param appno
	 * @param bussType
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月2日下午2:14:33
	 */
	public List<AppliBussDetailVO> getTblAppliBussDetail(@ScubeParam("appno") String appno, @ScubeParam("bussType") String bussType);

	/**
	 * 添加承购发票 【业务申请业务明细表】
	 * 
	 * @param insertList
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日下午2:12:26
	 */
	public void updateAppliBussDetall(@ScubeParam("insertList") List<NDebtBillsInfoVO> insertList, @ScubeParam("appno") String appno)
			throws ScubeBizException;

	/**
	 * 通过申请号和应收账款的ID获取唯一 申请明细信息
	 * @param appno
	 * @param bussType
	 * @return
	 * @author 	lihao
	 * @date 	2017年7月11日下午1:55:02
	 */
	public RBcpAppliBussDtl getAppliBussDtilByAppnoAndDebtId(@ScubeParam("appno") String appno, @ScubeParam("debtId") String debtId)throws ScubeBizException;

	/**
	 * 根据appno与业务品种分页查询明细信息
	 * @param pageNo
	 * @param pageSize
	 * @param appno
	 * @param bussType
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月20日上午9:28:56
	 */
	public Page queryAppliBussDetailByAppnoPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("appno") String appno,@ScubeParam("bussType") String bussType);

}
