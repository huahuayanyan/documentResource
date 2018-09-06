package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.model.BSysChkCnfg;
import com.huateng.scf.bas.sys.dao.model.BSysChkCnfgExample;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BSysChkCnfgDAO")
public class BSysChkCnfgDAOImpl extends IbatisDaoAnnotation4Template implements BSysChkCnfgDAO {
    
	@Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysChkCnfgDAOImpl() {
        super();
    }

    public int countByExample(BSysChkCnfgExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_CHK_CNFG.countByExample", example);
        return count;
    }
    
    public int deleteByExample(BSysChkCnfgExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_CHK_CNFG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String chkItId) {
        BSysChkCnfg _key = new BSysChkCnfg();
        _key.setChkItId(chkItId);
        int rows = getSqlMapClientTemplate().delete("B_SYS_CHK_CNFG.deleteByPrimaryKey", _key);
        return rows;
    }

    public String insert(BSysChkCnfg record) {
        Object newKey =getSqlMapClientTemplate().insert("B_SYS_CHK_CNFG.insert", record);
        return (String)newKey;
        
    }

    public String insertSelective(BSysChkCnfg record) {
    	Object newKey = getSqlMapClientTemplate().insert("B_SYS_CHK_CNFG.insertSelective", record);
    	return (String)newKey;
    }

    @SuppressWarnings("unchecked")
    public List<BSysChkCnfg> selectByExample(BSysChkCnfgExample example) {
        List<BSysChkCnfg> list = getSqlMapClientTemplate().queryForList("B_SYS_CHK_CNFG.selectByExample", example);
        return list;
    }

    public BSysChkCnfg selectByPrimaryKey(String chkItId) {
        BSysChkCnfg _key = new BSysChkCnfg();
        _key.setChkItId(chkItId);
        BSysChkCnfg record = (BSysChkCnfg) getSqlMapClientTemplate().queryForObject("B_SYS_CHK_CNFG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysChkCnfg record, BSysChkCnfgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_CNFG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysChkCnfg record, BSysChkCnfgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_CNFG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysChkCnfg record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_CNFG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysChkCnfg record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_CHK_CNFG.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysChkCnfg> selectByPage(BSysChkCnfgExample example, Page page) {
        List<BSysChkCnfg> list = this.searchListPageMyObject("B_SYS_CHK_CNFG.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysChkCnfgExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysChkCnfgExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public List<String> findListByColumnName(String columnName) {
		List<String> list = getSqlMapClientTemplate().queryForList("B_SYS_CHK_CNFG.selectListByColumn",columnName);
		return list;
	}

	
	public List<BSysChkCnfg> findAllList(){
		List<BSysChkCnfg> list = getSqlMapClientTemplate().queryForList("B_SYS_CHK_CNFG.findAllList");
		return list;
	}
}