package com.huateng.scf.bas.com.service.impl;

import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.ICreditServiceService;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>额度业务</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月30日下午1:42:41
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月30日下午1:42:41	     新增
 *
 * </pre>
 */
@ScubeService
@Service("CreditServiceServiceImpl")
public class CreditServiceServiceImpl implements ICreditServiceService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;
	
	/**
	 * 连表查询额度信息 
	 * @param creditQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午1:43:58
	 */
	@Override
	public Page getTblCreditInfoByCreditQryVO(CreditQryVO creditQryVO)throws ScubeBizException
	{
		log.debug("getTblCreditInfoByCreditQryVO==========================start");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(!StringUtil.isEmpty(creditQryVO.getCreditClass_Q()))
		{
			omap.put("creditClass", creditQryVO.getCreditClass_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getNodeType_Q()))
		{
			omap.put("nodeType", creditQryVO.getNodeType_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getCreditType_Q()))
		{
			omap.put("creditType", creditQryVO.getCreditType_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getCreditNo_Q()))
		{
			omap.put("creditNo", creditQryVO.getCreditNo_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getCustcd()))
		{
			omap.put("custcd", creditQryVO.getCustcd());
		}
		if(!StringUtil.isEmpty(creditQryVO.getOtherCustcd_Q()))
		{
			omap.put("otherCustcd", creditQryVO.getOtherCustcd_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getStatus_Q()))
		{
			omap.put("status", creditQryVO.getStatus_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getBusinessNo_Q()))
		{
			omap.put("businessNo", creditQryVO.getBusinessNo_Q());
		}
		if(ScfBasConstant.FLAG_ON.equalsIgnoreCase(creditQryVO.getFlag()))
		{//是否查询当前日期有效协议
			omap.put("date", ScfDateUtil.getStringDate(new Date()));
		}
		Page page = new Page();
		if(creditQryVO.isPageFlag())
		{
			int total = extnrecbcpdao.countTblCreditInfoByCreditQryVO(omap);
			page = new Page(creditQryVO.getPageSize(), creditQryVO.getPageIndex(), total);
		}
		page.setRecords(extnrecbcpdao.getTblCreditInfoByCreditQryVO(omap,page,creditQryVO.isPageFlag()));
		return page;
	}
	
	/**
	 * 
	 * @Description: 间接额度台账查询
	 * @author wenkui.xu
	 * @Created 2013-8-14下午5:11:10
	 * @param creditQryVO
	 * @return
	 * @throws CommonException
	 */
//	public PageQueryResult getIndirectCreditMultiQuery(CreditQryVO creditQryVO) throws CommonException{
//		List<Object>parmList=new ArrayList<Object>();
//		StringBuffer sb=new StringBuffer();
//		sb.append(" select tlbi.debetId,tci.custcd,tci.otherCustcd,tlbi.productId,tlbi.lnciType,tlbi.startDate,tlbi.lnciAmt,tlbi.endDate,tci.creditType,tcd.operType,tcd.usedAmount,tcd.txdate,tlbi.mgrno,tlbi.bussBrcode from TblCreditDetail tcd,TblCreditInfo tci,TblLnciBaseInfo tlbi ");
//		sb.append(" where (tcd.businessno=tlbi.debetNo or tcd.businessno=tlbi.debetId) and tci.creditNo=tcd.creditNo ");
//		if(!SCFDataFormat.isEmpty(creditQryVO.getCreditClass_Q())){
//			sb.append(" and tci.creditClass=? ");
//			parmList.add(creditQryVO.getCreditClass_Q());
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getNodeType_Q())){
//			sb.append(" and tci.nodeType=? ");
//			parmList.add(creditQryVO.getNodeType_Q());
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getCname_Q())){
//			sb.append(" and tci.custcd is not null and tci.custcd in  ");
//			sb.append(" (select tcbi.custcd from TblCustBaseInfo tcbi  where tcbi.cname like ?)  ");
//			parmList.add("%"+creditQryVO.getCname_Q()+"%");
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getCreditType_Q())){
//			sb.append(" and tci.creditType=? ");
//			parmList.add(creditQryVO.getCreditType_Q());
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getOtherCustName_Q())){
//			sb.append(" and tci.otherCustcd is not null and tci.otherCustcd in  ");
//			sb.append(" (select tcbi.custcd from TblCustBaseInfo tcbi where tcbi.cname like ?)  ");
//			parmList.add("%"+creditQryVO.getOtherCustName_Q()+"%");
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getProductId_Q())){
//			sb.append(" and tlbi.productId =?  ");
//			parmList.add(creditQryVO.getProductId_Q());
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getLoanDate_from_Q())){
//			sb.append(" and tlbi.insertDate >=to_date(?,'YYYY-MM-DD')  ");
//			parmList.add(creditQryVO.getLoanDate_from_Q());
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getLoanDate_to_Q())){
//			sb.append(" and tlbi.insertDate <=to_date(?,'YYYY-MM-DD')  ");
//			parmList.add(creditQryVO.getLoanDate_to_Q());
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getReturnDate_from_Q())){
//			sb.append(" and tcd.txdate >=to_date(?,'YYYY-MM-DD')  ");
//			parmList.add(creditQryVO.getReturnDate_from_Q());
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getReturnDate_to_Q())){
//			sb.append(" and tcd.txdate <=to_date(?,'YYYY-MM-DD')  ");
//			parmList.add(creditQryVO.getReturnDate_to_Q());
//		}
//		GlobalData gd = SCFCommonFunctions.getGlobalData();
//
//		Vector roleList = gd.getUserRoles();
//		
//		String roleFlag = "0"; //岗位标志，默认为0
//		if (roleList != null && roleList.size() == 1){ //只有一个客户经理岗，客户经理只能查到自己的
//			if (SCFConstants.ROLE_ID_MANAGER.equals(roleList.get(0).toString())){
//				roleFlag = "1";
//			}
//		}
//		if (roleFlag.equals("1")){
//			sb.append(" and tlbi.mgrno = ? ");
//			parmList.add(gd.getTlrno());
//		}else{
//			sb.append(BctlService.getInstance().getBctlQueryCondition("tlbi.bussBrcode", SCFConstants.QUERY_TYPE_ALL, gd.getBrcode()));
//		}
//		
//		return commonPageQuery(sb.toString(), parmList, creditQryVO.getPageIndex(), creditQryVO.getPageSize());
//	}
	
	
	/**
	 * 
	 * @Description: 查询间接额度流水信息
	 * @author michael.xu
	 * @Created 2013-8-30下午5:35:43
	 * @param creditQryVO
	 * @return
	 * @throws CommonException
	 */
//	public PageQueryResult getIndirectCreditFlowInfo(CreditQryVO creditQryVO)throws CommonException {
//		List<Object>paramList=new ArrayList<Object>();
//		StringBuffer sb=new StringBuffer();
//		sb.append(" select tcd,tci from TblCreditDetail tcd,TblCreditInfo tci ");
//		sb.append(" where tci.creditNo=tcd.creditNo and tcd.operType!='"+ SCFConstants.CREDIT_TRADE_TYPE_INPUT+"'");
//		if(!SCFDataFormat.isEmpty(creditQryVO.getCreditClass_Q())){
//			sb.append(" and tci.creditClass=? ");
//			paramList.add(creditQryVO.getCreditClass_Q());
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getNodeType_Q())){
//			sb.append(" and tci.nodeType=? ");
//			paramList.add(creditQryVO.getNodeType_Q());
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getCname_Q())){
//			sb.append(" and tci.custcd is not null and tci.custcd in  ");
//			sb.append(" (select tcbi.custcd from TblCustBaseInfo tcbi  where tcbi.cname like ?)  ");
//			paramList.add("%"+creditQryVO.getCname_Q()+"%");
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getCreditType_Q())){
//			sb.append(" and tci.creditType=? ");
//			paramList.add(creditQryVO.getCreditType_Q());
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getOtherCustName_Q())){
//			sb.append(" and tci.otherCustcd is not null and tci.otherCustcd in  ");
//			sb.append(" (select tcbi.custcd from TblCustBaseInfo tcbi where tcbi.cname like ?)  ");
//			paramList.add("%"+creditQryVO.getOtherCustName_Q()+"%");
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getStartDate_Q())){
//			sb.append(" and tcd.lastUpdateDate >=?  ");
//			paramList.add(new java.sql.Date(SCFDateUtil.stringToDate(creditQryVO.getStartDate_Q()).getTime()));
//		}
//		if(!SCFDataFormat.isEmpty(creditQryVO.getEndDate_Q())){
//			sb.append(" and tcd.lastUpdateDate <=?  ");
//			paramList.add(new java.sql.Date(SCFDateUtil.stringToDate(creditQryVO.getEndDate_Q()).getTime()));
//		}
//		sb.append(" order by tcd.lastUpdateDate desc");
//		return commonPageQuery(sb.toString(), paramList, creditQryVO.getPageIndex(), creditQryVO.getPageSize());
//	}
}
