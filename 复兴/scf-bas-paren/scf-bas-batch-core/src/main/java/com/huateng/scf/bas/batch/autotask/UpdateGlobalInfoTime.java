package com.huateng.scf.bas.batch.autotask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huateng.base.task.vo.TaskExecContext;
import com.huateng.base.task.vo.TaskExecResult;
import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.common.DateUtil;
import com.huateng.scf.bas.batch.vo.BSysGlobalInfo;
/**
 * <p>Title:B_SYS_GLOBAL_INFO表每晚零点定时更新</p>
 * <p>Description: </p>
 * @author fangquan
 * @version:2017-05-27 15:31:11
 */
public class UpdateGlobalInfoTime  {
	private Connection conn;
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	public UpdateGlobalInfoTime(){} 

private Logger logger = LoggerFactory.getLogger(getClass());
	
	private Integer count = 0;
	
	public TaskExecResult handle(TaskExecContext context){
		logger.info("==========the timed task has been invoked=={}============" , context.getContext().get("test"));
		count ++;
		System.out.println("定时调度任务开始执行。。。。每晚零点更新B_SYS_GLOBAL_INFO表"+new Date());
	    TaskExecResult tr= new TaskExecResult(true);
	    //更新 交易日期、批量日期 、上一批量日期
	    try {
			this.updateGlobalinfo();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
/*		Map<String,String> m = new HashMap<String,String>();
		m.put("a", "1");
		context.setTaskContext(m);*/
		return tr;
	}
	
	private int updateGlobalinfo() throws Exception{
		try {
			this.conn = this.dataSource.getConnection();
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		PreparedStatement pstmt = null;
		StringBuffer upGlobal=new StringBuffer();
		upGlobal.append("update B_SYS_GLOBAL_INFO ")
				.append("set  TBSDY=?, BHDATE =?, LBHDATE=?  where id ='" +BatchConstant.TABLE_GLOBAL_INFO_ID+"'");
		
		BSysGlobalInfo gb = BatchUtil.getGlobalInfo(conn);
	    Date txdate1 = DateUtil.numberToDate(gb.getTxdate().replace("-", ""));
	    Date bhdate1 = DateUtil.numberToDate(gb.getBhdate().replace("-", ""));
	    Date lbhdate1 = DateUtil.numberToDate(gb.getLbhdate().replace("-", ""));
	    
		Calendar cal1=Calendar.getInstance(); 
		cal1.setTime(txdate1);
		cal1.add(Calendar.DATE, 1);
		
		Calendar cal2=Calendar.getInstance(); 
		cal2.setTime(bhdate1);
		cal2.add(Calendar.DATE, 1);
		
		Calendar cal3=Calendar.getInstance(); 
		cal3.setTime(lbhdate1);
		cal3.add(Calendar.DATE, 1);
		
		try {
			pstmt = conn.prepareStatement(upGlobal.toString());
		
			pstmt.setString(1, DateUtil.dateToNumber(cal1.getTime()));
			pstmt.setString(2, DateUtil.dateToNumber(cal2.getTime()));
			pstmt.setString(3, DateUtil.dateToNumber(cal3.getTime()));
			int i = pstmt.executeUpdate();
			if(i<=0){
				throw new Exception("#############update rows :"+i+", update sql:"+upGlobal);
			}	
			return i;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally{
			if(conn != null){conn.close();}
			if(pstmt!= null){pstmt.close();}
		}
		return 0;
	}
	
	public void clear(){
		count = 0;
	}
	
	public Integer getCount(){
		return count;
	}
	
}
