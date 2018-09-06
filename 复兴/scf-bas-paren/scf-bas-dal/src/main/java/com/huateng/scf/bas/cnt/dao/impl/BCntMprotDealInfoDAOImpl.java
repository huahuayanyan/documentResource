package com.huateng.scf.bas.cnt.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntMprotDealInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BCntMprotDealInfoDAO")
public class BCntMprotDealInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntMprotDealInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntMprotDealInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntMprotDealInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_DEAL_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntMprotDealInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_DEAL_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String protocolNo) {
        BCntMprotDealInfo _key = new BCntMprotDealInfo();
        _key.setProtocolNo(protocolNo);
        int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_DEAL_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntMprotDealInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_MPROT_DEAL_INFO.insert", record);
    }

    public void insertSelective(BCntMprotDealInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_MPROT_DEAL_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotDealInfo> selectByExample(BCntMprotDealInfoExample example) {
        List<BCntMprotDealInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_DEAL_INFO.selectByExample", example);
        return list;
    }

    public BCntMprotDealInfo selectByPrimaryKey(String protocolNo) {
        BCntMprotDealInfo _key = new BCntMprotDealInfo();
        _key.setProtocolNo(protocolNo);
        BCntMprotDealInfo record = (BCntMprotDealInfo) getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_DEAL_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntMprotDealInfo record, BCntMprotDealInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_DEAL_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntMprotDealInfo record, BCntMprotDealInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_DEAL_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntMprotDealInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_DEAL_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntMprotDealInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_DEAL_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotDealInfo> selectByPage(BCntMprotDealInfoExample example, Page page) {
        List<BCntMprotDealInfo> list = this.searchListPageMyObject("B_CNT_MPROT_DEAL_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntMprotDealInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntMprotDealInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}