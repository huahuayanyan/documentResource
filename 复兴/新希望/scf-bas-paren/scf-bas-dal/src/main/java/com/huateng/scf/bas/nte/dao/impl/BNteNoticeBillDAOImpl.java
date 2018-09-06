package com.huateng.scf.bas.nte.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBillDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBill;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBillExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BNteNoticeBillDAO")
public class BNteNoticeBillDAOImpl extends IbatisDaoAnnotation4Template implements IBNteNoticeBillDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BNteNoticeBillDAOImpl() {
        super();
    }

    public int countByExample(BNteNoticeBillExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_NTE_NOTICE_BILL.countByExample", example);
        return count;
    }

    public int deleteByExample(BNteNoticeBillExample example) {
        int rows = getSqlMapClientTemplate().delete("B_NTE_NOTICE_BILL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BNteNoticeBill _key = new BNteNoticeBill();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_NTE_NOTICE_BILL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BNteNoticeBill record) {
        getSqlMapClientTemplate().insert("B_NTE_NOTICE_BILL.insert", record);
    }

    public void insertSelective(BNteNoticeBill record) {
        getSqlMapClientTemplate().insert("B_NTE_NOTICE_BILL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BNteNoticeBill> selectByExample(BNteNoticeBillExample example) {
        List<BNteNoticeBill> list = getSqlMapClientTemplate().queryForList("B_NTE_NOTICE_BILL.selectByExample", example);
        return list;
    }

    public BNteNoticeBill selectByPrimaryKey(String id) {
        BNteNoticeBill _key = new BNteNoticeBill();
        _key.setId(id);
        BNteNoticeBill record = (BNteNoticeBill) getSqlMapClientTemplate().queryForObject("B_NTE_NOTICE_BILL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BNteNoticeBill record, BNteNoticeBillExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_BILL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BNteNoticeBill record, BNteNoticeBillExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_BILL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BNteNoticeBill record) {
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_BILL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BNteNoticeBill record) {
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_BILL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BNteNoticeBill> selectByPage(BNteNoticeBillExample example, Page page) {
        List<BNteNoticeBill> list = this.searchListPageMyObject("B_NTE_NOTICE_BILL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BNteNoticeBillExample {
        private Object record;

        public UpdateByExampleParms(Object record, BNteNoticeBillExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    /**
     * 通过APPNO查找通知书票据信息
     */
	@Override
	public List<BNteNoticeBill> findBNteNoticeBillByAppno(String appno) {
		 List<BNteNoticeBill> list = getSqlMapClientTemplate().queryForList("EXT_B_NTE_NOTICE_BILL.findBNteNoticeBillByAppno", appno);
	     return list;
	}
}