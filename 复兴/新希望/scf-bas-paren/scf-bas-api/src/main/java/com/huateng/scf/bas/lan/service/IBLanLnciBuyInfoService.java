/**
 * 
 */
package com.huateng.scf.bas.lan.service;

import java.util.List;

import com.huateng.scf.bas.lan.model.BLanLnciBuyInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.model.ApplyBuyContVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>放款申请购销合同信息(申请)服务</p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月17日下午5:51:32
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月17日下午5:51:32              新增
 *
 * </pre>
 */
public interface IBLanLnciBuyInfoService {
	
	public static final String BEAN_ID = "bLanLnciBuyInfoService";
	public BLanLnciBuyInfo addBLanLnciBuyInfo(@ScubeParam("bLanLnciBuyInfo") BLanLnciBuyInfo bLanLnciBuyInfo) throws ScubeBizException;

	/**
	 * @param bLanLnciBuyInfo
	 * @return
	 */
	public int updateBLanLnciBuyInfo(@ScubeParam("bLanLnciBuyInfo") BLanLnciBuyInfo bLanLnciBuyInfo) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBLanLnciBuyInfo(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 根据申请编号查询购销合同申请信息
	 * 返回对象为购销合同表中的审批中出账金额
	 * @param pageNo
	 * @param pageSize
	 * @param bLanLnciBuyInfo
	 * @return
	 */
	public Page getLoanApplyBuyContnoInfo(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BLanLnciBuyInfo bLanLnciBuyInfo) throws ScubeBizException;

	/**
	 * @param
	 * @return
	 */
	public BLanLnciBuyInfo findBLanLnciBuyInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 根据appno查询放款申请购销合同信息(申请)
	 * @param appno
	 * @return list
	 * @throws ScubeBizException
	 */
	public List<BLanLnciBuyInfo> findBLanLnciBuyInfoByAppno(@ScubeParam("appno")String appno) throws ScubeBizException;
	/**
	 * 保存购销合同申请表信息
	 * @param buyContnoList
	 * @param appno
	 * @param okFlag
	 * @throws ScubeBizException
	 */
	public void saveLoanApplyBuyContnoInfo(@ScubeParam("buyContnoList")List<ApplyBuyContVO> buyContnoList,@ScubeParam("appno")String appno,@ScubeParam("flag")boolean okFlag)throws ScubeBizException;
	

}
