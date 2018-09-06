package com.huateng.scf.sto.nwr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.NoticeQryPrintVO;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.nte.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.dao.ISBcpAppliWarehouseDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliWarehouse;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.service.IBillStandardPledgeAppService;
import com.huateng.scf.sto.nwr.service.IBillManagerService;
import com.huateng.scf.sto.nwr.service.IBillNormalPledgeMngService;
import com.huateng.scf.sto.nwr.service.IBillStandardApplyService;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scf.sto.nwr.vo.BillStandardBussInfoVO;
import com.huateng.scf.sto.nwr.vo.BillStandardMortgageVO;
import com.huateng.scf.sto.nwr.vo.BillstandardAppVO;
import com.huateng.scf.sto.nwr.vo.BillstandardInfoVO;
import com.huateng.scf.sto.nwr.vo.PledgeContractVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>非标仓单质押	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月14日下午1:41:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月14日下午1:41:57	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillNormalPledgeMngServiceImpl")
public class BillNormalPledgeMngServiceImpl implements IBillNormalPledgeMngService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	//产品公共类
	@Resource(name = "ProductServiceImpl")
	IProductService productService;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	//监管协议/担保提货协议/先票(款)后货协议信息表
	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO bcntmprotbaseinfodao;
	
	//多方协议参与者信息表
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bcntmprotpartinfoservice;
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	//仓单质押申请
	@Resource(name = "BillStandardPledgeAppServiceImpl")
	IBillStandardPledgeAppService billstandardpledgeappservice;
	
	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;
	
	@Resource(name = "BillStandardApplyServiceImpl")
	IBillStandardApplyService billstandardapplyservice;
	
	@Resource(name = "ISBcpAppliWarehouseDAO")
	ISBcpAppliWarehouseDAO sbcpappliwarehousedao;
	
	//借据基本信息表
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;
	
	//押品基本信息表
	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;
	
	//业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	//押品业务申请表
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;
	
	//通知书信息
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bntenoticebaseservice;
	
	//仓单管理
	@Resource(name = "BillManagerServiceImpl")
	IBillManagerService billmanagerservice;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	/**
	 * 待选合同列表
	 * @param pageNo
	 * @param pageSize
	 * @param sbcpMortBillNormalVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月12日下午4:10:15
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page ChooseContractCommonQryGetter(int pageNo, int pageSize, PledgeContractVO pledgeContractVO)
	{
		log.debug("待选合同列表查询============");
		String supplyChainPdId_Q = pledgeContractVO.getSupplyChainPdId();//供应链产品ID
		String mastContno_Q = pledgeContractVO.getMastContno();//主合同号
		String slaveContno_Q = pledgeContractVO.getSlaveContno();//从合同号
		String custcd_Q = pledgeContractVO.getCustcd();//从合同出质人内部客户号
		String moniOfCustcd_Q = pledgeContractVO.getMoniOfCustcd();//从合同监管公司
		
		//added by hong.xu 2013-2-4 添加查询参数：产品中类ID start
		String midProductId = pledgeContractVO.getMidProductId();
		if(!StringUtil.isEmpty(midProductId)&&ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(midProductId))
		{
			supplyChainPdId_Q = contractservice.getProductByParentId(midProductId);
		}

		//added by hong.xu 2013-2-20 仓单查询 start
		if(!StringUtil.isEmpty(midProductId)&&ScfBasConstant.PRODUCT_TYPE_BILL.equals(midProductId))
		{
			String billType = pledgeContractVO.getBillType();//仓单类型
			supplyChainPdId_Q = productService.getBillByMidProductId(billType);
		}
		//added by hong.xu 2013-2-20 仓单查询 end
		if(StringUtil.isEmpty(mastContno_Q)){
			mastContno_Q = "";
		}
		if(mastContno_Q.contains("'")){
			mastContno_Q = "";
		}
		if(StringUtil.isEmpty(slaveContno_Q)){
			slaveContno_Q = "";
		}
		if(slaveContno_Q.contains("'")){
			slaveContno_Q = "";
		}

		pledgeContractVO.setSupplyChainPdId(supplyChainPdId_Q);
		pledgeContractVO.setMastContno(mastContno_Q);
		pledgeContractVO.setSlaveContno(slaveContno_Q);
		pledgeContractVO.setCustcd(custcd_Q);
		pledgeContractVO.setMoniOfCustcd(moniOfCustcd_Q);
		pledgeContractVO.setPageIndex(pageNo);
		pledgeContractVO.setPageSize(pageSize);
		Page pageQueryResult = contractservice.getAppContInfoBySupplyChainPdId(pledgeContractVO);

		List list=new ArrayList();
        for(int i=0;i<pageQueryResult.getRecords().size();i++){
        	HashMap<String, Object> contractVO =(HashMap<String, Object>)pageQueryResult.getRecords().get(i);

        	if(ScfBasConstant.PRODUCT_TYPE_FRANCHISER.equals(contractVO.get("vidPrdId").toString())){
        		BCntMprotBaseInfo tblMutiProtBaseInfo = bcntmprotbaseinfodao.selectByPrimaryKey(contractVO.get("prtclNo").toString());
            	if(ScfBasConstant.MUTI_PROTOCOL_FOURWH.equals(tblMutiProtBaseInfo.getProtocolType())){
            		BCntMprotPartInfo tblMutiProtPartInfo = bcntmprotpartinfoservice.findCoreorCustByProtocolNo(contractVO.get("prtclNo").toString(),ScfBasConstant.PROTOCOL_PART_ROLE_MONI);//查找监管公司
                	contractVO.put("planMoniEnt",tblMutiProtPartInfo.getCustcd());
            	}
        	}
        	list.add(contractVO);
        }

        pageQueryResult.setRecords(list);

		return pageQueryResult;
	}

	/**
	 * 查找业务申请基本信息
	 * @param bussInfoVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月17日下午5:58:33
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BillStandardBussInfoVO BillStandardBussInfoGetter(BillStandardBussInfoVO bussInfoVO) throws ScubeBizException
	{
		String appno = bussInfoVO.getAppno();
		String slaveContno = bussInfoVO.getSlaveContno();//质押合同号
		String mastContno = bussInfoVO.getMastContno();//主合同号
		String mastContcode = bussInfoVO.getMastContcode();//主合同号（纸质）
		if(StringUtil.isEmpty(mastContno)){
			if(null!=mastContno && !"".equals(mastContno) && !"null".equals(mastContno)){//modify by huangshuidan 20160907增加null非空判断
				mastContno = bcrrlnconservice.findBCrrLnConByAppId(mastContcode).getAppId();
			}
		}

		if(!StringUtil.isEmpty(appno))
		{
			BPbcAppliBaseInfo appliBaseInfo = billstandardapplyservice.getAppliBaseInfoByAppno(appno);
			SBcpAppliWarehouse ware = sbcpappliwarehousedao.selectByPrimaryKey(appno);
			BeanUtils.copyProperties(appliBaseInfo, bussInfoVO);
			bussInfoVO.setBussType(appliBaseInfo.getSupplyChainPdId());
			if(ware!=null){
				BeanUtils.copyProperties(ware, bussInfoVO);
			}
		}
		else
		{
			BCrrLnCon contBaseInfo = new BCrrLnCon();
			BCrrGntyCon slaveContInfo = new BCrrGntyCon();
			if(!StringUtil.isEmpty(slaveContno))
			{
				slaveContInfo = contractservice.getTblContSlaveInfo(slaveContno);
			}
			if(!StringUtil.isEmpty(mastContno))
			{
				contBaseInfo = contractservice.getTblContBaseInfo(mastContno);
			    HashMap<String, Object> map = blanlncibaseservice.getLnciSumByParam(mastContno);
			    BigDecimal lnciBal=(BigDecimal) map.get("lnciBal");
			    BigDecimal cashEqtAmt=(BigDecimal) map.get("cashEqtAmt");
			    BigDecimal bailAmount=(BigDecimal) map.get("bailAmount");
			    BigDecimal riskAmount=lnciBal.subtract(cashEqtAmt).subtract(bailAmount);
			    if(riskAmount.compareTo(BigDecimal.ZERO)<0){
		        	riskAmount=new BigDecimal(0.00);
		        }
			    BigDecimal receiptPledgeAmount = bpbcmtgbaseinfoservice.getMortgageSumPriceByBillMastno(mastContno);
			    if(receiptPledgeAmount.compareTo(BigDecimal.ZERO)<0){
			    	receiptPledgeAmount=new BigDecimal(0.00);
		        }
			    BigDecimal ration = BigDecimal.ZERO;
				if(slaveContInfo!=null){
					ration = slaveContInfo.getRation().divide(new BigDecimal(100));//质押率需要除以100以后使用
				}
				BigDecimal removePledgeHighestAmount = (receiptPledgeAmount.multiply(ration).subtract(riskAmount)).divide(ration,2,BigDecimal.ROUND_DOWN);//在押总价值乘以质押率减去敞口,然后除以质押率得到可解压仓单价值
				if(removePledgeHighestAmount.compareTo(BigDecimal.ZERO)<0)
				{//如果小于0则置为0
					removePledgeHighestAmount = new BigDecimal(0.00);
				}
			    BigDecimal theRPAmount=receiptPledgeAmount.multiply(ration);
			    bussInfoVO.setRiskAmount(riskAmount);
			    bussInfoVO.setReceiptPledgeAmount(receiptPledgeAmount);
			    bussInfoVO.setRemovePledgeHighestAmount(removePledgeHighestAmount);
			    bussInfoVO.setTheRPAmount(theRPAmount);
			}
			BeanUtils.copyProperties(contBaseInfo, bussInfoVO);
			BeanUtils.copyProperties(slaveContInfo, bussInfoVO);
			bussInfoVO.setBussType(slaveContInfo.getVidPrdId());
			bussInfoVO.setSupplyChainPdId(slaveContInfo.getVidPrdId());
		}

		List<com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo> mutiProtList=contractservice.getMutiProtPartInfo(bussInfoVO.getSlaveContno()).getRecords();
		if(mutiProtList!=null&&mutiProtList.size()>0){
			com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo info = mutiProtList.get(0);
			bussInfoVO.setProtocolNo(info.getProtocolNo());
			bussInfoVO.setPrtclBrNm(info.getCname());//监管人名称
			bussInfoVO.setExt1(info.getCustcd());
			BCrrGntyCon slaveContInfo = contractservice.getTblContSlaveInfo(bussInfoVO.getSlaveContno());
			bussInfoVO.setCname(slaveContInfo.getGutNm());
		}
		return bussInfoVO;
	}
	
	/**
	 *  任务基本信息
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno) {
		String process = WorkflowConstant.PROCNAME_NORMAL_BILL_QUALITY_APPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
	
	/**
	 * 业务管理-押品清单查询
	 * @param pageNo
	 * @param pageSize
	 * @param billNormalVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月14日下午5:00:31
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page BillNormalMngQueryGetter(int pageNo, int pageSize, BillNormalVO billNormalVO)
	{
		String flag_Q = billNormalVO.getFlag();
		billNormalVO.setPageIndex(pageNo);
		billNormalVO.setPageSize(pageSize);
		Page pageQueryResult = new Page(pageSize, pageNo, 0);
		if("1".equals(flag_Q))
		{
			billNormalVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_INPUT);
			billNormalVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_MAA);
			//当前业务品种
			String supplyChainPdId=productService.getBillByMidProductId(ScfBasConstant.BILL_TYPE_NORMAL);
			billNormalVO.setSupplyChainPdId(supplyChainPdId);
			pageQueryResult = billstandardpledgeappservice.getEffectNormalList(billNormalVO);
			List<String> idsSet = new ArrayList<String>();
			String selectId_Q = billNormalVO.getSelectId_Q();
			if(!StringUtil.isEmpty(selectId_Q)){
				String [] ids = selectId_Q.split("/f");
				for(String id : ids){
					idsSet.add(id);
				}
			}
			List<SBcpMortBillNormal> result = pageQueryResult.getRecords();
			List<BillstandardInfoVO> list = new ArrayList<BillstandardInfoVO>();
			for(int i = 0; i < result.size(); i++){
				BillstandardInfoVO billnormalInfo = new BillstandardInfoVO();
				SBcpMortBillNormal bcpMortBillNormal = result.get(i);
				BeanUtils.copyProperties(bcpMortBillNormal, billnormalInfo);
				billnormalInfo.setCname(bcrmbaseinfodao.selectById(billnormalInfo.getCustcd()).getCname());
//				if(idsSet.contains(billnormalInfo.getBillno())){
//					billnormalInfo.setSelect(true);
//				}
				String billno = billnormalInfo.getBillno();
				BigDecimal sum = billstandardpledgeappservice.getSubByBillno(billno);
				billnormalInfo.setWhReceiptValue(sum);//仓单价值
				list.add(billnormalInfo);
			}
			pageQueryResult.setRecords(list);
		}
		else if("2".equals(flag_Q))
		{
			billNormalVO.setSelectFlag_Q(true);
			pageQueryResult = billstandardpledgeappservice.getNormalList(billNormalVO);

		}
		else if(!StringUtil.isEmpty(billNormalVO.getAppno()))
		{
			billNormalVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_INPUT);
			pageQueryResult = billstandardpledgeappservice.getBillnormalListByAppno(billNormalVO, true);
		}

		return pageQueryResult;
	}
	
	/**
	 * 普通仓单新增保存
	 * @param billStandardBussInfoVO
	 * @param insertList
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月17日下午3:15:18
	 */
	@Override
	public String BillNormalPledgeAppUpdate(BillStandardBussInfoVO billStandardBussInfoVO,List<BillstandardInfoVO> insertList) throws ScubeBizException
	{
		String appliType = "";//申请类型
     	String workApplyType = ""; //申请业务类型
		String bussAppno=billStandardBussInfoVO.getAppno();
		String appno="";
		appliType=WorkflowConstant.APPLI_TYPE_BILL_NORMAL_QUALITYAPPLI;
		workApplyType=WorkflowConstant.PROCNAME_NORMAL_BILL_QUALITY_APPLY;
		billStandardBussInfoVO.setApplyType(appliType);
		billStandardBussInfoVO.setWorkApplyType(workApplyType);

		if(StringUtil.isEmpty(bussAppno))
		{
			//保存信息到申请基本信息表，生成appno并返回
			appno = billstandardpledgeappservice.saveAppliBaseInfo(billStandardBussInfoVO);
			//工作流开始
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", WorkflowConstant.PROCNAME_NORMAL_BILL_QUALITY_APPLY);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.commonStartFlow(appno,workApplyType, workApplyType, paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			// 更新业务申请基本信息
			billstandardpledgeappservice.updateAppliBaseInfo(billStandardBussInfoVO,false);
	    	appno = bussAppno;
	    }

		//存申请仓单信息
		List<BillNormalAppVO> list = new ArrayList<BillNormalAppVO>();
		if(insertList.size()>0)
		{
			for(BillstandardInfoVO billstandardInfoVO:insertList)
			{
				BillNormalAppVO appVO = new BillNormalAppVO();
				BeanUtils.copyProperties(billstandardInfoVO, appVO);
				list.add(appVO);
			}
		}
		billstandardpledgeappservice.BillNormalApplyInfSave(list,appno);
		return appno;
	}
	
	/**
	 * 非标准仓单质押填写岗提交
	 * @param billStandardBussInfoVO
	 * @param insertList
	 * @author 	mengjiajia
	 * @date 	2017年4月18日下午3:27:13
	 */
	@Override
	public void BillNorQualityAppSubmitUpdate(BillStandardBussInfoVO billStandardBussInfoVO,List<BillNormalAppVO> insertList)
	{
     	billstandardpledgeappservice.updateAppliBaseInfo(billStandardBussInfoVO,false);
		// 保存业务申请信息
     	billstandardpledgeappservice.BillNormalApplyInfSave(insertList,billStandardBussInfoVO.getAppno());
	 	// 工作流处理
     	String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//退回首节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billStandardBussInfoVO.getAppno());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 标准仓单核价，点击“保存”
	 * @param billNormalVO
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年4月18日下午7:10:53
	 */
	@Override
	public void BillNormalMorgListUpdate(BillNormalVO billNormalVO, List<BPbcMtgBaseInfoVO> list) throws ScubeBizException
	{
		String appno = billNormalVO.getAppno();//申请号
		String slaveContno = billNormalVO.getSlaveContno();
		String billnoTemp = billNormalVO.getBillno();
		if (StringUtil.isEmpty(appno))
		{//如果appno为空 则不进行押品信息保存，必须先保存仓单信息产生申请编号
			appno="";
		}
		if(slaveContno == null)
		{
			slaveContno ="";

		}
		String billno = null;
		if(!StringUtil.isEmpty(billnoTemp))
		{
			billnoTemp = billnoTemp.trim();
			try 
			{
				billno = billnoTemp;
			} catch (NumberFormatException e) 
			{
				log.info("------ BillstandardMorgPricingUpdate->saveOrUpdate 从String的billno到Long的billno 时转换出错------");
				e.printStackTrace();
			}
		}
		if(StringUtil.isEmpty(billno)){
			throw new ScubeBizException("仓单号丢失,无法保存押品信息！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
        /** modified by huaidong.li @2011-7-20 end */
		// 填装押品列表信息
		List<BillStandardMortgageVO> insertList = new ArrayList<BillStandardMortgageVO>();
		List<BillStandardMortgageVO> updateList = new ArrayList<BillStandardMortgageVO>();
		BillStandardMortgageVO applyVO = null;
		for(int i=0;i<list.size();i++)
		{
			BPbcMtgBaseInfoVO baseInfoVO = list.get(i);
			applyVO = new BillStandardMortgageVO();
			BeanUtils.copyProperties(baseInfoVO, applyVO);
			applyVO.setAppliMortBizType(ScfBasConstant.MORT_BIZ_TYPE_NORMAL_PLEDGE_IN); //  申请业务押品清单业务类型[标准仓单质押]
			applyVO.setAppno(appno);
			insertList.add(applyVO);
		}
		
		
		BillstandardAppVO contractVO = new BillstandardAppVO();
		BCrrGntyCon contSlaveInfo = contractservice.getTblContSlaveInfo(slaveContno);//根据slaveContno获取从合同信息
		BeanUtils.copyProperties(contSlaveInfo, contractVO);
		contractVO.setSlaveContno(contSlaveInfo.getConId());
		contractVO.setProtocolNo( contSlaveInfo.getPrtclNo());
		contractVO.setSecCd(contSlaveInfo.getGutId());
		contractVO.setMastContno(billNormalVO.getMastContno());
		// 增删改出质清单（押品列表）
		billstandardapplyservice.addModifyDeleteAppMortgageList(appno, contractVO, insertList, updateList, new ArrayList<BillStandardMortgageVO>());
	}
	
	/**
	 * 普通非标准仓单质押申请核价岗提交
	 * @param bussVO
	 * @author 	mengjiajia
	 * @date 	2017年4月18日下午5:10:11
	 */
	@Override
	public void BillNorQualityPricingUpdate(BillStandardBussInfoVO billStandardBussInfoVO)
	{
		String appno = billStandardBussInfoVO.getAppno();
		//校验是否对押品进行核价并保存
		HashMap<String, Object> poMap = new HashMap<String, Object>();
		poMap.put("appno", appno); // 申请编号
		poMap.put("appliMortBizType", ScfBasConstant.MORT_BIZ_TYPE_NORMAL_PLEDGE_IN); // 申请业务押品清单业务类型（仓单置换入库）
		bpbcapplimtginfoservice.findByConditionException("BPbcAppliMtgInfo", poMap, "请先对押品进行核价，并保存！");

		bntenoticebaseservice.saveBillNormalNoticeInfo(appno,NoticeConstant.NOTICE_TYPE_128,billStandardBussInfoVO);
		// 复核流程方法
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billStandardBussInfoVO.getAppno());
		applibaseinfo.setComment(billStandardBussInfoVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 普通非标准仓单质押申请复核岗复核
	 * @param billStandardBussInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年4月19日上午9:48:18
	 */
	@Override
	public void BillNorQualityReviewUpdate(BillStandardBussInfoVO billStandardBussInfoVO)
	{
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billStandardBussInfoVO.getAppno());
		applibaseinfo.setComment(billStandardBussInfoVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 普通非标准仓单质押申请回执确认
	 * @param billStandardBussInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年4月19日上午9:59:10
	 */
	@Override
	public void BillNorQualityConfirmUpdate(BillStandardBussInfoVO billStandardBussInfoVO)
	{
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		if(status.equals(WorkflowConstant.WORKFLOW_TRANS_AGREE)){
			billmanagerservice.saveTblMortgageBillNorInf(billStandardBussInfoVO.getAppno());
			//修改通知书状态
			bntenoticebaseservice.updateNoticeStatus(billStandardBussInfoVO.getAppno(),NoticeConstant.NOTICE_TYPE_128,NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		}
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billStandardBussInfoVO.getAppno());
		applibaseinfo.setComment(billStandardBussInfoVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 普通非标准仓单质押申请退回修改
	 * @param billStandardBussInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年4月19日上午9:42:47
	 */
	@Override
	public void BillNorQualityBackToModifyUpdate(BillStandardBussInfoVO billStandardBussInfoVO)
	{
		String status = WorkflowConstant.WORKFLOW_TRANS_GOBACK;//跳转下一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billStandardBussInfoVO.getAppno());
		applibaseinfo.setComment(billStandardBussInfoVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 通知书基本印信息查询
	 * @param noticeQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月20日上午9:53:18
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public BNteNoticeBase NoticePrintInfoGetter(NoticeQryPrintVO noticeQryVO) throws ScubeBizException
	{
		String bussAppno = noticeQryVO.getAppno();
//		String path= "";
		if(StringUtil.isEmpty(noticeQryVO.getNoticeType()))
		{
			throw new ScubeBizException("找不到相关的类型通知书",RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(noticeQryVO.getAppno()))
		{
			NoticeQryPrintVO noticeCommonQueryVO=new NoticeQryPrintVO();
			noticeCommonQueryVO.setId(noticeQryVO.getId());
			noticeCommonQueryVO.setNoticeType(noticeQryVO.getNoticeType());
			Page pageQueryResultNow = bntenoticebaseservice.getNoticeBaseInfoByNoticeCommonQueryVO(noticeCommonQueryVO);
			List list=pageQueryResultNow.getRecords();
			if(list!=null&&list.size()>0){
				BNteNoticeBase noticeVO=(BNteNoticeBase)list.get(0);
				bussAppno = noticeVO.getAppno();
				noticeQryVO.setAppno(bussAppno);
			}
		}

		Page pageQueryResult = bntenoticebaseservice.getNoticeBaseInfoByNoticeCommonQueryVO(noticeQryVO);
//		NoticeGeneratorService generateNoticeService=NoticeGeneratorService.getInstance();
//		try {
//			String swfPath=generateNoticeService.generateNoticeDocx(noticeQryVO,path);
//		} catch (AppException e) {
//			e.printStackTrace();
//			ExceptionUtil.throwCommonException("通知书生成失败！", BComErrorConstant.ERROR_CODE_CANNOT_SUBMIT);
//		}
		BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
		if(pageQueryResult.getRecords()!=null&&pageQueryResult.getRecords().size()>0)
		{
			com.huateng.scf.bas.nte.dao.model.BNteNoticeBase base = 
					(com.huateng.scf.bas.nte.dao.model.BNteNoticeBase) pageQueryResult.getRecords().get(0);
			
			BeanUtils.copyProperties(base, bNteNoticeBase);
		}
		return bNteNoticeBase;
	}
}
