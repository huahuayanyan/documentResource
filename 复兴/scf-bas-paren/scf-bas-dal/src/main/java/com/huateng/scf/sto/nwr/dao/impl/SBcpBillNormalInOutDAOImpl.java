package com.huateng.scf.sto.nwr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.sto.nwr.dao.ISBcpBillNormalInOutDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpBillNormalInOut;
import com.huateng.scf.sto.nwr.dao.model.SBcpBillNormalInOutExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * 
 * <p>仓单信息流水	数据库访问层通用接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月19日上午11:14:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月19日上午11:14:14	     新增
 *
 * </pre>
 */
@Repository("ISBcpBillNormalInOutDAO")
public class SBcpBillNormalInOutDAOImpl extends IbatisDaoAnnotation4Template implements ISBcpBillNormalInOutDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public SBcpBillNormalInOutDAOImpl() {
        super();
    }

    public int countByExample(SBcpBillNormalInOutExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("S_BCP_BILL_NORMAL_IN_OUT.countByExample", example);
        return count;
    }

    public int deleteByExample(SBcpBillNormalInOutExample example) {
        int rows = getSqlMapClientTemplate().delete("S_BCP_BILL_NORMAL_IN_OUT.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        SBcpBillNormalInOut _key = new SBcpBillNormalInOut();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("S_BCP_BILL_NORMAL_IN_OUT.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SBcpBillNormalInOut record) {
        getSqlMapClientTemplate().insert("S_BCP_BILL_NORMAL_IN_OUT.insert", record);
    }

    public void insertSelective(SBcpBillNormalInOut record) {
        getSqlMapClientTemplate().insert("S_BCP_BILL_NORMAL_IN_OUT.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<SBcpBillNormalInOut> selectByExample(SBcpBillNormalInOutExample example) {
        List<SBcpBillNormalInOut> list = getSqlMapClientTemplate().queryForList("S_BCP_BILL_NORMAL_IN_OUT.selectByExample", example);
        return list;
    }

    public SBcpBillNormalInOut selectByPrimaryKey(String id) {
        SBcpBillNormalInOut _key = new SBcpBillNormalInOut();
        _key.setId(id);
        SBcpBillNormalInOut record = (SBcpBillNormalInOut) getSqlMapClientTemplate().queryForObject("S_BCP_BILL_NORMAL_IN_OUT.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(SBcpBillNormalInOut record, SBcpBillNormalInOutExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_BILL_NORMAL_IN_OUT.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(SBcpBillNormalInOut record, SBcpBillNormalInOutExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_BILL_NORMAL_IN_OUT.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(SBcpBillNormalInOut record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_BILL_NORMAL_IN_OUT.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SBcpBillNormalInOut record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_BILL_NORMAL_IN_OUT.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<SBcpBillNormalInOut> selectByPage(SBcpBillNormalInOutExample example, Page page) {
        List<SBcpBillNormalInOut> list = this.searchListPageMyObject("S_BCP_BILL_NORMAL_IN_OUT.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends SBcpBillNormalInOutExample {
        private Object record;

        public UpdateByExampleParms(Object record, SBcpBillNormalInOutExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}