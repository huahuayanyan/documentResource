package com.huateng.scf.bas.sys.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.model.BSysUploadFileVO;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBSysUploadFileService {

	/**
	 * 文件信息新增
	 * @param omap
	 * @author 	mengjiajia
	 * @date 	2017年7月3日上午10:46:38
	 */
	public void addBSysUploadFile(@ScubeParam("omap") HashMap<String, Object> omap);

	/**
	 * 删除文件信息
	 * @param id
	 * @author 	mengjiajia
	 * @date 	2017年7月3日上午10:57:09
	 */
	public void deleteBSysUploadById(@ScubeParam("id") String id);

	/**
	 * 根据业务申请编号获取文件信息
	 * @param appno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月3日下午2:08:34
	 */
	public List<BSysUploadFileVO> findBSysUploadFileByAppno(@ScubeParam("appno") String appno);
	
	

	/**
	 * 信息发布文件信息新增
	 * @param omap
	 */
	public void addInfoPublishFile(@ScubeParam("omap") HashMap<String, Object> omap);
	
	
	/**
	 * 根据信息发布ID获取文件信息
	 * @param pageNo
	 * @param pageSize
	 * @param infoId
	 * @return
	 */
	public Page findPublishFileByInfoId(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("infoId") String infoId);
	
	

}
