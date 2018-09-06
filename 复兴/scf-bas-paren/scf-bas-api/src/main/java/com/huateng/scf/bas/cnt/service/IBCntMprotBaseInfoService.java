package com.huateng.scf.bas.cnt.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.mrn.vo.ProtocolQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCntMprotBaseInfoService {
	public static final String BEAN_ID = "bCntMprotBaseInfoService";

	public BCntMprotBaseInfo addBCntMprotBaseInfo(@ScubeParam("bCntMprotBaseInfo") BCntMprotBaseInfo bCntMprotBaseInfo) throws ScubeBizException;

	/**
	 * @param bCntDebtInfo
	 * @return
	 */
	public int updateBCntMprotBaseInfo(@ScubeParam("bCntMprotBaseInfo") BCntMprotBaseInfo bCntMprotBaseInfo) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBCntMprotBaseInfo(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public BCntMprotBaseInfo findBCntMprotBaseInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCntDebtInfo
	 * @return
	 */
	public Page findBCntMprotBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCntMprotBaseInfo") BCntMprotBaseInfo bCntMprotBaseInfo) throws ScubeBizException;

	/**
	 * 
	 * @param example
	 * @return
	 */
	/*
	 * public List<BCntMprotBaseInfo> selectBCntMprotBaseInfoByExample(
	 * 
	 * @ScubeParam("example") BCntMprotBaseInfoExample example) throws
	 * ScubeBizException;
	 */

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCntMprotBaseInfo
	 * @return
	 */
	public Page selectBCntMprotBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntMprotBaseInfo bCntMprotBaseInfo) throws ScubeBizException;

	/**
	 * 根据关联协议查询监管协议
	 * 
	 * @param otherProtocolNo
	 * @param protocolType
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BCntMprotBaseInfo> getProtocolByOtherProtocol(@ScubeParam("otherProtocolNo") String otherProtocolNo,
			@ScubeParam("protocolType") String protocolType) throws ScubeBizException;

	/**
	 * 根据监管协议号查询监管公司客户号
	 * @param protocolNo
	 * @return
	 * @throws ScubeBizException
	 */
	public String getMoniCustcdByMoniProtocolNo(@ScubeParam("protocolNo") String protocolNo) throws ScubeBizException;
	
	public Page getMutiProtDropDownInfo(@ScubeParam("protocolQryVO") ProtocolQryVO protocolQryVO) throws ScubeBizException;

	/**
	 * 
	 * @param slaveContno
	 * @param appno
	 * @param protocolType
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月19日上午10:55:15
	 */
	public String getMonitorProtocolNoBySlaveContnoAppnoPt(@ScubeParam("slaveContno") String slaveContno, @ScubeParam("appno") String appno,
			@ScubeParam("protocolType") String protocolType) throws ScubeBizException;

	/**
	 * 四方保兑：根据经销商核心厂商客户查询抵质押合同
	 * 
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月20日下午4:05:26
	 */
	public Page getContSlaveByCustcdAndCore(@ScubeParam("contSlaveQryVO") ContSlaveQryVO contSlaveQryVO) throws ScubeBizException;

}
