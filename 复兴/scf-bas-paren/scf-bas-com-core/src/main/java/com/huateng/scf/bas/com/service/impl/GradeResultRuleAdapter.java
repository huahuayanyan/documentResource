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
import com.huateng.toprules.scube.common.TopRulesScubeRuntimeException;
import com.huateng.toprules.scube.service.ITopRuleScubeService;
import com.huateng.toprules.scube.session.TopRulesScubeRequest;
import com.huateng.toprules.scube.session.TopRulesScubeResponse;
import com.huateng.toprules.xom.ScfCustBaseInfo;
import com.huateng.toprules.xom.TransRequest;
import com.thoughtworks.xstream.XStream;

/**
 * <p>评级结果规则</p>
 *
 * @author 	huangshuidan
 * @date 2017年5月25日 下午2:59:03
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			     date			          Content
 * huangshuidan		     2017年5月25日下午2:59:03           新增
 *
 * </pre>
 */
@ScubeService
@Service("gradeResultRuleAdapter")
public class GradeResultRuleAdapter implements IScfAbsAdapter{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.common.adapter.IScfAbsAdapter#process(com.huateng.scf.bas.common.adapter.IScfAbsInput)
	 */
	@Override
	public List<? extends IScfAbsOutput> process(IScfAbsInput<? extends IScfAbsInput> params) throws ScubeBizException {
		ScfCustBaseInfoAdapterInput inputParam = (ScfCustBaseInfoAdapterInput)params;
		List<ScfCustBaseInfoAdapterOutput> outputs = new ArrayList<ScfCustBaseInfoAdapterOutput>();
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
//		topRulesRequest.setRuleSetVersion("1.2");//规则集版本 1.1全 1.2定价客户分群策略 1.3评分卡 1.4普通规则
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
//		
//		ScfCustBaseInfo outScfCustBaseInfo = (ScfCustBaseInfo) map_out.get("scfCustBaseInfo");
//		
//		log.info("--------------outScfCustBaseInfo:"+outScfCustBaseInfo + "");
//		log.info("--------------客户评级结果:"+outScfCustBaseInfo.getCustLevel());
//		ScfCustBaseInfoAdapterOutput scfCustBaseInfoOutput=new ScfCustBaseInfoAdapterOutput();
//		scfCustBaseInfoOutput.setScfCustBaseInfo(outScfCustBaseInfo);
//		outputs.add(scfCustBaseInfoOutput);
		Map<String, Object> inputParams= new HashMap<String, Object>();
		inputParams.put(ScfBasConstant.RULES_VERSION,
				ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_VERSION_SCORECARD));// 执行的基线版本
		inputParams.put(ScfBasConstant.RULES_SET_VERSION,
				ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_SET_VERSION_GRADERESULT));// 规则集版本
		TopRulesScubeResponse response=ScfRuleUtil.commonExecuteRules(inputParam,inputParams);
		if(null!=response){
			Map<String, Object> map_out = response.getOutputParameters();
			ScfCustBaseInfo outScfCustBaseInfo = (ScfCustBaseInfo) map_out.get("scfCustBaseInfo");
			log.info("--------------outScfCustBaseInfo:"+outScfCustBaseInfo + "");
			log.info("--------------客户评级结果:"+outScfCustBaseInfo.getCustLevel());
			ScfCustBaseInfoAdapterOutput scfCustBaseInfoOutput=new ScfCustBaseInfoAdapterOutput();
			scfCustBaseInfoOutput.setScfCustBaseInfo(outScfCustBaseInfo);
			outputs.add(scfCustBaseInfoOutput);
		}
		return outputs;
	}
	
}
