package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.model.BSysChkRec;
import com.huateng.scf.bas.sys.dao.model.BSysChkRecExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BSysChkRecDAO")
public class BSysChkRecDAOImpl extends IbatisDaoAnnotation4Template implements BSysChkRecDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysChkRecDAOImpl() {
        super();
    }

    public int countByExample(BSysChkRecExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_CHK_REC.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysChkRecExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_CHK_REC.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String recId) {
        BSysChkRec _key = new BSysChkRec();
        _key.setRecId(recId);
        int rows = getSqlMapClientTemplate().delete("B_SYS_CHK_REC.deleteByPrimaryKey", _key);
        return rows;
    }

    public String insert(BSysChkRec record) {
        return (String)getSqlMapClientTemplate().insert("B_SYS_CHK_REC.insert", record);
    }

    public String insertSelective(BSysChkRec record) {
       return (String)getSqlMapClientTemplate().insert("B_SYS_CHK_REC.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysChkRec> selectByExample(BSysChkRecExample example) {
        List<BSysChkRec> list = getSqlMapClientTemplate().queryForList("B_SYS_CHK_REC.selectByExample", example);
        return list;
    }

    public BSysChkRec selectByPrimaryKey(String recId) {
        BSysChkRec _key = new BSysChkRec();
        _key.setRecId(recId);
        BSysChkRec record = (BSysChkRec) getSqlMapClientTemplate().queryForObject("B_SYS_CHK_REC.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysChkRec record, BSysChkRecExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_REC.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysChkRec record, BSysChkRecExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_REC.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysChkRec record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_REC.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysChkRec record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_REC.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysChkRec> selectByPage(BSysChkRecExample example, Page page) {
        List<BSysChkRec> list = this.searchListPageMyObject("B_SYS_CHK_REC.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysChkRecExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysChkRecExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	/* 
	 * select pl.CHK_PL_ID, pl.CHK_IT_ID, pl.NM, pl.ORD, pl.DEAL, cnfg.REM, pl.STAT from  
	 * B_SYS_CHK_PL pl joins B_SYS_CHK_CNFG cnfg
	 * on pl.CHK_IT_ID = cnfg.CHK_IT_ID;
	 * 
	 */
	@Override
	public List<BSysChkRec> findAllBSysChkRecs() {
		List<BSysChkRec> list = this.getSqlMapClientTemplate().queryForList("B_SYS_CHK_REC.findAllList");
        return list;		
	}
}