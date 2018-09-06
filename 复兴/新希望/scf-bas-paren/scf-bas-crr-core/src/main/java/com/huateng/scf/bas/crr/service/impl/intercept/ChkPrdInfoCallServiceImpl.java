package com.huateng.scf.bas.crr.service.impl.intercept;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.crr.dao.IBCrrBillInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrEqptInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrInvInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLcInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLgInfoDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrBillInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrEqptInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrInvInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrLcInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrLgInfo;
import com.huateng.scf.bas.crr.model.BCrrPrdMd;
import com.huateng.scf.bas.crr.service.impl.BCrrPrdMdServiceImpl;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;

@Service("ChkPrdInfoCallServiceImpl")
public class ChkPrdInfoCallServiceImpl extends SysChkCallService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BCrrPrdMdServiceImpl")
	BCrrPrdMdServiceImpl bcrrprdmdservice;
	
	@Resource(name = "IBCrrLgInfoDAO")
	IBCrrLgInfoDAO bcrrlginfodao;
	
	@Resource(name = "IBCrrEqptInfoDAO")
	IBCrrEqptInfoDAO bcrreqptinfodao;
	
	@Resource(name = "IBCrrLcInfoDAO")
	IBCrrLcInfoDAO bcrrlcinfodao;
	
	@Resource(name = "IBCrrBillInfoDAO")
	IBCrrBillInfoDAO bcrrbillinfodao;
	
	@Resource(name = "IBCrrInvInfoDAO")
	IBCrrInvInfoDAO bcrrinvinfodao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkPrdInfoCallServiceImpl--"+chkMap.toString());
		String prdId = chkMap.get("prdId").toString().trim();
		String extId = chkMap.get("extId").toString().trim();
		BCrrPrdMd prdmd = bcrrprdmdservice.findBCrrPrdMdByPrdId(prdId);
		String stat = prdmd.getStat();
		String titNm = prdmd.getTitNm();
		if(stat.equals("1"))
		{
			BCrrLgInfo lginfo = bcrrlginfodao.selectByPrimaryKey(extId);
			BCrrLcInfo lcinfo = bcrrlcinfodao.selectByPrimaryKey(extId);
			BCrrEqptInfo eqptinfo = bcrreqptinfodao.selectByPrimaryKey(extId);
			List<BCrrBillInfo> billinfo = bcrrbillinfodao.selectByExtId(extId);
			List<BCrrInvInfo> invinfo = bcrrinvinfodao.selectByExtId(extId);
			if(lginfo==null&&lcinfo==null&&eqptinfo==null&&billinfo.size()==0&&invinfo.size()==0)
			{
				chkResult.setRem("当前业务"+titNm+"未维护！");
				chkResult.setStat(this.ERROR);	
			}
			else
			{
				//chkResult.setRem("执行成功");
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
