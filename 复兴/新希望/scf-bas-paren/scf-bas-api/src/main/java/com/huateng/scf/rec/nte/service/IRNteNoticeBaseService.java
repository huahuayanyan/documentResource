package com.huateng.scf.rec.nte.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.nte.model.BNteNoticeBaseCon;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>应收类-通知书基本信息接口</p>
 *
 * @author 	liph
 * @date 	2016年12月15日.上午9:20:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月15日.上午9:20:46	     新增
 *
 * </pre>
 */

public interface IRNteNoticeBaseService {
	/***
	 * 根据查询条件获取通知书基本信息
	 * @param bntenoticebase,pagesize,pageno
	 * @throws ScubeBizException
	 */
	public Page findNoticeBaseInfoByCondition(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bNteNoticeBaseCon") BNteNoticeBaseCon bNteNoticeBaseCon);
}
