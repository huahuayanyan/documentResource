package com.huateng.scf.rec.wrn.service.impl;

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
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.wrn.dao.IBWrnBaseInfoDAO;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.wrn.dao.IBWrnDebtPdoInfoDAO;
import com.huateng.scf.rec.wrn.dao.IBWrnRiskOfInfoDAO;
import com.huateng.scf.rec.wrn.dao.ext.ExtBWrnDAO;
import com.huateng.scf.rec.wrn.model.BWrnDebtPdoInfoDetail;
import com.huateng.scf.rec.wrn.model.BWrnRiskOfInfoDetail;
import com.huateng.scf.rec.wrn.service.IRWrnBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>rwrnbaseinfo接口实现类</p>
 *
 * @author 	liph
 * @date 	2016年12月27日下午3:11:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月27日下午3:11:42	     新增
 *
 * </pre>
 */
@ScubeService
@Service("RWrnBaseInfoServiceImpl")
public class RWrnBaseInfoServiceImpl implements IRWrnBaseInfoService{
private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BWrnBaseInfoDAO")
	IBWrnBaseInfoDAO ibWrnBaseInfoDAO;
	@Resource(name = "BWrnDebtPdoInfoDAO")
	IBWrnDebtPdoInfoDAO ibWrnDebtPdoInfoDAO;
	@Resource(name = "BWrnRiskOfInfoDAO")
	IBWrnRiskOfInfoDAO ibWrnRiskOfInfoDAO;
	@Resource(name = "userService")
	UserService userService;
	@Resource(name = "orgService")
	OrgService orgService;
	
	@Resource(name = "ExtBWrnDAO")
	ExtBWrnDAO extbwrndao;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	/**
	 * 应收账款催收提示,到期提示
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Page findWrnBaseInfoByCondition(int pageNo, int pageSize,BWrnDebtPdoInfoDetail bWrnDebtPdoInfoDetail,String flag) {
		String brcode = ContextHolder.getOrgInfo().getBrNo();
		Map map = new HashMap();
		map.put("billsNo", bWrnDebtPdoInfoDetail.getBillsNo());
		map.put("bussContcode", bWrnDebtPdoInfoDetail.getBussContcode());
		map.put("startYj", bWrnDebtPdoInfoDetail.getStartYj());
		map.put("endYj", bWrnDebtPdoInfoDetail.getEndYj());
		map.put("brcode", brcode);
		if(!StringUtil.isEmpty(flag)){
			if("1".equals(flag)){
				map.put("p1", "123004008");
				map.put("p2", "123005008");
				map.put("p3", "123006008");
			}else if("2".equals(flag)){
				map.put("p1", "123004009");
				map.put("p2", "123005009");
				map.put("p3", "123006009");
			}
		}else{
			return null;
		}
		Page page = new Page(pageSize, pageNo, 0);
		List<com.huateng.scf.rec.wrn.dao.model.BWrnDebtPdoInfoDetail> list = ibWrnDebtPdoInfoDAO.getAccountDebtPromptWarnInfo(map, page);
		List resultList = new ArrayList();
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				com.huateng.scf.rec.wrn.dao.model.BWrnDebtPdoInfoDetail baseInfo = list.get(i);
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
	 * 敞口无法覆盖预警
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Page findWrnRiskOfInfoByCondition(int pageNo, int pageSize, BWrnRiskOfInfoDetail bWrnRiskOfInfoDetail,
			String flag) {
		Map map = new HashMap();
		map.put("bussContno", bWrnRiskOfInfoDetail.getBussContno());//业务合同号
		map.put("sellerName", bWrnRiskOfInfoDetail.getSellerName());//卖方名称
		map.put("startYj", bWrnRiskOfInfoDetail.getStartYj());//预警日期从
		map.put("endYj", bWrnRiskOfInfoDetail.getEndYj());//预警日期到
		if("1".equals(flag)){
			map.put("p1", "123004011");
			map.put("p2", "123005011");
			map.put("p3", "123006011");
		}
		Page page = new Page(pageSize, pageNo, 0);
		List<com.huateng.scf.rec.wrn.dao.model.BWrnRiskOfInfoDetail> list = ibWrnRiskOfInfoDAO.getUnableCoverOpenAmtWarnInfo(map ,page);
		List resultList = new ArrayList();
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				com.huateng.scf.rec.wrn.dao.model.BWrnRiskOfInfoDetail baseInfo = list.get(i);		
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
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		List list = extbwrndao.getAccountDebtPromptWarnInfo(omap,page);
		List resultList = new ArrayList();
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				HashMap<String, Object> map = (HashMap<String, Object>) list.get(i);
				String custManager = map.get("custManager").toString();
				String brcode = map.get("brcode").toString();
				UserInfo userInfo = scubeUserService.selectUserByTlrNo(custManager, ContextHolder.getUserInfo().getBrManagerNo());
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(brcode, ScfCommonUtil.getBrManagerNo(scubeUserService)==null?brcode:ScfCommonUtil.getBrManagerNo(scubeUserService));
				String custManagerNm = userInfo.getTlrName();
				String brcodeNm = bctlVO.getBrName();
				map.put("custManagerNm", custManagerNm);
				map.put("brcodeNm", brcodeNm);
				resultList.add(map);
			}
		}
		page.setRecords(resultList);
		page.setTotalRecord(extbwrndao.countByHashMap(omap));
		return page;
	}
}
