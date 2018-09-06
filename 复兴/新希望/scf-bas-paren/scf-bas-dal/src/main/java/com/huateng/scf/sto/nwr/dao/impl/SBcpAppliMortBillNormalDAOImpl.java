package com.huateng.scf.sto.nwr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.sto.nwr.dao.ISBcpAppliMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormalExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("ISBcpAppliMortBillNormalDAO")
public class SBcpAppliMortBillNormalDAOImpl extends IbatisDaoAnnotation4Template implements ISBcpAppliMortBillNormalDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public SBcpAppliMortBillNormalDAOImpl() {
        super();
    }

    public int countByExample(SBcpAppliMortBillNormalExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("S_BCP_APPLI_MORT_BILL_NORMAL.countByExample", example);
        return count;
    }

    public int deleteByExample(SBcpAppliMortBillNormalExample example) {
        int rows = getSqlMapClientTemplate().delete("S_BCP_APPLI_MORT_BILL_NORMAL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        SBcpAppliMortBillNormal _key = new SBcpAppliMortBillNormal();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("S_BCP_APPLI_MORT_BILL_NORMAL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SBcpAppliMortBillNormal record) {
        getSqlMapClientTemplate().insert("S_BCP_APPLI_MORT_BILL_NORMAL.insert", record);
    }

    public void insertSelective(SBcpAppliMortBillNormal record) {
        getSqlMapClientTemplate().insert("S_BCP_APPLI_MORT_BILL_NORMAL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<SBcpAppliMortBillNormal> selectByExample(SBcpAppliMortBillNormalExample example) {
        List<SBcpAppliMortBillNormal> list = getSqlMapClientTemplate().queryForList("S_BCP_APPLI_MORT_BILL_NORMAL.selectByExample", example);
        return list;
    }

    public SBcpAppliMortBillNormal selectByPrimaryKey(String id) {
        SBcpAppliMortBillNormal _key = new SBcpAppliMortBillNormal();
        _key.setId(id);
        SBcpAppliMortBillNormal record = (SBcpAppliMortBillNormal) getSqlMapClientTemplate().queryForObject("S_BCP_APPLI_MORT_BILL_NORMAL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(SBcpAppliMortBillNormal record, SBcpAppliMortBillNormalExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_MORT_BILL_NORMAL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(SBcpAppliMortBillNormal record, SBcpAppliMortBillNormalExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_MORT_BILL_NORMAL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(SBcpAppliMortBillNormal record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_MORT_BILL_NORMAL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SBcpAppliMortBillNormal record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_MORT_BILL_NORMAL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<SBcpAppliMortBillNormal> selectByPage(SBcpAppliMortBillNormalExample example, Page page) {
        List<SBcpAppliMortBillNormal> list = this.searchListPageMyObject("S_BCP_APPLI_MORT_BILL_NORMAL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends SBcpAppliMortBillNormalExample {
        private Object record;

        public UpdateByExampleParms(Object record, SBcpAppliMortBillNormalExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}