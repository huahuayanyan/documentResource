/**
 * 
 */
package com.huateng.scf.nbas.prd.service.impl;

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
import com.huateng.scf.bas.prd.dao.IBPrdWarnBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdWarnBind;
import com.huateng.scf.bas.prd.dao.model.BPrdWarnBindExample;
import com.huateng.scf.nbas.prd.model.BPrdWarnBindVO;
import com.huateng.scf.nbas.prd.service.INBPrdWarnBindService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>产品风险预警绑定	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月16日下午5:00:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月16日下午5:00:14	     新增
 *
 * </pre>
 */
@ScubeService
@Service("NBPrdWarnBindServiceImpl")
public class NBPrdWarnBindServiceImpl implements INBPrdWarnBindService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdWarnBindDAO")
	IBPrdWarnBindDAO bprdwarnbinddao;

	/**
	 * 分页查询产品风险预警列表
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdWarnBindVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月16日下午2:28:33
	 */
	@Override
	public Page findBPrdWarnBindByPage(int pageNo,int pageSize,BPrdWarnBindVO bPrdWarnBindVO)
	{
		log.debug("findBPrdWarnBindByPage=========================start");
		BPrdWarnBindExample example = new BPrdWarnBindExample();
		BPrdWarnBindExample.Criteria cri = example.createCriteria();
		if(bPrdWarnBindVO!=null)
		{
			if(!StringUtil.isEmpty(bPrdWarnBindVO.getProductId()))
			{
				cri.andProductIdEqualTo(bPrdWarnBindVO.getProductId());
			}
		}
		else 
		{
			return new Page(pageSize, pageNo, 0);
		}
		example.setOrderByClause("WARN_NO");
		int total = bprdwarnbinddao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(bprdwarnbinddao.selectByPage(example, page));
		log.debug("findBPrdWarnBindByPage=========================end");
		return page;
	}
	
	/**
	 * 保存产品风险预警信息
	 * @param list
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月16日下午2:31:50
	 */
	@Override
	@Transactional
	public void saveBPrdWarnBind(List<BPrdWarnBindVO> list,String productId)
	{
		//1.判断产品编号是否为空
		if(StringUtil.isEmpty(productId))
		{
			throw new ScubeBizException("产品编号丢失");
		}
		//2.判断勾选的预警信息是否已存在
		BPrdWarnBindExample example = new BPrdWarnBindExample();
		BPrdWarnBindExample.Criteria cri = example.createCriteria();
		cri.andProductIdEqualTo(productId);
		List<BPrdWarnBind> result = bprdwarnbinddao.selectByExample(example);
		//2-1.如果存在，则删除已存在预警信息
		if(result!=null&&result.size()>0)
		{
			for(BPrdWarnBind bind:result)
			{
				for(BPrdWarnBindVO bindVO:list)
				{
					if(bind.getWarnNo().equals(bindVO.getWarnNo()))
					{
						bprdwarnbinddao.deleteByPrimaryKey(bind.getId());
					}
				}
			}
		}
		if(list!=null&&list.size()>0)
		{
			for(BPrdWarnBindVO warnBindVO:list)
			{
				warnBindVO.setProductId(productId);
				this.addBPrdWarnBind(warnBindVO);
			}
		}
	}
	
	/**
	 * 新增预警绑定信息
	 * @param bPrdWarnBindVO
	 * @author 	mengjiajia
	 * @date 	2017年6月24日下午12:24:18
	 */
	@Override
	public void addBPrdWarnBind(BPrdWarnBindVO bPrdWarnBindVO)
	{
		BPrdWarnBind bind = new BPrdWarnBind();
		try
		{
			BeanUtils.copyProperties(bPrdWarnBindVO, bind);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		bind.setId(UUIDGeneratorUtil.generate());
		try
		{
			bprdwarnbinddao.insertSelective(bind);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
	}
	
	/**
	 * 删除产品风险预警信息
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午11:29:10
	 */
	@Override
	public void deleteBPrdWarnBindByKey(List<BPrdWarnBindVO> list)
	{
		if(list!=null&&list.size()>0)
		{
			for(BPrdWarnBindVO bindVO:list)
			{
				try
				{
					bprdwarnbinddao.deleteByPrimaryKey(bindVO.getId());
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("删除异常");
				}
			}
		}
	}
}
