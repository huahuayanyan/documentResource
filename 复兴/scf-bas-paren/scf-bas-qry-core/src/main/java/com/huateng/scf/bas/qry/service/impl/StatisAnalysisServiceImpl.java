/**
 * 
 */
package com.huateng.scf.bas.qry.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.data.dto.BdDataDictDto;
import com.huateng.data.dto.DataItem;
import com.huateng.data.service.BdDataDictService;
import com.huateng.data.util.BDDataUtil;
import com.huateng.scf.bas.brp.dao.IBBrpNoticeModelDAO;
import com.huateng.scf.bas.brp.dao.IBBrpWarnParamDAO;
import com.huateng.scf.bas.brp.dao.model.WarnParamVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmEntInfoDAO;
import com.huateng.scf.bas.crm.dao.IBCrmTagCloudDAO;
import com.huateng.scf.bas.crm.dao.IBCrmTagCloudRelDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRelExample;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRelExample.Criteria;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmTagCloud;
import com.huateng.scf.bas.crm.model.BCrmTagCloudRel;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crm.service.IBCrmEntInfoService;
import com.huateng.scf.bas.crm.service.IBCrmUpanddownRelService;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.qry.model.CooperPartnerInfo;
import com.huateng.scf.bas.qry.model.CustAnalysisInfo;
import com.huateng.scf.bas.qry.model.EchartItem;
import com.huateng.scf.bas.qry.model.FinAmtDistrib;
import com.huateng.scf.bas.qry.model.FinaStaAnalysisInfo;
import com.huateng.scf.bas.qry.model.LineData;
import com.huateng.scf.bas.qry.model.PointData;
import com.huateng.scf.bas.qry.model.SeriesData;
import com.huateng.scf.bas.qry.model.SeriesDataItem;
import com.huateng.scf.bas.qry.model.SeriesItem;
import com.huateng.scf.bas.qry.service.IStatisAnalysisService;
import com.huateng.scf.ods.dao.IOCrmInfoAnalysisDAO;
import com.huateng.scf.ods.dao.IOCrmTagDAO;
import com.huateng.scf.ods.dao.IOFinaStaAnalysisDAO;
import com.huateng.scf.ods.dao.IOdsTopCityDAO;
import com.huateng.scf.ods.dao.ext.ExtOdsDAO;
import com.huateng.scf.ods.dao.model.FundTransferVO;
import com.huateng.scf.ods.dao.model.OCooperPartner;
import com.huateng.scf.ods.dao.model.OCrmInfoAnalysis;
import com.huateng.scf.ods.dao.model.OCrmInfoAnalysisExample;
import com.huateng.scf.ods.dao.model.OFinaStaAnalysis;
import com.huateng.scf.ods.dao.model.OdsTopCity;
import com.huateng.scf.ods.dao.model.OdsTopCityExample;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月5日上午9:43:32  
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月5日上午9:43:32              新增
 *
 * </pre>
 */
@ScubeService
@Service(IStatisAnalysisService.BEAN_ID)
public class StatisAnalysisServiceImpl implements IStatisAnalysisService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BBrpNoticeModelDAO")
	IBBrpNoticeModelDAO bBrpNoticeModelDAO;
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;
	
	@Resource(name = "BCrmEntInfoServiceImpl") //公司信息
	IBCrmEntInfoService bCrmEntInfoService;
	
	@Resource(name = "IBCrmUpanddownRelServiceImpl") //公司信息
	IBCrmUpanddownRelService bCrmUpanddownRelServie;
	@Resource(name = "OCrmTagDAO") //客户标签
	IOCrmTagDAO oCrmTagDAO;
	@Resource(name = "OCrmInfoAnalysisDAO") //客户分析信息
	IOCrmInfoAnalysisDAO oCrmInfoAnalysisDAO;

	@Resource(name = "OFinaStaAnalysisDAO") //融资统计分析
	IOFinaStaAnalysisDAO oFinaStaAnalysisDAO;
	
	@Resource(name = "ExtOdsDAO")
	ExtOdsDAO extOdsDAO;
	@Resource(name = "BBrpWarnParamDAO") //预警参数配置
	IBBrpWarnParamDAO bBrpWarnParamDAO;
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;//借据基本信息
	
	@Resource(name = "IBCrmEntInfoDAO")
	IBCrmEntInfoDAO iBCrmEntInfoDAO;//客户企业信息
	
	@Resource(name = "BCrmTagCloudDAO")
	IBCrmTagCloudDAO bCrmTagCloudDAO;//客户企业信息
	
	@Resource(name = "OdsTopCityDAO")
	IOdsTopCityDAO odsTopCityDAO;//热门城市
	
	@Resource(name = "IBCrmTagCloudRelDAO")
	IBCrmTagCloudRelDAO bCrmTagCloudRelDAO;
	
	@Resource(name = "bdDataDictService")
	BdDataDictService bdDataDictService;
	
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;
	
	@Autowired
	BDDataUtil bDDataUtil;

	private static final String CUSTCD = "custcd";
	private static final String TYPE = "type";
	private static final String BELONGYEAR = "belongYear"; //年份
	private static final String BELONGYEARS = "belongYears";//年份集合
	
	private static final String COOPCUSTCD = "coopCustcd";
	private static final String SUMYEARMONTH = "sumYearMonth"; //统计年月
	
	private static final String currentDate = ScfDateUtil.formatDate(new Date());
	//private static final String currentYear = ScfDateUtil.formatDate(new Date()).substring(0, 4);
	private static final String currentYear = currentDate.substring(0,4);
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.brp.service.IReportDisplayService#getEChart(java.util.HashMap)
	 */
	@Override
	public List getEChart(HashMap<String, String> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		return list;
	}
	
	
	/**
	 * 查询首页预警信息
	 */
	@Override
	public EchartItem getWarningsHighCharts(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		EchartItem echartItem = new EchartItem();
		List<String> legendData = new ArrayList<String>();// legendData集合
		List<String> xAxisData = new ArrayList<String>();// xAxisData集合
		
		List<String> param = new ArrayList<String>();
		legendData = Arrays.asList("高级预警","中级预警","低级预警");
		List<SeriesItem> series  =new ArrayList<SeriesItem>(); //series集合
		Page page = new Page(10000000,1,0);

		List<WarnParamVO> list = bBrpWarnParamDAO.getWarningInfo(value,page);

		List<Object>  seriesDataValue = new ArrayList<Object>();
		List<Object>  seriesDataValueL = new ArrayList<Object>();
		List<Object>  seriesDataValueM = new ArrayList<Object>();
		List<Object>  seriesDataValueH = new ArrayList<Object>();
		/*Map fCustDsMap=new HashMap();
		fCustDsMap.put(bFinCustDsData.getSubjId(), bFinCustDsData.getColVal1());*/
		if (list != null && list.size() > 0) {
			//首页显示
			if (value != null&&value.get("index")!=null) {
				int index = (Integer) value.get("index");
				if(list.size()>index){
					list = list.subList(0, index);
				}
			}
			for (WarnParamVO vo : list) {
				xAxisData.add(vo.getWarnName());
				param.add(vo.getUrl());
				seriesDataValueL.add(vo.getWarnLevelL());
				seriesDataValueM.add(vo.getWarnLevelM());
				seriesDataValueH.add(vo.getWarnLevelH());
			}
			SeriesItem seriesItem = null;
			for(int i= legendData.size();i>0;i--){
				seriesItem= new SeriesItem();
				seriesItem.setSeriesName(legendData.get(i-1));
				if(i==3){
					seriesItem.setSeriesDataValue(seriesDataValueL);
				}
				if(i==2){
					seriesItem.setSeriesDataValue(seriesDataValueM);
				}
				if(i==1){
					seriesItem.setSeriesDataValue(seriesDataValueH);
				}
				series.add(seriesItem);
			}
			
		}
		map.put("waringUrl", param);
		echartItem.setMapParam(map);
		echartItem.setLegendData(legendData);
		echartItem.setXaxisData(xAxisData);
		echartItem.setSeries(series);
		/*map.put("xAxisData",xAxisData);
		map.put("waringHigh",seriesDataValueH);
		map.put("waringMid",seriesDataValueL);
		map.put("waringLow",seriesDataValueL);*/
		return echartItem;
	}
	


	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getWarningInfo(int, int, java.util.Map)
	 */
	@Override
	public Page getWarnInfoListByPage(int pageNo, int pageSize, Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		Page page = new Page(pageSize,pageNo,0);
		
		List<WarnParamVO> list = bBrpWarnParamDAO.getWarningInfo(value,page);
		
		return page;
	}
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.brp.service.IReportDisplayService#getBusinessAnalysisInfo(java.util.HashMap)
	 */
	@Override
	public CustAnalysisInfo getCustbaseInfo(BCrmBaseInfo value) throws ScubeBizException{
		// TODO	
		CustAnalysisInfo custInfo = new CustAnalysisInfo();
		//客户号和客户名称是筛选框中选择
//		int checkCustomerForSelect = bCrmBaseInfoService.checkCustomerForSelect(value);
//		if (checkCustomerForSelect != 1) {
//			throw new ScubeBizException("客户名称与客户号不对应，请通过对应的查询按钮选择客户名称!");
//		}
		/*BCrmBaseInfo bCrmBaseInfo =	bCrmBaseInfoService.findBCrmBaseInfoByKey(value);
		custInfo.setCustcd(bCrmBaseInfo.getCustcd());
		custInfo.setCname(bCrmBaseInfo.getCname());
		custInfo.setCoreFlag(bCrmBaseInfo.getCoreFlag());
		
		BCrmEntInfo queryBCrmEntInfo = new BCrmEntInfo();
		queryBCrmEntInfo.setCustcd(value.getCustcd());
		BCrmEntInfo bCrmEntInfo = bCrmEntInfoService.findBCrmEntInfoByKey(queryBCrmEntInfo);
		custInfo.setIndustryTypeName(bCrmEntInfo.getIndustryTypeName());
		custInfo.setTurnover(bCrmEntInfo.getTurnover());*/
		OCrmInfoAnalysisExample example = new OCrmInfoAnalysisExample();
		OCrmInfoAnalysisExample.Criteria  criteria = example.createCriteria();
		String custcd= value.getCustcd();
		if(StringUtil.isStrNotEmpty(custcd)){
			criteria.andCustcdEqualTo(custcd);
		}
		List<OCrmInfoAnalysis> list = oCrmInfoAnalysisDAO.selectByExample(example);
		if(list!=null&&list.size()>0){
			OCrmInfoAnalysis oCrmInfoAnalysis =list.get(0);
			BeanUtils.copyProperties(oCrmInfoAnalysis, custInfo);
			custInfo.setCname(value.getCname());
			
		}else{
			custInfo.setCustcd(custcd);
			custInfo.setCname(value.getCname());
		}
		return custInfo;
		
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getAnalysisChartInfo(com.huateng.scf.bas.crm.model.BCrmBaseInfo)
	 */
	@Override
	public List<Object> getAnalysisChartInfo(BCrmBaseInfo value) throws ScubeBizException {
		// TODO Auto-generated method stub
		List<Object> listR = new ArrayList<Object>();
		List<Object> list = new ArrayList<Object>();
		Map<String,Object> map = new HashMap<String, Object>();
		CustAnalysisInfo custInfo = this.getCustbaseInfo(value);
		//ERP使用比率  //逾期率 //坏账率  //预付款占比//应收帐款占比 //销售增长率//销售利润率//保证金覆盖率//关系紧密

		if(custInfo!=null){
			if(StringUtil.isEmpty(custInfo.getErpUsedRate())){  //ERP使用比率
				list.add( BigDecimal.ZERO);
			}else{
				list.add( custInfo.getErpUsedRate());
			}
			if(StringUtil.isEmpty(custInfo.getOverdueRate())){  //逾期比例
				list.add( BigDecimal.ZERO);
			}else{
				list.add(custInfo.getOverdueRate());
			}
			if(StringUtil.isEmpty(custInfo.getBadRate())){  //坏账率
				list.add( BigDecimal.ZERO);
			}else{
				list.add(custInfo.getBadRate());
			}
			if(StringUtil.isEmpty(custInfo.getPrepayRate())){  //预付款占比
				list.add( BigDecimal.ZERO);
			}else{
				list.add(custInfo.getPrepayRate());
			}
			if(StringUtil.isEmpty(custInfo.getRecRate())){  //应收帐款占比
				list.add( BigDecimal.ZERO);
			}else{
				list.add(custInfo.getRecRate());
			}
			
			if(StringUtil.isEmpty(custInfo.getSaleGrowthRate())){  //销售增长率
				list.add( BigDecimal.ZERO);
			}else{
				list.add(custInfo.getSaleGrowthRate());
			}
			
			if(StringUtil.isEmpty(custInfo.getSalesProfitRate())){  //销售利润率
				list.add( BigDecimal.ZERO);
			}else{
				list.add(custInfo.getSalesProfitRate());
			}
			
			if(StringUtil.isEmpty(custInfo.getMarginCoverRate())){  //保证金覆盖率
				list.add( BigDecimal.ZERO);
			}else{
				list.add(custInfo.getMarginCoverRate());
			}
			
			if(StringUtil.isEmpty(custInfo.getRelation())){  //紧密关系
				list.add( BigDecimal.ZERO);
			}else{
				list.add(custInfo.getRelation());
			}
			
			map.put("value",list);
			map.put("name","");
		}
		listR.add(map);
		return listR;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getparanterInfo(java.util.Map)
	 */
	@Override
	public List<CooperPartnerInfo> getCooperPartnerInfo(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		List<CooperPartnerInfo>  list=new ArrayList<CooperPartnerInfo>();
		CooperPartnerInfo cooperPartnerInfo = null;
		if(value!=null){
			String custcd =(String) value.get("custcd");
			String type =(String) value.get("type");
		
			List<String> belongYears =(List<String>) value.get(BELONGYEARS);
			HashMap<String, Object> omap = new HashMap<String, Object>();
			if(StringUtil.isStrNotEmpty(custcd)){
				omap.put(CUSTCD, custcd);
			}
			if(StringUtil.isStrNotEmpty(type)){
				omap.put(TYPE, type);
			}
			if(belongYears==null||belongYears.size()==0){
				belongYears =  new ArrayList<String>();
				belongYears.add(currentYear);
			}
			omap.put(BELONGYEARS, belongYears);	
			omap.putAll(value);
			List<OCooperPartner>  listR = extOdsDAO.getCooperPartnerInfoList(omap);
			if(listR!=null&&listR.size()>0){
				for(OCooperPartner vo:listR){
					cooperPartnerInfo = new CooperPartnerInfo();
					BeanUtils.copyProperties(vo, cooperPartnerInfo);
					String coopCname = "";
					String coopCustcd = vo.getCoopCustcd();
					if(StringUtil.isStrNotEmpty(coopCustcd)){
						//增加非空判断modify by huangshuidan 2017-07-21
						BCrmBaseInfo bcrmBaseInfo=bCrmBaseInfoService.findBCrmBaseInfoByCustcd(coopCustcd);
						if(null!=bcrmBaseInfo){
							coopCname= bcrmBaseInfo.getCname();
						}//end by huangshuidan 2017-07-21
					}
					cooperPartnerInfo.setTitle(coopCname);
					cooperPartnerInfo.setValue(vo.getCoopRate());
					list.add(cooperPartnerInfo);
				}
			}
		}
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getpurMonChartInfo(com.huateng.scf.bas.crm.model.BCrmBaseInfo)
	 */
	@Override
	public EchartItem getCoopPartMonthInfo(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		EchartItem echartItem = new EchartItem();
		List<String> legendData = new ArrayList<String>();// legendData集合
		List<String> xAxisData = new ArrayList<String>();// xAxisData集合
		
		List<SeriesItem> series  =new ArrayList<SeriesItem>(); //series集合
		if(value!=null){
			String custcd =(String) value.get("custcd");
			String type =(String) value.get("type");
			HashMap<String, Object> omap = new HashMap<String, Object>();
			if(StringUtil.isStrNotEmpty(custcd)){
				omap.put(CUSTCD, custcd);
			}
			if(StringUtil.isStrNotEmpty(type)){
				omap.put(TYPE, type);
			}
			omap.put(BELONGYEAR, currentYear);
			
			List<CooperPartnerInfo>  listR = this.getCooperPartnerInfo(value);
			if(listR!=null&&listR.size()>0){
				SeriesItem  seriesItem  = null;
				for(CooperPartnerInfo vo:listR){
					seriesItem = new SeriesItem();
					String coopName =vo.getTitle();
					legendData.add(coopName);
					seriesItem.setSeriesName(coopName);
					omap.put(COOPCUSTCD, vo.getCoopCustcd());	
					List<OCooperPartner>  listM =extOdsDAO.getCooperPartnerMonthList(omap);
					List<Object> seriesDataValue = new ArrayList<Object>();
					if(listM!=null&&listM.size()>0){
						//SeriesDataItem seriesDataItem = new SeriesDataItem();
						for(OCooperPartner month:listM){
							
							//xcontent.add(month.getBelongMonth()+'月');
							seriesDataValue.add(month.getMonthRate());
						}
						//seriesDataItem.setValue(seriesDataValue);
						//seriesData.add(seriesDataItem);
					}
					seriesItem.setSeriesDataValue(seriesDataValue);
					series.add(seriesItem);
				}
			}
			xAxisData = Arrays.asList("1","2","3","4","5","6");
			echartItem.setLegendData(legendData);
			echartItem.setXaxisData(xAxisData);
			echartItem.setSeries(series);
		
	}
		return echartItem;
}
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getpurMonChartInfo(com.huateng.scf.bas.crm.model.BCrmBaseInfo)
	 */
	@Override
		public EchartItem getCoopPartHisYearInfo(Map<String, Object> value) throws ScubeBizException {
			// TODO Auto-generated method stub
		EchartItem echartItem = new EchartItem();
		List<String> legendData = new ArrayList<String>();// legendData集合
		List<String> xAxisData = new ArrayList<String>();// xAxisData集合
		
		List<SeriesItem> series  =new ArrayList<SeriesItem>(); //series集合
			for (int i = 3; i >= 0; i--) { // X轴 集合
				int year = Integer.valueOf(currentYear);
				String sumYear = year - i + "";
				xAxisData.add(sumYear);
			}
			if (value != null) {
				String custcd = (String) value.get("custcd");
				String type = (String) value.get("type");
				HashMap<String, Object> omap = new HashMap<String, Object>();
				if (StringUtil.isStrNotEmpty(custcd)) {
					omap.put(CUSTCD, custcd);
				}
				if (StringUtil.isStrNotEmpty(type)) {
					omap.put(TYPE, type);
				}
				
				List<CooperPartnerInfo> listR = this.getCooperPartnerInfo(omap);
				if (listR != null && listR.size() > 0) {
					SeriesItem  seriesItem  = null;
					for (CooperPartnerInfo vo : listR) {
						seriesItem = new SeriesItem();
						String coopName =vo.getTitle();
						legendData.add(coopName);
						seriesItem.setSeriesName(coopName);
						// legNames.add(vo.getTitle());
						omap.put(COOPCUSTCD, vo.getCoopCustcd());
						omap.put(BELONGYEARS, xAxisData);
						List<CooperPartnerInfo> listY = this.getCooperPartnerInfo(omap);
						if (listY != null && listY.size() > 0) {
							List<Object> seriesDataValue = new ArrayList<Object>();
							for (CooperPartnerInfo info : listY) {
								// xcontent.add(month.getBelongMonth()+'月');
								seriesDataValue.add(info.getCoopRate());
							}

							seriesItem.setSeriesDataValue(seriesDataValue);
							series.add(seriesItem);
						}
					}
				}
				echartItem.setLegendData(legendData);
				echartItem.setXaxisData(xAxisData);
				echartItem.setSeries(series);

			}
			return echartItem;
		}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getCoopPartYearInfo(java.util.Map)
	 */
	@Override
	public EchartItem getCoopPartYearInfo(Map<String, Object> value) throws ScubeBizException {
		EchartItem echartItem = new EchartItem();
		List<String> legendData = new ArrayList<String>();// legendData集合
		List<SeriesItem> series  =new ArrayList<SeriesItem>(); //series集合
		List<SeriesDataItem> seriesData = new ArrayList<SeriesDataItem>(); //seriesData集合
		if (value != null) {
			String custcd = (String) value.get("custcd");
			String type = (String) value.get("type");
			HashMap<String, Object> omap = new HashMap<String, Object>();
			if (StringUtil.isStrNotEmpty(custcd)) {
				omap.put(CUSTCD, custcd);
			}
			if (StringUtil.isStrNotEmpty(type)) {
				omap.put(TYPE, type);
			}
			List<CooperPartnerInfo>  listR = this.getCooperPartnerInfo(omap);
			SeriesItem  seriesItem = new SeriesItem();
			List<Object> seriesDataValue = null;
			SeriesDataItem  seriesDataItem = null;
			if(listR!=null&&listR.size()>0){
				for(CooperPartnerInfo vo:listR){
					String coopName= vo.getTitle();
					legendData.add(coopName);
					seriesDataItem = new SeriesDataItem();
					seriesDataValue = new ArrayList<Object>();
					seriesDataItem.setName(coopName);
					seriesDataValue.add(vo.getCoopRate());
					seriesDataItem.setValue(seriesDataValue);
					seriesData.add(seriesDataItem);
					seriesItem.setSeriesName(coopName);
				}
			
				seriesItem.setSeriesData(seriesData);
				series.add(seriesItem);
			}
			echartItem.setLegendData(legendData);
			echartItem.setSeries(series);
		}
		return echartItem;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getCoopPartMonthRadarInfo(java.util.Map)
	 */
	@Override
	public EchartItem getCoopPartMonthRadarInfo(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		EchartItem echartItem = new EchartItem();
		List<String> legendData = new ArrayList<String>();// legendData集合
		List<SeriesItem> series  =new ArrayList<SeriesItem>(); //series集合
		List<SeriesDataItem> seriesData = new ArrayList<SeriesDataItem>(); //seriesData集合
		if (value != null) {
			String custcd = (String) value.get("custcd");
			String type = (String) value.get("type");
			HashMap<String, Object> omap = new HashMap<String, Object>();
			if (StringUtil.isStrNotEmpty(custcd)) {
				omap.put(CUSTCD, custcd);
			}
			if (StringUtil.isStrNotEmpty(type)) {
				omap.put(TYPE, type);
			}
			
			List<CooperPartnerInfo> listR = this.getCooperPartnerInfo(omap);
			SeriesItem  seriesItem = new SeriesItem();
			SeriesDataItem  seriesDataItem = null;
			if (listR != null && listR.size() > 0) {
				for (CooperPartnerInfo vo : listR) {
					seriesDataItem = new SeriesDataItem();
					String coopName= vo.getTitle();					
					legendData.add(coopName);
					omap.put(COOPCUSTCD, vo.getCoopCustcd());
					List<OCooperPartner>  listM =extOdsDAO.getCooperPartnerMonthList(omap);
					if (listM != null && listM.size() > 0) {
						//SeriesDataItem  seriesDataItem = new SeriesDataItem();
						seriesItem.setSeriesName(coopName);
						seriesDataItem.setName(coopName);
						List<Object> seriesDataValue = new ArrayList<Object>();
						for (OCooperPartner info : listM) {
							// xcontent.add(month.getBelongMonth()+'月');
							//coopValues.add(info.getMonthRate());
							seriesDataValue.add(info.getMonthRate());
						}
						seriesDataItem.setValue(seriesDataValue);
					}
					seriesData.add(seriesDataItem);
				}
			}
			seriesItem.setSeriesData(seriesData);
			series.add(seriesItem);
			echartItem.setLegendData(legendData);
			echartItem.setSeries(series);

		}
		return echartItem;
	}

	
	/*****                               融资分析 begin                                *********/
	
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getFinaTypeInfo(java.util.Map)
	 */
	@Override
	public List<FinaStaAnalysisInfo> getFinaTypeInfo(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		
		List<FinaStaAnalysisInfo> list  = new ArrayList<FinaStaAnalysisInfo>();
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (value != null) {
			String sumYearMonth = "";
			String sumDate = (String) value.get("sumDate");
			String finaType = (String) value.get("finaType");
			List<String> finaTypes = (List<String>) value.get("finaTypes");
			if (StringUtil.isStrNotEmpty(sumDate)) {
				// omap.put(CUSTCD, custcd);
				sumYearMonth = sumDate.substring(0, 6);
			} else {
				sumYearMonth = currentDate.substring(0, 6);
			}
			if (StringUtil.isStrNotEmpty(sumYearMonth)) {
				omap.put(SUMYEARMONTH, sumYearMonth);
			}
			if (StringUtil.isStrNotEmpty(finaType)) {
				omap.put(TYPE, finaType);
			}
			if(finaTypes!=null&&finaTypes.size()>0){
				omap.put("finaTypes", finaTypes);
			}
			
		}
		List<OFinaStaAnalysis> listR = extOdsDAO.getFinaTypeAmountList(omap);
		FinaStaAnalysisInfo info = null;
		if (listR != null && listR.size() > 0) {
			for (OFinaStaAnalysis vo : listR) {
				info = new FinaStaAnalysisInfo();
				BeanUtils.copyProperties(vo, info);
				list.add(info);
			}
		}
		return list;
	}
	
	/**
	 * 通过类型获取对应的融资产品和金额的列表
	 */
	@Override
	public List<FinaStaAnalysisInfo> getFinaProductAmountInfo(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		List<FinaStaAnalysisInfo> list  = new ArrayList<FinaStaAnalysisInfo>();
		if (value != null) {
			String sumYearMonth = "";
			String sumDate = (String) value.get("sumDate");
			String finaType = (String) value.get("finaType");
			HashMap<String, Object> omap = new HashMap<String, Object>();
			if (StringUtil.isStrNotEmpty(sumDate)) {
				// omap.put(CUSTCD, custcd);
				sumYearMonth = sumDate.substring(0, 6);
			} else {
				sumYearMonth = currentDate.substring(0, 6);
			}
			if (StringUtil.isStrNotEmpty(sumYearMonth)) {
				omap.put(SUMYEARMONTH, sumYearMonth);
			}
			if (StringUtil.isStrNotEmpty(finaType)) {
				omap.put(TYPE, finaType);
			}
			List<OFinaStaAnalysis>  listR =extOdsDAO.getProjectAmountList(omap);
			FinaStaAnalysisInfo info = null;
			if (listR != null && listR.size() > 0) {
				//首页显示
				if (value != null&&value.get("index")!=null) {
					int index = (Integer) value.get("index");
					if(listR.size()>index){
						listR = listR.subList(0, index);
					}
				}
				for(OFinaStaAnalysis vo:listR){
					info = new FinaStaAnalysisInfo();
					BeanUtils.copyProperties(vo, info);
					if(null!=info.getAmount()){
						//金额格式化为千分位
						info.setAmountStr(ScfCommonUtil.amountFormatToString(info.getAmount()));
					}
					list.add(info);
				}
			}
			
		}
		return list;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getFinaProductInfoadList(java.util.Map)
	 */
	@Override
	public List<FinaStaAnalysisInfo> getFinaProductInfodaList(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		List<FinaStaAnalysisInfo> list  = new ArrayList<FinaStaAnalysisInfo>();
		if (value != null) {
			String sumYearMonth = "";
			String sumDate = (String) value.get("sumDate");
			String finaType = (String) value.get("finaType");
			HashMap<String, Object> omap = new HashMap<String, Object>();
			if (StringUtil.isStrNotEmpty(sumDate)) {
				// omap.put(CUSTCD, custcd);
				sumYearMonth = sumDate.substring(0, 6);
			} else {
				sumYearMonth = currentDate.substring(0, 6);
			}
			if (StringUtil.isStrNotEmpty(sumYearMonth)) {
				omap.put(SUMYEARMONTH, sumYearMonth);
			}
			if (StringUtil.isStrNotEmpty(finaType)) {
				omap.put(TYPE, finaType);
			}
			List<OFinaStaAnalysis>  listR =extOdsDAO.getProjectDateAmountList(omap);
			FinaStaAnalysisInfo info = null;
			if (listR != null && listR.size() > 0) {
				for(OFinaStaAnalysis vo:listR){
					info = new FinaStaAnalysisInfo();
					BeanUtils.copyProperties(vo, info);
					list.add(info);
				}
			}
			
		}
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getFinaProductInfoadList(java.util.Map)
	 */
	@Override
	public List<FinaStaAnalysisInfo> getFinaProductInfoList(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		List<FinaStaAnalysisInfo> list  = new ArrayList<FinaStaAnalysisInfo>();
		if (value != null) {
			String sumYearMonth = "";
			String sumDate = (String) value.get("sumDate");
			String finaType = (String) value.get("finaType");
			HashMap<String, Object> omap = new HashMap<String, Object>();
			if (StringUtil.isStrNotEmpty(sumDate)) {
				// omap.put(CUSTCD, custcd);
				sumYearMonth = sumDate.substring(0, 6);
			} else {
				sumYearMonth = currentDate.substring(0, 6);
			}
			if (StringUtil.isStrNotEmpty(sumYearMonth)) {
				omap.put(SUMYEARMONTH, sumYearMonth);
			}
			if (StringUtil.isStrNotEmpty(finaType)) {
				omap.put(TYPE, finaType);
			}
			List<OFinaStaAnalysis>  listR =extOdsDAO.getProjectDateAmountList(omap);
			FinaStaAnalysisInfo info = null;
			if (listR != null && listR.size() > 0) {
				for(OFinaStaAnalysis vo:listR){
					info = new FinaStaAnalysisInfo();
					BeanUtils.copyProperties(vo, info);
					list.add(info);
				}
			}
			
		}
		return list;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#
	 * getFinaStaAnalysisInfo(java.util.Map)
	 */
	@Override
	public FinaStaAnalysisInfo getFinaSumStaAnalysisInfo(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		FinaStaAnalysisInfo finaStaAnalysisInfo = new FinaStaAnalysisInfo();
		//初始化
		finaStaAnalysisInfo.setTotalIncome(BigDecimal.ZERO);
		finaStaAnalysisInfo.setTotalOutcome(BigDecimal.ZERO);
		finaStaAnalysisInfo.setTotalLossAmt(BigDecimal.ZERO);
		finaStaAnalysisInfo.setTotalProfit(BigDecimal.ZERO);
		finaStaAnalysisInfo.setTotalIncomeStr("0.00");
		finaStaAnalysisInfo.setTotalOutcomeStr("0.00");
		finaStaAnalysisInfo.setTotalLossAmtStr("0.00");
		finaStaAnalysisInfo.setTotalProfitStr("0.00");
		List<FinaStaAnalysisInfo> list = this.getFinaTypeInfo(value);
			BigDecimal totalProfit = BigDecimal.ZERO;
			if (list != null && list.size() > 0) {
				for (FinaStaAnalysisInfo vo : list) {
					String	amountStr="";
					BigDecimal amount = vo.getAmount();
					if(null!=amount){
						//金额格式化为千分位
						amountStr = ScfCommonUtil.amountFormatToString(amount);
					}
					if ("1".equals(vo.getFinaType())) {
						finaStaAnalysisInfo.setTotalIncome(amount);
						finaStaAnalysisInfo.setTotalIncomeStr(amountStr);
					} else if ("2".equals(vo.getFinaType())) {
						finaStaAnalysisInfo.setTotalOutcome(amount);
						finaStaAnalysisInfo.setTotalOutcomeStr(amountStr);
					} else if ("3".equals(vo.getFinaType())) {
						finaStaAnalysisInfo.setTotalLossAmt(amount);
						finaStaAnalysisInfo.setTotalLossAmtStr(amountStr);
					}
					totalProfit = totalProfit.add(amount);
				}
			}
			if(null!=totalProfit){
				//金额格式化为千分位
				finaStaAnalysisInfo.setTotalProfitStr(ScfCommonUtil.amountFormatToString(totalProfit));
			}
			finaStaAnalysisInfo.setTotalProfit(totalProfit);
		return finaStaAnalysisInfo;
	}
	
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getFinaProductIncome(java.util.Map)
	 */
	@Override
	public EchartItem getFinaProductIncome(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		EchartItem echartItem = new EchartItem();
		List<String> legendData = new ArrayList<String>();// legendData集合
		
		List<SeriesItem> series  =new ArrayList<SeriesItem>(); //series集合
		List<SeriesDataItem> seriesData = new ArrayList<SeriesDataItem>(); //seriesData集合
		if (value != null) {
			String sumYearMonth ="";
			String sumDate = (String) value.get("sumDate");
			String finaType = (String) value.get("finaType");
			String [] finaTypes = finaType.split(".");
			
			if(finaTypes!=null&&finaTypes.length>0){
				
			}
			HashMap<String, Object> omap = new HashMap<String, Object>();
			/*if (StringUtil.isStrNotEmpty(custcd)) {
				omap.put(CUSTCD, custcd);
			}*/
			if (StringUtil.isStrNotEmpty(sumDate)) {
				//omap.put(CUSTCD, custcd);
				sumYearMonth = sumDate.substring(0, 6);
			}else{
				sumYearMonth= currentDate.substring(0, 6);
			}
			if (StringUtil.isStrNotEmpty(sumYearMonth)) {
				omap.put(SUMYEARMONTH, sumYearMonth);
			}
			if (StringUtil.isStrNotEmpty(finaType)) {
				omap.put(TYPE, finaType);
			}
			
			List<OFinaStaAnalysis>  listR =extOdsDAO.getProjectAmountList(omap);
			
			SeriesItem  seriesItem = new SeriesItem();
			SeriesDataItem  seriesDataItem = null;
			List<Object> seriesDataValue = null;
			
			if(listR!=null&&listR.size()>0){
				//首页显示
				if (value != null&&value.get("index")!=null) {
					int index = (Integer) value.get("index");
					if(listR.size()>index){
						listR = listR.subList(0, index);
					}
					//饼图 内环
					List<String> pieList = Arrays.asList("预付类","存货类","应收类");;
					BigDecimal mortTotal = BigDecimal.ZERO; //存货类
					BigDecimal prepTotal = BigDecimal.ZERO;//预付类
					BigDecimal accrTotal = BigDecimal.ZERO;//应收类
					for(OFinaStaAnalysis vo:listR){
						//获得产品的大类
						String projectId = vo.getProjectId();
						String parentId="";
						if(StringUtil.isStrNotEmpty(projectId)){
							BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(projectId);	
							parentId = bPrdInfo.getParentId();
							if(null!=bPrdInfo&&parentId.equals(ScfBasConstant.PRODUCT_TYPE_MORT)){ //存货类
								mortTotal = mortTotal.add(vo.getAmount());
							}else if(null!=bPrdInfo&&parentId.equals(ScfBasConstant.PRODUCT_TYPE_PREP)){ //预付类
								prepTotal = prepTotal.add(vo.getAmount());
							}
							else if(null!=bPrdInfo&&parentId.equals(ScfBasConstant.PRODUCT_TYPE_ACCR)){ //应收类
								accrTotal = accrTotal.add(vo.getAmount());
							}
						}
					}
					Map Map=new HashMap();
					Map.put("预付类", prepTotal);
					Map.put("存货类", mortTotal);
					Map.put("应收类", accrTotal);
					List<SeriesDataItem> seriesData1 = new ArrayList<SeriesDataItem>(); //seriesData集合
					SeriesItem  seriesItem1 = new SeriesItem();
					for(String pie:pieList){
						seriesDataItem = new SeriesDataItem();
						seriesDataValue = new ArrayList<Object>();
						seriesDataItem.setName(pie);
						seriesDataValue.add(Map.get(pie));
						seriesDataItem.setValue(seriesDataValue);
						seriesData1.add(seriesDataItem);
					}
					seriesItem1.setSeriesData(seriesData1);
					series.add(seriesItem1);
					
				}
				for(OFinaStaAnalysis vo:listR){
					seriesDataItem = new SeriesDataItem();
					String project = vo.getProject();
					legendData.add(project);
					seriesDataValue = new ArrayList<Object>();
					seriesDataItem.setName(project);
					seriesDataValue.add(vo.getAmount());
					seriesDataItem.setValue(seriesDataValue);
					seriesData.add(seriesDataItem);
					//seriesItem.setSeriesName(coopName);
				}
				seriesItem.setSeriesData(seriesData);
				series.add(seriesItem);
			}
			echartItem.setLegendData(legendData);
			echartItem.setSeries(series);
		}
		
		return echartItem;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getFinaInOutcome(java.util.Map)
	 */
	@Override
	public EchartItem getFinaInOutcomeBar(Map<String, Object> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		EchartItem echartItem = new EchartItem();
		List<String> legendData = new ArrayList<String>();// legendData集合
		
		List<SeriesItem> series  =new ArrayList<SeriesItem>(); //series集合
		List<FinaStaAnalysisInfo> listR = this.getFinaTypeInfo(value);
		SeriesItem  seriesItem  = null;
		if(listR!=null&&listR.size()>0){
			for(FinaStaAnalysisInfo vo:listR){
				seriesItem = new SeriesItem();
				List<Object> seriesDataValue = new ArrayList<Object>();
				BigDecimal amount = vo.getAmount();
				//seriesDataValue.add(amount);
				if ("1".equals(vo.getFinaType())) {
					seriesItem.setSeriesName("收入");
					seriesDataValue.add(amount);
				} 
				if ("2".equals(vo.getFinaType())) {
					seriesItem.setSeriesName("支出");
					seriesDataValue.add(amount);
					//finaStaAnalysisInfo.setTotalOutcome(amount);
				}
				seriesItem.setSeriesDataValue(seriesDataValue);
				series.add(seriesItem);
			}
		}
		echartItem.setLegendData(legendData);
		//echartItem.setXaxisData(xAxisData);
		echartItem.setSeries(series);
		return echartItem;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#queryFinAmtDistribList(java.util.Map)
	 */
	@Override
	public EchartItem getcustCreditInfo(Map<String, Object> value) throws ScubeBizException {
		EchartItem echartItem = new EchartItem();
//		List<String> legendData = new ArrayList<String>();// legendData集合
		List<SeriesItem> series  =new ArrayList<SeriesItem>(); //series集合
		Map<String,Object> mapParam = new  HashMap<String,Object>();
		List<SeriesData> seriesDatas = new ArrayList<SeriesData>(); 
		if (value != null&&value.get("custcd")!=null) {
			String  custcd = value.get("custcd").toString();
			BCrmEntInfo  bCrmEntInfo = iBCrmEntInfoDAO.selectByPrimaryKey(custcd);
			SeriesItem	seriesItem=new SeriesItem();
			SeriesData  seriesData = new SeriesData();
			String creditLevel = bCrmEntInfo.getCreditLevel(); //信用等级
			String creditLevelName = "信用";
			BigDecimal creditScr = null==bCrmEntInfo.getCreditScr()?BigDecimal.ZERO :bCrmEntInfo.getCreditScr();
		
			List<DataItem>  dataList = BDDataUtil.getDefaultDateItems(ScfBasConstant.DICT_CODE_CREDITLEVEL);
			if(dataList!=null&&dataList.size()>0){
				for(DataItem item:dataList){
					if(item.getDataVal().equals(creditLevel)){
						creditLevelName= creditLevelName+item.getDataTrsVal();
					}
				}
			}
			mapParam.put("creditDate", bCrmEntInfo.getCreditDate()); //评估时间
			seriesData.setName(creditLevelName);
			seriesData.setValue(creditScr); //信用评分
			seriesDatas.add(seriesData);
			seriesItem.setSeriesDatas(seriesDatas);
			series.add(seriesItem);
		}else{
			throw  new ScubeBizException("客户id参数丢失");
		}
		echartItem.setMapParam(mapParam);
		echartItem.setSeries(series);
		return echartItem;
	}


	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#getCustTagCloud(com.huateng.scf.bas.crm.model.BCrmBaseInfo)
	 */
	@Override
	public BCrmTagCloud getCustTagCloud(BCrmBaseInfo value) throws ScubeBizException {
		// TODO Auto-generated method stub
		BCrmTagCloud  bCrmTagCloud = new BCrmTagCloud();
		if(value!=null){
			String custCd = value.getCustcd();
			com.huateng.scf.bas.crm.dao.model.BCrmTagCloud  cBCrmTagCloudDal= bCrmTagCloudDAO.selectByPrimaryKey(custCd);
		
			if(cBCrmTagCloudDal!=null){
				BeanUtils.copyProperties(cBCrmTagCloudDal, bCrmTagCloud);
			}
		}
		return bCrmTagCloud;
	}
	/*****                               融资分析 end                                *********/

	
	
	/*****                               贷后分析 begin                                *********/
	

	/**
	 * 公司风险承受能力
	 * @param pageNo
	 * @param pageSize
	 * @param omap
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getPostLoanRiskList(int pageNo, int pageSize, HashMap<String, Object> omap) throws ScubeBizException {
		// TODO Auto-generated method stub
		Page page = new Page(pageSize,pageNo,0);
		OCrmInfoAnalysisExample  example = new OCrmInfoAnalysisExample();
		OCrmInfoAnalysisExample.Criteria criteria = example.createCriteria();
		if(omap!=null&&omap.get("cname")!=null){ 
			String cname = omap.get("cname").toString().trim();
			if(StringUtil.isStrNotEmpty(cname)){
				criteria.andCnameLike("%"+cname+"%");
			}
		}
		List<OCrmInfoAnalysis> list = oCrmInfoAnalysisDAO.selectByPage(example, page);
		page.setRecords(list);
		

		return page;
	}
	
	/**
	 * 贷后分析统计各客户下的业务和财务指标风险预警 
	 */
	public Page getPostLoanWarnStaList(int pageNo,int pageSize,HashMap<String, Object> omap)throws ScubeBizException{
		Page page = new Page(pageSize,pageNo,0);
		page.setRecords(extOdsDAO.getPostLoanWarnStaList(omap,page));
		return page;
		
	}
	/**
	 * 贷后分析查询客户的业务预警明细列表
	 */
	@Override
	public Page getPostLoanWarnDtlList(int pageNo, int pageSize, HashMap<String, Object> omap)
			throws ScubeBizException {
		Page page = new Page(pageSize,pageNo,0);
		page.setRecords(extOdsDAO.getPostLoanWarnDtlList(omap,page));
		return page;
	}

	/**
	 * 贷后分析查询客户的业务预警明细列表
	 */
	@Override
	public Page getPostLoanFinWarnDtlList(int pageNo, int pageSize, HashMap<String, Object> omap)
			throws ScubeBizException {
		Page page = new Page(pageSize,pageNo,0);
		page.setRecords(extOdsDAO.getPostLoanFinWarnDtlList(omap,page));
		return page;
	}


	/*****                               贷后分析 end                                *********/

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.qry.service.IStatisAnalysisService#queryFinAmtDistribList(java.util.Map)
	 */
	@Override
	public EchartItem queryFinAmtDistribList(Map<String, Object> value) throws ScubeBizException {
		EchartItem echartItem = new EchartItem();
		List<String> legendData = new ArrayList<String>();// legendData集合
		List<SeriesItem> series  =new ArrayList<SeriesItem>(); //series集合
		Map<String, Object> objMap = new HashMap<String, Object>();
		List<com.huateng.scf.bas.lan.dao.vo.FinAmtDistrib> finAmtDistribList=bLanLnciBaseDAO.queryFinAmtDistribList(objMap);
		List<com.huateng.scf.bas.lan.dao.vo.FinAmtDistrib> finAmtProductList=bLanLnciBaseDAO.queryFinAmtProductList(objMap);
		if(null!=finAmtProductList && finAmtProductList.size()>0){
			//首页显示
			if (value != null&&value.get("index")!=null) {
				int index = (Integer) value.get("index");
				if(finAmtProductList.size()>index){
					finAmtProductList = finAmtProductList.subList(0, index);
				}
			}
			for(int j=0;j<finAmtProductList.size();j++){
				com.huateng.scf.bas.lan.dao.vo.FinAmtDistrib finAmtProduct=(com.huateng.scf.bas.lan.dao.vo.FinAmtDistrib)finAmtProductList.get(j);
				String productId=finAmtProduct.getProductId();//产品ID
				String productNmae=finAmtProduct.getProductName();//产品名称
				legendData.add(productNmae);//产品名称放入legendData
				SeriesItem	seriesItem=new SeriesItem();
				if(null!=finAmtDistribList && finAmtDistribList.size()>0){
					List<SeriesData> seriesDataList=new ArrayList<SeriesData>();
					for(int i=0;i<finAmtDistribList.size();i++){
						com.huateng.scf.bas.lan.dao.vo.FinAmtDistrib finAmtDistribDal=finAmtDistribList.get(i);
						SeriesData seriesData=new SeriesData();
						if(null!=productId && productId.equals(finAmtDistribDal.getProductId())){
							String regionName=finAmtDistribDal.getRegionName();
							if(null!=regionName && regionName.indexOf("省")>-1){
								int n=regionName.indexOf("省");
								regionName=regionName.substring(0, n);
							}
							if(null!=regionName && regionName.indexOf("市")>-1){
								int f=regionName.indexOf("市");
								regionName=regionName.substring(0, f);
							}
							seriesData.setName(regionName);
							seriesData.setValue(finAmtDistribDal.getLnciAmt());
							seriesDataList.add(seriesData);
							seriesItem.setSeriesDatas(seriesDataList);
						}
					}
				}
				seriesItem.setSeriesName(productNmae);
				series.add(seriesItem);
			}
		}
		echartItem.setLegendData(legendData);
		echartItem.setSeries(series);
		List<com.huateng.scf.bas.lan.dao.vo.FinAmtDistrib> finAmtTopList=bLanLnciBaseDAO.queryFinAmtTopList(objMap);
		log.info("========================echartItem:"+echartItem);
		List<FinAmtDistrib> finAmtDistribVoList=new ArrayList<FinAmtDistrib>();
		if(null!=finAmtTopList && finAmtTopList.size()>0){
			for(int i=0;i<finAmtTopList.size();i++){
				com.huateng.scf.bas.lan.dao.vo.FinAmtDistrib finAmtDistribDal=finAmtTopList.get(i);
				FinAmtDistrib finAmtDistrib=new FinAmtDistrib();
				BeanUtils.copyProperties(finAmtDistribDal, finAmtDistrib);
				if(null!=finAmtDistrib.getLnciAmt()){
					//金额格式化为千分位
					finAmtDistrib.setLnciAmtStr(ScfCommonUtil.amountFormatToString(finAmtDistrib.getLnciAmt()));
				}
				finAmtDistribVoList.add(finAmtDistrib);
			}
			echartItem.setFinAmtTopList(finAmtDistribVoList);
		}
		return echartItem;
	}


	/**
	 * 查询资金迁徙地图数据
	 */
	@Override
	public EchartItem queryFundTransferList(Map<String, Object> value) throws ScubeBizException {
		EchartItem echartItem = new EchartItem();
		List<String> legendData = new ArrayList<String>();// legendData集合
		List<SeriesItem> series  =new ArrayList<SeriesItem>(); //series集合
		Map<String, Object> objMap = new HashMap<String, Object>();
		OdsTopCityExample example = new OdsTopCityExample();
		List<OdsTopCity> cityList = odsTopCityDAO.selectByExample(example);
		Map<String, Object> legendSelect = new HashMap<String, Object>();
		List<List<Object>> lineDatas = new ArrayList<List<Object>>();
		if(null!=cityList&&cityList.size()>0){
			for(int i=0;i<cityList.size();i++){
				OdsTopCity city = cityList.get(i);
				String area=city.getArea();// 区域编码
				String regionName = city.getAreaName();
				if(null!=regionName && regionName.indexOf("省")>-1){
					int n=regionName.indexOf("省");
					regionName=regionName.substring(0, n);
				}
				if(null!=regionName && regionName.indexOf("市")>-1){
					int f=regionName.indexOf("市");
					regionName=regionName.substring(0, f);
				}
				if(i!=0){
					legendSelect.put(regionName, false); //设置第一条选中	
				}
				legendData.add(regionName);//区域名称放入legendData
				SeriesItem	seriesItem=new SeriesItem();
				
				
				//查询实线相关
				List<FundTransferVO> routeList = extOdsDAO.queryFundTransferRouteList(objMap);
				List<PointData> spointDatas = new ArrayList<PointData>();
				List<List<Object>> slineDatas = new ArrayList<List<Object>>(); //series中 markLine 的data集合
			
				if(null!=routeList&&routeList.size()>0){
					 
					for(FundTransferVO route :routeList){
						List<Object> lineDataList = new ArrayList<Object>(); //series中 markLine 中的每一个data
						if(null!=area && area.equals(route.getStartArea())){
							String startAreaNm = route.getStartAreaNm();
							String endAreaNm = route.getEndAreaNm();
							if(null!=startAreaNm && startAreaNm.indexOf("省")>-1){
								int n=startAreaNm.indexOf("省");
								startAreaNm=startAreaNm.substring(0, n);
							}
							if(null!=startAreaNm && startAreaNm.indexOf("市")>-1){
								int f=startAreaNm.indexOf("市");
								startAreaNm=startAreaNm.substring(0, f);
							}
							if(null!=endAreaNm && endAreaNm.indexOf("省")>-1){
								int n=endAreaNm.indexOf("省");
								endAreaNm=endAreaNm.substring(0, n);
							}
							if(null!=endAreaNm && endAreaNm.indexOf("市")>-1){
								int f=endAreaNm.indexOf("市");
								endAreaNm=endAreaNm.substring(0, f);
							}
							//series  markline  Data  组装
							LineData	linedata = new LineData();
							PointData	pointData = new PointData();
							linedata.setName(startAreaNm);
							pointData.setName(endAreaNm);
							pointData.setValue(route.getAmt());

							lineDataList.add(linedata);  
							lineDataList.add(pointData);  
							slineDatas.add(lineDataList); //series  markline  Data 集合
					
							//series  markpoint  Data  组装

							PointData	spointData = new PointData();
							spointData.setName(endAreaNm);
							spointData.setValue(route.getAmt());
							spointDatas.add(spointData);
							//spointDatas.add(pointData);
						}
						
					}
					seriesItem.setSlineDatas(slineDatas);
					seriesItem.setSpointDatas(spointDatas);
				}
				seriesItem.setSeriesName(regionName);
				series.add(seriesItem);
				
			}
			//查询 虚线相关的数据
			 //虚线的 与其他不同  
			List<FundTransferVO> lineList= extOdsDAO.queryFundTransferLineList(objMap);

			if(null!=lineList&&lineList.size()>0){

				for(FundTransferVO line :lineList){
					List<Object> lineDataList = new ArrayList<Object>(); //series中 markLine 中的每一个data
					String startAreaNm = line.getStartAreaNm();
					String endAreaNm = line.getEndAreaNm();
					if(null!=startAreaNm && startAreaNm.indexOf("省")>-1){
						int n=startAreaNm.indexOf("省");
						startAreaNm=startAreaNm.substring(0, n);
					}
					if(null!=startAreaNm && startAreaNm.indexOf("市")>-1){
						int f=startAreaNm.indexOf("市");
						startAreaNm=startAreaNm.substring(0, f);
					}
					if(null!=endAreaNm && endAreaNm.indexOf("省")>-1){
						int n=endAreaNm.indexOf("省");
						endAreaNm=endAreaNm.substring(0, n);
					}
					if(null!=endAreaNm && endAreaNm.indexOf("市")>-1){
						int f=endAreaNm.indexOf("市");
						endAreaNm=endAreaNm.substring(0, f);
					}
					LineData	linedata = new LineData();
					PointData	pointData = new PointData();
					linedata.setName(startAreaNm);
					pointData.setName(endAreaNm);
					lineDataList.add(linedata);
					lineDataList.add(pointData);
		
					lineDatas.add(lineDataList);
				}
			}
		}
		echartItem.setLegendData(legendData);
		echartItem.setLegendSelect(legendSelect);

		echartItem.setSeries(series);
		echartItem.setSlineDatas(lineDatas);
		return echartItem;
	}


	@Override
	public List<BCrmTagCloudRel> getCustTagCloudRel(BCrmBaseInfo value) throws ScubeBizException {
		try {
			List<com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel> listdal = new ArrayList<com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel>();
			List<BCrmTagCloudRel> list = new ArrayList<BCrmTagCloudRel>();
			Map<String, String> map = getDictByDictCode("custTagType");
			if(value!=null){
				String custCd = value.getCustcd();
				BCrmTagCloudRelExample example = new BCrmTagCloudRelExample();
				Criteria criteria = example.createCriteria();
				if(StringUtils.isNoneEmpty(custCd)){
					criteria.andCustcdEqualTo(custCd);
					listdal = bCrmTagCloudRelDAO.selectByExample(example);
					for(com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel bCrmTagCloudReldal : listdal){
						BCrmTagCloudRel bCrmTagCloudRel = new BCrmTagCloudRel();
						BeanUtils.copyProperties(bCrmTagCloudReldal, bCrmTagCloudRel);
						bCrmTagCloudRel.setTagCode(map.get(bCrmTagCloudRel.getTagCode()));
						list.add(bCrmTagCloudRel);
					}
				}
			}
			return list;
		} catch (Exception e) {
			log.error("获取企业云标签失败！");
			throw new ScubeBizException("获取企业云标签失败！", e);
		}
	}
	
	private Map<String, String> getDictByDictCode(String dictCode) {
		BdDataDictDto bdDataDictDto = bdDataDictService.getDataByDictCode(dictCode);
		Map<String, String> resMap = new HashMap<String, String>();
		if (bdDataDictDto != null) {
			List<DataItem> list = bdDataDictDto.getDataItems();
			for (DataItem item : list) {
				resMap.put(item.getDataVal(), item.getDataTrsVal());
			}
		}
		return resMap;
	}

	
}
