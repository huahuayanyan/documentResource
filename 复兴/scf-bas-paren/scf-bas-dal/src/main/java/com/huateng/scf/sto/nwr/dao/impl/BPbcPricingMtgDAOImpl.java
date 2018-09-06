package com.huateng.scf.sto.nwr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.sto.nwr.dao.IBPbcPricingMtgDAO;
import com.huateng.scf.sto.nwr.dao.model.BPbcPricingMtg;
import com.huateng.scf.sto.nwr.dao.model.BPbcPricingMtgExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPbcPricingMtgDAO")
public class BPbcPricingMtgDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcPricingMtgDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcPricingMtgDAOImpl() {
        super();
    }

    public int countByExample(BPbcPricingMtgExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_PRICING_MTG.countByExample", example);
        return count;
    }

    public int deleteByExample(BPbcPricingMtgExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_PRICING_MTG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPbcPricingMtg _key = new BPbcPricingMtg();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PBC_PRICING_MTG.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcPricingMtg record) {
        getSqlMapClientTemplate().insert("B_PBC_PRICING_MTG.insert", record);
    }

    public void insertSelective(BPbcPricingMtg record) {
        getSqlMapClientTemplate().insert("B_PBC_PRICING_MTG.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcPricingMtg> selectByExample(BPbcPricingMtgExample example) {
        List<BPbcPricingMtg> list = getSqlMapClientTemplate().queryForList("B_PBC_PRICING_MTG.selectByExample", example);
        return list;
    }

    public BPbcPricingMtg selectByPrimaryKey(String id) {
        BPbcPricingMtg _key = new BPbcPricingMtg();
        _key.setId(id);
        BPbcPricingMtg record = (BPbcPricingMtg) getSqlMapClientTemplate().queryForObject("B_PBC_PRICING_MTG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcPricingMtg record, BPbcPricingMtgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_PRICING_MTG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcPricingMtg record, BPbcPricingMtgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_PRICING_MTG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcPricingMtg record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_PRICING_MTG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcPricingMtg record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_PRICING_MTG.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcPricingMtg> selectByPage(BPbcPricingMtgExample example, Page page) {
        List<BPbcPricingMtg> list = this.searchListPageMyObject("B_PBC_PRICING_MTG.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcPricingMtgExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcPricingMtgExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}