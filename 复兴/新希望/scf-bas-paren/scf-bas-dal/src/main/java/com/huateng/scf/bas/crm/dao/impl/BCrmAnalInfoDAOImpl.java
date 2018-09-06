package com.huateng.scf.bas.crm.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmAnalInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmAnalInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmAnalInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("IBCrmAnalInfoDAO")
public class BCrmAnalInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmAnalInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrmAnalInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrmAnalInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRM_ANAL_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrmAnalInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRM_ANAL_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCrmAnalInfo _key = new BCrmAnalInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CRM_ANAL_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrmAnalInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_ANAL_INFO.insert", record);
    }

    public void insertSelective(BCrmAnalInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_ANAL_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrmAnalInfo> selectByExample(BCrmAnalInfoExample example) {
        List<BCrmAnalInfo> list = getSqlMapClientTemplate().queryForList("B_CRM_ANAL_INFO.selectByExample", example);
        return list;
    }

    public BCrmAnalInfo selectByPrimaryKey(String id) {
        BCrmAnalInfo _key = new BCrmAnalInfo();
        _key.setId(id);
        BCrmAnalInfo record = (BCrmAnalInfo) getSqlMapClientTemplate().queryForObject("B_CRM_ANAL_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrmAnalInfo record, BCrmAnalInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_ANAL_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrmAnalInfo record, BCrmAnalInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_ANAL_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrmAnalInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_ANAL_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrmAnalInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_ANAL_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrmAnalInfo> selectByPage(BCrmAnalInfoExample example, Page page) {
        List<BCrmAnalInfo> list = this.searchListPageMyObject("B_CRM_ANAL_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrmAnalInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrmAnalInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}