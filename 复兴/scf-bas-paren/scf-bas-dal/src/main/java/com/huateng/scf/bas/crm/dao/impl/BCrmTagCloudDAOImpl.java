package com.huateng.scf.bas.crm.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmTagCloudDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloud;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloudExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BCrmTagCloudDAO")
public class BCrmTagCloudDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmTagCloudDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrmTagCloudDAOImpl() {
        super();
    }

    public int countByExample(BCrmTagCloudExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRM_TAG_CLOUD.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrmTagCloudExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRM_TAG_CLOUD.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String custCd) {
        BCrmTagCloud _key = new BCrmTagCloud();
        _key.setCustCd(custCd);
        int rows = getSqlMapClientTemplate().delete("B_CRM_TAG_CLOUD.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrmTagCloud record) {
        getSqlMapClientTemplate().insert("B_CRM_TAG_CLOUD.insert", record);
    }

    public void insertSelective(BCrmTagCloud record) {
        getSqlMapClientTemplate().insert("B_CRM_TAG_CLOUD.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrmTagCloud> selectByExample(BCrmTagCloudExample example) {
        List<BCrmTagCloud> list = getSqlMapClientTemplate().queryForList("B_CRM_TAG_CLOUD.selectByExample", example);
        return list;
    }

    public BCrmTagCloud selectByPrimaryKey(String custCd) {
        BCrmTagCloud _key = new BCrmTagCloud();
        _key.setCustCd(custCd);
        BCrmTagCloud record = (BCrmTagCloud) getSqlMapClientTemplate().queryForObject("B_CRM_TAG_CLOUD.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrmTagCloud record, BCrmTagCloudExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_TAG_CLOUD.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrmTagCloud record, BCrmTagCloudExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_TAG_CLOUD.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrmTagCloud record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_TAG_CLOUD.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrmTagCloud record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_TAG_CLOUD.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrmTagCloud> selectByPage(BCrmTagCloudExample example, Page page) {
        List<BCrmTagCloud> list = this.searchListPageMyObject("B_CRM_TAG_CLOUD.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrmTagCloudExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrmTagCloudExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}