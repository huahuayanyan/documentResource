package com.huateng.scf.bas.pbc.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgClassDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClassExample;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPbcMtgClassDAO")
public class BPbcMtgClassDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcMtgClassDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcMtgClassDAOImpl() {
        super();
    }

    public int countByExample(BPbcMtgClassExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_MTG_CLASS.countByExample", example);
        return count;
    }

    public int deleteByExample(BPbcMtgClassExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_CLASS.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(BigDecimal mortgageCode) {
        BPbcMtgClass _key = new BPbcMtgClass();
        _key.setMortgageCode(mortgageCode);
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_CLASS.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcMtgClass record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_CLASS.insert", record);
    }

    public void insertSelective(BPbcMtgClass record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_CLASS.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgClass> selectByExample(BPbcMtgClassExample example) {
        List<BPbcMtgClass> list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_CLASS.selectByExample", example);
        return list;
    }

    public BPbcMtgClass selectByPrimaryKey(BigDecimal mortgageCode) {
        BPbcMtgClass _key = new BPbcMtgClass();
        _key.setMortgageCode(mortgageCode);
        BPbcMtgClass record = (BPbcMtgClass) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_CLASS.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcMtgClass record, BPbcMtgClassExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CLASS.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcMtgClass record, BPbcMtgClassExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CLASS.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcMtgClass record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CLASS.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcMtgClass record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_CLASS.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgClass> selectByPage(BPbcMtgClassExample example, Page page) {
        List<BPbcMtgClass> list = this.searchListPageMyObject("B_PBC_MTG_CLASS.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcMtgClassExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcMtgClassExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}