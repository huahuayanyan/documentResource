package com.huateng.scf.sto.nwr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.sto.nwr.dao.IBPbcPricingBaseInfoDAO;
import com.huateng.scf.sto.nwr.dao.model.BPbcPricingBaseInfo;
import com.huateng.scf.sto.nwr.dao.model.BPbcPricingBaseInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPbcPricingBaseInfoDAO")
public class BPbcPricingBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcPricingBaseInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcPricingBaseInfoDAOImpl() {
        super();
    }

    public int countByExample(BPbcPricingBaseInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_PRICING_BASE_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BPbcPricingBaseInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_PRICING_BASE_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPbcPricingBaseInfo _key = new BPbcPricingBaseInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PBC_PRICING_BASE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcPricingBaseInfo record) {
        getSqlMapClientTemplate().insert("B_PBC_PRICING_BASE_INFO.insert", record);
    }

    public void insertSelective(BPbcPricingBaseInfo record) {
        getSqlMapClientTemplate().insert("B_PBC_PRICING_BASE_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcPricingBaseInfo> selectByExample(BPbcPricingBaseInfoExample example) {
        List<BPbcPricingBaseInfo> list = getSqlMapClientTemplate().queryForList("B_PBC_PRICING_BASE_INFO.selectByExample", example);
        return list;
    }

    public BPbcPricingBaseInfo selectByPrimaryKey(String id) {
        BPbcPricingBaseInfo _key = new BPbcPricingBaseInfo();
        _key.setId(id);
        BPbcPricingBaseInfo record = (BPbcPricingBaseInfo) getSqlMapClientTemplate().queryForObject("B_PBC_PRICING_BASE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcPricingBaseInfo record, BPbcPricingBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_PRICING_BASE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcPricingBaseInfo record, BPbcPricingBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_PRICING_BASE_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcPricingBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_PRICING_BASE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcPricingBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_PRICING_BASE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcPricingBaseInfo> selectByPage(BPbcPricingBaseInfoExample example, Page page) {
        List<BPbcPricingBaseInfo> list = this.searchListPageMyObject("B_PBC_PRICING_BASE_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcPricingBaseInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcPricingBaseInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}