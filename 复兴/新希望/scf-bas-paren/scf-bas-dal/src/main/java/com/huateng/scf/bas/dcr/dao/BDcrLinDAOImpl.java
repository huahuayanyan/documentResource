package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.dcr.model.BDcrLin;
import com.huateng.scf.bas.dcr.model.BDcrLinExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BDcrLinDAO")
public class BDcrLinDAOImpl extends IbatisDaoAnnotation4Template implements BDcrLinDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BDcrLinDAOImpl() {
        super();
    }

    public int countByExample(BDcrLinExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_DCR_LIN.countByExample", example);
        return count;
    }

    public int deleteByExample(BDcrLinExample example) {
        int rows = getSqlMapClientTemplate().delete("B_DCR_LIN.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String bcCrId) {
        BDcrLin _key = new BDcrLin();
        _key.setBcCrId(bcCrId);
        int rows = getSqlMapClientTemplate().delete("B_DCR_LIN.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BDcrLin record) {
        getSqlMapClientTemplate().insert("B_DCR_LIN.insert", record);
    }

    public void insertSelective(BDcrLin record) {
        getSqlMapClientTemplate().insert("B_DCR_LIN.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BDcrLin> selectByExample(BDcrLinExample example) {
        List<BDcrLin> list = getSqlMapClientTemplate().queryForList("B_DCR_LIN.selectByExample", example);
        return list;
    }

    public BDcrLin selectByPrimaryKey(String bcCrId) {
        BDcrLin _key = new BDcrLin();
        _key.setBcCrId(bcCrId);
        BDcrLin record = (BDcrLin) getSqlMapClientTemplate().queryForObject("B_DCR_LIN.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BDcrLin record, BDcrLinExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BDcrLin record, BDcrLinExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BDcrLin record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BDcrLin record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BDcrLin> selectByPage(BDcrLinExample example, Page page) {
        List<BDcrLin> list = this.searchListPageMyObject("B_DCR_LIN.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BDcrLinExample {
        private Object record;

        public UpdateByExampleParms(Object record, BDcrLinExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}