package com.huateng.scf.bas.sys.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.IBSysQueryLimitsDAO;
import com.huateng.scf.bas.sys.dao.model.BSysQueryLimits;
import com.huateng.scf.bas.sys.dao.model.BSysQueryLimitsExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBSysQueryLimitsDAO")
public class BSysQueryLimitsDAOImpl extends IbatisDaoAnnotation4Template implements IBSysQueryLimitsDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysQueryLimitsDAOImpl() {
        super();
    }

    public int countByExample(BSysQueryLimitsExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_QUERY_LIMITS.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysQueryLimitsExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_QUERY_LIMITS.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String roleId) {
        BSysQueryLimits _key = new BSysQueryLimits();
        _key.setRoleId(roleId);
        int rows = getSqlMapClientTemplate().delete("B_SYS_QUERY_LIMITS.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BSysQueryLimits record) {
        getSqlMapClientTemplate().insert("B_SYS_QUERY_LIMITS.insert", record);
    }

    public void insertSelective(BSysQueryLimits record) {
        getSqlMapClientTemplate().insert("B_SYS_QUERY_LIMITS.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysQueryLimits> selectByExample(BSysQueryLimitsExample example) {
        List<BSysQueryLimits> list = getSqlMapClientTemplate().queryForList("B_SYS_QUERY_LIMITS.selectByExample", example);
        return list;
    }

    public BSysQueryLimits selectByPrimaryKey(String roleId) {
        BSysQueryLimits _key = new BSysQueryLimits();
        _key.setRoleId(roleId);
        BSysQueryLimits record = (BSysQueryLimits) getSqlMapClientTemplate().queryForObject("B_SYS_QUERY_LIMITS.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysQueryLimits record, BSysQueryLimitsExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_QUERY_LIMITS.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysQueryLimits record, BSysQueryLimitsExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_QUERY_LIMITS.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysQueryLimits record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_QUERY_LIMITS.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysQueryLimits record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_QUERY_LIMITS.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysQueryLimits> selectByPage(BSysQueryLimitsExample example, Page page) {
        List<BSysQueryLimits> list = this.searchListPageMyObject("B_SYS_QUERY_LIMITS.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysQueryLimitsExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysQueryLimitsExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}