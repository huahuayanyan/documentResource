package com.huateng.scf.bas.nte.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.nte.dao.IBNetNoticeQryVODAO;
import com.huateng.scf.bas.nte.model.NoticeQryVO;
import com.huateng.scf.bas.nte.service.IBNteNoticeQryVOService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 收款确认通知书查询服务实现类
 * </p>
 * 
 * @author zhanghesheng
 * @date 2017年1月4日
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * zhanghesheng		2017年1月4日	     新增
 * 
 * </pre>
 */
@ScubeService
@Service("BNteNoticeQryVOServiceImpl")
public class BNteNoticeQryVOServiceImpl implements IBNteNoticeQryVOService {

	@Resource(name = "BNetNoticeQryVODAO")
	private IBNetNoticeQryVODAO bnetNetNoticeQryVODAO;
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
//	private final String NOTICE_TYPE_75 = "担保提货流贷收款确认通知书";
//	private final String NOTICE_TYPE_78 = "担保提货银承收款确认通知书";

	@SuppressWarnings("unchecked")
	@Override
	public Page queryNoticeQryVOByPage(int pageNo, int pageSize,
			NoticeQryVO noticeQryVO) throws ScubeBizException {
//		com.huateng.scf.bas.nte.dao.model.NoticeQryVO newNoticeQryVO = new com.huateng.scf.bas.nte.dao.model.NoticeQryVO();
//		BeanUtils.copyProperties(noticeQryVO, newNoticeQryVO);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("noticeType",noticeQryVO.getNoticeType());
		param.put("bussType",noticeQryVO.getBussType());
		param.put("confirmStatus",noticeQryVO.getConfirmStatus());
		param.put("debetId",noticeQryVO.getDebetId());
		param.put("custName",noticeQryVO.getCustName());
		param.put("otherCustName",noticeQryVO.getOtherCustName());
		param.put("signDateFrom",noticeQryVO.getSignDateFrom());
		param.put("signDateTo",noticeQryVO.getSignDateTo());
		param.put("commonDateFrom",noticeQryVO.getCommonDateFrom());
		param.put("commonDateTo",noticeQryVO.getCommonDateTo());
		//数据权限控制：1、默认查询出当前登录人机构及其以下机构信息 2、查询条件已经选了机构的,根据已选择的查询信息
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
	    ArrayList<String> arrBr = new ArrayList<String>();
		if(noticeQryVO.getBrcode()!=null){
			arrBr.add(noticeQryVO.getBrcode().toString());
 		}else{
			List<BctlVO> bctList = scubeUserService.getBrListByBrNo(brCode,ScfCommonUtil.getBrManagerNo(scubeUserService));
			for(BctlVO bctlVO : bctList){
				String brNo = bctlVO.getBrNo();
				arrBr.add(brNo);
			}
		}
		param.put("arrBr", arrBr);
		Page page = new Page(pageSize, pageNo, 0);
		bnetNetNoticeQryVODAO.queryNoticeQryVO(param,page);
		List<com.huateng.scf.bas.nte.dao.model.NoticeQryVO> list = page.getRecords();
		List<com.huateng.scf.bas.nte.dao.model.NoticeQryVO> response = new ArrayList<com.huateng.scf.bas.nte.dao.model.NoticeQryVO>();
		if(list!=null&&list.size()>0){
			Iterator<?> iter=list.iterator();
			while(iter.hasNext()){
				com.huateng.scf.bas.nte.dao.model.NoticeQryVO VO= (com.huateng.scf.bas.nte.dao.model.NoticeQryVO) iter.next();
				if(StringUtil.isStrNotEmpty(VO.getBrcode())){
					BctlVO bctl = scubeUserService.selectBctlByBrNo(VO.getBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					VO.setBrcode(bctl.getBrName());
				}
				if(StringUtil.isStrNotEmpty(VO.getTlrn())){
					UserInfo userInfo = scubeUserService.selectUserByTlrNo(VO.getTlrn(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					VO.setTlrn(userInfo.getTlrName());
				}
				response.add(VO);
			}
		}
		page.setRecords(response);
		return page;
	}

}
