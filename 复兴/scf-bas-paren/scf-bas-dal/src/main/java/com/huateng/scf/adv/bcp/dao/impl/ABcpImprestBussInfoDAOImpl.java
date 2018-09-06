package com.huateng.scf.adv.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.bcp.dao.IABcpImprestBussInfoDAO;
import com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfo;
import com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("ABcpImprestBussInfoDAO")
public class ABcpImprestBussInfoDAOImpl extends IbatisDaoAnnotation4Template implements IABcpImprestBussInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public ABcpImprestBussInfoDAOImpl() {
        super();
    }

    public int countByExample(ABcpImprestBussInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("A_BCP_IMPREST_BUSS_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(ABcpImprestBussInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("A_BCP_IMPREST_BUSS_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        ABcpImprestBussInfo _key = new ABcpImprestBussInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("A_BCP_IMPREST_BUSS_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(ABcpImprestBussInfo record) {
        getSqlMapClientTemplate().insert("A_BCP_IMPREST_BUSS_INFO.insert", record);
    }

    public void insertSelective(ABcpImprestBussInfo record) {
        getSqlMapClientTemplate().insert("A_BCP_IMPREST_BUSS_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<ABcpImprestBussInfo> selectByExample(ABcpImprestBussInfoExample example) {
        List<ABcpImprestBussInfo> list = getSqlMapClientTemplate().queryForList("A_BCP_IMPREST_BUSS_INFO.selectByExample", example);
        return list;
    }

    public ABcpImprestBussInfo selectByPrimaryKey(String id) {
        ABcpImprestBussInfo _key = new ABcpImprestBussInfo();
        _key.setId(id);
        ABcpImprestBussInfo record = (ABcpImprestBussInfo) getSqlMapClientTemplate().queryForObject("A_BCP_IMPREST_BUSS_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(ABcpImprestBussInfo record, ABcpImprestBussInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("A_BCP_IMPREST_BUSS_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(ABcpImprestBussInfo record, ABcpImprestBussInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("A_BCP_IMPREST_BUSS_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(ABcpImprestBussInfo record) {
        int rows = getSqlMapClientTemplate().update("A_BCP_IMPREST_BUSS_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(ABcpImprestBussInfo record) {
        int rows = getSqlMapClientTemplate().update("A_BCP_IMPREST_BUSS_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<ABcpImprestBussInfo> selectByPage(ABcpImprestBussInfoExample example, Page page) {
        List<ABcpImprestBussInfo> list = this.searchListPageMyObject("A_BCP_IMPREST_BUSS_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends ABcpImprestBussInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, ABcpImprestBussInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}