package com.huateng.scf.nrec.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nrec.bcp.dao.IRBcpDuebillAppDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillApp;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillAppExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IRBcpDuebillAppDAO")
public class RBcpDuebillAppDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpDuebillAppDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public RBcpDuebillAppDAOImpl() {
        super();
    }

    public int countByExample(RBcpDuebillAppExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("R_BCP_DUEBILL_APP.countByExample", example);
        return count;
    }

    public int deleteByExample(RBcpDuebillAppExample example) {
        int rows = getSqlMapClientTemplate().delete("R_BCP_DUEBILL_APP.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String appno) {
        RBcpDuebillApp _key = new RBcpDuebillApp();
        _key.setAppno(appno);
        int rows = getSqlMapClientTemplate().delete("R_BCP_DUEBILL_APP.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RBcpDuebillApp record) {
        getSqlMapClientTemplate().insert("R_BCP_DUEBILL_APP.insert", record);
    }

    public void insertSelective(RBcpDuebillApp record) {
        getSqlMapClientTemplate().insert("R_BCP_DUEBILL_APP.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RBcpDuebillApp> selectByExample(RBcpDuebillAppExample example) {
        List<RBcpDuebillApp> list = getSqlMapClientTemplate().queryForList("R_BCP_DUEBILL_APP.selectByExample", example);
        return list;
    }

    public RBcpDuebillApp selectByPrimaryKey(String appno) {
        RBcpDuebillApp _key = new RBcpDuebillApp();
        _key.setAppno(appno);
        RBcpDuebillApp record = (RBcpDuebillApp) getSqlMapClientTemplate().queryForObject("R_BCP_DUEBILL_APP.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RBcpDuebillApp record, RBcpDuebillAppExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_DUEBILL_APP.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RBcpDuebillApp record, RBcpDuebillAppExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_DUEBILL_APP.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RBcpDuebillApp record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_DUEBILL_APP.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RBcpDuebillApp record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_DUEBILL_APP.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<RBcpDuebillApp> selectByPage(RBcpDuebillAppExample example, Page page) {
        List<RBcpDuebillApp> list = this.searchListPageMyObject("R_BCP_DUEBILL_APP.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends RBcpDuebillAppExample {
        private Object record;

        public UpdateByExampleParms(Object record, RBcpDuebillAppExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}