package com.huateng.scf.bas.nte.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.model.BNteNoticeMtg;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 通知书关联押品信息接口
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月28日上午9:15:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月28日上午9:15:11              新增
 *
 *            </pre>
 */
public interface IBNteNoticeMtgService {
	public static final String BEAN_ID = "bNteNoticeMtgService";

	public void addBNteNoticeMtg(@ScubeParam("bNteNoticeMtg") BNteNoticeMtg bNteNoticeMtg) throws ScubeBizException;

	/**
	 * @param bNteNoticeMtg
	 * @return
	 */
	public int updateBNteNoticeMtg(@ScubeParam("bNteNoticeMtg") BNteNoticeMtg bNteNoticeMtg) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBNteNoticeMtg(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param appno
	 * @return
	 */
	public int deleteBNteNoticeMtgByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public BNteNoticeMtg findBNteNoticeMtgByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 通过APPNO查找通知书关联押品信息
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BNteNoticeMtg> findBNteNoticeMtgByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 根据pid查询通知书押品关联表TblNoticeMortgageInfo 一级二级押品名称转译
	 * 
	 * @param pid
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findBNteNoticeMtgByPid(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("pid") String pid)
			throws ScubeBizException;

	/**
	 * 根据押品编号查询发货通知押品信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param deliveryNo
	 * @param mortgageNo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getDeliveryNotifyMortList(@ScubeParam("deliveryNo") String deliveryNo, @ScubeParam("mortgageNo") String mortgageNo,
			@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize) throws ScubeBizException;

	/**
	 * 根据APPNO AND PID 查询
	 * 
	 * @param appno
	 * @param pid
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月27日下午1:35:56
	 */
	@SuppressWarnings("rawtypes")
	public List getMortgageListByAppnoAndPid(@ScubeParam("appno") String appno, @ScubeParam("pid") String pid) throws ScubeBizException;

	/**
	 * 出质入库押品价格确定调整通知书信息---押品列表
	 * 
	 * @param noticeId
	 * @param appno
	 * @param mortgageList
	 * @param mortgageType
	 * @throws ScubeBizException
	 */
	void addConfirmPriceNoticeMortInfo(@ScubeParam("noticeId") String noticeId, @ScubeParam("appno") String appno,
			@ScubeParam("mortgageList") List<BPbcAppliMtgInfo> mortgageList, @ScubeParam("mortgageType") String mortgageType)
					throws ScubeBizException;

	/**
	 * 添加到货出质入库押品清单信息
	 * 
	 * @param noticeId
	 * @param appno
	 * @param appMortgageList
	 * @param mortgageType
	 * @throws ScubeBizException
	 */
	void addPledgeNoticeMortInfo(@ScubeParam("noticeId") String noticeId, @ScubeParam("appno") String appno,
			@ScubeParam("mortgageList") List<BPbcAppliMtgInfo> mortgageList, @ScubeParam("mortgageType") String mortgageType)
					throws ScubeBizException;

	/**
	 * 保兑仓提货申请通知书保存押品信息(线下)
	 * 
	 * @param appno
	 * @param id
	 * @throws ScubeBizException
	 */
	public void deliveryNoticeMortListSave(@ScubeParam("appno") String appno, @ScubeParam("id") String id) throws ScubeBizException;

}
