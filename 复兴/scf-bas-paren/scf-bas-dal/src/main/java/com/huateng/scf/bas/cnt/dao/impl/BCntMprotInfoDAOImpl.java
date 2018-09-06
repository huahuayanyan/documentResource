package com.huateng.scf.bas.cnt.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntMprotInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BCntMprotInfoDAO")
public class BCntMprotInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntMprotInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntMprotInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntMprotInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_BUY_MPROT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntMprotInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_BUY_MPROT_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String mortgageNo) {
        BCntMprotInfo _key = new BCntMprotInfo();
        _key.setMortgageNo(mortgageNo);
        int rows = getSqlMapClientTemplate().delete("B_CNT_BUY_MPROT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntMprotInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_BUY_MPROT_INFO.insert", record);
    }

    public void insertSelective(BCntMprotInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_BUY_MPROT_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotInfo> selectByExample(BCntMprotInfoExample example) {
        List<BCntMprotInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_BUY_MPROT_INFO.selectByExample", example);
        return list;
    }

    public BCntMprotInfo selectByPrimaryKey(String mortgageNo) {
        BCntMprotInfo _key = new BCntMprotInfo();
        _key.setMortgageNo(mortgageNo);
        BCntMprotInfo record = (BCntMprotInfo) getSqlMapClientTemplate().queryForObject("B_CNT_BUY_MPROT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntMprotInfo record, BCntMprotInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_BUY_MPROT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntMprotInfo record, BCntMprotInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_BUY_MPROT_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntMprotInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_BUY_MPROT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntMprotInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_BUY_MPROT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotInfo> selectByPage(BCntMprotInfoExample example, Page page) {
        List<BCntMprotInfo> list = this.searchListPageMyObject("B_CNT_BUY_MPROT_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntMprotInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntMprotInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public int deleteByObject(BCntMprotInfo bCntMprotInfo) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_BUY_MPROT_INFO.deleteByPrimaryKey", bCntMprotInfo);
        return rows;
	}
}