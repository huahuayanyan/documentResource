package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebill;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrDuebill数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:31:10
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:31:10	     新增
 *
 * </pre>
 */
@Repository("IBCrrDuebillDAO")
public class BCrrDuebillDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrDuebillDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrDuebillDAOImpl() {
        super();
    }

    public int countByExample(BCrrDuebillExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_DUEBILL.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrDuebillExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_DUEBILL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String cino) {
        BCrrDuebill _key = new BCrrDuebill();
        _key.setCino(cino);
        int rows = getSqlMapClientTemplate().delete("B_CRR_DUEBILL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrDuebill record) {
        getSqlMapClientTemplate().insert("B_CRR_DUEBILL.insert", record);
    }

    public void insertSelective(BCrrDuebill record) {
        getSqlMapClientTemplate().insert("B_CRR_DUEBILL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrDuebill> selectByExample(BCrrDuebillExample example) {
        List<BCrrDuebill> list = getSqlMapClientTemplate().queryForList("B_CRR_DUEBILL.selectByExample", example);
        return list;
    }

    public BCrrDuebill selectByPrimaryKey(String cino) {
        BCrrDuebill _key = new BCrrDuebill();
        _key.setCino(cino);
        BCrrDuebill record = (BCrrDuebill) getSqlMapClientTemplate().queryForObject("B_CRR_DUEBILL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrDuebill record, BCrrDuebillExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_DUEBILL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrDuebill record, BCrrDuebillExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_DUEBILL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrDuebill record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_DUEBILL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrDuebill record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_DUEBILL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrDuebill> selectByPage(BCrrDuebillExample example, Page page) {
        List<BCrrDuebill> list = this.searchListPageMyObject("B_CRR_DUEBILL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrDuebillExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrDuebillExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    @Override
    public int deleteByRelaId(String relaId) {
        BCrrDuebill _key = new BCrrDuebill();
        _key.setRelaId(relaId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_DUEBILL.deleteByRelaId", _key);
        return rows;
    }
}