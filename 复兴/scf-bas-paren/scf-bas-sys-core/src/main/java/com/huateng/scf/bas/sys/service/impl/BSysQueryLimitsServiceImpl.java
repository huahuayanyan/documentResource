package com.huateng.scf.bas.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.RoleInfoVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.RoleService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.sys.dao.IBSysQueryLimitsDAO;
import com.huateng.scf.bas.sys.dao.model.BSysQueryLimits;
import com.huateng.scf.bas.sys.dao.model.BSysQueryLimitsExample;
import com.huateng.scf.bas.sys.model.BSysQueryLimitsVO;
import com.huateng.scf.bas.sys.service.IBSysQueryLimitsService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>数据查询权限分配</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月10日上午10:30:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月10日上午10:30:31	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BSysQueryLimitsServiceImpl")
public class BSysQueryLimitsServiceImpl implements IBSysQueryLimitsService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBSysQueryLimitsDAO")
	IBSysQueryLimitsDAO bsysquerylimitsdao;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	
	/**
	 * 查询角色列表
	 * @param pageNo
	 * @param pageSize
	 * @param roleInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月10日上午11:50:19
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page findRoleInfoAndLimitsByPage(int pageNo, int pageSize, RoleInfoVO roleInfoVO)
	{
		log.debug("findRoleInfoAndLimitsByPage==================================start");
		Page page = roleService.select(pageNo, pageSize, roleInfoVO);
		List<Map<String, Object>> list = page.getRecords();
		if(list!=null&&list.size()>0)
		{
			for(Map<String, Object> info:list)
			{
				BSysQueryLimits limits = bsysquerylimitsdao.selectByPrimaryKey(info.get("id").toString());
				if(limits!=null)
				{
					info.put("roleModel",limits.getRoleModel());
				}
				else
				{
					info.put("roleModel","未设置");
				}
			}
		}
		log.debug("findRoleInfoAndLimitsByPage==================================end");
		return page;
	}
	
	/**
	 * 保存角色查询权限
	 * @param bSysQueryLimitsVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月10日上午11:51:58
	 */
	@Override
	public void saveQueryLimits(BSysQueryLimitsVO bSysQueryLimitsVO) throws ScubeBizException
	{
		BSysQueryLimits limits = bsysquerylimitsdao.selectByPrimaryKey(bSysQueryLimitsVO.getId());
		if(limits!=null)
		{
			limits.setRoleModel(bSysQueryLimitsVO.getRoleModel());
			try
			{
				bsysquerylimitsdao.updateByPrimaryKeySelective(limits);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("保存异常");
			}
		}
		else
		{
			limits = new BSysQueryLimits();
			try
			{
				BeanUtils.copyProperties(bSysQueryLimitsVO, limits);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("转换异常");
			}
			limits.setInpDt(ScfDateUtil.getStringDate(new Date()));
			limits.setRoleId(bSysQueryLimitsVO.getId());
			try
			{
				bsysquerylimitsdao.insertSelective(limits);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("保存异常");
			}
		}
	}
	
	/**
	 * 根据数据查询权限获取不同权限信息
	 * @param tlrNo
	 * @param brNo
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月10日下午3:04:55
	 */
	@Override
	public HashMap<String, List<String>> getTlrNoListByRoleModel()
	{
		String tlrno = ContextHolder.getUserInfo().getTlrNo();
		String brno = ContextHolder.getOrgInfo().getBrNo();
		String roleModel = "";//查询数据权限
		List<String> roleList = ContextHolder.getUserInfo().getRoleList();
		BSysQueryLimitsExample example = new BSysQueryLimitsExample();
		BSysQueryLimitsExample.Criteria cri = example.createCriteria();
		if(roleList!=null&&roleList.size()>0)
		{
			cri.andRoleNoIn(roleList);
		}
		List<BSysQueryLimits> list = bsysquerylimitsdao.selectByExample(example);
		if(list!=null&&list.size()>0)
		{
			List<String> mdleList = new ArrayList<String>();
			for(BSysQueryLimits limits:list)
			{
				mdleList.add(limits.getRoleModel());
			}
			if(mdleList.contains(ScfBasConstant.CUST_QUERY_TYPE_BY_BCTL))
			{// 按本机构及下属机构
				roleModel = ScfBasConstant.CUST_QUERY_TYPE_BY_BCTL;
				mdleList.removeAll(mdleList);
			}
			if(mdleList.contains(ScfBasConstant.CUST_QUERY_TYPE_BY_MAA))
			{// 按本机构
				roleModel = ScfBasConstant.CUST_QUERY_TYPE_BY_MAA;
				mdleList.removeAll(mdleList);
			}
			if(mdleList.contains(ScfBasConstant.CUST_QUERY_TYPE_BY_NONE))
			{// 按角色
				roleModel = ScfBasConstant.CUST_QUERY_TYPE_BY_NONE;
				mdleList.removeAll(mdleList);
			}
			if(mdleList.contains(ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER))
			{// 按本用户
				roleModel = ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER;
				mdleList.removeAll(mdleList);
			}
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> result = new ArrayList<String>();
		if(ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER.equals(roleModel))
		{// 按本用户
			result.add(tlrno);
			map.put("tlrNoList", result);
		}
		if(ScfBasConstant.CUST_QUERY_TYPE_BY_MAA.equals(roleModel))
		{// 按本机构
			result.add(brno);
			if(result.size()>0)
			{
				map.put("brNoList", result);
			}
		}
		if(ScfBasConstant.CUST_QUERY_TYPE_BY_BCTL.equals(roleModel))
		{// 按本机构及下属机构
			//根据机构编号，总行编号查询机构和子机构
			List<BctlVO> bctllist = scubeUserService.getBrListByBrNo(brno, ScfCommonUtil.getBrManagerNo(scubeUserService));
			if(bctllist!=null&&bctllist.size()>0)
			{
				for(BctlVO bctlVO:bctllist)
				{
					result.add(bctlVO.getBrNo());
				}
			}
			if(result.size()>0)
			{
				map.put("brNoList", result);
			}
		}
		if(ScfBasConstant.CUST_QUERY_TYPE_BY_NONE.equals(roleModel))
		{// 按角色
			List<TlrInfoVO> tlrlist = new ArrayList<TlrInfoVO>();
			//查询当前角色下所有用户编号
			if(roleList.size()>0&&roleList!=null)
			{
				for(String roleNo : roleList)
				{
					RoleInfoVO roleInfoVO = new RoleInfoVO();
					roleInfoVO.setRoleNo(roleNo);
					roleInfoVO.setBrManagerNo(ScfCommonUtil.getBrManagerNo(scubeUserService));
					//根据角色编号获取用户信息
					tlrlist.addAll(scubeUserService.selectTLRInfoByRoleNoAndBrNo(roleInfoVO, 1, Integer.MAX_VALUE));
				}
			}
			if(tlrlist!=null&&tlrlist.size()>0)
			{
				for(TlrInfoVO tlrInfoVO:tlrlist)
				{
					result.add(tlrInfoVO.getTlrNo());
				}
			}
			if(result.size()>0)
			{
				map.put("tlrNoList", result);
			}
		}
		return map;
	}
}
