package com.huateng.scf.rec.bcp.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussInfoExample;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;

@Repository("IRBcpDebtBussInfoDAO")
public class RBcpDebtBussInfoDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpDebtBussInfoDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public RBcpDebtBussInfoDAOImpl() {
		super();
	}

	public int countByExample(RBcpDebtBussInfoExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_BUSS_INFO.countByExample",
				example);
		return count;
	}

	public int deleteByExample(RBcpDebtBussInfoExample example) {
		int rows = getSqlMapClientTemplate().delete("R_BCP_DEBT_BUSS_INFO.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		RBcpDebtBussInfo _key = new RBcpDebtBussInfo();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("R_BCP_DEBT_BUSS_INFO.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(RBcpDebtBussInfo record) {
		getSqlMapClientTemplate().insert("R_BCP_DEBT_BUSS_INFO.insert", record);
	}

	public void insertSelective(RBcpDebtBussInfo record) {
		getSqlMapClientTemplate().insert("R_BCP_DEBT_BUSS_INFO.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<RBcpDebtBussInfo> selectByExample(RBcpDebtBussInfoExample example) {
		List<RBcpDebtBussInfo> list = getSqlMapClientTemplate().queryForList("R_BCP_DEBT_BUSS_INFO.selectByExample",
				example);
		return list;
	}

	public RBcpDebtBussInfo selectByPrimaryKey(String id) {
		RBcpDebtBussInfo _key = new RBcpDebtBussInfo();
		_key.setId(id);
		RBcpDebtBussInfo record = (RBcpDebtBussInfo) getSqlMapClientTemplate()
				.queryForObject("R_BCP_DEBT_BUSS_INFO.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(RBcpDebtBussInfo record, RBcpDebtBussInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BUSS_INFO.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(RBcpDebtBussInfo record, RBcpDebtBussInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BUSS_INFO.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(RBcpDebtBussInfo record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BUSS_INFO.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(RBcpDebtBussInfo record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BUSS_INFO.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<RBcpDebtBussInfo> selectByPage(RBcpDebtBussInfoExample example, Page page) {
		List<RBcpDebtBussInfo> list = this.searchListPageMyObject("R_BCP_DEBT_BUSS_INFO.selectByExample", example,
				page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends RBcpDebtBussInfoExample {
		private Object record;

		public UpdateByExampleParms(Object record, RBcpDebtBussInfoExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public List<DebtBillsInfoVO> queryDebtRepaymentInfo(Map<String, Object> parameters, int pageSize, int pageNo) {
		Page page = new Page(pageSize, pageNo, 0);
		List<DebtBillsInfoVO> listResult = this.searchListPageMyObject("R_BCP_DEBT_BUSS_INFO.selectDebtRepaymentInfo", parameters, page );
		return listResult;
	}
	
	@Override
	public Integer queryDebtRepaymentInfoCount(Map<String, Object> parameters) {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_BUSS_INFO.selectDebtRepaymentCount", parameters);
		return count;
	}

}