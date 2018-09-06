package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdBranchAuthDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdBranchAuth;
import com.huateng.scf.bas.prd.dao.model.BPrdBranchAuthExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBPrdBranchAuthDAO")
public class BPrdBranchAuthDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdBranchAuthDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdBranchAuthDAOImpl() {
        super();
    }

    public int countByExample(BPrdBranchAuthExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_BRANCH_AUTH.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdBranchAuthExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_BRANCH_AUTH.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdBranchAuth _key = new BPrdBranchAuth();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_BRANCH_AUTH.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdBranchAuth record) {
        getSqlMapClientTemplate().insert("B_PRD_BRANCH_AUTH.insert", record);
    }

    public void insertSelective(BPrdBranchAuth record) {
        getSqlMapClientTemplate().insert("B_PRD_BRANCH_AUTH.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdBranchAuth> selectByExample(BPrdBranchAuthExample example) {
        List<BPrdBranchAuth> list = getSqlMapClientTemplate().queryForList("B_PRD_BRANCH_AUTH.selectByExample", example);
        return list;
    }

    public BPrdBranchAuth selectByPrimaryKey(String id) {
        BPrdBranchAuth _key = new BPrdBranchAuth();
        _key.setId(id);
        BPrdBranchAuth record = (BPrdBranchAuth) getSqlMapClientTemplate().queryForObject("B_PRD_BRANCH_AUTH.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdBranchAuth record, BPrdBranchAuthExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_BRANCH_AUTH.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdBranchAuth record, BPrdBranchAuthExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_BRANCH_AUTH.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdBranchAuth record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_BRANCH_AUTH.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdBranchAuth record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_BRANCH_AUTH.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdBranchAuth> selectByPage(BPrdBranchAuthExample example, Page page) {
        List<BPrdBranchAuth> list = this.searchListPageMyObject("B_PRD_BRANCH_AUTH.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdBranchAuthExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdBranchAuthExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}