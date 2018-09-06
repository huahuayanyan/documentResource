/**
 * 
 */
package com.huateng.scf.bas.brp.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpCostParam;
import com.huateng.scf.bas.brp.model.BBrpNoticeModel;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月3日 上午11:36:29
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * lihao		2016年12月3日 上午11:36:29	                                    新增
 *
 *            </pre>
 */

public interface IBBrpNoticeModelService {
	
	// 用于页面查询返回page对象
	public Page findBBrpNoticeModelByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BBrpNoticeModel bBrpNoticeModel);

	public String add(@ScubeParam("bBrpNoticeModel") BBrpNoticeModel bBrpNoticeModel);
	public String saveorupdate(@ScubeParam("bBrpNoticeModel") BBrpNoticeModel bBrpNoticeModel);
	public int delete(@ScubeParam("id") String id);
	public BBrpNoticeModel selectById(@ScubeParam("id") String id);

	BBrpNoticeModel selectByNoticeType(@ScubeParam("noticeType") String noticeType);


}
