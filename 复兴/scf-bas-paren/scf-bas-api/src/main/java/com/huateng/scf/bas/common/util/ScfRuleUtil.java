/**
 * 
 */
package com.huateng.scf.bas.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.huateng.scf.bas.common.adapter.IScfAbsInput;
import com.huateng.scf.bas.common.adapter.impl.ScfCustBaseInfoAdapterInput;
import com.huateng.scf.bas.common.adapter.impl.ScfCustBaseInfoAdapterOutput;
import com.huateng.scf.bas.common.constant.BComErrorConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.toprules.bizobject.PricingGroup;
import com.huateng.toprules.scube.common.TopRulesScubeRuntimeException;
import com.huateng.toprules.scube.service.ITopRuleScubeService;
import com.huateng.toprules.scube.session.TopRulesScubeRequest;
import com.huateng.toprules.scube.session.TopRulesScubeResponse;
import com.huateng.toprules.xom.ScfCustBaseInfo;
import com.huateng.toprules.xom.TransRequest;
import com.thoughtworks.xstream.XStream;

/**
 * <p>
 * 供应链规则工具类
 * </p>
 *
 * @author huangshuidan
 * @date 2017年5月25日下午5:03:36
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年5月25日下午5:03:36             新增
 *
 * </pre>
 */
public class ScfRuleUtil {
//	private final Logger log = LoggerFactory.getLogger(getClass());
	private static final String TOPRULESCUBE_BEAN_ID = "topRuleScubeService";
	/**
	 * 规则执行公共方法
	 * @param scfCustBaseInfoParm
	 * 		ScfCustBaseInfo对象
	 * @param inputParams
	 * 		Map<String, Object>-规则版本信息map
	 * @return TopRulesScubeResponse
	 * @throws ScubeBizException
	 */
	public static TopRulesScubeResponse commonExecuteRules(IScfAbsInput<? extends IScfAbsInput> params,
			Map<String, Object> inputParams) throws ScubeBizException {
		
		ScfCustBaseInfoAdapterInput inputParam = (ScfCustBaseInfoAdapterInput)params;
		ScfCustBaseInfo scfCustBaseInfoParm=null;
		PricingGroup pricingGroupParm=null;
		if(null!=inputParam){
			scfCustBaseInfoParm=inputParam.getScfCustBaseInfo();
			pricingGroupParm=inputParam.getPricingGroup();
		}
		ITopRuleScubeService topRuleScubeService=(ITopRuleScubeService)ContextUtil.getBean(TOPRULESCUBE_BEAN_ID);
		TransRequest trans = new TransRequest();
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		if(null!=scfCustBaseInfoParm){
			inputParameters.put("scfCustBaseInfo", scfCustBaseInfoParm);
		}
		if(null!=pricingGroupParm){
			inputParameters.put("pricingGroup", pricingGroupParm);
		}
		inputParameters.put(ScfBasConstant.RULES_TRANS, trans);//若没有传入trans参数对象，会出现规则没有命中的问题
		XStream xStream = new XStream();
		String xmlMap = xStream.toXML(inputParameters);
		String ruleVersion = null == inputParams.get(ScfBasConstant.RULES_VERSION) ? ""
				: inputParams.get(ScfBasConstant.RULES_VERSION).toString();// 执行的基线版本
		String ruleSetVersion = null == inputParams.get(ScfBasConstant.RULES_SET_VERSION) ? ""
				: inputParams.get(ScfBasConstant.RULES_SET_VERSION).toString();// 规则集版本
		TopRulesScubeRequest topRulesRequest=buildTopRulesRequest(ruleVersion, ruleSetVersion, xmlMap, inputParameters);
		TopRulesScubeResponse response=null;
		try {
			response = topRuleScubeService.executeRules(topRulesRequest);
		} catch (TopRulesScubeRuntimeException e) {
			//log.error("-----------executeRules，规则执行出错"+e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20007),
					BComErrorConstant.SCF_BAS_COM_20007);
		}
		return response;
	}
	/**
	 * 构造规则请求对象
	 * @param ruleVersion
	 * @param ruleSetVersion
	 * @param xmlMap
	 * @param inputParameters
	 * @return TopRulesScubeRequest
	 */
	public static TopRulesScubeRequest buildTopRulesRequest(String ruleVersion, String ruleSetVersion, String xmlMap,
			Map<String, Object> inputParameters) {
		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(ScfBasConstant.RULES_PROJECT_NAME);
		topRulesRequest.setVersion(ruleVersion);// 执行的基线版本
		topRulesRequest.setRuleSetName(ScfBasConstant.RULES_SETNAME);// 规则集名称
		topRulesRequest.setRuleSetVersion(ruleSetVersion);// 规则集版本 1.1全  1.2定价客户分群策略 1.3评分卡 1.4普通规则
		topRulesRequest.setFlag(true);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setIsExecutionPath(true);
		topRulesRequest.setInputParameters(inputParameters);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setSaveRuleFlowInfoFlag(true);
		topRulesRequest.setXmlMap(xmlMap);
		return topRulesRequest;
	}
}
