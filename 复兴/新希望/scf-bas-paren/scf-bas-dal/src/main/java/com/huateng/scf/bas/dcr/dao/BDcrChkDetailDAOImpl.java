package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.dcr.model.BDcrChkDetail;
import com.huateng.scf.bas.dcr.model.BDcrChkDetailExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BDcrChkDetailDAO")
public class BDcrChkDetailDAOImpl extends IbatisDaoAnnotation4Template implements BDcrChkDetailDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BDcrChkDetailDAOImpl() {
        super();
    }

    public int countByExample(BDcrChkDetailExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_DCR_CHK_DETAIL.countByExample", example);
        return count;
    }

    public int deleteByExample(BDcrChkDetailExample example) {
        int rows = getSqlMapClientTemplate().delete("B_DCR_CHK_DETAIL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String chkDetailId) {
        BDcrChkDetail _key = new BDcrChkDetail();
        _key.setChkDetailId(chkDetailId);
        int rows = getSqlMapClientTemplate().delete("B_DCR_CHK_DETAIL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BDcrChkDetail record) {
        getSqlMapClientTemplate().insert("B_DCR_CHK_DETAIL.insert", record);
    }

    public void insertSelective(BDcrChkDetail record) {
        getSqlMapClientTemplate().insert("B_DCR_CHK_DETAIL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BDcrChkDetail> selectByExample(BDcrChkDetailExample example) {
        List<BDcrChkDetail> list = getSqlMapClientTemplate().queryForList("B_DCR_CHK_DETAIL.selectByExample", example);
        return list;
    }

    public BDcrChkDetail selectByPrimaryKey(String chkDetailId) {
        BDcrChkDetail _key = new BDcrChkDetail();
        _key.setChkDetailId(chkDetailId);
        BDcrChkDetail record = (BDcrChkDetail) getSqlMapClientTemplate().queryForObject("B_DCR_CHK_DETAIL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BDcrChkDetail record, BDcrChkDetailExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_CHK_DETAIL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BDcrChkDetail record, BDcrChkDetailExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_CHK_DETAIL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BDcrChkDetail record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_CHK_DETAIL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BDcrChkDetail record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_CHK_DETAIL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BDcrChkDetail> selectByPage(BDcrChkDetailExample example, Page page) {
        List<BDcrChkDetail> list = this.searchListPageMyObject("B_DCR_CHK_DETAIL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BDcrChkDetailExample {
        private Object record;

        public UpdateByExampleParms(Object record, BDcrChkDetailExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}