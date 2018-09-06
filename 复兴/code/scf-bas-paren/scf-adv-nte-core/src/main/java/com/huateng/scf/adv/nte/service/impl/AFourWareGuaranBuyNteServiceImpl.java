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
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.nte.dao.IAFourWareGuaranBuyNteDAO;
import com.huateng.scf.adv.nte.dao.model.FourDeliveryNotifyVO;
import com.huateng.scf.adv.nte.service.FourWareGuaranBuyNoticeQryVO;
import com.huateng.scf.adv.nte.service.IAFourWareGuaranBuyNteService;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.nte.dao.model.NoticeResultVO;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service(IAFourWareGuaranBuyNteService.BeanId)
public class AFourWareGuaranBuyNteServiceImpl implements IAFourWareGuaranBuyNteService {
	@Resource(name = IAFourWareGuaranBuyNteDAO.BeanId)
	IAFourWareGuaranBuyNteDAO aFourWareGuaranBuyNteDAO;
	
	@Autowired
	ScubeUserService scubeUserService;

	@Override
	public Page queryFourWareGuaranBuyNteByPage(int pageNo, int pageSize, FourWareGuaranBuyNoticeQryVO noticeQryVO) {

		Page page = new Page(pageSize, pageNo, 0);

		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("brNo", ContextHolder.getOrgInfo().getBrNo());
		param.put("brAttr", ContextHolder.getOrgInfo().getBrAttr());
		if (StringUtils.isNotBlank(noticeQryVO.getAppno_Q())) {
			param.put("appno", noticeQryVO.getAppno_Q());
		}
		if (StringUtils.isNotBlank(noticeQryVO.getCustcd())) {
			param.put("custcd", noticeQryVO.getCustcd());
		}
		if (StringUtils.isNotBlank(noticeQryVO.getCname())) {
			param.put("cname", noticeQryVO.getCname());
		}
		if (StringUtils.isNotBlank(noticeQryVO.getCoreCustcd_Q())) {
			param.put("coreCustcd", noticeQryVO.getCoreCustcd_Q());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getCoreName_Q())) {
			param.put("coreName", noticeQryVO.getCoreName_Q());
		}
		if (noticeQryVO.getMoneyFrom_Q() != null) {
			param.put("moneyFrom", noticeQryVO.getMoneyFrom_Q());
		}

		if (noticeQryVO.getMoneyTo_Q() != null) {
			param.put("moneyTo", noticeQryVO.getMoneyTo_Q());
		}
		if (StringUtils.isNotBlank(noticeQryVO.getNum_Q())) {
			param.put("num", noticeQryVO.getNum_Q());
		}
		if (StringUtils.isNotBlank(noticeQryVO.getSignDate1_Q())) {
			param.put("signDate1", noticeQryVO.getSignDate1_Q());
		}
		if (StringUtils.isNotBlank(noticeQryVO.getSignDate2_Q())) {
			param.put("signDate2", noticeQryVO.getSignDate2_Q());
		}
		if (StringUtils.isNotBlank(noticeQryVO.getCommonDate1_Q())) {
			param.put("commonDate1", noticeQryVO.getCommonDate1_Q());
		}
		if (StringUtils.isNotBlank(noticeQryVO.getCommonDate2_Q())) {
			param.put("commonDate2", noticeQryVO.getCommonDate2_Q());
		}
		if (StringUtils.isNotBlank(noticeQryVO.getProductId_Q())) {
			param.put("bussType", noticeQryVO.getProductId_Q());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getNoticeStatus_Q())) {
			param.put("status", noticeQryVO.getNoticeStatus_Q());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getBrcode())) {
			param.put("brcode", noticeQryVO.getBrcode());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getNoticeType_Q())) {
			param.put("noticeType", noticeQryVO.getNoticeType_Q());
		}

		List<NoticeResultVO> list = aFourWareGuaranBuyNteDAO.findFourWareGuaranBuyNteByPage(param, page);

		Integer count = aFourWareGuaranBuyNteDAO.findFourWareGuaranBuyNteCount(param);

		ArrayList<com.huateng.scf.bas.nte.model.NoticeResultVO> responses = 
								new ArrayList<com.huateng.scf.bas.nte.model.NoticeResultVO>();
		com.huateng.scf.bas.nte.model.NoticeResultVO response = null;
		for (NoticeResultVO notifyVO : list) {
			response = new com.huateng.scf.bas.nte.model.NoticeResultVO();
			BeanUtils.copyProperties(notifyVO, response);
			if (StringUtils.isNotBlank(notifyVO.getBrcode())) {
				BctlVO bctl = scubeUserService.selectBctlByBrNo(notifyVO.getBrcode(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));
				String brName = bctl.getBrName();
				response.setBrName(brName);
			}
			if (StringUtils.isNotBlank(notifyVO.getTlrn())) {
				UserInfo user = scubeUserService.selectUserByTlrNo(notifyVO.getTlrn(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));
				String tlrName = user.getTlrName();
				response.setTlrName(tlrName);
			}
			responses.add(response);
		}

		page.setTotalRecord(count);
		page.setRecords(responses);

		return page;
	}

}
