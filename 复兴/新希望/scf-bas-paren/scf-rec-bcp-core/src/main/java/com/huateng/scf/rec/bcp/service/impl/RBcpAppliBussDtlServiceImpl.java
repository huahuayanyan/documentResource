/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.sys.dao.IBSysAcctBctlDAO;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample.Criteria;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月25日下午2:12:44
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月25日下午2:12:44	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("RBcpAppliBussDtlServiceImpl")
public class RBcpAppliBussDtlServiceImpl implements IRBcpAppliBussDtlService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	// 费用网点转译
	@Resource(name = "IBSysAcctBctlDAO")
	IBSysAcctBctlDAO iBSysAcctBctlDAO;
	// 申请明细信息
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;
	// 应收账款基本信息
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;

	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;

	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;

	// 一旦删除申请明细信息，就要将对应的应收账款基本信息中的对应的数据的状态改为未锁定，并且将锁定的申请号设置为空
	@Override
	@Transactional
	public int deleteRBcpAppliBussDtl(RBcpAppliBussDtl rBcpAppliBussDtl) {
		// 1.页面数据校验
		if (rBcpAppliBussDtl == null || "".equals(rBcpAppliBussDtl)) {
			throw new ScubeBizException("删除应收账款申请明细信息,前台所传数据无效！");
		}
		// 2.如果页面传过来数据有appno，就到数据库删除解锁，没有就直接返回
		if (rBcpAppliBussDtl.getAppno() != null && !"".equals(rBcpAppliBussDtl.getAppno())) {
			// 先找到对应的应收账款基本信息，解锁
			try {
				RBcpDebtBaseInfo rBcpDebtBaseInfo1 = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(rBcpAppliBussDtl.getDebtId());
				if (rBcpDebtBaseInfo1 != null) { // 待办任务这里选择添加的去删除这时候数据库其实是没数据的
					rBcpDebtBaseInfo1.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);// 设置对应的票据为未锁定状态。
					rBcpDebtBaseInfo1.setLockAppno(null);// 设置对应的锁定的申请号为空
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo1);
				}

			} catch (Exception e) {
				log.error(e.getMessage());
				throw new ScubeBizException("删除应收账款申请明细信息,解锁失败");
			}
			// 删除后台对应的明细信息
			try {
				return rBcpAppliBussDtlDAO.deleteByPrimaryKey(rBcpAppliBussDtl.getId());
			} catch (Exception e) {
				throw new ScubeBizException("删除应收账款申请明细信息失败！");
			}

		} else {// 说明页面传过来的数据是刚刚添加的，还未锁定生成对应的明细信息，又决定删除
			return 0;
		}
	}

	@Override
	public Page findRBcpAppliBussDtlPageByPage(int pageNo, int pageSize, RBcpAppliBussDtl rBcpAppliBussDtl) {
		Page p = new Page(pageSize, pageNo, 0);
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria cri = rBcpAppliBussDtlExample.createCriteria();
		if (rBcpAppliBussDtl != null && !"".equals(rBcpAppliBussDtl)) {
			if (rBcpAppliBussDtl.getAppno() != null && !"".equals(rBcpAppliBussDtl.getAppno())) {
				cri.andAppnoEqualTo(rBcpAppliBussDtl.getAppno());
			}
		}
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO.selectByPage(rBcpAppliBussDtlExample,
					p);
			for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl2 : rBcpAppliBussDtlList) {
				if (rBcpAppliBussDtl2.getDebtId() != null && !"".equals(rBcpAppliBussDtl2.getDebtId())) {
					RBcpDebtBaseInfo rBcpDebtBaseInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(rBcpAppliBussDtl2.getDebtId());
					if (rBcpDebtBaseInfo.getDeadline() != null) {
						rBcpAppliBussDtl2.setDeadline(rBcpDebtBaseInfo.getDeadline());
					}
				}
			}
			p.setRecords(rBcpAppliBussDtlList);
			return p;
		} catch (Exception e) {
			throw new ScubeBizException("分页条件查询应收账款申请明细信息失败！");
		}
	}

	@Override
	public RBcpAppliBussDtl findRBcpAppliBussDtl(RBcpAppliBussDtl rBcpAppliBussDtl) {
		if (rBcpAppliBussDtl != null && !"".equals(rBcpAppliBussDtl)) {
			RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
			if (rBcpAppliBussDtl.getAppno() != null && !"".equals(rBcpAppliBussDtl.getAppno())) {
				rBcpAppliBussDtlExample.createCriteria().andAppnoEqualTo(rBcpAppliBussDtl.getAppno());
				List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO
						.selectByExample(rBcpAppliBussDtlExample);
				if (rBcpAppliBussDtlList != null && rBcpAppliBussDtlList.size() > 0) {
					RBcpAppliBussDtl rBcpAppliBussDtl2 = new RBcpAppliBussDtl();
					BeanUtils.copyProperties(rBcpAppliBussDtlList.get(0), rBcpAppliBussDtl2);
					return rBcpAppliBussDtl2;
				} else {
					return null;
				}
			} else {
				throw new ScubeBizException("查询具体应收账款明细信息失败，前台所传数据无效");
			}
		} else {
			throw new ScubeBizException("查询具体应收账款明细信息失败，前台所传数据无效");
		}
	}

	// 查询明细信息集合
	@Override
	public List<RBcpAppliBussDtl> findRBcpAppliBussDtlByAppno(RBcpAppliBussDtl rBcpAppliBussDtl) {
		if (rBcpAppliBussDtl == null || "".equals(rBcpAppliBussDtl)) {
			throw new ScubeBizException("查询具体应收账款明细信息失败，前台所传数据无效");
		}
		if (rBcpAppliBussDtl.getAppno() == null || "".equals(rBcpAppliBussDtl.getAppno())) {
			throw new ScubeBizException("查询具体应收账款明细信息失败，前台所传数据无效");
		}
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		rBcpAppliBussDtlExample.createCriteria().andAppnoEqualTo(rBcpAppliBussDtl.getAppno());
		ArrayList<RBcpAppliBussDtl> arrayList = new ArrayList<RBcpAppliBussDtl>();
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO
					.selectByExample(rBcpAppliBussDtlExample);
			if (rBcpAppliBussDtlList != null && rBcpAppliBussDtlList.size() > 0) {
				for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl1 : rBcpAppliBussDtlList) {
					RBcpAppliBussDtl rBcpAppliBussDtl2 = new RBcpAppliBussDtl();
					BeanUtils.copyProperties(rBcpAppliBussDtl1, rBcpAppliBussDtl2);
					arrayList.add(rBcpAppliBussDtl2);
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new ScubeBizException("根据申请号查询申请明细信息失败！");
		}
		return arrayList;
	}

	@Override
	public Page findBcpAppliBussdtlByPage(int pageNo, int pageSize, RBcpDebtBussDtl rBcpDebtBussDtl) {
		RBcpAppliBussDtlExample example = new RBcpAppliBussDtlExample();
		Criteria cri = example.createCriteria();

		if (rBcpDebtBussDtl != null) {
			if (rBcpDebtBussDtl.getAppno() != null && rBcpDebtBussDtl.getAppno().length() > 0) {
				cri.andAppnoEqualTo(rBcpDebtBussDtl.getAppno());
			}
		}
		example.setOrderByClause("CRT_TIME DESC");

		int total = rBcpAppliBussDtlDAO.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		p.setRecords(rBcpAppliBussDtlDAO.selectByPage(example, p));
		return p;
	}

	/**
	 * @author lihao 根据申请号查询（没有申请号返回空值）
	 */

	@Override
	public Page findBcpAppliBussdtlByPage2(int pageNo, int pageSize, RBcpDebtBussDtl rBcpDebtBussDtl) {
		// 如果传过来的值是空的直接返回空值
		if (rBcpDebtBussDtl == null || "".equals(rBcpDebtBussDtl)) {
			return null;
		}
		if (rBcpDebtBussDtl.getAppno() == null || "".equals(rBcpDebtBussDtl.getAppno())) {// 申请流水号丢失
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_20001), RBcpErrorConstant.SCF_REC_BCP_20001);
		}
		Page p = new Page(pageSize, pageNo, 0);
		RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
		example.createCriteria().andLockAppnoEqualTo(rBcpDebtBussDtl.getAppno());
		example.setOrderByClause("DEADLINE DESC");
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> rBcpAppliBussDtlList = iRBcpDebtBaseInfoDAO.selectByPage(example, p);
			p.setRecords(rBcpAppliBussDtlList);
		} catch (Exception e) {
			log.error("条件分页查询应收账款信息失败!" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009), RBcpErrorConstant.SCF_REC_BCP_10009);
		}

		return p;
	}

	/**
	 * @author liph 根据主键删除记录
	 */
	@Override
	public void delete(String id) {
		if (StringUtil.isEmpty(id)) {
			try {
				rBcpAppliBussDtlDAO.deleteByPrimaryKey(id);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
						BLanErrorConstant.SCF_BAS_LAN_20000);
			}
		}
	}

	/*
	 * 保存信息到应收账款融资业务申请流水明细表 并将应收账款单据信息表锁定
	 * 
	 * @author daq
	 */
	@Override
	public void saveDebtPressingBackToModifyBussDetails(List<DebtBillsInfoVO> billlist, String appno) {

		DebtBillsInfoVO debtVo = new DebtBillsInfoVO();

		// 保存前先清掉APPNO查询到记录
		this.appliBussDetailUpdate(appno);
		if (billlist != null) {
			Iterator iter = billlist.iterator();
			while (iter.hasNext()) {

				debtVo = (com.huateng.scf.rec.bcp.model.DebtBillsInfoVO) iter.next();
				RBcpAppliBussDtl tblAppliBussDetail = new RBcpAppliBussDtl();
				BeanUtils.copyProperties(debtVo, tblAppliBussDetail);
				tblAppliBussDetail.setAppno(appno);

				// uuid 字符 拼音简写 6+ 日期 8+UUID 6
				String uuid = UUIDGeneratorUtil.generate(tblAppliBussDetail);
				tblAppliBussDetail.setId(uuid);
				tblAppliBussDetail.setAppno(appno);
				tblAppliBussDetail.setDebtId(debtVo.getId());
				tblAppliBussDetail.setMoney(debtVo.getMoney());
				tblAppliBussDetail.setBussType(debtVo.getBussType());
				// 设置申请类型为商纠
				tblAppliBussDetail.setApplyType(RBcpDebtConstant.APPLY_TYPE_ISSUE_SET);
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpDebtBussDtlDal = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
				BeanUtils.copyProperties(tblAppliBussDetail, rBcpDebtBussDtlDal);
				rBcpAppliBussDtlDAO.insertSelective(rBcpDebtBussDtlDal);
				if (StringUtils.isNotEmpty(tblAppliBussDetail.getDebtId())) {
					rBcpDebtBaseInfoService.lockDebtBaseInfo(tblAppliBussDetail.getDebtId(), tblAppliBussDetail.getAppno());
				}
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @author daq
	 */
	@Override
	public List<RBcpAppliBussDtl> queryAppliBussDetailByAppno(String appno, String bussType) {
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> list = rBcpAppliBussDtlDAO.queryAppliBussDetailByAppno(appno, bussType);
		List<RBcpAppliBussDtl> listDal = new ArrayList<RBcpAppliBussDtl>();
		for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtlDal : list) {
			RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
			BeanUtils.copyProperties(rBcpAppliBussDtlDal, rBcpAppliBussDtl);
			com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo tblDebtBaseInfo = rBcpDebtBaseInfoService.get(rBcpAppliBussDtl.getDebtId());
			rBcpAppliBussDtl.setDeadline(tblDebtBaseInfo.getDeadline());
			listDal.add(rBcpAppliBussDtl);
		}

		return listDal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @author daq
	 */
	@Override
	public List<String> findBillsBySallerBuyerAndContno(Map<String, Object> parameters) {
		List<String> list = rBcpAppliBussDtlDAO.selectBillsNoBySallerBuyerAndContno(parameters);
		return list;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService#
	 * saveDebtBackApplyBussDetail(java.util.List, java.lang.String,
	 * java.lang.String)
	 */
	/*
	 * @Override public void saveDebtBackApplyBussDetail(List insertList, String
	 * appno, String debtId) throws ScubeBizException { DebtBillsInfoVO debtVo =
	 * null; // //保存前先清掉APPNO查询到记录 this.appliBussDetailUpdate(appno); for (int i
	 * = 0; i < insertList.size(); i++) { debtVo = (DebtBillsInfoVO)
	 * insertList.get(i); com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl
	 * rBcpAppliBussDtl = new
	 * com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
	 * BeanUtils.copyProperties(debtVo,rBcpAppliBussDtl);// 拷贝信息
	 * rBcpAppliBussDtl.setAppno(appno);
	 * rBcpAppliBussDtl.setDebtId(debtVo.getId());
	 * rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
	 * rBcpAppliBussDtlDAO.insertSelective(rBcpAppliBussDtl);//保存业务申请业务明细表
	 * //锁定应收账款单据
	 * rBcpDebtBaseInfoService.lockDebtBaseInfo(rBcpAppliBussDtl.getDebtId(),
	 * rBcpAppliBussDtl.getAppno()); } }
	 */

	/**
	 * 应收 保存前先清掉APPNO查询到记录
	 */
	@Transactional
	@Override
	public void appliBussDetailUpdate(String appno) throws ScubeBizException {
		List<RBcpAppliBussDtl> list = this.queryAppliBussDetailByAppno(appno, "");
		if (list != null && list.size() > 0) {
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				RBcpAppliBussDtl rBcpAppliBussDtl = (RBcpAppliBussDtl) iter.next();
				com.huateng.scf.rec.bcp.model.AppliBussDetailVO applyVO = new com.huateng.scf.rec.bcp.model.AppliBussDetailVO();
				BeanUtils.copyProperties(rBcpAppliBussDtl, applyVO);
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl tblAppliBussDetail = rBcpAppliBussDtlDAO.selectByPrimaryKey(applyVO.getId());
				if (StringUtils.isNotEmpty(tblAppliBussDetail.getDebtId())) {
					// 解锁
					rBcpDebtBaseInfoService.releaseDebtBaseInfo(tblAppliBussDetail.getDebtId());
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
		RBcpDebtBaseInfoExample example2 = new RBcpDebtBaseInfoExample();
		RBcpDebtBaseInfoExample.Criteria crri = example2.createCriteria();
		if (debtIds.size() > 0) {
			// 解锁
			crri.andIdIn(debtIds);
			RBcpDebtBaseInfo record = new RBcpDebtBaseInfo();
			record.setIsLocked("0");
			iRBcpDebtBaseInfoDAO.updateByExampleSelective(record, example2);
			// 删除原有记录
			rBcpAppliBussDtlDAO.deleteByExample(example);
		}
	}

	@Override
	public void saveDebtBackApplyBussDetail(List<com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo> insertList, String appno, String debtId)
			throws ScubeBizException {
		// DebtBillsInfoVO debtVo = null;
		// 保存前先清掉APPNO查询到记录
		appliBussDetailUpdate(appno);
		for (int i = 0; i < insertList.size(); i++) {
			com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo baseinfo = insertList.get(i);
			// debtVo = (DebtBillsInfoVO) insertList.get(i);
			// BeanUtils.copyProperties(baseinfo, debtVo);
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			// BeanUtils.copyProperties(debtVo,rBcpAppliBussDtl);// 拷贝信息
			BeanUtils.copyProperties(baseinfo, rBcpAppliBussDtl);// 拷贝信息
			rBcpAppliBussDtl.setAppno(appno);
			rBcpAppliBussDtl.setDebtId(baseinfo.getId());
			rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
			rBcpAppliBussDtlDAO.insertSelective(rBcpAppliBussDtl);// 保存业务申请业务明细表
			// 锁定应收账款单据
			rBcpDebtBaseInfoService.lockDebtBaseInfo(rBcpAppliBussDtl.getDebtId(), rBcpAppliBussDtl.getAppno());
		}
	}

	/**
	 * 获得业务申请业务明细表
	 */
	@Override
	public List<AppliBussDetailVO> getTblAppliBussDetail(String appno, String bussType) {
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> list = rBcpAppliBussDtlDAO.queryAppliBussDetailByAppno(appno, bussType);
		List<AppliBussDetailVO> returnList = new ArrayList<AppliBussDetailVO>();
		for (int i = 0; i < list.size(); i++) {
			// com.huateng.scf.rec.bcp.model.AppliBussDetailVO vo =
			// (com.huateng.scf.rec.bcp.model.AppliBussDetailVO)list.get(i);

			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl vo = (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl) list.get(i);
			AppliBussDetailVO bussdtlVO = new AppliBussDetailVO();
			BeanUtils.copyProperties(vo, bussdtlVO);
			// TblDebtBaseInfo tblDebtBaseInfo =
			// SCFDAOUtils.getTblDebtBaseInfoDAO().get(vo.getDebtId());
			com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo tblDebtBaseInfo = rBcpDebtBaseInfoService.get(vo.getDebtId());
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
	 * @date 2011-11-19
	 * @param insertList
	 * @param appno
	 * @throws CommonException
	 */
	@Override
	public void updateAppliBussDetall(List<com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo> insertList, String appno) throws ScubeBizException {
		// 保存前先清掉APPNO查询到记录
		appliBussDetailUpdate(appno);
		for (int i = 0; i < insertList.size(); i++) {
			com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo baseinfo = insertList.get(i);
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			BeanUtils.copyProperties(baseinfo, rBcpAppliBussDtl);

			rBcpAppliBussDtl.setAppno(appno);
			// tblAppliBussDetail.setDebetNo(debtVo.getDebtNo());
			rBcpAppliBussDtl.setDebtId(baseinfo.getId());
			rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
			rBcpAppliBussDtlDAO.insertSelective(rBcpAppliBussDtl);
			if (!StringUtil.isEmpty(rBcpAppliBussDtl.getDebtId())) {
				rBcpDebtBaseInfoService.lockDebtBaseInfo(rBcpAppliBussDtl.getDebtId(), rBcpAppliBussDtl.getAppno());
			}
		}
	}

	/**
	 * 添加承购发票 【业务申请业务明细表】
	 * 
	 * @param insertList
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void updateAppliBussDetail(List<DebtBillsInfoVO> insertList, String appno) throws ScubeBizException {
		DebtBillsInfoVO debtVo = null;

		// 保存前先清掉APPNO查询到记录
		this.appliBussDetailUpdate(appno);

		for (int i = 0; i < insertList.size(); i++) {
			debtVo = (DebtBillsInfoVO) insertList.get(i);
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			BeanUtils.copyProperties(debtVo, rBcpAppliBussDtl);

			rBcpAppliBussDtl.setAppno(appno);
			// tblAppliBussDetail.setDebetNo(debtVo.getDebtNo());
			rBcpAppliBussDtl.setDebtId(debtVo.getId());
			rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
			try {
				rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("应收账款业务申请流水流水明细插入异常！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10021),
						RBcpErrorConstant.SCF_REC_BCP_10021);
			}
			if (StringUtil.isStrNotEmpty(rBcpAppliBussDtl.getDebtId())) {
				rBcpDebtBaseInfoService.lockDebtBaseInfo(rBcpAppliBussDtl.getDebtId(), rBcpAppliBussDtl.getAppno());
			}
		}
	}

	/***
	 * 根据appno查询rBcpAppliBussDtl ID返回应收账款的主键即rBcpAppliBussDtl中的debtId
	 */
	@Override
	public Page findRBcpAppliBussDtlPageByAppno(int pageNo, int pageSize, RBcpAppliBussDtl rBcpAppliBussDtl) {
		// TODO Auto-generated method stub
		Page page = new Page(pageSize, pageNo, 0);
		List<AppliBussDetailVO> resultList = new ArrayList<AppliBussDetailVO>();
		List<AppliBussDetailVO> list  = new ArrayList<AppliBussDetailVO>();
		if (null != rBcpAppliBussDtl) {
			String appno = rBcpAppliBussDtl.getAppno();
			if(StringUtil.isStrNotEmpty(appno)){
				list =this.getTblAppliBussDetail(appno, "");	
			}
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					AppliBussDetailVO applVO = (AppliBussDetailVO)list.get(i);
					applVO.setId(applVO.getDebtId());
					com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo debtInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
					if (!StringUtil.isEmpty(applVO.getDebtId())) {
						debtInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(applVO.getDebtId());
					}
					if (debtInfo.getPoolFlag()!=null&&applVO.getPoolFlag()!=null&&!debtInfo.getPoolFlag().equals(applVO.getPoolFlag())) {
						applVO.setPoolFlag(debtInfo.getPoolFlag());
					}
					resultList.add(applVO);// bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
				}
				page.setTotalRecord(list.size());
			}
		}
		page.setRecords(resultList);
		return page;
	}
	
	/**
	 * 现金等价物使用
	 * @param tblAppliBussDetail
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public void save(RBcpAppliBussDtl tblAppliBussDetail) throws ScubeBizException
	{
		if(StringUtil.isEmpty(tblAppliBussDetail.getId())){
			tblAppliBussDetail.setId(UUIDGeneratorUtil.generate());
		}
		tblAppliBussDetail.setInsertDate(ScfDateUtil.formatDate(new Date()));
		tblAppliBussDetail.setLastUpdTime(new Date());
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl appliBussDtl = 
				new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
		BeanUtils.copyProperties(tblAppliBussDetail, appliBussDtl);
		rBcpAppliBussDtlDAO.insertSelective(appliBussDtl);
	}
	
	@Override
	public List<RBcpAppliBussDtl> findByProperty(String appno) {
		RBcpAppliBussDtlExample example = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> listdal = rBcpAppliBussDtlDAO.selectByExample(example);
		List<RBcpAppliBussDtl> list = new ArrayList<RBcpAppliBussDtl>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl appliBussDtl:listdal)
			{
				RBcpAppliBussDtl bcpAppliBussDtl = new RBcpAppliBussDtl();
				try
				{
					BeanUtils.copyProperties(appliBussDtl, bcpAppliBussDtl);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				list.add(bcpAppliBussDtl);
			}
		}
		return list;
	}
	
	@Override
	public void delete(RBcpAppliBussDtl bcpAppliBussDtl) throws ScubeBizException
	{
		RBcpAppliBussDtlExample example = new RBcpAppliBussDtlExample();
		RBcpAppliBussDtlExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(bcpAppliBussDtl.getAppno());
		cri.andIdEqualTo(bcpAppliBussDtl.getId());
		rBcpAppliBussDtlDAO.deleteByExample(example);
	}
}
