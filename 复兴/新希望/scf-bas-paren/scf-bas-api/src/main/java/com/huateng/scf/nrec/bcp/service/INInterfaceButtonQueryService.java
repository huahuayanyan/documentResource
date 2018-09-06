package com.huateng.scf.nrec.bcp.service;

import java.math.BigDecimal;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.model.ExtInterface;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface INInterfaceButtonQueryService {

	public Page InterfaceButtonQuery(@ScubeParam("extInterface") ExtInterface extInterface) throws ScubeBizException;
	
	public BigDecimal getAmountFromRaccount(@ScubeParam("returnAccount")String returnAccount) throws ScubeBizException;

}
