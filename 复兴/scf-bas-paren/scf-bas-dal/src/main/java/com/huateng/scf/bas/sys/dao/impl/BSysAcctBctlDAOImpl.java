package com.huateng.scf.bas.sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.IBSysAcctBctlDAO;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctlExample;

@Repository("IBSysAcctBctlDAO")
public class BSysAcctBctlDAOImpl extends IbatisDaoAnnotation4Template implements IBSysAcctBctlDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BSysAcctBctlDAOImpl() {
		super();
	}

	public int countByExample(RSysAcctBctlExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_SYS_ACCT_BCTL.countByExample", example);
		return count;
	}

	public int deleteByExample(RSysAcctBctlExample example) {
		int rows = getSqlMapClientTemplate().delete("B_SYS_ACCT_BCTL.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String brcode) {
		RSysAcctBctl _key = new RSysAcctBctl();
		_key.setBrcode(brcode);
		int rows = getSqlMapClientTemplate().delete("B_SYS_ACCT_BCTL.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(RSysAcctBctl record) {
		getSqlMapClientTemplate().insert("B_SYS_ACCT_BCTL.insert", record);
	}

	public void insertSelective(RSysAcctBctl record) {
		getSqlMapClientTemplate().insert("B_SYS_ACCT_BCTL.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<RSysAcctBctl> selectByExample(RSysAcctBctlExample example) {
		List<RSysAcctBctl> list = getSqlMapClientTemplate().queryForList("B_SYS_ACCT_BCTL.selectByExample", example);
		return list;
	}

	public RSysAcctBctl selectByPrimaryKey(String brcode) {
		RSysAcctBctl _key = new RSysAcctBctl();
		_key.setBrcode(brcode);
		RSysAcctBctl record = (RSysAcctBctl) getSqlMapClientTemplate()
				.queryForObject("B_SYS_ACCT_BCTL.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(RSysAcctBctl record, RSysAcctBctlExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_SYS_ACCT_BCTL.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(RSysAcctBctl record, RSysAcctBctlExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_SYS_ACCT_BCTL.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(RSysAcctBctl record) {
		int rows = getSqlMapClientTemplate().update("B_SYS_ACCT_BCTL.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(RSysAcctBctl record) {
		int rows = getSqlMapClientTemplate().update("B_SYS_ACCT_BCTL.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<RSysAcctBctl> selectByPage(RSysAcctBctlExample example, Page page) {
		List<RSysAcctBctl> list = this.searchListPageMyObject("B_SYS_ACCT_BCTL.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends RSysAcctBctlExample {
		private Object record;

		public UpdateByExampleParms(Object record, RSysAcctBctlExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}