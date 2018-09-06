package com.huateng.scf.rec.bcp.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.PayMentLanInfo;
import com.huateng.scf.rec.bcp.model.PaymentBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IIfspRBcpPaymentService {
	

    public   String  addPaymentApply(@ScubeParam("rBcpAppliBussInfo")RBcpAppliBussInfo rBcpAppliBussInfo); 
	
}
