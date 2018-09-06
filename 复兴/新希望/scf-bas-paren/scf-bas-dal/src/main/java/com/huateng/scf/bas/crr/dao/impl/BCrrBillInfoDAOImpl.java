package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrBillInfoDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrBillInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrBillInfoExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrBillInfo数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:30:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:30:26	     新增
 *
 * </pre>
 */
@Repository("IBCrrBillInfoDAO")
public class BCrrBillInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrBillInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrBillInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrrBillInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_BILL_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrBillInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_BILL_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String billId) {
        BCrrBillInfo _key = new BCrrBillInfo();
        _key.setBillId(billId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_BILL_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrBillInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_BILL_INFO.insert", record);
    }

    public void insertSelective(BCrrBillInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_BILL_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrBillInfo> selectByExample(BCrrBillInfoExample example) {
        List<BCrrBillInfo> list = getSqlMapClientTemplate().queryForList("B_CRR_BILL_INFO.selectByExample", example);
        return list;
    }

    public BCrrBillInfo selectByPrimaryKey(String billId) {
        BCrrBillInfo _key = new BCrrBillInfo();
        _key.setBillId(billId);
        BCrrBillInfo record = (BCrrBillInfo) getSqlMapClientTemplate().queryForObject("B_CRR_BILL_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrBillInfo record, BCrrBillInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_BILL_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrBillInfo record, BCrrBillInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_BILL_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrBillInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_BILL_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrBillInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_BILL_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrBillInfo> selectByPage(BCrrBillInfoExample example, Page page) {
        List<BCrrBillInfo> list = this.searchListPageMyObject("B_CRR_BILL_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrBillInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrBillInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<BCrrBillInfo> selectByExtId(String extId) {
    	BCrrBillInfo _key = new BCrrBillInfo();
        _key.setExtId(extId);
        List<BCrrBillInfo> list = getSqlMapClientTemplate().queryForList("B_CRR_BILL_INFO.selectByExtId", _key);
        return list;
    }

    @Override
    public int deleteByExtId(String extId) {
    	BCrrBillInfo _key = new BCrrBillInfo();
        _key.setExtId(extId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_BILL_INFO.deleteByExtId", _key);
        return rows;
    }
}