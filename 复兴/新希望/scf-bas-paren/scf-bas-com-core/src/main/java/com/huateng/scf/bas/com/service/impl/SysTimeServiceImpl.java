/**
 * 
 */
package com.huateng.scf.bas.com.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.huateng.authority.service.SysTimeService;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>获取系统交易工作日</p>
 *
 * @author 	huangshuidan
 * @date 2017年1月23日 下午5:30:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			     date			          Content
 * huangshuidan		     2017年1月23日下午5:30:07           新增
 *
 * </pre>
 */
@ScubeService
@Service("SysTimeServiceImpl")
public class SysTimeServiceImpl implements SysTimeService{

	/* (non-Javadoc)
	 * @see com.huateng.authority.service.SysTimeService#selectSystemTime()
	 */
	@Override
	public Date selectSystemTime() {
		ScfGlobalInfo scfGlobalInfo=ScfBaseData.getScfGlobalInfoData();
		Date sysDate=null;
		if(null!=scfGlobalInfo){
			sysDate=scfGlobalInfo.getTimestamps();
		}else{
			sysDate=new Date();
		}
		return sysDate;
	}
	
}
