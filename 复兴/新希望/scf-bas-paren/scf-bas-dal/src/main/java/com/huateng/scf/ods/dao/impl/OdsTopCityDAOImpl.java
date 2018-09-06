package com.huateng.scf.ods.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.ods.dao.IOdsTopCityDAO;
import com.huateng.scf.ods.dao.model.OdsTopCity;
import com.huateng.scf.ods.dao.model.OdsTopCityExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("OdsTopCityDAO")
public class OdsTopCityDAOImpl extends IbatisDaoAnnotation4Template implements IOdsTopCityDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public OdsTopCityDAOImpl() {
        super();
    }

    public int countByExample(OdsTopCityExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ODS_TOP_CITY.countByExample", example);
        return count;
    }

    public int deleteByExample(OdsTopCityExample example) {
        int rows = getSqlMapClientTemplate().delete("ODS_TOP_CITY.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        OdsTopCity _key = new OdsTopCity();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ODS_TOP_CITY.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(OdsTopCity record) {
        getSqlMapClientTemplate().insert("ODS_TOP_CITY.insert", record);
    }

    public void insertSelective(OdsTopCity record) {
        getSqlMapClientTemplate().insert("ODS_TOP_CITY.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<OdsTopCity> selectByExample(OdsTopCityExample example) {
        List<OdsTopCity> list = getSqlMapClientTemplate().queryForList("ODS_TOP_CITY.selectByExample", example);
        return list;
    }

    public OdsTopCity selectByPrimaryKey(String id) {
        OdsTopCity _key = new OdsTopCity();
        _key.setId(id);
        OdsTopCity record = (OdsTopCity) getSqlMapClientTemplate().queryForObject("ODS_TOP_CITY.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(OdsTopCity record, OdsTopCityExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(OdsTopCity record, OdsTopCityExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(OdsTopCity record) {
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(OdsTopCity record) {
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<OdsTopCity> selectByPage(OdsTopCityExample example, Page page) {
        List<OdsTopCity> list = this.searchListPageMyObject("ODS_TOP_CITY.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends OdsTopCityExample {
        private Object record;

        public UpdateByExampleParms(Object record, OdsTopCityExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}