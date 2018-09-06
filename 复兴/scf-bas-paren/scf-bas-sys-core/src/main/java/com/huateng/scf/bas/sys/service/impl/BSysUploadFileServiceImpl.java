package com.huateng.scf.bas.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.sys.dao.IBSysUploadFileDAO;
import com.huateng.scf.bas.sys.dao.model.BSysUploadFile;
import com.huateng.scf.bas.sys.dao.model.BSysUploadFileExample;
import com.huateng.scf.bas.sys.model.BSysUploadFileVO;
import com.huateng.scf.bas.sys.service.IBSysUploadFileService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>文件上传信息 接口实现类 </p>
 *
 * @author mengjiajia
 * @date 2017年7月3日上午10:40:19
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年7月3日上午10:40:19	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BSysUploadFileServiceImpl")
public class BSysUploadFileServiceImpl implements IBSysUploadFileService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBSysUploadFileDAO")
	IBSysUploadFileDAO bsysuploadfiledao;
	
	@Autowired
	ScubeUserService scubeUserService;

	/**
	 * 文件信息新增
	 * @param omap
	 * @author 	mengjiajia
	 * @date 	2017年7月3日上午10:46:25
	 */
	@Override
	@Transactional
	public void addBSysUploadFile(HashMap<String, Object> omap)
	{
		log.debug("addBSysUploadFile======================start");
		String id = omap.get("picId").toString();
		String appno = omap.get("reservedValue1").toString();
		String picType = omap.get("picType").toString();
		String picName = omap.get("picName").toString();
		String url = omap.get("url").toString();
		byte[] contentUrl = url.getBytes();
		
		BSysUploadFile bSysUploadFile = new BSysUploadFile();
		if(!StringUtil.isEmpty(omap.get("flag")))
		{
			String contCode = omap.get("reservedValue2").toString();
			if(StringUtil.isEmpty(contCode)||contCode.equals("undefined"))
			{
				throw new ScubeBizException("文件类型未选择！");
			}
			bSysUploadFile.setExt1(contCode);
		}
		bSysUploadFile.setId(id);
		bSysUploadFile.setFileName(picName);
		bSysUploadFile.setFileExt(picType);
		bSysUploadFile.setAppno(appno);
		bSysUploadFile.setFileContent(contentUrl);
		bSysUploadFile.setUploadTlrno(ContextHolder.getUserInfo().getTlrNo());
		bSysUploadFile.setUploadTime(new Date());
		try
		{
			bsysuploadfiledao.insertSelective(bSysUploadFile);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("文件信息新增异常");
		}
		log.debug("addBSysUploadFile======================end");
	}
	
	/**
	 * 删除文件信息
	 * @param id
	 * @author 	mengjiajia
	 * @date 	2017年7月3日上午10:56:18
	 */
	@Override
	public void deleteBSysUploadById(String id)
	{
		try
		{
			bsysuploadfiledao.deleteByPrimaryKey(id);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("文件信息删除异常");
		}
	}
	
	/**
	 * 根据业务申请编号获取文件信息
	 * @param appno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月3日下午2:08:02
	 */
	@Override
	public List<BSysUploadFileVO> findBSysUploadFileByAppno(String appno)
	{
		if(StringUtil.isEmpty(appno))
		{
			throw new ScubeBizException("申请编号丢失！");
		}
		BSysUploadFileExample example = new BSysUploadFileExample();
		BSysUploadFileExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		List<BSysUploadFile> list = bsysuploadfiledao.selectByExampleWithoutBLOBs(example);
		List<BSysUploadFileVO> result = new ArrayList<BSysUploadFileVO>();
		if(list!=null&&list.size()>0)
		{
			for(BSysUploadFile bSysUploadFile:list)
			{
				BSysUploadFileVO bSysUploadFileVO = new BSysUploadFileVO();
				try
				{
					BeanUtils.copyProperties(bSysUploadFile, bSysUploadFileVO);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				result.add(bSysUploadFileVO);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IBSysUploadFileService#addInfoPublishFile(java.util.HashMap)
	 */
	@Override
	public void addInfoPublishFile(HashMap<String, Object> omap) {
		// TODO Auto-generated method stub
		log.info("addInfoPublishFile======================start");
		String id = omap.get("picId").toString();
		String infoId = omap.get("reservedValue1").toString();
		String picType = omap.get("picType").toString();
		String picName = omap.get("picName").toString();
		String url = omap.get("url").toString();
		byte[] contentUrl = url.getBytes();
		
		BSysUploadFile bSysUploadFile = new BSysUploadFile();
		if(StringUtil.isEmpty(infoId)||"undefined".equals(infoId))
		{
			throw new ScubeBizException("信息发布ID丢失！");
		}
		bSysUploadFile.setId(id);
		bSysUploadFile.setFileName(picName);
		bSysUploadFile.setFileExt(picType);
		bSysUploadFile.setFilePro(infoId);
		bSysUploadFile.setAppno("000000000");
		bSysUploadFile.setFileClass(ScfBasConstant.FILE_CLASS_INFO);
		bSysUploadFile.setFileContent(contentUrl);
		bSysUploadFile.setUploadTlrno(ContextHolder.getUserInfo().getTlrNo());
		bSysUploadFile.setUploadTime(new Date());
		try
		{
			bsysuploadfiledao.insertSelective(bSysUploadFile);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("文件信息新增异常");
		}
		log.debug("addInfoPublishFile======================end");
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IBSysUploadFileService#findPublishFileByInfoId(java.lang.String)
	 */
	@Override
	public Page findPublishFileByInfoId(int pageNo, int pageSize,String infoId) {
		Page page = new Page(pageSize, pageNo, 0);
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(infoId))
		{
			throw new ScubeBizException("信息发布ID丢失！");
		}
		BSysUploadFileExample example = new BSysUploadFileExample();
		BSysUploadFileExample.Criteria cri = example.createCriteria();
		cri.andFileProEqualTo(infoId);
		List<BSysUploadFile> list = bsysuploadfiledao.selectByPage(example,page);
		List<BSysUploadFileVO> result = new ArrayList<BSysUploadFileVO>();
		if(list!=null&&list.size()>0)
		{
			for(BSysUploadFile bSysUploadFile:list)
			{
				BSysUploadFileVO bSysUploadFileVO = new BSysUploadFileVO();
				try
				{
					BeanUtils.copyProperties(bSysUploadFile, bSysUploadFileVO);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				if (StringUtil.isStrNotEmpty(bSysUploadFile.getUploadTlrno())) {
					UserInfo userInfo = scubeUserService.selectUserByTlrNo(bSysUploadFile.getUploadTlrno(), ScfCommonUtil.getBrManagerNo(scubeUserService));
					if (userInfo != null) {
						bSysUploadFileVO.setUploadTlrnoName(userInfo.getTlrName());
					}
				}
				if (!StringUtil.isEmpty(bSysUploadFile.getUploadTime())) {
					String  uploadTimes = bSysUploadFile.getUploadTime().toLocaleString();
	
					bSysUploadFileVO.setUploadTimes(uploadTimes);
				}
				result.add(bSysUploadFileVO);
			}
		}
		page.setRecords(result);
		return page;
	}
}
