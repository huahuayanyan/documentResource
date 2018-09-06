package com.huateng.scf.bas.mrn.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.mrn.dao.IBMrnBussInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnBussInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnBussInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBMrnBussInfoDAO")
public class BMrnBussInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBMrnBussInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BMrnBussInfoDAOImpl() {
        super();
    }

    public int countByExample(BMrnBussInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_MRN_BUSS_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BMrnBussInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_MRN_BUSS_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BMrnBussInfo _key = new BMrnBussInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_MRN_BUSS_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BMrnBussInfo record) {
        getSqlMapClientTemplate().insert("B_MRN_BUSS_INFO.insert", record);
    }

    public void insertSelective(BMrnBussInfo record) {
        getSqlMapClientTemplate().insert("B_MRN_BUSS_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BMrnBussInfo> selectByExample(BMrnBussInfoExample example) {
        List<BMrnBussInfo> list = getSqlMapClientTemplate().queryForList("B_MRN_BUSS_INFO.selectByExample", example);
        return list;
    }

    public BMrnBussInfo selectByPrimaryKey(String id) {
        BMrnBussInfo _key = new BMrnBussInfo();
        _key.setId(id);
        BMrnBussInfo record = (BMrnBussInfo) getSqlMapClientTemplate().queryForObject("B_MRN_BUSS_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BMrnBussInfo record, BMrnBussInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_MRN_BUSS_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BMrnBussInfo record, BMrnBussInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_MRN_BUSS_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BMrnBussInfo record) {
        int rows = getSqlMapClientTemplate().update("B_MRN_BUSS_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BMrnBussInfo record) {
        int rows = getSqlMapClientTemplate().update("B_MRN_BUSS_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BMrnBussInfo> selectByPage(BMrnBussInfoExample example, Page page) {
        List<BMrnBussInfo> list = this.searchListPageMyObject("B_MRN_BUSS_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BMrnBussInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BMrnBussInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}