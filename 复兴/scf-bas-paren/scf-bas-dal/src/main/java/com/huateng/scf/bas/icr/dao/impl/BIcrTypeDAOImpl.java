package com.huateng.scf.bas.icr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.icr.dao.IBIcrTypeDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrType;
import com.huateng.scf.bas.icr.dao.model.BIcrTypeExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BIcrTypeDAO")
public class BIcrTypeDAOImpl extends IbatisDaoAnnotation4Template implements IBIcrTypeDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BIcrTypeDAOImpl() {
        super();
    }

    public int countByExample(BIcrTypeExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_ICR_TYPE.countByExample", example);
        return count;
    }

    public int deleteByExample(BIcrTypeExample example) {
        int rows = getSqlMapClientTemplate().delete("B_ICR_TYPE.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BIcrType _key = new BIcrType();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_ICR_TYPE.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BIcrType record) {
        getSqlMapClientTemplate().insert("B_ICR_TYPE.insert", record);
    }

    public void insertSelective(BIcrType record) {
        getSqlMapClientTemplate().insert("B_ICR_TYPE.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BIcrType> selectByExample(BIcrTypeExample example) {
        List<BIcrType> list = getSqlMapClientTemplate().queryForList("B_ICR_TYPE.selectByExample", example);
        return list;
    }

    public BIcrType selectByPrimaryKey(String id) {
        BIcrType _key = new BIcrType();
        _key.setId(id);
        BIcrType record = (BIcrType) getSqlMapClientTemplate().queryForObject("B_ICR_TYPE.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BIcrType record, BIcrTypeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_TYPE.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BIcrType record, BIcrTypeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_TYPE.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BIcrType record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_TYPE.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BIcrType record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_TYPE.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BIcrType> selectByPage(BIcrTypeExample example, Page page) {
        List<BIcrType> list = this.searchListPageMyObject("B_ICR_TYPE.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BIcrTypeExample {
        private Object record;

        public UpdateByExampleParms(Object record, BIcrTypeExample example) {
            super(example);
            this.record = record;
        }

        
        public Object getRecord() {
            return record;
        }
    }
    
    //ext
    
	public int batchDelete(List idList) {
		return getSqlMapClientTemplate().delete("EXT_B_ICR_TYPE.batchDelete", idList);
	}
	//额度种类筛选
   public List<BIcrType> selectBIcrType(BIcrType bIcrType, Page page) {
        List<BIcrType> list = this.searchListPageMyObject("EXT_B_ICR_TYPE.selectBIcrType", bIcrType, page);
        return list;
    }
   /**
    * 获得额度种类
    * @param bIcrType
    * @return
    */
   public List<BIcrType> findBIcrTypeByBIcrType(BIcrType bIcrType) {
       List<BIcrType> list = getSqlMapClientTemplate().queryForList("EXT_B_ICR_TYPE.findBIcrTypeByBIcrType", bIcrType);
       return list;
   }
}