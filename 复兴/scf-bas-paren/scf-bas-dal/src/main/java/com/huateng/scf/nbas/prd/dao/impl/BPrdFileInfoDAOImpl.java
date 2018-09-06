package com.huateng.scf.nbas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nbas.prd.dao.IBPrdFileInfoDAO;
import com.huateng.scf.nbas.prd.dao.model.BPrdFileInfo;
import com.huateng.scf.nbas.prd.dao.model.BPrdFileInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBPrdFileInfoDAO")
public class BPrdFileInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdFileInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdFileInfoDAOImpl() {
        super();
    }

    public int countByExample(BPrdFileInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_FILE_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdFileInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_FILE_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdFileInfo _key = new BPrdFileInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_FILE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdFileInfo record) {
        getSqlMapClientTemplate().insert("B_PRD_FILE_INFO.insert", record);
    }

    public void insertSelective(BPrdFileInfo record) {
        getSqlMapClientTemplate().insert("B_PRD_FILE_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdFileInfo> selectByExample(BPrdFileInfoExample example) {
        List<BPrdFileInfo> list = getSqlMapClientTemplate().queryForList("B_PRD_FILE_INFO.selectByExample", example);
        return list;
    }

    public BPrdFileInfo selectByPrimaryKey(String id) {
        BPrdFileInfo _key = new BPrdFileInfo();
        _key.setId(id);
        BPrdFileInfo record = (BPrdFileInfo) getSqlMapClientTemplate().queryForObject("B_PRD_FILE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdFileInfo record, BPrdFileInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_FILE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdFileInfo record, BPrdFileInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_FILE_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdFileInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_FILE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdFileInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_FILE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdFileInfo> selectByPage(BPrdFileInfoExample example, Page page) {
        List<BPrdFileInfo> list = this.searchListPageMyObject("B_PRD_FILE_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdFileInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdFileInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}