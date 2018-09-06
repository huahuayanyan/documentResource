package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrEqptInfoDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrEqptInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrEqptInfoExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrEqptInfo数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:31:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:31:24	     新增
 *
 * </pre>
 */
@Repository("IBCrrEqptInfoDAO")
public class BCrrEqptInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrEqptInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrEqptInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrrEqptInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_EQPT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrEqptInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_EQPT_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String eqptId) {
        BCrrEqptInfo _key = new BCrrEqptInfo();
        _key.setEqptId(eqptId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_EQPT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrEqptInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_EQPT_INFO.insert", record);
    }

    public void insertSelective(BCrrEqptInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_EQPT_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrEqptInfo> selectByExample(BCrrEqptInfoExample example) {
        List<BCrrEqptInfo> list = getSqlMapClientTemplate().queryForList("B_CRR_EQPT_INFO.selectByExample", example);
        return list;
    }

    public BCrrEqptInfo selectByPrimaryKey(String eqptId) {
        BCrrEqptInfo _key = new BCrrEqptInfo();
        _key.setEqptId(eqptId);
        BCrrEqptInfo record = (BCrrEqptInfo) getSqlMapClientTemplate().queryForObject("B_CRR_EQPT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrEqptInfo record, BCrrEqptInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_EQPT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrEqptInfo record, BCrrEqptInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_EQPT_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrEqptInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_EQPT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrEqptInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_EQPT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrEqptInfo> selectByPage(BCrrEqptInfoExample example, Page page) {
        List<BCrrEqptInfo> list = this.searchListPageMyObject("B_CRR_EQPT_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrEqptInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrEqptInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}