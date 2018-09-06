package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.model.BWrnDropCtlInfo;
import com.huateng.scf.adv.wrn.dao.model.BWrnDropCtlInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BWrnDropCtlInfoDAO")
public class BWrnDropCtlInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBWrnDropCtlInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BWrnDropCtlInfoDAOImpl() {
        super();
    }

    public int countByExample(BWrnDropCtlInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_WRN_DROP_CTL_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BWrnDropCtlInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_WRN_DROP_CTL_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BWrnDropCtlInfo _key = new BWrnDropCtlInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_WRN_DROP_CTL_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BWrnDropCtlInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_DROP_CTL_INFO.insert", record);
    }

    public void insertSelective(BWrnDropCtlInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_DROP_CTL_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BWrnDropCtlInfo> selectByExample(BWrnDropCtlInfoExample example) {
        List<BWrnDropCtlInfo> list = getSqlMapClientTemplate().queryForList("B_WRN_DROP_CTL_INFO.selectByExample", example);
        return list;
    }

    public BWrnDropCtlInfo selectByPrimaryKey(String id) {
        BWrnDropCtlInfo _key = new BWrnDropCtlInfo();
        _key.setId(id);
        BWrnDropCtlInfo record = (BWrnDropCtlInfo) getSqlMapClientTemplate().queryForObject("B_WRN_DROP_CTL_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BWrnDropCtlInfo record, BWrnDropCtlInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_DROP_CTL_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BWrnDropCtlInfo record, BWrnDropCtlInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_DROP_CTL_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BWrnDropCtlInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_DROP_CTL_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BWrnDropCtlInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_DROP_CTL_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BWrnDropCtlInfo> selectByPage(BWrnDropCtlInfoExample example, Page page) {
        List<BWrnDropCtlInfo> list = this.searchListPageMyObject("B_WRN_DROP_CTL_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BWrnDropCtlInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BWrnDropCtlInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}