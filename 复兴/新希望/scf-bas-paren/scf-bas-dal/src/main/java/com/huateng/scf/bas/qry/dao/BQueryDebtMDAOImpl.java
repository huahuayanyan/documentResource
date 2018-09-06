package com.huateng.scf.bas.qry.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.qry.dao.model.BQueryDebtM;
import com.huateng.scf.bas.qry.dao.model.BQueryDebtMExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BQueryDebtMDAO")
public class BQueryDebtMDAOImpl extends IbatisDaoAnnotation4Template implements IBQueryDebtMDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BQueryDebtMDAOImpl() {
        super();
    }

    public int countByExample(BQueryDebtMExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_QUERY_DEBT_M.countByExample", example);
        return count;
    }

    public int deleteByExample(BQueryDebtMExample example) {
        int rows = getSqlMapClientTemplate().delete("B_QUERY_DEBT_M.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BQueryDebtM _key = new BQueryDebtM();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_QUERY_DEBT_M.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BQueryDebtM record) {
        getSqlMapClientTemplate().insert("B_QUERY_DEBT_M.insert", record);
    }

    public void insertSelective(BQueryDebtM record) {
        getSqlMapClientTemplate().insert("B_QUERY_DEBT_M.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BQueryDebtM> selectByExample(BQueryDebtMExample example) {
        List<BQueryDebtM> list = getSqlMapClientTemplate().queryForList("B_QUERY_DEBT_M.selectByExample", example);
        return list;
    }

    public BQueryDebtM selectByPrimaryKey(String id) {
        BQueryDebtM _key = new BQueryDebtM();
        _key.setId(id);
        BQueryDebtM record = (BQueryDebtM) getSqlMapClientTemplate().queryForObject("B_QUERY_DEBT_M.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BQueryDebtM record, BQueryDebtMExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_QUERY_DEBT_M.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BQueryDebtM record, BQueryDebtMExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_QUERY_DEBT_M.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BQueryDebtM record) {
        int rows = getSqlMapClientTemplate().update("B_QUERY_DEBT_M.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BQueryDebtM record) {
        int rows = getSqlMapClientTemplate().update("B_QUERY_DEBT_M.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BQueryDebtM> selectByPage(BQueryDebtMExample example, Page page) {
        List<BQueryDebtM> list = this.searchListPageMyObject("B_QUERY_DEBT_M.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BQueryDebtMExample {
        private Object record;

        public UpdateByExampleParms(Object record, BQueryDebtMExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}