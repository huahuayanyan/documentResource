package com.huateng.scf.rec.bcp.service;

import java.util.ArrayList;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.ImpairmentInfo;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBCntDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBCntDebtExtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfoV;
import com.huateng.scf.rec.bcp.model.TaskBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpImpairmentService {

	public TaskBaseInfo queryTaskBaseInfo(@ScubeParam("debtContno") String debtContno) throws Exception;

	public RBCntDebtBaseInfo queryBaseInfo(@ScubeParam("debtContno") String debtContno) throws Exception;

	public RBCntDebtExtBaseInfo queryPoolBaseInfo(@ScubeParam("debtContno") String debtContno) throws Exception;

	public List selectBuyerName(@ScubeParam("debtContno") String debtContno) throws Exception;

	public String saveImpairmentRequestInfo(@ScubeParam("taskBaseInfo") TaskBaseInfo taskBaseInfo, @ScubeParam("baseInfo") RBCntDebtBaseInfo BaseInfo,
			@ScubeParam("impairmentInfo") ImpairmentInfo impairmentInfo, @ScubeParam("rBcpDebtBaseInfo") List<RBcpDebtBaseInfoV> bBcpDebtBaseInfoList)
					throws Exception;

	public void submitImpairmentRequestInfo(@ScubeParam("taskBaseInfo") TaskBaseInfo taskBaseInfo, @ScubeParam("baseInfo") RBCntDebtBaseInfo BaseInfo,
			@ScubeParam("impairmentInfo") ImpairmentInfo impairmentInfo, @ScubeParam("rBcpDebtBaseInfo") List<RBcpDebtBaseInfoV> bBcpDebtBaseInfoList)
					throws Exception;

	public String getBPbcAppliBaseInfoStateByAppno(@ScubeParam("key") String key) throws Exception;

	public RBCntDebtBaseInfo queryBaseInfoTask(@ScubeParam("key") String key) throws Exception;

	public List selectBuyerNameTask(@ScubeParam("key") String key) throws Exception;

	public ImpairmentInfo getImpairmentInfoByAppno(@ScubeParam("key") String key) throws Exception;

	public Page findRBcpDebtBaseInfoPageByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("key") String key)
			throws Exception;

	public void saveImpairmentRequestInfoTask(@ScubeParam("key") String key, @ScubeParam("taskBaseInfo") TaskBaseInfo taskBaseInfo,
			@ScubeParam("baseInfo") RBCntDebtBaseInfo BaseInfo, @ScubeParam("impairmentInfo") ImpairmentInfo impairmentInfo,
			@ScubeParam("rBcpDebtBaseInfo") List<RBcpDebtBaseInfoV> bBcpDebtBaseInfoList) throws Exception;

	public void submitImpairmentRequestInfoTask(@ScubeParam("key") String key, @ScubeParam("taskBaseInfo") TaskBaseInfo taskBaseInfo,
			@ScubeParam("baseInfo") RBCntDebtBaseInfo BaseInfo, @ScubeParam("impairmentInfo") ImpairmentInfo impairmentInfo,
			@ScubeParam("rBcpDebtBaseInfo") List<RBcpDebtBaseInfoV> bBcpDebtBaseInfoList) throws Exception;

	public Page getLanLnciInfoByContno(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("debtContno") String debtContno, @ScubeParam("debtno") List debtno) throws Exception;

	public void deleterBcpDebtBasebyId(@ScubeParam("id") String id, @ScubeParam("appNo") String appNo,
			@ScubeParam("impairmentCount") String impairmentCount, @ScubeParam("impairmentAmount") String impairmentAmount) throws Exception;

	public Page queryBCntDebtInfoListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("factType") String factType, @ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;

	// 减值页面保存按钮
	public RBcpAppliBussInfo ImpairApplySaveUpdate(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO,
			@ScubeParam("RBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds, @ScubeParam("processModel") ProcessModel processModel)
					throws ScubeBizException;

	// 新增对应的申请信息，申请明细信息，锁定单据
	public void addImpairBussInfo(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO, @ScubeParam("RBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds,
			@ScubeParam("appno") String appno) throws ScubeBizException;

	// 修改申请信息，申请明细信息，调整锁定单据
	public void updateImpairBussInfo(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO,
			@ScubeParam("RBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds, @ScubeParam("appno") String appno) throws ScubeBizException;

	// 页面提交按钮
	public void impairApplySubmit(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO, @ScubeParam("RBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds,
			@ScubeParam("processModel") ProcessModel processModel) throws ScubeBizException;

	// 池融资减值涉及池信息变化
	public void updateDebtPoolInfo(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO) throws ScubeBizException;
}
