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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.huateng.common.Constants;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.scf.bas.batch.common.ApplicationContextUtils;
import com.huateng.exception.AppException;
import com.huateng.report.adapter.base._ReportAdapter;
import com.huateng.report.bean.base.IReport;
import com.huateng.report.bean.base.IReportBody;
import com.huateng.report.bean.impl.BaseReport;

/**
 * @author Administrator
 *
 */
public class SemsReportFileAdapter extends _ReportAdapter {

	private String separator = null;

	/** memeber variables describing report data file title section tag */
	private String title_tag = null;

	/** memeber variables describing report data file head section tag */
	private String head_tag = null;

	/** memeber variables describing report data file body section tag */
	private String body_tag = null;

	/** memeber variables describing report data file tail section tag */
	private String tail_tag = null;

	/**
	 *
	 */
	public SemsReportFileAdapter() {
		super();
		this.separator = separator;
	}

	public SemsReportFileAdapter(String separator) {
		super();
		this.separator = separator;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}
	/* (non-Javadoc)
	 * @see com.huateng.report.adapter.base.IReportAdapter#process(java.lang.Object)
	 */
	public IReport process(Object file) throws AppException {
		BufferedReader br = null;
		File dataFile = null;
		String line = null;
		// check param type
		if (!(file instanceof File)) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.REPORT_ADAPTER_PARAM_TYPE_ERROR,
					"ReportFileAdapter Process Param Error:Using java.io.File");
		} else {
			dataFile = (File) file;
			// check file exist
			if (!dataFile.exists()) {
				throw new AppException(Module.SYSTEM_MODULE,
						Rescode.REPORT_FILE_ADAPTER_DATA_FILE_NOT_FOUND,
						"ReportFileAdapter Process: data file not found");
			}
			try {
				br = new BufferedReader(new FileReader(dataFile));
				List titleList = new ArrayList(0);
				List headList = new ArrayList(0);
				List tailList = new ArrayList(0);
				String section = "";
				while ((line = br.readLine()) != null) {
					if (line.trim().length() == 0) {
						continue;
					}
					if (line.trim().equals(title_tag)) {
						section = title_tag;
					} else if (line.trim().equals(head_tag)) {
						section = head_tag;
					} else if (line.trim().equals(body_tag)) {
						section = body_tag;
					} else if (line.trim().equals(tail_tag)) {
						section = tail_tag;
					} else {
						if (section.equals(title_tag)) {
							titleList.add(line);
						} else if (section.equals(head_tag)) {
							headList.add(line);
						} else if (section.equals(body_tag)) {
							processBody(line);
						} else if (section.equals(tail_tag)) {
							tailList.add(line);
						} else {
							// 不处理的信息
						}
					}
				}
				// 处理title,head,tail
				processTitle(titleList.toArray());
				processHead(headList.toArray());
				processTail(tailList.toArray());
			} catch (IOException ioex) {
				throw new AppException(Module.SYSTEM_MODULE,
						Rescode.REPORT_FILE_ADAPTER_READ_DATA_FILE_ERROR,
						"ReportFileAdapter Process: read data file error");
			}finally{
				try
				{
				if(br!=null)br.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}

		return report;
	}

	private void processTitle(Object[] title) throws AppException {
		try {
			if (title.length == 0) {
				return;
			} else {
				List titleList = new ArrayList(0);
				StringTokenizer titleToken;
				for (int i = 0; i < title.length; i++) {
					titleToken = new StringTokenizer((String)title[i],separator);
					while(titleToken.hasMoreTokens()){
						titleList.add(titleToken.nextToken());
					}
				}
				Iterator it = report.getTitle().getParamMap().keySet()
						.iterator();
				int i = 0;
				String key, value;
				while (it.hasNext()) {
					key = (String) it.next();
					if (i >= titleList.size()) {
						report.getTitle().putParam(key, Constants.BLANK);
					} else {
						value = titleList.get(i).toString().trim();
						report.getTitle().putParam(key, value);
					}
					i++;
				}
			}
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.REPORTFILEADAPTER_PROCESS_TITLE_FAIL,
					"ReportFileAdapter ProcessTitle Fail", ex);
		}
	}

	/**
	 * process body data
	 *
	 * @param bodyString
	 * @throws AppException
	 */
	private void processBody(String bodyString) throws AppException {
		try {
			String bodyArry[]=bodyString.split(",");
			int bodyInt=bodyArry.length;
			StringTokenizer	bodyToken = new StringTokenizer(bodyString,separator);
			IReportBody body = (IReportBody) ApplicationContextUtils
					.getBean(((BaseReport) report).getBodyBeanId());
			Iterator it = body.getParamMap().keySet().iterator();
			String key;
			int i=0;
			while(it.hasNext()){
				key = (String) it.next().toString().trim();
				body.putParam(key, bodyArry[i].trim());
				i=i+1;
			}

//			while (it.hasNext()) {
//				key = (String) it.next().toString().trim();
//				System.out.println("===:"+key);
//				if(bodyToken.hasMoreTokens()){
//					body.putParam(key, bodyToken.nextToken().trim());
//					System.out.println("Key=:"+key+"="+bodyToken.nextToken().trim());
//				}else{
//					body.putParam(key, Constants.BLANK);
//				}
//			}
			report.addBodyRow(body);


		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.REPORTFILEADAPTER_PROCESS_BODY_FAIL,
					"ReportFileAdapter ProcessBody Fail", ex);
		}
	}

	/**
	 * process head data
	 *
	 * @param headString
	 */
	private void processHead(Object[] head) throws AppException {
		try {
			if (head.length == 0) {
				return;
			} else {
				List headList = new ArrayList(0);
				StringTokenizer headToken;
				for (int i = 0; i < head.length; i++) {
					headToken = new StringTokenizer((String)head[i],separator);
					while(headToken.hasMoreTokens()){
						headList.add(headToken.nextToken());
					}
				}
				Iterator it = report.getHead().getParamMap().keySet()
						.iterator();
				int i = 0;
				String key, value;
				while (it.hasNext()) {
					key = (String) it.next();
					if (i >= headList.size()) {
						report.getHead().putParam(key, Constants.BLANK);
					} else {
						value = headList.get(i).toString().trim();
						report.getHead().putParam(key, value);
					}
					i++;
				}
			}
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.REPORTFILEADAPTER_PROCESS_HEAD_FAIL,
					"ReportFileAdapter ProcessHead Fail", ex);
		}
	}

	/**
	 * process tail data
	 *
	 * @param tailString
	 */
	private void processTail(Object[] tail) throws AppException {
		try {
			if (tail.length == 0) {
				return;
			} else {
				List tailList = new ArrayList(0);
				StringTokenizer tailToken;
				for (int i = 0; i < tail.length; i++) {
					tailToken = new StringTokenizer((String)tail[i],separator);
					while(tailToken.hasMoreTokens()){
						tailList.add(tailToken.nextToken());
					}
				}
				Iterator it = report.getTail().getParamMap().keySet()
						.iterator();
				int i = 0;
				String key, value;
				while (it.hasNext()) {
					key = (String) it.next();
					if (i >= tailList.size()) {
						report.getTail().putParam(key, Constants.BLANK);
					} else {
						value = tailList.get(i).toString().trim();
						report.getTail().putParam(key, value);
					}
					i++;
				}
			}
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.REPORTFILEADAPTER_PROCESS_TAIL_FAIL,
					"ReportFileAdapter ProcessTail Fail", ex);
		}
	}

	public String getBody_tag() {
		return body_tag;
	}

	public void setBody_tag(String body_tag) {
		this.body_tag = body_tag;
	}

	public String getHead_tag() {
		return head_tag;
	}

	public void setHead_tag(String head_tag) {
		this.head_tag = head_tag;
	}

	public String getTail_tag() {
		return tail_tag;
	}

	public void setTail_tag(String tail_tag) {
		this.tail_tag = tail_tag;
	}

	public String getTitle_tag() {
		return title_tag;
	}

	public void setTitle_tag(String title_tag) {
		this.title_tag = title_tag;
	}

}
