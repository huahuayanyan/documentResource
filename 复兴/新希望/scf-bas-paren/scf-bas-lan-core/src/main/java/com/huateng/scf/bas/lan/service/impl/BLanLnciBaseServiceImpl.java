/**
 * 
 */
package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CommonQryVO;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.ext.ExtBLanDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample.Criteria;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月14日上午11:21:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月14日上午11:21:55	     新增
 *
 *            </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("BLanLnciBaseServiceImpl")
public class BLanLnciBaseServiceImpl implements IBLanLnciBaseService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;

	@Resource(name = "ExtBLanDAO")
	ExtBLanDAO extblandao;

	private static final String STATE = "state";
	private static final String ISSETTLE = "isSettle";
	private static final String MASTCONTNO = "mastContno";
	private static final String PROTOCOLNO = "protocolNo";
	@Transactional
	@Override
	public void addBLanLnciBase(BLanLnciBase bLanLnciBase) throws ScubeBizException {
		// ScfCommonUtil.setCommonField(bLanLnciBase);//设置公共字段 add by
		// huangshuidan 2016-11-11
		com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBasedal = new com.huateng.scf.bas.lan.dao.model.BLanLnciBase();
		try {
			BeanUtils.copyProperties(bLanLnciBase, bLanLnciBasedal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("借据基本信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10004), BLanErrorConstant.SCF_BAS_LAN_10004);
		}
		// TODO
		try {
			bLanLnciBaseDAO.insertSelective(bLanLnciBasedal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("借据基本信息插入异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10005), BLanErrorConstant.SCF_BAS_LAN_10005);
		}
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

	@Transactional
	@Override
	public int deleteBLanLnciBase(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = bLanLnciBaseDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("借据基本信息更新异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10007), BLanErrorConstant.SCF_BAS_LAN_10007);
		}
		return i;
	}

	@Override
	@Transactional
	public BLanLnciBase findBLanLnciBaseByKey(String key) throws ScubeBizException {
		BLanLnciBase bLanLnciBase = null;
		com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBasedal = new com.huateng.scf.bas.lan.dao.model.BLanLnciBase();
		bLanLnciBasedal = bLanLnciBaseDAO.selectByPrimaryKey(key);
		try {
			if(bLanLnciBasedal!=null){
				bLanLnciBase = new BLanLnciBase();
				BeanUtils.copyProperties(bLanLnciBasedal, bLanLnciBase);
			}
			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("借据基本信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10004), BLanErrorConstant.SCF_BAS_LAN_10004);
		}
		return bLanLnciBase;
	}

	/**
	 * 借据锁定
	 */
	@Override
	@Transactional
	public void lockDebtBaseInfo(String debetNo, String lockAppno) throws ScubeBizException {
		BLanLnciBase lanciBaseInfo = new BLanLnciBase();
		// lanciBaseInfo =bLanLnciBaseDAO.selectByPrimaryKey(debetNo);
		lanciBaseInfo = this.findBLanLnciBaseByKey(debetNo);
		if (lanciBaseInfo != null) {
			lanciBaseInfo.setIsLocked(ScfBasConstant.LOCKED);
			lanciBaseInfo.setLockAppno(lockAppno);
			// bLanLnciBaseDAO.updateByPrimaryKeySelective(lanciBaseInfo);
			this.updateBLanLnciBase(lanciBaseInfo);
		}
	}

	/**
	 * 借据解锁
	 * 
	 * @param debetNo
	 * @throws ScubeBizException
	 */
	@Override
	@Transactional
	public void releaseDebtBaseInfo(String debetNo) throws ScubeBizException {
		BLanLnciBase lanciBaseInfo = new BLanLnciBase();
		lanciBaseInfo = this.findBLanLnciBaseByKey(debetNo);
		if (lanciBaseInfo != null) {
			lanciBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
			lanciBaseInfo.setLockAppno("");
			this.updateBLanLnciBase(lanciBaseInfo);
		}
	}

	/**
	 * 根据借据编号查询借据信息
	 */
	@Override
	public BLanLnciBase findBLanLnciBaseByDebtId(String debtId) throws ScubeBizException {
		BLanLnciBase bLanLnciBase = new BLanLnciBase();
		com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBasedal = new com.huateng.scf.bas.lan.dao.model.BLanLnciBase();
		bLanLnciBasedal = bLanLnciBaseDAO.findBLanLnciBaseByDebtId(debtId);
		try {
			if (null != bLanLnciBasedal) {
				BeanUtils.copyProperties(bLanLnciBasedal, bLanLnciBase);
			}
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("借据基本信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10004), BLanErrorConstant.SCF_BAS_LAN_10004);
		}
		return bLanLnciBase;
	}

	/**
	 *
	 * @Description: 查询未结清且有效的借据
	 * @param commonQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BLanLnciBase> queryValidLnciBaseInfo(CommonQryVO commonQryVO) throws ScubeBizException {
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != commonQryVO) {
			String mastContno = commonQryVO.getMastContno();// 合同号
			if (StringUtil.isStrNotEmpty(mastContno)) {
				map.put(MASTCONTNO, mastContno);
			}
		}

		map.put(STATE, BSysConstant.FLAG_ON); // 记录状态
		map.put(ISSETTLE, BSysConstant.FLAG_OFF); // 是否结清
		List<BLanLnciBase> list = new ArrayList<BLanLnciBase>();
		BLanLnciBase bLanLnciBase = null;
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> listdal = bLanLnciBaseDAO.queryValidLnciBaseInfo(map);
		if (listdal != null && listdal.size() > 0) {
			for (com.huateng.scf.bas.lan.dao.model.BLanLnciBase info : listdal) {
				bLanLnciBase = new BLanLnciBase();
				BeanUtils.copyProperties(info, bLanLnciBase);
				list.add(bLanLnciBase);
			}
		}

		return list;
	}

	/**
	 * 根据借据编号查询借据信息
	 */
	@Override
	public List<BLanLnciBase> queryLnciBaseInfoByDebetNo(String debetNo, int pageNo, int pageSize) {
		Page page = new Page(pageSize, pageNo, 0);
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		Criteria criteria = example.createCriteria();
		if (StringUtil.isStrNotEmpty(debetNo)) {
			criteria.andDebetNoEqualTo(debetNo);
		} else {
			return null;
		}
		criteria.andIsSettleEqualTo(ScfBasConstant.FLAG_OFF);// 是否结清
		criteria.andStateNotEqualTo(ScfBasConstant.FLAG_ON); // 记录状态
		example.setOrderByClause("END_DATE asc,DEBET_ID asc"); // 排序
		List<BLanLnciBase> list = new ArrayList<BLanLnciBase>();
		BLanLnciBase bLanLnciBase = null;
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> listdal = bLanLnciBaseDAO.selectByPage(example, page); // 分页查询
		if (listdal != null && listdal.size() > 0) {
			for (com.huateng.scf.bas.lan.dao.model.BLanLnciBase info : listdal) {
				bLanLnciBase = new BLanLnciBase();
				BeanUtils.copyProperties(info, bLanLnciBase);
				list.add(bLanLnciBase);
			}
		}
		return list;
	}

	public Page findBLanLnciBasePageByDebtId(int pageNo, int pageSize, List<String> debtNos) throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		Criteria criteria = example.createCriteria();
		criteria.andDebetIdIn(debtNos);
		bLanLnciBaseDAO.selectByPage(example, p);
		return p;

	}

	/**
	 * DESCRIPTION:提货借据更新(线下) 
	 * updateTblLnciBaseInfo 方法
	 * @param bLanLnciBase
	 * @param abcpAppliImprestBuss
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void updateTblLnciBaseInfo(BLanLnciBase bLanLnciBase, ABcpAppliImprestBuss abcpAppliImprestBuss)
			throws ScubeBizException {
		bLanLnciBase.setAmountIn(bLanLnciBase.getAmountIn().subtract(abcpAppliImprestBuss.getCommonAmt()));// 剩余提货金额
		bLanLnciBase.setAmountOut(bLanLnciBase.getAmountOut().add(abcpAppliImprestBuss.getCommonAmt()));// 累计提货金额
		BigDecimal addBailAmount = bLanLnciBase.getAddBailAmount() == null ? BigDecimal.ZERO: bLanLnciBase.getAddBailAmount();// 借据保证金金额
		BigDecimal addBailAmount_v = abcpAppliImprestBuss.getAddBailAmt() == null ? BigDecimal.ZERO: abcpAppliImprestBuss.getAddBailAmt();// 本次追加保证金金额
		bLanLnciBase.setAddBailAmount(addBailAmount.add(addBailAmount_v)); // modify // 借据表的追加保证金金额
		this.updateBLanLnciBase(bLanLnciBase);
	}
	@Override
	public Page getLnciBaseInfoByDebetNo(DebtCommonQryVO commonQueryVO) {
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		cri.andIsSettleEqualTo(ScfBasConstant.FLAG_OFF);
		cri.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno())) {
			// mengjiajia 在借据表中mastContno字段中保存的都是信贷合同号
			// cri.andMastContnoEqualTo(commonQueryVO.getMastContno());
			cri.andSlaveContnoEqualTo(commonQueryVO.getMastContno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getDebetNo_Q())) {
			if(commonQueryVO.getDebetNo_Q().indexOf("/f")==-1){
				cri.andDebetIdEqualTo(commonQueryVO.getDebetNo_Q());
			}else{
				String[] id=commonQueryVO.getDebetNo_Q().split("/f");
				List<String> debetIds = new ArrayList<String>();
				for(String debetId:id)
				{
					if(!StringUtil.isEmpty(debetId))
					{
						debetIds.add(debetId);
					}
				}
				if(debetIds.size()>0)
				{
					cri.andDebetIdIn(debetIds);
				}
			}
		} else {
			// TODO mengjiajia
			// sb.append(" and 1=2");
		}
		Page page = new Page();
		page.setRecords(bLanLnciBaseDAO.selectByExample(example));
		return page;
	}

	/**
	 *
	 * @Description: 池 查询融资列表
	 * @author jialei.zhang
	 * @Created 2013-8-21上午11:48:13
	 * @param lnciQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page queryLnciInfoByBusinessNo(DebtLnciQryVO lnciQryVO) throws ScubeBizException {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.lan.service.IBLanLnciBaseService#setLnciIsSettle(com.
	 * huateng.scf.bas.lan.model.BLanLnciBase)
	 */
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
	}

	/**
	 * 
	 * @param mastContno
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List calSumCashAndBailByMastContno(String mastContno) {
		HashMap<String, String> omap = new HashMap<String, String>();
		omap.put(STATE, ScfBasConstant.FLAG_ON);
		if (!StringUtil.isEmpty(mastContno)) {
			omap.put(MASTCONTNO, mastContno);
		}
		List list = extblandao.queryCalSumCashAndBailByMastContno(omap);
		return list;
	}

	/**
	 * @Description: 现金等价物查询，前台分页
	 * @Created 2013-10-31下午3:40:14
	 * @param debetNo
	 * @param debetId
	 * @param mastContno
	 * @param custcd
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getLnciBaseInfo(String debetNo, String debetId, String mastContno, String custcd) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		// 主合同号
		if (!StringUtil.isEmpty(mastContno)) {
			omap.put(MASTCONTNO, mastContno);
		}
		// 客户号
		if (!StringUtil.isEmpty(custcd)) {
			omap.put("custcd", custcd);
		}
		// 单据号
		if (!StringUtil.isEmpty(debetNo)) {
			omap.put("debetNo", debetNo);
		}
		// 子合同外部合同号
		if (!StringUtil.isEmpty(debetId)) {
			omap.put("debetId", debetId);
		}
		// 借据状态
		omap.put("state", ScfBasConstant.FLAG_ON);// 不等于
		omap.put("isSettle", ScfBasConstant.FLAG_OFF);// 等于
		omap.put("isLocked", ScfBasConstant.FLAG_ON);// 不等于

		List list = extblandao.getLnciBaseInfo(omap);
		return list;
	}

	/**
	 * DESCRIPTION: 借据解锁
	 * 
	 * @author zhoujun.hou
	 * @date 2013-5-9 releaseDebtBaseInfo 方法
	 * @param debetNo
	 * @throws ScubeBizException
	 * @param commonQueryVO
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void releaseDebtBaseInfoByLockAppno(String lockAppno) throws ScubeBizException {
		BLanLnciBase lnciBaseInfo = new BLanLnciBase();
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		cri.andLockAppnoEqualTo(lockAppno);
		List list = bLanLnciBaseDAO.selectByExample(example);
		if (list != null && list.size() > 0) {
			com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBase = (com.huateng.scf.bas.lan.dao.model.BLanLnciBase) list.get(0);
			BeanUtils.copyProperties(bLanLnciBase, lnciBaseInfo);
			lnciBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
			lnciBaseInfo.setLockAppno(null);
			this.updateBLanLnciBase(lnciBaseInfo);
		}
	}

	/**
	 * @Description: 查询全部合同全部借据
	 * @author mengjiajia
	 * @Created 2012-11-12下午05:09:51
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getLnciBaseInfoByWriteParamGetter(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		// 主合同号
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno_Q())) {
			cri.andMastContnoEqualTo(commonQueryVO.getMastContno_Q());
		}

		// 子合同号
		if (!StringUtil.isEmpty(commonQueryVO.getSubContno_Q())) {
			cri.andAppnoEqualTo(commonQueryVO.getSubContno_Q());
		}

		// 单据号
		if (!StringUtil.isEmpty(commonQueryVO.getDebetNo_Q())) {
			cri.andDebetNoEqualTo(commonQueryVO.getDebetNo_Q());
		}

		// 子合同外部合同号
		if (!StringUtil.isEmpty(commonQueryVO.getDebetId_Q())) {
			cri.andDebetIdLike(commonQueryVO.getDebetId_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getLnciStatus_Q())) {// 借据状态
			cri.andLnciStatusEqualTo(commonQueryVO.getLnciStatus_Q());
		}
		example.setOrderByClause("DEBET_NO asc");

		int total = bLanLnciBaseDAO.countByExample(example);
		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), total);
		page.setRecords(bLanLnciBaseDAO.selectByPage(example, page));

		return page;
	}

	/**
	 * DESCRIPTION:获取有效的借据
	 * 
	 * @author mengjiajia
	 * @date 2012-5-18 getLnciBaseInfoByParamGetter 方法
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getLnciBaseInfoByParamGetter(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		// 主合同号
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno_Q())) {
			cri.andMastContnoEqualTo(commonQueryVO.getMastContno_Q());
		}

		// 子合同号
		if (!StringUtil.isEmpty(commonQueryVO.getSubContno_Q())) {
			cri.andAppnoEqualTo(commonQueryVO.getSubContno_Q());
		}

		// 单据号
		if (!StringUtil.isEmpty(commonQueryVO.getDebetNo_Q())) {
			cri.andDebetNoEqualTo(commonQueryVO.getDebetNo_Q());
		}

		// 子合同外部合同号
		if (!StringUtil.isEmpty(commonQueryVO.getDebetId_Q())) {
			cri.andDebetIdLike(commonQueryVO.getDebetId_Q());
		}
		cri.andLnciStatusEqualTo(ScfBasConstant.LNCI_STATUS_NORMAL);
		example.setOrderByClause("DEBET_NO asc");

		int total = bLanLnciBaseDAO.countByExample(example);
		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), total);
		page.setRecords(bLanLnciBaseDAO.selectByPage(example, page));

		return page;
	}

	@Override
	public Page findBLanLnciBaseListForBLanLnciBase(int pageNo, int pageSize, BLanLnciBase bLanLnciBase) {
		Page p = new Page(pageSize, pageNo, 0);
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsSettleNotEqualTo(ScfBasConstant.FLAG_ON);
		criteria.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		example.setOrderByClause("END_DATE asc,DEBET_ID asc"); // 排序
		if (bLanLnciBase != null) {
			if (bLanLnciBase.getCustcd() != null && bLanLnciBase.getCustcd().length() > 0) {
				criteria.andCustcdEqualTo(bLanLnciBase.getCustcd());
			}
			if (bLanLnciBase.getMastContcode() != null && bLanLnciBase.getMastContcode().length() > 0) {
				criteria.andMastContcodeEqualTo(bLanLnciBase.getMastContcode());
			}
			if (bLanLnciBase.getMastContno() != null && bLanLnciBase.getMastContno().length() > 0) {
				criteria.andMastContnoEqualTo(bLanLnciBase.getMastContno());
			}
			if (bLanLnciBase.getDebetId() != null && bLanLnciBase.getDebetId().length() > 0) {
				criteria.andDebetIdEqualTo(bLanLnciBase.getDebetId());
			}
			if (bLanLnciBase.getDebetNo() != null && bLanLnciBase.getDebetNo().length() > 0) {
				criteria.andDebetNoEqualTo(bLanLnciBase.getDebetNo());
			}
		}

		bLanLnciBaseDAO.selectByPage(example, p);
		return p;

	}

	@Override
	public Page getAppliLnciBaseInfo(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		// 主合同号
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno_Q())) {
			omap.put("mastContno", commonQueryVO.getMastContno_Q());
		}

		// 子合同号
		if (!StringUtil.isEmpty(commonQueryVO.getSubContno_Q())) {
			omap.put("subContno", commonQueryVO.getSubContno_Q());
		}

		// 单据号
		if (!StringUtil.isEmpty(commonQueryVO.getDebetNo_Q())) {
			omap.put("debetNo", commonQueryVO.getDebetNo_Q());
		}

		if (!StringUtil.isEmpty(commonQueryVO.getAppno_Q())) {
			omap.put("appno", commonQueryVO.getAppno_Q());
		}

		// 子合同外部合同号
		if (!StringUtil.isEmpty(commonQueryVO.getDebetId_Q())) {
			omap.put("debetId", commonQueryVO.getDebetId_Q());
		}
		omap.put("lnciStatus", ScfBasConstant.LNCI_STATUS_NORMAL);

		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), 0);
		page.setRecords(extblandao.getAppliLnciBaseInfo(omap, page));
		page.setTotalRecord(extblandao.countAppliLnciBaseInfo(omap));

		return page;
	}

	/**
	 * DESCRIPTION:更新TblLnciBaseInfo的list
	 * 
	 * @author QUANYU.SI
	 * @date 2012-5-19 updateAll 方法
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void updateAll(List list) {
		for (int i = 0; i < list.size(); i++) {
			BLanLnciBase tblLnciBaseInfo = new BLanLnciBase();
			tblLnciBaseInfo = (BLanLnciBase) list.get(i);
			this.updateBLanLnciBase(tblLnciBaseInfo);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.lan.service.IBLanLnciBaseService#
	 * queryLnciBalByProtocolNo(java.lang.String)
	 */
	@Override
	public BigDecimal queryLnciBalByProtocolNo(String protocolNo) throws ScubeBizException {
		if (protocolNo == null || protocolNo.equals("")) {// SCF_BAS_LAN_20002
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002), BLanErrorConstant.SCF_BAS_LAN_20002);
		}
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		Criteria criteria = example.createCriteria();
		criteria.andProtocolNoEqualTo(protocolNo);
		criteria.andIsSettleNotEqualTo(ScfBasConstant.FLAG_ON);// 未结清
		criteria.andStateNotEqualTo(ScfBasConstant.FLAG_ON);// 非删除状态的
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> bLanLnciBaseList = bLanLnciBaseDAO.selectByExample(example);
		BigDecimal totalLnciBal = new BigDecimal(0);
		for (com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBase : bLanLnciBaseList) {
			BigDecimal lnciBal = bLanLnciBase.getLnciBal();
			if (lnciBal == null) {
				lnciBal = new BigDecimal(0);
			}
			totalLnciBal = totalLnciBal.add(lnciBal);
		}
		return totalLnciBal;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.lan.service.IBLanLnciBaseService#getDebetAmtOfSum(java.lang.String)
	 */
	@Override
	public List<BLanLnciBase> getDebetAmtOfSum(String protocolNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<BLanLnciBase> list  = new ArrayList<BLanLnciBase>();
		BLanLnciBase bLanLnciBase = null;
		if(StringUtil.isStrNotEmpty(protocolNo)){
			map.put(PROTOCOLNO, protocolNo);
		}
		map.put(STATE, BSysConstant.FLAG_ON); // 记录状态
		map.put(ISSETTLE, BSysConstant.FLAG_OFF); // 是否结清
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> listdal = extblandao.getDebetAmtOfSum(map);
		if(listdal!=null&&listdal.size()>0){
			for (com.huateng.scf.bas.lan.dao.model.BLanLnciBase info : listdal) {
				bLanLnciBase  = new BLanLnciBase();
				BeanUtils.copyProperties(info, bLanLnciBase);
				list.add(bLanLnciBase);
			}
		}
		return list;
	}
	/**
	 * 通过信贷合同号获取保证金总额和现金等价物
	 * @param mastContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月18日上午9:31:59
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public HashMap<String, Object> getLnciSumByParam(String mastContno) throws ScubeBizException
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		BigDecimal bailAmount = null;
		BigDecimal addBailAmount = null;
		BigDecimal addCashEqtAmt = null;
		BigDecimal initCashEqtAmt = null;
		BigDecimal lnciBal = null;
		BigDecimal lnciAmt = null;
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("state", ScfBasConstant.FLAG_ON);//不等于
		if(!StringUtil.isEmpty(mastContno)){
			omap.put("mastContno", mastContno);
		}
		List list = extblandao.getLnciSumByParam(omap);
		if(list!=null&&list.size()>0){
			Map<String, Object> obj = (Map<String, Object>) list.get(0);
			bailAmount = (BigDecimal)obj.get("bailAmount");
			addBailAmount = (BigDecimal)obj.get("addBailAmount");
			addCashEqtAmt = (BigDecimal)obj.get("addCashEqtAmt");
			initCashEqtAmt = (BigDecimal)obj.get("initCashEqtAmt");
			lnciBal = (BigDecimal)obj.get("lnciBal");
			lnciAmt = (BigDecimal)obj.get("lnciAmt");
		}
		if(null == bailAmount){
			bailAmount = new BigDecimal(0.00);
		}
		if(null == addBailAmount){
			addBailAmount = new BigDecimal(0.00);
		}
		if(null == addCashEqtAmt){
			addCashEqtAmt = new BigDecimal(0.00);
		}
		if(null == initCashEqtAmt){
			initCashEqtAmt = new BigDecimal(0.00);
		}
		if(null == lnciBal){
			lnciBal = new BigDecimal(0.00);
		}
		if(null == lnciAmt){
			lnciAmt = new BigDecimal(0.00);
		}
		map.put("bailAmount", bailAmount.add(addBailAmount));
		map.put("cashEqtAmt", addCashEqtAmt.add(initCashEqtAmt));
		map.put("lnciBal", lnciBal);
		map.put("lnciAmt", lnciAmt);
		return map;
	}


    /**
     * 查询质押合同下所有借据
     * @param slaveContno
     * @return
     * @throws ScubeBizException
     * @author 	mengjiajia
     * @date 	2017年4月26日下午2:03:17
     */
	@SuppressWarnings("rawtypes")
	@Override
	public List getLnciBaseInfoListBySlaveContno(String slaveContno) throws ScubeBizException
	{
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		cri.andSlaveContnoEqualTo(slaveContno);
		cri.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		cri.andIsSettleEqualTo(ScfBasConstant.FLAG_OFF);
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> list = bLanLnciBaseDAO.selectByExample(example);
		return list;
	}
	
	/**
	 * 根据申请号查询借据信息（主要用于提货申请关联借据信息的场景）
	 * @param appNo
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午3:48:26
	 */
	@Override
	public BLanLnciBase getTblLnciBaseInfoByBussAppNo(String appNo) throws ScubeBizException
	{
		BLanLnciBase bLanLnciBase = null;
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("appno", appNo);
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> list = extblandao.getTblLnciBaseInfoByBussAppNo(omap);
		if(null!=list && list.size()>0)
		{
			bLanLnciBase = new BLanLnciBase();
			com.huateng.scf.bas.lan.dao.model.BLanLnciBase baseinfo = list.get(0);
			BeanUtils.copyProperties(baseinfo, bLanLnciBase);
		}
		return bLanLnciBase;
	}
	
	/**
	 * 根据借据编号查询借据信息
	 * @param debetNo
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午9:15:30
	 */
	@Override
	public Page getLnciBaseInfoByDebetNo(String debetNo,int pageNo,int pageSize) throws ScubeBizException
	{
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		List<String> debetNoList = new ArrayList<String>();
		if(!StringUtil.isEmpty(debetNo))
		{
			 if(debetNo.indexOf("/f")==-1)
			 {
				cri.andDebetNoEqualTo(debetNo);
			 }
			 else
			 {
				 String[] id=debetNo.split("/f");
				 for(int i=0;i<id.length;i++)
				 {
					 if(!StringUtil.isEmpty(id[i]))
					 {
						 debetNoList.add(id[i]);
					 }
				 }
				 if(debetNoList.size()>0&&debetNoList!=null)
				 {
					 cri.andDebetNoIn(debetNoList);
				 }
			 }
		}
		else
		{
			 cri.andDebetNoEqualTo("#");
		}
		cri.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		cri.andIsSettleEqualTo(ScfBasConstant.FLAG_OFF);
		example.setOrderByClause("END_DATE asc,DEBET_ID asc");
		
		int total = bLanLnciBaseDAO.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(bLanLnciBaseDAO.selectByPage(example, page));
		return page;
	}
	
	/**
	 * 根据质押合同号查询借据列表
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午10:13:54
	 */
	@Override
	public Page getDebetList(DeliveryQryVO deliveryQryVO) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		List<String> debetNoList = new ArrayList<String>();
		omap.put("businessNo", deliveryQryVO.getBusinessNo());
		if(!StringUtil.isEmpty(deliveryQryVO.getDebetNo()))
		{
			if(deliveryQryVO.getDebetNo().indexOf("/f")==-1)
			{
				omap.put("debetNo", deliveryQryVO.getDebetNo());
			}
			else
			{
				String[] id=deliveryQryVO.getDebetNo().split("/f");
				for(int i=0;i<id.length;i++)
				{
					if(!StringUtil.isEmpty(id[i]))
					{
						debetNoList.add("'"+id[i]+"'");
					}
				}
			}
		}
		if(debetNoList!=null&&debetNoList.size()>0)
		{
			omap.put("debetNoList", debetNoList);
		}
		omap.put("state", ScfBasConstant.FLAG_OFF);
		omap.put("isSettle", ScfBasConstant.FLAG_OFF);
		
		int total = extblandao.countDebetList(omap);
		Page page = new Page(deliveryQryVO.getPageSize(), deliveryQryVO.getPageIndex(), total);
		page.setRecords(extblandao.getDebetList(omap, page));
		return page;
	}
	
	/**
	 * 根据协议号查询借据信息
	 * @param protocolNo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午10:42:45
	 */
	@Override
	public Page getLnciBaseInfoByProtocolNo(String protocolNo,int pageNo,int pageSize) throws ScubeBizException
	{
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		cri.andProtocolNoEqualTo(protocolNo);
		cri.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		cri.andIsSettleEqualTo(ScfBasConstant.FLAG_OFF);
		example.setOrderByClause("END_DATE asc");
		
		int total = bLanLnciBaseDAO.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(bLanLnciBaseDAO.selectByPage(example, page));
		return page;
	}
	
	/**
	 * 质押合同下出账总金额
	 * @param slaveContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午2:40:24
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public  BigDecimal queryLnciAmtBySlaveContno(String slaveContno)throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("state", ScfBasConstant.FLAG_ON);//不等于
		omap.put("slaveContno", slaveContno);
		List list = extblandao.queryLnciAmtBySlaveContno(omap);
		
		BigDecimal totalLnciBal = new BigDecimal("0");
		if(list!=null && list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				Map<String, BigDecimal> map = (Map<String, BigDecimal>) list.get(i);
				BigDecimal	lnciAmt = map.get("lnciAmt");
				totalLnciBal =totalLnciBal.add(lnciAmt==null?new BigDecimal("0"):lnciAmt);
			}
		}
		return totalLnciBal;
	}
	

	/**
	 * 查询质押合同下所有借据
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午5:17:57
	 */
	@Override
	public Page getLnciBaseInfoListBySlaveContno(ContSlaveQryVO contSlaveQryVO) throws ScubeBizException
	{
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		cri.andSlaveContnoEqualTo(contSlaveQryVO.getSlaveContno());
		cri.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		
		int total = bLanLnciBaseDAO.countByExample(example);
		Page page = new Page(contSlaveQryVO.getPageSize(), contSlaveQryVO.getPageIndex(), total);
		page.setRecords(bLanLnciBaseDAO.selectByPage(example, page));
		return page;
	}
}
