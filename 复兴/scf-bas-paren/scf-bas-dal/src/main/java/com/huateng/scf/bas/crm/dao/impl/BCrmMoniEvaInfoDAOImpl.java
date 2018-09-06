package com.huateng.scf.bas.crm.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmMoniEvaInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("IBCrmMoniEvaInfoDAO")
public class BCrmMoniEvaInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmMoniEvaInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrmMoniEvaInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrmMoniEvaInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRM_MONI_EVA_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrmMoniEvaInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRM_MONI_EVA_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCrmMoniEvaInfo _key = new BCrmMoniEvaInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CRM_MONI_EVA_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrmMoniEvaInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_MONI_EVA_INFO.insert", record);
    }

    public void insertSelective(BCrmMoniEvaInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_MONI_EVA_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrmMoniEvaInfo> selectByExample(BCrmMoniEvaInfoExample example) {
        List<BCrmMoniEvaInfo> list = getSqlMapClientTemplate().queryForList("B_CRM_MONI_EVA_INFO.selectByExample", example);
        return list;
    }

    public BCrmMoniEvaInfo selectByPrimaryKey(String id) {
        BCrmMoniEvaInfo _key = new BCrmMoniEvaInfo();
        _key.setId(id);
        BCrmMoniEvaInfo record = (BCrmMoniEvaInfo) getSqlMapClientTemplate().queryForObject("B_CRM_MONI_EVA_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrmMoniEvaInfo record, BCrmMoniEvaInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_MONI_EVA_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrmMoniEvaInfo record, BCrmMoniEvaInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_MONI_EVA_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrmMoniEvaInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_MONI_EVA_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrmMoniEvaInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRM_MONI_EVA_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrmMoniEvaInfo> selectByPage(BCrmMoniEvaInfoExample example, Page page) {
        List<BCrmMoniEvaInfo> list = this.searchListPageMyObject("B_CRM_MONI_EVA_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrmMoniEvaInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrmMoniEvaInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}