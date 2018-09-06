package com.huateng.scf.bas.nte.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.nte.dao.IBNteNoticeLnciDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeLnci;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeLnciExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BNteNoticeLnciDAO")
public class BNteNoticeLnciDAOImpl extends IbatisDaoAnnotation4Template implements IBNteNoticeLnciDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BNteNoticeLnciDAOImpl() {
        super();
    }

    public int countByExample(BNteNoticeLnciExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_NTE_NOTICE_LNCI.countByExample", example);
        return count;
    }

    public int deleteByExample(BNteNoticeLnciExample example) {
        int rows = getSqlMapClientTemplate().delete("B_NTE_NOTICE_LNCI.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BNteNoticeLnci _key = new BNteNoticeLnci();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_NTE_NOTICE_LNCI.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BNteNoticeLnci record) {
        getSqlMapClientTemplate().insert("B_NTE_NOTICE_LNCI.insert", record);
    }

    public void insertSelective(BNteNoticeLnci record) {
        getSqlMapClientTemplate().insert("B_NTE_NOTICE_LNCI.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BNteNoticeLnci> selectByExample(BNteNoticeLnciExample example) {
        List<BNteNoticeLnci> list = getSqlMapClientTemplate().queryForList("B_NTE_NOTICE_LNCI.selectByExample", example);
        return list;
    }

    public BNteNoticeLnci selectByPrimaryKey(String id) {
        BNteNoticeLnci _key = new BNteNoticeLnci();
        _key.setId(id);
        BNteNoticeLnci record = (BNteNoticeLnci) getSqlMapClientTemplate().queryForObject("B_NTE_NOTICE_LNCI.selectByPrimaryKey", _key);
        return record;
    }
    public List<BNteNoticeLnci>  selectByDebetNo(String debetNo) {
    	BNteNoticeLnci _key = new BNteNoticeLnci();
    	_key.setDebetNo(debetNo);
    	List<BNteNoticeLnci> list =  getSqlMapClientTemplate().queryForList("B_NTE_NOTICE_LNCI.selectByDebetNo", _key);
    	return list;
    }

    public int updateByExampleSelective(BNteNoticeLnci record, BNteNoticeLnciExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_LNCI.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BNteNoticeLnci record, BNteNoticeLnciExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_LNCI.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BNteNoticeLnci record) {
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_LNCI.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BNteNoticeLnci record) {
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_LNCI.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BNteNoticeLnci> selectByPage(BNteNoticeLnciExample example, Page page) {
        List<BNteNoticeLnci> list = this.searchListPageMyObject("B_NTE_NOTICE_LNCI.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BNteNoticeLnciExample {
        private Object record;

        public UpdateByExampleParms(Object record, BNteNoticeLnciExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}