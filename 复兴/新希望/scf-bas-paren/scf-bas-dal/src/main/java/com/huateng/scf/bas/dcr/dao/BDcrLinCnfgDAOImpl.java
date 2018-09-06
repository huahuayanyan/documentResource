package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.dcr.model.BDcrLinCnfg;
import com.huateng.scf.bas.dcr.model.BDcrLinCnfgExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BDcrLinCnfgDAO")
public class BDcrLinCnfgDAOImpl extends IbatisDaoAnnotation4Template implements BDcrLinCnfgDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BDcrLinCnfgDAOImpl() {
        super();
    }

    public int countByExample(BDcrLinCnfgExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_DCR_LIN_CNFG.countByExample", example);
        return count;
    }

    public int deleteByExample(BDcrLinCnfgExample example) {
        int rows = getSqlMapClientTemplate().delete("B_DCR_LIN_CNFG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String typId) {
        BDcrLinCnfg _key = new BDcrLinCnfg();
        _key.setTypId(typId);
        int rows = getSqlMapClientTemplate().delete("B_DCR_LIN_CNFG.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BDcrLinCnfg record) {
        getSqlMapClientTemplate().insert("B_DCR_LIN_CNFG.insert", record);
    }

    public void insertSelective(BDcrLinCnfg record) {
        getSqlMapClientTemplate().insert("B_DCR_LIN_CNFG.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BDcrLinCnfg> selectByExample(BDcrLinCnfgExample example) {
        List<BDcrLinCnfg> list = getSqlMapClientTemplate().queryForList("B_DCR_LIN_CNFG.selectByExample", example);
        return list;
    }

    public BDcrLinCnfg selectByPrimaryKey(String typId) {
        BDcrLinCnfg _key = new BDcrLinCnfg();
        _key.setTypId(typId);
        BDcrLinCnfg record = (BDcrLinCnfg) getSqlMapClientTemplate().queryForObject("B_DCR_LIN_CNFG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BDcrLinCnfg record, BDcrLinCnfgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_CNFG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BDcrLinCnfg record, BDcrLinCnfgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_CNFG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BDcrLinCnfg record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_CNFG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BDcrLinCnfg record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_CNFG.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BDcrLinCnfg> selectByPage(BDcrLinCnfgExample example, Page page) {
        List<BDcrLinCnfg> list = this.searchListPageMyObject("B_DCR_LIN_CNFG.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BDcrLinCnfgExample {
        private Object record;

        public UpdateByExampleParms(Object record, BDcrLinCnfgExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}