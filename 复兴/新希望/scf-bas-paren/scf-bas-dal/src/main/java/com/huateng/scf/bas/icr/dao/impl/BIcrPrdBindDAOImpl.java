package com.huateng.scf.bas.icr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.icr.dao.IBIcrPrdBindDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrPrdBind;
import com.huateng.scf.bas.icr.dao.model.BIcrPrdBindExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BIcrPrdBindDAO")
public class BIcrPrdBindDAOImpl extends IbatisDaoAnnotation4Template implements IBIcrPrdBindDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BIcrPrdBindDAOImpl() {
        super();
    }

    public int countByExample(BIcrPrdBindExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_ICR_PRD_BIND.countByExample", example);
        return count;
    }

    public int deleteByExample(BIcrPrdBindExample example) {
        int rows = getSqlMapClientTemplate().delete("B_ICR_PRD_BIND.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BIcrPrdBind _key = new BIcrPrdBind();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_ICR_PRD_BIND.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BIcrPrdBind record) {
        getSqlMapClientTemplate().insert("B_ICR_PRD_BIND.insert", record);
    }

    public void insertSelective(BIcrPrdBind record) {
        getSqlMapClientTemplate().insert("B_ICR_PRD_BIND.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BIcrPrdBind> selectByExample(BIcrPrdBindExample example) {
        List<BIcrPrdBind> list = getSqlMapClientTemplate().queryForList("B_ICR_PRD_BIND.selectByExample", example);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<BIcrPrdBind> selectByPid(String pid) {
        List<BIcrPrdBind> list = getSqlMapClientTemplate().queryForList("B_ICR_PRD_BIND.selectByPid", pid);
        return list;
    }
    
    public BIcrPrdBind selectByPrimaryKey(String id) {
        BIcrPrdBind _key = new BIcrPrdBind();
        _key.setId(id);
        BIcrPrdBind record = (BIcrPrdBind) getSqlMapClientTemplate().queryForObject("B_ICR_PRD_BIND.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BIcrPrdBind record, BIcrPrdBindExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_PRD_BIND.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BIcrPrdBind record, BIcrPrdBindExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_PRD_BIND.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BIcrPrdBind record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_PRD_BIND.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BIcrPrdBind record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_PRD_BIND.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BIcrPrdBind> selectByPage(BIcrPrdBindExample example, Page page) {
        List<BIcrPrdBind> list = this.searchListPageMyObject("B_ICR_PRD_BIND.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BIcrPrdBindExample {
        private Object record;

        public UpdateByExampleParms(Object record, BIcrPrdBindExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //ext
    /**
     * 根据额度种类删除额度与产品的绑定关系
     */
	@Override
	public int deleteBIcrPrdBindByCreditType(BIcrPrdBind bIcrPrdBind) {
		return getSqlMapClientTemplate().delete("EXT_B_ICR_PRD_BIND.deleteBIcrPrdBindByCreditType", bIcrPrdBind);
	}
    
}