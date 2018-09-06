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

@Service("ChkGntyConAddCallServiceImpl")
public class ChkGntyConAddCallServiceImpl extends SysChkCallService{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrLnConRelaDAO")
	IBCrrLnConRelaDAO bcrrlnconreladao;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkGntyConAddCallServiceImpl--"+chkMap.toString());
		String appId = chkMap.get("appId").toString().trim();
		BCrrLnConRelaExample example = new BCrrLnConRelaExample();
		BCrrLnConRelaExample.Criteria cri = example.createCriteria();
		cri.andSerialnoEqualTo(appId);
		List<BCrrLnConRela> conrelalist = bcrrlnconreladao.selectByExample(example);
		for(BCrrLnConRela rela:conrelalist)
		{
			String conId = rela.getRltNo();
			BCrrGntyCon gntycon = bcrrgntycondao.selectByPrimaryKey(conId);
			if(gntycon.getVidPrdId()==null||gntycon.getVidPrdId().equals(""))
			{
				String gntyconid = gntycon.getConId();
				chkResult.setRem("抵/质押合同号为"+gntyconid+"的信息未补录！");
				chkResult.setStat(this.ERROR);
				return;
			}
		}
		//chkResult.setRem("执行成功");
		chkResult.setStat(this.SUCCESS);
	}

}
