package com.huateng.scf.bas.cnt.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfoExample;

public interface IBCntBuyInfoDAO {
	int countByExample(BCntBuyInfoExample example);

	int deleteByExample(BCntBuyInfoExample example);

	int deleteByPrimaryKey(String tradeContno);

	String insert(BCntBuyInfo record);

	void insertSelective(BCntBuyInfo record);

	List<BCntBuyInfo> selectByExample(BCntBuyInfoExample example);

	BCntBuyInfo selectByPrimaryKey(String tradeContno);

	int updateByExampleSelective(BCntBuyInfo record, BCntBuyInfoExample example);

	int updateByExample(BCntBuyInfo record, BCntBuyInfoExample example);

	int updateByPrimaryKeySelective(BCntBuyInfo record);

	int updateByPrimaryKey(BCntBuyInfo record);

	List<BCntBuyInfo> selectByPage(BCntBuyInfoExample example, Page page);

	List<BCntBuyInfo> selectContBuyInfoByDebetNo(String debetNo, Page page);

	Integer selectContBuyCountByDebetNo(String debetNo);

	List<BCntBuyInfo> selectByProtocolNo(String protocolNo);

	public Page selectThreeProtocolList(Map map, Page page);

	/***
	 * 购销合同列表查询
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	public Page queryBCntBuyInfoListByPage(Map map, Page page);

	/***
	 * 购销合同列表查询
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	public Page getDeliveryNotifyBuycontInfo(Map map, Page page);

}