package com.huateng.scf.bas.crr.service.impl.intercept;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;

@Service("ChkDuebillAppCallServiceImpl")
public class ChkDuebillAppCallServiceImpl extends SysChkCallService{
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkDuebillAppCallServiceImpl--"+chkMap.toString());
		String appId = chkMap.get("appId").toString().trim();
		BCrrLnCon lncon = bcrrlnconservice.findBCrrLnConByAppId(appId);
		String vidNo = lncon.getVidNo();
		@SuppressWarnings("static-access")
		String flag = ScfBaseData.getInstance().getLoanWayFlag();
		if(flag.equals("1")||flag=="1")
		{
			if(StringUtil.isEmpty(vidNo))
			{
				//担保合同信息未维护
				chkResult.setRem("当前出账模式为供应链模式，信贷合同未关联！");
				chkResult.setStat(this.ERROR);
				return;
			}
			else
			{
				chkResult.setStat(this.SUCCESS);
			}
		}
		else
		{
			//chkResult.setRem("执行成功");
			chkResult.setStat(this.SUCCESS);
		}
	}
}
