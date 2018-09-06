/**
 * 
 */
package com.huateng.scf.bas.brp.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpWarnParam;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月4日 下午3:16:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * lihao		2016年12月4日 下午3:16:11	                                    新增
 *
 *            </pre>
 */

public interface IBBrpWarnParamService {
	// 查找具体费用信息
	public BBrpWarnParam findBBrpWarnParamByKey(@ScubeParam("bBrpWarnParam") BBrpWarnParam bBrpWarnParam);

	// 用于页面查询返回page对象
	public Page findBBrpWarnParamByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BBrpWarnParam bBrpWarnParam);
	
	public void addBBrpWarnParam(@ScubeParam("bBrpWarnParam") BBrpWarnParam bBrpWarnParam) throws ScubeBizException;

	/**
	 * @param bBrpWarnParam
	 * @return
	 */
	public int updateBBrpWarnParam(@ScubeParam("bBrpWarnParam") BBrpWarnParam bBrpWarnParam) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBBrpWarnParam(@ScubeParam("key") String key) throws ScubeBizException;

}
