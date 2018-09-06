/**
 * 
 */
package com.huateng.scf.bas.common.service;

import java.util.List;
import java.util.Map;

import com.huateng.scf.bas.common.adapter.IScfAbsAdapter;
import com.huateng.scf.bas.common.adapter.IScfAbsInput;
import com.huateng.scf.bas.common.adapter.IScfAbsOutput;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;
import com.huateng.toprules.core.browse.entity.Rule;
import com.huateng.toprules.core.project.entity.Project;

/**
 * <p>
 * 规则引擎平台接口
 * </p>
 *
 * @author huangshuidan
 * @date 2017年5月19日下午4:08:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年5月19日下午4:08:14             新增
 *
 * </pre>
 */
public interface IScfTopRulesService {
	public static final String BEAN_ID = "scfTopRulesService";
	/**
	 * 根据工程名称查询工程接口
	 * @param projectName
	 * 		String-工程名称
	 * @return Project对象
	 * @throws ScubeBizException
	 */
	public Project getProjectByName(@ScubeParam("projectName") String projectName) throws ScubeBizException;
	/**
	 * 查询规则列表
	 * @param projectUuid
	 * 		String-工程UUID
	 * @param types
	 * 		String[]- 规则类型 1-普通规则 2-决策表 3-决策树 4-评分卡 5-规则流
	 * @return
	 * @throws ScubeBizException
	 */
	public List<Rule> getProjectRules(@ScubeParam("projectUuid") String projectUuid, @ScubeParam("types") String[] types) throws ScubeBizException;
	/**
	 * 执行规则
	 * @param inputParams
	 * 		IScfAbsInput-继承IScfAbsInput的业务输出对象
	 * @return 继承IScfAbsOutput的业务输入对象
	 * @throws ScubeBizException
	 */
	public List<? extends IScfAbsOutput> executeRules(
			@ScubeParam("inputParams") IScfAbsInput<? extends IScfAbsInput> inputParams,
			@ScubeParam("paramMaps") Map<String, Object> paramMaps) throws ScubeBizException;
	/**
	 * 根据adapterId返回具体的Adapter对象
	 * @param adapterId
	 * 		String-适配器id
	 * @return
	 * @throws ScubeBizException
	 */
	public IScfAbsAdapter getAdapter(String adapterId) throws ScubeBizException;

}
