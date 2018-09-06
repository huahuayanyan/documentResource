package com.huateng.scf.bas.bcp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.bcp.dao.ISBcpAppliLowerPriceDAO;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPrice;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPriceExample;

@Repository("SBcpAppliLowerPriceDAO")
public class SBcpAppliLowerPriceDAOImpl extends IbatisDaoAnnotation4Template implements ISBcpAppliLowerPriceDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public SBcpAppliLowerPriceDAOImpl() {
        super();
    }

    public int countByExample(SBcpAppliLowerPriceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("S_BCP_APPLI_LOWER_PRICE.countByExample", example);
        return count;
    }

    public int deleteByExample(SBcpAppliLowerPriceExample example) {
        int rows = getSqlMapClientTemplate().delete("S_BCP_APPLI_LOWER_PRICE.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        SBcpAppliLowerPrice _key = new SBcpAppliLowerPrice();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("S_BCP_APPLI_LOWER_PRICE.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SBcpAppliLowerPrice record) {
        getSqlMapClientTemplate().insert("S_BCP_APPLI_LOWER_PRICE.insert", record);
    }

    public void insertSelective(SBcpAppliLowerPrice record) {
        getSqlMapClientTemplate().insert("S_BCP_APPLI_LOWER_PRICE.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<SBcpAppliLowerPrice> selectByExample(SBcpAppliLowerPriceExample example) {
        List<SBcpAppliLowerPrice> list = getSqlMapClientTemplate().queryForList("S_BCP_APPLI_LOWER_PRICE.selectByExample", example);
        return list;
    }

    public SBcpAppliLowerPrice selectByPrimaryKey(String id) {
        SBcpAppliLowerPrice _key = new SBcpAppliLowerPrice();
        _key.setId(id);
        SBcpAppliLowerPrice record = (SBcpAppliLowerPrice) getSqlMapClientTemplate().queryForObject("S_BCP_APPLI_LOWER_PRICE.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(SBcpAppliLowerPrice record, SBcpAppliLowerPriceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_LOWER_PRICE.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(SBcpAppliLowerPrice record, SBcpAppliLowerPriceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_LOWER_PRICE.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(SBcpAppliLowerPrice record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_LOWER_PRICE.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SBcpAppliLowerPrice record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_APPLI_LOWER_PRICE.updateByPrimaryKey", record);
        return rows;
    }
	@SuppressWarnings("unchecked")
	public List<SBcpAppliLowerPrice> selectByAppno(String appno) {
    	SBcpAppliLowerPrice _key = new SBcpAppliLowerPrice();
        _key.setAppno(appno);
        List<SBcpAppliLowerPrice> list  = getSqlMapClientTemplate().queryForList("S_BCP_APPLI_LOWER_PRICE.selectByAppno", _key);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<SBcpAppliLowerPrice> selectByPage(SBcpAppliLowerPriceExample example, Page page) {
        List<SBcpAppliLowerPrice> list = this.searchListPageMyObject("S_BCP_APPLI_LOWER_PRICE.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends SBcpAppliLowerPriceExample {
        private Object record;

        public UpdateByExampleParms(Object record, SBcpAppliLowerPriceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }


}