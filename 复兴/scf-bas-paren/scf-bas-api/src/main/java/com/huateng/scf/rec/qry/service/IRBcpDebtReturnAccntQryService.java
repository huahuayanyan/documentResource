package com.huateng.scf.rec.qry.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpDebtReturnAccntQryService {
	
	public Page getDebtReturnAccountPage(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO,@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize) throws ScubeBizException;
	
	public Page getDebtReturnAccountImpDetail(@ScubeParam("dtsrcList") List<DebtBillsInfoVO> dtsrcList,@ScubeParam("returnAccount") String returnAccount,@ScubeParam("payDatefrom") String payDatefrom,@ScubeParam("payDateto") String payDateto,@ScubeParam("pageNo")  int pageNo,@ScubeParam("pageSize") int pageSize) throws ScubeBizException;

	public Page getReturnAccountImpDtl(@ScubeParam("returnAccount") String returnAccount,@ScubeParam("pageNo")  int pageNo,@ScubeParam("pageSize") int pageSize) throws ScubeBizException;
	

}
