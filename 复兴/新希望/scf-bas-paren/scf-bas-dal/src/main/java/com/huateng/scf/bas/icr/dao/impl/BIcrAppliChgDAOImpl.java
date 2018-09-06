package com.huateng.scf.bas.icr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.icr.dao.IBIcrAppliChgDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliChg;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliChgExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BIcrAppliChgDAO")
public class BIcrAppliChgDAOImpl extends IbatisDaoAnnotation4Template implements IBIcrAppliChgDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BIcrAppliChgDAOImpl() {
        super();
    }

    public int countByExample(BIcrAppliChgExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_ICR_APPLI_CHG.countByExample", example);
        return count;
    }

    public int deleteByExample(BIcrAppliChgExample example) {
        int rows = getSqlMapClientTemplate().delete("B_ICR_APPLI_CHG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BIcrAppliChg _key = new BIcrAppliChg();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_ICR_APPLI_CHG.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BIcrAppliChg record) {
        getSqlMapClientTemplate().insert("B_ICR_APPLI_CHG.insert", record);
    }

    public void insertSelective(BIcrAppliChg record) {
        getSqlMapClientTemplate().insert("B_ICR_APPLI_CHG.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BIcrAppliChg> selectByExample(BIcrAppliChgExample example) {
        List<BIcrAppliChg> list = getSqlMapClientTemplate().queryForList("B_ICR_APPLI_CHG.selectByExample", example);
        return list;
    }

    public BIcrAppliChg selectByPrimaryKey(String id) {
        BIcrAppliChg _key = new BIcrAppliChg();
        _key.setId(id);
        BIcrAppliChg record = (BIcrAppliChg) getSqlMapClientTemplate().queryForObject("B_ICR_APPLI_CHG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BIcrAppliChg record, BIcrAppliChgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_CHG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BIcrAppliChg record, BIcrAppliChgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_CHG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BIcrAppliChg record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_CHG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BIcrAppliChg record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_CHG.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BIcrAppliChg> selectByPage(BIcrAppliChgExample example, Page page) {
        List<BIcrAppliChg> list = this.searchListPageMyObject("B_ICR_APPLI_CHG.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BIcrAppliChgExample {
        private Object record;

        public UpdateByExampleParms(Object record, BIcrAppliChgExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}