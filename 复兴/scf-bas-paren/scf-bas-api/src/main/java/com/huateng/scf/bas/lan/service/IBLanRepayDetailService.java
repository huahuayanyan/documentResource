package com.huateng.scf.bas.lan.service;

import com.huateng.scf.bas.crr.model.BCrrDueBillDetail;
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

public interface IBLanRepayDetailService{
	public BCrrDueBillDetail findBLanRepayDetailById(@ScubeParam("id") String id);
}
