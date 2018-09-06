package com.huateng.scf.sto.nwr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.ICustomerService;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrLnConRela;
import com.huateng.scf.bas.crr.service.IBCrrLnConRelaService;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.ext.ExtIBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStorDeliService;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.dao.ISBcpAppliMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.ISBcpAppliWarehouseDAO;
import com.huateng.scf.sto.nwr.dao.ISBcpMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.ext.ExtSBcpNwrDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormalExample;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliWarehouse;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormalExample;
import com.huateng.scf.sto.nwr.dao.vo.SBcpBillNormalAppVO;
import com.huateng.scf.sto.nwr.model.SBcpAppliMortBillNormalVO;
import com.huateng.scf.sto.nwr.model.SBcpMortBillNormalVO;
import com.huateng.scf.sto.nwr.service.IBillStandardPledgeAppService;
import com.huateng.scf.sto.nwr.service.ISBcpAppliMortBillNormalService;
import com.huateng.scf.sto.nwr.service.ISBcpMortBillNormalService;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scf.sto.nwr.vo.BillStandardBussInfoVO;
import com.huateng.scf.sto.nwr.vo.BillStandardMortgageBaseVO;
import com.huateng.scf.sto.nwr.vo.BillstandardMortgageQryVO;
import com.huateng.scf.sto.nwr.vo.BillstandardQryVO;
import com.huateng.scf.sto.nwr.vo.DeliveyApplyVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>非标仓单公共类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月12日下午5:21:39
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月12日下午5:21:39	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillStandardPledgeAppServiceImpl")
public class BillStandardPledgeAppServiceImpl implements IBillStandardPledgeAppService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "ExtSBcpNwrDAO")
	ExtSBcpNwrDAO extsbcpnwrdao;
	
	@Resource(name = "CustomerServiceImpl")
	ICustomerService customerservice;
	
	@Resource(name = "ISBcpMortBillNormalDAO")
	ISBcpMortBillNormalDAO sbcpmortbillnormaldao;
	
	@Resource(name = "SBcpMortBillNormalServiceImpl")
	ISBcpMortBillNormalService sbcpmortbillnormalservice;
	
	@Resource(name ="BCrrLnConRelaServiceImpl")
	IBCrrLnConRelaService bcrrlnconrelaservice;
	
	@Resource(name ="BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO bpbcmtgbaseinfodao;
	
	@Resource(name ="BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name ="ExtBPbcMtgBaseInfoDAO")
	ExtIBPbcMtgBaseInfoDAO extbpbcmtgbaseinfodao;

	@Resource(name ="BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService bSysSerialNoService;// 流水号生成服务
	
	@Resource(name = "ISBcpAppliMortBillNormalDAO")
	ISBcpAppliMortBillNormalDAO sbcpapplimortbillnormaldao;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO bcntmprotbaseinfodao;

	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;
	
	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService bmrnappliacctinfoservice;
	
	@Resource(name = "SBcpAppliMortBillNormalServiceImpl")
	ISBcpAppliMortBillNormalService sbcpapplimortbillnormalservice;
	
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;
	
	@Resource(name = "BPbcMtgStorDeliServiceImpl")
	IBPbcMtgStorDeliService bpbcmtgstordeliservice;
	
	@Resource(name = "ISBcpAppliWarehouseDAO")
	ISBcpAppliWarehouseDAO sbcpappliwarehousedao;
	
	@Override
	public Page getNormalList(BillNormalVO billNormalVO)
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		List<String> billnoList = new ArrayList<String>();
		List<String> custcdList = new ArrayList<String>();
		if(billNormalVO != null)
		{
			if(!StringUtil.isEmpty(billNormalVO.getSlaveContno()))
			{
				omap.put("slaveContno", billNormalVO.getSlaveContno());
			}
			if(!StringUtil.isEmpty(billNormalVO.getCustcd()))
			{
				omap.put("custcd", billNormalVO.getCustcd());
			}
			if(!StringUtil.isEmpty(billNormalVO.getCname()))
			{
				omap.put("cname", billNormalVO.getCname());
			}
			if(!StringUtil.isEmpty(billNormalVO.getKeeperName()))
			{
				omap.put("keeperName", billNormalVO.getKeeperName());
			}
			if(!StringUtil.isEmpty(billNormalVO.getStartDate()))
			{
				omap.put("startDate", billNormalVO.getStartDate());
			}
			if(!StringUtil.isEmpty(billNormalVO.getEndDate()))
			{
				omap.put("endDate", billNormalVO.getEndDate());
			}
			if(!StringUtil.isEmpty(billNormalVO.getBillcode()))
			{
				omap.put("billcode", billNormalVO.getBillcode());
			}
			if (billNormalVO.isSelectFlag_Q()) {
				if (!StringUtil.isEmpty(billNormalVO.getBillno())) {
					if(billNormalVO.getBillno().indexOf("/f")==-1){
						omap.put("billno", billNormalVO.getBillno());
					}else{
						String[] ids=billNormalVO.getBillno().split("/f");
						for(int i=0;i<ids.length-1;i++)
						{
							if(!StringUtil.isEmpty(ids[i]))
							{
								billnoList.add(ids[i]);
							}
						}
					}
				}
				else{
				}
			}

			if(ScfBasConstant.CUST_QUERY_TYPE_BY_MAA.equals(billNormalVO.getFlag())){//按主管客户经理+协管客户经理
				custcdList = customerservice.getCustcdsQueryCondition("cust.custcd", ScfBasConstant.QUERY_TYPE_MAG_ALL, ContextHolder.getUserInfo().getTlrNo());
			}
		}
		if(billnoList.size()>0)
		{
			omap.put("billnoList", billnoList);
		}
		if(custcdList.size()>0)
		{
			omap.put("custcdList", custcdList);
		}
		int total = extsbcpnwrdao.countSBcpMortBill(omap);
		Page page = new Page(billNormalVO.getPageSize(), billNormalVO.getPageIndex(), total);
		page.setRecords(extsbcpnwrdao.selectSBcpMortBill(omap, page));
		return page;
	}

	/**
	 * 查询非标准普通仓单保存
	 * @author zhangcheng
	 * @date 2013-9-13
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String billnormalAdd(BillNormalVO infoVO, List billnormalList) throws ScubeBizException {
		String billno="";
		for(int i=0;i<billnormalList.size();i++)
		{
			SBcpMortBillNormalVO billnormal=new SBcpMortBillNormalVO();
			billnormal = (SBcpMortBillNormalVO) billnormalList.get(i);
			SBcpMortBillNormalExample example = new SBcpMortBillNormalExample();
			com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormalExample.Criteria  cri = example.createCriteria();
			if(billnormal != null && billnormal.getBillcode() != null){
				cri.andBillcodeEqualTo(billnormal.getBillcode());
				List<SBcpMortBillNormal> sbcpbillnormalList = sbcpmortbillnormaldao.selectByExample(example);
				if(sbcpbillnormalList!=null && sbcpbillnormalList.size()>0){
					throw new ScubeBizException("仓单编号为【"+billnormal.getBillcode()+"】的仓单已存在，请重新输入仓单编号，确保不出现重复！", RBcpErrorConstant.RECORD_HAS_EXIST);
				}
			}
			billnormal.setBrcode(infoVO.getBrcode());
			billnormal.setCustcd(infoVO.getCustcd());
			billnormal.setSlaveContno(infoVO.getSlaveContno());
			billnormal.setRegistrationNum(infoVO.getRegistrationNum());
			billnormal.setBillno(UUIDGeneratorUtil.generate());
			billnormal.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_INPUT);
			//根据抵质押合同号查询主合同信息号，即查询信贷合同号
			BCrrLnConRela bCrrLnConRela = new BCrrLnConRela();
			bCrrLnConRela.setRltNo(infoVO.getSlaveContno());
			bCrrLnConRela.setIsRelate("01");
			List<BCrrLnConRela> listrela = bcrrlnconrelaservice.findBCrrLnConRelaByExample(bCrrLnConRela);
//		  	TblContBaseInfo baseInfo=SCFDAOUtils.getTblContBaseInfoDAO().getMastContByBusinessNo(infoVO.getSlaveContno());
			if(listrela.size()==0)
			{
				throw new ScubeBizException("主合同不存在！", RBcpErrorConstant.RECORD_NOT_EXIST);
			}
		  	billnormal.setMastContno(listrela.get(0).getSerialno());
			billno=billno+"/f"+sbcpmortbillnormalservice.save(billnormal);

		}
		return billno;
	}

	/**
	 * 标准仓单押品查询
	 * @Description: 标准仓单押品查询
	 * @author huangshan
	 * @Created 2013-9-11下午02:07:21
	 * @param billstandardAppVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page billstandardMortgageQuery(BillstandardMortgageQryVO qryVO) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		
		List<String> billnoList = new ArrayList<String>();
		List<String> custcdList = new ArrayList<String>();
		if (!StringUtil.isEmpty(qryVO.getBillno())) 
		{
			if(qryVO.getBillno().indexOf("/f")==-1)
			{
				omap.put("billno", qryVO.getBillno());
			}
			else
			{
				String[] ids=qryVO.getBillno().split("/f");
				for(int i=0;i<ids.length;i++)
				{
					if(!StringUtil.isEmpty(ids[i]))
					{
						billnoList.add("'"+ids[i].trim()+"'");
					}
				}
			}
		}
		else
		{
			omap.put("flag", "#");
		}
		if (!StringUtil.isEmpty(qryVO.getMortgageNo())) 
		{
			omap.put("mortgageNo", qryVO.getMortgageNo());
		}
		if(ScfBasConstant.CUST_QUERY_TYPE_BY_MAA.equals(qryVO.getFlag())){//按主管客户经理+协管客户经理
			custcdList = customerservice.getCustcdsQueryCondition("tmbi.custcd", ScfBasConstant.QUERY_TYPE_MAG_ALL, ContextHolder.getUserInfo().getTlrNo());
		}
		if(billnoList.size()>0)
		{
			omap.put("billnoList", billnoList);
		}
		if(custcdList.size()>0)
		{
			omap.put("custcdList", custcdList);
		}
		
		int tatol = extbpbcmtgbaseinfodao.countBillstandardMortgageQuery(omap);
		Page result=new Page(qryVO.getPageSize(), qryVO.getPageIndex(), tatol);
		List<BPbcMtgBaseInfoVO> list = extbpbcmtgbaseinfodao.findBillstandardMortgageQuery(omap, result, false);
		if(list.size()>0)
		{
			for(int i = 0;i<list.size();i++)
			{
				BPbcMtgBaseInfoVO baseInfoVO = list.get(i);
				baseInfoVO.setCname(bcrmbaseinfodao.selectById(baseInfoVO.getCustcd()).getCname());
				String billno = baseInfoVO.getBillno();
				SBcpMortBillNormal bcpMortBillNormal = sbcpmortbillnormaldao.selectByPrimaryKey(billno);
				if(bcpMortBillNormal!=null)
				{
					baseInfoVO.setBillcode(bcpMortBillNormal.getBillcode());
				}
			}
		}
		result.setRecords(list);
		return result;
	}
	
	/**
	 * 仓单押品新增
	 * @param slaveContno
	 * @param baseVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午7:39:10
	 */
	@Override
	public void billstandardMorgAdd(String slaveContno, BillStandardMortgageBaseVO baseVO) throws ScubeBizException
	{
		BCrrGntyCon contSlaveInfo = contractservice.getTblContSlaveInfo(slaveContno);//根据slaveContno获取从合同信息
		// 增加操作.
		BPbcMtgBaseInfo baseInfo=new BPbcMtgBaseInfo();
		BeanUtils.copyProperties(baseVO, baseInfo);
		baseInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 经办行
		baseInfo.setMonitorProtocolNo(contSlaveInfo.getPrtclNo());// 监管协议
		baseInfo.setMastContno("");
		baseInfo.setSupplyChainPdId(contSlaveInfo.getVidPrdId());//获取业务品种
		bpbcmtgbaseinfoservice.saveMorgBaseInfo(baseInfo);
	}
	
	/**
	 * 仓单押品修改
	 * @param slaveContno
	 * @param baseVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午8:00:10
	 */
	@Override
	public void billstandardMorgModity(String slaveContno,BillStandardMortgageBaseVO baseVO)throws ScubeBizException
	{
		BCrrGntyCon contSlaveInfo = contractservice.getTblContSlaveInfo(slaveContno);//根据slaveContno获取从合同信息
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo baseInfo =
				new com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo();
		BeanUtils.copyProperties(baseVO, baseInfo);
		baseInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 经办行
		baseInfo.setMonitorProtocolNo(contSlaveInfo.getPrtclNo());// 监管协议
		baseInfo.setSupplyChainPdId(contSlaveInfo.getVidPrdId());//获取业务品种
		baseInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		baseInfo.setLastUpdTime(new Date());
		bpbcmtgbaseinfodao.updateByPrimaryKeySelective(baseInfo);
	}

	/**
	 * 仓单押品删除
	 * @param mortgageNo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午8:03:56
	 */
	@Override
	public void billstandardMorgDelete(String mortgageNo) throws ScubeBizException
	{
		bpbcmtgbaseinfodao.deleteByPrimaryKey(mortgageNo);
	}
	
	/**
	 * 查询有押品的普通仓单信息
	 * @param billNormalVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月14日下午5:04:42
	 */
	@Override
	public Page getEffectNormalList(BillNormalVO billNormalVO) throws ScubeBizException 
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
        List<String> billnoList = new ArrayList<String>();
        List<String> custList = new ArrayList<String>();
		if (!StringUtil.isEmpty(billNormalVO.getCustcd())) 
		{ // 出质人
			omap.put("custcd", billNormalVO.getCustcd());
		}
		if (!StringUtil.isEmpty(billNormalVO.getKeeperName_Q()))
		{// 保管人名称
			omap.put("keeperName", billNormalVO.getKeeperName());
		}
		if (!StringUtil.isEmpty(billNormalVO.getSlaveContno())) 
		{ // 质押合同号
			omap.put("slaveContno", billNormalVO.getSlaveContno());
		}
		if(!StringUtil.isEmpty(billNormalVO.getBillcode()))
		{ //仓单号
			omap.put("billcode", billNormalVO.getBillcode());
		}
		if(!StringUtil.isEmpty(billNormalVO.getStartDate()))
		{ //开始时间  从
			omap.put("startDate", billNormalVO.getStartDate());
		}
		if(!StringUtil.isEmpty(billNormalVO.getStartDate1()))
		{ //开始时间  到
			omap.put("startDate1", billNormalVO.getStartDate1());
		}
		if(!StringUtil.isEmpty(billNormalVO.getEndDate()))
		{ //结束时间  从
			omap.put("endDate", billNormalVO.getEndDate());
		}
		if(!StringUtil.isEmpty(billNormalVO.getEndDate1()))
		{ //结束时间  到
			omap.put("endDate1", billNormalVO.getEndDate1());
		}
		if(!StringUtil.isEmpty(billNormalVO.getStatus()))
		{ //状态
			omap.put("status", billNormalVO.getStatus());
		}
		if (billNormalVO.isSelectFlag_Q()) 
		{
			if (!StringUtil.isEmpty(billNormalVO.getBillno())) 
			{
				if(billNormalVO.getBillno().indexOf("/f")==-1)
				{
					omap.put("billno", billNormalVO.getBillno());
				}else
				{
					String[] ids=billNormalVO.getBillno().split("/f");
					for(int i=0;i<ids.length-1;i++)
					{
						if(!StringUtil.isEmpty(ids[i]))
						{
							billnoList.add(ids[i]);
						}
					}
				}
			}
			else
			{
				omap.put("flag", "#");
			}
		}
		if(billnoList.size()>0)
		{
			omap.put("billnoList", billnoList);
		}
		if(ScfBasConstant.CUST_QUERY_TYPE_BY_MAA.equals(billNormalVO.getFlag()))
		{//按主管客户经理+协管客户经理
			custList = customerservice.getCustcdsQueryCondition("cust.custcd", ScfBasConstant.QUERY_TYPE_MAG_ALL, ContextHolder.getUserInfo().getTlrNo());
		}
		if(custList.size()>0)
		{
			omap.put("custList", custList);
		}
		
		int total = extsbcpnwrdao.countEffectNormalList(omap);
		Page page = new Page(billNormalVO.getPageSize(), billNormalVO.getPageIndex(), total);
		page.setRecords(extsbcpnwrdao.getEffectNormalList(omap,page));
		return page;
	}
	
	/**
	 * 
	 * @param qryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月17日上午9:34:30
	 */
	@Override
	public Page getBillnormalListByAppno(BillNormalVO qryVO, boolean flag) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(qryVO.getAppno())) 
		{
			omap.put("appno", qryVO.getAppno());
		}
		if (!StringUtil.isEmpty(qryVO.getStatus())) 
		{
			omap.put("status", qryVO.getStatus());
		}
//		if(SCFConstants.CUST_QUERY_TYPE_BY_MAA.equals(qryVO.getFlag_Q())){//按主管客户经理+协管客户经理
//			sb.append(CustomerService.getInstance().getCustcdsQueryCondition("tmbs.custcd", SCFConstants.QUERY_TYPE_MAG_ALL, GlobalInfo.getCurrentInstance().getTlrno()));
//		}
		
		int total = extsbcpnwrdao.countBillnormalListByAppno(omap);
		Page page = new Page(qryVO.getPageSize(), qryVO.getPageIndex(), total);
		List<SBcpBillNormalAppVO> list = extsbcpnwrdao.getBillnormalListByAppno(omap,page,flag);
		for(SBcpBillNormalAppVO appVO:list)
		{
			String cname = bcrmbaseinfodao.selectById(appVO.getCustcd()).getCname();
			String billno = appVO.getBillno();
			BigDecimal sum = this.getSubByBillno(billno);
			appVO.setCname(cname);
			appVO.setWhReceiptValue(sum);//仓单价值
		}
		page.setRecords(list);
		return page;
	}
	
	/**
	 * 保存业务申请基本信息
	 * @param appliBussInfo
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月17日下午3:28:25
	 */
	@Override
	public String saveAppliBaseInfo(BillStandardBussInfoVO appliBussInfo) throws ScubeBizException
	{
		String appliType = appliBussInfo.getApplyType();
		String appno = "";
		if(appliType.equals(WorkflowConstant.APPLI_TYPE_BILL_NORMAL_QUALITYAPPLI))
		{
			appno = bSysSerialNoService.genSerialNo("FBZY_APP_NO");
		}
		else if(appliType.equals(WorkflowConstant.APPLI_TYPE_BILL_NORMAL_ADD_APPLI))
		{
			appno = bSysSerialNoService.genSerialNo("FBZJ_APP_NO");
		}
		BPbcAppliBaseInfo tblAppliBaseInfo = new BPbcAppliBaseInfo();
		tblAppliBaseInfo.setCustcd(appliBussInfo.getCustcd()); // 客户号
		tblAppliBaseInfo.setCurcd(appliBussInfo.getCurcd()); // 币种
		tblAppliBaseInfo.setProcessTemplateName(appliBussInfo.getWorkApplyType()); // 流程名称
		tblAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO); // 业务编号类型
		tblAppliBaseInfo.setBusinessno(appliBussInfo.getSlaveContno());  //
		tblAppliBaseInfo.setAppliType(appliBussInfo.getApplyType()); // 申请类型
		if(StringUtil.isEmpty(appliBussInfo.getAppliStatus())){// 申请状态:
			tblAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
		}else{
			tblAppliBaseInfo.setAppliStatus(appliBussInfo.getAppliStatus()); // 申请状态
		}
		if(StringUtil.isEmpty(appliBussInfo.getAppliStatusDtl())){// 申请状态明细:
			tblAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
		}else{
			tblAppliBaseInfo.setAppliStatusDtl(appliBussInfo.getAppliStatusDtl()); // 申请状态
		}
		tblAppliBaseInfo.setStartTime(new Date()); // 流程发票日期
		tblAppliBaseInfo.setSupplyChainPdId(appliBussInfo.getBussType()); // 产品ID
		tblAppliBaseInfo.setMastContno(appliBussInfo.getMastContno()); // 主合同号
		tblAppliBaseInfo.setSlaveContno(appliBussInfo.getSlaveContno());//抵质押合同号
		tblAppliBaseInfo.setMemo(appliBussInfo.getMemo()); // 描述
		tblAppliBaseInfo.setAmt(appliBussInfo.getAmount());  // 业务金额
		tblAppliBaseInfo.setAppno(appno);
		appno = bpbcapplibaseinfoservice.save(tblAppliBaseInfo);
		return appno;
	}
	
	/**
	 * 更新业务申请基本信息
	 * @Description: 更新业务申请基本信息
	 * @author zhangwu
	 * @Created 2013-7-9下午03:20:17
	 * @param appliBussInfo
	 * @param isUpdateApproveInfo
	 * @throws ScubeBizException
	 */
	@Override
	public void updateAppliBaseInfo(BillStandardBussInfoVO appliBussInfo,boolean isUpdateApproveInfo) throws ScubeBizException
	{
		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appliBussInfo.getAppno());
		if(isUpdateApproveInfo){// 更新审批信息
			tblAppliBaseInfo.setAppBrcode(ContextHolder.getOrgInfo().getBrNo()); // 审批人机构
			tblAppliBaseInfo.setApprover(ContextHolder.getUserInfo().getTlrNo()); // 审批人
			tblAppliBaseInfo.setApproveTime(new Date()); //审批时间
			tblAppliBaseInfo.setAppDate(ScfDateUtil.formatDate(new Date()));	  // 审批日期
		}
		if(!StringUtil.isEmpty(appliBussInfo.getAmount())){
			tblAppliBaseInfo.setAmt(appliBussInfo.getAmount());  // 业务金额
		}
		if(!StringUtil.isEmpty(appliBussInfo.getBusinessno())){
			tblAppliBaseInfo.setBusinessno(appliBussInfo.getBusinessno());
		}
		if(!StringUtil.isEmpty(appliBussInfo.getAppliStatus())){// 申请状态:
			tblAppliBaseInfo.setAppliStatus(appliBussInfo.getAppliStatus());
		}
		if(!StringUtil.isEmpty(appliBussInfo.getAppliStatusDtl())){// 申请状态明细:
			tblAppliBaseInfo.setAppliStatusDtl(appliBussInfo.getAppliStatusDtl());
		}
		if(!StringUtil.isEmpty(appliBussInfo.getMemo())){
			tblAppliBaseInfo.setMemo(appliBussInfo.getMemo());
		}
		bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(tblAppliBaseInfo);
	}
	
	/**
	 * 保持仓单质押中的仓单信息
	 * @Description:保持仓单质押中的仓单信息
	 * @author zhangcheng
	 * @Created 2013-9-30上午09:33:15
	 * @param list,appno
	 * @throws ScubeBizException
	 */
	@Override
	public void BillNormalApplyInfSave(List<BillNormalAppVO> list,String appno) throws ScubeBizException
	{
		this.deleteBillNormalApplyInfo(appno,ScfBasConstant.BILL_MANAGE_STATUS_INPUT);//保持信息前，先进行删除
		BillNormalAppVO appVO = new BillNormalAppVO();
		for(int i=0;i<list.size();i++){
			appVO=list.get(i);
			if(!bpbcmtgbaseinfoservice.isBillstandardMorgNoExist(appVO.getBillno())){
				throw new ScubeBizException("仓单编号【"+appVO.getBillcode()+"】下不存在押品信息，不能质押申请！", RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			SBcpAppliMortBillNormal billNormal=new SBcpAppliMortBillNormal();
			BeanUtils.copyProperties(appVO, billNormal);
			billNormal.setAppno(appno);
			billNormal.setBillno(appVO.getBillno());
			billNormal.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
			billNormal.setId(UUIDGeneratorUtil.generate());
			sbcpapplimortbillnormaldao.insertSelective(billNormal);
		}
	}

	/**
	 * 删除非标仓单质押仓单列表
	 * @param appno
	 * @param status
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月17日下午3:43:02
	 */
	@SuppressWarnings({ "rawtypes" })
	public void deleteBillNormalApplyInfo(String  appno,String status) throws ScubeBizException
	{
		BillNormalVO qryVO=new BillNormalVO();
		qryVO.setAppno(appno);
		qryVO.setStatus(status);
		List list = this.getBillnormalListByAppno(qryVO, false).getRecords();
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++)
			{
				SBcpBillNormalAppVO mortBillNormal = (SBcpBillNormalAppVO) list.get(i);
				SBcpAppliMortBillNormalExample example = new SBcpAppliMortBillNormalExample();
				SBcpAppliMortBillNormalExample.Criteria cri = example.createCriteria();
				cri.andBillnoEqualTo(mortBillNormal.getBillno());
				sbcpapplimortbillnormaldao.deleteByExample(example);
			}
		}
	}
	
	/**
	 * 业务管理-押品清单查询
	 * @param qryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月24日上午10:15:54
	 */
	@Override
	public Page getBillnormalListBySlaveContno(BillNormalVO qryVO) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		
		SBcpMortBillNormalExample example = new SBcpMortBillNormalExample();
		SBcpMortBillNormalExample.Criteria cri = example.createCriteria();
		
		if (!StringUtil.isEmpty(qryVO.getSlaveContno())) 
		{
			omap.put("slaveContno", qryVO.getSlaveContno());
		}
		if (!StringUtil.isEmpty(qryVO.getStatus())) 
		{
			cri.andStatusEqualTo(qryVO.getStatus());
			omap.put("status", qryVO.getStatus());
		}

		int total = extsbcpnwrdao.countBillnormalListBySlaveContno(omap);
		Page page = new Page(qryVO.getPageSize(), qryVO.getPageIndex(), total);
		page.setRecords(extsbcpnwrdao.getBillnormalListBySlaveContno(omap, page));
		
		return page;
	}
	
	/**
	 * 查询已质押可以提货的仓单
	 * @param vo
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月26日上午10:25:41
	 */
	@Override
	public Page getBillNormalDeliverableList(BillNormalVO billNormalVO) throws ScubeBizException 
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		List<String> statusList =new ArrayList<String>();
		if(StringUtil.isEmpty(billNormalVO.getFlag()))
		{//in
			omap.put("flag1", 1);
			statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
			statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_LOAN);
		}
		else
		{//not in
			omap.put("flag2", 1);
			statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_INPUT);
			statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_DELIVERY);
			statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_ADJUST);
		}
		if(statusList!=null&&statusList.size()>0)
		{
			omap.put("statusList", statusList);
		}
		if(!StringUtil.isEmpty(billNormalVO.getSlaveContno()))
		{
			omap.put("slaveContno", billNormalVO.getSlaveContno());
		}
		if(!StringUtil.isEmpty(billNormalVO.getCustcd()))
		{
			omap.put("custcd", billNormalVO.getCustcd());
		}
		
		int total = extsbcpnwrdao.countBillNormalDeliverableList(omap);
		Page page = new Page(billNormalVO.getPageSize(), billNormalVO.getPageIndex(), total);
		page.setRecords(extsbcpnwrdao.getBillNormalDeliverableList(omap, page));
		return page;
	}
	
	/**
	 * 非标仓单提货 合同协议敞口相关申请信息
	 * @param qryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午1:33:23
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public DeliveyApplyVO getBillNormalDeliveryInfo(BillNormalAppVO qryVO) throws ScubeBizException
	{
		DeliveyApplyVO applyVO = new DeliveyApplyVO();
		if(StringUtil.isEmpty(qryVO.getAppno()))
		{

			com.huateng.scf.bas.crr.dao.model.BCrrGntyCon tblContSlaveInfo= bcrrgntycondao.selectByPrimaryKey(qryVO.getSlaveContno());
			BCntMprotBaseInfo tblMutiProtBaseInfo = bcntmprotbaseinfodao.selectByPrimaryKey(tblContSlaveInfo.getPrtclNo());

//			DeliveryApplyQryVO commonQueryVO =new  DeliveryApplyQryVO();
//			commonQueryVO.setProtocolNo_Q(tblContSlaveInfo.getProtocolNo());
//			commonQueryVO.setRole_Q("02");
//			commonQueryVO.setPageIndex(1);
//			commonQueryVO.setPageSize(Integer.MAX_VALUE);
//			PageQueryResult PageQu=ContractService.getInstance().getMutiProtPartInfoByPara(commonQueryVO);
//			List list1=PageQu.getQueryResult();
//			Iterator it =list1.iterator();
//			String  MoniCustcd="";
//			while(it.hasNext()){
//				TblMutiProtPartInfo TblMutiProtPartInfo=(com.huateng.scf.contractmng.data.TblMutiProtPartInfo) it.next();
//				MoniCustcd = TblMutiProtPartInfo.getCustcd();
//
//			}
//			applyVO.setMoniCustcd(MoniCustcd);
			//仓单质押价值
			applyVO.setRation(tblContSlaveInfo.getRation());//质押率
			List pledgeList= bpbcmtgbaseinfoservice.calBillPledgePriceBySlaveContno(qryVO.getSlaveContno());
			List allList = bpbcmtgbaseinfoservice.calBillAllPriceBySlaveContno(qryVO.getSlaveContno());
			if(null!=pledgeList&&pledgeList.size()>0)
			{
				Map<String, BigDecimal> object = (Map<String, BigDecimal>)pledgeList.get(0);
				if(null!=object){
					applyVO.setTotalPrice(object.get("totPrice"));
					applyVO.setTotalPrice(applyVO.getTotalPrice().multiply(applyVO.getRation())
						.divide(BigDecimal.TEN).divide(BigDecimal.TEN,2,BigDecimal.ROUND_HALF_DOWN));
				}
				else
				{
					applyVO.setTotalPrice(BigDecimal.ZERO.setScale(2));
				}
			}
			if(null!=allList&&allList.size()>0)
			{
				Map<String, BigDecimal> object = (Map<String, BigDecimal>)allList.get(0);
				if(null!=object)
				{
					applyVO.setMortAmount(object.get("totPrice"));
					applyVO.setMortAmount(applyVO.getMortAmount().multiply(applyVO.getRation())
						.divide(BigDecimal.TEN).divide(BigDecimal.TEN,2,BigDecimal.ROUND_HALF_DOWN));
				}
				else
				{
					applyVO.setMortAmount(BigDecimal.ZERO.setScale(2));
				}
			}
			//融资金额 敞口
			BigDecimal lnciAmt=BigDecimal.ZERO;
			BigDecimal lnciBal=BigDecimal.ZERO;
			BigDecimal sumBail=BigDecimal.ZERO;
			BigDecimal openAmt=BigDecimal.ZERO;
			List lnciList = blanlncibaseservice.getLnciBaseInfoListBySlaveContno(qryVO.getSlaveContno());
			if(null!=lnciList&&lnciList.size()>0)
			{
				for(int i=0;i<lnciList.size();i++)
				{
					BLanLnciBase lnci = (BLanLnciBase) lnciList.get(i);
					sumBail=sumBail.add(lnci.getBailAmount()!=null?lnci.getBailAmount():BigDecimal.ZERO)
					.add(lnci.getAddBailAmount()!=null?lnci.getAddBailAmount():BigDecimal.ZERO)
					.add(lnci.getInitCashEqtAmt()!=null?lnci.getInitCashEqtAmt():BigDecimal.ZERO)
					.add(lnci.getAddCashEqtAmt()!=null?lnci.getAddCashEqtAmt():BigDecimal.ZERO);
					lnciAmt=lnciAmt.add(lnci.getLnciAmt()!=null?lnci.getLnciAmt():BigDecimal.ZERO);
					lnciBal=lnciBal.add(lnci.getLnciBal()!=null?lnci.getLnciBal():BigDecimal.ZERO);
				}
			}
			openAmt =lnciBal.subtract(sumBail);
			applyVO.setBailAmount(sumBail);
			applyVO.setDebtAmount(lnciAmt);
			applyVO.setRiskamt(openAmt);
			applyVO.setAddBailAmount(BigDecimal.ZERO);
			if(applyVO.getMortAmount().compareTo(applyVO.getRiskamt())>0){
				applyVO.setMaxDeliverValue((applyVO.getMortAmount().subtract(applyVO.getRiskamt()))
						.multiply(BigDecimal.TEN).multiply(BigDecimal.TEN).divide(applyVO.getRation(),2,BigDecimal.ROUND_HALF_DOWN));//可提货价值
			}else{
				applyVO.setMaxDeliverValue(BigDecimal.ZERO);
			}

			applyVO.setSlaveContno(tblContSlaveInfo.getConId());
			applyVO.setSlaveContcode(tblContSlaveInfo.getConId());
			applyVO.setSupplyChainPdId(tblMutiProtBaseInfo.getProductId());
			applyVO.setCustcd(tblContSlaveInfo.getGutId());
			applyVO.setMonitorProtocolNo(tblContSlaveInfo.getPrtclNo());
			applyVO.setProtocolNo(tblContSlaveInfo.getPrtclNo());
			if(!StringUtil.isEmpty(qryVO.getMastContno())){
				applyVO.setMastContno(qryVO.getMastContno());
			}
			applyVO.setCurcd(tblContSlaveInfo.getGutCurcd());
			//获得押品总价
/*				MortgageSumPriceQryVO commonVO = new MortgageSumPriceQryVO();
			commonVO.setSlaveContno_Q(tblContSlaveInfo.getSlaveContno());
			commonVO.setPageIndex(1);
			commonVO.setPageSize(Integer.MAX_VALUE);
			BigDecimal totalPrice = MortgageDynamicService.getInstance().getMortgageSumPriceByParam(commonVO);
			applyVO.setTotalPrice(totalPrice);
			applyVO.setRation(tblContSlaveInfo.getRation());
			AmountService amountService=AmountService.getInstance();
			AmountVO amountVO=new AmountVO(applyVO.getSupplyChainPdId(),tblContSlaveInfo.getSlaveContno());
			//供应链产品种类：动产(动产协议里面暂时没存productId字段)
			amountVO.setMidProductId(SCFConstants.PRODUCT_TYPE_BILL);//动产
		//	BigDecimal amt=amountService.getDelivery(amountVO);//可提货
			BigDecimal pant=amountService.getPant(amountVO);//敞口
*/			//	applyVO.setAmt(amt);
//			applyVO.setMaxDeliverValue(amountService.getDelivery(amountVO));  //可提货金额

//			applyVO.setLowPriceNew(amountVO.getLowPriceNew());//监管下限

			return applyVO;
		}
		else
		{
			BPbcAppliBaseInfo appliInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(qryVO.getAppno());
			if(null!=appliInfo){
				BeanUtils.copyProperties(appliInfo, applyVO);
				applyVO.setAddBailAmount(appliInfo.getBailAmount()!=null?appliInfo.getBailAmount():BigDecimal.ZERO);
				applyVO.setMonitorProtocolNo(appliInfo.getProtocolNo());
				com.huateng.scf.bas.crr.dao.model.BCrrGntyCon tblContSlaveInfo = bcrrgntycondao.selectByPrimaryKey(appliInfo.getSlaveContno());
				/*AmountVO amountVO=new AmountVO(appliInfo.getSupplyChainPdId(),slaveContno);
				amountVO.setMidProductId(SCFConstants.PRODUCT_TYPE_BILL);//仓单
//				BigDecimal amt=amountService.getDelivery(amountVO);//可提货
				BigDecimal pant=amountService.getPant(amountVO);//敞口
				*/
				applyVO.setRation(tblContSlaveInfo.getRation());//质押率
				//仓单质押价值
				List pledgeList = bpbcmtgbaseinfoservice.calBillPledgePriceBySlaveContno(appliInfo.getSlaveContno());
				List allList = bpbcmtgbaseinfoservice.calBillAllPriceBySlaveContno(appliInfo.getSlaveContno());
				if(null!=pledgeList&&pledgeList.size()>0)
				{
					Map<String, BigDecimal> object = (Map<String, BigDecimal>)pledgeList.get(0);
					if(null!=object){
						applyVO.setTotalPrice(object.get("totPrice"));
						applyVO.setTotalPrice(applyVO.getTotalPrice().multiply(applyVO.getRation())
							.divide(BigDecimal.TEN).divide(BigDecimal.TEN,2,BigDecimal.ROUND_HALF_DOWN));
					}
				}else
				{
					applyVO.setTotalPrice(BigDecimal.ZERO);
				}
				if(null!=allList&&allList.size()>0)
				{
					Map<String, BigDecimal> object = (Map<String, BigDecimal>)allList.get(0);
					if(null!=object)
					{
						applyVO.setMortAmount(object.get("totPrice"));
						applyVO.setMortAmount(applyVO.getMortAmount().multiply(applyVO.getRation())
							.divide(BigDecimal.TEN).divide(BigDecimal.TEN,2,BigDecimal.ROUND_HALF_DOWN));
					}
				}
				else
				{
					applyVO.setMortAmount(BigDecimal.ZERO);
				}
				//融资金额 敞口
				BigDecimal lnciAmt=BigDecimal.ZERO;
				BigDecimal lnciBal=BigDecimal.ZERO;
				BigDecimal sumBail=BigDecimal.ZERO;
				BigDecimal openAmt=BigDecimal.ZERO;
				BigDecimal addBail=BigDecimal.ZERO;
				if(!StringUtil.isEmpty(qryVO.getBailAmount()))
				{
					addBail=qryVO.getBailAmount().setScale(2, BigDecimal.ROUND_HALF_UP);
				}
				if(applyVO.getAddBailAmount().compareTo(BigDecimal.ZERO)==0
						&&addBail.compareTo(BigDecimal.ZERO)==0){
					//本次追加保证金
					List accountList = bmrnappliacctinfoservice.findBMrnAppliAcctInfoByAppno(qryVO.getAppno());
					BigDecimal totalAddBailAmount = BigDecimal.ZERO;////本次追加保证金金额
					if(accountList!=null && accountList.size()>0){
			        	for (int i = 0; i < accountList.size(); i++) {
			        		BMrnAppliAcctInfo bean = (BMrnAppliAcctInfo) accountList.get(i);
			        		BigDecimal bailAmount = bean.getAmount()==null?BigDecimal.ZERO:bean.getAmount();//冻结保证金列表
			        		totalAddBailAmount=totalAddBailAmount.add(bailAmount);
			    		}
			        	applyVO.setAddBailAmount(totalAddBailAmount);
					}

				}
				else if(applyVO.getAddBailAmount().compareTo(BigDecimal.ZERO)>0
						&&addBail.compareTo(BigDecimal.ZERO)==0)
				{

				}
				else
				{
					applyVO.setAddBailAmount(addBail);
				}
				List lnciList = blanlncibaseservice.getLnciBaseInfoListBySlaveContno(appliInfo.getSlaveContno());
				if(null!=lnciList&&lnciList.size()>0)
				{
					for(int i=0;i<lnciList.size();i++)
					{
						BLanLnciBase lnci=(BLanLnciBase)lnciList.get(i);
						sumBail=sumBail.add(lnci.getBailAmount()!=null?lnci.getBailAmount():BigDecimal.ZERO)
						.add(lnci.getAddBailAmount()!=null?lnci.getAddBailAmount():BigDecimal.ZERO)
						.add(lnci.getInitCashEqtAmt()!=null?lnci.getInitCashEqtAmt():BigDecimal.ZERO)
						.add(lnci.getAddCashEqtAmt()!=null?lnci.getAddCashEqtAmt():BigDecimal.ZERO);
						lnciAmt=lnciAmt.add(lnci.getLnciAmt()!=null?lnci.getLnciAmt():BigDecimal.ZERO);
						lnciBal=lnciBal.add(lnci.getLnciBal()!=null?lnci.getLnciBal():BigDecimal.ZERO);
					}
				}
				openAmt =lnciBal.subtract(sumBail);
				applyVO.setBailAmount(sumBail);
				applyVO.setDebtAmount(lnciAmt);
				applyVO.setRiskamt(openAmt);

/*					//可提货金额，需要考虑本次追加的保证金金额   add by fengjinfu
				if(applyVO.getBailAmount() !=null && applyVO.getBailAmount().floatValue() > 0)
				{
//					amt = amt.add(applyVO.getBailAmount().
//							multiply(new BigDecimal(100)).
//							divide(applyVO.getRation(),2,BigDecimal.ROUND_HALF_UP));
				}  */


				applyVO.setDeliverValue(appliInfo.getAmt());//本次提货价值
				if((applyVO.getMortAmount().add(applyVO.getAddBailAmount())).compareTo(applyVO.getRiskamt())>0){
					applyVO.setMaxDeliverValue((applyVO.getAddBailAmount().add(applyVO.getMortAmount()).subtract(applyVO.getRiskamt()))
							.multiply(BigDecimal.TEN).multiply(BigDecimal.TEN).divide(applyVO.getRation(),2,BigDecimal.ROUND_HALF_DOWN));//可提货价值
				}else{
					applyVO.setMaxDeliverValue(BigDecimal.ZERO);
				}
			}
		}
		return applyVO;
	}

	/**
	 * 非标仓单提货 仓单列表信息查询
	 * @param mortgageQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午2:34:00
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getBillNormalDeliveryList(BillNormalMortgageQryVO mortgageQryVO) throws ScubeBizException
	{
		Page result =new Page();
		if(StringUtil.isEmpty(mortgageQryVO.getAppno()))
		{
			result = sbcpmortbillnormalservice.queryMortgageBillNormal(mortgageQryVO);
		}
		else
		{
			List list = sbcpapplimortbillnormalservice.findByProperty(mortgageQryVO.getAppno());
			if(null!=list&&list.size()>0)
			{
				SBcpAppliMortBillNormal apply = (SBcpAppliMortBillNormal)list.get(0);
				SBcpMortBillNormal bill = sbcpmortbillnormaldao.selectByPrimaryKey(apply.getBillno());
				List<SBcpMortBillNormal> resultList =new ArrayList<SBcpMortBillNormal>();
				resultList.add(bill);
				result.setRecords(resultList);
				result.setTotalRecord(1);
			}
		}
		return result;
	}
	
	/**
	 * 非标仓单提货 押品查询
	 * @param mortgageQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午2:54:24
	 */
	@Override
	public Page getBillNormalDeliveryApplyList(BillNormalMortgageQryVO mortgageQryVO) throws ScubeBizException
	{
		Page result =new Page();
		List<MortgageApplyVO> resultList =new ArrayList<MortgageApplyVO>();
		MortgageApplyVO vo=null;
		Map<String, BigDecimal> map =new HashMap<String, BigDecimal>();
		if(!StringUtil.isEmpty(mortgageQryVO.getAppno()))
		{
			List<BPbcAppliMtgInfo> applyList = bpbcapplimtginfoservice.findBPbcAppliMtgInfoByAppno(mortgageQryVO.getAppno());
			if(null!=applyList&&applyList.size()>0)
			{
				for(BPbcAppliMtgInfo appInfo:applyList)
				{
//					vo =new MortgageApplyVO();
//					CommonFunction.copyProperties(vo, appInfo);
//					resultList.add(vo);
					if(null!=appInfo){
						map.put(appInfo.getMortgageNo(), appInfo.getBalQuantity());
					}
				}
			}
		}
		if(!StringUtil.isEmpty(mortgageQryVO.getBillno()))
		{
			Page appResult =bpbcmtgbaseinfoservice.getBillNormalUnlockedByBillno(mortgageQryVO);
			result = appResult;
			if(null!=appResult.getRecords()&&appResult.getRecords().size()>0)
			{
				for(int i=0;i<appResult.getRecords().size();i++)
				{
					com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo baseInfo =
							(com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo) appResult.getRecords().get(i);
					vo = new MortgageApplyVO();
					BeanUtils.copyProperties(baseInfo, vo);
					if(map.containsKey(vo.getMortgageNo()))
					{
						vo.setBalQuantity((BigDecimal)map.get(vo.getMortgageNo()));
					}
					else
					{
						vo.setBalQuantity(BigDecimal.ZERO);
					}
					vo.setAmt((vo.getConfirmPrice()!=null?vo.getConfirmPrice():BigDecimal.ZERO)
							.multiply(vo.getBalQuantity()!=null?vo.getBalQuantity():BigDecimal.ZERO));
					resultList.add(vo);
				}
			}
		}
		result.setRecords(resultList);
		return result;
	}

	/**
	 * 非标仓单提货 保存基本申请信息
	 * @param appVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午5:09:11
	 */
	@Override
	public String normalDeliverApplySaveBaseInfo(DeliveyApplyVO appVO) throws ScubeBizException
	{
		BPbcAppliBaseInfo tblAppliBaseInfo = null;
		String appno=appVO.getAppno();
		if(StringUtil.isEmpty(appno)){
			tblAppliBaseInfo=new BPbcAppliBaseInfo();
			appno = bSysSerialNoService.genSerialNo("FBTH_APP_NO");
			tblAppliBaseInfo.setAppno(appno);
			tblAppliBaseInfo.setCustcd(appVO.getCustcd()); // 客户号
			tblAppliBaseInfo.setCurcd(appVO.getCurcd()); // 币种
			tblAppliBaseInfo.setProcessTemplateName(appVO.getProcessTemplateName()); // 流程名称
			tblAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO); // 业务编号类型
			tblAppliBaseInfo.setBusinessno(appVO.getSlaveContno());  //
			tblAppliBaseInfo.setAppliType(appVO.getAppliType()); // 申请类型
			tblAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			tblAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			tblAppliBaseInfo.setSupplyChainPdId(appVO.getSupplyChainPdId()); // 产品ID
			tblAppliBaseInfo.setMastContno(appVO.getMastContno()); // 主合同号
			tblAppliBaseInfo.setSlaveContno(appVO.getSlaveContno());//抵质押合同号
			tblAppliBaseInfo.setMemo(appVO.getMemo()); // 描述
			tblAppliBaseInfo.setAmt(appVO.getDeliverValue());  // 提货价值
			tblAppliBaseInfo.setBailAmount(appVO.getAddBailAmount());//本次追加保证金金额
			appno = bpbcapplibaseinfoservice.save(tblAppliBaseInfo);
		}
		else
		{
			tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			if(null!=tblAppliBaseInfo){
				tblAppliBaseInfo.setAmt(appVO.getDeliverValue());  // 提货金额
				tblAppliBaseInfo.setBailAmount(appVO.getAddBailAmount());//本次追加保证金金额
			}
			bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(tblAppliBaseInfo);

		}
		return appno;
	}
	
	/**
	 *
	 * @Description: 非标提货申请 保存S_BCP_APPLI_MORT_BILL_NORMAL
	 * @author jialei.zhang
	 * @Created 2014年3月4日上午9:59:00
	 * @param billList
	 * @param appno
	 * @throws CommonException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void saveAppliMortgageBillNormal(List<BillNormalMortgageVO> billList, String appno) throws ScubeBizException
	{
		//delete
		List applyList = sbcpapplimortbillnormalservice.findByProperty(appno);
		if(null!=applyList&&applyList.size()>0)
		{
			for(int i=0;i<applyList.size();i++)
			{
				SBcpAppliMortBillNormal appInfo = (SBcpAppliMortBillNormal)applyList.get(i);
				sbcpapplimortbillnormaldao.deleteByPrimaryKey(appInfo.getId());
			}
		}
		//add
		SBcpAppliMortBillNormalVO appInfo=null;
		if(null!=billList&&billList.size()>0)
		{
			for(int i=0;i<billList.size();i++)
			{
				BillNormalMortgageVO vo=(BillNormalMortgageVO)billList.get(i);
				appInfo =new SBcpAppliMortBillNormalVO();
				BeanUtils.copyProperties(vo, appInfo);
				appInfo.setId(null);
				appInfo.setAppno(appno);
				sbcpapplimortbillnormalservice.save(appInfo);
			}
		}
	}
	
	/**
	 * 非标提货申请 保存 B_PBC_APPLI_MTG_INFO 锁定B_PBC_MTG_BASE_INFO
	 * @param mortList
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午5:31:28
	 */
	@Override
	public void saveAppliMortgageDeliverList(List<MortgageApplyVO> mortList,String appno) throws ScubeBizException
	{
		//delete release
		bpbcapplimtginfoservice.delAppliMortgageListByAppno(appno);
		//add lock
		if(null!=mortList&&mortList.size()>0)
		{
			BPbcAppliMtgInfo appInfo=null;
			for(int i=0;i<mortList.size();i++)
			{
				MortgageApplyVO vo = (MortgageApplyVO)mortList.get(i);
				if(!StringUtil.isEmpty(vo.getMortgageNo()))
				{
					BPbcMtgBaseInfo mortInfo = bpbcmtgbaseinfoservice.findBPbcMtgBaseInfoByKey(vo.getMortgageNo());
					if(null!=mortInfo){
						appInfo =new BPbcAppliMtgInfo();
						BeanUtils.copyProperties(mortInfo, appInfo);
						appInfo.setId(null);
						appInfo.setAppno(appno);
						appInfo.setBalQuantity(vo.getBalQuantity());
						mortInfo.setLockAppno(appno);
						mortInfo.setIsLocked(ScfBasConstant.LOCKED);
						bpbcmtgbaseinfoservice.updateBPbcMtgBaseInfo(mortInfo);
						bpbcapplimtginfoservice.save(appInfo);
					}
					else
					{
						throw new ScubeBizException("押品信息不存在!");
					}
				}

			}
		}
		else
		{
			throw new ScubeBizException("提货押品信息缺失!");
		}
	}
	
	/**
	 * 非标仓单提货 校验数据
	 * @param applyVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日上午11:00:02
	 */
	@Override
	public void checkbillNormalDeliveryBailAmount(DeliveyApplyVO applyVO) throws ScubeBizException
	{
		this.checkBillNormalDeliveryStatus(applyVO.getAppno());
		//敞口校验
		List<BMrnAppliAcctInfo> accountList = bmrnappliacctinfoservice.findBMrnAppliAcctInfoByAppno(applyVO.getAppno());
		BigDecimal totalAddBailAmount = BigDecimal.ZERO;////本次追加保证金金额
		if(accountList!=null && accountList.size()>0){
       	for (int i = 0; i < accountList.size(); i++) {
       		BMrnAppliAcctInfo bean = (BMrnAppliAcctInfo) accountList.get(i);
       		BigDecimal bailAmount = bean.getAmount()==null?BigDecimal.ZERO:bean.getAmount();//冻结保证金列表
       		totalAddBailAmount=totalAddBailAmount.add(bailAmount);
   		}

		}
		if(applyVO.getMortAmount().compareTo(applyVO.getRiskamt())<0&&null==accountList)
		{
			throw new ScubeBizException("可提货金额不足，请追加保证金！",RBcpErrorConstant.ERROR_CODE_DATA_NOT_EQUAL);
		}
		if(applyVO.getMortAmount().add(totalAddBailAmount).compareTo(applyVO.getRiskamt())<0)
		{
			throw new ScubeBizException("可提货金额不足，请追加更多的保证金", RBcpErrorConstant.ERROR_CODE_DATA_NOT_EQUAL);
		}
	}
	

	/**
	 * 仓单状态校验
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日上午11:00:52
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void checkBillNormalDeliveryStatus(String appno) throws ScubeBizException
	{
		List applyList = sbcpapplimortbillnormalservice.findByProperty(appno);
		if(null!=applyList)
		{
			SBcpAppliMortBillNormal app=(SBcpAppliMortBillNormal)applyList.get(0);
			if(null!=app&&!StringUtil.isEmpty(app.getBillno()))
			{
				SBcpMortBillNormal bill = sbcpmortbillnormaldao.selectByPrimaryKey(app.getBillno());
				if(null!=bill)
				{
					if(!ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE.equalsIgnoreCase(bill.getStatus())
							&&!ScfBasConstant.BILL_MANAGE_STATUS_LOAN.equals(bill.getStatus()))
					{
						throw new ScubeBizException("该仓单已解押或者置换，不可提货", RBcpErrorConstant.ERROR_CODE_APPINFO_ERROR);
					}
				}
			}
		}
	}
	

	/**
	 * 非标仓单提货 更新BPbcAppliBaseInfo保证金金额
	 * @param bussAppno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午2:50:48
	 */
	@Override
	public void billNormalDeliveryUpdateBailAmount(String bussAppno) throws ScubeBizException
	{
		List<BMrnAppliAcctInfo> accountList = bmrnappliacctinfoservice.findBMrnAppliAcctInfoByAppno(bussAppno);
		BigDecimal totalAddBailAmount = BigDecimal.ZERO;////本次追加保证金金额
		if(accountList!=null && accountList.size()>0)
		{
        	for (int i = 0; i < accountList.size(); i++) 
        	{
        		BMrnAppliAcctInfo bean = (BMrnAppliAcctInfo) accountList.get(i);
        		BigDecimal bailAmount = bean.getAmount()==null?BigDecimal.ZERO:bean.getAmount();//冻结保证金列表
        		totalAddBailAmount=totalAddBailAmount.add(bailAmount);
    		}

		}
		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(bussAppno);
		if(null!=appliBaseInfo)
		{
			appliBaseInfo.setBailAmount(totalAddBailAmount);
			bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(appliBaseInfo);
		}
		else
		{
			throw new ScubeBizException("申请信息丢失", RBcpErrorConstant.ERROR_CODE_APPINFO_ERROR);
		}
	}

	/**
	 * 查询非标准普通仓单明细
	 * @param id
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日上午10:07:26
	 */
	@Override
	public SBcpMortBillNormalVO getNormalById(String id) throws ScubeBizException
	{
		SBcpMortBillNormal bcpMortBillNormal = sbcpmortbillnormaldao.selectByPrimaryKey(id);
		SBcpMortBillNormalVO bcpMortBillNormalVO = new SBcpMortBillNormalVO();
		BeanUtils.copyProperties(bcpMortBillNormal, bcpMortBillNormalVO);
		return bcpMortBillNormalVO;//非标准仓单查询
	}
	
	/**
	 * 保持仓单追加中的仓单信息
	 * @param list
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日上午11:02:11
	 */
	@Override
	public void BillNormalAddApplyInfSave(List<BillNormalAppVO> list,String appno) throws ScubeBizException
	{
		this.deleteBillNormalApplyInfo(appno);//保持信息前，先进行删除
		BillNormalAppVO appVO=new BillNormalAppVO();
		for(int i=0;i<list.size();i++)
		{
			appVO=list.get(i);
			if(!bpbcmtgbaseinfoservice.isBillstandardMorgNoExist(appVO.getBillno()))
			{
				throw new ScubeBizException("仓单编号【"+appVO.getBillcode()+"】下不存在押品信息，不能质押申请！", RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			SBcpAppliMortBillNormalVO billNormal=new SBcpAppliMortBillNormalVO();
			BeanUtils.copyProperties(appVO, billNormal);
			billNormal.setAppno(appno);
			billNormal.setBillno(appVO.getBillno());
			billNormal.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
			billNormal.setId(UUIDGeneratorUtil.generate());
			sbcpapplimortbillnormalservice.save(billNormal);
		}
	}
	
	/**
	 * 仓单信息删除
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日上午11:03:33
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void deleteBillNormalApplyInfo(String  appno) throws ScubeBizException
	{
		BillNormalVO qryVO=new BillNormalVO();
		qryVO.setAppno(appno);
		List list = this.getBillnormalListByAppno(qryVO, false).getRecords();
		if(list!=null&&list.size()>0)
		{
			for(int i=0;i<list.size();i++){
				SBcpBillNormalAppVO map = (SBcpBillNormalAppVO) list.get(i);
				String id = map.getId();
				sbcpapplimortbillnormaldao.deleteByPrimaryKey(id);
			}
		}
	}
	
	/**
	 * 
	 * @param billno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日上午9:27:12
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BigDecimal getSubByBillno(String billno) throws ScubeBizException
	{
		List list = bpbcmtgbaseinfoservice.getAppliReceiptPledgeAmountBybillno(billno);
		if(list.size()>0)
		{
			Map<String,BigDecimal> map = (Map<String, BigDecimal>) list.get(0);
			BigDecimal sum = map.get("totPrice");
			return sum;
		}
		return new BigDecimal("0.00");
	}

	/**
	 * 新增仓单解押申请保存
	 * @param basicApplyVO
	 * @param outInsertList
	 * @param outUpdateList
	 * @param outDelList
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午1:46:03
	 */
	@Override
	public String updateReceiptAppBasic(BillNormalAppVO billNormalAppVO, List<BillNormalAppVO> outInsertList,
			List<BillNormalAppVO> outUpdateList, List<BillNormalAppVO> outDelList)
			throws ScubeBizException {

		// 换货申请-维护TBL_APPLI_BASE_INFO[业务申请基本信息表]
		String appno = bpbcapplibaseinfoservice.addBillNormalReceiptAppInfo(billNormalAppVO);
		// 维护TBL_APPLI_MORTGAGE_BASE_INFO[业务申请仓单基本信息]-----begin 解押出库操作
		sbcpapplimortbillnormalservice.updateReceiptAppOutStorage(appno,
				outInsertList, outUpdateList, outDelList);
		// 维护维护TBL_APPLI_MORTGAGE_BASE_INFO[业务申请仓单下对应押品基本信息清单]
		bpbcapplimtginfoservice.updatebillNoramlMortgageAppOutStorage(appno,
				outInsertList, outUpdateList, outDelList);
		return appno;
	}
	
	/**
	 * getReceiptAppListMngAdd 预解押仓单列表
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午3:01:09
	 */
	@Override
	public Page getReceiptAppListMngAdd(BillNormalAppVO billNormalAppVO) throws ScubeBizException
	{
		if (StringUtil.isEmpty(billNormalAppVO.getAppno()))
		{ // 申请编号
			return new Page();
		}
		Page page = bpbcapplibaseinfoservice.getWareMnAddByPara(billNormalAppVO);
		return page;
	}
	
	/**
	 * 标准仓单解压信息存入正式表
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午4:51:49
	 */
	@Override
	public void copyStandardUpledgeAppInfoToDelTable(String appno) throws ScubeBizException
	{
		BPbcAppliBaseInfo appBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno); // 主申请信息
		if(appBaseInfo==null)
		{
			throw new ScubeBizException("主申请信息信息丢失，无法生成相关信息");
		}
		// 保存 业务流水信息
		String pid = bpbcmtgstordeliservice.addTblMortgageStorDeliInfo(appBaseInfo, ScfBasConstant.STOR_OR_DELI_OUT, ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_RECEIPT, null,
				appBaseInfo.getSupplyChainPdId());

		// 解押出库申请：复制业务申请用仓单申请基本信息 到 更新仓单基本信息表、新增出入库信息表
		sbcpmortbillnormalservice.copyNormalUpledgeAppInfoToBill(appno, pid, appBaseInfo);
	}
	
	/**
	 * 仓单申请审批通过，修改正式表及申请表信息
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午5:13:04
	 */
	@Override
	public void updateBillNormalOffAppliStatus(String appno) throws ScubeBizException
	{
		BPbcAppliBaseInfo appBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);// 主申请信息
		if(appBaseInfo==null)
		{
			throw new ScubeBizException("主申请信息信息丢失，无法生成相关信息");
		}
		//保存业务流水信息表 add by saiyao.gao 2011-6-10
		String pid = bpbcmtgstordeliservice.addTblMortgageStorDeliInfo(appBaseInfo, ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_RECEIPT, ScfBasConstant.STOR_OR_DELI_OUT, null, appBaseInfo.getSupplyChainPdId());
		//VO改造 2013-07-13 modify by michael.xu
		sbcpapplimortbillnormalservice.updateTblAppliMortgageBillNormalStatus(appno, pid, appBaseInfo);
	}
	
	/**
	 * 
	 * @param billNormalVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月8日下午5:08:00
	 */
	@Override
	public Page getAppliBillnormalList(BillNormalVO billNormalVO, boolean flag) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(billNormalVO.getAppno())) 
		{
			omap.put("appno", billNormalVO.getAppno());
		}
		if (!StringUtil.isEmpty(billNormalVO.getStatus())) 
		{
			omap.put("status", billNormalVO.getStatus());
		}
		
		int total = extsbcpnwrdao.countAppliBillnormalList(omap);
		Page page = new Page(billNormalVO.getPageSize(), billNormalVO.getPageIndex(), total);
		List<SBcpBillNormalAppVO> list = extsbcpnwrdao.getAppliBillnormalList(omap,page,flag);
		for(SBcpBillNormalAppVO appVO:list)
		{
			String cname = bcrmbaseinfodao.selectById(appVO.getCustcd()).getCname();
			String billno = appVO.getBillno();
			BigDecimal sum = this.getSubByBillno(billno);
			appVO.setCname(cname);
			appVO.setWhReceiptValue(sum);//仓单价值
		}
		page.setRecords(list);
		return page;
	}
	
	/**
	 * 普通仓单置换信息保存
	 * @param vo
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月8日下午6:08:43
	 */
	@Override
	@Transactional
	public void saveAppliWarehouse(BillNormalAppVO billNormalAppVO,String appno) throws ScubeBizException
	{
		SBcpAppliWarehouse taw = sbcpappliwarehousedao.selectByPrimaryKey(appno);
		if(taw!=null)
		{
			sbcpappliwarehousedao.deleteByPrimaryKey(appno);
		}
		taw = new SBcpAppliWarehouse();
		BeanUtils.copyProperties(billNormalAppVO, taw);
		taw.setAppno(appno);
		try
		{
			sbcpappliwarehousedao.insertSelective(taw);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存失败！");
		}
	}
	
	/**
	 * 新增仓单解押申请保存
	 * @param appno
	 * @param outInsertList
	 * @param outUpdateList
	 * @param outDelList
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日上午9:25:16
	 */
	@Override
	public String updateReceiptAppBasic(String appno,List<BillNormalAppVO> outInsertList, 
			List<BillNormalAppVO> outUpdateList, List<BillNormalAppVO> outDelList) throws ScubeBizException 
	{
		// 维护S_BCP_APPLI_MORT_BILL_NORMAL[业务申请仓单基本信息]-----begin 解押出库操作
		sbcpapplimortbillnormalservice.updateReceiptAppOutStorage(appno,
				outInsertList, outUpdateList, outDelList);
		// 维护维护B_PBC_APPLI_MTG_INFO[业务申请仓单下对应押品基本信息清单]
		bpbcapplimtginfoservice.updatebillNoramlMortgageAppOutStorage(appno,
				outInsertList, outUpdateList, outDelList);
		return appno;
	}
	
	/**
	 * 单表获取押品基本信息
	 * @param billstandardQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月11日上午11:20:07
	 */
	@Override
	public Page getMortgageBaseInfo(BillstandardQryVO billstandardQryVO) throws ScubeBizException
	{
		log.info("单表获取押品基本信息 method:getMortgageBaseInfo begin");
		Page pageQueryResult = bpbcmtgbaseinfoservice.getMortgageBaseInfoByPara(billstandardQryVO);
		log.info("单表获取押品基本信息 method:getMortgageBaseInfo end");
		return pageQueryResult;
	}

}
