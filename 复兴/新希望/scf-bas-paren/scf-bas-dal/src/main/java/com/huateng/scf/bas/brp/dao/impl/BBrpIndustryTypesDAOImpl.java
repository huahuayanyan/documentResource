package com.huateng.scf.bas.brp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.brp.dao.IBBrpIndustryTypesDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes;
import com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypesExample;

@Repository("BBrpIndustryTypesDAO")
public class BBrpIndustryTypesDAOImpl extends IbatisDaoAnnotation4Template implements IBBrpIndustryTypesDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BBrpIndustryTypesDAOImpl() {
		super();
	}

	public int countByExample(BBrpIndustryTypesExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_BRP_INDUSTRY_TYPES.countByExample",
				example);
		return count;
	}

	public int deleteByExample(BBrpIndustryTypesExample example) {
		int rows = getSqlMapClientTemplate().delete("B_BRP_INDUSTRY_TYPES.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String industryCode) {
		BBrpIndustryTypes _key = new BBrpIndustryTypes();
		_key.setIndustryCode(industryCode);
		int rows = getSqlMapClientTemplate().delete("B_BRP_INDUSTRY_TYPES.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BBrpIndustryTypes record) {
		getSqlMapClientTemplate().insert("B_BRP_INDUSTRY_TYPES.insert", record);
	}

	public void insertSelective(BBrpIndustryTypes record) {
		getSqlMapClientTemplate().insert("B_BRP_INDUSTRY_TYPES.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BBrpIndustryTypes> selectByExample(BBrpIndustryTypesExample example) {
		List<BBrpIndustryTypes> list = getSqlMapClientTemplate().queryForList("B_BRP_INDUSTRY_TYPES.selectByExample",
				example);
		return list;
	}

	public BBrpIndustryTypes selectByPrimaryKey(String industryCode) {
		BBrpIndustryTypes _key = new BBrpIndustryTypes();
		_key.setIndustryCode(industryCode);
		BBrpIndustryTypes record = (BBrpIndustryTypes) getSqlMapClientTemplate()
				.queryForObject("B_BRP_INDUSTRY_TYPES.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BBrpIndustryTypes record, BBrpIndustryTypesExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_BRP_INDUSTRY_TYPES.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BBrpIndustryTypes record, BBrpIndustryTypesExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_BRP_INDUSTRY_TYPES.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BBrpIndustryTypes record) {
		int rows = getSqlMapClientTemplate().update("B_BRP_INDUSTRY_TYPES.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BBrpIndustryTypes record) {
		int rows = getSqlMapClientTemplate().update("B_BRP_INDUSTRY_TYPES.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BBrpIndustryTypes> selectByPage(BBrpIndustryTypesExample example, Page page) {
		List<BBrpIndustryTypes> list = this.searchListPageMyObject("B_BRP_INDUSTRY_TYPES.selectByExample", example,
				page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BBrpIndustryTypesExample {
		private Object record;

		public UpdateByExampleParms(Object record, BBrpIndustryTypesExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}