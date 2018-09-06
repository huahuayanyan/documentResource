package com.huateng.scf.sto.nwr.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStorDeliService;
import com.huateng.scf.sto.nwr.service.IBillManagerService;
import com.huateng.scf.sto.nwr.service.ISBcpAppliMortBillNormalService;
import com.huateng.scf.sto.nwr.service.ISBcpBillNormalInOutService;
import com.huateng.scf.sto.nwr.vo.BillNormalInOutQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>仓单管理</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月19日上午10:02:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月19日上午10:02:21	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillManagerServiceImpl")
public class BillManagerServiceImpl implements IBillManagerService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	//押品业务申请表
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;
		
	//非标仓单业务申请
	@Resource(name = "SBcpAppliMortBillNormalServiceImpl")
	ISBcpAppliMortBillNormalService sbcpapplimortbillnormalservice;
	
	//业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;

	//质押合同表
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bcntmprotpartinfoservice;
	
	//押品变更流水信息表
	@Resource(name = "BPbcMtgStorDeliServiceImpl")
	IBPbcMtgStorDeliService bpbcmtgstordeliservice;
	
	@Resource(name = "SBcpBillNormalInOutServiceImpl")
	ISBcpBillNormalInOutService sbcpbillnormalinoutservice;
		
	/**
	 * 普通仓单质押--正式表的写入
	 * 1、仓单置换---入库仓单的质押操作--仓单流水表的写入--入库押品的维护
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月19日上午10:18:25
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void saveTblMortgageBillNorInf(String appno) throws ScubeBizException
	{
		log.debug("appno="+appno);
		// 监管公司客户号
		HashMap<String, Object> poMap = new HashMap<String, Object>();
		poMap.put("appno", appno); // 申请编号
		poMap.put("appliMortBizType", ScfBasConstant.MORT_BIZ_TYPE_NORMAL_PLEDGE_IN);// 申请业务押品清单业务类型（仓单置换入库）
		List<BPbcAppliMtgInfo> appMorgInfoList = bpbcapplimtginfoservice.findByConditionException("BPbcAppliMtgInfo", poMap, "请先对押品进行核价，并保存！");
		//第一步：根据申请编号 得到主申请信息
		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno); // 主申请信息
		if(tblAppliBaseInfo==null)
		{
			throw new ScubeBizException("主申请信息信息丢失，无法生成相关信息");
		}
		//第二步：保存业务流水信息表 add by saiyao.gao 2011-6-10
		BCrrGntyCon contSlaveInfo = bcrrgntycondao.selectByPrimaryKey(tblAppliBaseInfo.getSlaveContno());
		if(contSlaveInfo==null)
		{
			throw new ScubeBizException("该申请下对应从合同号不存在，无法操作！");
		}
		BCntMprotPartInfo tblMutiProtPartInfo = bcntmprotpartinfoservice.findCustByProtocolNoAndRole(contSlaveInfo.getPrtclNo(), ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		String moniOfCustcd = tblMutiProtPartInfo.getCustcd();

		String pid = bpbcmtgstordeliservice.addTblMortgageStorDeliInfo(tblAppliBaseInfo, ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_EXCHANGE, ScfBasConstant.STOR_OR_DELI_EXP, null, tblAppliBaseInfo.getSupplyChainPdId());
		//第三步：入库仓单的质押操作
		sbcpapplimortbillnormalservice.copyBillAPPInfoToPledge(appno,pid,tblAppliBaseInfo.getMastContno(),tblAppliBaseInfo.getSlaveContno(),appMorgInfoList,moniOfCustcd);
	}
	
	/**
	 * 普通仓单追加--正式表的写入
	 * 1、仓单置换---入库仓单的质押操作--仓单流水表的写入--入库押品的维护
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日下午3:48:41
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void saveTblMortgageBillNorAdd(String appno) throws ScubeBizException
	{
		// 监管公司客户号
		HashMap<String, Object> poMap = new HashMap<String, Object>();
		poMap.put("appno", appno); // 申请编号
		poMap.put("appliMortBizType", ScfBasConstant.MORT_BIZ_TYPE_NORMAL_PLEDGE_IN);// 申请业务押品清单业务类型（仓单置换入库）
		List<BPbcAppliMtgInfo> appMorgInfoList = bpbcapplimtginfoservice.findByConditionException("BPbcAppliMtgInfo", poMap, "请先对押品进行核价，并保存！");
		//第一步：根据申请编号 得到主申请信息
		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno); // 主申请信息
		if(tblAppliBaseInfo==null)
		{
			throw new ScubeBizException("主申请信息信息丢失，无法生成相关信息");
		}
		//第二步：保存业务流水信息表 add by saiyao.gao 2011-6-10
		BCrrGntyCon contSlaveInfo = bcrrgntycondao.selectByPrimaryKey(tblAppliBaseInfo.getSlaveContno());
		if(contSlaveInfo==null)
		{
			throw new ScubeBizException("该申请下对应从合同号不存在，无法操作！");
		}
		BCntMprotPartInfo tblMutiProtPartInfo = bcntmprotpartinfoservice.findCustByProtocolNoAndRole(contSlaveInfo.getPrtclNo(), ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		String moniOfCustcd = tblMutiProtPartInfo.getCustcd();
		
		String pid = bpbcmtgstordeliservice.addTblMortgageStorDeliInfo(tblAppliBaseInfo, ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_ADD, ScfBasConstant.STOR_OR_DELI_ADD, null, tblAppliBaseInfo.getSupplyChainPdId());
		//第三步：入库仓单的质押操作
		sbcpapplimortbillnormalservice.copyBillNorAddAPPInfoToPledge(appno,pid,tblAppliBaseInfo.getMastContno(),tblAppliBaseInfo.getSlaveContno(),appMorgInfoList,moniOfCustcd);
	}
	
	/**
	 * 普通仓单置换--仓单置换-置换解压
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月8日下午1:21:42
	 */
	@Override
	public Page getBillExchangeEnteringListByParam(BillNormalVO billNormalVO) throws ScubeBizException
	{
		Page page = sbcpapplimortbillnormalservice.getBillExchangeEnteringListByParam(billNormalVO, true);
		return page;
	}

	/**
	 * 普通仓单置换--正式表的写入
	 * 1、仓单置换---入库仓单的质押操作--仓单流水表的写入--入库押品的维护
	 * 2、仓单置换---出库仓单的解压操作--仓单流水表的写入
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日下午3:04:44
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void saveTblMortgageBillNorInfo(String appno) throws ScubeBizException
	{
		// 监管公司客户号
		HashMap<String, Object> poMap = new HashMap<String, Object>();
		poMap.put("appno", appno); // 申请编号
		poMap.put("appliMortBizType" , ScfBasConstant.MORT_BIZ_TYPE_NORMAL_EXCHANGE_IN);// 申请业务押品清单业务类型（仓单置换入库）
		List appMorgInfoList = bpbcapplimtginfoservice.findByConditionException("BPbcAppliMtgInfo", poMap, "押品信息没保存，请先保持押品信息！");
		//第一步：根据申请编号 得到主申请信息
		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno); // 主申请信息
		if(tblAppliBaseInfo==null)
		{
			throw new ScubeBizException("主申请信息信息丢失，无法生成相关信息");
		}
		//第二步：保存业务流水信息表
		BCrrGntyCon contSlaveInfo = bcrrgntycondao.selectByPrimaryKey(tblAppliBaseInfo.getSlaveContno());
		if(contSlaveInfo==null)
		{
			throw new ScubeBizException("该申请下对应从合同号不存在，无法操作！");
		}
		BCntMprotPartInfo tblMutiProtPartInfo = bcntmprotpartinfoservice.findCustByProtocolNoAndRole(contSlaveInfo.getPrtclNo(), ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		String moniOfCustcd = tblMutiProtPartInfo.getCustcd();

		String pid = bpbcmtgstordeliservice.addTblMortgageStorDeliInfo(tblAppliBaseInfo, ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_EXCHANGE, ScfBasConstant.STOR_OR_DELI_EXP, null, tblAppliBaseInfo.getSupplyChainPdId());
		//第四步：出库仓单的解压操作
		sbcpapplimortbillnormalservice.copyBillNorExcAPPInfoToUnpledge(appno,pid,tblAppliBaseInfo.getMastContno(),tblAppliBaseInfo.getSlaveContno());
		//第三步：入库仓单的质押操作
		sbcpapplimortbillnormalservice.copyBillNorExcAPPInfoToPledge(appno,pid,tblAppliBaseInfo.getMastContno(),tblAppliBaseInfo.getSlaveContno(),appMorgInfoList,moniOfCustcd);
	}
	
	/**
	 * 获取普通非标准仓单信息
	 * @param billNormalInOutQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月11日上午10:27:05
	 */
	@Override
	public Page getNormalBill(BillNormalInOutQryVO billNormalInOutQryVO) throws ScubeBizException
	{
		log.info("获取普通非标准仓单信息 method:getNormalBill begin");
		Page page = sbcpbillnormalinoutservice.getNormalBillByPara(billNormalInOutQryVO);
		log.info("获取普通非标准仓单信息 method:getNormalBill end");
		return page;
	}

}
