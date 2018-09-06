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
import com.huateng.scf.adv.nte.dao.IANteFourDeliveryNotifyDAO;
import com.huateng.scf.adv.nte.dao.model.FourDeliveryNotifyVO;
import com.huateng.scf.adv.nte.model.FourConfirmQryVO;
import com.huateng.scf.adv.nte.service.IANteFourDeliveryNotifyService;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scube.server.annotation.ScubeService;


/**
 * @author htrad0055
 *	
 *	发货入库通知书
 */
@ScubeService
@Service(IANteFourDeliveryNotifyService.BeanId)
public class ANteFourDeliveryNotifyServiceImpl implements IANteFourDeliveryNotifyService {

	@Resource(name=IANteFourDeliveryNotifyDAO.BeanId)
	private IANteFourDeliveryNotifyDAO aNteFourDeliveryNotifyDAO; 
	
	@Autowired
	private ScubeUserService scubeUserService;
	
	@Override
	public Page queryFourDeliveryNotifyListByPage( int pageNo,int pageSize, FourConfirmQryVO qryVO) {
		
		Page page = new Page(pageSize, pageNo, 0);

		Map<String, Object> param = new HashMap<String, Object>();
		String brattr = ContextHolder.getOrgInfo().getBrAttr();
		if(StringUtils.isNotBlank(brattr)){
			param.put("brattr", brattr);
		}
		String brNo= ContextHolder.getUserInfo().getBrNo();
		if(StringUtils.isNotBlank(brNo)){
//			param.put("brNo", brNo);
		}
		
		if(StringUtils.isNotBlank(qryVO.getCname())){
			param.put("cname", qryVO.getCname());
		}

		if(StringUtils.isNotBlank(qryVO.getStatus_Q())){
			param.put("status", qryVO.getStatus_Q());
		}
		
		if(StringUtils.isNotBlank(qryVO.getProductId_Q())){
			param.put("bussType", qryVO.getProductId_Q());
		}
		
		if(StringUtils.isNotBlank(qryVO.getSignDate1_Q())){
			param.put("signDate1", qryVO.getSignDate1_Q());
		}

		if(StringUtils.isNotBlank(qryVO.getSignDate2_Q())){
			param.put("signDate2", qryVO.getSignDate2_Q());
		}

		if(StringUtils.isNotBlank(qryVO.getCommonDate1_Q())){
			param.put("commonDate1", qryVO.getCommonDate1_Q());
		}

		if(StringUtils.isNotBlank(qryVO.getCommonDate2_Q())){
			param.put("commonDate2", qryVO.getCommonDate2_Q());
		}
		if(StringUtils.isNotBlank(qryVO.getBrcode())){
			param.put("brcode", qryVO.getBrcode());
		}
		List<FourDeliveryNotifyVO> list = aNteFourDeliveryNotifyDAO.findFourDeliveryNotifyByPage(param, page);
		Integer count = aNteFourDeliveryNotifyDAO.findFourDeliveryNotifyCount(param);
		ArrayList<FourDeliveryNotifyVO> responses = new ArrayList<FourDeliveryNotifyVO>();
		FourDeliveryNotifyVO response = null;
		for(FourDeliveryNotifyVO  notifyVO:list){
			response = new FourDeliveryNotifyVO();
			BeanUtils.copyProperties(notifyVO, response);
			if(StringUtils.isNotBlank(notifyVO.getBrcode())){
				BctlVO bctl = scubeUserService.selectBctlByBrNo(notifyVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				String brName =	bctl.getBrName();
				response.setBrName(brName);
			}
			if(StringUtils.isNotBlank(notifyVO.getTlrn())){
				UserInfo user = scubeUserService.selectUserByTlrNo(notifyVO.getTlrn(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				String tlrName = user.getTlrName();
				response.setTlrName(tlrName);
			}
			responses.add(response);
		}
		
		page.setTotal(count);
		page.setRecords(responses);
		return page;
	}

}
