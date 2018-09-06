package com.huateng.scf.bas.common.service;

import java.math.BigDecimal;

import com.huateng.scf.bas.icr.model.CreditInterParamBean;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p></p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月25日下午3:31:05
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月25日下午3:31:05	     新增
 *
 * </pre>
 */
public interface IScfCreditService {

	public void credit(@ScubeParam("creditInterParamBean") CreditInterParamBean creditInterParamBean,@ScubeParam("custcd") String custcd,
			@ScubeParam("otherCustcd") String otherCustcd,@ScubeParam("creditType") String creditType,
			@ScubeParam("type")String type,@ScubeParam("amount") BigDecimal amount) throws ScubeBizException;

}
