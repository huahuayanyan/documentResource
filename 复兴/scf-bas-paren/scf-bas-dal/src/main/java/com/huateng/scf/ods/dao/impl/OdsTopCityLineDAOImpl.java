package com.huateng.scf.ods.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.ods.dao.IOdsTopCityLineDAO;
import com.huateng.scf.ods.dao.model.OdsTopCityLine;
import com.huateng.scf.ods.dao.model.OdsTopCityLineExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("OdsTopCityLineDAO")
public class OdsTopCityLineDAOImpl extends IbatisDaoAnnotation4Template implements IOdsTopCityLineDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public OdsTopCityLineDAOImpl() {
        super();
    }

    public int countByExample(OdsTopCityLineExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ODS_TOP_CITY_LINE.countByExample", example);
        return count;
    }

    public int deleteByExample(OdsTopCityLineExample example) {
        int rows = getSqlMapClientTemplate().delete("ODS_TOP_CITY_LINE.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        OdsTopCityLine _key = new OdsTopCityLine();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ODS_TOP_CITY_LINE.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(OdsTopCityLine record) {
        getSqlMapClientTemplate().insert("ODS_TOP_CITY_LINE.insert", record);
    }

    public void insertSelective(OdsTopCityLine record) {
        getSqlMapClientTemplate().insert("ODS_TOP_CITY_LINE.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<OdsTopCityLine> selectByExample(OdsTopCityLineExample example) {
        List<OdsTopCityLine> list = getSqlMapClientTemplate().queryForList("ODS_TOP_CITY_LINE.selectByExample", example);
        return list;
    }

    public OdsTopCityLine selectByPrimaryKey(String id) {
        OdsTopCityLine _key = new OdsTopCityLine();
        _key.setId(id);
        OdsTopCityLine record = (OdsTopCityLine) getSqlMapClientTemplate().queryForObject("ODS_TOP_CITY_LINE.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(OdsTopCityLine record, OdsTopCityLineExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY_LINE.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(OdsTopCityLine record, OdsTopCityLineExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY_LINE.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(OdsTopCityLine record) {
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY_LINE.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(OdsTopCityLine record) {
        int rows = getSqlMapClientTemplate().update("ODS_TOP_CITY_LINE.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<OdsTopCityLine> selectByPage(OdsTopCityLineExample example, Page page) {
        List<OdsTopCityLine> list = this.searchListPageMyObject("ODS_TOP_CITY_LINE.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends OdsTopCityLineExample {
        private Object record;

        public UpdateByExampleParms(Object record, OdsTopCityLineExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}