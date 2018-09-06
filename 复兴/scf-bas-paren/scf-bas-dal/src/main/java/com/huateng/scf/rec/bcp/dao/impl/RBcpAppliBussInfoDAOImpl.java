package com.huateng.scf.rec.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository("RBcpAppliBussInfoDAO")
public class RBcpAppliBussInfoDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpAppliBussInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public RBcpAppliBussInfoDAOImpl() {
        super();
    }

    public int countByExample(RBcpAppliBussInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("R_BCP_APPLI_BUSS_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(RBcpAppliBussInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("R_BCP_APPLI_BUSS_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        RBcpAppliBussInfo _key = new RBcpAppliBussInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("R_BCP_APPLI_BUSS_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RBcpAppliBussInfo record) {
        getSqlMapClientTemplate().insert("R_BCP_APPLI_BUSS_INFO.insert", record);
    }

    public void insertSelective(RBcpAppliBussInfo record) {
        getSqlMapClientTemplate().insert("R_BCP_APPLI_BUSS_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RBcpAppliBussInfo> selectByExample(RBcpAppliBussInfoExample example) {
        List<RBcpAppliBussInfo> list = getSqlMapClientTemplate().queryForList("R_BCP_APPLI_BUSS_INFO.selectByExample", example);
        return list;
    }

    @SuppressWarnings("unchecked")
    public RBcpAppliBussInfo selectByAppno(String appno) {
        RBcpAppliBussInfo record = (RBcpAppliBussInfo) getSqlMapClientTemplate().queryForObject("R_BCP_APPLI_BUSS_INFO.selectByAppno", appno);
        return record;
    }
    
    public RBcpAppliBussInfo selectByPrimaryKey(String id) {
        RBcpAppliBussInfo _key = new RBcpAppliBussInfo();
        _key.setId(id);
        RBcpAppliBussInfo record = (RBcpAppliBussInfo) getSqlMapClientTemplate().queryForObject("R_BCP_APPLI_BUSS_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RBcpAppliBussInfo record, RBcpAppliBussInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_BUSS_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RBcpAppliBussInfo record, RBcpAppliBussInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_BUSS_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RBcpAppliBussInfo record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_BUSS_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RBcpAppliBussInfo record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_BUSS_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<RBcpAppliBussInfo> selectByPage(RBcpAppliBussInfoExample example, Page page) {
        List<RBcpAppliBussInfo> list = this.searchListPageMyObject("R_BCP_APPLI_BUSS_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends RBcpAppliBussInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, RBcpAppliBussInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public List<RBcpAppliBussInfo> selectAppliBussInfoBillsNo(String appno) {
		Map<String, Object> parameterObject = new HashMap<String, Object>();
		parameterObject.put("appno", appno);
		List<RBcpAppliBussInfo> record = getSqlMapClientTemplate().queryForList("R_BCP_APPLI_BUSS_INFO.selectAppliBussInfoBillsByAppno", parameterObject);
	    return record;
	}



}