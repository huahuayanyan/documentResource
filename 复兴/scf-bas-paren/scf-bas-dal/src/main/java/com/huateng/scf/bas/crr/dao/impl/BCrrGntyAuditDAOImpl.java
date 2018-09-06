package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrGntyAuditDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyAudit;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyAuditExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrGntyAudit数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月24日下午3:41:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月24日下午3:41:53	     新增
 *
 * </pre>
 */
@Repository("IBCrrGntyAuditDAO")
public class BCrrGntyAuditDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrGntyAuditDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrGntyAuditDAOImpl() {
        super();
    }

    public int countByExample(BCrrGntyAuditExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_AUDIT.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrGntyAuditExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_AUDIT.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String serialno) {
        BCrrGntyAudit _key = new BCrrGntyAudit();
        _key.setSerialno(serialno);
        int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_AUDIT.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrGntyAudit record) {
        getSqlMapClientTemplate().insert("B_CRR_GNTY_AUDIT.insert", record);
    }

    public void insertSelective(BCrrGntyAudit record) {
        getSqlMapClientTemplate().insert("B_CRR_GNTY_AUDIT.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrGntyAudit> selectByExample(BCrrGntyAuditExample example) {
        List<BCrrGntyAudit> list = getSqlMapClientTemplate().queryForList("B_CRR_GNTY_AUDIT.selectByExample", example);
        return list;
    }

    public BCrrGntyAudit selectByPrimaryKey(String serialno) {
        BCrrGntyAudit _key = new BCrrGntyAudit();
        _key.setSerialno(serialno);
        BCrrGntyAudit record = (BCrrGntyAudit) getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_AUDIT.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrGntyAudit record, BCrrGntyAuditExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_AUDIT.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrGntyAudit record, BCrrGntyAuditExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_AUDIT.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrGntyAudit record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_AUDIT.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrGntyAudit record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_AUDIT.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrGntyAudit> selectByPage(BCrrGntyAuditExample example, Page page) {
        List<BCrrGntyAudit> list = this.searchListPageMyObject("B_CRR_GNTY_AUDIT.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrGntyAuditExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrGntyAuditExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}