package com.huateng.scf.bas.lan.service;

import java.util.Map;

import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月12日下午19:11:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * liph		2016年12月12日下午19:11:24                     放款申请
 *
 *            </pre>
 */

public interface IBLanRepayApproveCommonService{
	public String repayapprove(@ScubeParam("map") Map map);

	/**
	 * 
	 * @param appno
	 * @param noticeType
	 * @param status
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午7:51:12
	 */
	public void updateNoticeStatus(@ScubeParam("appno") String appno,@ScubeParam("noticeType") String noticeType,@ScubeParam("status") String status);
}
