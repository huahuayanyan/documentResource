package com.huateng.scf.adv.nte.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.nte.dao.IBFourWareAcctConfirmNoticeDAO;
import com.huateng.scf.adv.nte.model.FourConfirmQryVO;
import com.huateng.scf.adv.nte.model.FourWareConfirmNoticeVO;
import com.huateng.scf.adv.nte.service.IBFourWareAcctConfirmNoticeService;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 收款确认通知书
 * 
 * @author htrad0055
 *
 */
@ScubeService
@Service(IBFourWareAcctConfirmNoticeService.BeanId)
public class BFourWareAcctConfirmNoticeServiceImpl implements IBFourWareAcctConfirmNoticeService {

	@Resource(name = IBFourWareAcctConfirmNoticeDAO.BeanId)
	private IBFourWareAcctConfirmNoticeDAO bFourWareAcctConfirmNoticeDAO;
	
	@Autowired
	private ScubeUserService scubeUserService;
	
	private static int START_PAGE_NO=1;
	private static int MAX_PAGE_SIZE=200;

	@Override
	public Page queryAcctConfirmNoticeByPage(int pageNo, int pageSize, FourConfirmQryVO fourConfirmQryVO) {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> param = new HashMap<String, Object>();
		String brcode = ContextHolder.getOrgInfo().getBrNo();
//		param.put("brcode", brcode);//暂不考虑机构权限
		String brattr=ContextHolder.getOrgInfo().getBrAttr();
		param.put("brattr", brattr);
		String brcode2 = fourConfirmQryVO.getBrcode();
		if(StringUtils.isNotBlank(fourConfirmQryVO.getBrcode())){
			param.put("brNo", fourConfirmQryVO.getBrcode());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getNoticeType_Q())){
			param.put("noticeType", fourConfirmQryVO.getNoticeType_Q());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getProductId_Q())){
			param.put("bussType", fourConfirmQryVO.getProductId_Q());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getCname())){
			param.put("cname", fourConfirmQryVO.getCname());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getCoreCustName_Q())){
			param.put("coreCustName", fourConfirmQryVO.getCoreCustName_Q());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getProtocolNo())){
			param.put("protocolNo", fourConfirmQryVO.getProtocolNo());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getDebetId_Q())){
			param.put("debetId", fourConfirmQryVO.getDebetId_Q());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getStatus_Q())){
			param.put("status", fourConfirmQryVO.getStatus_Q());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getNoticeStatus_Q())){
			param.put("noticeStatus", fourConfirmQryVO.getNoticeStatus_Q());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getSignDate1_Q())){
			param.put("signDate1", fourConfirmQryVO.getSignDate1_Q());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getSignDate2_Q())){
			param.put("signDate2", fourConfirmQryVO.getSignDate2_Q());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getCommonDate1_Q())){
			param.put("commonDate1", fourConfirmQryVO.getCommonDate1_Q());
		}
		if(StringUtils.isNotBlank(fourConfirmQryVO.getCommonDate2_Q())){
			param.put("commonDate2", fourConfirmQryVO.getCommonDate2_Q());
		}
		
		List<com.huateng.scf.adv.nte.dao.model.FourWareConfirmNoticeVO> list = bFourWareAcctConfirmNoticeDAO.findAcctConfirmNoticeByPage(param, page);
		Integer count = bFourWareAcctConfirmNoticeDAO.findAcctConfirmNoticeCount(param);
		List<FourWareConfirmNoticeVO> responses = new ArrayList<FourWareConfirmNoticeVO>();
		FourWareConfirmNoticeVO response = null;
		for(com.huateng.scf.adv.nte.dao.model.FourWareConfirmNoticeVO noticeVO:list){
			response = new FourWareConfirmNoticeVO();
			BeanUtils.copyProperties(noticeVO, response);
			if(StringUtils.isNotBlank(response.getTlrn())){
				com.huateng.authority.entity.UserInfo userInfo =scubeUserService.selectUserByTlrNo(response.getTlrn(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				response.setTlrName(userInfo.getTlrName());
			}
			if(StringUtils.isNotBlank(response.getBrcode())){
				BctlVO bctlVO =scubeUserService.selectBctlByBrNo(response.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				response.setBrName(bctlVO.getBrName());
			}
			responses.add(response);
		
		}


		page.setRecords(responses);
		page.setTotalRecord(count);
		return page;
	}
	
	@SuppressWarnings("unchecked")
	private boolean isLikeThisBrName(com.huateng.scf.adv.nte.dao.model.FourWareConfirmNoticeVO  noticeVO,String brCode){
		String brNo =noticeVO.getBrcode();
		boolean result = false;

		if(brNo.equals(brCode)){
			result = true;
		}
		return result;
	}

}
