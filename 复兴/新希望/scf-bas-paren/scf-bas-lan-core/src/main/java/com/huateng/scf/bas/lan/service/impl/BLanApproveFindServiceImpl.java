package com.huateng.scf.bas.lan.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.lan.dao.IBLanAppliBillInfoDAO;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.model.BlanApproveDetail;
import com.huateng.scf.bas.lan.service.IBLanApproveFindService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>借据基本信息接口</p>
 *
 * @author 	liph
 * @date 	2016年12月14日.上午11:13:52
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月14日.上午11:13:52	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BLanApproveFindServiceImpl")
public class BLanApproveFindServiceImpl implements IBLanApproveFindService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO ibPbcAppliBaseInfoDAO;
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO ibPrdInfoDAO;
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO ibCrmBaseInfoDAO;
	@Resource(name = "BLanAppliBillInfoDAO")
	IBLanAppliBillInfoDAO ibLanAppliBillInfoDAO;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO ibLanLnciBaseDAO;
	
	//担保提货
	@SuppressWarnings("rawtypes")
	@Override
	public Page findAccountLoanApplyByPage(int pageNo, int pageSize, String cname, String mastContno, String debetId,
			String status) {	
		log.debug("担保提货放款审批查询");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cname", cname);
		map.put("mastContno", mastContno);
		map.put("debetId", debetId);
		map.put("status", status);
		map.put("proid", ScfBasConstant.PRODUCT_TYPE_SMALL_WH);
		map.put("processName", WorkflowConstant.PROCNAME_THREE_BILL_APPLY);
		Page page = new Page(pageSize, pageNo, 0);
		List<BPbcAppliBaseInfo> list = ibPbcAppliBaseInfoDAO.selectByProductId(map,page);//预付类
		List resultList = new ArrayList();
		if(list.size()>0||list!=null){
			for(int i=0;i<list.size();i++){
				BlanApproveDetail approveDetail = new BlanApproveDetail();
				BPbcAppliBaseInfo bPbcAppliBaseInfo = list.get(i);
				String appno = bPbcAppliBaseInfo.getAppno();
				approveDetail.setAppno(appno);
				approveDetail.setPiid(bPbcAppliBaseInfo.getPiid());
				BLanAppliLnciBase appliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
				if(appliLnciBase != null){
					//approveDetail.setDebetId(appliLnciBase.getDebetId());
					//借据编号从正式表取
					String debetNo = appliLnciBase.getDebetNo();
					BLanLnciBase bLanLnciBase = ibLanLnciBaseDAO.selectByPrimaryKey(debetNo);
					if(bLanLnciBase!=null){
						approveDetail.setDebetId(bLanLnciBase.getDebetId());
					}
				}
				approveDetail.setMastContno(bPbcAppliBaseInfo.getMastContcode());
				com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bPbcAppliBaseInfo.getMastContcode());
				if(bCrrLnCon != null){
					approveDetail.setVidNo(bCrrLnCon.getVidNo());
					approveDetail.setVidBusTyp(bCrrLnCon.getVidBusiTyp());
					approveDetail.setLnAmt(bCrrLnCon.getLnAmt());
					//TODO
					approveDetail.setLnSum(bCrrLnCon.getLnSum());
				}
				BCrmBaseInfo bCrmBaseInfo = ibCrmBaseInfoDAO.selectById(bPbcAppliBaseInfo.getCustcd());
				if(bCrmBaseInfo != null){
					approveDetail.setCustName(bCrmBaseInfo.getCname());
				}
				approveDetail.setExt1(bPbcAppliBaseInfo.getExt1());
				approveDetail.setAmt(bPbcAppliBaseInfo.getAmt());
				approveDetail.setStatus(bPbcAppliBaseInfo.getAppliStatusDtl());
				
				resultList.add(approveDetail);
			}
		}
		page.setRecords(resultList);
		return page;
	}
	//应收账款
	@Override
	public Page findInvoiceFinancingApply(int pageNo, int pageSize, String cname, String mastContno, String debetId,
			String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cname", cname);
		map.put("mastContno", mastContno);
		map.put("debetId", debetId);
		map.put("status", status);
		String [] types = {ScfBasConstant.PRODUCT_TYPE_GNFAC, ScfBasConstant.PRODUCT_TYPE_GNFXBL, ScfBasConstant.PRODUCT_TYPE_YSZKZY};
		map.put("proids", types);
		map.put("processName", WorkflowConstant.PROCNAME_INCOICE_FINANCING_APPLY);
		Page page = new Page(pageSize, pageNo, 0);
		List<BPbcAppliBaseInfo> list = ibPbcAppliBaseInfoDAO.selectByProductId(map,page);//应收类
		List resultList = new ArrayList();
		if(list.size()>0||list!=null){
			for(int i=0;i<list.size();i++){
				BlanApproveDetail approveDetail = new BlanApproveDetail();
				BPbcAppliBaseInfo bPbcAppliBaseInfo = list.get(i);
				String appno = bPbcAppliBaseInfo.getAppno();
				approveDetail.setAppno(appno);
				approveDetail.setPiid(bPbcAppliBaseInfo.getPiid());
				BLanAppliLnciBase appliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
				if(appliLnciBase != null){
					approveDetail.setDebetId(appliLnciBase.getDebetId());
				}
				approveDetail.setMastContno(bPbcAppliBaseInfo.getMastContcode());
				com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bPbcAppliBaseInfo.getMastContcode());
				if(bCrrLnCon != null){
					approveDetail.setVidNo(bCrrLnCon.getVidNo());
					approveDetail.setVidBusTyp(bCrrLnCon.getVidBusiTyp());
					approveDetail.setLnAmt(bCrrLnCon.getLnAmt());
					approveDetail.setLnSum(bCrrLnCon.getLnSum());
				}
				BCrmBaseInfo bCrmBaseInfo = ibCrmBaseInfoDAO.selectById(bPbcAppliBaseInfo.getCustcd());
				if(bCrmBaseInfo != null){
					approveDetail.setCustName(bCrmBaseInfo.getCname());
				}
				approveDetail.setExt1(bPbcAppliBaseInfo.getExt1());
				approveDetail.setAmt(bPbcAppliBaseInfo.getAmt());
				approveDetail.setStatus(bPbcAppliBaseInfo.getAppliStatusDtl());
				
				resultList.add(approveDetail);
			}
		}
		page.setRecords(resultList);
		return page;
	}
	//现货抵押
	@Override
	public Page findMortgageLoanApply(int pageNo, int pageSize, String cname, String mastContno, String debetId,
			String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cname", cname);
		map.put("mastContno", mastContno);
		map.put("debetId", debetId);
		map.put("status", status);
		map.put("proid", ScfBasConstant.PRODUCT_TYPE_PLDY);
		List<String> processNames = new ArrayList<String>();
		processNames.add(WorkflowConstant.PROCNAME_MORTGAGECASHLOANAPPLY);
		processNames.add(WorkflowConstant.PROCNAME_MORTGAGEBILLLOANAPPLY);
		map.put("processNameList", processNames);
		Page page = new Page(pageSize, pageNo, 0);
		List<BPbcAppliBaseInfo> list = ibPbcAppliBaseInfoDAO.selectByProductId(map,page);//现货类
		List resultList = new ArrayList();
		if(list.size()>0||list!=null){
			for(int i=0;i<list.size();i++){
				BlanApproveDetail approveDetail = new BlanApproveDetail();
				BPbcAppliBaseInfo bPbcAppliBaseInfo = list.get(i);
				String appno = bPbcAppliBaseInfo.getAppno();
				approveDetail.setAppno(appno);
				approveDetail.setPiid(bPbcAppliBaseInfo.getPiid());
				BLanAppliLnciBase appliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
				if(appliLnciBase != null){
					approveDetail.setDebetId(appliLnciBase.getDebetId());
				}
				approveDetail.setMastContno(bPbcAppliBaseInfo.getMastContcode());
				com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bPbcAppliBaseInfo.getMastContcode());
				if(bCrrLnCon != null){
					approveDetail.setVidNo(bCrrLnCon.getVidNo());
					approveDetail.setVidBusTyp(bCrrLnCon.getVidBusiTyp());
					approveDetail.setLnAmt(bCrrLnCon.getLnAmt());
					approveDetail.setLnSum(bCrrLnCon.getLnSum());
				}
				BCrmBaseInfo bCrmBaseInfo = ibCrmBaseInfoDAO.selectById(bPbcAppliBaseInfo.getCustcd());
				if(bCrmBaseInfo != null){
					approveDetail.setCustName(bCrmBaseInfo.getCname());
				}
				approveDetail.setExt1(bPbcAppliBaseInfo.getExt1());
				approveDetail.setAmt(bPbcAppliBaseInfo.getAmt());
				approveDetail.setStatus(bPbcAppliBaseInfo.getAppliStatusDtl());
				
				resultList.add(approveDetail);
			}
		}
		page.setRecords(resultList);
		return page;
	}
	
	//应收账款池
	@Override
	public Page findInvoicePoolFinancingApply(int pageNo, int pageSize, String cname, String mastContno, String debetId,
			String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cname", cname);
		map.put("mastContno", mastContno);
		map.put("debetId", debetId);
		map.put("status", status);
//		map.put("proid", ScfBasConstant.PRODUCT_TYPE_DEBT_POOL);
		map.put("processName", WorkflowConstant.PROCNAME_FINANCING_POOL_APPLY);
		Page page = new Page(pageSize, pageNo, 0);
		List<BPbcAppliBaseInfo> list = ibPbcAppliBaseInfoDAO.selectByProductId(map,page);//应收类
		List resultList = new ArrayList();
		if(list.size()>0||list!=null){
			for(int i=0;i<list.size();i++){
				BlanApproveDetail approveDetail = new BlanApproveDetail();
				BPbcAppliBaseInfo bPbcAppliBaseInfo = list.get(i);
				String appno = bPbcAppliBaseInfo.getAppno();
				approveDetail.setAppno(appno);
				approveDetail.setPiid(bPbcAppliBaseInfo.getPiid());
				BLanAppliLnciBase appliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
				if(appliLnciBase != null){
					approveDetail.setDebetId(appliLnciBase.getDebetId());
				}
				approveDetail.setMastContno(bPbcAppliBaseInfo.getMastContcode());
				com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bPbcAppliBaseInfo.getMastContcode());
				if(bCrrLnCon != null){
					approveDetail.setVidNo(bCrrLnCon.getVidNo());
					approveDetail.setVidBusTyp(bCrrLnCon.getVidBusiTyp());
					approveDetail.setLnAmt(bCrrLnCon.getLnAmt());
					approveDetail.setLnSum(bCrrLnCon.getLnSum());
				}
				BCrmBaseInfo bCrmBaseInfo = ibCrmBaseInfoDAO.selectById(bPbcAppliBaseInfo.getCustcd());
				if(bCrmBaseInfo != null){
					approveDetail.setCustName(bCrmBaseInfo.getCname());
				}
				approveDetail.setExt1(bPbcAppliBaseInfo.getExt1());
				approveDetail.setAmt(bPbcAppliBaseInfo.getAmt());
				approveDetail.setStatus(bPbcAppliBaseInfo.getAppliStatusDtl());
				
				resultList.add(approveDetail);
			}
		}
		page.setRecords(resultList);
		return page;
	}
}
