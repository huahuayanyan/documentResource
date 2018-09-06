package com.huateng.scf.bas.batch.warnbatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.huateng.scf.bas.batch.control.scf.vo.WarnVO;

/**
 * company: ShangHai HuaTeng Software System CO.,LTD.
 * file name：BatchLoanLnciDueWarn.java
 * description：借据到期敞口未结清预警
 * author: zhaoyang.lv;
 * JDK version: <1.6.0>
 * project : SupplyChainSysBatch <1.0> <br>
 * modified history  <br>
 *  date:2017-05-25    | author: fangquan <br>
 */
@SuppressWarnings("unused")
public class BatchLnciExposureDueWarn extends BatchTemplet{

	private Connection conn;
	public BatchLnciExposureDueWarn(Integer _id, String threadName, String _brcode) {
		super(_id, threadName, _brcode);
	}
  
	public BatchLnciExposureDueWarn(Integer _id, String threadName) {
		super(_id, threadName);
	}

	@Override
	protected void doProcess() throws Exception {

		Map<String, String > newWarn = new HashMap<String, String>();

		conn = this.getConn();
		WarnVO warnVO = CommonService.getWarnParam(conn, this.getClass().getName());
		String strBhdate = this.getBhdate();//yyyy-MM-dd

		java.util.Date nowDate = DateUtil.stringToDate(strBhdate);
		String strEndDate = DateUtil.dateToString(DateUtil.getEndDateByDays(nowDate, Integer.parseInt(warnVO.getWarnLevelLow())));
		java.sql.Date nowSqlDate = java.sql.Date.valueOf(strBhdate.substring(0, 10));
		java.sql.Date endSqlDate = java.sql.Date.valueOf(strEndDate);
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs4 = null;
		PreparedStatement pstmt5 = null;
		ResultSet rs5 = null;
		PreparedStatement pstmt6 = null;
		ResultSet rs6 = null;

		StringBuffer queryWarnLnciInfo = new StringBuffer();//查询需要预警的借据
		queryWarnLnciInfo.append("select bllb.DEBET_NO, bllb.END_DATE, bllb.MAST_CONTNO  ")
		.append(" from B_LAN_LNCI_BASE bllb, B_CRR_LN_CON  bclc where  bllb.MAST_CONTNO=bclc.APP_ID and bclc.VID_BUSI_TYP='1210010' ")
		.append(" and (bllb.LNCI_BAL-bllb.ADD_BAIL_AMOUNT-bllb.BAIL_AMOUNT) >0 ")
		.append(" and bllb.LNCI_STATUS = '"+SystemConstant.LNCI_STATUS_EFFECT +"' and bllb.END_DATE>=?  and  bllb.END_DATE <= ?  ");

		StringBuffer insertWarnBase = new StringBuffer();//新增预警基本信息
		insertWarnBase.append("insert into B_WRN_BASE_INFO(ID, PARAM_ID, WARN_DATE, WARN_LEVEL, STATUS, CUST_MANAGER, BRCODE) ")
		.append("  values(?, ?, ?, ?, ?, ?, ?) ");

		StringBuffer insertWarnDue = new StringBuffer();//新增到期预警信息
		insertWarnDue.append("insert into B_WRN_DUE_INFO(ID, WARN_ID, BUSINESSNO_TYPE, BUSINESSNO) ")
		.append("  values(?, ?, ?, ?)");

		StringBuffer queryWarnDue = new StringBuffer();//查询预警到期信息
		queryWarnDue.append("select twdi.WARN_ID, twbi.WARN_LEVEL, twbi.STATUS ")
		.append(" from B_WRN_DUE_INFO twdi , B_WRN_BASE_INFO twbi ")
		.append(" where twdi.WARN_ID=twbi.ID and  twdi.BUSINESSNO_TYPE = '"+SystemConstant.BUSINESS_TYPE_LNCI_EXPOSURE+"' and twdi.BUSINESSNO = ?");

		StringBuffer updateWarn = new StringBuffer();//修改预警基本信息
		updateWarn.append(" update B_WRN_BASE_INFO twbi ")
		.append(" set twbi.WARN_LEVEL=?, twbi.STATUS=? ")
		.append(" where twbi.Id=? ");

		StringBuffer queryMgrnoAndBrcode = new StringBuffer();//查询客户经理及机构 MGRNO       BRCODE  MAST_CONTNO换
		queryMgrnoAndBrcode.append("select tcbi.TLR_NO, tcbi.BR_CD from B_CRR_LN_CON tcbi where tcbi.APP_ID=?");

		StringBuffer queryAllWarnDue = new StringBuffer();//查询所有借据预警信息
		queryAllWarnDue.append(" select twdi.ID, twdi.WARN_ID, twdi.BUSINESSNO from B_WRN_DUE_INFO twdi ")
		.append(" where twdi.BUSINESSNO_TYPE = '"+SystemConstant.BUSINESS_TYPE_LNCI_EXPOSURE +"'");

		StringBuffer deleteWarnBase = new StringBuffer();//删除预警基本信息
		deleteWarnBase.append("delete from B_WRN_BASE_INFO t where t.id = ?");

		StringBuffer deleteWarnDue = new StringBuffer();//删除到期预警信息
		deleteWarnDue.append("delete from B_WRN_DUE_INFO t where t.id = ?");


		this.writeFileLog("###########借据到期敞口未结清预警 start ");
		try{
			pstmt1 = conn.prepareStatement(queryWarnLnciInfo.toString());
			
			pstmt1.setString(1, nowSqlDate.toString().replace("-",""));  
			pstmt1.setString(2, endSqlDate.toString().replace("-","")); 
			rs1 = pstmt1.executeQuery();
			while(rs1.next()){
				String debetNo = rs1.getString("DEBET_NO");
				String endDate = rs1.getString("END_DATE");
				String mastContno = rs1.getString("MAST_CONTNO");
 				newWarn.put(debetNo, debetNo);
				this.writeFileLog("############本次到期预警借据："+debetNo);
                
				java.util.Date endDate1 = DateUtil.numberToDate(endDate);
				String warnLevel = CommonService.getWarnDueLevel(warnVO, nowDate, endDate1);

				try {
					pstmt2 = conn.prepareStatement(queryWarnDue.toString());
					pstmt2.setString(1, debetNo);
					rs2 = pstmt2.executeQuery();
					if(rs2.next()){//存在记录
						String warnId = rs2.getString("WARN_ID");
						String oldWarnLevel = rs2.getString("WARN_LEVEL");
						String status = rs2.getString("STATUS");
						String nowWarnLevel = null;
						boolean flag = false;
						if(!warnLevel.equals(oldWarnLevel)){//预警级别变化
							if(SystemConstant.WARN_STATUS_SUSPEND.equals(status)||SystemConstant.WARN_STATUS_EFFICT.equals(status)){//忽略,改为有效
								flag = true;
								status = SystemConstant.WARN_STATUS_EFFICT;
							}
						}
						if(flag){//执行update
							pstmt3 = conn.prepareStatement(updateWarn.toString());
							pstmt3.setString(1, warnLevel);
							pstmt3.setString(2, status);
							pstmt3.setString(3, warnId);
							int i = pstmt3.executeUpdate();
							if(i<=0){
								throw new Exception("#############update rows :"+i+", update sql:"+updateWarn);
							}

						}
					}else{//不存在记录，新增记录
						pstmt3 = conn.prepareStatement(queryMgrnoAndBrcode.toString());
						pstmt3.setString(1, mastContno);
						rs3 = pstmt3.executeQuery();
						String mgrno = null;
						String brcode = null;
						if(rs3.next()){
							mgrno = rs3.getString("BR_CD");
							brcode = rs3.getString("TLR_NO");
						}
						if(DataFormat.isEmpty(mgrno)||DataFormat.isEmpty(brcode)){//后续处理
							mgrno = "";
							brcode = "";
						}

						String warnBaseId = BatchUtil.getUUID();
						pstmt4 = conn.prepareStatement(insertWarnBase.toString());
						pstmt4.setString(1, warnBaseId);
						pstmt4.setString(2, warnVO.getWarnNo());
						pstmt4.setString(3,nowSqlDate.toString().replace("-",""));//
						pstmt4.setString(4, warnLevel);
						pstmt4.setString(5, SystemConstant.WARN_STATUS_EFFICT);
						pstmt4.setString(6, mgrno);
						pstmt4.setString(7, brcode);
						int i = pstmt4.executeUpdate();
						if(i<=0){
							throw new Exception("#############insert rows : "+i+", insert sql:"+insertWarnBase);
						}

						if(pstmt4!=null)pstmt4.close();

						pstmt4 = conn.prepareStatement(insertWarnDue.toString());//ID, WARN_ID, BUSINESSNO_TYPE, BUSINESSNO
						pstmt4.setString(1, BatchUtil.getUUID());
						pstmt4.setString(2, warnBaseId);
						pstmt4.setString(3, SystemConstant.BUSINESS_TYPE_LNCI_EXPOSURE);
						pstmt4.setString(4, debetNo);
						i = pstmt4.executeUpdate();
						if(i<=0){
							throw new Exception("#############insert rows : "+i+", insert sql:"+insertWarnDue);
						}
					}

				} finally{
					if(rs3!=null)rs3.close();
					if(pstmt3!=null)pstmt3.close();
					if(pstmt4!=null)pstmt4.close();
					if(rs2!=null)rs2.close();
					if(pstmt2!=null)pstmt2.close();
				}
			}

			pstmt5 = conn.prepareStatement(queryAllWarnDue.toString());
			rs5 = pstmt5.executeQuery();
			while(rs5.next()){
				String id = rs5.getString("ID");
				String warnId = rs5.getString("WARN_ID");
				String businessno = rs5.getString("BUSINESSNO");
				if(!newWarn.containsKey(businessno)){//预警范围外，删除
					try {
						pstmt6 = conn.prepareStatement(deleteWarnBase.toString());
						pstmt6.setString(1, warnId);
						int i = pstmt6.executeUpdate();
						if(i<=0){
							throw new Exception("#############delete rows : "+i+" ,delete sql:"+deleteWarnBase);
						}

						if(pstmt6!=null){
							pstmt6.close();
						}

						pstmt6 = conn.prepareStatement(deleteWarnDue.toString());
						pstmt6.setString(1, id);
						i = pstmt6.executeUpdate();

						if(i<=0){
							throw new Exception("#############delete rows : "+i+" ,delete sql:"+deleteWarnDue);
						}
					} finally {
						if(pstmt6!=null){
							pstmt6.close();
						}
					}
				}
			}
			this.writeFileLog("############借据到期敞口未结清预警 end");
			conn.commit();
		}finally{

			if(rs5!=null)rs5.close();
			if(pstmt5!=null)pstmt5.close();

			if(rs1!=null)rs1.close();
			if(pstmt1!=null)pstmt1.close();
		}
	}
}
