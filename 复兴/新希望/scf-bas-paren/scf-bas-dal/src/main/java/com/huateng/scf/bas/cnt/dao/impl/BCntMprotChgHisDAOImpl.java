package com.huateng.scf.bas.cnt.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntMprotChgHisDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotChgHis;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotChgHisExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BCntMprotChgHisDAO")
public class BCntMprotChgHisDAOImpl extends IbatisDaoAnnotation4Template implements IBCntMprotChgHisDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntMprotChgHisDAOImpl() {
        super();
    }

    public int countByExample(BCntMprotChgHisExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_CHG_HIS.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntMprotChgHisExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_CHG_HIS.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCntMprotChgHis _key = new BCntMprotChgHis();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_CHG_HIS.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntMprotChgHis record) {
        getSqlMapClientTemplate().insert("B_CNT_MPROT_CHG_HIS.insert", record);
    }

    public void insertSelective(BCntMprotChgHis record) {
        getSqlMapClientTemplate().insert("B_CNT_MPROT_CHG_HIS.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotChgHis> selectByExample(BCntMprotChgHisExample example) {
        List<BCntMprotChgHis> list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_CHG_HIS.selectByExample", example);
        return list;
    }

    public BCntMprotChgHis selectByPrimaryKey(String id) {
        BCntMprotChgHis _key = new BCntMprotChgHis();
        _key.setId(id);
        BCntMprotChgHis record = (BCntMprotChgHis) getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_CHG_HIS.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntMprotChgHis record, BCntMprotChgHisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CHG_HIS.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntMprotChgHis record, BCntMprotChgHisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CHG_HIS.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntMprotChgHis record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CHG_HIS.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntMprotChgHis record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CHG_HIS.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotChgHis> selectByPage(BCntMprotChgHisExample example, Page page) {
        List<BCntMprotChgHis> list = this.searchListPageMyObject("B_CNT_MPROT_CHG_HIS.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntMprotChgHisExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntMprotChgHisExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}