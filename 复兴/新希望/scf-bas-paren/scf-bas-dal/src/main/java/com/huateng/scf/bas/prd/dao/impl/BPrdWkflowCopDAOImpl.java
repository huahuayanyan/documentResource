package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdWkflowCopDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdWkflowCop;
import com.huateng.scf.bas.prd.dao.model.BPrdWkflowCopExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BPrdWkflowCopDAO")
public class BPrdWkflowCopDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdWkflowCopDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdWkflowCopDAOImpl() {
        super();
    }

    public int countByExample(BPrdWkflowCopExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_WKFLOW_COP.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdWkflowCopExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_WKFLOW_COP.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdWkflowCop _key = new BPrdWkflowCop();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_WKFLOW_COP.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdWkflowCop record) {
        getSqlMapClientTemplate().insert("B_PRD_WKFLOW_COP.insert", record);
    }

    public void insertSelective(BPrdWkflowCop record) {
        getSqlMapClientTemplate().insert("B_PRD_WKFLOW_COP.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdWkflowCop> selectByExample(BPrdWkflowCopExample example) {
        List<BPrdWkflowCop> list = getSqlMapClientTemplate().queryForList("B_PRD_WKFLOW_COP.selectByExample", example);
        return list;
    }

    public BPrdWkflowCop selectByPrimaryKey(String id) {
        BPrdWkflowCop _key = new BPrdWkflowCop();
        _key.setId(id);
        BPrdWkflowCop record = (BPrdWkflowCop) getSqlMapClientTemplate().queryForObject("B_PRD_WKFLOW_COP.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdWkflowCop record, BPrdWkflowCopExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_WKFLOW_COP.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdWkflowCop record, BPrdWkflowCopExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_WKFLOW_COP.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdWkflowCop record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_WKFLOW_COP.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdWkflowCop record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_WKFLOW_COP.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdWkflowCop> selectByPage(BPrdWkflowCopExample example, Page page) {
        List<BPrdWkflowCop> list = this.searchListPageMyObject("B_PRD_WKFLOW_COP.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdWkflowCopExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdWkflowCopExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}