package com.huateng.scf.bas.pbc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfoExample;

@Repository("BPbcMtgBaseInfoDAO")
public class BPbcMtgBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcMtgBaseInfoDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BPbcMtgBaseInfoDAOImpl() {
		super();
	}

	public int countByExample(BPbcMtgBaseInfoExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_BASE_INFO.countByExample", example);
		return count;
	}

	public int deleteByExample(BPbcMtgBaseInfoExample example) {
		int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_BASE_INFO.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String mortgageNo) {
		BPbcMtgBaseInfo _key = new BPbcMtgBaseInfo();
		_key.setMortgageNo(mortgageNo);
		int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_BASE_INFO.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BPbcMtgBaseInfo record) {
		getSqlMapClientTemplate().insert("B_PBC_MTG_BASE_INFO.insert", record);
	}

	public void insertSelective(BPbcMtgBaseInfo record) {
		getSqlMapClientTemplate().insert("B_PBC_MTG_BASE_INFO.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BPbcMtgBaseInfo> selectByExample(BPbcMtgBaseInfoExample example) {
		List<BPbcMtgBaseInfo> list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO.selectByExample", example);
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map> selectByCondition(String contno) {
		List<Map> list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO.selectByCondition", contno);
		return list;
	}

	public BPbcMtgBaseInfo selectByPrimaryKey(String mortgageNo) {
		BPbcMtgBaseInfo _key = new BPbcMtgBaseInfo();
		_key.setMortgageNo(mortgageNo);
		BPbcMtgBaseInfo record = (BPbcMtgBaseInfo) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_BASE_INFO.selectByPrimaryKey", mortgageNo);
		return record;
	}

	public int updateByExampleSelective(BPbcMtgBaseInfo record, BPbcMtgBaseInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_BASE_INFO.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BPbcMtgBaseInfo record, BPbcMtgBaseInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_BASE_INFO.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BPbcMtgBaseInfo record) {
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_BASE_INFO.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BPbcMtgBaseInfo record) {
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_BASE_INFO.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BPbcMtgBaseInfo> selectByPage(BPbcMtgBaseInfoExample example, Page page) {
		List<BPbcMtgBaseInfo> list = this.searchListPageMyObject("B_PBC_MTG_BASE_INFO.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BPbcMtgBaseInfoExample {
		private Object record;

		public UpdateByExampleParms(Object record, BPbcMtgBaseInfoExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}