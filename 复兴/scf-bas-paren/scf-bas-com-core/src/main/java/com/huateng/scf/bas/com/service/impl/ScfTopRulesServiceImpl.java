/**
 * 
 */
package com.huateng.scf.bas.com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.adapter.IScfAbsAdapter;
import com.huateng.scf.bas.common.adapter.IScfAbsInput;
import com.huateng.scf.bas.common.adapter.IScfAbsOutput;
import com.huateng.scf.bas.common.adapter.impl.PersonInfoAdapterOutput;
import com.huateng.scf.bas.common.adapter.impl.ScfCustBaseInfoAdapterInput;
import com.huateng.scf.bas.common.constant.BComErrorConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfTopRulesService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
import com.huateng.toprules.core.browse.entity.Rule;
import com.huateng.toprules.core.project.entity.Project;
import com.huateng.toprules.scube.common.TopRulesScubeRuntimeException;
import com.huateng.toprules.scube.service.ITopRuleScubeService;

/**
 * <p>
 * 规则引擎接口包含接口查询、规则执行等
 * </p>
 *
 * @author 	huangshuidan
 * @date 2017年5月19日 下午4:52:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			     date			          Content
 * huangshuidan		     2017年5月19日下午4:52:55           新增
 *
 * </pre>
 */
@ScubeService
@Service(IScfTopRulesService.BEAN_ID)
public class ScfTopRulesServiceImpl implements IScfTopRulesService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ITopRuleScubeService topRuleScubeService;

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.common.service.IScfTopRulesService#getProjectByName(java.lang.String)
	 */
	@Override
	public Project getProjectByName(String projectName) throws ScubeBizException {
		Project project=null;
		try {
			project=topRuleScubeService.getProjectByName(projectName);
		} catch (TopRulesScubeRuntimeException e) {
			log.error("-----------getProjectByName，查询规则项目信息异常"+e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20005), BComErrorConstant.SCF_BAS_COM_20005);
		}
		if(null==project){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20006), BComErrorConstant.SCF_BAS_COM_20006);
		}
		return project;

	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.common.service.IScfTopRulesService#getProjectRules(java.lang.String, java.lang.String[])
	 */
	@Override
	public List<Rule> getProjectRules(String projectUuid, String[] types) throws ScubeBizException {
		List<Rule> ruleList = null;
		try {
			ruleList=topRuleScubeService.getProjectRules(projectUuid, types);
		} catch (TopRulesScubeRuntimeException e) {
			log.error("-----------getProjectRules，查询查询规则列表异常"+e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20007), BComErrorConstant.SCF_BAS_COM_20007);
		}
		if(null!=ruleList && ruleList.size()>0){
			for(int i=0;i<ruleList.size();i++){
				Rule rules=(Rule)ruleList.get(i);
				log.info("--------------规则名称:"+rules.getRuleName());
				log.info("--------------规则内容:"+rules.getContent());
			}
		}
		return ruleList;
	}
	
	

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.common.service.IScfTopRulesService#executeRules(com.huateng.scf.bas.common.adapter.IScfAbsInput, java.util.Map)
	 */
	@Override
	public List<? extends IScfAbsOutput> executeRules(IScfAbsInput<? extends IScfAbsInput> inputParams,
			Map<String, Object> paramMaps) throws ScubeBizException {
		String adapterId="";//adapterId
		String rulesType=paramMaps.get(ScfBasConstant.RULES_TYPE).toString();//规则类型
		if (StringUtil.isStrNotEmpty(rulesType)) {
			if(ScfBasConstant.RULES_TYPE_VALUE_4.equals(rulesType)){//4-评分卡规则
				adapterId=ScfBasConstant.RULES_ADAPTER_SCORECARDRULE;
				return this.executeRulesProcess(adapterId, inputParams);
			}
			if(ScfBasConstant.RULES_TYPE_VALUE_3.equals(rulesType)){//3-评级结果规则
				adapterId=ScfBasConstant.RULES_ADAPTER_GRADERESULTRULE;
				return this.executeRulesProcess(adapterId, inputParams);
			}
			if(ScfBasConstant.RULES_TYPE_VALUE_5.equals(rulesType)){//5-客户产品定价规则
				adapterId=ScfBasConstant.RULES_ADAPTER_CUSTPRICINGGROUPRULE;
				return this.executeRulesProcess(adapterId, inputParams);
			}
			if(ScfBasConstant.RULES_TYPE_VALUE_6.equals(rulesType)){//6-利率定价规则
				adapterId=ScfBasConstant.RULES_ADAPTER_PRODPRICINGTABLERULE;
				return this.executeRulesProcess(adapterId, inputParams);
			}
		}else{
			log.error("-----------executeRules，规则类型参数不能为空！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20010),
					BComErrorConstant.SCF_BAS_COM_20010);
		}
		return null;
	}


	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.common.service.IScfTopRulesService#getAdapter(java.lang.String)
	 */
	@Override
	public IScfAbsAdapter getAdapter(String adapterId) throws ScubeBizException {
		String adapterClassName=null;
		//根据adapterId查找具体业务Adapter对象
		adapterClassName=ScfMessageUtil.transSysMsgByKey(adapterId);
		if(null==adapterClassName || "".equals(adapterClassName)){
			log.error("-----------getAdapter，没有找到adapter配置，请配置规则adapter！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20011),
					BComErrorConstant.SCF_BAS_COM_20011);
		}
		IScfAbsAdapter adapter = null;
		try {
			adapter = (IScfAbsAdapter)Class.forName(adapterClassName).newInstance();
		} catch(Exception e) {
			log.error("-----------getAdapter，加载adapter对象出错！"+e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20009),
					BComErrorConstant.SCF_BAS_COM_20009);
		}
		return adapter;
	}
	/**
	 * 根据adapterId查找具体业务Adapter并执行规则
	 * @param adapterId
	 * 		String-适配器id
	 * @param inputParam
	 * 		IScfAbsInput-输入的参数
	 * @return
	 * @throws ScubeBizException
	 */
	private List<? extends IScfAbsOutput> executeRulesProcess(String adapterId,
			IScfAbsInput<? extends IScfAbsInput> inputParam) throws ScubeBizException {
		IScfAbsAdapter adapter = this.getAdapter(adapterId);
		return adapter.process(inputParam);
	}
	

}
