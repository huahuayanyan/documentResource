package com.huateng.scf.bas.crr.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.trade.dic.PartyRole;
import com.huateng.trade.dic.PartyType;
import com.huateng.trade.dic.TradeType;
import com.huateng.trade.model.TradeBaseResponse;
import com.huateng.trade.model.TradeModel;
import com.huateng.trade.model.TradeParty;
import  com.huateng.trade.model.TradeRequest;
import com.huateng.trade.service.TradeService;

/**
 * <p>核算账户接口测试类</p>
 *
 * @author 	杨冬
 * @date 	2016年11月9日下午5:00:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月9日下午5:00:43	                                 新增
 *
 * </pre>
 */

public class TradeTest {
	private final Logger log = LoggerFactory.getLogger(getClass());
	


	/**
	 * 放款清结算请求赋值
	 */
	public TradeRequest buildTradeRequest() {
		TradeRequest request = new TradeRequest();
		request.setTradeType(TradeType.FUNDIN);
		request.setRequestNo(UUIDGeneratorUtil.generate());
		request.setSystemCode("TEST");
		request.setProduceCode("P001");
		request.setTradeCode("10001");
		request.setOrderNo("uuwyy2wy2y2");
		request.setOrderAmount(new BigDecimal("50"));
		request.setTradeAmount(new BigDecimal("50"));
		request.setNotifyAddress("test");
		request.setPartyId("123213");
		
		List<TradeParty> partyList = new ArrayList<TradeParty>();
		TradeParty tradeStart = new TradeParty();
		tradeStart.setPartyType(PartyType.ACCOUNT);
		tradeStart.setAccountNo("1");
		tradeStart.setAccountType("1");
		tradeStart.setAmount(new BigDecimal("50"));
		tradeStart.setCustomerId("111111uuu");
		tradeStart.setInstCode("1222");
		tradeStart.setPartyRole(PartyRole.TRADE_START.name());

		TradeParty tradeTarPayer = new TradeParty();
		tradeTarPayer.setPartyType(PartyType.ACCOUNT);
		tradeTarPayer.setAccountNo("2");
		tradeTarPayer.setAccountType("1");
		tradeTarPayer.setAmount(new BigDecimal("50"));
		tradeTarPayer.setCustomerId("111111uuu");
		tradeTarPayer.setInstCode("3332");
		tradeTarPayer.setPartyRole(PartyRole.TRADE_TARGET.name());
//		
//		TradeParty tradeBuyer = new TradeParty();
//		tradeBuyer.setPartyType(PartyType.ACCOUNT);
//		tradeBuyer.setAccountNo("3");
//		tradeBuyer.setAccountType("1");
//		tradeBuyer.setAmount(new BigDecimal("50"));
//		tradeBuyer.setCustomerId("111111uuu");
//		tradeBuyer.setInstCode("3332");
//		tradeBuyer.setPartyRole(PartyRole.BUYER.name());
		
//		TradeParty tradeTTT = new TradeParty();
//		tradeTTT.setPartyType(PartyType.ACCOUNT);
//		tradeTTT.setAccountNo("4");
//		tradeTTT.setAccountType("1");
//		tradeTTT.setAmount(new BigDecimal("50"));
//		tradeTTT.setCustomerId("111111uuu");
//		tradeTTT.setInstCode("3332");
//		tradeTTT.setPartyRole(PartyRole.SELLER.name());

		partyList.add(tradeStart);
		partyList.add(tradeTarPayer);
	//	partyList.add(tradeBuyer);
		//partyList.add(tradeTTT);

		request.setPartyList(partyList);
		return request;
	}
	
	/**
	 * 放款清结算请求赋值
	 */
	public TradeBaseResponse<TradeModel> jointClearSys(
			TradeRequest request) {
		log.debug("【request】 ========" + request);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-spring-service.xml");
	//	ScubeClientCall.setCtx(ctx);
		TradeService tradeServicel =  ctx.getBean("tradeServicel", TradeService.class);
		TradeBaseResponse<TradeModel> response = tradeServicel.trade(request);
		
		log.debug("【response】 ========" + response);
		return response;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TradeTest  tradeTest=new   TradeTest();
		
		tradeTest.jointClearSys(tradeTest.buildTradeRequest());
	}

}
