package com.huateng.scf.bas.pbc.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliOrderBussInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliOrderBussInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliOrderBussInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBPbcAppliOrderBussInfoDAO")
public class BPbcAppliOrderBussInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcAppliOrderBussInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcAppliOrderBussInfoDAOImpl() {
        super();
    }

    public int countByExample(BPbcAppliOrderBussInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_APPLI_ORDER_BUSS_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BPbcAppliOrderBussInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_APPLI_ORDER_BUSS_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPbcAppliOrderBussInfo _key = new BPbcAppliOrderBussInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PBC_APPLI_ORDER_BUSS_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcAppliOrderBussInfo record) {
        getSqlMapClientTemplate().insert("B_PBC_APPLI_ORDER_BUSS_INFO.insert", record);
    }

    public void insertSelective(BPbcAppliOrderBussInfo record) {
        getSqlMapClientTemplate().insert("B_PBC_APPLI_ORDER_BUSS_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcAppliOrderBussInfo> selectByExample(BPbcAppliOrderBussInfoExample example) {
        List<BPbcAppliOrderBussInfo> list = getSqlMapClientTemplate().queryForList("B_PBC_APPLI_ORDER_BUSS_INFO.selectByExample", example);
        return list;
    }

    public BPbcAppliOrderBussInfo selectByPrimaryKey(String id) {
        BPbcAppliOrderBussInfo _key = new BPbcAppliOrderBussInfo();
        _key.setId(id);
        BPbcAppliOrderBussInfo record = (BPbcAppliOrderBussInfo) getSqlMapClientTemplate().queryForObject("B_PBC_APPLI_ORDER_BUSS_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcAppliOrderBussInfo record, BPbcAppliOrderBussInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_ORDER_BUSS_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcAppliOrderBussInfo record, BPbcAppliOrderBussInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_ORDER_BUSS_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcAppliOrderBussInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_ORDER_BUSS_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcAppliOrderBussInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_ORDER_BUSS_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcAppliOrderBussInfo> selectByPage(BPbcAppliOrderBussInfoExample example, Page page) {
        List<BPbcAppliOrderBussInfo> list = this.searchListPageMyObject("B_PBC_APPLI_ORDER_BUSS_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcAppliOrderBussInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcAppliOrderBussInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}