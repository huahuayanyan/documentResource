package com.huateng.scf.bas.icr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.icr.dao.IBIcrBrcodeListDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList;
import com.huateng.scf.bas.icr.dao.model.BIcrBrcodeList;
import com.huateng.scf.bas.icr.dao.model.BIcrBrcodeListExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BIcrBrcodeListDAO")
public class BIcrBrcodeListDAOImpl extends IbatisDaoAnnotation4Template implements IBIcrBrcodeListDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BIcrBrcodeListDAOImpl() {
        super();
    }

    public int countByExample(BIcrBrcodeListExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_ICR_BRCODE_LIST.countByExample", example);
        return count;
    }

    public int deleteByExample(BIcrBrcodeListExample example) {
        int rows = getSqlMapClientTemplate().delete("B_ICR_BRCODE_LIST.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BIcrBrcodeList _key = new BIcrBrcodeList();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_ICR_BRCODE_LIST.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BIcrBrcodeList record) {
        getSqlMapClientTemplate().insert("B_ICR_BRCODE_LIST.insert", record);
    }

    public void insertSelective(BIcrBrcodeList record) {
        getSqlMapClientTemplate().insert("B_ICR_BRCODE_LIST.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BIcrBrcodeList> selectByExample(BIcrBrcodeListExample example) {
        List<BIcrBrcodeList> list = getSqlMapClientTemplate().queryForList("B_ICR_BRCODE_LIST.selectByExample", example);
        return list;
    }

    public BIcrBrcodeList selectByPrimaryKey(String id) {
        BIcrBrcodeList _key = new BIcrBrcodeList();
        _key.setId(id);
        BIcrBrcodeList record = (BIcrBrcodeList) getSqlMapClientTemplate().queryForObject("B_ICR_BRCODE_LIST.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BIcrBrcodeList record, BIcrBrcodeListExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_BRCODE_LIST.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BIcrBrcodeList record, BIcrBrcodeListExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_BRCODE_LIST.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BIcrBrcodeList record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_BRCODE_LIST.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BIcrBrcodeList record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_BRCODE_LIST.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BIcrBrcodeList> selectByPage(BIcrBrcodeListExample example, Page page) {
        List<BIcrBrcodeList> list = this.searchListPageMyObject("B_ICR_BRCODE_LIST.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BIcrBrcodeListExample {
        private Object record;

        public UpdateByExampleParms(Object record, BIcrBrcodeListExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //ext
    
    public int deleteBrcodeListByNo(BIcrBrcodeList bIcrBrcodeList) {
      
        int rows = getSqlMapClientTemplate().delete("EXT_B_ICR_BRCODE_LIST.deleteBrcodeListByNo", bIcrBrcodeList);
        return rows;
    }
}