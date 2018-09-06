package com.huateng.scf.bas.batch.StatAnaly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.common.CommonService;
import com.huateng.scf.bas.batch.common.DataFormat;
import com.huateng.scf.bas.batch.common.DateUtil;
import com.huateng.scf.bas.batch.common.SystemConstant;
import com.huateng.scf.bas.batch.frame.BatchTemplet;
import com.huateng.scf.bas.qry.model.OCrmInfoAnalysis;
import com.huateng.scf.bas.batch.control.scf.vo.WarnVO;

/**
 * 
 * <p>统计分析：客户信息分析</p>
 *
 * @author 	shangxiujuan
 * @date 2017年7月5日上午10:37:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年7月5日上午10:37:04              新增
 *
 * </pre>
 */
@SuppressWarnings("unused")
public class BatchOdsCrmInfoAnalysis extends BatchTemplet {

	private Connection conn;

	public BatchOdsCrmInfoAnalysis(Integer _id, String threadName, String _brcode) {
		super(_id, threadName, _brcode);
	}

	public BatchOdsCrmInfoAnalysis(Integer _id, String threadName) {
		super(_id, threadName);
	}

	@Override
	protected void doProcess() throws Exception {

		Map<String, String> newWarn = new HashMap<String, String>();

		conn = this.getConn();
		List<OCrmInfoAnalysis> custList = CommonService.getCustInfo(conn); // 查询客户信息
		String strBhdate = this.getBhdate().replace("-", "");// yyyy-MM-dd

		// java.util.Date nowDate = DateUtil.stringToDate(strBhdate);
		// String strEndDate =
		// DateUtil.dateToString(DateUtil.getEndDateByDays(nowDate,
		// Integer.parseInt(warnVO.getWarnLevelLow())));
		// java.sql.Date nowSqlDate =
		// java.sql.Date.valueOf(strBhdate.substring(0, 10));
		// java.sql.Date endSqlDate = java.sql.Date.valueOf(strEndDate);

		PreparedStatement pstmtdelete = null;
		ResultSet rsdelete = null;
		PreparedStatement pstmtinsertCust = null;
		ResultSet rsinsertCust = null;

		StringBuffer delete = new StringBuffer();// 删除融资统计分析信息
		delete.append("delete from ODS_CRM_INFO_ANALYSIS t ");

		StringBuffer insertCustBase = new StringBuffer();// 新增客户分析信息
		insertCustBase.append(
				"insert into ODS_CRM_INFO_ANALYSIS(ID, CUSTCD, CNAME, CREATE_DATE, INDUSTRY_TYPE,INDUSTRY_TYPE_NAME, OPEN_DATE, ANNUAL_SALES_AMT, SALES_RATE, ANNUAL_PURCHASE_AMT, PURCHASE_RATE, ANNUAL_REC, OVERDUE_RATE, AVERAGE_AGE, ANNUAL_PAY, PROFIT_RATE, ERP_USED_RATE, RELATION, QUALITY_ENVIR, SALES_PROFIT_RATE, ANNUAN_GROWTH, LASTQUA_SALE_ACTIVE_RATE, LASTQUA_PUA_ACTIVE_RATE, LASTQUA_IN_ACTIVE_RATE, LASTQUA_OUT_ACTIVE_RATE, DEPOSIT_MY_RATE, CREDIT_RATE, CREDIT_MY_RATE, THREEM_DALIY_ASSETS, THREEM_DALIY_DEPOSIT, ASSETS, DEPOSIT, THREEM_DALIY_LOAN_IN, THREEM_DALIY_LOAN_OUT, OVERDUE_AMOUNT, PRINCIPAL_LOSS_AMT, MARGIN_COVER_RATE, SALE_GROWTH_RATE, REC_RATE, PREPAY_RATE, BAD_RATE, TOTAL_LOAN_AMT, REPAYMENT_AMT, OVERDUE_NUM, LOSS_AMT, TOTAL_CHAN_FEE, TOTAL_INCOME)")

				.append("  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) ");

		this.writeFileLog("###########客户信息分析 start ");

		if (null != custList && custList.size() > 0) {
			try {
				pstmtdelete = conn.prepareStatement(delete.toString());
				int i = pstmtdelete.executeUpdate();
				if (i < 0) {
					throw new Exception("#############delete rows : " + i + " ,delete sql:" + delete);
				}
				for (OCrmInfoAnalysis cust : custList) {

					// 不存在记录，新增记录
					String custInfoId = BatchUtil.getUUID();
					pstmtinsertCust = conn.prepareStatement(insertCustBase.toString());
					// TOTAL_LOAN_AMT, REPAYMENT_AMT, OVERDUE_NUM, LOSS_AMT,
					// TOTAL_CHAN_FEE, TOTAL_INCOME)

					// ID, CUSTCD, CNAME, CREATE_DATE, INDUSTRY_TYPE,
					// INDUSTRY_TYPE_NAME
					pstmtinsertCust.setString(1, custInfoId);
					pstmtinsertCust.setString(2, cust.getCustcd());
					pstmtinsertCust.setString(3, cust.getCname());
					pstmtinsertCust.setString(4, strBhdate); // cust.getCreateDate()
					pstmtinsertCust.setString(5, cust.getIndustryType());
					pstmtinsertCust.setString(6, cust.getIndustryTypeName());

					// OPEN_DATE, ANNUAL_SALES_AMT, SALES_RATE,
					// ANNUAL_PURCHASE_AMT, PURCHASE_RATE,
					pstmtinsertCust.setString(7, cust.getOpenDate());
					pstmtinsertCust.setBigDecimal(8, cust.getAnnualSalesAmt());
					pstmtinsertCust.setBigDecimal(9, cust.getSalesRate());
					pstmtinsertCust.setBigDecimal(10, cust.getAnnualPurchaseAmt());
					pstmtinsertCust.setBigDecimal(11, cust.getPurchaseRate());

					// ANNUAL_REC, OVERDUE_RATE, AVERAGE_AGE, ANNUAL_PAY,
					// PROFIT_RATE,
					pstmtinsertCust.setBigDecimal(12, cust.getAnnualRec());
					pstmtinsertCust.setBigDecimal(13, cust.getOverdueRate());
					pstmtinsertCust.setBigDecimal(14, cust.getAverageAge());
					pstmtinsertCust.setBigDecimal(15, cust.getAnnualPay());
					pstmtinsertCust.setBigDecimal(16, cust.getProfitRate());

					// ERP_USED_RATE, RELATION, QUALITY_ENVIR,
					// SALES_PROFIT_RATE, ANNUAN_GROWTH,
					pstmtinsertCust.setBigDecimal(17, cust.getErpUsedRate());
					pstmtinsertCust.setBigDecimal(18, cust.getRelation());
					pstmtinsertCust.setBigDecimal(19, cust.getQualityEnvir());
					pstmtinsertCust.setBigDecimal(20, cust.getSalesProfitRate());
					pstmtinsertCust.setBigDecimal(21, cust.getAnnuanGrowth());

					// LASTQUA_SALE_ACTIVE_RATE, LASTQUA_PUA_ACTIVE_RATE,
					// LASTQUA_IN_ACTIVE_RATE, LASTQUA_OUT_ACTIVE_RATE,
					// DEPOSIT_MY_RATE,
					pstmtinsertCust.setBigDecimal(22, cust.getLastquaSaleActiveRate());
					pstmtinsertCust.setBigDecimal(23, cust.getLastquaPuaActiveRate());
					pstmtinsertCust.setBigDecimal(24, cust.getLastquaInActiveRate());
					pstmtinsertCust.setBigDecimal(25, cust.getLastquaOutActiveRate());
					pstmtinsertCust.setBigDecimal(26, cust.getDepositMyRate());

					// CREDIT_RATE, CREDIT_MY_RATE, THREEM_DALIY_ASSETS,
					// THREEM_DALIY_DEPOSIT, ASSETS,
					pstmtinsertCust.setBigDecimal(27, cust.getCreditRate());
					pstmtinsertCust.setBigDecimal(28, cust.getCreditMyRate());
					pstmtinsertCust.setBigDecimal(29, cust.getThreemDaliyAssets());
					pstmtinsertCust.setBigDecimal(30, cust.getThreemDaliyDeposit());
					pstmtinsertCust.setBigDecimal(31, cust.getAssets());

					// DEPOSIT, THREEM_DALIY_LOAN_IN, THREEM_DALIY_LOAN_OUT,
					// OVERDUE_AMOUNT, PRINCIPAL_LOSS_AMT,
					pstmtinsertCust.setBigDecimal(32, cust.getDeposit());
					pstmtinsertCust.setBigDecimal(33, cust.getThreemDaliyLoanIn());
					pstmtinsertCust.setBigDecimal(34, cust.getThreemDaliyLoanOut());
					pstmtinsertCust.setBigDecimal(35, cust.getOverdueAmount());
					pstmtinsertCust.setBigDecimal(36, cust.getPrincipalLossAmt());

					// MARGIN_COVER_RATE, SALE_GROWTH_RATE, REC_RATE,
					// PREPAY_RATE, BAD_RATE,
					pstmtinsertCust.setBigDecimal(37, cust.getMarginCoverRate());
					pstmtinsertCust.setBigDecimal(38, cust.getSaleGrowthRate());
					pstmtinsertCust.setBigDecimal(39, cust.getRecRate());
					pstmtinsertCust.setBigDecimal(40, cust.getPrepayRate());
					pstmtinsertCust.setBigDecimal(41, cust.getBadRate());

					// TOTAL_LOAN_AMT, REPAYMENT_AMT, OVERDUE_NUM, LOSS_AMT,
					// TOTAL_CHAN_FEE, TOTAL_INCOME)
					pstmtinsertCust.setBigDecimal(42, cust.getTotalLoanAmt());
					pstmtinsertCust.setBigDecimal(43, cust.getRepaymentAmt());
					pstmtinsertCust.setBigDecimal(44, cust.getOverdueNum());
					pstmtinsertCust.setBigDecimal(45, cust.getLossAmt());
					pstmtinsertCust.setBigDecimal(46, cust.getTotalChanFee());
					pstmtinsertCust.setBigDecimal(47, cust.getTotalIncome());

					int j = pstmtinsertCust.executeUpdate();
					if (j <= 0) {
						throw new Exception("#############insert rows : " + j + ", insert sql:" + insertCustBase);
					}

				}
			} finally {
				if (pstmtdelete != null)
					pstmtdelete.close();
				if (pstmtinsertCust != null)
					pstmtinsertCust.close();
			}
		}
		this.writeFileLog("############客户信息分析 end");
		conn.commit();
	}

}
