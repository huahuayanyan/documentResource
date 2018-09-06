package com.huateng.scf.bas.cnt.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntCostInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntCostInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntCostInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BCntCostInfoDAO")
public class BCntCostInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntCostInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntCostInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntCostInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_COST_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntCostInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_COST_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCntCostInfo _key = new BCntCostInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CNT_COST_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntCostInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_COST_INFO.insert", record);
    }

    public void insertSelective(BCntCostInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_COST_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntCostInfo> selectByExample(BCntCostInfoExample example) {
        List<BCntCostInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_COST_INFO.selectByExample", example);
        return list;
    }

    public BCntCostInfo selectByPrimaryKey(String id) {
        BCntCostInfo _key = new BCntCostInfo();
        _key.setId(id);
        BCntCostInfo record = (BCntCostInfo) getSqlMapClientTemplate().queryForObject("B_CNT_COST_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntCostInfo record, BCntCostInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_COST_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntCostInfo record, BCntCostInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_COST_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntCostInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_COST_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntCostInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_COST_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntCostInfo> selectByPage(BCntCostInfoExample example, Page page) {
        List<BCntCostInfo> list = this.searchListPageMyObject("B_CNT_COST_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntCostInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntCostInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //EXT
    //根据关联号/关联号和关联类型获取费用信息
    public BCntCostInfo findCostInfoByContno(BCntCostInfo bCntCostInfo) {
        BCntCostInfo record = (BCntCostInfo) getSqlMapClientTemplate().queryForObject("EXT_B_CNT_COST_INFO.findCostInfoByContno", bCntCostInfo);
        return record;
    }

}