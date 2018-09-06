package com.huateng.scf.rec.wrn.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.wrn.dao.IBWrnDebtPdoInfoDAO;
import com.huateng.scf.rec.wrn.dao.model.BWrnDebtPdoInfo;
import com.huateng.scf.rec.wrn.dao.model.BWrnDebtPdoInfoDetail;
import com.huateng.scf.rec.wrn.dao.model.BWrnDebtPdoInfoExample;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BWrnDebtPdoInfoDAO")
public class BWrnDebtPdoInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBWrnDebtPdoInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BWrnDebtPdoInfoDAOImpl() {
        super();
    }

    public int countByExample(BWrnDebtPdoInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_WRN_DEBT_PDO_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BWrnDebtPdoInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_WRN_DEBT_PDO_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BWrnDebtPdoInfo _key = new BWrnDebtPdoInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_WRN_DEBT_PDO_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BWrnDebtPdoInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_DEBT_PDO_INFO.insert", record);
    }

    public void insertSelective(BWrnDebtPdoInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_DEBT_PDO_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BWrnDebtPdoInfo> selectByExample(BWrnDebtPdoInfoExample example) {
        List<BWrnDebtPdoInfo> list = getSqlMapClientTemplate().queryForList("B_WRN_DEBT_PDO_INFO.selectByExample", example);
        return list;
    }

    public BWrnDebtPdoInfo selectByPrimaryKey(String id) {
        BWrnDebtPdoInfo _key = new BWrnDebtPdoInfo();
        _key.setId(id);
        BWrnDebtPdoInfo record = (BWrnDebtPdoInfo) getSqlMapClientTemplate().queryForObject("B_WRN_DEBT_PDO_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BWrnDebtPdoInfo record, BWrnDebtPdoInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_DEBT_PDO_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BWrnDebtPdoInfo record, BWrnDebtPdoInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_DEBT_PDO_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BWrnDebtPdoInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_DEBT_PDO_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BWrnDebtPdoInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_DEBT_PDO_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BWrnDebtPdoInfo> selectByPage(BWrnDebtPdoInfoExample example, Page page) {
        List<BWrnDebtPdoInfo> list = this.searchListPageMyObject("B_WRN_DEBT_PDO_INFO.selectByExample", example, page);
        return list;
    }


    @SuppressWarnings("unchecked")
    public List<BWrnDebtPdoInfoDetail> getAccountDebtPromptWarnInfo(Map map, Page page) {
        List<BWrnDebtPdoInfoDetail> list = this.searchListPageMyObject("B_WRN_DEBT_PDO_INFO.getAccountDebtPromptWarnInfo", map, page);
        return list;
    }
    
    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BWrnDebtPdoInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BWrnDebtPdoInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}