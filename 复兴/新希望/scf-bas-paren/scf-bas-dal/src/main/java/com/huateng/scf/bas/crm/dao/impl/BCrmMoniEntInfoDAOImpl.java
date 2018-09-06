package com.huateng.scf.bas.crm.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmMoniEntInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("IBCrmMoniEntInfoDAO")
public class BCrmMoniEntInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmMoniEntInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrmMoniEntInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrmMoniEntInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRM_MONI_ENT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrmMoniEntInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRM_MONI_ENT_INFO.deleteByExample", example);
        return rows;
    }

    public void insert(BCrmMoniEntInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_MONI_ENT_INFO.insert", record);
    }

    public void insertSelective(BCrmMoniEntInfo record) {
        getSqlMapClientTemplate().insert("B_CRM_MONI_ENT_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrmMoniEntInfo> selectByExample(BCrmMoniEntInfoExample example) {
        List<BCrmMoniEntInfo> list = getSqlMapClientTemplate().queryForList("B_CRM_MONI_ENT_INFO.selectByExample", example);
        return list;
    }

    public int updateByExampleSelective(BCrmMoniEntInfo record, BCrmMoniEntInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_MONI_ENT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrmMoniEntInfo record, BCrmMoniEntInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRM_MONI_ENT_INFO.updateByExample", parms);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrmMoniEntInfo> selectByPage(BCrmMoniEntInfoExample example, Page page) {
        List<BCrmMoniEntInfo> list = this.searchListPageMyObject("B_CRM_MONI_ENT_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrmMoniEntInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrmMoniEntInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public BCrmMoniEntInfo selectByPrimaryKey(String custcd) {
		BCrmMoniEntInfo bCrmMoniEntInfo =(BCrmMoniEntInfo) this.getSqlMapClientTemplate().queryForObject("B_CRM_MONI_ENT_INFO.selectById", custcd);
		return bCrmMoniEntInfo;
	}
}