package com.huateng.scf.bas.mrn.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.CommonApplyDtlInfoVO;
import com.huateng.scf.bas.mrn.vo.BailLnciQryVO;
import com.huateng.scf.bas.mrn.vo.CashEqualValueContractVO;
import com.huateng.scf.bas.mrn.vo.OldApplyVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.mrn.vo.OldContractVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

@SuppressWarnings("deprecation")
public interface ICompositeMngService {

	public Page getTblCustAccountBussInfoByParam(@ScubeParam("commonQueryVO") BailLnciQryVO commonQueryVO) throws ScubeBizException;

	public String saveApplyBaseInfo(@ScubeParam("contractVO") CashEqualValueContractVO contractVO,@ScubeParam("businessnoType") String businessnoType,@ScubeParam("workApplyType") String workApplyType)
			throws ScubeBizException;

	@SuppressWarnings("rawtypes")
	public void saveAppliDetailInfo(@ScubeParam("inAppno") String inAppno,@ScubeParam("lncimodifyList") List lncimodifyList) throws ScubeBizException;

	@SuppressWarnings("rawtypes")
	public void saveAppliCustAccountInfo(@ScubeParam("inAppno") String inAppno,@ScubeParam("insertList") List insertList) throws ScubeBizException;

	public void saveTblCustAccountBussInfo(@ScubeParam("bussAppno") String bussAppno) throws ScubeBizException;

	public void updateLnciBaseInfoWithCashEql(@ScubeParam("bussAppno") String bussAppno) throws ScubeBizException;

	public Page getBailTransferQuery(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	public String saveApplyBaseInfo(@ScubeParam("applyVO") OldApplyVO applyVO,@ScubeParam("businessnoType") String businessnoType,@ScubeParam("workApplyType") String workApplyType) throws ScubeBizException;

	public BPbcAppliBaseInfo getTblAppliBaseInfo(@ScubeParam("appno") String appno);

	@SuppressWarnings("rawtypes")
	public String writeDismortgaegeBill(@ScubeParam("cont") OldApplyVO cont,@ScubeParam("billList") List billList,@ScubeParam("lnciList") List lnciList)
			throws ScubeBizException, IllegalAccessException, InvocationTargetException;

	public void saveNotice(@ScubeParam("commAppInfoVo") CommonApplyDtlInfoVO commAppInfoVo) throws ScubeBizException;

	public void dealPrint(@ScubeParam("commAppInfoVo") CommonApplyDtlInfoVO commAppInfoVo) throws ScubeBizException;

	public Page getMaxBailAccountApplyInfo(@ScubeParam("appno") String appno,@ScubeParam("slaveContno") String slaveContno,@ScubeParam("supplyChainPdId") String supplyChainPdId)
			throws ScubeBizException;

	public void saveBailTransferApply(@ScubeParam("contractVO") OldContractVO contractVO) throws ScubeBizException;

	public Page getBailTransferSerialQuery(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	public String saveApplyBaseInfo(@ScubeParam("contractVO") OldContractVO contractVO,@ScubeParam("businessnoType") String businessnoType,@ScubeParam("workApplyType") String workApplyType)
			throws ScubeBizException;

	public void saveBailTransferOutWriteNew(@ScubeParam("vo") OldContractVO vo) throws ScubeBizException;

	public void checkBailTransferOutIsSave(@ScubeParam("appno") String appno) throws ScubeBizException;

	public void updateBailTransferOutInfoNew(@ScubeParam("appno") String appno) throws ScubeBizException;
}
