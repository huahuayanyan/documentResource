package com.huateng.scf.bas.mrn.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.model.BMrnBussInfo;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BMrnBussInfo接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月27日下午4:09:58
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月27日下午4:09:58	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
public interface IBMrnBussInfoService {

	public void save(@ScubeParam("bMrnBussInfo") BMrnBussInfo bMrnBussInfo) throws ScubeBizException;

	public Page getBailTransferQuery(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

}
