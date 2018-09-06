package com.huateng.scf.nbas.prd.model;

import java.io.Serializable;

public class BPrdBaseInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(10) 必填<br>
	 * 产品编号
	 */
	private String productId;

	/**
	 * CHAR(1)<br>
	 * 是否支持流动资金贷款：1-是，2-否
	 */
	private String loansFlag="2";

	/**
	 * CHAR(1)<br>
	 * 是否支持银行承兑汇票：1-是，2-否
	 */
	private String acceptanceFlag="2";

	/**
	 * CHAR(1)<br>
	 * 是否支持融资性保函：1-是，2-否
	 */
	private String guaranteeLetterFlag="2";

	/**
	 * CHAR(1)<br>
	 * 是否支持信用证：1-是，2-否
	 */
	private String creditrLetterFlag="2";

	/**
	 * CHAR(1)<br>
	 * 是否支持商票保贴：1-是，2-否
	 */
	private String commercialDiscountFlag="2";

	/**
	 * CHAR(1)<br>
	 * 是否支持预支金价：1-是，2-否
	 */
	private String advGoldPriceFlag="2";

	/**
	 * CHAR(1)<br>
	 * 交易结构：1-先款后货，2-先货后款，3-组合类
	 */
	private String traStrue;

	/**
	 * CHAR(1)<br>
	 * 融资模式：1-单笔，2-池融资
	 */
	private String finModel;

	/**
	 * CHAR(1) 必填<br>
	 * 是否使用准入：1-是，2-否
	 */
	private String isUseAccessFlag;

	/**
	 * CHAR(1)<br>
	 * 是否支持非融资性保函:1-是，2-否
	 */
	private String isnfinGuaLetFlag="2";

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 产品编号
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 产品编号
	 */
	public void setProductId(String productId) {
		this.productId = productId == null ? null : productId.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否支持流动资金贷款：1-是，2-否
	 */
	public String getLoansFlag() {
		return loansFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否支持流动资金贷款：1-是，2-否
	 */
	public void setLoansFlag(String loansFlag) {
		this.loansFlag = loansFlag == null ? null : loansFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否支持银行承兑汇票：1-是，2-否
	 */
	public String getAcceptanceFlag() {
		return acceptanceFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否支持银行承兑汇票：1-是，2-否
	 */
	public void setAcceptanceFlag(String acceptanceFlag) {
		this.acceptanceFlag = acceptanceFlag == null ? null : acceptanceFlag
				.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否支持融资性保函：1-是，2-否
	 */
	public String getGuaranteeLetterFlag() {
		return guaranteeLetterFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否支持融资性保函：1-是，2-否
	 */
	public void setGuaranteeLetterFlag(String guaranteeLetterFlag) {
		this.guaranteeLetterFlag = guaranteeLetterFlag == null ? null
				: guaranteeLetterFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否支持信用证：1-是，2-否
	 */
	public String getCreditrLetterFlag() {
		return creditrLetterFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否支持信用证：1-是，2-否
	 */
	public void setCreditrLetterFlag(String creditrLetterFlag) {
		this.creditrLetterFlag = creditrLetterFlag == null ? null
				: creditrLetterFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否支持商票保贴：1-是，2-否
	 */
	public String getCommercialDiscountFlag() {
		return commercialDiscountFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否支持商票保贴：1-是，2-否
	 */
	public void setCommercialDiscountFlag(String commercialDiscountFlag) {
		this.commercialDiscountFlag = commercialDiscountFlag == null ? null
				: commercialDiscountFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否支持预支金价：1-是，2-否
	 */
	public String getAdvGoldPriceFlag() {
		return advGoldPriceFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否支持预支金价：1-是，2-否
	 */
	public void setAdvGoldPriceFlag(String advGoldPriceFlag) {
		this.advGoldPriceFlag = advGoldPriceFlag == null ? null
				: advGoldPriceFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 交易结构：1-先款后货，2-先货后款，3-组合类
	 */
	public String getTraStrue() {
		return traStrue;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 交易结构：1-先款后货，2-先货后款，3-组合类
	 */
	public void setTraStrue(String traStrue) {
		this.traStrue = traStrue == null ? null : traStrue.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 融资模式：1-单笔，2-池融资
	 */
	public String getFinModel() {
		return finModel;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 融资模式：1-单笔，2-池融资
	 */
	public void setFinModel(String finModel) {
		this.finModel = finModel == null ? null : finModel.trim();
	}

	/**
	 * CHAR(1) 必填<br>
	 * 获得 是否使用准入：1-是，2-否
	 */
	public String getIsUseAccessFlag() {
		return isUseAccessFlag;
	}

	/**
	 * CHAR(1) 必填<br>
	 * 设置 是否使用准入：1-是，2-否
	 */
	public void setIsUseAccessFlag(String isUseAccessFlag) {
		this.isUseAccessFlag = isUseAccessFlag == null ? null : isUseAccessFlag
				.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否支持非融资性保函:1-是，2-否
	 */
	public String getIsnfinGuaLetFlag() {
		return isnfinGuaLetFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否支持非融资性保函:1-是，2-否
	 */
	public void setIsnfinGuaLetFlag(String isnfinGuaLetFlag) {
		this.isnfinGuaLetFlag = isnfinGuaLetFlag == null ? null
				: isnfinGuaLetFlag.trim();
	}
}