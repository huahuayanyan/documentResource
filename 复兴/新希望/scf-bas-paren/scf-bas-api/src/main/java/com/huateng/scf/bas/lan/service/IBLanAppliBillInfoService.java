/**
 * 
 */
package com.huateng.scf.bas.lan.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.model.BIcrAppliBrcodeList;
import com.huateng.scf.bas.lan.model.BLanAppliBillInfo;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>放款申请，供应链补录，票据信息列表显示</p>
 *
 * @author 	liph
 * @date 	2016年12月12日.下午1:45:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月12日.下午1:45:35	     新增
 *
 * </pre>
 */

public interface IBLanAppliBillInfoService {
	public Page findBLanAppliBillInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("value") BLanAppliBillInfo bLanAppliBillInfo);
}
