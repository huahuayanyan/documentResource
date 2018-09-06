package com.huateng.scf.bas.crm.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmUpanddownRelDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel;
import com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRelExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBCrmUpanddownRelDAO")
public class BCrmUpanddownRelDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmUpanddownRelDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrmUpanddownRelDAOImpl() {
        super();
    }

    public int countByExample(BCrmUpanddownRelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRM_UPANDDOWN_REL.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrmUpanddownRelExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRM_UPANDDOWN_REL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCrmUpanddownRel _key = new BCrmUpanddownRel();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CRM_UPANDDOWN_REL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrmUpanddownRel record) {
        getSqlMapClientTemplate().insert("B_CRM_UPANDDOWN_REL.insert", record);
    }

    public void insertSelective(BCrmUpanddownRel record) {
        getSqlMapClientTemplate().insert("B_CRM_UPANDDOWN_REL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrmUpanddownRel> selectByExample(BCrmUpanddownRelExample example) {
        List<BCrmUpanddownRel> list = getSqlMapClientTemplate().queryForList("B_CRM_UPANDDOWN_REL.selectByExample", example);
        return list;
    }

    public BCrmUpanddownRel selectByPrimaryKey(String id) {
        BCrmUpanddownRel _key = new BCrmUpanddownRel();
        _key.setId(id);
        BCrmUpanddownRel record = (BCrmUpanddownRel) getSqlMapClientTemplate().queryForObject("B_CRM_UPANDDOWN_REL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrmUpanddownRel record, BCrmUpanddownRelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_UPANDDOWN_REL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrmUpanddownRel record, BCrmUpanddownRelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_UPANDDOWN_REL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrmUpanddownRel record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_UPANDDOWN_REL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrmUpanddownRel record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_UPANDDOWN_REL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrmUpanddownRel> selectByPage(BCrmUpanddownRelExample example, Page page) {
        List<BCrmUpanddownRel> list = this.searchListPageMyObject("B_CRM_UPANDDOWN_REL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrmUpanddownRelExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrmUpanddownRelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}