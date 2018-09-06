/**
 * 
 */
package com.huateng.scf.bas.cnt.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntCostInfo;
import com.huateng.scf.nbas.prd.model.BCntCostInfoVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月20日下午7:12:56
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月20日下午7:12:56	      新增
 *
 *            </pre>
 */
public interface IBCntCostInfoService {
	public static final String BEAN_ID = "bCntCostInfoService";

	// 根据业务合同号查询具体分页对象
	public BCntCostInfo findBCntCostInfoByKey(@ScubeParam("value") BCntCostInfo bCntCostInfo) throws ScubeBizException;

	// 根据业务合同号查询具体分页对象
	public Page findBCntCostInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntCostInfo bCntCostInfo) throws ScubeBizException;

	public BCntCostInfo getTblCostInfoByBusniessNoAndCostCode(@ScubeParam("realNo") String realNo,@ScubeParam("costCode") String costCode) throws ScubeBizException;

	/**
	 * 根据关联编号查询费用信息
	 * @param mastContno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月19日下午2:42:00
	 */
	public BCntCostInfoVO findBCntCostInfoByRelaNo(@ScubeParam("mastContno") String mastContno);

	/**
	 * 新增费用信息
	 * @param bCntCostInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月19日下午2:53:17
	 */
	public void addBCntCostInfo(@ScubeParam("bCntCostInfoVO") BCntCostInfoVO bCntCostInfoVO);

	/**
	 * 修改费用信息
	 * @param bCntCostInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月19日下午2:56:06
	 */
	public void updateBCntCostInfo(@ScubeParam("bCntCostInfoVO") BCntCostInfoVO bCntCostInfoVO);

}
