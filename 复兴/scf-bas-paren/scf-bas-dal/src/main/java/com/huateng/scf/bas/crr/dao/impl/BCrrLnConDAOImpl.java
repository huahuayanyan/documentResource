package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrLnCon数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:33:10
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:33:10	     新增
 *
 * </pre>
 */
@Repository("IBCrrLnConDAO")
public class BCrrLnConDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrLnConDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrLnConDAOImpl() {
        super();
    }

    public int countByExample(BCrrLnConExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_LN_CON.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrLnConExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_LN_CON.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String appId) {
        BCrrLnCon _key = new BCrrLnCon();
        _key.setAppId(appId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_LN_CON.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrLnCon record) {
        getSqlMapClientTemplate().insert("B_CRR_LN_CON.insert", record);
    }

    public void insertSelective(BCrrLnCon record) {
        getSqlMapClientTemplate().insert("B_CRR_LN_CON.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLnCon> selectByExample(BCrrLnConExample example) {
        List<BCrrLnCon> list = getSqlMapClientTemplate().queryForList("B_CRR_LN_CON.selectByExample", example);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Map> getLoanPercent(Map map) {
        List<Map> list = getSqlMapClientTemplate().queryForList("B_CRR_LN_CON.getLoanPercent", map);
        return list;
    }
    
    public BCrrLnCon selectByPrimaryKey(String appId) {
        BCrrLnCon _key = new BCrrLnCon();
        _key.setAppId(appId);
        BCrrLnCon record = (BCrrLnCon) getSqlMapClientTemplate().queryForObject("B_CRR_LN_CON.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrLnCon record, BCrrLnConExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_CON.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrLnCon record, BCrrLnConExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_CON.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrLnCon record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_CON.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrLnCon record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_CON.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLnCon> selectByPage(BCrrLnConExample example, Page page) {
        List<BCrrLnCon> list = this.searchListPageMyObject("B_CRR_LN_CON.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrLnConExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrLnConExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}