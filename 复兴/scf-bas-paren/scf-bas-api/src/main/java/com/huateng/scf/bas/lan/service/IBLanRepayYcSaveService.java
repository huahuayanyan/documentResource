package com.huateng.scf.bas.lan.service;

import java.util.List;

import com.huateng.scf.bas.crr.model.BCrrDueBillDetail;
import com.huateng.scf.bas.lan.model.BLanLnciBuyBiz;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月24日下午19:11:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * liph		2016年12月24日下午19:11:24          供应链补录提交
 *
 *            </pre>
 */
public interface IBLanRepayYcSaveService {
	public void saveYc(@ScubeParam("bcrrDuebillDetail") BCrrDueBillDetail bCrrDueBillDetail,@ScubeParam("buyinfoArray") List<BLanLnciBuyBiz> list);
}
