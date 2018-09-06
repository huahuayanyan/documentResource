package com.huateng.scf.nrec.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nrec.bcp.dao.IRBcpDuebillRegisterDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillRegister;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillRegisterExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IRBcpDuebillRegisterDAO")
public class RBcpDuebillRegisterDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpDuebillRegisterDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public RBcpDuebillRegisterDAOImpl() {
        super();
    }

    public int countByExample(RBcpDuebillRegisterExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("R_BCP_DUEBILL_REGISTER.countByExample", example);
        return count;
    }

    public int deleteByExample(RBcpDuebillRegisterExample example) {
        int rows = getSqlMapClientTemplate().delete("R_BCP_DUEBILL_REGISTER.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        RBcpDuebillRegister _key = new RBcpDuebillRegister();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("R_BCP_DUEBILL_REGISTER.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RBcpDuebillRegister record) {
        getSqlMapClientTemplate().insert("R_BCP_DUEBILL_REGISTER.insert", record);
    }

    public void insertSelective(RBcpDuebillRegister record) {
        getSqlMapClientTemplate().insert("R_BCP_DUEBILL_REGISTER.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RBcpDuebillRegister> selectByExample(RBcpDuebillRegisterExample example) {
        List<RBcpDuebillRegister> list = getSqlMapClientTemplate().queryForList("R_BCP_DUEBILL_REGISTER.selectByExample", example);
        return list;
    }

    public RBcpDuebillRegister selectByPrimaryKey(String id) {
        RBcpDuebillRegister _key = new RBcpDuebillRegister();
        _key.setId(id);
        RBcpDuebillRegister record = (RBcpDuebillRegister) getSqlMapClientTemplate().queryForObject("R_BCP_DUEBILL_REGISTER.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RBcpDuebillRegister record, RBcpDuebillRegisterExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_DUEBILL_REGISTER.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RBcpDuebillRegister record, RBcpDuebillRegisterExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_DUEBILL_REGISTER.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RBcpDuebillRegister record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_DUEBILL_REGISTER.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RBcpDuebillRegister record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_DUEBILL_REGISTER.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<RBcpDuebillRegister> selectByPage(RBcpDuebillRegisterExample example, Page page) {
        List<RBcpDuebillRegister> list = this.searchListPageMyObject("R_BCP_DUEBILL_REGISTER.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends RBcpDuebillRegisterExample {
        private Object record;

        public UpdateByExampleParms(Object record, RBcpDuebillRegisterExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}