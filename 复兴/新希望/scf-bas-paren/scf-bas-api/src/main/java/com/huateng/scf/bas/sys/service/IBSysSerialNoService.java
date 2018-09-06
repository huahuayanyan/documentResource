/**
 * 
 */
package com.huateng.scf.bas.sys.service;

import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>供应链业务流水号生成接口</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月5日上午11:33:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月5日上午11:33:17	                                 新增
 *
 * </pre>
 */
public interface IBSysSerialNoService {
	/**
	 * 根据序号代码生成序号
	 * @param SerialCode
	 * 		String-序号代码
	 * @return 流水号
	 */
	public String genSerialNo(@ScubeParam("serialCode") String serialCode) throws ScubeBizException;
}
