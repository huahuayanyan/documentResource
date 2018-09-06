package com.huateng.sample.website.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huateng.scf.bas.brp.model.BBrpNoticeModel;
import com.huateng.scf.bas.brp.service.IBBrpNoticeModelService;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.startup.ScfNoticeTypeData;
import com.huateng.scf.bas.common.util.ContextUtil;
import com.huateng.scf.bas.web.util.NoticeUtil;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scube.exception.ScubeBizException;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/report")
public class NoticeController{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	//上传路径
//	private final String UPLOAD_PATH = "scube.tmpFilePath";
	
	//下载路径
	private final String DOWNLOAD_PATH = "AuthorizationFromParamsUrl";
	
	// 可以注入其他类 
	@Resource(name="BBrpNoticeModelServiceImpl") 
	IBBrpNoticeModelService bbrpnoticemodelservice; 
	
	
	
	 /**
     * 
     * 套打的实现
     *
     * @author 	htrad0084
     * @date 	2017年2月25日 
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/reportMultiHtml")
    public void reportMultiHtml(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取条件
    	Map param=NoticeUtil.getMapFromRequest(request);
    
        String id = (String)(param.get("id"));
        String noticeTy = (String)param.get("noticeType");
        if(id==null||"".equals(id)){
			throw new ScubeBizException("通知书异常");
		}
        if(noticeTy==null||"".equals(noticeTy)){
        	throw new ScubeBizException("通知书异常");
        }
		OutputStream outInputStream=null;
		BBrpNoticeModel bBrpNoticeModel=bbrpnoticemodelservice.selectByNoticeType(noticeTy);
	    if(bBrpNoticeModel==null||bBrpNoticeModel.getId()==null){
        	throw new ScubeBizException("通知书模版不存在！");
	    }
		String fileName=bBrpNoticeModel.getFileName();
		String fileExt=bBrpNoticeModel.getFileExt();
		byte[] fileDate=bBrpNoticeModel.getFileData();
		String filepath=ScfMessageUtil.transSysMsgByKey(DOWNLOAD_PATH);//下载文件路径，配置文件中配置
		String filename=noticeTy+"."+fileExt;
		File fileparent=new File(filepath);
        String paths =filepath+"/"+filename;//下载文件的完整路径
		if(!fileparent.exists()){
			fileparent.mkdirs();
		}
		File file=new File(filepath+"/"+filename);
		if(file.exists()){
			file.delete();
			
		}
		try {
			outInputStream=new FileOutputStream(filepath+"/"+filename);
			outInputStream.write(fileDate, 0, fileDate.length);//写文件
			outInputStream.flush();
			outInputStream.close();
			//获取不同通知书处理类
			//String className=propertiesUtil.getProperty("NOTICE_TYPE_"+bBrpNoticeModel.getNoticeType());	
			
			// modify by zhangcheng 20170228  通过scf_bas_config.properties配置文件获取通知书处理类 start
			String noticeType="noticeType_"+bBrpNoticeModel.getNoticeType();	
			ScfNoticeTypeData noticeData=ScfBaseData.getInstance().getScfNoticeTypeData();
            Class clazz=noticeData.getClass();
            String field="get"+noticeType.substring(0, 1).toUpperCase()+noticeType.substring(1);
		    Method m=clazz.getMethod(field);
            String className=(String)m.invoke(noticeData);
			// modify by zhangcheng 20170228  通过scf_bas_config.properties配置文件获取通知书处理类 end
			Class c=Class.forName(className);
			INoticeExportReportService ser=(INoticeExportReportService)ContextUtil.getBean(c.getSimpleName());
			Map map=ser.getContentMap(param);//获取表单数据
			Collection collection = ser.getIterativeData(param);//获取表格数据
		
			if(collection == null || collection.isEmpty()){
				map.put("datasource", new JREmptyDataSource());
			}else{
				map.put("datasource", new JRBeanCollectionDataSource(collection));
			}
          NoticeUtil.reportMultiHtml(paths, map, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        	throw new ScubeBizException(e);
        }
    }

    

   
}
