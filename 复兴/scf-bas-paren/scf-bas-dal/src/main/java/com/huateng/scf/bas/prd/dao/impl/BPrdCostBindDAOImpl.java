package com.huateng.scf.bas.prd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdCostBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCostBind;
import com.huateng.scf.bas.prd.dao.model.BPrdCostBindExample;

@Repository("BPrdCostBindDAO")
public class BPrdCostBindDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdCostBindDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BPrdCostBindDAOImpl() {
		super();
	}

	public int countByExample(BPrdCostBindExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PRD_COST_BIND.countByExample", example);
		return count;
	}

	public int deleteByExample(BPrdCostBindExample example) {
		int rows = getSqlMapClientTemplate().delete("B_PRD_COST_BIND.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BPrdCostBind _key = new BPrdCostBind();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_PRD_COST_BIND.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BPrdCostBind record) {
		getSqlMapClientTemplate().insert("B_PRD_COST_BIND.insert", record);
	}

	public void insertSelective(BPrdCostBind record) {
		getSqlMapClientTemplate().insert("B_PRD_COST_BIND.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BPrdCostBind> selectByExample(BPrdCostBindExample example) {
		List<BPrdCostBind> list = getSqlMapClientTemplate().queryForList("B_PRD_COST_BIND.selectByExample", example);
		return list;
	}

	public BPrdCostBind selectByPrimaryKey(String id) {
		BPrdCostBind _key = new BPrdCostBind();
		_key.setId(id);
		BPrdCostBind record = (BPrdCostBind) getSqlMapClientTemplate()
				.queryForObject("B_PRD_COST_BIND.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BPrdCostBind record, BPrdCostBindExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PRD_COST_BIND.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BPrdCostBind record, BPrdCostBindExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PRD_COST_BIND.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BPrdCostBind record) {
		int rows = getSqlMapClientTemplate().update("B_PRD_COST_BIND.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BPrdCostBind record) {
		int rows = getSqlMapClientTemplate().update("B_PRD_COST_BIND.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BPrdCostBind> selectByPage(BPrdCostBindExample example, Page page) {
		List<BPrdCostBind> list = this.searchListPageMyObject("B_PRD_COST_BIND.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BPrdCostBindExample {
		private Object record;

		public UpdateByExampleParms(Object record, BPrdCostBindExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}