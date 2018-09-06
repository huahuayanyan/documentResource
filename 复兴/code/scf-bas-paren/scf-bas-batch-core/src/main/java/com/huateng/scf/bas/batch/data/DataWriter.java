/**
 * <p>@Title: 交通银行个人贷款管理系统</p>
 * <p>@Description: </p>
 * <p>@Created time: Jun 17, 2005 8:01:36 PM</p>
 * <p>@Company:上海华腾软件系统有限公司</p>
 * <p>@author Ranger.Mao</p>
 */

/*
 * change activity:
 *
 * Reason  Date        Origin     Description
 * ------  --------    ---------  ------------------------------
 *         2007-08-31  Farly.yu   新增方法 void writeList(list)
 */

package com.huateng.scf.bas.batch.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;

import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.common.DateUtil;


public class DataWriter {
//	private BufferedWriter writer=null;
//	private String reportGenPath=null;
//	private StringBuffer stringBuffer=new StringBuffer();
//	private boolean isTop=true;
//	public DataWriter(Date date,String subPathName,String brcode,String fileName,String extName) throws Exception{
//		reportGenPath=BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"");
//		if ("".equals(reportGenPath))
//			throw new Exception(
//				BatchConstant.BATCH_PROPERTY_FILE
//					+ BatchUtil.convert("中")
//					+ BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH
//					+ BatchUtil.convert("未配置!"));
//		if (!reportGenPath.substring(reportGenPath.length() - 1, reportGenPath.length()).equals("/")
//			&& !reportGenPath.substring(reportGenPath.length() - 1, reportGenPath.length()).equals("\\"))
//			reportGenPath += "/";
//		reportGenPath+=BatchUtil.dateToString(date)+"/";
//		if (subPathName!=null)
//			reportGenPath +=subPathName+"/";
//		File file = new File(reportGenPath);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//		reportGenPath +=fileName;
//		if (brcode!=null)
//			reportGenPath +="_"+brcode+extName;
//		this.writer=new BufferedWriter(new FileWriter(reportGenPath));
//	}
//
//	/**
//	 * 将数组内容写入文件
//	 * @param String[] strs
//	 * @throws IOException
//	 */
//	public void write(String[] strs) throws IOException{
//		if (isTop){
//			isTop=false;
//		}else
//			this.writer.newLine();
//		stringBuffer.delete(0,stringBuffer.length());
//		for (int cnt=0;cnt<strs.length;cnt++){
//			if (cnt>0) stringBuffer.append(",");
//			stringBuffer.append(strs[cnt]);
//		}
//		this.writer.write(stringBuffer.toString());
//	}
//
//	/**
//	 * 关闭文件
//	 * @throws IOException
//	 */
//	public void close() throws IOException{
//		this.writer.close();
//	}
//
//
//	/**
//	 * @Title:
//	 * @Description:
//	 * @return
//	 * @author Ranger.Mao
//	 * @Created time: Jun 20, 2005 12:01:15 PM
//	 */
//	public String getReportGenPath() {
//		return reportGenPath;
//	}
//
//
//	/**
//	 * 将list内容写入文件
//	 * @author farly.yu
//	 * @date Oct,31 2007
//	 * @param ArrayList list
//	 * @throws Exception
//	 */
//	public void writeList(ArrayList list) throws Exception {
//		if (list == null) return;
//		if (list.size() <= 0 ) return;
//		Object o = null;
//		for (int i=0; i<list.size(); i++) {
//			o = list.get(i);
//			if (o instanceof String[]) {
//				write((String[])o);
//			}
//		}
//	}
	private BufferedWriter writer=null;
	private String reportGenPath=null;
//	private String aceGenPath=null;//核算部分路径
	private String reportSavePath=null;//导出报表存放路径
	private String reportCheckPath=null;//导出报表存放路径
	private StringBuffer stringBuffer=new StringBuffer();
	private boolean isTop=true;
	public DataWriter(){
		super();

	}
	public DataWriter(Date date,String brcode,String fileName) throws Exception{
		reportGenPath=BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"");
		if ("".equals(reportGenPath))
			throw new Exception(
				BatchConstant.BATCH_PROPERTY_FILE + "中"
					+ BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH + "未配置!");
		if (!reportGenPath.substring(reportGenPath.length() - 1, reportGenPath.length()).equals(File.separator)
			&& !reportGenPath.substring(reportGenPath.length() - 1, reportGenPath.length()).equals(File.separator))
			reportGenPath += File.separator;
		reportGenPath+=DateUtil.dateToNumber(date)+File.separator;
		reportGenPath+=brcode+File.separator;



		File file = new File(reportGenPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		reportGenPath += (brcode + "-" + DateUtil.dateToNumber(date) + "-");
		reportGenPath +=fileName;
		this.writer=new BufferedWriter(new FileWriter(reportGenPath));
	}


//	public DataWriter(Date date,String fileName) throws Exception{
//		aceGenPath=BatchUtil.getBatchProperty(BatchConstant.BATCH_TLA_ACE_FILE_PATH,"");
//		if ("".equals(aceGenPath))
//			throw new Exception(
//				BatchConstant.BATCH_PROPERTY_FILE + "中"
//					+ BatchConstant.BATCH_TLA_ACE_FILE_PATH + "未配置!");
//		if (!aceGenPath.substring(aceGenPath.length() - 1, aceGenPath.length()).equals(File.separator)
//			&& !aceGenPath.substring(aceGenPath.length() - 1, aceGenPath.length()).equals(File.separator))
//			aceGenPath += File.separator;
//		aceGenPath+=DateUtil.dateToNumber(date)+File.separator;
//		File file = new File(aceGenPath);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//
////		aceGenPath += (brcode + "-" + DateUtil.dateToNumber(date) + "-");
//		aceGenPath +=fileName;
//		this.writer=new BufferedWriter(new FileWriter(aceGenPath));
//	}


	public boolean CheckReportStyleFile(Date date,String brcode,String fileName)throws Exception{
		reportCheckPath=BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"");
		if ("".equals(reportGenPath))
			throw new Exception(
				BatchConstant.BATCH_PROPERTY_FILE + "中"
					+ BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH + "未配置!");
		if (!reportCheckPath.substring(reportCheckPath.length() - 1, reportCheckPath.length()).equals("/")
			&& !reportCheckPath.substring(reportCheckPath.length() - 1, reportCheckPath.length()).equals("\\"))
			reportCheckPath += File.separator;
		reportCheckPath+=DateUtil.dateToNumber(date)+File.separator;
		reportCheckPath+=brcode+File.separator;
		reportCheckPath += (brcode + "-" + DateUtil.dateToNumber(date) + "-");
		reportCheckPath +=fileName;
		File file = new File(reportCheckPath);
		if (!file.exists()) {
			return false;
		}else{
		reportSavePath=File.separator+DateUtil.dateToNumber(date)+File.separator+brcode+File.separator;
		return true;
		}

	}

	/**
	 * 将数组内容写入文件
	 * @param String[] strs
	 * @throws IOException
	 */
	public void write(String[] strs) throws IOException{
		if (isTop){
			isTop=false;
		}else
			this.writer.newLine();
		stringBuffer.delete(0,stringBuffer.length());
		for (int cnt=0;cnt<strs.length;cnt++){
			if (cnt>0) stringBuffer.append(",");
			stringBuffer.append(strs[cnt]);
		}
		this.writer.write(stringBuffer.toString());
	}


	public void print(String value) throws IOException {
		this.writer.write(value);

	}


	public void println(String value) throws IOException {
		this.writer.write(value);
		this.writer.newLine();
	}


	public void close() throws IOException{
		this.writer.close();
	}


	public String getReportGenPath() {
		return reportGenPath;
	}

	public String getReportSavePath(){
		return reportSavePath;
	}
	public String getReportCheckPath(){
		return reportCheckPath;
	}
}
