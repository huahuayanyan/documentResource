package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huateng.scf.bas.bcp.dao.ext.ExtSBcpAppliLowerPriceDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotDealInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.ext.ExtBLanDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.ext.ExtIBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;


@ScubeService
@Service("AmountServiceImpl")
public class AmountServiceImpl implements IAmountService {

	// 金额计算模式
	public static final String CALCULATE_MODEL_1 = "1";// 可提货金额（动产）
	public static final String CALCULATE_MODEL_2 = "2";// 敞口
	public static final String CALCULATE_MODEL_3 = "3";// 融资余额-保证金-等价物-押品价值
	public static final String CALCULATE_MODEL_4 = "4";// 可提货价值(预付款)
	public static final String CALCULATE_MODEL_5 = "5";// 押品价值-融资余额
	// 返回模式
	public static final String RETURN_MODEL_0 = "0";// 非负
	public static final String RETURN_MODEL_1 = "1";// 取反值
	public static final String RETURN_MODEL_2 = "2";// 取绝对值

	public static final String SLAVECONTNO = "slaveContno";// 取绝对值
	public static final String CUSTCD = "custcd";// 取绝对值
	public static final String MORTGAGELEVELONE = "mortgageLevelOne";// 取绝对值
	public static final String MORTGAGELEVELTWO = "mortgageLevelTwo";// 取绝对值

	@Resource(name = "ExtBPbcMtgBaseInfoDAO")
	ExtIBPbcMtgBaseInfoDAO extBPbcMtgBaseInfoDAO;

	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;

	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;

	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO bPbcMtgBaseInfoDAO;

	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bCrrGntyConDAO;

	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO bCntMprotBaseInfoDAO;

	@Resource(name = "BCntMprotDealInfoDAO")
	IBCntMprotDealInfoDAO bCntMprotDealInfoDAO;

	@Resource(name = "ExtBLanDAO")
	ExtBLanDAO extblandao;

	@Resource(name = "ExtSBcpAppliLowerPriceDAO")
	ExtSBcpAppliLowerPriceDAO extlowerpricedao;

	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO blanapplilncibasedao;
	//借据基本信息
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService bLanLnciBaseService;
	
	//业务申请信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;

 
	/**
	 * @Description: 获取可提货金额
	 * @param amountVO
	 * @return
	 * @throws ScubeBizException
	 */
	public BigDecimal getDelivery(AmountVO amountVO) throws ScubeBizException {
		String productId = amountVO.getProductId();// 供应链产品小类
		/*
		 * String midProductId = amountVO.getMidProductId();//供应链产品中类
		 * if(!StringUtils.isEmpty(productId) &&
		 * StringUtils.isEmpty(midProductId)){ midProductId =
		 * ProductService.getInstance().getParentIdById(productId); }
		 * amountVO.setMidProductId(midProductId);
		 */
		BPrdInfo bPrdInfo = new BPrdInfo();
		bPrdInfo.setProductId(productId);
		BPrdInfo info = bPrdInfoService.findBPrdInfoByKey(bPrdInfo);
		amountVO.setParentId(info.getParentId());
		BigDecimal amount = BigDecimal.ZERO;
		String bigProductId = info.getParentId();// 产品种类--产品大类：预付类
		// TODO
		if(ScfBasConstant.PRODUCT_TYPE_MORT.equals(bigProductId)){//动产		现货
			 amount=getTotalAmount(amountVO,CALCULATE_MODEL_1,RETURN_MODEL_0);
		}

		if(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(bigProductId)){//汽车货押
			 amount=getTotalAmount(amountVO,CALCULATE_MODEL_1,RETURN_MODEL_0);
		}
		if(ScfBasConstant.PRODUCT_TYPE_CAR_FIRST_PAY.equals(bigProductId)){//汽车先票后货
			amount=getTotalAmount(amountVO,CALCULATE_MODEL_1,RETURN_MODEL_0);
		}
		// 保兑仓 begin
		if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(bigProductId)) {
			if (ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(productId)) { // 小类担保提货-三方
				amount = getTotalAmount(amountVO, CALCULATE_MODEL_4, RETURN_MODEL_0);
			}
			if (ScfBasConstant.PRODUCT_TYPE_XPHH.endsWith(productId)) {// 小类先票款提货-四方
				if (ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE.equals(amountVO.getArrivedManageModel())) {// 单笔模式/一一对应
					amount = getTotalAmount(amountVO, CALCULATE_MODEL_4, RETURN_MODEL_0);
				} else {
					amount = getTotalAmount(amountVO, CALCULATE_MODEL_1, RETURN_MODEL_0);
				}
			}
		}

	/*	if(ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(amountVO.
		getMidProductId())){//三方保兑，四方保兑 TblProductWarehouse warehouse =
		SCFDAOUtils.getTblProductWarehouseDAO().get(productId);
		if(SCFConstants.WAREHOUSE_TYPE_THREE.equals(warehouse.
		getWarehouseType())){//三方
		amount=getTotalAmount(amountVO,CALCULATE_MODEL_4,RETURN_MODEL_0); }
		if(ScfBasConstant.WAREHOUSE_TYPE_FOUR.equals(warehouse.
		getWarehouseType())){//四方
		if(ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE.equals(amountVO.
		getArrivedManageModel())){// 单笔模式/一一对应
		amount=getTotalAmount(amountVO,CALCULATE_MODEL_4,RETURN_MODEL_0);
		}else{
		amount=getTotalAmount(amountVO,CALCULATE_MODEL_1,RETURN_MODEL_0); } }
		}*/
		
		// 保兑仓 end
		/*
		 * if(ScfBasConstant.PRODUCT_TYPE_BILL.equals(amountVO.getMidProductId()
		 * )){//仓单
		 * amount=getTotalAmount(amountVO,CALCULATE_MODEL_1,RETURN_MODEL_0); }
		 * if(ScfBasConstant.PRODUCT_TYPE_INDUSTRY_FINANCING.equals(amountVO.
		 * getMidProductId())){//行业金融
		 * amount=getTotalAmount(amountVO,CALCULATE_MODEL_1,RETURN_MODEL_0); }
		 */
		return amount;
	}

	/**
	 * @Description: 获取敞口
	 * @author lei.wang
	 * @Created 2012-10-19下午01:05:08
	 * @param amountVO
	 * @return
	 * @throws CommonException
	 */
	@Override
	public BigDecimal getPant(AmountVO amountVO) {
		String productId = amountVO.getProductId();// 供应链产品小类
		// String midProductId = amountVO.getMidProductId();//供应链产品中类
		BPrdInfo bPrdInfo = new BPrdInfo();
		bPrdInfo.setProductId(productId);
		BPrdInfo info = bPrdInfoService.findBPrdInfoByKey(bPrdInfo);
		amountVO.setParentId(info.getParentId());
		// if (!SCFDataFormat.isEmpty(productId) &&
		// SCFDataFormat.isEmpty(midProductId)) {
		// midProductId =
		// ProductService.getInstance().getParentIdById(productId);
		// amountVO.setMidProductId(midProductId);
		// }
		BigDecimal amount = getTotalAmount(amountVO, CALCULATE_MODEL_2, RETURN_MODEL_0);
		return amount;
	}

	/**
	 * @Description: 金额计算接口
	 * @author lei.wang
	 * @Created 2012-9-17下午04:41:37
	 * @param amountVO
	 * @param model
	 * @param returnModel
	 * @return
	 * @throws CommonException
	 */
	private BigDecimal getTotalAmount(AmountVO amountVO, String model, String returnModel) {
		if (model == null) {
			throw new ScubeBizException("计算模式丢失！");
			// ExceptionUtil.throwAppException("计算模式丢失！",
			// SCFErrorCode.ERROR_CODE_PARAM_NOT_EXIST);
		}
		// 3:加载金额
		amountVO = getAmountInfo(amountVO);
		// 4：计算金额
		BigDecimal amount = calculateAmount(amountVO, model);
		amount = calculate(amount, returnModel);
		return amount;
	}

	/**
	 * @Description: 封装金额信息
	 * @author lei.wang
	 * @Created 2012-9-18上午11:20:26
	 * @param amountVO
	 * @return
	 * @throws CommonException
	 */
	public AmountVO getAmountInfo(AmountVO amountVO) {
		if (amountVO.getLoadFlag()) {// 如果加载了数据就不再加载
			return amountVO;
		}
		if (ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE.equals(amountVO.getArrivedManageModel())) {// 单笔模式，封装借据信息
			amountVO = setLnciBaseInfo(amountVO);
		} else {// 池模式：封装金额信息
				// 封装抵质押合同基本信息
			amountVO = setProtocolBaseInfo(amountVO);
			// 获取借据金额信息
			BigDecimal lnciAmt = new BigDecimal("0.00");
			BigDecimal lnciBal = new BigDecimal("0.00");
			BigDecimal amountIn = new BigDecimal("0.00");
			BigDecimal amountOut = new BigDecimal("0.00");
			BigDecimal amountUpOut = new BigDecimal("0.00");
			List list = getKindsOfSum(amountVO.getSlaveContno(), amountVO.getProductId(), amountVO.getParentId());
			List flowList = getFlowKindsOfSum(amountVO.getSlaveContno(), amountVO.getProductId(),
					amountVO.getParentId());
			if (list != null && list.size() > 0) {
				// Object[] obj=(Object[]) list.get(0);
				HashMap<String, Object> obj = (HashMap<String, Object>) list.get(0);
				// 获取融资金额
				// lnciAmt=(BigDecimal)(obj[0]==null?new
				// BigDecimal("0.00"):obj[0]);
				lnciAmt = (BigDecimal) (obj.get("lnciAmt") == null ? new BigDecimal("0.00") : obj.get("lnciAmt"));
				// 获取融资余额
				// lnciBal=(BigDecimal)(obj[1]==null?new
				// BigDecimal("0.00"):obj[1]);
				lnciBal = (BigDecimal) (obj.get("lnciBal") == null ? new BigDecimal("0.00") : obj.get("lnciBal"));
				// 获取剩余提货金额
				// amountIn=(BigDecimal)(obj[2]==null?new
				// BigDecimal("0.00"):obj[2]);
				amountIn = (BigDecimal) (obj.get("amountIn") == null ? new BigDecimal("0.00") : obj.get("amountIn"));
				// 获取累计提货金额
				// amountOut=(BigDecimal)(obj[3]==null?new
				// BigDecimal("0.00"):obj[3]);
				amountOut = (BigDecimal) (obj.get("amountOut") == null ? new BigDecimal("0.00") : obj.get("amountOut"));
				// 向核心厂商提货金额
				// amountUpOut=(BigDecimal)(obj[4]==null?new
				// BigDecimal("0.00"):obj[4]);
				amountUpOut = (BigDecimal) (obj.get("amountUpOut") == null ? new BigDecimal("0.00")
						: obj.get("amountUpOut"));
			}
			// 池模式要增加流程中的放款流程敞口计算 add by xiaolong.xiong 2013-09-27
			if (flowList != null && flowList.size() > 0) {
				HashMap<String, Object> map = (HashMap<String, Object>) flowList.get(0);
				// BigDecimal amt = (BigDecimal) (flowList.get(0) == null ?
				// BigDecimal.ZERO : flowList.get(0));
				BigDecimal amt = (BigDecimal) (map.get("lnciAmt") == null ? BigDecimal.ZERO : map.get("lnciAmt"));
				lnciAmt = lnciAmt.add(amt);
				lnciBal = lnciBal.add(amt);
			}
			// 获取保证金及现金等价物信息
			amountVO = setBailAmount(amountVO);
			// 获取质押合同下的押品价值
			BigDecimal totPirce = getMortAmtBySlaveContNo(amountVO.getSlaveContno(), amountVO.getParentId());
			amountVO.setTotPrice(totPirce);
			// 获取质物价值
			BigDecimal mortAmount = getMortAmountByProtocolNo(amountVO);
			amountVO.setLnciBal(lnciBal);
			amountVO.setLnciAmt(lnciAmt);
			amountVO.setAmountIn(amountIn);
			amountVO.setAmountOut(amountOut);
			amountVO.setAmountUpOut(amountUpOut);
			amountVO.setMortAmount(mortAmount);
			amountVO.setLoadFlag(true);
			return amountVO;
		}
		return amountVO;
	}

	/**
	 * @Description: 获取抵质押合同下的押品总价值
	 * @author lei.wang
	 * @Created 2012-9-18下午03:22:35
	 * @param protocolNo
	 * @param productId
	 * @return
	 */
	@Override
	public BigDecimal getMortAmtBySlaveContNo(String slaveContno, String midProductId) {
		BigDecimal amount = new BigDecimal(0);
		// 动产融资,标准仓单,b2b融资,非标准仓单
		if (ScfBasConstant.PRODUCT_TYPE_MORT.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_BILL.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId)) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(SLAVECONTNO, slaveContno);
			List price = extlowerpricedao.queryMtgTotalPrice(map);
			if (price.size() > 0) {
				HashMap<String, Object> pricemap = (HashMap<String, Object>) price.get(0);
				amount = (BigDecimal) pricemap.get("mortAmount");
			}
			return (amount == null ? new BigDecimal(0) : amount.setScale(2, BigDecimal.ROUND_DOWN));
		}
		// 预付款
		if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(midProductId)) {
			// amount =
			// SCFDAOUtils.getTblMortgageBaseInfoDAO().getSumPriceByParam(slaveContno,null,null,null);
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(SLAVECONTNO, slaveContno);
			List price = extlowerpricedao.queryMtgTotalPrice(map);
			if (price.size() > 0) {
				HashMap<String, Object> pricemap = (HashMap<String, Object>) price.get(0);
				amount = (BigDecimal) pricemap.get("mortAmount");
			}
			return (amount == null ? new BigDecimal(0) : amount.setScale(2, BigDecimal.ROUND_DOWN));
		}
		// 行业金融
		if (ScfBasConstant.PRODUCT_TYPE_INDUSTRY_FINANCING.equals(midProductId)) {
			// amount =
			// SCFDAOUtils.getTblMortgageBaseInfoDAO().getSumPriceByParam(slaveContno,null,null,null);
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(SLAVECONTNO, slaveContno);
			List price = extlowerpricedao.queryMtgTotalPrice(map);
			if (price.size() > 0) {
				HashMap<String, Object> pricemap = (HashMap<String, Object>) price.get(0);
				amount = (BigDecimal) pricemap.get("mortAmount");
			}
			return (amount == null ? new BigDecimal(0) : amount.setScale(2, BigDecimal.ROUND_DOWN));
		}
		return amount;
	}

	/**
	 * @Description: 获取协议下的质押价值
	 * @author lei.wang
	 * @Created 2012-9-18下午03:37:35
	 * @param amountVO
	 * @return
	 * @throws CommonException
	 * @throws CommonException
	 */
	private BigDecimal getMortAmountByProtocolNo(AmountVO amountVO) {
		String midProductId = amountVO.getParentId();// 产品大类
		// String slaveContno = amountVO.getSlaveContno();//抵质押合同号
		// BigDecimal amount=getMortAmtBySlaveContNo(slaveContno,midProductId);
		BigDecimal amount = amountVO.getTotPrice();
		if (ScfBasConstant.PRODUCT_TYPE_MORT.equals(midProductId)) {// 动产融资
			// if(DataFormat.isEmpty(amountVO.getMoniType())){
			// ExceptionUtil.throwAppException("监管模式参数不存在！",
			// SCFErrorCode.ERROR_CODE_PARAM_NOT_EXIST);
			// }
			if (ScfBasConstant.MONI_MODEL_DYNAMIC.equals(amountVO.getMoniType())) {
				BigDecimal totPrice = amountVO.getLowPriceNew() == null ? new BigDecimal(0) : amountVO.getLowPriceNew();
				// modified by hong.xu 2013-1-22
				// 动产融资动态放款时可融资金额取监管下限和押品中的较小者乘以融资比例 start
				// 这样处理是因为如果协议有监管下限而没有做出质入库的话不允许融资放款
				BigDecimal totGagePrice = amountVO.getTotPrice();// 协议下押品总价值
				if (totGagePrice.compareTo(totPrice) < 0) {
					totPrice = totGagePrice;
				}
				// modified by hong.xu 2013-1-22
				// 动产融资动态放款时可融资金额取监管下限和押品中的较小者乘以融资比例 end
				BigDecimal ration = amountVO.getLoanPercent() == null ? new BigDecimal(100) : amountVO.getLoanPercent();
				return totPrice.multiply(ration).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN);
			}
			if (ScfBasConstant.MONI_MODEL_STATIC.equals(amountVO.getMoniType())) {
				BigDecimal ration = amountVO.getLoanPercent() == null ? new BigDecimal(100) : amountVO.getLoanPercent();
				return amount.multiply(ration).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN);
			}
		}

		// 增加汽车货押的处理 add by fengjinfu 2013-10-22
		if (ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId)) {// 汽车货押
			if (ScfBasConstant.MONI_MODEL_STATIC.equals(amountVO.getMoniType())) {
				BigDecimal ration = amountVO.getLoanPercent() == null ? new BigDecimal(100) : amountVO.getLoanPercent();
				return amount.multiply(ration).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN);
			}
		}
		if (ScfBasConstant.PRODUCT_TYPE_BILL.equals(midProductId)) {// 标准仓单，非标准仓单
			BigDecimal ration = amountVO.getLoanPercent() == null ? new BigDecimal(100) : amountVO.getLoanPercent();
			return amount.multiply(ration).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN);
		}
		if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(midProductId)) {// 预付款
			BigDecimal ration = amountVO.getLoanPercent() == null ? new BigDecimal(100) : amountVO.getLoanPercent();
			return amount.multiply(ration).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN);
		}
		if (ScfBasConstant.PRODUCT_TYPE_INDUSTRY_FINANCING.equals(midProductId)) {// 行业金融
			BigDecimal ration = amountVO.getLoanPercent() == null ? new BigDecimal(100) : amountVO.getLoanPercent();
			return amount.multiply(ration).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN);
		}
		return amount;
	}

	/**
	 * @Description: 封装保证金信息
	 * @author lei.wang
	 * @Created 2012-10-12下午01:29:35
	 * @param amountVO
	 * @return
	 * @throws HibernateException
	 * @throws CommonException
	 */
	public AmountVO setBailAmount(AmountVO amountVO) {
		List bailList = new ArrayList();
		List flowBailList = new ArrayList();
		if (ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE.equals(amountVO.getArrivedManageModel())) {// 单笔模式
			// 借据下保证金及现金等价物金额
			// bailList=DAOUtils.getTblCustAccountBussInfoDAO().getAccountListByParam(amountVO.getSlaveContno(),String.valueOf(amountVO.getDebetNo()));
			// bailList=SCFDAOUtils.getTblLnciBaseInfoDAO().queryAmountByDebetNo(amountVO.getSlaveContno(),String.valueOf(amountVO.getDebetNo()));
			BLanLnciBase bean = new BLanLnciBase();
			bean.setState(ScfBasConstant.FLAG_ON);
			bean.setDebetNo(amountVO.getDebetNo());
			bailList = extblandao.queryAmountByDebetNo(bean);
		} else {
			// 质押合同项下保证金及现金等价物金额
			bailList = getAccountListByParam(amountVO);
			flowBailList = getFlowBailInfoListByParam(amountVO);
		}
		Iterator iter = bailList.iterator();
		Iterator flowIter = flowBailList.iterator();
		BigDecimal bailInit = BigDecimal.ZERO;// 初始保证金
		BigDecimal bailRefund = BigDecimal.ZERO;// 追加保证金
		BigDecimal cashInit = BigDecimal.ZERO;// 初始现金等价物
		BigDecimal cashRefund = BigDecimal.ZERO;// 追加现金等价物
		BigDecimal maxBail = BigDecimal.ZERO;// 最高额

		while (iter.hasNext()) {
			// Object[] obj = (Object[])iter.next();
			// bailInit = obj[0]==null?BigDecimal.ZERO:new
			// BigDecimal(obj[0].toString());
			// bailRefund = obj[1]==null?BigDecimal.ZERO:new
			// BigDecimal(obj[1].toString());
			// cashInit = obj[2]==null?BigDecimal.ZERO:new
			// BigDecimal(obj[2].toString());
			// cashRefund = obj[3]==null?BigDecimal.ZERO:new
			// BigDecimal(obj[3].toString());
			HashMap<String, Object> obj = (HashMap<String, Object>) iter.next();
			bailInit = obj.get("bailAmount") == null ? BigDecimal.ZERO
					: new BigDecimal(obj.get("bailAmount").toString());
			bailRefund = obj.get("addBailAmount") == null ? BigDecimal.ZERO
					: new BigDecimal(obj.get("addBailAmount").toString());
			cashInit = obj.get("initCashEqtAmt") == null ? BigDecimal.ZERO
					: new BigDecimal(obj.get("initCashEqtAmt").toString());
			cashRefund = obj.get("addCashEqtAmt") == null ? BigDecimal.ZERO
					: new BigDecimal(obj.get("addCashEqtAmt").toString());
			amountVO.setBailInit(bailInit);// 初始保证金
			amountVO.setBailRefund(bailRefund);// 追加保证金
			amountVO.setCashInit(cashInit);// 初始等价物
			amountVO.setCashRefund(cashRefund);// 追加等价物
		}

		// 流程中的保证金及现金等价物信息也要统计在内 add by xiaolong.xiong 2013-09-29
		while (flowIter.hasNext()) {
			// Object[] flowObj = (Object[])flowIter.next();
			// BigDecimal flowbailInit = flowObj[0]==null?BigDecimal.ZERO:new
			// BigDecimal(flowObj[0].toString());
			// BigDecimal flowcashInit = flowObj[1]==null?BigDecimal.ZERO:new
			// BigDecimal(flowObj[1].toString());
			HashMap<String, Object> flowObj = (HashMap<String, Object>) flowIter.next();
			BigDecimal flowbailInit = flowObj.get("bailAmount") == null ? BigDecimal.ZERO
					: new BigDecimal(flowObj.get("bailAmount").toString());
			BigDecimal flowcashInit = flowObj.get("initCashEqtAmt") == null ? BigDecimal.ZERO
					: new BigDecimal(flowObj.get("initCashEqtAmt").toString());
			bailInit = bailInit.add(flowbailInit);
			cashInit = cashInit.add(flowcashInit);
			// amountVO.setBailInit(flowbailInit.add(amountVO.getBailInit()));//初始保证金
			// amountVO.setCashInit(flowcashInit.add(amountVO.getCashInit()));//初始等价物

		}

		// amountVO.setMaxBailAmount(maxBail);//最高额(目前没有最高额)
		amountVO.setBailAmount(bailInit.add(bailRefund).add(maxBail));// 保证金金额
		amountVO.setCashAmount(cashInit.add(cashRefund));// 等价物
		amountVO.setInitAmount(bailInit.add(cashInit));// 初始保证金及现金等价物
		amountVO.setRefundAmount(bailRefund.add(cashRefund));// 追加保证金及等价物
		amountVO.setAccountAmount(amountVO.getBailAmount().add(amountVO.getCashAmount()));
		return amountVO;
	}

	/**
	 * @Description: 获取抵质押合同下保证金列表
	 * @author lei.wang
	 * @Created 2012-10-12下午03:38:00
	 * @param amountVO
	 * @return
	 */
	public List getAccountListByParam(AmountVO amountVO) {
		// 动产、汽车货押、先票款后货、仓单
		String midProductId = amountVO.getParentId();
		if (ScfBasConstant.PRODUCT_TYPE_MORT.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_BILL.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_PREP.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_CAR_FIRST_PAY.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_INDUSTRY_FINANCING.equals(midProductId)) {
			BLanLnciBase bean = new BLanLnciBase();
			bean.setState(ScfBasConstant.FLAG_ON);
			bean.setDebetNo(amountVO.getDebetNo());
			bean.setSlaveContno(amountVO.getSlaveContno());//增加一个条件，通过抵质押合同查询
			List list = extblandao.queryAmountByDebetNo(bean);
			return list;
		}
		return new ArrayList();
	}

	/**
	 * @Description: 统计流程中的保证金及现金等价物汇总信息
	 * @author xiaolong.xiong
	 * @Created 2013-9-29上午9:49:01
	 * @param amountVO
	 * @return
	 * @throws HibernateException
	 * @throws CommonException
	 */
	public List getFlowBailInfoListByParam(AmountVO amountVO) {
		// 动产、汽车货押、先票款后货、仓单
		String midProductId = amountVO.getParentId();
		List list = new ArrayList();
		if (ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_BILL.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_CAR_FIRST_PAY.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_INDUSTRY_FINANCING.equals(midProductId)) {
			BPbcAppliBaseInfo bean = new BPbcAppliBaseInfo();
			bean.setSlaveContno(amountVO.getSlaveContno());
			bean.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
			list = extblandao.queryFlowBailInfoByBussinessNo(bean);
		} else if (ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(midProductId)) {// 先票款后货
			// 先票款后货信贷合同的业务合同号是先票款后货协议 add by xiaolong.xiong 2013-09-29
			BCrrGntyCon contSlaveInfo = bCrrGntyConDAO.selectByPrimaryKey(amountVO.getSlaveContno());
			BCntMprotBaseInfo moniCont = bCntMprotBaseInfoDAO.selectByPrimaryKey(contSlaveInfo.getPrtclNo());
			if (moniCont != null) {
				BPbcAppliBaseInfo bean = new BPbcAppliBaseInfo();
				bean.setSlaveContno(moniCont.getOtherprotocolNo());
				bean.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
				list = extblandao.queryFlowBailInfoByBussinessNo(bean);
				// list =
				// SCFDAOUtils.getTblAppliLnciBaseInfoDAO().queryFlowBailInfoByBussinessNo(moniCont.getOtherprotocolNo());
			}
		}
		return list;
	}

	/**
	 * @Description: 获取协议下的融资金额，余额，剩余提货金额，累计提货金额
	 * @author lei.wang
	 * @Created 2012-10-11下午05:46:46
	 * @param protocolNo
	 * @param productId
	 * @return
	 * @throws CommonException
	 */
	public List getKindsOfSum(String slaveContno, String productId, String midProductId) {
		// 动产,标准仓单,b2b融资,非标准仓单,三方保兑,四方保兑,订单融资,行业金融
		if (ScfBasConstant.PRODUCT_TYPE_MORT.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_BILL.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_PREP.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_INDUSTRY_FINANCING.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_CAR_FIRST_PAY.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId)) {
			// List list =
			// SCFDAOUtils.getTblLnciBaseInfoDAO().getKindsOfSum(slaveContno);
			BLanLnciBase bean = new BLanLnciBase();
			bean.setSlaveContno(slaveContno);
			bean.setState(ScfBasConstant.FLAG_ON);
			bean.setIsSettle(ScfBasConstant.FLAG_OFF);
			List list = extblandao.querySum(bean);
			return list;
		}
		return new ArrayList();
	}

	/**
	 * @Description: 获取质押合同下流程中的融资金额，余额
	 * @author xiaolong.xiong
	 * @Created 2013-9-27上午11:29:46
	 * @param slaveContno
	 * @param productId
	 * @param midProductId
	 * @return
	 */
	public List getFlowKindsOfSum(String slaveContno, String productId, String midProductId) {
		// 动产、仓单、保兑仓、行业金融、汽车货押
		if (ScfBasConstant.PRODUCT_TYPE_MORT.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_BILL.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_PREP.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_INDUSTRY_FINANCING.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_CAR_FIRST_PAY.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId)) {
			// List list =
			// SCFDAOUtils.getTblAppliLnciBaseInfoDAO().getFlowKindsOfSum(slaveContno);
			BPbcAppliBaseInfo bean = new BPbcAppliBaseInfo();
			bean.setSlaveContno(slaveContno);
			bean.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
			List list = extblandao.queryLnciAmt(bean);
			return list;
		}
		return new ArrayList();
	}

	/**
	 * @Description: 抵质押合同基本信息
	 * @author lei.wang
	 * @Created 2012-9-18下午04:59:41
	 * @param amountVO
	 * @return
	 * @throws CommonException
	 */
	public AmountVO setProtocolBaseInfo(AmountVO amountVO) {
		// 校验基本数据
		initCheck(amountVO);
		// String productId = amountVO.getProductId();//产品类型
		String parentId = amountVO.getParentId();// 产品大类
		String slaveContno = amountVO.getSlaveContno();// 抵质押合同号
		if (ScfBasConstant.PRODUCT_TYPE_MORT.equals(parentId) || ScfBasConstant.PRODUCT_TYPE_BILL.equals(parentId)
				|| ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(parentId)) {// 现货类
			BCrrGntyCon bean = bCrrGntyConDAO.selectByPrimaryKey(slaveContno);

			if (StringUtil.isStrNotEmpty(bean.getPrtclNo())) {
				BCntMprotBaseInfo bmbi = bCntMprotBaseInfoDAO.selectByPrimaryKey(bean.getPrtclNo());
				if (null != bmbi) {
					if (StringUtil.isEmpty(amountVO.getArrivedManageModel())) {// 货物管理模式
						amountVO.setArrivedManageModel(bmbi.getArrivedManageMode());
					}
				}

			}
			/*String moniType = "";
			if(bean.getVidPrdId().equals(ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL))
			{
				moniType = ScfBasConstant.MONI_MODEL_STATIC;
			}
			amountVO.setMoniType(moniType);// 监管模式*/
			amountVO.setLoanPercent(bean.getRation());// 质押率
			amountVO.setMoniType(bean.getMoniMd());// 监管模式
			amountVO.setLowPriceNew(bean.getLowPriceNew());// 质物最低价值
			return amountVO;
		} else if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(parentId)
				&& !(ScfBasConstant.PRODUCT_TYPE_DDRZ.equals(amountVO.getProductId()))) {// 保兑协议
			BCrrGntyCon bean = bCrrGntyConDAO.selectByPrimaryKey(slaveContno);
			if (bean != null) {
				BCntMprotBaseInfo bmbi = bCntMprotBaseInfoDAO.selectByPrimaryKey(bean.getPrtclNo());
				// System.out.println(tblMutiProtBaseInfo.getProtocolNo());
				if (bmbi != null) {
					BCntMprotDealInfo cmdi = bCntMprotDealInfoDAO.selectByPrimaryKey(bmbi.getOtherprotocolNo());
					if (cmdi != null) {
						amountVO.setDeliveryModel(cmdi.getFirstBailType());// 提货模式
						amountVO.setFirstBailRatio(cmdi.getFirstBailRatio());// 保证金比例
						amountVO.setLoanPercent(bean.getRation());// 质押率
						if (StringUtil.isEmpty(amountVO.getArrivedManageModel())) {// 货物管理模式
							amountVO.setArrivedManageModel(cmdi.getArrivedManageMode());
						}
					}
				}
			}
			return amountVO;
		} else if (ScfBasConstant.PRODUCT_TYPE_INDUSTRY_FINANCING.equals(parentId)) {// 行业金融
			// TblContSlaveInfo bean =
			// DAOUtils.getTblContSlaveInfoDAO().get(slaveContno);
			// TblContBaseInfo tblContBaseInfo =
			// DAOUtils.getTblContBaseInfoDAO().get(bean.getMastContno());
			// TblMutiProtAutoInfo tblMutiProtAutoInfo =
			// DAOUtils.getTblMutiProtAutoInfoDAO().get(tblContBaseInfo.getProtocolNo());
			// amountVO.setDeliveryModel(tblMutiProtAutoInfo.getFirstBailType());//提货模式
			// amountVO.setFirstBailRatio(tblMutiProtAutoInfo.getFirstBailRatio());//保证金比例
			// amountVO.setLoanPercent(bean.getRation());
			return amountVO;
		}
		return amountVO;
	}

	/**
	 * @Description: 借据相关信息
	 * @author lei.wang
	 * @Created 2012-9-19下午02:33:58
	 * @param amountVO
	 * @return
	 * @throws CommonException
	 */
	private AmountVO setLnciBaseInfo(AmountVO amountVO) {
		String midProductId = amountVO.getParentId();// 产品大类
		String debetNo = amountVO.getDebetNo();// 借据信息
		// 三方保兑协议，四方保兑协议,订单融资
		if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(midProductId)
				&& !(ScfBasConstant.PRODUCT_TYPE_DDRZ.equals(amountVO.getProductId()))) {
			if (debetNo != null) {
				// BLanLnciBase bean
				// =bLanLnciBaseDAO.findBLanLnciBaseByDebtId(debetNo);
				BLanLnciBase bean = bLanLnciBaseDAO.selectByPrimaryKey(debetNo);
				if (bean != null) {
					BCntMprotDealInfo cmdi = bCntMprotDealInfoDAO.selectByPrimaryKey(bean.getProtocolNo());
					amountVO.setLnciAmt(bean.getLnciAmt());// 融资金额
					amountVO.setLnciBal(bean.getLnciBal());// 融资余额
					amountVO.setAmountIn(bean.getAmountIn());// 剩余提货金额
					amountVO.setAmountOut(bean.getAmountOut());// 累计提货金额
					amountVO.setFirstBailRatio(bean.getFirstBailRatio());// 初始保证金比例
					if (cmdi != null) {
						amountVO.setDeliveryModel(cmdi.getFirstBailType());// 提货模式
					}
					BPbcAppliBaseInfo appbase = bPbcAppliBaseInfoDAO.selectByPrimaryKey(bean.getAppno());
					if (appbase.getChannelFlag() != null
							&& appbase.getChannelFlag().equals(ScfBasConstant.CHANNEL_FLAG_IFSP)) {
						if (amountVO.getLnciType() != null
								&& amountVO.getLnciType().equals(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL)) {// 流贷
							amountVO.setOwnFundPayAmt(bean.getOwnFundPayAmt());// 自有资金
						}
					}
					// 获取保证金及现金等价物信息
					amountVO = this.setBailAmount(amountVO);
					amountVO.setLoadFlag(true);
					return amountVO;
				}
			}
		}
		amountVO.setBailInit(BigDecimal.ZERO);// 初始保证金
		amountVO.setBailRefund(BigDecimal.ZERO);// 追加保证金
		amountVO.setCashInit(BigDecimal.ZERO);// 初始等价物
		amountVO.setCashRefund(BigDecimal.ZERO);// 追加等价物
		amountVO.setMaxBailAmount(BigDecimal.ZERO);// 最高额
		amountVO.setBailAmount(BigDecimal.ZERO);// 保证金金额
		amountVO.setCashAmount(BigDecimal.ZERO);// 现价等价物
		amountVO.setLnciAmt(BigDecimal.ZERO);// 融资金额
		amountVO.setLnciBal(BigDecimal.ZERO);// 融资余额
		amountVO.setAccountAmount(BigDecimal.ZERO);// 保证金及现金等价物总和
		amountVO.setAmountIn(BigDecimal.ZERO);// 剩余提货金额
		amountVO.setAmountOut(BigDecimal.ZERO);// 累计提货金额
		amountVO.setFirstBailRatio(BigDecimal.ZERO);// 初始保证金比例
		amountVO.setLoadFlag(true);
		return amountVO;
	}

	/**
	 * @Description: 计算金额
	 * @author lei.wang
	 * @Created 2012-9-17下午05:37:05
	 * @param amountVO
	 * @return
	 * @throws CommonException
	 */
	private BigDecimal calculateAmount(AmountVO amountVO, String model) {
		BigDecimal money = new BigDecimal("0");
		// 2：根据计算模式的不同计算金额
		if (CALCULATE_MODEL_1.equals(model)) {
			// 计算公式：现金等价物-敞口
			return calculateDynamicDelivery(amountVO);
		} else if (CALCULATE_MODEL_2.equals(model)) {
			// 计算方式:融资余额-保证金总额-现金等价物总额
			return calculateSlave(amountVO);
		} else if (CALCULATE_MODEL_3.equals(model)) {
			// 计算方式:融资余额-保证金总额-现金等价物总额-质押物价值
			return calculatePant(amountVO);
		} else if (CALCULATE_MODEL_4.equals(model)) {// 可提货金额(含有提货规则的)
			if (StringUtil.isEmpty(amountVO.getDeliveryModel())) {
				throw new ScubeBizException("提货规则参数不存在！");
				// ExceptionUtil.throwAppException("提货规则参数不存在！",
				// SCFErrorCode.ERROR_CODE_PARAM_NOT_EXIST);
			}
			return calculateDelivery(amountVO);
		} else if (CALCULATE_MODEL_5.equals(model)) {// 可融资金额
			return calculateLoan(amountVO);
		}
		return money;
	}

	/**
	 * @Description: 计算敞口金额 计算公式：融资余额-保证金-现金等价物
	 * @author lei.wang
	 * @Created 2012-10-11下午01:37:51
	 * @param amountVO
	 * @return
	 * @throws CommonException
	 */
	private BigDecimal calculateSlave(AmountVO amountVO) throws ScubeBizException {
		BigDecimal lnciBal = amountVO.getLnciBal() == null ? new BigDecimal(0) : amountVO.getLnciBal();// 融资余额
		BigDecimal accountAmount = amountVO.getAccountAmount() == null ? new BigDecimal(0)
				: amountVO.getAccountAmount();// 保证金及等价物总和
		BigDecimal addBailAmount = amountVO.getAddBailAmount() == null ? BigDecimal.ZERO : amountVO.getAddBailAmount();// 业务流程中追加的保证金
		BigDecimal money = new BigDecimal(0.00);
		// ifsp流贷对敞口和剩余可提货金额的处理
		if (amountVO.getDebetNo() != null) {
			// TblLnciBaseInfo bean
			// =SCFDAOUtils.getTblLnciBaseInfoDAO().get(amountVO.getDebetNo());
			BLanLnciBase bean = bLanLnciBaseDAO.selectByPrimaryKey(amountVO.getDebetNo());
			if (bean != null) {
				// TblAppliBaseInfo
				// appbase=SCFDAOUtils.getTblAppliBaseInfoDAO().get(bean.getAppno());
				BPbcAppliBaseInfo appbase = bPbcAppliBaseInfoDAO.selectByPrimaryKey(bean.getAppno());

				money = lnciBal.subtract(accountAmount).subtract(addBailAmount);

				if (appbase.getChannelFlag() != null
						&& appbase.getChannelFlag().equals(ScfBasConstant.CHANNEL_FLAG_IFSP)) {// ifsp流贷,敞口需加上自有资金的处理
					if (amountVO.getLnciType() != null && amountVO.getLnciType().equals("01")) {// 流贷
						BigDecimal ownfundmat = amountVO.getOwnFundPayAmt() == null ? BigDecimal.ZERO
								: amountVO.getOwnFundPayAmt();
						money = money.add(ownfundmat);
					}
				}
			} else {
				money = lnciBal.subtract(accountAmount).subtract(addBailAmount);
			}
		} else {
			money = lnciBal.subtract(accountAmount).subtract(addBailAmount);
		}
		return money;
	}

	/**
	 * @Description: 根据返回值的不同返回不同的结果
	 * @author lei.wang
	 * @Created 2012-9-17下午04:41:59
	 * @param amountVO
	 * @return
	 * @throws CommonException
	 */
	private BigDecimal calculate(BigDecimal money, String returnModel) {
		// 根据返回值的不同返回不同的结果
		if (RETURN_MODEL_0.equals(returnModel))
			return (money.floatValue() < 0 ? new BigDecimal(0) : money);
		if (RETURN_MODEL_1.equals(returnModel))
			return money.negate();
		if (RETURN_MODEL_2.equals(returnModel))
			return money.abs();
		return money;
	}

	/**
	 * @Description: 检验类基本参数是否全
	 * @author lei.wang
	 * @Created 2012-9-18上午11:21:30
	 * @param amountVO
	 * @throws CommonException
	 */
	private void initCheck(AmountVO amountVO) throws ScubeBizException {
		String productId = amountVO.getProductId();// 产品类型
		String midProductId = amountVO.getParentId();// 产品中类
		if (StringUtil.isEmpty(productId) && StringUtil.isEmpty(midProductId)) {
			throw new ScubeBizException("产品类型丢失！");
		}
		String slaveContno = amountVO.getSlaveContno();// 抵质押合同号
		if (StringUtil.isEmpty(slaveContno)) {
			throw new ScubeBizException("抵质押合同号丢失！");
		}
	}

	/**
	 * @Description: 动产(可提货金额)
	 * @author lei.wang
	 * @Created 2012-10-15下午03:38:46
	 * @param amountVO
	 * @return
	 * @throws CommonException
	 */
	private BigDecimal calculateDynamicDelivery(AmountVO amountVO) throws ScubeBizException {
		BigDecimal money = new BigDecimal(0.00);
		BigDecimal loanPercent = amountVO.getLoanPercent() == null ? new BigDecimal(0) : amountVO.getLoanPercent();// 质物率
		BigDecimal mortAmount = amountVO.getMortAmount() == null ? new BigDecimal(0) : amountVO.getMortAmount();// 质物价值
		// 判断敞口
		BigDecimal pant = this.calculateAmount(amountVO, CALCULATE_MODEL_2);
		if (pant.compareTo(new BigDecimal(0)) != 1) {// 敞口小于等于0，可以全部提货
			return amountVO.getTotPrice();
		}
		// BigDecimal
		// amount=this.calculate(amountVO,SCFConstants.CALCULATE_MODEL_3,SCFConstants.RETURN_MODEL_1);
		BigDecimal amount = mortAmount.subtract(pant);
		money = amount.multiply(new BigDecimal(100)).divide(loanPercent, 10, BigDecimal.ROUND_DOWN);
		return money;
	}

	/**
	 * @Description: 计算敞口金额（不含押品）计算公式：融资金额-保证金-现金等价物-押品价值
	 * @author lei.wang
	 * @Created 2012-10-11下午01:37:59
	 * @param amountVO
	 * @return
	 */
	private BigDecimal calculatePant(AmountVO amountVO) {
		BigDecimal lnciBal = amountVO.getLnciBal() == null ? new BigDecimal(0) : amountVO.getLnciBal();// 融资余额
		BigDecimal mortAmount = amountVO.getMortAmount() == null ? new BigDecimal(0) : amountVO.getMortAmount();// 质物价值
		BigDecimal accountAmount = amountVO.getAccountAmount() == null ? new BigDecimal(0)
				: amountVO.getAccountAmount();// 保证金及等价物总和
		BigDecimal money = lnciBal.subtract(accountAmount).subtract(mortAmount);
		return money;
	}

	/**
	 * @Description: 计算可以提货金额
	 * @author lei.wang
	 * @Created 2012-10-11下午01:37:39
	 * @param amountVO
	 * @return
	 * @throws CommonException
	 */
	private BigDecimal calculateDelivery(AmountVO amountVO) throws ScubeBizException {
		BigDecimal money = new BigDecimal(0.00);
		// 1：预处理金额
		BigDecimal deliveriedAmount = amountVO.getAmountOut() == null ? new BigDecimal(0) : amountVO.getAmountOut();// 累计提货金额
		// BigDecimal amountIn=amountVO.getAmountIn()== null ? new BigDecimal(0)
		// : amountVO.getAmountIn();//可提货金额
		BigDecimal percent = amountVO.getFirstBailRatio() == null ? new BigDecimal(0) : amountVO.getFirstBailRatio();// 初始保证金比例
		BigDecimal lnciAmt = amountVO.getLnciAmt() == null ? new BigDecimal(0) : amountVO.getLnciAmt();// 出账总金额
		String deliveryModel = amountVO.getDeliveryModel();// 提货方式

		BigDecimal initAmount = amountVO.getInitAmount() == null ? BigDecimal.ZERO : amountVO.getInitAmount();// 初始保证金及现金等价物金额
		BigDecimal refundAmount = amountVO.getRefundAmount() == null ? BigDecimal.ZERO : amountVO.getRefundAmount();// 追加保证金及现金等价物金额
		BigDecimal addBailAmount = amountVO.getAddBailAmount() == null ? BigDecimal.ZERO : amountVO.getAddBailAmount();//// 流程中追加的保证金
		BigDecimal ownFundPayAmt = amountVO.getOwnFundPayAmt() == null ? BigDecimal.ZERO : amountVO.getOwnFundPayAmt();//// 自有资金
		// TblLnciBaseInfo bean
		// =SCFDAOUtils.getTblLnciBaseInfoDAO().get(amountVO.getDebetNo());
		// TblAppliBaseInfo
		// appbase=SCFDAOUtils.getTblAppliBaseInfoDAO().get(bean.getAppno());
		BLanLnciBase bean = bLanLnciBaseDAO.selectByPrimaryKey(amountVO.getDebetNo());
		BPbcAppliBaseInfo appbase = bPbcAppliBaseInfoDAO.selectByPrimaryKey(bean.getAppno());
		refundAmount = refundAmount.add(addBailAmount);
		//refundAmount = refundAmount.add(addBailAmount);
		// 判断敞口
		BigDecimal pant = this.calculateAmount(amountVO, CALCULATE_MODEL_2);
		/*
		 * if(pant.compareTo(new BigDecimal(0))!=1){//敞口小于等于0，可以全部提货 return
		 * amountIn; }
		 */
		if (appbase.getChannelFlag() != null && appbase.getChannelFlag().equals(ScfBasConstant.CHANNEL_FLAG_IFSP)) {// ifsp流贷可提货需加上自有资金处理方式
			if (amountVO.getLnciType() != null && amountVO.getLnciType().equals("01")) {
				money = money.add(ownFundPayAmt);
			}
		}
		if (ScfBasConstant.TRI_DELIVERY_RULE_ALL.equals(deliveryModel)) {// 首笔可全额提货
			// 本次可提货金额 = 初始保证金及等价物金额 + 追加保证金及等价物金额 – 已累计提货金额
			money = initAmount.add(refundAmount).subtract(deliveriedAmount);
			// 计算方式:本次可提货金额=出账金额-敞口余额-累计提货金额
			// money= lnciAmt.subtract(pant).subtract(deliveriedAmount);
			return money;
		}
		if (appbase.getChannelFlag() != null && appbase.getChannelFlag().equals(ScfBasConstant.CHANNEL_FLAG_IFSP)) {// ifsp流贷可提货需加上自有资金处理方式
			if (amountVO.getLnciType() != null && amountVO.getLnciType().equals("01")) {
				money = money.add(ownFundPayAmt);
			}
		}
		if (ScfBasConstant.TRI_DELIVERY_RULE_NONE.equals(deliveryModel)) {// 首笔按比例
			// 本次可提货金额 = 追加保证金及等价物金额/(1-初始自有资金比例) – 已累计提货金额
			money = refundAmount.multiply(new BigDecimal(100))
					.divide(new BigDecimal(100).subtract(percent), 2, BigDecimal.ROUND_UP).subtract(deliveriedAmount);

			// 计算方式:本次可提货金额=出账金额-敞口余额/敞口率-累计提货金额
			// money= lnciAmt.subtract(pant.multiply(new
			// BigDecimal(100)).divide(new
			// BigDecimal(100).subtract(percent),2,BigDecimal.ROUND_UP)).subtract(deliveriedAmount);
			return money;
		}
		if (ScfBasConstant.TRI_DELIVERY_RULE_LAST.equals(deliveryModel)) {// 首笔最后全额提货
			// 敞口余额 = 出账金额–(初始保证金及等价物金额 + 追加保证金及等价物金额)
			// BigDecimal openAmount
			// =lnciAmt.subtract(initAmount).subtract(refundAmount);

			// 计算方式:敞口余额 >0, 本次可提货金额 =追加保证金及等价物金额-已累计提货金额
			if (pant.compareTo(BigDecimal.ZERO) > 0) {
				money = refundAmount.subtract(deliveriedAmount);
			} else if (pant.compareTo(BigDecimal.ZERO) == 0) {// 敞口余额 =
																// 0，本次可提货金额 =
																// 剩余提货金额
				money = lnciAmt.subtract(deliveriedAmount);
			}
			if (appbase.getChannelFlag() != null && appbase.getChannelFlag().equals(ScfBasConstant.CHANNEL_FLAG_IFSP)) {// ifsp流贷可提货需加上自有资金处理方式
				if (amountVO.getLnciType() != null && amountVO.getLnciType().equals("01")) {
					money = money.add(ownFundPayAmt);
				}
			}
			/*
			 * // 计算方式:敞口大于0：本次可提货金额=出账金额-（敞口余额+出账金额*（1-敞口率））-累计提货金额
			 * if(pant.compareTo(BigDecimal.ZERO)>0){ money=
			 * lnciAmt.subtract(pant.add(lnciAmt.multiply(percent).divide(new
			 * BigDecimal(100),2,BigDecimal.ROUND_UP))).subtract(
			 * deliveriedAmount); }else{//敞口等于0：本次提货金额=出账金额-累积提货金额 money =
			 * lnciAmt.subtract(deliveriedAmount); }
			 */

			return money;
		}
		return money;
	}

	/**
	 * @Description: 融资余额-质物价值
	 * @author lei.wang
	 * @Created 2012-10-19下午03:48:11
	 * @param amountVO
	 * @return
	 */
	private BigDecimal calculateLoan(AmountVO amountVO) {
		BigDecimal lnciBal = amountVO.getLnciBal() == null ? new BigDecimal(0) : amountVO.getLnciBal();// 融资余额
		BigDecimal mortAmount = amountVO.getMortAmount() == null ? new BigDecimal(0) : amountVO.getMortAmount();// 质物价值
		return mortAmount.subtract(lnciBal);
	}

	/**
	 * 计算本笔借据的敞口余额(本笔数风险敞口)
	 * 
	 * @param tblLnciBaseInfo
	 * @return
	 * @author fengjinfu
	 * @Created 2013-8-1
	 */
	@Override
	public BigDecimal getLnciRiskAmt(com.huateng.scf.bas.lan.model.BLanLnciBase bLanLnciBase) throws ScubeBizException {

		BigDecimal bailAmount = null;
		BigDecimal initCashEqtAmt = null;
		BigDecimal addBailAmount = null;
		BigDecimal addCashEqtAmt = null;
		BigDecimal riskAmt = null;
		bailAmount = (bLanLnciBase.getBailAmount() == null ? new BigDecimal(0) : bLanLnciBase.getBailAmount());
		addBailAmount = (bLanLnciBase.getAddBailAmount() == null ? new BigDecimal(0) : bLanLnciBase.getAddBailAmount());
		initCashEqtAmt = (bLanLnciBase.getInitCashEqtAmt() == null ? new BigDecimal(0)
				: bLanLnciBase.getInitCashEqtAmt());
		addCashEqtAmt = (bLanLnciBase.getAddCashEqtAmt() == null ? new BigDecimal(0) : bLanLnciBase.getAddCashEqtAmt());
		riskAmt = (bLanLnciBase.getLnciBal() == null ? new BigDecimal(0) : bLanLnciBase.getLnciBal())
				.subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt);
		return riskAmt;
	}

	/**
	 *
	 * @Description: 计算本笔借据的敞口余额(本笔数风险敞口)查询申请表
	 * @author wenkui.xu
	 * @Created 2013-8-19下午4:39:49
	 * @param appno
	 * @return
	 */
	@Override
	public BigDecimal getLnciRiskAmtByAppno(String appno) throws ScubeBizException {

		BLanAppliLnciBase bLanAppliLnciBase = blanapplilncibasedao.selectByAppno(appno);

		BigDecimal bailAmount = null;
		BigDecimal initCashEqtAmt = null;
		BigDecimal addBailAmount = null;
		BigDecimal addCashEqtAmt = null;
		BigDecimal riskAmt = null;
		bailAmount = (bLanAppliLnciBase.getBailAmount() == null ? new BigDecimal(0)
				: bLanAppliLnciBase.getBailAmount());
		addBailAmount = (bLanAppliLnciBase.getAddBailAmount() == null ? new BigDecimal(0)
				: bLanAppliLnciBase.getAddBailAmount());
		initCashEqtAmt = (bLanAppliLnciBase.getInitCashEqtAmt() == null ? new BigDecimal(0)
				: bLanAppliLnciBase.getInitCashEqtAmt());
		addCashEqtAmt = (bLanAppliLnciBase.getAddCashEqtAmt() == null ? new BigDecimal(0)
				: bLanAppliLnciBase.getAddCashEqtAmt());
		riskAmt = bLanAppliLnciBase.getLnciBal().subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt)
				.subtract(addCashEqtAmt);
		return riskAmt;
	}

	/**
	 * @author liph 池敞口余额
	 */

	@Override
	public BigDecimal calculatePoolRiskAvailableAmtByBusinessNo(String businessNo) {
		Map map = new HashMap();
		map.put("vidNo", businessNo);
		map.put("appliStatusDtl", "010");
		map.put("state", "1");
		map.put("is_settle", "0");
		// and a.state !='1' and a.is_settle ='0'
		List<BLanLnciBase> lnciList = bLanLnciBaseDAO.queryLnciInfoByBusinessNo(map);
		List<Map> flowList = blanapplilncibasedao.getFlowRiskAmtByVidno(businessNo);
		BigDecimal totalContRist = new BigDecimal(0);
		if (lnciList != null && lnciList.size() > 0) {
			BLanLnciBase bLanLnciBase = null;
			BigDecimal addBailAmount;
			BigDecimal bailAmount;
			BigDecimal initCashEqtAmt;
			BigDecimal addCashEqtAmt;
			BigDecimal lnciBal;
			for (int i = 0; i < lnciList.size(); i++) {
				bLanLnciBase = lnciList.get(i);
				// 借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
				addBailAmount = (bLanLnciBase.getAddBailAmount() == null ? new BigDecimal(0)
						: bLanLnciBase.getAddBailAmount());
				bailAmount = (bLanLnciBase.getBailAmount() == null ? new BigDecimal(0) : bLanLnciBase.getBailAmount());
				initCashEqtAmt = (bLanLnciBase.getInitCashEqtAmt() == null ? new BigDecimal(0)
						: bLanLnciBase.getInitCashEqtAmt());
				addCashEqtAmt = (bLanLnciBase.getAddCashEqtAmt() == null ? new BigDecimal(0)
						: bLanLnciBase.getAddCashEqtAmt());
				lnciBal = bLanLnciBase.getLnciBal();
				totalContRist = totalContRist.add(lnciBal.subtract(addBailAmount).subtract(bailAmount)
						.subtract(initCashEqtAmt).subtract(addCashEqtAmt));
			}
		}
		if (null != flowList && flowList.size() > 0) {
			Map flowMap = flowList.get(0);
			BigDecimal amt = (flowMap.get("AMT") == null ? BigDecimal.ZERO
					: new BigDecimal(flowMap.get("AMT").toString()));
			totalContRist = totalContRist.add(amt);
		}

		return totalContRist;
	}
	
	
	/**
	 * 获取敞口余额
	 * 根据合同类型，计算敞口余额。
	 * 循环合同：  敞口余额 = 信贷合同项下所有已经出账成功的敞口余额之和+供应链已经提交给信贷的借据的敞口余额之和（未 出账）
	 * 非循环合同： 敞口余额 = ∑（借据金额-初始保证金金额-初始现金等价物金额）【含出账已经成功和已经提交给信贷的】
	 * 该方法仅适合放款时的校验使用！！！
	 * @Description: 在这里添加方法的注释
	 * @author fengjinfu
	 * @Created 2013-10-12上午8:49:16
	 * @param mastContno
	 * @param cycle
	 * @return
	 * @throws CommonException
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public BigDecimal getContRiskAmtByCycle(String mastContno,String cycle)  
	{
		BigDecimal avalibalRiskAmt = new BigDecimal(0);
		List<Map> list = blanapplilncibasedao.getFlowRiskAmtByMastContno(mastContno);
		BigDecimal flowRiskAmt= new BigDecimal(0);

		if(list !=null && list.size() >0)
		{
			flowRiskAmt = (BigDecimal) (list.get(0).get("RISKAMT") == null ? BigDecimal.ZERO : list.get(0).get("RISKAMT"));
		}

		//非循环合同
		if(ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle))
		{
			avalibalRiskAmt = getContRiskAmt(mastContno,cycle);
		}
		//循环合同
		if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle))
		{
			avalibalRiskAmt = getContRiskAmt(mastContno,cycle);
		}
		//增加流程审批中的借据（仅仅包括已经提交给信贷，但是未审批通过）
		avalibalRiskAmt =avalibalRiskAmt.add(flowRiskAmt);
		return avalibalRiskAmt;
		
	}
	
	/**
	 * @Description: 计算信贷合同向下所有借据的敞口余额
	 * @author zhonghuabin
	 * @Created 2013-9-3下午7:36:30
	 * @param mastContno
	 * @return
	 * @throws CommonException
	 */
	@Override
	public BigDecimal getContRiskAmt(String mastContno,String cycle) {
		BigDecimal riskAmt = BigDecimal.ZERO;
		BigDecimal totRiskAmt = BigDecimal.ZERO;
//		bLanLnciBaseDAO.sele
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		if(mastContno!=null&&!"".equals(mastContno))
		{
			cri.andMastContnoEqualTo(mastContno);
		}
		cri.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		//循环合同，已经结清的借据不需要要计算的。
		if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle))
		{
			cri.andIsSettleEqualTo(ScfBasConstant.FLAG_OFF);
		}
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> list = bLanLnciBaseDAO.selectByExample(example);
		if (list != null && list.size() >0){
			for (int i=0;i<list.size();i++){
				riskAmt = this.getLnciRiskAmt((BLanLnciBase)list.get(i),cycle);
				if (riskAmt == null){
					riskAmt = BigDecimal.ZERO;
				}
				totRiskAmt = totRiskAmt.add(riskAmt);
			}
		}
		return totRiskAmt;
	}
	
	/**
	 * 计算本笔借据的敞口余额(本笔数风险敞口)
	 * @param tblLnciBaseInfo B_LAN_LNCI_BASE
	 * @return
	 * @author fengjinfu
	 * @Created 2013-8-1
	 */
	public BigDecimal getLnciRiskAmt(BLanLnciBase tblLnciBaseInfo,String cycle) {

		BigDecimal bailAmount = null;
		BigDecimal initCashEqtAmt = null;
		BigDecimal addBailAmount = null;
		BigDecimal addCashEqtAmt = null;
		BigDecimal riskAmt = null;
		bailAmount = (tblLnciBaseInfo.getBailAmount()==null?new BigDecimal(0):tblLnciBaseInfo.getBailAmount());
		addBailAmount= (tblLnciBaseInfo.getAddBailAmount()==null?new BigDecimal(0):tblLnciBaseInfo.getAddBailAmount());
		initCashEqtAmt = (tblLnciBaseInfo.getInitCashEqtAmt()==null?new BigDecimal(0):tblLnciBaseInfo.getInitCashEqtAmt());
		addCashEqtAmt = (tblLnciBaseInfo.getAddCashEqtAmt()==null ? new BigDecimal(0):tblLnciBaseInfo.getAddCashEqtAmt());
		if(ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle))
		{
			riskAmt = tblLnciBaseInfo.getLnciAmt().subtract(bailAmount).subtract(initCashEqtAmt);
		}
		if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle))
		{

			riskAmt = tblLnciBaseInfo.getLnciBal().subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt);
		}

		return riskAmt;
	}
	
	/**
	 * 计算协议项下敞口余额（先票款后货）
	 * @param protocolNo
	 * @return
	 * @throws ScubeBizException
	 */
	public BigDecimal getLnciRiskAmtByProtocolNo(String protocolNo,BigDecimal newAddBailAmount) throws ScubeBizException{
//		BigDecimal lnciAmt=new BigDecimal("0.00");
		BigDecimal lnciBal=new BigDecimal("0.00");
		BigDecimal bailAmount=new BigDecimal("0.00");
		BigDecimal addBailAmount=new BigDecimal("0.00");
		BigDecimal initCashEqtAmt=new BigDecimal("0.00");
		BigDecimal addCashEqtAmt=new BigDecimal("0.00");
		List<com.huateng.scf.bas.lan.model.BLanLnciBase> list=bLanLnciBaseService.getDebetAmtOfSum(protocolNo);
		List<?> flowList = bPbcAppliBaseInfoService.getFlowRiskAmtByBusinessNo(protocolNo);
		BigDecimal riskAmt = new BigDecimal("0");
		if(list!=null&&list.size()>0){
			com.huateng.scf.bas.lan.model.BLanLnciBase obj=(com.huateng.scf.bas.lan.model.BLanLnciBase) list.get(0);
			// 获取融资金额
//			 lnciAmt=(BigDecimal)(obj[0]==null?new BigDecimal("0.00"):obj[0]);
			// 获取融资余额
			 lnciBal=obj.getLnciBal();
			//获取初始保证金
			 bailAmount=obj.getBailAmount();
			//获取追加保证金
			 addBailAmount=obj.getAddBailAmount();
			 //初始现金等价物
			 initCashEqtAmt=obj.getInitCashEqtAmt();;
			 //追加现金等价物
			 addCashEqtAmt=obj.getAddCashEqtAmt();
		}
		//敞口余额 = 先票/款后货协议项下有效借据敞口余额累加(∑借据余额 – 保证金(不含本次追加)-现金等价物)
		riskAmt = lnciBal.subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt);
		// 流程中借据敞口余额也要统计  add by xiaolong.xiong 2013-09-29
		BigDecimal amt = BigDecimal.ZERO;
		if(flowList != null && flowList.size() > 0){
			Map<String, Object> map = (Map<String, Object>) (flowList.get(0));
			
			amt = (BigDecimal) (map.get("riskAmount")== null ?BigDecimal.ZERO:map.get("riskAmount"));
			riskAmt = riskAmt.add(amt);
		}
		return riskAmt;
	}
}
