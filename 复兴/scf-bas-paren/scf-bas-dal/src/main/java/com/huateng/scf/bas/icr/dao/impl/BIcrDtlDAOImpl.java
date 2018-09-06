package com.huateng.scf.bas.icr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.icr.dao.IBIcrDtlDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrDtl;
import com.huateng.scf.bas.icr.dao.model.BIcrDtlExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BIcrDtlDAO")
public class BIcrDtlDAOImpl extends IbatisDaoAnnotation4Template implements IBIcrDtlDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BIcrDtlDAOImpl() {
        super();
    }

    public int countByExample(BIcrDtlExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_ICR_DTL.countByExample", example);
        return count;
    }

    public int deleteByExample(BIcrDtlExample example) {
        int rows = getSqlMapClientTemplate().delete("B_ICR_DTL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BIcrDtl _key = new BIcrDtl();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_ICR_DTL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BIcrDtl record) {
        getSqlMapClientTemplate().insert("B_ICR_DTL.insert", record);
    }

    public void insertSelective(BIcrDtl record) {
        getSqlMapClientTemplate().insert("B_ICR_DTL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BIcrDtl> selectByExample(BIcrDtlExample example) {
        List<BIcrDtl> list = getSqlMapClientTemplate().queryForList("B_ICR_DTL.selectByExample", example);
        return list;
    }

    public BIcrDtl selectByPrimaryKey(String id) {
        BIcrDtl _key = new BIcrDtl();
        _key.setId(id);
        BIcrDtl record = (BIcrDtl) getSqlMapClientTemplate().queryForObject("B_ICR_DTL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BIcrDtl record, BIcrDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_DTL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BIcrDtl record, BIcrDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_DTL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BIcrDtl record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_DTL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BIcrDtl record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_DTL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BIcrDtl> selectByPage(BIcrDtlExample example, Page page) {
        List<BIcrDtl> list = this.searchListPageMyObject("B_ICR_DTL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BIcrDtlExample {
        private Object record;

        public UpdateByExampleParms(Object record, BIcrDtlExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}