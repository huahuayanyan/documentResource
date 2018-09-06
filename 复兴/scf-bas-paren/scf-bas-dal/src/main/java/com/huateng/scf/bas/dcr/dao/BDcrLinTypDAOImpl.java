package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.dcr.model.BDcrLinTyp;
import com.huateng.scf.bas.dcr.model.BDcrLinTypExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BDcrLinTypDAO")
public class BDcrLinTypDAOImpl extends IbatisDaoAnnotation4Template implements BDcrLinTypDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BDcrLinTypDAOImpl() {
        super();
    }

    public int countByExample(BDcrLinTypExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_DCR_LIN_TYP.countByExample", example);
        return count;
    }

    public int deleteByExample(BDcrLinTypExample example) {
        int rows = getSqlMapClientTemplate().delete("B_DCR_LIN_TYP.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String crId) {
        BDcrLinTyp _key = new BDcrLinTyp();
        _key.setCrId(crId);
        int rows = getSqlMapClientTemplate().delete("B_DCR_LIN_TYP.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BDcrLinTyp record) {
        getSqlMapClientTemplate().insert("B_DCR_LIN_TYP.insert", record);
    }

    public void insertSelective(BDcrLinTyp record) {
        getSqlMapClientTemplate().insert("B_DCR_LIN_TYP.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BDcrLinTyp> selectByExample(BDcrLinTypExample example) {
        List<BDcrLinTyp> list = getSqlMapClientTemplate().queryForList("B_DCR_LIN_TYP.selectByExample", example);
        return list;
    }

    public BDcrLinTyp selectByPrimaryKey(String crId) {
        BDcrLinTyp _key = new BDcrLinTyp();
        _key.setCrId(crId);
        BDcrLinTyp record = (BDcrLinTyp) getSqlMapClientTemplate().queryForObject("B_DCR_LIN_TYP.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BDcrLinTyp record, BDcrLinTypExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_TYP.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BDcrLinTyp record, BDcrLinTypExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_TYP.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BDcrLinTyp record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_TYP.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BDcrLinTyp record) {
        int rows = getSqlMapClientTemplate().update("B_DCR_LIN_TYP.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BDcrLinTyp> selectByPage(BDcrLinTypExample example, Page page) {
        List<BDcrLinTyp> list = this.searchListPageMyObject("B_DCR_LIN_TYP.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BDcrLinTypExample {
        private Object record;

        public UpdateByExampleParms(Object record, BDcrLinTypExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}