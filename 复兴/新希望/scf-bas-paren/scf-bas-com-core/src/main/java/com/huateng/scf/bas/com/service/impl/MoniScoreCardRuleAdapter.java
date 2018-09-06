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
import com.huateng.toprules.api.common.ResultKey;
import com.huateng.toprules.core.executionpath.RuleExecutionPath;
import com.huateng.toprules.core.executionpath.Rulecondition;
import com.huateng.toprules.core.executionpath.ScoreCard;
import com.huateng.toprules.scube.session.TopRulesScubeResponse;
import com.huateng.toprules.xom.ScfCustBaseInfo;
import com.huateng.toprules.xom.TransRequest;


/**
 * <p>
 * 供应商评分卡规则调用
 * </p>
 *
 * @author shangxiujuan
 * @date 2017年6月13日下午7:20:03
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月13日下午7:20:03            新增
 *
 * </pre>
 */
@ScubeService
@Service("moniScoreCardRuleAdapter")
public class MoniScoreCardRuleAdapter implements IScfAbsAdapter{
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
				ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_VERSION_SUPSCORECARD));// 执行的基线版本
		inputParams.put(ScfBasConstant.RULES_SET_VERSION,
				ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_SET_VERSION_MONISCORECARD));// 规则集版本
		TopRulesScubeResponse response=ScfRuleUtil.commonExecuteRules(inputParam,inputParams);
		if(null!=response){
			Map<String, Object> map_out = response.getOutputParameters();
			List<RuleExecutionPath> list0 = (List<RuleExecutionPath>) map_out.get(ResultKey.EXECUTIONPATH);
			if (null != list0 && list0.size() > 0) {
				for (RuleExecutionPath ruleExecutionPath : list0) {
					System.out.println(ruleExecutionPath.getRuleName());
					if ("1".equals(ruleExecutionPath.getType())) {// 1:普通规则
						List<Rulecondition> listRuleconditions = ruleExecutionPath.getNoFireHits();
						for (int i = 0; i < listRuleconditions.size(); i++) {
							log.info("未命中的普通规则条件=" + listRuleconditions.get(0).getCondition());
						}
					} else if ("3".equals(ruleExecutionPath.getType())) {// 3:评分卡
						List<ScoreCard> listScoreCards = ruleExecutionPath.getScoreCardsList();
						for (ScoreCard sc : listScoreCards) {
							log.info("命中的评分卡规则条件" + sc.getScoreCondition().getCondition());
						}
					} else if ("2".equals(ruleExecutionPath.getType())) {// 2:决策表
						List<Rulecondition> decisionTables = ruleExecutionPath.getDecisionTables();
						for (Rulecondition rulecondition : decisionTables) {
							log.info(rulecondition.getCondition() + "==命中的决策表条件" + rulecondition.getIndex());
						}
					} else if ("4".equals(ruleExecutionPath.getType())) {// 决策树
						List<Rulecondition> decisionTrees = ruleExecutionPath.getDecisonTrees();
						for (Rulecondition rulecondition : decisionTrees) {
							log.info(rulecondition.getCondition() + "==命中的决策树条件" + rulecondition.getIndex());
						}
					}
				}
			}
			
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
