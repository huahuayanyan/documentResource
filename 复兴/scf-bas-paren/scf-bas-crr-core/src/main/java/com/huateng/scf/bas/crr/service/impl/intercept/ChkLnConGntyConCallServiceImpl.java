package com.huateng.scf.bas.crr.service.impl.intercept;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConRelaDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRelaExample;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;

@Service("ChkLnConGntyConCallServiceImpl")
public class ChkLnConGntyConCallServiceImpl extends SysChkCallService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCrrLnConRelaDAO")
	IBCrrLnConRelaDAO bcrrlnconreladao;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkLnConGntyConCallServiceImpl--"+chkMap.toString());
		String appId = chkMap.get("appId").toString().trim();
		BCrrLnConRelaExample example = new BCrrLnConRelaExample();
		BCrrLnConRelaExample.Criteria cri = example.createCriteria();
		cri.andSerialnoEqualTo(appId);
		List<BCrrLnConRela> conrelalist = bcrrlnconreladao.selectByExample(example);
		for(BCrrLnConRela rela:conrelalist)
		{
			String conId = rela.getRltNo();
			BCrrGntyCon gntycon = bcrrgntycondao.selectByPrimaryKey(conId);
			if(gntycon.getStrtDt()==null||gntycon.getStrtDt().equals(""))
			{
				chkResult.setRem("担保合同生效日期未录入！");
				chkResult.setStat(this.ERROR);
				return;
			}
			if(gntycon.getEndDt()==null||gntycon.getEndDt().equals(""))
			{
				chkResult.setRem("担保合同到期日期未录入！");
				chkResult.setStat(this.ERROR);
				return;
			}
		}
		//chkResult.setRem("执行成功");
		chkResult.setStat(this.SUCCESS);
	}
}
