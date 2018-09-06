package com.huateng.scf.adv.fcs.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.fcs.dao.IBPbcMtgChkStockDtlDAO;
import com.huateng.scf.adv.fcs.model.BPbcMtgChkStockDtl;
import com.huateng.scf.adv.fcs.model.BPbcMtgChkStockDtlExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BPbcMtgChkStockDtlDAO")
public class BPbcMtgChkStockDtlDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcMtgChkStockDtlDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcMtgChkStockDtlDAOImpl() {
        super();
    }

    public int countByExample(BPbcMtgChkStockDtlExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_MTG_CHK_STOCK_DTL.countByExample", example);
        return count;
    }

    public int deleteByExample(BPbcMtgChkStockDtlExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_CHK_STOCK_DTL.deleteByExample", example);
        return rows;
    }

	@Override
	public int deleteByTblId(String tblId) {
		return getSqlMapClientTemplate().delete("B_PBC_MTG_CHK_STOCK_DTL.deleteByTblId", tblId);
	}
	
    public int deleteByPrimaryKey(String id) {
        BPbcMtgChkStockDtl _key = new BPbcMtgChkStockDtl();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_CHK_STOCK_DTL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcMtgChkStockDtl record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_CHK_STOCK_DTL.insert", record);
    }

    public void insertSelective(BPbcMtgChkStockDtl record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_CHK_STOCK_DTL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgChkStockDtl> selectByExample(BPbcMtgChkStockDtlExample example) {
        List<BPbcMtgChkStockDtl> list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_CHK_STOCK_DTL.selectByExample", example);
        return list;
    }

    public BPbcMtgChkStockDtl selectByPrimaryKey(String id) {
        BPbcMtgChkStockDtl _key = new BPbcMtgChkStockDtl();
        _key.setId(id);
        BPbcMtgChkStockDtl record = (BPbcMtgChkStockDtl) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_CHK_STOCK_DTL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcMtgChkStockDtl record, BPbcMtgChkStockDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CHK_STOCK_DTL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcMtgChkStockDtl record, BPbcMtgChkStockDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CHK_STOCK_DTL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcMtgChkStockDtl record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CHK_STOCK_DTL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcMtgChkStockDtl record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CHK_STOCK_DTL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgChkStockDtl> selectByPage(BPbcMtgChkStockDtlExample example, Page page) {
        List<BPbcMtgChkStockDtl> list = this.searchListPageMyObject("B_PBC_MTG_CHK_STOCK_DTL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcMtgChkStockDtlExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcMtgChkStockDtlExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

}