package com.huateng.scf.rec.bcp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository("RBcpAppliBussDtlDAO")
public class RBcpAppliBussDtlDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpAppliBussDtlDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public RBcpAppliBussDtlDAOImpl() {
        super();
    }

    public int countByExample(RBcpAppliBussDtlExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("R_BCP_APPLI_BUSS_DTL.countByExample", example);
        return count;
    }

    public int deleteByExample(RBcpAppliBussDtlExample example) {
        int rows = getSqlMapClientTemplate().delete("R_BCP_APPLI_BUSS_DTL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        RBcpAppliBussDtl _key = new RBcpAppliBussDtl();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("R_BCP_APPLI_BUSS_DTL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RBcpAppliBussDtl record) {
        getSqlMapClientTemplate().insert("R_BCP_APPLI_BUSS_DTL.insert", record);
    }

    public void insertSelective(RBcpAppliBussDtl record) {
        getSqlMapClientTemplate().insert("R_BCP_APPLI_BUSS_DTL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RBcpAppliBussDtl> selectByExample(RBcpAppliBussDtlExample example) {
        List<RBcpAppliBussDtl> list = getSqlMapClientTemplate().queryForList("R_BCP_APPLI_BUSS_DTL.selectByExample", example);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<RBcpAppliBussDtl> selectByAppno(String appno) {
    	RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
    	rBcpAppliBussDtl.setAppno(appno);
        List<RBcpAppliBussDtl> list = getSqlMapClientTemplate().queryForList("R_BCP_APPLI_BUSS_DTL.selectByAppno", rBcpAppliBussDtl);
        return list;
    }
    
    public RBcpAppliBussDtl selectByPrimaryKey(String id) {
        RBcpAppliBussDtl _key = new RBcpAppliBussDtl();
        _key.setId(id);
        RBcpAppliBussDtl record = (RBcpAppliBussDtl) getSqlMapClientTemplate().queryForObject("R_BCP_APPLI_BUSS_DTL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RBcpAppliBussDtl record, RBcpAppliBussDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_BUSS_DTL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RBcpAppliBussDtl record, RBcpAppliBussDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_BUSS_DTL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RBcpAppliBussDtl record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_BUSS_DTL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RBcpAppliBussDtl record) {
        int rows = getSqlMapClientTemplate().update("R_BCP_APPLI_BUSS_DTL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<RBcpAppliBussDtl> selectByPage(RBcpAppliBussDtlExample example, Page page) {
        List<RBcpAppliBussDtl> list = this.searchListPageMyObject("R_BCP_APPLI_BUSS_DTL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends RBcpAppliBussDtlExample {
        private Object record;

        public UpdateByExampleParms(Object record, RBcpAppliBussDtlExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpAppliBussDtl> selectAppliBussDtlByAppno(String appno) {
        RBcpAppliBussDtl _key = new RBcpAppliBussDtl();
        _key.setId(appno);
        List<RBcpAppliBussDtl> list = getSqlMapClientTemplate().queryForList("R_BCP_APPLI_BUSS_DTL.selectAppliBussDtlByAppno", _key);
        return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectBillsNoBySallerBuyerAndContno(Map<String, Object> parameters) {
		List<String>   list =getSqlMapClientTemplate().queryForList("R_BCP_APPLI_BUSS_DTL.selectBillsNoByParameters", parameters);
		return list;
	}

	/**
	 *
	 * @Description:根据appno,busstype查询TblAppliBussInfo表
	 * @author jialei.zhang
	 * @Created 2012-7-26下午02:59:45
	 * @param appno
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpAppliBussDtl> queryAppliBussDetailByAppno(String appno,String bussType)
	{
		RBcpAppliBussDtl key = new RBcpAppliBussDtl();
		key.setAppno(appno);
		if(bussType!=null&&bussType!="")
		{
			key.setBussType(bussType);
		}
		List<RBcpAppliBussDtl> list = getSqlMapClientTemplate().queryForList("EXT_R_BCP.queryAppliBussDetailByAppno", key);
		return list;
	}
}