package com.huateng.scf.nbas.prd.service.impl;

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
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.nbas.prd.dao.IBPrdChkdirInfoDAO;
import com.huateng.scf.nbas.prd.dao.model.BPrdChkdirInfo;
import com.huateng.scf.nbas.prd.dao.model.BPrdChkdirInfoExample;
import com.huateng.scf.nbas.prd.model.BPrdChkdirInfoVO;
import com.huateng.scf.nbas.prd.service.IBPrdChkdirInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>业务品种风险拦截模型绑定	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月23日下午4:01:29
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月23日下午4:01:29	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BPrdChkdirInfoServiceImpl")
public class BPrdChkdirInfoServiceImpl implements IBPrdChkdirInfoService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBPrdChkdirInfoDAO")
	IBPrdChkdirInfoDAO bprdchkdirinfodao;
	
	/**
	 * 根据业务品种查询各调用阶段风险拦截信息
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdChkdirInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:05:48
	 */
	@Override
	public Page findBPrdChkdirInfoByPage(int pageNo,int pageSize,BPrdChkdirInfoVO bPrdChkdirInfoVO)
	{
		log.debug("findBPrdChkdirInfoByPage================================start");
		BPrdChkdirInfoExample example = new BPrdChkdirInfoExample();
		BPrdChkdirInfoExample.Criteria cri = example.createCriteria();
		if(bPrdChkdirInfoVO!=null)
		{
			if(!StringUtil.isEmpty(bPrdChkdirInfoVO.getProductId()))
			{
				cri.andProductIdEqualTo(bPrdChkdirInfoVO.getProductId());
			}
		}
		else 
		{
			return new Page(pageSize, pageNo, 0);
		}
		int total = bprdchkdirinfodao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(bprdchkdirinfodao.selectByPage(example, page));
		log.debug("findBPrdChkdirInfoByPage================================end");
		return page;
	}
	
	/**
	 * 保存风险拦截模版信息
	 * @param list
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:08:55
	 */
	@Override
	@Transactional
	public void saveBPrdChkdirInfo(List<BPrdChkdirInfoVO> list,String productId)
	{
		//1.判断产品编号是否为空
		if(StringUtil.isEmpty(productId))
		{
			throw new ScubeBizException("产品编号丢失");
		}
		if(list!=null&&list.size()>0)
		{
			for(BPrdChkdirInfoVO infoVO:list)
			{
				BPrdChkdirInfo info = new BPrdChkdirInfo();
				try
				{
					BeanUtils.copyProperties(infoVO, info);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				info.setProductId(productId);
				info.setId(UUIDGeneratorUtil.generate());
				try
				{
					bprdchkdirinfodao.insertSelective(info);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("保存异常");
				}
			}
		}
	}
	
	/**
	 * 修改风险拦截模型绑定信息
	 * @param bPrdChkdirInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:12:06
	 */
	@Override
	@Transactional
	public void updateBPrdChkdir(BPrdChkdirInfoVO bPrdChkdirInfoVO)
	{
		boolean flag = checkChkdir(bPrdChkdirInfoVO);
		if(!flag)
		{
			throw new ScubeBizException("该拦截模型的调用阶段已存在，请重新选择！");
		}
		BPrdChkdirInfo info = new BPrdChkdirInfo();
		try
		{
			BeanUtils.copyProperties(bPrdChkdirInfoVO, info);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bprdchkdirinfodao.updateByPrimaryKeySelective(info);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
	}
	
	/**
	 * 删除绑定风险拦截模型信息
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:13:42
	 */
	@Override
	public void deleteBPrdChkdirInfoByKey(List<BPrdChkdirInfoVO> list)
	{
		if(list!=null&&list.size()>0)
		{
			for(BPrdChkdirInfoVO infoVO:list)
			{
				try
				{
					bprdchkdirinfodao.deleteByPrimaryKey(infoVO.getId());
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("删除异常");
				}
			}
		}
	}
	
	/**
	 * 校验业务品种风险截模型的调用阶段是否重复
	 * 重复则返回false,不重复返回true
	 * @param bPrdChkdirInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:15:34
	 */
	public boolean checkChkdir(BPrdChkdirInfoVO bPrdChkdirInfoVO)
	{
		boolean flag = false;
		BPrdChkdirInfoExample example = new BPrdChkdirInfoExample();
		BPrdChkdirInfoExample.Criteria cri = example.createCriteria();
		cri.andProductIdEqualTo(bPrdChkdirInfoVO.getProductId());
		cri.andInvokPhaseEqualTo(bPrdChkdirInfoVO.getInvokPhase());
		List<BPrdChkdirInfo> list = bprdchkdirinfodao.selectByExample(example);
		if(list!=null&&list.size()>0)
		{//存在
			flag = false;
		}
		else
		{//不存在
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 根据业务品种及调用阶段查询风险拦截模型信息
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:28:31
	 */
	@Override
	public BPrdChkdirInfoVO findBPrdChkdirInfoByParam(HashMap<String, Object> omap)
	{
		if(StringUtil.isEmpty(omap.get("productId")))
		{
			throw new ScubeBizException("业务品种丢失！");
		}
		if(StringUtil.isEmpty(omap.get("invokPhase")))
		{
			throw new ScubeBizException("调用阶段丢失！");
		}
		BPrdChkdirInfoVO infoVO = null;
		String productId = omap.get("productId").toString();//业务品种
		String invokPhase = omap.get("invokPhase").toString();//调用阶段
		BPrdChkdirInfoExample example = new BPrdChkdirInfoExample();
		BPrdChkdirInfoExample.Criteria cri = example.createCriteria();
		cri.andProductIdEqualTo(productId);
		cri.andInvokPhaseEqualTo(invokPhase);
		List<BPrdChkdirInfo> list = bprdchkdirinfodao.selectByExample(example);
		if(list==null||list.size()==0)
		{
//			throw new ScubeBizException("该业务品种对应调用阶段的风险拦截模型未绑定,请在业务配置中绑定！");
		}
		else
		{
			infoVO = new BPrdChkdirInfoVO();
			BeanUtils.copyProperties(list.get(0), infoVO);
		}
		return infoVO;
	}
	
	/**
	 * 删除调用阶段为空的风险拦截模型信息
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午5:25:56
	 */
	@Override
	public void deleteBPrdChkdirByExample(String productId)
	{
		BPrdChkdirInfoExample example = new BPrdChkdirInfoExample();
		BPrdChkdirInfoExample.Criteria cri = example.createCriteria();
		cri.andProductIdEqualTo(productId);
		cri.andInvokPhaseIsNull();
		bprdchkdirinfodao.deleteByExample(example);
	}
}
