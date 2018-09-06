package com.huateng.scf.adv.bcp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStockDtl;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStockDtlExample;

@Repository("ABcpMoreDvyChkStockDtlDAO")
public class IABcpMoreDvyChkStockDtlDAOImpl extends IbatisDaoAnnotation4Template implements IABcpMoreDvyChkStockDtlDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public IABcpMoreDvyChkStockDtlDAOImpl() {
        super();
    }

    public int countByExample(ABcpMoreDvyChkStockDtlExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("A_BCP_MORE_DVY_CHK_STOCK_DTL.countByExample", example);
        return count;
    }

    public int deleteByExample(ABcpMoreDvyChkStockDtlExample example) {
        int rows = getSqlMapClientTemplate().delete("A_BCP_MORE_DVY_CHK_STOCK_DTL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        ABcpMoreDvyChkStockDtl _key = new ABcpMoreDvyChkStockDtl();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("A_BCP_MORE_DVY_CHK_STOCK_DTL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(ABcpMoreDvyChkStockDtl record) {
        getSqlMapClientTemplate().insert("A_BCP_MORE_DVY_CHK_STOCK_DTL.insert", record);
    }

    public void insertSelective(ABcpMoreDvyChkStockDtl record) {
        getSqlMapClientTemplate().insert("A_BCP_MORE_DVY_CHK_STOCK_DTL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<ABcpMoreDvyChkStockDtl> selectByExample(ABcpMoreDvyChkStockDtlExample example) {
        List<ABcpMoreDvyChkStockDtl> list = getSqlMapClientTemplate().queryForList("A_BCP_MORE_DVY_CHK_STOCK_DTL.selectByExample", example);
        return list;
    }

    public ABcpMoreDvyChkStockDtl selectByPrimaryKey(String id) {
        ABcpMoreDvyChkStockDtl _key = new ABcpMoreDvyChkStockDtl();
        _key.setId(id);
        ABcpMoreDvyChkStockDtl record = (ABcpMoreDvyChkStockDtl) getSqlMapClientTemplate().queryForObject("A_BCP_MORE_DVY_CHK_STOCK_DTL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(ABcpMoreDvyChkStockDtl record, ABcpMoreDvyChkStockDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("A_BCP_MORE_DVY_CHK_STOCK_DTL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(ABcpMoreDvyChkStockDtl record, ABcpMoreDvyChkStockDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("A_BCP_MORE_DVY_CHK_STOCK_DTL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(ABcpMoreDvyChkStockDtl record) {
        int rows = getSqlMapClientTemplate().update("A_BCP_MORE_DVY_CHK_STOCK_DTL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(ABcpMoreDvyChkStockDtl record) {
        int rows = getSqlMapClientTemplate().update("A_BCP_MORE_DVY_CHK_STOCK_DTL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<ABcpMoreDvyChkStockDtl> selectByPage(ABcpMoreDvyChkStockDtlExample example, Page page) {
        List<ABcpMoreDvyChkStockDtl> list = this.searchListPageMyObject("A_BCP_MORE_DVY_CHK_STOCK_DTL.selectByExample", example, page);
        return list;
    }
    @SuppressWarnings("unchecked")
    public List<ABcpMoreDvyChkStockDtl> selectUninByStock(String appno) {
    	 Map map=new HashMap() ;
    	 map.put("appno", appno);
    	List<ABcpMoreDvyChkStockDtl> list = getSqlMapClientTemplate().queryForList("A_BCP_MORE_DVY_CHK_STOCK_DTL.selectUninByStock", map);
        return list;
    }
    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends ABcpMoreDvyChkStockDtlExample {
        private Object record;

        public UpdateByExampleParms(Object record, ABcpMoreDvyChkStockDtlExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}