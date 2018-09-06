package com.huateng.scf.bas.icr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.icr.dao.IBIcrBusiRelDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrBusiRel;
import com.huateng.scf.bas.icr.dao.model.BIcrBusiRelExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.scheduling.SchedulingException;
import org.springframework.stereotype.Repository;

@Repository("BIcrBusiRelDAO")
public class BIcrBusiRelDAOImpl extends IbatisDaoAnnotation4Template implements IBIcrBusiRelDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BIcrBusiRelDAOImpl() {
        super();
    }

    public int countByExample(BIcrBusiRelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_ICR_BUSI_REL.countByExample", example);
        return count;
    }

    public int deleteByExample(BIcrBusiRelExample example) {
        int rows = getSqlMapClientTemplate().delete("B_ICR_BUSI_REL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BIcrBusiRel _key = new BIcrBusiRel();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_ICR_BUSI_REL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BIcrBusiRel record) {
        getSqlMapClientTemplate().insert("B_ICR_BUSI_REL.insert", record);
    }

    public void insertSelective(BIcrBusiRel record) {
        getSqlMapClientTemplate().insert("B_ICR_BUSI_REL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BIcrBusiRel> selectByExample(BIcrBusiRelExample example) {
        List<BIcrBusiRel> list = getSqlMapClientTemplate().queryForList("B_ICR_BUSI_REL.selectByExample", example);
        return list;
    }

    public BIcrBusiRel selectByPrimaryKey(String id) {
        BIcrBusiRel _key = new BIcrBusiRel();
        _key.setId(id);
        BIcrBusiRel record = (BIcrBusiRel) getSqlMapClientTemplate().queryForObject("B_ICR_BUSI_REL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BIcrBusiRel record, BIcrBusiRelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_BUSI_REL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BIcrBusiRel record, BIcrBusiRelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_BUSI_REL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BIcrBusiRel record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_BUSI_REL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BIcrBusiRel record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_BUSI_REL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BIcrBusiRel> selectByPage(BIcrBusiRelExample example, Page page) {
        List<BIcrBusiRel> list = this.searchListPageMyObject("B_ICR_BUSI_REL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BIcrBusiRelExample {
        private Object record;

        public UpdateByExampleParms(Object record, BIcrBusiRelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	/**
	 *
	 * @Description: 新增额度业务合同协议关联信息
	 * @author wenkui.xu
	 * @Created 2013-7-17上午09:28:07
	 * @param relaType
	 * @param creditNo
	 * @param businessNo
	 * @throws CommonException
	 */
    @Override
	public void addTblCreditBusiRel(String relaType,String creditNo,String businessNo)throws SchedulingException {
		BIcrBusiRel tblCreditBusiRel=new BIcrBusiRel();
		tblCreditBusiRel.setRelaType(relaType);
		tblCreditBusiRel.setCreditNo(creditNo);
		tblCreditBusiRel.setBusinessNo(businessNo);
		insert(tblCreditBusiRel);
	}
}