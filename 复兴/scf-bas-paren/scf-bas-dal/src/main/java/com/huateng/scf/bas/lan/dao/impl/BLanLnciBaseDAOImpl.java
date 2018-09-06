package com.huateng.scf.bas.lan.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseVO;
import com.huateng.scf.bas.lan.dao.vo.FinAmtDistrib;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BLanLnciBaseDAO")
public class BLanLnciBaseDAOImpl extends IbatisDaoAnnotation4Template implements IBLanLnciBaseDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BLanLnciBaseDAOImpl() {
        super();
    }

    //添加
    @SuppressWarnings("unchecked")
    public BigDecimal getTotalLoanAmtInContInfo(String mastContno){
    	List<Map> list = getSqlMapClientTemplate().queryForList("B_LAN_LNCI_BASE.getTotalLoanAmtInContInfo", mastContno);
    	String loanAmt = "";
    	Map map = null;
    	BigDecimal totalLnciBal = BigDecimal.ZERO;
    	if(list.size()>0){
    		Iterator iter = list.iterator();
			while(iter.hasNext()){
				map = (Map) iter.next();
				BigDecimal lnciAmt = (BigDecimal) (map.get("LOANAMT")==null?BigDecimal.ZERO:map.get("LOANAMT"));
				totalLnciBal =totalLnciBal.add(lnciAmt==null?new BigDecimal("0"):lnciAmt);
			}
    	}
    	return totalLnciBal;
    }
    public int countByExample(BLanLnciBaseExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_LAN_LNCI_BASE.countByExample", example);
        return count;
    }

    public int deleteByExample(BLanLnciBaseExample example) {
        int rows = getSqlMapClientTemplate().delete("B_LAN_LNCI_BASE.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String debetNo) {
        BLanLnciBase _key = new BLanLnciBase();
        _key.setDebetNo(debetNo);
        int rows = getSqlMapClientTemplate().delete("B_LAN_LNCI_BASE.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BLanLnciBase record) {
        getSqlMapClientTemplate().insert("B_LAN_LNCI_BASE.insert", record);
    }

    public void insertSelective(BLanLnciBase record) {
        getSqlMapClientTemplate().insert("B_LAN_LNCI_BASE.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BLanLnciBase> selectByExample(BLanLnciBaseExample example) {
        List<BLanLnciBase> list = getSqlMapClientTemplate().queryForList("B_LAN_LNCI_BASE.selectByExample", example);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BLanLnciBase> queryLnciInfoByBusinessNo(Map map) {
        List<BLanLnciBase> list = getSqlMapClientTemplate().queryForList("B_LAN_LNCI_BASE.queryLnciInfoByBusinessNo", map);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<BLanLnciBase> selectByAppno(String appno) {
        List<BLanLnciBase> list = getSqlMapClientTemplate().queryForList("B_LAN_LNCI_BASE.selectByAppno", appno);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BLanLnciBase> selectByCondition(String protocolNo) {
        List<BLanLnciBase> list = getSqlMapClientTemplate().queryForList("B_LAN_LNCI_BASE.selectByCondition", protocolNo);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BLanLnciBase> queryByCondition(BLanLnciBase bLanLnciBase) {
        List<BLanLnciBase> list = getSqlMapClientTemplate().queryForList("B_LAN_LNCI_BASE.queryByCondition", bLanLnciBase);
        return list;
    }
    
    public BLanLnciBase selectByPrimaryKey(String debetNo) {
        BLanLnciBase _key = new BLanLnciBase();
        _key.setDebetNo(debetNo);
        BLanLnciBase record = (BLanLnciBase) getSqlMapClientTemplate().queryForObject("B_LAN_LNCI_BASE.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BLanLnciBase record, BLanLnciBaseExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BASE.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BLanLnciBase record, BLanLnciBaseExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BASE.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BLanLnciBase record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BASE.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BLanLnciBase record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BASE.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BLanLnciBase> selectByPage(BLanLnciBaseExample example, Page page) {
        List<BLanLnciBase> list = this.searchListPageMyObject("B_LAN_LNCI_BASE.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BLanLnciBaseExample {
        private Object record;

        public UpdateByExampleParms(Object record, BLanLnciBaseExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //ext
    
    /**
     * 根据借据号查询借据信息
     * @param debetId
     * @return
     */
    public BLanLnciBase findBLanLnciBaseByDebtId(String debetId) {

        BLanLnciBase record = (BLanLnciBase) getSqlMapClientTemplate().queryForObject("EXT_B_LAN_LNCI_BASE.findBLanLnciBaseByDebtId", debetId);
        return record;
    }

   /**
    * 查询未结清且有效的借据
    */
    @Override
  	public List<BLanLnciBase> queryValidLnciBaseInfo(Map<String, Object> map) {
  		
  		List<BLanLnciBase> resultList = getSqlMapClientTemplate().queryForList("EXT_B_LAN_LNCI_BASE.queryValidLnciBaseInfo",map);
  		
  		return resultList;
  	}

	@Override
	public List getThreeLnciInfoListByExample(BLanLnciBaseExample example) {
		
		List resultList = getSqlMapClientTemplate().queryForList("EXT_B_LAN_LNCI_BASE.selectThreeLnciInfoList",example);
		
		return resultList;
	}

	
	@Override
	public int getThreeLnciInfoListCount(Map<String, Object> params) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_B_LAN_LNCI_BASE.selectThreeLnciInfoCount",params);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBaseVO> getThreeLnciInfoListPageByParams(Map<String, Object> params, Page pageResult) {
		List<BLanLnciBaseVO> resultList = this.searchListPageByMap("EXT_B_LAN_LNCI_BASE.selectThreeLnciInfoList",params,pageResult);
		return resultList;
	}
	
	/**
	 *
	 * @Description: 池 查询融资列表
	 * @author jialei.zhang
	 * @Created 2013-8-21上午11:48:13
	 * @param lnciQryVO
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBase> queryLnciInfoByBusinessNo(HashMap<String, Object> omap){
		List<BLanLnciBase> resultList = getSqlMapClientTemplate().queryForList("EXT_B_LAN_LNCI_BASE.queryLnciInfoByBusinessNo",omap);
		return resultList;
	}

	@Override
	public BLanLnciBase get(String debetNo) {
		BLanLnciBase result = (BLanLnciBase) getSqlMapClientTemplate().queryForObject("EXT_B_LAN_LNCI_BASE.findBLanLnciBaseByDebtNo", debetNo);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBase> getFourLnciInfoListPageByParams(Map<String, Object> params, Page pageResult) {
		List<BLanLnciBase> resultList = this.searchListPageByMap("EXT_B_LAN_LNCI_BASE.selectFourLnciInfoList",params,pageResult);
		return resultList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	    public List<BLanLnciBase> selectByIfspPage(Map map, Page page) {
	    	List<BLanLnciBase> list = this.searchListPageMyObject("B_LAN_LNCI_BASE.selectByIfspExample", map, page);
	    	return list;
	    }
	@SuppressWarnings("unchecked")
	@Override
	 public int countByIfspExample(Map map) {
	    	Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_LAN_LNCI_BASE.countByIfspExample", map);
	    	return count;
	    }

	@Override
	public BigDecimal queryLnciAmtBySlaveContno(Map map) {
		List<Map> list = getSqlMapClientTemplate().queryForList("EXT_B_LAN_LNCI_BASE.queryLnciAmtBySlaveContno", map);
    	Map map1 = null;
    	BigDecimal totalLnciBal = BigDecimal.ZERO;
    	if(list.size()>0){
    		Iterator iter = list.iterator();
			while(iter.hasNext()){
				map1 = (Map) iter.next();
				BigDecimal lnciAmt = (BigDecimal) (map1.get("LNCIAMT")==null?BigDecimal.ZERO:map1.get("LNCIAMT"));
				totalLnciBal =totalLnciBal.add(lnciAmt==null?new BigDecimal("0"):lnciAmt);
			}
    	}
    	return totalLnciBal;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO#queryFinAmtDistribList(java.util.Map)
	 */
	@Override
	public List<FinAmtDistrib> queryFinAmtDistribList(Map<String, Object> map) {
		List<FinAmtDistrib> resultList = getSqlMapClientTemplate()
				.queryForList("EXT_B_LAN_LNCI_BASE.queryFinAmtDistribList", map);
		return resultList;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO#queryFinAmtProductList(java.util.Map)
	 */
	@Override
	public List<FinAmtDistrib> queryFinAmtProductList(Map<String, Object> map) {
		List<FinAmtDistrib> resultList = getSqlMapClientTemplate()
				.queryForList("EXT_B_LAN_LNCI_BASE.queryFinAmtProductList", map);
		return resultList;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO#queryFinAmtTopList(java.util.Map)
	 */
	@Override
	public List<FinAmtDistrib> queryFinAmtTopList(Map<String, Object> map) {
		List<FinAmtDistrib> resultList = getSqlMapClientTemplate()
				.queryForList("EXT_B_LAN_LNCI_BASE.queryFinAmtTopList", map);
		return resultList;
	}
	
	@Override
    public List<Map<String, Object>> getKindsOfSum(String slaveContno,String oldThrCd){
		Map<String, String> map = new HashMap<String, String>();
		map.put("slaveContno", slaveContno);
		map.put("oldThrCd", oldThrCd);
		return getSqlMapClientTemplate()
				.queryForList("EXT_B_LAN_LNCI_BASE.getKindsOfSum", map);
    }

	@Override
	public List<BLanLnciBase> getTblLnciBaseInfo(String creditCustcd,String custcd,String slaveContno) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("creditCustcd", creditCustcd);
		map.put("custcd", custcd);
		map.put("slaveContno", slaveContno);
		return getSqlMapClientTemplate()
				.queryForList("EXT_B_LAN_LNCI_BASE.getTblLnciBaseInfo", map);
	}
	
}