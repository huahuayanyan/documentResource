package com.huateng.scf.bas.wrn.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.wrn.dao.IBWrnBaseInfoDAO;
import com.huateng.scf.bas.wrn.dao.model.BWrnBaseInfo;
import com.huateng.scf.bas.wrn.dao.model.BWrnBaseInfoExample;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BWrnBaseInfoDAO")
public class BWrnBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBWrnBaseInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BWrnBaseInfoDAOImpl() {
        super();
    }

    public int countByExample(BWrnBaseInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_WRN_BASE_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BWrnBaseInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_WRN_BASE_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BWrnBaseInfo _key = new BWrnBaseInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_WRN_BASE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BWrnBaseInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_BASE_INFO.insert", record);
    }

    public void insertSelective(BWrnBaseInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_BASE_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BWrnBaseInfo> selectByExample(BWrnBaseInfoExample example) {
        List<BWrnBaseInfo> list = getSqlMapClientTemplate().queryForList("B_WRN_BASE_INFO.selectByExample", example);
        return list;
    }

    public BWrnBaseInfo selectByPrimaryKey(String id) {
        BWrnBaseInfo _key = new BWrnBaseInfo();
        _key.setId(id);
        BWrnBaseInfo record = (BWrnBaseInfo) getSqlMapClientTemplate().queryForObject("B_WRN_BASE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BWrnBaseInfo record, BWrnBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_BASE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BWrnBaseInfo record, BWrnBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_BASE_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BWrnBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_BASE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BWrnBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_BASE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BWrnBaseInfo> selectByPage(BWrnBaseInfoExample example, Page page) {
        List<BWrnBaseInfo> list = this.searchListPageMyObject("B_WRN_BASE_INFO.selectByExample", example, page);
        return list;
    }
    
    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BWrnBaseInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BWrnBaseInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}