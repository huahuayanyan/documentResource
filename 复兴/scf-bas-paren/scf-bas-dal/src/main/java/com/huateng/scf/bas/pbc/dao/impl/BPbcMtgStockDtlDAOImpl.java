package com.huateng.scf.bas.pbc.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgStockDtlDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtlExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BPbcMtgStockDtlDAO")
public class BPbcMtgStockDtlDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcMtgStockDtlDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcMtgStockDtlDAOImpl() {
        super();
    }

    public int countByExample(BPbcMtgStockDtlExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_MTG_STOCK_DTL.countByExample", example);
        return count;
    }

    public int deleteByExample(BPbcMtgStockDtlExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_STOCK_DTL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPbcMtgStockDtl _key = new BPbcMtgStockDtl();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_STOCK_DTL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcMtgStockDtl record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_STOCK_DTL.insert", record);
    }

    public void insertSelective(BPbcMtgStockDtl record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_STOCK_DTL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgStockDtl> selectByExample(BPbcMtgStockDtlExample example) {
        List<BPbcMtgStockDtl> list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_STOCK_DTL.selectByExample", example);
        return list;
    }

    public BPbcMtgStockDtl selectByPrimaryKey(String id) {
        BPbcMtgStockDtl _key = new BPbcMtgStockDtl();
        _key.setId(id);
        BPbcMtgStockDtl record = (BPbcMtgStockDtl) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_STOCK_DTL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcMtgStockDtl record, BPbcMtgStockDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_STOCK_DTL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcMtgStockDtl record, BPbcMtgStockDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_STOCK_DTL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcMtgStockDtl record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_STOCK_DTL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcMtgStockDtl record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_STOCK_DTL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgStockDtl> selectByPage(BPbcMtgStockDtlExample example, Page page) {
        List<BPbcMtgStockDtl> list = this.searchListPageMyObject("B_PBC_MTG_STOCK_DTL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcMtgStockDtlExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcMtgStockDtlExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //EXT
	/**
	 * 根据appno查询押品信息变更明细
	 */
	@Override
	public List<BPbcMtgStockDtl> selectByAppno(String appno) {
		  List<BPbcMtgStockDtl> list = getSqlMapClientTemplate().queryForList("EXT_B_PBC_MTG_STOCK_DTL.selectByAppno", appno);
	      return list;
	}
}