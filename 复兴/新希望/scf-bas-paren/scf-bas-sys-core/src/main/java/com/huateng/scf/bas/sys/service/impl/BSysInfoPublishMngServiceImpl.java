/**
 * 
 */
package com.huateng.scf.bas.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.sys.dao.IBSysInfoPublishMngDAO;
import com.huateng.scf.bas.sys.dao.IBSysUploadFileDAO;
import com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMngExample;
import com.huateng.scf.bas.sys.model.BSysInfoPublishMng;
import com.huateng.scf.bas.sys.model.BSysInfoPublishVO;
import com.huateng.scf.bas.sys.model.BSysUploadFileVO;
import com.huateng.scf.bas.sys.model.PublishInfoQryVO;
import com.huateng.scf.bas.sys.service.IBSysInfoPublishMngService;
import com.huateng.scf.bas.sys.service.IBSysUploadFileService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年7月15日上午11:46:28
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年7月15日上午11:46:28              新增
 *
 * </pre>
 */
@ScubeService
@Service(IBSysInfoPublishMngService.BEAN_ID)
public class BSysInfoPublishMngServiceImpl implements IBSysInfoPublishMngService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BSysInfoPublishMngDAO")
	IBSysInfoPublishMngDAO bSysInfoPublishMngDAO;
	
	@Resource(name = "IBSysUploadFileDAO")
	IBSysUploadFileDAO bSysUploadFileDAO;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name = "BSysUploadFileServiceImpl")
	IBSysUploadFileService bSysUploadFileService;	
	@Transactional
	@Override
	public String addBSysInfoPublishMng(BSysInfoPublishMng bSysInfoPublishMng) throws ScubeBizException {
		com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMng bSysInfoPublishMngdal = new com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMng();
		String id  = UUIDGeneratorUtil.generate();
		try {

			bSysInfoPublishMng.setId(id);
			bSysInfoPublishMng.setPublishDate(ScfDateUtil.formatDate(new Date())); //发布日期
			bSysInfoPublishMng.setAuthorTlrno(ContextHolder.getUserInfo().getTlrNo());
			if(StringUtil.isEmpty(bSysInfoPublishMng.getState())){
				bSysInfoPublishMng.setState(ScfBasConstant.INFO_STATE_VALID);
			}
			BeanUtils.copyProperties(bSysInfoPublishMng, bSysInfoPublishMngdal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("信息发布转换异常！");
			throw new ScubeBizException("信息发布转换异常！");
		}
		// TODO
		try {
			bSysInfoPublishMngDAO.insertSelective(bSysInfoPublishMngdal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("信息发布插入异常！");
			throw new ScubeBizException("信息发布插入异常！");
		}
		return id;
	}

	@Transactional
	@Override
	public int updateBSysInfoPublishMng(BSysInfoPublishMng bSysInfoPublishMng) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMng bSysInfoPublishMngdal = new com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMng();
		try {
			
			BeanUtils.copyProperties(bSysInfoPublishMng, bSysInfoPublishMngdal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("信息发布转换异常！");
			throw new ScubeBizException("信息发布转换异常！");
		}
		int i = 0;
		try {
			i = bSysInfoPublishMngDAO.updateByPrimaryKeySelective(bSysInfoPublishMngdal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("信息发布更新异常！");
			throw new ScubeBizException("信息发布更新异常！");
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteBSysInfoPublishMng(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = bSysInfoPublishMngDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("信息发布删除异常！");
			throw new ScubeBizException("信息发布删除异常！");
			}
		return i;
	}

	@Override
	@Transactional
	public BSysInfoPublishMng findBSysInfoPublishMngByKey(String key) throws ScubeBizException {
		BSysInfoPublishMng bSysInfoPublishMng = null;
		com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMng bSysInfoPublishMngdal = new com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMng();
		bSysInfoPublishMngdal = bSysInfoPublishMngDAO.selectByPrimaryKey(key);
		try {
			if(bSysInfoPublishMngdal!=null){
				bSysInfoPublishMng = new BSysInfoPublishMng();
				BeanUtils.copyProperties(bSysInfoPublishMngdal, bSysInfoPublishMng);
			}
			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("信息发布转换异常！");
			throw new ScubeBizException("信息发布转换异常！");
			}
		return bSysInfoPublishMng;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IBSysInfoPublishMngService#findBSysInfoPublishMngByPage(com.huateng.scf.bas.sys.model.PublishInfoQryVO)
	 */
	@Override
	public Page findBSysInfoPublishMngByPage(int pageNo, int pageSize,PublishInfoQryVO publishInfoQryVO) {
		// TODO Auto-generated method stub
		Page page = new Page(pageSize, pageNo, 0);
		BSysInfoPublishMngExample example = new BSysInfoPublishMngExample();
		BSysInfoPublishMngExample.Criteria criteria = example.createCriteria();
		if(publishInfoQryVO!=null){
			String title =publishInfoQryVO.getTitle();
			String authorTlrno =publishInfoQryVO.getAuthorTlrno();
			String publishDate =publishInfoQryVO.getPublishDate();
			String state =publishInfoQryVO.getState();
			if(StringUtil.isStrNotEmpty(title)){
				criteria.andTitleLike("%"+title+"%");
			}
			if(StringUtil.isStrNotEmpty(authorTlrno)){
				criteria.andAuthorTlrnoLike("%"+authorTlrno+"%");
			}
			if(StringUtil.isStrNotEmpty(publishDate)){
				criteria.andPublishDateEqualTo(publishDate);
			}
			if(StringUtil.isStrNotEmpty(state)){
				criteria.andStateEqualTo(state);
			}
		}
		example.setOrderByClause("PUBLISH_DATE DESC");
		List<com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMng>	listdal = bSysInfoPublishMngDAO.selectByPage(example,page);
		List<BSysInfoPublishVO> list = new ArrayList<BSysInfoPublishVO>();
		if(null!=listdal&&listdal.size()>0){
			for(com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMng info: listdal){
				BSysInfoPublishVO VO =  new BSysInfoPublishVO();
				BeanUtils.copyProperties(info, VO);
				if (StringUtil.isStrNotEmpty(info.getAuthorTlrno())) {
					String brManagerNo = ScfCommonUtil.getBrManagerNo(scubeUserService);
					if(StringUtil.isStrNotEmpty(brManagerNo)){
						UserInfo userInfo = scubeUserService.selectUserByTlrNo(info.getAuthorTlrno(),brManagerNo);
						if (userInfo != null) {
							VO.setAuthorTlrnoName(userInfo.getTlrName());
						}	
					}
				}
				list.add(VO);
			}
		}
		page.setRecords(list);
		return page;
	}

	/**
	 * 保存信息发布，已保存则更新
	 */
	@Transactional
	@Override
	public String addInfoPublish(BSysInfoPublishMng bSysInfoPublishMng) throws ScubeBizException {
		// TODO Auto-generated method stub
		String id ="";
		if(bSysInfoPublishMng!=null){
			id = bSysInfoPublishMng.getId();
			if(StringUtil.isEmpty(id)){
				id = this.addBSysInfoPublishMng(bSysInfoPublishMng);
			}else{
				BSysInfoPublishMng info = this.findBSysInfoPublishMngByKey(id);
				if(info==null){
					id = this.addBSysInfoPublishMng(bSysInfoPublishMng);
				}else{
					this.updateBSysInfoPublishMng(bSysInfoPublishMng);
				}
			}
		}
		return id;
	}

	/**
	 * 信息发布更新
	 */
	@Transactional
	@Override
	public String updateInfoPublish(BSysInfoPublishMng bSysInfoPublishMng) throws ScubeBizException {
		// TODO Auto-generated method stub
		String id = "";
		if(bSysInfoPublishMng!=null){
			if(StringUtil.isEmpty(bSysInfoPublishMng.getState())){
				bSysInfoPublishMng.setState(ScfBasConstant.INFO_STATE_VALID);
			}
			this.updateBSysInfoPublishMng(bSysInfoPublishMng);
			id= bSysInfoPublishMng.getId();
		}
		return id;
	}

	/**
	 * 信息发布删除
	 */
	@Transactional
	@Override
	public List<String> deleteInfoPublish(BSysInfoPublishMng bSysInfoPublishMng) throws ScubeBizException {
		// TODO Auto-generated method stub
		Page page = new Page(10000000, 1, 0);
		List<String> picIds = new ArrayList<String>();
		if(bSysInfoPublishMng!=null){
			String id = bSysInfoPublishMng.getId();
			if(StringUtil.isStrEmpty(id)){
				log.error("信息发布ID 丢失！");
				throw new ScubeBizException("信息发布参数丢失！");
			}
			this.deleteBSysInfoPublishMng(id);
			//删除发布信息相关文件信息
			page = bSysUploadFileService.findPublishFileByInfoId(1,1000000,id);
			List<BSysUploadFileVO> fileList = page.getRecords();
			if (fileList != null && fileList.size() > 0) {
				for (BSysUploadFileVO fileVO : fileList) {
					picIds.add(fileVO.getId());
					bSysUploadFileService.deleteBSysUploadById(fileVO.getId());
				}
			}
		}
		return picIds;
	}

}
