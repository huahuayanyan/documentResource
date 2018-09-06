/**
 * 
 */
package com.huateng.scf.bas.sys.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.sys.service.IScfSysCacheService;
import com.huateng.scf.bas.sys.service.impl.ScfMcachedClientServiceImpl;
import com.huateng.toprules.api.common.ResultKey;
import com.huateng.toprules.bizobject.PricingGroup;
import com.huateng.toprules.core.browse.entity.Rule;
import com.huateng.toprules.core.executionpath.RuleExecutionPath;
import com.huateng.toprules.core.executionpath.Rulecondition;
import com.huateng.toprules.core.executionpath.ScoreCard;
import com.huateng.toprules.core.project.entity.Project;
import com.huateng.toprules.scube.common.DomainClass;
import com.huateng.toprules.scube.common.TopRulesScubeRuntimeException;
import com.huateng.toprules.scube.service.ITopRuleScubeService;
import com.huateng.toprules.scube.service.ITopRulesUserScubeService;
import com.huateng.toprules.scube.session.TopRulesScubeRequest;
import com.huateng.toprules.scube.session.TopRulesScubeResponse;
import com.huateng.toprules.xom.PersonInfo;
import com.huateng.toprules.xom.ProductInfo;
import com.huateng.toprules.xom.ScfCustBaseInfo;
import com.huateng.toprules.xom.TransRequest;
import com.huateng.toprules.xom.domain.DynamicElement;
import com.thoughtworks.xstream.XStream;

/**
 * <p>规则接口测试</p>
 *
 * @author 	huangshuidan
 * @date 	2017年5月07日上午9:40:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年5月07日上午9:40:48              新增
 *
 * </pre>
 */
public class ToprulesScubeTest {
	private final Logger logger = LoggerFactory.getLogger(getClass());
//	ITopRuleScubeService topRuleScubeService;
//	ITopRulesUserScubeService topRulesUserScubeService;
//	static String projectName = "SCF_DEMO_01";
	static String projectName = "SCF_PROJECT";
	
	@Test
	public void initService(){
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
//		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
//		ITopRulesUserScubeService topRulesUserScubeService =  ctx.getBean("topRulesUserScubeService", ITopRulesUserScubeService.class);
//		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
//		logger.info("--------------topRulesUserScubeService:"+topRulesUserScubeService);
		
//		try {
//			Project project = topRuleScubeService.createProjectByNameForProduct(projectName);
//			logger.info("--------------project:"+project);
//		} catch (TopRulesScubeRuntimeException e) {
//			e.printStackTrace();
//		}
	}
	
	@Test
	public void toprulesTest() throws Exception{
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
//		logger.info("--------------ctx:"+ctx);
		//1、 创建公共工程与规则工程
		//（ 1） 、 在规则平台创建公共工程（ DEFAULT_PROJECT） 与规则工程（ RULE_PROJECT）
		//（ 2）、 公共工程与规则工程名称必须是DEFAULT_PROJECT和RULE_PROJECT，且不能删除。
		//（ 3）、上传模型jar包（已提供默认toprules-base-xom.2.5.9包）
		//2、新建工程
//		Project project = createProjectByNameForProduct(ctx);
//		logger.info("--------------新建工程:"+project);
//		//3、刷新动态域
//		updateRuleModelDomain(project,ctx);
//		//4、新建规则
//		//在规则平台创建规则。
//		//5、发布工程
//		publishProject(project,ctx);
		//6、执行规则
//		executeRules0(ctx);
//		executeRulesScoreCard0(ctx);
//		executeRulesScoreCard1(ctx);//评分卡
//		executeRulesScoreCard2(ctx);//核心企业评级
//		executeRulesCustLevelTable(ctx);//策略表
//		executeRulesCustPricingGroup(ctx);//定价分群
//		executeRulesProdPricingTable(ctx);//利率定价表
		//查询工程信息
//		getProjectByName(projectName, ctx);
		//查询规则列表    2a7c47225c197b18015c1993dcc70008
//		getProjectRules("2a7c47225c34ad4f015c34ad4f130000", new String[]{"3"}, ctx);
	}

	private Project createProjectByNameForProduct(ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		Project project = topRuleScubeService.createProjectByNameForProduct(projectName);
		return project;
	}

	private void updateRuleModelDomain(Project project,ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		List<DomainClass> list = new ArrayList<DomainClass>();
		DomainClass d1 = new DomainClass("name2", "tommy", "String");
		DomainClass d2 = new DomainClass("age2", "22", "int");
		list.add(d2);
		list.add(d1);
		logger.info(DynamicElement.class.getName());
		topRuleScubeService.updateRuleModelDomain(project.getUuid(), list, "信贷", DynamicElement.class.getName());
		logger.info(topRuleScubeService.getAllProject().get(0).getProjectName());
	}

	

	private void publishProject(Project project,ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		// 1、 发布工程
		topRuleScubeService.publishProject(project.getUuid());
		// 2、 刷新规则集
		topRuleScubeService.refreshRuleSet();
	}

	private void executeRules(ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest[] transRequest = new TransRequest[1];
		TransRequest trans = new TransRequest();
		trans.getDynamicElement().getDynamicData().put("name2", "eed");
		trans.getDynamicElement().getDynamicData().put("age2", 25);
		transRequest[0] = trans;
		String mapKey = "trans";
		trans.getPersonInfo().setName("123");
		inputParameters.put(mapKey, transRequest);
		XStream xStream = new XStream();
		String xmlMap = xStream.toXML(inputParameters);
		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(projectName);
//		topRulesRequest.setVersion("Y2017051902");
		topRulesRequest.setXmlMap(xmlMap);
		TopRulesScubeResponse response = topRuleScubeService.executeRules(topRulesRequest);
		Map<String, Object> map = response.getOutputParameters();
		Object object = map.get(mapKey);
		logger.info("--------------object:"+object + "");
		TransRequest[] _transRequest = JSON.parseObject(object + "", TransRequest[].class);
		map.put(mapKey, _transRequest);
		TransRequest[] tequest = (TransRequest[]) response.getOutputParameters().get(mapKey);
		logger.info("--------------tequest[0].getResults().get(0):"+tequest[0].getResults().get(0) + "");
	}
	private void executeRules0(ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest[] transRequest = new TransRequest[1];
		TransRequest trans = new TransRequest();
		
		PersonInfo personInfo = new PersonInfo();
		personInfo.setSalary(25000);
		personInfo.setSex("男");
		
		
//		trans.getDynamicElement().getDynamicData().put("name2", "eed");
//		trans.getDynamicElement().getDynamicData().put("age2", 25);
//		transRequest[0] = trans;
//		String mapKey = "trans";
//		trans.getPersonInfo().setSalary(20000);
		
		inputParameters.put("personinfo", personInfo);
		inputParameters.put("trans", trans);//若没有传入trans参数对象，会出现规则没有命中的问题
		XStream xStream = new XStream();
		String xmlMap = xStream.toXML(inputParameters);
		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(projectName);
//		topRulesRequest.setVersion("Y2017051902");
		topRulesRequest.setFlag(true);
		topRulesRequest.setXmlMap(xmlMap);
		TopRulesScubeResponse response = topRuleScubeService.executeRules(topRulesRequest);
		Map<String, Object> map = response.getOutputParameters();
		
		PersonInfo outPersonInfo = (PersonInfo) map.get("personinfo");
		
		logger.info("--------------outPersonInfo:"+outPersonInfo + "");
//		TransRequest[] _transRequest = JSON.parseObject(object + "", TransRequest[].class);
//		map.put(mapKey, _transRequest);
//		TransRequest[] tequest = (TransRequest[]) response.getOutputParameters().get(mapKey);
		logger.info("--------------客户等级CustLevel:"+outPersonInfo.getCustLevel());
		logger.info("--------------客户状态:"+outPersonInfo.getCuststatus());
//		logger.info("--------------tequest[0].getResults().get(0):"+tequest[0].getResults().get(0) + "");
	}
	private void executeRulesScoreCard0(ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest[] transRequest = new TransRequest[1];
		TransRequest trans = new TransRequest();
		ScfCustBaseInfo scfCustBaseInfo=new ScfCustBaseInfo();
		PersonInfo personInfo = new PersonInfo();
		//评分卡-begin
		personInfo.setNation("汉族");
		personInfo.setAge(25);
		personInfo.setSalary(35000);
		personInfo.setEducation("本科");
		personInfo.setHunyin("已婚");
		//评分卡-end
		//普通规则
		personInfo.setSex("男");
		//决策树
		personInfo.setCustLevel("AA");
		personInfo.setZhengzhimianmao("H");
		
		inputParameters.put("personinfo", personInfo);
		inputParameters.put("scfCustBaseInfo", scfCustBaseInfo);
		inputParameters.put("trans", trans);//若没有传入trans参数对象，会出现规则没有命中的问题
		XStream xStream = new XStream();
		String xmlMap = xStream.toXML(inputParameters);
		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(projectName);
		topRulesRequest.setVersion("1.0");//执行的基线版本
		topRulesRequest.setRuleSetName("Default_RuleSet");//规则集名称
		topRulesRequest.setRuleSetVersion("1.3");//规则集版本 1.1全 1.2定价客户分群策略 1.3评分卡 1.4普通规则
		topRulesRequest.setFlag(true);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setIsExecutionPath(true);
		topRulesRequest.setInputParameters(inputParameters);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setSaveRuleFlowInfoFlag(true);
		topRulesRequest.setXmlMap(xmlMap);
		TopRulesScubeResponse response = topRuleScubeService.executeRules(topRulesRequest);
		Map<String, Object> map_out = response.getOutputParameters();
		
		PersonInfo outPersonInfo = (PersonInfo) map_out.get("personinfo");
		
		logger.info("--------------outPersonInfo:"+outPersonInfo + "");
		logger.info("--------------客户名称:"+outPersonInfo.getName());
		logger.info("--------------客户年龄:"+outPersonInfo.getAge());
		logger.info("--------------客户等级CustLevel:"+outPersonInfo.getCustLevel());
		logger.info("--------------客户状态:"+outPersonInfo.getCuststatus());
		
		// 普通规则命中信息
		List<RuleExecutionPath> list = (List<RuleExecutionPath>) map_out.get(ResultKey.FIREDCOMMONRULES);
		if(null!=list && list.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list) {
				logger.info(ruleExecutionPath.getConditionsToString() + "==命中规则的条件");
			}
		}
		
		List<RuleExecutionPath> list0 = (List<RuleExecutionPath>) map_out.get(ResultKey.EXECUTIONPATH);
		if(null!=list0 && list0.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list0) {
				System.out.println(ruleExecutionPath.getRuleName());
				if ("1".equals(ruleExecutionPath.getType())) {// 1:普通规则
					List<Rulecondition> listRuleconditions = ruleExecutionPath.getNoFireHits();
					for (int i = 0; i < listRuleconditions.size(); i++) {
						logger.info("未命中的普通规则条件=" + listRuleconditions.get(0).getCondition());
					}
				} else if ("3".equals(ruleExecutionPath.getType())) {//3:评分卡
					List<ScoreCard> listScoreCards = ruleExecutionPath.getScoreCardsList();
					for (ScoreCard sc : listScoreCards) {
						logger.info("命中的评分卡规则条件" + sc.getScoreCondition().getCondition());
					}
				} else if ("2".equals(ruleExecutionPath.getType())) {//2:决策表
					List<Rulecondition> decisionTables = ruleExecutionPath.getDecisionTables();
					for (Rulecondition rulecondition : decisionTables) {
						logger.info(rulecondition.getCondition() + "==命中的决策表条件" + rulecondition.getIndex());
					}
				} else if ("4".equals(ruleExecutionPath.getType())) {//决策树
					List<Rulecondition> decisionTrees = ruleExecutionPath.getDecisonTrees();
					for (Rulecondition rulecondition : decisionTrees) {
						logger.info(rulecondition.getCondition() + "==命中的决策树条件" + rulecondition.getIndex());
					}
				}
			}
		}
		
	}
	private void executeRulesScoreCard1(ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest[] transRequest = new TransRequest[1];
		TransRequest trans = new TransRequest();
		ScfCustBaseInfo scfCustBaseInfo=new ScfCustBaseInfo();

		//评分卡-begin
		scfCustBaseInfo.setAnnualTurnoverAmt(new BigDecimal(80000000));//年营业额
		scfCustBaseInfo.setAnnualPurchaseAmt(new BigDecimal(40000000));//年采购额
		scfCustBaseInfo.setTurnoverRate(new BigDecimal(0.8));//营业额增长率
		scfCustBaseInfo.setEarningPower("盈利且同比正增长");//盈利能力
		scfCustBaseInfo.setCreditRecord("公司及法人从未有逾期");//征信记录
		scfCustBaseInfo.setPerformanceRate("水电费、增值税或工资缴纳及发放及时且稳定（不减少或增长）");//履约率
		scfCustBaseInfo.setFinCondtion(new BigDecimal(20000000));//资产状况
		scfCustBaseInfo.setCashFlow("企业及关联企业以及企业主个人账户银行对账单交易连续且稳定增长");//现金流
		scfCustBaseInfo.setCourtDoc("无诉讼记录");//诉讼记录
		scfCustBaseInfo.setProofOfCredit(3);//资信实力证明
		scfCustBaseInfo.setCooperative(5);//合作年限
		scfCustBaseInfo.setStablityOftrad("较好");//交易稳定性
		scfCustBaseInfo.setMainProduct("主推XX产品");//主营产品
		scfCustBaseInfo.setPaymengTimeliness(new BigDecimal(0));//付款及时性
		scfCustBaseInfo.setFinancial("是");//账务往来
		scfCustBaseInfo.setIndustryExperi(6);//行业经验
		scfCustBaseInfo.setChlCapacity("电商");//渠道能力
		scfCustBaseInfo.setOrderMng("最近一年没有取消或修改订单");//订单管理
		scfCustBaseInfo.setLocalSales(new BigDecimal(40000000));//当地销售份额
		scfCustBaseInfo.setOperatorQuality("好");//经营者素质
		//评分卡-end


		inputParameters.put("scfCustBaseInfo", scfCustBaseInfo);
		inputParameters.put("trans", trans);//若没有传入trans参数对象，会出现规则没有命中的问题
		XStream xStream = new XStream();
		String xmlMap = xStream.toXML(inputParameters);
		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(projectName);
		topRulesRequest.setVersion("2.0");//执行的基线版本
		topRulesRequest.setRuleSetName("Default_RuleSet");//规则集名称
		topRulesRequest.setRuleSetVersion("2.0");//规则集版本 1.1全 1.2定价客户分群策略 1.3评分卡 1.4普通规则
		topRulesRequest.setFlag(true);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setIsExecutionPath(true);
		topRulesRequest.setInputParameters(inputParameters);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setSaveRuleFlowInfoFlag(true);
		topRulesRequest.setXmlMap(xmlMap);
		TopRulesScubeResponse response = topRuleScubeService.executeRules(topRulesRequest);
		Map<String, Object> map_out = response.getOutputParameters();
		
		ScfCustBaseInfo outScfCustBaseInfo = (ScfCustBaseInfo) map_out.get("scfCustBaseInfo");
		
		logger.info("--------------outScfCustBaseInfo:"+outScfCustBaseInfo + "");
		logger.info("--------------客户评级得分:"+outScfCustBaseInfo.getTotalScore());
		List<RuleExecutionPath> list1 = (List<RuleExecutionPath>) map_out.get(ResultKey.RECORDLIST);
		Map<String, Object> map_out_path  = (Map)map_out.get(ResultKey.RULEFLOWINFOPATH);
		
		// 普通规则命中信息
		List<RuleExecutionPath> list = (List<RuleExecutionPath>) map_out.get(ResultKey.FIREDCOMMONRULES);
		if(null!=list && list.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list) {
				logger.info(ruleExecutionPath.getConditionsToString() + "==命中规则的条件");
			}
		}
		
		List<RuleExecutionPath> list0 = (List<RuleExecutionPath>) map_out.get(ResultKey.EXECUTIONPATH);
		if(null!=list0 && list0.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list0) {
				System.out.println(ruleExecutionPath.getRuleName());
				if ("1".equals(ruleExecutionPath.getType())) {// 1:普通规则
					List<Rulecondition> listRuleconditions = ruleExecutionPath.getNoFireHits();
					for (int i = 0; i < listRuleconditions.size(); i++) {
						
						logger.info("未命中的普通规则条件=" + listRuleconditions.get(0).getCondition());
					}
				} else if ("3".equals(ruleExecutionPath.getType())) {//3:评分卡
					List<ScoreCard> listScoreCards = ruleExecutionPath.getScoreCardsList();
					for (ScoreCard sc : listScoreCards) {
						logger.info("命中的评分卡规则条件" + sc.getScoreCondition().getCondition() + "RuleUuid:"
								+ sc.getScoreCondition().getRuleUuid() + "Percent:"
								+ sc.getScoreCondition().getPercent() + "row:" + sc.getScoreCondition().getRow()+"Class:" + sc.getScoreCondition().getClass());
					}
				} else if ("2".equals(ruleExecutionPath.getType())) {//2:决策表
					List<Rulecondition> decisionTables = ruleExecutionPath.getDecisionTables();
					for (Rulecondition rulecondition : decisionTables) {
						logger.info(rulecondition.getCondition() + "==命中的决策表条件" + rulecondition.getIndex());
					}
				} else if ("4".equals(ruleExecutionPath.getType())) {//决策树
					List<Rulecondition> decisionTrees = ruleExecutionPath.getDecisonTrees();
					for (Rulecondition rulecondition : decisionTrees) {
						logger.info(rulecondition.getCondition() + "==命中的决策树条件" + rulecondition.getIndex());
					}
				}
			}
		}
		
	}
	/**
	 * 核心企业评级模型
	 * @param ctx
	 * @throws TopRulesScubeRuntimeException
	 */
	private void executeRulesScoreCard2(ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest[] transRequest = new TransRequest[1];
		TransRequest trans = new TransRequest();
		ScfCustBaseInfo scfCustBaseInfo=new ScfCustBaseInfo();

		//评分卡-begin
		scfCustBaseInfo.setMainBizIncome(new BigDecimal(80000000));//主营业务收入
		scfCustBaseInfo.setNetProfitMargin(new BigDecimal(0.09));//净利润率
		scfCustBaseInfo.setReturnOnEquity(new BigDecimal(0.0045));//净资产收益率
		scfCustBaseInfo.setAssetLibRatio(new BigDecimal(0.02));//资产负债率
//		@ModelField(name="流动比率", bindDomain="")
//		private BigDecimal currentRatio=new BigDecimal(0.0);
//		@ModelField(name="速冻比率", bindDomain="")
//		private BigDecimal quickRatio=new BigDecimal(0.0);
//		@ModelField(name="利息保障倍数", bindDomain="")
//		private BigDecimal interestCoverage=new BigDecimal(0.0);
//		@ModelField(name="应收账款周转率", bindDomain="")
//		private BigDecimal accountsRecTurnover=new BigDecimal(0.0);
//		@ModelField(name="销售增长率", bindDomain="")
//		private BigDecimal salesGrowthRate=new BigDecimal(0.0);
//		@ModelField(name="现金流负债比", bindDomain="")
//		private BigDecimal cashFlowLibRatio=new BigDecimal(0.0);
//		@ModelField(name="销售额现金比", bindDomain="")
//		private BigDecimal salesCashRatio=new BigDecimal(0.0);
//		@ModelField(name="公司历史逾期笔数", bindDomain="")
//		private int companyHisOverdue=0;
//		@ModelField(name="坏败率", bindDomain="")
//		private BigDecimal badDebtRate=new BigDecimal(0.0);
//		@ModelField(name="下游稳定性", bindDomain="")
//		private BigDecimal downStability=new BigDecimal(0.0);
//		@ModelField(name="年均订单额增长率", bindDomain="")
//		private BigDecimal annualAveGrowReteOfOder=new BigDecimal(0.0);
//		@ModelField(name="下游集中度", bindDomain="")
//		private BigDecimal downConcent=new BigDecimal(0.0);
//		@ModelField(name="订单违背率", bindDomain="")
//		private BigDecimal orderViolationRate=new BigDecimal(0.0);
		//评分卡-end


		inputParameters.put("scfCustBaseInfo", scfCustBaseInfo);
		inputParameters.put("trans", trans);//若没有传入trans参数对象，会出现规则没有命中的问题
		XStream xStream = new XStream();
		String xmlMap = xStream.toXML(inputParameters);
		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(projectName);
		topRulesRequest.setVersion("2.0");//执行的基线版本
		topRulesRequest.setRuleSetName("Default_RuleSet");//规则集名称
		topRulesRequest.setRuleSetVersion("2.4");//规则集版本 1.1全 1.2定价客户分群策略 1.3评分卡 1.4普通规则
		topRulesRequest.setFlag(true);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setIsExecutionPath(true);
		topRulesRequest.setInputParameters(inputParameters);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setSaveRuleFlowInfoFlag(true);
		topRulesRequest.setXmlMap(xmlMap);
		TopRulesScubeResponse response = topRuleScubeService.executeRules(topRulesRequest);
		Map<String, Object> map_out = response.getOutputParameters();
		
		ScfCustBaseInfo outScfCustBaseInfo = (ScfCustBaseInfo) map_out.get("scfCustBaseInfo");
		
		logger.info("--------------outScfCustBaseInfo:"+outScfCustBaseInfo + "");
		logger.info("--------------客户评级得分:"+outScfCustBaseInfo.getTotalScore());
		List<RuleExecutionPath> list1 = (List<RuleExecutionPath>) map_out.get(ResultKey.RECORDLIST);
		Map<String, Object> map_out_path  = (Map)map_out.get(ResultKey.RULEFLOWINFOPATH);
		
		// 普通规则命中信息
		List<RuleExecutionPath> list = (List<RuleExecutionPath>) map_out.get(ResultKey.FIREDCOMMONRULES);
		if(null!=list && list.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list) {
				logger.info(ruleExecutionPath.getConditionsToString() + "==命中规则的条件");
			}
		}
		
		List<RuleExecutionPath> list0 = (List<RuleExecutionPath>) map_out.get(ResultKey.EXECUTIONPATH);
		if(null!=list0 && list0.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list0) {
				System.out.println(ruleExecutionPath.getRuleName());
				if ("1".equals(ruleExecutionPath.getType())) {// 1:普通规则
					List<Rulecondition> listRuleconditions = ruleExecutionPath.getNoFireHits();
					for (int i = 0; i < listRuleconditions.size(); i++) {
						
						logger.info("未命中的普通规则条件=" + listRuleconditions.get(0).getCondition());
					}
				} else if ("3".equals(ruleExecutionPath.getType())) {//3:评分卡
					List<ScoreCard> listScoreCards = ruleExecutionPath.getScoreCardsList();
					for (ScoreCard sc : listScoreCards) {
						logger.info("命中的评分卡规则条件" + sc.getScoreCondition().getCondition() + "RuleUuid:"
								+ sc.getScoreCondition().getRuleUuid() + "Percent:"
								+ sc.getScoreCondition().getPercent() + "row:" + sc.getScoreCondition().getRow()+"Class:" + sc.getScoreCondition().getClass());
					}
				} else if ("2".equals(ruleExecutionPath.getType())) {//2:决策表
					List<Rulecondition> decisionTables = ruleExecutionPath.getDecisionTables();
					for (Rulecondition rulecondition : decisionTables) {
						logger.info(rulecondition.getCondition() + "==命中的决策表条件" + rulecondition.getIndex());
					}
				} else if ("4".equals(ruleExecutionPath.getType())) {//决策树
					List<Rulecondition> decisionTrees = ruleExecutionPath.getDecisonTrees();
					for (Rulecondition rulecondition : decisionTrees) {
						logger.info(rulecondition.getCondition() + "==命中的决策树条件" + rulecondition.getIndex());
					}
				}
			}
		}
		
	}
	private void executeRulesCustLevelTable(ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest[] transRequest = new TransRequest[1];
		TransRequest trans = new TransRequest();
		ScfCustBaseInfo scfCustBaseInfo=new ScfCustBaseInfo();
		PersonInfo personInfo = new PersonInfo();
		//评分卡-begin
		scfCustBaseInfo.setTotalScore(95);
		//评分卡-end

		inputParameters.put("personinfo", personInfo);
		inputParameters.put("scfCustBaseInfo", scfCustBaseInfo);
		inputParameters.put("trans", trans);//若没有传入trans参数对象，会出现规则没有命中的问题
		XStream xStream = new XStream();
		String xmlMap = xStream.toXML(inputParameters);
		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(projectName);
		topRulesRequest.setVersion("1.0");//执行的基线版本
		topRulesRequest.setRuleSetName("Default_RuleSet");//规则集名称
		topRulesRequest.setRuleSetVersion("1.2");//规则集版本 1.1全 1.2定价客户分群策略 1.3评分卡 1.4普通规则
		topRulesRequest.setFlag(true);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setIsExecutionPath(true);
		topRulesRequest.setInputParameters(inputParameters);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setSaveRuleFlowInfoFlag(true);
		topRulesRequest.setXmlMap(xmlMap);
		TopRulesScubeResponse response = topRuleScubeService.executeRules(topRulesRequest);
		Map<String, Object> map_out = response.getOutputParameters();
		
//		PersonInfo outPersonInfo = (PersonInfo) map_out.get("personinfo");
		ScfCustBaseInfo outScfCustBaseInfo = (ScfCustBaseInfo) map_out.get("scfCustBaseInfo");
		
		logger.info("--------------outScfCustBaseInfo:"+outScfCustBaseInfo + "");
//		logger.info("--------------客户评级得分:"+outScfCustBaseInfo.getTotalScore());
//		logger.info("--------------客户名称:"+outPersonInfo.getName());
//		logger.info("--------------客户年龄:"+outPersonInfo.getAge());
		logger.info("--------------客户等级CustLevel:"+outScfCustBaseInfo.getCustLevel());
//		logger.info("--------------客户状态:"+outPersonInfo.getCuststatus());
		
		// 普通规则命中信息
		List<RuleExecutionPath> list = (List<RuleExecutionPath>) map_out.get(ResultKey.FIREDCOMMONRULES);
		if(null!=list && list.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list) {
				logger.info(ruleExecutionPath.getConditionsToString() + "==命中规则的条件");
			}
		}
		List<RuleExecutionPath> list0 = (List<RuleExecutionPath>) map_out.get(ResultKey.EXECUTIONPATH);
		if(null!=list0 && list0.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list0) {
				System.out.println(ruleExecutionPath.getRuleName());
				if ("1".equals(ruleExecutionPath.getType())) {// 1:普通规则
					List<Rulecondition> listRuleconditions = ruleExecutionPath.getNoFireHits();
					for (int i = 0; i < listRuleconditions.size(); i++) {
						logger.info("未命中的普通规则条件=" + listRuleconditions.get(0).getCondition());
					}
				} else if ("3".equals(ruleExecutionPath.getType())) {//3:评分卡
					List<ScoreCard> listScoreCards = ruleExecutionPath.getScoreCardsList();
					for (ScoreCard sc : listScoreCards) {
						logger.info("命中的评分卡规则条件" + sc.getScoreCondition().getCondition());
					}
				} else if ("2".equals(ruleExecutionPath.getType())) {//2:决策表
					List<Rulecondition> decisionTables = ruleExecutionPath.getDecisionTables();
					for (Rulecondition rulecondition : decisionTables) {
						logger.info(rulecondition.getCondition() + "==命中的决策表条件" + rulecondition.getIndex());
					}
				} else if ("4".equals(ruleExecutionPath.getType())) {//决策树
					List<Rulecondition> decisionTrees = ruleExecutionPath.getDecisonTrees();
					for (Rulecondition rulecondition : decisionTrees) {
						logger.info(rulecondition.getCondition() + "==命中的决策树条件" + rulecondition.getIndex());
					}
				}
			}
		}
		
	}
	private void executeRulesCustPricingGroup(ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest[] transRequest = new TransRequest[1];
		TransRequest trans = new TransRequest();
		ScfCustBaseInfo scfCustBaseInfo=new ScfCustBaseInfo();
		PersonInfo personInfo = new PersonInfo();
		//评分卡-begin
		scfCustBaseInfo.setEnterpriseScope("01");//企业规模
		scfCustBaseInfo.setCustLevel("AAA");//评级
		//评分卡-end

		inputParameters.put("personinfo", personInfo);
		inputParameters.put("scfCustBaseInfo", scfCustBaseInfo);
		inputParameters.put("trans", trans);//若没有传入trans参数对象，会出现规则没有命中的问题
		XStream xStream = new XStream();
		String xmlMap = xStream.toXML(inputParameters);
		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(projectName);
		topRulesRequest.setVersion("1.0");//执行的基线版本
		topRulesRequest.setRuleSetName("Default_RuleSet");//规则集名称
		topRulesRequest.setRuleSetVersion("1.3");//规则集版本 1.1全 1.2定价客户分群策略 1.3评分卡 1.4普通规则
		topRulesRequest.setFlag(true);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setIsExecutionPath(true);
		topRulesRequest.setInputParameters(inputParameters);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setSaveRuleFlowInfoFlag(true);
		topRulesRequest.setXmlMap(xmlMap);
		TopRulesScubeResponse response = topRuleScubeService.executeRules(topRulesRequest);
		Map<String, Object> map_out = response.getOutputParameters();
		
		PricingGroup outPricingGroup = (PricingGroup) map_out.get("pricingGroup");
		logger.info("--------------outPricingGroup:"+outPricingGroup + "");
		logger.info("--------------定价组ID:"+outPricingGroup.getPricId());

		
		// 普通规则命中信息
		List<RuleExecutionPath> list = (List<RuleExecutionPath>) map_out.get(ResultKey.FIREDCOMMONRULES);
		if(null!=list && list.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list) {
				logger.info(ruleExecutionPath.getConditionsToString() + "==命中规则的条件");
			}
		}
		List<RuleExecutionPath> list0 = (List<RuleExecutionPath>) map_out.get(ResultKey.EXECUTIONPATH);
		if(null!=list0 && list0.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list0) {
				System.out.println(ruleExecutionPath.getRuleName());
				if ("1".equals(ruleExecutionPath.getType())) {// 1:普通规则
					List<Rulecondition> listRuleconditions = ruleExecutionPath.getNoFireHits();
					for (int i = 0; i < listRuleconditions.size(); i++) {
						logger.info("未命中的普通规则条件=" + listRuleconditions.get(0).getCondition());
					}
				} else if ("3".equals(ruleExecutionPath.getType())) {//3:评分卡
					List<ScoreCard> listScoreCards = ruleExecutionPath.getScoreCardsList();
					for (ScoreCard sc : listScoreCards) {
						logger.info("命中的评分卡规则条件" + sc.getScoreCondition().getCondition());
					}
				} else if ("2".equals(ruleExecutionPath.getType())) {//2:决策表
					List<Rulecondition> decisionTables = ruleExecutionPath.getDecisionTables();
					for (Rulecondition rulecondition : decisionTables) {
						logger.info(rulecondition.getCondition() + "==命中的决策表条件" + rulecondition.getIndex());
					}
				} else if ("4".equals(ruleExecutionPath.getType())) {//决策树
					List<Rulecondition> decisionTrees = ruleExecutionPath.getDecisonTrees();
					for (Rulecondition rulecondition : decisionTrees) {
						logger.info(rulecondition.getCondition() + "==命中的决策树条件" + rulecondition.getIndex());
					}
				}
			}
		}
		
	}
	private void executeRulesProdPricingTable(ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest[] transRequest = new TransRequest[1];
		TransRequest trans = new TransRequest();
//		ScfCustBaseInfo scfCustBaseInfo=new ScfCustBaseInfo();
//		PersonInfo personInfo = new PersonInfo();
		PricingGroup pricingGroup=new PricingGroup();
		//评分卡-begin
		pricingGroup.setPricId("PRICB001");//利率定价ID
		//评分卡-end
//		inputParameters.put("personinfo", personInfo);
//		inputParameters.put("scfCustBaseInfo", scfCustBaseInfo);
		inputParameters.put("pricingGroup", pricingGroup);
		inputParameters.put("trans", trans);//若没有传入trans参数对象，会出现规则没有命中的问题
		XStream xStream = new XStream();
		String xmlMap = xStream.toXML(inputParameters);
		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(projectName);
		topRulesRequest.setVersion("1.0");//执行的基线版本
		topRulesRequest.setRuleSetName("Default_RuleSet");//规则集名称
		topRulesRequest.setRuleSetVersion("1.4");//规则集版本 1.1全 1.2定价客户分群策略 1.3评分卡 1.4普通规则
		topRulesRequest.setFlag(true);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setIsExecutionPath(true);
		topRulesRequest.setInputParameters(inputParameters);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setSaveRuleFlowInfoFlag(true);
		topRulesRequest.setXmlMap(xmlMap);
		TopRulesScubeResponse response = topRuleScubeService.executeRules(topRulesRequest);
		Map<String, Object> map_out = response.getOutputParameters();
		
		ProductInfo outProductInfo = (ProductInfo) map_out.get("productInfo");
		
		logger.info("--------------outProductInfo:"+outProductInfo + "");
		logger.info("--------------定价组ID:"+pricingGroup.getPricId());
		logger.info("--------------标准定价:"+outProductInfo.getNormPricing());

		
		// 普通规则命中信息
		List<RuleExecutionPath> list = (List<RuleExecutionPath>) map_out.get(ResultKey.FIREDCOMMONRULES);
		if(null!=list && list.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list) {
				logger.info(ruleExecutionPath.getConditionsToString() + "==命中规则的条件");
			}
		}
		List<RuleExecutionPath> list0 = (List<RuleExecutionPath>) map_out.get(ResultKey.EXECUTIONPATH);
		if(null!=list0 && list0.size()>0){
			for (RuleExecutionPath ruleExecutionPath : list0) {
				System.out.println(ruleExecutionPath.getRuleName());
				if ("1".equals(ruleExecutionPath.getType())) {// 1:普通规则
					List<Rulecondition> listRuleconditions = ruleExecutionPath.getNoFireHits();
					for (int i = 0; i < listRuleconditions.size(); i++) {
						logger.info("未命中的普通规则条件=" + listRuleconditions.get(0).getCondition());
					}
				} else if ("3".equals(ruleExecutionPath.getType())) {//3:评分卡
					List<ScoreCard> listScoreCards = ruleExecutionPath.getScoreCardsList();
					for (ScoreCard sc : listScoreCards) {
						logger.info("命中的评分卡规则条件" + sc.getScoreCondition().getCondition());
					}
				} else if ("2".equals(ruleExecutionPath.getType())) {//2:决策表
					List<Rulecondition> decisionTables = ruleExecutionPath.getDecisionTables();
					for (Rulecondition rulecondition : decisionTables) {
						logger.info(rulecondition.getCondition() + "==命中的决策表条件" + rulecondition.getIndex());
					}
				} else if ("4".equals(ruleExecutionPath.getType())) {//决策树
					List<Rulecondition> decisionTrees = ruleExecutionPath.getDecisonTrees();
					for (Rulecondition rulecondition : decisionTrees) {
						logger.info(rulecondition.getCondition() + "==命中的决策树条件" + rulecondition.getIndex());
					}
				}
			}
		}
		
	}
	private void executeRulesScoreCard(ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService = ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		/* 入参对象 */
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		TransRequest[] transRequest = new TransRequest[1];
		TransRequest trans = new TransRequest();
		trans.getDynamicElementB().getDynamicData().put("age", 3);
		trans.getDynamicElementB().getDynamicData().put("sal", 25.0);
		trans.getDynamicElementB().getDynamicData().put("address", "guangzhou");
		trans.getDynamicElementB().getDynamicData().put("name", "zs");
		trans.getDynamicElement().getDynamicData().put("name", "zs");
		trans.getDynamicElement().getDynamicData().put("sal", 15.0);
		trans.getDynamicElement().getDynamicData().put("age", 25);
		trans.getPersonInfo().setName("zs");
		// PersonInfo personInfo = new PersonInfo();
		// personInfo.setName("zl");
		// trans.setPersonInfo(personInfo);
		transRequest[0] = trans;
		// transRequest[1] = trans1;
		String mapKey = "trans";
		PersonInfo personInfo = new PersonInfo();
		// personInfo.setName("zl");inputParameters.put(mapKey, transRequest);
		inputParameters.put("personInfo", personInfo);
		TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(projectName);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setIsExecutionPath(true);
		topRulesRequest.setInputParameters(inputParameters);
		// 是否开启规则执行轨迹信息
		topRulesRequest.setSaveRuleFlowInfoFlag(true);
		TopRulesScubeResponse response = topRuleScubeService.executeRules(topRulesRequest);
		Map<String, Object> map_out = response.getOutputParameters();
		// 规则流返回规则轨迹信息
		// Map<Long, Map<Long, Node>> mapProcess = (Map<Long, Map<Long,Node>>)
		// outputParameters.get(ResultKey.RULEFLOWINFOPATH);
		// for(Map.Entry<Long, Map<Long, Node>>entry :mapProcess.entrySet()){
		// System.out.println(entry.getValue().toString());
		// }
		// 普通规则命中信息
		List<RuleExecutionPath> list = (List<RuleExecutionPath>) map_out.get(ResultKey.FIREDCOMMONRULES);
		for (RuleExecutionPath ruleExecutionPath : list) {
			logger.info(ruleExecutionPath.getConditionsToString() + "==命中规则的条件");
		}
		List<RuleExecutionPath> list0 = (List<RuleExecutionPath>) map_out.get(ResultKey.EXECUTIONPATH);
		for (RuleExecutionPath ruleExecutionPath : list0) {
			System.out.println(ruleExecutionPath.getRuleName());
			if ("1".equals(ruleExecutionPath.getType())) {// 1:普通规则
				List<Rulecondition> listRuleconditions = ruleExecutionPath.getNoFireHits();
				for (int i = 0; i < listRuleconditions.size(); i++) {
					System.out.println("未命中的普通规则条件=" + listRuleconditions.get(0).getCondition());
				}
			} else if ("3".equals(ruleExecutionPath.getType())) {// 3:评分卡
				List<ScoreCard> listScoreCards = ruleExecutionPath.getScoreCardsList();
				for (ScoreCard sc : listScoreCards) {
					System.out.println("命中的评分卡规则条件" + sc.getScoreCondition().getCondition());
				}
			} else if ("2".equals(ruleExecutionPath.getType())) {
				List<Rulecondition> decisionTables = ruleExecutionPath.getDecisionTables();
				for (Rulecondition rulecondition : decisionTables) {
					System.out.println(rulecondition.getCondition() + "==命中的决策表条件" + rulecondition.getIndex());
				}
			} else if ("4".equals(ruleExecutionPath.getType())) {
				List<Rulecondition> decisionTrees = ruleExecutionPath.getDecisonTrees();
				for (Rulecondition rulecondition : decisionTrees) {
					System.out.println(rulecondition.getCondition() + "==命中的决策树条件" + rulecondition.getIndex());
				}
			}
		}
	}
	/**
	 * 查询规则列表接口
	 * @param projectUuid
	 * 		String-工程UUID
	 * @param types
	 * 		String- 规则类型 1-普通规则 2-决策表 3-决策树 4-评分卡 5-规则流
	 * @return
	 * @throws TopRulesScubeRuntimeException
	 */
	public List<Rule> getProjectRules(String projectUuid, String[] types,ApplicationContext ctx)
			throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService = ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		List<Rule> ruleList = null;
		ruleList=topRuleScubeService.getProjectRules(projectUuid, types);
		if(null!=ruleList && ruleList.size()>0){
			for(int i=0;i<ruleList.size();i++){
				Rule rules=(Rule)ruleList.get(i);
				logger.info("--------------规则名称:"+rules.getRuleName());
				logger.info("--------------规则内容:"+rules.getContent());
			}
		}
		return ruleList;
	}
	/**
	 * 根据工程名称查询工程接口
	 * @param projectName
	 * 		String-工程名称
	 * @return
	 * @throws TopRulesScubeRuntimeException
	 */
	public Project getProjectByName(String projectName,ApplicationContext ctx) throws TopRulesScubeRuntimeException{
		ITopRuleScubeService topRuleScubeService = ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		Project project=null;
		project=topRuleScubeService.getProjectByName(projectName);
		if(null!=project){
			//2a7c47225c197b18015c1993dcc70008
			logger.info("--------------工程UUID:"+project.getUuid());
			//工程UUID:2a7c47225c34ad4f015c34ad4f130000
		}
		return project;
	}
	
	
	public void modelDomain(Project project,ApplicationContext ctx) throws TopRulesScubeRuntimeException {
		ITopRuleScubeService topRuleScubeService =  ctx.getBean("topRuleScubeService", ITopRuleScubeService.class);
		logger.info("--------------topRuleScubeService:"+topRuleScubeService);
		List<DomainClass> list = new ArrayList<DomainClass>();
		DomainClass domainClass = new DomainClass("name", "姓名", "String");
		DomainClass domainClass01 = new DomainClass("age", "年龄", "Integer");
		list.add(domainClass);
		list.add(domainClass01);
		String dyclass = "com.huateng.toprules.xom.domain.DynamicElement";
		DomainClass domainClass02 = new DomainClass("address", "城市", "String");
		DomainClass shanghai = new DomainClass("shanghai", "上海", "String", "shanghai");
		shanghai.setDynamicClass(dyclass);
		DomainClass beijing = new DomainClass("beijing", "北京", "String", "beijing");
		beijing.setDynamicClass(dyclass);
		DomainClass guangzhou = new DomainClass("guangzhou", "广州", "String", "guangzhou");
		guangzhou.setDynamicClass(dyclass);
		DomainClass shenzhen = new DomainClass("shenzhen", "深圳", "String", "shenzhen");
		shenzhen.setDynamicClass(dyclass);
		List<DomainClass> list01 = new ArrayList<DomainClass>();
		list01.add(shanghai);
		list01.add(beijing);
		list01.add(guangzhou);
		list01.add(shenzhen);
		domainClass02.setSetDomainClass(list01);
		domainClass02.setDomainLable("城市");
		list.add(domainClass02);
		try {
			topRuleScubeService.updateRuleModelDomain(projectName, list, "小额贷款",
					"com.huateng.toprules.xom.domain.DynamicElement");
		} catch (TopRulesScubeRuntimeException e) {
			e.printStackTrace();
		}
		logger.info(topRuleScubeService.getAllProject().get(0).getProjectName());
	}
}
