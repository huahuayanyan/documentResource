package com.huateng.scf.rec.qry.service;

import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IDebtPoolGenerateQueryService {
     /**
      * 应收账款池融资 台账基本信息详情
      *  */
	public DebtBussInfoVO queryDebtGenaralLedger(@ScubeParam("mastContno") String mastContno);
	/**
	 * @Description: 台账综合查询信贷合同信息
	 */
	public Page getCreditLoanContInfoByParam(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("mastContno") String mastContno);
	/**
	 * @Description: 根据业务合同号获取借据信息
	 */
	public Page getLnciBaseInfoByProtocolNo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("mastContno") String mastContno);
	/**
	 * @Description: 保理应收账款单据列表查询
	 */
	public Page getDebtBillsInfo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("paramMap") Map<String,String> paramMap);
	
}
