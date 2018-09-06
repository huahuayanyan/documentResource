package com.huateng.scf.bas.com.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfCreditService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.icr.model.BIcrType;
import com.huateng.scf.bas.icr.model.CreditInterParamBean;
import com.huateng.scf.bas.icr.service.IBIcrDtlService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.icr.service.IBIcrTypeService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>额度接口Service</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月25日下午3:31:33
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月25日下午3:31:33	     新增
 *
 * </pre>
 */
@ScubeService
@Service("ScfCreditServiceImpl")
public class ScfCreditServiceImpl implements IScfCreditService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bicrinfoservice;//额度信息表
	
	@Resource(name = "BIcrDtlServiceImpl")
	IBIcrDtlService bicrdtlservice;//额度使用流水表
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;//客户信息表
	
	@Resource(name = "BIcrTypeServiceImpl")
	IBIcrTypeService bicrtypeservice;//额度种类信息表
	
	@Resource(name = "BSysSerialNoServiceImpl")
	private  IBSysSerialNoService bSysSerialNoService;
	
	/**
	 *
	 * @Description: 额度接口检查
	 * @author wenkui.xu
	 * @Created 2012-9-13上午09:22:16
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("rawtypes")
	public Boolean checkCredit(String custcd, String otherCustcd,
			String creditType) throws ScubeBizException {
		List list = bicrinfoservice.checkCredit(custcd, otherCustcd,
				creditType);
		if (list != null && list.size() > 0) {
			return true;// 额度存在
		} else {
			return false;// 额度不存在
		}
	}

	/**
	 *
	 * @Description: 检查额度操作时数据正确性
	 * @author wenkui.xu
	 * @Created 2012-9-13上午09:34:45
	 * @param obj
	 * @param amount
	 * @param type
	 * @throws CommonException
	 */
	public void checkCreditOpInfo(String custcd, String otherCustcd,
			String creditType, BigDecimal amount, String type)
			throws ScubeBizException {
		bicrinfoservice.checkCreditOpInfo(custcd, otherCustcd, creditType,
				amount, type);
	}

	/**
	 * 检查数据完整性
	 * @param creditInterParamBean
	 * @param custcd
	 * @param creditType
	 * @param type
	 * @param amount
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午3:50:43
	 */
	public void checkCreditBean(CreditInterParamBean creditInterParamBean, String custcd,String creditType, String type,
			BigDecimal amount) throws ScubeBizException {
		if(StringUtil.isEmpty(custcd)){
			throw new ScubeBizException("客户号参数不存在！",
					RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(creditType)){
			throw new ScubeBizException("额度种类参数不存在！",
					RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(amount==null){
			throw new ScubeBizException("交易金额参数不存在！",
					RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(type)){
			throw new ScubeBizException("操作类型参数不存在！",
					RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}else{
			if(creditInterParamBean!=null){
				if (ScfBasConstant.CREDIT_TRADE_TYPE_INPUT.equals(type))// 生效(录入)
				{
					if(StringUtil.isEmpty(creditInterParamBean.getCurcd())){
						throw new ScubeBizException("交易币种参数不存在！",
								RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
					}
					if(StringUtil.isEmpty(creditInterParamBean.getControlType())){
						throw new ScubeBizException("额度控制类型参数不存在！",
								RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
					}
					if(creditInterParamBean.getStartDate()==null){
						throw new ScubeBizException("额度起始日参数不存在！",
								RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
					}
					if(creditInterParamBean.getEndDate()==null){
						throw new ScubeBizException("额度截止日参数不存在！",
								RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
					}
					if(StringUtil.isEmpty(creditInterParamBean.getRelaType())){
						throw new ScubeBizException("业务关联类型参数不存在！",
								RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
					}
					if(StringUtil.isEmpty(creditInterParamBean.getBusinessno())){
						throw new ScubeBizException("业务编号参数不存在！",
								RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
					}
					if(StringUtil.isEmpty(creditInterParamBean.getApplyType())){
						throw new ScubeBizException("交易类型参数不存在！",
								RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
					}
				}
				if (ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(type)// 预占用
				  || ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(type)// 占用
				  || ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(type)// 预占用恢复（释放）
				  || ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(type)// 占用恢复（释放）
				  || ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(type)// 冻结
				  || ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(type)// 解冻
				  || ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(type)// 变更
				  || ScfBasConstant.CREDIT_TRADE_TYPE_END.equals(type))// 终止
				{
					if(StringUtil.isEmpty(creditInterParamBean.getRelaType())){
						throw new ScubeBizException("业务关联类型参数不存在！",
								RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
					}
					if(StringUtil.isEmpty(creditInterParamBean.getBusinessno())){
						throw new ScubeBizException("业务编号参数不存在！",
								RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
					}
					if(StringUtil.isEmpty(creditInterParamBean.getApplyType())){
						throw new ScubeBizException("交易类型参数不存在！",
								RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
					}
				}
			}else{
				throw new ScubeBizException("交易参数不存在！",
						RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
			}
		}
	}
	
	/**
	 *
	 * @Description: 额度操作接口-记录流水和额度信息维护
	 * @author wenkui.xu
	 * @Created 2012-9-10下午03:11:38
	 * @param creditNo
	 *            额度编号
	 * @param custcd
	 *            客户号
	 * @param otherCustcd
	 *            交易对手客户号
	 * @param creditType
	 *            额度种类
	 * @param type
	 *            操作类型 00-生效(录入); 01-预占用; 02-占用; 03-占用恢复（释放）; 04-冻结; 05-冻结;
	 *            06-变更; 07-终止; 08-预占用恢复（释放）;09-直接占用;
	 * @param amount
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public void credit(CreditInterParamBean creditInterParamBean, String custcd,
			String otherCustcd, String creditType, String type,
			BigDecimal amount) throws ScubeBizException 
	{
		log.debug("额度操作接口-记录流水和额度信息维护");
		String custName="";
		String errString="";
		if(!StringUtil.isEmpty(custcd))
		{
			BCrmBaseInfo tblCustBaseInfo = bcrmbaseinfodao.selectById(custcd);
			custName=tblCustBaseInfo.getCname();
			errString+="客户为【"+custName+"】";
		}

		String otherCustcdName="";
		if(!StringUtil.isEmpty(otherCustcd)){
			BCrmBaseInfo tblCustBaseInfo = bcrmbaseinfodao.selectById(otherCustcd);
			otherCustcdName=tblCustBaseInfo.getCname();
			errString+="，交易对手为【"+otherCustcdName+"】";
		}

		String creditTypeName="";
		if(!StringUtil.isEmpty(creditType))
		{
			//B_ICR_TYPE[额度种类信息表]
			BIcrType tblCreditType = bicrtypeservice.getTblCreditTypeByCreditType(creditType);
			creditTypeName=tblCreditType.getCreditName();
			errString+="，额度类型为【"+creditTypeName+"】";
		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_INPUT.equals(type))// 生效(录入)
		{
			// 检查数据完整性
			checkCreditBean(creditInterParamBean, custcd, creditType, type,	amount);
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录存在则异常抛出错误
			if (checkCredit(custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息已经存在！",
						RBcpErrorConstant.RECORD_HAS_EXIST);
			}
			//获取新生成的额度编号
			String creditNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_INDIRECT_CREDIT_NO);
			creditInterParamBean.setCreditNo(creditNo);
			// 记录流水新增
			bicrdtlservice.addCreditDetail(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount,null);
			// 额度信息新增
			bicrinfoservice.addCreditInfo(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount);

		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(type))// 预占用
		{
			// 检查数据完整性
			checkCreditBean(creditInterParamBean, custcd, creditType, type,
					amount);
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (!checkCredit(custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息不存在！",
						RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			// check数据的准确性 预占用额度不可以超过当前可用额度
			checkCreditOpInfo(custcd, otherCustcd, creditType, amount, type);
			// 记录流水
			bicrdtlservice.addCreditDetail(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount,null);
			// 更新额度信息
			bicrinfoservice.modifyCreditInfo(custcd, otherCustcd, creditType,
					type, amount);

		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(type))// 占用
		{
			// 检查数据完整性
			checkCreditBean(creditInterParamBean, custcd, creditType, type,
					amount);
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (!checkCredit(custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息不存在！",
						RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			// check数据的准确性 占用额度不可以超过当前可用额度
			checkCreditOpInfo(custcd, otherCustcd, creditType, amount, type);
			// 记录流水
			bicrdtlservice.addCreditDetail(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount,null);
			// 更新额度信息
			bicrinfoservice.modifyCreditInfo(custcd, otherCustcd, creditType,
					type, amount);
		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(type))// 直接占用
		{
			// 检查数据完整性
			checkCreditBean(creditInterParamBean, custcd, creditType, type,
					amount);
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (!checkCredit(custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息不存在！",
						RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			// check数据的准确性 占用额度不可以超过当前可用额度
			checkCreditOpInfo(custcd, otherCustcd, creditType, amount, type);
			// 记录流水
			bicrdtlservice.addCreditDetail(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount,null);
			// 更新额度信息
			bicrinfoservice.modifyCreditInfo(custcd, otherCustcd, creditType,
					type, amount);
		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(type))// 预占用恢复（释放）
		{
			// 检查数据完整性
			checkCreditBean(creditInterParamBean, custcd, creditType, type,
					amount);
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (!checkCredit(custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息获取失败！",
						RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			// check数据的准确性 预恢复(释放)额度不可大于占用额度
			checkCreditOpInfo(custcd, otherCustcd, creditType, amount, type);
			// 记录流水
			bicrdtlservice.addCreditDetail(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount,null);
			// 更新额度信息
			bicrinfoservice.modifyCreditInfo(custcd, otherCustcd, creditType,
					type, amount);
		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(type))// 占用恢复（释放）
		{
			// 检查数据完整性
			checkCreditBean(creditInterParamBean, custcd, creditType, type,
					amount);
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (!checkCredit(custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息获取失败！",
						RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			// check数据的准确性 恢复(释放)额度不可大于占用额度
			checkCreditOpInfo(custcd, otherCustcd, creditType, amount, type);
			// 记录流水
			bicrdtlservice.addCreditDetail(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount,null);
			// 更新额度信息
			bicrinfoservice.modifyCreditInfo(custcd, otherCustcd, creditType,
					type, amount);

		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(type))// 冻结
		{
			// 检查数据完整性
			checkCreditBean(creditInterParamBean, custcd, creditType, type,
					amount);
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (!checkCredit(custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息不存在！",
						RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			checkCreditOpInfo(custcd, otherCustcd, creditType, amount, type);
			// 记录流水
			bicrdtlservice.addCreditDetail(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount,null);
			// 更新额度信息
			bicrinfoservice.modifyCreditInfo(custcd, otherCustcd, creditType,
					type, amount);
		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(type))// 解冻
		{
			// 检查数据完整性
			checkCreditBean(creditInterParamBean, custcd, creditType, type,
					amount);
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (!checkCredit(custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息不存在！",
						RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			checkCreditOpInfo(custcd, otherCustcd, creditType, amount, type);
			// 记录流水
			bicrdtlservice.addCreditDetail(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount,null);
			// 更新额度信息
			bicrinfoservice.modifyCreditInfo(custcd, otherCustcd, creditType,
					type, amount);
		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(type))// 变更
		{
			// 检查数据完整性
			checkCreditBean(creditInterParamBean, custcd, creditType, type,
					amount);
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (!checkCredit(custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息获取失败！",
						RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			checkCreditOpInfo(custcd, otherCustcd, creditType, amount, type);
			// 记录流水
			bicrdtlservice.addCreditDetail(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount,null);
			// 更新额度信息
			bicrinfoservice.modifyCreditInfo(custcd, otherCustcd, creditType,
					type, amount);
		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_END.equals(type))// 终止
		{
			// 检查数据完整性
			checkCreditBean(creditInterParamBean, custcd, creditType, type,
					amount);
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (!checkCredit(custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息不存在！",
						RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			// 记录流水
			bicrdtlservice.addCreditDetail(creditInterParamBean,custcd,
					otherCustcd,creditType,type,amount,null);
			// 更新额度信息
			bicrinfoservice.modifyCreditInfo(custcd, otherCustcd, creditType,
					type, amount);

		}

	}
}
