package com.huateng.scf.bas.common.service;

import java.util.List;

import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>公共类		接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月28日下午7:12:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月28日下午7:12:20	     新增
 *
 * </pre>
 */
public interface ICustomerService {

	public List<String> getCustcdsQueryCondition(@ScubeParam("param") String param,@ScubeParam("type") String type,@ScubeParam("mgrno") String mgrno) throws ScubeBizException;

}
