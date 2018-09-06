package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdBaseInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdBaseInfo;
import com.huateng.scf.bas.prd.dao.model.BPrdBaseInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPrdBaseInfoDAO")
public class BPrdBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdBaseInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdBaseInfoDAOImpl() {
        super();
    }

    public int countByExample(BPrdBaseInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_BASE_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdBaseInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_BASE_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String productId) {
        BPrdBaseInfo _key = new BPrdBaseInfo();
        _key.setProductId(productId);
        int rows = getSqlMapClientTemplate().delete("B_PRD_BASE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdBaseInfo record) {
        getSqlMapClientTemplate().insert("B_PRD_BASE_INFO.insert", record);
    }

    public void insertSelective(BPrdBaseInfo record) {
        getSqlMapClientTemplate().insert("B_PRD_BASE_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdBaseInfo> selectByExample(BPrdBaseInfoExample example) {
        List<BPrdBaseInfo> list = getSqlMapClientTemplate().queryForList("B_PRD_BASE_INFO.selectByExample", example);
        return list;
    }

    public BPrdBaseInfo selectByPrimaryKey(String productId) {
        BPrdBaseInfo _key = new BPrdBaseInfo();
        _key.setProductId(productId);
        BPrdBaseInfo record = (BPrdBaseInfo) getSqlMapClientTemplate().queryForObject("B_PRD_BASE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdBaseInfo record, BPrdBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_BASE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdBaseInfo record, BPrdBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_BASE_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_BASE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_BASE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdBaseInfo> selectByPage(BPrdBaseInfoExample example, Page page) {
        List<BPrdBaseInfo> list = this.searchListPageMyObject("B_PRD_BASE_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdBaseInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdBaseInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}