package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrLnAppRelaDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaKey;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午7:42:47
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午7:42:47	     新增
 *
 * </pre>
 */
@Repository("IBCrrLnAppRelaDAO")
public class BCrrLnAppRelaDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrLnAppRelaDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrLnAppRelaDAOImpl() {
        super();
    }

    public int countByExample(BCrrLnAppRelaExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_LN_APP_RELA.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrLnAppRelaExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_LN_APP_RELA.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(BCrrLnAppRelaKey _key) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_LN_APP_RELA.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrLnAppRela record) {
        getSqlMapClientTemplate().insert("B_CRR_LN_APP_RELA.insert", record);
    }

    public void insertSelective(BCrrLnAppRela record) {
        getSqlMapClientTemplate().insert("B_CRR_LN_APP_RELA.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLnAppRela> selectByExample(BCrrLnAppRelaExample example) {
        List<BCrrLnAppRela> list = getSqlMapClientTemplate().queryForList("B_CRR_LN_APP_RELA.selectByExample", example);
        return list;
    }

    public BCrrLnAppRela selectByPrimaryKey(BCrrLnAppRela _key) {
        BCrrLnAppRela record = (BCrrLnAppRela) getSqlMapClientTemplate().queryForObject("B_CRR_LN_APP_RELA.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrLnAppRela record, BCrrLnAppRelaExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_APP_RELA.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrLnAppRela record, BCrrLnAppRelaExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_APP_RELA.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrLnAppRela record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_APP_RELA.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrLnAppRela record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_APP_RELA.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLnAppRela> selectByPage(BCrrLnAppRelaExample example, Page page) {
        List<BCrrLnAppRela> list = this.searchListPageMyObject("B_CRR_LN_APP_RELA.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrLnAppRelaExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrLnAppRelaExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}