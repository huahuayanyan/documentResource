package com.huateng.scf.bas.pbc.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.IBPbcWhseInspectDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcHkDetail;
import com.huateng.scf.bas.pbc.dao.model.BPbcWhseInspect;
import com.huateng.scf.bas.pbc.dao.model.BPbcWhseInspectExample;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPbcWhseInspectDAO")
public class BPbcWhseInspectDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcWhseInspectDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcWhseInspectDAOImpl() {
        super();
    }

    public int countByExample(BPbcWhseInspectExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_WHSE_INSPECT.countByExample", example);
        return count;
    }

    public int findHkCount(Map map){
    	Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_WHSE_INSPECT.findHkCount", map);
        return count;
    }
    
    public int deleteByExample(BPbcWhseInspectExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_WHSE_INSPECT.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPbcWhseInspect _key = new BPbcWhseInspect();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PBC_WHSE_INSPECT.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcWhseInspect record) {
        getSqlMapClientTemplate().insert("B_PBC_WHSE_INSPECT.insert", record);
    }

    public void insertSelective(BPbcWhseInspect record) {
        getSqlMapClientTemplate().insert("B_PBC_WHSE_INSPECT.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcWhseInspect> selectByExample(BPbcWhseInspectExample example) {
        List<BPbcWhseInspect> list = getSqlMapClientTemplate().queryForList("B_PBC_WHSE_INSPECT.selectByExample", example);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BPbcHkDetail> findHkInfo(Map map) {
        List<BPbcHkDetail> list = getSqlMapClientTemplate().queryForList("B_PBC_WHSE_INSPECT.findHkInfo", map);
        return list;
    }
    
    public BPbcWhseInspect selectByPrimaryKey(String id) {
        BPbcWhseInspect _key = new BPbcWhseInspect();
        _key.setId(id);
        BPbcWhseInspect record = (BPbcWhseInspect) getSqlMapClientTemplate().queryForObject("B_PBC_WHSE_INSPECT.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcWhseInspect record, BPbcWhseInspectExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_WHSE_INSPECT.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcWhseInspect record, BPbcWhseInspectExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_WHSE_INSPECT.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcWhseInspect record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_WHSE_INSPECT.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcWhseInspect record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_WHSE_INSPECT.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcWhseInspect> selectByPage(BPbcWhseInspectExample example, Page page) {
        List<BPbcWhseInspect> list = this.searchListPageMyObject("B_PBC_WHSE_INSPECT.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcWhseInspectExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcWhseInspectExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}