package com.huateng.scf.adv.nte.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.nte.service.IDvyChkNoticeService;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
@ScubeService
@Service("DvyChkNoticeServiceImpl")
public class DvyChkNoticeServiceImpl implements IDvyChkNoticeService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = IDvyChkNoticeService.BEAN_ID)
	IDvyChkNoticeService dvyChkNoticeService; 
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@Resource(name = "BNteNoticeBaseDAO")
	private IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public Page queryDvyChkNteByPage(int pageNo, int pageSize, Map<String, String> param) throws ScubeBizException {
		log.info("发货对账通知书查询");
		Page page = new Page(pageSize, pageNo, 0);
		 //数据权限控制：1、默认查询出当前登录人机构及其以下机构信息 2、查询条件已经选了机构的,根据已选择的查询信息
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
	    ArrayList<String> arrBr = new ArrayList<String>();
		if(param.get("brcode")!=null){
			arrBr.add(param.get("brcode").toString());
 		}else{
			List<BctlVO> bctList = scubeUserService.getBrListByBrNo(brCode,ScfCommonUtil.getBrManagerNo(scubeUserService));
			for(BctlVO bctlVO : bctList){
				String brNo = bctlVO.getBrNo();
				arrBr.add(brNo);
			}
		}
		BNteNoticeBaseExample example = new BNteNoticeBaseExample();
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(param.get("custName"))) {
			criteria.andCustNameLike("%"+param.get("custName")+"%");
		}
		if (StringUtils.isNotEmpty(param.get("otherCustName"))) {
			criteria.andOtherCustNameLike("%"+param.get("otherCustName")+"%");
		}
		if (StringUtils.isNotEmpty(param.get("protocolNo"))) {
			criteria.andProtocolNoEqualTo(param.get("protocolNo"));
		}
		if (StringUtils.isNotEmpty(param.get("productId"))) {
			criteria.andBussTypeEqualTo(param.get("productId"));
		}
		if (StringUtils.isNotEmpty(param.get("noticeType"))) {
			criteria.andNoticeTypeEqualTo(param.get("noticeType"));
		}
		if (null!=arrBr){
//			criteria.andBrcodeEqualTo(param.get("brcode"));
			criteria.andBrcodeIn(arrBr);
		}
		if (StringUtils.isNotEmpty(param.get("signDateFrom"))) {
			criteria.andSignDateGreaterThanOrEqualTo(param.get("signDateFrom"));
		}
		if (StringUtils.isNotEmpty(param.get("signDateTo"))) {
			criteria.andSignDateLessThanOrEqualTo(param.get("signDateTo"));
		}
		if (StringUtils.isNotEmpty(param.get("commonDateFrom"))) {
			criteria.andCommonDateGreaterThanOrEqualTo(param.get("commonDateFrom"));
		}
		if (StringUtils.isNotEmpty(param.get("commonDateTo"))) {
			criteria.andCommonDateLessThanOrEqualTo(param.get("commonDateTo"));
		}
		example.setOrderByClause(" NUM desc, SIGN_DATE desc");
		bNteNoticeBaseDAO.selectByPage(example, page);
		 
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
