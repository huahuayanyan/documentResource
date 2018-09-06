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
package com.huateng.scf.bas.batch.report.processor.base;

import com.huateng.exception.AppException;
import com.huateng.report.adapter.base.IReportAdapter;
import com.huateng.report.processor.base.IReportProcess;

/**
 * @author Administrator
 *
 */
public abstract class SemsReportProcess implements IReportProcess {

	protected IReportAdapter adapter;

	public SemsReportProcess() {
		super();
	}

	/**
	 * @return adapter
	 * @author Maik.chen
	 * create time :2008-02-10 18:23:38
	 */
	public IReportAdapter getAdapter() {
		return adapter;
	}

	/**
	 * @param adapter the adapter to set
	 * @author Maik.chen
	 * create time :2008-02-10 18:23:38
	 */
	public void setAdapter(IReportAdapter adapter) {
		this.adapter = adapter;
	}

	/* (non-Javadoc)
	 * @see com.huateng.report.processor.base.IReportProcess#destruct()
	 */
	public void destruct() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.huateng.report.processor.base.IReportProcess#genEXCEL(java.lang.String)
	 */
	public void genEXCEL(String targetName) throws AppException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.huateng.report.processor.base.IReportProcess#genHTML(java.lang.String)
	 */
	public void genHTML(String targetName) throws AppException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.huateng.report.processor.base.IReportProcess#genPDF(java.lang.String)
	 */
	public void genPDF(String targetName) throws AppException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.huateng.report.processor.base.IReportProcess#genXML(java.lang.String)
	 */
	public void genXML(String targetName) throws AppException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.huateng.report.processor.base.IReportProcess#init(java.lang.Object)
	 */
	public void init(Object data) throws AppException {
		// TODO Auto-generated method stub

	}

}
