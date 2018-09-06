package com.huateng.scf.bas.mrn.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfoExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BMrnAppliAcctInfo数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月13日上午9:52:25
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月13日上午9:52:25	     新增
 *
 * </pre>
 */
@Repository("IBMrnAppliAcctInfoDAO")
public class BMrnAppliAcctInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBMrnAppliAcctInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BMrnAppliAcctInfoDAOImpl() {
        super();
    }

    public int countByExample(BMrnAppliAcctInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_MRN_APPLI_ACCT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BMrnAppliAcctInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_MRN_APPLI_ACCT_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BMrnAppliAcctInfo _key = new BMrnAppliAcctInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_MRN_APPLI_ACCT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BMrnAppliAcctInfo record) {
        getSqlMapClientTemplate().insert("B_MRN_APPLI_ACCT_INFO.insert", record);
    }

    public void insertSelective(BMrnAppliAcctInfo record) {
        getSqlMapClientTemplate().insert("B_MRN_APPLI_ACCT_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BMrnAppliAcctInfo> selectByExample(BMrnAppliAcctInfoExample example) {
        List<BMrnAppliAcctInfo> list = getSqlMapClientTemplate().queryForList("B_MRN_APPLI_ACCT_INFO.selectByExample", example);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BMrnAppliAcctInfo> selectByAppno(String appno) {
        List<BMrnAppliAcctInfo> list = getSqlMapClientTemplate().queryForList("B_MRN_APPLI_ACCT_INFO.selectByAppno", appno);
        return list;
    }
    
    public BMrnAppliAcctInfo selectByPrimaryKey(String id) {
        BMrnAppliAcctInfo _key = new BMrnAppliAcctInfo();
        _key.setId(id);
        BMrnAppliAcctInfo record = (BMrnAppliAcctInfo) getSqlMapClientTemplate().queryForObject("B_MRN_APPLI_ACCT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BMrnAppliAcctInfo record, BMrnAppliAcctInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_MRN_APPLI_ACCT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BMrnAppliAcctInfo record, BMrnAppliAcctInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_MRN_APPLI_ACCT_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BMrnAppliAcctInfo record) {
        int rows = getSqlMapClientTemplate().update("B_MRN_APPLI_ACCT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BMrnAppliAcctInfo record) {
        int rows = getSqlMapClientTemplate().update("B_MRN_APPLI_ACCT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BMrnAppliAcctInfo> selectByPage(BMrnAppliAcctInfoExample example, Page page) {
        List<BMrnAppliAcctInfo> list = this.searchListPageMyObject("B_MRN_APPLI_ACCT_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BMrnAppliAcctInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BMrnAppliAcctInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<BMrnAppliAcctInfo> selectByBillId(String billId) {
        BMrnAppliAcctInfo _key = new BMrnAppliAcctInfo();
        _key.setBillId(billId);
        List<BMrnAppliAcctInfo> record = getSqlMapClientTemplate().queryForList("B_MRN_APPLI_ACCT_INFO.selectByBillId", _key);
        return record;
    }
    
    @Override
    public int updateByBillId(BMrnAppliAcctInfo record) {
        int rows = getSqlMapClientTemplate().update("B_MRN_APPLI_ACCT_INFO.updateByBillId", record);
        return rows;
    }
}