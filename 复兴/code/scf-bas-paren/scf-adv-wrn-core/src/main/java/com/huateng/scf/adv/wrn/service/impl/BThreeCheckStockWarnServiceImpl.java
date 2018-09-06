package com.huateng.scf.adv.wrn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.huateng.scf.adv.wrn.dao.IBThreeCheckStockWarnDAO;
import com.huateng.scf.adv.wrn.dao.model.ThreeCheckStockWarnVO;
import com.huateng.scf.adv.wrn.model.WarnQryVO;
import com.huateng.scf.adv.wrn.service.IBThreeCheckStockWarnService;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * @author htrad0055
 * 发货对账不平预警
 */

@ScubeService
@Service(IBThreeCheckStockWarnService.BEAN_ID)
public class BThreeCheckStockWarnServiceImpl implements IBThreeCheckStockWarnService {
	
	@Resource(name = IBThreeCheckStockWarnDAO.BEAN_ID)
	private IBThreeCheckStockWarnDAO bThreeCheckStockWarnDAO;
	
	@Autowired
	private ScubeUserService scubeUserService;
	
	@Resource(name = "BPrdInfoDAO")
	private IBPrdInfoDAO bPrdInfoDAO;
	
	//现票款后货业务品种,产品ID
	public static final String PRODUCT_ID ="1210020";

	/**
	 *  查询发货对账不平预警列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page queryCheckStockWarnByPage(WarnQryVO warnQryVO, int pageSize, int pageNo) {

		Page page = new Page(pageSize, pageNo, 0);
		com.huateng.scf.adv.wrn.dao.model.WarnQryVO warnQryVODal = new com.huateng.scf.adv.wrn.dao.model.WarnQryVO();
		BeanUtils.copyProperties(warnQryVO, warnQryVODal);

		warnQryVODal.setCurrentDate_Q(ScfDateUtil.formatDate(new Date()));
		
		String brcode = ContextHolder.getOrgInfo().getBrNo();
		
		if (StringUtils.isNotBlank(brcode)) {
			warnQryVODal.setBrcode_Q(brcode);
		}
		
//		warnQryVODal.setStatus_Q(ScfBasConstant.QUERY_TYPE_ALL);
		
		String brattr = ContextHolder.getOrgInfo().getBrAttr();
		//查看老数据库，建议直接写死
//		warnQryVODal.setProductId_Q(BThreeCheckStockWarnServiceImpl.PRODUCT_ID);
		
		if(StringUtils.isNotBlank(brattr)){
			warnQryVODal.setBrattr(brattr );
		}
		Page pageResult = bThreeCheckStockWarnDAO.getCheckStockWarnInfo(warnQryVODal, page);
		
		List<ThreeCheckStockWarnVO> list =pageResult.getRecords();
		
		List<ThreeCheckStockWarnVO> responses = new ArrayList<ThreeCheckStockWarnVO>();
		ThreeCheckStockWarnVO resp = new ThreeCheckStockWarnVO();
		for(ThreeCheckStockWarnVO checkStockWarn:list){
			BeanUtils.copyProperties(checkStockWarn, resp);
			if(StringUtils.isNotBlank(checkStockWarn.getCustManager())){
				UserInfo userinfo=scubeUserService.selectUserByTlrNo(checkStockWarn.getCustManager(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				String mgrName = userinfo.getTlrName();
				resp.setMgrName(mgrName);
			}
			if(StringUtils.isNotBlank(checkStockWarn.getBrcode())){
				BctlVO bctl =scubeUserService.selectBctlByBrNo(checkStockWarn.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				String brName =bctl.getBrName();
				resp.setBrName(brName);
			}
			if(StringUtils.isNotBlank(checkStockWarn.getProductId())){
				BPrdInfo prdInfo = bPrdInfoDAO.selectByPrimaryKey(checkStockWarn.getProductId());
				String productName =prdInfo.getProductName();
				resp.setProductName(productName);
			}
			responses.add(resp);
		}
		pageResult.setRecords(responses);
		return pageResult;
	}

}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
