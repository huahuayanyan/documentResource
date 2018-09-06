package com.huateng.scf.ods.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.ods.dao.IOCrmInfoAnalysisDAO;
import com.huateng.scf.ods.dao.model.OCrmInfoAnalysis;
import com.huateng.scf.ods.dao.model.OCrmInfoAnalysisExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("OCrmInfoAnalysisDAO")
public class OCrmInfoAnalysisDAOImpl extends IbatisDaoAnnotation4Template implements IOCrmInfoAnalysisDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public OCrmInfoAnalysisDAOImpl() {
        super();
    }

    public int countByExample(OCrmInfoAnalysisExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ODS_CRM_INFO_ANALYSIS.countByExample", example);
        return count;
    }

    public int deleteByExample(OCrmInfoAnalysisExample example) {
        int rows = getSqlMapClientTemplate().delete("ODS_CRM_INFO_ANALYSIS.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        OCrmInfoAnalysis _key = new OCrmInfoAnalysis();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ODS_CRM_INFO_ANALYSIS.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(OCrmInfoAnalysis record) {
        getSqlMapClientTemplate().insert("ODS_CRM_INFO_ANALYSIS.insert", record);
    }

    public void insertSelective(OCrmInfoAnalysis record) {
        getSqlMapClientTemplate().insert("ODS_CRM_INFO_ANALYSIS.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<OCrmInfoAnalysis> selectByExample(OCrmInfoAnalysisExample example) {
        List<OCrmInfoAnalysis> list = getSqlMapClientTemplate().queryForList("ODS_CRM_INFO_ANALYSIS.selectByExample", example);
        return list;
    }

    public OCrmInfoAnalysis selectByPrimaryKey(String id) {
        OCrmInfoAnalysis _key = new OCrmInfoAnalysis();
        _key.setId(id);
        OCrmInfoAnalysis record = (OCrmInfoAnalysis) getSqlMapClientTemplate().queryForObject("ODS_CRM_INFO_ANALYSIS.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(OCrmInfoAnalysis record, OCrmInfoAnalysisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_CRM_INFO_ANALYSIS.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(OCrmInfoAnalysis record, OCrmInfoAnalysisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_CRM_INFO_ANALYSIS.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(OCrmInfoAnalysis record) {
        int rows = getSqlMapClientTemplate().update("ODS_CRM_INFO_ANALYSIS.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(OCrmInfoAnalysis record) {
        int rows = getSqlMapClientTemplate().update("ODS_CRM_INFO_ANALYSIS.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<OCrmInfoAnalysis> selectByPage(OCrmInfoAnalysisExample example, Page page) {
        List<OCrmInfoAnalysis> list = this.searchListPageMyObject("ODS_CRM_INFO_ANALYSIS.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends OCrmInfoAnalysisExample {
        private Object record;

        public UpdateByExampleParms(Object record, OCrmInfoAnalysisExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}