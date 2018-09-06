package com.huateng.scf.bas.crr.service.impl.intercept;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.crr.dao.IBCrrLnAppRelaDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRela;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;

@Service("ChkGntyConCallServiceImpl")
public class ChkGntyConCallServiceImpl extends SysChkCallService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCrrLnAppRelaDAO")
	IBCrrLnAppRelaDAO bcrrlnappreladao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkGntyConCallServiceImpl--"+chkMap.toString());
		String appId = chkMap.get("appId").toString().trim();
		BCrrLnAppRelaExample example = new BCrrLnAppRelaExample();
		BCrrLnAppRelaExample.Criteria cri = example.createCriteria();
		cri.andSerialnoEqualTo(appId);
		List<BCrrLnAppRela> apprela = bcrrlnappreladao.selectByExample(example);
		if(apprela.size()==0)
		{
			//担保合同信息未维护
			chkResult.setRem("当前业务担保合同信息未维护！");
			chkResult.setStat(this.ERROR);
		}
		else
		{
			//chkResult.setRem("执行成功");
			chkResult.setStat(this.SUCCESS);
		}
	}

}
