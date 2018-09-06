package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.dcr.model.BDcrChkDir;
import com.huateng.scf.bas.dcr.model.BDcrChkDirExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BDcrChkDirDAO")
public class BDcrChkDirDAOImpl extends IbatisDaoAnnotation4Template implements BDcrChkDirDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BDcrChkDirDAOImpl() {
        super();
    }

    public int countByExample(BDcrChkDirExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_DCR_CHK_DIR.countByExample", example);
        return count;
    }

    public int deleteByExample(BDcrChkDirExample example) {
        int rows = getSqlMapClientTemplate().delete("B_DCR_CHK_DIR.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String chkDirId) {
        BDcrChkDir _key = new BDcrChkDir();
        _key.setChkDirId(chkDirId);
        int rows = getSqlMapClientTemplate().delete("B_DCR_CHK_DIR.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BDcrChkDir record) {
        getSqlMapClientTemplate().insert("B_DCR_CHK_DIR.insert", record);
    }

    public void insertSelective(BDcrChkDir record) {
        getSqlMapClientTemplate().insert("B_DCR_CHK_DIR.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BDcrChkDir> selectByExample(BDcrChkDirExample example) {
        List<BDcrChkDir> list = getSqlMapClientTemplate().queryForList("B_DCR_CHK_DIR.selectByExample", example);
        return list;
    }

    public BDcrChkDir selectByPrimaryKey(String chkDirId) {
        BDcrChkDir _key = new BDcrChkDir();
        _key.setChkDirId(chkDirId);
        BDcrChkDir record = (BDcrChkDir) getSqlMapClientTemplate().queryForObject("B_DCR_CHK_DIR.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BDcrChkDir record, BDcrChkDirExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_CHK_DIR.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BDcrChkDir record, BDcrChkDirExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_CHK_DIR.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BDcrChkDir record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_CHK_DIR.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BDcrChkDir record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_CHK_DIR.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BDcrChkDir> selectByPage(BDcrChkDirExample example, Page page) {
        List<BDcrChkDir> list = this.searchListPageMyObject("B_DCR_CHK_DIR.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BDcrChkDirExample {
        private Object record;

        public UpdateByExampleParms(Object record, BDcrChkDirExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}