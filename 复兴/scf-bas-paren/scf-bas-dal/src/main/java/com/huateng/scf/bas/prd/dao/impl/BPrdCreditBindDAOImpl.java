package com.huateng.scf.bas.prd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdCreditBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBindExample;

@Repository("BPrdCreditBindDAO")
public class BPrdCreditBindDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdCreditBindDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BPrdCreditBindDAOImpl() {
		super();
	}

	public int countByExample(BPrdCreditBindExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PRD_CREDIT_BIND.countByExample", example);
		return count;
	}

	public int deleteByExample(BPrdCreditBindExample example) {
		int rows = getSqlMapClientTemplate().delete("B_PRD_CREDIT_BIND.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BPrdCreditBind _key = new BPrdCreditBind();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_PRD_CREDIT_BIND.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BPrdCreditBind record) {
		getSqlMapClientTemplate().insert("B_PRD_CREDIT_BIND.insert", record);
	}

	public void insertSelective(BPrdCreditBind record) {
		getSqlMapClientTemplate().insert("B_PRD_CREDIT_BIND.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BPrdCreditBind> selectByExample(BPrdCreditBindExample example) {
		List<BPrdCreditBind> list = getSqlMapClientTemplate().queryForList("B_PRD_CREDIT_BIND.selectByExample",
				example);
		return list;
	}

	public BPrdCreditBind selectByPrimaryKey(String id) {
		BPrdCreditBind _key = new BPrdCreditBind();
		_key.setId(id);
		BPrdCreditBind record = (BPrdCreditBind) getSqlMapClientTemplate()
				.queryForObject("B_PRD_CREDIT_BIND.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BPrdCreditBind record, BPrdCreditBindExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PRD_CREDIT_BIND.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BPrdCreditBind record, BPrdCreditBindExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PRD_CREDIT_BIND.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BPrdCreditBind record) {
		int rows = getSqlMapClientTemplate().update("B_PRD_CREDIT_BIND.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BPrdCreditBind record) {
		int rows = getSqlMapClientTemplate().update("B_PRD_CREDIT_BIND.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BPrdCreditBind> selectByPage(BPrdCreditBindExample example, Page page) {
		List<BPrdCreditBind> list = this.searchListPageMyObject("B_PRD_CREDIT_BIND.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BPrdCreditBindExample {
		private Object record;

		public UpdateByExampleParms(Object record, BPrdCreditBindExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@SuppressWarnings("unchecked")
	public List<BPrdCreditBind> selectCreditBind(BPrdCreditBind record) {
		List<BPrdCreditBind> list = getSqlMapClientTemplate().queryForList("B_PRD_CREDIT_BIND.selectCreditBind", record);
		return list;
	}
	
	
}