package com.huateng.scf.nrec.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpAppliBaseInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpAppliBaseInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpAppliBaseInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBCntBcpAppliBaseInfoDAO")
public class BCntBcpAppliBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntBcpAppliBaseInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntBcpAppliBaseInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntBcpAppliBaseInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_BCP_APPLI_BASE_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntBcpAppliBaseInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_BCP_APPLI_BASE_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String appno) {
        BCntBcpAppliBaseInfo _key = new BCntBcpAppliBaseInfo();
        _key.setAppno(appno);
        int rows = getSqlMapClientTemplate().delete("B_CNT_BCP_APPLI_BASE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntBcpAppliBaseInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_BCP_APPLI_BASE_INFO.insert", record);
    }

    public void insertSelective(BCntBcpAppliBaseInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_BCP_APPLI_BASE_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntBcpAppliBaseInfo> selectByExample(BCntBcpAppliBaseInfoExample example) {
        List<BCntBcpAppliBaseInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_BCP_APPLI_BASE_INFO.selectByExample", example);
        return list;
    }

    public BCntBcpAppliBaseInfo selectByPrimaryKey(String appno) {
        BCntBcpAppliBaseInfo _key = new BCntBcpAppliBaseInfo();
        _key.setAppno(appno);
        BCntBcpAppliBaseInfo record = (BCntBcpAppliBaseInfo) getSqlMapClientTemplate().queryForObject("B_CNT_BCP_APPLI_BASE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntBcpAppliBaseInfo record, BCntBcpAppliBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_APPLI_BASE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntBcpAppliBaseInfo record, BCntBcpAppliBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_APPLI_BASE_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntBcpAppliBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_APPLI_BASE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntBcpAppliBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_BCP_APPLI_BASE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntBcpAppliBaseInfo> selectByPage(BCntBcpAppliBaseInfoExample example, Page page) {
        List<BCntBcpAppliBaseInfo> list = this.searchListPageMyObject("B_CNT_BCP_APPLI_BASE_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntBcpAppliBaseInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntBcpAppliBaseInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}