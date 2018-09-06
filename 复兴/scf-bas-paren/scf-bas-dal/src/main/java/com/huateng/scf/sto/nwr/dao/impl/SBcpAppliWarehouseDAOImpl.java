package com.huateng.scf.sto.nwr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.sto.nwr.dao.ISBcpAppliWarehouseDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliWarehouse;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliWarehouseExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("ISBcpAppliWarehouseDAO")
public class SBcpAppliWarehouseDAOImpl extends IbatisDaoAnnotation4Template implements ISBcpAppliWarehouseDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public SBcpAppliWarehouseDAOImpl() {
        super();
    }

    public int countByExample(SBcpAppliWarehouseExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("S_BCP_APPLI_WAREHOUSE.countByExample", example);
        return count;
    }

    public int deleteByExample(SBcpAppliWarehouseExample example) {
        int rows = getSqlMapClientTemplate().delete("S_BCP_APPLI_WAREHOUSE.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String appno) {
        SBcpAppliWarehouse _key = new SBcpAppliWarehouse();
        _key.setAppno(appno);
        int rows = getSqlMapClientTemplate().delete("S_BCP_APPLI_WAREHOUSE.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SBcpAppliWarehouse record) {
        getSqlMapClientTemplate().insert("S_BCP_APPLI_WAREHOUSE.insert", record);
    }

    public void insertSelective(SBcpAppliWarehouse record) {
        getSqlMapClientTemplate().insert("S_BCP_APPLI_WAREHOUSE.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<SBcpAppliWarehouse> selectByExample(SBcpAppliWarehouseExample example) {
        List<SBcpAppliWarehouse> list = getSqlMapClientTemplate().queryForList("S_BCP_APPLI_WAREHOUSE.selectByExample", example);
        return list;
    }

    public SBcpAppliWarehouse selectByPrimaryKey(String appno) {
        SBcpAppliWarehouse _key = new SBcpAppliWarehouse();
        _key.setAppno(appno);
        SBcpAppliWarehouse record = (SBcpAppliWarehouse) getSqlMapClientTemplate().queryForObject("S_BCP_APPLI_WAREHOUSE.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(SBcpAppliWarehouse record, SBcpAppliWarehouseExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_WAREHOUSE.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(SBcpAppliWarehouse record, SBcpAppliWarehouseExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_WAREHOUSE.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(SBcpAppliWarehouse record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_WAREHOUSE.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SBcpAppliWarehouse record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_WAREHOUSE.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<SBcpAppliWarehouse> selectByPage(SBcpAppliWarehouseExample example, Page page) {
        List<SBcpAppliWarehouse> list = this.searchListPageMyObject("S_BCP_APPLI_WAREHOUSE.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends SBcpAppliWarehouseExample {
        private Object record;

        public UpdateByExampleParms(Object record, SBcpAppliWarehouseExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}