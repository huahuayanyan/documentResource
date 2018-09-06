package com.huateng.scf.rec.wrn.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.wrn.dao.IBWrnRiskOfInfoDAO;
import com.huateng.scf.rec.wrn.dao.model.BWrnRiskOfInfo;
import com.huateng.scf.rec.wrn.dao.model.BWrnRiskOfInfoDetail;
import com.huateng.scf.rec.wrn.dao.model.BWrnRiskOfInfoExample;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BWrnRiskOfInfoDAO")
public class BWrnRiskOfInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBWrnRiskOfInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BWrnRiskOfInfoDAOImpl() {
        super();
    }

    public int countByExample(BWrnRiskOfInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_WRN_RISK_OF_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BWrnRiskOfInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_WRN_RISK_OF_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BWrnRiskOfInfo _key = new BWrnRiskOfInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_WRN_RISK_OF_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BWrnRiskOfInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_RISK_OF_INFO.insert", record);
    }

    public void insertSelective(BWrnRiskOfInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_RISK_OF_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BWrnRiskOfInfo> selectByExample(BWrnRiskOfInfoExample example) {
        List<BWrnRiskOfInfo> list = getSqlMapClientTemplate().queryForList("B_WRN_RISK_OF_INFO.selectByExample", example);
        return list;
    }

    public BWrnRiskOfInfo selectByPrimaryKey(String id) {
        BWrnRiskOfInfo _key = new BWrnRiskOfInfo();
        _key.setId(id);
        BWrnRiskOfInfo record = (BWrnRiskOfInfo) getSqlMapClientTemplate().queryForObject("B_WRN_RISK_OF_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BWrnRiskOfInfo record, BWrnRiskOfInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_RISK_OF_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BWrnRiskOfInfo record, BWrnRiskOfInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_RISK_OF_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BWrnRiskOfInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_RISK_OF_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BWrnRiskOfInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_RISK_OF_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BWrnRiskOfInfo> selectByPage(BWrnRiskOfInfoExample example, Page page) {
        List<BWrnRiskOfInfo> list = this.searchListPageMyObject("B_WRN_RISK_OF_INFO.selectByExample", example, page);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BWrnRiskOfInfoDetail> getUnableCoverOpenAmtWarnInfo(Map map, Page page) {
        List<BWrnRiskOfInfoDetail> list = this.searchListPageMyObject("B_WRN_RISK_OF_INFO.getUnableCoverOpenAmtWarnInfo", map, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BWrnRiskOfInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BWrnRiskOfInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}