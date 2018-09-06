package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdBcopDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdBcop;
import com.huateng.scf.bas.prd.dao.model.BPrdBcopExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPrdBcopDAO")
public class BPrdBcopDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdBcopDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdBcopDAOImpl() {
        super();
    }

    public int countByExample(BPrdBcopExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_BCOP.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdBcopExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_BCOP.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdBcop _key = new BPrdBcop();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_BCOP.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdBcop record) {
        getSqlMapClientTemplate().insert("B_PRD_BCOP.insert", record);
    }

    public void insertSelective(BPrdBcop record) {
        getSqlMapClientTemplate().insert("B_PRD_BCOP.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdBcop> selectByExample(BPrdBcopExample example) {
        List<BPrdBcop> list = getSqlMapClientTemplate().queryForList("B_PRD_BCOP.selectByExample", example);
        return list;
    }

    public BPrdBcop selectByPrimaryKey(String id) {
        BPrdBcop _key = new BPrdBcop();
        _key.setId(id);
        BPrdBcop record = (BPrdBcop) getSqlMapClientTemplate().queryForObject("B_PRD_BCOP.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdBcop record, BPrdBcopExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_BCOP.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdBcop record, BPrdBcopExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_BCOP.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdBcop record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_BCOP.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdBcop record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_BCOP.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdBcop> selectByPage(BPrdBcopExample example, Page page) {
        List<BPrdBcop> list = this.searchListPageMyObject("B_PRD_BCOP.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdBcopExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdBcopExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //批量删除
    @Override
	public int batchDelete(List<String> idList) {

		return getSqlMapClientTemplate().delete("B_PRD_BCOP.batchDelete", idList);
	}
}