package com.huateng.scf.nrec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliRepayment;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;


public interface INRBcpAppliRepaymentService {
	
	public static final String BEAN_ID = "NRBcpAppliRepaymentServiceImpl";

	public void clearTblAppliRepaymentInfo(@ScubeParam("appno") String appno)throws ScubeBizException;

	public List<RBcpAppliRepayment> queryTblAppliRepaymentInfoByAppno(@ScubeParam("appno") String appno);

}
