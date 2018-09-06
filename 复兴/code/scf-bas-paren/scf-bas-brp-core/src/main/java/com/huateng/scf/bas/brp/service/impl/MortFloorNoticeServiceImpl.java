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
import com.huateng.scf.bas.bcp.dao.ISBcpAppliLowerPriceDAO;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPrice;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * <p>
 * 质物最低要求通知书
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
@Service("MortFloorNoticeServiceImpl")

public class MortFloorNoticeServiceImpl implements INoticeExportReportService {
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	@Resource(name = "SBcpAppliLowerPriceDAO")
	ISBcpAppliLowerPriceDAO sBcpAppliLowerPriceDAO;
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	
	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException {
		String id=params.get("id");
	
		Map<String, Object> showValues = new HashMap<String, Object>();
		BNteNoticeBase notice=bNteNoticeBaseDAO.selectByPrimaryKey(id);
		if(notice!=null){
			if(notice.getCustcd()!=null&&!"".equals(notice.getCustcd())){
				BCrmBaseInfo base=iBCrmBaseInfoDAO.selectById(notice.getCustcd());
				showValues.put("cname",base.getCname());//Parameter36  	(36)
			}else{
				showValues.put("cname","");

			}
			if(notice.getMoniOfCustcd()!=null&&!"".equals(notice.getMoniOfCustcd())){
				BCrmBaseInfo base=iBCrmBaseInfoDAO.selectById(notice.getMoniOfCustcd());
				showValues.put("moniOfName",base.getCname());//Parameter36  	(36)
			}else{
				showValues.put("moniOfName","");

			}
			if(notice.getBrcode()!=null&&!"".equals(notice.getBrcode())){
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(notice.getBrcode(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));

				if(bctlVO!=null)
				  showValues.put("brcodeNm",bctlVO.getBrName());
			}else{
				  showValues.put("brcodeNm","");

			}
			showValues.put("num",notice.getNum()!=null?notice.getNum():"");//Parameter35  	(35)
			//showValues.put("moniOfName",notice.getMoniOfName()!=null?notice.getMoniOfName():"");//Parameter36  	(36)
			//showValues.put("cname",notice.getCustName()!=null?notice.getCustName():"");
			
			showValues.put("pledgeeDate_Y",notice.getSignDate()!=null&&!"".equals(notice.getSignDate())?notice.getSignDate().substring(0,4):"");//Parameter38  	(38)
			showValues.put("pledgeeDate_M",notice.getSignDate()!=null&&!"".equals(notice.getSignDate())?notice.getSignDate().substring(4,6):"");//Parameter38  	(38)
			showValues.put("pledgeeDate_D",notice.getSignDate()!=null&&!"".equals(notice.getSignDate())?notice.getSignDate().substring(6):"");//Parameter38  	(38)
			//showValues.put("brcodeNm",notice.getTlrn()!=null?notice.getTlrn():"");//Parameter38  	(38)
		}else{
			showValues.put("num","");//Parameter35  	(35)
			showValues.put("moniOfName","");//Parameter36  	(36)
			showValues.put("cname","");
			
			showValues.put("pledgeeDate_Y","");//Parameter38  	(38)
			showValues.put("pledgeeDate_M","");//Parameter38  	(38)
			showValues.put("pledgeeDate_D","");//Parameter38  	(38)
			showValues.put("brcodeNm","");//Parameter38  	(38)
		}
		
		
		return showValues;
	}

	@Override
	public Collection<?> getIterativeData(Map<String, String> params) throws ScubeBizException {
		String appno=params.get("appno");
		Map<String, Object> showValues = new HashMap<String, Object>();
		List priceList=sBcpAppliLowerPriceDAO.selectByAppno(appno);
	    Map map=new HashMap();
        List list=new ArrayList();
		if(priceList!=null&&priceList.size()>0){
			SBcpAppliLowerPrice prce=(SBcpAppliLowerPrice)priceList.get(0);
		    map.put("protLowPric",prce.getLowPriceNew());//Parameter38  	(38)
		}else{
		    map.put("protLowPric",null);//Parameter38  	(38)

		}
	      list.add(map);
          return list;
	}

	@Override
	public List<Map<String, Object>> getContentMapMultiRecord(Map<String, String> params) throws ScubeBizException {
		return null;
	}

}
