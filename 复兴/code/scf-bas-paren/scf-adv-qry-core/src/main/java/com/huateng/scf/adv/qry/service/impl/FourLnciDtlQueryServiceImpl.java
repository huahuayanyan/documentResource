package com.huateng.scf.adv.qry.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.huateng.scf.adv.qry.dao.IFourLnciDtlQryDAO;
import com.huateng.scf.adv.qry.service.IFourLnciDtlQueryService;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseVO;
import com.huateng.scf.bas.lan.dao.model.ThreeChargeOffVO;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("FourLnciDtlQueryServiceImpl")
public class FourLnciDtlQueryServiceImpl implements IFourLnciDtlQueryService {
	
	@Resource(name="fourLnciDtlQryDAO")
	IFourLnciDtlQryDAO fourLnciDtlQryDAO;
	
	@Autowired
	ScubeUserService scubeUserService;

	@Override
	public Page findFourLnciInfoQuery(int pageNo,int pageSize,DeliveryQryVO deliveryQryVO) {
		com.huateng.scf.bas.cnt.dao.model.DeliveryQryVO deliveryQryVODal = 
				new com.huateng.scf.bas.cnt.dao.model.DeliveryQryVO();
		BeanUtils.copyProperties(deliveryQryVO, deliveryQryVODal);
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(StringUtils.isNotBlank(deliveryQryVODal.getSellerNm())){
			params.put("sellerNm", deliveryQryVODal.getSellerNm());
		}
		
		if(StringUtils.isNotBlank(deliveryQryVODal.getCoreNm())){
			params.put("coreNm", deliveryQryVODal.getCoreNm());
		}
		
		if(StringUtils.isNotBlank(deliveryQryVODal.getDebetId())){
			params.put("debetId", deliveryQryVODal.getDebetId().toLowerCase());
		}
		
		if(StringUtils.isNotBlank(deliveryQryVODal.getProtocolCode())){
			params.put("protocolCode", deliveryQryVODal.getProtocolCode().toLowerCase());
		}
		
		if(StringUtils.isNotBlank(deliveryQryVODal.getTradeContno())){
			params.put("tradeContno", deliveryQryVODal.getTradeContno().toLowerCase());
		}
		if(StringUtils.isNotBlank(deliveryQryVODal.getLoanWay())){
			params.put("loanWay", deliveryQryVODal.getLoanWay());
		}
		if(StringUtils.isNotBlank(deliveryQryVODal.getStartDate1())){
			params.put("startDate1", deliveryQryVODal.getStartDate1());
		}
		if(StringUtils.isNotBlank(deliveryQryVODal.getStartDate2())){
			params.put("startDate2", deliveryQryVODal.getStartDate2());
		}
		if(StringUtils.isNotBlank(deliveryQryVODal.getStartDate3())){
			params.put("startDate3", deliveryQryVODal.getStartDate3());
		}
		if(StringUtils.isNotBlank(deliveryQryVODal.getStartDate4())){
			params.put("startDate4", deliveryQryVODal.getStartDate4());
		}
		if(deliveryQryVODal.getAmount1()!=null){
			params.put("amount1", deliveryQryVODal.getAmount1());
		}
		if(deliveryQryVODal.getAmount2()!=null){
			params.put("amount2", deliveryQryVODal.getAmount2());
		}
		if(StringUtils.isNotBlank(deliveryQryVODal.getStatus())){
			params.put("status",deliveryQryVODal.getStatus());
		}	
		//数据权限控制：“经办机构”设置默认值，值为：当前用户所属机构及以下。
		ArrayList<String> arrBr = new ArrayList<String>();
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
		if(StringUtils.isNotBlank(deliveryQryVODal.getBrcode())){
			arrBr.add(deliveryQryVODal.getBrcode());
		}else{
			List<BctlVO> bctList = scubeUserService.getBrListByBrNo(brCode,ScfCommonUtil.getBrManagerNo(scubeUserService));
			for(BctlVO bctlVO : bctList){
				String brNo = bctlVO.getBrNo();
				arrBr.add(brNo);
			}
		}
		params.put("arrBr", arrBr);

		Page pageResult = new Page(pageSize,pageNo,0);
		List<BLanLnciBaseVO> resultList =fourLnciDtlQryDAO.selectByPage(params,pageResult);
		
		List<ThreeChargeOffVO> outputList = new ArrayList<ThreeChargeOffVO>();
		if(resultList!=null&&resultList.size()>0){
			Iterator<BLanLnciBaseVO> it = resultList.iterator();
			while(it.hasNext()){
				BLanLnciBaseVO bLanLnciBaseVO = (BLanLnciBaseVO) it.next();
				BLanLnciBase bLanLnciBase = new BLanLnciBase();
				BeanUtils.copyProperties(bLanLnciBaseVO, bLanLnciBase);

				ThreeChargeOffVO chargeOffVO = new ThreeChargeOffVO();
				
				BeanUtils.copyProperties(bLanLnciBase, chargeOffVO);

				if(StringUtils.isNoneBlank(bLanLnciBaseVO.getSellerCustcd())){
					chargeOffVO.setCustcd(bLanLnciBaseVO.getSellerCustcd());
				}
				
				if(StringUtils.isNoneBlank(bLanLnciBaseVO.getSellerCname())){
					chargeOffVO.setCname(bLanLnciBaseVO.getSellerCname());
				}
				
				if(StringUtils.isNoneBlank(bLanLnciBaseVO.getCoreCustcd())){
					chargeOffVO.setCoreCustcd(bLanLnciBaseVO.getCoreCustcd());
				}
				
				if(StringUtils.isNoneBlank(bLanLnciBaseVO.getCoreCname())){
					chargeOffVO.setCoreCName(bLanLnciBaseVO.getCoreCname());
				}
				
				if(StringUtils.isNotBlank(bLanLnciBase.getBussBrcode())){
					chargeOffVO.setDept(bLanLnciBase.getBussBrcode());
				}
				if(StringUtils.isNoneBlank(bLanLnciBase.getLnciType())){					
					chargeOffVO.setLoanWay(bLanLnciBase.getLnciType());
				}
				
				if(StringUtils.isNotBlank(chargeOffVO.getSlaveLimit())&&chargeOffVO.getStartDate()!=null){
					Date limitDate = getEndDateByDays(chargeOffVO.getStartDate(), Integer.valueOf(chargeOffVO.getSlaveLimit()));
					chargeOffVO.setLimitDate(limitDate);
				}
				
				if(chargeOffVO.getAddBailAmount()!=null){					
					chargeOffVO.setAddBailAmount(chargeOffVO.getAddBailAmount().add(chargeOffVO.getBailAmount()==null?BigDecimal.ZERO:chargeOffVO.getBailAmount()));
				}
				
				if(chargeOffVO.getAddCashEqtAmt()!=null){
					chargeOffVO.setAddCashEqtAmt(chargeOffVO.getAddCashEqtAmt().add(chargeOffVO.getAddCashEqtAmt()==null?BigDecimal.ZERO:chargeOffVO.getAddCashEqtAmt()));
				}
				BigDecimal lnciBal = chargeOffVO.getLnciBal()==null?BigDecimal.ZERO:chargeOffVO.getLnciBal();
				BigDecimal bailAmount = chargeOffVO.getBailAmount()==null?BigDecimal.ZERO:chargeOffVO.getBailAmount();
				BigDecimal refundAmounnt = chargeOffVO.getRefundAmount()==null?BigDecimal.ZERO:chargeOffVO.getRefundAmount();
				chargeOffVO.setOpenAmount(lnciBal.subtract(bailAmount).subtract(refundAmounnt));
				chargeOffVO.setBrcode(bLanLnciBaseVO.getBrcode());
				chargeOffVO.setTlrno(bLanLnciBaseVO.getTlrno());
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(chargeOffVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				UserInfo userInfo = scubeUserService.selectUserByTlrNo(chargeOffVO.getTlrno(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				String tlrName=userInfo.getTlrName();
				
				chargeOffVO.setTlrName(tlrName);
				String brcodeName=bctlVO.getBrName();
				chargeOffVO.setBrcodeName(brcodeName);
				
				chargeOffVO.setProductName(bLanLnciBaseVO.getProductName());
				chargeOffVO.setProtocolCode(bLanLnciBaseVO.getProtocolCode());
				chargeOffVO.setFirstBailRatio(bLanLnciBaseVO.getFirstBailRatio());
				
				//统计保证金金额
				BigDecimal tempAmt1 = BigDecimal.ZERO;
				BigDecimal tempAmt2 = BigDecimal.ZERO;
				if(!StringUtil.isEmpty(bLanLnciBaseVO.getBailAmount())){
					tempAmt1 = bLanLnciBaseVO.getBailAmount();
				}
				if(!StringUtil.isEmpty(bLanLnciBaseVO.getAddBailAmount())){
					tempAmt2 = bLanLnciBaseVO.getAddBailAmount();
				}
				chargeOffVO.setTotBailAmount(tempAmt1.add(tempAmt2));
				
				//统计现金等价物价值
				tempAmt1 = BigDecimal.ZERO;
				tempAmt2 = BigDecimal.ZERO;
				if(!StringUtil.isEmpty(bLanLnciBaseVO.getInitCashEqtAmt())){
					tempAmt1 = bLanLnciBaseVO.getInitCashEqtAmt();
				}
				if(!StringUtil.isEmpty(bLanLnciBaseVO.getAddCashEqtAmt())){
					tempAmt2 = bLanLnciBaseVO.getAddCashEqtAmt();
				}
				chargeOffVO.setTotCashEqtAmt(tempAmt1.add(tempAmt2));
				
				outputList.add(chargeOffVO);
			}
		}
		
		pageResult.setRecords(outputList);
		return pageResult;
	}
	
//TODO 2017/1/5	
	public Date getEndDateByDays(String startDate,Integer passDays){
        Calendar calendarStartDate = Calendar.getInstance();
        try {
			calendarStartDate.setTime(ScfDateUtil.toDate(startDate, "yyyyMMdd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        calendarStartDate.add(Calendar.DAY_OF_YEAR, passDays);

        return calendarStartDate.getTime();
	}
	
	@Override
	public Page getContBuyInfoByDebetNo(int pageNo,int pageSize,String debetNo){
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		fourLnciDtlQryDAO.queryBCntBuyInfoListByPage(debetNo, page);
		return page;
	}

}
