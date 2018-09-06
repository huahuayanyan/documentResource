package com.huateng.scf.bas.prd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdCreditPlyDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditPly;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditPlyExample;

@Repository("BPrdCreditPlyDAO")
public class BPrdCreditPlyDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdCreditPlyDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BPrdCreditPlyDAOImpl() {
		super();
	}

	public int countByExample(BPrdCreditPlyExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PRD_CREDIT_PLY.countByExample", example);
		return count;
	}

	public int deleteByExample(BPrdCreditPlyExample example) {
		int rows = getSqlMapClientTemplate().delete("B_PRD_CREDIT_PLY.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BPrdCreditPly _key = new BPrdCreditPly();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_PRD_CREDIT_PLY.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BPrdCreditPly record) {
		getSqlMapClientTemplate().insert("B_PRD_CREDIT_PLY.insert", record);
	}

	public void insertSelective(BPrdCreditPly record) {
		getSqlMapClientTemplate().insert("B_PRD_CREDIT_PLY.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BPrdCreditPly> selectByExample(BPrdCreditPlyExample example) {
		List<BPrdCreditPly> list = getSqlMapClientTemplate().queryForList("B_PRD_CREDIT_PLY.selectByExample", example);
		return list;
	}

	public BPrdCreditPly selectByPrimaryKey(String id) {
		BPrdCreditPly _key = new BPrdCreditPly();
		_key.setId(id);
		BPrdCreditPly record = (BPrdCreditPly) getSqlMapClientTemplate()
				.queryForObject("B_PRD_CREDIT_PLY.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BPrdCreditPly record, BPrdCreditPlyExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PRD_CREDIT_PLY.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BPrdCreditPly record, BPrdCreditPlyExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PRD_CREDIT_PLY.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BPrdCreditPly record) {
		int rows = getSqlMapClientTemplate().update("B_PRD_CREDIT_PLY.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BPrdCreditPly record) {
		int rows = getSqlMapClientTemplate().update("B_PRD_CREDIT_PLY.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BPrdCreditPly> selectByPage(BPrdCreditPlyExample example, Page page) {
		List<BPrdCreditPly> list = this.searchListPageMyObject("B_PRD_CREDIT_PLY.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BPrdCreditPlyExample {
		private Object record;

		public UpdateByExampleParms(Object record, BPrdCreditPlyExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}