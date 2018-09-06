package com.huateng.scf.adv.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.bcp.dao.IABcpMoreDvyChkStockDAO;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStock;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStockExample;
import com.huateng.scf.adv.bcp.dao.model.ThreeCheckStockDebetVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("ABcpMoreDvyChkStockDAO")
public class ABcpMoreDvyChkStockDAOImpl extends IbatisDaoAnnotation4Template implements IABcpMoreDvyChkStockDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public ABcpMoreDvyChkStockDAOImpl() {
        super();
    }

    public int countByExample(ABcpMoreDvyChkStockExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("A_BCP_MORE_DVY_CHK_STOCK.countByExample", example);
        return count;
    }

    public int deleteByExample(ABcpMoreDvyChkStockExample example) {
        int rows = getSqlMapClientTemplate().delete("A_BCP_MORE_DVY_CHK_STOCK.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        ABcpMoreDvyChkStock _key = new ABcpMoreDvyChkStock();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("A_BCP_MORE_DVY_CHK_STOCK.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(ABcpMoreDvyChkStock record) {
        getSqlMapClientTemplate().insert("A_BCP_MORE_DVY_CHK_STOCK.insert", record);
    }

    public void insertSelective(ABcpMoreDvyChkStock record) {
        getSqlMapClientTemplate().insert("A_BCP_MORE_DVY_CHK_STOCK.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<ABcpMoreDvyChkStock> selectByExample(ABcpMoreDvyChkStockExample example) {
        List<ABcpMoreDvyChkStock> list = getSqlMapClientTemplate().queryForList("A_BCP_MORE_DVY_CHK_STOCK.selectByExample", example);
        return list;
    }

    public ABcpMoreDvyChkStock selectByPrimaryKey(String id) {
        ABcpMoreDvyChkStock _key = new ABcpMoreDvyChkStock();
        _key.setId(id);
        ABcpMoreDvyChkStock record = (ABcpMoreDvyChkStock) getSqlMapClientTemplate().queryForObject("A_BCP_MORE_DVY_CHK_STOCK.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(ABcpMoreDvyChkStock record, ABcpMoreDvyChkStockExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("A_BCP_MORE_DVY_CHK_STOCK.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(ABcpMoreDvyChkStock record, ABcpMoreDvyChkStockExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("A_BCP_MORE_DVY_CHK_STOCK.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(ABcpMoreDvyChkStock record) {
        int rows = getSqlMapClientTemplate().update("A_BCP_MORE_DVY_CHK_STOCK.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(ABcpMoreDvyChkStock record) {
        int rows = getSqlMapClientTemplate().update("A_BCP_MORE_DVY_CHK_STOCK.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<ABcpMoreDvyChkStock> selectByPage(ABcpMoreDvyChkStockExample example, Page page) {
        List<ABcpMoreDvyChkStock> list = this.searchListPageMyObject("A_BCP_MORE_DVY_CHK_STOCK.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends ABcpMoreDvyChkStockExample {
        private Object record;

        public UpdateByExampleParms(Object record, ABcpMoreDvyChkStockExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public List<ABcpMoreDvyChkStock> queryCheckStock(Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<ABcpMoreDvyChkStock> list =  this.searchListPageMyObject("EXT_CHECKSTOCK.queryCheckStockList",param, page);
        return list;
	}

	@Override
	public List<ThreeCheckStockDebetVO> getThreeCheckStockDebetQry(Map<String, String> param, Page page) {
		@SuppressWarnings("unchecked")
		List<ThreeCheckStockDebetVO> list =  this.searchListPageMyObject("EXT_CHECKSTOCK.threeCheckStockDebetQry",param, page);
        return list;
	}

	@Override
	public int getThreeCheckStockDebetNum(Map<String, String> param) {
		@SuppressWarnings("unchecked")
		List<ThreeCheckStockDebetVO> list = getSqlMapClientTemplate().queryForList("EXT_CHECKSTOCK.threeCheckStockDebetQry", param);
        return list.size();
	}

	@Override
	public List<ThreeCheckStockDebetVO> getThreeCheckStockDebetQry(Map<String, String> param) {
		@SuppressWarnings("unchecked")
		List<ThreeCheckStockDebetVO> list = getSqlMapClientTemplate().queryForList("EXT_CHECKSTOCK.threeCheckStockDebetQry", param);
        return list;
	}

	@Override
	public List<Map<String, String>> getSumQuantityByDebetNo(Map<String, String> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = getSqlMapClientTemplate().queryForList("EXT_CHECKSTOCK.getSumQuantityByDebetNo", param);
        return list;
	}
	
	@Override
	public List<Map<String, Object>> getSumQuantityByNoticeType(Map<String, String> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_CHECKSTOCK.getSumQuantityByNoticeType", param);
		return list;
	}

	@Override
	public List<Map<String, Object>> getCheckStockAmtByProtocol(Map<String, String> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_CHECKSTOCK.getCheckStockAmtByProtocol", param);
        return list;
	}
}