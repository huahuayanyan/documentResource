/**
 * 
 */
package com.huateng.scf.bas.brp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpPageParamPackageDAO;
import com.huateng.scf.bas.brp.dao.IBBrpWarnParamDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackageExample;
import com.huateng.scf.bas.brp.dao.model.BBrpWarnParamExample;
import com.huateng.scf.bas.brp.model.BBrpPageParamPackage;
import com.huateng.scf.bas.brp.model.BBrpWarnParam;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scf.bas.brp.service.IWarnParamMngService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>预警参数设置服务类</p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月15日上午11:08:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月15日上午11:08:51              新增
 *
 * </pre>
 */
@ScubeService
@Service(IWarnParamMngService.BEAN_ID)
public class WarnParamMngServiceImpl implements IWarnParamMngService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BBrpPageParamPackageDAO")
	IBBrpPageParamPackageDAO bBrpPageParamPackageDAO; //预警参数设置分类表
	
	@Resource(name = "BBrpWarnParamDAO")
	IBBrpWarnParamDAO bBrpWarnParamDAO;  //预警参数配置表
	
	

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.brp.service.IWarningMngService#WarningMngTreeGetter(java.util.HashMap)
	 */
	@Override
	public List<TreeModel> getWarnParamPackageList(HashMap<String, String> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		log.debug("获预警参数设置分类信息==================");
		List<TreeModel> list = new ArrayList<TreeModel>();
		BBrpPageParamPackageExample example = new BBrpPageParamPackageExample();
		BBrpPageParamPackageExample.Criteria cri = example.createCriteria();
		
		if(value!=null){
			String id = value.get("id");
			if(StringUtil.isStrNotEmpty(id)){
				cri.andIdEqualTo("id");
			}
		}
		example.setOrderByClause("SUPER_ID,ID");
		List<com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackage> listP = bBrpPageParamPackageDAO.selectByExample(example);
		TreeModel treeMode  = null;
		if(listP!=null&&listP.size()>0){
			for(com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackage VO:listP){
				treeMode = new TreeModel();

				treeMode.setTreeId(VO.getId());
				//treeMode.setTreeLevel(String.valueOf(newLevel));
				treeMode.setTreeName(VO.getName());
				treeMode.setTreeParentId(VO.getSuperId());
				list.add(treeMode);
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.brp.service.IWarnParamMngService#findBBrpPageParamPackageByKey(java.lang.String)
	 */
	@Override
	public BBrpPageParamPackage findBBrpPageParamPackageByKey(String key) {
		// TODO Auto-generated method stub
		BBrpPageParamPackage bBrpPageParamPackage = null;
		com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackage bBrpPageParamPackagedal = bBrpPageParamPackageDAO.selectByPrimaryKey(key);
		if(bBrpPageParamPackagedal!=null){
			bBrpPageParamPackage = new BBrpPageParamPackage();
			BeanUtils.copyProperties(bBrpPageParamPackagedal,bBrpPageParamPackage);
			
		}
		return bBrpPageParamPackage;
	}
	
	@Transactional
	@Override
	public void addBBrpPageParamPackage(BBrpPageParamPackage bBrpPageParamPackage) throws ScubeBizException {
		com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackage bBrpPageParamPackagedal = new com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackage();
		bBrpPageParamPackage.setId(UUIDGeneratorUtil.generate());
		try {
			BeanUtils.copyProperties(bBrpPageParamPackage, bBrpPageParamPackagedal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("预警参数设置分类信息转换异常！");
			throw new ScubeBizException("预警参数设置分类转换异常！");
		}
		// TODO
		try {
			bBrpPageParamPackageDAO.insertSelective(bBrpPageParamPackagedal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预警参数设置分类插入异常！");
			throw new ScubeBizException("预警参数设置分类插入异常！");
		}
	}

	@Transactional
	@Override
	public int updateBBrpPageParamPackage(BBrpPageParamPackage bBrpPageParamPackage) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackage bBrpPageParamPackagedal = new com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackage();
		try {
			BeanUtils.copyProperties(bBrpPageParamPackage, bBrpPageParamPackagedal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预警参数设置分类转换异常！");
			throw new ScubeBizException("预警参数设置分类转换异常！");
		}
		int i = 0;
		try {
			i = bBrpPageParamPackageDAO.updateByPrimaryKeySelective(bBrpPageParamPackagedal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预警参数设置分类更新异常！");
			throw new ScubeBizException("预警参数设置分类更新异常！");
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteBBrpPageParamPackage(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = bBrpPageParamPackageDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预警参数设置分类删除异常！");
			throw new ScubeBizException("预警参数设置分类删除异常！");
		}
		return i;
	}  
	
	
	@Override
	public Page findWarnParamListByPage(int pageNo, int pageSize, BBrpWarnParam bBrpWarnParam) {
		Page p = new Page(pageSize, pageNo, 0);
		BBrpWarnParamExample example = new BBrpWarnParamExample();
		com.huateng.scf.bas.brp.dao.model.BBrpWarnParamExample.Criteria cri = example.createCriteria();
		if (bBrpWarnParam != null) {
			// 预警编号,warnNo
			if (bBrpWarnParam.getWarnNo() != null && !"".equals(bBrpWarnParam.getWarnNo())) {
				cri.andWarnNoEqualTo(bBrpWarnParam.getWarnNo());
			}
			// 预警名称,warnName
			if (bBrpWarnParam.getWarnName() != null && !"".equals(bBrpWarnParam.getWarnName())) {
				cri.andWarnNameLike("%" + bBrpWarnParam.getWarnName() + "%");
			}
			// 预警类型,warnType
			if (bBrpWarnParam.getWarnType() != null && !"".equals(bBrpWarnParam.getWarnType())) {
				cri.andWarnTypeEqualTo(bBrpWarnParam.getWarnType());
			}
			// 预警目标类型,targetType
			if (bBrpWarnParam.getTargetType() != null && !"".equals(bBrpWarnParam.getTargetType())) {
				cri.andTargetTypeEqualTo(bBrpWarnParam.getTargetType());
			}
			//所属包编号packageId
			if (StringUtil.isStrNotEmpty(bBrpWarnParam.getPackageId())) {
				cri.andPackageIdEqualTo(bBrpWarnParam.getPackageId());
			}else{
				cri.andPackageIdEqualTo("1"); //默认查询预警参数配置库
			}
		}
		try {
			p.setRecords(bBrpWarnParamDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("预警信息分页查询失败！");
			throw new ScubeBizException("预警信息分页查询失败！", e);
		}
	}
	/**
	 * 预警配置信息删除
	 */
	@Override
	@Transactional
	public void deleteWarnParam(@ScubeParam("list")List<BBrpWarnParam> list)throws ScubeBizException{
		if(list!=null&&list.size()!=0){
			for(BBrpWarnParam VO:list){
				try {
					bBrpWarnParamDAO.deleteByPrimaryKey(VO.getWarnNo());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
					throw new ScubeBizException("预警信息删除失败！", e);
				}
			}
		}
		
	}


}
