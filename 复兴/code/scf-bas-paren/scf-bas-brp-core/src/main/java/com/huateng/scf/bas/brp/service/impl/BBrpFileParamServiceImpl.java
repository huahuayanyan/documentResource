package com.huateng.scf.bas.brp.service.impl;

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
import com.huateng.scf.bas.brp.dao.IBBrpFileParamDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpFileParam;
import com.huateng.scf.bas.brp.dao.model.BBrpFileParamExample;
import com.huateng.scf.bas.brp.model.BBrpFileParamVO;
import com.huateng.scf.bas.brp.service.IBBrpFileParamService;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>合同模板信息	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月15日下午5:05:39
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月15日下午5:05:39	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BBrpFileParamServiceImpl")
public class BBrpFileParamServiceImpl implements IBBrpFileParamService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBBrpFileParamDAO")
	IBBrpFileParamDAO bbrpfileparamdao;
	
	/**
	 * 分页查询合同模版列表
	 * @param pageNo
	 * @param pageSize
	 * @param bBrpFileParamVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月17日上午11:49:31
	 */
	@Override
	public Page findBBrpFileParamByPage(int pageNo,int pageSize,BBrpFileParamVO bBrpFileParamVO)
	{
		log.debug("findBBrpFileParamByPage================================start");
		BBrpFileParamExample example = new BBrpFileParamExample();
		BBrpFileParamExample.Criteria cri = example.createCriteria();
		if(bBrpFileParamVO!=null)
		{
			if(!StringUtil.isEmpty(bBrpFileParamVO.getContName()))
			{
				cri.andContNameLike(bBrpFileParamVO.getContName());
			}
			if(!StringUtil.isEmpty(bBrpFileParamVO.getContCode()))
			{
				cri.andContCodeLike(bBrpFileParamVO.getContCode());
			}
		}
		example.setOrderByClause("LAST_UPD_TIME desc");
		int total = bbrpfileparamdao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		List<BBrpFileParam> list = bbrpfileparamdao.selectByPage(example, page);
		List<BBrpFileParamVO> result = new ArrayList<BBrpFileParamVO>();
		if(list!=null&&list.size()>0)
		{
			for(BBrpFileParam bBrpFileParam:list)
			{
				BBrpFileParamVO fileParamVO = new BBrpFileParamVO();
				BeanUtils.copyProperties(bBrpFileParam, fileParamVO);
				String inpDt = ScfDateUtil.formatDate(fileParamVO.getCrtTime(), ScfDateUtil.DATE_FORMAT_FULL);
				fileParamVO.setInpDt(inpDt);
				result.add(fileParamVO);
			}
		}
		page.setRecords(result);
		log.debug("findBBrpFileParamByPage================================start");
		return page;
	}
	
	/**
	 * 新增
	 * @param bBrpFileParamVO
	 * @author 	mengjiajia
	 * @date 	2017年6月17日上午11:49:24
	 */
	@Override
	@Transactional
	public void addBBrpFileParam(BBrpFileParamVO bBrpFileParamVO)
	{
		BBrpFileParam bBrpFileParam = bbrpfileparamdao.selectByPrimaryKey(bBrpFileParamVO.getContCode());
		if(bBrpFileParam!=null)
		{
			throw new ScubeBizException("类型编号为："+bBrpFileParamVO.getContCode()+"的文件类型已存在，请重新输入");
		}
		bBrpFileParam = new BBrpFileParam();
		try
		{
			BeanUtils.copyProperties(bBrpFileParamVO, bBrpFileParam);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		bBrpFileParam.setId(bBrpFileParam.getContCode());
		String tlrno = ContextHolder.getUserInfo().getTlrNo();
		String brno = ContextHolder.getOrgInfo().getBrNo();
		bBrpFileParam.setTlrcd(tlrno);
		bBrpFileParam.setBrcode(brno);
		bBrpFileParam.setCrtTime(new Date());
		bBrpFileParam.setLastUpdBrcode(brno);
		bBrpFileParam.setLastUpdTlrcd(tlrno);
		bBrpFileParam.setLastUpdTime(new Date());
		try
		{
			bbrpfileparamdao.insertSelective(bBrpFileParam);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
	}
	
	/**
	 * 修改
	 * @param bBrpFileParamVO
	 * @author 	mengjiajia
	 * @date 	2017年6月17日上午11:49:18
	 */
	@Override
	@Transactional
	public void updateBBrpFileParam(BBrpFileParamVO bBrpFileParamVO)
	{
		BBrpFileParam bBrpFileParam = new BBrpFileParam();
		try
		{
			BeanUtils.copyProperties(bBrpFileParamVO, bBrpFileParam);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		String tlrno = ContextHolder.getUserInfo().getTlrNo();
		String brno = ContextHolder.getOrgInfo().getBrNo();
		bBrpFileParam.setLastUpdBrcode(brno);
		bBrpFileParam.setLastUpdTlrcd(tlrno);
		bBrpFileParam.setLastUpdTime(new Date());
		try
		{
			bbrpfileparamdao.updateByPrimaryKeySelective(bBrpFileParam);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
	}
}
