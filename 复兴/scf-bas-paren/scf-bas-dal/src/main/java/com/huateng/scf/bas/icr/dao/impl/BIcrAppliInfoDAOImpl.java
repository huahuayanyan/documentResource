package com.huateng.scf.bas.icr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.icr.dao.IBIcrAppliInfoDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliInfo;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliInfoExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BIcrAppliInfoDAO")
public class BIcrAppliInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBIcrAppliInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BIcrAppliInfoDAOImpl() {
        super();
    }

    public int countByExample(BIcrAppliInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_ICR_APPLI_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BIcrAppliInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_ICR_APPLI_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BIcrAppliInfo _key = new BIcrAppliInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_ICR_APPLI_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BIcrAppliInfo record) {
        getSqlMapClientTemplate().insert("B_ICR_APPLI_INFO.insert", record);
    }

    public void insertSelective(BIcrAppliInfo record) {
        getSqlMapClientTemplate().insert("B_ICR_APPLI_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BIcrAppliInfo> selectByExample(BIcrAppliInfoExample example) {
        List<BIcrAppliInfo> list = getSqlMapClientTemplate().queryForList("B_ICR_APPLI_INFO.selectByExample", example);
        return list;
    }

    public BIcrAppliInfo selectByPrimaryKey(String id) {
        BIcrAppliInfo _key = new BIcrAppliInfo();
        _key.setId(id);
        BIcrAppliInfo record = (BIcrAppliInfo) getSqlMapClientTemplate().queryForObject("B_ICR_APPLI_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BIcrAppliInfo record, BIcrAppliInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BIcrAppliInfo record, BIcrAppliInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BIcrAppliInfo record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BIcrAppliInfo record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_APPLI_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BIcrAppliInfo> selectByPage(BIcrAppliInfoExample example, Page page) {
        List<BIcrAppliInfo> list = this.searchListPageMyObject("B_ICR_APPLI_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BIcrAppliInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BIcrAppliInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
  //根据额度编号更新额度申请信息状态和分项额度申请信息状态
	@Override
	public int updateAppliInfoOrUpBycreditNo(BIcrAppliInfo bIcrAppliInfo) {
		int rows = getSqlMapClientTemplate().update("EXT_B_ICR_APPLI_INFO.updateAppliInfoOrUpBycreditNo", bIcrAppliInfo);
		return rows;
	}
    /**
     * 根据额度编号查询额度申请信息
     */
	@Override
	public BIcrAppliInfo queryBIcrAppliInfoByCreditNo(BIcrAppliInfo bIcrAppliInfo) {
		// TODO Auto-generated method stub
		return (BIcrAppliInfo) getSqlMapClientTemplate().queryForObject("EXT_B_ICR_APPLI_INFO.selectBIcrAppliInfoBycreditNo", bIcrAppliInfo);
	}
}