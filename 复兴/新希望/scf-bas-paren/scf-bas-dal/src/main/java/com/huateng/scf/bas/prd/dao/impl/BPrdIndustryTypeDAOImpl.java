package com.huateng.scf.bas.prd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdIndustryTypeDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdIndustryType;
import com.huateng.scf.bas.prd.dao.model.BPrdIndustryTypeExample;

@Repository("BPrdIndustryTypeDAO")
public class BPrdIndustryTypeDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdIndustryTypeDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BPrdIndustryTypeDAOImpl() {
		super();
	}

	public int countByExample(BPrdIndustryTypeExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PRD_INDUSTRY_TYPE.countByExample",
				example);
		return count;
	}

	public int deleteByExample(BPrdIndustryTypeExample example) {
		int rows = getSqlMapClientTemplate().delete("B_PRD_INDUSTRY_TYPE.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BPrdIndustryType _key = new BPrdIndustryType();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_PRD_INDUSTRY_TYPE.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BPrdIndustryType record) {
		getSqlMapClientTemplate().insert("B_PRD_INDUSTRY_TYPE.insert", record);
	}

	public void insertSelective(BPrdIndustryType record) {
		getSqlMapClientTemplate().insert("B_PRD_INDUSTRY_TYPE.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BPrdIndustryType> selectByExample(BPrdIndustryTypeExample example) {
		List<BPrdIndustryType> list = getSqlMapClientTemplate().queryForList("B_PRD_INDUSTRY_TYPE.selectByExample",
				example);
		return list;
	}

	public BPrdIndustryType selectByPrimaryKey(String id) {
		BPrdIndustryType _key = new BPrdIndustryType();
		_key.setId(id);
		BPrdIndustryType record = (BPrdIndustryType) getSqlMapClientTemplate()
				.queryForObject("B_PRD_INDUSTRY_TYPE.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BPrdIndustryType record, BPrdIndustryTypeExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PRD_INDUSTRY_TYPE.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BPrdIndustryType record, BPrdIndustryTypeExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PRD_INDUSTRY_TYPE.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BPrdIndustryType record) {
		int rows = getSqlMapClientTemplate().update("B_PRD_INDUSTRY_TYPE.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BPrdIndustryType record) {
		int rows = getSqlMapClientTemplate().update("B_PRD_INDUSTRY_TYPE.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BPrdIndustryType> selectByPage(BPrdIndustryTypeExample example, Page page) {
		List<BPrdIndustryType> list = this.searchListPageMyObject("B_PRD_INDUSTRY_TYPE.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BPrdIndustryTypeExample {
		private Object record;

		public UpdateByExampleParms(Object record, BPrdIndustryTypeExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public BPrdIndustryType selectByProductId(String productId) {
		BPrdIndustryType _key = new BPrdIndustryType();
		_key.setProductId(productId);
		BPrdIndustryType record = (BPrdIndustryType) getSqlMapClientTemplate()
				.queryForObject("B_PRD_INDUSTRY_TYPE.selectByProductId", _key);
		return record;
	}
}