/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtPoolDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPoolExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.FactoringContVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
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
@Service("RBcpDebtPoolServiceImpl")
public class RBcpDebtPoolServiceImpl implements IRBcpDebtPoolService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "RBcpDebtPoolDAO")
	IRBcpDebtPoolDAO rBcpDebtPoolDAO;

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

				BigDecimal debtNum = (BigDecimal) (debtVO.getTotalNum() == null ? BigDecimal.ZERO : debtVO.getTotalNum());

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
	public void updateInpoolInfo(DebtBussInfoVO debtVO, List contlist) throws ScubeBizException {
		// 融资利率
		BigDecimal loanPercent = null;
		if (contlist == null || "".equals(contlist)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR),
					RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
		} else {
			for (int i = 0; i < contlist.size(); i++) {
				FactoringContVO vo = new FactoringContVO();
				BeanUtils.copyProperties(contlist.get(i), vo);
				loanPercent = vo.getLoanPercent();
			}
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
					BigDecimal poolUseableAmount = debtVO.getPoolUseableAmount() == null ? new BigDecimal("0") : debtVO.getPoolUseableAmount();
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
		if (listdal.size() > 0) {
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
	 * 
	 * @author zhoujun.hou
	 * @date 2012-01-06 编辑 updatePoolRemainAmount 方法的文档注释
	 * @param debtPool
	 * @param amount
	 */
	@Override
	public void updatePoolRemainAmount(RBcpDebtPool debtPool, BCntDebtInfo baseInfo, BigDecimal amount) {
		BigDecimal totalDebtRemainAmount = debtPool.getTotalDebtRemainAmount() == null ? new BigDecimal("0") : debtPool.getTotalDebtRemainAmount();
		BigDecimal loanPercent = baseInfo.getLoanPercent() == null ? new BigDecimal("0") : baseInfo.getLoanPercent();
		BigDecimal poolUseableAmount = debtPool.getPoolUseableAmount() == null ? new BigDecimal("0") : debtPool.getPoolUseableAmount();
		debtPool.setPoolUseableAmount(
				poolUseableAmount.subtract(amount.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));// 可融资余额
		debtPool.setTotalDebtRemainAmount(totalDebtRemainAmount.subtract(amount));// 池发票总余额
		this.updateRBcpDebtPool(debtPool);
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

		List<RBcpDebtPool> rBcpDebtPoolList = queryDebtPollByMastContno(mastContno, null);
		RBcpDebtPool rBcpDebtPool = null;
		if (null != rBcpDebtPoolList && rBcpDebtPoolList.size() > 0) {
			rBcpDebtPool = rBcpDebtPoolList.get(0);
		}
		return rBcpDebtPool;
	}

	@Override
	public RBcpDebtPool findRBcpDebtPoolByMastContno(String mastContno) throws ScubeBizException {
		if (StringUtils.isEmpty(mastContno)) {
			return null;
		}
		RBcpDebtPoolExample rBcpDebtPoolExample = new RBcpDebtPoolExample();
		RBcpDebtPoolExample.Criteria createCriteria = rBcpDebtPoolExample.createCriteria();
		createCriteria.andMastContnoEqualTo(mastContno);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool> rBcpDebtPoolList = rBcpDebtPoolDAO.selectByExample(rBcpDebtPoolExample);
		RBcpDebtPool rBcpDebtPool = new RBcpDebtPool();
		if (rBcpDebtPoolList != null && rBcpDebtPoolList.size() > 0) {
			BeanUtils.copyProperties(rBcpDebtPoolList.get(0), rBcpDebtPool);
			return rBcpDebtPool;
		} else {
			return null;
		}
	}

}
