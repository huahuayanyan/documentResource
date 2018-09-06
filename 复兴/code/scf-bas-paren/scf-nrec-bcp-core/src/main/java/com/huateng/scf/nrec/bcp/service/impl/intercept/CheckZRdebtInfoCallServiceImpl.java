package com.huateng.scf.nrec.bcp.service.impl.intercept;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.nrec.bcp.service.ITransferApplyService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scube.exception.ScubeBizException;

@Service("CheckZRdebtInfoCallServiceImpl")
public class CheckZRdebtInfoCallServiceImpl extends SysChkCallService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rBcpDebtInfoService;

	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nRBcpAppliBussDtlService;

	@Resource(name = "TransferApplyServiceImpl")
	ITransferApplyService transferApplyService;

	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("RBcpDebtInfoServiceImpl--" + chkMap.toString());
		String appno = chkMap.get("appno").toString();
		List<RBcpAppliBussDtl> rBcpAppliBussDtlList = nRBcpAppliBussDtlService.queryRBcpAppliBussDtlByAppno(appno);
		if (rBcpAppliBussDtlList == null || rBcpAppliBussDtlList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		// 校验单据唯一性
		transferApplyService.checkDebtRule(rBcpAppliBussDtlList);

		chkResult.setStat(this.SUCCESS);
	}

}
