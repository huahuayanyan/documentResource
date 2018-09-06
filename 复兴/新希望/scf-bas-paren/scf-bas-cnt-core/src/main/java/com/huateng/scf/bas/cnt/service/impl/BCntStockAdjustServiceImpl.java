package com.huateng.scf.bas.cnt.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.ext.ExtIBCntContSlaveAndMortgageInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.BPbcMtgBaseInfoDO;
import com.huateng.scf.bas.cnt.service.IBCntStockAdjustService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgStockDtlDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgStorDeliDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BCntStockAdjustServiceImpl")
public class BCntStockAdjustServiceImpl implements IBCntStockAdjustService {
	
	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService bSysSerialNoService;//流水号生成服务
	
	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO ibPbcMtgBaseInfoDAO;
	
	@Resource(name="BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO iBCntMprotBaseInfoDAO;
	
	@Resource(name="IBCrrGntyConDAO")
	IBCrrGntyConDAO iBCrrGntyConDAO;
	
	@Resource(name="BCntMprotPartInfoDAO")
	IBCntMprotPartInfoDAO iBCntMprotPartInfoDAO;
	
	@Resource(name="BPbcMtgStorDeliDAO")
	IBPbcMtgStorDeliDAO iBPbcMtgStorDeliDAO;
	
	@Resource(name="BPbcMtgStockDtlDAO")
	IBPbcMtgStockDtlDAO iBPbcMtgStockDtlDAO;
	
	@Resource(name="ExtIBCntContSlaveAndMortgageInfoDAO")
	ExtIBCntContSlaveAndMortgageInfoDAO extIBCntContSlaveAndMortgageInfoDAO;

	@Override
	@Transactional
	public void saveStockAdjust(BPbcMtgBaseInfoDO bPbcMtgBaseInfoDO) throws ScubeBizException {
		if(null == bPbcMtgBaseInfoDO)
			throw new ScubeBizException("保存信息不能为空！");
		
		BCrrGntyCon bCrrGntyCon = iBCrrGntyConDAO.selectByPrimaryKey(bPbcMtgBaseInfoDO.getSlaveContno());
		
		BCntMprotBaseInfo bCntMprotBaseInfo = iBCntMprotBaseInfoDAO.selectByPrimaryKey(bCrrGntyCon.getPrtclNo());
		
		Map<String ,String> map = new HashMap<String, String>();
		map.put("protocolNo", bCrrGntyCon.getPrtclNo());
		map.put("role", ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		List<BCntMprotPartInfo> bCntMprotPartInfoList =  iBCntMprotPartInfoDAO.selectByRole(map);
		
		//押品信息保存
		BPbcMtgBaseInfo bPbcMtgBaseInfo = new BPbcMtgBaseInfo();
		// 获取机构信息
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		//获得用户信息
		UserInfo user = ContextHolder.getUserInfo();
		
		BeanUtils.copyProperties(bPbcMtgBaseInfoDO, bPbcMtgBaseInfo);
		bPbcMtgBaseInfo.setBrcode(bctlVO.getBrNo());
		bPbcMtgBaseInfo.setLastUpdTlrcd(user.getTlrNo());
		bPbcMtgBaseInfo.setLastUpdTime(new Date());
		bPbcMtgBaseInfo.setMortgageNo(bSysSerialNoService.genSerialNo(ScfBasConstant.MORTGAGE_NO));
		bPbcMtgBaseInfo.setSupplyChainPdId(bCntMprotBaseInfo.getProductId());
		bPbcMtgBaseInfo.setCustcd(bCrrGntyCon.getGutId());
		if(bCntMprotPartInfoList != null && bCntMprotPartInfoList.size()>0 && bCntMprotPartInfoList.get(0)!=null)
			bPbcMtgBaseInfo.setMoniOfCustcd(bCntMprotPartInfoList.get(0).getCustcd());
		bPbcMtgBaseInfo.setMonitorProtocolNo(bCrrGntyCon.getPrtclNo());
		bPbcMtgBaseInfo.setTotPrice(bPbcMtgBaseInfoDO.getConfirmPrice().multiply(bPbcMtgBaseInfoDO.getQuantity()));
		bPbcMtgBaseInfo.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL);
		bPbcMtgBaseInfo.setRation(bCrrGntyCon.getRation());
		ibPbcMtgBaseInfoDAO.insertSelective(bPbcMtgBaseInfo);
		
		//库存调整保存
		BPbcMtgStorDeli bPbcMtgStorDeli = new BPbcMtgStorDeli();
		bPbcMtgStorDeli.setMonitorProtocolNo(bPbcMtgBaseInfo.getMonitorProtocolNo());
		bPbcMtgStorDeli.setTxdate(BSysConstant.WORKDATE);
		bPbcMtgStorDeli.setTxtime(new Date());
		bPbcMtgStorDeli.setTlrcd(user.getTlrNo());
		bPbcMtgStorDeli.setBrcode(bctlVO.getBrNo());
		bPbcMtgStorDeli.setSlaveContno(bPbcMtgBaseInfo.getSlaveContno());
		bPbcMtgStorDeli.setCurcd(bPbcMtgBaseInfo.getCurcd());
		bPbcMtgStorDeli.setBussType(bPbcMtgBaseInfo.getSupplyChainPdId());
		bPbcMtgStorDeli.setFreightarea(bPbcMtgBaseInfo.getFreightarea());
		bPbcMtgStorDeli.setFreightlot(bPbcMtgBaseInfo.getFreightlot());
		bPbcMtgStorDeli.setWarehouse(bPbcMtgBaseInfo.getWarehouse());
		bPbcMtgStorDeli.setMortgageUnits(bPbcMtgBaseInfo.getMortgageUnits());
		bPbcMtgStorDeli.setQuantity(bPbcMtgBaseInfo.getQuantity());
		bPbcMtgStorDeli.setStorOrDeli(ScfBasConstant.STOR_OR_DELI_IN);
		bPbcMtgStorDeli.setTotPrice(bPbcMtgBaseInfo.getPrice());
		bPbcMtgStorDeli.setStorDeliBizType(ScfBasConstant.STOR_DELI_BIZ_TYPE_CORRECT);
		String id = UUIDGeneratorUtil.generate();
		bPbcMtgStorDeli.setId(id);
		iBPbcMtgStorDeliDAO.insertSelective(bPbcMtgStorDeli);
		
		//押品变更流水信息
		BPbcMtgStockDtl bPbcMtgStockDtl = new BPbcMtgStockDtl();
		BeanUtils.copyProperties(bPbcMtgBaseInfo, bPbcMtgStockDtl);
		bPbcMtgStockDtl.setId(UUIDGeneratorUtil.generate());
		bPbcMtgStockDtl.setPid(id);
		bPbcMtgStockDtl.setTotPrice(bPbcMtgStockDtl.getQuantity().multiply(bPbcMtgBaseInfoDO.getConfirmPrice()));
		bPbcMtgStockDtl.setType(ScfBasConstant.STOR_DELI_BIZ_TYPE_CORRECT);
		bPbcMtgStockDtl.setBussType(bPbcMtgBaseInfoDO.getSupplyChainPdId());
		bPbcMtgStockDtl.setMortgageBizType(ScfBasConstant.MORT_BIZ_TYPE_CORRECT_IN);
		bPbcMtgStockDtl.setLastUpdTime(new Date());
		bPbcMtgStockDtl.setLastUpdTlrcd(user.getTlrNo());
		bPbcMtgStockDtl.setStockAdjustType(ScfBasConstant.STOCK_ADJUST_TYPE_ADD);
		iBPbcMtgStockDtlDAO.insertSelective(bPbcMtgStockDtl);
	}

	@Override
	public Page getSlaveContcode(int pageNo, int pageSize, com.huateng.scf.bas.crr.model.BCrrGntyCon bCrrGntyCon) {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(bCrrGntyCon.getConId())) {
			omap.put("conId", bCrrGntyCon.getConId());
		}
		omap.put("mortgageNo", bCrrGntyCon.getMortgageNo());
		Page page = new Page(pageSize, pageNo, 0);
		page.setRecords(extIBCntContSlaveAndMortgageInfoDAO.getContSlaveBaseInfo(omap, page));
		page.setTotalRecord(extIBCntContSlaveAndMortgageInfoDAO.countContSlaveBaseInfo(omap));
		return page;
	}

	@Override
	@Transactional
	public void updateStockAdjust(BPbcMtgBaseInfoDO bPbcMtgBaseInfoDO) throws ScubeBizException {

		if(null == bPbcMtgBaseInfoDO)
			throw new ScubeBizException("保存信息不能为空！");
		
		BigDecimal oldQuantity=bPbcMtgBaseInfoDO.getQuantity();//调整前数量
		BigDecimal quantityAfter=bPbcMtgBaseInfoDO.getNewQuantity();//调整后数量
		
		// 获取机构信息
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		//获得用户信息
		UserInfo user = ContextHolder.getUserInfo();
		
		BPbcMtgBaseInfo bPbcMtgBaseInfo = ibPbcMtgBaseInfoDAO.selectByPrimaryKey(bPbcMtgBaseInfoDO.getMortgageNo());
		
		//押品信息修改
		
		bPbcMtgBaseInfo.setTotPrice(bPbcMtgBaseInfoDO.getConfirmPrice().multiply(bPbcMtgBaseInfoDO.getNewQuantity()));
		bPbcMtgBaseInfo.setQuantity(bPbcMtgBaseInfoDO.getNewQuantity());
		bPbcMtgBaseInfo.setLastUpdTime(new Date());
		bPbcMtgBaseInfo.setLastUpdTlrcd(user.getTlrNo());
		ibPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(bPbcMtgBaseInfo);
		
		//库存调整保存
		BPbcMtgStorDeli bPbcMtgStorDeli = new BPbcMtgStorDeli();
		bPbcMtgStorDeli.setMonitorProtocolNo(bPbcMtgBaseInfo.getMonitorProtocolNo());
		bPbcMtgStorDeli.setTxdate(BSysConstant.WORKDATE);
		bPbcMtgStorDeli.setTxtime(new Date());
		bPbcMtgStorDeli.setTlrcd(user.getTlrNo());
		bPbcMtgStorDeli.setBrcode(bctlVO.getBrNo());
		bPbcMtgStorDeli.setSlaveContno(bPbcMtgBaseInfo.getSlaveContno());
		bPbcMtgStorDeli.setCurcd(bPbcMtgBaseInfo.getCurcd());
		bPbcMtgStorDeli.setPrice(bPbcMtgBaseInfoDO.getConfirmPrice());
		bPbcMtgStorDeli.setBussType(bPbcMtgBaseInfo.getSupplyChainPdId());
		bPbcMtgStorDeli.setFreightarea(bPbcMtgBaseInfo.getFreightarea());
		bPbcMtgStorDeli.setFreightlot(bPbcMtgBaseInfo.getFreightlot());
		bPbcMtgStorDeli.setWarehouse(bPbcMtgBaseInfo.getWarehouse());
		bPbcMtgStorDeli.setMortgageUnits(bPbcMtgBaseInfo.getMortgageUnits());
		int tip = oldQuantity.compareTo(quantityAfter);
		BigDecimal quantity = new BigDecimal(0);
		if(tip<0){//入库
			quantity = quantityAfter.subtract(oldQuantity);
			bPbcMtgStorDeli.setStorOrDeli(ScfBasConstant.STOR_OR_DELI_IN);
		}else{//出库
			quantity = oldQuantity.subtract(quantityAfter);
			bPbcMtgStorDeli.setStorOrDeli(ScfBasConstant.STOR_OR_DELI_OUT);
		}
		bPbcMtgStorDeli.setQuantity(quantity);
		bPbcMtgStorDeli.setTotPrice(bPbcMtgStorDeli.getPrice());
		bPbcMtgStorDeli.setStorDeliBizType(ScfBasConstant.STOR_DELI_BIZ_TYPE_CORRECT);//业务类型
		String id = UUIDGeneratorUtil.generate();
		bPbcMtgStorDeli.setId(id);
		iBPbcMtgStorDeliDAO.insertSelective(bPbcMtgStorDeli);
		
		//押品变更流水信息
		BPbcMtgStockDtl bPbcMtgStockDtl = new BPbcMtgStockDtl();
		BeanUtils.copyProperties(bPbcMtgBaseInfo, bPbcMtgStockDtl);
		bPbcMtgStockDtl.setId(UUIDGeneratorUtil.generate());
		bPbcMtgStockDtl.setPid(id);
		bPbcMtgStockDtl.setQuantity(quantity);
		bPbcMtgStockDtl.setTotPrice(bPbcMtgStockDtl.getQuantity().multiply(bPbcMtgBaseInfoDO.getConfirmPrice()));
		bPbcMtgStockDtl.setType(ScfBasConstant.STOR_DELI_BIZ_TYPE_CORRECT);
		bPbcMtgStockDtl.setBussType(bPbcMtgBaseInfoDO.getSupplyChainPdId());
		if(!StringUtil.isEmpty(bPbcMtgBaseInfoDO.getCustcd())){
			bPbcMtgStockDtl.setCustcd(bPbcMtgBaseInfoDO.getCustcd());
		}

		if(tip<0){//入库
			bPbcMtgStockDtl.setMortgageBizType(ScfBasConstant.MORT_BIZ_TYPE_CORRECT_IN);
		}else{//出库
			bPbcMtgStockDtl.setMortgageBizType(ScfBasConstant.MORT_BIZ_TYPE_CORRECT_OUT);
		}
		bPbcMtgStockDtl.setOldConfirmPrice(bPbcMtgBaseInfo.getConfirmPrice());
		bPbcMtgStockDtl.setOriginalPrice(bPbcMtgBaseInfo.getPrice());
		bPbcMtgStockDtl.setOriginalTotPrice(oldQuantity.multiply(bPbcMtgBaseInfo.getConfirmPrice()));
		bPbcMtgStockDtl.setOriginalQuantity(oldQuantity);
		bPbcMtgStockDtl.setLastUpdTime(new Date());
		bPbcMtgStockDtl.setLastUpdTlrcd(user.getTlrNo());
		bPbcMtgStockDtl.setStockAdjustType(ScfBasConstant.STOCK_ADJUST_TYPE_ADJUST);
		iBPbcMtgStockDtlDAO.insertSelective(bPbcMtgStockDtl);		
	}

}
