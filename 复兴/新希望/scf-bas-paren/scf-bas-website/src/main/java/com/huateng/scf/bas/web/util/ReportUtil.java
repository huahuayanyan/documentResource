package com.huateng.scf.bas.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;

import com.huateng.scf.bas.common.constant.ReportConstant;
import com.huateng.scf.bas.common.util.StringUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

public final class ReportUtil {

    private static String characterEncoding = "UTF-8";

	public ReportUtil() {
		
	}

	/**
	 * 
	 * 多页面（套打） 返回HTML
	 *
	 * @author htrad0011
	 * @date 2016年11月25日
	 * @param paths
	 * @param paras
	 * @param lists
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void reportMultiHtml(final String path, final Map<String, String> paras, DataSource dataSource,
			final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding(characterEncoding);
		response.setContentType("text/html; charset=UTF-8");
	    String inputdate = (String)(paras.get("p_inputdate"));
	    if(StringUtil.isStrNotEmpty(inputdate)){
	    	inputdate =  inputdate.substring(0, 6);
	    	paras.put(ReportConstant.P_INPUTDATE, inputdate);
        }
		try {
			//修改为通过dataSource实例化JdbcTemplate回调方法Connection为ireport数据源 modify by huangshuidan 2017-07-08
			JdbcTemplate template = new JdbcTemplate(dataSource);
			template.execute(new ConnectionCallback<String>(){
				@Override
				public String doInConnection(Connection conn) throws SQLException, DataAccessException {
					try {
						PrintWriter out = response.getWriter();
						JasperPrint jasperPrint = null;
						InputStream ins = null;
						int jaspers_length = paras.size();
						final List<JasperPrint> jaspers = new ArrayList<JasperPrint>(jaspers_length);
						ins = new FileInputStream(new File(path));
						if (null==ins) {
							return null;
						}	
						synchronized (ins) {
							jasperPrint = JasperFillManager.fillReport(path, paras, conn);
							jaspers.add(jasperPrint);
						}
						JRHtmlExporter exporter = new JRHtmlExporter();
						request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_LIST_SESSION_ATTRIBUTE, jaspers);

						exporter.setParameter(JRHtmlExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
						exporter.setParameter(JRHtmlExporterParameter.JASPER_PRINT_LIST, jaspers);
						exporter.setParameter(JRHtmlExporterParameter.OUTPUT_WRITER, out);
						exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, characterEncoding);
						exporter.setParameter(JRHtmlExporterParameter.BETWEEN_PAGES_HTML, "<br/><br/><br/><br/><br/>");
						// exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
						// Boolean.TRUE);

						exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT, "pt");
						// 增加参数，导出html时文字过长，自动换行
						exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD, Boolean.TRUE);
						exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
						exporter.exportReport();
						if (out != null) {
							try {
								out.flush();
								out.close();
							} catch (Exception e) {
								BasicConfigurator.configure();
								// logger.info(e);
							}
						}
						if(null!=ins){
							ins.close();
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (JRException e) {
						e.printStackTrace();
					}
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
