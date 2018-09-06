package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.model.BWrnOverMoniInfo;
import com.huateng.scf.adv.wrn.dao.model.BWrnOverMoniInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BWrnOverMoniInfoDAO")
public class BWrnOverMoniInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBWrnOverMoniInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BWrnOverMoniInfoDAOImpl() {
        super();
    }

    public int countByExample(BWrnOverMoniInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_WRN_OVER_MONI_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BWrnOverMoniInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_WRN_OVER_MONI_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BWrnOverMoniInfo _key = new BWrnOverMoniInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_WRN_OVER_MONI_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BWrnOverMoniInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_OVER_MONI_INFO.insert", record);
    }

    public void insertSelective(BWrnOverMoniInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_OVER_MONI_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BWrnOverMoniInfo> selectByExample(BWrnOverMoniInfoExample example) {
        List<BWrnOverMoniInfo> list = getSqlMapClientTemplate().queryForList("B_WRN_OVER_MONI_INFO.selectByExample", example);
        return list;
    }

    public BWrnOverMoniInfo selectByPrimaryKey(String id) {
        BWrnOverMoniInfo _key = new BWrnOverMoniInfo();
        _key.setId(id);
        BWrnOverMoniInfo record = (BWrnOverMoniInfo) getSqlMapClientTemplate().queryForObject("B_WRN_OVER_MONI_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BWrnOverMoniInfo record, BWrnOverMoniInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_OVER_MONI_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BWrnOverMoniInfo record, BWrnOverMoniInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_OVER_MONI_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BWrnOverMoniInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_OVER_MONI_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BWrnOverMoniInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_OVER_MONI_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BWrnOverMoniInfo> selectByPage(BWrnOverMoniInfoExample example, Page page) {
        List<BWrnOverMoniInfo> list = this.searchListPageMyObject("B_WRN_OVER_MONI_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BWrnOverMoniInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BWrnOverMoniInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}