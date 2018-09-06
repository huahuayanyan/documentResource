package com.huateng.scf.bas.cnt.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCntBuyInfoService {

	public BCntBuyInfo addBCntBuyInfo(@ScubeParam("bCntBuyInfo") BCntBuyInfo bCntBuyInfo, @ScubeParam("insertList") List<BCntMprotInfo> insertList)
			throws ScubeBizException;

	/**
	 * @param bCntDebtInfo
	 * @return
	 */
	public int updateBCntBuyInfoObject(@ScubeParam("bCntBuyInfo") BCntBuyInfo bCntBuyInfo) throws ScubeBizException;

	/**
	 * @param bCntDebtInfo
	 * @return
	 */
	public int updateBCntBuyInfo(@ScubeParam("bCntBuyInfo") BCntBuyInfo bCntBuyInfo, @ScubeParam("insertList") List<BCntMprotInfo> insertList,
			@ScubeParam("deleteList") List<BCntMprotInfo> deleteList) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteByPrimaryKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteByVO(@ScubeParam("bCntBuyInfo") BCntBuyInfo bCntBuyInfo) throws ScubeBizException;

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCntDebtInfo
	 * @return
	 */
	public Page findBCntBuyInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCntBuyInfo") BCntBuyInfo bCntBuyInfo) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public BCntBuyInfo findBCntBuyInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 
	 * @param example
	 * @return
	 */
	// public List<BCntBuyInfo>
	// selectBCntBuyInfoByExample(@ScubeParam("example") BCntBuyInfoExample
	// example)
	// throws ScubeBizException;
	/**
	 * 
	 * @param example
	 * @return
	 */
	public Page selectBCntBuyInfo(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntBuyInfo bCntBuyInfo, @ScubeParam("list") List list) throws ScubeBizException;

	/**
	 * 保兑仓协议筛选
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public Page selectThreeProtocolList(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") Map<String, String> value) throws ScubeBizException;

	/****
	 * 购销合同列表查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCntBuyInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page queryBCntBuyInfoListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") Map<String, String> value) throws ScubeBizException;

	/**
	 * 关联购销合同获取 -先票款后货
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCntBuyInfo
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getBuyContAdd(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("value") BCntBuyInfo bCntBuyInfo,
			@ScubeParam("list") List list) throws ScubeBizException;

	/****
	 * 获取购销合同押品信息表下的信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param 购销合同号
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getDeliveryNotifyBuycontInfo(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") String tradeContno) throws ScubeBizException;
	
	/**
	 * 根据协议号查询购销合同
	 * @param protocolNo
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BCntBuyInfo> findByProtocolNo(@ScubeParam("protocolNo") String protocolNo)throws ScubeBizException;
	
}
