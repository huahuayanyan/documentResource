/**
 * 
 */
package com.huateng.scf.bas.pbc.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.fcs.model.FourDeliveryQryVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scf.sto.nwr.vo.BillStandardMortgageVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 业务申请押品信息接口
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月27日下午5:28:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月27日下午5:28:12              新增
 *
 *            </pre>
 */
@SuppressWarnings("deprecation")
public interface IBPbcAppliMtgInfoService {
	public static final String BEAN_ID = "bPbcAppliMtgInfoService";

	public String addBPbcAppliMtgInfo(@ScubeParam("bPbcAppliMtgInfo") BPbcAppliMtgInfo bPbcAppliMtgInfo) throws ScubeBizException;

	/**
	 * @param bPbcAppliMtgInfo
	 * @return
	 */
	public int updateBPbcAppliMtgInfo(@ScubeParam("bPbcAppliMtgInfo") BPbcAppliMtgInfo bPbcAppliMtgInfo) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBPbcAppliMtgInfo(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public BPbcAppliMtgInfo findBPbcAppliMtgInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 根据appno查询押品申请表信息
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BPbcAppliMtgInfo> findBPbcAppliMtgInfoByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 根据appno获取本次申请下的购销合同已提货金额
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BPbcAppliMtgInfo> getTradeAppliTotPriceByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 
	 * @param appliMortgageBaseQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月13日下午5:36:24
	 */
	public Page getTblAppliMortgageBaseInfoByPara(@ScubeParam("appliMortgageBaseQryVO") AppliMortgageBaseQryVO appliMortgageBaseQryVO)
			throws ScubeBizException;

	/**
	 * 
	 * @param billno
	 * @return
	 * @throws BeansException
	 * @author mengjiajia
	 * @date 2017年4月13日下午5:41:30
	 */
	public boolean queryAppliMortgageByBillno(@ScubeParam("billno") String billno) throws BeansException;

	/**
	 * 
	 * @param poName
	 * @param poMap
	 * @param errorMsg
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日下午5:23:26
	 */
	@SuppressWarnings("rawtypes")
	public List findByConditionException(@ScubeParam("poName") String poName, @ScubeParam("poMap") HashMap<String, Object> poMap,
			@ScubeParam("errorMsg") String errorMsg) throws ScubeBizException;

	/**
	 * 
	 * @param commonQueryVo
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日下午5:51:38
	 */
	public BigDecimal getAppliMortgageTotalPrice(@ScubeParam("commonQueryVo") AppliMortgageBaseQryVO commonQueryVo) throws ScubeBizException;

	/**
	 * 
	 * @param applyVO
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日下午7:41:08
	 */
	public String saveAppMorgInfoByApplyVO(@ScubeParam("applyVO") BillStandardMortgageVO applyVO) throws ScubeBizException;

	/**
	 * 
	 * @param appMorgBaseInfo
	 * @param applyVO
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日下午7:47:15
	 */
	public void updateAppMorgInfoByApplyVO(@ScubeParam("appMorgBaseInfo") BPbcAppliMtgInfo appMorgBaseInfo,
			@ScubeParam("applyVO") BillStandardMortgageVO applyVO) throws ScubeBizException;

	/**
	 * 获取押品出质清单押品列表
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BPbcAppliMtgInfo> getQualityNoticeMortList(@ScubeParam("fourDeliveryQryVO") FourDeliveryQryVO deliveryQryVO) throws ScubeBizException;

	/**
	 * 到货出质入库核价信息保存
	 * 
	 * @param appno
	 * @param appliMtgInfoList
	 * @throws ScubeBizException
	 */
	public void pledgeAppPricing(@ScubeParam("appno") String appno, @ScubeParam("appliMtgInfoList") List<BPbcAppliMtgInfo> appliMtgInfoList)
			throws ScubeBizException;

	/**
	 * DESCRIPTION:根据appno查询押品申请表Map
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public Map<String, Object> queryAppliMortgageByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 批量调价页面信息修改保存
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public void updateMutiPriceAdjustInfo(@ScubeParam("BPbcAppliMtgInfo") BPbcAppliMtgInfo bPbcAppliMtgInfo) throws ScubeBizException;

	/**
	 * 保存押品申请信息
	 * 
	 * @param pbcAppliMtgInfo
	 * @author mengjiajia
	 * @date 2017年4月26日下午5:39:35
	 */
	public void save(@ScubeParam("pbcAppliMtgInfo") BPbcAppliMtgInfo pbcAppliMtgInfo);

	/**
	 * 根据appno删除表中数据
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月26日下午5:45:54
	 */
	public void delAppliMortgageListByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * updateMortgageAppOutStorage 普通仓单解押(置换) 根据仓单号增加、删除、修改仓单下对应的押品申请信息
	 * 
	 * @param appno
	 * @param outInsertList
	 * @param outUpdateList
	 * @param outDelList
	 * @param appliMortBizType
	 *            1302 普通仓单解押出库 ; 1502 普通仓单置换出库
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日下午2:00:23
	 */
	public void updatebillNoramlMortgageAppOutStorage(@ScubeParam("appno") String appno,
			@ScubeParam("outInsertList") List<BillNormalAppVO> outInsertList, @ScubeParam("BillNormalAppVO") List<BillNormalAppVO> outUpdateList,
			@ScubeParam("outDelList") List<BillNormalAppVO> outDelList) throws ScubeBizException;

	/**
	 * 按条件查询押品LIST
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日下午4:22:06
	 */
	@SuppressWarnings("rawtypes")
	public List getApplyMortgageList(@ScubeParam("commonQueryVO") AppliMortgageBaseQryVO commonQueryVO) throws ScubeBizException;

	/**
	 * 置换管理仓单押品列表的获取---普通仓单
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月8日上午9:04:19
	 */
	public Page getBillMortListByParam(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	/**
	 * 获取申请下押品列表
	 * 
	 * @param bussAppno
	 * @param appliMortBizType
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月9日上午10:48:35
	 */
	@SuppressWarnings("rawtypes")
	public List getAppliMortgageByAppliMortBizType(@ScubeParam("bussAppno") String bussAppno, @ScubeParam("appliMortBizType") String appliMortBizType)
			throws ScubeBizException;

	/**
	 * 获取非标准仓单置换押品总价值。
	 * 
	 * @param commonQueryVo
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月9日下午1:26:49
	 */
	public BigDecimal getExchangeTotalPrice(@ScubeParam("commonQueryVo") AppliMortgageBaseQryVO commonQueryVo) throws ScubeBizException;

	/**
	 * 置换管理仓单押品列表的获取---普通仓单
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月9日下午3:28:09
	 */
	public Page getBillMortListByParam(@ScubeParam("commonQueryVO") BillNormalVO commonQueryVO) throws ScubeBizException;

	public Page queryNotifyMortgageListByAppno(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("appno") String appno) throws BeansException;

	/**
	 * 增加/追加押品信息
	 * @param appBaseInfo
	 * @param mortgageApplyVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午3:40:16
	 */
	public void addAppMortgageVO(@ScubeParam("appBaseInfo") BPbcAppliBaseInfo appBaseInfo,@ScubeParam("mortgageApplyVO") MortgageApplyVO mortgageApplyVO) throws ScubeBizException;
}
