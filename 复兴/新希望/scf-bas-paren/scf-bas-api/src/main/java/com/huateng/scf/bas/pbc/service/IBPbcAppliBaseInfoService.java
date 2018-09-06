/**
 * 
 */
package com.huateng.scf.bas.pbc.service;

import java.math.BigDecimal;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.fcs.model.FourApplyVO;
import com.huateng.scf.bas.cnt.model.BCntDebtInfoVO;
import com.huateng.scf.bas.lan.model.LoanApplyVO;
import com.huateng.scf.bas.mrn.vo.CashEqualValueContractVO;
import com.huateng.scf.bas.mrn.vo.OldApplyVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 业务申请基本信息接口
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月14日.下午5:19:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月14日.下午5:19:46	     新增
 *
 *            </pre>
 */

public interface IBPbcAppliBaseInfoService {
	public static final String BEAN_ID = "bPbcAppliBaseInfoService";

	public void addBPbcAppliBaseInfo(@ScubeParam("bPbcAppliBaseInfo") BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException;

	/**
	 * @param bPbcAppliBaseInfo
	 * @return
	 */
	public int updateBPbcAppliBaseInfo(@ScubeParam("bPbcAppliBaseInfo") BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBPbcAppliBaseInfo(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public List<String> batchDeleteBPbcAppliBaseInfoAndRelated(@ScubeParam("list") List<BPbcAppliBaseInfo> list) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 根据某些条件查询对象（页面合同按钮）
	 * 
	 * @param key
	 * @return
	 */
	public int findBPbcAppliBaseInfoByLimits(@ScubeParam("BPbcAppliBaseInfo") BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException;

	/**
	 * @param debtVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 */
	public String saveBillsVendorAppliBaseInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO, @ScubeParam("businessnoType") String businessnoType,
			@ScubeParam("workApplyType") String workApplyType) throws ScubeBizException;

	/**
	 * 新应收类商纠登记新增申请基本信息
	 * 
	 * @param debtVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 */
	public String saveDisputeRegisterAppliBaseInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO, @ScubeParam("businessnoType") String businessnoType,
			@ScubeParam("workApplyType") String workApplyType) throws ScubeBizException;

	public BCntDebtInfoVO queuyBCntDebtInfoVOByAppno(@ScubeParam("appno") java.lang.String appno,
			@ScubeParam("buyerCustcd") java.lang.String buyerCustcd) throws ScubeBizException;

	public Page queryBPbcAppliBaseInfoList(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPbcAppliBaseInfo value);

	/**
	 * 
	 * @param businessNo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getFlowRiskAmtByBusinessNo(@ScubeParam("businessNo") String businessNo);

	/**
	 * 
	 * @param contractVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	public String saveApplyBaseInfo(@ScubeParam("contractVO") CashEqualValueContractVO contractVO,
			@ScubeParam("businessnoType") String businessnoType, @ScubeParam("workApplyType") String workApplyType) throws ScubeBizException;

	/**
	 * 
	 * @param applyVO
	 * @throws ScubeBizException
	 */
	public void checkAppliBaseInfo(@ScubeParam("applyVO") OldApplyVO applyVO) throws ScubeBizException;

	/**
	 * 
	 * @param applyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	public String saveApplyBaseInfo(@ScubeParam("applyVO") OldApplyVO applyVO, @ScubeParam("businessnoType") String businessnoType,
			@ScubeParam("workApplyType") String workApplyType) throws ScubeBizException;

	/**
	 * 放款补录添加业务申请基本信息表
	 * 
	 * @param loanApplyVO
	 * @return
	 * @throws ScubeBizException
	 */
	public String saveLoanAppBasicInfo(@ScubeParam("loanApplyVO") LoanApplyVO loanApplyVO) throws ScubeBizException;

	/**
	 * 
	 * @param tblAppliBaseInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public String save(@ScubeParam("tblAppliBaseInfo") BPbcAppliBaseInfo tblAppliBaseInfo) throws ScubeBizException;

	/**
	 * 保存或更新业务申请基本信息
	 * 
	 * @param applyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	public String saveOrUpdateAppInfo(@ScubeParam("applyVO") FourApplyVO applyVO, @ScubeParam("businessnoType") String businessnoType,
			@ScubeParam("workApplyType") String workApplyType) throws ScubeBizException;

	/**
	 * 到货出质入库核价信息保存
	 * 
	 * @param appno
	 * @param appAmt
	 * @return
	 * @throws ScubeBizException
	 */
	public BPbcAppliBaseInfo updatePledgeAppAmt(@ScubeParam("appno") String appno, @ScubeParam("appAmt") BigDecimal appAmt) throws ScubeBizException;

	// 查询有没有涉及业务的抵/质押合同
	public int getListBySlaveContno(@ScubeParam("slaveContno") String slaveContno) throws ScubeBizException;

	// 保存批量调价信息
	public String saveOrUpdateMutilPriceAdjustApplyInfo(@ScubeParam("BPbcAppliMtgInfo") BPbcAppliMtgInfo bPbcAppliMtgInfo) throws ScubeBizException;

	// 提交批量调价信息
	public void submitMutilPriceAdjustApplyInfo(@ScubeParam("BPbcAppliMtgInfo") BPbcAppliMtgInfo bPbcAppliMtgInfo) throws ScubeBizException;

	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByIfspAppno(@ScubeParam("ifspAppno") String ifspAppno) throws ScubeBizException;

	/**
	 * 解押申请-维护普通仓单质押 B_PBC_APPLI_BASE_INFO[业务申请基本信息表]
	 * 
	 * @param basicApplyVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日上午11:05:37
	 */
	public String addBillNormalReceiptAppInfo(@ScubeParam("billNormalAppVO") BillNormalAppVO billNormalAppVO) throws ScubeBizException;

	/**
	 * getWareMnAddByPara 预解押仓单列表
	 * 
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日下午3:27:07
	 */
	public Page getWareMnAddByPara(@ScubeParam("billNormalAppVO") BillNormalAppVO billNormalAppVO) throws ScubeBizException;

	/**
	 * 普通仓单置换申请表的保存
	 * 
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月8日下午5:47:58
	 */
	public String saveBillManageExchangeAppBaseInfo(@ScubeParam("billNormalAppVO") BillNormalAppVO billNormalAppVO) throws ScubeBizException;

	/**
	 * 修改置换申请信息
	 * 
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月8日下午6:03:36
	 */
	public String saveBillManageExchangeAppBaseInfoForModify(@ScubeParam("billNormalAppVO") BillNormalAppVO billNormalAppVO) throws ScubeBizException;

	/**
	 * 根据质押合同号查询，处于审批流程中的质押合同
	 * 
	 * @param slaveContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月10日下午2:35:09
	 */
	@SuppressWarnings("rawtypes")
	public List queryAppliBaseInfoBySlaveContno(@ScubeParam("slaveContno") String slaveContno);

	/**
	 * 存货类现货静态/动态出质入库申请基本信息
	 * 
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年5月14日下午5:03:36
	 */
	public String saveQualityApplyInfo(@ScubeParam("MortgageApplyVO") MortgageApplyVO mortgageApplyVO,
			@ScubeParam("businessnoType") String businessnoType, @ScubeParam("workApplyType") String workApplyType) throws ScubeBizException;

	/**
	 * 根据appliType查询申请信息
	 * 
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年5月14日下午5:03:36
	 */
	public Page queryBPbcAppliBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException;

	/**
	 * 根据flag修改申请基本信息申请状态
	 * 
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年5月14日下午5:03:36
	 */
	public void editAppliBaseStatusByFlag(@ScubeParam("key") String appno, @ScubeParam("flag") String flag) throws ScubeBizException;
	
	/**
	 * 查询在流程中的放款信息(池融资放款)
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月20日下午4:36:07
	 */
	public List<BPbcAppliBaseInfoVO> findInFlowDuebillAppByParam();
}
