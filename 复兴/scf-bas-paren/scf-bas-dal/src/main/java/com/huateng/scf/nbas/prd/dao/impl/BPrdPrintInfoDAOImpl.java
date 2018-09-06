package com.huateng.scf.nbas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nbas.prd.dao.IBPrdPrintInfoDAO;
import com.huateng.scf.nbas.prd.dao.model.BPrdPrintInfo;
import com.huateng.scf.nbas.prd.dao.model.BPrdPrintInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBPrdPrintInfoDAO")
public class BPrdPrintInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdPrintInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdPrintInfoDAOImpl() {
        super();
    }

    public int countByExample(BPrdPrintInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_PRINT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdPrintInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_PRINT_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdPrintInfo _key = new BPrdPrintInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_PRINT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdPrintInfo record) {
        getSqlMapClientTemplate().insert("B_PRD_PRINT_INFO.insert", record);
    }

    public void insertSelective(BPrdPrintInfo record) {
        getSqlMapClientTemplate().insert("B_PRD_PRINT_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdPrintInfo> selectByExampleWithBLOBs(BPrdPrintInfoExample example) {
        List<BPrdPrintInfo> list = getSqlMapClientTemplate().queryForList("B_PRD_PRINT_INFO.selectByExampleWithBLOBs", example);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdPrintInfo> selectByExampleWithoutBLOBs(BPrdPrintInfoExample example) {
        List<BPrdPrintInfo> list = getSqlMapClientTemplate().queryForList("B_PRD_PRINT_INFO.selectByExample", example);
        return list;
    }

    public BPrdPrintInfo selectByPrimaryKey(String id) {
        BPrdPrintInfo _key = new BPrdPrintInfo();
        _key.setId(id);
        BPrdPrintInfo record = (BPrdPrintInfo) getSqlMapClientTemplate().queryForObject("B_PRD_PRINT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdPrintInfo record, BPrdPrintInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_PRINT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExampleWithBLOBs(BPrdPrintInfo record, BPrdPrintInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_PRINT_INFO.updateByExampleWithBLOBs", parms);
        return rows;
    }

    public int updateByExampleWithoutBLOBs(BPrdPrintInfo record, BPrdPrintInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_PRINT_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdPrintInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_PRINT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKeyWithBLOBs(BPrdPrintInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_PRINT_INFO.updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    public int updateByPrimaryKeyWithoutBLOBs(BPrdPrintInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_PRINT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdPrintInfo> selectByPage(BPrdPrintInfoExample example, Page page) {
        List<BPrdPrintInfo> list = this.searchListPageMyObject("B_PRD_PRINT_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdPrintInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdPrintInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}