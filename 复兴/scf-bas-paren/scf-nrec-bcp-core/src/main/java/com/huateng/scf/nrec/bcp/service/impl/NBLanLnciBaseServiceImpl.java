package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.ext.ExtBLanDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.INBLanLnciBaseService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliRepaymentDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service(INBLanLnciBaseService.BeanId)
public class NBLanLnciBaseServiceImpl implements INBLanLnciBaseService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;

	// 回款信息
	@Resource(name = "IRBcpAppliRepaymentDAO")
	IRBcpAppliRepaymentDAO rBcpAppliRepaymentDAO;

	@Resource(name = "ExtBLanDAO")
	ExtBLanDAO extBLanDAO;

	/**
	 * 查询融资列表
	 * 
	 * @param lnciQryVO
	 * @return
	 * @author Qinwei
	 * @date 2017年6月2日 下午5:30:06
	 * @returnType
	 */
	@Override
	public Page queryLnciInfoByBusinessNo(DebtLnciQryVO lnciQryVO) {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(lnciQryVO.getBussContno())) {
			omap.put("businessNo", lnciQryVO.getBussContno());
		}
		// 不是查池敞口余额才加如下的查询条件 add by xiaolong.xiong 2013-09-27
		if (!ScfBasConstant.FLAG_ON.equals(lnciQryVO.getFlag())) {
			// 借据未被锁定或是被本流程锁定
			omap.put("isLocked", ScfBasConstant.UNLOCKED);
			if (!StringUtil.isEmpty(lnciQryVO.getAppno())) {
				omap.put("lockAppno", lnciQryVO.getAppno());
			}
		}

		if (!StringUtil.isEmpty(lnciQryVO.getLnciType())) {
			omap.put("lnciType", lnciQryVO.getLnciType());
		}

		if (!StringUtil.isEmpty(lnciQryVO.getLoanAppno())) {
			omap.put("loanAppno", lnciQryVO.getLoanAppno());
		}

		if (!StringUtil.isEmpty(lnciQryVO.getStartDate())) {
			omap.put("startDate", lnciQryVO.getStartDate());
		}

		if (!StringUtil.isEmpty(lnciQryVO.getDebetId())) {
			omap.put("debetId", lnciQryVO.getDebetId());
		}

		omap.put("state", ScfBasConstant.FLAG_ON);// 生效的借据

		if (ScfBasConstant.FLAG_ON.equals(lnciQryVO.getFlag())) {
			omap.put("isSettle", ScfBasConstant.FLAG_OFF);// 未结清的借据
		}
		Page page = new Page();
		page.setRecords(bLanLnciBaseDAO.queryLnciInfoByBusinessNo(omap));
		return page;
	}

	/**
	 * 
	 * 根据借据编号查询借据信息
	 * 
	 * @param debtId
	 * @return
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年6月2日 下午8:12:36
	 */
	@Override
	public BLanLnciBase findBLanLnciBaseByDebtId(String debtId) throws ScubeBizException {
		BLanLnciBaseExample bLanLnciBaseExample = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria criteria = bLanLnciBaseExample.createCriteria();
		criteria.andDebetIdEqualTo(debtId);
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> bLanLnciBaseList = bLanLnciBaseDAO.selectByExample(bLanLnciBaseExample);
		BLanLnciBase bLanLnciBase = new BLanLnciBase();
		if (bLanLnciBaseList != null && bLanLnciBaseList.size() == 1) {
			BeanUtils.copyProperties(bLanLnciBaseList.get(0), bLanLnciBase);
			return bLanLnciBase;
		} else {
			return null;
		}

	}

	@Override
	public void setLnciIsSettle(BLanLnciBase bLanLnciBase) throws ScubeBizException {
		// 解决在没有批量的情况下
		BigDecimal openAmt = bLanLnciBase.getLnciBal()
				.subtract(bLanLnciBase.getAddBailAmount() != null ? bLanLnciBase.getAddBailAmount() : BigDecimal.ZERO)
				.subtract(bLanLnciBase.getBailAmount() != null ? bLanLnciBase.getBailAmount() : BigDecimal.ZERO)
				.subtract(bLanLnciBase.getAddCashEqtAmt() != null ? bLanLnciBase.getAddCashEqtAmt() : BigDecimal.ZERO)
				.subtract(bLanLnciBase.getInitCashEqtAmt() != null ? bLanLnciBase.getInitCashEqtAmt() : BigDecimal.ZERO);
		if (openAmt.compareTo(BigDecimal.ZERO) <= 0) {
			bLanLnciBase.setIsSettle(ScfBasConstant.FLAG_ON);// 已结清
		}
		// 解锁借据
		bLanLnciBase.setIsLocked("0");// 未锁定
		bLanLnciBase.setLockAppno("");
		this.updateBLanLnciBase(bLanLnciBase);
	}

	@Transactional
	@Override
	public int updateBLanLnciBase(BLanLnciBase bLanLnciBase) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBasedal = new com.huateng.scf.bas.lan.dao.model.BLanLnciBase();
		try {
			BeanUtils.copyProperties(bLanLnciBase, bLanLnciBasedal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("借据基本信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10004), BLanErrorConstant.SCF_BAS_LAN_10004);
		}
		int i = 0;
		try {
			i = bLanLnciBaseDAO.updateByPrimaryKeySelective(bLanLnciBasedal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("借据基本信息更新异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10006), BLanErrorConstant.SCF_BAS_LAN_10006);
		}
		return i;
	}

	// 分页条件查询对应借据信息
	@Override
	public Page selectBLanLnciBaseInfoByPage(int pageNo, int pageSize, BLanLnciBase bLanLnciBase) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BLanLnciBaseExample bLanLnciBaseExample = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria criteria = bLanLnciBaseExample.createCriteria();
		bLanLnciBaseExample.setOrderByClause("TIMESTAMPS DESC");
		if (bLanLnciBase != null) {
			if (StringUtils.isNotEmpty(bLanLnciBase.getLockAppno())) {
				criteria.andLockAppnoEqualTo(bLanLnciBase.getLockAppno());
			}
			if (StringUtils.isNotEmpty(bLanLnciBase.getIsLocked())) {
				criteria.andIsLockedEqualTo(bLanLnciBase.getIsLocked());
			}

		}
		bLanLnciBaseDAO.selectByPage(bLanLnciBaseExample, page);
		return page;
	}

	@Override
	public List<DebtLnciBaseInfoVO> selectBLanLnciBaseListByDebetId(List<RBcpDebtInfoVO> list) throws ScubeBizException {
		// 1.取出对应的单据Id
		ArrayList<String> arrayList = new ArrayList<String>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (list != null && list.size() > 0) {
			for (RBcpDebtInfoVO rBcpDebtBaseInfo1 : list) {
				if (StringUtils.isNotEmpty(rBcpDebtBaseInfo1.getId())) {
					arrayList.add(rBcpDebtBaseInfo1.getId());
				}
			}
			map.put("debtIdList", arrayList);
		} else {
			return null;
		}
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> bLanLnciBaseList = extBLanDAO.getNoPoolBLanLnciBaseByDebtIdList(map,null,false);
		if (bLanLnciBaseList != null && bLanLnciBaseList.size() > 0) {
			ArrayList<DebtLnciBaseInfoVO> arrayList2 = new ArrayList<DebtLnciBaseInfoVO>();
			for (com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBase : bLanLnciBaseList) {
				DebtLnciBaseInfoVO payMentLanInfo = new DebtLnciBaseInfoVO();
				BeanUtils.copyProperties(bLanLnciBase, payMentLanInfo);
				BigDecimal receInt = payMentLanInfo.getReceivableInt() != null ? payMentLanInfo.getReceivableInt() : new BigDecimal(0);
				BigDecimal recePunInt = payMentLanInfo.getReceivablePunishInt() != null ? payMentLanInfo.getReceivablePunishInt() : new BigDecimal(0);
				payMentLanInfo.setInTableInt(receInt.add(recePunInt));// 欠息总额=应收欠息+应收罚息
				payMentLanInfo.setRepayAmount(BigDecimal.ZERO);
				arrayList2.add(payMentLanInfo);
			}
			return arrayList2;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void addRepayInfoAndLockLnciBase(RBcpAppliBussInfo rBcpAppliBussInfo, List<BLanLnciBase> bLanLnciBaseList) throws ScubeBizException {
		// 1.校验数据
		if (rBcpAppliBussInfo == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		} else if (bLanLnciBaseList == null || bLanLnciBaseList.size() == 0) {
			return;
		}
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		// 2.新增回款信息
		for (BLanLnciBase bLanLnciBase : bLanLnciBaseList) {
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment rBcpAppliRepayment = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment();
			rBcpAppliRepayment.setId(UUIDGeneratorUtil.generate());
			rBcpAppliRepayment.setAppno(rBcpAppliBussInfo.getAppno());
			rBcpAppliRepayment.setDebetNo(bLanLnciBase.getDebetId());// 借据号
			if (DebtConstants.RETURN_METHOD_BUYER_PAYMENT.equals(rBcpAppliBussInfo.getReturnMethod())) {
				rBcpAppliRepayment.setCustcd(rBcpAppliBussInfo.getCustcdBuyer());// 买方客户内部号
			} else {
				rBcpAppliRepayment.setCustcd(rBcpAppliBussInfo.getCustcdSaller());// 卖方客户内部号
			}
			rBcpAppliRepayment.setTlrcd(tlrcd);
			rBcpAppliRepayment.setBrcode(brcode);
			rBcpAppliRepayment.setRepayDate(BSysConstant.WORKDATE);// txdate
			rBcpAppliRepayment.setCurcd(rBcpAppliBussInfo.getCurcd());// 默认人民币
			rBcpAppliRepayment.setReturnMethod(rBcpAppliBussInfo.getReturnMethod());// 还款类型
			rBcpAppliRepayment.setRepayAmount(bLanLnciBase.getRepayAmount());// 还款金额
			rBcpAppliRepayment.setMastContno(rBcpAppliBussInfo.getMastContno());// 主合同号
			rBcpAppliRepayment.setPayAmount(bLanLnciBase.getRepayAmount());// 入账金额
			rBcpAppliRepayment.setMemo(bLanLnciBase.getLnciStatus());// 借据状态
			BigDecimal receInt = bLanLnciBase.getReceivableInt() != null ? bLanLnciBase.getReceivableInt() : new BigDecimal(0);
			BigDecimal recePunInt = bLanLnciBase.getReceivablePunishInt() != null ? bLanLnciBase.getReceivablePunishInt() : new BigDecimal(0);
			// 这里存储页面的欠息总额(实际还息金额)
			rBcpAppliRepayment.setRepayIntamt(receInt.add(recePunInt));
			// 这里存储页面的借据余额(实际还本金额)
			rBcpAppliRepayment.setRepayBalamt(bLanLnciBase.getLnciBal());//
			rBcpAppliRepayment.setAccountNo(rBcpAppliBussInfo.getBailAccount());// 保证金账号
			rBcpAppliRepayment.setReturnType(rBcpAppliBussInfo.getReturnType());// 还款方式
			// 新增回款信息
			rBcpAppliRepaymentDAO.insertSelective(rBcpAppliRepayment);
			// 3.锁定对应借据(需要查看这张借据是否已经被锁定，如果被锁定需要报错提示。)
			com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBase2 = bLanLnciBaseDAO.selectByPrimaryKey(bLanLnciBase.getDebetNo());
			if (bLanLnciBase2 != null) {
				if (!StringUtil.isEmpty(bLanLnciBase2.getIsLocked()) && bLanLnciBase2.getIsLocked().equals(RBcpDebtConstant.IS_LOCKED_TRUE)) {
					throw new ScubeBizException("借据号为" + bLanLnciBase.getDebetId() + "的融资信息已被锁定，请重新选择融资信息！");
				}
				bLanLnciBase2.setIsLocked(RBcpDebtConstant.IS_LOCKED_TRUE);
				bLanLnciBase2.setLockAppno(rBcpAppliBussInfo.getAppno());
				try {
					bLanLnciBaseDAO.updateByPrimaryKeySelective(bLanLnciBase2);
				} catch (Exception e) {
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10016),
							BLanErrorConstant.SCF_BAS_LAN_10016);
				}
			} else {
				throw new ScubeBizException("无借据号为" + bLanLnciBase.getDebetId() + "的融资信息，锁定对应借据失败！");
			}
		}
		return;
	}

	@Override
	@Transactional
	public void deleteRepayInfoAndReleaseLnciBase(String appno) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 删除回款信息
		RBcpAppliRepaymentExample rBcpAppliRepaymentExample = new RBcpAppliRepaymentExample();
		RBcpAppliRepaymentExample.Criteria createCriteria = rBcpAppliRepaymentExample.createCriteria();
		createCriteria.andAppnoEqualTo(appno);
		rBcpAppliRepaymentDAO.deleteByExample(rBcpAppliRepaymentExample);
		// 解锁对应的借据信息
		releaseBLanLnciBase(appno);
		return;

	}

	@Override
	@Transactional
	public void lockBLanLnciBase(String appno, List<BLanLnciBase> bLanLnciBaseList) throws ScubeBizException {
		if (StringUtils.isEmpty(appno) || bLanLnciBaseList == null || bLanLnciBaseList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		for (BLanLnciBase bLanLnciBase : bLanLnciBaseList) {
			com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBase2 = bLanLnciBaseDAO.selectByPrimaryKey(bLanLnciBase.getDebetNo());
			if (bLanLnciBase2 != null) {
				if (bLanLnciBase2.getIsLocked().equals(RBcpDebtConstant.IS_LOCKED_TRUE)) {
					throw new ScubeBizException("借据号为" + bLanLnciBase.getDebetId() + "的融资信息已被锁定，请重新选择融资信息！");
				}
				bLanLnciBase2.setIsLocked(RBcpDebtConstant.IS_LOCKED_TRUE);
				bLanLnciBase2.setLockAppno(appno);
				try {
					bLanLnciBaseDAO.updateByPrimaryKeySelective(bLanLnciBase2);
				} catch (Exception e) {
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10016),
							BLanErrorConstant.SCF_BAS_LAN_10016);
				}
			} else {
				throw new ScubeBizException("无借据号为" + bLanLnciBase.getDebetId() + "的融资信息，锁定对应借据失败！");
			}
		}
		return;

	}

	@Override
	@Transactional
	public void releaseBLanLnciBase(String appno) throws ScubeBizException {
		BLanLnciBaseExample bLanLnciBaseExample = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria criteria = bLanLnciBaseExample.createCriteria();
		criteria.andLockAppnoEqualTo(appno);
		try {
			List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> bLanLnciBaseList = bLanLnciBaseDAO.selectByExample(bLanLnciBaseExample);
			if (bLanLnciBaseList != null && bLanLnciBaseList.size() > 0) {
				for (com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBase1 : bLanLnciBaseList) {
					bLanLnciBase1.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);
					bLanLnciBase1.setLockAppno("");
					bLanLnciBaseDAO.updateByPrimaryKeySelective(bLanLnciBase1);
				}
			} else {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10017),
						BLanErrorConstant.SCF_BAS_LAN_10017);
			}
		} catch (Exception e) {// 解锁失败
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10017), BLanErrorConstant.SCF_BAS_LAN_10017);
		}
		return;

	}

	/**
	 * 根据应收账款ID获取借据信息
	 * @param commonQueryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月5日下午4:01:28
	 */
	@Override
	public Page getLnciBaseInfoByDebtId(DebtCommonQryVO commonQueryVO)
	{
		ArrayList<String> debtIds = new ArrayList<String>();
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(commonQueryVO.getDebetNo_Q()))
		{
			if(commonQueryVO.getDebetNo_Q().indexOf("/f")==-1){
				debtIds.add(commonQueryVO.getDebetNo_Q());
			}else{
				String[] id=commonQueryVO.getDebetNo_Q().split("/f");
				for(String debtId:id)
				{
					if(!StringUtil.isEmpty(debtId))
					{
						debtIds.add(debtId);
					}
				}
			}
		}
		omap.put("debtIdList", debtIds);
		if(!StringUtil.isEmpty(commonQueryVO.getMastContno()))
		{
			omap.put("mastContno", commonQueryVO.getMastContno());
		}
		int total = extBLanDAO.countNoPoolBLanLnciBaseByDebtIdList(omap);
		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), total);
		page.setRecords(extBLanDAO.getNoPoolBLanLnciBaseByDebtIdList(omap,page,true));
		page.setTotalRecord(total);
		return page;
	}

}
