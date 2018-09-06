package com.huateng.scf.bas.prd.model;

import java.io.Serializable;
import java.util.List;

public class BPrdBaseInfo implements Serializable {
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
	 * ----------------------------- 
	 * 接受页面复选框传递过来的数据
	 * -----------------------------
	 */
	private List<String> loanWay;

	public List<String> getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(List<String> loanWay) {
		this.loanWay = loanWay;
		if (loanWay != null) {
			for (String loan : loanWay) {
				switch (Integer.valueOf(loan)) {
				case 0:
					setAdvGoldPriceFlag("1");
					break;
				case 1:
					setLoansFlag("1");
					break;
				case 2:
					setAcceptanceFlag("1");
					break;
				case 3:
					setGuaranteeLetterFlag("1");
					break;
				case 4:
					setIsnfinGuaLetFlag("1");
					break;
				case 5:
					setCommercialDiscountFlag("1");
					break;
				case 6:
					setCreditrLetterFlag("1");
					break;
				}
			}
		}
	}

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", productId=").append(productId);
		sb.append(", loansFlag=").append(loansFlag);
		sb.append(", acceptanceFlag=").append(acceptanceFlag);
		sb.append(", guaranteeLetterFlag=").append(guaranteeLetterFlag);
		sb.append(", creditrLetterFlag=").append(creditrLetterFlag);
		sb.append(", commercialDiscountFlag=").append(commercialDiscountFlag);
		sb.append(", advGoldPriceFlag=").append(advGoldPriceFlag);
		sb.append(", traStrue=").append(traStrue);
		sb.append(", finModel=").append(finModel);
		sb.append(", isUseAccessFlag=").append(isUseAccessFlag);
		sb.append(", isnfinGuaLetFlag=").append(isnfinGuaLetFlag);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		BPrdBaseInfo other = (BPrdBaseInfo) that;
		return (this.getProductId() == null ? other.getProductId() == null
				: this.getProductId().equals(other.getProductId()))
				&& (this.getLoansFlag() == null ? other.getLoansFlag() == null
						: this.getLoansFlag().equals(other.getLoansFlag()))
				&& (this.getAcceptanceFlag() == null ? other
						.getAcceptanceFlag() == null : this.getAcceptanceFlag()
						.equals(other.getAcceptanceFlag()))
				&& (this.getGuaranteeLetterFlag() == null ? other
						.getGuaranteeLetterFlag() == null : this
						.getGuaranteeLetterFlag().equals(
								other.getGuaranteeLetterFlag()))
				&& (this.getCreditrLetterFlag() == null ? other
						.getCreditrLetterFlag() == null : this
						.getCreditrLetterFlag().equals(
								other.getCreditrLetterFlag()))
				&& (this.getCommercialDiscountFlag() == null ? other
						.getCommercialDiscountFlag() == null : this
						.getCommercialDiscountFlag().equals(
								other.getCommercialDiscountFlag()))
				&& (this.getAdvGoldPriceFlag() == null ? other
						.getAdvGoldPriceFlag() == null : this
						.getAdvGoldPriceFlag().equals(
								other.getAdvGoldPriceFlag()))
				&& (this.getTraStrue() == null ? other.getTraStrue() == null
						: this.getTraStrue().equals(other.getTraStrue()))
				&& (this.getFinModel() == null ? other.getFinModel() == null
						: this.getFinModel().equals(other.getFinModel()))
				&& (this.getIsUseAccessFlag() == null ? other
						.getIsUseAccessFlag() == null : this
						.getIsUseAccessFlag()
						.equals(other.getIsUseAccessFlag()))
				&& (this.getIsnfinGuaLetFlag() == null ? other
						.getIsnfinGuaLetFlag() == null : this
						.getIsnfinGuaLetFlag().equals(
								other.getIsnfinGuaLetFlag()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getProductId() == null) ? 0 : getProductId().hashCode());
		result = prime * result
				+ ((getLoansFlag() == null) ? 0 : getLoansFlag().hashCode());
		result = prime
				* result
				+ ((getAcceptanceFlag() == null) ? 0 : getAcceptanceFlag()
						.hashCode());
		result = prime
				* result
				+ ((getGuaranteeLetterFlag() == null) ? 0
						: getGuaranteeLetterFlag().hashCode());
		result = prime
				* result
				+ ((getCreditrLetterFlag() == null) ? 0
						: getCreditrLetterFlag().hashCode());
		result = prime
				* result
				+ ((getCommercialDiscountFlag() == null) ? 0
						: getCommercialDiscountFlag().hashCode());
		result = prime
				* result
				+ ((getAdvGoldPriceFlag() == null) ? 0 : getAdvGoldPriceFlag()
						.hashCode());
		result = prime * result
				+ ((getTraStrue() == null) ? 0 : getTraStrue().hashCode());
		result = prime * result
				+ ((getFinModel() == null) ? 0 : getFinModel().hashCode());
		result = prime
				* result
				+ ((getIsUseAccessFlag() == null) ? 0 : getIsUseAccessFlag()
						.hashCode());
		result = prime
				* result
				+ ((getIsnfinGuaLetFlag() == null) ? 0 : getIsnfinGuaLetFlag()
						.hashCode());
		return result;
	}
}