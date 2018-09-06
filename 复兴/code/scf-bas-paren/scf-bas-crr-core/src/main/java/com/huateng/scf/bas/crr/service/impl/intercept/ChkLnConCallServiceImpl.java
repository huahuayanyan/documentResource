package com.huateng.scf.bas.crr.service.impl.intercept;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;

@Service("ChkLnConCallServiceImpl")
public class ChkLnConCallServiceImpl extends SysChkCallService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkLnConCallServiceImpl--"+chkMap.toString());
//		String prdId = chkMap.get("prdId").toString().trim();
//		if(prdId.equals("01")||prdId=="01")
//		{
		if(StringUtil.isEmpty(chkMap.get("lnStrtDt"))||StringUtil.isEmpty(chkMap.get("lnEndDt")))
		{
			chkResult.setRem("合同信息缺失！");
			chkResult.setStat(this.ERROR);
			return;
		}
//		}
		//chkResult.setRem("执行成功");
		chkResult.setStat(this.SUCCESS);
	}
}
