package com.huateng.scf.nbas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nbas.prd.dao.IBPrdChkdirInfoDAO;
import com.huateng.scf.nbas.prd.dao.model.BPrdChkdirInfo;
import com.huateng.scf.nbas.prd.dao.model.BPrdChkdirInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBPrdChkdirInfoDAO")
public class BPrdChkdirInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdChkdirInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdChkdirInfoDAOImpl() {
        super();
    }

    public int countByExample(BPrdChkdirInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_CHKDIR_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdChkdirInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_CHKDIR_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdChkdirInfo _key = new BPrdChkdirInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_CHKDIR_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdChkdirInfo record) {
        getSqlMapClientTemplate().insert("B_PRD_CHKDIR_INFO.insert", record);
    }

    public void insertSelective(BPrdChkdirInfo record) {
        getSqlMapClientTemplate().insert("B_PRD_CHKDIR_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdChkdirInfo> selectByExample(BPrdChkdirInfoExample example) {
        List<BPrdChkdirInfo> list = getSqlMapClientTemplate().queryForList("B_PRD_CHKDIR_INFO.selectByExample", example);
        return list;
    }

    public BPrdChkdirInfo selectByPrimaryKey(String id) {
        BPrdChkdirInfo _key = new BPrdChkdirInfo();
        _key.setId(id);
        BPrdChkdirInfo record = (BPrdChkdirInfo) getSqlMapClientTemplate().queryForObject("B_PRD_CHKDIR_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdChkdirInfo record, BPrdChkdirInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_CHKDIR_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdChkdirInfo record, BPrdChkdirInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_CHKDIR_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdChkdirInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_CHKDIR_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdChkdirInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_CHKDIR_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdChkdirInfo> selectByPage(BPrdChkdirInfoExample example, Page page) {
        List<BPrdChkdirInfo> list = this.searchListPageMyObject("B_PRD_CHKDIR_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdChkdirInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdChkdirInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}