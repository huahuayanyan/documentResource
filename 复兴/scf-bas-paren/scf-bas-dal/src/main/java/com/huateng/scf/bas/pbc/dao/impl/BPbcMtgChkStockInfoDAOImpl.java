package com.huateng.scf.bas.pbc.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgChkStockInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgChkStockInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgChkStockInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBPbcMtgChkStockInfoDAO")
public class BPbcMtgChkStockInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcMtgChkStockInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcMtgChkStockInfoDAOImpl() {
        super();
    }

    public int countByExample(BPbcMtgChkStockInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_MTG_CHK_STOCK_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BPbcMtgChkStockInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_CHK_STOCK_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPbcMtgChkStockInfo _key = new BPbcMtgChkStockInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_CHK_STOCK_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcMtgChkStockInfo record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_CHK_STOCK_INFO.insert", record);
    }

    public void insertSelective(BPbcMtgChkStockInfo record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_CHK_STOCK_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgChkStockInfo> selectByExample(BPbcMtgChkStockInfoExample example) {
        List<BPbcMtgChkStockInfo> list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_CHK_STOCK_INFO.selectByExample", example);
        return list;
    }

    public BPbcMtgChkStockInfo selectByPrimaryKey(String id) {
        BPbcMtgChkStockInfo _key = new BPbcMtgChkStockInfo();
        _key.setId(id);
        BPbcMtgChkStockInfo record = (BPbcMtgChkStockInfo) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_CHK_STOCK_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcMtgChkStockInfo record, BPbcMtgChkStockInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CHK_STOCK_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcMtgChkStockInfo record, BPbcMtgChkStockInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CHK_STOCK_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcMtgChkStockInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CHK_STOCK_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcMtgChkStockInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CHK_STOCK_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgChkStockInfo> selectByPage(BPbcMtgChkStockInfoExample example, Page page) {
        List<BPbcMtgChkStockInfo> list = this.searchListPageMyObject("B_PBC_MTG_CHK_STOCK_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcMtgChkStockInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcMtgChkStockInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}