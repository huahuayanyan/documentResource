package com.huateng.scf.bas.mrn.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.cnt.model.MonitorProtocolVO;
import com.huateng.scf.bas.common.model.DeliveryApplyQryVO;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.mrn.vo.CashEqualValueContractVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.mrn.vo.ProtocolQryVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.sto.nwr.vo.PledgeContractVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

@SuppressWarnings("deprecation")
public interface IContractService {

	public List<CashEqualValueContractVO> getCashEqualValueWriteLnciInfo(@ScubeParam("appno") String appno,@ScubeParam("debetNo") String debetNo,@ScubeParam("pageIndex") int pageIndex,@ScubeParam("pageSize") int pageSize)
			throws ScubeBizException;

	public List<CashEqualValueContractVO> getCashEqualValueLnciByMastContno(@ScubeParam("mastContno") String mastContno) throws ScubeBizException;

	public Page getTblContDebtInfoList(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO) throws ScubeBizException;

	public Page getLnciBaseInfoWriteByParamGetter(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	public Page getLnciBaseInfoByParamGetter(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	public Page getBillCustAccountInfoByParam(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	public Page getAppliLnciBaseInfo(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	public Page getBillCustAccountInfoApproveByParam(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	public Page getMutiProtPartInfoByPara(@ScubeParam("commonQueryVO") DeliveryApplyQryVO commonQueryVO) throws ScubeBizException;

	public Page getContSlaveBaseInfo(@ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;

	public BCrrGntyCon getTblContSlaveInfo(@ScubeParam("slaveContno") String slaveContno) throws ScubeBizException;

	public String getProductByParentId(@ScubeParam("parentId") String parentId) throws ScubeBizException;

	public Page getAppContInfoBySupplyChainPdId(@ScubeParam("pledgeContractVO") PledgeContractVO pledgeContractVO) throws ScubeBizException;

	public BCrrLnCon getTblContBaseInfo(@ScubeParam("mastContno") String mastContno) throws ScubeBizException;

	/**
	 * 
	 * @param slaveContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月18日上午10:40:26
	 */
	public Page getMutiProtPartInfo(@ScubeParam("slaveContno") String slaveContno) throws ScubeBizException;

	/**
	 * 监管协议获取
	 * @param protocolQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月21日下午1:54:25
	 */
	public Page getMonitorProtocolQuery(@ScubeParam("protocolQryVO") ProtocolQryVO protocolQryVO) throws ScubeBizException;

	/**
	 * 查询抵质押合同列表
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午2:31:08
	 */
	public Page getSlaveContList(@ScubeParam("contSlaveQryVO") ContSlaveQryVO contSlaveQryVO) throws ScubeBizException;

	/**
	 * 信贷合同列表
	 * @param commonQueryVo
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午4:54:08
	 */
	public Page getContBaseInfoListBySlaveContno(@ScubeParam("contSlaveQryVO") ContSlaveQryVO contSlaveQryVO);

	/**
	 * 查询质押合同下所有借据
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午5:20:56
	 */
	public Page getLnciBaseInfoListBySlaveContno(@ScubeParam("contSlaveQryVO") ContSlaveQryVO contSlaveQryVO) throws ScubeBizException;
	
	/**
	 * 保存时验证担保合同是否已被其他供应链产品抢占,未抢占则更新担保合同的产品ID
	 * @param slaveContno
	 * @param supplyChainPdId
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午4:06:59
	 */
	public void checkUpdateSlaveContractBySupplyChainPdId(@ScubeParam("slaveContno") String slaveContno,@ScubeParam("supplyChainPdId") String supplyChainPdId) throws ScubeBizException;
	
	/**
	 * 监管商变更
	 * @param contractVO
	 * @throws ScubeBizException
	 * @author 	tangwei
	 * @date 	2017年7月13日
	 */
	public String saveChgMutiProt(@ScubeParam("contractVO") MonitorProtocolVO monitorProtocolVO) throws ScubeBizException;
}
