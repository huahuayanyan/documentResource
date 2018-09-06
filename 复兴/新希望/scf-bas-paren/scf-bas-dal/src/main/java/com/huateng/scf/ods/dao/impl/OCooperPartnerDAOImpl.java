package com.huateng.scf.ods.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.ods.dao.IOCooperPartnerDAO;
import com.huateng.scf.ods.dao.model.OCooperPartner;
import com.huateng.scf.ods.dao.model.OCooperPartnerExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("OCooperPartnerDAO")
public class OCooperPartnerDAOImpl extends IbatisDaoAnnotation4Template implements IOCooperPartnerDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public OCooperPartnerDAOImpl() {
        super();
    }

    public int countByExample(OCooperPartnerExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ODS_COOPER_PARTNER.countByExample", example);
        return count;
    }

    public int deleteByExample(OCooperPartnerExample example) {
        int rows = getSqlMapClientTemplate().delete("ODS_COOPER_PARTNER.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        OCooperPartner _key = new OCooperPartner();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ODS_COOPER_PARTNER.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(OCooperPartner record) {
        getSqlMapClientTemplate().insert("ODS_COOPER_PARTNER.insert", record);
    }

    public void insertSelective(OCooperPartner record) {
        getSqlMapClientTemplate().insert("ODS_COOPER_PARTNER.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<OCooperPartner> selectByExample(OCooperPartnerExample example) {
        List<OCooperPartner> list = getSqlMapClientTemplate().queryForList("ODS_COOPER_PARTNER.selectByExample", example);
        return list;
    }

    public OCooperPartner selectByPrimaryKey(String id) {
        OCooperPartner _key = new OCooperPartner();
        _key.setId(id);
        OCooperPartner record = (OCooperPartner) getSqlMapClientTemplate().queryForObject("ODS_COOPER_PARTNER.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(OCooperPartner record, OCooperPartnerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_COOPER_PARTNER.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(OCooperPartner record, OCooperPartnerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_COOPER_PARTNER.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(OCooperPartner record) {
        int rows = getSqlMapClientTemplate().update("ODS_COOPER_PARTNER.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(OCooperPartner record) {
        int rows = getSqlMapClientTemplate().update("ODS_COOPER_PARTNER.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<OCooperPartner> selectByPage(OCooperPartnerExample example, Page page) {
        List<OCooperPartner> list = this.searchListPageMyObject("ODS_COOPER_PARTNER.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends OCooperPartnerExample {
        private Object record;

        public UpdateByExampleParms(Object record, OCooperPartnerExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}