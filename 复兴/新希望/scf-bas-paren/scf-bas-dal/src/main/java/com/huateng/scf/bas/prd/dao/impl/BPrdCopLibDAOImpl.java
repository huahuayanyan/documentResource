package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdCopLibDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLib;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLibExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPrdCopLibDAO")
public class BPrdCopLibDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdCopLibDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdCopLibDAOImpl() {
        super();
    }

    public int countByExample(BPrdCopLibExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_COP_LIB.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdCopLibExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_COP_LIB.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdCopLib _key = new BPrdCopLib();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_COP_LIB.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdCopLib record) {
        getSqlMapClientTemplate().insert("B_PRD_COP_LIB.insert", record);
    }

    public void insertSelective(BPrdCopLib record) {
        getSqlMapClientTemplate().insert("B_PRD_COP_LIB.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdCopLib> selectByExample(BPrdCopLibExample example) {
        List<BPrdCopLib> list = getSqlMapClientTemplate().queryForList("B_PRD_COP_LIB.selectByExample", example);
        return list;
    }

    public BPrdCopLib selectByPrimaryKey(String id) {
        BPrdCopLib _key = new BPrdCopLib();
        _key.setId(id);
        BPrdCopLib record = (BPrdCopLib) getSqlMapClientTemplate().queryForObject("B_PRD_COP_LIB.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdCopLib record, BPrdCopLibExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_COP_LIB.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdCopLib record, BPrdCopLibExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_COP_LIB.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdCopLib record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_COP_LIB.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdCopLib record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_COP_LIB.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdCopLib> selectByPage(BPrdCopLibExample example, Page page) {
        List<BPrdCopLib> list = this.searchListPageMyObject("B_PRD_COP_LIB.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdCopLibExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdCopLibExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}