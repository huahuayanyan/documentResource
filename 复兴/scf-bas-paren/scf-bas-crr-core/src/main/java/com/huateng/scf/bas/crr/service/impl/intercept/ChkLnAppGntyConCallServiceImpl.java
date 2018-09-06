package com.huateng.scf.bas.crr.service.impl.intercept;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnAppRelaDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;

@Service("ChkLnAppGntyConCallServiceImpl")
public class ChkLnAppGntyConCallServiceImpl extends SysChkCallService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCrrLnAppRelaDAO")
	IBCrrLnAppRelaDAO bcrrlnappreladao;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkLnAppGntyConCallServiceImpl--"+chkMap.toString());
		String appId = chkMap.get("appId").toString().trim();
		BCrrLnAppRelaExample example = new BCrrLnAppRelaExample();
		BCrrLnAppRelaExample.Criteria cri = example.createCriteria();
		cri.andSerialnoEqualTo(appId);
		List<BCrrLnAppRela> apprela = bcrrlnappreladao.selectByExample(example);
		if(apprela.size()==0)
		{
			chkResult.setRem("当前业务缺少相同担保类型担保合同！");
			chkResult.setStat(this.ERROR);
		}
		else
		{
			String appgnty = chkMap.get("guatTypMain").toString();
			StringBuilder sb = new StringBuilder();
			for(BCrrLnAppRela rela:apprela)
			{
				String conId = rela.getRltNo();
				BCrrGntyCon gntycon = bcrrgntycondao.selectByPrimaryKey(conId);
				sb.append(gntycon.getGutyTyp()).append(",");
			}
			String gutys = sb.toString().substring(0, sb.toString().lastIndexOf(","));
			String[] gutyArr = gutys.split(",");
			for(String guty : gutyArr)
			{
				if(appgnty.equals(guty))
				{
					//chkResult.setRem("执行成功");
					chkResult.setStat(this.SUCCESS);
					return;
				}
			}
			chkResult.setRem("当前业务缺少相同担保类型担保合同！");
			chkResult.setStat(this.ERROR);
		}
	}

}
