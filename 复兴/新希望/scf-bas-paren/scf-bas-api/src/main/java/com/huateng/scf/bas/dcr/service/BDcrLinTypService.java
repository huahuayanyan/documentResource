package com.huateng.scf.bas.dcr.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.vo.VbDcrLinTyp;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * BDcrLinTyp接口类
 *
 * @author huateng
 * @date 2016年7月6日
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=================
 * Modifier			date			Content
 * huateng			2016年7月6日			新增
 *
 *            </pre>
 */
public interface BDcrLinTypService {

	/**
	 * @param bDcrLinTyp
	 * @return
	 */
	public void add(@ScubeParam("bDcrLinTyp") VbDcrLinTyp vbDcrLinTyp);

	/**
	 * @param bDcrLinTyp
	 * @return
	 */
	public int update(@ScubeParam("bDcrLinTyp") VbDcrLinTyp vbDcrLinTyp) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param orgUser
	 * @return
	 */
	public Page findObjectConditionByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bDcrLinTyp") VbDcrLinTyp vbDcrLinTyp);

	/**
	 * @param key
	 * @return
	 */
	public VbDcrLinTyp findBDcrLinTypByKey(@ScubeParam("key") String key);

}
