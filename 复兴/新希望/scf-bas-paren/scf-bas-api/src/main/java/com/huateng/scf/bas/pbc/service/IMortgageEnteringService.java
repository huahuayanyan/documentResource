/**
 * 
 */
package com.huateng.scf.bas.pbc.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DataItemsDO;
import com.huateng.scf.bas.cnt.model.DataItemsVO;
import com.huateng.scf.bas.cnt.model.MonitorProtocolVO;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoDO;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcMtgClassVO;
import com.huateng.scf.bas.pbc.model.MortgageEnterDO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月22日下午19:35:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * lihao		2016年11月22日下午19:35:24                                  新增
 *
 *            </pre>
 */

public interface IMortgageEnteringService {
	/**
	 * 入库押品管理列表查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param mortgageEnter
	 * @return
	 */
	public Page queryMortgageEnteringListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mortgageEnter") MortgageEnterDO mortgageEnter) throws ScubeBizException;

	/**
	 * 入库押品管理列表查询2 当押品状态为已出质的时候，页面的数量重量字段要重新写入取quantity字段填充到invQuantity
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param mortgageEnter
	 * @return
	 */
	public Page queryMortgageEnteringListByPageForManage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mortgageEnter") MortgageEnterDO mortgageEnter) throws ScubeBizException;

	/**
	 * 入库押品列表保存
	 * 
	 * @param mortgageInfo
	 * @param mortgageInfoList
	 */
	public void saveMortgageEnteringList(@ScubeParam("mortgageInfo") MortgageEnterDO mortgageInfo,
			@ScubeParam("mortgageInfoList") List<BPbcMtgBaseInfoDO> mortgageInfoList) throws ScubeBizException;

	/**
	 * 押品等级
	 * 
	 * @param dataItemsDO
	 * @return
	 */
	public List<DataItemsVO> getMortgageLevel(@ScubeParam("dataItemsDO") DataItemsDO dataItemsDO) throws ScubeBizException;

	/**
	 * 抵/质押合同号
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page getSlaveContcode(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("value") DataItemsDO value)
			throws ScubeBizException;

	/**
	 * 通过抵/质押合同号查询监管合同信息
	 * 
	 * @param conId
	 * @return
	 */
	public MonitorProtocolVO getMonitorProtocolInfoByConId(@ScubeParam("conId") String conId) throws ScubeBizException;

	/**
	 * 查询押品名称
	 * 
	 * @param mortgageCode
	 * @return
	 */
	public BPbcMtgClassVO getMortgageName(@ScubeParam("mortgageCode") BigDecimal mortgageCode) throws ScubeBizException;

	/**
	 * 查询押品信息
	 * 
	 * @param mortgageNo
	 * @return
	 */
	public BPbcMtgBaseInfoVO bPbcMtgBaseInfoQuery(@ScubeParam("mortgageNo") String mortgageNo) throws ScubeBizException;

	/**
	 * 修改押品信息
	 * 
	 * @param bPbcMtgBaseInfoDO
	 */
	public void bPbcMtgBaseInfoUpdate(@ScubeParam("bPbcMtgBaseInfoDO") BPbcMtgBaseInfoDO bPbcMtgBaseInfoDO) throws ScubeBizException;

	/**
	 * 修改押品信息
	 * 
	 * @param bPbcMtgBaseInfoDO
	 */
	public void bPbcMtgBaseInfoUpdateSelective(@ScubeParam("bPbcMtgBaseInfoDO") BPbcMtgBaseInfo bPbcMtgBaseInfo) throws ScubeBizException;

	/**
	 * 删除押品信息
	 * 
	 * @param bPbcMtgBaseInfoDO
	 */
	public void bPbcMtgBaseInfoDelete(@ScubeParam("bPbcMtgBaseInfoDO") List<BPbcMtgBaseInfoDO> bPbcMtgBaseInfoDO) throws ScubeBizException;

	/**
	 * 入库押品管理-新增
	 * 
	 * @param
	 */
	public ArrayList<BPbcMtgBaseInfoVO> mortgageEnteringQryAdd(@ScubeParam("mortgageInfo") MortgageEnterDO mortgageInfo,
			@ScubeParam("mortgageInfoList") List<BPbcMtgBaseInfoDO> mortgageInfoList) throws ScubeBizException;
}
