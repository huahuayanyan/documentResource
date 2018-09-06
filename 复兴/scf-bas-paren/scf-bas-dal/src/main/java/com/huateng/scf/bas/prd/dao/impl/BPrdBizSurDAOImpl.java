package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdBizSurDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSur;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSurExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPrdBizSurDAO")
public class BPrdBizSurDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdBizSurDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdBizSurDAOImpl() {
        super();
    }

    public int countByExample(BPrdBizSurExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_BIZ_SUR.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdBizSurExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_BIZ_SUR.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdBizSur _key = new BPrdBizSur();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_BIZ_SUR.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdBizSur record) {
        getSqlMapClientTemplate().insert("B_PRD_BIZ_SUR.insert", record);
    }

    public void insertSelective(BPrdBizSur record) {
        getSqlMapClientTemplate().insert("B_PRD_BIZ_SUR.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdBizSur> selectByExample(BPrdBizSurExample example) {
        List<BPrdBizSur> list = getSqlMapClientTemplate().queryForList("B_PRD_BIZ_SUR.selectByExample", example);
        return list;
    }

    public BPrdBizSur selectByPrimaryKey(String id) {
        BPrdBizSur _key = new BPrdBizSur();
        _key.setId(id);
        BPrdBizSur record = (BPrdBizSur) getSqlMapClientTemplate().queryForObject("B_PRD_BIZ_SUR.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdBizSur record, BPrdBizSurExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_BIZ_SUR.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdBizSur record, BPrdBizSurExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_BIZ_SUR.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdBizSur record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_BIZ_SUR.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdBizSur record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_BIZ_SUR.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdBizSur> selectByPage(BPrdBizSurExample example, Page page) {
        List<BPrdBizSur> list = this.searchListPageMyObject("B_PRD_BIZ_SUR.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdBizSurExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdBizSurExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

}