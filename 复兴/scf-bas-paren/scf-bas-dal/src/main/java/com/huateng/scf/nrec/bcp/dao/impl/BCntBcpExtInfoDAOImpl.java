package com.huateng.scf.nrec.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpExtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBCntBcpExtInfoDAO")
public class BCntBcpExtInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntBcpExtInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntBcpExtInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntBcpExtInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_BCP_EXT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntBcpExtInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_BCP_EXT_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCntBcpExtInfo _key = new BCntBcpExtInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CNT_BCP_EXT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntBcpExtInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_BCP_EXT_INFO.insert", record);
    }

    public void insertSelective(BCntBcpExtInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_BCP_EXT_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntBcpExtInfo> selectByExample(BCntBcpExtInfoExample example) {
        List<BCntBcpExtInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_BCP_EXT_INFO.selectByExample", example);
        return list;
    }

    public BCntBcpExtInfo selectByPrimaryKey(String id) {
        BCntBcpExtInfo _key = new BCntBcpExtInfo();
        _key.setId(id);
        BCntBcpExtInfo record = (BCntBcpExtInfo) getSqlMapClientTemplate().queryForObject("B_CNT_BCP_EXT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntBcpExtInfo record, BCntBcpExtInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_EXT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntBcpExtInfo record, BCntBcpExtInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_EXT_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntBcpExtInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_EXT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntBcpExtInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_EXT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntBcpExtInfo> selectByPage(BCntBcpExtInfoExample example, Page page) {
        List<BCntBcpExtInfo> list = this.searchListPageMyObject("B_CNT_BCP_EXT_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntBcpExtInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntBcpExtInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}