package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrLnAppDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnApp;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrLnApp数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:32:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:32:51	     新增
 *
 * </pre>
 */
@Repository("IBCrrLnAppDAO")
public class BCrrLnAppDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrLnAppDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrLnAppDAOImpl() {
        super();
    }

    public int countByExample(BCrrLnAppExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_LN_APP.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrLnAppExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_LN_APP.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String appId) {
    	BCrrLnApp record = new BCrrLnApp();
    	record.setAppId(appId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_LN_APP.deleteByPrimaryKey", record);
        return rows;
    }
    
    @Override
    public int batchDelete(List<BCrrLnApp> list) {
    	int rows = 0;
    	for(BCrrLnApp record:list)
    	{
    		String appId = record.getAppId();
    		rows += deleteByPrimaryKey(appId);
    	}
        return rows;
    }

    public void insert(BCrrLnApp record) {
        getSqlMapClientTemplate().insert("B_CRR_LN_APP.insert", record);
    }

    public void insertSelective(BCrrLnApp record) {
        getSqlMapClientTemplate().insert("B_CRR_LN_APP.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLnApp> selectByExample(BCrrLnAppExample example) {
        List<BCrrLnApp> list = getSqlMapClientTemplate().queryForList("B_CRR_LN_APP.selectByExample", example);
        return list;
    }

    public BCrrLnApp selectByPrimaryKey(String appId) {
        BCrrLnApp _key = new BCrrLnApp();
        _key.setAppId(appId);
        BCrrLnApp record = (BCrrLnApp) getSqlMapClientTemplate().queryForObject("B_CRR_LN_APP.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrLnApp record, BCrrLnAppExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_APP.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrLnApp record, BCrrLnAppExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_APP.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrLnApp record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_APP.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrLnApp record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_APP.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLnApp> selectByPage(BCrrLnAppExample example, Page page) {
        List<BCrrLnApp> list = this.searchListPageMyObject("B_CRR_LN_APP.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrLnAppExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrLnAppExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}