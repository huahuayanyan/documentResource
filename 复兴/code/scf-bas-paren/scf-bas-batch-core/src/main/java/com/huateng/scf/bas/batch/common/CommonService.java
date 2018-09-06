package com.huateng.scf.bas.batch.common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.scf.bas.batch.control.scf.vo.WarnVO;
import com.huateng.scf.bas.qry.model.OCrmInfoAnalysis;
import com.huateng.scf.bas.qry.model.OFinaStaAnalysis;


public class CommonService {

	public static String getExtBrhNo ( String brhId, Connection conn ) throws Exception {
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//		String querySql = " select * from BRANCH_INFO where ID = ";
		String querySql = " select * from BCTL where ID = ";
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
		Statement state = null;
		ResultSet rs = null;
		String extBrhNo = null;
		try{
			state = conn.createStatement();
			querySql = querySql + brhId;
			rs = state.executeQuery(querySql);
			if ( rs.next() ){
				//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//				extBrhNo = rs.getString("BRH_NO").trim();
				extBrhNo = rs.getString("BRNO").trim();
				//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
			}else{
				throw new Exception("记录不存在！");
			}
		}catch ( Exception ex){
			System.out.println("Error SQL["+querySql+"]");
			throw ex;
		}finally{
			if ( rs != null ) rs.close();
			if ( state !=null ) state.close();
		}
		return extBrhNo;
	}

	public static String getExtBrhNo ( Integer brhId, Connection conn ) throws Exception {
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//		String querySql = " select * from BRANCH_INFO where ID = ";
		String querySql = " select * from BCTL where ID = ";
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
		Statement state = null;
		ResultSet rs = null;
		String extBrhNo = null;
		try{
			state = conn.createStatement();
			querySql = querySql + brhId;

			rs = state.executeQuery(querySql);
			if ( rs.next() ){
				//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//				extBrhNo = rs.getString("BRH_NO").trim();
				extBrhNo = rs.getString("BRNO").trim();
				//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
			}else{
				throw new Exception("记录不存在！");
			}
		}catch ( Exception ex){
			System.out.println("Error SQL["+querySql+"]");
			throw ex;
		}finally{
			if ( rs != null ) rs.close();
			if ( state !=null ) state.close();
		}
		return extBrhNo;
	}
	public static String getExtBrhNoName ( String brhId, Connection conn ) throws Exception {
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//		String querySql = " select * from BRANCH_INFO where ID = ";
		String querySql = " select * from BCTL where ID = ";
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
		Statement state = null;
		ResultSet rs = null;
		String extBrhNoName = null;
		try{
			state = conn.createStatement();
			querySql = querySql + brhId;

			rs = state.executeQuery(querySql);
			if ( rs.next() ){
				//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//				extBrhNoName = rs.getString("BRH_NO").trim()+"-"+rs.getString("BRH_NAME").trim();
				extBrhNoName = rs.getString("BRNO").trim()+"-"+rs.getString("BRNAME").trim();
				//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
			}else{
				throw new Exception("记录不存在！");
			}
		}catch ( Exception ex){
			System.out.println("Error SQL["+querySql+"]");
			throw ex;
		}finally{
			if ( rs != null ) rs.close();
			if ( state !=null ) state.close();
		}
		return extBrhNoName;
	}

	public static String getExtBrhNoName ( Integer brhId, Connection conn ) throws Exception {
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//		String querySql = " select * from BRANCH_INFO where ID = ";
		String querySql = " select * from BCTL where ID = ";
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
		Statement state = null;
		ResultSet rs = null;
		String extBrhNoName = null;
		try{
			state = conn.createStatement();
			querySql = querySql + brhId;

			rs = state.executeQuery(querySql);
			if ( rs.next() ){
				//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//				extBrhNoName = rs.getString("BRH_NO").trim()+"-"+rs.getString("BRH_NAME").trim();
				extBrhNoName = rs.getString("BRNO").trim()+"-"+rs.getString("BRNAME").trim();
				//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
			}else{
				throw new Exception("记录不存在！");
			}
		}catch ( Exception ex){
			System.out.println("Error SQL["+querySql+"]");
			throw ex;
		}finally{
			if ( rs != null ) rs.close();
			if ( state !=null ) state.close();
		}
		return extBrhNoName;
	}

	public String nvlString(String str,String ret){
		if(str==null)
			str=ret;
		return str.trim();
	}

	/**
	 *
	 * Description: TODO 将利率统一转换成年利率表示值
	 * @param
	 * @return BigDecimal
	 * @exception
	 * @author Robin Suo
	 * @version v1.0,2009-9-16
	 */
	public static BigDecimal formateIntRate(String rateType, BigDecimal rate ) throws Exception {
		BigDecimal formatIntRate = null;
		if ( rate == null ) rate = new BigDecimal(0.00);
		if ( StringUtils.equalsIgnoreCase(rateType, BatchConstant.RATE_TYPE_YEAR)){
			formatIntRate = rate.multiply(new BigDecimal(100)).setScale(5,BigDecimal.ROUND_HALF_UP);
		}else if ( StringUtils.equalsIgnoreCase(rateType, BatchConstant.RATE_TYPE_MONTH)){
			formatIntRate = rate.multiply(new BigDecimal(100)).multiply(new BigDecimal(12)).setScale(5,BigDecimal.ROUND_HALF_UP);
		}else if ( StringUtils.equalsIgnoreCase(rateType, BatchConstant.RATE_TYPE_DAY)){
			formatIntRate = rate.multiply(new BigDecimal(100)).multiply(new BigDecimal(360)).setScale(5,BigDecimal.ROUND_HALF_UP);
		}else {
			throw new Exception ("错误的利率标志!RATE_TYPE["+rateType+"]");
		}

		return formatIntRate;
	}

	/**
	 *
	 * Description: TODO 获取上一日工作日
	 * @param
	 * @return String
	 * @exception
	 * @author Robin Suo
	 * @version v1.0,2009-10-6
	 */
	public static String getPreWorkDay(String date, Connection conn, String logFilePath )throws Exception {
		PreparedStatement holidayPs = null;
		ResultSet holidayRs = null;
		String preWorkDay = null;
		try{
			SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
			Calendar calendar = Calendar.getInstance();
			int yearDate = calendar.get(Calendar.DAY_OF_YEAR);
			String year = date.substring(0, 4);
			String sql = " select * from HOLIDAY where YEAR = ? "+year;
			holidayPs = conn.prepareStatement(sql);
			while ( true ){
				holidayPs.setString(1, year);
				holidayRs = holidayPs.executeQuery();
				if ( holidayRs.next() == false ){
					throw new Exception ("获取指定年[" + year + "]的信息失败,没有该信息");
				}
				String hoildayDef = holidayRs.getString("HOLIDAY_DEF");
				for(int i=yearDate-1;i>=1;i--){
					char ch = hoildayDef.charAt(i-1);
					calendar.add(Calendar.DAY_OF_YEAR, -1);
					if(ch=='1'){
						preWorkDay = formater.format(calendar.getTime());
						break;
					}else{
					}
				}

				if(preWorkDay == null){
					//获取前一年信息
					calendar.set(Calendar.YEAR	, calendar.get(Calendar.YEAR)-1);
					year = String.valueOf(calendar.get(Calendar.YEAR));
					yearDate = calendar.getMaximum(Calendar.DAY_OF_YEAR);
					calendar.set(Calendar.DAY_OF_YEAR, yearDate);
					continue;
				}else{
					break;
				}
			}
		}catch ( Exception ex ){
			BatchUtil.writeFileLog(logFilePath, "获取工作日失败！错误信息：["+ex.getMessage()+"]");
			throw ex;
		}finally{
			if ( holidayPs != null) holidayPs.close();
			if ( holidayRs != null) holidayRs.close();
		}

		return preWorkDay;
	}


	/*
	 * 获取交易对手的联行号和名称（联行号+名称）
	 */
	public static String getTradeOper ( Integer custId, Connection conn , String filePathName ) throws Exception {
		String tradeOper = "";
		String queryCustSql = " select CUST_TYPE,BANK_NO,CUST_NAME from customer_info ci where ci.ID = "+String.valueOf(custId);
		String querySql = " select ub.ubank_no,ub.ubank_name from UNION_BANK ub where ub.ID = (";
		Statement state = null;
		ResultSet rs = null;
		try{
			state = conn.createStatement();
			rs = state.executeQuery(queryCustSql);
			if ( rs.next() ){
				String ubankName = rs.getString("CUST_NAME");
				tradeOper = ubankName.trim();
			}else{
				BatchUtil.writeFileLog(filePathName, "未找到客户信息！SQL["+querySql+"]");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if ( rs != null ) rs.close();
			if ( state !=null ) state.close();
		}
		return tradeOper;
	}

	/*
	 * 获取交易对手开户行行号
	 */
	public static String getTradeOperBank ( Integer custId, Connection conn , String filePathName ) throws Exception {
		String tradeOper = "";
		String queryCustSql = " select CUST_TYPE,BANK_NO,CUST_NAME from customer_info ci where ci.ID = "+String.valueOf(custId);
		Statement state = null;
		ResultSet rs = null;
		try{
			state = conn.createStatement();
			rs = state.executeQuery(queryCustSql);
			if ( rs.next() ){
				String ubankName = rs.getString("BANK_NO");
				tradeOper = ubankName.trim();
			}else{
				BatchUtil.writeFileLog(filePathName, "未找到客户信息！SQL["+queryCustSql+"]");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if ( rs != null ) rs.close();
			if ( state !=null ) state.close();
		}
		return tradeOper;
	}

	/* add by shen_antonio 20100113 jira: BMS-2415 begin .*/
	/**
	 * 判断当天是否为节假日
	 * @param _date
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 */
	public static boolean isHoliday(Connection conn, String _date) throws SQLException, ParseException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Calendar catendar = Calendar.getInstance();
			catendar.setTime(DateUtil.numberToDate(_date));

			StringBuffer sbSelHoliday = new StringBuffer();
			sbSelHoliday.append("select * from HOLIDAY where YEAR=");
			sbSelHoliday.append(_date.substring(0, 4));
			sbSelHoliday.append(" ");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sbSelHoliday.toString());
			String holiday = null;

			if (rs.next()) {
				holiday = BatchUtil.trim(rs.getString("HOLIDAY_DEF"));
				char[] holidays = holiday.toCharArray();
				int idx = catendar.get(Calendar.DAY_OF_YEAR) - 1;
				if (idx > holidays.length - 1) {
					return false;
				} else {
					if (holidays[idx] == '0') {
						return true;
					} else {
						return false;
					}
				}
			}
			return false;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		}
	}

	/**
	 * 取下一ECDS工作日期
	 *
	 * @return
	 * @throws SQLException
	 */
	public static String getEcdsNextDate(Connection conn, String bhDate, String txDate) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			StringBuffer sbSelCmon = new StringBuffer();
			sbSelCmon
					.append("select CMON_DT_CD,CMON_DT_VAL from TBL_SWT_COMMON_DATA ");
			sbSelCmon.append("where CMON_DT_CD='");
			sbSelCmon.append("ECD01003");
			sbSelCmon.append("' or CMON_DT_CD='");
			sbSelCmon.append("ECD01006");
			sbSelCmon.append("'");
			rs = stmt.executeQuery(sbSelCmon.toString());
			String _ecdsDate = bhDate;
			String _nextEcdsDate = txDate;
			while(rs.next()) {
				String cmonDtCd = rs.getString("CMON_DT_CD");
				if ("ECD01003".equals(cmonDtCd)) {
					_ecdsDate = BatchUtil.trim(rs.getString("CMON_DT_VAL"));
					if (_ecdsDate.length()==10)
						_ecdsDate = _ecdsDate.replaceAll("-", "");
				} else {
					_nextEcdsDate = BatchUtil.trim(rs.getString("CMON_DT_VAL"));
					_nextEcdsDate = _nextEcdsDate.replaceAll("-", "");
				}
			}
			if (_ecdsDate.compareTo(bhDate) <= 0) {
				return _nextEcdsDate;
			} else {
				return _ecdsDate;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}

		}
	}

	/**
	 * 获取当前日期的3天前工作日
	 * @param _date
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public static String get3daysBefore(Connection conn, String _date) throws SQLException,
			ParseException, java.text.ParseException {
		Statement stmt = null;
		ResultSet rs = null;

		Calendar catendar = Calendar.getInstance();
		catendar.setTime(DateUtil.numberToDate(_date));
		catendar.add(Calendar.DATE, -2);// 取三天前
		Date _lastDate = catendar.getTime();
		String lastDate = DateUtil.dateToNumber(_lastDate);
		int idx = catendar.get(Calendar.DAY_OF_YEAR) - 1;
		String thisYear = lastDate.substring(0, 4);
		int yearInt = Integer.valueOf(thisYear).intValue();
		try {
			StringBuffer sbSelHoliday = new StringBuffer();
			sbSelHoliday.append("select * from HOLIDAY where YEAR<=");
			sbSelHoliday.append(thisYear);
			sbSelHoliday.append(" order by year desc ");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sbSelHoliday.toString());
			int year = 0;
			String holiday = null;

			while (rs.next()) {
				year = rs.getInt("YEAR");
				holiday = BatchUtil.trim(rs.getString("HOLIDAY_DEF"));
				if (year == yearInt) {
					char[] holidays = holiday.toCharArray();

					while (true) {
						if (idx > holidays.length - 1)
							idx = holidays.length - 1;// 防止溢出

						char holidayFlg = holidays[idx];
						if (holidayFlg != '0') {
							catendar.setTime(DateUtil.numberToDate(String
									.valueOf(yearInt)
									+ "0101"));
							catendar.set(Calendar.DAY_OF_YEAR, idx + 1);
							return BatchUtil.dateToNumber(catendar.getTime());
						}

						if (idx > 0) {
							idx--;
						} else {
							yearInt--;
							idx = 1000;// 设为最大
							break;
						}
					}
				} else {
					// 找不到数据有问题
					break;
				}
			}
			return _date;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		}
	}
	/* add by shen_antonio 20100113 jira: BMS-2415 end.*/


	/**
	 * description：根据类名查询预警参数信息
	 * @param conn
	 * @param clss( this.getClass().getName() )
	 * @return
	 * @throws Exception
	 * @date 2013-3-8
	 * @author zhaoyang.lv
	 */
	public static WarnVO getWarnParam(Connection conn, String className) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select t.WARN_NO,t.WARN_NAME,t.WARN_TYPE,t.SUSPEND_FLAG,t.SUSPEND_DAY,t.TARGET_TYPE," +
				"t.TARGET_BRCLASS,t.TARGET_ROLEID,t.PACKAGE_ID,t.WARN_PROCESS,t.WARN_LEVEL_LOW,t.WARN_LEVEL_MIDI," +
				"t.WARN_LEVEL_HIGH,t.WARN_BUSS_TYPE,t.TLRNO,t.URL from B_BRP_WARN_PARAM t " +
				" where trim(t.WARN_PROCESS)='"+className+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				WarnVO warnVO = new WarnVO();
				warnVO.setWarnNo(rs.getString("WARN_NO"));
				warnVO.setWarnName(rs.getString("WARN_NAME"));
				warnVO.setWarnType(rs.getString("WARN_TYPE"));
				warnVO.setSuspendFlag(rs.getString("SUSPEND_FLAG"));
				warnVO.setSuspendDay(rs.getInt("SUSPEND_DAY"));
				warnVO.setTargetType(rs.getString("TARGET_TYPE"));
				warnVO.setTargetBrclass(rs.getString("TARGET_BRCLASS"));
				warnVO.setTargetRoleid(rs.getInt("TARGET_ROLEID"));
				warnVO.setPackageId(rs.getString("PACKAGE_ID"));
				warnVO.setWarnProcess(rs.getString("WARN_PROCESS"));
				warnVO.setWarnLevelLow(rs.getString("WARN_LEVEL_LOW"));
				warnVO.setWarnLevelMidi(rs.getString("WARN_LEVEL_MIDI"));
				warnVO.setWarnLevelHigh(rs.getString("WARN_LEVEL_HIGH"));
				warnVO.setWarnBussType(rs.getString("WARN_BUSS_TYPE"));
				warnVO.setTlrno(rs.getString("TLRNO"));
				warnVO.setUrl(rs.getString("URL"));
				warnVO.setWarnProcess(rs.getString("WARN_PROCESS"));
				return warnVO;
			}else{
				throw new Exception("根据类："+className+"未找到预警参数信息");
			}
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
	}

	/**
	 * 
	 * @Description: 根据预警编号查询预警参数信息
	 * @author michael
	 * @Created 2013-8-21下午4:47:44
	 * @param conn
	 * @param warnNo
	 * @return
	 * @throws Exception
	 */
	public static WarnVO getWarnParamByWarnNo(Connection conn, String warnNo) throws Exception{
		PreparedStatement warnPstmt = null;
		ResultSet warnRs = null;
		String sql = "select t.WARN_NO,t.WARN_NAME,t.WARN_TYPE,t.SUSPEND_FLAG,t.SUSPEND_DAY,t.TARGET_TYPE," +
				"t.TARGET_BRCLASS,t.TARGET_ROLEID,t.PACKAGE_ID,t.WARN_PROCESS,t.WARN_LEVEL_LOW,t.WARN_LEVEL_MIDI," +
				"t.WARN_LEVEL_HIGH,t.WARN_BUSS_TYPE,t.TLRNO,t.URL from TBL_WARN_PARAM t " +
				" where t.WARN_NO=?";
		try {
			WarnVO warnVO=null;
			warnPstmt = conn.prepareStatement(sql);
			warnPstmt.setString(1, warnNo);
			warnRs = warnPstmt.executeQuery();
			if(warnRs.next()){
				warnVO=new WarnVO();
				warnVO.setWarnNo(warnRs.getString("WARN_NO"));
				warnVO.setWarnName(warnRs.getString("WARN_NAME"));
				warnVO.setWarnType(warnRs.getString("WARN_TYPE"));
				warnVO.setSuspendFlag(warnRs.getString("SUSPEND_FLAG"));
				warnVO.setSuspendDay(warnRs.getInt("SUSPEND_DAY"));
				warnVO.setTargetType(warnRs.getString("TARGET_TYPE"));
				warnVO.setTargetBrclass(warnRs.getString("TARGET_BRCLASS"));
				warnVO.setTargetRoleid(warnRs.getInt("TARGET_ROLEID"));
				warnVO.setPackageId(warnRs.getString("PACKAGE_ID"));
				warnVO.setWarnProcess(warnRs.getString("WARN_PROCESS"));
				warnVO.setWarnLevelLow(warnRs.getString("WARN_LEVEL_LOW"));
				warnVO.setWarnLevelMidi(warnRs.getString("WARN_LEVEL_MIDI"));
				warnVO.setWarnLevelHigh(warnRs.getString("WARN_LEVEL_HIGH"));
				warnVO.setWarnBussType(warnRs.getString("WARN_BUSS_TYPE"));
				warnVO.setTlrno(warnRs.getString("TLRNO"));
				warnVO.setUrl(warnRs.getString("URL"));
				warnVO.setWarnProcess(warnRs.getString("WARN_PROCESS"));
				return warnVO;
			}
		} finally {
			if(warnRs!=null) warnRs.close();
			if(warnPstmt!=null) warnPstmt.close();
		}
		return null;
	}
	/**
	 * DESCRIPTION:根据到期日得到到期预警级别(提前N天预警)
	 * @author zhoujun.hou
	 * @date 2013-3-11
	 * getWarnLevel 方法
	 * @param warnVO 预警参数信息
	 * @param txdate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @param commonQueryVO
	 * @return
	 * @throws Exception
	 */
	public static String getWarnDueLevel(WarnVO warnVO,Date startDate,Date endDate) throws Exception{
		int bettwen = DateUtil.getDaysBetween(startDate, endDate);
		String warnLevel = null;
		int warnLevelLow = Integer.parseInt(warnVO.getWarnLevelLow());
		int warnLevelMidi = Integer.parseInt(warnVO.getWarnLevelMidi());
		int warnLevelHigh = Integer.parseInt(warnVO.getWarnLevelHigh());
		if(bettwen>=0&&bettwen<=warnLevelHigh){//高级预警
			warnLevel = SystemConstant.WARN_LEVEL_HIGH;
		}else if(bettwen>warnLevelHigh&&bettwen<=warnLevelMidi){//中级预警
			warnLevel = SystemConstant.WARN_LEVEL_MIDI;
		}else if(bettwen>warnLevelMidi&&bettwen<=warnLevelLow){//低级预警
			warnLevel = SystemConstant.WARN_LEVEL_LOW;
		}
		return warnLevel;
	}

	/**
	 * DESCRIPTION:根据到期日得到逾期预警级别(超过N天后预警)
	 * @author zhoujun.hou
	 * @date 2013-3-13
	 * getWarnOverdueLevel 方法
	 * @param warnVO
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 * @param commonQueryVO
	 * @return
	 */
	public static String getWarnOverdueLevel(WarnVO warnVO,Date startDate,Date endDate) throws Exception{
		int bettwen = DateUtil.getDaysBetween(startDate, endDate);
		String warnLevel = null;
		int warnLevelLow = Integer.parseInt(warnVO.getWarnLevelLow());//低
		int warnLevelMidi = Integer.parseInt(warnVO.getWarnLevelMidi());//中
		int warnLevelHigh = Integer.parseInt(warnVO.getWarnLevelHigh());//高
		if(bettwen>=warnLevelHigh){//高级预警
			warnLevel = SystemConstant.WARN_LEVEL_HIGH;
		}else if(bettwen<warnLevelHigh&&bettwen>=warnLevelMidi){//中级预警
			warnLevel = SystemConstant.WARN_LEVEL_MIDI;
		}else if(bettwen<warnLevelMidi&&bettwen>=warnLevelLow){//低级预警
			warnLevel = SystemConstant.WARN_LEVEL_LOW;
		}
		return warnLevel;
	}

	/**
	 * DESCRIPTION:根据参数获得预警级别(未巡库、未核库)
	 * @author zhaoyang.lv
	 * @date 2013-3-13
	 * @param warnVO
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public static String getUnPatrolStoreWarnLevel(WarnVO warnVO,Date startDate,Date endDate) throws Exception{
		int bettwen = DateUtil.getDaysBetween2(startDate, endDate);
		String warnLevel = null;
		int warnLevelLow = Integer.parseInt(warnVO.getWarnLevelLow());//低
		int warnLevelMidi = Integer.parseInt(warnVO.getWarnLevelMidi());//中
		int warnLevelHigh = Integer.parseInt(warnVO.getWarnLevelHigh());//高
		if(bettwen>=warnLevelHigh){//高级预警
			warnLevel = SystemConstant.WARN_LEVEL_HIGH;
		}else if(bettwen<warnLevelHigh&&bettwen>=warnLevelMidi){//中级预警
			warnLevel = SystemConstant.WARN_LEVEL_MIDI;
		}else if(bettwen<warnLevelMidi&&bettwen>=warnLevelLow){//低级预警
			warnLevel = SystemConstant.WARN_LEVEL_LOW;
		}
		return warnLevel;
	}
	/**
	 * 
	 * @Description:根据业务品种查询该业务大类
	 * @author hjf 
	 * @Created 2013-8-21下午2:17:38
	 * @param conn
	 * @param supplyChainPdId
	 * @return
	 * @throws Exception
	 */
	public static String getParentProductId(Connection conn, String supplyChainPdId) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select t.PARENT_ID from TBL_PRODUCT_INFO t where t.PRODUCT_ID = (select t2.PARENT_ID from TBL_PRODUCT_INFO t2 where t2.PRODUCT_ID ='"+supplyChainPdId+"' )";
		String parentID="";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				parentID= rs.getString("PARENT_ID");
				return parentID;
			}
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		return null;
	}
	/**
	 * 
	 * @Description: 根据客户号查询客户名称
	 * @author michael
	 * @Created 2013-8-21下午3:25:45
	 * @param conn
	 * @param custcd
	 * @return
	 * @throws Exception
	 */
	public static String getCustNameByCustcd(Connection conn,String custcd) throws Exception{
		String cname=null;
		PreparedStatement custPstmt = null;
		ResultSet custRs = null;
		String sql = "select t.CNAME from TBL_CUST_BASE_INFO t  where t.CUSTCD=?";
		try {
			custPstmt = conn.prepareStatement(sql);
			custPstmt.setString(1,StringUtils.trim(custcd));
			custRs = custPstmt.executeQuery();
			if(custRs.next()){
				cname=custRs.getString("CNAME");
			}
			return StringUtils.isEmpty(cname)?"":cname.trim();
		}finally {
			if(custRs!=null) custRs.close();
			if(custPstmt!=null) custPstmt.close();
		}
	}
	
	/**
	 * 
	 * @Description: 根据协议编号查询产品编号
	 * @author michael
	 * @Created 2013-8-21下午3:44:46
	 * @param conn
	 * @param protocolNo
	 * @return
	 * @throws Exception
	 */
	public static String getProductIdByProtocolNo(Connection conn,String protocolNo)throws Exception{
		String productId=null;
		PreparedStatement productPstmt = null;
		ResultSet productRs = null;
		String sql = "SELECT t.PRODUCT_ID FROM　TBL_MUTI_PROT_BASE_INFO　t WHERE t.PROTOCOL_NO=?";
		try {
			productPstmt = conn.prepareStatement(sql);
			productPstmt.setString(1,StringUtils.trim(protocolNo));
			productRs = productPstmt.executeQuery();
			if(productRs.next()){
				productId=productRs.getString("PRODUCT_ID");
			}
			return StringUtils.isEmpty(productId)?"":productId.trim();
		}finally {
			if(productRs!=null) productRs.close();
			if(productPstmt!=null) productPstmt.close();
		}
		
	}
	
	/**
	 * 
	 * @Description: 根据协议编号查询监管公司客户号
	 * @author michael
	 * @Created 2013-8-21下午3:50:33
	 * @param conn
	 * @param protocolNo
	 * @return
	 * @throws Exception
	 */
	public static String getMoniCustcdByProtocolNo(Connection conn,String protocolNo)throws Exception{
		String moniCustcd=null;
		PreparedStatement moniPstmt = null;
		ResultSet moniRs = null;
		String sql = "SELECT t.CUSTCD FROM　TBL_MUTI_PROT_PART_INFO　t WHERE t.PROTOCOL_NO=? AND　t.ROLE='"+SystemConstant.PROTOCOL_PART_ROLE_MONI+"'";
		try {
			moniPstmt = conn.prepareStatement(sql);
			moniPstmt.setString(1,StringUtils.trim(protocolNo));
			moniRs = moniPstmt.executeQuery();
			if(moniRs.next()){
				moniCustcd=moniRs.getString("CUSTCD");
			}
			return StringUtils.isEmpty(moniCustcd)?"":moniCustcd.trim();
		}finally {
			if(moniRs!=null) moniRs.close();
			if(moniPstmt!=null) moniPstmt.close();
		}
	}
	/**
	 * 
	 * @Description: 根据质押合同号查询质押合同编号
	 * @author michael
	 * @Created 2013-8-21下午3:50:33
	 * @param conn
	 * @param protocolNo
	 * @return
	 * @throws Exception
	 */
	public static String getSlaveConcodeBySlaveContno(Connection conn,String SlaveContno)throws Exception{
		String slaveConcode=null;
		PreparedStatement slaveConPstmt = null;
		ResultSet slaveConRs = null;
		String sql = "SELECT t.SLAVE_CONTCODE FROM　TBL_CONT_SLAVE_INFO t WHERE t.SLAVE_CONTNO=? ";
		try {
			slaveConPstmt = conn.prepareStatement(sql);
			slaveConPstmt.setString(1,StringUtils.trim(SlaveContno));
			slaveConRs = slaveConPstmt.executeQuery();
			if(slaveConRs.next()){
				slaveConcode=slaveConRs.getString("SLAVE_CONTCODE");
			}
			return StringUtils.isEmpty(slaveConcode)?"":slaveConcode.trim();
		}finally {
			if(slaveConRs!=null) slaveConRs.close();
			if(slaveConPstmt!=null) slaveConPstmt.close();
		}
	}
	
	/**
	 * 
	 * @Description: 根据质押合同号查询质押合同编号
	 * @author michael
	 * @Created 2013-8-21下午3:50:33
	 * @param conn
	 * @param protocolNo
	 * @return
	 * @throws Exception
	 */
	public static BigDecimal getTotalMortAmtBySlaveContno(Connection conn,String SlaveContno)throws Exception{
		BigDecimal mortAmt=new BigDecimal(0);
		PreparedStatement mortPstmt = null;
		ResultSet mortRs = null;
		String sql = "SELECT SUM(t.TOT_PRICE) TOTAL_AMT FROM　TBL_MORTGAGE_BASE_INFO t WHERE t.SLAVE_CONTNO=? ";
		try {
			mortPstmt = conn.prepareStatement(sql);
			mortPstmt.setString(1,StringUtils.trim(SlaveContno));
			mortRs = mortPstmt.executeQuery();
			if(mortRs.next()){
				mortAmt=mortRs.getBigDecimal("TOTAL_AMT");
			}
			return mortAmt;
		}finally {
			if(mortRs!=null) mortRs.close();
			if(mortPstmt!=null) mortPstmt.close();
		}
	}
	/**
	 * description：获得客户的信息
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public static  List<OCrmInfoAnalysis> getCustInfo(Connection conn) throws Exception{
	  List<OCrmInfoAnalysis> list = new ArrayList<OCrmInfoAnalysis>(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select t1.CUSTCD,T1.CUSTNO,t1.CNAME,t1.CUST_STATUS,T1.CUST_TYPE,T2.INDUSTRY_TYPE,T3.INDUSTRY_NAME"
				+" from B_CRM_BASE_INFO T1,B_CRM_ENT_INFO T2,B_BRP_INDUSTRY_TYPES T3"
				+" where T1.CUSTCD = T2.CUSTCD AND T2.INDUSTRY_TYPE = T3.INDUSTRY_CODE";

		try {
			int count=0;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
			
				OCrmInfoAnalysis custInfoVO = new OCrmInfoAnalysis();
				//客户基本信息和企业信息中获得
				custInfoVO.setCustcd(rs.getString("CUSTCD")); //客户号
				custInfoVO.setCname(rs.getString("CNAME"));//客户名称
				custInfoVO.setIndustryType(rs.getString("INDUSTRY_TYPE"));//国标行业分类
				custInfoVO.setIndustryTypeName(rs.getString("INDUSTRY_NAME"));//国标行业分类名称
				//设置初始值

				   //设置 年度销售额
				  custInfoVO.setAnnualSalesAmt(BigDecimal.ZERO) ;
				   //设置 相对销售占比
				  custInfoVO.setSalesRate(BigDecimal.ZERO) ;
				   //设置 年度采购额
				  custInfoVO.setAnnualPurchaseAmt(BigDecimal.ZERO) ;
				   //设置 相对采购占比
				  custInfoVO.setPurchaseRate(BigDecimal.ZERO) ;
				   //设置 年度应收账数
				  custInfoVO.setAnnualRec(BigDecimal.ZERO) ;
				   //设置 逾期比例
				  custInfoVO.setOverdueRate(BigDecimal.ZERO) ;
				   //设置 平均账龄
				  custInfoVO.setAverageAge(BigDecimal.ZERO) ;
				   //设置 年度应付账数
				  custInfoVO.setAnnualPay(BigDecimal.ZERO) ;
				   //设置 利润率
				  custInfoVO.setProfitRate(BigDecimal.ZERO) ;
				   //设置 ERP使用比率
				  custInfoVO.setErpUsedRate(BigDecimal.ZERO) ;
				   //设置 紧密关系
				  custInfoVO.setRelation(BigDecimal.ZERO) ;   
				  //设置 质量环境稳固
				  custInfoVO.setQualityEnvir(BigDecimal.ZERO) ;
				   //设置 销售利润率
				  custInfoVO.setSalesProfitRate(BigDecimal.ZERO) ;
				   //设置 年增长趋势
				  custInfoVO.setAnnuanGrowth(BigDecimal.ZERO) ;
				   //设置 上季度资金销售活跃率
				  custInfoVO.setLastquaSaleActiveRate(BigDecimal.ZERO) ;
				   //设置 上季度资金采购活跃率
				  custInfoVO.setLastquaPuaActiveRate(BigDecimal.ZERO) ;
				   //设置 上季度资金入账活跃率
				  custInfoVO.setLastquaInActiveRate(BigDecimal.ZERO) ;
				   //设置 上季度资金出账活跃率
				  custInfoVO.setLastquaOutActiveRate(BigDecimal.ZERO) ;
				   //设置 存款我行占比
				  custInfoVO.setDepositMyRate(BigDecimal.ZERO) ;
				    //设置 信贷比率
				  custInfoVO.setCreditRate(BigDecimal.ZERO) ;
				   //设置 信贷我行占比
				  custInfoVO.setCreditMyRate(BigDecimal.ZERO) ;
				   //设置 三个月日均资产
				  custInfoVO.setThreemDaliyAssets(BigDecimal.ZERO) ;
				   //设置 三个月日均存款
				  custInfoVO.setThreemDaliyDeposit(BigDecimal.ZERO) ;
				   //设置 时点资产
				  custInfoVO.setAssets(BigDecimal.ZERO) ;
				   //设置 时点存款
				  custInfoVO.setDeposit(BigDecimal.ZERO) ;
				   //设置 三个月日均贷款（表内）
				  custInfoVO.setThreemDaliyLoanIn(BigDecimal.ZERO) ;
				   //设置 三个月日均贷款（表外）
				  custInfoVO.setThreemDaliyLoanOut(BigDecimal.ZERO) ;  
				   //设置 逾期金额
				  custInfoVO.setOverdueAmount(BigDecimal.ZERO) ;   
				  //设置 本息损失
				  custInfoVO.setPrincipalLossAmt(BigDecimal.ZERO) ;
				   //设置 保证金覆盖率
				  custInfoVO.setMarginCoverRate(BigDecimal.ZERO) ;
				   //设置 销售增长率
				  custInfoVO.setSaleGrowthRate(BigDecimal.ZERO) ;
				   //设置 应收帐款占比
				  custInfoVO.setRecRate(BigDecimal.ZERO) ;  
				   //设置 预付款占比
				  custInfoVO.setPrepayRate(BigDecimal.ZERO) ; 
				   //设置 坏账率
				  custInfoVO.setBadRate(BigDecimal.ZERO) ;  
				   //设置 总贷款额
				  custInfoVO.setTotalLoanAmt(BigDecimal.ZERO) ;
				   //设置 已还款额
				  custInfoVO.setRepaymentAmt(BigDecimal.ZERO) ;     
				   //设置 逾期笔数
				  custInfoVO.setOverdueNum(BigDecimal.ZERO) ;
				   //设置 损失金额
				  custInfoVO.setLossAmt(BigDecimal.ZERO) ;   
				  //设置 总通道费用
				  custInfoVO.setTotalChanFee(BigDecimal.ZERO) ;   
				  //设置 总收益
				  custInfoVO.setTotalIncome(BigDecimal.ZERO) ;
				//获得业务汇总相关的信息
				  custInfoVO = getbussTotal(conn,custInfoVO);
				//获得财务报表相关的信息
				  custInfoVO =getFinCWZBInfo(conn,custInfoVO); 
				count++;
				list.add(custInfoVO);
			}
			System.out.println("客户数量为："+count);
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		return list;
	}
	/**
	 * 获得业务汇总相关的信息
	 * @param conn
	 * @param custInfoVO
	 * @return
	 * @throws Exception
	 */
	public static  OCrmInfoAnalysis getbussTotal(Connection conn,OCrmInfoAnalysis custInfoVO) throws Exception{
		//总贷款额
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select nvl(sum(nvl(t.lnci_amt,0)),0) LNCI_AMT, nvl(max(t.AMOUNT_OUT),0) AMOUNT_OUT from  B_LAN_LNCI_BASE t"  //amountOut
				+" where T.CUSTCD=?";
		PreparedStatement repaypstmt = null;
		ResultSet repayrs = null;
		String repaysql = " SELECT nvl(max(t.PAY_AMOUNT),0) PAY_AMOUNT from  R_BCP_DEBT_BASE_INFO t"  //amountOut
				+" where T.CUSTCD_BUYER=?";
		BigDecimal repaymentAmt = BigDecimal.ZERO; //累计提货金额+累计还款金额
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,StringUtils.trim(custInfoVO.getCustcd()));
			rs = pstmt.executeQuery();
			if(rs.next()){
			  //获得业务汇总相关的信息
			   custInfoVO.setTotalLoanAmt(rs.getBigDecimal("LNCI_AMT")); //总贷款额
			   repaymentAmt = repaymentAmt.add(rs.getBigDecimal("AMOUNT_OUT")); //累计提货金额
			}
			
			repaypstmt = conn.prepareStatement(repaysql);
			repaypstmt.setString(1,StringUtils.trim(custInfoVO.getCustcd()));
			repayrs = repaypstmt.executeQuery();
			if(repayrs.next()){
			   repaymentAmt = repaymentAmt.add(repayrs.getBigDecimal("PAY_AMOUNT")); //累计还款金额
			}
			custInfoVO.setRepaymentAmt(repaymentAmt);
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(repayrs!=null) repayrs.close();
			if(repaypstmt!=null) repaypstmt.close();
		}
		return custInfoVO;
		
	}
	
	/**
	 * 获得财务相关的信息
	 * @param conn
	 * @param custInfoVO
	 * @return
	 * @throws Exception
	 */
	public static  OCrmInfoAnalysis getFinCWZBInfo(Connection conn,OCrmInfoAnalysis custInfoVO) throws Exception{
		//总贷款额
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//查询财务报表CWZB中月报，月报周期的
		String sql = " SELECT t.SUBJ_ID,MAX(t.SUBJ_NM) SUBJ_NM,SUM(t.COL_VAL1)COL_VAL1,t.RPT_NO " 
				+" FROM B_FIN_CUST_DS t"
				+" WHERE 1=1 AND t.fin_dir_id IN "
				+" (SELECT  s.fin_dir_id FROM B_FIN_CUST_DIR s WHERE 1=1 AND SUBSTR(s.mdl_id,5,4)='CWZB' AND s.FIN_PD='01' and s.cust_id =?  )"
				+" AND t.RP_SOURCE ='01'"
				+" GROUP BY t.SUBJ_ID,t.RPT_NO";
		
		
		// 查询资产负债表年度的相关信息
		PreparedStatement pstmtZCFZ = null;
		ResultSet rsZCFZ = null;
		//获得 应收帐款占比 ， 预付款占比  ,年度应收帐款 ,年度应付账款 
		String sqlZCFZ =  "SELECT t.SUBJ_ID,MAX(t.SUBJ_NM) SUBJ_NM,SUM(t.COL_VAL1)COL_VAL1" 
				+" FROM B_FIN_CUST_DS t"
				+" WHERE 1=1 AND t.fin_dir_id IN "
				+" (SELECT  s.fin_dir_id FROM B_FIN_CUST_DIR s WHERE 1=1 AND SUBSTR(s.mdl_id,5,4)='ZCFZ' AND s.FIN_PD='04' and s.cust_id =?  )"
				+" AND t.RP_SOURCE ='04'"
				+"GROUP BY t.SUBJ_ID,t.RPT_NO";
		
		// 查询损益表年度的相关信息
		PreparedStatement pstmtSYB = null;
		ResultSet rsSYB = null;
		//获得 营业收入 
		String sqlSYB =  "SELECT t.SUBJ_ID,MAX(t.SUBJ_NM) SUBJ_NM,SUM(t.COL_VAL1)COL_VAL1" 
				+" FROM B_FIN_CUST_DS t"
				+" WHERE 1=1 AND t.fin_dir_id IN "
				+" (SELECT  s.fin_dir_id FROM B_FIN_CUST_DIR s WHERE 1=1 AND SUBSTR(s.mdl_id,5,4)='SYB' AND s.FIN_PD='04' and s.cust_id =?  )"
				+" AND t.RP_SOURCE ='04'"
				+" GROUP BY t.SUBJ_ID,t.RPT_NO";
				
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,StringUtils.trim(custInfoVO.getCustcd()));
			rs = pstmt.executeQuery();
			while(rs.next()){
				String  subjId =rs.getString("SUBJ_ID");
				BigDecimal  colVal =rs.getBigDecimal("COL_VAL1")==null?BigDecimal.ZERO:rs.getBigDecimal("COL_VAL1");
				if("CWZB0832".equals(subjId)){ //运营毛利润率(%)
					custInfoVO.setProfitRate(colVal); //利润率
				}else if("CWZB0104".equals(subjId)){ //销售收入增长率(%)
					custInfoVO.setSaleGrowthRate(colVal); //销售增长率
				}else if("CWZB0834".equals(subjId)){ //净利润率(%)
					custInfoVO.setSalesProfitRate(colVal); //销售利润率
				} 
			}
			
			//资产负债
			pstmtZCFZ = conn.prepareStatement(sqlZCFZ);
			pstmtZCFZ.setString(1,StringUtils.trim(custInfoVO.getCustcd()));
			rsZCFZ = pstmtZCFZ.executeQuery();
			BigDecimal annualRec =BigDecimal.ZERO;  //应收账款
			BigDecimal annualPay =BigDecimal.ZERO;  //应付账数
			BigDecimal prepay =BigDecimal.ZERO;  //预付款
			BigDecimal totalFlowAmt =BigDecimal.ZERO;   //流动资产合计 
			BigDecimal recRate =BigDecimal.ZERO;   //应收帐款占比 
			BigDecimal prepayRate =BigDecimal.ZERO;   //预付款占比 
		
			while(rsZCFZ.next()){
				//应收帐款占比= 应收帐款/流动资产合计
				//预付款占比 = 预付款 /流动资产合计
				String  subjId =rsZCFZ.getString("SUBJ_ID");
				BigDecimal  colVal =rsZCFZ.getBigDecimal("COL_VAL1")==null?BigDecimal.ZERO:rsZCFZ.getBigDecimal("COL_VAL1");
				if("ZCFZ1142".equals(subjId)){ //应收账款
					annualRec =colVal;
				}else if("ZCFZ2122".equals(subjId)){ //　应付账款
					annualPay =colVal;
				} else if("ZCFZ1152".equals(subjId)){ //　预付款项
					prepay =colVal;
				} else if("ZCFZ1100".equals(subjId)){ //ZCFZ1100 流动资产合计
					totalFlowAmt =colVal;
				}   
			}
			if(!totalFlowAmt.equals(BigDecimal.ZERO)){
				recRate = annualRec.multiply(new BigDecimal(100)).divide(totalFlowAmt, 2, BigDecimal.ROUND_DOWN);
				prepayRate = prepay.multiply(new BigDecimal(100)).divide(totalFlowAmt, 2, BigDecimal.ROUND_DOWN);
			}
			
			custInfoVO.setAnnualRec(annualRec); //年度应收账数
			custInfoVO.setAnnualPay(annualPay); //年度应付账数
			custInfoVO.setRecRate(recRate); //应收帐款占比 
			custInfoVO.setPrepayRate(prepayRate);////预付款占比 
			
			//损益表
			
			pstmtSYB = conn.prepareStatement(sqlSYB);
			pstmtSYB.setString(1,StringUtils.trim(custInfoVO.getCustcd()));
			rsSYB = pstmtSYB.executeQuery();
			while(rsSYB.next()){
				String  subjId =rsSYB.getString("SUBJ_ID");
				BigDecimal  colVal =rsSYB.getBigDecimal("COL_VAL1")==null?BigDecimal.ZERO:rsSYB.getBigDecimal("COL_VAL1");
				if("SYB3100".equals(subjId)){ //营业收入
					custInfoVO.setAnnualSalesAmt(colVal); //年度销售额 
				}
			}
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(rsZCFZ!=null) rsZCFZ.close();
			if(pstmtZCFZ!=null) pstmtZCFZ.close();
			if(rsSYB!=null) rsSYB.close();
			if(pstmtSYB!=null) pstmtSYB.close();
		}
		return custInfoVO;
		
	}
	//
	public static  List<OFinaStaAnalysis> getFinaStaAnalysis(Connection conn) throws Exception{
		List<OFinaStaAnalysis> list = new ArrayList<OFinaStaAnalysis>();
		PreparedStatement pstmtin = null;
		ResultSet rsin = null; //产品收入信息
	
		String insql = " SELECT  t.PRODUCT_ID,max(p.product_name) PRODUCT_NAME,sum(t.lnci_amt) LNCI_AMT,t.START_DATE "  //amountOut
				+" FROM B_LAN_LNCI_BASE t,B_PRD_INFO  p"
				+" WHERE 1 = 1 AND t.product_id = p.product_id "
				+" GROUP BY t.product_id,t.START_DATE ORDER BY sum(t.lnci_amt) desc";
		
		//支出
		PreparedStatement pstmtout = null;
		ResultSet rsout = null; //产品支出信息
		//查询现金流量中月报，月报周期的 --经营活动现金流出小计,投资活动现金流出小计,筹资活动现金流出小计 的金额
		String outsql = " SELECT t.SUBJ_ID,MAX(t.SUBJ_NM) SUBJ_NM,SUM(t.COL_VAL1)COL_VAL1,t.RPT_NO " 
				+" FROM B_FIN_CUST_DS t"
				+" WHERE 1=1 AND t.fin_dir_id IN "
				+" (SELECT  s.fin_dir_id FROM B_FIN_CUST_DIR s WHERE 1=1 AND SUBSTR(s.mdl_id,5,4)='XJLL' AND s.FIN_PD='01' )"
				+" AND t.RP_SOURCE ='01' AND t.COL_VAL1 <>0 AND t.SUBJ_ID IN('XJLL4125','XJLL4227','XJLL4317')"
				+" GROUP BY t.SUBJ_ID,t.RPT_NO";
		try {
			int count=0;
			pstmtin = conn.prepareStatement(insql);
			rsin = pstmtin.executeQuery();
			while(rsin.next()){
				OFinaStaAnalysis info = new OFinaStaAnalysis();
				info.setAmount(rsin.getBigDecimal("LNCI_AMT")); 
				info.setFinaType("1");  //收入
				info.setProjectId(rsin.getString("PRODUCT_ID"));
				info.setProject(rsin.getString("PRODUCT_NAME"));
				info.setFinaDate(rsin.getString("START_DATE"));
				list.add(info);
				count++;
			}
			System.out.println("收入的条数为"+count);
			pstmtout = conn.prepareStatement(outsql);
			rsout = pstmtout.executeQuery();
			int outcount=0;
			while(rsout.next()){
				OFinaStaAnalysis info = new OFinaStaAnalysis();
				String subjNm = StringUtils.trim(rsout.getString("SUBJ_NM"));
				info.setAmount(rsout.getBigDecimal("COL_VAL1")); 
				info.setFinaType("2");  //支出
				info.setProjectId(rsout.getString("SUBJ_ID"));
				info.setProject(subjNm);
				if(null!=rsout.getString("RPT_NO")){
					info.setFinaDate(rsout.getString("RPT_NO")+"01");
				}
				
				list.add(info);
				outcount++;
			}
		System.out.println("支出的条数为"+outcount);
		} finally {
			if(rsin!=null) rsin.close();
			if(pstmtin!=null) pstmtin.close();
			if(rsout!=null) rsout.close();
			if(pstmtout!=null) pstmtout.close();
		}
		return list;
		
	}
}


