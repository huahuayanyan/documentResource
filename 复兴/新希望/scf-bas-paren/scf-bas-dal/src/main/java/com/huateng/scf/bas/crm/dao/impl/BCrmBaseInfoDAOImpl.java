package com.huateng.scf.bas.crm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample;

@Repository("IBCrmBaseInfoDAO")
public class BCrmBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmBaseInfoDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BCrmBaseInfoDAOImpl() {
		super();
	}

	public int countByExample(BCrmBaseInfoExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_CRM_BASE_INFO.countByExample", example);
		return count;
	}

	public int deleteByExample(BCrmBaseInfoExample example) {
		int rows = getSqlMapClientTemplate().delete("B_CRM_BASE_INFO.deleteByExample", example);
		return rows;
	}

	public void insert(BCrmBaseInfo record) {
		getSqlMapClientTemplate().insert("B_CRM_BASE_INFO.insert", record);
	}

	public void insertSelective(BCrmBaseInfo record) {
		getSqlMapClientTemplate().insert("B_CRM_BASE_INFO.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BCrmBaseInfo> selectByExample(BCrmBaseInfoExample example) {
		List<BCrmBaseInfo> list = getSqlMapClientTemplate().queryForList("B_CRM_BASE_INFO.selectByExample", example);
		return list;
	}

	public int updateByExampleSelective(BCrmBaseInfo record, BCrmBaseInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CRM_BASE_INFO.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BCrmBaseInfo record, BCrmBaseInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CRM_BASE_INFO.updateByExample", parms);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BCrmBaseInfo> selectByPage(BCrmBaseInfoExample example, Page page) {
		List<BCrmBaseInfo> list = this.searchListPageMyObject("B_CRM_BASE_INFO.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BCrmBaseInfoExample {
		private Object record;

		public UpdateByExampleParms(Object record, BCrmBaseInfoExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	// 放款申请添加
	public BCrmBaseInfo selectById(String custcd) {
		BCrmBaseInfo record = (BCrmBaseInfo) getSqlMapClientTemplate()
				.queryForObject("B_CRM_BASE_INFO.selectById", custcd);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO#batchDelete(java.util.List)
	 */
	@Override
	public int batchDelete(List custcd2List) {
		return getSqlMapClientTemplate().delete("B_CRM_BASE_INFO.batchDelete", custcd2List);

	}

}