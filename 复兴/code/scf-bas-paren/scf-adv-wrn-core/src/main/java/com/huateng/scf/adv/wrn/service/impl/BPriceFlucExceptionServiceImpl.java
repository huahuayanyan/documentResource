package com.huateng.scf.adv.wrn.service.impl;

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
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.IBPriceFlucExceptionDAO;
import com.huateng.scf.adv.wrn.dao.model.BWanMortFlucPriceVO;
import com.huateng.scf.adv.wrn.model.WarnQryVO;
import com.huateng.scf.adv.wrn.service.IBPriceFlucExceptionService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgClassDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * @author htrad0055
 *	价格跌幅预警
 */
@ScubeService
@Service(IBPriceFlucExceptionService.BeanID)
public class BPriceFlucExceptionServiceImpl implements IBPriceFlucExceptionService {
	
	@Resource(name=IBPriceFlucExceptionDAO.BeanID)
	IBPriceFlucExceptionDAO bPriceFlucExceptionDAO;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name="BPbcMtgClassDAO")
	IBPbcMtgClassDAO bPbcMtgClassDAO;
	
	/**
	 * 
	 *	分页查询价格跌幅预警列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page findPriceFlucExceptionPage(WarnQryVO warnQryVO, int pageSize, int pageNo) {
		
		com.huateng.scf.adv.wrn.dao.model.WarnQryVO warnQryVODal = new com.huateng.scf.adv.wrn.dao.model.WarnQryVO();
		BeanUtils.copyProperties(warnQryVO, warnQryVODal);
		warnQryVODal.setBrcode_Q(ContextHolder.getOrgInfo().getBrNo());
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(warnQryVO.getWarnType_Q())){
			params.put("warnType", warnQryVO.getWarnType_Q());
		}
		
		if(StringUtils.isNotBlank(warnQryVO.getSlaveContCode())){
			//质押合同号
			params.put("slaveContCode", warnQryVO.getSlaveContCode());
		}
		if(StringUtils.isNotBlank(warnQryVO.getWarnLevel_Q())){
			params.put("warnLevel", warnQryVO.getWarnLevel_Q());
		}
		if(StringUtils.isNotBlank(warnQryVO.getFluctuation1_Q())){
			//波动率  
			Long fluctuation1 =Long.valueOf(warnQryVO.getFluctuation1_Q());
			params.put("fluctuation1", 	BigDecimal.valueOf(fluctuation1));
		}
		if(StringUtils.isNotBlank(warnQryVO.getFluctuation2_Q())){
			Long fluctuation2 =Long.valueOf(warnQryVO.getFluctuation2_Q());
			params.put("fluctuation2", 	BigDecimal.valueOf(fluctuation2));
		}
		if(StringUtils.isNotBlank(warnQryVO.getWarnNo_Q())){
			//预警编号
			params.put("paramId", warnQryVO.getWarnNo_Q());
		}
		if(StringUtils.isNotBlank(warnQryVO.getCname())){
			//出质人名称
			params.put("cname", warnQryVO.getCname());
		}
		if(StringUtils.isNotBlank(warnQryVO.getCustcd())){
			//出质人客户号
			params.put("custcd", warnQryVO.getCustcd());
		}
		if(StringUtils.isNotBlank(warnQryVO.getWarnDueType_Q())){
			params.put("warnDueType", warnQryVO.getWarnDueType_Q());
		}

//		params.put("brcode", ContextHolder.getOrgInfo().getBrNo());
		String brattr= ContextHolder.getOrgInfo().getBrAttr();
		if(StringUtils.isNotBlank(brattr)){
			params.put("brattr", brattr);
		}
		List<BWanMortFlucPriceVO> list =bPriceFlucExceptionDAO.getPriceFluctuationExceptionList(params,page);
		List<com.huateng.scf.adv.wrn.model.BWanMortFlucPriceVO> records = new ArrayList<com.huateng.scf.adv.wrn.model.BWanMortFlucPriceVO>();
		com.huateng.scf.adv.wrn.model.BWanMortFlucPriceVO element = new com.huateng.scf.adv.wrn.model.BWanMortFlucPriceVO();
		for(BWanMortFlucPriceVO vo:list){
			BeanUtils.copyProperties(vo, element);

			//获取质押品一级名称
			String mortgageLevelOneName=null;
			if(StringUtil.isStrNotEmpty(element.getMortgageLevelOne())){
				Long levelOneCode = Long.valueOf(element.getMortgageLevelOne());
				BPbcMtgClass mortgageLevelOne = bPbcMtgClassDAO.selectByPrimaryKey(BigDecimal.valueOf(levelOneCode));
				mortgageLevelOneName = mortgageLevelOne.getMortgageName();
				element.setMortgageLevelOneName(mortgageLevelOneName);
			}

			//获取质押品二级名称
			String mortgageLevelTwoName=null;
			if(StringUtil.isStrNotEmpty(element.getMortgageLevelTwo())){
				Long levelTwoCode = Long.valueOf(element.getMortgageLevelTwo());
				BPbcMtgClass mortgageLevelTwo = bPbcMtgClassDAO.selectByPrimaryKey(BigDecimal.valueOf(levelTwoCode));
				mortgageLevelTwoName = mortgageLevelTwo.getMortgageName();
				element.setMortgageLevelTwoName(mortgageLevelTwoName);
			}
			
			//获取质押品三级名称
			String mortgageLevelThreeName=null;
			if(StringUtil.isStrNotEmpty(element.getMortgageLevelThree())){
				Long LevelThreeCode = Long.valueOf(element.getMortgageLevelThree());
				BPbcMtgClass mortgageLevelThree = bPbcMtgClassDAO.selectByPrimaryKey(BigDecimal.valueOf(LevelThreeCode));
				mortgageLevelThreeName = mortgageLevelThree.getMortgageName();
				element.setMortgageLevelThreeName(mortgageLevelThreeName);
			}
			
			//获取客户经理姓名
			UserInfo userInfo =ContextHolder.getUserInfo();
			String custManager=userInfo.getTlrName();
			element.setCustManager(custManager);

			//获取机构名称
			String brcodeName=ContextHolder.getOrgInfo().getBrName();
			element.setBrcodeName(brcodeName);
			records.add(element);
		}
			
		int totalRecord = bPriceFlucExceptionDAO.countPriceFluctuationException(params);
		page.setRecords(records);
		page.setTotalRecord(totalRecord);
		return page;
		
	}
	
	

}
