package com.huateng.scf.bas.crm.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmRelationInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmRelationInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmRelationInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("IBCrmRelationInfoDAO")
public class BCrmRelationInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmRelationInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrmRelationInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrmRelationInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRM_RELATION_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrmRelationInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRM_RELATION_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCrmRelationInfo _key = new BCrmRelationInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CRM_RELATION_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrmRelationInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_RELATION_INFO.insert", record);
    }

    public void insertSelective(BCrmRelationInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_RELATION_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrmRelationInfo> selectByExample(BCrmRelationInfoExample example) {
        List<BCrmRelationInfo> list = getSqlMapClientTemplate().queryForList("B_CRM_RELATION_INFO.selectByExample", example);
        return list;
    }

    public BCrmRelationInfo selectByPrimaryKey(String id) {
        BCrmRelationInfo _key = new BCrmRelationInfo();
        _key.setId(id);
        BCrmRelationInfo record = (BCrmRelationInfo) getSqlMapClientTemplate().queryForObject("B_CRM_RELATION_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrmRelationInfo record, BCrmRelationInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_RELATION_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrmRelationInfo record, BCrmRelationInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_RELATION_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrmRelationInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_RELATION_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrmRelationInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_RELATION_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrmRelationInfo> selectByPage(BCrmRelationInfoExample example, Page page) {
        List<BCrmRelationInfo> list = this.searchListPageMyObject("B_CRM_RELATION_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrmRelationInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrmRelationInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}