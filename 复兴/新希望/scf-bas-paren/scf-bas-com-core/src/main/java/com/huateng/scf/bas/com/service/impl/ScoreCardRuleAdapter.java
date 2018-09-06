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
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfRuleUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
import com.huateng.toprules.scube.session.TopRulesScubeResponse;
import com.huateng.toprules.xom.ScfCustBaseInfo;
import com.huateng.toprules.xom.TransRequest;

/**
 * <p>
 * 评分卡规则调用
 * </p>
 *
 * @author huangshuidan
 * @date 2017年5月22日下午2:20:03
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年5月22日下午2:20:03             新增
 *
 * </pre>
 */
@ScubeService
@Service("scoreCardRuleAdapter")
public class ScoreCardRuleAdapter implements IScfAbsAdapter{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.common.adapter.IScfAbsAdapter#process(com.huateng.scf.bas.common.adapter.IScfAbsInput)
	 */
	@Override
	public List<? extends IScfAbsOutput> process(IScfAbsInput<? extends IScfAbsInput> params) throws ScubeBizException {
		ScfCustBaseInfoAdapterInput inputParam = (ScfCustBaseInfoAdapterInput)params;
		List<ScfCustBaseInfoAdapterOutput> outputs = new ArrayList<ScfCustBaseInfoAdapterOutput>();
		Map<String, Object> inputParams= new HashMap<String, Object>();
		TransRequest[] transRequest = new TransRequest[1];
		TransRequest trans = new TransRequest();
		ScfCustBaseInfo scfCustBaseInfoParm=new ScfCustBaseInfo();
		if(null!=inputParam){
			scfCustBaseInfoParm=inputParam.getScfCustBaseInfo();
		}
		inputParams.put(ScfBasConstant.RULES_VERSION,
				ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_VERSION_SCORECARD));// 执行的基线版本
		inputParams.put(ScfBasConstant.RULES_SET_VERSION,
				ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_SET_VERSION_SCORECARD));// 规则集版本
		TopRulesScubeResponse response=ScfRuleUtil.commonExecuteRules(inputParam,inputParams);
		if(null!=response){
			Map<String, Object> map_out = response.getOutputParameters();
			ScfCustBaseInfo outScfCustBaseInfo = (ScfCustBaseInfo) map_out.get("scfCustBaseInfo");
			log.info("--------------outScfCustBaseInfo:"+outScfCustBaseInfo + "");
			log.info("--------------客户评级得分:"+outScfCustBaseInfo.getTotalScore());
			ScfCustBaseInfoAdapterOutput scfCustBaseInfoOutput=new ScfCustBaseInfoAdapterOutput();
			scfCustBaseInfoOutput.setScfCustBaseInfo(outScfCustBaseInfo);
			outputs.add(scfCustBaseInfoOutput);
		}
		return outputs;
	}
	
	
}
