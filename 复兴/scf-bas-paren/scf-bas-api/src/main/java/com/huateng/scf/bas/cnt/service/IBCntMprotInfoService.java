package com.huateng.scf.bas.cnt.service;


import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCntMprotInfoService {
	
	public BCntMprotInfo addBCntMprotInfo(@ScubeParam("bCntMprotInfo") BCntMprotInfo bCntMprotInfo) throws ScubeBizException;
		
	/**
	 * @param bCntDebtInfo
	 * @return
	 */
	public int updateBCntMprotInfo(@ScubeParam("bCntMprotInfo") BCntMprotInfo bCntMprotInfo) throws ScubeBizException;
	
	/**
	 * @param key
	 * @return
	 */
	public int deleteByPrimaryKey(@ScubeParam("key") String key) throws ScubeBizException;
	
	
	/**
	 * @param key
	 * @return
	 */
	public int deleteBCntMprotInfo(@ScubeParam("bCntMprotInfo") BCntMprotInfo bCntMprotInfo) throws ScubeBizException;
	
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCntDebtInfo
	 * @return
	 */
	public Page findBCntMprotInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCntBuyInfo") BCntBuyInfo bCntBuyInfo) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public BCntMprotInfo findBCntMprotInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 
	 * @param example
	 * @return
	 */
	//public List<BCntMprotInfo> selectBCntMprotInfoByExample(@ScubeParam("example") BCntMprotInfoExample example)throws ScubeBizException;
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCntDebtInfo
	 * @return
	 */
	public Page findBCntMprotInfoVOByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCntBuyInfo") BCntBuyInfo bCntBuyInfo) throws ScubeBizException;
	
	


}
