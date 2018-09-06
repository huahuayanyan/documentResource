/**
 * 
 */
package com.huateng.scf.bas.qry.model;

import java.util.List;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月10日下午1:09:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月10日下午1:09:12              新增
 *
 * </pre>
 */
public class SeriesItem {
	
	
	private String seriesName;
	
	List<SeriesDataItem> seriesData ;//series中的data集合 含有多个字段
	private List<SeriesData> seriesDatas;
	 
	 List<Object> seriesDataValue ; //
	 
	 List<List<Object>> slineDatas; //  series中 markLine 的data集合
	 List<PointData> spointDatas; //  series中 markPoint 的data集合

	/**
	 * @return the seriesName
	 */
	public String getSeriesName() {
		return seriesName;
	}

	/**
	 * @param seriesName the seriesName to set
	 */
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	/**
	 * @return the seriesData
	 */
	public List<SeriesDataItem> getSeriesData() {
		return seriesData;
	}

	/**
	 * @param seriesData the seriesData to set
	 */
	public void setSeriesData(List<SeriesDataItem> seriesData) {
		this.seriesData = seriesData;
	}

	/**
	 * @return the seriesDataValue
	 */
	public List<Object> getSeriesDataValue() {
		return seriesDataValue;
	}

	/**
	 * @param seriesDataValue the seriesDataValue to set
	 */
	public void setSeriesDataValue(List<Object> seriesDataValue) {
		this.seriesDataValue = seriesDataValue;
	}

	/**
	 * @return the seriesDatas
	 */
	public List<SeriesData> getSeriesDatas() {
		return seriesDatas;
	}

	/**
	 * @param seriesDatas the seriesDatas to set
	 */
	public void setSeriesDatas(List<SeriesData> seriesDatas) {
		this.seriesDatas = seriesDatas;
	}

	/**
	 * @return the slineDatas
	 */
	public List<List<Object>> getSlineDatas() {
		return slineDatas;
	}

	/**
	 * @param slineDatas the slineDatas to set
	 */
	public void setSlineDatas(List<List<Object>> slineDatas) {
		this.slineDatas = slineDatas;
	}

	/**
	 * @return the spointDatas
	 */
	public List<PointData> getSpointDatas() {
		return spointDatas;
	}

	/**
	 * @param spointDatas the spointDatas to set
	 */
	public void setSpointDatas(List<PointData> spointDatas) {
		this.spointDatas = spointDatas;
	}


	
	

	
}
