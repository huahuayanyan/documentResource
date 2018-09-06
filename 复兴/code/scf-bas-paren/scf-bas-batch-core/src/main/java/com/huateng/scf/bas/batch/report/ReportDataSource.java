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

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

/**
 * @author Administrator
 *
 */
public class ReportDataSource implements JRDataSource {

	private List data;

	private int index;

	private int count;

	/**
	 *
	 */
	public ReportDataSource(List data) {
		this.data = data;
		this.index = -1;
		this.count = data.size();
	}

	/* (non-Javadoc)
	 * @see net.sf.jasperreports.engine.JRDataSource#getFieldValue(net.sf.jasperreports.engine.JRField)
	 */
	public Object getFieldValue(JRField field) throws JRException {
		Map row = (Map) data.get(index);

		Object o = row.get(field.getName());
//		if (o != null && o instanceof BigDecimal) {
//			BigDecimal d = (BigDecimal)o;
//			o = new Double(d.doubleValue());
//		}

		return o;
	}

	/* (non-Javadoc)
	 * @see net.sf.jasperreports.engine.JRDataSource#next()
	 */
	public boolean next() throws JRException {
		if (this.index >= this.count - 1)
			return false;
		else {
			this.index++;
			return true;
		}
	}
}
