package com.huateng.scf.bas.cnt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.DebtContVO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;

public interface IBCntDebtInfoDAO {
	int countByExample(BCntDebtInfoExample example);

	int deleteByExample(BCntDebtInfoExample example);

	int deleteByPrimaryKey(String debtContno);

	void insert(BCntDebtInfo record);

	void insertSelective(BCntDebtInfo record);

	List<BCntDebtInfo> selectByExample(BCntDebtInfoExample example);

	BCntDebtInfo selectByPrimaryKey(String debtContno);

	int updateByExampleSelective(BCntDebtInfo record, BCntDebtInfoExample example);

	int updateByExample(BCntDebtInfo record, BCntDebtInfoExample example);

	int updateByPrimaryKeySelective(BCntDebtInfo record);

	int updateByPrimaryKey(BCntDebtInfo record);

	List<BCntDebtInfo> selectByPage(BCntDebtInfoExample example, Page page);

	// ext
	/**
	 * 应收账款合同列表
	 * 
	 * @param bCntDebtInfo
	 * @param page
	 * @return
	 */
	List<DebtContVO> selectBCntDebtInfoList(Map<String, Object> map, Page page);

	/**
	 * 应收账款合同列表(商纠使用)
	 * 
	 * @param bCntDebtInfo
	 * @param page
	 * @return
	 */
	List<DebtContVO> selectBCntDebtInfoListForDispute(Map<String, Object> map, Page page);

	// 交易对手买方的选择
	public List<?> findCustBaseInfoList(Map<String, Object> map, Page page);

	/**
	 * 根据业务品种获得费用信息
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> findCostInfoByProduct(Map<String, String> map, Page page);

	/**
	 * 根据合同编号获得应收账款合同的详情信息
	 * 
	 * @param map
	 * @return
	 */
	public DebtContVO queryBCntDebtInfoByContno(Map<String, String> map);

	/**
	 * 根据factType查询客户号，客户名称
	 * 
	 * @param map
	 * @return
	 */
	public List<BCrmBaseInfo> findBCrmByFactType(Page page, HashMap<String, String> example);
	public List<DebtContVO> selectIfspBCntDebtInfoList(Map<String, Object> map, Page page);


}