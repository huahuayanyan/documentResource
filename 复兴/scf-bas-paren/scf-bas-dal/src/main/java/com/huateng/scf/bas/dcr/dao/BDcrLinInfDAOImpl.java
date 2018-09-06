package com.huateng.scf.bas.dcr.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.dcr.model.BDcrLinInf;
import com.huateng.scf.bas.dcr.model.BDcrLinInfExample;

@Repository("BDcrLinInfDAO")
public class BDcrLinInfDAOImpl extends IbatisDaoAnnotation4Template implements BDcrLinInfDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BDcrLinInfDAOImpl() {
        super();
    }

    public int countByExample(BDcrLinInfExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_DCR_LIN_INF.countByExample", example);
        return count;
    }

    public int deleteByExample(BDcrLinInfExample example) {
        int rows = getSqlMapClientTemplate().delete("B_DCR_LIN_INF.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String linId) {
        BDcrLinInf _key = new BDcrLinInf();
        _key.setLinId(linId);
        int rows = getSqlMapClientTemplate().delete("B_DCR_LIN_INF.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BDcrLinInf record) {
        getSqlMapClientTemplate().insert("B_DCR_LIN_INF.insert", record);
    }

    public void insertSelective(BDcrLinInf record) {
        getSqlMapClientTemplate().insert("B_DCR_LIN_INF.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BDcrLinInf> selectByExample(BDcrLinInfExample example) {
        List<BDcrLinInf> list = getSqlMapClientTemplate().queryForList("B_DCR_LIN_INF.selectByExample", example);
        return list;
    }

    public BDcrLinInf selectByPrimaryKey(String linId) {
        BDcrLinInf _key = new BDcrLinInf();
        _key.setLinId(linId);
        BDcrLinInf record = (BDcrLinInf) getSqlMapClientTemplate().queryForObject("B_DCR_LIN_INF.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BDcrLinInf record, BDcrLinInfExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_INF.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BDcrLinInf record, BDcrLinInfExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_INF.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BDcrLinInf record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_INF.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BDcrLinInf record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_INF.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BDcrLinInf> selectByPage(BDcrLinInfExample example, Page page) {
        List<BDcrLinInf> list = this.searchListPageMyObject("B_DCR_LIN_INF.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BDcrLinInfExample {
        private Object record;

        public UpdateByExampleParms(Object record, BDcrLinInfExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}