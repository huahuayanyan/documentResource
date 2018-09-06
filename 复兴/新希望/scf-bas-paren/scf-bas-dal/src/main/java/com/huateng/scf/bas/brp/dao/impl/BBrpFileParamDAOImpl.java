package com.huateng.scf.bas.brp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.brp.dao.IBBrpFileParamDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpFileParam;
import com.huateng.scf.bas.brp.dao.model.BBrpFileParamExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBBrpFileParamDAO")
public class BBrpFileParamDAOImpl extends IbatisDaoAnnotation4Template implements IBBrpFileParamDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BBrpFileParamDAOImpl() {
        super();
    }

    public int countByExample(BBrpFileParamExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_BRP_FILE_PARAM.countByExample", example);
        return count;
    }

    public int deleteByExample(BBrpFileParamExample example) {
        int rows = getSqlMapClientTemplate().delete("B_BRP_FILE_PARAM.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BBrpFileParam _key = new BBrpFileParam();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_BRP_FILE_PARAM.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BBrpFileParam record) {
        getSqlMapClientTemplate().insert("B_BRP_FILE_PARAM.insert", record);
    }

    public void insertSelective(BBrpFileParam record) {
        getSqlMapClientTemplate().insert("B_BRP_FILE_PARAM.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BBrpFileParam> selectByExample(BBrpFileParamExample example) {
        List<BBrpFileParam> list = getSqlMapClientTemplate().queryForList("B_BRP_FILE_PARAM.selectByExample", example);
        return list;
    }

    public BBrpFileParam selectByPrimaryKey(String id) {
        BBrpFileParam _key = new BBrpFileParam();
        _key.setId(id);
        BBrpFileParam record = (BBrpFileParam) getSqlMapClientTemplate().queryForObject("B_BRP_FILE_PARAM.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BBrpFileParam record, BBrpFileParamExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_BRP_FILE_PARAM.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BBrpFileParam record, BBrpFileParamExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_BRP_FILE_PARAM.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BBrpFileParam record) {
        int rows = getSqlMapClientTemplate().update("B_BRP_FILE_PARAM.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BBrpFileParam record) {
        int rows = getSqlMapClientTemplate().update("B_BRP_FILE_PARAM.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BBrpFileParam> selectByPage(BBrpFileParamExample example, Page page) {
        List<BBrpFileParam> list = this.searchListPageMyObject("B_BRP_FILE_PARAM.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BBrpFileParamExample {
        private Object record;

        public UpdateByExampleParms(Object record, BBrpFileParamExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}