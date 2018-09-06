package com.huateng.scf.bas.lan.service;

import java.util.List;

import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.crr.model.BCrrDueBillDetail;
import com.huateng.scf.bas.lan.model.BLanLnciBuyBiz;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月8日下午19:11:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * liph		2016年12月8日下午19:11:24                     放款申请
 *
 *            </pre>
 */
public interface IBLanRepayYcSubmitService {
	public void ycSubmit(@ScubeParam("bcrrDuebillDetail") BCrrDueBillDetail bCrrDueBillDetail,@ScubeParam("buyinfoArray") List<BLanLnciBuyBiz> list) 
			throws FlowsharpException;
}
