package com.huateng.scf.bas.brp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.brp.dao.IBBrpPageParamPackageDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackage;
import com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackageExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BBrpPageParamPackageDAO")
public class BBrpPageParamPackageDAOImpl extends IbatisDaoAnnotation4Template implements IBBrpPageParamPackageDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BBrpPageParamPackageDAOImpl() {
        super();
    }

    public int countByExample(BBrpPageParamPackageExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_BRP_PAGE_PARAM_PACKAGE.countByExample", example);
        return count;
    }

    public int deleteByExample(BBrpPageParamPackageExample example) {
        int rows = getSqlMapClientTemplate().delete("B_BRP_PAGE_PARAM_PACKAGE.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BBrpPageParamPackage _key = new BBrpPageParamPackage();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_BRP_PAGE_PARAM_PACKAGE.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BBrpPageParamPackage record) {
        getSqlMapClientTemplate().insert("B_BRP_PAGE_PARAM_PACKAGE.insert", record);
    }

    public void insertSelective(BBrpPageParamPackage record) {
        getSqlMapClientTemplate().insert("B_BRP_PAGE_PARAM_PACKAGE.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BBrpPageParamPackage> selectByExample(BBrpPageParamPackageExample example) {
        List<BBrpPageParamPackage> list = getSqlMapClientTemplate().queryForList("B_BRP_PAGE_PARAM_PACKAGE.selectByExample", example);
        return list;
    }

    public BBrpPageParamPackage selectByPrimaryKey(String id) {
        BBrpPageParamPackage _key = new BBrpPageParamPackage();
        _key.setId(id);
        BBrpPageParamPackage record = (BBrpPageParamPackage) getSqlMapClientTemplate().queryForObject("B_BRP_PAGE_PARAM_PACKAGE.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BBrpPageParamPackage record, BBrpPageParamPackageExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_BRP_PAGE_PARAM_PACKAGE.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BBrpPageParamPackage record, BBrpPageParamPackageExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_BRP_PAGE_PARAM_PACKAGE.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BBrpPageParamPackage record) {
        int rows = getSqlMapClientTemplate().update("B_BRP_PAGE_PARAM_PACKAGE.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BBrpPageParamPackage record) {
        int rows = getSqlMapClientTemplate().update("B_BRP_PAGE_PARAM_PACKAGE.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BBrpPageParamPackage> selectByPage(BBrpPageParamPackageExample example, Page page) {
        List<BBrpPageParamPackage> list = this.searchListPageMyObject("B_BRP_PAGE_PARAM_PACKAGE.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BBrpPageParamPackageExample {
        private Object record;

        public UpdateByExampleParms(Object record, BBrpPageParamPackageExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}