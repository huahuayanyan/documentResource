/**
 * 
 */
package com.huateng.scf.bas.qry.model;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月10日上午11:26:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月10日上午11:26:43              新增
 *
 * </pre>
 */
public class EchartItem {

	 List<String> legendData; //legend 中的data
	 List<String> xaxisData; //X轴坐标 xAxis的data
	 List<SeriesItem> series ;//series中的data集合
	 List<FinAmtDistrib> finAmtTopList;//融资地图TOP，list

	 Map<String,Object> mapParam; //额外的参数
	 
	 Map<String,Object> legendSelect;
	 
	 List<List<Object>> slineDatas; // 虚线的数据

	/**
	 * @return the legendData
	 */
	public List<String> getLegendData() {
		return legendData;
	}

	/**
	 * @param legendData the legendData to set
	 */
	public void setLegendData(List<String> legendData) {
		this.legendData = legendData;
	}

	/**
	 * @return the xaxisData
	 */
	public List<String> getXaxisData() {
		return xaxisData;
	}

	/**
	 * @param xaxisData the xaxisData to set
	 */
	public void setXaxisData(List<String> xaxisData) {
		this.xaxisData = xaxisData;
	}

	/**
	 * @return the series
	 */
	public List<SeriesItem> getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(List<SeriesItem> series) {
		this.series = series;
	}

	/**
	 * @return the mapParam
	 */
	public Map<String, Object> getMapParam() {
		return mapParam;
	}

	/**
	 * @param mapParam the mapParam to set
	 */
	public void setMapParam(Map<String, Object> mapParam) {
		this.mapParam = mapParam;
	}

	/**
	 * @return the finAmtTopList
	 */
	public List<FinAmtDistrib> getFinAmtTopList() {
		return finAmtTopList;
	}

	/**
	 * @param finAmtTopList the finAmtTopList to set
	 */
	public void setFinAmtTopList(List<FinAmtDistrib> finAmtTopList) {
		this.finAmtTopList = finAmtTopList;
	}

	/**
	 * @return the legendSelect
	 */
	public Map<String, Object> getLegendSelect() {
		return legendSelect;
	}

	/**
	 * @param legendSelect the legendSelect to set
	 */
	public void setLegendSelect(Map<String, Object> legendSelect) {
		this.legendSelect = legendSelect;
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

	
 
}
