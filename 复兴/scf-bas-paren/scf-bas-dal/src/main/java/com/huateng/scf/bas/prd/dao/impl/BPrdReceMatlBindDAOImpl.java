package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdReceMatlBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBindExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPrdReceMatlBindDAO")
public class BPrdReceMatlBindDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdReceMatlBindDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdReceMatlBindDAOImpl() {
        super();
    }

    public int countByExample(BPrdReceMatlBindExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_RECE_MATL_BIND.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdReceMatlBindExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_RECE_MATL_BIND.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdReceMatlBind _key = new BPrdReceMatlBind();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_RECE_MATL_BIND.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdReceMatlBind record) {
        getSqlMapClientTemplate().insert("B_PRD_RECE_MATL_BIND.insert", record);
    }

    public void insertSelective(BPrdReceMatlBind record) {
        getSqlMapClientTemplate().insert("B_PRD_RECE_MATL_BIND.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdReceMatlBind> selectByExample(BPrdReceMatlBindExample example) {
        List<BPrdReceMatlBind> list = getSqlMapClientTemplate().queryForList("B_PRD_RECE_MATL_BIND.selectByExample", example);
        return list;
    }

    public BPrdReceMatlBind selectByPrimaryKey(String id) {
        BPrdReceMatlBind _key = new BPrdReceMatlBind();
        _key.setId(id);
        BPrdReceMatlBind record = (BPrdReceMatlBind) getSqlMapClientTemplate().queryForObject("B_PRD_RECE_MATL_BIND.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdReceMatlBind record, BPrdReceMatlBindExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_RECE_MATL_BIND.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdReceMatlBind record, BPrdReceMatlBindExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_RECE_MATL_BIND.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdReceMatlBind record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_RECE_MATL_BIND.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdReceMatlBind record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_RECE_MATL_BIND.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdReceMatlBind> selectByPage(BPrdReceMatlBindExample example, Page page) {
        List<BPrdReceMatlBind> list = this.searchListPageMyObject("B_PRD_RECE_MATL_BIND.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdReceMatlBindExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdReceMatlBindExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}