package com.huateng.scf.bas.cnt.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntInsuranceBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>
 * BCntInsuranceBaseInfo接口类
 * </p>
 *
 * @author mengjiajia
 * @date 2016年12月24日下午1:45:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月24日下午1:45:46	     新增
 *
 *            </pre>
 */
public interface IBCntInsuranceBaseInfoService {
	/**
	 * 
	 * @param bCntInsBaseInfo
	 */
	public void cacheAdd(@ScubeParam("bCntInsBaseInfo") BCntInsuranceBaseInfo bCntInsBaseInfo);

	/**
	 * 
	 * @param bCntInsBaseInfo
	 */
	public void add(@ScubeParam("bCntInsBaseInfo") BCntInsuranceBaseInfo bCntInsBaseInfo);

	/**
	 * 
	 * 批量新增合同下保险信息
	 */
	public void batchAddBCntInsurance(@ScubeParam("bCntInsBaseInfo") List<BCntInsuranceBaseInfo> bCntInsBaseInfo,
			@ScubeParam("slaveContno") String slaveContno);

	/**
	 * 
	 * @param bCntInsBaseInfo
	 * @return
	 */
	public int update(@ScubeParam("bCntInsBaseInfo") BCntInsuranceBaseInfo bCntInsBaseInfo);

	/**
	 * 
	 * @param list
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCntInsuranceBaseInfo> list);

	/**
	 * 
	 * 根据合同号删除保险信息
	 * 
	 * @return
	 */
	public int deleteInsuranceBySlaveContno(@ScubeParam("slaveContno") String slaveContno);

	/**
	 * 
	 * @param bCntInsBaseInfo
	 * @return
	 */
	public Page findBCntInsuranceBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCntInsBaseInfo") BCntInsuranceBaseInfo bCntInsBaseInfo, @ScubeParam("cache") String cache);

	/**
	 * 
	 * 抵/质押合同管理，根据合同号slaveContno，无条件查询返回空值
	 * 
	 */
	public Page findBCntInsuranceBaseInfoByContNo(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntInsuranceBaseInfo bCntInsBaseInfo) throws ScubeBizException;
}
