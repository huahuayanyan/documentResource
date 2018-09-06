package com.huateng.scf.bas.crm.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmTagCloudRelDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRelExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("IBCrmTagCloudRelDAO")
public class BCrmTagCloudRelDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmTagCloudRelDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrmTagCloudRelDAOImpl() {
        super();
    }

    public int countByExample(BCrmTagCloudRelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRM_TAG_CLOUD_REL.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrmTagCloudRelExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRM_TAG_CLOUD_REL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCrmTagCloudRel _key = new BCrmTagCloudRel();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CRM_TAG_CLOUD_REL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrmTagCloudRel record) {
        getSqlMapClientTemplate().insert("B_CRM_TAG_CLOUD_REL.insert", record);
    }

    public void insertSelective(BCrmTagCloudRel record) {
        getSqlMapClientTemplate().insert("B_CRM_TAG_CLOUD_REL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrmTagCloudRel> selectByExample(BCrmTagCloudRelExample example) {
        List<BCrmTagCloudRel> list = getSqlMapClientTemplate().queryForList("B_CRM_TAG_CLOUD_REL.selectByExample", example);
        return list;
    }

    public BCrmTagCloudRel selectByPrimaryKey(String id) {
        BCrmTagCloudRel _key = new BCrmTagCloudRel();
        _key.setId(id);
        BCrmTagCloudRel record = (BCrmTagCloudRel) getSqlMapClientTemplate().queryForObject("B_CRM_TAG_CLOUD_REL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrmTagCloudRel record, BCrmTagCloudRelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_TAG_CLOUD_REL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrmTagCloudRel record, BCrmTagCloudRelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_TAG_CLOUD_REL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrmTagCloudRel record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_TAG_CLOUD_REL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrmTagCloudRel record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_TAG_CLOUD_REL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrmTagCloudRel> selectByPage(BCrmTagCloudRelExample example, Page page) {
        List<BCrmTagCloudRel> list = this.searchListPageMyObject("B_CRM_TAG_CLOUD_REL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrmTagCloudRelExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrmTagCloudRelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}