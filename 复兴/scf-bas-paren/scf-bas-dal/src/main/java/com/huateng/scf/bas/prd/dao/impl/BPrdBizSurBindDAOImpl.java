package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdBizSurBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSurBindExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPrdBizSurBindDAO")
public class BPrdBizSurBindDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdBizSurBindDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdBizSurBindDAOImpl() {
        super();
    }

    public int countByExample(BPrdBizSurBindExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_BIZ_SUR_BIND.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdBizSurBindExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_BIZ_SUR_BIND.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdBizSurBind _key = new BPrdBizSurBind();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_BIZ_SUR_BIND.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdBizSurBind record) {
        getSqlMapClientTemplate().insert("B_PRD_BIZ_SUR_BIND.insert", record);
    }

    public void insertSelective(BPrdBizSurBind record) {
        getSqlMapClientTemplate().insert("B_PRD_BIZ_SUR_BIND.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdBizSurBind> selectByExample(BPrdBizSurBindExample example) {
        List<BPrdBizSurBind> list = getSqlMapClientTemplate().queryForList("B_PRD_BIZ_SUR_BIND.selectByExample", example);
        return list;
    }

    public BPrdBizSurBind selectByPrimaryKey(String id) {
        BPrdBizSurBind _key = new BPrdBizSurBind();
        _key.setId(id);
        BPrdBizSurBind record = (BPrdBizSurBind) getSqlMapClientTemplate().queryForObject("B_PRD_BIZ_SUR_BIND.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdBizSurBind record, BPrdBizSurBindExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_BIZ_SUR_BIND.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdBizSurBind record, BPrdBizSurBindExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_BIZ_SUR_BIND.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdBizSurBind record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_BIZ_SUR_BIND.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdBizSurBind record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_BIZ_SUR_BIND.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdBizSurBind> selectByPage(BPrdBizSurBindExample example, Page page) {
        List<BPrdBizSurBind> list = this.searchListPageMyObject("B_PRD_BIZ_SUR_BIND.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdBizSurBindExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdBizSurBindExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}