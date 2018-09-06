package com.huateng.scf.rec.bcp.service;

import java.util.List;

import com.huateng.scf.rec.bcp.model.RBcpAppliRepayment;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpAppliRepaymentService {
	/**
	 * 
	 * @param appno
	 * @return
	 */
	public List<RBcpAppliRepayment> queryTblAppliRepaymentInfoByAppno(@ScubeParam("appno") String appno);
	
	
	/**
	 * 通过APPNO清空还款表对应数据
	 * @param appno
	 * @throws ScubeBizException
	 */
	public void clearTblAppliRepaymentInfo(@ScubeParam("appno") String appno)throws ScubeBizException;
}
