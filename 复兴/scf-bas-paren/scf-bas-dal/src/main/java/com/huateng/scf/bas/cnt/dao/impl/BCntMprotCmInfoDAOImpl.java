package com.huateng.scf.bas.cnt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntMprotCmInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmInfoExample;

@Repository("BCntMprotCmInfoDAO")
public class BCntMprotCmInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntMprotCmInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntMprotCmInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntMprotCmInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_CM_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntMprotCmInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_CM_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String protocolNo) {
        BCntMprotCmInfo _key = new BCntMprotCmInfo();
        _key.setProtocolNo(protocolNo);
        int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_CM_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntMprotCmInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_MPROT_CM_INFO.insert", record);
    }

    public void insertSelective(BCntMprotCmInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_MPROT_CM_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotCmInfo> selectByExample(BCntMprotCmInfoExample example) {
        List<BCntMprotCmInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_CM_INFO.selectByExample", example);
        return list;
    }

    public BCntMprotCmInfo selectByPrimaryKey(String protocolNo) {
        BCntMprotCmInfo _key = new BCntMprotCmInfo();
        _key.setProtocolNo(protocolNo);
        BCntMprotCmInfo record = (BCntMprotCmInfo) getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_CM_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntMprotCmInfo record, BCntMprotCmInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CM_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntMprotCmInfo record, BCntMprotCmInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CM_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntMprotCmInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CM_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntMprotCmInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_CM_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotCmInfo> selectByPage(BCntMprotCmInfoExample example, Page page) {
        List<BCntMprotCmInfo> list = this.searchListPageMyObject("B_CNT_MPROT_CM_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntMprotCmInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntMprotCmInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}