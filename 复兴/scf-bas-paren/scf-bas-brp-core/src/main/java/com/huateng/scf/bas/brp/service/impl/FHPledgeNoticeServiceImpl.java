package com.huateng.scf.bas.brp.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.IBNteNoticeMtgDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * <p>
 * 先票/款后货查询及出质通知书
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
@Service("FHPledgeNoticeServiceImpl")
public class FHPledgeNoticeServiceImpl implements INoticeExportReportService {
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	@Resource(name = "BCntMprotPartInfoDAO")
	IBCntMprotPartInfoDAO bCntMprotPartInfoDAO;
	@Resource(name = "BNteNoticeMtgDAO")
	IBNteNoticeMtgDAO iBNteNoticeMtgDAO;
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException {
		
		String id=params.get("id");
		
		Map<String, Object> showValues = new HashMap<String, Object>();
		BNteNoticeBase notice=bNteNoticeBaseDAO.selectByPrimaryKey(id);
		if(notice!=null){
			 Map map=new HashMap();
			 map.put("protocolNo",notice.getProtocolNo());
			 map.put("role","02");
			List list= bCntMprotPartInfoDAO.selectByRole(map);
			if(list!=null&&list.size()>0){
				BCntMprotPartInfo mort=(BCntMprotPartInfo)list.get(0);
				showValues.put("thrName",mort.getCname()!=null?mort.getCname():"");
			}else{
				showValues.put("thrName","");

			}
			if(notice.getBrcode()!=null&&!"".equals(notice.getBrcode())){
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(notice.getBrcode(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));

				if(bctlVO!=null)
				  showValues.put("firName",bctlVO.getBrName());
			}else{
				  showValues.put("firName","");

			}
			showValues.put("num",notice.getNum()!=null?notice.getNum():"");
			showValues.put("protocolNo",notice.getProtocolNo()!=null?notice.getProtocolNo():"");
			
		}else{
			showValues.put("thrName","");
			showValues.put("firName","");
			showValues.put("num","");
			showValues.put("protocolNo","");

		}
		
		
		return showValues;
	}

	@Override
	public Collection<?> getIterativeData(Map<String, String> params) throws ScubeBizException {
		  String id=params.get("id");
		  List list=new ArrayList();
		  Map map=new HashMap();
		  List mtgList=iBNteNoticeMtgDAO.selectByPid(id);
		  if(mtgList!=null&&mtgList.size()>0){
			  for(int i=0;i<mtgList.size();i++){
				  BNteNoticeMtg mtg=(BNteNoticeMtg)mtgList.get(i);  
				  map.put("MortgageName",mtg.getMortgageName()!=null?mtg.getMortgageName():"");
				  map.put("MortgageModel",mtg.getMortgageModel()!=null?mtg.getMortgageModel():"");
				  map.put("Quantity",mtg.getQuantity()!=null?mtg.getQuantity().toString():"");
				  map.put("Freightarea",mtg.getManufacturer()!=null?mtg.getManufacturer():"");
				  map.put("BillNo",mtg.getDocumentNo()!=null?mtg.getDocumentNo():"");
				  map.put("ConfirmPrice",mtg.getConfirmPrice()!=null?mtg.getConfirmPrice():null);
		          list.add(map);
			  }
		 }else{
			      map.put("MortgageName","");
			      map.put("MortgageModel","");
			      map.put("Quantity","");
			      map.put("Freightarea","");
			      map.put("BillNo","");
			      map.put("ConfirmPrice",null);
			      list.add(map);
 
		 }
		    	
          return list;
	}

	@Override
	public List<Map<String, Object>> getContentMapMultiRecord(Map<String, String> params) throws ScubeBizException {
		return null;
	}

}
