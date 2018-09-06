/**
 * 
 */
package com.huateng.scf.nbas.prd.service.impl;

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
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.cnt.service.IBCntCostInfoService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.prd.dao.IBPrdCostBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCostBind;
import com.huateng.scf.bas.prd.dao.model.BPrdCostBindExample;
import com.huateng.scf.nbas.prd.dao.domodel.BPrdCostInfoDO;
import com.huateng.scf.nbas.prd.dao.ext.ExtNBPrdDAO;
import com.huateng.scf.nbas.prd.model.BCntCostInfoVO;
import com.huateng.scf.nbas.prd.model.BPrdCostBindVO;
import com.huateng.scf.nbas.prd.service.INBPrdCostBindService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>产品费用绑定	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月16日上午10:29:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月16日上午10:29:43	     新增
 *
 * </pre>
 */
@ScubeService
@Service("NBPrdCostBindServiceImpl")
public class NBPrdCostBindServiceImpl implements INBPrdCostBindService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdCostBindDAO")
	IBPrdCostBindDAO bprdcostbinddao;

	@Resource(name = "ExtNBPrdDAO")
	ExtNBPrdDAO extnbprddao;
	
	//费用信息
	@Resource(name = "BCntCostInfoServiceImpl")
	IBCntCostInfoService bcntcostinfoservice;
	
	/**
	 * 分页查询产品费用信息
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdCostBindVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午10:53:46
	 */
	@Override
	public Page findBPrdCostBindByPage(int pageNo,int pageSize,BPrdCostBindVO bPrdCostBindVO)
	{
		log.debug("findBPrdCostBindByPage=========================start");
		BPrdCostBindExample example = new BPrdCostBindExample();
		BPrdCostBindExample.Criteria cri = example.createCriteria();
		if(bPrdCostBindVO!=null)
		{
			if(!StringUtil.isEmpty(bPrdCostBindVO.getProductId()))
			{
				cri.andProductIdEqualTo(bPrdCostBindVO.getProductId());
			}
		}
		else 
		{
			return new Page(pageSize, pageNo, 0);
		}
		example.setOrderByClause("COST_PHASE");
		int total = bprdcostbinddao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(bprdcostbinddao.selectByPage(example, page));
		log.debug("findBPrdCostBindByPage=========================end");
		return page;
	}
	
	/**
	 * 保存产品费用信息
	 * @param list
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午11:21:00
	 */
	@Override
	@Transactional
	public void saveBPrdCostBind(List<BPrdCostBindVO> list,String productId)
	{
		//1.判断产品编号是否为空
		if(StringUtil.isEmpty(productId))
		{
			throw new ScubeBizException("产品编号丢失");
		}
		//2.清空原有产品费用信息
//		BPrdCostBindExample example = new BPrdCostBindExample();
//		BPrdCostBindExample.Criteria cri = example.createCriteria();
//		cri.andProductIdEqualTo(productId);
//		bprdcostbinddao.deleteByExample(example);
		if(list!=null&&list.size()>0)
		{
			for(BPrdCostBindVO bindVO:list)
			{
				BPrdCostBind bind = new BPrdCostBind();
				try
				{
					BeanUtils.copyProperties(bindVO, bind);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				bind.setProductId(productId);
				bind.setId(UUIDGeneratorUtil.generate());
				try
				{
					bprdcostbinddao.insertSelective(bind);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("保存异常");
				}
			}
		}
	}
	
	/**
	 * 修改产品费用信息
	 * @param bPrdCostBindVO
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午11:27:26
	 */
	@Override
	@Transactional
	public void updateBPrdCostBind(BPrdCostBindVO bPrdCostBindVO)
	{
		boolean flag = checkCostBind(bPrdCostBindVO);
		if(!flag)
		{
			throw new ScubeBizException("该拦截模型的调用阶段已存在，请重新选择！");
		}
		BPrdCostBind bind = new BPrdCostBind();
		try
		{
			BeanUtils.copyProperties(bPrdCostBindVO, bind);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bprdcostbinddao.updateByPrimaryKeySelective(bind);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
	}
	
	/**
	 * 删除产品费用信息
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午11:29:10
	 */
	@Override
	public void deleteBPrdCostBindByKey(List<BPrdCostBindVO> list)
	{
		if(list!=null&&list.size()>0)
		{
			for(BPrdCostBindVO bindVO:list)
			{
				try
				{
					bprdcostbinddao.deleteByPrimaryKey(bindVO.getId());
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("删除异常");
				}
			}
		}
	}
	
	/**
	 * 根据productId和costPhase查询业务品种费用信息
	 * @param productId
	 * @param costPhase
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月19日上午10:52:20
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<?> findBPrdCostInfoByProductIdAndCostPhase(HashMap<String, Object> omap)
	{
		if(StringUtil.isEmpty(omap.get("mastContno")))
		{
			throw new ScubeBizException("业务合同号丢失！");
		}
		if(StringUtil.isEmpty(omap.get("productId")))
		{
			throw new ScubeBizException("业务品种编号丢失！");
		}
		if(StringUtil.isEmpty(omap.get("costPhase")))
		{
			throw new ScubeBizException("费用收取阶段丢失！");
		}
		String mastContno = omap.get("mastContno").toString();
		String productId = omap.get("productId").toString();
		String costPhase = omap.get("costPhase").toString();
		List result = new ArrayList();
		if(!StringUtil.isEmpty(mastContno))
		{
			BCntCostInfoVO costinfo = bcntcostinfoservice.findBCntCostInfoByRelaNo(mastContno);
			if(costinfo!=null)
			{
				result.add(costinfo);
				return result;
			}
		}
		omap.put("productId", productId);
		omap.put("costPhase", costPhase);
		List<BPrdCostInfoDO> list = extnbprddao.queryProductCost(omap);
		if(list==null||list.size()<=0)
		{
			throw new ScubeBizException("该业务品种费用信息未绑定，请在产品配置中版定费用信息！");
		}
		else
		{
			BPrdCostInfoDO bindDO = list.get(0);
			// 费用收取种类,收取方式，扣取方式,计算方式 的处理
			String costClass = bindDO.getCostClass(); // 第1位-整体、第2位-单张
			String costType = bindDO.getCostType(); // 第1位-先收；第2位-后收；第3位-免收
			String chargeType = bindDO.getChargeType(); // 先收时使用第1位-外扣，第2位-内收
			String costCalcType = bindDO.getCostCalcType(); // 第1位-固定、第2位-按比率
			if (costClass.trim().length() == 2)
			{
				String o1 = costClass.substring(0, 1);
				String o2 = costClass.substring(1, 2);
				if (o1.equals("1")) {
					costClass = BCntBizConstant.COST_CLASS_WHOLE;
				} else if (o2.equals("1")) {
					costClass = BCntBizConstant.COST_CLASS_SINGLE;
				}
				bindDO.setCostClass(costClass);
			}
			if (costType.trim().length() == 3)
			{
				String o1 = costType.substring(0, 1);
				String o2 = costType.substring(1, 2);
				String o3 = costType.substring(2, 3);
				if (o1.equals("1")) {
					costType = BCntBizConstant.COST_TYPE_FIRST;
				} else if (o2.equals("1")) {
					costType = BCntBizConstant.COST_TYPE_LAST;
				} else if (o3.equals("1")) {
					costType = BCntBizConstant.COST_TYPE_FREE;
				}
				bindDO.setCostType(costType);
			}
			if (chargeType.trim().length() == 2)
			{
				String o1 = chargeType.substring(0, 1);
				String o2 = chargeType.substring(1, 2);
				if (o1.equals("1")) {
					chargeType = BCntBizConstant.CHARGE_TYPE_OUT;
				} else if (o2.equals("1")) {
					chargeType = BCntBizConstant.CHARGE_TYPE_IN;
				}
				bindDO.setChargeType(chargeType);
			}
			if (costCalcType.trim().length() == 2)
			{
				String o1 = costCalcType.substring(0, 1);
				String o2 = costCalcType.substring(1, 2);
				if (o1.equals("1")) {
					costCalcType = BCntBizConstant.COST_CALC_TYPE_FIX;
				} else if (o2.equals("1")) {
					costCalcType = BCntBizConstant.COST_CALC_TYPE_RATE;
				}
				bindDO.setCostCalcType(costCalcType);
			}
			result.add(bindDO);
		}
		return result;
	}
	
	/**
	 * 校验业务品种费用参数的费用收取阶段是否重复
	 * 重复则返回false,不重复返回true
	 * @param bPrdChkdirInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:15:34
	 */
	public boolean checkCostBind(BPrdCostBindVO bPrdCostBindVO)
	{
		boolean flag = false;
		BPrdCostBindExample example = new BPrdCostBindExample();
		BPrdCostBindExample.Criteria cri = example.createCriteria();
		cri.andProductIdEqualTo(bPrdCostBindVO.getProductId());
		cri.andCostPhaseEqualTo(bPrdCostBindVO.getCostPhase());
		List<BPrdCostBind> list = bprdcostbinddao.selectByExample(example);
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
	 * 删除调用阶段为空的绑定费用信息信息
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午5:25:56
	 */
	@Override
	public void deleteBPrdCostBindByExample(String productId)
	{
		BPrdCostBindExample example = new BPrdCostBindExample();
		BPrdCostBindExample.Criteria cri = example.createCriteria();
		cri.andProductIdEqualTo(productId);
		cri.andCostPhaseIsNull();
		bprdcostbinddao.deleteByExample(example);
	}
}
