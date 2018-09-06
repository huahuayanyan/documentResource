package com.huateng.sample.website.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ContextUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.web.util.WordNoticeUtil;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scf.nbas.prd.dao.model.BPrdPrintInfo;
import com.huateng.scf.nbas.prd.model.BPrdPrintInfoVO;
import com.huateng.scf.nbas.prd.service.IBPrdPrintInfoService;
import com.huateng.scube.exception.ScubeBizException;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/factoringReport")
public class FactoringController{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	//上传路径
//	private final String UPLOAD_PATH = "scube.tmpFilePath";
	
	//下载路径
	private final String DOWNLOAD_PATH = "AuthorizationFromParamsUrl";
	
	// 可以注入其他类 
	@Resource(name="BBrpNoticeModelServiceImpl") 
	IBBrpNoticeModelService bbrpnoticemodelservice; 
	
	//业务申请信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "BPrdPrintInfoServiceImpl")
	IBPrdPrintInfoService bprdprintinfoservice;
	
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
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/reportMultiHtml")
    public void reportMultiHtml(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取条件
    	Map<String, String> param = WordNoticeUtil.getMapFromRequest(request);
    	String appno = param.get("appno");//申请编号
    	String invokPhase = param.get("invokPhase");//调用阶段
		String id = (param.get("id"));
        String noticeTy = param.get("noticeType");
        
		OutputStream outInputStream = null;
		String fileName = "";
		String fileExt = "";
		byte[] fileDate = null;
		
		List<BPrdPrintInfo> list = new ArrayList<BPrdPrintInfo>();
    	if(!StringUtil.isEmpty(appno)&&!StringUtil.isEmpty(invokPhase))
    	{
    		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
    		if(appliBaseInfo!=null&&!StringUtil.isEmpty(appliBaseInfo.getSupplyChainPdId()))
    		{
    			list = bprdprintinfoservice.CheckBPrdPrintInfo(appliBaseInfo.getSupplyChainPdId(), invokPhase);
    		}
    	}
    	if(list!=null&&list.size()>0)
		{
    		String printid = list.get(0).getId();
    		BPrdPrintInfoVO bPrdPrintInfoVO = bprdprintinfoservice.findBPrdPrintInfoById(printid);
//			fileName = bPrdPrintInfoVO.getFileName();
    		fileExt = bPrdPrintInfoVO.getFileExt();
    		fileDate = bPrdPrintInfoVO.getFileData();
		}
    	else
    	{
            if(id==null||"".equals(id))
            {
    			throw new ScubeBizException("打印模板异常");
    		}
            if(noticeTy==null||"".equals(noticeTy))
            {
            	throw new ScubeBizException("打印模板异常");
            }
    		BBrpNoticeModel bBrpNoticeModel = bbrpnoticemodelservice.selectByNoticeType(noticeTy);
    	    if(bBrpNoticeModel==null||bBrpNoticeModel.getId()==null)
    	    {
            	throw new ScubeBizException("打印模板不存在！");
    	    }
//    	    fileName = bBrpNoticeModel.getFileName();
    		fileExt = bBrpNoticeModel.getFileExt();
    		fileDate = bBrpNoticeModel.getFileData();
    	}
    	fileName = noticeTy;
		String filepath = ScfMessageUtil.transSysMsgByKey(DOWNLOAD_PATH);//下载文件路径，暂时写死
		String filename = fileName+"."+fileExt;
		File fileparent = new File(filepath);
//		String paths = filepath+"/"+filename;//下载文件的完整路径
		if(!fileparent.exists())
		{
			fileparent.mkdirs();
		}
		File file=new File(filepath+"/"+filename);
		if(file.exists())
		{
			file.delete();
		}
		
		String newfilename = fileName+".doc";
		String newpaths = filepath+"/"+newfilename;
		File newfile = new File(newpaths);
		if(!newfile.exists())
		{
			newfile.createNewFile();
		}
		
		try
		{
			outInputStream = new FileOutputStream(newpaths);
			outInputStream.write(fileDate, 0, fileDate.length);//写文件
			outInputStream.flush();
			outInputStream.close();
			String noticeType = "NOTICE_TYPE_"+noticeTy;	
            String field = ScfMessageUtil.transSysMsgByKey(noticeType);
			Class c = Class.forName(field);
			INoticeExportReportService ser = (INoticeExportReportService)ContextUtil.getBean(c.getSimpleName());
			Map map = ser.getContentMap(param);//获取表单数据
			map.put("appno", appno);
			Collection collection = ser.getIterativeData(param);//获取表格数据
		
			if(collection == null || collection.isEmpty()){
				map.put("datasource", new JREmptyDataSource());
			}else{
				map.put("datasource", new JRBeanCollectionDataSource(collection));
			}
			WordNoticeUtil.reportMultiHtml(newpaths, map, request, response);
          
        }
		catch (Exception e)
		{
            e.printStackTrace();
        	throw new ScubeBizException(e);
        }
    }

}
