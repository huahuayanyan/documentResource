package com.huateng.scf.brp.notice.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface INoticeExportReportService {
	/**
	 * 初始化打印页面空格展示内容值
	 * @param params 参数
	 * @return	 页面元素值Map对象
	 */
	public Map<String,Object> getContentMap(@ScubeParam("params")Map<String,String> params) throws ScubeBizException;
	
	/**
	 * 初始化打印页面Table或List展示的内容
	 * @param params
	 * @return 集合（List或Set）
	 */
	public  Collection<?> getIterativeData(@ScubeParam("params")Map<String,String> params) throws ScubeBizException;
	
	/**
	 * 多条记录打印，初始化打印页面空格展示内容值（仅对模板只包含Parameter控件页面有效）
	 * @param params 参数
	 * @return	 页面元素值Map对象
	 */
	public List<Map<String,Object>> getContentMapMultiRecord(@ScubeParam("params")Map<String,String> params) throws ScubeBizException;
}
