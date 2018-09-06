package com.huateng.scf.rec.bcp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.IRBcpCostOutDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpCostOut;
import com.huateng.scf.rec.bcp.dao.model.RBcpCostOutExample;

@Repository("IRBcpCostOutDAO")
public class RBcpCostOutDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpCostOutDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public RBcpCostOutDAOImpl() {
		super();
	}

	public int countByExample(RBcpCostOutExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("R_BCP_COST_OUT.countByExample", example);
		return count;
	}

	public int deleteByExample(RBcpCostOutExample example) {
		int rows = getSqlMapClientTemplate().delete("R_BCP_COST_OUT.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		RBcpCostOut _key = new RBcpCostOut();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("R_BCP_COST_OUT.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(RBcpCostOut record) {
		getSqlMapClientTemplate().insert("R_BCP_COST_OUT.insert", record);
	}

	public void insertSelective(RBcpCostOut record) {
		getSqlMapClientTemplate().insert("R_BCP_COST_OUT.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<RBcpCostOut> selectByExample(RBcpCostOutExample example) {
		List<RBcpCostOut> list = getSqlMapClientTemplate().queryForList("R_BCP_COST_OUT.selectByExample", example);
		return list;
	}

	public RBcpCostOut selectByPrimaryKey(String id) {
		RBcpCostOut _key = new RBcpCostOut();
		_key.setId(id);
		RBcpCostOut record = (RBcpCostOut) getSqlMapClientTemplate().queryForObject("R_BCP_COST_OUT.selectByPrimaryKey",
				_key);
		return record;
	}

	public int updateByExampleSelective(RBcpCostOut record, RBcpCostOutExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_COST_OUT.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(RBcpCostOut record, RBcpCostOutExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_COST_OUT.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(RBcpCostOut record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_COST_OUT.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(RBcpCostOut record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_COST_OUT.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<RBcpCostOut> selectByPage(RBcpCostOutExample example, Page page) {
		List<RBcpCostOut> list = this.searchListPageMyObject("R_BCP_COST_OUT.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends RBcpCostOutExample {
		private Object record;

		public UpdateByExampleParms(Object record, RBcpCostOutExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}