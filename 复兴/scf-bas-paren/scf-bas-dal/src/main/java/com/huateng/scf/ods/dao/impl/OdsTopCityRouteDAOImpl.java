package com.huateng.scf.ods.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.ods.dao.IOdsTopCityRouteDAO;
import com.huateng.scf.ods.dao.model.OdsTopCityRoute;
import com.huateng.scf.ods.dao.model.OdsTopCityRouteExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("OdsTopCityRouteDAO")
public class OdsTopCityRouteDAOImpl extends IbatisDaoAnnotation4Template implements IOdsTopCityRouteDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public OdsTopCityRouteDAOImpl() {
        super();
    }

    public int countByExample(OdsTopCityRouteExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ODS_TOP_CITY_ROUTE.countByExample", example);
        return count;
    }

    public int deleteByExample(OdsTopCityRouteExample example) {
        int rows = getSqlMapClientTemplate().delete("ODS_TOP_CITY_ROUTE.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        OdsTopCityRoute _key = new OdsTopCityRoute();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ODS_TOP_CITY_ROUTE.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(OdsTopCityRoute record) {
        getSqlMapClientTemplate().insert("ODS_TOP_CITY_ROUTE.insert", record);
    }

    public void insertSelective(OdsTopCityRoute record) {
        getSqlMapClientTemplate().insert("ODS_TOP_CITY_ROUTE.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<OdsTopCityRoute> selectByExample(OdsTopCityRouteExample example) {
        List<OdsTopCityRoute> list = getSqlMapClientTemplate().queryForList("ODS_TOP_CITY_ROUTE.selectByExample", example);
        return list;
    }

    public OdsTopCityRoute selectByPrimaryKey(String id) {
        OdsTopCityRoute _key = new OdsTopCityRoute();
        _key.setId(id);
        OdsTopCityRoute record = (OdsTopCityRoute) getSqlMapClientTemplate().queryForObject("ODS_TOP_CITY_ROUTE.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(OdsTopCityRoute record, OdsTopCityRouteExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY_ROUTE.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(OdsTopCityRoute record, OdsTopCityRouteExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY_ROUTE.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(OdsTopCityRoute record) {
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY_ROUTE.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(OdsTopCityRoute record) {
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY_ROUTE.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<OdsTopCityRoute> selectByPage(OdsTopCityRouteExample example, Page page) {
        List<OdsTopCityRoute> list = this.searchListPageMyObject("ODS_TOP_CITY_ROUTE.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends OdsTopCityRouteExample {
        private Object record;

        public UpdateByExampleParms(Object record, OdsTopCityRouteExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}