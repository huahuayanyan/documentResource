package com.huateng.scf.bas.crr.service;

import java.util.List;

import com.huateng.scf.bas.crr.model.BCrrLnConRela;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrLnConRela接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:48:30
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:48:30	     新增
 *
 * </pre>
 */
public interface IBCrrLnConRelaService {
	/**
	 * @param bCrrLnConRela
	 * @return
	 */
	public void add(@ScubeParam("bCrrLnConRela") BCrrLnConRela bCrrLnConRela);

	/**
	 * 
	 * @param bCrrLnConRela
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午2:55:44
	 */
	public List<BCrrLnConRela> findBCrrLnConRelaByExample(@ScubeParam("bCrrLnConRela") BCrrLnConRela bCrrLnConRela);
}
