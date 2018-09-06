package com.huateng.scf.sto.nwr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.sto.nwr.dao.ISBcpProductBillDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpProductBill;
import com.huateng.scf.sto.nwr.dao.model.SBcpProductBillExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>SBcpProductBill仓单产品参数扩展表 数据库访问层通用接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月12日下午3:59:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月12日下午3:59:12	     新增
 *
 * </pre>
 */
@Repository("ISBcpProductBillDAO")
public class SBcpProductBillDAOImpl extends IbatisDaoAnnotation4Template implements ISBcpProductBillDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public SBcpProductBillDAOImpl() {
        super();
    }

    public int countByExample(SBcpProductBillExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("S_BCP_PRODUCT_BILL.countByExample", example);
        return count;
    }

    public int deleteByExample(SBcpProductBillExample example) {
        int rows = getSqlMapClientTemplate().delete("S_BCP_PRODUCT_BILL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String productId) {
        SBcpProductBill _key = new SBcpProductBill();
        _key.setProductId(productId);
        int rows = getSqlMapClientTemplate().delete("S_BCP_PRODUCT_BILL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SBcpProductBill record) {
        getSqlMapClientTemplate().insert("S_BCP_PRODUCT_BILL.insert", record);
    }

    public void insertSelective(SBcpProductBill record) {
        getSqlMapClientTemplate().insert("S_BCP_PRODUCT_BILL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<SBcpProductBill> selectByExample(SBcpProductBillExample example) {
        List<SBcpProductBill> list = getSqlMapClientTemplate().queryForList("S_BCP_PRODUCT_BILL.selectByExample", example);
        return list;
    }

    public SBcpProductBill selectByPrimaryKey(String productId) {
        SBcpProductBill _key = new SBcpProductBill();
        _key.setProductId(productId);
        SBcpProductBill record = (SBcpProductBill) getSqlMapClientTemplate().queryForObject("S_BCP_PRODUCT_BILL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(SBcpProductBill record, SBcpProductBillExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_PRODUCT_BILL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(SBcpProductBill record, SBcpProductBillExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("S_BCP_PRODUCT_BILL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(SBcpProductBill record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_PRODUCT_BILL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SBcpProductBill record) {
        int rows = getSqlMapClientTemplate().update("S_BCP_PRODUCT_BILL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<SBcpProductBill> selectByPage(SBcpProductBillExample example, Page page) {
        List<SBcpProductBill> list = this.searchListPageMyObject("S_BCP_PRODUCT_BILL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends SBcpProductBillExample {
        private Object record;

        public UpdateByExampleParms(Object record, SBcpProductBillExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}