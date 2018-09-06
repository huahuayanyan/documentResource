/**
 * 
 */
package com.huateng.scf.bas.sys.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.model.BSysAcctBctl;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月21日下午2:51:32
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月21日下午2:51:32	      新增
 *
 *            </pre>
 */
public interface IBSysAcctBctlService {
	public static final String BEAN_ID = "bSysAcctBctlService";

	// 用于页面下拉菜单费用收取网店查询
	public Page findBSysAcctBctlByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BSysAcctBctl bSysAcctBctl);

	//用于校验
	public BSysAcctBctl findBSysAcctBctlByBrcode(@ScubeParam("brcode") String brcode);
}
