package com.huateng.scf.adv.wrn.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.IBWanCheckStockDAO;
import com.huateng.scf.adv.wrn.dao.model.BWanCheckStock;
import com.huateng.scf.adv.wrn.dao.model.BWanCheckStockExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("IBWanCheckStockDAO")
public class BWanCheckStockDAOImpl extends IbatisDaoAnnotation4Template implements IBWanCheckStockDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BWanCheckStockDAOImpl() {
        super();
    }

    public int countByExample(BWanCheckStockExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_WRN_CHECK_STOCK.countByExample", example);
        return count;
    }

    public int deleteByExample(BWanCheckStockExample example) {
        int rows = getSqlMapClientTemplate().delete("B_WRN_CHECK_STOCK.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BWanCheckStock _key = new BWanCheckStock();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_WRN_CHECK_STOCK.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BWanCheckStock record) {
        getSqlMapClientTemplate().insert("B_WRN_CHECK_STOCK.insert", record);
    }

    public void insertSelective(BWanCheckStock record) {
        getSqlMapClientTemplate().insert("B_WRN_CHECK_STOCK.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BWanCheckStock> selectByExample(BWanCheckStockExample example) {
        List<BWanCheckStock> list = getSqlMapClientTemplate().queryForList("B_WRN_CHECK_STOCK.selectByExample", example);
        return list;
    }

    public BWanCheckStock selectByPrimaryKey(String id) {
        BWanCheckStock _key = new BWanCheckStock();
        _key.setId(id);
        BWanCheckStock record = (BWanCheckStock) getSqlMapClientTemplate().queryForObject("B_WRN_CHECK_STOCK.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BWanCheckStock record, BWanCheckStockExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_CHECK_STOCK.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BWanCheckStock record, BWanCheckStockExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_CHECK_STOCK.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BWanCheckStock record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_CHECK_STOCK.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BWanCheckStock record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_CHECK_STOCK.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BWanCheckStock> selectByPage(BWanCheckStockExample example, Page page) {
        List<BWanCheckStock> list = this.searchListPageMyObject("B_WRN_CHECK_STOCK.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BWanCheckStockExample {
        private Object record;

        public UpdateByExampleParms(Object record, BWanCheckStockExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}