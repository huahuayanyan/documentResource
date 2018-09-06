package com.huateng.scf.bas.pbc.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scf.bas.pbc.model.BPbcMtgClassVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>押品目录管理接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月23日下午5:34:16
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月23日下午5:34:16	     新增
 *
 * </pre>
 */
public interface IMortgageClassService {

	public List<TreeModel> MortgageClassTreeGetter(@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;

	public Page MortgageClassPageGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bPbcMtgClass") BPbcMtgClassVO bPbcMtgClass);

	public int updateMtgClass(@ScubeParam("mtgClassVO") BPbcMtgClassVO mtgClassVO);

	public int deleteMtgClass(@ScubeParam("list") List<BPbcMtgClassVO> list);
}
