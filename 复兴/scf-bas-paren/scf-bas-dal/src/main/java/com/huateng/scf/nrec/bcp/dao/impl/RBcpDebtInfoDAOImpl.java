package com.huateng.scf.nrec.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IRBcpDebtInfoDAO")
public class RBcpDebtInfoDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpDebtInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public RBcpDebtInfoDAOImpl() {
        super();
    }

    public int countByExample(RBcpDebtInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(RBcpDebtInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("R_BCP_DEBT_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        RBcpDebtInfo _key = new RBcpDebtInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("R_BCP_DEBT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RBcpDebtInfo record) {
        getSqlMapClientTemplate().insert("R_BCP_DEBT_INFO.insert", record);
    }

    public void insertSelective(RBcpDebtInfo record) {
        getSqlMapClientTemplate().insert("R_BCP_DEBT_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RBcpDebtInfo> selectByExample(RBcpDebtInfoExample example) {
        List<RBcpDebtInfo> list = getSqlMapClientTemplate().queryForList("R_BCP_DEBT_INFO.selectByExample", example);
        return list;
    }

    public RBcpDebtInfo selectByPrimaryKey(String id) {
        RBcpDebtInfo _key = new RBcpDebtInfo();
        _key.setId(id);
        RBcpDebtInfo record = (RBcpDebtInfo) getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RBcpDebtInfo record, RBcpDebtInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RBcpDebtInfo record, RBcpDebtInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RBcpDebtInfo record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RBcpDebtInfo record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<RBcpDebtInfo> selectByPage(RBcpDebtInfoExample example, Page page) {
        List<RBcpDebtInfo> list = this.searchListPageMyObject("R_BCP_DEBT_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends RBcpDebtInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, RBcpDebtInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}