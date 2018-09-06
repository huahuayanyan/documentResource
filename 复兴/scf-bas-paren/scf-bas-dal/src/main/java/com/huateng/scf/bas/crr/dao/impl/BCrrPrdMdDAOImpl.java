package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrPrdMdDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMd;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMdExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBCrrPrdMdDAO")
public class BCrrPrdMdDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrPrdMdDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrPrdMdDAOImpl() {
        super();
    }

    public int countByExample(BCrrPrdMdExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_PRD_MD.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrPrdMdExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_PRD_MD.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String prdId) {
        BCrrPrdMd _key = new BCrrPrdMd();
        _key.setPrdId(prdId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_PRD_MD.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrPrdMd record) {
        getSqlMapClientTemplate().insert("B_CRR_PRD_MD.insert", record);
    }

    public void insertSelective(BCrrPrdMd record) {
        getSqlMapClientTemplate().insert("B_CRR_PRD_MD.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrPrdMd> selectByExample(BCrrPrdMdExample example) {
        List<BCrrPrdMd> list = getSqlMapClientTemplate().queryForList("B_CRR_PRD_MD.selectByExample", example);
        return list;
    }

    public BCrrPrdMd selectByPrimaryKey(String prdId) {
        BCrrPrdMd _key = new BCrrPrdMd();
        _key.setPrdId(prdId);
        BCrrPrdMd record = (BCrrPrdMd) getSqlMapClientTemplate().queryForObject("B_CRR_PRD_MD.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrPrdMd record, BCrrPrdMdExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_PRD_MD.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrPrdMd record, BCrrPrdMdExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_PRD_MD.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrPrdMd record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_PRD_MD.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrPrdMd record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_PRD_MD.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrPrdMd> selectByPage(BCrrPrdMdExample example, Page page) {
        List<BCrrPrdMd> list = this.searchListPageMyObject("B_CRR_PRD_MD.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrPrdMdExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrPrdMdExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

    @Override
    public BCrrPrdMd selectByPrdNm(String prdNm) {
        BCrrPrdMd _key = new BCrrPrdMd();
        _key.setPrdNm(prdNm);
        BCrrPrdMd record = (BCrrPrdMd) getSqlMapClientTemplate().queryForObject("B_CRR_PRD_MD.selectByPrdNm", _key);
        return record;
    }

    @SuppressWarnings("unchecked")
    @Override
	public List<BCrrPrdMd> selectByPrdMd(BCrrPrdMd bCrrPrdMd) {
    	List<BCrrPrdMd> record =  getSqlMapClientTemplate().queryForList("B_CRR_PRD_MD.selectByPrdMd", bCrrPrdMd);
        return record;
	}

}