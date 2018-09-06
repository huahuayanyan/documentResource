package com.huateng.scf.bas.cnt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.DebtContVO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;

@Repository("BCntDebtInfoDAO")
public class BCntDebtInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntDebtInfoDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BCntDebtInfoDAOImpl() {
		super();
	}

	public int countByExample(BCntDebtInfoExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_CNT_DEBT_INFO.countByExample", example);
		return count;
	}

	public int deleteByExample(BCntDebtInfoExample example) {
		int rows = getSqlMapClientTemplate().delete("B_CNT_DEBT_INFO.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String debtContno) {
		BCntDebtInfo _key = new BCntDebtInfo();
		_key.setDebtContno(debtContno);
		int rows = getSqlMapClientTemplate().delete("B_CNT_DEBT_INFO.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BCntDebtInfo record) {
		getSqlMapClientTemplate().insert("B_CNT_DEBT_INFO.insert", record);
	}

	public void insertSelective(BCntDebtInfo record) {
		getSqlMapClientTemplate().insert("B_CNT_DEBT_INFO.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BCntDebtInfo> selectByExample(BCntDebtInfoExample example) {
		List<BCntDebtInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_DEBT_INFO.selectByExample", example);
		return list;
	}

	public BCntDebtInfo selectByPrimaryKey(String debtContno) {
		BCntDebtInfo _key = new BCntDebtInfo();
		_key.setDebtContno(debtContno);
		BCntDebtInfo record = (BCntDebtInfo) getSqlMapClientTemplate().queryForObject("B_CNT_DEBT_INFO.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BCntDebtInfo record, BCntDebtInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CNT_DEBT_INFO.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BCntDebtInfo record, BCntDebtInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CNT_DEBT_INFO.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BCntDebtInfo record) {
		int rows = getSqlMapClientTemplate().update("B_CNT_DEBT_INFO.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BCntDebtInfo record) {
		int rows = getSqlMapClientTemplate().update("B_CNT_DEBT_INFO.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BCntDebtInfo> selectByPage(BCntDebtInfoExample example, Page page) {
		List<BCntDebtInfo> list = this.searchListPageMyObject("B_CNT_DEBT_INFO.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BCntDebtInfoExample {
		private Object record;

		public UpdateByExampleParms(Object record, BCntDebtInfoExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	// ext
	/**
	 * 应收账款合同查询列表
	 * 
	 * @param bCntDebtInfo
	 * @param page
	 * @return
	 */
	@Override
	public List<DebtContVO> selectBCntDebtInfoList(Map<String, Object> map, Page page) {
		List<DebtContVO> list = this.searchListPageMyObject("EXT_B_CNT_DEBT_INFO.selectBCntDebtInfoList", map, page);
		return list;
	}

	// 交易对手买方的选择
	public List findCustBaseInfoList(Map map, Page page) {
		List list = this.searchListPageMyObject("EXT_B_CNT_DEBT_INFO.findCustBaseInfoList", map, page);
		return list;
	}

	/**
	 * 根据业务品种获得费用相关信息
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> findCostInfoByProduct(Map<String, String> map, Page page) {
		List<Map<String, String>> list = this.searchListPageMyObject("EXT_B_CNT_DEBT_INFO.findCostInfoByProduct", map, page);
		return list;
	}

	/**
	 * 根据合同编号获得应收账款合同的详情信息
	 * 
	 * @param map
	 * @return
	 */
	public DebtContVO queryBCntDebtInfoByContno(Map<String, String> map) {
		DebtContVO record = (DebtContVO) getSqlMapClientTemplate().queryForObject("EXT_B_CNT_DEBT_INFO.queryBCntDebtInfoByContno", map);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.cnt.dao.ext.ExtIBCntMprotBaseInfoDAO#
	 * findBCrmByFactType(com.huateng.base.common.beans.Page,
	 * com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoExample)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BCrmBaseInfo> findBCrmByFactType(Page page, HashMap<String, String> example) {
		List<BCrmBaseInfo> list = this.searchListPageMyObject("EXT_B_CNT_DEBT_INFO.queryBCrmCustcdByFactType", example, page);
		return list;

	}

	/*
	 * 商纠首页应收合同查询
	 * 
	 * @lihao
	 * 
	 */
	@Override
	public List<DebtContVO> selectBCntDebtInfoListForDispute(Map<String, Object> map, Page page) {
		List<DebtContVO> list = this.searchListPageMyObject("EXT_B_CNT_DEBT_INFO.selectBCntDebtInfoForDispute", map, page);
		return list;
	}
	  /**
     * 查询应收账款
     * @param bCntDebtInfo
     * @param page
     * @return
     */
    @Override
	public List<DebtContVO> selectIfspBCntDebtInfoList(Map<String, Object> map, Page page) {
		List<DebtContVO> list =this.searchListPageMyObject("EXT_B_CNT_DEBT_INFO.selectIfspBCntDebtInfoList", map,page);
        return list;
	}
}