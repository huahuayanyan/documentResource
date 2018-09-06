package com.huateng.scf.bas.nte.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.model.NoticeQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 收款确认通知书查询服务接口
 * </p>
 * 
 * @author zhanghesheng
 * @date 2017年1月4日上午11:10:25
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * zhanghesheng		2017年1月4日上午11:10:25	     新增
 * 
 * </pre>
 */
public interface IBNteNoticeQryVOService {
	/**
	 * 分页查询收款确认通知书
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param noticeQryVO
	 * @return Page
	 */
	Page queryNoticeQryVOByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") NoticeQryVO noticeQryVO)
			throws ScubeBizException;
}
