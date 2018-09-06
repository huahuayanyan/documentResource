package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdCopLibBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLibBindExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPrdCopLibBindDAO")
public class BPrdCopLibBindDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdCopLibBindDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdCopLibBindDAOImpl() {
        super();
    }

    public int countByExample(BPrdCopLibBindExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_COP_LIB_BIND.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdCopLibBindExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_COP_LIB_BIND.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdCopLibBind _key = new BPrdCopLibBind();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_COP_LIB_BIND.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdCopLibBind record) {
        getSqlMapClientTemplate().insert("B_PRD_COP_LIB_BIND.insert", record);
    }

    public void insertSelective(BPrdCopLibBind record) {
        getSqlMapClientTemplate().insert("B_PRD_COP_LIB_BIND.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdCopLibBind> selectByExample(BPrdCopLibBindExample example) {
        List<BPrdCopLibBind> list = getSqlMapClientTemplate().queryForList("B_PRD_COP_LIB_BIND.selectByExample", example);
        return list;
    }

    public BPrdCopLibBind selectByPrimaryKey(String id) {
        BPrdCopLibBind _key = new BPrdCopLibBind();
        _key.setId(id);
        BPrdCopLibBind record = (BPrdCopLibBind) getSqlMapClientTemplate().queryForObject("B_PRD_COP_LIB_BIND.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdCopLibBind record, BPrdCopLibBindExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_COP_LIB_BIND.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdCopLibBind record, BPrdCopLibBindExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_COP_LIB_BIND.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdCopLibBind record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_COP_LIB_BIND.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdCopLibBind record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_COP_LIB_BIND.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdCopLibBind> selectByPage(BPrdCopLibBindExample example, Page page) {
        List<BPrdCopLibBind> list = this.searchListPageMyObject("B_PRD_COP_LIB_BIND.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdCopLibBindExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdCopLibBindExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}