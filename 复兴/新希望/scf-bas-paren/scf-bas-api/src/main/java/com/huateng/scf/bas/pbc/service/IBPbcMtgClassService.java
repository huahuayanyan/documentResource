/**
 * 
 */
package com.huateng.scf.bas.pbc.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.model.BPbcMtgClassVO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 押品信息变更明细
 * </p>
 *
 * @author lihao
 * @date 2016年12月29日上午10:52:44
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * lihao		   2016年12月29日上午10:52:44              新增
 *
 *            </pre>
 */
public interface IBPbcMtgClassService {

	public static final String BEAN_ID = "bPbcMtgClassService";

	/**
	 * 根据押品代码转译押品名称
	 *
	 */
	public BPbcMtgClass translateMortgageNameByCode(@ScubeParam("key") String mortgageCode);

	// 检验押品名称和押品号是否一致
	public boolean checkMtgInfo(@ScubeParam("mortgageCode") Object mortgageCode,
			@ScubeParam("mortgageName") Object mortgageName, @ScubeParam("errMsg") String errMsg);
	
	// 检验押品名称和押品号是否一致
	public int checkInfoForSelect(@ScubeParam("bPbcMtgClassVO") BPbcMtgClassVO bPbcMtgClassVO);

	// 检验一及二级三级押品名称和代码一致
	public void checkInfoForThreeLevelsSelect(@ScubeParam("BPbcMtgBaseInfo") BPbcMtgBaseInfoVO bPbcMtgBaseInfoVO);
	
	/**
	 * 检验一及二级押品名称和代码一致 如果有三级检查三级
	 * @param bPbcMtgBaseInfoVO
	 */
	public void checkInfoForTwoLevelsSelect(@ScubeParam("BPbcMtgBaseInfo") BPbcMtgBaseInfoVO bPbcMtgBaseInfoVO);

	/**
	 * 用于页面押品一级二级（无三级）下拉菜单选择
	 *
	 */
	public Page findBPbcMtgClassForTwoLevelSelect(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPbcMtgClassVO bPbcMtgClassVO);

	/**
	 * 用于页面押品一级二级三级下拉 菜单选择
	 *
	 */
	public Page findBPbcMtgClassForThreeLevelSelect(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPbcMtgClassVO bPbcMtgClassVO);

}
