package com.huateng.scf.bas.cnt.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntInsuranceBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfoExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCntInsuranceBaseInfo数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月24日下午1:49:02
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月24日下午1:49:02	     新增
 *
 * </pre>
 */
@Repository("IBCntInsuranceBaseInfoDAO")
public class BCntInsuranceBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntInsuranceBaseInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntInsuranceBaseInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntInsuranceBaseInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_INSURANCE_BASE_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntInsuranceBaseInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_INSURANCE_BASE_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String insuranceNo) {
        BCntInsuranceBaseInfo _key = new BCntInsuranceBaseInfo();
        _key.setInsuranceNo(insuranceNo);
        int rows = getSqlMapClientTemplate().delete("B_CNT_INSURANCE_BASE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntInsuranceBaseInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_INSURANCE_BASE_INFO.insert", record);
    }

    public void insertSelective(BCntInsuranceBaseInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_INSURANCE_BASE_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntInsuranceBaseInfo> selectByExample(BCntInsuranceBaseInfoExample example) {
        List<BCntInsuranceBaseInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_INSURANCE_BASE_INFO.selectByExample", example);
        return list;
    }

    public BCntInsuranceBaseInfo selectByPrimaryKey(String insuranceNo) {
        BCntInsuranceBaseInfo _key = new BCntInsuranceBaseInfo();
        _key.setInsuranceNo(insuranceNo);
        BCntInsuranceBaseInfo record = (BCntInsuranceBaseInfo) getSqlMapClientTemplate().queryForObject("B_CNT_INSURANCE_BASE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntInsuranceBaseInfo record, BCntInsuranceBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_INSURANCE_BASE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntInsuranceBaseInfo record, BCntInsuranceBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_INSURANCE_BASE_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntInsuranceBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_INSURANCE_BASE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntInsuranceBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_INSURANCE_BASE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntInsuranceBaseInfo> selectByPage(BCntInsuranceBaseInfoExample example, Page page) {
        List<BCntInsuranceBaseInfo> list = this.searchListPageMyObject("B_CNT_INSURANCE_BASE_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntInsuranceBaseInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntInsuranceBaseInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}