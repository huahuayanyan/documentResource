/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import java.util.ArrayList;

import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月23日下午8:03:02
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月23日下午8:03:02	      新增
 *
 *            </pre>
 */
public interface INRBcpAppliBussInfoService {

	public RBcpAppliBussInfo findBcpAppliBussInfoByAppno(@ScubeParam("key") String appno) throws ScubeBizException;

	public void save(@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpAppliBussInfo) throws ScubeBizException;

	public void update(@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpAppliBussInfo) throws ScubeBizException;


	// 入池（应收账款池融资）
	public void inPool(@ScubeParam("rBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds, @ScubeParam("debtBussInfoVO") DebtBussInfoVO debtVO)
			throws ScubeBizException;


	/**
	 * 根据appno删除信息
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月25日上午11:14:12
	 */
	public void deleteByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * (应收账款业务)保存或新增应业务申请信息表
	 * @param debtVO
	 * @author 	mengjiajia
	 * @date 	2017年5月31日上午10:28:31
	 */
	public void saveOrUpdateDebtAppliBussInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO);

	/**
	 * 应收账款回购/反转让，发票信息保存
	 * @param debtVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午11:01:30
	 */
	public String saveDebtBackAppliBussInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO) throws ScubeBizException;

	/**
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo findByAppno(@ScubeParam("appno") String appno);
}
