package com.huateng.scf.bas.fin.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.fin.dao.IBFinCustDsExtDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExt;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExtExample;

@Repository("BFinCustDsExtDAO")
public class BFinCustDsExtDAOImpl extends IbatisDaoAnnotation4Template implements IBFinCustDsExtDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BFinCustDsExtDAOImpl() {
        super();
    }

    public int countByExample(BFinCustDsExtExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_FIN_CUST_DS_EXT.countByExample", example);
        return count;
    }

    public int deleteByExample(BFinCustDsExtExample example) {
        int rows = getSqlMapClientTemplate().delete("B_FIN_CUST_DS_EXT.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BFinCustDsExt _key = new BFinCustDsExt();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_FIN_CUST_DS_EXT.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BFinCustDsExt record) {
        getSqlMapClientTemplate().insert("B_FIN_CUST_DS_EXT.insert", record);
    }

    public void insertSelective(BFinCustDsExt record) {
        getSqlMapClientTemplate().insert("B_FIN_CUST_DS_EXT.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BFinCustDsExt> selectByExample(BFinCustDsExtExample example) {
        List<BFinCustDsExt> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DS_EXT.selectByExample", example);
        return list;
    }

    public BFinCustDsExt selectByPrimaryKey(String id) {
        BFinCustDsExt _key = new BFinCustDsExt();
        _key.setId(id);
        BFinCustDsExt record = (BFinCustDsExt) getSqlMapClientTemplate().queryForObject("B_FIN_CUST_DS_EXT.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BFinCustDsExt record, BFinCustDsExtExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DS_EXT.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BFinCustDsExt record, BFinCustDsExtExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DS_EXT.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BFinCustDsExt record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DS_EXT.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BFinCustDsExt record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DS_EXT.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BFinCustDsExt> selectByPage(BFinCustDsExtExample example, Page page) {
        List<BFinCustDsExt> list = this.searchListPageMyObject("B_FIN_CUST_DS_EXT.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BFinCustDsExtExample {
        private Object record;

        public UpdateByExampleParms(Object record, BFinCustDsExtExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}