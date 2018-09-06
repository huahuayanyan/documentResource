package com.huateng.scf.rec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.acc.model.BAccAccountInfo;
import com.huateng.scf.bas.cnt.model.DataItemsVO;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpPoolRePayVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpPoolRePayService {
	/**
	 * 获取借款企业信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page getCustNameBycd(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCrmBaseInfo value) throws ScubeBizException;

	/**
	 * 通过企业编号获取回款账户
	 * 
	 * @param bAccAccountInfo
	 * @return
	 */
	public List<DataItemsVO> getReturnAccountbyCustcd(@ScubeParam("bAccAccountInfo") BAccAccountInfo bAccAccountInfo)
			throws ScubeBizException;

	/**
	 * 回款专户转让保存
	 * 
	 * @param bcpPoolRePayVO
	 * @return
	 */
	public String savePoolRePay(@ScubeParam("bcpPoolRePayVO") RBcpPoolRePayVO bcpPoolRePayVO) throws ScubeBizException;

	/**
	 * 回款专户信息查询
	 * 
	 * @param appNo
	 * @return
	 */
	public RBcpPoolRePayVO findPoolRePay(@ScubeParam("appNo") String appNo);

	/**
	 * 回款专户信息修改
	 * 
	 * @param appNo
	 * @param bcpPoolRePayVO
	 * @return
	 */
	public String updatePoolRePay(@ScubeParam("appNo") String appNo,
			@ScubeParam("bcpPoolRePayVO") RBcpPoolRePayVO bcpPoolRePayVO) throws ScubeBizException;

	/**
	 * 回款专户信息提交
	 * 
	 * @param appNo
	 * @param bcpPoolRePayVO
	 * @return
	 */
	public void submitPoolRePay(@ScubeParam("appNo") String appNo,
			@ScubeParam("bcpPoolRePayVO") RBcpPoolRePayVO bcpPoolRePayVO) throws ScubeBizException;
}
