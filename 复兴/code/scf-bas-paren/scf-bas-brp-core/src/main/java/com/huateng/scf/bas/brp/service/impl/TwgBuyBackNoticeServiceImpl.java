package com.huateng.scf.bas.brp.service.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.scf.bas.cnt.dao.IBCntBuyInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * <p>
 * 担保提货差额退款通知书
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
@Service("TwgBuyBackNoticeServiceImpl")
public class TwgBuyBackNoticeServiceImpl implements INoticeExportReportService {
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	@Resource(name = "BCntMprotPartInfoDAO")
	IBCntMprotPartInfoDAO bCntMprotPartInfoDAO;
	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO iBCntMprotBaseInfoDAO;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO bLanAppliLnciBaseDAO;
	@Resource(name = "BCntBuyInfoDAO")
	IBCntBuyInfoDAO IBCntBuyInfoDAO;
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException {
		
		String id=params.get("id");
		String appno=params.get("appno");
		String custName="";
		String coreName="";
		String protocolCode="";
		String tadeNoStr="";
		Map<String, Object> showValues = new HashMap<String, Object>();
		BNteNoticeBase notice=bNteNoticeBaseDAO.selectByPrimaryKey(id);
		if(notice!=null){
			if(notice.getCustcd()!=null&&!"".equals(notice.getCustcd())){
				BCrmBaseInfo base=iBCrmBaseInfoDAO.selectById(notice.getCustcd());
				custName=base.getCname();
			}
			if(notice.getProtocolNo()!=null&&!"".equals(notice.getProtocolNo())){
				if("71".equals(notice.getNoticeType())){// 核心企业
					Map map=new HashMap();
					map.put("protocolNo", notice.getProtocolNo());
					map.put("role", "04");
				    List mortList=bCntMprotPartInfoDAO.selectByRole(map);
				    if(mortList!=null&&mortList.size()>0){
						BCntMprotPartInfo mort=(BCntMprotPartInfo)mortList.get(0);
						BCrmBaseInfo base=iBCrmBaseInfoDAO.selectById(mort.getCustcd());
						if(base!=null){
							coreName=base.getCname();
						}

				    }
				}
				if("87".equals(notice.getNoticeType())){// 回购厂商
					Map map=new HashMap();
					map.put("protocolNo", notice.getProtocolNo());
					map.put("role", "05");
				    List mortList=bCntMprotPartInfoDAO.selectByRole(map);
				    if(mortList!=null&&mortList.size()>0){
						BCntMprotPartInfo mort=(BCntMprotPartInfo)mortList.get(0);
						BCrmBaseInfo base=iBCrmBaseInfoDAO.selectById(mort.getCustcd());
						if(base!=null){
							coreName=base.getCname();
						}

				    }
				}
				 BCntMprotBaseInfo muit=iBCntMprotBaseInfoDAO.selectByPrimaryKey(notice.getProtocolNo());
			   	 if(muit!=null){
					 protocolCode=muit.getProtocolCode();
			   	 }
				//协议下的购销合同
				 List<BCntBuyInfo> buyList=IBCntBuyInfoDAO.selectByProtocolNo(notice.getProtocolNo());
				 for(BCntBuyInfo t:buyList){
					 String tradeContcode=t.getTradeContcode()==null?"":t.getTradeContcode();
					 if(tadeNoStr.length()>0){
						 tadeNoStr=tadeNoStr+","+tradeContcode;
					 }else{
						 tadeNoStr+=tradeContcode;
					 }
				 }
			}
			
			 showValues.put("tradeContno",tadeNoStr);
			 showValues.put("num",notice.getNum()!=null?notice.getNum():"");//编号
			 showValues.put("cname",coreName);
			 showValues.put("protocolCode",protocolCode);
			 showValues.put("amt",notice.getCommonAmt()!=null?notice.getCommonAmt().divide(new BigDecimal(10000)):"");
			 showValues.put("custname",custName);
			 if(notice.getBrcode()!=null&&!"".equals(notice.getBrcode())){
					BctlVO bctlVO = scubeUserService.selectBctlByBrNo(notice.getBrcode(),
							ScfCommonUtil.getBrManagerNo(scubeUserService));

					if(bctlVO!=null)
					  showValues.put("brcodeNm",bctlVO.getBrName());
				}else{
					  showValues.put("brcodeNm","");

				}
				 
			 //计算日期 取借据最晚的出账日期及最早的到期日
			 BigDecimal lnciAmtSum=BigDecimal.ZERO;//借据总金额
			 String lnciStartDate="";//开始日期
			 String lnciEndDate="";//结束日期
			List<BLanAppliLnciBase> lncibase=bLanAppliLnciBaseDAO.selectByAppNo(appno);
			if(lncibase!=null&&lncibase.size()>0){
				for(BLanAppliLnciBase lnci:lncibase){
					BigDecimal lnciAmt=lnci.getLnciAmt()==null?BigDecimal.ZERO:lnci.getLnciAmt();
					lnciAmtSum=lnciAmtSum.add(lnciAmt);
					lnciStartDate=lnci.getStartDate();
					lnciEndDate=lnci.getEndDate();
					
				 }
			}
		showValues.put("pledgeeDate_Y",lnciStartDate!=null&&!"".equals(lnciStartDate)?lnciStartDate.substring(0,4):"");//Parameter38  	(38)
		showValues.put("pledgeeDate_M",lnciStartDate!=null&&!"".equals(lnciStartDate)?lnciStartDate.substring(4,6):"");//Parameter38  	(38)
		showValues.put("pledgeeDate_D",lnciStartDate!=null&&!"".equals(lnciStartDate)?lnciStartDate.substring(6):"");//
		showValues.put("year",lnciEndDate!=null&&!"".equals(lnciEndDate)?lnciEndDate.substring(0,4):"");//Parameter38  	(38)
		showValues.put("month",lnciEndDate!=null&&!"".equals(lnciEndDate)?lnciEndDate.substring(4,6):"");//Parameter38  	(38)
		showValues.put("day",lnciEndDate!=null&&!"".equals(lnciEndDate)?lnciEndDate.substring(6):"");//
		showValues.put("lnciAmt",lnciAmtSum==null?"":lnciAmtSum.divide(new BigDecimal(10000)));
		showValues.put("totalTotalAmt",notice.getExt1Amount()==null?"":ScfCommonUtil.currencyToChineseCurrency(notice.getExt1Amount().toEngineeringString()));
		showValues.put("totalCostAmt",notice.getExt2Amount()==null?"":ScfCommonUtil.currencyToChineseCurrency(notice.getExt2Amount().toString()));
		}else{
			showValues.put("num","");//Parameter35  	(35)
			showValues.put("cname","");//Parameter36  	(36)
			showValues.put("protocolCode","");
			showValues.put("pledgeeDate_Y","");//Parameter38  	(38)
			showValues.put("pledgeeDate_M","");//Parameter38  	(38)
			showValues.put("pledgeeDate_D","");//Parameter38  	(38)
			showValues.put("lnciAmt",new BigDecimal(0));//Parameter38  	(38)
			showValues.put("custname","");//Parameter38  	(38)
			showValues.put("tradeContno","");//Parameter38  	(38)
			showValues.put("year","");//Parameter38  	(38)
			showValues.put("month","");//Parameter38  	(38)
			showValues.put("day","");//Parameter38  	(38)
			showValues.put("totalTotalAmt","");//Parameter38  	(38)
			showValues.put("totalCostAmt","");//Parameter38  	(38)
			showValues.put("amt","");//Parameter38  	(38)
			showValues.put("brcodeNm","");//Parameter38  	(38)
			}
		
		
		return showValues;
	}

	@Override
	public Collection<?> getIterativeData(Map<String, String> params) throws ScubeBizException {
		return null;
		 
	}

	@Override
	public List<Map<String, Object>> getContentMapMultiRecord(Map<String, String> params) throws ScubeBizException {
		return null;
	}

}
