package com.huateng.scf.bas.brp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.brp.dao.IBBrpPrdFactoringDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.dao.model.BBrpPrdFactoringExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BBrpPrdFactoringDAO")
public class BBrpPrdFactoringDAOImpl extends IbatisDaoAnnotation4Template implements IBBrpPrdFactoringDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BBrpPrdFactoringDAOImpl() {
        super();
    }

    public int countByExample(BBrpPrdFactoringExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_BRP_PRD_FACTORING.countByExample", example);
        return count;
    }

    public int deleteByExample(BBrpPrdFactoringExample example) {
        int rows = getSqlMapClientTemplate().delete("B_BRP_PRD_FACTORING.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String productId) {
        BBrpPrdFactoring _key = new BBrpPrdFactoring();
        _key.setProductId(productId);
        int rows = getSqlMapClientTemplate().delete("B_BRP_PRD_FACTORING.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BBrpPrdFactoring record) {
        getSqlMapClientTemplate().insert("B_BRP_PRD_FACTORING.insert", record);
    }

    public void insertSelective(BBrpPrdFactoring record) {
        getSqlMapClientTemplate().insert("B_BRP_PRD_FACTORING.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BBrpPrdFactoring> selectByExample(BBrpPrdFactoringExample example) {
        List<BBrpPrdFactoring> list = getSqlMapClientTemplate().queryForList("B_BRP_PRD_FACTORING.selectByExample", example);
        return list;
    }

    public BBrpPrdFactoring selectByPrimaryKey(String productId) {
        BBrpPrdFactoring _key = new BBrpPrdFactoring();
        _key.setProductId(productId);
        BBrpPrdFactoring record = (BBrpPrdFactoring) getSqlMapClientTemplate().queryForObject("B_BRP_PRD_FACTORING.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BBrpPrdFactoring record, BBrpPrdFactoringExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_BRP_PRD_FACTORING.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BBrpPrdFactoring record, BBrpPrdFactoringExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_BRP_PRD_FACTORING.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BBrpPrdFactoring record) {
        int rows = getSqlMapClientTemplate().update("B_BRP_PRD_FACTORING.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BBrpPrdFactoring record) {
        int rows = getSqlMapClientTemplate().update("B_BRP_PRD_FACTORING.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BBrpPrdFactoring> selectByPage(BBrpPrdFactoringExample example, Page page) {
        List<BBrpPrdFactoring> list = this.searchListPageMyObject("B_BRP_PRD_FACTORING.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BBrpPrdFactoringExample {
        private Object record;

        public UpdateByExampleParms(Object record, BBrpPrdFactoringExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}