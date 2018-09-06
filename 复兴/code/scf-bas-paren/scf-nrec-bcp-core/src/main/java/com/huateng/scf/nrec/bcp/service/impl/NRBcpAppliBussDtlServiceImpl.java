/**
 * 
 */
package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.sys.dao.IBSysAcctBctlDAO;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfoExample;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年5月24日上午10:41:44
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月24日上午10:41:44	     新增
 *
 *            </pre>
 */

@ScubeService
@Service("NRBcpAppliBussDtlServiceImpl")
public class NRBcpAppliBussDtlServiceImpl implements INRBcpAppliBussDtlService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	// 费用网点转译
	@Resource(name = "IBSysAcctBctlDAO")
	IBSysAcctBctlDAO iBSysAcctBctlDAO;

	// 应收类申请明细信息
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;

	// 应收账款基本信息
	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rbcpdebtinfodao;

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rbcpdebtinfoservice;

	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;

	@Override
	public Page findBcpAppliBussDtlByAppno(int pageNo, int pageSize, String appno) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			return null;
		}
		Page page = new Page(pageSize, pageNo, 0);
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria cri = rBcpAppliBussDtlExample.createCriteria();
		cri.andAppnoEqualTo(appno);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO.selectByPage(rBcpAppliBussDtlExample,
				page);
		ArrayList<RBcpAppliBussDtl> arrayList = new ArrayList<com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl>();
		if (rBcpAppliBussDtlList != null && rBcpAppliBussDtlList.size() > 0) {
			for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl : rBcpAppliBussDtlList) {
				RBcpAppliBussDtl rBcpAppliBussDtl2 = new RBcpAppliBussDtl();
				BeanUtils.copyProperties(rBcpAppliBussDtl, rBcpAppliBussDtl2);
				RBcpDebtInfoVO rBcpDebtInfoVO = rbcpdebtinfoservice.queryRBcpDebtInfoById(rBcpAppliBussDtl2.getDebtId());
				if (rBcpDebtInfoVO != null) {
					rBcpAppliBussDtl2.setDeadline(rBcpDebtInfoVO.getDeadline());
				} else {// 用于应收类转让时，将最迟付款日存储于UnpledgeActiveDate字段,宽限期存储于badRason
					rBcpAppliBussDtl2.setDeadline(rBcpAppliBussDtl2.getUnpledgeActiveDate());
					rBcpAppliBussDtl2.setGracePeriod(new BigDecimal(rBcpAppliBussDtl2.getBadReason()));
				}
				arrayList.add(rBcpAppliBussDtl2);
			}
		}
		page.setRecords(arrayList);
		return page;
	}

	// 新增对应的申请明细信息，锁定对应的单据信息
	@Override
	@Transactional
	public void addRBcpAppliBussDtlAndLockedDebt(String appno, List<RBcpAppliBussDtl> ds) throws ScubeBizException {
		if (StringUtils.isEmpty(appno) || ds == null || ds.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		for (RBcpAppliBussDtl rBcpAppliBussDtl : ds) {// 遍历新增应收账款转让的明细信息。
			String debtId = "";
			if (StringUtils.isEmpty(rBcpAppliBussDtl.getAppno())) {
				debtId = rBcpAppliBussDtl.getId();
			} else {
				debtId = rBcpAppliBussDtl.getDebtId();
			}
			// 新增的时候传过来的明细信息数据的ID就是RBcpDebtBaseInfo的ID
			RBcpDebtInfo rBcpDebtBaseInfo1 = rbcpdebtinfodao.selectByPrimaryKey(debtId);
			if (rBcpDebtBaseInfo1 != null) {
				// 防止在选择数据到确定保存的过程中，对应的单据信息被其他人锁定，所以这里要验证下。
				if (rBcpDebtBaseInfo1.getIsLocked().equals(RBcpDebtConstant.IS_LOCKED_TRUE)) {
					throw new ScubeBizException("凭证编号为" + rBcpDebtBaseInfo1.getBillsNo() + "的凭证信息已经被锁定，无法使用！");
				}
				rBcpDebtBaseInfo1.setIsLocked(RBcpDebtConstant.IS_LOCKED_TRUE);// 设置对应的票据为锁定状态。
				rBcpDebtBaseInfo1.setLockAppno(appno);// 设置对应的锁定的申请号
				rbcpdebtinfodao.updateByPrimaryKey(rBcpDebtBaseInfo1);
			} else {// SCF_REC_BCP_10025 ,锁定应收账款基本信息失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10025),
						RBcpErrorConstant.SCF_REC_BCP_10025);
			}
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			ScfCommonUtil.setCommonField(rBcpAppliBussDtl);// 设置公共字段
			BeanUtils.copyProperties(rBcpAppliBussDtl, rBcpAppliBussDtl2);
			rBcpAppliBussDtl2.setAppno(appno);// 申请号
			rBcpAppliBussDtl2.setInsertDate(insertDate);// 登记时间
			rBcpAppliBussDtl2.setId(UUIDGeneratorUtil.generate());// id
			rBcpAppliBussDtl2.setDebtId(debtId);// 对应的应收账款基本信息的ID
			rBcpAppliBussDtl2.setBillsDate(rBcpDebtBaseInfo1.getBillsDate());// 应收账款日期（从应收账款基本信息表中查出来的）
			rBcpAppliBussDtl2.setDebtEnd(rBcpDebtBaseInfo1.getDebtEnd());// 应收账款到期日
			// rBcpAppliBussDtl2.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);//
			// 申请状态为录入00
			rBcpAppliBussDtl2.setBrcode(brcode);// 设置经办机构信息
			rBcpAppliBussDtl2.setTlrcd(tlrcd);
			try {
				rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl2);
			} catch (Exception e) {// SCF_REC_BCP_10027
									// 新增应收账款业务历程明细信息失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10027),
						RBcpErrorConstant.SCF_REC_BCP_10027);
			}
		}
	}

	@Override
	@Transactional
	public void deleteRBcpAppliBussDtlAndReleaseDebt(String appno) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria cre = rBcpAppliBussDtlExample.createCriteria();
		cre.andAppnoEqualTo(appno);
		rBcpAppliBussDtlDAO.deleteByExample(rBcpAppliBussDtlExample);
		RBcpDebtInfoExample rBcpDebtInfoExample = new RBcpDebtInfoExample();
		RBcpDebtInfoExample.Criteria createCriteria = rBcpDebtInfoExample.createCriteria();
		createCriteria.andLockAppnoEqualTo(appno);
		List<RBcpDebtInfo> rBcpDebtInfoList = rbcpdebtinfodao.selectByExample(rBcpDebtInfoExample);
		if (rBcpDebtInfoList != null && rBcpDebtInfoList.size() > 0) {
			for (RBcpDebtInfo rBcpDebtInfo : rBcpDebtInfoList) {
				rBcpDebtInfo.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);
				rBcpDebtInfo.setLockAppno(null);
				rbcpdebtinfodao.updateByPrimaryKey(rBcpDebtInfo);
			}
		}
		return;
	}

	/**
	 * 应收 保存前先清掉APPNO查询到记录
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日上午9:59:44
	 */
	@Transactional
	@Override
	public void appliBussDetailUpdate(String appno) throws ScubeBizException {
		log.debug("更新明细信息======================");
		List<RBcpAppliBussDtl> list = this.queryRBcpAppliBussDtlByAppno(appno);
		if (list != null && list.size() > 0) {
			for (RBcpAppliBussDtl rBcpAppliBussDtl : list) {
				com.huateng.scf.rec.bcp.model.AppliBussDetailVO applyVO = new com.huateng.scf.rec.bcp.model.AppliBussDetailVO();
				BeanUtils.copyProperties(rBcpAppliBussDtl, applyVO);
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl tblAppliBussDetail = rBcpAppliBussDtlDAO.selectByPrimaryKey(applyVO.getId());
				if (StringUtils.isNotEmpty(tblAppliBussDetail.getDebtId())) {
					// 解锁
					rbcpdebtinfoservice.releaseDebtBaseInfo(tblAppliBussDetail.getDebtId());
				}
				rBcpAppliBussDtlDAO.deleteByPrimaryKey(tblAppliBussDetail.getId());
			}
		}
		RBcpAppliBussDtlExample example = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		// 查找原有记录
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> dtlinfo = rBcpAppliBussDtlDAO.selectByAppno(appno);
		List<String> debtIds = new ArrayList<String>();
		for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl dtl : dtlinfo) {
			debtIds.add(dtl.getDebtId());
		}
		// 修改记录来源状态
		RBcpDebtInfoExample example2 = new RBcpDebtInfoExample();
		RBcpDebtInfoExample.Criteria crri = example2.createCriteria();
		if (debtIds.size() > 0) {
			// 解锁
			crri.andIdIn(debtIds);
			RBcpDebtInfo record = new RBcpDebtInfo();
			record.setIsLocked("0");
			rbcpdebtinfodao.updateByExampleSelective(record, example2);
			// 删除原有记录
			rBcpAppliBussDtlDAO.deleteByExample(example);
		}
	}

	/**
	 * 根据appno与业务品种获取明细信息
	 * 
	 * @param appno
	 * @param bussType
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月24日上午10:06:26
	 */
	@Override
	public List<RBcpAppliBussDtl> queryAppliBussDetailByAppno(String appno, String bussType) {
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> list = rBcpAppliBussDtlDAO.queryAppliBussDetailByAppno(appno, bussType);
		List<RBcpAppliBussDtl> listDal = new ArrayList<RBcpAppliBussDtl>();
		for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtlDal : list) {
			RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
			BeanUtils.copyProperties(rBcpAppliBussDtlDal, rBcpAppliBussDtl);
			RBcpDebtInfo bcpDebtInfo = rbcpdebtinfodao.selectByPrimaryKey(rBcpAppliBussDtl.getDebtId());
			if (bcpDebtInfo != null) {
				rBcpAppliBussDtl.setDeadline(bcpDebtInfo.getDeadline());
			}
			listDal.add(rBcpAppliBussDtl);
		}
		return listDal;
	}

	/**
	 * 保存明细信息
	 * 
	 * @param appliBussDtl
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日上午10:10:22
	 */
	@Override
	public void save(RBcpAppliBussDtl appliBussDtl) throws ScubeBizException {
		if (StringUtil.isEmpty(appliBussDtl.getId())) {
			appliBussDtl.setId(UUIDGeneratorUtil.generate());
		}
		appliBussDtl.setInsertDate(ScfDateUtil.formatDate(new Date()));
		appliBussDtl.setLastUpdTime(new Date());
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl bussDtl = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
		BeanUtils.copyProperties(appliBussDtl, bussDtl);
		rBcpAppliBussDtlDAO.insertSelective(bussDtl);
	}

	@Override
	@Transactional
	public void deleteBcpAppliBussDtlByAppno(String appno) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			throw new ScubeBizException("应收类申请明细信息删除失败！");
		}
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria cri = rBcpAppliBussDtlExample.createCriteria();
		cri.andAppnoEqualTo(appno);
		rBcpAppliBussDtlDAO.deleteByExample(rBcpAppliBussDtlExample);
		return;
	}

	// 转让时使用的需要查重对应的单据信息
	@Override
	@Transactional
	public void addRBcpAppliBussDtlForTransfer(String appno, List<RBcpAppliBussDtl> ds) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10027), RBcpErrorConstant.SCF_REC_BCP_10027);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		for (RBcpAppliBussDtl rBcpAppliBussDtl : ds) {
			// 需要先查重
			RBcpDebtInfoVO debtInfoVO = new com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO();
			debtInfoVO.setBillsNo(rBcpAppliBussDtl.getBillsNo());
			debtInfoVO.setCustcdSaller(rBcpAppliBussDtl.getCustcdSaller());
			debtInfoVO.setCustcdBuyer(rBcpAppliBussDtl.getCustcdBuyer());
			debtInfoVO.setMastContno(rBcpAppliBussDtl.getMastContno());
			RBcpDebtInfoVO debtInfoVO2 = rbcpdebtinfoservice.findRBcpDebtInfoByKey(debtInfoVO);
			if (debtInfoVO2 != null) {// 去重！
				throw new ScubeBizException("凭证编号为" + debtInfoVO2.getBillsNo() + "的单据信息已存在，请重新填写凭证信息！");
			}
			// 再新增
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			ScfCommonUtil.setCommonField(rBcpAppliBussDtl);// 设置公共字段
			BeanUtils.copyProperties(rBcpAppliBussDtl, rBcpAppliBussDtl2);
			rBcpAppliBussDtl2.setBadReason(rBcpAppliBussDtl.getGracePeriod().toString());// 存储宽限期
			rBcpAppliBussDtl2.setUnpledgeActiveDate(rBcpAppliBussDtl2.getDeadline());// 存储最迟付款日
			rBcpAppliBussDtl2.setAppno(appno);// 申请号
			rBcpAppliBussDtl2.setInsertDate(insertDate);// 登记时间
			rBcpAppliBussDtl2.setId(UUIDGeneratorUtil.generate());// id
			rBcpAppliBussDtl2.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入00
			rBcpAppliBussDtl2.setBrcode(brcode);// 设置经办机构信息
			rBcpAppliBussDtl2.setTlrcd(tlrcd);
			try {
				rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl2);
			} catch (Exception e) {
				log.debug(e.getMessage());
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10027),
						RBcpErrorConstant.SCF_REC_BCP_10027);
			}
		}
	}

	/**
	 * 保存催收管理申请流程发票信息
	 * 
	 * @param billList
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月31日上午10:31:24
	 */
	@Transactional
	@Override
	public void saveDebtPressingBussDetails(List<NDebtBillsInfoVO> billList, String appno) throws ScubeBizException {
		NDebtBillsInfoVO debtVo = null;

		// 保存前先清掉APPNO查询到记录
		this.appliBussDetailUpdate(appno);
		if (billList != null) {
			Iterator<NDebtBillsInfoVO> iter = billList.iterator();
			while (iter.hasNext()) {
				debtVo = iter.next();
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
				BeanUtils.copyProperties(debtVo, rBcpAppliBussDtl);
				rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
				rBcpAppliBussDtl.setAppno(appno);
				rBcpAppliBussDtl.setDebtId(debtVo.getId());
				rBcpAppliBussDtl.setWarnCount(debtVo.getWarnCount());// 提示次数
				rBcpAppliBussDtl.setPressCount(debtVo.getPressCount());// 催收次数
				rBcpAppliBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_COLLECTION);
				try {
					rBcpAppliBussDtlDAO.insertSelective(rBcpAppliBussDtl);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("应收账款业务申请流水流水明细插入异常！");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10021),
							RBcpErrorConstant.SCF_REC_BCP_10021);
				}
				// tblAppliBussDetailDAO.save(tblAppliBussDetail);
				if (StringUtil.isStrNotEmpty(rBcpAppliBussDtl.getDebtId())) {
					rbcpdebtinfoservice.lockDebtBaseInfo(rBcpAppliBussDtl.getDebtId(), rBcpAppliBussDtl.getAppno());
				}
			}
		}
	}

	/**
	 * 根据appno获取明细信息
	 * 
	 * @param appno
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月31日下午3:17:12
	 */
	@Override
	public List<RBcpAppliBussDtl> queryRBcpAppliBussDtlByAppno(String appno) throws ScubeBizException {
		RBcpAppliBussDtlExample example = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> list = rBcpAppliBussDtlDAO.selectByExample(example);
		List<RBcpAppliBussDtl> listDal = new ArrayList<RBcpAppliBussDtl>();
		for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtlDal : list) {
			RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
			BeanUtils.copyProperties(rBcpAppliBussDtlDal, rBcpAppliBussDtl);
			RBcpDebtInfo bcpDebtInfo = rbcpdebtinfodao.selectByPrimaryKey(rBcpAppliBussDtl.getDebtId());
			if (bcpDebtInfo != null) {
				rBcpAppliBussDtl.setDeadline(bcpDebtInfo.getDeadline());
				rBcpAppliBussDtl.setGracePeriod(bcpDebtInfo.getGracePeriod());
			}
			listDal.add(rBcpAppliBussDtl);
		}
		return listDal;
	}

	/**
	 * 应收账款回购/反转让，回购发票信息
	 * 
	 * @param insertList
	 * @param appno
	 * @param debtId
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月1日上午11:03:39
	 */
	@Override
	public void saveDebtBackApplyBussDetail(List<NDebtBillsInfoVO> insertList, String appno, String debtId) throws ScubeBizException {
		// 保存前先清掉APPNO查询到记录
		this.appliBussDetailUpdate(appno);
		for (int i = 0; i < insertList.size(); i++) {
			NDebtBillsInfoVO baseinfo = insertList.get(i);
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			BeanUtils.copyProperties(baseinfo, rBcpAppliBussDtl);// 拷贝信息
			rBcpAppliBussDtl.setAppno(appno);
			rBcpAppliBussDtl.setDebtId(baseinfo.getId());
			rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
			rBcpAppliBussDtlDAO.insertSelective(rBcpAppliBussDtl);// 保存业务申请业务明细表
			// 锁定应收账款单据
			rbcpdebtinfoservice.lockDebtBaseInfo(rBcpAppliBussDtl.getDebtId(), rBcpAppliBussDtl.getAppno());
		}
	}

	/**
	 * 获得业务申请业务明细表
	 * 
	 * @param appno
	 * @param bussType
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月2日下午2:14:17
	 */
	@Override
	public List<AppliBussDetailVO> getTblAppliBussDetail(String appno, String bussType) {
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> list = rBcpAppliBussDtlDAO.queryAppliBussDetailByAppno(appno, bussType);
		List<AppliBussDetailVO> returnList = new ArrayList<AppliBussDetailVO>();
		for (int i = 0; i < list.size(); i++) {
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl vo = (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl) list.get(i);
			AppliBussDetailVO bussdtlVO = new AppliBussDetailVO();
			BeanUtils.copyProperties(vo, bussdtlVO);
			RBcpDebtInfoVO tblDebtBaseInfo = rbcpdebtinfoservice.queryRBcpDebtInfoById(vo.getDebtId());
			bussdtlVO.setBussContcode(tblDebtBaseInfo.getBussContcode());
			bussdtlVO.setDeadline(tblDebtBaseInfo.getDeadline());

			bussdtlVO.setBillsAmountView(tblDebtBaseInfo.getBillsAmountView());
			bussdtlVO.setClaimStatus(tblDebtBaseInfo.getClaimStatus());
			bussdtlVO.setGracePeriod(tblDebtBaseInfo.getGracePeriod());
			if (StringUtils.isNotEmpty(tblDebtBaseInfo.getDebetNo())) {
				com.huateng.scf.bas.lan.dao.model.BLanLnciBase lnciInfo = bLanLnciBaseDAO.selectByPrimaryKey(tblDebtBaseInfo.getDebetNo());
				if (lnciInfo != null) {
					bussdtlVO.setDebetId(lnciInfo.getDebetId());
				}
			}
			returnList.add(bussdtlVO);
		}
		return returnList;
	}

	/**
	 * 添加承购发票 【业务申请业务明细表】
	 * 
	 * @param insertList
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日下午2:12:17
	 */
	@Override
	public void updateAppliBussDetall(List<NDebtBillsInfoVO> insertList, String appno) throws ScubeBizException {
		// 保存前先清掉APPNO查询到记录
		this.appliBussDetailUpdate(appno);
		for (int i = 0; i < insertList.size(); i++) {
			NDebtBillsInfoVO baseinfo = insertList.get(i);
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			BeanUtils.copyProperties(baseinfo, rBcpAppliBussDtl);

			rBcpAppliBussDtl.setAppno(appno);
			rBcpAppliBussDtl.setDebtId(baseinfo.getId());
			rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
			rBcpAppliBussDtlDAO.insertSelective(rBcpAppliBussDtl);
			if (!StringUtil.isEmpty(rBcpAppliBussDtl.getDebtId())) {
				rbcpdebtinfoservice.lockDebtBaseInfo(rBcpAppliBussDtl.getDebtId(), rBcpAppliBussDtl.getAppno());
			}
		}
	}
	//如果有输入查询关键字缺少，则直接返回空值。
	@Override
	public RBcpAppliBussDtl getAppliBussDtilByAppnoAndDebtId(String appno, String debtId) throws ScubeBizException {
		if(StringUtils.isEmpty(appno) || StringUtils.isEmpty(debtId)){
			return null;
		}
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria criteria = rBcpAppliBussDtlExample.createCriteria();
		criteria.andAppnoEqualTo(appno);
		criteria.andDebtIdEqualTo(debtId);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
		if(rBcpAppliBussDtlList != null && rBcpAppliBussDtlList.size() == 1){
			RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
			BeanUtils.copyProperties(rBcpAppliBussDtlList.get(0), rBcpAppliBussDtl);
			return rBcpAppliBussDtl;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据appno与业务品种分页查询明细信息
	 * @param appno
	 * @param bussType
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月20日上午9:25:27
	 */
	@Override
	public Page queryAppliBussDetailByAppnoPage(int pageNo, int pageSize,String appno, String bussType) {
		RBcpAppliBussDtlExample example = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria cri = example.createCriteria();
		if(!StringUtil.isEmpty(appno))
		{
			cri.andAppnoEqualTo(appno);
		}
		if(!StringUtil.isEmpty(bussType))
		{
			cri.andBussTypeEqualTo(bussType);
		}
		int total = rBcpAppliBussDtlDAO.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> list = rBcpAppliBussDtlDAO.selectByPage(example, page);
		List<RBcpAppliBussDtl> listDal = new ArrayList<RBcpAppliBussDtl>();
		for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtlDal : list) {
			RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
			BeanUtils.copyProperties(rBcpAppliBussDtlDal, rBcpAppliBussDtl);
			RBcpDebtInfo bcpDebtInfo = rbcpdebtinfodao.selectByPrimaryKey(rBcpAppliBussDtl.getDebtId());
			if (bcpDebtInfo != null) {
				rBcpAppliBussDtl.setDeadline(bcpDebtInfo.getDeadline());
			}
			listDal.add(rBcpAppliBussDtl);
		}
		page.setRecords(listDal);
		return page;
	}

	@Override
	public List<RBcpAppliBussDtl> queryAppliBussDetailByAppnoForTransfer(String appno) throws ScubeBizException {
		if(StringUtils.isEmpty(appno)){
			return null;
		}
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria criteria = rBcpAppliBussDtlExample.createCriteria();
		criteria.andAppnoEqualTo(appno);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
		List<RBcpAppliBussDtl> listDal = new ArrayList<RBcpAppliBussDtl>();
		for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtlDal : rBcpAppliBussDtlList) {
			RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
			BeanUtils.copyProperties(rBcpAppliBussDtlDal, rBcpAppliBussDtl);
			rBcpAppliBussDtl.setGracePeriod(new BigDecimal(rBcpAppliBussDtlDal.getBadReason()));
			rBcpAppliBussDtl.setDeadline(rBcpAppliBussDtlDal.getUnpledgeActiveDate());
			listDal.add(rBcpAppliBussDtl);
		}
		return listDal;
	}
}
