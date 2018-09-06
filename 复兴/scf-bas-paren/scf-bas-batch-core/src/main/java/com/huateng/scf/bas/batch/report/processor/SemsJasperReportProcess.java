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
package com.huateng.scf.bas.batch.report.processor;

import com.huateng.scf.bas.batch.report.processor.base.SemsReportProcess;

import java.io.File;
import java.util.HashMap;
import java.util.Properties;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import com.huateng.common.CommonFunction;
import com.huateng.common.Constants;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.exception.AppException;
import com.huateng.report.adapter.base._ReportAdapter;
import com.huateng.report.bean.base.IReport;


/**
 * @author Administrator
 *
 */
public class SemsJasperReportProcess extends SemsReportProcess {

	/** memeber variable: Jasperreport file postfix. */
	protected static String JASPER_REPORT_FILE_POSTIFIX = ".jasper";
	/** memeber variables describing JasperReport JasperPrint. */
    private static JasperPrint jasperPrint;
	/** memeber variables describing Adapter Data. */
    private Object adapterData;
	/** memeber variables describing reportId. */
    private String reportId;
	/** memeber variables describing report. */
    private IReport report;

    private String jrprintStr;


    public SemsJasperReportProcess(){
    	super();
    }
    /**
     * initialize processor
     * @param data 如果是文件，data文件对象！
     */
    public void init(Object data)throws AppException{
    	this.adapterData = data;
    	reportId = ((_ReportAdapter)getAdapter()).getReportId();
    	Properties property = System.getProperties();
    	StringBuffer fileJasperPath=new StringBuffer();
        //使用的project 绝对路径；
		String str = property.getProperty("user.dir");
		fileJasperPath.append(str).append(File.separator).append("jasper").append(File.separator)
		              .append(reportId.trim()).append(JASPER_REPORT_FILE_POSTIFIX);

    	try{
    		//adapter process
    		report = getAdapter().process(adapterData);
    		HashMap map = new HashMap(report.getTitle().getParamMap());
    		map.putAll(report.getHead().getParamMap());
    		map.putAll(report.getTail().getParamMap());

    		System.out.println("报表模板路径:"+fileJasperPath.toString());
    		File file = new File(fileJasperPath.toString());
    		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(report.getBody());
    		jasperPrint = JasperFillManager.fillReport(
    				fileJasperPath.toString(),
    				map,
    				ds);
    		//jrprintStr=JasperFillManager.fillReportToFile(fileJasperPath.toString(),map,ds);

    	}catch(net.sf.jasperreports.engine.JRException jasperEx){
    		throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_INIT_FAIL,jasperEx);
    	}catch(Exception ex){
    		throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_INIT_FAIL,ex);
    	}catch(Throwable th){
    		throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_INIT_FAIL);
		}
    	System.out.println(reportId.trim()+"加载报表数据成功!");
    }
    /*
     * (non-Javadoc)
     * @see com.huateng.report.processor.base.IReportProcess#getEXCEL(java.lang.String)
     */
	public void genEXCEL(String targetName)throws AppException {
		targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.EXCEL_FILE_POSTFIX);

		String fileJasperPath=null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"");
		} catch (Exception e) {

			e.printStackTrace();
		}

		fileJasperPath=fileJasperPath+targetName;
		System.out.println("JasperReportProcess::genEXCEL targetName = " + fileJasperPath);
		try{
			JRXlsExporter jrxe = new JRXlsExporter();
    		jrxe.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    		jrxe.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileJasperPath);
    		jrxe.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
    		jrxe.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
    		jrxe.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
    		jrxe.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
    		jrxe.exportReport();
		}catch(net.sf.jasperreports.engine.JRException jasperEx){
			throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOEXCEL_FAIL,jasperEx);
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOEXCEL_FAIL,ex);
		}catch(Throwable th){
    		throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOEXCEL_FAIL);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.huateng.report.processor.base.IReportProcess#getHTML(java.lang.String)
	 */
	public void genHTML(String targetName)throws AppException {
		targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.HTML_FILE_POSTFIX);

		String fileJasperPath=null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"");
		} catch (Exception e) {

			e.printStackTrace();
		}

		fileJasperPath=fileJasperPath+targetName;
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

	/*
	 * (non-Javadoc)
	 * @see com.huateng.report.processor.base.IReportProcess#getPDF(java.lang.String)
	 */
	public void genPDF(String targetName)throws AppException{
		targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.PDF_FILE_POSTFIX);
		//System.out.println("JasperReportProcess::genPDF targetName = " + targetName);
		String fileJasperPath=null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"");
		} catch (Exception e) {

			e.printStackTrace();
		}

		fileJasperPath=fileJasperPath+targetName;
		System.out.println("JasperReportProcess::genPDF targetName = " + fileJasperPath);
		try{
			JasperExportManager.exportReportToPdfFile(jasperPrint, fileJasperPath);
			//genRTF();
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
	/*
	 * (non-Javadoc)
	 * @see com.huateng.report.processor.base.IReportProcess#getXML(java.lang.String)
	 */
	public void genXML(String targetName)throws AppException{
		targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.XMLJ_FILE_POSTFIX);
		String fileJasperPath=null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"");
		} catch (Exception e) {

			e.printStackTrace();
		}
		fileJasperPath=fileJasperPath+targetName;
		System.out.println("JasperReportProcess::genPDF targetName = " + fileJasperPath);
		try{
			JasperExportManager.exportReportToXmlFile(jasperPrint,fileJasperPath,true);
		}catch(net.sf.jasperreports.engine.JRException jasperEx){
			throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOXML_FAIL,jasperEx);
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOXML_FAIL,ex);
		}catch(Throwable th){
    		throw new AppException(Module.SYSTEM_MODULE,Rescode.JASPERREPORTPROCESS_TOXML_FAIL);
		}
	}

	public void genRTF(String targetName) throws AppException, JRException {

		 targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.RTF_FILE_POSTFIX);

			String fileJasperPath=null;
			try {
				fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"");
			} catch (Exception e) {

				e.printStackTrace();
			}

			File destFile = new File(fileJasperPath.toString(), targetName);

		JRRtfExporter exporter = new JRRtfExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());

		exporter.exportReport();

	}

	public static void genCSV(String targetName) throws AppException, JRException {

		targetName = CommonFunction.stringEnd(targetName,BatchConstant.POINT + BatchConstant.CSV_FILE_POSTFIX);

		String fileJasperPath=null;
		try {
			fileJasperPath = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH,"");
		} catch (Exception e) {

			e.printStackTrace();
		}

		File destFile = new File(fileJasperPath.toString(), targetName);
		JRCsvExporter exporter = new JRCsvExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());

		exporter.exportReport();
	}

	/**
	 * destructor
	 *
	 */
	public void destruct(){
		super.destruct();
		this.jasperPrint = null;
	}

}
