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
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.IBPrdWkflowCopDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdWkflowCopExample;
import com.huateng.scf.nbas.prd.dao.IBPrdFlowDAO;
import com.huateng.scf.nbas.prd.dao.model.BPrdFlow;
import com.huateng.scf.nbas.prd.dao.model.BPrdFlowExample;
import com.huateng.scf.nbas.prd.model.BPrdFlowVO;
import com.huateng.scf.nbas.prd.service.IBPrdFlowService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>业务品种配置属性	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月13日下午3:30:06
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月13日下午3:30:06	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BPrdFlowServiceImpl")
public class BPrdFlowServiceImpl implements IBPrdFlowService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBPrdFlowDAO")
	IBPrdFlowDAO bprdflowdao;
	
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bprdinfodao;
	
	@Resource(name = "BPrdWkflowCopDAO")
	IBPrdWkflowCopDAO bprdwkflowcopdao;

	/**
	 * 分页查询列表信息
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdFlowVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午1:52:33
	 */
	@Override
	public Page findBPrdFlowServiceByPage(int pageNo, int pageSize, BPrdFlowVO bPrdFlowVO) throws ScubeBizException
	{
		log.debug("findBPrdFlowServiceByPage================================start");
		BPrdFlowExample example = new BPrdFlowExample();
		BPrdFlowExample.Criteria cri = example.createCriteria();
		if(bPrdFlowVO!=null)
		{
			if(!StringUtil.isEmpty(bPrdFlowVO.getProductId()))
			{
				cri.andProductIdEqualTo(bPrdFlowVO.getProductId());
			}
			if(!StringUtil.isEmpty(bPrdFlowVO.getModelId()))
			{
				cri.andModelIdLike(bPrdFlowVO.getModelId());
			}
		}
		else 
		{
			return new Page(pageSize, pageNo, 0);
		}
		int total = bprdflowdao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		List<BPrdFlow> list = bprdflowdao.selectByPage(example, page);
		List<BPrdFlowVO> result = new ArrayList<BPrdFlowVO>();
		BPrdFlowVO flowVO = null;
		if(list!=null&&list.size()>0)
		{
			for(BPrdFlow bPrdFlow:list)
			{
				flowVO = new BPrdFlowVO();
				BeanUtils.copyProperties(bPrdFlow, flowVO);
				if(!StringUtil.isEmpty(flowVO.getModelId()))
				{
					BPrdWkflowCopExample examplefl = new BPrdWkflowCopExample();
					BPrdWkflowCopExample.Criteria crifl = examplefl.createCriteria();
					crifl.andFlowCopIdEqualTo(flowVO.getModelId());
					flowVO.setModelName(bprdwkflowcopdao.selectByExample(examplefl).get(0).getFlowName());
				}
				else
				{
					flowVO.setModelName("无");
				}
				if(StringUtil.isEmpty(flowVO.getCallerClasspath()))
				{
					flowVO.setCallerClasspath("无");
				}
				if(StringUtil.isEmpty(flowVO.getUrl()))
				{
					flowVO.setUrl("无");
				}
				String inpDt = ScfDateUtil.formatDate(flowVO.getCrtTime(), ScfDateUtil.DATE_FORMAT_FULL);
				flowVO.setInpDt(inpDt);
				result.add(flowVO);
			}
		}
		page.setRecords(result);
		log.debug("findBPrdFlowServiceByPage================================end");
		return page;
	}
	
	/**
	 * 新增
	 * @param bPrdFlowVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午2:44:22
	 */
	@Override
	@Transactional
	public void addBPrdFlow(BPrdFlowVO bPrdFlowVO) throws ScubeBizException
	{
		this.CheckBPrdFlow(bPrdFlowVO);
		BPrdFlow bPrdFlow = new BPrdFlow();
		try
		{
			BeanUtils.copyProperties(bPrdFlowVO, bPrdFlow);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		bPrdFlow.setId(UUIDGeneratorUtil.generate());
		String tlrno = ContextHolder.getUserInfo().getTlrNo();
		String brno = ContextHolder.getOrgInfo().getBrNo();
		bPrdFlow.setTlrcd(tlrno);
		bPrdFlow.setBrcode(brno);
		bPrdFlow.setCrtTime(new Date());
		bPrdFlow.setLastUpdBrcode(brno);
		bPrdFlow.setLastUpdTlrcd(tlrno);
		bPrdFlow.setLastUpdTime(new Date());
		try
		{
			bprdflowdao.insertSelective(bPrdFlow);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
	}
	
	/**
	 * 修改
	 * @param bPrdFlowVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午2:47:18
	 */
	@Override
	@Transactional
	public void updateBPrdFlow(BPrdFlowVO bPrdFlowVO) throws ScubeBizException
	{
		this.CheckBPrdFlow(bPrdFlowVO);
		BPrdFlow bPrdFlow = new BPrdFlow();
		try
		{
			BeanUtils.copyProperties(bPrdFlowVO, bPrdFlow);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		String tlrno = ContextHolder.getUserInfo().getTlrNo();
		String brno = ContextHolder.getOrgInfo().getBrNo();
		bPrdFlow.setLastUpdBrcode(brno);
		bPrdFlow.setLastUpdTlrcd(tlrno);
		bPrdFlow.setLastUpdTime(new Date());
		try
		{
			bprdflowdao.updateByPrimaryKeySelective(bPrdFlow);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
	}
	
	/**
	 * 删除
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午2:50:51
	 */
	@Override
	public int deleteBPrdFlow(List<BPrdFlowVO> list) throws ScubeBizException
	{
		int i = 0;
		if(list!=null&&list.size()>0)
		{
			for(BPrdFlowVO flowVO:list)
			{
				try
				{
					i += bprdflowdao.deleteByPrimaryKey(flowVO.getId());
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("删除异常");
				}
			}
		}
		return i;
	}
	
	/**
	 * 查重
	 * @param bPrdFlowVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午4:09:05
	 */
	public void CheckBPrdFlow(BPrdFlowVO bPrdFlowVO) throws ScubeBizException
	{
		BPrdFlowExample example = new BPrdFlowExample();
		BPrdFlowExample.Criteria cri = example.createCriteria();
		cri.andProductIdEqualTo(bPrdFlowVO.getProductId());
		cri.andInvokPhaseEqualTo(bPrdFlowVO.getInvokPhase());
		if(!StringUtil.isEmpty(bPrdFlowVO.getId()))
		{
			cri.andIdNotEqualTo(bPrdFlowVO.getId());
		}
		List<BPrdFlow> list = bprdflowdao.selectByExample(example);
		if(list!=null&&list.size()>0)
		{
			throw new ScubeBizException("调用阶段已存在，请重新选择");
		}
	}
	
	/**
	 * 根据条件获取配置信息
	 * @param productId
	 * @param invokPhase
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午4:36:37
	 */
	@Override
	public BPrdFlowVO findBPrdFlowVOByParam(String productId,String invokPhase) throws ScubeBizException
	{
		BPrdFlowVO flowVO = null;
		BPrdFlowExample example = new BPrdFlowExample();
		BPrdFlowExample.Criteria cri = example.createCriteria();
		cri.andProductIdEqualTo(productId);
		cri.andInvokPhaseEqualTo(invokPhase);
		List<BPrdFlow> list = bprdflowdao.selectByExample(example);
		if(list!=null&&list.size()>0)
		{
			flowVO = new BPrdFlowVO();
			BeanUtils.copyProperties(list.get(0), flowVO);
		}
		return flowVO;
	}
	
	/**
	 * 复制已有信息，改变个别要素，并新增
	 * @param bPrdFlowVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月13日上午9:41:06
	 */
	@Override
	public void copyBprdFolw(BPrdFlowVO bPrdFlowVO) throws ScubeBizException
	{
		bPrdFlowVO.setId(null);
		this.CheckBPrdFlow(bPrdFlowVO);
		BPrdFlow bPrdFlow = new BPrdFlow();
		try
		{
			BeanUtils.copyProperties(bPrdFlowVO, bPrdFlow);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		bPrdFlow.setId(UUIDGeneratorUtil.generate());
		try
		{
			bprdflowdao.insertSelective(bPrdFlow);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
	}
}
