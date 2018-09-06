package com.huateng.scf.bas.mrn.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.model.BCrrLnConCash;
import com.huateng.scf.bas.mrn.vo.OldApplyVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>现金等价物解押接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月20日下午2:32:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月20日下午2:32:17	     新增
 *
 * </pre>
 */
public interface IDismortgageBillService {

	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(@ScubeParam("appno") String appno);

	public String StartUpdater(@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash) throws ScubeBizException;

	public Page queryListByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash);

	public Page DismortgageBillWriteContGetter(@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash) throws ScubeBizException;

	public Page DismortgageBillLnciGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash);

	public Page DismortgageBillwriteBillGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash)
			throws ScubeBizException;

	@SuppressWarnings("rawtypes")
	public void DismortgageBillWriteUpdater(@ScubeParam("cont") OldApplyVO cont,@ScubeParam("billList") List billList,@ScubeParam("lnciList") List lnciList,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;

	public Page DismortgageBillApproveLnciGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash)
			throws ScubeBizException;

	public Page DismortgageBillApproveBillGetter(@ScubeParam("appno") String appno) throws ScubeBizException;

	public void DismortgageBillApproveUpdater(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;

	public void DismortgageBillConfirmUpdater(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;

	public void DismortgageBillPrintUpdater(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;

	public void DismortgageBillGoBackUpdater(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;

}
