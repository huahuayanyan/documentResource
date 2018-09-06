package com.huateng.scf.sto.wrn.service.impl;

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
import com.huateng.scf.sto.wrn.model.DownLowPriceNewQryVO;
import com.huateng.scf.sto.wrn.model.DownLowPriceNewVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.impl.BPrdInfoDAOImpl;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.sto.wrn.dao.ext.IBDownLowPriceDAO;
import com.huateng.scf.sto.wrn.service.IBDownLowPriceService;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * @author htrad0055
 *	跌破最低控货价值预警
 */

@ScubeService
@Service(IBDownLowPriceService.BeanId)
public class BDownLowPriceServiceImpl implements IBDownLowPriceService {
	
	@Resource(name=IBDownLowPriceDAO.BeanId)
	IBDownLowPriceDAO  bDownLowPriceDAO;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name ="BPrdInfoDAO")
	IBPrdInfoDAO bPrdInfoDAO;
	
	/**
	 * 
	 *	分页查询跌破最低控货价值预警
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page queryDownLowPriceNewByPage(DownLowPriceNewQryVO qryVO, int pageNo,
			int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		Page page = new Page(pageSize, pageNo, 0);		
		params.put("role", ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		String brcode = ContextHolder.getOrgInfo().getBrNo();
		params.put("brcode", brcode);
		params.put("brattr", ContextHolder.getOrgInfo().getBrAttr());
		
		if(StringUtils.isNotBlank(qryVO.getWarnNo_Q())){
			params.put("warnNo", qryVO.getWarnNo_Q());
		}
		
		if(StringUtils.isNotEmpty(qryVO.getWarnLevel_Q())){
			params.put("warnLevel", qryVO.getWarnLevel_Q());
		}
		if(StringUtils.isNotEmpty(qryVO.getCustName_Q())){
			params.put("custName", qryVO.getCustName_Q());
		}
		if(StringUtils.isNotEmpty(qryVO.getSlaveContcode_Q())){
			params.put("slaveContcode", qryVO.getSlaveContcode_Q());
		}
		if(StringUtils.isNotEmpty(qryVO.getMoniCname_Q())){
			params.put("moniCname", qryVO.getMoniCname_Q());
		}
		if(StringUtils.isNotBlank(qryVO.getStartDate_Q())){
			params.put("startDate", qryVO.getStartDate_Q());
		}
		if(StringUtils.isNotBlank(qryVO.getEndDate_Q())){
			params.put("endDate", qryVO.getEndDate_Q());
		}
		if(StringUtils.isNotBlank(qryVO.getCustcd())){
			params.put("custcd", qryVO.getCustcd());
		}
		
		List<com.huateng.scf.adv.wrn.dao.model.DownLowPriceNewVO> list = bDownLowPriceDAO.selectDownLowPriceNewByPage(params,page);
		Integer totalRecord = bDownLowPriceDAO.countDownLowPriceNew(params);
		List<DownLowPriceNewVO> records = new ArrayList<DownLowPriceNewVO>();
		DownLowPriceNewVO record = new DownLowPriceNewVO();
		for(com.huateng.scf.adv.wrn.dao.model.DownLowPriceNewVO downLowPriceNewVO:list){
			BeanUtils.copyProperties(downLowPriceNewVO, record);
			if(StringUtils.isNotBlank(record.getCustManager())){
				UserInfo userInfo = scubeUserService.selectUserByTlrNo(record.getCustManager(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				record.setMgrNm(userInfo.getTlrName());
			}
			if(StringUtils.isNotBlank(record.getBrcode())){
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(record.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				record.setBrcodeNm(bctlVO.getBrName());
			}
			
			if(StringUtils.isNotBlank(record.getProductId())){
				BPrdInfo prdInfo = bPrdInfoDAO.selectByPrimaryKey(record.getProductId());
				if(prdInfo!=null){
					String productNm = prdInfo.getProductName();
					record.setProductNm(productNm);		
				}
			}
			records.add(record);
		}
		
		page.setTotalRecord(totalRecord);
		page.setRecords(records);
		return page;
	}

}
