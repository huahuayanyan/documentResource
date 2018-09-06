package com.huateng.scf.nrec.bcp.service.impl.intercept;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;

@Service("ChkFAppliCallSerivceImpl")
public class ChkFAppliCallSerivceImpl extends SysChkCallService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkFAppliCallSerivceImpl--"+chkMap.toString());
		chkResult.setStat(this.SUCCESS);
	}

}
