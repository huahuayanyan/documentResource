package com.huateng.scf.bas.prd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdWarnBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdWarnBind;
import com.huateng.scf.bas.prd.dao.model.BPrdWarnBindExample;

@Repository("BPrdWarnBindDAO")
public class BPrdWarnBindDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdWarnBindDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BPrdWarnBindDAOImpl() {
		super();
	}

	public int countByExample(BPrdWarnBindExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PRD_WARN_BIND.countByExample", example);
		return count;
	}

	public int deleteByExample(BPrdWarnBindExample example) {
		int rows = getSqlMapClientTemplate().delete("B_PRD_WARN_BIND.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BPrdWarnBind _key = new BPrdWarnBind();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_PRD_WARN_BIND.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BPrdWarnBind record) {
		getSqlMapClientTemplate().insert("B_PRD_WARN_BIND.insert", record);
	}

	public void insertSelective(BPrdWarnBind record) {
		getSqlMapClientTemplate().insert("B_PRD_WARN_BIND.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BPrdWarnBind> selectByExample(BPrdWarnBindExample example) {
		List<BPrdWarnBind> list = getSqlMapClientTemplate().queryForList("B_PRD_WARN_BIND.selectByExample", example);
		return list;
	}

	public BPrdWarnBind selectByPrimaryKey(String id) {
		BPrdWarnBind _key = new BPrdWarnBind();
		_key.setId(id);
		BPrdWarnBind record = (BPrdWarnBind) getSqlMapClientTemplate()
				.queryForObject("B_PRD_WARN_BIND.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BPrdWarnBind record, BPrdWarnBindExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PRD_WARN_BIND.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BPrdWarnBind record, BPrdWarnBindExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PRD_WARN_BIND.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BPrdWarnBind record) {
		int rows = getSqlMapClientTemplate().update("B_PRD_WARN_BIND.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BPrdWarnBind record) {
		int rows = getSqlMapClientTemplate().update("B_PRD_WARN_BIND.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BPrdWarnBind> selectByPage(BPrdWarnBindExample example, Page page) {
		List<BPrdWarnBind> list = this.searchListPageMyObject("B_PRD_WARN_BIND.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BPrdWarnBindExample {
		private Object record;

		public UpdateByExampleParms(Object record, BPrdWarnBindExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}