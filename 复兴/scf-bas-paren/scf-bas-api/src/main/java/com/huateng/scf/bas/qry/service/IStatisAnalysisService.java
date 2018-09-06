/**
 * 
 */
package com.huateng.scf.bas.qry.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.model.BCrmTagCloud;
import com.huateng.scf.bas.crm.model.BCrmTagCloudRel;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.qry.model.CooperPartnerInfo;
import com.huateng.scf.bas.qry.model.CustAnalysisInfo;
import com.huateng.scf.bas.qry.model.EchartItem;
import com.huateng.scf.bas.qry.model.FinaStaAnalysisInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月5日上午9:42:32
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月5日上午9:42:32              新增
 *
 * </pre>
 */
public interface IStatisAnalysisService {

	public static final String BEAN_ID = "iStatisAnalysisService";
	public List getEChart(@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;
	
	/**
	 * 查询首页预警信息
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  EchartItem getWarningsHighCharts(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/**
	 * 预警信息
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 * @return Page
	 */
	public  Page getWarnInfoListByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	/**
	 * 获得客户基础信息,业务汇总信息
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public CustAnalysisInfo getCustbaseInfo(@ScubeParam("value") BCrmBaseInfo value) throws ScubeBizException;
	
	
	/**
	 * 获得雷达图的信息
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  List<Object>  getAnalysisChartInfo(@ScubeParam("value") BCrmBaseInfo value) throws ScubeBizException;
	
	
	/**
	 * 获合作伙伴的信息
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  List<CooperPartnerInfo>  getCooperPartnerInfo(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	//
	
	/**
	 * 获得采购方月份维度比率
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  EchartItem  getCoopPartMonthInfo(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	
	/**
	 * 获得采购方历史年份数据
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  EchartItem getCoopPartHisYearInfo(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/**
	 * 获得合作方饼图
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  EchartItem  getCoopPartYearInfo(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/**
	 * 获得合作方饼图
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  EchartItem  getCoopPartMonthRadarInfo(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/*****                               融资分析 begin                                *********/
	
	/**
	 * 获得各融资类型的融资总金额
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  List<FinaStaAnalysisInfo>  getFinaTypeInfo(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/**
	 * 通过类型获取对应的融资产品和金额的列表
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  List<FinaStaAnalysisInfo>  getFinaProductAmountInfo(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/**
	 * 通过类型获取对应的融资产品和金额和日期的列表
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  List<FinaStaAnalysisInfo>  getFinaProductInfodaList(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/**
	 * 通过类型获取对应的融资产品和金额和日期,备注信息的列表
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  List<FinaStaAnalysisInfo>  getFinaProductInfoList(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	
	/**
	 * 获得融资汇总信息
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public  FinaStaAnalysisInfo  getFinaSumStaAnalysisInfo(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/**
	 *  融资统计分析产品收入饼图
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 * @return EchartItem
	 */
	public  EchartItem  getFinaProductIncome(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/**
	 *  获得收入支出柱状图
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 * @return EchartItem
	 */
	public  EchartItem  getFinaInOutcomeBar(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/**
	 * 查询企业信用
	 * @param value
	 * 		Map<String, Object>对象
	 * @return EchartItem
	 * @throws ScubeBizException
	 */
	public  EchartItem  getcustCreditInfo(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	
	/**
	 * 查询企业云标签
	 * @param value
	 * @throws ScubeBizException
	 */
	public BCrmTagCloud getCustTagCloud(@ScubeParam("value") BCrmBaseInfo value) throws ScubeBizException;
	
	/**
	 * 查询企业云标签
	 * @param value
	 * @throws ScubeBizException
	 */
	public List<BCrmTagCloudRel> getCustTagCloudRel(@ScubeParam("value") BCrmBaseInfo value) throws ScubeBizException;
	
	/*****                               融资分析 end                                *********/
	
	/**
	 * 公司风险承受能力
	 * @param pageNo
	 * @param pageSize
	 * @param omap
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getPostLoanRiskList(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value")HashMap<String, Object> omap)throws ScubeBizException;
	
	/**
	 * 贷后分析统计各客户下的业务和财务指标风险预警 
	 * @param pageNo
	 * @param pageSize
	 * @param omap
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getPostLoanWarnStaList(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value")HashMap<String, Object> omap)throws ScubeBizException;
	
	/**
	 * 贷后分析查询客户的业务预警明细列表
	 * @param pageNo
	 * @param pageSize
	 * @param omap
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getPostLoanWarnDtlList(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value")HashMap<String, Object> omap)throws ScubeBizException;
	
	/**
	 * 贷后分析查询客户的财务指标预警明细列表
	 * @param pageNo
	 * @param pageSize
	 * @param omap
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getPostLoanFinWarnDtlList(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value")HashMap<String, Object> omap)throws ScubeBizException;
	
	/**
	 * 查询融资分布地图数据
	 * @param value
	 * 		Map<String, Object>对象
	 * @return EchartItem
	 * @throws ScubeBizException
	 */
	public  EchartItem  queryFinAmtDistribList(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
	/**
	 * 查询资金迁徙地图数据
	 * @param value
	 * 		Map<String, Object>对象
	 * @return EchartItem
	 * @throws ScubeBizException
	 */
	public  EchartItem  queryFundTransferList(@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;
	
}
