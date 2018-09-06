package com.huateng.scf.nbas.prd.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.prd.dao.IBPrdBaseInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdBaseInfo;
import com.huateng.scf.nbas.prd.model.BPrdBaseInfoVO;
import com.huateng.scf.nbas.prd.service.INBPrdBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>产品出账方式绑定	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月16日下午5:01:54
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月16日下午5:01:54	     新增
 *
 * </pre>
 */
@ScubeService
@Service("NBPrdBaseInfoServiceImpl")
public class NBPrdBaseInfoServiceImpl implements INBPrdBaseInfoService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdBaseInfoDAO")
	IBPrdBaseInfoDAO bprdbaseinfodao;

	/**
	 * 查询产品出账方式
	 * @param bPrdBaseInfoVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月16日下午5:18:06
	 */
	@Override
	public BPrdBaseInfoVO findBPrdBaseInfoByKey(BPrdBaseInfoVO bPrdBaseInfoVO) throws ScubeBizException
	{
		log.debug("findBPrdBaseInfoByKey============================start");
		BPrdBaseInfoVO baseInfoVO = new BPrdBaseInfoVO();
		if (bPrdBaseInfoVO != null)
		{
			if (StringUtil.isEmpty(bPrdBaseInfoVO.getProductId()))
			{
				throw new ScubeBizException("产品编号丢失！");
			}
			BPrdBaseInfo prdBaseInfo = bprdbaseinfodao.selectByPrimaryKey(bPrdBaseInfoVO.getProductId());
			if (prdBaseInfo != null)
			{
				try
				{
					BeanUtils.copyProperties(prdBaseInfo, baseInfoVO);
				}
				catch (BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
			}
		}
		log.debug("findBPrdBaseInfoByKey============================end");
		return baseInfoVO;
	}
	
	/**
	 * 保存产品出账方式
	 * @param bPrdBaseInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月16日下午5:23:53
	 */
	@Override
	@Transactional
	public void saveBPrdBaseInfo(BPrdBaseInfoVO bPrdBaseInfoVO, String productId)
	{
		if(StringUtil.isEmpty(productId))
		{
			throw new ScubeBizException("产品编号丢失");
		}
		BPrdBaseInfo baseInfo = null;
		if(bPrdBaseInfoVO!=null)
		{
			baseInfo = bprdbaseinfodao.selectByPrimaryKey(productId);
			if(baseInfo!=null)
			{//有记录则修改信息
				BeanUtils.copyProperties(bPrdBaseInfoVO, baseInfo);
				baseInfo.setProductId(productId);
				bprdbaseinfodao.updateByPrimaryKeySelective(baseInfo);
			}
			else
			{//没有记录则新增
				baseInfo = new BPrdBaseInfo();
				BeanUtils.copyProperties(bPrdBaseInfoVO, baseInfo);
				baseInfo.setProductId(productId);
				bprdbaseinfodao.insertSelective(baseInfo);
			}
		}
	}
	
}
