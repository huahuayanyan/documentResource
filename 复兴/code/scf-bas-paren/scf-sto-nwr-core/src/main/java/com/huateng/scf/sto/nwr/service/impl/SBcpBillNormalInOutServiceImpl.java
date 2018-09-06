package com.huateng.scf.sto.nwr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.sto.nwr.dao.ISBcpBillNormalInOutDAO;
import com.huateng.scf.sto.nwr.dao.ext.ExtSBcpNwrDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpBillNormalInOut;
import com.huateng.scf.sto.nwr.dao.vo.SBcpBillNormalInOutDO;
import com.huateng.scf.sto.nwr.model.SBcpBillNormalInOutVO;
import com.huateng.scf.sto.nwr.model.SBcpMortBillNormalVO;
import com.huateng.scf.sto.nwr.service.ISBcpBillNormalInOutService;
import com.huateng.scf.sto.nwr.vo.BillNormalInOutQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>仓单信息流水表	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月19日上午11:18:49
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月19日上午11:18:49	     新增
 *
 * </pre>
 */
@ScubeService
@Service("SBcpBillNormalInOutServiceImpl")
public class SBcpBillNormalInOutServiceImpl implements ISBcpBillNormalInOutService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ISBcpBillNormalInOutDAO")
	ISBcpBillNormalInOutDAO sbcpbillnormalinoutdao;

	@Resource(name = "ExtSBcpNwrDAO")
	ExtSBcpNwrDAO extsbcpnwrdao;

	@Autowired
	ScubeUserService scubeUserService;
	
	@Override
	public void add(SBcpBillNormalInOutVO bcpBillNormalInOutVO)
	{
		SBcpBillNormalInOut bcpBillNormalInOut = new SBcpBillNormalInOut();
		BeanUtils.copyProperties(bcpBillNormalInOutVO, bcpBillNormalInOut);
		if(StringUtil.isEmpty(bcpBillNormalInOut.getId()))
		{
			bcpBillNormalInOut.setId(UUIDGeneratorUtil.generate());
		}
		sbcpbillnormalinoutdao.insertSelective(bcpBillNormalInOut);
	}
	
	/**
	 * DESCRIPTION:保存普通仓单流水表信息
	 * @param tblAppliMortgageBillNormal
	 * @param appno
	 * @param pid
	 * @param status
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月19日上午11:22:37
	 */
	@Override
	public void addTblBillNormalInOutInfo(SBcpMortBillNormalVO billNormalVO,String appno,String pid,
			String status) throws ScubeBizException
	{
		log.debug("appno="+appno);
		SBcpBillNormalInOutVO tblBillNormalInOut = new SBcpBillNormalInOutVO();//普通仓单流水表
		BeanUtils.copyProperties(billNormalVO, tblBillNormalInOut);
		tblBillNormalInOut.setPid(pid);
		tblBillNormalInOut.setAppno(appno);
		tblBillNormalInOut.setStatus(status);
		tblBillNormalInOut.setId(null);
		tblBillNormalInOut.setBillno(billNormalVO.getBillno());
		tblBillNormalInOut.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
		this.add(tblBillNormalInOut);

	}
	
	/**
	 * 获取普通非标准仓单信息
	 * @param billNormalInOutQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月11日上午10:29:35
	 */
	@Override
	public Page getNormalBillByPara(BillNormalInOutQryVO billNormalInOutQryVO) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		
		//ID
		if(!StringUtil.isEmpty(billNormalInOutQryVO.getId()))
		{
			omap.put("id", billNormalInOutQryVO.getId());
		}
		//客户名称
		if (!StringUtil.isEmpty(billNormalInOutQryVO.getCustcd()))
		{
			omap.put("custcd", billNormalInOutQryVO.getCustcd());
		}
		//从合同号
		if (!StringUtil.isEmpty(billNormalInOutQryVO.getSlaveContno()))
		{
			omap.put("slaveContno", billNormalInOutQryVO.getSlaveContno());
		}
		//仓单状态
		if(!StringUtil.isEmpty(billNormalInOutQryVO.getStatus()))
		{
			omap.put("status", billNormalInOutQryVO.getStatus());
		}
		//有效期起
		if(!StringUtil.isEmpty(billNormalInOutQryVO.getStartDate()))
		{
			omap.put("startDate", billNormalInOutQryVO.getStartDate());
		}
		//有效期止
		if(!StringUtil.isEmpty(billNormalInOutQryVO.getEndDate()))
		{
			omap.put("endDate", billNormalInOutQryVO.getEndDate());
		}
		
		int total = extsbcpnwrdao.countNormalBillByPara(omap);
		Page page = new Page(billNormalInOutQryVO.getPageSize(), billNormalInOutQryVO.getPageIndex(), total);
		List<SBcpBillNormalInOutDO> result = extsbcpnwrdao.getNormalBillByPara(omap, page);
		List<SBcpBillNormalInOutDO> list = new ArrayList<SBcpBillNormalInOutDO>();
		if(result!=null&&result.size()>0)
		{
			for(SBcpBillNormalInOutDO inOutDO:result)
			{
				String tlrcd = inOutDO.getTlrcd();
				UserInfo userinfo = scubeUserService.selectUserByTlrNo(tlrcd, ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(userinfo!=null)
				{
					inOutDO.setTlrname(userinfo.getTlrName());
				}
				list.add(inOutDO);
			}
		}
		page.setRecords(list);
		return page;
	}
}
