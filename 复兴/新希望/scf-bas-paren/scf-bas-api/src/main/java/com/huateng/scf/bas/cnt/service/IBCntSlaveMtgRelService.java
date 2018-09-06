package com.huateng.scf.bas.cnt.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntSlaveMtgRel;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>
 * BCntSlaveMtgRel接口类
 * </p>
 *
 * @author mengjiajia
 * @date 2016年12月24日下午2:01:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月24日下午2:01:20	     新增
 *
 *            </pre>
 */
public interface IBCntSlaveMtgRelService {
	/**
	 * 
	 * @param bCntSlaveMtgRel
	 */
	public void cacheAdd(@ScubeParam("bCntSlaveMtgRel") BCntSlaveMtgRel bCntSlaveMtgRel);

	/**
	 * 
	 * @param bCntSlaveMtgRel
	 */
	public void add(@ScubeParam("bCntSlaveMtgRel") BCntSlaveMtgRel bCntSlaveMtgRel);

	/**
	 * 
	 * 批量新增押品信息
	 */
	public void batchAddSlaveMtgRel(@ScubeParam("bCntSlaveMtgRel") List<BCntSlaveMtgRel> bCntSlaveMtgRel,
			@ScubeParam("slaveContno") String slaveContno);

	/**
	 * 
	 * @param bCntSlaveMtgRel
	 * @return
	 */
	public int update(@ScubeParam("bCntSlaveMtgRel") BCntSlaveMtgRel bCntSlaveMtgRel);

	/**
	 * 
	 * @param list
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCntSlaveMtgRel> list);

	/**
	 * 
	 * 根据合同号 slaveContno
	 */
	public int deleteMtgRelBySlaveContno(@ScubeParam("slaveContno") String slaveContno);

	/**
	 * 
	 * @param bCntSlaveMtgRel
	 * @return
	 */
	public Page findBCntSlaveMtgRelByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCntSlaveMtgRel") BCntSlaveMtgRel bCntSlaveMtgRel, @ScubeParam("cache") String cache);

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page findBPbcMtgClassByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") HashMap<String, String> value);

	/**
	 * 
	 * 根据合同号查询押品信息，无条件返回空
	 */
	public Page findBPbcMtgClassForMortage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntSlaveMtgRel bCntSlaveMtgRel);
}
