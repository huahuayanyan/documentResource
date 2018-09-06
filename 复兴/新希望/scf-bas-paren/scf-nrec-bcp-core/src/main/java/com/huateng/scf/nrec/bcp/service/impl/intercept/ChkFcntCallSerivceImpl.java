package com.huateng.scf.nrec.bcp.service.impl.intercept;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;

@Service("ChkFcntCallSerivceImpl")
public class ChkFcntCallSerivceImpl extends SysChkCallService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkFcntCallSerivceImpl--"+chkMap.toString());
		String mastContno = chkMap.get("mastContno").toString();
		BCntBcpInfoVO bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(mastContno);
		if(bCntBcpInfoVO==null)
		{
			//合同信息不存在
			chkResult.setRem("业务合同信息不存在！");
			chkResult.setStat(this.ERROR);
			return;
		}
		if(StringUtil.isEmpty(bCntBcpInfoVO.getStartDate()))
		{
			//合同信息未维护
			chkResult.setRem("合同信息缺失！");
			chkResult.setStat(this.ERROR);
			return;
		}
		chkResult.setStat(this.SUCCESS);
	}

}
