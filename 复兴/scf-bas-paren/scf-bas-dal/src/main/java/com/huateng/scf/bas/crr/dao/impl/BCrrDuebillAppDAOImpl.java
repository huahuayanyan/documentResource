package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillAppExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrDuebillApp数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:30:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:30:51	     新增
 *
 * </pre>
 */
@Repository("IBCrrDuebillAppDAO")
public class BCrrDuebillAppDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrDuebillAppDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrDuebillAppDAOImpl() {
        super();
    }

    public int countByExample(BCrrDuebillAppExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_DUEBILL_APP.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrDuebillAppExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_DUEBILL_APP.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCrrDuebillApp _key = new BCrrDuebillApp();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CRR_DUEBILL_APP.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrDuebillApp record) {
        getSqlMapClientTemplate().insert("B_CRR_DUEBILL_APP.insert", record);
    }

    public void insertSelective(BCrrDuebillApp record) {
        getSqlMapClientTemplate().insert("B_CRR_DUEBILL_APP.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrDuebillApp> selectByExample(BCrrDuebillAppExample example) {
        List<BCrrDuebillApp> list = getSqlMapClientTemplate().queryForList("B_CRR_DUEBILL_APP.selectByExample", example);
        return list;
    }

    public BCrrDuebillApp selectByPrimaryKey(String id) {
        BCrrDuebillApp _key = new BCrrDuebillApp();
        _key.setId(id);
        BCrrDuebillApp record = (BCrrDuebillApp) getSqlMapClientTemplate().queryForObject("B_CRR_DUEBILL_APP.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrDuebillApp record, BCrrDuebillAppExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_DUEBILL_APP.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrDuebillApp record, BCrrDuebillAppExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_DUEBILL_APP.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrDuebillApp record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_DUEBILL_APP.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrDuebillApp record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_DUEBILL_APP.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrDuebillApp> selectByPage(BCrrDuebillAppExample example, Page page) {
        List<BCrrDuebillApp> list = this.searchListPageMyObject("B_CRR_DUEBILL_APP.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrDuebillAppExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrDuebillAppExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    public BCrrDuebillApp findBCrrDuebillAppByIfspAppno(String ifspAppno) {
        BCrrDuebillApp _key = new BCrrDuebillApp();
        _key.setIfspAppno(ifspAppno);
        BCrrDuebillApp record = (BCrrDuebillApp) getSqlMapClientTemplate().queryForObject("EXT_B_CRR_DUEBILL_APP.selectByIfspAppno", _key);
        return record;
    }
    public void insertIfspSelective(BCrrDuebillApp record) {
    	getSqlMapClientTemplate().insert("EXT_B_CRR_DUEBILL_APP.insertSelective", record);
    }
}