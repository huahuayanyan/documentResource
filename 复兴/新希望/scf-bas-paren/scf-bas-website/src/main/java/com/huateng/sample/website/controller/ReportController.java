package com.huateng.sample.website.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huateng.scf.bas.brp.model.BBrpNoticeModel;
import com.huateng.scf.bas.brp.service.IBBrpNoticeModelService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.web.util.NoticeUtil;
import com.huateng.scf.bas.web.util.ReportUtil;
import com.huateng.scube.exception.ScubeBizException;

@Controller
@RequestMapping("/htreport")
public class ReportController{

	private final Logger logger = LoggerFactory.getLogger(getClass());

	//上传路径
//	private final String UPLOAD_PATH = "scube.tmpFilePath";
	
	//下载路径
	private final String DOWNLOAD_PATH = "AuthorizationFromParamsUrl";
	// 可以注入其他类 
	@Resource(name="BBrpNoticeModelServiceImpl") 
	IBBrpNoticeModelService bbrpnoticemodelservice; 
	@Resource(name="dataSource")
    private DataSource dataSource;
	
	
	
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
       // String noticeTy = (String)param.get("noticeType");
   
        if(id==null||"".equals(id)){
			throw new ScubeBizException("统计报表异常");
		}
//        if(noticeTy==null||"".equals(noticeTy)){
//        	throw new ScubeBizException("统计报表异常");
//        }
        String noticeType="";
		OutputStream outInputStream=null;
		//BBrpNoticeModel bBrpNoticeModel=IBBrpNoticeModelService.selectByNoticeType(noticeTy);
		BBrpNoticeModel bBrpNoticeModel=bbrpnoticemodelservice.selectById(id);
	    if(bBrpNoticeModel==null||bBrpNoticeModel.getId()==null){
        	throw new ScubeBizException("报表模版不存在！");
	    }
	    noticeType= bBrpNoticeModel.getNoticeType();
	    param.put("noticeType", noticeType);
		String fileExt=bBrpNoticeModel.getFileExt();
		String fileName=bBrpNoticeModel.getFileName()+"."+fileExt;;
		byte[] fileDate=bBrpNoticeModel.getFileData();
		String filepath= ScfMessageUtil.transSysMsgByKey(DOWNLOAD_PATH);//下载文件路径，暂时写死
		String filename=noticeType+"."+fileExt;
		File fileparent=new File(filepath);
		String paths =filepath+"/"+filename;//下载文件的完整路径
		//String paths =filepath+"/"+fileName;//下载文件的完整路径
		if(!fileparent.exists()){
			fileparent.mkdirs();
		}
		File file=new File(filepath+"/"+filename);
		//File file=new File(filepath+"/"+fileName);
		if(file.exists()){
			file.delete();
			
		}
		try {
			outInputStream=new FileOutputStream(filepath+"/"+filename);
			//outInputStream=new FileOutputStream(filepath+"/"+fileName);
			outInputStream.write(fileDate, 0, fileDate.length);//写文件
			outInputStream.flush();
			outInputStream.close();
			ReportUtil reportUtil=new ReportUtil();
			logger.info("====================dataSource:"+dataSource);
			reportUtil.reportMultiHtml(paths, param,dataSource, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        	throw new ScubeBizException(e);
        }
    }

    

   
}
