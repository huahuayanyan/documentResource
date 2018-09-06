package com.huateng.scf.bas.batch.vo;

import java.io.Serializable;

/*
 * 创建日期 2007-9-21
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 统计分析扫描合同子程序数据传输对象</p>
 * @author pei
 * @version :2007-9-21 9:50:19
 */
public class LoanInfoWrapVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BHCustIndvInfoVO bhCustIndvInfoVO = new BHCustIndvInfoVO();
	
	private BhLoanInfoVO bhLoanInfoVO = new BhLoanInfoVO();
	
	private BhLoanExtInfoVO bhLoanExtInfoVO = new BhLoanExtInfoVO();
	
	private BhCostomerInfoVO bhCostomerInfoVO =  new BhCostomerInfoVO();

	public LoanInfoWrapVO() {
		super();
	}

	/**
	 * @return
	 */
	public BHCustIndvInfoVO getBhCustIndvInfoVO() {
		return bhCustIndvInfoVO;
	}

	/**
	 * @param infoVO
	 */
	public void setBhCustIndvInfoVO(BHCustIndvInfoVO infoVO) {
		bhCustIndvInfoVO = infoVO;
	}

	/**
	 * @return
	 */
	public BhLoanInfoVO getBhLoanInfoVO() {
		return bhLoanInfoVO;
	}

	/**
	 * @param infoVO
	 */
	public void setBhLoanInfoVO(BhLoanInfoVO infoVO) {
		bhLoanInfoVO = infoVO;
	}

	/**
	 * @return
	 */
	public BhCostomerInfoVO getBhCostomerInfoVO() {
		return bhCostomerInfoVO;
	}

	/**
	 * @return
	 */
	public BhLoanExtInfoVO getBhLoanExtInfoVO() {
		return bhLoanExtInfoVO;
	}

	/**
	 * @param infoVO
	 */
	public void setBhCostomerInfoVO(BhCostomerInfoVO infoVO) {
		bhCostomerInfoVO = infoVO;
	}

	/**
	 * @param infoVO
	 */
	public void setBhLoanExtInfoVO(BhLoanExtInfoVO infoVO) {
		bhLoanExtInfoVO = infoVO;
	}

}
