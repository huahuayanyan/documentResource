package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdMortDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdMort;
import com.huateng.scf.bas.prd.dao.model.BPrdMortExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBPrdMortDAO")
public class BPrdMortDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdMortDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdMortDAOImpl() {
        super();
    }

    public int countByExample(BPrdMortExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_MORT.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdMortExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_MORT.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String productId) {
        BPrdMort _key = new BPrdMort();
        _key.setProductId(productId);
        int rows = getSqlMapClientTemplate().delete("B_PRD_MORT.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdMort record) {
        getSqlMapClientTemplate().insert("B_PRD_MORT.insert", record);
    }

    public void insertSelective(BPrdMort record) {
        getSqlMapClientTemplate().insert("B_PRD_MORT.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdMort> selectByExample(BPrdMortExample example) {
        List<BPrdMort> list = getSqlMapClientTemplate().queryForList("B_PRD_MORT.selectByExample", example);
        return list;
    }

    public BPrdMort selectByPrimaryKey(String productId) {
        BPrdMort _key = new BPrdMort();
        _key.setProductId(productId);
        BPrdMort record = (BPrdMort) getSqlMapClientTemplate().queryForObject("B_PRD_MORT.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdMort record, BPrdMortExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_MORT.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdMort record, BPrdMortExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_MORT.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdMort record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_MORT.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdMort record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_MORT.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdMort> selectByPage(BPrdMortExample example, Page page) {
        List<BPrdMort> list = this.searchListPageMyObject("B_PRD_MORT.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdMortExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdMortExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}