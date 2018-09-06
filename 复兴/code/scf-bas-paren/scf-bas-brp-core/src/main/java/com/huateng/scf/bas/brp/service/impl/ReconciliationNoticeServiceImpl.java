package com.huateng.scf.bas.brp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huateng.scf.adv.bcp.dao.IABcpMoreDvyChkStockDtlDAO;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStockDtl;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.IBNteNoticeLnciDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeLnci;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * <p>
 * 担保提货发货通知书
 * </p>
 * 
 * @author zhangcheng
 * @date 2017年2月26日上午11:38:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * 
 *            </pre>
 */
@ScubeService
@Service("ReconciliationNoticeServiceImpl")
public class ReconciliationNoticeServiceImpl implements INoticeExportReportService {
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	@Resource(name = "ABcpMoreDvyChkStockDtlDAO")
	IABcpMoreDvyChkStockDtlDAO aBcpMoreDvyChkStockDtlDAO;
	@Resource(name = "BNteNoticeLnciDAO")
	IBNteNoticeLnciDAO bNteNoticeLnciDAO;
	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException {
		
	    String id=params.get("id");
			
	    Map<String, Object> showValues = new HashMap<String, Object>();
		BNteNoticeBase notice=bNteNoticeBaseDAO.selectByPrimaryKey(id);
		if(notice!=null){	
			showValues.put("num",notice.getNum()==null?"":notice.getNum());
			//卖方（上游客户）
			showValues.put("coreName",notice.getOtherCustName()==null?"":notice.getOtherCustName());
			//协议编号 protocolCode
			showValues.put("protocolCode", notice.getProtocolCode()==null?"":notice.getProtocolCode());
			//截止日期
			showValues.put("year",notice.getSignDate()!=null&&!"".equals(notice.getSignDate())?notice.getSignDate().substring(0,4):"");//Parameter38  	(38)
			showValues.put("month",notice.getSignDate()!=null&&!"".equals(notice.getSignDate())?notice.getSignDate().substring(4,6):"");//Parameter38  	(38)
			showValues.put("day",notice.getSignDate()!=null&&!"".equals(notice.getSignDate())?notice.getSignDate().substring(6):"");//
			//借据总金额
			showValues.put("totalAmount", notice.getCommonAmt()==null?"":notice.getCommonAmt().divide(new BigDecimal(10000)));
			//商承保贴函张数(暂时不做)
			//商承保贴函金额(暂时不做)
			//买方（授信客户）
			showValues.put("custname", notice.getCustName()==null?"":notice.getCustName());
		}else{
			showValues.put("coreName","");
			showValues.put("protocolCode","");
			showValues.put("totalAmount","");
			showValues.put("custname","");
			showValues.put("year","");
			showValues.put("month","");
			showValues.put("day","");
		}
			return showValues;
	
	}

	@Override
	public Collection<?> getIterativeData(Map<String, String> params) throws ScubeBizException {
		 Map map=new HashMap();
         List list=new ArrayList();
 	     String appno=params.get("appno");
 	     List<ABcpMoreDvyChkStockDtl> stockDtlList=aBcpMoreDvyChkStockDtlDAO.selectUninByStock(appno);
         if(stockDtlList!=null){
        	 for(ABcpMoreDvyChkStockDtl dtl:stockDtlList){
        		  List<BNteNoticeLnci> noticeList=bNteNoticeLnciDAO.selectByDebetNo(dtl.getDebetNo()!=null?dtl.getDebetNo():"null");
                  if(noticeList!=null) {
                	  BNteNoticeLnci noticeLnci=noticeList.get(0);  
          			  BigDecimal quantity=noticeLnci.getDeliveryQuantity()==null?BigDecimal.ZERO:noticeLnci.getDeliveryQuantity();
                	  map.put("StartDateStr",ScfDateUtil.numberToDate(noticeLnci.getStartDate()));
                	  map.put("DebetId",noticeLnci.getDebetId()!=null?noticeLnci.getDebetId():"");
                	  map.put("QuantityCount",quantity);
                	  map.put("BalanceAccount",noticeLnci.getDeliveryValue()!=null?noticeLnci.getDeliveryValue():new BigDecimal(0));
                  } else{
                	  map.put("StartDateStr",null);
            		  map.put("DebetId","");
            		  map.put("QuantityCount",new BigDecimal(0));
            		  map.put("BalanceAccount",new BigDecimal(0));
                  }
                  list.add(map);
        	 }
         }else{
        	 map.put("StartDateStr","");
   		     map.put("DebetId","");
   		     map.put("QuantityCount","");
   		     map.put("BalanceAccount","");
   		     list.add(map);
         }   
 	   
        
         return list;
	}

	@Override
	public List<Map<String, Object>> getContentMapMultiRecord(Map<String, String> params) throws ScubeBizException {
		return null;

	}

}
