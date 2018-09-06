/**
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2007-2008 Huateng Software System.  All rights
 * reserved.
 * @author MAIK.CHEN
 * create time :2008-02-17 16:45:38
 * ==================================================================
 */
package com.huateng.scf.bas.batch.report.adapter;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import com.huateng.common.CommonFunction;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.scf.bas.batch.report.ReportDataSource;
import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.exception.AppException;

public class ReportSqlService {

//	private static JasperPrint jasperPrint;
	private static String jasperEx=".jasper";

	/**
	 *
	 */
	public ReportSqlService() {
		super();
	}

	/**
	 *
	 * @param rs 获取RESULTSET结果；
	 * @param loadTemplet  加载报表模板文件（指定的路径下）
	 * @param parameters   报表参数值填写的内容
	 * @param tagReporName 生成报表的名称
	 * @param reportFlag   要生成的报表
	 * @param brno 机构、或是别的一类值
	 * @param datepath 以日期为路径（文件包）
	 * @throws Exception
	 */
	public static void createReport(ResultSet rs, String loadTemplet,
			Map parameters,String tagReporName,String reportFlag,String brno,String datepath
			) throws Exception {
		JasperReport fillTemp = loadReportTemplate(loadTemplet);
		JasperPrint jasperPrint = JasperFillManager.fillReport(fillTemp, parameters,
		getDs2(rs));
		//根据批量日期和机构产生路径
		String filepath= File.separator+datepath + File.separator + brno;

//		生产报表标志
//		1-EXCL报表        getEXCEL(jasperPrint, tagReporName);
//		2-PDF 报表        getPDF(jasperPrint, tagReporName);
//		3-HTML 报表       getHTML(jasperPrint, tagReporName);
//		4-RTF(WORD)报表  getRTF(jasperPrint, tagReporName);
//		5-CVS报表         getCSV(jasperPrint, tagReporName);
//		如：[1-0-1-1-0]
//		说明产出报表1、3、4对应的报表
		if(reportFlag==null || reportFlag.length()==0){
			System.out.println("批处理配置表的生产报表标志设置错误！");
			return ;
		}
		String report[]=reportFlag.trim().split("-");
		//与上面注释对应
		if(report[0].trim().equals("1")){
			getEXCEL(tagReporName,filepath,jasperPrint);
		}
        if(report[1].trim().equals("1")){
        	getPDF(tagReporName,filepath,jasperPrint);
		}
        if(report[2].trim().equals("1")){
        	getHTML(tagReporName,filepath,jasperPrint);
		}
        if(report[3].trim().equals("1")){
        	getRTF( tagReporName,filepath,jasperPrint);
		}
        if(report[4].trim().equals("1")){
        	getCSV( tagReporName,filepath,jasperPrint);
		}

	}

	/**
	 * @param list 获取生成报表数据结果集
	 * @param loadTemplet  加载报表模板文件（指定的路径下）
	 * @param parameters   报表参数值填写的内容
	 * @param tagReporName 生成报表的名称
	 * @param reportFlag   要生成的报表
	 * @param brno 机构、或是别的一类值
	 * @param datepath 以日期为路径（文件包）
	 * @throws Exception
	 */
	public static void createReportByList(List list, String loadTemplet,
			Map parameters,String tagReporName,String reportFlag,String brno,String datepath
			) throws Exception {
		JasperReport fillTemp = loadReportTemplate(loadTemplet);
		JasperPrint jasperPrint = JasperFillManager.fillReport(fillTemp, parameters,
				new ReportDataSource(list));
		String filepath= "/"+datepath + "/" + brno;

//		生产报表标志
//		1-EXCL报表        getEXCEL(jasperPrint, tagReporName);
//		2-PDF 报表        getPDF(jasperPrint, tagReporName);
//		3-HTML 报表       getHTML(jasperPrint, tagReporName);
//		4-RTF(WORD)报表  getRTF(jasperPrint, tagReporName);
//		5-CVS报表         getCSV(jasperPrint, tagReporName);
//		如：[1-0-1-1-0]
//		说明产出报表1、3、4对应的报表
		if(reportFlag==null || reportFlag.length()==0){
			System.out.println("批处理配置表的生产报表标志设置错误！");
			return ;
		}
		String report[]=reportFlag.trim().split("-");
		//与上面注释对应
		if(report[0].equals("1")){
			getEXCEL(tagReporName,filepath,jasperPrint);
		}
        if(report[1].equals("1")){
        	getPDF(tagReporName,filepath,jasperPrint);
		}
        if(report[2].equals("1")){
        	getHTML(tagReporName,filepath,jasperPrint);
		}
        if(report[3].equals("1")){
        	getRTF( tagReporName,filepath,jasperPrint);
		}
        if(report[4].equals("1")){
        	getCSV( tagReporName,filepath,jasperPrint);
		}

	}
	public static List loadDs(ResultSet rs)
			throws Exception {
		long s = System.currentTimeMillis();
		List l = new ArrayList();

		try {
			ResultSetMetaData rm = rs.getMetaData();
			List fields = new ArrayList();
			for (int i = 1; i <= rm.getColumnCount(); i++) {
				fields.add(rm.getColumnName(i));
			}
			int j = 0;
			while (rs.next()) {
				HashMap map = new HashMap();

				for (int i = 0; i < fields.size(); i++) {
					String fieldName = (String) fields.get(i);
					Object value = rs.getObject(fields.get(i).toString());
					if(value instanceof String) {
						value = value.toString().trim();
					}
					//map.put(fieldName.toUpperCase(), value);
					map.put(fieldName, value);
					//map.put(fields.get(i), rs.getObject(fields.get(i).toString()));
				}
				l.add(map);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		long e = System.currentTimeMillis();
		System.out.println("执行时间:time:" + (e - s));
		return l;
	}

	public static ReportDataSource getDs2(ResultSet rs)
			throws Exception {
		List list = loadDs(rs);
		return new ReportDataSource(list);
	}

	public static JasperReport loadReportTemplate(String fileName)
			throws Exception {
		String FILE_SUFFIX_JASPER = ".jasper";

		if (fileName == null || !fileName.endsWith(FILE_SUFFIX_JASPER)) {
			throw new Exception("error report.loadTemplatNotJasperFile");
		}
		return (JasperReport) JRLoader.loadObject(fileName);
	}

	public static void getEXCEL( String targetName,String filepath,JasperPrint jasperPrint)
			throws AppException {
		targetName = CommonFunction.stringEnd(targetName, BatchConstant.POINT
				+ BatchConstant.EXCEL_FILE_POSTFIX);

		String fileJasperPath = null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(
					BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH, "")+filepath;
		} catch (Exception e) {

			e.printStackTrace();
		}
		File file = new File(fileJasperPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		fileJasperPath = fileJasperPath + "/"+targetName;
//		System.out.println("JasperReportProcess::genEXCEL targetName = "
//				+ fileJasperPath);
		try {
			JRXlsExporter jrxe = new JRXlsExporter();
			jrxe.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			jrxe.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					fileJasperPath);
			jrxe.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.TRUE);
			jrxe.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
					Boolean.TRUE);
			jrxe.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			jrxe.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);
			jrxe.exportReport();
		} catch (net.sf.jasperreports.engine.JRException jasperEx) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.JASPERREPORTPROCESS_TOEXCEL_FAIL, jasperEx);
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.JASPERREPORTPROCESS_TOEXCEL_FAIL, ex);
		} catch (Throwable th) {
			th.printStackTrace();
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.JASPERREPORTPROCESS_TOEXCEL_FAIL);
		}
	}

	public static void getHTML(String targetName,String filepath,JasperPrint jasperPrint)throws AppException {
		targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.HTML_FILE_POSTFIX);

		String fileJasperPath=null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"")+filepath;
		} catch (Exception e) {

			e.printStackTrace();
		}
		File file = new File(fileJasperPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		fileJasperPath=fileJasperPath+ "/"+targetName;
		System.out.println("JasperReportProcess::genEXCEL targetName = " + fileJasperPath);
		try{
			JasperExportManager.exportReportToHtmlFile(jasperPrint, fileJasperPath);
		}catch(net.sf.jasperreports.engine.JRException jasperEx){
			throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOHTML_FAIL,jasperEx);
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOHTML_FAIL,ex);
		}catch(Throwable th){
    		throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOHTML_FAIL);
		}
	}
	public static void getPDF(String targetName,String filepath,JasperPrint jasperPrint)throws AppException{
		targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.PDF_FILE_POSTFIX);

		String fileJasperPath=null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"")+filepath;
		} catch (Exception e) {

			e.printStackTrace();
		}
		File file = new File(fileJasperPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		fileJasperPath=fileJasperPath+ "/"+targetName;
		System.out.println("JasperReportProcess::genPDF targetName = " + fileJasperPath);
		try{
			JasperExportManager.exportReportToPdfFile(jasperPrint, fileJasperPath);
		}
		catch(net.sf.jasperreports.engine.JRException jasperEx){
			throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOPDF_FAIL,jasperEx);
		}
		catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOPDF_FAIL,ex);
		}catch(Throwable th){
    		throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOPDF_FAIL);
		}
	}

	public static void getRTF(String targetName,String filepath,JasperPrint jasperPrint) throws AppException, JRException {

       targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.RTF_FILE_POSTFIX);
        System.out.println(targetName);
		String fileJasperPath=null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"")+filepath;
		} catch (Exception e) {

			e.printStackTrace();
		}

		File destFile = new File(fileJasperPath.toString(), targetName);
		System.out.println("JasperReportProcess::getRTF targetName = " + destFile.toString());
		JRRtfExporter exporter = new JRRtfExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());

		exporter.exportReport();

	}

	public static void getCSV(String targetName,String filepath,JasperPrint jasperPrint) throws JRException{

		targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.CSV_FILE_POSTFIX);

		String fileJasperPath=null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"")+filepath;
		} catch (Exception e) {

			e.printStackTrace();
		}

		File destFile = new File(fileJasperPath.toString(), targetName);
		System.out.println("JasperReportProcess::getCSV targetName = " + destFile.toString());
		JRCsvExporter exporter = new JRCsvExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());

		exporter.exportReport();
	}

	public static void getODT(String targetName,String filepath,JasperPrint jasperPrint) throws JRException{
		targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.CSV_FILE_POSTFIX);

		String fileJasperPath=null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"")+filepath;
		} catch (Exception e) {

			e.printStackTrace();
		}

		File destFile = new File(fileJasperPath.toString(), targetName);
		JROdtExporter exporter = new JROdtExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());

		exporter.exportReport();

	}

}
