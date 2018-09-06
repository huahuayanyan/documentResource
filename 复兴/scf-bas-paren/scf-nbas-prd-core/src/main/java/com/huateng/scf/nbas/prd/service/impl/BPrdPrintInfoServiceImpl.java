package com.huateng.scf.nbas.prd.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.nbas.prd.dao.IBPrdPrintInfoDAO;
import com.huateng.scf.nbas.prd.dao.model.BPrdPrintInfo;
import com.huateng.scf.nbas.prd.dao.model.BPrdPrintInfoExample;
import com.huateng.scf.nbas.prd.model.BPrdPrintInfoVO;
import com.huateng.scf.nbas.prd.service.IBPrdPrintInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>业务品种绑定打印模板	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月17日下午2:51:52
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月17日下午2:51:52	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BPrdPrintInfoServiceImpl")
public class BPrdPrintInfoServiceImpl implements IBPrdPrintInfoService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBPrdPrintInfoDAO")
	IBPrdPrintInfoDAO bprdprintinfodao;
	
	/**
	 * 分页查询业务品种绑定打印模板
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdPrintInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午3:03:28
	 */
	@Override
	public Page findBPrdPrintInfoByPage(int pageNo,int pageSize,BPrdPrintInfoVO bPrdPrintInfoVO)
	{
		log.debug("findBPrdPringInfoByPage================================start");
		BPrdPrintInfoExample example = new BPrdPrintInfoExample();
		BPrdPrintInfoExample.Criteria cri = example.createCriteria();
		if(bPrdPrintInfoVO!=null)
		{
			if(!StringUtil.isEmpty(bPrdPrintInfoVO.getProductId()))
			{
				cri.andProductIdEqualTo(bPrdPrintInfoVO.getProductId());
			}
		}
		else 
		{
			return new Page(pageSize, pageNo, 0);
		}
		int total = bprdprintinfodao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		List<BPrdPrintInfo> list = bprdprintinfodao.selectByPage(example, page);
		List<BPrdPrintInfoVO> result = new ArrayList<BPrdPrintInfoVO>();
		if(list!=null&&list.size()>0)
		{
			BPrdPrintInfoVO infoVO = null;
			for(BPrdPrintInfo info:list)
			{
				infoVO = new BPrdPrintInfoVO();
				BeanUtils.copyProperties(info, infoVO);
				infoVO.setInpDt(ScfDateUtil.formatDate(infoVO.getUploadTime(), ScfDateUtil.DATE_FORMAT_FULL));
				result.add(infoVO);
			}
		}
		page.setRecords(result);
		log.debug("findBPrdPringInfoByPage================================start");
		return page;
	}
	
	/**
	 * 新增
	 * @param bPrdPrintInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午3:40:20
	 */
	@Override
	public void addBPrdPrintInfo(BPrdPrintInfoVO bPrdPrintInfoVO)
	{
		if (bPrdPrintInfoVO != null)
		{
			String tlrno = ContextHolder.getUserInfo().getTlrNo();
			bPrdPrintInfoVO.setUploadTlrno(tlrno);
			Timestamp ts=new Timestamp(System.currentTimeMillis());
			bPrdPrintInfoVO.setUploadTime(ts);// 最后更新时间
			bPrdPrintInfoVO.setId(UUIDGeneratorUtil.generate());
			BPrdPrintInfo bPrdPrintInfo = new BPrdPrintInfo();
			try
			{
				BeanUtils.copyProperties(bPrdPrintInfoVO, bPrdPrintInfo);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("转换异常");
			}
			try
			{
				bprdprintinfodao.insertSelective(bPrdPrintInfo);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("保存异常");
			}
		}
	}
	
	/**
	 * 校验同一业务品种同一调用阶段模板信息是否存在
	 * @param productId
	 * @param invokPhase
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午3:50:39
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List CheckBPrdPrintInfo(String productId,String invokPhase)
	{
		BPrdPrintInfoExample example = new BPrdPrintInfoExample();
		BPrdPrintInfoExample.Criteria cri = example.createCriteria();
		cri.andProductIdEqualTo(productId);
		cri.andInvokPhaseEqualTo(invokPhase);
		List<BPrdPrintInfo> list = bprdprintinfodao.selectByExampleWithoutBLOBs(example);
		return list;
	}
	
	/**
	 * 根据ID查询文件模版信息
	 * @param id
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午3:53:12
	 */
	@Override
	public BPrdPrintInfoVO findBPrdPrintInfoById(String id)
	{
		BPrdPrintInfo info = bprdprintinfodao.selectByPrimaryKey(id);
		if(info==null)
		{
			throw new ScubeBizException("该合同模版不存在！");
		}
		BPrdPrintInfoVO infoVO = new BPrdPrintInfoVO();
		try
		{
			BeanUtils.copyProperties(info, infoVO);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		return infoVO;
	}
	
	/**
	 * 删除
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午3:27:42
	 */
	@Override
	public void deleteBPrdPrintInfo(List<BPrdPrintInfoVO> list)
	{
		if(list!=null&&list.size()>0)
		{
			for(BPrdPrintInfoVO infoVO:list)
			{
				bprdprintinfodao.deleteByPrimaryKey(infoVO.getId());
			}
		}
	}
}
