package com.huateng.scf.adv.wrn.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.IBWanMortCheckInfoDAO;
import com.huateng.scf.adv.wrn.dao.model.BWanMortCheckInfo;
import com.huateng.scf.adv.wrn.dao.model.BWanMortCheckInfoExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("IBWanMortCheckInfoDAO")
public class BWanMortCheckInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBWanMortCheckInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BWanMortCheckInfoDAOImpl() {
        super();
    }

    public int countByExample(BWanMortCheckInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_WRN_MORT_CHECK_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BWanMortCheckInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_WRN_MORT_CHECK_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BWanMortCheckInfo _key = new BWanMortCheckInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_WRN_MORT_CHECK_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BWanMortCheckInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_MORT_CHECK_INFO.insert", record);
    }

    public void insertSelective(BWanMortCheckInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_MORT_CHECK_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BWanMortCheckInfo> selectByExample(BWanMortCheckInfoExample example) {
        List<BWanMortCheckInfo> list = getSqlMapClientTemplate().queryForList("B_WRN_MORT_CHECK_INFO.selectByExample", example);
        return list;
    }

    public BWanMortCheckInfo selectByPrimaryKey(String id) {
        BWanMortCheckInfo _key = new BWanMortCheckInfo();
        _key.setId(id);
        BWanMortCheckInfo record = (BWanMortCheckInfo) getSqlMapClientTemplate().queryForObject("B_WRN_MORT_CHECK_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BWanMortCheckInfo record, BWanMortCheckInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_CHECK_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BWanMortCheckInfo record, BWanMortCheckInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_CHECK_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BWanMortCheckInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_CHECK_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BWanMortCheckInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_CHECK_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BWanMortCheckInfo> selectByPage(BWanMortCheckInfoExample example, Page page) {
        List<BWanMortCheckInfo> list = this.searchListPageMyObject("B_WRN_MORT_CHECK_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BWanMortCheckInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BWanMortCheckInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}