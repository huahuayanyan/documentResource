/**
 * 
 */
package com.huateng.scf.bas.com.service.impl;

import java.math.BigDecimal;
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
import com.huateng.toprules.bizobject.PricingGroup;
import com.huateng.toprules.scube.session.TopRulesScubeResponse;
import com.huateng.toprules.xom.ProductInfo;
import com.huateng.toprules.xom.ScfCustBaseInfo;
import com.huateng.toprules.xom.TransRequest;

/**
 * <p>客户产品调分群规则调用</p>
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
@Service("custPriceAdjustGroupRuleAdapter")
public class CustPriceAdjustGroupRuleAdapter implements IScfAbsAdapter{
	private final Logger log = LoggerFactory.getLogger(getClass());
	private static final String TOPRULESCUBE_BEAN_ID = "topRuleScubeService";
	
	@Resource(name = "custPricingGroupRuleAdapter")
	IScfAbsAdapter custPricingGroupRuleAdapter;
	@Resource(name = "prodPricingTableRuleAdapter")
	IScfAbsAdapter prodPricingTableRuleAdapter;
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
		//调用 定价分群
		List<? extends IScfAbsOutput> custPricoutputs =custPricingGroupRuleAdapter.process(inputParam);
		ScfCustBaseInfoAdapterOutput scfCustBaseInfoOutput =(ScfCustBaseInfoAdapterOutput) custPricoutputs.get(0);
		PricingGroup outPricingGroup  = scfCustBaseInfoOutput.getPricingGroup();
		log.info("--------------定价组ID:"+outPricingGroup.getPricId());
		//调用 定价表 标准定价
		inputParam.setPricingGroup(outPricingGroup);
		List<ScfCustBaseInfoAdapterOutput> prodPriceOutputs	= (List<ScfCustBaseInfoAdapterOutput>) prodPricingTableRuleAdapter.process(inputParam);
		ProductInfo  outProductInfo = prodPriceOutputs.get(0).getProductInfo();
		log.info("--------------标准定价:"+outProductInfo.getNormPricing());
		scfCustBaseInfoParm.setBaseRate(outProductInfo.getNormPricing());
		inputParam.setScfCustBaseInfo(scfCustBaseInfoParm);
		Map<String, Object> inputParams= new HashMap<String, Object>();
		inputParams.put(ScfBasConstant.RULES_VERSION,
				ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_VERSION_SCORECARD));// 执行的基线版本
		inputParams.put(ScfBasConstant.RULES_SET_VERSION,
				ScfMessageUtil.transSysMsgByKey(ScfBasConstant.RULES_SET_VERSION_CUSTPRICEADJUSTGROUP));// 规则集版本
		TopRulesScubeResponse response=ScfRuleUtil.commonExecuteRules(inputParam,inputParams);
		if(null!=response){
			Map<String, Object> map_out = response.getOutputParameters();
			ScfCustBaseInfo outScfCustBaseInfo = (ScfCustBaseInfo) map_out.get("scfCustBaseInfo");
			log.info("--------------scfCustBaseInfo:"+outScfCustBaseInfo + "");
			log.info("--------------基准利率:"+outScfCustBaseInfo.getBaseRate());
			log.info("--------------调整利率:"+outScfCustBaseInfo.getAdjustRate());
			log.info("--------------总利率:"+outScfCustBaseInfo.getTotalRate());
			
			//由于计算不对，在此重新计算
			BigDecimal totalRate = BigDecimal.ZERO; 
			totalRate=outScfCustBaseInfo.getBaseRate().multiply(outScfCustBaseInfo.getAdjustRate().add(BigDecimal.ONE));
			outScfCustBaseInfo.setTotalRate(totalRate);
			log.info("--------------总利率:"+outScfCustBaseInfo.getTotalRate());
			ScfCustBaseInfoAdapterOutput adjustOutput=new ScfCustBaseInfoAdapterOutput();
			scfCustBaseInfoOutput.setScfCustBaseInfo(outScfCustBaseInfo);
			outputs.add(scfCustBaseInfoOutput);
		}
		return outputs;
	}
	
}
