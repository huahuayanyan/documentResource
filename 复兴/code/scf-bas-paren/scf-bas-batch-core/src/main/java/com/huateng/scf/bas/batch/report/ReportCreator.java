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
package com.huateng.scf.bas.batch.report;

import net.sf.jasperreports.engine.JRException;

import com.huateng.scf.bas.batch.report.processor.SemsJasperReportProcess;
import com.huateng.scf.bas.batch.common.ApplicationContextUtils;
import com.huateng.exception.AppException;
import com.huateng.report.processor.base.IReportProcess;


/**
 * @author Administrator
 *
 */
public class ReportCreator {

		/** memeber variable: this bean id of report process in spring bean. */
		private String reportProcessId;
		/** memeber variable: report data. */
		private Object data;
		/** memeber variable: report process instantce. */
		private IReportProcess reportProcess;

		public ReportCreator(String reportProcessId,Object data)throws AppException{
			this.reportProcessId = reportProcessId;
			this.data = data;
			init();
		}

		public ReportCreator(Object data,String reportProcessId)throws AppException{

			this.data = data;
			this.reportProcessId = reportProcessId.trim();
			init();
			//initObejctToJasper();
		}

		/**
		 *  initialize creator
		 * @throws AppException
		 */
		public void init()throws AppException{
			reportProcess = (IReportProcess)ApplicationContextUtils.getBean(this.reportProcessId);
			reportProcess.init(this.data);
		}
		/**
		 *  initialize creator
		 * @throws AppException
		 */
		public void initObejctToJasper()throws AppException{
			reportProcess = (IReportProcess)ApplicationContextUtils.getBean(this.reportProcessId);
			reportProcess.init(this.data);
		}
		/**
		 * genertor pdf file
		 * @param targetName
		 * @throws AppException
		 */
		public void genPDF(String targetName)throws AppException{
			reportProcess.genPDF(targetName);
		}

		/**
		 * genertor html file
		 * @param targetName
		 * @throws AppException
		 */
		public void genHTML(String targetName)throws AppException{
			reportProcess.genHTML(targetName);
		}

		/**
		 * genertor excel file
		 * @param targetName
		 * @throws AppException
		 */
		public void genEXCEL(String targetName)throws AppException{
			reportProcess.genEXCEL(targetName);
		}

		public void genRTF(String targetName)throws AppException, JRException{
			new SemsJasperReportProcess().genRTF(targetName);
		}

		public void genCSV(String targetName)throws AppException, JRException{
			new SemsJasperReportProcess().genCSV(targetName);
		}
		/**
		 * genertor xml file
		 * @param targetName
		 * @throws AppException
		 */
		public void genXML(String targetName)throws AppException{
			reportProcess.genXML(targetName);
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public String getReportProcessId() {
			return reportProcessId;
		}

		public void setReportProcessId(String reportProcessId) {
			this.reportProcessId = reportProcessId;
		}

		/**
		 * 析构操作
		 *
		 */
		public void destruct(){
			reportProcess.destruct();
		}
}
