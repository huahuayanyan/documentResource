package com.huateng.scf.bas.lan.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.sto.nwr.vo.BillCommonQryVO;
import com.huateng.scf.sto.nwr.vo.BillLnciBaseInfoVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>仓单融资服务类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月21日上午11:11:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月21日上午11:11:57	     新增
 *
 * </pre>
 */
public interface IBillLoanApplyService {

	/**
	 * 得到普通仓单贷款申请信息
	 * @param billCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月21日上午11:21:00
	 */
	public Page getBillNormalLoanApplyInfo(@ScubeParam("billCommonQryVO") BillCommonQryVO billCommonQryVO) throws ScubeBizException;

	/**
	 * 查询普通仓单申请质物的核库信息
	 * @param billCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午2:38:21
	 */
	public Page getBillNormalAppChkStockInfo(@ScubeParam("billCommonQryVO") BillCommonQryVO billCommonQryVO) throws ScubeBizException;

	/**
	 * 保存借据表的信息
	 * @param appliLnciInfo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午4:13:20
	 */
	public void saveLoanApplyInfo(@ScubeParam("appliLnciInfo") BillLnciBaseInfoVO appliLnciInfo) throws ScubeBizException;

}
