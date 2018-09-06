package com.huateng.scf.bas.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

/**
 * 
 * 打印功能的实现
 *
 * @author htrad0011
 * @date 2016年11月25日
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=================
 * Modifier			date			Content
 * htrad0011			2016年11月25日			新增
 *
 * </pre>
 */
public final class NoticeUtil {


    private static String characterEncoding = "UTF-8";
    private NoticeUtil() {
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
    public static void reportMultiHtml(String path, Map paras, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        response.setCharacterEncoding(characterEncoding);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        JasperPrint jasperPrint = null;
        InputStream ins = null;
        int jaspers_length = paras.size();
        List<JasperPrint> jaspers = new ArrayList<JasperPrint>(jaspers_length);
            ins = new FileInputStream(new File(path));
            if (ins == null) {
                return;
            }

            synchronized (ins) {
                jasperPrint = JasperFillManager.fillReport(ins, paras, (JRDataSource)paras.get("datasource"));
                jaspers.add(jasperPrint);
            }

        JRHtmlExporter exporter = new JRHtmlExporter();
        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_LIST_SESSION_ATTRIBUTE, jaspers);

        exporter.setParameter(JRHtmlExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
        exporter.setParameter(JRHtmlExporterParameter.JASPER_PRINT_LIST, jaspers);
        exporter.setParameter(JRHtmlExporterParameter.OUTPUT_WRITER, out);
        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, characterEncoding);
        exporter.setParameter(JRHtmlExporterParameter.BETWEEN_PAGES_HTML, "<br/><br/><br/><br/><br/>");
       // exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);

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
      
    }
    /**
     * 打印前调用html（解决访问跨域问题）
     * 
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/html")
    public void html(HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer sb = new StringBuffer();
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        int port = request.getLocalPort();
        response.setContentType("text/html; charset=UTF-8");
        sb.append("<!DOCTYPE html>"
                + "<html lang='en'>"
                + "<head>"
                + "    <meta charset='UTF-8'>"
                + "    <title>print</title>"
                + "    <script type='text/javascript'>"
                + "        function htPrint(){"
                + "            document.getElementById('htPrintFrame').contentWindow.print();"
                + "        }"
                + "        function on_load(){"
                + "            var parentTable = document.getElementById('htPrintFrame').contentWindow.document.getElementsByTagName('table');"
                + "            if(parentTable){"
                + "                var childTables = parentTable[0].getElementsByTagName('table');"
                + "                if(childTables){"
                + "                    for(var i=1;i<childTables.length;i++){"// 从第二个开始分页
                + "                       childTables[i].style.cssText='page-break-before: always';"
                + "                    }"
                + "                }"
                + "             }"
                + "        }"
                + "    </script>"
                + "</head>"
                + "<body onload='on_load()'>"
                + "<button onclick='htPrint()'>打印</button><button onclick='window.close();'>关闭</button><br/>"
                + "<iframe name='htPrintFrame' id='htPrintFrame' src='http://"
                + hostAddress
                + ":"
                + port
                + "/busi/Report/reportMultiHtml.htm ' scrolling='auto' frameborder='0'  width='100%' height='100%'></iframe>"
                + "</body>" + "</html>");
        PrintWriter out = response.getWriter();
        out.println(new String(sb.toString().getBytes("UTF-8"), "ISO-8859-1"));
        out.flush();
        out.close();
    }

    
    
    /**
     * 从HttpServletRequest中获取map转化为可读map
     * 
     * @param request
     * @param response
     * @throws Exception
     */
    public static Map getMapFromRequest(HttpServletRequest request){
    	Map param =request.getParameterMap();
        Iterator it=(Iterator) param.entrySet().iterator();
        Map map=new HashMap();
        while(it.hasNext()){
        	Map.Entry ent=(Map.Entry)it.next();
        	String key=(String)ent.getKey();
        	String value="";
        	Object obj=ent.getValue();
        	if(obj!=null){
        	  if(obj instanceof String[]){
                 value=((String[])obj)[0];
               }else{
            	   value=obj.toString();
               } 		
        	}
        	map.put(key, value);
        }
    	return map;
    }
    }

    