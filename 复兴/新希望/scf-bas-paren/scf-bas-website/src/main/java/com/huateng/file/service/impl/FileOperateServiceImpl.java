package com.huateng.file.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import com.huateng.file.service.FileOperateService;
import com.huateng.scf.bas.brp.model.BBrpNoticeModel;
import com.huateng.scf.bas.brp.service.IBBrpNoticeModelService;
import com.huateng.scube.exception.ScubeBizException;

public class FileOperateServiceImpl implements FileOperateService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 可以注入其他类 
	@Resource(name="BBrpNoticeModelServiceImpl") 
	IBBrpNoticeModelService bbrpnoticemodelservice; 


	/*
	 * 
	 * 上传
	 * 
	 */
	@Override
	public Object upload(List<File> fileList, Map<String, String> paramMap) {
		String uploadType=(String)paramMap.get("uploadType");
		if("1001".equals(uploadType)){
			String noticeType=(String)paramMap.get("noticeType");
			if(noticeType!=null&&!"".equals(noticeType)){
				for (File file : fileList) {
                     String fileName=file.getName();
                     int num=fileName.lastIndexOf(".");
                     BBrpNoticeModel bBrpNoticeModel=new BBrpNoticeModel();
                     if(num==-1){
         				throw new ScubeBizException("文件格式错误！");	
                     }
                    String filename=fileName.substring(0,num);//文件名称
                    String fileext=fileName.substring(num+1);//文件类型
                    if("exe".equalsIgnoreCase(fileext)){
         				throw new ScubeBizException("文件格式不能为exe！");	
                    }
                    try {
						InputStream in=new FileInputStream(file);
						byte[] b=FileCopyUtils.copyToByteArray(in);
						bBrpNoticeModel.setFileExt(fileext);
						bBrpNoticeModel.setFileName(filename);
						bBrpNoticeModel.setNoticeType(noticeType);
						bBrpNoticeModel.setFileData(b);
						bbrpnoticemodelservice.add(bBrpNoticeModel);//保存到数据库	
						//删除生成的临时文件 start
						if (file.exists())
						{
							file.delete();
						}
						File parentFile = file.getParentFile();
						deleteDir(parentFile);
						deleteDir(parentFile.getParentFile());
						//删除生成的临时文件 end
					} catch (FileNotFoundException e) {
						throw new ScubeBizException("通知书上传失败！");	

					} catch (IOException e) {
						throw new ScubeBizException("通知书上传失败！");	

					}
                    
				}	
			}else{
				throw new ScubeBizException("通知书类型不能为空！");	
			}
			
		}

	/*	for (Map.Entry<String, String> entry : paramMap.entrySet()) {

			System.out.println(entry.getKey() + "--------" + entry.getValue());

		}*/

		/*for (File file : fileList) {

			System.out.println(file);

		}*/

		logger.debug("upload 完成");

		return fileList;

	}

	/*
	 * 
	 * 下载方法
	 * 
	 */
	@Override
	public InputStream download(Map<String, String> paramMap) {

		logger.debug("upload 完成");
		InputStream isInputStream=null;
		OutputStream outInputStream=null;
		String downloadType=(String)paramMap.get("downloadType");
		try {
			if("2001".equals(downloadType)){
				String id=(String)paramMap.get("id");
				if(id==null||"".equals(id)){
					return null;
					//throw new ScubeBizException("下载异常");
				}
				BBrpNoticeModel bBrpNoticeModel=bbrpnoticemodelservice.selectById(id);
				String fileName=bBrpNoticeModel.getFileName();
				String fileExt=bBrpNoticeModel.getFileExt();
				byte[] fileDate=bBrpNoticeModel.getFileData();
				String filepath="/apps/rd_notice";//下载文件路径，暂时写死
				String filename=fileName+"."+fileExt;
				File fileparent=new File(filepath);
				if(!fileparent.exists()){
					fileparent.mkdirs();
				}
				File file=new File(filepath+"/"+filename);
				if(file.exists()){
					file.delete();
					
				}
				outInputStream=new FileOutputStream(filepath+"/"+filename,true);
				outInputStream.write(fileDate, 0, fileDate.length);//写文件
				outInputStream.close();
				if(file.exists()){
				isInputStream = new FileInputStream(file);
				}
				
				  
			}


			/*for (Map.Entry<String, String> entry : paramMap.entrySet()) {

				System.out.println(entry.getKey() + "--------" + entry.getValue());

			}
*/
			//File file = new File("/apps/config/scfbas-app/config.properties");


			return isInputStream;

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
			//throw new ScubeBizException("下载异常");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			//throw new ScubeBizException("下载异常");
		}

	}

	/**
	 * 删除文件
	 * mengjiajia
	 * @param dir
	 */
	public static void deleteDir(File dir) {
		if (dir == null || !dir.exists() || !dir.isDirectory()) {
			for (File f : dir.listFiles()) {
				if (f.isFile()) {
					f.delete();
				} else if (f.isDirectory()) {
					deleteDir(f);
				}
			}
		}
		dir.delete();
	}
}
