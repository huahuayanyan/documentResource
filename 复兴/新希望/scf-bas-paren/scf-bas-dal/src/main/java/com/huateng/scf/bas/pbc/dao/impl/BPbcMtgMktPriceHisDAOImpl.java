package com.huateng.scf.bas.pbc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgMktPriceHisDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceHis;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceHisExample;

@Repository("IBPbcMtgMktPriceHisDAO")
public class BPbcMtgMktPriceHisDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcMtgMktPriceHisDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BPbcMtgMktPriceHisDAOImpl() {
		super();
	}

	public int countByExample(BPbcMtgMktPriceHisExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_MKT_PRICE_HIS.countByExample", example);
		return count;
	}

	public int deleteByExample(BPbcMtgMktPriceHisExample example) {
		int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_MKT_PRICE_HIS.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BPbcMtgMktPriceHis _key = new BPbcMtgMktPriceHis();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_MKT_PRICE_HIS.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BPbcMtgMktPriceHis record) {
		getSqlMapClientTemplate().insert("B_PBC_MTG_MKT_PRICE_HIS.insert", record);
	}

	public void insertSelective(BPbcMtgMktPriceHis record) {
		getSqlMapClientTemplate().insert("B_PBC_MTG_MKT_PRICE_HIS.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BPbcMtgMktPriceHis> selectByExample(BPbcMtgMktPriceHisExample example) {
		List<BPbcMtgMktPriceHis> list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_MKT_PRICE_HIS.selectByExample", example);
		return list;
	}

	public BPbcMtgMktPriceHis selectByPrimaryKey(String id) {
		BPbcMtgMktPriceHis _key = new BPbcMtgMktPriceHis();
		_key.setId(id);
		BPbcMtgMktPriceHis record = (BPbcMtgMktPriceHis) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_MKT_PRICE_HIS.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BPbcMtgMktPriceHis record, BPbcMtgMktPriceHisExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_MKT_PRICE_HIS.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BPbcMtgMktPriceHis record, BPbcMtgMktPriceHisExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_MKT_PRICE_HIS.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BPbcMtgMktPriceHis record) {
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_MKT_PRICE_HIS.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BPbcMtgMktPriceHis record) {
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_MKT_PRICE_HIS.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BPbcMtgMktPriceHis> selectByPage(BPbcMtgMktPriceHisExample example, Page page) {
		List<BPbcMtgMktPriceHis> list = this.searchListPageMyObject("B_PBC_MTG_MKT_PRICE_HIS.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BPbcMtgMktPriceHisExample {
		private Object record;

		public UpdateByExampleParms(Object record, BPbcMtgMktPriceHisExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}