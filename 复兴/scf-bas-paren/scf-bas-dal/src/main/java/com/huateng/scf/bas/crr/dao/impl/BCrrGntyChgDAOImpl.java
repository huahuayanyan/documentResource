package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrGntyChgDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyChg;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyChgExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrGntyChg数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月24日下午3:42:19
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月24日下午3:42:19	     新增
 *
 * </pre>
 */
@Repository("IBCrrGntyChgDAO")
public class BCrrGntyChgDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrGntyChgDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrGntyChgDAOImpl() {
        super();
    }

    public int countByExample(BCrrGntyChgExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_CHG.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrGntyChgExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_CHG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String serialno) {
        BCrrGntyChg _key = new BCrrGntyChg();
        _key.setSerialno(serialno);
        int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_CHG.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrGntyChg record) {
        getSqlMapClientTemplate().insert("B_CRR_GNTY_CHG.insert", record);
    }

    public void insertSelective(BCrrGntyChg record) {
        getSqlMapClientTemplate().insert("B_CRR_GNTY_CHG.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrGntyChg> selectByExample(BCrrGntyChgExample example) {
        List<BCrrGntyChg> list = getSqlMapClientTemplate().queryForList("B_CRR_GNTY_CHG.selectByExample", example);
        return list;
    }

    public BCrrGntyChg selectByPrimaryKey(String serialno) {
        BCrrGntyChg _key = new BCrrGntyChg();
        _key.setSerialno(serialno);
        BCrrGntyChg record = (BCrrGntyChg) getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_CHG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrGntyChg record, BCrrGntyChgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_CHG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrGntyChg record, BCrrGntyChgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_CHG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrGntyChg record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_CHG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrGntyChg record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_CHG.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrGntyChg> selectByPage(BCrrGntyChgExample example, Page page) {
        List<BCrrGntyChg> list = this.searchListPageMyObject("B_CRR_GNTY_CHG.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrGntyChgExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrGntyChgExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}