package com.huateng.scf.bas.sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.IBSysRegionDAO;
import com.huateng.scf.bas.sys.dao.model.BSysRegion;
import com.huateng.scf.bas.sys.dao.model.BSysRegionExample;

@Repository("BSysRegionDAO")
public class BSysRegionDAOImpl extends IbatisDaoAnnotation4Template implements IBSysRegionDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BSysRegionDAOImpl() {
		super();
	}

	public int countByExample(BSysRegionExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_SYS_REGION.countByExample", example);
		return count;
	}

	public int deleteByExample(BSysRegionExample example) {
		int rows = getSqlMapClientTemplate().delete("B_SYS_REGION.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BSysRegion _key = new BSysRegion();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_SYS_REGION.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BSysRegion record) {
		getSqlMapClientTemplate().insert("B_SYS_REGION.insert", record);
	}

	public void insertSelective(BSysRegion record) {
		getSqlMapClientTemplate().insert("B_SYS_REGION.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BSysRegion> selectByExample(BSysRegionExample example) {
		List<BSysRegion> list = getSqlMapClientTemplate().queryForList("B_SYS_REGION.selectByExample", example);
		return list;
	}

	public BSysRegion selectByPrimaryKey(String id) {
		BSysRegion _key = new BSysRegion();
		_key.setId(id);
		BSysRegion record = (BSysRegion) getSqlMapClientTemplate().queryForObject("B_SYS_REGION.selectByPrimaryKey",
				_key);
		return record;
	}

	public int updateByExampleSelective(BSysRegion record, BSysRegionExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_SYS_REGION.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BSysRegion record, BSysRegionExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_SYS_REGION.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BSysRegion record) {
		int rows = getSqlMapClientTemplate().update("B_SYS_REGION.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BSysRegion record) {
		int rows = getSqlMapClientTemplate().update("B_SYS_REGION.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BSysRegion> selectByPage(BSysRegionExample example, Page page) {
		List<BSysRegion> list = this.searchListPageMyObject("B_SYS_REGION.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BSysRegionExample {
		private Object record;

		public UpdateByExampleParms(Object record, BSysRegionExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}