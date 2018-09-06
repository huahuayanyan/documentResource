package com.huateng.scf.bas.crm.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmEntInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("IBCrmEntInfoDAO")
public class BCrmEntInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmEntInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrmEntInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrmEntInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRM_ENT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrmEntInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRM_ENT_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String custcd) {
        BCrmEntInfo _key = new BCrmEntInfo();
        _key.setCustcd(custcd);
        int rows = getSqlMapClientTemplate().delete("B_CRM_ENT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrmEntInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_ENT_INFO.insert", record);
    }

    public void insertSelective(BCrmEntInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_ENT_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrmEntInfo> selectByExample(BCrmEntInfoExample example) {
        List<BCrmEntInfo> list = getSqlMapClientTemplate().queryForList("B_CRM_ENT_INFO.selectByExample", example);
        return list;
    }

    public BCrmEntInfo selectByPrimaryKey(String custcd) {
        BCrmEntInfo _key = new BCrmEntInfo();
        _key.setCustcd(custcd);
        BCrmEntInfo record = (BCrmEntInfo) getSqlMapClientTemplate().queryForObject("B_CRM_ENT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrmEntInfo record, BCrmEntInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_ENT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrmEntInfo record, BCrmEntInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_ENT_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrmEntInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_ENT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrmEntInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_ENT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrmEntInfo> selectByPage(BCrmEntInfoExample example, Page page) {
        List<BCrmEntInfo> list = this.searchListPageMyObject("B_CRM_ENT_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrmEntInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrmEntInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}