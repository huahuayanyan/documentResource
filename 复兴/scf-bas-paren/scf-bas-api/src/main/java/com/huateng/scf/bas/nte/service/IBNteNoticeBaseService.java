/**
 * 
 */
package com.huateng.scf.bas.nte.service;

import java.math.BigDecimal;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.FourWareLoanVO;
import com.huateng.scf.bas.common.model.NoticeQryPrintVO;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.nte.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.model.BNteNoticeMtg;
import com.huateng.scf.bas.nte.model.NoticeQryVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.rec.bcp.model.AppliBussInfoVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageVO;
import com.huateng.scf.sto.nwr.vo.BillStandardBussInfoVO;
import com.huateng.scf.sto.nwr.vo.DeliveyApplyVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 通知书基本信息接口
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月15日.上午9:20:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月15日.上午9:20:46	     新增
 *
 *            </pre>
 */

public interface IBNteNoticeBaseService {
	public static final String BEAN_ID = "bNteNoticeBaseService";

	public String addBNteNoticeBase(@ScubeParam("bNteNoticeBase") BNteNoticeBase bNteNoticeBase) throws ScubeBizException;

	/**
	 * @param bNteNoticeBase
	 * @return
	 */
	public int updateBNteNoticeBase(@ScubeParam("bNteNoticeBase") BNteNoticeBase bNteNoticeBase) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBNteNoticeBase(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public BNteNoticeBase findBNteNoticeBaseByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 通过APPNO和NOTICETYPE查找通知书
	 * 
	 * @param bNteNoticeBase
	 * @return
	 */
	List<BNteNoticeBase> findBNteNoticeBaseByAppno(@ScubeParam("bNteNoticeBase") BNteNoticeBase bNteNoticeBase) throws ScubeBizException;

	/**
	 * 根据appno删除对应的通知书
	 * 
	 * @param appno
	 */
	void deleteBNteNoticeBaseByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 担保提货更改通知书状态公共方法
	 * 
	 * @param appno
	 * @param status
	 * @throws ScubeBizException
	 */
	void updaterNoticeStatus(@ScubeParam("appno") String appno, @ScubeParam("status") String status) throws ScubeBizException;

	/***
	 * 保理催收 提示付款通知书
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 */
	void savePromptPaymentNoticeInfo(@ScubeParam("appno") String appno) throws ScubeBizException;

	/***
	 * 根据申请编号保存通知书基本信息表
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 */
	void dealWithNoticeInfo(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 更新通知书基础信息
	 * 
	 * @param appno
	 * @param noticeBaseStatus
	 */
	public void modifyNoticeBaseInfo(@ScubeParam("appno") String appno, @ScubeParam("status") String noticeBaseStatus);

	/**
	 * 通过appno生成核销通知书
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 */
	public void addDebtCancelNoticeByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 保理应收账款管理生成通知书
	 * 
	 * @param debtVO
	 * @param amount
	 * @param noticeType
	 * @throws ScubeBizException
	 */
	public void saveFactoringNotice(@ScubeParam("debtVO") AppliBussInfoVO debtVO, @ScubeParam("amount") BigDecimal amount,
			@ScubeParam("noticeType") String noticeType) throws ScubeBizException;

	/**
	 * 预付类发货通知管理首页查询
	 * 
	 */
	public Page getAdvDeliveryNotifyByParam(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("NoticeQryVO") NoticeQryVO noticeQryVO) throws ScubeBizException;

	/**
	 * 预付类发货通知管理-收款确认函查询
	 * 
	 */
	public Page getAdvDeliveryNotifyConfirmByParam(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("NoticeQryVO") NoticeQryVO noticeQryVO) throws ScubeBizException;

	/**
	 * 预付类发货通知管理-根据发货通知书编号，申请号查询对应发货通知书
	 * 
	 */
	public BNteNoticeBase getDeliveryNotifyByDeliveryNo(@ScubeParam("deliveryNo") String deliveryNo, @ScubeParam("appno") String appno)
			throws ScubeBizException;

	/**
	 * 预付类发货通知管理-新增/修改发货通知书
	 * 
	 */
	public BNteNoticeBase saveDeliveryNotify(@ScubeParam("BNteNoticeBase") BNteNoticeBase deliveryNotify,
			@ScubeParam("BNteNoticeMtg") List<BNteNoticeMtg> bNteNoticeMtg) throws ScubeBizException;

	/**
	 * 预付类发货通知管理-修改发货通知书
	 * 
	 */
	public void updateDeliveryNotify(@ScubeParam("BNteNoticeBase") BNteNoticeBase deliveryNotify,
			@ScubeParam("BNteNoticeMtg") List<BNteNoticeMtg> bNteNoticeMtg) throws ScubeBizException;

	/**
	 * 预付类发货通知管理-提交发货通知书
	 * 
	 */
	public void submitDeliveryNotify(@ScubeParam("BNteNoticeBase") BNteNoticeBase deliveryNotify,
			@ScubeParam("BNteNoticeMtg") List<BNteNoticeMtg> bNteNoticeMtg) throws ScubeBizException;

	/**
	 * 保存通知书基础信息 先票款后货出质入库
	 * 
	 * @param bPbcAppliBaseInfo
	 * @param bCrrGntyCon
	 * @param bCntMprotBaseInfo
	 * @param mortgageChangeType
	 * @param noticeType
	 * @param noticeNo
	 *            --通知书编号
	 * @return
	 * @throws ScubeBizException
	 */
	public String addNoticeBaseInfo(@ScubeParam("bPbcAppliBaseInfo") BPbcAppliBaseInfo bPbcAppliBaseInfo,
			@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon, @ScubeParam("bCntMprotBaseInfo") BCntMprotBaseInfo bCntMprotBaseInfo,
			@ScubeParam("mortgageChangeType") String mortgageChangeType, @ScubeParam("noticeType") String noticeType,
			@ScubeParam("noticeNo") String noticeNo) throws ScubeBizException;

	/**
	 * 
	 * @param appno
	 * @param noticeType
	 * @param bussVO
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日下午7:57:29
	 */
	public void saveBillNormalNoticeInfo(@ScubeParam("appno") String appno, @ScubeParam("noticeType") String noticeType,
			@ScubeParam("bussVO") BillStandardBussInfoVO bussVO) throws ScubeBizException;

	/**
	 * 更新通知书状态
	 * 
	 * @param appno
	 * @param noticeType
	 * @param status
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月19日下午3:05:21
	 */
	public void updateNoticeStatus(@ScubeParam("appno") String appno, @ScubeParam("noticeType") String noticeType,
			@ScubeParam("status") String status) throws ScubeBizException;

	/**
	 * 预付类发货通知管理-删除发货通知书
	 * 
	 */
	public void deleteDeliveryNotify(@ScubeParam("BNteNoticeBase") BNteNoticeBase deliveryNotify) throws ScubeBizException;

	/**
	 * 预付类发货通知管理-提交发货通知书(仅修改状态)
	 * 
	 */
	public void submitDeliveryNotify2(@ScubeParam("BNteNoticeBase") BNteNoticeBase deliveryNotify) throws ScubeBizException;

	/**
	 * 跌价管理首页通知书查询 通知书分页条件查询 （翻译业务品种和出质人名称）
	 */
	public Page selectNoticePageByParam(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("NoticeQryVO") NoticeQryVO noticeQryVO) throws ScubeBizException;

	/**
	 * 查询及出质通知书查询 （翻译业务品种和出质人名称）
	 */
	public Page selectQuantityNoticeBaseInfoForPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("NoticeQryPrintVO") NoticeQryPrintVO noticeQryPrintVO) throws ScubeBizException;

	/**
	 * 新增预付类跌价补偿通知书
	 */
	public void addAdvWorthCompensateNoticeInfo(@ScubeParam("BNteNoticeBase") BNteNoticeBase bNteNoticeBase) throws ScubeBizException;

	public Page getNoticeBaseInfoByNoticeCommonQueryVO(@ScubeParam("noticeCommonQueryVO") NoticeQryPrintVO noticeCommonQueryVO)
			throws ScubeBizException;

	/**
	 * 非标仓单提货通知书 保存
	 * 
	 * @param applyVO
	 * @param billList
	 * @param mortList
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月27日上午11:06:55
	 */
	public void saveBillNormalDeliveryNotice(@ScubeParam("deliveyApplyVO") DeliveyApplyVO deliveyApplyVO,
			@ScubeParam("billList") List<BillNormalMortgageVO> billList, @ScubeParam("mortList") List<MortgageApplyVO> mortList)
					throws ScubeBizException;

	/**
	 * 根据appno查询通知书信息
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月27日上午11:15:21
	 */
	@SuppressWarnings("rawtypes")
	public List getNoticeBaseInfoByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 保兑仓提货申请生成通知书(城商行)
	 * 
	 * @param appno
	 * @param noticeNo
	 * @return
	 * @throws ScubeBizException
	 */
	public String deliveryNoticeBasicInfoSave(@ScubeParam("appno") String appno, @ScubeParam("noticeNo") String noticeNo) throws ScubeBizException;

	/**
	 * 四方差额退款通知书信息保存
	 * 
	 * @param appno
	 * @param vo
	 * @param noticeNo
	 * @throws ScubeBizException
	 */
	public void saveFourMarginNoticBaseInfo(@ScubeParam("appno") String appno, @ScubeParam("fourWareLoanVO") FourWareLoanVO vo)
			throws ScubeBizException;

	/**
	 * 普通仓单解押通知书保存
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日下午4:01:46
	 */
	public void addBillNoticeByMortgageModifyMoniFloor(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 非标准仓单置换通知书
	 * 
	 * @param appno
	 * @param noticeType
	 * @param bussVO
	 * @param status
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月9日上午11:18:50
	 */
	public void saveBillNormalNoticeInfo(@ScubeParam("appno") String appno, @ScubeParam("noticeType") String noticeType,
			@ScubeParam("bussVO") BillStandardBussInfoVO bussVO, @ScubeParam("status") String status) throws ScubeBizException;

	/**
	 * 通过APPNO 生成通知书（0-押品价格确定调整通知书/2-押品变更通知书）
	 * 
	 * @param bussAppno
	 * @param appliType
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月9日下午2:33:51
	 */
	public void addNoticeByMortgagePriceModify(@ScubeParam("bussAppno") String bussAppno, @ScubeParam("appliType") String appliType)
			throws ScubeBizException;

	/**
	 * 现货静态动态核价通知书生成
	 * 
	 * @param bussAppno
	 * @param appliType
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年5月16日下午2:33:51
	 */
	public void addNoticeByMortgagePriceFloor(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 现货静态动态核价通知书修改
	 * 
	 * @param bussAppno
	 * @param appliType
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年5月16日下午2:33:51
	 */
	public void modifyNoticeByMortgagePriceFloor(@ScubeParam("appno") String appno) throws ScubeBizException;

	public void addNoticeMortgageInfo(@ScubeParam("noticeId") String noticeId,@ScubeParam("applyMortgageList") List<?> applyMortgageList,@ScubeParam("mortgageType") String mortgageType)
			throws ScubeBizException;
}
