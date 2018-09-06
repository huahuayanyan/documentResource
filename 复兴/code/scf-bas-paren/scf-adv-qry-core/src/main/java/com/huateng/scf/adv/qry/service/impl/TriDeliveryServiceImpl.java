package com.huateng.scf.adv.qry.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.huateng.scf.adv.qry.dao.ITriDeliveryInfoDAO;
import com.huateng.scf.adv.qry.service.ITriDeliveryService;
import com.huateng.scf.adv.tcs.dao.model.ThreeDeliveryVO;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
@ScubeService
@Service("TriDeliveryServiceImpl")
public class TriDeliveryServiceImpl implements ITriDeliveryService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = ITriDeliveryService.BEAN_ID)
	ITriDeliveryService triDeliveryService; 
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@Resource(name = "TriDeliveryInfoDAO")
	private ITriDeliveryInfoDAO triDeliveryInfoDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public Page queryTriDeliveryByPage(int pageNo, int pageSize, Map<String, Object> param) throws ScubeBizException {
		log.info("提货台帐查询");
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
		param.put("arrBr", arrBr);
		
		triDeliveryInfoDAO.selectByPage(param, page);
		List<Map<String,Object>> list = page.getRecords();
		List<ThreeDeliveryVO> response = new ArrayList<ThreeDeliveryVO>();
		if(list!=null&&list.size()>0){
			Iterator<?> iter=list.iterator();
			while(iter.hasNext()){
				ThreeDeliveryVO deliveryVO = new ThreeDeliveryVO();
				Map<String,Object> temp = (Map<String,Object>) iter.next();
				deliveryVO.setCustcd(temp.get("CUSTCD").toString());
				deliveryVO.setCoreCustcd(temp.get("CORECUSTCD").toString());
				deliveryVO.setFouCd(temp.get("FOUCD").toString());
				deliveryVO.setFirstBailRatio(null==temp.get("FIRST_BAIL_RATIO")?BigDecimal.ZERO:new BigDecimal(temp.get("FIRST_BAIL_RATIO").toString()));
				deliveryVO.setStartDate(temp.get("START_DATE").toString());
				deliveryVO.setEndDate(temp.get("END_DATE").toString());
				String slaveLimit = temp.get("SLAVE_LIMIT").toString();
				if(!StringUtils.isEmpty(deliveryVO.getStartDate())){
					Date limitDate =getEndDateByDays(deliveryVO.getStartDate(), Integer.valueOf(slaveLimit)); 
					deliveryVO.setLimitDate(limitDate.toString());
				}
				deliveryVO.setLnciAmt(null==temp.get("LNCI_AMT")?BigDecimal.ZERO:new BigDecimal(temp.get("LNCI_AMT").toString()));
				deliveryVO.setOpenAmount(null==temp.get("RISK_AMT")?BigDecimal.ZERO:new BigDecimal(temp.get("RISK_AMT").toString()));
				deliveryVO.setCurrDeliveryAmt(null==temp.get("COMMON_AMT")?BigDecimal.ZERO:new BigDecimal(temp.get("COMMON_AMT").toString()));
				deliveryVO.setDebetId(temp.get("DEBET_ID").toString());
				deliveryVO.setInsertDate(temp.get("INSERT_DATE").toString());
				deliveryVO.setMastContno(temp.get("MAST_CONTCODE").toString());
				deliveryVO.setProductName(temp.get("PRODUCT_NAME").toString());
				deliveryVO.setMgrno(temp.get("MGRNO").toString());
				deliveryVO.setBrcode(temp.get("BRCODE").toString());
				
				if(StringUtil.isStrNotEmpty(temp.get("BRCODE").toString())){
					BctlVO bctl = scubeUserService.selectBctlByBrNo(temp.get("BRCODE").toString(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					if(null!=bctl){
						deliveryVO.setBrcodeName(bctl.getBrName());
					}
				}
				if(StringUtil.isStrNotEmpty(temp.get("MGRNO").toString())){
					UserInfo userInfo = scubeUserService.selectUserByTlrNo(temp.get("MGRNO").toString(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					if(null!=userInfo){
						deliveryVO.setTlrName(userInfo.getTlrName());
					}
				}
				response.add(deliveryVO);
			}
		}
		
		page.setRecords(response);
		return page;
	}
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
}
