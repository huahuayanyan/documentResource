package com.huateng.scf.bas.brp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.brp.dao.IBBrpFinParamDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpFinParam;
import com.huateng.scf.bas.brp.dao.model.BBrpFinParamExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BBrpFinParamDAO")
public class BBrpFinParamDAOImpl extends IbatisDaoAnnotation4Template implements IBBrpFinParamDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BBrpFinParamDAOImpl() {
        super();
    }

    public int countByExample(BBrpFinParamExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_BRP_FIN_PARAM.countByExample", example);
        return count;
    }

    public int deleteByExample(BBrpFinParamExample example) {
        int rows = getSqlMapClientTemplate().delete("B_BRP_FIN_PARAM.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String subjId) {
        BBrpFinParam _key = new BBrpFinParam();
        _key.setSubjId(subjId);
        int rows = getSqlMapClientTemplate().delete("B_BRP_FIN_PARAM.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BBrpFinParam record) {
        getSqlMapClientTemplate().insert("B_BRP_FIN_PARAM.insert", record);
    }

    public void insertSelective(BBrpFinParam record) {
        getSqlMapClientTemplate().insert("B_BRP_FIN_PARAM.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BBrpFinParam> selectByExample(BBrpFinParamExample example) {
        List<BBrpFinParam> list = getSqlMapClientTemplate().queryForList("B_BRP_FIN_PARAM.selectByExample", example);
        return list;
    }

    public BBrpFinParam selectByPrimaryKey(String subjId) {
        BBrpFinParam _key = new BBrpFinParam();
        _key.setSubjId(subjId);
        BBrpFinParam record = (BBrpFinParam) getSqlMapClientTemplate().queryForObject("B_BRP_FIN_PARAM.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BBrpFinParam record, BBrpFinParamExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_BRP_FIN_PARAM.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BBrpFinParam record, BBrpFinParamExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_BRP_FIN_PARAM.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BBrpFinParam record) {
        int rows = getSqlMapClientTemplate().update("B_BRP_FIN_PARAM.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BBrpFinParam record) {
        int rows = getSqlMapClientTemplate().update("B_BRP_FIN_PARAM.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BBrpFinParam> selectByPage(BBrpFinParamExample example, Page page) {
        List<BBrpFinParam> list = this.searchListPageMyObject("B_BRP_FIN_PARAM.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BBrpFinParamExample {
        private Object record;

        public UpdateByExampleParms(Object record, BBrpFinParamExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}