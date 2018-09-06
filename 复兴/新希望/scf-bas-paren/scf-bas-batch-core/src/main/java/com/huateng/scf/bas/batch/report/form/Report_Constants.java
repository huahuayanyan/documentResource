package com.huateng.scf.bas.batch.report.form;

import com.huateng.scf.bas.batch.common.Arith;

public class Report_Constants {


	public static final String REPORT_R_R001_JASPER = "report_R_R001.jasper";

	public static final String REPORT_R_R002_JASPER = "report_R_R002.jasper";

	public static final String REPORT_R_R003_JASPER = "report_R_R003.jasper";

	public static final String REPORT_R_R005_JASPER = "report_R_R005.jasper";

	public static final String REPORT_R_R006_JASPER = "report_R_R006.jasper";

	public static final String REPORT_R_R007_JASPER = "report_R_R007.jasper";

	public static final String REPORT_R_R008_JASPER = "report_R_R008.jasper";

	public static final String REPORT_R_R009_JASPER = "report_R_R009.jasper";

	public static final String REPORT_R_R012_JASPER = "report_R_R012.jasper";

	public static final String REPORT_R_R101_JASPER = "report_R_R101.jasper";

	public static final String REPORT_R_R201_JASPER = "report_R_R201.jasper";

	//add by ghw090925贴现信贷资金流向表
	public static final String REPORT_R_BA001_JASPER = "report_R_BA001.jasper";
	//add by ghw090925按承兑行分类统计表
	public static final String REPORT_R_BA002_JASPER = "report_R_BA002.jasper";
	////add by ghw091030票据综合业务统计表
	public static final String REPORT_R_BA004_JASPER = "report_R_BA004.jasper";
	//add by ghw090925利息收入分析表
	public static final String REPORT_R_BA008_JASPER = "report_R_BA008.jasper";
	//add by ghw090925利息支出分析表
	public static final String REPORT_R_BA009_JASPER = "report_R_BA009.jasper";
	//add by ghw090925利差分析表
	public static final String REPORT_R_BA010_JASPER = "report_R_BA010.jasper";

	//add by joan.wu 20091006 客户经理贡献表
	public static final String REPORT_R_BA013_JASPER = "report_R_BA013.jasper";
	//add by joan.wu 20091008 部门支行贡献表
	public static final String REPORT_R_BA014_JASPER = "report_R_BA014.jasper";
	//add by joan.wu 20091008 客户贴限量排序表
	public static final String REPORT_R_BA012_JASPER = "report_R_BA012.jasper";
	//add by joan.wu 20091015 买卖利率分析表
	public static final String REPORT_R_BA011_JASPER = "report_R_BA011.jasper";
	//add by joan.wu 20091027 人民币贴现利率水平表
	public static final String REPORT_R_BA007_JASPER = "report_R_BA007.jasper";
	//add by joan.wu 20091119 质押及解除质押统计表
	public static final String REPORT_R_BA015_JASPER = "report_R_BA015.jasper";

	/**
	 * 实物＋电子
	 */
	public static final String DRAFT_ATTR_ALL = "e";
	/** 票据属性-1-实物 */
	public static final String DRAFT_ATTR_REAL = "1";
	/** 票据属性-2-电子 */
	public static final String DRAFT_ATTR_ELECTRON = "2";


	/** 票据类型-1-银票 */
	public static final String DRAFT_TYPE_BANK = "1";
	/** 票据类型-2-商票 */
	public static final String DRAFT_TYPE_BUSINESS = "2";


	/**
	 * 总行
	 */
	public static final String DRAFT_BRANCH_ALL = "1";
	/**
	 * 分行
	 */
	public static final String DRAFT_BRANCH_2 = "2";
	/**
	 *支行
	 */
	public static final String DRAFT_BRANCH_3 = "3";


	/** 票据属性-汇总 1,2 */
	public static final String DRAFT_ATTR_SUM = "E";
	/** 承兑 **/
	public static final String BUY_CONTRACT_BUY_TYPE_BANK_ACCEPTOR = "04";
	/** 银贴 **/
	public static final String BUY_CONTRACT_BUY_TYPE_BANK_DISCOUNT = "10";
	/** 商贴  **/
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_DISCOUNT = "20";
	/** 银票转贴 **/
	public static final String BUY_CONTRACT_BUY_TYPE_BANK_RESELL = "11";
	/** 商票转贴  **/
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_RESELL = "21";

	/** 发生额统计 */
	public static final String REPORT_MONEY_TYPE_OCCUR = "01";
	/** 余额统计 */
	public static final String REPORT_MONEY_TYPE_BALANCE = "02";

	/**
	 * 0-贴现
	 */
	public static final String DISC_TYPE_0 = "0";//0-贴现
	/**
	 * 1-转贴现
	 */
	public static final String DISC_TYPE_1 = "1";//	1-转贴现
	/**
	 * 2-再贴现
	 */
	public static final String DISC_TYPE_2 = "2";//2-再贴现

	/**
	 * 报表统计单位，采集数据以元为单位，报表以万元为单位，这里是精度。
	 */
	public static final double DOUBLE_DIVIDE_10000=10000;
	/**
	 * 小数后保留精度。
	 */
	public static final int   DIVIDE_SCAL_7=7;


	/**
	 *
	 * @param dsource
	 * @return
	 */
	public static Double getReportDouble(Double dsource)
	{
		if(dsource==null)
			return new Double(0);
		return  new Double(Arith.divideRoundHarfUp(dsource.doubleValue(), DOUBLE_DIVIDE_10000, DIVIDE_SCAL_7));
	}
}
