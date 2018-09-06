package com.huateng.scf.bas.mrn.service;

import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>最高额保证金流水查询接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月27日下午4:28:40
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月27日下午4:28:40	     新增
 *
 * </pre>
 */
public interface IMaxmumBailTransferQueryService {

	public Page MaxmumBailTransferQueryGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, String> value)
			throws ScubeBizException;

	public Page MutiProtDropDownGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;

	public Page SlaveContractGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;

}
