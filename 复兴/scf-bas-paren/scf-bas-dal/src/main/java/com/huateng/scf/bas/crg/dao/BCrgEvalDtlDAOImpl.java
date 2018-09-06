package com.huateng.scf.bas.crg.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalDtl;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalDtlExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BCrgEvalDtlDAO")
public class BCrgEvalDtlDAOImpl extends IbatisDaoAnnotation4Template implements BCrgEvalDtlDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrgEvalDtlDAOImpl() {
        super();
    }

    public int countByExample(BCrgEvalDtlExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRG_EVAL_DTL.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrgEvalDtlExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRG_EVAL_DTL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String evalDtlId) {
        BCrgEvalDtl _key = new BCrgEvalDtl();
        _key.setEvalDtlId(evalDtlId);
        int rows = getSqlMapClientTemplate().delete("B_CRG_EVAL_DTL.deleteByPrimaryKey", _key);
        return rows;
    }

    public String insert(BCrgEvalDtl record) {
    	return(String) getSqlMapClientTemplate().insert("B_CRG_EVAL_DTL.insert", record);
    }

    public String insertSelective(BCrgEvalDtl record) {
        return(String)getSqlMapClientTemplate().insert("B_CRG_EVAL_DTL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrgEvalDtl> selectByExample(BCrgEvalDtlExample example) {
        List<BCrgEvalDtl> list = getSqlMapClientTemplate().queryForList("B_CRG_EVAL_DTL.selectByExample", example);
        return list;
    }

    public BCrgEvalDtl selectByPrimaryKey(String evalDtlId) {
        BCrgEvalDtl _key = new BCrgEvalDtl();
        _key.setEvalDtlId(evalDtlId);
        BCrgEvalDtl record = (BCrgEvalDtl) getSqlMapClientTemplate().queryForObject("B_CRG_EVAL_DTL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrgEvalDtl record, BCrgEvalDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_DTL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrgEvalDtl record, BCrgEvalDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_DTL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrgEvalDtl record) {
        int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_DTL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrgEvalDtl record) {
        int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_DTL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrgEvalDtl> selectByPage(BCrgEvalDtlExample example, Page page) {
        List<BCrgEvalDtl> list = this.searchListPageMyObject("B_CRG_EVAL_DTL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrgEvalDtlExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrgEvalDtlExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}