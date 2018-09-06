package com.huateng.scf.bas.icr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.icr.dao.IBIcrAppliBrcodeListDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeListExample;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliInfo;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BIcrAppliBrcodeListDAO")
public class BIcrAppliBrcodeListDAOImpl extends IbatisDaoAnnotation4Template implements IBIcrAppliBrcodeListDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BIcrAppliBrcodeListDAOImpl() {
        super();
    }

    public int countByExample(BIcrAppliBrcodeListExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_ICR_APPLI_BRCODE_LIST.countByExample", example);
        return count;
    }

    public int deleteByExample(BIcrAppliBrcodeListExample example) {
        int rows = getSqlMapClientTemplate().delete("B_ICR_APPLI_BRCODE_LIST.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BIcrAppliBrcodeList _key = new BIcrAppliBrcodeList();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_ICR_APPLI_BRCODE_LIST.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BIcrAppliBrcodeList record) {
        getSqlMapClientTemplate().insert("B_ICR_APPLI_BRCODE_LIST.insert", record);
    }

    public void insertSelective(BIcrAppliBrcodeList record) {
        getSqlMapClientTemplate().insert("B_ICR_APPLI_BRCODE_LIST.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BIcrAppliBrcodeList> selectByExample(BIcrAppliBrcodeListExample example) {
        List<BIcrAppliBrcodeList> list = getSqlMapClientTemplate().queryForList("B_ICR_APPLI_BRCODE_LIST.selectByExample", example);
        return list;
    }

    public BIcrAppliBrcodeList selectByPrimaryKey(String id) {
        BIcrAppliBrcodeList _key = new BIcrAppliBrcodeList();
        _key.setId(id);
        BIcrAppliBrcodeList record = (BIcrAppliBrcodeList) getSqlMapClientTemplate().queryForObject("B_ICR_APPLI_BRCODE_LIST.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BIcrAppliBrcodeList record, BIcrAppliBrcodeListExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_BRCODE_LIST.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BIcrAppliBrcodeList record, BIcrAppliBrcodeListExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_BRCODE_LIST.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BIcrAppliBrcodeList record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_BRCODE_LIST.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BIcrAppliBrcodeList record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_BRCODE_LIST.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BIcrAppliBrcodeList> selectByPage(BIcrAppliBrcodeListExample example, Page page) {
        List<BIcrAppliBrcodeList> list = this.searchListPageMyObject("B_ICR_APPLI_BRCODE_LIST.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BIcrAppliBrcodeListExample {
        private Object record;

        public UpdateByExampleParms(Object record, BIcrAppliBrcodeListExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    //ext
    
    public int deleteAppliBrcodeListByNo(BIcrAppliBrcodeList bIcrAppliBrcodeList) {
      
        int rows = getSqlMapClientTemplate().delete("EXT_B_ICR_APPLI_BRCODE_LIST.deleteAppliBrcodeListByNo", bIcrAppliBrcodeList);
        return rows;
    }
    /**
     * 
     */
	@Override
	public List<BIcrAppliBrcodeList> queryBIcrAppliBrcodeListByCreditNo(BIcrAppliBrcodeList bIcrAppliBrcodeList) {
		 List<BIcrAppliBrcodeList> list= getSqlMapClientTemplate().queryForList("EXT_B_ICR_APPLI_BRCODE_LIST.selectBIcrAppliBrcodeLisBycreditNo", bIcrAppliBrcodeList);
		 return list;
	}
    
    
    
}