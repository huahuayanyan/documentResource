package com.huateng.scf.nrec.bcp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.nrec.bcp.model.BCntBcpExtInfoVO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.vo.NFactoringContVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCntBcpInfoBussQryService {

	public static final String BeanId = "BCntBcpInfoBussQryServiceImpl";

	Page getDebtReturnAccountByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("commonQueryVO") Map<String, Object> bcntbcpinfo) throws ScubeBizException;

	Page getDebtRepaymentInfo(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("commonQueryVO") Map<String, Object> bcntbcpinfo) throws ScubeBizException;

	Page getDebtQuery(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("commonQueryVO") Map<String, Object> bcntbcpinfo) throws ScubeBizException;

	Page getDebtReturnAccountImpDetail(@ScubeParam("dtsrcList") List<RBcpDebtInfoVO> dtsrcList,
			@ScubeParam("returnAccount") String returnAccount, @ScubeParam("payDatefrom") String payDatefrom,
			@ScubeParam("payDateto") String payDateto, @ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize) throws ScubeBizException;

	DebtBussInfoVO queryDebtGenaralLedger(@ScubeParam("mastContno") String mastContno) throws ScubeBizException;

	Page queryBCntBcpInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCntBcpInfoVO") BCntBcpInfoVO bCntBcpInfoV) throws ScubeBizException;

	Page getCreditLoanContInfoByParam(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mastContno") String mastContno) throws ScubeBizException;

	Page getLnciBaseInfoByProtocolNo(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mastContno") String mastContno);

	Page getDebtBillsInfo(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("paramMap") Map<String, String> paramMap);

	DebtContVO queryBCntDebtInfoByContno(@ScubeParam("debtContVO") DebtContVO debtContVO) throws ScubeBizException;

	BCntBcpExtInfoVO queryBCntBcpExtInfoByContno(@ScubeParam("debtContVO") DebtContVO debtContVO) throws ScubeBizException;

	public NFactoringContVO getFactContDetailByMastContno(@ScubeParam("mastContno") String mastContno);

	/**
	 * 根据业务申请类型及其他参数获取业务申请信息
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月12日下午4:07:35
	 */
	public Page findBPbcAppliBaseInfoByParam(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, Object> value);

}
