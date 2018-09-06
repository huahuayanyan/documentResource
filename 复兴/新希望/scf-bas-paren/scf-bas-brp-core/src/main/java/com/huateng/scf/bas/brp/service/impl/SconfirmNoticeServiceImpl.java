package com.huateng.scf.bas.brp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.UserService;
import com.huateng.scf.bas.cnt.dao.IBCntBuyInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBillDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBill;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * <p>
 * 担保提货收款确认银承通知书
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
@Service("SconfirmNoticeServiceImpl")
public class SconfirmNoticeServiceImpl implements INoticeExportReportService {
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	@Resource(name = "BNteNoticeBillDAO")
	IBNteNoticeBillDAO bNteNoticeBillDAO;
	@Resource(name = "BCntBuyInfoDAO")
	IBCntBuyInfoDAO IBCntBuyInfoDAO;
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@Resource(name = "userService")
	UserService userService;
	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException {
        String id=params.get("id");
		String tadeNoStr="";
		Map<String, Object> showValues = new HashMap<String, Object>();
		BNteNoticeBase notice=bNteNoticeBaseDAO.selectByPrimaryKey(id);
		if(notice!=null){
			if(notice.getCustcd()!=null&&!"".equals(notice.getCustcd())){
				BCrmBaseInfo base=iBCrmBaseInfoDAO.selectById(notice.getCustcd());
				showValues.put("cname",base.getCname());//Parameter36  	(36)
			}else{
				showValues.put("cname","");

			}
			if(notice.getBrcode()!=null&&!"".equals(notice.getBrcode())){
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(notice.getBrcode(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));

				if(bctlVO!=null){
				  showValues.put("brname",bctlVO.getBrName());
	
			}else{
				  showValues.put("brname","");

			}
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
		
		    showValues.put("slaveContcode",tadeNoStr);
			showValues.put("num", notice.getNum()==null?"":notice.getNum());
			showValues.put("protocolCode", notice.getProtocolCode()==null?"":notice.getProtocolCode());
			showValues.put("tradeContno", notice.getTradeContno()==null?"":notice.getTradeContno());
//			map.put(NoticeConstants.MSRNO, vo.getMsrno()==null?"":vo.getMsrno());
			showValues.put("billNum", notice.getCommonNum()==null?"":notice.getCommonNum());
			showValues.put("moniOfName", notice.getMoniOfName()==null?"":notice.getMoniOfName());
			if(notice.getCommonAmt()!=null){
			 	BigDecimal milMoney = notice.getCommonAmt().divide(new BigDecimal(10000));
			 	showValues.put("money", milMoney);
			}else {
				showValues.put("money", "");
			}
			
			List lsit=bNteNoticeBillDAO.findBNteNoticeBillByAppno(notice.getAppno());
			BigDecimal amout=new BigDecimal(0);
			if(lsit!=null&&lsit.size()>0){
				for(int i=0;i<lsit.size();i++){
				BNteNoticeBill bill=(BNteNoticeBill)lsit.get(i);
				amout=amout.add(bill.getAmount());
				}
			}
			showValues.put("amount",amout);
			//TODO: 追加上游客户名称、主合同编号的通知书常量
			showValues.put("custname",notice.getCustName()==null?"":notice.getCustName());
			showValues.put("mastContcode",notice.getMastContcode()==null?"":notice.getMastContcode());
			//showValues.put("slaveContcode", notice.getSlaveContcode()==null?"":notice.getSlaveContcode());

		}else{
		showValues.put("num","");
		showValues.put("brname","");
		showValues.put("protocolCode","");
		
		showValues.put("money","");
		showValues.put("custname","");
		showValues.put("billNum","");
		showValues.put("slaveContcode","");
		}
		return showValues;
	}

	@Override
	public Collection<?> getIterativeData(Map<String, String> params) throws ScubeBizException {
	      String appno=params.get("appno");
	      Map map=new HashMap();
          List list=new ArrayList();
		  List lsit=bNteNoticeBillDAO.findBNteNoticeBillByAppno(appno);
		  if(lsit!=null&&lsit.size()>0){
				for(int i=0;i<lsit.size();i++){
				BNteNoticeBill bill=(BNteNoticeBill)lsit.get(i);
				  map.put("Drawer",bill.getDrawer());
				  map.put("Payee",bill.getPayee());
				  map.put("BillNo",bill.getBillNo());
				  map.put("Amount",bill.getAmount());
				  map.put("BillDate",bill.getBillDate());
				  map.put("BillEndDate",bill.getBillEndDate());
		          list.add(map);
				}
			}else{
				  map.put("Drawer","");
				  map.put("Payee","");
				  map.put("BillNo","");
				  map.put("Amount","");
				  map.put("BillDate",null);
				  map.put("BillEndDate",null);
		          list.add(map);

			}

          return list;
	}

	@Override
	public List<Map<String, Object>> getContentMapMultiRecord(Map<String, String> params) throws ScubeBizException {
		return null;
	}

}
