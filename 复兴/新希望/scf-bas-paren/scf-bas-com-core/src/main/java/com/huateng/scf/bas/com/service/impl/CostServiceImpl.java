package com.huateng.scf.bas.com.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.service.IBCntCostInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.dao.ext.ExtCostOutDAO;
import com.huateng.scf.bas.common.model.CostQryVO;
import com.huateng.scf.bas.common.service.ICostService;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.rec.bcp.dao.IRBcpCostOutDAO;
import com.huateng.scf.rec.bcp.model.RBcpCostOut;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

import oracle.sql.TIMESTAMP;

@ScubeService
@Service("CostServiceImpl")
public class CostServiceImpl implements ICostService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ExtCostOutDAO")
	ExtCostOutDAO extcostoutdao;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name = "BCntCostInfoServiceImpl")
	IBCntCostInfoService bcntcostinfoservice;
	
	@Resource(name = "IRBcpCostOutDAO")
	IRBcpCostOutDAO rbcpcostoutdao;
	
	/**
	 * 费用查询
	 * @Description: 在这里添加方法的注释
	 * @author zhangwu
	 * @Created 2013-5-16下午03:59:33
	 * @param costQryVO
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page queryTblCostOut(CostQryVO costQryVO) throws ScubeBizException 
	{
		log.debug("分页查询开始=================");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		
		if (!StringUtil.isEmpty(costQryVO.getCname())) {
			omap.put("cname",costQryVO.getCname());
		}
		
		if (null!=costQryVO.getCommonDate_from_Q()) { // 扣收日期
			omap.put("commonDate1",costQryVO.getCommonDate_from_Q());
		}
		
		if (null!=costQryVO.getCommonDate_to_Q()) { // 扣收日期
			omap.put("commonDate2",costQryVO.getCommonDate_to_Q());
		}
		
		if(!StringUtil.isEmpty(costQryVO.getBussContno())){
			omap.put("bussContno",costQryVO.getBussContno());
		}
		
		if(!StringUtil.isEmpty(costQryVO.getChargeClass_Q())){
			omap.put("chargeClass",costQryVO.getChargeClass_Q());
		}
		
		if(!StringUtil.isEmpty(costQryVO.getBrcode())){
			omap.put("parentBrcode",ContextHolder.getOrgInfo().getBrNo());
			omap.put("affiliationType",ScfBasConstant.BCTL_AFFILIATION_BELONG);
		}

		Page page = new Page(costQryVO.getPageSize(), costQryVO.getPageIndex(), 0);
		List list = extcostoutdao.queryTblCostOut(omap, page);
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				HashMap<String, Object> map = (HashMap<String, Object>) list.get(i);
				if(null!=map.get("commonDate"))
				{
					TIMESTAMP time = (TIMESTAMP) map.get("commonDate");
					try {
						String commonDate = time.timestampValue().toString();
						if(commonDate.indexOf(".")>-1)
						{
							commonDate = commonDate.substring(0, commonDate.lastIndexOf("."));
						}
						map.put("commonDate", commonDate);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				String tlrcd = map.get("tlrcd").toString();
				String brcode = map.get("brcode").toString();
				UserInfo userInfo = scubeUserService.selectUserByTlrNo(tlrcd,ScfCommonUtil.getBrManagerNo(scubeUserService));
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(brcode,ScfCommonUtil.getBrManagerNo(scubeUserService));
				map.put("tlrnm",userInfo.getTlrName());
				map.put("brname",bctlVO.getBrName());
			}
		}
		page.setRecords(list);
		page.setTotalRecord(extcostoutdao.countQueryTblCostOut(omap));
		return page;
	}

	/**
	 * @Description: 保存费用使用流水信息
	 * @author mengjiajia
	 * @Created 2013-8-1下午7:46:16
	 * @param tblCostOut
	 * @throws CommonException
	 */
	@Override
	public void saveTblCostOut(RBcpCostOut tblCostOut) throws ScubeBizException {
		com.huateng.scf.bas.cnt.model.BCntCostInfo costInfo = bcntcostinfoservice.getTblCostInfoByBusniessNoAndCostCode(tblCostOut.getBussContno(), tblCostOut.getCostCode());
		tblCostOut.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
		tblCostOut.setBrcode(ContextHolder.getOrgInfo().getBrNo());
		tblCostOut.setCostInfoId(costInfo.getId());
		tblCostOut.setCostRate(costInfo.getCostRate());
		tblCostOut.setChargeType(costInfo.getChargeType());
//		tblCostOut.setCostPhase(costInfo.getCostPhase());//费用阶段
		if(StringUtil.isEmpty(tblCostOut.getId())){
			tblCostOut.setId(UUIDGeneratorUtil.generate());
		}
		com.huateng.scf.rec.bcp.dao.model.RBcpCostOut costOut = new com.huateng.scf.rec.bcp.dao.model.RBcpCostOut();
		BeanUtils.copyProperties(tblCostOut, costOut);
		rbcpcostoutdao.insertSelective(costOut);
	}

}
