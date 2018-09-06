package com.huateng.scf.rec.qry.service;


import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IConMngQryService {
	 /**
     * 应收账款融资 台账基本信息详情
     *  */
	public DebtContVO queryDebtConByNo(@ScubeParam("debtContno") String debtContno);
	 
	 
}
