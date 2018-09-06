/**
 * 
 */
package com.huateng.scf.bas.brp.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpPageParamPackage;
import com.huateng.scf.bas.brp.model.BBrpWarnParam;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>预警参数设置服务类</p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月15日上午11:07:09
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月15日上午11:07:09              新增
 *
 * </pre>
 */
public interface IWarnParamMngService {
	public static final String BEAN_ID="iWarnParamMngService";
	
	/**
	 * 获取预警参数设置分类的书结构
	 * @author shangxiujuan
	 * @date 2017年6月15日上午11:11:42
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 * @return List<TreeModel>
	 */
	public List<TreeModel> getWarnParamPackageList(@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;
	
	public BBrpPageParamPackage findBBrpPageParamPackageByKey(@ScubeParam("key") String key);

	
	public void addBBrpPageParamPackage(@ScubeParam("bBrpPageParamPackage") BBrpPageParamPackage bBrpPageParamPackage) throws ScubeBizException;

	/**
	 * @param bBrpPageParamPackage
	 * @return
	 */
	public int updateBBrpPageParamPackage(@ScubeParam("bBrpPageParamPackage") BBrpPageParamPackage bBrpPageParamPackage) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBBrpPageParamPackage(@ScubeParam("key") String key) throws ScubeBizException;   
	
	// 用于页面查询返回page对象
	public Page findWarnParamListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BBrpWarnParam bBrpWarnParam)throws ScubeBizException;
	
	/**
	 * 预警配置信息删除
	 * @author shangxiujuan
	 * @date 2017年6月15日下午7:48:58
	 * @param list
	 * @throws ScubeBizException
	 * @return void
	 */
	public void deleteWarnParam(@ScubeParam("list")List<BBrpWarnParam> list)throws ScubeBizException;

}
