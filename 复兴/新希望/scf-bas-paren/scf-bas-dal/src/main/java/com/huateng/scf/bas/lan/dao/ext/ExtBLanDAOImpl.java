package com.huateng.scf.bas.lan.dao.ext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBaseExample;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.LoanApplyListVO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;

@Repository("ExtBLanDAO")
public class ExtBLanDAOImpl extends IbatisDaoAnnotation4Template implements ExtBLanDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public ExtBLanDAOImpl() {
		super();
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BLanAppliLnciBaseExample {
		private Object record;

		public UpdateByExampleParms(Object record, BLanAppliLnciBaseExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List queryLnciAmt(BPbcAppliBaseInfo bean) {
		List lncibase = getSqlMapClientTemplate().queryForList("EXT_B_LAN.queryLnciAmt", bean);
		return lncibase;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List querySum(BLanLnciBase bean) {
		List list = getSqlMapClientTemplate().queryForList("EXT_B_LAN.querySum", bean);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List queryAmountByDebetNo(BLanLnciBase bean) {
		List lncibase = getSqlMapClientTemplate().queryForList("EXT_B_LAN.queryAmountByDebetNo", bean);
		return lncibase;
	}

	/**
	 * @Description: 统计流程中的保证金及现金等价物汇总信息
	 * @author xiaolong.xiong
	 * @Created 2013-9-29上午9:11:43
	 * @param slaveContno
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List queryFlowBailInfoByBussinessNo(BPbcAppliBaseInfo bean) {
		List lncibase = getSqlMapClientTemplate().queryForList("EXT_B_LAN.queryFlowBailInfoByBussinessNo", bean);
		return lncibase;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List queryCalSumCashAndBailByMastContno(HashMap<String, String> omap) {
		List lncibase = getSqlMapClientTemplate().queryForList("EXT_B_LAN.queryCalSumCashAndBailByMastContno", omap);
		return lncibase;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getLnciBaseInfo(HashMap<String, Object> omap) {
		List lncibase = getSqlMapClientTemplate().queryForList("EXT_B_LAN.getLnciBaseInfo", omap);
		return lncibase;
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List getAppliLnciBaseInfo(HashMap<String, Object> omap, Page page) {
		List list = this.searchListPageMyObject("EXT_B_LAN.getAppliLnciBaseInfo", omap, page);
		return list;
	}

	@Override
	public int countAppliLnciBaseInfo(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_B_LAN.countAppliLnciBaseInfo", omap);
		return count;
	}

	/**
	 * 放款列表 先票/款后货
	 */
	@SuppressWarnings("unchecked")
	public List<LoanApplyListVO> getLoanApplyList(Map<String, Object> map, Page page) {
		List<LoanApplyListVO> list = this.searchListPageMyObject("EXT_B_LAN.getLoanApplyList", map, page);
		return list;
	}

	/**
	 * 获取协议下的融资金额，融资余额，初始保证金金额，追加保证金金额，初始现金等价物金额，追加现金等价物金额
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBase> getDebetAmtOfSum(HashMap<String, Object> map) {
		List<BLanLnciBase> list = getSqlMapClientTemplate().queryForList("EXT_B_LAN.getDebetAmtOfSum", map);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getLnciSumByParam(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("EXT_B_LAN.getLnciSumByParam", omap);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApplyListVO> getBillNomalLoanApplyList(HashMap<String, Object> omap, Page page) {
		List<LoanApplyListVO> list = this.searchListPageMyObject("EXT_B_LAN.getBillNomalLoanApplyList", omap, page);
		return list;
	}

	@Override
	public int countBillNomalLoanApplyList(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_B_LAN.countBillNomalLoanApplyList", omap);
		return count;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getBillNormalLoanAmt(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("EXT_B_LAN.getBillNormalLoanAmt", omap);
		return list;
	}

	@Override
	public int countBillNormalAppChkStockInfo(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_B_LAN.countBillNormalAppChkStockInfo", omap);
		return count;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getBillNormalAppChkStockInfo(HashMap<String, Object> omap, Page page) {
		List list = this.searchListPageMyObject("EXT_B_LAN.getBillNormalAppChkStockInfo", omap, page);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBase> getTblLnciBaseInfoByBussAppNo(HashMap<String, Object> omap) {
		List<BLanLnciBase> list = getSqlMapClientTemplate().queryForList("EXT_B_LAN.getTblLnciBaseInfoByBussAppNo", omap);
		return list;
	}

	@Override
	public int countDebetList(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_B_LAN.countDebetList", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBase> getDebetList(HashMap<String, Object> omap, Page page) {
		List<BLanLnciBase> list = this.searchListPageMyObject("EXT_B_LAN.getDebetList", omap, page);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBase> findBLanListForPay(HashMap<String, Object> omap, Page page) {
		List<BLanLnciBase> list = this.searchListPageMyObject("EXT_B_LAN.findBLanListForPay", omap, page);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List queryLnciAmtBySlaveContno(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("EXT_B_LAN.queryLnciAmtBySlaveContno", omap);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, BigDecimal>> getFlowRiskAmtByMastContno(HashMap<String, Object> omap) {
		List<HashMap<String, BigDecimal>> list = getSqlMapClientTemplate().queryForList("EXT_B_LAN.getFlowRiskAmtByMastContno", omap);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, BigDecimal>> getFlowKindsOfSumByMastContno(HashMap<String, Object> omap) {
		List<HashMap<String, BigDecimal>> list = getSqlMapClientTemplate().queryForList("EXT_B_LAN.getFlowKindsOfSumByMastContno", omap);
		return list;
	}

	// 现金回款查询未结清的借据信息
	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBase> queryUnsettleLoanBaseInfoList(HashMap<String, Object> omap, Page page) {
		List<BLanLnciBase> list = this.searchListPageMyObject("EXT_B_LAN_LNCI_BASE.queryLnciInfoByBusinessNo", omap, page);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBase> getNoPoolBLanLnciBaseByDebtIdList(HashMap<String, Object> omap, Page page, boolean flag) {
		List<BLanLnciBase> list = new ArrayList<BLanLnciBase>();
		if(flag)
		{
			list = this.searchListPageMyObject("EXT_B_LAN_LNCI_BASE.getNoPoolBLanLnciBaseByDebtIdList", omap, page);
		}
		else
		{
			list = getSqlMapClientTemplate().queryForList("EXT_B_LAN_LNCI_BASE.getNoPoolBLanLnciBaseByDebtIdList", omap);
		}
		return list;
	}

	@Override
	public int countNoPoolBLanLnciBaseByDebtIdList(HashMap<String, Object> omap)
	{
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_B_LAN_LNCI_BASE.countNoPoolBLanLnciBaseByDebtIdList", omap);
		return count;
	}
}