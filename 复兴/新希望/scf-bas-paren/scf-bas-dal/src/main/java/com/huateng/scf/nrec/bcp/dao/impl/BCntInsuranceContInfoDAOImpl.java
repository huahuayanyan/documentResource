package com.huateng.scf.nrec.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nrec.bcp.dao.IBCntInsuranceContInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntInsuranceContInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntInsuranceContInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBCntInsuranceContInfoDAO")
public class BCntInsuranceContInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntInsuranceContInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntInsuranceContInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntInsuranceContInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_INSURANCE_CONT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntInsuranceContInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_INSURANCE_CONT_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String insuranceNo) {
        BCntInsuranceContInfo _key = new BCntInsuranceContInfo();
        _key.setInsuranceNo(insuranceNo);
        int rows = getSqlMapClientTemplate().delete("B_CNT_INSURANCE_CONT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntInsuranceContInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_INSURANCE_CONT_INFO.insert", record);
    }

    public void insertSelective(BCntInsuranceContInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_INSURANCE_CONT_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntInsuranceContInfo> selectByExample(BCntInsuranceContInfoExample example) {
        List<BCntInsuranceContInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_INSURANCE_CONT_INFO.selectByExample", example);
        return list;
    }

    public BCntInsuranceContInfo selectByPrimaryKey(String insuranceNo) {
        BCntInsuranceContInfo _key = new BCntInsuranceContInfo();
        _key.setInsuranceNo(insuranceNo);
        BCntInsuranceContInfo record = (BCntInsuranceContInfo) getSqlMapClientTemplate().queryForObject("B_CNT_INSURANCE_CONT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntInsuranceContInfo record, BCntInsuranceContInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_INSURANCE_CONT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntInsuranceContInfo record, BCntInsuranceContInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_INSURANCE_CONT_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntInsuranceContInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_INSURANCE_CONT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntInsuranceContInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_INSURANCE_CONT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntInsuranceContInfo> selectByPage(BCntInsuranceContInfoExample example, Page page) {
        List<BCntInsuranceContInfo> list = this.searchListPageMyObject("B_CNT_INSURANCE_CONT_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntInsuranceContInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntInsuranceContInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}