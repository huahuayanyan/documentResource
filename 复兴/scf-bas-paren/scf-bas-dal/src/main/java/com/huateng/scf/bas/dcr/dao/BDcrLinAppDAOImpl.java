package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.dcr.model.BDcrLinApp;
import com.huateng.scf.bas.dcr.model.BDcrLinAppExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BDcrLinAppDAO")
public class BDcrLinAppDAOImpl extends IbatisDaoAnnotation4Template implements BDcrLinAppDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BDcrLinAppDAOImpl() {
        super();
    }

    public int countByExample(BDcrLinAppExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_DCR_LIN_APP.countByExample", example);
        return count;
    }

    public int deleteByExample(BDcrLinAppExample example) {
        int rows = getSqlMapClientTemplate().delete("B_DCR_LIN_APP.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String appCrId) {
        BDcrLinApp _key = new BDcrLinApp();
        _key.setAppCrId(appCrId);
        int rows = getSqlMapClientTemplate().delete("B_DCR_LIN_APP.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BDcrLinApp record) {
        getSqlMapClientTemplate().insert("B_DCR_LIN_APP.insert", record);
    }

    public void insertSelective(BDcrLinApp record) {
        getSqlMapClientTemplate().insert("B_DCR_LIN_APP.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BDcrLinApp> selectByExample(BDcrLinAppExample example) {
        List<BDcrLinApp> list = getSqlMapClientTemplate().queryForList("B_DCR_LIN_APP.selectByExample", example);
        return list;
    }

    public BDcrLinApp selectByPrimaryKey(String appCrId) {
        BDcrLinApp _key = new BDcrLinApp();
        _key.setAppCrId(appCrId);
        BDcrLinApp record = (BDcrLinApp) getSqlMapClientTemplate().queryForObject("B_DCR_LIN_APP.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BDcrLinApp record, BDcrLinAppExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_APP.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BDcrLinApp record, BDcrLinAppExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_APP.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BDcrLinApp record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_APP.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BDcrLinApp record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_APP.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BDcrLinApp> selectByPage(BDcrLinAppExample example, Page page) {
        List<BDcrLinApp> list = this.searchListPageMyObject("B_DCR_LIN_APP.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BDcrLinAppExample {
        private Object record;

        public UpdateByExampleParms(Object record, BDcrLinAppExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}