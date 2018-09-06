package com.huateng.scf.nbas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nbas.prd.dao.IBPrdFlowDAO;
import com.huateng.scf.nbas.prd.dao.model.BPrdFlow;
import com.huateng.scf.nbas.prd.dao.model.BPrdFlowExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBPrdFlowDAO")
public class BPrdFlowDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdFlowDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdFlowDAOImpl() {
        super();
    }

    public int countByExample(BPrdFlowExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_FLOW.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdFlowExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_FLOW.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdFlow _key = new BPrdFlow();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_FLOW.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdFlow record) {
        getSqlMapClientTemplate().insert("B_PRD_FLOW.insert", record);
    }

    public void insertSelective(BPrdFlow record) {
        getSqlMapClientTemplate().insert("B_PRD_FLOW.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdFlow> selectByExample(BPrdFlowExample example) {
        List<BPrdFlow> list = getSqlMapClientTemplate().queryForList("B_PRD_FLOW.selectByExample", example);
        return list;
    }

    public BPrdFlow selectByPrimaryKey(String id) {
        BPrdFlow _key = new BPrdFlow();
        _key.setId(id);
        BPrdFlow record = (BPrdFlow) getSqlMapClientTemplate().queryForObject("B_PRD_FLOW.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdFlow record, BPrdFlowExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_FLOW.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdFlow record, BPrdFlowExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_FLOW.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdFlow record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_FLOW.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdFlow record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_FLOW.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdFlow> selectByPage(BPrdFlowExample example, Page page) {
        List<BPrdFlow> list = this.searchListPageMyObject("B_PRD_FLOW.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdFlowExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdFlowExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}