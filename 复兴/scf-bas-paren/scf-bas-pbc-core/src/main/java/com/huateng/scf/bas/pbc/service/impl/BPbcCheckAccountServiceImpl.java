package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.fcs.dao.IBPbcMtgChkStockDtlDAO;
import com.huateng.scf.adv.fcs.model.BPbcMtgChkStockDtl;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConVO;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgChkStockInfoDAO;
import com.huateng.scf.bas.pbc.dao.ext.ExtIBPbcMtgChkStockBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgChkStockInfo;
import com.huateng.scf.bas.pbc.dao.model.ext.BPbcMtgChkStockInfoVO;
import com.huateng.scf.bas.pbc.service.IBPbcCheckAccountService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BPbcCheckAccountServiceImpl")
public class BPbcCheckAccountServiceImpl implements IBPbcCheckAccountService {
	
	String date = ScfDateUtil.formatDate(new Date());

	@Resource(name = "ExtIBPbcMtgChkStockBaseInfoDAO")
	ExtIBPbcMtgChkStockBaseInfoDAO extIBPbcMtgChkStockBaseInfoDAO;

	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService iBPbcMtgBaseInfoService;

	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;

	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO ibPbcMtgBaseInfoDAO;

	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO iBCrrGntyConDAO;

	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO iBCntMprotBaseInfoDAO;

	@Resource(name = "BCntMprotPartInfoDAO")
	IBCntMprotPartInfoDAO iBCntMprotPartInfoDAO;

	@Resource(name = "BSysSerialNoServiceImpl")
	private IBSysSerialNoService bSysSerialNoService;// 流水号生成服务

	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO iBNteNoticeBaseDAO;
	
	@Resource(name="IBPbcMtgChkStockInfoDAO")
	IBPbcMtgChkStockInfoDAO iBPbcMtgChkStockInfoDAO;
	
	@Resource(name="BPbcMtgChkStockDtlDAO")
	IBPbcMtgChkStockDtlDAO iBPbcMtgChkStockDtlDAO;

	@Override
	public Page queryChkStockListByPage(int pageNo, int pageSize, HashMap<String, Object> map) {
		if (null == map)
			map = new HashMap<String, Object>();
		/*map.put("checkStockType", ScfBasConstant.CHK_STOCK_DTL_TYPE_CHECK);*/
		Page scfPage = new Page(pageSize, pageNo, 0);
		List<BPbcMtgChkStockInfoVO> list = extIBPbcMtgChkStockBaseInfoDAO.getCheckAccountInfoByPara(map, scfPage);
		List<BPbcMtgChkStockInfoVO> bPbcMtgBaseInfoVOList = new ArrayList<BPbcMtgChkStockInfoVO>();
		HashMap<String, Object> conditionMap = new HashMap<String, Object>();
		for (BPbcMtgChkStockInfoVO bPbcMtgChkStockInfoVO : list) {
			// 获取押品总价格
			conditionMap.put("slaveContno", bPbcMtgChkStockInfoVO.getSlaveContno());
			BigDecimal mortgageTotAmount = iBPbcMtgBaseInfoService.getMortgageSumPriceByParam(conditionMap);
			bPbcMtgChkStockInfoVO.setMortgageTotAmount(mortgageTotAmount);
			// 获取出质人
			bPbcMtgChkStockInfoVO.setCname(bcrmbaseinfodao.selectById(bPbcMtgChkStockInfoVO.getCustcd()).getCname());
			// 获取监管公司名称
			bPbcMtgChkStockInfoVO
					.setPrtclBrNm(bcrmbaseinfodao.selectById(bPbcMtgChkStockInfoVO.getMoniOfCustcd()).getCname());

			bPbcMtgBaseInfoVOList.add(bPbcMtgChkStockInfoVO);
		}
		scfPage.setRecords(bPbcMtgBaseInfoVOList);
		return scfPage;
	}

	@Override
	public Page getContSlaveInfoByProduct(int pageNo, int pageSize, HashMap<String, Object> map) {
		if (null == map)
			map = new HashMap<String, Object>();
		map.put("conStat", "1");
		map.put("state", ScfBasConstant.STATE_VALID);
		Page scfPage = new Page(pageSize, pageNo, 0);
		extIBPbcMtgChkStockBaseInfoDAO.getContSlaveInfoByProduct(map, scfPage);
		return scfPage;
	}

	@Override
	public Page getTblMortgageBaseInfoPageByParam(int pageNo, int pageSize, HashMap<String, Object> map) {
		if (map == null)
			map = new HashMap<String, Object>();
		Page page = new Page(pageSize, pageNo, 0);
		extIBPbcMtgChkStockBaseInfoDAO.getTblMortgageBaseInfoPageByParam(map, page);
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void addCheckAccount(String conId) {
		if (StringUtil.isEmpty(conId))
			throw new ScubeBizException("质押合同号为空");
		String noticeNum = this.addBankCheckConfirm(conId);
		
		// 获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
		
		//保存对账信息
		BCrrGntyCon bCrrGntyCon = iBCrrGntyConDAO.selectByPrimaryKey(conId);
		
		BCntMprotPartInfoExample example = new BCntMprotPartInfoExample();
		com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample.Criteria c = example.createCriteria();
		c.andRoleEqualTo(ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		c.andProtocolNoEqualTo(bCrrGntyCon.getPrtclNo());
		BCntMprotPartInfo bCntMprotPartInfo = new BCntMprotPartInfo();
		List<BCntMprotPartInfo> bCntMprotPartInfoList = iBCntMprotPartInfoDAO.selectByExample(example);
		if(bCntMprotPartInfoList!=null && bCntMprotPartInfoList.size()>0)
			bCntMprotPartInfo = bCntMprotPartInfoList.get(0);
		
		BPbcMtgChkStockInfo bPbcMtgChkStockInfo = new BPbcMtgChkStockInfo();
		bPbcMtgChkStockInfo.setOtherProtocolNo(bCrrGntyCon.getPrtclNo());
		bPbcMtgChkStockInfo.setSlaveContno(conId);
		bPbcMtgChkStockInfo.setCheckStockDate(date);
		bPbcMtgChkStockInfo.setCheckStockTime(new Date());
		bPbcMtgChkStockInfo.setCheckStockTlrcd(user.getTlrNo());
		bPbcMtgChkStockInfo.setCheckStockType(ScfBasConstant.CHK_STOCK_DTL_TYPE_CHECK);
		bPbcMtgChkStockInfo.setCheckStockWay(ScfBasConstant.CHECK_STOCK_WAY_CUST);
		bPbcMtgChkStockInfo.setRecordTlrcd(user.getTlrNo());
		bPbcMtgChkStockInfo.setRecordBrcode(user.getBrNo());
		bPbcMtgChkStockInfo.setCustcd(bCrrGntyCon.getGutId());
		bPbcMtgChkStockInfo.setMoniOfCustcd(bCntMprotPartInfo.getCustcd());
		bPbcMtgChkStockInfo.setStatus(ScfBasConstant.CHECK_STOCK_STATUS_CHECKING);
		bPbcMtgChkStockInfo.setNoticeNo(noticeNum);
		String id = UUIDGeneratorUtil.generate();
		bPbcMtgChkStockInfo.setId(id);
		iBPbcMtgChkStockInfoDAO.insert(bPbcMtgChkStockInfo);
		
		//保存对账明细
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("conId", conId);
		Page scfPage = new Page(Integer.MAX_VALUE, 1, 0);
		extIBPbcMtgChkStockBaseInfoDAO.getTblMortgageBaseInfoPageByParam(map, scfPage);
		if(scfPage !=null && scfPage.getRecords()!=null && scfPage.getRecords().size()>0){
			for (int i = 0; i < scfPage.getRecords().size(); i++) {
				Map<String, Object> mortgageBaseInfo=(Map<String, Object>) scfPage.getRecords().get(i);
				BPbcMtgChkStockDtl bPbcMtgChkStockDtl = new BPbcMtgChkStockDtl();
				bPbcMtgChkStockDtl.setTblId(id);
				bPbcMtgChkStockDtl.setType(ScfBasConstant.CHK_STOCK_DTL_TYPE_CHECK);
				bPbcMtgChkStockDtl.setStockQuantity(mortgageBaseInfo.get("QUANTITY")==null  ? BigDecimal.ZERO:(BigDecimal)mortgageBaseInfo.get("QUANTITY"));// 库存数量
				bPbcMtgChkStockDtl.setConfirmPrice(mortgageBaseInfo.get("CONFIRM_PRICE")==null  ? BigDecimal.ZERO:(BigDecimal)mortgageBaseInfo.get("CONFIRM_PRICE"));// 单价格
				bPbcMtgChkStockDtl.setMortgageLevelOne((String)mortgageBaseInfo.get("MORTGAGE_LEVEL_ONE"));// 质押物一级
				bPbcMtgChkStockDtl.setMortgageLevelTwo((String)mortgageBaseInfo.get("MORTGAGE_LEVEL_TWO"));// 质押物二级
				bPbcMtgChkStockDtl.setMortgageLevelThree((String)mortgageBaseInfo.get("MORTGAGE_LEVEL_THREE"));// 质押物三级
				bPbcMtgChkStockDtl.setProductArea((String)mortgageBaseInfo.get("PRODUCT_AREA"));// 产地
				bPbcMtgChkStockDtl.setVender((String)mortgageBaseInfo.get("VENDER"));// 品牌
				bPbcMtgChkStockDtl.setWarehouseAddress((String)mortgageBaseInfo.get("WAREHOUSE_ADDRESS"));// 存放地
				bPbcMtgChkStockDtl.setEntityQuantity(mortgageBaseInfo.get("QUANTITY")==null  ? BigDecimal.ZERO:(BigDecimal)mortgageBaseInfo.get("QUANTITY"));// 实际数量
				bPbcMtgChkStockDtl.setMortgageUnits((String)mortgageBaseInfo.get("MORTGAGE_UNITS"));// 单位
				bPbcMtgChkStockDtl.setMortgageNo((String)mortgageBaseInfo.get("MORTGAGE_NO"));// 押品编号
				iBPbcMtgChkStockDtlDAO.insert(bPbcMtgChkStockDtl);
			}
		}
		
		
	}

	/**
	 *  银行端发起对账生成对账通知书
	 * @param conId
	 * @return
	 */
	public String addBankCheckConfirm(String conId){
		
		// 获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
		String tlrNo=user.getTlrNo();
		String brCode=user.getBrNo();
		
		BCrrGntyCon bCrrGntyCon = iBCrrGntyConDAO.selectByPrimaryKey(conId);
		
		BCntMprotBaseInfo bCntMprotBaseInfo = iBCntMprotBaseInfoDAO.selectByPrimaryKey(bCrrGntyCon.getPrtclNo());
		
		BCntMprotPartInfoExample example = new BCntMprotPartInfoExample();
		com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample.Criteria c = example.createCriteria();
		c.andRoleEqualTo(ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		c.andProtocolNoEqualTo(bCrrGntyCon.getPrtclNo());
		BCntMprotPartInfo bCntMprotPartInfo = new BCntMprotPartInfo();
		List<BCntMprotPartInfo> bCntMprotPartInfoList = iBCntMprotPartInfoDAO.selectByExample(example);
		if(bCntMprotPartInfoList!=null && bCntMprotPartInfoList.size()>0)
			bCntMprotPartInfo = bCntMprotPartInfoList.get(0);
		
		String appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_DZGL_F_APP_NO);//业务申请编号生成
		
		String noticeNum = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_DZGL_F_NOTICE_NO);//通知书编号生成
		
		BNteNoticeBase bNteNoticeBase =  new BNteNoticeBase();
		bNteNoticeBase.setAppno(appno);
		bNteNoticeBase.setNum(noticeNum);
		bNteNoticeBase.setMonitorProtocolNo(bCrrGntyCon.getPrtclNo());
		bNteNoticeBase.setProtocolCode(bCntMprotBaseInfo.getProtocolCode());
		bNteNoticeBase.setSlaveContno(conId);
		bNteNoticeBase.setSlaveContcode(conId);
		bNteNoticeBase.setCustcd(bCrrGntyCon.getGutId());
		bNteNoticeBase.setMoniOfCustcd(bCntMprotPartInfo.getCustcd());
		bNteNoticeBase.setNoticeType(NoticeConstant.NOTICE_TYPE_7);
		bNteNoticeBase.setBrcode(brCode);
		bNteNoticeBase.setMoniOfName(bCntMprotPartInfo.getCname());
		bNteNoticeBase.setTlrn(tlrNo);
		bNteNoticeBase.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);
		bNteNoticeBase.setPledgeMode(bCntMprotBaseInfo.getMoniType());
		bNteNoticeBase.setBussType(bCntMprotBaseInfo.getProductId());
		bNteNoticeBase.setAppliDate(date);
		bNteNoticeBase.setSignDate(date);
		return noticeNum;
	}

	@Override
	@Transactional
	public void checkAccountConfirm(com.huateng.scf.bas.pbc.model.BPbcMtgChkStockInfoVO bPbcMtgChkStockInfoVO) {
		if(null == bPbcMtgChkStockInfoVO)
			throw new ScubeBizException("参数不能为空");
		
		BPbcMtgChkStockInfo bPbcMtgChkStockInfo = iBPbcMtgChkStockInfoDAO.selectByPrimaryKey(bPbcMtgChkStockInfoVO.getId());
		bPbcMtgChkStockInfo.setCheckStockResults(bPbcMtgChkStockInfoVO.getCheckStockResults());
		bPbcMtgChkStockInfo.setCurrentCreditAmt(bPbcMtgChkStockInfoVO.getCurrentCreditAmt());
		bPbcMtgChkStockInfo.setReason(bPbcMtgChkStockInfoVO.getReason());
		bPbcMtgChkStockInfo.setCheckStockConfirmDate(date);
		bPbcMtgChkStockInfo.setMoniPrincipal(bPbcMtgChkStockInfoVO.getMoniPrincipal());
		bPbcMtgChkStockInfo.setStatus(ScfBasConstant.CHECK_STOCK_STATUS_FINISHED);
		iBPbcMtgChkStockInfoDAO.updateByPrimaryKey(bPbcMtgChkStockInfo);
	}

	@Override
	public BigDecimal getSumTblMortgageBaseInfoByParam(HashMap<String, Object> map) {
		return extIBPbcMtgChkStockBaseInfoDAO.getSumTblMortgageBaseInfoByParam(map);
	}

}
