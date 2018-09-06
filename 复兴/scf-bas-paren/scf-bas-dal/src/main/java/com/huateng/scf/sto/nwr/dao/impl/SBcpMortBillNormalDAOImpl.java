package com.huateng.scf.sto.nwr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.sto.nwr.dao.ISBcpMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormalExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>SBcpMortBillNormal非标准仓单信息表数据库访问层通用接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月12日下午4:00:59
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月12日下午4:00:59	     新增
 *
 * </pre>
 */
@Repository("ISBcpMortBillNormalDAO")
public class SBcpMortBillNormalDAOImpl extends IbatisDaoAnnotation4Template implements ISBcpMortBillNormalDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public SBcpMortBillNormalDAOImpl() {
        super();
    }

    public int countByExample(SBcpMortBillNormalExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("S_BCP_MORT_BILL_NORMAL.countByExample", example);
        return count;
    }

    public int deleteByExample(SBcpMortBillNormalExample example) {
        int rows = getSqlMapClientTemplate().delete("S_BCP_MORT_BILL_NORMAL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String billno) {
        SBcpMortBillNormal _key = new SBcpMortBillNormal();
        _key.setBillno(billno);
        int rows = getSqlMapClientTemplate().delete("S_BCP_MORT_BILL_NORMAL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SBcpMortBillNormal record) {
        getSqlMapClientTemplate().insert("S_BCP_MORT_BILL_NORMAL.insert", record);
    }

    public void insertSelective(SBcpMortBillNormal record) {
        getSqlMapClientTemplate().insert("S_BCP_MORT_BILL_NORMAL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<SBcpMortBillNormal> selectByExample(SBcpMortBillNormalExample example) {
        List<SBcpMortBillNormal> list = getSqlMapClientTemplate().queryForList("S_BCP_MORT_BILL_NORMAL.selectByExample", example);
        return list;
    }

    public SBcpMortBillNormal selectByPrimaryKey(String billno) {
        SBcpMortBillNormal _key = new SBcpMortBillNormal();
        _key.setBillno(billno);
        SBcpMortBillNormal record = (SBcpMortBillNormal) getSqlMapClientTemplate().queryForObject("S_BCP_MORT_BILL_NORMAL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(SBcpMortBillNormal record, SBcpMortBillNormalExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_MORT_BILL_NORMAL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(SBcpMortBillNormal record, SBcpMortBillNormalExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_MORT_BILL_NORMAL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(SBcpMortBillNormal record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_MORT_BILL_NORMAL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SBcpMortBillNormal record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_MORT_BILL_NORMAL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<SBcpMortBillNormal> selectByPage(SBcpMortBillNormalExample example, Page page) {
        List<SBcpMortBillNormal> list = this.searchListPageMyObject("S_BCP_MORT_BILL_NORMAL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends SBcpMortBillNormalExample {
        private Object record;

        public UpdateByExampleParms(Object record, SBcpMortBillNormalExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}