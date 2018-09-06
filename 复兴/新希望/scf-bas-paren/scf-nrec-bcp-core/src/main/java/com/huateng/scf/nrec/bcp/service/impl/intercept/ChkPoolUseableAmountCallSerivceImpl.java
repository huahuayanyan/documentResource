package com.huateng.scf.nrec.bcp.service.impl.intercept;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;

@Service("ChkPoolUseableAmountCallSerivceImpl")
public class ChkPoolUseableAmountCallSerivceImpl extends SysChkCallService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nrbcpdebtpoolservice;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkFcntCallSerivceImpl--"+chkMap.toString());
		String appNo = chkMap.get("appno").toString();
		String invokPhase = chkMap.get("invokPhase").toString();
		
		String message = nrbcpdebtpoolservice.getPoolMessage(appNo, invokPhase);
		if(!StringUtil.isEmpty(message))
		{
			if(message.equals("1"))
			{
				chkResult.setRem("本次为非池业务申请,无需校验风险敞口!");
			}
			else
			{
				chkResult.setRem(message);
				chkResult.setStat(this.ERROR);
				return;
			}
		}
		chkResult.setStat(this.SUCCESS);
	}
}
