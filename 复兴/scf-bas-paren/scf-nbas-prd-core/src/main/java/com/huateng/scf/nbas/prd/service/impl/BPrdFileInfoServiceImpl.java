package com.huateng.scf.nbas.prd.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.nbas.prd.dao.IBPrdFileInfoDAO;
import com.huateng.scf.nbas.prd.dao.domodel.BPrdFileInfoDO;
import com.huateng.scf.nbas.prd.dao.ext.ExtNBPrdDAO;
import com.huateng.scf.nbas.prd.dao.model.BPrdFileInfo;
import com.huateng.scf.nbas.prd.dao.model.BPrdFileInfoExample;
import com.huateng.scf.nbas.prd.model.BPrdFileInfoVO;
import com.huateng.scf.nbas.prd.service.IBPrdFileInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>产品合同模板	接口上实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月15日下午5:06:00
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月15日下午5:06:00	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BPrdFileInfoServiceImpl")
public class BPrdFileInfoServiceImpl implements IBPrdFileInfoService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBPrdFileInfoDAO")
	IBPrdFileInfoDAO bprdfileinfodao;
	
	@Resource(name = "ExtNBPrdDAO")
	ExtNBPrdDAO extnbprddao;
	
	/**
	 * 分页查询该业务品种下上传文件所需类型
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdContInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月15日下午5:09:25
	 */
	@Override
	public Page findBPrdFileInfoByPage(int pageNo,int pageSize,BPrdFileInfoVO bPrdFileInfoVO)
	{
		log.debug("findBPrdFileInfoByPage================================start");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(bPrdFileInfoVO!=null)
		{
			if(!StringUtil.isEmpty(bPrdFileInfoVO.getProductId()))
			{
				omap.put("productId", bPrdFileInfoVO.getProductId());
			}
		}
		else 
		{
			return new Page(pageSize, pageNo, 0);
		}
		int total = extnbprddao.countBPrdFileInfoByPage(omap);
		Page page = new Page(pageSize, pageNo, total);
		List<BPrdFileInfoDO> list = extnbprddao.findBPrdFileInfoByPage(omap, page, true);
		List<BPrdFileInfoVO> result = new ArrayList<BPrdFileInfoVO>();
		if(list!=null&&list.size()>0)
		{
			for(BPrdFileInfoDO bPrdContInfoDO:list)
			{
				BPrdFileInfoVO contInfoVO = new BPrdFileInfoVO();
				BeanUtils.copyProperties(bPrdContInfoDO, contInfoVO);
				String inpDt = ScfDateUtil.formatDate(contInfoVO.getCrtTime(), ScfDateUtil.DATE_FORMAT_FULL);
				contInfoVO.setInpDt(inpDt);
				result.add(contInfoVO);
			}
		}
		page.setRecords(result);
		log.debug("findBPrdFileInfoByPage================================start");
		return page;
	}
	
	/**
	 * 保存合同模板信息
	 * @param bPrdContInfoVO
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午9:50:54
	 */
	@Override
	@Transactional
	public void saveBPrdFileInfo(List<BPrdFileInfoVO> list,String productId)
	{
		//1.判断产品编号
		if(StringUtil.isEmpty(productId))
		{
			throw new ScubeBizException("产品编号丢失");
		}
		//2.判断勾选的合同类型信息是否已存在
		BPrdFileInfoExample example = new BPrdFileInfoExample();
		BPrdFileInfoExample.Criteria cri = example.createCriteria();
		cri.andProductIdEqualTo(productId);
		List<BPrdFileInfo> result = bprdfileinfodao.selectByExample(example);
		//2-1.若存在，则删除已存在数据
		if(result!=null&&result.size()>0)
		{
			for(BPrdFileInfo info:result)
			{
				for(BPrdFileInfoVO infoVO:list)
				{
					if(info.getContCode().equals(infoVO.getContCode()))
					{
						bprdfileinfodao.deleteByPrimaryKey(info.getId());
					}
				}
			}
		}
		if(list!=null&&list.size()>0)
		{
			for(BPrdFileInfoVO bPrdFileInfoVO:list)
			{
				BPrdFileInfo fileInfo = new BPrdFileInfo();
				try
				{
					BeanUtils.copyProperties(bPrdFileInfoVO, fileInfo);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				fileInfo.setId(UUIDGeneratorUtil.generate());
				fileInfo.setProductId(productId);
				fileInfo.setStatus(ScfBasConstant.FLAG_ON);
				String tlrno = ContextHolder.getUserInfo().getTlrNo();
				String brno = ContextHolder.getOrgInfo().getBrNo();
				fileInfo.setTlrcd(tlrno);
				fileInfo.setBrcode(brno);
				fileInfo.setCrtTime(new Date());
				fileInfo.setLastUpdBrcode(brno);
				fileInfo.setLastUpdTlrcd(tlrno);
				fileInfo.setLastUpdTime(new Date());
				try
				{
					bprdfileinfodao.insertSelective(fileInfo);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("保存异常");
				}
			}
		}
	}
	
	/**
	 * 删除
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午10:00:14
	 */
	@Override
	@Transactional
	public void deleteBPrdFileInfoById(List<BPrdFileInfoVO> list)
	{
		if(list!=null&&list.size()>0)
		{
			for(BPrdFileInfoVO fileInfoVO:list)
			{
				try
				{
					bprdfileinfodao.deleteByPrimaryKey(fileInfoVO.getId());
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("删除异常");
				}
			}
		}
	}
}
