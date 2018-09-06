package com.huateng.scf.bas.sys.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.model.BSysFlowUrlRel;
import com.huateng.scf.bas.sys.dao.model.BSysFlowUrlRelExample;

@Repository("BSysFlowUrlRelDAO")
public class BSysFlowUrlRelDAOImpl extends IbatisDaoAnnotation4Template implements IBSysFlowUrlRelDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysFlowUrlRelDAOImpl() {
        super();
    }

    public int countByExample(BSysFlowUrlRelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_FLOW_URL_REL.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysFlowUrlRelExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_FLOW_URL_REL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BSysFlowUrlRel _key = new BSysFlowUrlRel();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_SYS_FLOW_URL_REL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BSysFlowUrlRel record) {
        getSqlMapClientTemplate().insert("B_SYS_FLOW_URL_REL.insert", record);
    }

    public void insertSelective(BSysFlowUrlRel record) {
        getSqlMapClientTemplate().insert("B_SYS_FLOW_URL_REL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysFlowUrlRel> selectByExample(BSysFlowUrlRelExample example) {
        List<BSysFlowUrlRel> list = getSqlMapClientTemplate().queryForList("B_SYS_FLOW_URL_REL.selectByExample", example);
        return list;
    }

    public BSysFlowUrlRel selectByPrimaryKey(String id) {
        BSysFlowUrlRel _key = new BSysFlowUrlRel();
        _key.setId(id);
        BSysFlowUrlRel record = (BSysFlowUrlRel) getSqlMapClientTemplate().queryForObject("B_SYS_FLOW_URL_REL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysFlowUrlRel record, BSysFlowUrlRelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_FLOW_URL_REL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysFlowUrlRel record, BSysFlowUrlRelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_FLOW_URL_REL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysFlowUrlRel record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_FLOW_URL_REL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysFlowUrlRel record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_FLOW_URL_REL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysFlowUrlRel> selectByPage(BSysFlowUrlRelExample example, Page page) {
        List<BSysFlowUrlRel> list = this.searchListPageMyObject("B_SYS_FLOW_URL_REL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysFlowUrlRelExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysFlowUrlRelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.dao.IBSysFlowUrlRelDAO#selectByFlowAndNodeId(com.huateng.scf.bas.sys.dao.model.BSysFlowUrlRel)
	 */
	@Override
	public BSysFlowUrlRel selectByFlowAndNodeId(BSysFlowUrlRel bSysFlowUrlRel) {
		BSysFlowUrlRel record = (BSysFlowUrlRel) getSqlMapClientTemplate()
				.queryForObject("B_SYS_FLOW_URL_REL.selectByFlowAndNodeId", bSysFlowUrlRel);
		return record;
	}
    
}