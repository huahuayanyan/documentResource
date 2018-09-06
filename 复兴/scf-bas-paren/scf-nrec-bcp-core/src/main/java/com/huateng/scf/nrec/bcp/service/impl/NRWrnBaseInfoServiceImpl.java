package com.huateng.scf.nrec.bcp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.AccountDebtQryVO;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.nrec.bcp.dao.INBWrnBaseInfoDAO;
import com.huateng.scf.nrec.bcp.dao.domodel.NBWrnDebtPdoInfoDetailDO;
import com.huateng.scf.nrec.bcp.service.INRWrnBaseInfoService;
import com.huateng.scf.nrec.bcp.vo.NBWrnDebtPdoInfoDetail;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.wrn.dao.IBWrnDebtPdoInfoDAO;
import com.huateng.scf.rec.wrn.dao.IBWrnRiskOfInfoDAO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service(INRWrnBaseInfoService.BEAN_ID)
public class NRWrnBaseInfoServiceImpl implements INRWrnBaseInfoService {
private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = INBWrnBaseInfoDAO.BEAN_ID)
	INBWrnBaseInfoDAO nBWrnBaseInfoDAO;
	
	@Resource(name = "BWrnDebtPdoInfoDAO")
	IBWrnDebtPdoInfoDAO ibWrnDebtPdoInfoDAO;
	
	@Resource(name = "BWrnRiskOfInfoDAO")
	IBWrnRiskOfInfoDAO ibWrnRiskOfInfoDAO;
	
	@Resource(name = "userService")
	UserService userService;
	
	@Resource(name = "orgService")
	OrgService orgService;
	
//	@Resource(name = "ExtBWrnDAO")
//	ExtBWrnDAO extbwrndao;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	public static final String FLAG_DEADLINE="1";
	
	public static final String FLAG_PROMPT = "2";
	
	/**
	 * 应收账款催收提示,到期提示
	 */
	@Override
	public Page findWrnBaseInfoByCondition(int pageNo, int pageSize,NBWrnDebtPdoInfoDetail bWrnDebtPdoInfoDetail,String flag) {
		String brcode = ContextHolder.getOrgInfo().getBrNo();
		Map<String, Object> omap = new HashMap<String, Object>();
		omap.put("billsNo", bWrnDebtPdoInfoDetail.getBillsNo());
		omap.put("bussContcode", bWrnDebtPdoInfoDetail.getBussContcode());
		omap.put("startYj", bWrnDebtPdoInfoDetail.getStartYj());
		omap.put("endYj", bWrnDebtPdoInfoDetail.getEndYj());
		omap.put("brcode", brcode);
		List<String> paramIds = new ArrayList<String>();
		if(!StringUtil.isEmpty(flag)){
			//
				if(FLAG_DEADLINE.equals(flag)){					
					//单笔
					paramIds.add("123001008");
					paramIds.add("123002008");
					paramIds.add("123003008");
					
					//池融资				
					paramIds.add("123004008");
					paramIds.add("123005008");
					paramIds.add("123006008");
					
					
				}else if(FLAG_PROMPT.equals(flag)){
					//单笔
					paramIds.add("123001009");
					paramIds.add("123002008");
					paramIds.add("123003008");
					
					//池融资				
					paramIds.add("123004009");
					paramIds.add("123005009");
					paramIds.add("123006009");
				}
				
				omap.put("paramIds", paramIds);
		}
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		omap.putAll(map);	
		
		Page page = new Page(pageSize, pageNo, 0);
		List<NBWrnDebtPdoInfoDetailDO> list = nBWrnBaseInfoDAO.getAccountDebtPromptWarnInfo(omap, page);
		List<NBWrnDebtPdoInfoDetailDO> resultList = new ArrayList<NBWrnDebtPdoInfoDetailDO>();
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				NBWrnDebtPdoInfoDetailDO baseInfo = list.get(i);
				if(baseInfo!=null){
					UserInfo userInfo = new UserInfo();
					userInfo.setTlrNo(baseInfo.getCustManager());// 搜索创建人对应的名称。
					List<TlrInfoVO> userList = userService.selectByExample(userInfo);
					if (userList != null && userList.size()>0) {
						baseInfo.setKhjl(userList.get(0).getTlrName());//客户经理
					} else {
						baseInfo.setKhjl(null);
					}
					BctlVO bctlVO = new BctlVO();
					bctlVO.setBrNo(baseInfo.getBrcode());
					List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
					if (bctlVOList != null && bctlVOList.size()>0) {
						baseInfo.setJbjg(bctlVOList.get(0).getBrName()+"-"+baseInfo.getBrcode());//经办机构		
					} else {
						baseInfo.setJbjg(null);
					}
				}
				resultList.add(baseInfo);
			}
		}
		page.setRecords(resultList);
		return page;
	}	
	
	
	/**
	 * 
	 * @Description: 应收账款到期提醒
	 * @author mengjiajia
	 * @Created 2013-9-2下午3:57:07
	 * @param accountDebtQryVO
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page AccountDebtPromptWarn(int pageNo, int pageSize,AccountDebtQryVO accountDebtQryVO) throws ScubeBizException{
		log.debug("应收账款到期提醒============");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(accountDebtQryVO!=null)
		{
			if(!StringUtil.isEmpty(accountDebtQryVO.getWarnNo())&&accountDebtQryVO.getWarnNo().length()>0)
			{
				omap.put("paramId", accountDebtQryVO.getWarnNo());
			}
			if(!StringUtil.isEmpty(accountDebtQryVO.getBillsNo())&&accountDebtQryVO.getBillsNo().length()>0)
			{
				omap.put("billsNo", accountDebtQryVO.getBillsNo());
			}
			if(!StringUtil.isEmpty(accountDebtQryVO.getBussContcode())&&accountDebtQryVO.getBussContcode().length()>0)
			{
				omap.put("bussContcode", accountDebtQryVO.getBussContcode());
			}
			if(!StringUtil.isEmpty(accountDebtQryVO.getStartDate())&&accountDebtQryVO.getStartDate().length()>0)
			{
				omap.put("startDate", accountDebtQryVO.getStartDate());
			}
			if(!StringUtil.isEmpty(accountDebtQryVO.getEndDate())&&accountDebtQryVO.getEndDate().length()>0)
			{
				omap.put("endDate", accountDebtQryVO.getEndDate());
			}
			if(!StringUtil.isEmpty(accountDebtQryVO.getBrcode())&&accountDebtQryVO.getBrcode().length()>0)
			{
				omap.put("brcode", accountDebtQryVO.getBrcode());
				String brcode = ContextHolder.getOrgInfo().getBrNo();
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(brcode,ScfCommonUtil.getBrManagerNo(scubeUserService));
				if (bctlVO == null) {
					throw new ScubeBizException("机构不存在！", RBcpErrorConstant.RECORD_NOT_EXIST);
				}
				String brattr = bctlVO.getBrAttr();
				if(ScfBasConstant.FLAG_ON.equals(brattr))
				{
					omap.put("state", "1");
				}
				else
				{
					omap.put("affiliationType", ScfBasConstant.BCTL_AFFILIATION_BELONG);
				}
			}
		}
		
		List<String> paramIds = new ArrayList<String>();
		{
			paramIds.add("123001010");
			paramIds.add("123002010");
			paramIds.add("123003010");
			paramIds.add("123004010");
			paramIds.add("123005010");
			paramIds.add("123006010");
			
		}
		
		omap.put("paramIds", paramIds);
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		omap.putAll(map);
		
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		List list = nBWrnBaseInfoDAO.getAccountDebtPromptWarnInfo(omap,page);
		List resultList = new ArrayList();
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				HashMap<String, Object> hasmap = (HashMap<String, Object>) list.get(i);
				String custManager = hasmap.get("custManager").toString();
				String brcode = hasmap.get("brcode").toString();
				UserInfo userInfo = scubeUserService.selectUserByTlrNo(custManager, ContextHolder.getUserInfo().getBrManagerNo());
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(brcode, ScfCommonUtil.getBrManagerNo(scubeUserService)==null?brcode:ScfCommonUtil.getBrManagerNo(scubeUserService));
				String custManagerNm = userInfo.getTlrName();
				String brcodeNm = bctlVO.getBrName();
				hasmap.put("custManagerNm", custManagerNm);
				hasmap.put("brcodeNm", brcodeNm);
				resultList.add(map);
			}
		}
		page.setRecords(resultList);
		return page;
	}

}
