package com.huateng.scf.rec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("RBcpAppliRepaymentDAO")
public class RBcpAppliRepaymentDAOImpl extends IbatisDaoAnnotation4Template implements RBcpAppliRepaymentDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public RBcpAppliRepaymentDAOImpl() {
        super();
    }

    public int countByExample(RBcpAppliRepaymentExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("R_BCP_APPLI_REPAYMENT.countByExample", example);
        return count;
    }

    public int deleteByExample(RBcpAppliRepaymentExample example) {
        int rows = getSqlMapClientTemplate().delete("R_BCP_APPLI_REPAYMENT.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        RBcpAppliRepayment _key = new RBcpAppliRepayment();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("R_BCP_APPLI_REPAYMENT.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RBcpAppliRepayment record) {
        getSqlMapClientTemplate().insert("R_BCP_APPLI_REPAYMENT.insert", record);
    }

    public void insertSelective(RBcpAppliRepayment record) {
        getSqlMapClientTemplate().insert("R_BCP_APPLI_REPAYMENT.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RBcpAppliRepayment> selectByExample(RBcpAppliRepaymentExample example) {
        List<RBcpAppliRepayment> list = getSqlMapClientTemplate().queryForList("R_BCP_APPLI_REPAYMENT.selectByExample", example);
        return list;
    }

    public RBcpAppliRepayment selectByPrimaryKey(String id) {
        RBcpAppliRepayment _key = new RBcpAppliRepayment();
        _key.setId(id);
        RBcpAppliRepayment record = (RBcpAppliRepayment) getSqlMapClientTemplate().queryForObject("R_BCP_APPLI_REPAYMENT.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RBcpAppliRepayment record, RBcpAppliRepaymentExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_REPAYMENT.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RBcpAppliRepayment record, RBcpAppliRepaymentExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_REPAYMENT.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RBcpAppliRepayment record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_REPAYMENT.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RBcpAppliRepayment record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_REPAYMENT.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<RBcpAppliRepayment> selectByPage(RBcpAppliRepaymentExample example, Page page) {
        List<RBcpAppliRepayment> list = this.searchListPageMyObject("R_BCP_APPLI_REPAYMENT.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends RBcpAppliRepaymentExample {
        private Object record;

        public UpdateByExampleParms(Object record, RBcpAppliRepaymentExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}