package com.huateng.scf.rec.bcp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliCostOutDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOutExample;

@Repository("IRBcpAppliCostOutDAO")
public class RBcpAppliCostOutDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpAppliCostOutDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public RBcpAppliCostOutDAOImpl() {
		super();
	}

	public int countByExample(RBcpAppliCostOutExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("R_BCP_APPLI_COST_OUT.countByExample",
				example);
		return count;
	}

	public int deleteByExample(RBcpAppliCostOutExample example) {
		int rows = getSqlMapClientTemplate().delete("R_BCP_APPLI_COST_OUT.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		RBcpAppliCostOut _key = new RBcpAppliCostOut();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("R_BCP_APPLI_COST_OUT.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(RBcpAppliCostOut record) {
		getSqlMapClientTemplate().insert("R_BCP_APPLI_COST_OUT.insert", record);
	}

	public void insertSelective(RBcpAppliCostOut record) {
		getSqlMapClientTemplate().insert("R_BCP_APPLI_COST_OUT.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<RBcpAppliCostOut> selectByExample(RBcpAppliCostOutExample example) {
		List<RBcpAppliCostOut> list = getSqlMapClientTemplate().queryForList("R_BCP_APPLI_COST_OUT.selectByExample",
				example);
		return list;
	}

	public RBcpAppliCostOut selectByPrimaryKey(String id) {
		RBcpAppliCostOut _key = new RBcpAppliCostOut();
		_key.setId(id);
		RBcpAppliCostOut record = (RBcpAppliCostOut) getSqlMapClientTemplate()
				.queryForObject("R_BCP_APPLI_COST_OUT.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(RBcpAppliCostOut record, RBcpAppliCostOutExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_COST_OUT.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(RBcpAppliCostOut record, RBcpAppliCostOutExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_COST_OUT.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(RBcpAppliCostOut record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_COST_OUT.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(RBcpAppliCostOut record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_COST_OUT.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<RBcpAppliCostOut> selectByPage(RBcpAppliCostOutExample example, Page page) {
		List<RBcpAppliCostOut> list = this.searchListPageMyObject("R_BCP_APPLI_COST_OUT.selectByExample", example,
				page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends RBcpAppliCostOutExample {
		private Object record;

		public UpdateByExampleParms(Object record, RBcpAppliCostOutExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}