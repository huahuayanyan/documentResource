package com.huateng.scf.bas.lan.dao.ext;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.LoanApplyListVO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;

public interface ExtBLanDAO {

	@SuppressWarnings("rawtypes")
	List queryLnciAmt(BPbcAppliBaseInfo bean);

	@SuppressWarnings("rawtypes")
	List querySum(BLanLnciBase bean);

	@SuppressWarnings("rawtypes")
	List queryAmountByDebetNo(BLanLnciBase bean);

	@SuppressWarnings("rawtypes")
	List queryFlowBailInfoByBussinessNo(BPbcAppliBaseInfo bean);

	@SuppressWarnings("rawtypes")
	List queryCalSumCashAndBailByMastContno(HashMap<String, String> omap);

	@SuppressWarnings("rawtypes")
	List getLnciBaseInfo(HashMap<String, Object> omap);

	@SuppressWarnings("rawtypes")
	List getAppliLnciBaseInfo(HashMap<String, Object> omap, Page page);

	int countAppliLnciBaseInfo(HashMap<String, Object> omap);

	/**
	 * 放款查询列表 先票/款后货
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	public List<LoanApplyListVO> getLoanApplyList(Map<String, Object> map, Page page);

	/**
	 * 获取协议下的融资金额，融资余额，初始保证金金额，追加保证金金额，初始现金等价物金额，追加现金等价物金额
	 * 
	 * @param map
	 * @return
	 */
	List<BLanLnciBase> getDebetAmtOfSum(HashMap<String, Object> map);

	@SuppressWarnings("rawtypes")
	List getLnciSumByParam(HashMap<String, Object> omap);

	/**
	 * 放款审批列表 非标仓单
	 * 
	 * @param omap
	 * @param page
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月20日下午5:12:02
	 */
	List<LoanApplyListVO> getBillNomalLoanApplyList(HashMap<String, Object> omap, Page page);

	/**
	 * 放款审批列表个数 非标仓单
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月20日下午5:12:22
	 */
	int countBillNomalLoanApplyList(HashMap<String, Object> omap);

	/**
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月21日下午4:25:35
	 */
	@SuppressWarnings("rawtypes")
	List getBillNormalLoanAmt(HashMap<String, Object> omap);

	int countBillNormalAppChkStockInfo(HashMap<String, Object> omap);

	@SuppressWarnings("rawtypes")
	List getBillNormalAppChkStockInfo(HashMap<String, Object> omap, Page page);

	List<BLanLnciBase> getTblLnciBaseInfoByBussAppNo(HashMap<String, Object> omap);

	int countDebetList(HashMap<String, Object> omap);

	List<BLanLnciBase> getDebetList(HashMap<String, Object> omap, Page page);

	List<BLanLnciBase> findBLanListForPay(HashMap<String, Object> omap, Page page);

	/**
	 * 非池合同下查询的单据的对应的未删除的，未结清的借据信息(个数)
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月21日上午9:53:11
	 */
	int countNoPoolBLanLnciBaseByDebtIdList(HashMap<String, Object> omap);
	
	/**
	 * 非池合同下查询的单据的对应的未删除的，未结清的借据信息
	 * @param omap
	 * @param page
	 * @param flag
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月21日上午9:53:05
	 */
	List<BLanLnciBase> getNoPoolBLanLnciBaseByDebtIdList(HashMap<String, Object> omap, Page page, boolean flag);

	/**
	 * 质押合同下出账总金额
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月10日下午2:44:45
	 */
	@SuppressWarnings("rawtypes")
	List queryLnciAmtBySlaveContno(HashMap<String, Object> omap);

	/**
	 * 根据合同号查询流程中的借据敞口余额汇总
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月6日下午1:25:18
	 */
	List<HashMap<String, BigDecimal>> getFlowRiskAmtByMastContno(HashMap<String, Object> omap);

	/**
	 * 统计流程中的借据金额
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月6日下午1:41:37
	 */
	List<HashMap<String, BigDecimal>> getFlowKindsOfSumByMastContno(HashMap<String, Object> omap);

	/**
	 * 现金回款未结清借据信息查询
	 * 
	 * @param omap
	 * @param page
	 * @return
	 * @author lihao
	 * @date 2017年6月13日下午5:12:02
	 */
	List<BLanLnciBase> queryUnsettleLoanBaseInfoList(HashMap<String, Object> omap, Page page);

}