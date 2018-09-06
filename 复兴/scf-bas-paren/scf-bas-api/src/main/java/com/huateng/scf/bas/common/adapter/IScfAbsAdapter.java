/**
 * 
 */
package com.huateng.scf.bas.common.adapter;

import java.util.List;

import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 公共适配器统一接口
 * </p>
 *
 * @author huangshuidan
 * @date 2017年5月22日下午2:05:37
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年5月22日下午2:05:37             新增
 *
 * </pre>
 */
public interface IScfAbsAdapter {
	public static final String BEAN_ID = "scfAbsAdapter";
	/**
	 * 具体业务对象调用方法
	 * @param params
	 * 		IScfAbsInput-继承IScfAbsInput的业务输入对象
	 * @return List-存放继承IScfAbsOutput的业务输出
	 * @throws ScubeBizException
	 */
	public List<? extends IScfAbsOutput> process(@ScubeParam("inputParams") IScfAbsInput<? extends IScfAbsInput> params)
			throws ScubeBizException;
}
