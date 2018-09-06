package com.huateng.scf.sto.nwr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.service.IAdjustPriceBillService;
import com.huateng.scf.sto.nwr.service.ISBcpMortBillNormalService;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
@ScubeService
@Service("AdjustPriceBillServiceImpl")
public class AdjustPriceBillServiceImpl implements IAdjustPriceBillService {

	@Resource(name="SBcpMortBillNormalServiceImpl")
	ISBcpMortBillNormalService iSBcpMortBillNormalService;
	
	@Resource(name="BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService iBPbcMtgBaseInfoService;
	
	@SuppressWarnings("unchecked")
	@Override
	public Page getBillnormalQueryPage(BillNormalMortgageQryVO mortgageQryVO) throws ScubeBizException {

		if(mortgageQryVO != null)
			mortgageQryVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
		Page page = iSBcpMortBillNormalService.queryMortgageBillNormal(mortgageQryVO);
		if(page != null){
			List list = page.getRecords();
			List listNew=new ArrayList();
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					BillNormalVO vo = new BillNormalVO();
					SBcpMortBillNormal bill=(SBcpMortBillNormal)list.get(i);
					String billno=bill.getBillno();
			         BeanUtils.copyProperties(bill, vo);
					List listReceiptPledge=iBPbcMtgBaseInfoService.getAppliReceiptPledgeAmountBybillno(billno);
					if(listReceiptPledge !=null && listReceiptPledge.size()>0 && listReceiptPledge.get(0)!=null){
						HashMap<String, Object > map = (HashMap<String, Object>) listReceiptPledge.get(0);
						vo.setWhReceiptValue( map==null?BigDecimal.ZERO:new BigDecimal(map.get("totPrice").toString()));
					}
					listNew.add(vo);
					page.setRecords(listNew);
				   }
				}
		}
		return page;
	}

}
