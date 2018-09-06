package com.huateng.scf.rec.bcp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;

@Repository("IRBcpDebtBaseInfoDAO")
public class RBcpDebtBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpDebtBaseInfoDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public RBcpDebtBaseInfoDAOImpl() {
		super();
	}

	public int countByExample(RBcpDebtBaseInfoExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_BASE_INFO.countByExample", example);
		return count;
	}

	// 流贷--应收账款新增--数目
	@Override
	public int countys() {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_BASE_INFO.countys");
		return count;
	}

	public int deleteByExample(RBcpDebtBaseInfoExample example) {
		int rows = getSqlMapClientTemplate().delete("R_BCP_DEBT_BASE_INFO.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		RBcpDebtBaseInfo _key = new RBcpDebtBaseInfo();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("R_BCP_DEBT_BASE_INFO.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(RBcpDebtBaseInfo record) {
		getSqlMapClientTemplate().insert("R_BCP_DEBT_BASE_INFO.insert", record);
	}

	public void insertSelective(RBcpDebtBaseInfo record) {
		getSqlMapClientTemplate().insert("R_BCP_DEBT_BASE_INFO.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<RBcpDebtBaseInfo> selectByExample(RBcpDebtBaseInfoExample example) {
		List<RBcpDebtBaseInfo> list = getSqlMapClientTemplate().queryForList("R_BCP_DEBT_BASE_INFO.selectByExample", example);
		return list;
	}

	public RBcpDebtBaseInfo selectByPrimaryKey(String id) {
		RBcpDebtBaseInfo _key = new RBcpDebtBaseInfo();
		_key.setId(id);
		RBcpDebtBaseInfo record = (RBcpDebtBaseInfo) getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_BASE_INFO.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(RBcpDebtBaseInfo record, RBcpDebtBaseInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BASE_INFO.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(RBcpDebtBaseInfo record, RBcpDebtBaseInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BASE_INFO.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(RBcpDebtBaseInfo record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BASE_INFO.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(RBcpDebtBaseInfo record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BASE_INFO.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<RBcpDebtBaseInfo> selectByPage(RBcpDebtBaseInfoExample example, Page page) {
		List<RBcpDebtBaseInfo> list = this.searchListPageMyObject("R_BCP_DEBT_BASE_INFO.selectByExample", example, page);
		return list;
	}

	// 流贷--新增应收账款
	@SuppressWarnings("unchecked")
	public List<RBcpDebtBaseInfo> selectys(Map map, Page page) {
		List<RBcpDebtBaseInfo> list = this.searchListPageMyObject("R_BCP_DEBT_BASE_INFO.selectys", map, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends RBcpDebtBaseInfoExample {
		private Object record;

		public UpdateByExampleParms(Object record, RBcpDebtBaseInfoExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public void lockDebtBaseInfo(String debetNo, String appno) {
		RBcpDebtBaseInfo debtBaseInfo = new RBcpDebtBaseInfo();
		debtBaseInfo = this.selectByPrimaryKey(debetNo);
		if (debtBaseInfo != null) {
			debtBaseInfo.setIsLocked("1"); // SCFConstants.LOCKED="1"
			debtBaseInfo.setLockAppno(appno);
			this.updateByPrimaryKey(debtBaseInfo);
		}

	}

	@Override
	public void releaseDebtBaseInfo(String debtNo) {
		RBcpDebtBaseInfo debtBaseInfo = new RBcpDebtBaseInfo();
		debtBaseInfo = this.selectByPrimaryKey(debtNo);
		if (debtBaseInfo != null) {
			debtBaseInfo.setIsLocked("0");// SCFConstants.UNLOCKED
			debtBaseInfo.setLockAppno(null);
			this.updateByPrimaryKey(debtBaseInfo);
		}

	}

	/**
	 * 未核销的应收账款
	 */
	@Override
	public List<RBcpDebtBaseInfo> queryValidDebtBaseInfo(Map<String, Object> map) {
		List<RBcpDebtBaseInfo> list = getSqlMapClientTemplate().queryForList("EXT_R_BCP_DEBT_BASE_INFO.queryValidDebtBaseInfo", map);
		return list;
	}

	/**
	 * 催收待添加发票信息查询
	 */
	public List<RBcpDebtBaseInfo> getDebtInvoiceInfoPressing(Map<String, Object> map, Page page) {
		List<RBcpDebtBaseInfo> list = this.searchListPageMyObject("EXT_R_BCP_DEBT_BASE_INFO.getDebtInvoiceInfoPressing", map, page);
		return list;
	}

	/**
	 * 应收类转让添加发票信息查询
	 */
	public List<RBcpDebtBaseInfo> getDebtInvoiceInfoTransfer(Map<String, Object> map, Page page) {
		List<RBcpDebtBaseInfo> list = this.searchListPageMyObject("EXT_R_BCP_DEBT_BASE_INFO.getDebtInvoiceInfoTransfer", map, page);
		return list;
	}

	/**
	 * 出池待添加发票信息查询
	 */
	public List<RBcpDebtBaseInfo> getInvoiceOut(Map<String, Object> map, Page page) {
		List<RBcpDebtBaseInfo> list = this.searchListPageMyObject("EXT_R_BCP_DEBT_BASE_INFO.getInvoiceOut", map, page);
		return list;
	}

	@Override
	public void invoiceOutpoolAddSave(List insertDebtList, DebtBussInfoVO debtVO) {

		DebtBillsInfoVO billVO = null;
		// 修改发票出池状态
		for (int i = 0; i < insertDebtList.size(); i++) {
			billVO = (DebtBillsInfoVO) insertDebtList.get(i);
			RBcpDebtBaseInfo debtBaseInfo = this.selectByPrimaryKey(billVO.getId());
			// DebtConstants.POOL_FLAG_OUT_POOL
			debtBaseInfo.setPoolFlag("0");
			debtBaseInfo.setIsLocked("0");
			debtBaseInfo.setLockAppno(null);
			if (StringUtils.isNotBlank(billVO.getIssueReason())) {
				debtBaseInfo.setIssueReason(billVO.getIssueReason());
			}
			if (StringUtils.isNotBlank(billVO.getOtherReason())) {
				debtBaseInfo.setOtherReason(billVO.getOtherReason());
			}
			this.updateByPrimaryKey(debtBaseInfo);
		}

	}

	@Override
	public List selectByArgsSallerBuyerAndContno(Map<String, Object> parameters) {
		// String sqlId="R_BCP_DEBT_BASE_INFO.selectByBuyserSallerAndContno";
		List list = getSqlMapClientTemplate().queryForList("R_BCP_DEBT_BASE_INFO.selectDebtBaseInfoByParameters", parameters);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page getInvoiceDebtBackAddQry(HashMap<String, Object> omap) {
		Page p = new Page();
		List<RBcpDebtBaseInfo> list = getSqlMapClientTemplate().queryForList("EXT_R_BCP.getInvoiceDebtBackAddQry", omap);
		p.setRecords(list);
		return p;
	}

	// 池应收账款
	@SuppressWarnings("unchecked")
	public List<RBcpDebtBaseInfo> getDebtInfoQuery(Map map, Page page) {
		List<RBcpDebtBaseInfo> list = this.searchListPageMyObject("R_BCP_DEBT_BASE_INFO.getDebtInfoQuery", map, page);
		return list;
	}

	@Override
	public Page getInvoiceSelectedQuery(String id_Q, int pageIndex, int pageSize, List<String> orderFileds) {

		return null;
	}

	// ext_bcp_debt_base_info_SqlMap.xml
	@SuppressWarnings("unchecked")
	@Override
	public List<DebtBillsInfoVO> getDebtBackActImpInfoQuery(Map<String, Object> parameters, Page page) {
		List<DebtBillsInfoVO> list = this.searchListPageByMap("EXT_R_BCP_DEBT_BASE_INFO.getDebtBackActImpInfoQuery", parameters, page);
		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Page getInvoiceAdd(HashMap<String, Object> omap) {
		Page p = new Page();
		List<RBcpDebtBaseInfo> list = getSqlMapClientTemplate().queryForList("EXT_R_BCP.getInvoiceAdd", omap);
		p.setRecords(list);
		return p;
	}

	// ext_bcp_debt_base_info_SqlMap.xml
	@SuppressWarnings("unchecked")
	@Override
	public Integer getDebtBackActImpInfoQueryCount(Map<String, Object> parameters) {

		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("EXT_R_BCP_DEBT_BASE_INFO.getDebtBackActImpInfoQueryCount",
				parameters);

		return count;

	}

	// 对应的sqlmap文件 ext_bcp_debt_base_info_SqlMap.xml
	@Override
	public List selectDebtInfoByPerson(int pageNo, int pageSize, Map<String, Object> parameters) {
		Page page = new Page(pageSize, pageNo, 0);
		List listResult = this.searchListPageByMap("EXT_R_BCP_DEBT_BASE_INFO.selectDebtInfoByPerson", parameters, page);
		return listResult;
	}

	@Override
	public Integer selectDebtInfoByPersonCount(Map<String, Object> parameters) {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("EXT_R_BCP_DEBT_BASE_INFO.selectDebtInfoByPersonCount", parameters);
		return count;
	}

	@Override
	public List<RBcpDebtBaseInfo> selectDisputeInvoiceForAdding(Map<String, Object> params, Page page) {
		List<RBcpDebtBaseInfo> list = this.searchListPageMyObject("R_BCP_DEBT_BASE_INFO.selectDisputeInvoiceForAdding", params, page);
		return list;
	}

	@Override
	public Integer selectDisputeInvoiceForAddingCount(Map<String, Object> params) {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_BASE_INFO.selectDisputeInvoiceForAddingCount", params);
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO#
	 * getDebtInvoiceInfoRegister(java.util.Map,
	 * com.huateng.base.common.beans.Page)
	 */
	@Override
	public List<RBcpDebtBaseInfo> getDebtInvoiceInfoRegister(Map<String, Object> map, Page page) {
		List<RBcpDebtBaseInfo> list = this.searchListPageMyObject("EXT_R_BCP_DEBT_BASE_INFO.getDebtInvoiceInfoRegister", map, page);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO#getDebtInvoiceInfoRemove
	 * (java.util.Map, com.huateng.base.common.beans.Page)
	 */
	@Override
	public List<RBcpDebtBaseInfo> getDebtInvoiceInfoRemove(Map<String, Object> map, Page page) {
		List<RBcpDebtBaseInfo> list = this.searchListPageMyObject("EXT_R_BCP_DEBT_BASE_INFO.getDebtInvoiceInfoRemove", map, page);
		return list;
	}
	@Override
	public RBcpDebtBaseInfo selectByBillsNo(String billsNo) {
		RBcpDebtBaseInfo _key = new RBcpDebtBaseInfo();
		_key.setBillsNo(billsNo);
		RBcpDebtBaseInfo record = (RBcpDebtBaseInfo) getSqlMapClientTemplate()
				.queryForObject("R_BCP_DEBT_BASE_INFO.selectByBillsNo", _key);
		return record;
	}

}