package com.huateng.scf.nbas.prd.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpIndustryTypesDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.prd.dao.IBPrdIndustryTypeDAO;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.prd.dao.model.BPrdInfoExample;
import com.huateng.scf.bas.prd.dao.model.BPrdIndustryType;
import com.huateng.scf.nbas.prd.dao.IBPrdFileInfoDAO;
import com.huateng.scf.nbas.prd.dao.model.BPrdFileInfo;
import com.huateng.scf.nbas.prd.model.BPrdFileInfoVO;
import com.huateng.scf.nbas.prd.model.BPrdInfoVO;
import com.huateng.scf.nbas.prd.service.INBPrdInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>产品基本信息	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月15日下午3:01:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月15日下午3:01:43	     新增
 *
 * </pre>
 */
@ScubeService
@Service("NBPrdInfoServiceImpl")
public class NBPrdInfoServiceImpl implements INBPrdInfoService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bprdinfodao;
	
	@Resource(name = "IBPrdFileInfoDAO")
	IBPrdFileInfoDAO bprdfileinfodao;
	
	@Resource(name = "BPrdIndustryTypeDAO")
	IBPrdIndustryTypeDAO bprdindustrytypedao;
	
	@Resource(name = "BBrpIndustryTypesDAO")
	IBBrpIndustryTypesDAO bbrpindustrytypesdao;
	
	/**
	 * 分页查询产品列表信息
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月15日下午3:19:33
	 */
	@Override
	public Page findBPrdInfoByPage(int pageNo,int pageSize,BPrdInfoVO bPrdInfoVO)
	{
		log.debug("findBPrdInfoByPage================================start");
		BPrdInfoExample example = new BPrdInfoExample();
		BPrdInfoExample.Criteria cri = example.createCriteria();
		if(bPrdInfoVO!=null)
		{
			if(!StringUtil.isEmpty(bPrdInfoVO.getProductId()))
			{
				cri.andProductIdLike("%"+bPrdInfoVO.getProductId()+"%");
			}
			if(!StringUtil.isEmpty(bPrdInfoVO.getProductName()))
			{
				cri.andProductNameLike("%"+bPrdInfoVO.getProductName()+"%");
			}
			if(!StringUtil.isEmpty(bPrdInfoVO.getProductType()))
			{
				cri.andProductTypeEqualTo(bPrdInfoVO.getProductType());
			}
		}
		example.setOrderByClause("LAST_UPD_TIME desc");
		int total = bprdinfodao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		List<BPrdInfo> list = bprdinfodao.selectByPage(example, page);
		List<BPrdInfoVO> result = new ArrayList<BPrdInfoVO>();
		if(list!=null&&list.size()>0)
		{
			for(BPrdInfo bPrdInfo:list)
			{
				BPrdInfoVO infoVO = new BPrdInfoVO();
				BeanUtils.copyProperties(bPrdInfo, infoVO);
				BPrdIndustryType bPrdIndustryType = bprdindustrytypedao.selectByProductId(infoVO.getProductId());
				if(bPrdIndustryType!=null)
				{
					String industryType = "";
					String industryTypeName = "";
					for(String type:bPrdIndustryType.getIndustryType().split(","))
					{
						BBrpIndustryTypes types = bbrpindustrytypesdao.selectByPrimaryKey(type);
						industryType += types.getIndustryCode()+",";
						industryTypeName += types.getIndustryCode()+"-"+types.getIndustryName()+",";
					}
					industryType = industryType.substring(0, industryType.lastIndexOf(","));
					industryTypeName = industryTypeName.substring(0, industryTypeName.lastIndexOf(","));
					infoVO.setIndustryType(industryType);
					infoVO.setIndustryTypeName(industryTypeName);
				}
				result.add(infoVO);
			}
		}
		page.setRecords(result);
		log.debug("findBPrdInfoByPage================================start");
		return page;
	}
	
	/**
	 * 新增修改产品基本信息
	 * @param bPrdInfoVO
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月15日下午5:20:35
	 */
	@Override
	@Transactional
	public void addBPrdInfo(BPrdInfoVO bPrdInfoVO,List<BPrdFileInfoVO> list)
	{
		BPrdInfo bPrdInfo = bprdinfodao.selectByPrimaryKey(bPrdInfoVO.getProductId());
		if(bPrdInfo!=null)
		{
			throw new ScubeBizException("产品编号已存在，请重新输入！");
		}
		bPrdInfo = new BPrdInfo();
		try
		{
			BeanUtils.copyProperties(bPrdInfoVO, bPrdInfo);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		String tlrno = ContextHolder.getUserInfo().getTlrNo();
		String brno = ContextHolder.getOrgInfo().getBrNo();
		bPrdInfo.setTlrcd(tlrno);
		bPrdInfo.setBrcode(brno);
		bPrdInfo.setCrtTime(new Date());
		bPrdInfo.setLastUpdBrcode(brno);
		bPrdInfo.setLastUpdTlrcd(tlrno);
		bPrdInfo.setLastUpdTime(new Date());
		bPrdInfo.setActiveDate(ScfDateUtil.getStringDate(new Date()));
		bPrdInfo.setStatus(ScfBasConstant.FLAG_ON);
		try
		{
			bprdinfodao.insertSelective(bPrdInfo);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
		if(!StringUtil.isEmpty(bPrdInfoVO.getIndustryType()))
		{
			BPrdIndustryType industryType = new BPrdIndustryType();
			BeanUtils.copyProperties(bPrdInfoVO, industryType);
			industryType.setId(UUIDGeneratorUtil.generate());
			bprdindustrytypedao.insertSelective(industryType);
		}
		if(list!=null&&list.size()>0)
		{
			BPrdFileInfo bPrdFileInfo = null;
			for(BPrdFileInfoVO fileInfoVO:list)
			{
				bPrdFileInfo = new BPrdFileInfo();
				try
				{
					BeanUtils.copyProperties(fileInfoVO, bPrdFileInfo);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				bPrdFileInfo.setId(UUIDGeneratorUtil.generate());
				bPrdFileInfo.setStatus(ScfBasConstant.FLAG_ON);
				bPrdFileInfo.setTlrcd(tlrno);
				bPrdFileInfo.setBrcode(brno);
				bPrdFileInfo.setCrtTime(new Date());
				bPrdFileInfo.setLastUpdBrcode(brno);
				bPrdFileInfo.setLastUpdTlrcd(tlrno);
				bPrdFileInfo.setLastUpdTime(new Date());
				try
				{
					bprdfileinfodao.insertSelective(bPrdFileInfo);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("保存异常");
				}
			}
		}
	}
	
	/**
	 * 修改产品信息
	 * @param bPrdInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月15日下午5:30:36
	 */
	@Override
	@Transactional
	public void updateBPrdInfo(BPrdInfoVO bPrdInfoVO)
	{
		BPrdInfo bPrdInfo = new BPrdInfo();
		try
		{
			BeanUtils.copyProperties(bPrdInfoVO, bPrdInfo);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		String tlrno = ContextHolder.getUserInfo().getTlrNo();
		String brno = ContextHolder.getOrgInfo().getBrNo();
		bPrdInfo.setLastUpdBrcode(brno);
		bPrdInfo.setLastUpdTlrcd(tlrno);
		bPrdInfo.setLastUpdTime(new Date());
		try
		{
			bprdinfodao.updateByPrimaryKeySelective(bPrdInfo);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
		if(!StringUtil.isEmpty(bPrdInfoVO.getIndustryType()))
		{
			BPrdIndustryType bPrdIndustryType = bprdindustrytypedao.selectByProductId(bPrdInfoVO.getProductId());
			BPrdIndustryType industryType = new BPrdIndustryType();
			if(bPrdIndustryType!=null)
			{
				industryType.setId(bPrdIndustryType.getId());
				industryType.setIndustryType(bPrdInfoVO.getIndustryType());
				bprdindustrytypedao.updateByPrimaryKeySelective(industryType);
			}
			else
			{
				BeanUtils.copyProperties(bPrdInfoVO, industryType);
				industryType.setId(UUIDGeneratorUtil.generate());
				bprdindustrytypedao.insertSelective(industryType);
			}
		}
	}
}
