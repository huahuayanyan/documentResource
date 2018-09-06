package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrLnConRelaDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRelaExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRelaKey;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrLnConRela数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午7:43:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午7:43:14	     新增
 *
 * </pre>
 */
@Repository("IBCrrLnConRelaDAO")
public class BCrrLnConRelaDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrLnConRelaDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrLnConRelaDAOImpl() {
        super();
    }

    public int countByExample(BCrrLnConRelaExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_LN_CON_RELA.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrLnConRelaExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_LN_CON_RELA.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(BCrrLnConRelaKey _key) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_LN_CON_RELA.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrLnConRela record) {
        getSqlMapClientTemplate().insert("B_CRR_LN_CON_RELA.insert", record);
    }

    public void insertSelective(BCrrLnConRela record) {
        getSqlMapClientTemplate().insert("B_CRR_LN_CON_RELA.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLnConRela> selectByExample(BCrrLnConRelaExample example) {
        List<BCrrLnConRela> list = getSqlMapClientTemplate().queryForList("B_CRR_LN_CON_RELA.selectByExample", example);
        return list;
    }

    public BCrrLnConRela selectByPrimaryKey(BCrrLnConRelaKey _key) {
        BCrrLnConRela record = (BCrrLnConRela) getSqlMapClientTemplate().queryForObject("B_CRR_LN_CON_RELA.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrLnConRela record, BCrrLnConRelaExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_CON_RELA.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrLnConRela record, BCrrLnConRelaExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_CON_RELA.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrLnConRela record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_CON_RELA.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrLnConRela record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LN_CON_RELA.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLnConRela> selectByPage(BCrrLnConRelaExample example, Page page) {
        List<BCrrLnConRela> list = this.searchListPageMyObject("B_CRR_LN_CON_RELA.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrLnConRelaExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrLnConRelaExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
//    @SuppressWarnings("unchecked")
//	  @Override
//    public List<BCrrLnConRelaKey> selectBySerialno(String appId)
//    {
//    	BCrrLnConRelaKey _key = new BCrrLnConRelaKey();
//    	_key.setSerialno(appId);
//    	List<BCrrLnConRelaKey> record = getSqlMapClientTemplate().queryForList("B_CRR_LN_CON_RELA.selectBySerialno", _key);
//    	return record;
//    }
//    
//    @Override
//    public int update(BCrrLnConRelaKey record) {
//    	int rows = getSqlMapClientTemplate().update("B_CRR_LN_CON_RELA.updateByPrimaryKey", record);
//        return rows;
//    }
//
//    @Override
//    public BCrrLnConRelaKey selectByAppIdAndConId(BCrrLnConRelaKey bCrrLnConRela)
//    {
//    	BCrrLnConRelaKey record = (BCrrLnConRelaKey) getSqlMapClientTemplate().queryForObject("B_CRR_LN_CON_RELA.selectByAppIdAndConId", bCrrLnConRela);
//    	return record;
//    }
}