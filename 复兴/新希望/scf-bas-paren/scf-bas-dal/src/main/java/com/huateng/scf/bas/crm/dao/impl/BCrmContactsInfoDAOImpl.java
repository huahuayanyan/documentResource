package com.huateng.scf.bas.crm.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmContactsInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmContactsInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmContactsInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBCrmContactsInfoDAO")
public class BCrmContactsInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmContactsInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrmContactsInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrmContactsInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRM_CONTACTS_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrmContactsInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRM_CONTACTS_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCrmContactsInfo _key = new BCrmContactsInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CRM_CONTACTS_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrmContactsInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_CONTACTS_INFO.insert", record);
    }

    public void insertSelective(BCrmContactsInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_CONTACTS_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrmContactsInfo> selectByExample(BCrmContactsInfoExample example) {
        List<BCrmContactsInfo> list = getSqlMapClientTemplate().queryForList("B_CRM_CONTACTS_INFO.selectByExample", example);
        return list;
    }

    public BCrmContactsInfo selectByPrimaryKey(String id) {
        BCrmContactsInfo _key = new BCrmContactsInfo();
        _key.setId(id);
        BCrmContactsInfo record = (BCrmContactsInfo) getSqlMapClientTemplate().queryForObject("B_CRM_CONTACTS_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrmContactsInfo record, BCrmContactsInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_CONTACTS_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrmContactsInfo record, BCrmContactsInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_CONTACTS_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrmContactsInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_CONTACTS_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrmContactsInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_CONTACTS_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrmContactsInfo> selectByPage(BCrmContactsInfoExample example, Page page) {
        List<BCrmContactsInfo> list = this.searchListPageMyObject("B_CRM_CONTACTS_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrmContactsInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrmContactsInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}