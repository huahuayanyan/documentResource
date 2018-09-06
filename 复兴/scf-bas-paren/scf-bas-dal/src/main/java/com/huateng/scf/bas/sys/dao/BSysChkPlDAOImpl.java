package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.model.BSysChkPl;
import com.huateng.scf.bas.sys.dao.model.BSysChkPlExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BSysChkPlDAO")
public class BSysChkPlDAOImpl extends IbatisDaoAnnotation4Template implements BSysChkPlDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysChkPlDAOImpl() {
        super();
    }

    public int countByExample(BSysChkPlExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_CHK_PL.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysChkPlExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_CHK_PL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String chkPlId) {
        BSysChkPl _key = new BSysChkPl();
        _key.setChkPlId(chkPlId);
        int rows = getSqlMapClientTemplate().delete("B_SYS_CHK_PL.deleteByPrimaryKey", _key);
        return rows;
    }

    public String insert(BSysChkPl record) {
        return (String)getSqlMapClientTemplate().insert("B_SYS_CHK_PL.insert", record);
    }

    public String insertSelective(BSysChkPl record) {
        return (String)getSqlMapClientTemplate().insert("B_SYS_CHK_PL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysChkPl> selectByExample(BSysChkPlExample example) {
        List<BSysChkPl> list = getSqlMapClientTemplate().queryForList("B_SYS_CHK_PL.selectByExample", example);
        return list;
    }

    public BSysChkPl selectByPrimaryKey(String chkPlId) {
        BSysChkPl _key = new BSysChkPl();
        _key.setChkPlId(chkPlId);
        BSysChkPl record = (BSysChkPl) getSqlMapClientTemplate().queryForObject("B_SYS_CHK_PL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysChkPl record, BSysChkPlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_PL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysChkPl record, BSysChkPlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_PL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysChkPl record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_PL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysChkPl record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_PL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysChkPl> selectByPage(BSysChkPlExample example, Page page) {
        List<BSysChkPl> list = this.searchListPageMyObject("B_SYS_CHK_PL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysChkPlExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysChkPlExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}