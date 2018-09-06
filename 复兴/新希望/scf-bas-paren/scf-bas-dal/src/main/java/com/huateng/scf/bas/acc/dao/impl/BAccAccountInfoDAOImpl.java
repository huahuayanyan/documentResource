package com.huateng.scf.bas.acc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.acc.dao.IBAccAccountInfoDAO;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample;

@Repository("BAccAccountInfoDAO")
public class BAccAccountInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBAccAccountInfoDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BAccAccountInfoDAOImpl() {
		super();
	}

	public int countByExample(BAccAccountInfoExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_ACC_ACCOUNT_INFO.countByExample",
				example);
		return count;
	}

	public int deleteByExample(BAccAccountInfoExample example) {
		int rows = getSqlMapClientTemplate().delete("B_ACC_ACCOUNT_INFO.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BAccAccountInfo _key = new BAccAccountInfo();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_ACC_ACCOUNT_INFO.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BAccAccountInfo record) {
		getSqlMapClientTemplate().insert("B_ACC_ACCOUNT_INFO.insert", record);
	}

	public void insertSelective(BAccAccountInfo record) {
		getSqlMapClientTemplate().insert("B_ACC_ACCOUNT_INFO.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BAccAccountInfo> selectByExample(BAccAccountInfoExample example) {
		List<BAccAccountInfo> list = getSqlMapClientTemplate().queryForList("B_ACC_ACCOUNT_INFO.selectByExample",
				example);
		return list;
	}

	public BAccAccountInfo selectByPrimaryKey(String id) {
		BAccAccountInfo _key = new BAccAccountInfo();
		_key.setId(id);
		BAccAccountInfo record = (BAccAccountInfo) getSqlMapClientTemplate()
				.queryForObject("B_ACC_ACCOUNT_INFO.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BAccAccountInfo record, BAccAccountInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_ACC_ACCOUNT_INFO.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BAccAccountInfo record, BAccAccountInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_ACC_ACCOUNT_INFO.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BAccAccountInfo record) {
		int rows = getSqlMapClientTemplate().update("B_ACC_ACCOUNT_INFO.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BAccAccountInfo record) {
		int rows = getSqlMapClientTemplate().update("B_ACC_ACCOUNT_INFO.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BAccAccountInfo> selectByPage(BAccAccountInfoExample example, Page page) {
		List<BAccAccountInfo> list = this.searchListPageMyObject("B_ACC_ACCOUNT_INFO.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BAccAccountInfoExample {
		private Object record;

		public UpdateByExampleParms(Object record, BAccAccountInfoExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	/*
	 * 批量删除账户信息
	 */
	@Override
	public int batchDelete(List idList2) {

		return getSqlMapClientTemplate().delete("B_ACC_ACCOUNT_INFO.batchDelete", idList2);
	}
}