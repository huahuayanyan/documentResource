package com.huateng.scf.bas.cnt.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntMprotCmPriceHisDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmPriceHis;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmPriceHisExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBCntMprotCmPriceHisDAO")
public class BCntMprotCmPriceHisDAOImpl extends IbatisDaoAnnotation4Template implements IBCntMprotCmPriceHisDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntMprotCmPriceHisDAOImpl() {
        super();
    }

    public int countByExample(BCntMprotCmPriceHisExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_CM_PRICE_HIS.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntMprotCmPriceHisExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_CM_PRICE_HIS.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCntMprotCmPriceHis _key = new BCntMprotCmPriceHis();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_CM_PRICE_HIS.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntMprotCmPriceHis record) {
        getSqlMapClientTemplate().insert("B_CNT_MPROT_CM_PRICE_HIS.insert", record);
    }

    public void insertSelective(BCntMprotCmPriceHis record) {
        getSqlMapClientTemplate().insert("B_CNT_MPROT_CM_PRICE_HIS.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotCmPriceHis> selectByExample(BCntMprotCmPriceHisExample example) {
        List<BCntMprotCmPriceHis> list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_CM_PRICE_HIS.selectByExample", example);
        return list;
    }

    public BCntMprotCmPriceHis selectByPrimaryKey(String id) {
        BCntMprotCmPriceHis _key = new BCntMprotCmPriceHis();
        _key.setId(id);
        BCntMprotCmPriceHis record = (BCntMprotCmPriceHis) getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_CM_PRICE_HIS.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntMprotCmPriceHis record, BCntMprotCmPriceHisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CM_PRICE_HIS.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntMprotCmPriceHis record, BCntMprotCmPriceHisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CM_PRICE_HIS.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntMprotCmPriceHis record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CM_PRICE_HIS.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntMprotCmPriceHis record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CM_PRICE_HIS.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotCmPriceHis> selectByPage(BCntMprotCmPriceHisExample example, Page page) {
        List<BCntMprotCmPriceHis> list = this.searchListPageMyObject("B_CNT_MPROT_CM_PRICE_HIS.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntMprotCmPriceHisExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntMprotCmPriceHisExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}