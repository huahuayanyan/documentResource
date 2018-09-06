/**
 * 
 */
package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.adv.tcs.constant.ATcsErrorConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgStorDeliDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgStockDtl;
import com.huateng.scf.bas.pbc.model.BPbcMtgStorDeli;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStockDtlService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStorDeliService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月29日上午9:46:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月29日上午9:46:42              新增
 *
 * </pre>
 */
@ScubeService
@Service("BPbcMtgStorDeliServiceImpl")
public class BPbcMtgStorDeliServiceImpl implements IBPbcMtgStorDeliService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BPbcMtgStorDeliDAO")
	IBPbcMtgStorDeliDAO bPbcMtgStorDeliDAO;
	
	@Resource(name = IBPbcAppliMtgInfoService.BEAN_ID)
	IBPbcAppliMtgInfoService bPbcAppliMtgInfoService; //业务申请押品信息

	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bCrrLnConService;
	
	@Resource(name = "BPbcMtgStockDtlServiceImpl")
	IBPbcMtgStockDtlService bPbcMtgStockDtlService; //押品信息变更明细
	@Transactional
	@Override
	public String addBPbcMtgStorDeli(BPbcMtgStorDeli bPbcMtgStorDeli) throws ScubeBizException {
		//ScfCommonUtil.setCommonField(bPbcMtgStorDeli);//设置公共字段 add by huangshuidan 2016-11-11
		 // 获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
	    bPbcMtgStorDeli.setBrcode(brCode);
	    bPbcMtgStorDeli.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli bPbcMtgStorDelidal = new com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli();
		try {
			BeanUtils.copyProperties(bPbcMtgStorDeli, bPbcMtgStorDelidal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品变更流水信息转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_30000),BPbcErrorConstant.SCF_BAS_PBC_30000);
		} 
	    try {
			//TODO
			bPbcMtgStorDeliDAO.insertSelective(bPbcMtgStorDelidal);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("押品变更流水信息插入异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_30001),BPbcErrorConstant.SCF_BAS_PBC_30001);
		}
	    return bPbcMtgStorDeli.getId();
	}

	@Transactional
	@Override
	public int updateBPbcMtgStorDeli(BPbcMtgStorDeli bPbcMtgStorDeli) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli bPbcMtgStorDelidal = 
				new com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli();
			try {
				BeanUtils.copyProperties(bPbcMtgStorDeli, bPbcMtgStorDelidal);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("押品变更流水信息转换异常！");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_30000),BPbcErrorConstant.SCF_BAS_PBC_30000);
			}
		int i = 0;
		 try {
			i = bPbcMtgStorDeliDAO.updateByPrimaryKeySelective(bPbcMtgStorDelidal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品变更流水信息更新异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_30002),BPbcErrorConstant.SCF_BAS_PBC_30002);
		}
		 return i;
	}
	@Transactional
	@Override
	public int deleteBPbcMtgStorDeli(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = bPbcMtgStorDeliDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品变更流水信息删除异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_30003),BPbcErrorConstant.SCF_BAS_PBC_30003);
		}
		return i;
	}

	@Transactional
	@Override
	public BPbcMtgStorDeli findBPbcMtgStorDeliByKey(String key) throws ScubeBizException {
		BPbcMtgStorDeli bPbcMtgStorDeli = new BPbcMtgStorDeli();
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli bPbcMtgStorDelidal = 
				new com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli();
		bPbcMtgStorDelidal=bPbcMtgStorDeliDAO.selectByPrimaryKey(key);
		try {
			BeanUtils.copyProperties(bPbcMtgStorDelidal, bPbcMtgStorDeli);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品变更流水信息转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_30000),BPbcErrorConstant.SCF_BAS_PBC_30000);
		}
		return bPbcMtgStorDeli;
	}

	/**
	 * 根据appno查询押品变更流水信息
	 */
	@Override
	public List<BPbcMtgStorDeli> findBPbcMtgStorDeliByAppno(String appno) throws ScubeBizException {
		List<BPbcMtgStorDeli> list =  new ArrayList<BPbcMtgStorDeli>(); 
		BPbcMtgStorDeli bPbcMtgStorDeli = null;
		List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli> listdal=  bPbcMtgStorDeliDAO.selectByAppno(appno);
		for(com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli info:listdal){
			bPbcMtgStorDeli =new BPbcMtgStorDeli();
			try {
				BeanUtils.copyProperties(info, bPbcMtgStorDeli);
			} catch (BeansException e) {
				log.error("押品变更流水信息转换异常！");
				e.printStackTrace();
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_30000),BPbcErrorConstant.SCF_BAS_PBC_30000);
			}
			list.add(bPbcMtgStorDeli);
		}
		return list;
	}

	/**
	 * 保存 业务流水信息(1)(公用)
	 * @param appliBaseInfo
	 * @param storDeliBizType
	 * @param storOrDeli
	 * @param mortgageBizNo
	 * @param bussType
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月19日下午2:56:20
	 */
	@Override
	public String addTblMortgageStorDeliInfo(BPbcAppliBaseInfo appliBaseInfo,String storDeliBizType, String storOrDeli, 
			Integer mortgageBizNo,String bussType) throws ScubeBizException
	{
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli tblMortgageStorDeliInfo = 
				new com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli();
		BeanUtils.copyProperties(appliBaseInfo, tblMortgageStorDeliInfo);
		tblMortgageStorDeliInfo.setTxdate(ScfDateUtil.getStringDate(new Date()));
		tblMortgageStorDeliInfo.setTxtime(new Date());
		tblMortgageStorDeliInfo.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
		tblMortgageStorDeliInfo.setStorDeliBizType(storDeliBizType);//出入库业务类型
		tblMortgageStorDeliInfo.setBussType(bussType);//业务类型
		tblMortgageStorDeliInfo.setStorOrDeli(storOrDeli);//出库/入库
		tblMortgageStorDeliInfo.setMortgageBizNo(StringUtil.isEmpty(mortgageBizNo)?null:new BigDecimal(mortgageBizNo));//出入库换货申请单号
		String id = UUIDGeneratorUtil.generate();
		tblMortgageStorDeliInfo.setId(id);
		bPbcMtgStorDeliDAO.insertSelective(tblMortgageStorDeliInfo);
		return id;
	}

	/**
	 * 四方到货出质入库押品流水信息添加
	 */
	@Transactional
	@Override
	public String addMortgageStorDeliInfo(BPbcAppliBaseInfo appliBaseInfo, String storDeliBizType, String storOrDeli,
			List<BPbcAppliMtgInfo> appMortgageList) throws ScubeBizException {
		// TODO Auto-generated method stub
		ScfGlobalInfo scfGlobalInfo = ScfBaseData.getScfGlobalInfoData();
		BPbcMtgStorDeli bPbcMtgStorDeli = new BPbcMtgStorDeli();
		bPbcMtgStorDeli.setAppno(appliBaseInfo.getAppno());
		bPbcMtgStorDeli.setOtherProtocolNo(appliBaseInfo.getBusinessno());//四方协议
		//tblMortgageStorDeliInfo.setMonitorProtocolNo(appliBaseInfo.getProtocolNo());//监管协议 before
		bPbcMtgStorDeli.setMonitorProtocolNo(appliBaseInfo.getOtherProtocolNo());//监管协议
		bPbcMtgStorDeli.setSlaveContno(appliBaseInfo.getSlaveContno());//抵质押合同
		bPbcMtgStorDeli.setTxdate(scfGlobalInfo.getTxnDate());
		bPbcMtgStorDeli.setTxtime(scfGlobalInfo.getTimestamps());
		bPbcMtgStorDeli.setStorOrDeli(storOrDeli);//出库/入库
		bPbcMtgStorDeli.setStorDeliBizType(storDeliBizType);//业务类型
		bPbcMtgStorDeli.setTlrcd(appliBaseInfo.getStartTlrcd());
		bPbcMtgStorDeli.setCurcd(appliBaseInfo.getCurcd());

		//本次出质金额 = 新入库押品总和+库存押品增加数量*核定价
		BigDecimal amt = BigDecimal.ZERO;
		for (BPbcAppliMtgInfo bPbcAppliMtgInfo : appMortgageList) {
			amt = amt.add(bPbcAppliMtgInfo.getTotPrice());
		}
		bPbcMtgStorDeli.setTotPrice(amt);//此次申请总价值， for 会计记账
		bPbcMtgStorDeli.setBussType(appliBaseInfo.getSupplyChainPdId());//产品类型
		String id = this.addBPbcMtgStorDeli(bPbcMtgStorDeli);
		return  id;
	}

	 /**
	 * DESCRIPTION:提货押品操作流水信息写入(线下)
	 * saveMortgageStockInfoDtl 方法
	 * @param tblAppliBaseInfo
	 * @param tblAppliBussInfo
	 * @throws ScubeBizException
	 * @param commonQueryVO
	 * @return
	 */
	@Transactional
	@Override
	public void saveMortgageStockInfoDtl(BPbcAppliBaseInfo bPbcAppliBaseInfo,ABcpAppliImprestBuss aBcpAppliImprestBuss) throws ScubeBizException{
   	//1、数据准备
		
		UserInfo user = ContextHolder.getUserInfo(); 
		String tlrNo=user.getTlrNo();
		//String brCode=user.getBrNo();
   	//获得已存在押品列表
		List<BPbcAppliMtgInfo> mortList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(bPbcAppliBaseInfo.getAppno());
   	
   	if(mortList==null){
   		log.error("申请基本信息:提货押品列表丢失!");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40006),ATcsErrorConstant.SCF_ADV_TCS_40006);
   	}
   	BCrrLnCon  bCrrLnCon = bCrrLnConService.findBCrrLnConByAppId(bPbcAppliBaseInfo.getMastContno());
		if(bCrrLnCon==null){
			log.error("合同信息丢失!");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10003),ATcsErrorConstant.SCF_ADV_TCS_10003);
		}
   	//2、押品操作流水信息写入--差额回购提货：总括表TBL_MORTGAGE_STOR_DELI_INFO
			BPbcMtgStorDeli bPbcMtgStorDeli = null;
   	//--校验是否记录已存在
   	List<BPbcMtgStorDeli> storDeliInfoList = this.findBPbcMtgStorDeliByAppno(bPbcAppliBaseInfo.getAppno());
   	if(storDeliInfoList!=null&&storDeliInfoList.size()>0){
   		bPbcMtgStorDeli = (BPbcMtgStorDeli) storDeliInfoList.get(0);
   		bPbcMtgStorDeli.setAppno(bPbcAppliBaseInfo.getAppno());
   		bPbcMtgStorDeli.setOtherProtocolNo(bPbcAppliBaseInfo.getProtocolNo());
   		bPbcMtgStorDeli.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
   		bPbcMtgStorDeli.setTxdate(BSysConstant.WORKDATE);
   		//bPbcMtgStorDeli.setTxtime(globalInfo.txnDate);
   		bPbcMtgStorDeli.setTlrcd(tlrNo);
   		bPbcMtgStorDeli.setStorOrDeli(ScfBasConstant.STOR_OR_DELI_OUT);
   		bPbcMtgStorDeli.setStorDeliBizType(ScfBasConstant.STOR_DELI_BIZ_TYPE_DELIVERY);
   		bPbcMtgStorDeli.setCurcd(ScfBasConstant.RMB);
   		bPbcMtgStorDeli.setTotPrice(aBcpAppliImprestBuss.getCommonAmt());//提货金额
   		bPbcMtgStorDeli.setBussType(bCrrLnCon.getVidBusiTyp());
   		this.updateBPbcMtgStorDeli(bPbcMtgStorDeli);

   	}else{
   		bPbcMtgStorDeli = new BPbcMtgStorDeli();
   		bPbcMtgStorDeli.setAppno(bPbcAppliBaseInfo.getAppno());
   		bPbcMtgStorDeli.setOtherProtocolNo(bPbcAppliBaseInfo.getProtocolNo());
   		bPbcMtgStorDeli.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
   		bPbcMtgStorDeli.setTxdate(BSysConstant.WORKDATE);
   		//bPbcMtgStorDeli.setTxtime(globalInfo.txnDate);
   		bPbcMtgStorDeli.setTlrcd(tlrNo);
   		bPbcMtgStorDeli.setStorOrDeli(ScfBasConstant.STOR_OR_DELI_OUT);
   		bPbcMtgStorDeli.setStorDeliBizType(ScfBasConstant.STOR_DELI_BIZ_TYPE_DELIVERY);
   		bPbcMtgStorDeli.setCurcd(ScfBasConstant.RMB);
   		bPbcMtgStorDeli.setTotPrice(aBcpAppliImprestBuss.getCommonAmt());//提货金额
   		bPbcMtgStorDeli.setId(null);
   		this.addBPbcMtgStorDeli(bPbcMtgStorDeli);
   	}

   	//3、押品操作流水信息写入--差额回购提货：总括表TBL_MORTGAGE_STOCK_INFO
   	//--查询已存在记录  删除全部 重新添加记录
   	List<BPbcMtgStockDtl> appList = bPbcMtgStockDtlService.findBPbcMtgStockDtlByAppno(bPbcAppliBaseInfo.getAppno());
   	for (int i = 0; i < appList.size(); i++) {
   		BPbcMtgStockDtl bean = (BPbcMtgStockDtl) appList.get(i);
   		bPbcMtgStockDtlService.deleteBPbcMtgStockDtl(bean.getId());
		}
   	for (int i = 0; i < mortList.size(); i++) {
   		BPbcAppliMtgInfo bPbcAppliMtgInfo = (BPbcAppliMtgInfo) mortList.get(i);
   		BPbcMtgStockDtl bPbcMtgStockDtl = new BPbcMtgStockDtl();
   		
   		bPbcMtgStockDtl.setOtherProtocolNo(bPbcAppliMtgInfo.getOtherProtocolNo());
   		bPbcMtgStockDtl.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
   		bPbcMtgStockDtl.setMortgageBizType(ScfBasConstant.MORT_BIZ_TYPE_DELIVERY_OUT);
   		bPbcMtgStockDtl.setLastUpdTime(new Date());
   		
   		bPbcMtgStockDtl.setFirstAppno(bPbcAppliMtgInfo.getAppno());
   		bPbcMtgStockDtl.setMortgageNo(bPbcAppliMtgInfo.getMortgageNo());
   		bPbcMtgStockDtl.setExt1(bPbcAppliMtgInfo.getMortgageName());//押品名称
   		bPbcMtgStockDtl.setMortgageLevelOne(bPbcAppliMtgInfo.getMortgageLevelOne());
   		bPbcMtgStockDtl.setMortgageLevelTwo(bPbcAppliMtgInfo.getMortgageLevelTwo());
   		bPbcMtgStockDtl.setMortgageLevelThree(bPbcAppliMtgInfo.getMortgageLevelThree());
   		bPbcMtgStockDtl.setMortgageModel(bPbcAppliMtgInfo.getMortgageModel());
   		bPbcMtgStockDtl.setQuantity(bPbcAppliMtgInfo.getQuantity());
   		//提货数量本次
   		bPbcMtgStockDtl.setBillQuantity(bPbcAppliMtgInfo.getBillQuantity());
   	
   		bPbcMtgStockDtl.setMortgageUnits(bPbcAppliMtgInfo.getMortgageUnits());
   		bPbcMtgStockDtl.setTotPrice(bPbcAppliMtgInfo.getTotPrice());
   		bPbcMtgStockDtl.setIncomeNo(bPbcAppliMtgInfo.getWarehouse());//相关凭证号
   		bPbcMtgStockDtl.setExt2(bPbcAppliMtgInfo.getDescription());//Description
   		bPbcMtgStockDtl.setType(ScfBasConstant.STOR_DELI_BIZ_TYPE_DELIVERY);//
   		bPbcMtgStockDtl.setSupplyChainPdId(bCrrLnCon.getVidBusiTyp());
   		bPbcMtgStockDtl.setExt3(bPbcAppliBaseInfo.getBusinessno());//借据号
   		bPbcMtgStockDtlService.addBPbcMtgStockDtl(bPbcMtgStockDtl);
		}

   }
}
