package com.huateng.scf.rec.bcp.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpWriteoffService {

	/**
	 * 查询核销的信息
	 * @param debtBussInfoVO
	 * @return
	 * @throws Exception
	 */
	public DebtBussInfoVO queryBaseInfo(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO) throws ScubeBizException;
	/**
	 * 核销申请发票添加查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getInvoiceChargeOffAddQry(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value")Map rBcpDebtBaseInfo) throws ScubeBizException;

	/***
	 * 核销信息保存
	 * @param debtBussInfoVO
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 */
	public String saveWriteoffRequestInfo(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("rBcpDebtBaseInfoList") List<RBcpDebtBaseInfo> list) throws ScubeBizException;
    /**
     * 核销信息提交
     * @param debtBussInfoVO
     * @param list
     * @throws ScubeBizException
     */
	public void submitWriteoffRequestInfo(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("rBcpDebtBaseInfoList") List<RBcpDebtBaseInfo> list) throws ScubeBizException;
	

	/**
	 * 核销列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param factType
	 * @param mastContQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page queryBCntDebtInfoListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("factType")String factType,@ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;
	
	/**
	 * 获得应收账款列表
	 * @param pageNo
	 * @param pageSize
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Page findRBcpDebtBaseInfoPageByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("key") String key)throws Exception;
	
	
	/**
	 * 获取任务信息
	 * @param appno
	 * @return
	 */
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(@ScubeParam("appno") String appno,@ScubeParam("factType") String factType);
	

}
