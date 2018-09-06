package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.prd.dao.model.BPrdInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BPrdInfoDAO")
public class BPrdInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdInfoDAOImpl() {
        super();
    }

    public int countByExample(BPrdInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String productId) {
        BPrdInfo _key = new BPrdInfo();
        _key.setProductId(productId);
        int rows = getSqlMapClientTemplate().delete("B_PRD_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdInfo record) {
        getSqlMapClientTemplate().insert("B_PRD_INFO.insert", record);
    }

    public void insertSelective(BPrdInfo record) {
        getSqlMapClientTemplate().insert("B_PRD_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdInfo> selectByExample(BPrdInfoExample example) {
        List<BPrdInfo> list = getSqlMapClientTemplate().queryForList("B_PRD_INFO.selectByExample", example);
        return list;
    }

    public BPrdInfo selectByPrimaryKey(String productId) {
        BPrdInfo _key = new BPrdInfo();
        _key.setProductId(productId);
        BPrdInfo record = (BPrdInfo) getSqlMapClientTemplate().queryForObject("B_PRD_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdInfo record, BPrdInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdInfo record, BPrdInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdInfo> selectByPage(BPrdInfoExample example, Page page) {
        List<BPrdInfo> list = this.searchListPageMyObject("B_PRD_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}