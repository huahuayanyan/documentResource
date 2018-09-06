/**
 * 
 */
package com.huateng.scf.bas.com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
 * 客户产品折扣分群规则调用
 * </p>
 *
 * @author huangshuidan
 * @date 2017年5月25日 下午7:07:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			     date			          Content
 * huangshuidan		     2017年5月25日下午7:07:01           新增
 *
 *            </pre>
 */
@ScubeService
@Service("custDiscountGroupRuleAdapter")
public class CustDiscountGroupRuleAdapter implements IScfAbsAdapter {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private static final String TOPRULESCUBE_BEAN_ID = "topRuleScubeService";

	@Resource(name = "custPriceAdjustGroupRuleAdapter")
	IScfAbsAdapter custPriceAdjustGroupRuleAdapter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.common.adapter.IScfAbsAdapter#process(com.huateng.scf
	 * .bas.common.adapter.IScfAbsInput)
	 */
	@Override
	public List<? extends IScfAbsOutput> process(IScfAbsInput<? extends IScfAbsInput> params) throws ScubeBizException {
		ScfCustBaseInfoAdapterInput inputParam = (ScfCustBaseInfoAdapterInput) params;
		List<ScfCustBaseInfoAdapterOutput> outputs = new ArrayList<ScfCustBaseInfoAdapterOutput>();
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest trans = new TransRequest();
		ScfCustBaseInfo scfCustBaseInfoParm = new ScfCustBaseInfo();
		if (null != inputParam) {
			scfCustBaseInfoParm = inputParam.getScfCustBaseInfo();
		}
		// 调用 调价

		List<ScfCustBaseInfoAdapterOutput> priceAdjustOutputs = (List<ScfCustBaseInfoAdapterOutput>) custPriceAdjustGroupRuleAdapter
				.process(inputParam);
		ScfCustBaseInfo scfCustBaseInfoOutput = priceAdjustOutputs.get(0).getScfCustBaseInfo();
		scfCustBaseInfoParm.setTotalRate(scfCustBaseInfoOutput.getTotalRate());
		inputParam.setScfCustBaseInfo(scfCustBaseInfoParm);
		Map<String, Object> inputParams = new HashMap<String, Object>();
		inputParams.put(ScfBasConstant.RULES_VERSION, ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_VERSION_SCORECARD));// 执行的基线版本
		inputParams.put(ScfBasConstant.RULES_SET_VERSION, ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_SET_VERSION_CUSTDISCOUNTGROUP));// 规则集版本
																																				// //TODO
		TopRulesScubeResponse response = ScfRuleUtil.commonExecuteRules(inputParam, inputParams);
		if (null != response) {
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
			log.info("--------------scfCustBaseInfo:" + outScfCustBaseInfo + "");
			// log.info("--------------基准利率:"+outScfCustBaseInfo.getBaseRate());
			// log.info("--------------调整利率:"+outScfCustBaseInfo.getAdjustRate());
			// log.info("--------------折扣率:"+outScfCustBaseInfo.getDiscountRate());
			log.info("--------------总利率:" + outScfCustBaseInfo.getTotalRate());

			/*
			 * //由于计算不对，在此重新计算 BigDecimal totalRate = BigDecimal.ZERO;
			 * totalRate=outScfCustBaseInfo.getTotalRate().multiply(
			 * outScfCustBaseInfo.getDiscountRate());
			 * outScfCustBaseInfo.setTotalRate(totalRate);
			 * log.info("--------------总利率:"+outScfCustBaseInfo.getTotalRate());
			 */
			ScfCustBaseInfoAdapterOutput discountOutput = new ScfCustBaseInfoAdapterOutput();

			// 普通规则命中信息
			List<RuleExecutionPath> list = (List<RuleExecutionPath>) map_out.get(ResultKey.FIREDCOMMONRULES);
			if (null != list && list.size() > 0) {
				for (RuleExecutionPath ruleExecutionPath : list) {
					log.info(ruleExecutionPath.getConditionsToString() + "==命中规则的条件");
				}
			}

			discountOutput.setScfCustBaseInfo(outScfCustBaseInfo);
			outputs.add(discountOutput);
		}
		return outputs;
	}

}
