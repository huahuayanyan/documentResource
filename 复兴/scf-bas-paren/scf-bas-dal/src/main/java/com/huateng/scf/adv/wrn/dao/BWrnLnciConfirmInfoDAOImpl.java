package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.model.BWrnLnciConfirmInfo;
import com.huateng.scf.adv.wrn.dao.model.BWrnLnciConfirmInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BWrnLnciConfirmInfoDAO")
public class BWrnLnciConfirmInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBWrnLnciConfirmInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BWrnLnciConfirmInfoDAOImpl() {
        super();
    }

    public int countByExample(BWrnLnciConfirmInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_WRN_LNCI_CONFIRM_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BWrnLnciConfirmInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_WRN_LNCI_CONFIRM_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BWrnLnciConfirmInfo _key = new BWrnLnciConfirmInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_WRN_LNCI_CONFIRM_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BWrnLnciConfirmInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_LNCI_CONFIRM_INFO.insert", record);
    }

    public void insertSelective(BWrnLnciConfirmInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_LNCI_CONFIRM_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BWrnLnciConfirmInfo> selectByExample(BWrnLnciConfirmInfoExample example) {
        List<BWrnLnciConfirmInfo> list = getSqlMapClientTemplate().queryForList("B_WRN_LNCI_CONFIRM_INFO.selectByExample", example);
        return list;
    }

    public BWrnLnciConfirmInfo selectByPrimaryKey(String id) {
        BWrnLnciConfirmInfo _key = new BWrnLnciConfirmInfo();
        _key.setId(id);
        BWrnLnciConfirmInfo record = (BWrnLnciConfirmInfo) getSqlMapClientTemplate().queryForObject("B_WRN_LNCI_CONFIRM_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BWrnLnciConfirmInfo record, BWrnLnciConfirmInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_LNCI_CONFIRM_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BWrnLnciConfirmInfo record, BWrnLnciConfirmInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_LNCI_CONFIRM_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BWrnLnciConfirmInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_LNCI_CONFIRM_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BWrnLnciConfirmInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_LNCI_CONFIRM_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BWrnLnciConfirmInfo> selectByPage(BWrnLnciConfirmInfoExample example, Page page) {
        List<BWrnLnciConfirmInfo> list = this.searchListPageMyObject("B_WRN_LNCI_CONFIRM_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BWrnLnciConfirmInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BWrnLnciConfirmInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}