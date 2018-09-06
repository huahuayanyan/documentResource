/**
 * 
 */
package com.huateng.scf.bas.com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.adapter.IScfAbsAdapter;
import com.huateng.scf.bas.common.adapter.IScfAbsInput;
import com.huateng.scf.bas.common.adapter.IScfAbsOutput;
import com.huateng.scf.bas.common.adapter.impl.ScfCustBaseInfoAdapterInput;
import com.huateng.scf.bas.common.adapter.impl.ScfCustBaseInfoAdapterOutput;
import com.huateng.scf.bas.common.constant.BComErrorConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ContextUtil;
import com.huateng.scf.bas.common.util.ScfRuleUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
import com.huateng.toprules.bizobject.PricingGroup;
import com.huateng.toprules.scube.common.TopRulesScubeRuntimeException;
import com.huateng.toprules.scube.service.ITopRuleScubeService;
import com.huateng.toprules.scube.session.TopRulesScubeRequest;
import com.huateng.toprules.scube.session.TopRulesScubeResponse;
import com.huateng.toprules.xom.ScfCustBaseInfo;
import com.huateng.toprules.xom.TransRequest;
import com.thoughtworks.xstream.XStream;

/**
 * <p>客户产品定价分群规则调用</p>
 *
 * @author 	huangshuidan
 * @date 2017年5月25日 下午7:07:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			     date			          Content
 * huangshuidan		     2017年5月25日下午7:07:01           新增
 *
 * </pre>
 */
@ScubeService
@Service("custPricingGroupRuleAdapter")
public class CustPricingGroupRuleAdapter implements IScfAbsAdapter{
	private final Logger log = LoggerFactory.getLogger(getClass());
	private static final String TOPRULESCUBE_BEAN_ID = "topRuleScubeService";
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.common.adapter.IScfAbsAdapter#process(com.huateng.scf.bas.common.adapter.IScfAbsInput)
	 */
	@Override
	public List<? extends IScfAbsOutput> process(IScfAbsInput<? extends IScfAbsInput> params) throws ScubeBizException {
		ScfCustBaseInfoAdapterInput inputParam = (ScfCustBaseInfoAdapterInput)params;
		List<ScfCustBaseInfoAdapterOutput> outputs = new ArrayList<ScfCustBaseInfoAdapterOutput>();
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest trans = new TransRequest();
		ScfCustBaseInfo scfCustBaseInfoParm=new ScfCustBaseInfo();
		if(null!=inputParam){
			scfCustBaseInfoParm=inputParam.getScfCustBaseInfo();
		}
//		ITopRuleScubeService topRuleScubeService=(ITopRuleScubeService)ContextUtil.getBean(TOPRULESCUBE_BEAN_ID);
//		inputParameters.put("scfCustBaseInfo", scfCustBaseInfoParm);
//		inputParameters.put(ScfBasConstant.RULES_TRANS, trans);//若没有传入trans参数对象，会出现规则没有命中的问题
//		XStream xStream = new XStream();
//		String xmlMap = xStream.toXML(inputParameters);
//		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(ScfBasConstant.RULES_PROJECT_NAME);
//		topRulesRequest.setVersion("1.0");//执行的基线版本
//		topRulesRequest.setRuleSetName(ScfBasConstant.RULES_SETNAME);//规则集名称
//		topRulesRequest.setRuleSetVersion("1.3");//规则集版本 1.1全 1.2定价客户分群策略 1.3评分卡 1.4普通规则
//		topRulesRequest.setFlag(true);
//		// 是否开启规则执行轨迹信息
//		topRulesRequest.setIsExecutionPath(true);
//		topRulesRequest.setInputParameters(inputParameters);
//		// 是否开启规则执行轨迹信息
//		topRulesRequest.setSaveRuleFlowInfoFlag(true);
//		topRulesRequest.setXmlMap(xmlMap);
//		TopRulesScubeResponse response=null;
//		try {
//			response = topRuleScubeService.executeRules(topRulesRequest);
//		} catch (TopRulesScubeRuntimeException e) {
//			log.error("-----------executeRules，规则执行出错"+e.getMessage());
//			e.printStackTrace();
//			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20007), BComErrorConstant.SCF_BAS_COM_20007);
//		}
//		Map<String, Object> map_out = response.getOutputParameters();
//		PricingGroup outPricingGroup = (PricingGroup) map_out.get("pricingGroup");
//		log.info("--------------outPricingGroup:"+outPricingGroup + "");
//		log.info("--------------定价组ID:"+outPricingGroup.getPricId());
//		ScfCustBaseInfoAdapterOutput scfCustBaseInfoOutput=new ScfCustBaseInfoAdapterOutput();
//		scfCustBaseInfoOutput.setOutPricingGroup(outPricingGroup);
//		outputs.add(scfCustBaseInfoOutput);
		Map<String, Object> inputParams= new HashMap<String, Object>();
		inputParams.put(ScfBasConstant.RULES_VERSION,
				ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_VERSION_SCORECARD));// 执行的基线版本
		inputParams.put(ScfBasConstant.RULES_SET_VERSION,
				ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_SET_VERSION_CUSTPRICINGGROUP));// 规则集版本
		TopRulesScubeResponse response=ScfRuleUtil.commonExecuteRules(inputParam,inputParams);
		if(null!=response){
			Map<String, Object> map_out = response.getOutputParameters();
			PricingGroup outPricingGroup = (PricingGroup) map_out.get("pricingGroup");
			log.info("--------------outPricingGroup:"+outPricingGroup + "");
			log.info("--------------定价组ID:"+outPricingGroup.getPricId());
			ScfCustBaseInfoAdapterOutput scfCustBaseInfoOutput=new ScfCustBaseInfoAdapterOutput();
			scfCustBaseInfoOutput.setPricingGroup(outPricingGroup);
			outputs.add(scfCustBaseInfoOutput);
		}
		return outputs;
	}
	
}
