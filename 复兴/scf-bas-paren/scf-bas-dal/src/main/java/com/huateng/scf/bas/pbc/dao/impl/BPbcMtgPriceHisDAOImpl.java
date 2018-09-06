package com.huateng.scf.bas.pbc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgPriceHisDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgPriceHis;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgPriceHisExample;

@Repository("BPbcMtgPriceHisDAO")
public class BPbcMtgPriceHisDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcMtgPriceHisDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcMtgPriceHisDAOImpl() {
        super();
    }

    public int countByExample(BPbcMtgPriceHisExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_MTG_PRICE_HIS.countByExample", example);
        return count;
    }

    public int deleteByExample(BPbcMtgPriceHisExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_PRICE_HIS.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPbcMtgPriceHis _key = new BPbcMtgPriceHis();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_PRICE_HIS.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcMtgPriceHis record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_PRICE_HIS.insert", record);
    }

    public void insertSelective(BPbcMtgPriceHis record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_PRICE_HIS.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgPriceHis> selectByExample(BPbcMtgPriceHisExample example) {
        List<BPbcMtgPriceHis> list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_PRICE_HIS.selectByExample", example);
        return list;
    }

    public BPbcMtgPriceHis selectByPrimaryKey(String id) {
        BPbcMtgPriceHis _key = new BPbcMtgPriceHis();
        _key.setId(id);
        BPbcMtgPriceHis record = (BPbcMtgPriceHis) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_PRICE_HIS.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcMtgPriceHis record, BPbcMtgPriceHisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_PRICE_HIS.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcMtgPriceHis record, BPbcMtgPriceHisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_PRICE_HIS.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcMtgPriceHis record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_PRICE_HIS.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcMtgPriceHis record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_PRICE_HIS.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgPriceHis> selectByPage(BPbcMtgPriceHisExample example, Page page) {
        List<BPbcMtgPriceHis> list = this.searchListPageMyObject("B_PBC_MTG_PRICE_HIS.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcMtgPriceHisExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcMtgPriceHisExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}