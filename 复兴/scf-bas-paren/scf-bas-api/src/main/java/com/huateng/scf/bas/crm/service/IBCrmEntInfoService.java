/**
 * 
 */
package com.huateng.scf.bas.crm.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.model.BCrmEntInfo;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月21日 上午10:41:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * lihao		2016年11月21日 上午10:41:24	                                    新增
 *
 *            </pre>
 */

public interface IBCrmEntInfoService {
	public String add(@ScubeParam("bCrmEntInfo") BCrmEntInfo bCrmEntInfo);

	public int delete(@ScubeParam("custcd") String custcd);

	public int update(@ScubeParam("bCrmEntInfo") BCrmEntInfo bCrmEntInfo);

	public BCrmEntInfo findBCrmEntInfoByKey(@ScubeParam("bCrmEntInfo") BCrmEntInfo bCrmEntInfo);

	public List<BCrmEntInfo> findBCrmEntInfoByBCrm(@ScubeParam("bCrmEntInfo") BCrmEntInfo bCrmEntInfo);

	public Page findBCrmEntInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrmEntInfo") BCrmEntInfo bCrmEntInfo);

}
