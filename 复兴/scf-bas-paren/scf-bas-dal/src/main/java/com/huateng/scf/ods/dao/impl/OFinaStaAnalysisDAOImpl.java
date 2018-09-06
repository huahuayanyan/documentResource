package com.huateng.scf.ods.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.ods.dao.IOFinaStaAnalysisDAO;
import com.huateng.scf.ods.dao.model.OFinaStaAnalysis;
import com.huateng.scf.ods.dao.model.OFinaStaAnalysisExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("OFinaStaAnalysisDAO")
public class OFinaStaAnalysisDAOImpl extends IbatisDaoAnnotation4Template implements IOFinaStaAnalysisDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public OFinaStaAnalysisDAOImpl() {
        super();
    }

    public int countByExample(OFinaStaAnalysisExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ODS_FINA_STA_ANALYSIS.countByExample", example);
        return count;
    }

    public int deleteByExample(OFinaStaAnalysisExample example) {
        int rows = getSqlMapClientTemplate().delete("ODS_FINA_STA_ANALYSIS.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        OFinaStaAnalysis _key = new OFinaStaAnalysis();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ODS_FINA_STA_ANALYSIS.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(OFinaStaAnalysis record) {
        getSqlMapClientTemplate().insert("ODS_FINA_STA_ANALYSIS.insert", record);
    }

    public void insertSelective(OFinaStaAnalysis record) {
        getSqlMapClientTemplate().insert("ODS_FINA_STA_ANALYSIS.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<OFinaStaAnalysis> selectByExample(OFinaStaAnalysisExample example) {
        List<OFinaStaAnalysis> list = getSqlMapClientTemplate().queryForList("ODS_FINA_STA_ANALYSIS.selectByExample", example);
        return list;
    }

    public OFinaStaAnalysis selectByPrimaryKey(String id) {
        OFinaStaAnalysis _key = new OFinaStaAnalysis();
        _key.setId(id);
        OFinaStaAnalysis record = (OFinaStaAnalysis) getSqlMapClientTemplate().queryForObject("ODS_FINA_STA_ANALYSIS.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(OFinaStaAnalysis record, OFinaStaAnalysisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_FINA_STA_ANALYSIS.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(OFinaStaAnalysis record, OFinaStaAnalysisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_FINA_STA_ANALYSIS.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(OFinaStaAnalysis record) {
        int rows = getSqlMapClientTemplate().update("ODS_FINA_STA_ANALYSIS.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(OFinaStaAnalysis record) {
        int rows = getSqlMapClientTemplate().update("ODS_FINA_STA_ANALYSIS.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<OFinaStaAnalysis> selectByPage(OFinaStaAnalysisExample example, Page page) {
        List<OFinaStaAnalysis> list = this.searchListPageMyObject("ODS_FINA_STA_ANALYSIS.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends OFinaStaAnalysisExample {
        private Object record;

        public UpdateByExampleParms(Object record, OFinaStaAnalysisExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}