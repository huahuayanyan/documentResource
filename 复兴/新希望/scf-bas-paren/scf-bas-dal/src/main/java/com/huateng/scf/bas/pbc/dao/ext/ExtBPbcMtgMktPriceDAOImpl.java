package com.huateng.scf.bas.pbc.dao.ext;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPrice;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceExample;

@Repository("ExtBPbcMtgMktPrice")
public class ExtBPbcMtgMktPriceDAOImpl extends IbatisDaoAnnotation4Template implements ExtIBPbcMtgMktPriceDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public ExtBPbcMtgMktPriceDAOImpl() {
		super();
	}

	public int countByExample(BPbcMtgMktPriceExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_MKT_PRICE.countByExample", example);
		return count;
	}

	public int deleteByExample(BPbcMtgMktPriceExample example) {
		int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_MKT_PRICE.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BPbcMtgMktPrice _key = new BPbcMtgMktPrice();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_MKT_PRICE.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BPbcMtgMktPrice record) {
		getSqlMapClientTemplate().insert("B_PBC_MTG_MKT_PRICE.insert", record);
	}

	public void insertSelective(BPbcMtgMktPrice record) {
		getSqlMapClientTemplate().insert("B_PBC_MTG_MKT_PRICE.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BPbcMtgMktPrice> selectByExample(BPbcMtgMktPriceExample example) {
		List<BPbcMtgMktPrice> list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_MKT_PRICE.selectByExample", example);
		return list;
	}

	public BPbcMtgMktPrice selectByPrimaryKey(String id) {
		BPbcMtgMktPrice _key = new BPbcMtgMktPrice();
		_key.setId(id);
		BPbcMtgMktPrice record = (BPbcMtgMktPrice) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_MKT_PRICE.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BPbcMtgMktPrice record, BPbcMtgMktPriceExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_MKT_PRICE.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BPbcMtgMktPrice record, BPbcMtgMktPriceExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_MKT_PRICE.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BPbcMtgMktPrice record) {
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_MKT_PRICE.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BPbcMtgMktPrice record) {
		int rows = getSqlMapClientTemplate().update("B_PBC_MTG_MKT_PRICE.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BPbcMtgMktPrice> selectByPage(BPbcMtgMktPriceExample example, Page page) {
		List<BPbcMtgMktPrice> list = this.searchListPageMyObject("B_PBC_MTG_MKT_PRICE.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BPbcMtgMktPriceExample {
		private Object record;

		public UpdateByExampleParms(Object record, BPbcMtgMktPriceExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	/*
	 * 市场价格导入页面查询
	 */
	@Override
	public List<BPbcMtgMktPrice> getBaiInfoMarketPri(Page page, Map map) {
		List<BPbcMtgMktPrice> list = this.searchListPageMyObject("EXT_B_PBC_MTG_MKT_PRICE.getBaiInfoMarketPri", map, page);
		return list;
	}

}