package com.huateng.scf.bas.mrn.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.mrn.dao.IBMrnAcctBussInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BMrnAcctBussInfoDAO")
public class BMrnAcctBussInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBMrnAcctBussInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BMrnAcctBussInfoDAOImpl() {
        super();
    }

    public int countByExample(BMrnAcctBussInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_MRN_ACCT_BUSS_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BMrnAcctBussInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_MRN_ACCT_BUSS_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BMrnAcctBussInfo _key = new BMrnAcctBussInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_MRN_ACCT_BUSS_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BMrnAcctBussInfo record) {
        getSqlMapClientTemplate().insert("B_MRN_ACCT_BUSS_INFO.insert", record);
    }

    public void insertSelective(BMrnAcctBussInfo record) {
        getSqlMapClientTemplate().insert("B_MRN_ACCT_BUSS_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BMrnAcctBussInfo> selectByExample(BMrnAcctBussInfoExample example) {
        List<BMrnAcctBussInfo> list = getSqlMapClientTemplate().queryForList("B_MRN_ACCT_BUSS_INFO.selectByExample", example);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BMrnAcctBussInfo> selectByAppno(String appno) {
        List<BMrnAcctBussInfo> list = getSqlMapClientTemplate().queryForList("B_MRN_ACCT_BUSS_INFO.selectByAppno", appno);
        return list;
    }

    public BMrnAcctBussInfo selectByPrimaryKey(String id) {
        BMrnAcctBussInfo _key = new BMrnAcctBussInfo();
        _key.setId(id);
        BMrnAcctBussInfo record = (BMrnAcctBussInfo) getSqlMapClientTemplate().queryForObject("B_MRN_ACCT_BUSS_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BMrnAcctBussInfo record, BMrnAcctBussInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_MRN_ACCT_BUSS_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BMrnAcctBussInfo record, BMrnAcctBussInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_MRN_ACCT_BUSS_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BMrnAcctBussInfo record) {
        int rows = getSqlMapClientTemplate().update("B_MRN_ACCT_BUSS_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BMrnAcctBussInfo record) {
        int rows = getSqlMapClientTemplate().update("B_MRN_ACCT_BUSS_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BMrnAcctBussInfo> selectByPage(BMrnAcctBussInfoExample example, Page page) {
        List<BMrnAcctBussInfo> list = this.searchListPageMyObject("B_MRN_ACCT_BUSS_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BMrnAcctBussInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BMrnAcctBussInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}