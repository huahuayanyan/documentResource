/**
 * 
 */
package com.huateng.scf.bas.pbc.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeansException;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.MonitorProtocolVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoDO;
import com.huateng.scf.bas.pbc.model.CustInfo;
import com.huateng.scf.bas.pbc.model.GntyconInfo;
import com.huateng.scf.bas.pbc.model.ProcessTemplate;
import com.huateng.scf.bas.pbc.model.QualityApplyDO;
import com.huateng.scf.bas.pbc.model.SlaveProtoContInfo;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
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

public interface IQualityApplyService {
	/**
	 * 出质入库申请信息查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param qualityApplyDO
	 * @return
	 */
	public SlaveProtoContInfo slaveProtocontInfo(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("qualityApplyDO") QualityApplyDO qualityApplyDO);

	/**
	 * 抵质押合同信息查询
	 * 
	 * @param qualityApplyDO
	 * @return
	 */
	public GntyconInfo findBCrrGntyCon(@ScubeParam("qualityApplyDO") QualityApplyDO qualityApplyDO);

	/**
	 * 监管合同基本信息查询
	 * 
	 * @param qualityApplyDO
	 * @return
	 */
	public MonitorProtocolVO monitorProtocontInfo(@ScubeParam("qualityApplyDO") QualityApplyDO qualityApplyDO);

	/**
	 * 客户信息查询
	 * 
	 * @param qualityApplyDO
	 * @return
	 */
	public CustInfo findBCrmBaseInfo(@ScubeParam("qualityApplyDO") QualityApplyDO qualityApplyDO);

	/**
	 * 保存
	 * 
	 * @param conId
	 * @param lowPriceNew
	 * @param mortgageInfoList
	 * @return
	 */
	public String saveQualityApplyInfo(@ScubeParam("conId") String conId, @ScubeParam("lowPriceNew") BigDecimal lowPriceNew,
			@ScubeParam("mortgageInfoList") List<BPbcMtgBaseInfoDO> mortgageInfoList);

	/**
	 * 现货静态/动态出质入库 保存按钮
	 * 
	 * @param conId
	 * @param lowPriceNew
	 * @param mortgageInfoList
	 * @return
	 */
	public String saveQualityApply(@ScubeParam("SlaveProtoContInfo") SlaveProtoContInfo SlaveProtoContInfo,
			@ScubeParam("mortgageInfoList") List<BPbcMtgBaseInfoDO> mortgageInfoList) throws BeansException;

	/**
	 * 修改
	 * 
	 * @param appNo
	 * @param conId
	 * @param lowPriceNew
	 * @param mortgageInfoList
	 * @return
	 */
	public String updateQualityApplyInfo(@ScubeParam("appNo") String appNo, @ScubeParam("conId") String conId,
			@ScubeParam("lowPriceNew") BigDecimal lowPriceNew, @ScubeParam("mortgageInfoList") List<BPbcMtgBaseInfoDO> mortgageInfoList);

	/**
	 * 提交
	 * 
	 * @param appNo
	 * @param conId
	 * @param lowPriceNew
	 * @param mortgageInfoList
	 * @param state
	 */
	public void submitQualityApplyInfo(@ScubeParam("appNo") String appNo, @ScubeParam("conId") String conId,
			@ScubeParam("lowPriceNew") BigDecimal lowPriceNew, @ScubeParam("mortgageInfoList") List<BPbcMtgBaseInfoDO> mortgageInfoList,
			@ScubeParam("state") String state);

	/**
	 * 初始化页面的用户及机构信息
	 * 
	 * @return ProcessTemplate
	 * @throws ScubeBizException
	 */
	public ProcessTemplate initPageUserOrg();

	/**
	 * 任务信息现货动态
	 * 
	 * @param appno
	 * @return
	 */
	public BPbcAppliBaseInfo queryTaskInfoByAppno(@ScubeParam("appno") String appno);

	/**
	 * 任务信息现货静态
	 * 
	 * @param appno
	 * @return
	 */
	public BPbcAppliBaseInfo queryStaticTaskInfoByAppno(@ScubeParam("appno") String appno);

	/**
	 * 
	 * @param appliMortgageBaseQryVO
	 * @return
	 * @throws BeansException
	 * @author mengjiajia
	 * @date 2017年4月13日下午4:50:54
	 */
	public Page getApplyMortgageList(@ScubeParam("appliMortgageBaseQryVO") AppliMortgageBaseQryVO appliMortgageBaseQryVO) throws BeansException;

	/**
	 * 存货类出质入库添加押品页面押品选择
	 * 
	 * @param appliMortgageBaseQryVO
	 * @return
	 * @throws BeansException
	 * @author lihao
	 * @date 2017年5月12日 14:30:53
	 */
	public Page MortgageEnteringAddListGettter(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("BPbcMtgBaseInfo") BPbcMtgBaseInfo baseInfo, @ScubeParam("list") List<BPbcMtgBaseInfo> baseInfoList) throws BeansException;

	/**
	 * 存货类出质入库添加押品页面押品选择
	 * 
	 * @param appliMortgageBaseQryVO
	 * @return
	 * @throws BeansException
	 * @author lihao
	 * @date 2017年5月12日 14:30:53
	 */
	public void modifyAppMortgageList(@ScubeParam("appno") String appno, @ScubeParam("list") List<BPbcMtgBaseInfoDO> mortgageInfoList)
			throws BeansException;

	/**
	 * 现货静态/动态出质入库 提交按钮
	 * 
	 * @param conId
	 * @param lowPriceNew
	 * @param mortgageInfoList
	 * @return
	 */
	public String QualityAppWriteSubmitUpdater(@ScubeParam("SlaveProtoContInfo") SlaveProtoContInfo SlaveProtoContInfo,
			@ScubeParam("mortgageInfoList") List<BPbcMtgBaseInfoDO> mortgageInfoList) throws BeansException;

	/**
	 * 出质入库申请回执确认: 1.更新押品申请信息表 2.更新最低价值申请信息表 3.保存押品基本信息表 4.保存库存信息明细表 5.保存监管下线信息表
	 * 
	 * @author wenkui.xu
	 * @Created 2013-5-18上午11:52:24
	 * @param bussAppno
	 * @throws CommonException
	 */
	public void qualityAppliAccountProcess(@ScubeParam("appno") String appno) throws BeansException;

	/**
	 * 保存到B_PBC_APPLI_BASE_INFO[业务申请基本信息表]
	 * 
	 * @param mortgageApplyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月16日下午4:05:39
	 */
	public String saveQualityApplyInfo(@ScubeParam("mortgageApplyVO") MortgageApplyVO mortgageApplyVO,
			@ScubeParam("businessnoType") String businessnoType, @ScubeParam("workApplyType") String workApplyType) throws ScubeBizException;
}
