package com.huateng.scf.bas.mrn.service;


import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.vo.BCrrGntyConVO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>最高额保证金转入登记接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月27日上午10:00:05
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月27日上午10:00:05	     新增
 *
 * </pre>
 */
public interface IMaximumBailTransferApplyService {

	public Page findBCrrGntyConByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrGntyConVO") BCrrGntyConVO bCrrGntyConVO);

	public Page BailAccountBaseInfoGetter(@ScubeParam("bCrrGntyConVO") BCrrGntyConVO bCrrGntyConVO);

	public void BailTransferApplyUpdate(@ScubeParam("bCrrGntyConVO") BCrrGntyConVO bCrrGntyConVO,@ScubeParam("value") HashMap<String, Object> value);

}
