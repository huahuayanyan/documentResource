package com.huateng.scf.bas.cnt.service;


import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.model.CheckStockVO;
import com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO;
 
import com.huateng.scf.adv.tcs.model.ThreeBalanceRefundLnciVO;
import com.huateng.scf.bas.cnt.model.ThreeProtocolVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>发货对账</p>
  
 */
public interface IBCntFourCheckStockService {
	public static final String BEAN_ID = "fourCheckStockService";
	/**
	 *发货对账查询列表
	 * @param pageNo
	 * @param pageSize
	 * @param conditionForm
	 * @return
	 * @throws ScubeBizException
	 */
	public Page queryFourCheckStockByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("conditionForm") Map<String,Object> param) throws ScubeBizException;
	/**
	 *先票/款后货发货明细信息查询
	 * @param pageNo
	 * @param pageSize
	 * @param conditionForm
	 * @return
	 * @throws ScubeBizException
	 */
	public Page fourCheckStockDebetByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("conditionForm") Map<String,String> param) throws ScubeBizException;
	/**
	 *担先票/款后货发货明细信息查询 (不分页)
	 ***/
	public List<ThreeCheckStockDebetVO> fourCheckStockDebt(@ScubeParam("conditionForm") Map<String,String> param) throws ScubeBizException;
	
	
	/**
	 *先票/款后货发货明细信息 条数
	 ***/
	public int fourCheckStockNum(@ScubeParam("conditionForm") Map<String,String> param) throws ScubeBizException;
	
	
	/**
	 * 发起对账*/
	public void fourCheckStockApply(@ScubeParam("threeProtocolVO") ThreeProtocolVO threeProtocolVO,
			@ScubeParam("debetList") List<ThreeCheckStockDebetVO> debetList);
	
	/**
	 * 确认对账*/
	public void fourCheckStockVerify(@ScubeParam("baseInfo") CheckStockVO baseInfo);
	
	/**
	 *先票/款后货发货明细信息查询  
	 *收款和提货的汇总金额：收到款项总计 ，累计提货总计 ，剩余提货总计
	 ***/
	public Map<String,Object> fourCheckStockDebtSum(@ScubeParam("conditionForm") Map<String,String> param) throws ScubeBizException;
	
	
	
	
}
