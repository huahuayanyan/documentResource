package com.huateng.scf.rec.wrn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.rec.wrn.dao.IPromptPaymentNoticeQryDAO;
import com.huateng.scf.rec.wrn.service.IPromptPaymentNoticeQryService;
import com.huateng.scube.server.annotation.ScubeService;
@ScubeService
@Service("PromptPaymentNoticeQryServiceImpl")
public class PromptPaymentNoticeQryServiceImpl implements IPromptPaymentNoticeQryService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "PromptPaymentNoticeQryDAO")
	IPromptPaymentNoticeQryDAO promptPaymentNoticeQryDAO;
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@SuppressWarnings("unchecked")
	@Override
	public Page queryPromptPayNotice(int pageNo, int pageSize, HashMap<String, String> conditionForm) {
		log.info("通知书查询--应收账款提示付款通知书");
		Page page = new Page(pageSize, pageNo, 0);
		promptPaymentNoticeQryDAO.getDebtNoticeInfo(conditionForm, page);
		List<BNteNoticeBase> list = page.getRecords();
		List<BNteNoticeBase> response = new ArrayList<BNteNoticeBase>();
		if(list!=null&&list.size()>0){
			Iterator<?> iter=list.iterator();
			while(iter.hasNext()){
				BNteNoticeBase VO= (BNteNoticeBase) iter.next();
				if(StringUtil.isStrNotEmpty(VO.getBrcode())){
					BctlVO bctl = scubeUserService.selectBctlByBrNo(VO.getBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					if(null!=bctl){
						VO.setBrcode(bctl.getBrName());
					}
				}
				if(StringUtil.isStrNotEmpty(VO.getTlrn())){
					UserInfo userInfo = scubeUserService.selectUserByTlrNo(VO.getTlrn(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					if(null!=userInfo){
						VO.setTlrn(userInfo.getTlrName());
					}
				}
				response.add(VO);
			}
		}
		
		page.setRecords(response);
		return page;
	}

}
