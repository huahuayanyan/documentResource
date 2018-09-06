package com.huateng.scf.sto.nwr.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfoVO;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStockDtlService;
import com.huateng.scf.sto.nwr.dao.ISBcpAppliMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.ISBcpMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.ext.ExtSBcpNwrDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormalExample;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.model.SBcpAppliMortBillNormalVO;
import com.huateng.scf.sto.nwr.model.SBcpMortBillNormalVO;
import com.huateng.scf.sto.nwr.service.ISBcpAppliMortBillNormalService;
import com.huateng.scf.sto.nwr.service.ISBcpBillNormalInOutService;
import com.huateng.scf.sto.nwr.service.ISBcpMortBillNormalService;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 非标仓单业务申请表
 * <p></p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月19日上午10:12:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月19日上午10:12:12	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("SBcpAppliMortBillNormalServiceImpl")
public class SBcpAppliMortBillNormalServiceImpl implements ISBcpAppliMortBillNormalService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bcntmprotpartinfoservice;
	
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bcntmprotbaseinfoservice;
	
	//业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;

	//质押合同表
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@Resource(name = "ISBcpMortBillNormalDAO")
	ISBcpMortBillNormalDAO sbcpmortbillnormaldao;
	
	//仓单信息流水表
	@Resource(name = "SBcpBillNormalInOutServiceImpl")
	ISBcpBillNormalInOutService sbcpbillnormalinoutservice;
	
	//押品信息
	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO bpbcmtgbaseinfodao;
	
	//押品信息变更明细表
	@Resource(name = "BPbcMtgStockDtlServiceImpl")
	IBPbcMtgStockDtlService bpbcmtgstockdtlservice;
	
	@Resource(name = "ExtSBcpNwrDAO")
	ExtSBcpNwrDAO extsbcpnwrdao;

	@Resource(name = "ISBcpAppliMortBillNormalDAO")
	ISBcpAppliMortBillNormalDAO sbcpapplimortbillnormaldao;
	
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;
	
	//押品基本信息表
	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;
	
	//非标仓单基本信息
	@Resource(name = "SBcpMortBillNormalServiceImpl")
	ISBcpMortBillNormalService sbcpmortbillnormalservice;
	
	/**
	 * 入库仓单的质押操作
	 * @param appno
	 * @param pid
	 * @param mastContno
	 * @param slaveContno
	 * @param appMorgInfoList
	 * @param moniOfCustcd
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月19日上午10:26:48
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void copyBillAPPInfoToPledge(String appno,String pid,String mastContno,String slaveContno,List<BPbcAppliMtgInfo> appMorgInfoList,String moniOfCustcd) throws ScubeBizException
	{
		log.debug("appno="+appno);
		//根据条件查找需要入库的仓单信息
		//监管协议
//		String monitorProtocolNo = bcntmprotbaseinfoservice.getMonitorProtocolNoBySlaveContnoAppnoPt(slaveContno,appno,ScfBasConstant.MUTI_PROTOCOL_MONI);

		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		String productId = null;
		if(tblAppliBaseInfo!=null){
			productId = tblAppliBaseInfo.getSupplyChainPdId();
		}

//		BCrrGntyCon slave = bcrrgntycondao.selectByPrimaryKey(slaveContno);
		mastContno =mastContno!=null?mastContno:"";
		BillNormalVO commonQueryVO = new BillNormalVO();
		commonQueryVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_INPUT);//普通仓单置换申请  -- 置换质押
		commonQueryVO.setAppno(appno.trim());
		commonQueryVO.setMastContno(mastContno.trim());
		commonQueryVO.setSlaveContno(slaveContno.trim());
		Page pageQueryResult = null;
		try 
		{
			pageQueryResult = this.getBillExchangeEnteringListByParam(commonQueryVO, false);
		} catch (BeansException e) 
		{
			e.printStackTrace();
		}
		List<SBcpMortBillNormal> tblAppliMortgageBillNormalList = pageQueryResult.getRecords();
		for (SBcpMortBillNormal billNormal:tblAppliMortgageBillNormalList) 
		{
			// 仓单基本信息表
			SBcpMortBillNormal tblMortgageBill = sbcpmortbillnormaldao.selectByPrimaryKey(billNormal.getBillno());
			//写入流水表
			// 保存普通仓单流水表信息 ADD
			SBcpMortBillNormalVO billNormalVO = new SBcpMortBillNormalVO();
			BeanUtils.copyProperties(billNormal, billNormalVO);
			sbcpbillnormalinoutservice.addTblBillNormalInOutInfo(billNormalVO,appno, pid,ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
			//DAOUtils.getTblBillStandInOutDAO().addTblBillNormalInOutInfo(tblMortgageBillStand,appno,pid, SCFConstants.BILL_MANAGE_STATUS_DELIVERY);
			tblMortgageBill.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE); // 状态更新
			sbcpmortbillnormaldao.updateByPrimaryKeySelective(tblMortgageBill);//更新仓单信息（状态置为质押）
		}

		//仓单对应押品信息的正式表写入
		for(BPbcAppliMtgInfo appliMtgInfo:appMorgInfoList)
		{//To 押品表
			// 1. COPY至押品基本信息表
			BCrrGntyCon tblContSlaveInf = bcrrgntycondao.selectByPrimaryKey(appliMtgInfo.getSlaveContno());

			BPbcMtgBaseInfo morgInfo = bpbcmtgbaseinfodao.selectByPrimaryKey(appliMtgInfo.getMortgageNo());	// 目标对象
			//保存押品信息变更明细表
			BPbcAppliMtgInfoVO appliMtgInfoVO = new BPbcAppliMtgInfoVO();
			BeanUtils.copyProperties(appliMtgInfo, appliMtgInfoVO);
			bpbcmtgstockdtlservice.addTblMortgageStockInfoByAppliInfo(appliMtgInfoVO, pid,
					ScfBasConstant.MORT_BIZ_TYPE_NORMAL_EXCHANGE_OUT, ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_EXCHANGE,
					productId);
			BeanUtils.copyProperties(appliMtgInfo,morgInfo);
			morgInfo.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL);	// 存货库存状态
			morgInfo.setFirstAppno(appliMtgInfo.getAppno());	// 首次入库申请号
			morgInfo.setFirstStorageDate(ScfDateUtil.getStringDate(new Date())); // 首次入库日期
			morgInfo.setOriginalPrice(appliMtgInfo.getPrice());	// 原始单价
			morgInfo.setOriginalTotPrice(appliMtgInfo.getTotPrice());	// 原始总价
			morgInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());	// 最后修改人
			morgInfo.setLastUpdTime(new Date());	// 最后修改日期
			morgInfo.setSupplyChainPdId(tblContSlaveInf.getVidPrdId());//产品类型  标准仓单
			morgInfo.setMoniOfCustcd(moniOfCustcd);//监管协议号
			bpbcmtgbaseinfodao.updateByPrimaryKeySelective(morgInfo);
		}
	}
	
	/**
	 * DESCRIPTION:普通仓单置换--置换解压
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月19日上午10:31:21
	 */
	@Override
	public Page getBillExchangeEnteringListByParam(BillNormalVO billNormalVO, boolean flag) throws ScubeBizException
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
//		if (!StringUtil.isEmpty(commonQueryVO.getMastContno()))
//		{
//			omap.put("mastContno", commonQueryVO.getMastContno());
//		}
//		if (!StringUtil.isEmpty(commonQueryVO.getSlaveContno()))
//		{
//			omap.put("slaveContno", commonQueryVO.getSlaveContno());
//		}
		
		int total = extsbcpnwrdao.countBillExchangeEnteringListByParam(omap);
		Page page = new Page(billNormalVO.getPageSize(), billNormalVO.getPageIndex(), total);
		page.setRecords(extsbcpnwrdao.getBillExchangeEnteringListByParam(omap,flag,page));
		return page;
	}
	
	/**
	 * 查询客户的普通仓单申请列表
	 * 返回列表为SBcpAppliMortBillNormal
	 * @param bussAppno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月21日下午3:43:08
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getBillNormalAppByAppno(String bussAppno) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("businessnoType", ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO);
		omap.put("appno", bussAppno);
		List list = extsbcpnwrdao.getBillNormalAppByAppno(omap);
		return list;
	}
	

	/**
	 * findByProperty方法 根据单属性查询PO实例，返回list
	 * @param appno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午2:47:23
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List findByProperty(String appno) 
	{
		SBcpAppliMortBillNormalExample example = new SBcpAppliMortBillNormalExample();
		SBcpAppliMortBillNormalExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		List list = sbcpapplimortbillnormaldao.selectByExample(example);
		return list;
	}
	
	/**
	 * 保存仓单申请信息
	 * @param bcpAppliMortBillNormalVO
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午5:28:43
	 */
	@Override
	public void save(SBcpAppliMortBillNormalVO bcpAppliMortBillNormalVO)
	{
		SBcpAppliMortBillNormal appliMortBillNormal = new SBcpAppliMortBillNormal();
		try
		{
			BeanUtils.copyProperties(bcpAppliMortBillNormalVO, appliMortBillNormal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		if(StringUtil.isEmpty(appliMortBillNormal.getId()))
		{
			appliMortBillNormal.setId(UUIDGeneratorUtil.generate());
		}
		sbcpapplimortbillnormaldao.insertSelective(appliMortBillNormal);
	}
	
	/**
	 * 普通仓单的追加申请--正式表写入--入库仓单的质押操作-流水表的写入--押品信息的维护
	 * @param appno
	 * @param pid
	 * @param mastContno
	 * @param slaveContno
	 * @param appMorgInfoList
	 * @param moniOfCustcd
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日下午3:56:22
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void copyBillNorAddAPPInfoToPledge(String appno,String pid,String mastContno,String slaveContno,List<BPbcAppliMtgInfo> appMorgInfoList,String moniOfCustcd)
			throws ScubeBizException{
		//根据条件查找需要追加的仓单信息
		//监管协议
//		String monitorProtocolNo = bcntmprotbaseinfoservice.getMonitorProtocolNoBySlaveContnoAppnoPt(slaveContno,appno,ScfBasConstant.MUTI_PROTOCOL_MONI);

		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		String productId = null;
		if(tblAppliBaseInfo!=null){
			productId = tblAppliBaseInfo.getSupplyChainPdId();
		}

//		BCrrGntyCon slave = bcrrgntycondao.selectByPrimaryKey(slaveContno);
		mastContno = mastContno!=null?mastContno:"";
		BillNormalVO commonQueryVO = new BillNormalVO();
		//commonQueryVO.setStatus(SCFConstants.BILL_MANAGE_STATUS_INPUT);//普通仓单置换申请  -- 置换质押
		commonQueryVO.setAppno(appno.trim());
		commonQueryVO.setMastContno(mastContno.trim());
		commonQueryVO.setSlaveContno(slaveContno.trim());
		Page pageQueryResult = null;
		try {
			pageQueryResult = this.getBillExchangeEnteringListByParam(commonQueryVO, false);
		} catch (ScubeBizException e) {
			e.printStackTrace();
		}
		List<SBcpMortBillNormal> tblAppliMortgageBillNormalList = pageQueryResult.getRecords();
		for (SBcpMortBillNormal billNormal:tblAppliMortgageBillNormalList) 
		{
			// 仓单基本信息表
			SBcpMortBillNormal tblMortgageBill = sbcpmortbillnormaldao.selectByPrimaryKey(billNormal.getBillno());
			//写入流水表
			// 保存普通仓单流水表信息 ADD
			SBcpMortBillNormalVO billNormalVO = new SBcpMortBillNormalVO();
			BeanUtils.copyProperties(billNormal, billNormalVO);
			sbcpbillnormalinoutservice.addTblBillNormalInOutInfo(billNormalVO,appno, pid,ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
			//DAOUtils.getTblBillStandInOutDAO().addTblBillNormalInOutInfo(tblMortgageBillStand,appno,pid, SCFConstants.BILL_MANAGE_STATUS_DELIVERY);
			tblMortgageBill.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE); // 状态更新
			sbcpmortbillnormaldao.updateByPrimaryKeySelective(tblMortgageBill);//更新仓单信息（状态置为质押）
		}

		//仓单对应押品信息的正式表写入
		for(BPbcAppliMtgInfo appliMtgInfo:appMorgInfoList)
		{//To 押品表
			// 1. COPY至押品基本信息表
			BCrrGntyCon tblContSlaveInf = bcrrgntycondao.selectByPrimaryKey(appliMtgInfo.getSlaveContno());

			//更改追加的数量
			if(StringUtil.isEmpty(appliMtgInfo.getQuantity())){
				appliMtgInfo.setQuantity(new BigDecimal(0));
			}
			if(StringUtil.isEmpty(appliMtgInfo.getAddQuantity())){
				appliMtgInfo.setAddQuantity(new BigDecimal(0));
			}
			appliMtgInfo.setQuantity(appliMtgInfo.getQuantity().add(appliMtgInfo.getAddQuantity()));
			
			BPbcMtgBaseInfo morgInfo = bpbcmtgbaseinfodao.selectByPrimaryKey(appliMtgInfo.getMortgageNo());	// 目标对象
			if(!StringUtil.isEmpty(morgInfo))
			{
				//保存押品信息变更明细表
				BPbcAppliMtgInfoVO appliMtgInfoVO = new BPbcAppliMtgInfoVO();
				BeanUtils.copyProperties(appliMtgInfo, appliMtgInfoVO);
				bpbcmtgstockdtlservice.addTblMortgageStockInfoByAppliInfo(appliMtgInfoVO, pid,
						ScfBasConstant.MORT_BIZ_TYPE_NORMAL_ADD,
						ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_ADD,
						productId);
				
				BeanUtils.copyProperties(appliMtgInfo,morgInfo);
				morgInfo.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL);	// 存货库存状态
				morgInfo.setFirstAppno(appliMtgInfo.getAppno());	// 首次入库申请号
				morgInfo.setFirstStorageDate(ScfDateUtil.getStringDate(new Date())); // 首次入库日期
				morgInfo.setOriginalPrice(appliMtgInfo.getPrice());	// 原始单价
				morgInfo.setOriginalTotPrice(appliMtgInfo.getTotPrice());	// 原始总价
				morgInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());	// 最后修改人
				morgInfo.setLastUpdTime(new Date());	// 最后修改日期
				morgInfo.setSupplyChainPdId(tblContSlaveInf.getVidPrdId());//产品类型  标准仓单
				morgInfo.setMoniOfCustcd(moniOfCustcd);//监管协议号
				bpbcmtgbaseinfodao.updateByPrimaryKeySelective(morgInfo);
			}
			else
			{
				morgInfo = new BPbcMtgBaseInfo();
				//保存押品信息变更明细表
				BPbcAppliMtgInfoVO appliMtgInfoVO = new BPbcAppliMtgInfoVO();
				BeanUtils.copyProperties(appliMtgInfo, appliMtgInfoVO);
				bpbcmtgstockdtlservice.addTblMortgageStockInfoByAppliInfo(appliMtgInfoVO, pid,
						ScfBasConstant.MORT_BIZ_TYPE_NORMAL_ADD,
						ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_ADD,
						productId);
				
				BeanUtils.copyProperties(appliMtgInfo,morgInfo);
				morgInfo.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL);	// 存货库存状态
				morgInfo.setFirstAppno(appliMtgInfo.getAppno());	// 首次入库申请号
				morgInfo.setFirstStorageDate(ScfDateUtil.getStringDate(new Date())); // 首次入库日期
				morgInfo.setOriginalPrice(appliMtgInfo.getPrice());	// 原始单价
				morgInfo.setOriginalTotPrice(appliMtgInfo.getTotPrice());	// 原始总价
				morgInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());	// 最后修改人
				morgInfo.setLastUpdTime(new Date());	// 最后修改日期
				morgInfo.setSupplyChainPdId(tblContSlaveInf.getVidPrdId());//产品类型  标准仓单
				morgInfo.setMoniOfCustcd(moniOfCustcd);//监管协议号
				bpbcmtgbaseinfodao.insertSelective(morgInfo);
			}
		}
	}
	
	/**
	 * updateReceiptAppOutStorage (普单置换 解押)增加、修改、删除仓单解押业务申请信息
	 * @param appno
	 * @param outInsertList
	 * @param outUpdateList
	 * @param outDelList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午1:35:01
	 */
	@Override
	public void updateReceiptAppOutStorage(String appno, List<BillNormalAppVO> outInsertList,
			List<BillNormalAppVO> outUpdateList, List<BillNormalAppVO> outDelList) throws ScubeBizException
	{
		SBcpAppliMortBillNormalExample example = new SBcpAppliMortBillNormalExample();
		SBcpAppliMortBillNormalExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		cri.andStatusEqualTo(ScfBasConstant.BILL_MANAGE_STATUS_DELIVERY);
		List<SBcpAppliMortBillNormal> oldOutList = sbcpapplimortbillnormaldao.selectByExample(example);
		if(oldOutList!=null&&oldOutList.size()>0)
		{
			for(SBcpAppliMortBillNormal appliMortBillNormal:oldOutList)
			{
				sbcpapplimortbillnormaldao.deleteByPrimaryKey(appliMortBillNormal.getId());
			}
		}

		// 增加操作
		for (BillNormalAppVO applyVO:outInsertList) 
		{
			SBcpAppliMortBillNormal sBcpAppliMortBillNormal = new SBcpAppliMortBillNormal(); // 目标对象
			BeanUtils.copyProperties(applyVO, sBcpAppliMortBillNormal);
			sBcpAppliMortBillNormal.setAppno(appno); // 申请编号
//			sBcpAppliMortBillNormal.setBillno(applyVO.getBillno()); // 仓单编号
			sBcpAppliMortBillNormal.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_DELIVERY);
			sBcpAppliMortBillNormal.setId(UUIDGeneratorUtil.generate());
			sbcpapplimortbillnormaldao.insertSelective(sBcpAppliMortBillNormal);
		}
		for (BillNormalAppVO applyVO:outUpdateList) 
		{
			SBcpAppliMortBillNormal sBcpAppliMortBillNormal = new SBcpAppliMortBillNormal(); // 目标对象
			BeanUtils.copyProperties(applyVO, sBcpAppliMortBillNormal);
			sBcpAppliMortBillNormal.setAppno(appno); // 申请编号
			sBcpAppliMortBillNormal.setBillno(applyVO.getBillno()); // 仓单编号
			sBcpAppliMortBillNormal.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_DELIVERY);
			sbcpapplimortbillnormaldao.updateByPrimaryKeySelective(sBcpAppliMortBillNormal);
		}

		// 删除操作.
		for (BillNormalAppVO applyVO:outDelList) 
		{
			SBcpAppliMortBillNormalExample exampled = new SBcpAppliMortBillNormalExample();
			SBcpAppliMortBillNormalExample.Criteria crid = example.createCriteria();
			crid.andAppnoEqualTo(appno);
			crid.andBillnoEqualTo(applyVO.getBillno());
			List<SBcpAppliMortBillNormal> list = sbcpapplimortbillnormaldao.selectByExample(exampled);
			if(list!=null&&list.size()==1){
				sbcpapplimortbillnormaldao.deleteByPrimaryKey(list.get(0).getId());
			}
		}
	}
	
	/**
	 * 仓单申请审批通过，修改正式表及申请表信息
	 * @param appno
	 * @param pid
	 * @param appBaseInfo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月8日上午9:00:21
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void updateTblAppliMortgageBillNormalStatus(String appno,String pid,BPbcAppliBaseInfo appBaseInfo)
			throws ScubeBizException 
	{
//		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		String productId = null;
		if(appBaseInfo!=null){
			productId = appBaseInfo.getSupplyChainPdId();
		}
		List appliBillNormalList = this.findByProperty(appno);//解押仓单申请列表
		if(appliBillNormalList!=null&&appliBillNormalList.size()>0)
		{
			for (int i=0;i<appliBillNormalList.size();i++) 
			{
				SBcpAppliMortBillNormal appliMortBillNormal = (SBcpAppliMortBillNormal) appliBillNormalList.get(i);
				//根据仓单号查找仓单信息
				SBcpMortBillNormal bcpMortBillNormal = sbcpmortbillnormaldao.selectByPrimaryKey(appliMortBillNormal.getBillno());
				SBcpMortBillNormalVO bcpMortBillNormalVO = new SBcpMortBillNormalVO();
				BeanUtils.copyProperties(bcpMortBillNormal, bcpMortBillNormalVO);
				//保存普通仓单流水表信息
				sbcpbillnormalinoutservice.addTblBillNormalInOutInfo(bcpMortBillNormalVO,appno, pid,
						ScfBasConstant.BILL_MANAGE_STATUS_DELIVERY);
				bcpMortBillNormalVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_DELIVERY); // 状态更新
				//查找押品
				OldCommonQueryVO commonQueryVO0 = new OldCommonQueryVO();
				Page pageQueryResult0 = null;
				//commonQueryVO0.setAppliMortBizType_Q(SCFConstants.STOR_DELI_BIZ_TYPE_1302);//普通仓单解押出库 MODIFY BY SAIYAO.GAO 2011-6-10
				commonQueryVO0.setAppno_Q(appno);
				commonQueryVO0.setBillno_Q(String.valueOf(appliMortBillNormal.getBillno()));
				pageQueryResult0 = bpbcapplimtginfoservice.getBillMortListByParam(commonQueryVO0);
				List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> tblAppliMortgageBaseInfoList = 
						pageQueryResult0.getRecords();//押品list
				for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo bPbcAppliMtgInfo:tblAppliMortgageBaseInfoList) 
				{
					//押品数量置为0
					bpbcmtgbaseinfoservice.resetMortQuantity(bPbcAppliMtgInfo.getMortgageNo());//押品数量置为0
					BPbcAppliMtgInfoVO appliMortgageBaseInfo = new BPbcAppliMtgInfoVO();
					BeanUtils.copyProperties(bPbcAppliMtgInfo, appliMortgageBaseInfo);

					//保存押品信息变更明细表
					bpbcmtgstockdtlservice.addTblMortgageStockInfoByAppliInfo(appliMortgageBaseInfo, pid,
							ScfBasConstant.MORT_BIZ_TYPE_NORMAL_RECEIPT_OUT,
							ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_RECEIPT,
							productId);
				}
				sbcpmortbillnormalservice.update(bcpMortBillNormalVO);//更新状态

			}
		}
	}
	
	/**
	 * 普通仓单的置换申请--正式表写入--出库仓单的解押操作-流水表的写入
	 * @param appno
	 * @param pid
	 * @param mastContno
	 * @param slaveContno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日下午3:13:25
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void copyBillNorExcAPPInfoToUnpledge(String appno,String pid,String mastContno,String slaveContno) throws ScubeBizException
	{
		//根据条件查询出库的仓单信息
		//监管协议
//		String monitorProtocolNo = bcntmprotbaseinfoservice.getMonitorProtocolNoBySlaveContnoAppnoPt(slaveContno,appno,ScfBasConstant.MUTI_PROTOCOL_MONI);

		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		String productId = null;
		if(tblAppliBaseInfo!=null){
			productId = tblAppliBaseInfo.getSupplyChainPdId();
		}

		BillNormalVO commonQueryVO = new BillNormalVO();
		commonQueryVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);//普通仓单置换申请  -- 置换解压
		commonQueryVO.setAppno(appno);
		commonQueryVO.setMastContno(mastContno);
		commonQueryVO.setSlaveContno(slaveContno);
		Page PageQueryResult = null;
		try 
		{
			PageQueryResult = this.getBillExchangeEnteringListByParam(commonQueryVO, false);
		} 
		catch(ScubeBizException e) 
		{
			e.printStackTrace();
		}
		List<SBcpMortBillNormal> tblAppliMortgageBillNormalList = PageQueryResult.getRecords();
		//循环写入正式表  状态置为解压
		for (SBcpMortBillNormal tblMortgageBillNormal : tblAppliMortgageBillNormalList) 
		{
			//原质押仓单的解压
			commonQueryVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);//在押
			commonQueryVO.setBillno(String.valueOf(tblMortgageBillNormal.getBillno()));
			Page PageQueryResult0 = sbcpmortbillnormalservice.getBillInfoForUnplrdgeListByParam(commonQueryVO);
			if(PageQueryResult0.getRecords().isEmpty())
			{
				throw new ScubeBizException("该申请下要换出仓单不存在,请查证！");
			}
			SBcpMortBillNormal tblMortgageBillNormal1 = (SBcpMortBillNormal) PageQueryResult0.getRecords().get(0);
			SBcpMortBillNormalVO bcpMortBillNormalVO = new SBcpMortBillNormalVO();
			BeanUtils.copyProperties(tblMortgageBillNormal1, bcpMortBillNormalVO);
			// 保存普通仓单流水表信息 ADD BY SAIYAO.GAO 2011-6-10
			sbcpbillnormalinoutservice.addTblBillNormalInOutInfo(bcpMortBillNormalVO,appno, pid,
					ScfBasConstant.BILL_MANAGE_STATUS_OUT);

			//押品信息写入出入库表
			//查找押品
			BillNormalVO commonQueryVO0 = new BillNormalVO();
			Page pageQueryResult0 = null;
			commonQueryVO0.setAppliMortBizType_Q(ScfBasConstant.MORT_BIZ_TYPE_NORMAL_EXCHANGE_OUT);//普通仓单置换出库 MODIFY BY SAIYAO.GAO 2011-6-10
			commonQueryVO0.setAppno(appno);
			commonQueryVO0.setBillno(String.valueOf(tblMortgageBillNormal.getBillno()));
			commonQueryVO0.setSlaveContno(slaveContno);
			commonQueryVO0.setAppType("normal");
			pageQueryResult0 = bpbcapplimtginfoservice.getBillMortListByParam(commonQueryVO0);
			List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> tblAppliMortgageBaseInfoList=pageQueryResult0.getRecords();
			for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo applyVO : tblAppliMortgageBaseInfoList) {
				//押品数量置为0
				bpbcmtgbaseinfoservice.resetMortQuantity(applyVO.getMortgageNo());//押品数量置为0
				BPbcAppliMtgInfoVO appliMortgageBaseInfo = new BPbcAppliMtgInfoVO();
				BeanUtils.copyProperties(applyVO, appliMortgageBaseInfo);
				//保存押品信息变更明细表
				bpbcmtgstockdtlservice.addTblMortgageStockInfoByAppliInfo(
						appliMortgageBaseInfo, pid,
						ScfBasConstant.MORT_BIZ_TYPE_NORMAL_EXCHANGE_OUT,
						ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_EXCHANGE,
						productId);
			}
//			SCFDAOUtils.getTblMortgageBillNormalDAO().getCurSession().flush();
//			SCFDAOUtils.getTblMortgageBillNormalDAO().getCurSession().clear();

			tblMortgageBillNormal.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_OUT);
			SBcpMortBillNormalVO billNormalVO = new SBcpMortBillNormalVO();
			BeanUtils.copyProperties(tblMortgageBillNormal, billNormalVO);
			sbcpmortbillnormalservice.update(billNormalVO);

		}
	}
	
	/**
	 * 普通仓单的置换申请--正式表写入--入库仓单的质押操作-流水表的写入--押品信息的维护
	 * @param appno
	 * @param pid
	 * @param mastContno
	 * @param slaveContno
	 * @param appMorgInfoList
	 * @param moniOfCustcd
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日下午3:38:29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void copyBillNorExcAPPInfoToPledge(String appno,String pid,String mastContno,String slaveContno,
			List<?> appMorgInfoList,String moniOfCustcd) throws ScubeBizException
	{
		//根据条件查找需要入库的仓单信息
		//监管协议
//		String monitorProtocolNo = bcntmprotbaseinfoservice.getMonitorProtocolNoBySlaveContnoAppnoPt(slaveContno,appno,ScfBasConstant.MUTI_PROTOCOL_MONI);

		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		String productId = null;
		if(tblAppliBaseInfo!=null){
			productId = tblAppliBaseInfo.getSupplyChainPdId();
		}

//		BCrrGntyCon slave = bcrrgntycondao.selectByPrimaryKey(slaveContno);
		mastContno = mastContno!=null?mastContno:"";
		BillNormalVO commonQueryVO = new BillNormalVO();
		commonQueryVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_INPUT);//普通仓单置换申请  -- 置换质押
		commonQueryVO.setAppno(appno.trim());
		commonQueryVO.setMastContno(mastContno.trim());
		commonQueryVO.setSlaveContno(slaveContno.trim());
		Page pageQueryResult = null;
		try
		{
			pageQueryResult = this.getBillExchangeEnteringListByParam(commonQueryVO, false);
		}
		catch(ScubeBizException e)
		{
			e.printStackTrace();
		}
		List<SBcpMortBillNormal> tblAppliMortgageBillNormalList = pageQueryResult.getRecords();
		for (SBcpMortBillNormal tblMortgageBillNormal : tblAppliMortgageBillNormalList) 
		{
			// 仓单基本信息表
			SBcpMortBillNormal tblMortgageBill = sbcpmortbillnormaldao.selectByPrimaryKey(tblMortgageBillNormal.getBillno());;
			SBcpMortBillNormalVO billNormalVO = new SBcpMortBillNormalVO();
			BeanUtils.copyProperties(tblMortgageBill, billNormalVO);
			//写入流水表	保存普通仓单流水表信息
			sbcpbillnormalinoutservice.addTblBillNormalInOutInfo(billNormalVO,appno, pid,
					ScfBasConstant.BILL_MANAGE_STATUS_IN);
			billNormalVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_IN); // 状态更新
			sbcpmortbillnormalservice.update(billNormalVO);//更新仓单信息（状态置为解押）
		}

		//仓单对应押品信息的正式表写入
		for(int i=0;i<appMorgInfoList.size();i++)
		{//To 押品表
			// 1. COPY至押品基本信息表
			BPbcAppliMtgInfo appMorgInfo = (BPbcAppliMtgInfo)appMorgInfoList.get(i); // 源对象
			BCrrGntyCon tblContSlaveInf = bcrrgntycondao.selectByPrimaryKey(appMorgInfo.getSlaveContno());

			//DAOUtils.getTblMortgageStockInfoDAO().addTblMortgageStockInfoByAppliInfo(appMorgInfo, pid, SCFConstants.MORT_BIZ_TYPE_NORMAL_PLEDGE_IN, SCFConstants.STOR_DELI_BIZ_TYPE_NORMAL_PLEDGE, "1201");//保存押品信息变更明细表
			com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo morgInfo = bpbcmtgbaseinfoservice.findBPbcMtgBaseInfoByKey(appMorgInfo.getMortgageNo());	// 目标对象
			//保存押品信息变更明细表
			BPbcAppliMtgInfoVO appliMtgInfoVO = new BPbcAppliMtgInfoVO();
			BeanUtils.copyProperties(appMorgInfo, appliMtgInfoVO);
			bpbcmtgstockdtlservice.addTblMortgageStockInfoByAppliInfo(appliMtgInfoVO, pid,
					ScfBasConstant.MORT_BIZ_TYPE_NORMAL_EXCHANGE_OUT,
					ScfBasConstant.STOR_DELI_BIZ_TYPE_NORMAL_EXCHANGE,
					productId);
			BeanUtils.copyProperties(appMorgInfo,morgInfo);
			morgInfo.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL);	// 存货库存状态
			morgInfo.setFirstAppno(appMorgInfo.getAppno());	// 首次入库申请号
			morgInfo.setFirstStorageDate(ScfDateUtil.getStringDate(new Date())); // 首次入库日期
			morgInfo.setOriginalPrice(appMorgInfo.getPrice());	// 原始单价
			morgInfo.setOriginalTotPrice(appMorgInfo.getTotPrice());	// 原始总价
			morgInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());	// 最后修改人
			morgInfo.setLastUpdTime(new Date());	// 最后修改日期
//			morgInfo.setMastContno(contSlaveInfo.getMastContno());	// 主合同号
			morgInfo.setSupplyChainPdId(tblContSlaveInf.getVidPrdId());//产品类型  标准仓单
			morgInfo.setMoniOfCustcd(moniOfCustcd);//监管协议号
			//morgInfo.setConfirmPrice(appMorgInfo.getConfirmPrice());
		    bpbcmtgbaseinfoservice.update(morgInfo);

		}

	}
}
