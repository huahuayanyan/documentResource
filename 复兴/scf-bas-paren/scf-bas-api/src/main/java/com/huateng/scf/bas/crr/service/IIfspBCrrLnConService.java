package com.huateng.scf.bas.crr.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrLnCon接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:51:34
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:51:34	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
public interface IIfspBCrrLnConService {

	/* * @param pageNo
	 * @param pageSize
	 * @param bCrrLnCon
	 * @return
	 */
	public Page findBCrrLnConByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLnCon") BCrrLnCon bCrrLnCon);
	
}
