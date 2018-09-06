/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月17日下午4:13:03
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月17日下午4:13:03	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("RBcpDebtBussInfoServiceImpl")
public class RBcpDebtBussInfoServiceImpl implements IRBcpDebtBussInfoService {
	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;
	@Resource(name = "IRBcpDebtBussInfoDAO")
	IRBcpDebtBussInfoDAO iRBcpDebtBussInfoDAO;
	@Resource(name = "rBcpDebtBussDtlService")
	IRBcpDebtBussDtlService rBcpDebtBussDtlService;
	@Autowired
	ScubeUserService scubeUserService;

	@Override
	@Transactional
	public String addRBcpDebtBussInfo(RBcpDebtBussInfo rBcpDebtBussInfo) {
		if (StringUtils.isEmpty(rBcpDebtBussInfo.getId())) {
			rBcpDebtBussInfo.setId(UUIDGeneratorUtil.generate());
		}
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussInfo bcpDebtBussInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussInfo();
		try {
			BeanUtils.copyProperties(rBcpDebtBussInfo, bcpDebtBussInfo);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		try {
			iRBcpDebtBussInfoDAO.insertSelective(bcpDebtBussInfo);
		} catch (BeansException e) {
			throw new ScubeBizException("入池流水新增异常");
		}
		return null;
	}

	// 删除应收账款单据基本信息，不会去级联删除应收账款单据明细信息
	@Override
	@Transactional
	public int deleteRBcpDebtBussInfo(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 修改应收账款单据基本信息，也会新增应收账款基本信息明细
	@Override
	@Transactional
	public int updateRBcpDebtBussInfo(RBcpDebtBussInfo rBcpDebtBussInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 查询具体应收账款单据基本信息
	@Override
	public RBcpDebtBussInfo findRBcpDebtBussInfoByKey(RBcpDebtBussInfo rBcpDebtBussInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	// 分页条件查询应收账款单据基本信息
	@Override
	public Page findRBcpDebtBussInfoPageByPage(int pageNo, int pageSize, RBcpDebtBussInfo rBcpDebtBussInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void invoiceOutpoolAddSave(List insertDebtList, DebtBussInfoVO debtVO) {

		// com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO billVO=null;
		// //修改发票出池状态
		// for (int i = 0; i < insertDebtList.size(); i++) {
		// billVO = (DebtBillsInfoVO) insertDebtList.get(i);
		// TblDebtBaseInfo debtBaseInfo = this.get(billVO.getId());
		// debtBaseInfo.setPoolFlag(DebtConstants.POOL_FLAG_OUT_POOL);
		// debtBaseInfo.setIsLocked(SCFConstants.UNLOCKED);
		// debtBaseInfo.setLockAppno(null);
		// if(!DataFormat.isEmpty(billVO.getIssueReason())){
		// debtBaseInfo.setIssueReason(billVO.getIssueReason());
		// }
		// if(!DataFormat.isEmpty(billVO.getOtherReason())){
		// debtBaseInfo.setOtherReason(billVO.getOtherReason());
		// }
		// this.update(debtBaseInfo);
		// }
	}

	/*
	 * 应收账款业务流水新增
	 */
	/*
	 * 应收账款业务流水新增
	 */
	@Transactional
	@Override
	public RBcpDebtBussInfo debtBussInfoAdd(DebtBussInfoVO debtVO) {

		ScfGlobalInfo gb = ScfBaseData.getScfGlobalInfo();
		RBcpDebtBussInfo debtBussInfo = new RBcpDebtBussInfo();
		BeanUtils.copyProperties(debtVO, debtBussInfo);
		debtBussInfo.setId(UUIDGeneratorUtil.generate(debtBussInfo));
		if (StringUtils.isEmpty(debtVO.getAppno())) {
			// SJDJ 表示商纠登记,日期， 01表示应收账款， TODO
			String appno = "SJDJ" + ScfDateUtil.formatDate(new Date()) + "01" + UUIDGeneratorUtil.generate(debtBussInfo).substring(26);
			debtBussInfo.setAppno(appno);
		} else {
			debtBussInfo.setAppno(debtVO.getAppno());
		}
		// debtBussInfo.setApplyType(debtVO.getApplyType());
		debtBussInfo.setCostAccount(debtVO.getBalanceAccount());
		debtBussInfo.setAccountNo(debtVO.getAccountNo());
		debtBussInfo.setDebtNum(debtVO.getTotalNum());
		debtBussInfo.setTlrcd(gb.getTlrNo());
		debtBussInfo.setBrcode(gb.getBrCode());
		// debtBussInfo.setOtherReason(debtVO.getOtherReason());
		// debtBussInfo.setPurchaseDate(debtVO.getPurchaseDate());
		debtBussInfo.setAppDate(ScfDateUtil.formatDate(new Date()));
		this.addRBcpDebtBussInfo(debtBussInfo);
		return debtBussInfo;

	}

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;

	@Override
	@Transactional
	public RBcpDebtBussInfo saveDebtOutPoolInfo(DebtBussInfoVO debtVO, String AppType) {
		UserInfo gb = ContextHolder.getUserInfo();
		RBcpDebtBussInfo debtBussInfo = new RBcpDebtBussInfo();
		try {
			BeanUtils.copyProperties(debtVO, debtBussInfo);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		String uuid = UUIDGeneratorUtil.generate();
		debtBussInfo.setId(uuid);
		if (StringUtils.isEmpty(debtVO.getAppno())) {
			// TODO daq 2017/01/11
			String appno = "";
			debtBussInfo.setAppno(appno);
		} else {
			debtBussInfo.setAppno(debtVO.getAppno());
		}
		debtBussInfo.setApplyType(AppType);// 出池/入池
		debtBussInfo.setCostAccount(debtVO.getBalanceAccount());
		debtBussInfo.setAccountNo(debtVO.getAccountNo());
		debtBussInfo.setDebtNum(debtVO.getTotalNum());
		debtBussInfo.setTlrcd(gb.getTlrNo());
		debtBussInfo.setBrcode(gb.getBrNo());
		debtBussInfo.setOtherReason(debtVO.getOtherReason());
		debtBussInfo.setCostAccount(debtVO.getBalanceAccount());
		debtBussInfo.setPurchaseDate(debtVO.getPurchaseDate());
		debtBussInfo.setAppDate(ScfDateUtil.formatDate(new Date()));
		debtBussInfo.setAmount(debtVO.getTotalBillsAmount());
		this.addRBcpDebtBussInfo(debtBussInfo);
		return debtBussInfo;

	}

	/**
	 *
	 * @Description: 更新入池流水
	 * @param debtVO
	 * @param applyType
	 * @throws ScubeBizException
	 */
	@Override
	@Transactional
	public void updateInpoolInfo(DebtBussInfoVO debtVO, String applyType) throws ScubeBizException {
		RBcpDebtBussInfo debtBussInfo = new RBcpDebtBussInfo();
		try {
			BeanUtils.copyProperties(debtVO, debtBussInfo);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		debtBussInfo.setId(UUIDGeneratorUtil.generate());
		debtBussInfo.setMastContno(debtVO.getMastContno());
		debtBussInfo.setCustcdBuyer(debtVO.getCustcdBuyer());
		debtBussInfo.setCustcdSaller(debtVO.getCustcdSaller());
		debtBussInfo.setAmount(debtVO.getTotalAmount());// 入池金额
		// debtBussInfo.setApplyType(DebtConstants.APPLY_TYPE_INPOOL);
		debtBussInfo.setApplyType(applyType);
		// 申请编号--设置为合同号
		debtBussInfo.setAppno(debtVO.getAppno());
		// debtBussInfo.setInsertDate(ScfDateUtil.formatDate(debtVO.getInpoolDate()));//入池时间保存在insertDate字段，这里直接使用insertDate
		Integer debtNum = debtVO.getTotalNum() == null ? new Integer("0") : debtVO.getTotalNum();
		debtBussInfo.setDebtNum(debtNum);
		BigDecimal totalAmount = debtVO.getTotalAmount() == null ? new BigDecimal("0") : debtVO.getTotalAmount();
		debtBussInfo.setTotalDebtAmount(totalAmount);
		debtBussInfo.setCurcd(debtVO.getCurcd());
		debtBussInfo.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
		this.addRBcpDebtBussInfo(debtBussInfo);
	}

	/**
	 *
	 * @Description: 查询应收账款回款
	 * @param commonQueryVO
	 * @param pageSize
	 * @param pageNo
	 * @throws ScubeBizException
	 */
	@Override
	public Page queryDebtRepaymentInfo(DebtCommonQryVO commonQueryVO, int pageSize, int pageNo) throws ScubeBizException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(commonQueryVO.getCustcdSaller_Q())) {
			parameters.put("custcdSaller_Q", commonQueryVO.getCustcdSaller_Q());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getCustcdBuyer_Q())) {
			parameters.put("custcdBuyer_Q", commonQueryVO.getCustcdBuyer_Q());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getMastContno())) {
			parameters.put("mastContno", commonQueryVO.getMastContno());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getBussType_Q())) {
			parameters.put("bussType_Q", commonQueryVO.getBussType_Q());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getLoanWay_Q())) {
			parameters.put("loanWay_Q", commonQueryVO.getLoanWay_Q());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getBrcode())) {
			parameters.put("brcode", commonQueryVO.getBrcode());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getStart_Q())) {
			parameters.put("start_Q", commonQueryVO.getStart_Q());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getEnd_Q())) {
			parameters.put("end_Q", commonQueryVO.getEnd_Q());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getReturnMethod_Q())) {
			parameters.put("returnMethod_Q", commonQueryVO.getReturnMethod_Q());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getRepayPurpose_Q())) {
			parameters.put("repayPurpose_Q", commonQueryVO.getRepayPurpose_Q());
		}
		if(commonQueryVO.getBussTypeList_Q()!=null && commonQueryVO.getBussTypeList_Q().size()>0){
			parameters.put("bussTypeList", commonQueryVO.getBussTypeList_Q());
		}

		List<DebtBillsInfoVO> list = iRBcpDebtBussInfoDAO.queryDebtRepaymentInfo(parameters, pageSize, pageNo);

		List<com.huateng.scf.rec.bcp.model.DebtBillsInfoVO> responseList = new ArrayList<com.huateng.scf.rec.bcp.model.DebtBillsInfoVO>();

		Iterator<DebtBillsInfoVO> it = list.iterator();
		while (it.hasNext()) {
			DebtBillsInfoVO billsInfoVO = it.next();
			com.huateng.scf.rec.bcp.model.DebtBillsInfoVO debtvo = new com.huateng.scf.rec.bcp.model.DebtBillsInfoVO();
			BeanUtils.copyProperties(billsInfoVO, debtvo);
			BctlVO bctlVO = scubeUserService.selectBctlByBrNo(billsInfoVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			UserInfo userInfo = scubeUserService.selectUserByTlrNo(billsInfoVO.getTlrNo(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			if (bctlVO != null && StringUtils.isNotEmpty(bctlVO.getBrName())) {
				debtvo.setBrcodeNm(bctlVO.getBrName());
			}
			if (userInfo != null && StringUtils.isNotEmpty(userInfo.getTlrName())) {
				debtvo.setTlrName(userInfo.getTlrName());
			}
			responseList.add(debtvo);

		}
		Integer count = iRBcpDebtBussInfoDAO.queryDebtRepaymentInfoCount(parameters);
		Page pageResult = new Page(pageSize, pageNo, 0);
		pageResult.setRecords(responseList);
		pageResult.setTotalRecord(count);

		return pageResult;
	}

}
