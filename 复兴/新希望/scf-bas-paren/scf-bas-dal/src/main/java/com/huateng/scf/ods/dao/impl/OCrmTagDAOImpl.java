package com.huateng.scf.ods.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.ods.dao.IOCrmTagDAO;
import com.huateng.scf.ods.dao.model.OCrmTag;
import com.huateng.scf.ods.dao.model.OCrmTagExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("OCrmTagDAO")
public class OCrmTagDAOImpl extends IbatisDaoAnnotation4Template implements IOCrmTagDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public OCrmTagDAOImpl() {
        super();
    }

    public int countByExample(OCrmTagExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ODS_CRM_TAG.countByExample", example);
        return count;
    }

    public int deleteByExample(OCrmTagExample example) {
        int rows = getSqlMapClientTemplate().delete("ODS_CRM_TAG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        OCrmTag _key = new OCrmTag();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ODS_CRM_TAG.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(OCrmTag record) {
        getSqlMapClientTemplate().insert("ODS_CRM_TAG.insert", record);
    }

    public void insertSelective(OCrmTag record) {
        getSqlMapClientTemplate().insert("ODS_CRM_TAG.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<OCrmTag> selectByExample(OCrmTagExample example) {
        List<OCrmTag> list = getSqlMapClientTemplate().queryForList("ODS_CRM_TAG.selectByExample", example);
        return list;
    }

    public OCrmTag selectByPrimaryKey(String id) {
        OCrmTag _key = new OCrmTag();
        _key.setId(id);
        OCrmTag record = (OCrmTag) getSqlMapClientTemplate().queryForObject("ODS_CRM_TAG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(OCrmTag record, OCrmTagExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_CRM_TAG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(OCrmTag record, OCrmTagExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_CRM_TAG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(OCrmTag record) {
        int rows = getSqlMapClientTemplate().update("ODS_CRM_TAG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(OCrmTag record) {
        int rows = getSqlMapClientTemplate().update("ODS_CRM_TAG.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<OCrmTag> selectByPage(OCrmTagExample example, Page page) {
        List<OCrmTag> list = this.searchListPageMyObject("ODS_CRM_TAG.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends OCrmTagExample {
        private Object record;

        public UpdateByExampleParms(Object record, OCrmTagExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}