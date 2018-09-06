package com.huateng.scf.bas.brp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.brp.dao.IBBrpCostParamDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpCostParam;
import com.huateng.scf.bas.brp.dao.model.BBrpCostParamExample;

@Repository("BBrpCostParamDAO")
public class BBrpCostParamDAOImpl extends IbatisDaoAnnotation4Template implements IBBrpCostParamDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BBrpCostParamDAOImpl() {
		super();
	}

	public int countByExample(BBrpCostParamExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_BRP_COST_PARAM.countByExample", example);
		return count;
	}

	public int deleteByExample(BBrpCostParamExample example) {
		int rows = getSqlMapClientTemplate().delete("B_BRP_COST_PARAM.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BBrpCostParam _key = new BBrpCostParam();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_BRP_COST_PARAM.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BBrpCostParam record) {
		getSqlMapClientTemplate().insert("B_BRP_COST_PARAM.insert", record);
	}

	public void insertSelective(BBrpCostParam record) {
		getSqlMapClientTemplate().insert("B_BRP_COST_PARAM.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BBrpCostParam> selectByExample(BBrpCostParamExample example) {
		List<BBrpCostParam> list = getSqlMapClientTemplate().queryForList("B_BRP_COST_PARAM.selectByExample", example);
		return list;
	}

	public BBrpCostParam selectByPrimaryKey(String id) {
		BBrpCostParam _key = new BBrpCostParam();
		_key.setId(id);
		BBrpCostParam record = (BBrpCostParam) getSqlMapClientTemplate()
				.queryForObject("B_BRP_COST_PARAM.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BBrpCostParam record, BBrpCostParamExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_BRP_COST_PARAM.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BBrpCostParam record, BBrpCostParamExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_BRP_COST_PARAM.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BBrpCostParam record) {
		int rows = getSqlMapClientTemplate().update("B_BRP_COST_PARAM.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BBrpCostParam record) {
		int rows = getSqlMapClientTemplate().update("B_BRP_COST_PARAM.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BBrpCostParam> selectByPage(BBrpCostParamExample example, Page page) {
		List<BBrpCostParam> list = this.searchListPageMyObject("B_BRP_COST_PARAM.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BBrpCostParamExample {
		private Object record;

		public UpdateByExampleParms(Object record, BBrpCostParamExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}