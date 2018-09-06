package com.huateng.scf.bas.qry.service.impl;

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
import com.huateng.scf.bas.cnt.dao.IBCntBuyInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseVO;
import com.huateng.scf.bas.lan.dao.model.ThreeChargeOffVO;
import com.huateng.scf.bas.qry.service.IBQryTripartiteDeliveryInfoService;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BQryTripartiteDeliveryInfoServiceImpl")
public class BQryTripartiteDeliveryInfoServiceImpl implements IBQryTripartiteDeliveryInfoService {
	
	@Resource(name="BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBasedao;
	@Resource(name="BCntBuyInfoDAO")
	IBCntBuyInfoDAO bCntBuyInfoDAO;
	
	@Autowired
	ScubeUserService scubeUserService;

	@Override
	public Page findThreeLnciInfoQuery(int pageNo,int pageSize,DeliveryQryVO deliveryQryVO) {
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
		
		if(StringUtils.isNotBlank(deliveryQryVODal.getProtocolNo())){
			params.put("protocolNo", deliveryQryVODal.getProtocolNo());
		}
		
		if(StringUtils.isNotBlank(deliveryQryVODal.getDebetId())){
			params.put("debetId", deliveryQryVODal.getDebetId());
		}
		
		if(StringUtils.isNotBlank(deliveryQryVODal.getTradeContno())){
			params.put("tradeContno", deliveryQryVODal.getTradeContno());
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
//		int resultCount =bLanLnciBasedao.getThreeLnciInfoListCount(params);
		Page pageResult = new Page(pageSize,pageNo,0);
		List<BLanLnciBaseVO> resultList =bLanLnciBasedao.getThreeLnciInfoListPageByParams(params,pageResult);
		
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
		Integer count = bCntBuyInfoDAO.selectContBuyCountByDebetNo(debetNo);
		List<BCntBuyInfo> list= bCntBuyInfoDAO.selectContBuyInfoByDebetNo(debetNo,page);
		page.setTotalRecord(count);
		page.setRecords(list);
		return page;
	}

}
