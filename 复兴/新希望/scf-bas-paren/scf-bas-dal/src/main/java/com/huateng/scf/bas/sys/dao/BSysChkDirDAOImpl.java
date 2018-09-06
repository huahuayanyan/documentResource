package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.model.BSysChkDir;
import com.huateng.scf.bas.sys.dao.model.BSysChkDirExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BSysChkDirDAO")
public class BSysChkDirDAOImpl extends IbatisDaoAnnotation4Template implements BSysChkDirDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysChkDirDAOImpl() {
        super();
    }

    public int countByExample(BSysChkDirExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_CHK_DIR.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysChkDirExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_CHK_DIR.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String mdlId) {
        BSysChkDir _key = new BSysChkDir();
        _key.setMdlId(mdlId);
        int rows = getSqlMapClientTemplate().delete("B_SYS_CHK_DIR.deleteByPrimaryKey", _key);
        return rows;
    }

    public String insert(BSysChkDir record) {
        return (String) getSqlMapClientTemplate().insert("B_SYS_CHK_DIR.insert", record);
    }

    public String insertSelective(BSysChkDir record) {
        return (String) getSqlMapClientTemplate().insert("B_SYS_CHK_DIR.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysChkDir> selectByExample(BSysChkDirExample example) {
        List<BSysChkDir> list = getSqlMapClientTemplate().queryForList("B_SYS_CHK_DIR.selectByExample", example);
        return list;
    }

    public BSysChkDir selectByPrimaryKey(String mdlId) {
        BSysChkDir _key = new BSysChkDir();
        _key.setMdlId(mdlId);
        BSysChkDir record = (BSysChkDir) getSqlMapClientTemplate().queryForObject("B_SYS_CHK_DIR.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysChkDir record, BSysChkDirExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_DIR.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysChkDir record, BSysChkDirExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_DIR.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysChkDir record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_DIR.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysChkDir record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_DIR.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysChkDir> selectByPage(BSysChkDirExample example, Page page) {
        List<BSysChkDir> list = this.searchListPageMyObject("B_SYS_CHK_DIR.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysChkDirExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysChkDirExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}