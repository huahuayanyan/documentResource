package com.huateng.scf.adv.nte.service.impl;

import java.math.BigDecimal;
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
import com.huateng.scf.adv.nte.dao.IAQuantityNoticeDAO;
import com.huateng.scf.adv.nte.service.IAQuantityNoticeService;
import com.huateng.scf.bas.nte.model.NoticeQryVO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.impl.BPbcMtgBaseInfoDAOImpl;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfoExample;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.bcp.dao.ISBcpAppliLowerPriceDAO;
import com.huateng.scf.bas.bcp.dao.impl.SBcpAppliLowerPriceDAOImpl;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPrice;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.nte.dao.model.NoticeResultVO;
import com.huateng.scube.server.annotation.ScubeService;
import com.huateng.sso.vo.UserInfo;

/**
 *  出质通知书查询
 *  
 * @author htrad0055
 *
 */
@ScubeService
@Service(IAQuantityNoticeService.BeanId)
public class AQuantityNoticeServiceImpl implements IAQuantityNoticeService {

	@Resource(name = IAQuantityNoticeDAO.BeanId)
	IAQuantityNoticeDAO aQuantityNoticeDAO;

	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name="SBcpAppliLowerPriceDAO")
	ISBcpAppliLowerPriceDAO sBcpAppliLowerPrice;
	
	@Resource(name="BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO bPbcMtgBaseInfoDAO;
	
	@Resource(name="BPrdInfoDAO")
	IBPrdInfoDAO bPrdInfoDAO;

	@Override
	public Page queryQuantityNoticeByPage(int pageNo, int pageSize, NoticeQryVO noticeQryVO) {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> param = new HashMap<String, Object>();
		
		if (StringUtils.isNotBlank(noticeQryVO.getBussType())) {
			param.put("bussType", noticeQryVO.getBussType());
		}
		if (StringUtils.isNotBlank(noticeQryVO.getNoticeType())) {
			param.put("noticeType", noticeQryVO.getNoticeType());
		}

		if (noticeQryVO.getNoticeTypeSet()!=null&&noticeQryVO.getNoticeTypeSet().size()>0) {
			param.put("noticeTypeSet", noticeQryVO.getNoticeTypeSet());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getSlaveContcode())) {
			param.put("slaveContcode", noticeQryVO.getSlaveContcode());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getCustName())) {
			param.put("cname", noticeQryVO.getCustName());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getStatus())) {
			param.put("status", noticeQryVO.getStatus());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getSignDateFrom())) {
			param.put("signDate1", noticeQryVO.getSignDateFrom());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getSignDateTo())) {
			param.put("signDate2", noticeQryVO.getSignDateTo());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getCommonDateFrom())) {
			param.put("commonDate1", noticeQryVO.getCommonDateFrom());
		}

		if (StringUtils.isNotBlank(noticeQryVO.getCommonDateTo())) {
			param.put("commonDate2", noticeQryVO.getCommonDateTo());
		}

		String brNo = ContextHolder.getOrgInfo().getBrNo();
		
		String brAttr = ContextHolder.getOrgInfo().getBrAttr();
//		param.put("brNo", brNo);
		param.put("brattr", brAttr);
		
		List<NoticeResultVO> list = aQuantityNoticeDAO.findQuantityNoticeListByPage(param, page);
		Integer count = aQuantityNoticeDAO.findQuantityNoticeCount(param);
		List<com.huateng.scf.bas.nte.model.NoticeResultVO> responses = new ArrayList<com.huateng.scf.bas.nte.model.NoticeResultVO>();
		com.huateng.scf.bas.nte.model.NoticeResultVO response = null;
		for (NoticeResultVO element : list) {
			response = new com.huateng.scf.bas.nte.model.NoticeResultVO();
			BeanUtils.copyProperties(element, response);
			BigDecimal bailAmount = response.getBailAmount()==null?new BigDecimal(0):response.getBailAmount();
			response.setBailAmount(bailAmount);
			if(StringUtils.isNotBlank(response.getBrcode())){				
				BctlVO bctlVO= scubeUserService.selectBctlByBrNo(response.getBrcode(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));
				response.setBrName(bctlVO.getBrName());
			}
			if(StringUtils.isNotBlank(response.getTlrn())){				
				com.huateng.authority.entity.UserInfo userinfo =scubeUserService.selectUserByTlrNo(response.getTlrn(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));
				response.setTlrName(userinfo.getTlrName());
			}
			if(StringUtils.isNotBlank(response.getBussType())){
				BPrdInfo bPrdInfo =bPrdInfoDAO.selectByPrimaryKey(response.getBussType());
				response.setBussTypeName(bPrdInfo.getProductName());
			}
			
			if("1".equals(noticeQryVO.getNoticeType()))
			{
				String appno = response.getAppno();

				List listTemp = sBcpAppliLowerPrice.selectByAppno(appno);
				if(listTemp !=null && listTemp.size() > 0)
				{
					SBcpAppliLowerPrice tblAppliLowerPrice = (SBcpAppliLowerPrice) listTemp.get(0);
					response.setExt1Amount(tblAppliLowerPrice.getLowPrice());
					response.setExt2Amount(tblAppliLowerPrice.getLowPriceNew());
				}
			}
			
			if("127".equals(noticeQryVO.getNoticeType())){
				String appno = response.getAppno();
				BigDecimal mortAmountTemp = new BigDecimal(0);;
				BigDecimal mortAmount = new BigDecimal(0);
				BPbcMtgBaseInfoExample example = new BPbcMtgBaseInfoExample();
				List listTemp = bPbcMtgBaseInfoDAO.selectByExample(example );
				for(int i=0;i<listTemp.size();i++)
				{
					BPbcMtgBaseInfo tblAppliLnciBaseInfo = (BPbcMtgBaseInfo) listTemp.get(i);
					mortAmount = (tblAppliLnciBaseInfo.getTotPrice()==null?new BigDecimal(0):tblAppliLnciBaseInfo.getTotPrice());
					mortAmountTemp = mortAmount.add(mortAmountTemp);
				}
				response.setCommonAmt(mortAmountTemp);
			}
			
			responses.add(response);
		}

		page.setTotalRecord(count);
		page.setRecords(responses);
		return page;
	}

}
