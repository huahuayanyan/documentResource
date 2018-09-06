/**
 * 
 */
package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INFactFinanceBaseService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtPoolDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPoolExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2017年1月11日下午5:32:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年1月11日下午5:32:48              新增
 *
 *            </pre>
 */
@ScubeService
@Service("NRBcpDebtPoolServiceImpl")
public class NRBcpDebtPoolServiceImpl implements INRBcpDebtPoolService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rbcpdebtinfodao;

	@Resource(name = "RBcpDebtPoolDAO")
	IRBcpDebtPoolDAO rBcpDebtPoolDAO;

	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bCntBcpInfoService;

	@Resource(name = "NFactFinanceBaseServiceImpl")
	INFactFinanceBaseService nfactfinancebaseservice;

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rbcpdebtinfoservice;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Transactional
	@Override
	public void addRBcpDebtPool(RBcpDebtPool rBcpDebtPool) throws ScubeBizException {
		// ScfCommonUtil.setCommonField(RBcpDebtPool);//设置公共字段 add by
		// huangshuidan 2016-11-11
		rBcpDebtPool.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool rBcpDebtPooldal = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool();
		try {
			BeanUtils.copyProperties(rBcpDebtPool, rBcpDebtPooldal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("应收账款池信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_00000), RBcpErrorConstant.SCF_REC_BCP_00000);
		}
		try {
			// TODO
			rBcpDebtPoolDAO.insertSelective(rBcpDebtPooldal);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("应收账款池信息插入异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_00001), RBcpErrorConstant.SCF_REC_BCP_00001);
		}
	}

	@Transactional
	@Override
	public int updateRBcpDebtPool(RBcpDebtPool rBcpDebtPool) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool rBcpDebtPooldal = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool();
		try {
			BeanUtils.copyProperties(rBcpDebtPool, rBcpDebtPooldal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("应收账款池信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_00000), RBcpErrorConstant.SCF_REC_BCP_00000);
		}
		int i = 0;
		try {
			i = rBcpDebtPoolDAO.updateByPrimaryKeySelective(rBcpDebtPooldal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("应收账款池信息更新异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_00002), RBcpErrorConstant.SCF_REC_BCP_00002);
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteRBcpDebtPool(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = rBcpDebtPoolDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("应收账款池信息删除异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_00003), RBcpErrorConstant.SCF_REC_BCP_00003);
		}
		return i;
	}

	@Transactional
	@Override
	public RBcpDebtPool findRBcpDebtPoolByKey(String key) throws ScubeBizException {
		RBcpDebtPool rBcpDebtPool = new RBcpDebtPool();
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool rBcpDebtPooldal = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool();
		rBcpDebtPooldal = rBcpDebtPoolDAO.selectByPrimaryKey(key);
		try {
			BeanUtils.copyProperties(rBcpDebtPooldal, rBcpDebtPool);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("应收账款池信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_00000), RBcpErrorConstant.SCF_REC_BCP_00000);
		}
		return rBcpDebtPool;
	}

	/**
	 * 根据合同号判断额度融资池是否存在
	 */
	@Override
	public boolean checkPoolIsExist(String mastContno) throws ScubeBizException {
		// TODO Auto-generated method stub
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool> list = rBcpDebtPoolDAO.checkPoolIsExist(mastContno);
		boolean result = false;
		if (list.size() > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * 修改出池信息
	 */
	@SuppressWarnings("rawtypes")
	@Transactional
	@Override
	public void updateOutpoolInfo(DebtBussInfoVO debtVO, List<DebtContVO> contlist) throws ScubeBizException {
		// 融资利率
		BigDecimal loanPercent = null;
		Iterator it = contlist.iterator();
		while (it.hasNext()) {
			DebtContVO vo = (DebtContVO) it.next();
			loanPercent = vo.getLoanPercent();
		}
		List<RBcpDebtPool> list = this.queryDebtPollByMastContno(debtVO.getMastContno(), debtVO.getCustcdSaller());
		if (list != null && list.size() > 0) {
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				RBcpDebtPool tblDebtPool = (RBcpDebtPool) iter.next();
				// 发票池金额
				BigDecimal totalDebtAmount_P = tblDebtPool.getTotalDebtAmount() == null ? new BigDecimal("0") : tblDebtPool.getTotalDebtAmount();
				// 本次发票出池金额
				BigDecimal totalAmount = debtVO.getTotalAmount() == null ? new BigDecimal("0") : debtVO.getTotalAmount();
				tblDebtPool.setTotalDebtAmount(totalDebtAmount_P.subtract(totalAmount));
				// 池发票余额
				BigDecimal totalDebtRemainAmount_p = tblDebtPool.getTotalDebtRemainAmount() == null ? new BigDecimal("0")
						: tblDebtPool.getTotalDebtRemainAmount();
				tblDebtPool.setTotalDebtRemainAmount(totalDebtRemainAmount_p.subtract(totalAmount));
				// 池可融资余额
				BigDecimal poolUseableAmount_p = tblDebtPool.getPoolUseableAmount() == null ? new BigDecimal("0")
						: tblDebtPool.getPoolUseableAmount();
				loanPercent = loanPercent == null ? new BigDecimal("0") : loanPercent;

				tblDebtPool.setPoolUseableAmount(
						poolUseableAmount_p.subtract(totalAmount.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));
				// 发票池份数
				BigDecimal debtNum_P = tblDebtPool.getDebtNum() == null ? BigDecimal.ZERO : tblDebtPool.getDebtNum();

				BigDecimal debtNum = (BigDecimal) (debtVO.getTotalNum() == null ? BigDecimal.ZERO : new BigDecimal(debtVO.getTotalNum()));

				tblDebtPool.setDebtNum(debtNum_P.subtract(debtNum));
				// 插入日期
				tblDebtPool.setInsertDate(debtVO.getInpoolDate());

				this.updateRBcpDebtPool(tblDebtPool);
			}
		}

	}

	/**
	 * 入池操作
	 */
	@Override
	@Transactional
	public void updateInpoolInfo(DebtBussInfoVO debtVO, List<BCntBcpInfoVO> contlist) throws ScubeBizException {
		// 融资利率
		BigDecimal loanPercent = null;
		if (contlist == null || contlist.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR),
					RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
		} else {
			loanPercent = contlist.get(0).getLoanPercent();
			List<RBcpDebtPool> list = this.queryDebtPollByMastContno(debtVO.getMastContno(), debtVO.getCustcdSaller());
			if (list != null && list.size() > 0) {
				for (RBcpDebtPool tblDebtPool : list) {

					// 发票池金额
					BigDecimal totalDebtAmount_P = tblDebtPool.getTotalDebtAmount() == null ? new BigDecimal("0") : tblDebtPool.getTotalDebtAmount();
					// 本次发票入池金额
					BigDecimal totalAmount = debtVO.getTotalAmount() == null ? new BigDecimal("0") : debtVO.getTotalAmount();
					tblDebtPool.setTotalDebtAmount(totalDebtAmount_P.add(totalAmount));
					// 池发票余额
					BigDecimal totalDebtRemainAmount_p = tblDebtPool.getTotalDebtRemainAmount() == null ? new BigDecimal("0")
							: tblDebtPool.getTotalDebtRemainAmount();
					tblDebtPool.setTotalDebtRemainAmount(totalDebtRemainAmount_p.add(totalAmount));
					// 池可融资余额
					BigDecimal poolUseableAmount_p = tblDebtPool.getPoolUseableAmount() == null ? new BigDecimal("0")
							: tblDebtPool.getPoolUseableAmount();
					// BigDecimal poolUseableAmount =
					// debtVO.getPoolUseableAmount() == null ? new
					// BigDecimal("0") : debtVO.getPoolUseableAmount();
					loanPercent = loanPercent == null ? new BigDecimal("0") : loanPercent;
					// poolUseableAmount(可融资总余额：发票余额*比率+* 现金余额-融资余额)
					tblDebtPool.setPoolUseableAmount(
							poolUseableAmount_p.add(totalAmount.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));

					// 发票池份数
					int parseInt = Integer.parseInt(tblDebtPool.getDebtNum().toString());
					Integer debtNum_P = new Integer(parseInt) == null ? new Integer("0") : new Integer(parseInt);
					Integer debtNum = debtVO.getTotalNum() == null ? new Integer("0") : debtVO.getTotalNum();

					tblDebtPool.setDebtNum(new BigDecimal(debtNum_P + debtNum));
					// 插入日期
					tblDebtPool.setInsertDate(debtVO.getInsertDate());
					com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool rBcpDebtPool = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool();
					try {
						BeanUtils.copyProperties(tblDebtPool, rBcpDebtPool);
					} catch (BeansException e) {
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_00000),
								RBcpErrorConstant.SCF_REC_BCP_00000);
					}
					rBcpDebtPoolDAO.updateByPrimaryKeySelective(rBcpDebtPool);
				}
			}
		}
	}

	@Override
	public List<RBcpDebtPool> queryDebtPollByMastContno(String mastContno, String custcdSaller) throws ScubeBizException {
		RBcpDebtPoolExample example = new RBcpDebtPoolExample();
		RBcpDebtPoolExample.Criteria cri = example.createCriteria();
		if (StringUtil.isStrNotEmpty(mastContno)) {
			cri.andMastContnoEqualTo(mastContno);
		}
		if (StringUtil.isStrNotEmpty(custcdSaller)) {
			cri.andCustcdSallerEqualTo(custcdSaller);
		}

		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool> listdal = rBcpDebtPoolDAO.selectByExample(example);
		List<RBcpDebtPool> list = new ArrayList<RBcpDebtPool>();
		if (listdal != null && listdal.size() > 0) {
			for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool rBcpDebtPooldal : listdal) {
				RBcpDebtPool bcpDebtPool = new RBcpDebtPool();
				BeanUtils.copyProperties(rBcpDebtPooldal, bcpDebtPool);
				list.add(bcpDebtPool);
			}
		}
		return list;
	}

	/**
	 * 回购、核销更新池的发票总余额和可融资余额
	 * @param debtPool
	 * @param baseInfo
	 * @param amount
	 * @param invokPhase
	 * @author 	mengjiajia
	 * @date 	2017年7月5日下午1:40:28
	 */
	@Override
	public void updatePoolRemainAmount(RBcpDebtPool debtPool, BCntBcpInfoVO baseInfo, String invokPhase)
	{
		RBcpDebtInfoVO debtInfoVO = rbcpdebtinfoservice.findSumRBcpDebtInfoByMastContno(baseInfo.getMastContno(), null);
		this.updateRBcpDebtPoolDebtAmount(debtPool, debtInfoVO, baseInfo.getLoanPercent(), invokPhase);
	}

	/**
	 *
	 * @Description: 根据合同号查询池信息
	 * @author jialei.zhang
	 * @Created 2013-5-14上午10:28:17
	 * @param commonQueryVO
	 * @return
	 * @throws CommonException
	 */
	@Override
	public List<RBcpDebtPool> getInPoolInfo(DebtCommonQryVO commonQueryVO) throws ScubeBizException {
		RBcpDebtPoolExample example = new RBcpDebtPoolExample();
		RBcpDebtPoolExample.Criteria cri = example.createCriteria();
		if (!StringUtil.isEmpty(commonQueryVO.getCustcdBuyer_Q())) { // 买方
			cri.andCustcdBuyerEqualTo(commonQueryVO.getCustcdBuyer_Q());
		} else {
			cri.andCustcdBuyerEqualTo("0");
		}
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno())) { // 主合同号
			cri.andMastContnoEqualTo(commonQueryVO.getMastContno());
		} else {
			cri.andMastContnoEqualTo("0");
		}
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool> listdal = rBcpDebtPoolDAO.selectByExample(example);
		List<RBcpDebtPool> list = new ArrayList<RBcpDebtPool>();
		if (listdal.size() > 0) {
			for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool rBcpDebtPooldal : listdal) {
				RBcpDebtPool bcpDebtPool = new RBcpDebtPool();
				BeanUtils.copyProperties(rBcpDebtPooldal, bcpDebtPool);
				list.add(bcpDebtPool);
			}
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService#
	 * queryInPoolInfoByMastContno(java.lang.String)
	 */
	@Override
	public RBcpDebtPool queryInPoolInfoByMastContno(String mastContno) throws ScubeBizException {
		List<RBcpDebtPool> rBcpDebtPoolList = this.queryDebtPollByMastContno(mastContno, null);
		RBcpDebtPool rBcpDebtPool = null;
		if (null != rBcpDebtPoolList && rBcpDebtPoolList.size() > 0) {
			rBcpDebtPool = rBcpDebtPoolList.get(0);
		}
		return rBcpDebtPool;
	}

	/**
	 * 折让池更新
	 * 
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日下午3:00:03
	 */
	@Override
	public void updateDebtPoolInfo(DebtBussInfoVO debtVO) throws ScubeBizException {
		List<RBcpDebtPool> list = this.queryDebtPollByMastContno(debtVO.getMastContno(), debtVO.getCustcdSaller());
		//池合同项下应收账款金额总值
		RBcpDebtInfoVO debtInfoVO = rbcpdebtinfoservice.findSumRBcpDebtInfoByMastContno(debtVO.getMastContno(), null);
		BigDecimal loanPercent = debtVO.getLoanPercent() == null ? new BigDecimal("0") : debtVO.getLoanPercent();
		if (list != null && list.size() > 0) {
			for (RBcpDebtPool bcpDebtPool : list) {
				this.updateRBcpDebtPoolDebtAmount(bcpDebtPool, debtInfoVO, loanPercent, debtVO.getFlag());
			}
		}
	}

	@Override
	@Transactional
	public void NUpdateOutpoolInfo(List<RBcpDebtInfoVO> list) throws ScubeBizException {
		// 1.数据校验
		if (list == null || list.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_NREC_BCP_00001), RBcpErrorConstant.SCF_NREC_BCP_00001);
		}
		// 2.出池信息准备
		String mastContno = list.get(0).getMastContno();
		if (StringUtils.isEmpty(mastContno)) {
			throw new ScubeBizException("合同号丢失，出池失败！");
		}
		BCntBcpInfoVO debtContVO = bCntBcpInfoService.queryBCntBcpInfoByMastContno(mastContno);
		if (debtContVO == null) {
			throw new ScubeBizException("合同号为 " + mastContno + "合同信息丢失！");
		}
		BigDecimal loanPercent = debtContVO.getLoanPercent();
		BigDecimal totalOutPoolDebtAmount = BigDecimal.ZERO;// 本次出池的单据有效金额总和
		BigDecimal outPoolAmount = BigDecimal.ZERO;// 本次出池单据应收账款总额
		BigDecimal outPoolNum = BigDecimal.ZERO;// 本次出池单据数量
		for (RBcpDebtInfoVO rBcpDebtInfo : list) {
			// 只有为入池状态的单据才能参加出池操作,而且这里的出池操作也是应该是计算应收账款余额，不是单据的有效金额
			if (rBcpDebtInfo.getPoolFlag().equals("1")) {
				totalOutPoolDebtAmount = totalOutPoolDebtAmount.add(rBcpDebtInfo.getBillsAmount());
				outPoolAmount = outPoolAmount.add(rBcpDebtInfo.getRemainingAmount());
				outPoolNum = outPoolNum.add(BigDecimal.ONE);
			}
		}
		// 出池操作
		List<RBcpDebtPool> tblDebtPoolList = this.queryDebtPollByMastContno(mastContno, "");
		if (tblDebtPoolList != null && tblDebtPoolList.size() == 1) {
			RBcpDebtPool tblDebtPool = tblDebtPoolList.get(0);
			// 发票池金额
			BigDecimal totalDebtAmount_P = tblDebtPool.getTotalDebtAmount() == null ? new BigDecimal("0") : tblDebtPool.getTotalDebtAmount();
			// 池发票余额
			BigDecimal totalDebtRemainAmount_p = tblDebtPool.getTotalDebtRemainAmount() == null ? new BigDecimal("0")
					: tblDebtPool.getTotalDebtRemainAmount();
			// 发票池份数
			BigDecimal debtNum_P = tblDebtPool.getDebtNum() == null ? BigDecimal.ZERO : tblDebtPool.getDebtNum();
			// 池可融资余额
			BigDecimal poolUseableAmount_p = tblDebtPool.getPoolUseableAmount() == null ? new BigDecimal("0") : tblDebtPool.getPoolUseableAmount();

			tblDebtPool.setTotalDebtAmount(totalDebtAmount_P.subtract(totalOutPoolDebtAmount));
			tblDebtPool.setTotalDebtRemainAmount(totalDebtRemainAmount_p.subtract(outPoolAmount));
			tblDebtPool.setDebtNum(debtNum_P.subtract(outPoolNum));
			// 最重要的池可融资余额
			loanPercent = loanPercent == null ? new BigDecimal("0") : loanPercent;
			tblDebtPool.setPoolUseableAmount(
					poolUseableAmount_p.subtract(outPoolAmount.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));
			// 插入日期
			tblDebtPool.setInsertDate(ScfDateUtil.formatDate(new Date()));
			try {
				this.updateRBcpDebtPool(tblDebtPool);
			} catch (Exception e) {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_NREC_BCP_00001),
						RBcpErrorConstant.SCF_NREC_BCP_00001);
			}
		}
	}

	@Override
	@Transactional
	public void NUpdateInpoolInfo(List<RBcpDebtInfoVO> list) throws ScubeBizException {
		// 1.数据校验
		if (list == null || list.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_NREC_BCP_00001), RBcpErrorConstant.SCF_NREC_BCP_00001);
		}
		// 2.入池信息准备
		String mastContno = list.get(0).getMastContno();
		if (StringUtils.isEmpty(mastContno)) {
			throw new ScubeBizException("合同号丢失，入池失败！");
		}
		BCntBcpInfoVO debtContVO = bCntBcpInfoService.queryBCntBcpInfoByMastContno(mastContno);
		if (debtContVO == null) {
			throw new ScubeBizException("合同号为 " + mastContno + "合同信息丢失！");
		}
		BigDecimal loanPercent = debtContVO.getLoanPercent();
		BigDecimal totalInPoolDebtAmount = BigDecimal.ZERO;// 本次入池的单据有效金额总和
		BigDecimal inPoolAmount = BigDecimal.ZERO;// 本次入池单据应收账款总额
		BigDecimal inPoolNum = BigDecimal.ZERO;
		for (RBcpDebtInfoVO rBcpDebtInfo : list) {
			// 只有为出池状态的单据才能参加入池操作,而且这里的入池操作也是应该是计算应收账款余额，不是单据的有效金额
			if (rBcpDebtInfo.getPoolFlag().equals("0")) {
				totalInPoolDebtAmount = totalInPoolDebtAmount.add(rBcpDebtInfo.getBillsAmount());
				inPoolAmount = inPoolAmount.add(rBcpDebtInfo.getRemainingAmount());
				inPoolNum = inPoolNum.add(BigDecimal.ONE);
			}
		}
		// 出池操作
		List<RBcpDebtPool> tblDebtPoolList = this.queryDebtPollByMastContno(mastContno, "");
		if (tblDebtPoolList != null && tblDebtPoolList.size() == 1) {
			RBcpDebtPool tblDebtPool = tblDebtPoolList.get(0);
			// 发票池金额
			BigDecimal totalDebtAmount_P = tblDebtPool.getTotalDebtAmount() == null ? new BigDecimal("0") : tblDebtPool.getTotalDebtAmount();
			// 池发票余额
			BigDecimal totalDebtRemainAmount_p = tblDebtPool.getTotalDebtRemainAmount() == null ? new BigDecimal("0")
					: tblDebtPool.getTotalDebtRemainAmount();
			// 发票池份数
			BigDecimal debtNum_P = tblDebtPool.getDebtNum() == null ? BigDecimal.ZERO : tblDebtPool.getDebtNum();
			// 池可融资余额
			BigDecimal poolUseableAmount_p = tblDebtPool.getPoolUseableAmount() == null ? new BigDecimal("0") : tblDebtPool.getPoolUseableAmount();

			tblDebtPool.setTotalDebtAmount(totalDebtAmount_P.add(totalInPoolDebtAmount));
			tblDebtPool.setTotalDebtRemainAmount(totalDebtRemainAmount_p.add(inPoolAmount));
			tblDebtPool.setDebtNum(debtNum_P.add(inPoolNum));
			// 最重要的池可融资余额
			loanPercent = loanPercent == null ? new BigDecimal("0") : loanPercent;
			tblDebtPool.setPoolUseableAmount(
					poolUseableAmount_p.add(inPoolAmount.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));
			// 插入日期
			tblDebtPool.setInsertDate(ScfDateUtil.formatDate(new Date()));
			try {
				this.updateRBcpDebtPool(tblDebtPool);
			} catch (Exception e) {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_NREC_BCP_00002),
						RBcpErrorConstant.SCF_NREC_BCP_00002);
			}
		}

	}

	
	/**
	 * 减值、反转让、核销后对池信息更新
	 * @param bcpDebtPool
	 * @param debtInfoVO
	 * @param loanPercent
	 * @param invokPhase
	 * @author 	mengjiajia
	 * @date 	2017年7月5日下午1:37:40
	 */
	@Override
	public void updateRBcpDebtPoolDebtAmount(RBcpDebtPool bcpDebtPool,RBcpDebtInfoVO debtInfoVO,BigDecimal loanPercent,String invokPhase)
	{
		BigDecimal debtNum = BigDecimal.ZERO;
		BigDecimal totalDebtAmount = BigDecimal.ZERO;
		BigDecimal totalDebtRemainAmount = BigDecimal.ZERO;
		BigDecimal poolUseableAmount = BigDecimal.ZERO;//可融资余额
		BigDecimal poolRemainingAmount = bcpDebtPool.getPoolRemainingAmount();//已融资总金额
		if(debtInfoVO!=null)
		{
			BigDecimal billsAmount = StringUtil.isEmpty(debtInfoVO.getBillsAmount())?BigDecimal.ZERO:debtInfoVO.getBillsAmount();//有效金额总金额
			BigDecimal remainingAmount = StringUtil.isEmpty(debtInfoVO.getRemainingAmount())?BigDecimal.ZERO:debtInfoVO.getRemainingAmount();//应收账款余额总金额
			BigDecimal count = debtInfoVO.getDebtNum();//应收账款总数
			debtNum = debtNum.add(count);
			totalDebtAmount = totalDebtAmount.add(billsAmount);
			totalDebtRemainAmount = totalDebtRemainAmount.add(remainingAmount);
			//可融资总余额：应收账款余额*融资比率+现金余额-已融资金额
			poolUseableAmount = totalDebtRemainAmount.multiply(loanPercent).
					divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)
					.subtract(poolRemainingAmount);
		}
		if (poolUseableAmount.compareTo(new BigDecimal("0")) < 0) {
//			if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_BACK_TRANSFER))
//			{
//				throw new ScubeBizException("本次回购后客户融资池出现溢拨" + poolUseableAmount.toString() + "，" + "提示客户需发票补入池、融资还款、补充现金余额入池融资内部户!",
//						RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
//			}
//			else if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_CHARGE_OFF))
//			{
//				throw new ScubeBizException("本次核销后客户融资池出现溢拨" + poolUseableAmount.toString() + "，" + "提示客户需发票补入池、融资还款、补充现金余额入池融资内部户!",
//						RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
//			}
//			else if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_IMPAIRMENT))
//			{
//				throw new ScubeBizException("本次折让后客户融资池出现溢拨" + poolUseableAmount.toString() + "，" + "提示客户需发票补入池、融资还款、补充现金余额入池融资内部户!",
//						RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
//			}
//			else if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_REPAYMENT))
//			{
//				throw new ScubeBizException("本次回款后客户融资池出现溢拨" + poolUseableAmount.toString() + "，" + "提示客户需发票补入池、融资还款、补充现金余额入池融资内部户!",
//						RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
//			}
//			else if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_DISPUTE_REGISTER))
//			{
//				throw new ScubeBizException("本次商纠登记后客户融资池出现溢拨" + poolUseableAmount.toString() + "，" + "提示客户需发票补入池、融资还款、补充现金余额入池融资内部户!",
//						RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
//			}
//			else if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_OUT_POOL))
//			{
//				throw new ScubeBizException("本次出池后客户融资池出现溢拨" + poolUseableAmount.toString() + "，" + "提示客户需发票补入池、融资还款、补充现金余额入池融资内部户!",
//						RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
//			}
//			else
//			{
//				throw new ScubeBizException("本次操作后客户融资池出现溢拨" + poolUseableAmount.toString() + "，" + "提示客户需发票补入池、融资还款、补充现金余额入池融资内部户!",
//						RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
//			}
			poolUseableAmount = BigDecimal.ZERO;
		}
		bcpDebtPool.setDebtNum(debtNum);// 入池的单据数量
		bcpDebtPool.setTotalDebtAmount(totalDebtAmount);// 入池的单据有效金额总和
		bcpDebtPool.setTotalDebtRemainAmount(totalDebtRemainAmount);// 入池的单据的应收账款余额总和
		bcpDebtPool.setPoolUseableAmount(poolUseableAmount);
		this.updateRBcpDebtPool(bcpDebtPool);
	}

	/**
	 * 出池/入池池信息修改
	 */
	@Override
	@Transactional
	public void NUpdatePoolInfoByMastContno(String mastContno, BigDecimal money, String flag) throws ScubeBizException {
		if (StringUtils.isEmpty(mastContno)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_00002), RBcpErrorConstant.SCF_REC_BCP_00002);
		}
		//池合同项下应收账款金额总值
		RBcpDebtInfoVO debtInfoVO = rbcpdebtinfoservice.findSumRBcpDebtInfoByMastContno(mastContno, null);
		// 1.找到对应池信息
		RBcpDebtPoolExample example = new RBcpDebtPoolExample();
		RBcpDebtPoolExample.Criteria cri = example.createCriteria();
		cri.andMastContnoEqualTo(mastContno);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool> listdal = rBcpDebtPoolDAO.selectByExample(example);
		if (listdal != null && listdal.size() == 1) {
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool rBcpDebtPool = listdal.get(0);
			// 2.找到对应的入池的单据
			BigDecimal debtNum = BigDecimal.ZERO;
			BigDecimal totalDebtAmount = BigDecimal.ZERO;
			BigDecimal totalDebtRemainAmount = BigDecimal.ZERO;
			if(debtInfoVO!=null)
			{
				BigDecimal billsAmount = debtInfoVO.getBillsAmount();
				BigDecimal remainingAmount = debtInfoVO.getRemainingAmount();
				BigDecimal count = debtInfoVO.getDebtNum();
				debtNum = debtNum.add(count);
				totalDebtAmount = totalDebtAmount.add(billsAmount);
				totalDebtRemainAmount = totalDebtRemainAmount.add(remainingAmount);
			}
			BCntBcpInfoVO debtContVO = bCntBcpInfoService.queryBCntBcpInfoByMastContno(mastContno);
			if (debtContVO == null) {
				throw new ScubeBizException("合同号为 " + mastContno + "合同信息丢失！");
			}
			rBcpDebtPool.setDebtNum(debtNum);// 入池的单据数量
			rBcpDebtPool.setTotalDebtAmount(totalDebtAmount);// 入池的单据有效金额总和
			rBcpDebtPool.setTotalDebtRemainAmount(totalDebtRemainAmount);// 入池的单据的应收账款余额总和
			//池可融资余额计算
			BigDecimal loanPercent=debtContVO.getLoanPercent() == null ? BigDecimal.ZERO:debtContVO.getLoanPercent();
			BigDecimal poolUseableAmount = rBcpDebtPool.getPoolUseableAmount();
			BigDecimal divide = money.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
			if(flag.equals(RBcpDebtConstant.APPLY_TYPE_IN_POOL)){//入池
				poolUseableAmount=poolUseableAmount.add(divide);
			}else if(flag.equals(RBcpDebtConstant.APPLY_TYPE_OUT_POOL)){//出池
				poolUseableAmount=poolUseableAmount.subtract(divide);
			}
			rBcpDebtPool.setPoolUseableAmount(poolUseableAmount);
			rBcpDebtPoolDAO.updateByPrimaryKeySelective(rBcpDebtPool);
		
		}
	}
	
	/**
	 * 根据appNo及调用阶段获取池信息提示
	 * @param appNo
	 * @param invokPhase
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月18日下午3:05:19
	 */
	@Override
	public String getPoolMessage(String appNo, String invokPhase)
	{
		String message = "";
		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appNo);
		if(appliBaseInfo==null)
		{
			return message;
		}
		String mastContno = appliBaseInfo.getMastContno();
		if(StringUtil.isEmpty(mastContno))
		{
			return message;
		}
		BCntBcpInfoVO baseInfo = bCntBcpInfoService.queryOnlyBCntBcpInfoByMastContno(mastContno);
		if(baseInfo==null)
		{
			return message;
		}
		if(DebtConstants.FINANCING_TYPE_POOL.equals(baseInfo.getFinancingType()))
		{//是池融资
			//获取未锁定的，非本次业务申请的应收账款金额信息
			RBcpDebtInfoVO debtInfoVOUnlock = rbcpdebtinfoservice.findSumRBcpDebtInfoByMastContno(mastContno,appNo);
			//获取已锁定并不在本次业务中的应收账款金额信息
			RBcpDebtInfoVO debtInfoVOLock = rbcpdebtinfoservice.findOtherSumRBcpDebtInfoByMastContno(mastContno,appNo);
			List<RBcpDebtPool> tblDebtPoolList = this.queryDebtPollByMastContno(mastContno, null);
			RBcpDebtPool debtPool = new RBcpDebtPool(); 
			if (tblDebtPoolList != null && tblDebtPoolList.size() == 1)
			{
				debtPool = tblDebtPoolList.get(0);
				BigDecimal totalDebtRemainAmount = BigDecimal.ZERO;
				BigDecimal poolUseableAmount = BigDecimal.ZERO;//可融资余额
				BigDecimal poolRemainingAmount = debtPool.getPoolRemainingAmount();//已融资总金额
				if(debtInfoVOUnlock!=null)
				{
					BigDecimal remainingAmount = StringUtil.isEmpty(debtInfoVOUnlock.getRemainingAmount())?BigDecimal.ZERO:debtInfoVOUnlock.getRemainingAmount();//应收账款余额总金额
					totalDebtRemainAmount = totalDebtRemainAmount.add(remainingAmount);
				}
				if(debtInfoVOLock!=null)
				{
					BigDecimal remainingAmount = StringUtil.isEmpty(debtInfoVOLock.getRemainingAmount())?BigDecimal.ZERO:debtInfoVOLock.getRemainingAmount();//预估应收账款余额总金额
					BigDecimal loanAmount = StringUtil.isEmpty(debtInfoVOLock.getLoanAmount())?BigDecimal.ZERO:debtInfoVOLock.getLoanAmount();//预估融资金额
					totalDebtRemainAmount = totalDebtRemainAmount.add(remainingAmount);
					poolRemainingAmount = poolRemainingAmount.add(loanAmount);
					
				}
				//可融资总余额：应收账款余额*融资比率+现金余额-已融资金额
				poolUseableAmount = totalDebtRemainAmount.multiply(baseInfo.getLoanPercent()).
						divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)
						.subtract(poolRemainingAmount);
				if (poolUseableAmount.compareTo(new BigDecimal("0")) < 0) {
					if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_BACK_TRANSFER))
					{
						message = "回购";
					}
					else if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_CHARGE_OFF))
					{
						message = "核销";
					}
					else if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_IMPAIRMENT))
					{
						message = "折让";
					}
					else if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_REPAYMENT))
					{
						message = "回款";
					}
					else if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_DISPUTE_REGISTER))
					{
						message = "商纠登记";
					}
					else if(invokPhase.equals(ScfBasConstant.INVOKE_PHASE_OUT_POOL))
					{
						message = "出池";
					}
					else
					{
						message = "操作";
					}
					String amountMessage = poolUseableAmount.toString();
					amountMessage =  amountMessage.substring(1);
					message = "本次"+message+"后客户融资池出现风险敞口"+ amountMessage + ",提示客户需发票补入池、融资还款、补充现金余额入池融资内部户!";
				}
			}
		}
		else
		{
			message = "1";
		}
		return message;
	}
}
