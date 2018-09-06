package com.huateng.scf.bas.crr.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrGntyAudit;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrGntyAudit接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:38:50
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:38:50	     新增
 *
 * </pre>
 */
public interface IBCrrGntyAuditService {
	/**
	 * @param bCrrGntyAudit
	 * @return
	 */
	public void add(@ScubeParam("bCrrGntyAudit") BCrrGntyAudit bCrrGntyAudit);
	/**
	 * @param bCrrGntyAudit
	 * @return
	 */
	public int update(@ScubeParam("bCrrGntyAudit") BCrrGntyAudit bCrrGntyAudit);
	/**
	 * @param serialno
	 * @return
	 */
	public int delete(@ScubeParam("serialno") String serialno);
	/**
	 * @param serialnos
	 * @return
	 */
	public int batchDelete(@ScubeParam("serialnos") String serialnos);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrGntyAudit
	 * @return
	 */
	public Page findBCrrGntyAuditByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrGntyAudit") BCrrGntyAudit bCrrGntyAudit);
}
