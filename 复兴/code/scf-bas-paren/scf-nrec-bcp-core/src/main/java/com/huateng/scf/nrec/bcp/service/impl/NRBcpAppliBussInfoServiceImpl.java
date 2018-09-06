/**
 * 
 */
package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年5月24日上午10:41:56
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月24日上午10:41:56	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("NRBcpAppliBussInfoServiceImpl")
public class NRBcpAppliBussInfoServiceImpl implements INRBcpAppliBussInfoService {

	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rBcpDebtInfoService;

	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nRBcpDebtPoolService;

	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bCntBcpInfoService;

	@Override
	public RBcpAppliBussInfo findBcpAppliBussInfoByAppno(String appno) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			return null;
		}
		RBcpAppliBussInfoExample rBcpAppliBussInfoExample = new RBcpAppliBussInfoExample();
		RBcpAppliBussInfoExample.Criteria cri = rBcpAppliBussInfoExample.createCriteria();
		cri.andAppnoEqualTo(appno);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> rBcpAppliBussInfoList = rBcpAppliBussInfoDAO
				.selectByExample(rBcpAppliBussInfoExample);
		RBcpAppliBussInfo rBcpAppliBussInfo = null;
		if (rBcpAppliBussInfoList != null && rBcpAppliBussInfoList.size() == 1) {
			rBcpAppliBussInfo = new RBcpAppliBussInfo();
			BeanUtils.copyProperties(rBcpAppliBussInfoList.get(0), rBcpAppliBussInfo);
		}
		return rBcpAppliBussInfo;
	}

	/**
	 * 保存
	 * 
	 * @param tblAppliBussInfo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日上午10:39:00
	 */
	@Override
	public void save(RBcpAppliBussInfo rBcpAppliBussInfo) throws ScubeBizException {
		if (StringUtils.isEmpty(rBcpAppliBussInfo.getId())) {
			rBcpAppliBussInfo.setId(UUIDGeneratorUtil.generate());
		}
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo appliBussInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		BeanUtils.copyProperties(rBcpAppliBussInfo, appliBussInfo);
		rBcpAppliBussInfoDAO.insertSelective(appliBussInfo);
	}

	/**
	 * 更新
	 * 
	 * @param tblAppliBussInfo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日上午10:39:10
	 */
	@Override
	public void update(RBcpAppliBussInfo rBcpAppliBussInfo) throws ScubeBizException {
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo appliBussInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		BeanUtils.copyProperties(rBcpAppliBussInfo, appliBussInfo);
		rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(appliBussInfo);
	}

	@Override
	@Transactional
	public void inPool(ArrayList<RBcpAppliBussDtl> rBcpAppliBussDtlList, DebtBussInfoVO debtVO) throws ScubeBizException {
		BigDecimal totalDebtAmount = new BigDecimal("0"); // [池发票总金额]
		BigDecimal totalDebtRemainAmount = new BigDecimal("0"); // TOTAL_DEBT_REMAIN_AMOUNT[池发票总余额]
		BigDecimal poolRemainingAmount = new BigDecimal("0"); // POOL_REMAINING_AMOUNT[池融资余额]
		BigDecimal poolUseableAmount = new BigDecimal("0"); // POOL_USEABLE_AMOUNT[池可融资余额]
		for (RBcpAppliBussDtl rBcpAppliBussDtl : rBcpAppliBussDtlList) {

			BigDecimal billsAmount = rBcpAppliBussDtl.getBillsAmount() == null ? new BigDecimal("0") : rBcpAppliBussDtl.getBillsAmount();
			BigDecimal loanAmount = rBcpAppliBussDtl.getLoanAmount() == null ? new BigDecimal("0") : rBcpAppliBussDtl.getLoanAmount();
			BigDecimal loanRemainingAmount = rBcpAppliBussDtl.getLoanRemainingAmount() == null ? new BigDecimal("0")
					: rBcpAppliBussDtl.getLoanRemainingAmount();
			BigDecimal remainingUseableAmount = rBcpAppliBussDtl.getRemainingUseableAmount() == null ? new BigDecimal("0")
					: rBcpAppliBussDtl.getRemainingUseableAmount();

			// 准备入池属性计算金额
			totalDebtAmount = totalDebtAmount.add(billsAmount);
			totalDebtRemainAmount = totalDebtRemainAmount.add(loanAmount);
			poolRemainingAmount = poolRemainingAmount.add(loanRemainingAmount);
			poolUseableAmount = poolUseableAmount.add(remainingUseableAmount);

		}
		// 查询对应合同信息(关键是取出对应融资比例)
		BCntBcpInfoVO bCntDebtInfo = bCntBcpInfoService.queryBCntBcpInfoByMastContno(debtVO.getMastContno());

		ArrayList<BCntBcpInfoVO> list = new ArrayList<BCntBcpInfoVO>();
		list.add(bCntDebtInfo);
		debtVO.setTotalAmount(totalDebtAmount); // 承购金额
		debtVO.setTotalNum(debtVO.getDebtNum());// 承购票据总数
		String purchaseDate = debtVO.getPurchaseDate();
		debtVO.setInpoolDate(purchaseDate);
		debtVO.setTotalDebtAmount(totalDebtAmount);
		debtVO.setTotalDebtRemainAmount(totalDebtRemainAmount);
		debtVO.setPoolRemainingAmount(poolRemainingAmount);
		debtVO.setPoolUseableAmount(poolUseableAmount);
		nRBcpDebtPoolService.updateInpoolInfo(debtVO, list);
		// 发票入池（解锁对应票据，设置poolFlag为1）
		// rBcpdebtBaseInfoService.invoiceInpoolAddSave(rBcpAppliBussDtlList,
		// debtVO);
		// 流水表修改
		// tblDebtBussInfoDAO.updateInpoolInfo(debtVO,
		// DebtConstants.APPLY_TYPE_IN_POOL);
		// 明细表修改
		// tblDebtBussDetailDAO.updateInpoolInfo(rBcpAppliBussDtlList, debtVO);

	}

	/**
	 * 根据appno删除信息
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月25日上午11:13:53
	 */
	@Override
	@Transactional
	public void deleteByAppno(String appno) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			throw new ScubeBizException("应收类申请业务信息删除失败！");
		}
		RBcpAppliBussInfoExample example = new RBcpAppliBussInfoExample();
		RBcpAppliBussInfoExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		rBcpAppliBussInfoDAO.deleteByExample(example);
	}

	/**
	 * (应收账款业务)保存或新增应业务申请信息表
	 * 
	 * @param debtVO
	 * @author mengjiajia
	 * @date 2017年5月31日上午10:28:10
	 */
	@Transactional
	@Override
	public void saveOrUpdateDebtAppliBussInfo(DebtBussInfoVO debtVO) {
		UserInfo gb = ContextHolder.getUserInfo();
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo tblAppliBussInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> list = rBcpAppliBussInfoDAO.selectAppliBussInfoBillsNo(debtVO.getAppno());// 获取票据
		if (list != null && list.size() > 0) {// 存在票据
			for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo debtVO_ : list) {
				tblAppliBussInfo = rBcpAppliBussInfoDAO.selectByPrimaryKey(debtVO_.getId());
				// TODO老代码 是设置 debtVO.getTotalNum() 查看是否待修改
				tblAppliBussInfo.setDebtNum(debtVO.getTotalNum());// 发票个数
				tblAppliBussInfo.setBillDate(debtVO.getStartDate());// 合同生效日
				tblAppliBussInfo.setBillEndDate(debtVO.getEndDate());// 合同到期日
				tblAppliBussInfo.setTotalDebtAmount(debtVO.getTotalAmount());// 发票余额总额

				tblAppliBussInfo.setTlrcd(gb.getTlrNo());

				tblAppliBussInfo.setBrcode(gb.getBrNo());
				tblAppliBussInfo.setAmount(debtVO.getAmount());// 发票总争议金额
				tblAppliBussInfo.setInsertDate(debtVO.getInsertDate());
				tblAppliBussInfo.setPurchaseDate(debtVO.getInsertDate());// 折让
				tblAppliBussInfo.setAppDate(debtVO.getPurchaseDate()); // 承购日期
				tblAppliBussInfo.setAppDate(debtVO.getAppDate());// 申请日期
				tblAppliBussInfo.setMemo(debtVO.getMemo()); // 备注
				tblAppliBussInfo.setReason(debtVO.getReason());
				// 买方名称
				tblAppliBussInfo.setCustcdBuyer(debtVO.getCustcdBuyer());
				if (StringUtils.isNotBlank(debtVO.getPressMode())) {
					// 催收方式
					tblAppliBussInfo.setReturnType(debtVO.getPressMode());
				}
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfoDal = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
				BeanUtils.copyProperties(tblAppliBussInfo, rBcpAppliBussInfoDal);
				rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(rBcpAppliBussInfoDal);
			}
		} else {
			BeanUtils.copyProperties(debtVO, tblAppliBussInfo);
			if (StringUtils.isEmpty(tblAppliBussInfo.getBussType()) && !StringUtils.isEmpty(debtVO.getProductId())) {
				tblAppliBussInfo.setBussType(debtVO.getProductId());// 业务品种
			}
			tblAppliBussInfo.setDebtNum(debtVO.getTotalNum());// 发票个数
			tblAppliBussInfo.setBillDate(debtVO.getStartDate());// 合同生效日
			tblAppliBussInfo.setBillEndDate(debtVO.getEndDate());// 合同到期日
			tblAppliBussInfo.setTotalDebtAmount(debtVO.getTotalAmount());// 发票余额总额
			tblAppliBussInfo.setAmount(debtVO.getAmount());// 发票总争议金额
			tblAppliBussInfo.setInsertDate(debtVO.getInsertDate());// 争议日期
			tblAppliBussInfo.setTlrcd(gb.getTlrNo());
			tblAppliBussInfo.setBrcode(gb.getBrNo());
			tblAppliBussInfo.setMemo(debtVO.getMemo()); // 备注
			if (StringUtils.isNotBlank(debtVO.getPressMode())) {
				// 催收方式
				tblAppliBussInfo.setReturnType(debtVO.getPressMode());
			}
			tblAppliBussInfo.setId(null);
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfoDal = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
			BeanUtils.copyProperties(tblAppliBussInfo, rBcpAppliBussInfoDal);
			if (StringUtils.isBlank(rBcpAppliBussInfoDal.getId())) {
				rBcpAppliBussInfoDal.setId(UUIDGeneratorUtil.generate(rBcpAppliBussInfoDal));
			}
			rBcpAppliBussInfoDAO.insertSelective(rBcpAppliBussInfoDal);

		}
	}

	/**
	 * 应收账款回购/反转让，发票信息保存
	 * 
	 * @param debtVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月1日上午11:01:09
	 */
	@Transactional
	@SuppressWarnings("rawtypes")
	@Override
	public String saveDebtBackAppliBussInfo(DebtBussInfoVO debtVO) throws ScubeBizException {
		String id = null;
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> list = rBcpAppliBussInfoDAO.selectAppliBussInfoBillsNo(debtVO.getAppno());// 获取票据
		if (list != null && list.size() > 0) {// 存在票据
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo debtVO_ = (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo) iter.next();
				rBcpAppliBussInfo = rBcpAppliBussInfoDAO.selectByPrimaryKey(debtVO_.getId());
				rBcpAppliBussInfo.setDebtNum(debtVO.getTotalNum());// 发票份数
				rBcpAppliBussInfo.setTotalDebtAmount(debtVO.getTotalAmount());// 回购总金额
				rBcpAppliBussInfo.setReason(debtVO.getReason());// 回购原因
				rBcpAppliBussInfo.setOtherReason(debtVO.getOtherReason());// 其他原因
				rBcpAppliBussInfoDAO.updateByPrimaryKey(rBcpAppliBussInfo);
				id = debtVO_.getId();
			}
		} else {
			BeanUtils.copyProperties(debtVO, rBcpAppliBussInfo);// 拷贝信息
			// 拷贝数据信息
			rBcpAppliBussInfo.setBussType(debtVO.getBussType());// 业务品种
			rBcpAppliBussInfo.setBillDate(debtVO.getStartDate());// 合同生效日期
			rBcpAppliBussInfo.setBillEndDate(debtVO.getEndDate());// 合同到期日期
			rBcpAppliBussInfo.setDebtNum(debtVO.getTotalNum());// 发票份数
			rBcpAppliBussInfo.setTotalDebtAmount(debtVO.getTotalAmount());// 回购总金额
			rBcpAppliBussInfo.setReason(debtVO.getReason());// 回购原因
			rBcpAppliBussInfo.setId(UUIDGeneratorUtil.generate());
			rBcpAppliBussInfoDAO.insertSelective(rBcpAppliBussInfo);
			id = rBcpAppliBussInfo.getId();
		}
		return id;
	}
	
	


	/**
	* 
	* @param appno
	* @return
	* @author 	Qinwei
	* @date 	2017年6月2日 下午8:10:25
	*/
	@Override
	public RBcpAppliBussInfo findByAppno(String appno) {

		RBcpAppliBussInfo rBcpAppliBussInfo = new RBcpAppliBussInfo();
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfoDal = rBcpAppliBussInfoDAO.selectByAppno(appno);
		BeanUtils.copyProperties(rBcpAppliBussInfoDal, rBcpAppliBussInfo);
		return rBcpAppliBussInfo;
	}

}
