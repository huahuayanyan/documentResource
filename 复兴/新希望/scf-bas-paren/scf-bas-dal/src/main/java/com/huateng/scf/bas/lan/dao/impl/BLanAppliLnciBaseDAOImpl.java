package com.huateng.scf.bas.lan.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBaseExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BLanAppliLnciBaseDAO")
public class BLanAppliLnciBaseDAOImpl extends IbatisDaoAnnotation4Template implements IBLanAppliLnciBaseDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BLanAppliLnciBaseDAOImpl() {
        super();
    }

    public int countByExample(BLanAppliLnciBaseExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_LAN_APPLI_LNCI_BASE.countByExample", example);
        return count;
    }

    public int deleteByExample(BLanAppliLnciBaseExample example) {
        int rows = getSqlMapClientTemplate().delete("B_LAN_APPLI_LNCI_BASE.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BLanAppliLnciBase _key = new BLanAppliLnciBase();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_LAN_APPLI_LNCI_BASE.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BLanAppliLnciBase record) {
        getSqlMapClientTemplate().insert("B_LAN_APPLI_LNCI_BASE.insert", record);
    }

    public void insertSelective(BLanAppliLnciBase record) {
        getSqlMapClientTemplate().insert("B_LAN_APPLI_LNCI_BASE.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BLanAppliLnciBase> selectByExample(BLanAppliLnciBaseExample example) {
        List<BLanAppliLnciBase> list = getSqlMapClientTemplate().queryForList("B_LAN_APPLI_LNCI_BASE.selectByExample", example);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Map> getFlowRiskAmtByVidno(String protocolNo) {
        List<Map> list = getSqlMapClientTemplate().queryForList("B_LAN_APPLI_LNCI_BASE.getFlowRiskAmtByVidno", protocolNo);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<Map> getFlowKindsOfSumByMastContno(String mastContno) {
        List<Map> list = getSqlMapClientTemplate().queryForList("B_LAN_APPLI_LNCI_BASE.getFlowKindsOfSumByMastContno", mastContno);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<Map> getFlowRiskAmtByMastContno(String mastContno) {
        List<Map> list = getSqlMapClientTemplate().queryForList("B_LAN_APPLI_LNCI_BASE.getFlowRiskAmtByMastContno", mastContno);
        return list;
    }
    
    public BLanAppliLnciBase selectByPrimaryKey(String id) {
        BLanAppliLnciBase _key = new BLanAppliLnciBase();
        _key.setId(id);
        BLanAppliLnciBase record = (BLanAppliLnciBase) getSqlMapClientTemplate().queryForObject("B_LAN_APPLI_LNCI_BASE.selectByPrimaryKey", _key);
        return record;
    }

    public BLanAppliLnciBase selectByAppno(String appno) {
        BLanAppliLnciBase record = (BLanAppliLnciBase) getSqlMapClientTemplate().queryForObject("B_LAN_APPLI_LNCI_BASE.selectByAppno", appno);
        return record;
    }
    
    public int updateByExampleSelective(BLanAppliLnciBase record, BLanAppliLnciBaseExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_APPLI_LNCI_BASE.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BLanAppliLnciBase record, BLanAppliLnciBaseExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_APPLI_LNCI_BASE.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BLanAppliLnciBase record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_APPLI_LNCI_BASE.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BLanAppliLnciBase record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_APPLI_LNCI_BASE.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BLanAppliLnciBase> selectByPage(BLanAppliLnciBaseExample example, Page page) {
        List<BLanAppliLnciBase> list = this.searchListPageMyObject("B_LAN_APPLI_LNCI_BASE.selectByExample", example, page);
        return list;
    }
    
    public List<BLanAppliLnciBase> selectByAppNo(String appno) {
        List<BLanAppliLnciBase> list = getSqlMapClientTemplate().queryForList("B_LAN_APPLI_LNCI_BASE.selectByAppNo",appno);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BLanAppliLnciBaseExample {
        private Object record;

        public UpdateByExampleParms(Object record, BLanAppliLnciBaseExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //EXT
    /**
     * 根据借据号查询借据申请信息
     * @param debetId
     * @return
     */
    public BLanAppliLnciBase findBLanAppliLnciBaseByDebtId(String debetId) {
    	BLanAppliLnciBase record = (BLanAppliLnciBase) getSqlMapClientTemplate().queryForObject("EXT_B_LAN_APPLI_LNCI_BASE.findBLanAppliLnciBaseByDebtId", debetId);
        return record;
    }

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO#queryBLanAppliLnciBaseByDebtNo(java.lang.String)
	 */
	@Override
	public BLanAppliLnciBase queryBLanAppliLnciBaseByDebtNo(String debetNo) {
		BLanAppliLnciBase record = (BLanAppliLnciBase) getSqlMapClientTemplate().queryForObject("EXT_B_LAN_APPLI_LNCI_BASE.queryBLanAppliLnciBaseByDebtNo", debetNo);
        return record;
	}

	@Override
	public List<BLanAppliLnciBase> getTblAppliLnciBaseInfo(String creditCustcd, String custcd, String slaveContno) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("creditCustcd", creditCustcd);
		map.put("custcd", custcd);
		map.put("slaveContno", slaveContno);
		return getSqlMapClientTemplate()
				.queryForList("EXT_B_LAN_APPLI_LNCI_BASE.getTblAppliLnciBaseInfo", map);
	}
    
}