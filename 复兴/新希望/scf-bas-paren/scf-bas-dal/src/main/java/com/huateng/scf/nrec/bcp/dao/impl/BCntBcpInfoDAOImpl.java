package com.huateng.scf.nrec.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBCntBcpInfoDAO")
public class BCntBcpInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntBcpInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntBcpInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntBcpInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_BCP_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntBcpInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_BCP_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String mastContno) {
        BCntBcpInfo _key = new BCntBcpInfo();
        _key.setMastContno(mastContno);
        int rows = getSqlMapClientTemplate().delete("B_CNT_BCP_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntBcpInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_BCP_INFO.insert", record);
    }

    public void insertSelective(BCntBcpInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_BCP_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntBcpInfo> selectByExample(BCntBcpInfoExample example) {
        List<BCntBcpInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_BCP_INFO.selectByExample", example);
        return list;
    }

    public BCntBcpInfo selectByPrimaryKey(String mastContno) {
        BCntBcpInfo _key = new BCntBcpInfo();
        _key.setMastContno(mastContno);
        BCntBcpInfo record = (BCntBcpInfo) getSqlMapClientTemplate().queryForObject("B_CNT_BCP_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntBcpInfo record, BCntBcpInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntBcpInfo record, BCntBcpInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntBcpInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntBcpInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntBcpInfo> selectByPage(BCntBcpInfoExample example, Page page) {
        List<BCntBcpInfo> list = this.searchListPageMyObject("B_CNT_BCP_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntBcpInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntBcpInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}