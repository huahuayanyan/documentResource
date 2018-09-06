package com.huateng.scf.adv.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.bcp.dao.IABcpAppliImprestBussDAO;
import com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss;
import com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBussExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("ABcpAppliImprestBussDAO")
public class ABcpAppliImprestBussDAOImpl extends IbatisDaoAnnotation4Template implements IABcpAppliImprestBussDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public ABcpAppliImprestBussDAOImpl() {
        super();
    }

    public int countByExample(ABcpAppliImprestBussExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("A_BCP_APPLI_IMPREST_BUSS.countByExample", example);
        return count;
    }

    public int deleteByExample(ABcpAppliImprestBussExample example) {
        int rows = getSqlMapClientTemplate().delete("A_BCP_APPLI_IMPREST_BUSS.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        ABcpAppliImprestBuss _key = new ABcpAppliImprestBuss();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("A_BCP_APPLI_IMPREST_BUSS.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(ABcpAppliImprestBuss record) {
        getSqlMapClientTemplate().insert("A_BCP_APPLI_IMPREST_BUSS.insert", record);
    }

    public void insertSelective(ABcpAppliImprestBuss record) {
        getSqlMapClientTemplate().insert("A_BCP_APPLI_IMPREST_BUSS.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<ABcpAppliImprestBuss> selectByExample(ABcpAppliImprestBussExample example) {
        List<ABcpAppliImprestBuss> list = getSqlMapClientTemplate().queryForList("A_BCP_APPLI_IMPREST_BUSS.selectByExample", example);
        return list;
    }

    public ABcpAppliImprestBuss selectByPrimaryKey(String id) {
        ABcpAppliImprestBuss _key = new ABcpAppliImprestBuss();
        _key.setId(id);
        ABcpAppliImprestBuss record = (ABcpAppliImprestBuss) getSqlMapClientTemplate().queryForObject("A_BCP_APPLI_IMPREST_BUSS.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(ABcpAppliImprestBuss record, ABcpAppliImprestBussExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("A_BCP_APPLI_IMPREST_BUSS.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(ABcpAppliImprestBuss record, ABcpAppliImprestBussExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("A_BCP_APPLI_IMPREST_BUSS.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(ABcpAppliImprestBuss record) {
        int rows = getSqlMapClientTemplate().update("A_BCP_APPLI_IMPREST_BUSS.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(ABcpAppliImprestBuss record) {
        int rows = getSqlMapClientTemplate().update("A_BCP_APPLI_IMPREST_BUSS.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<ABcpAppliImprestBuss> selectByPage(ABcpAppliImprestBussExample example, Page page) {
        List<ABcpAppliImprestBuss> list = this.searchListPageMyObject("A_BCP_APPLI_IMPREST_BUSS.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends ABcpAppliImprestBussExample {
        private Object record;

        public UpdateByExampleParms(Object record, ABcpAppliImprestBussExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //EXT 

	/**
	 * 根据申请编号查询预付款流水表
	 */
	@Override
	public ABcpAppliImprestBuss queryAppliImprestBussByAppno(String appno) {
		// TODO Auto-generated method stub
		return (ABcpAppliImprestBuss) getSqlMapClientTemplate().queryForObject("EXT_A_BCP_APPLI_IMPREST_BUSS.queryAppliImprestBussByAppno", appno);
	}
}