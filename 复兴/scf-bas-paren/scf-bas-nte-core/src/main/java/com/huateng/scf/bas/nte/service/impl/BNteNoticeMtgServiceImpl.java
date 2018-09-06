package com.huateng.scf.bas.nte.service.impl;

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

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.nte.constant.BNteErrorConstant;
import com.huateng.scf.bas.nte.dao.IBNteNoticeMtgDAO;
import com.huateng.scf.bas.nte.dao.ext.ExtBNteDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExample;
import com.huateng.scf.bas.nte.model.BNteNoticeMtg;
import com.huateng.scf.bas.nte.service.IBNteNoticeMtgService;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月28日上午9:18:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月28日上午9:18:11              新增
 *
 *            </pre>
 */
@ScubeService
@Service("BNteNoticeMtgServiceImpl")
public class BNteNoticeMtgServiceImpl implements IBNteNoticeMtgService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BNteNoticeMtgDAO")
	IBNteNoticeMtgDAO bNteNoticeMtgDAO;
	@Resource(name = "BPbcMtgClassServiceImpl")
	IBPbcMtgClassService bPbcMtgClassService;

	@Resource(name = "ExtBNteDAO")
	ExtBNteDAO extBNteDAO;

	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bPbcAppliMtgInfoService; // 业务申请押品信息

	private static final String DELIVERYNOS = "deliveryNos";
	private static final String MORTGAGENOS = "mortgageNos";

	@Transactional
	@Override
	public void addBNteNoticeMtg(BNteNoticeMtg bNteNoticeMtg) throws ScubeBizException {
		// ScfCommonUtil.setCommonField(bNteNoticeMtg);//设置公共字段 add by
		// huangshuidan 2016-11-11
		bNteNoticeMtg.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg bNteNoticeMtgdal = new com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg();
		try {
			BeanUtils.copyProperties(bNteNoticeMtg, bNteNoticeMtgdal);
		} catch (BeansException e) {
			log.error("通知书关联押品信息转换异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_30000), BNteErrorConstant.SCF_BAS_NTE_30000);
		}
		// TODO
		try {
			bNteNoticeMtgDAO.insertSelective(bNteNoticeMtgdal);
		} catch (Exception e) {
			log.error("通知书关联押品信息插入异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_30001), BNteErrorConstant.SCF_BAS_NTE_30001);
		}
	}

	@Transactional
	@Override
	public int updateBNteNoticeMtg(BNteNoticeMtg bNteNoticeMtg) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg bNteNoticeMtgdal = new com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg();
		try {
			BeanUtils.copyProperties(bNteNoticeMtg, bNteNoticeMtgdal);
		} catch (BeansException e) {
			log.error("通知书关联押品信息转换异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_30000), BNteErrorConstant.SCF_BAS_NTE_30000);
		}
		int i = 0;
		try {
			i = bNteNoticeMtgDAO.updateByPrimaryKeySelective(bNteNoticeMtgdal);
		} catch (Exception e) {
			log.error("通知书关联押品信息更新异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_30002), BNteErrorConstant.SCF_BAS_NTE_30002);
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteBNteNoticeMtg(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = bNteNoticeMtgDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.error("通知书关联押品信息删除异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_30003), BNteErrorConstant.SCF_BAS_NTE_30003);
		}
		return i;
	}

	@Override
	public BNteNoticeMtg findBNteNoticeMtgByKey(String key) throws ScubeBizException {
		BNteNoticeMtg bNteNoticeMtg = new BNteNoticeMtg();
		com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg bNteNoticeMtgdal = new com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg();
		bNteNoticeMtgdal = bNteNoticeMtgDAO.selectByPrimaryKey(key);
		try {
			BeanUtils.copyProperties(bNteNoticeMtgdal, bNteNoticeMtg);
		} catch (BeansException e) {
			log.error("通知书关联押品信息转换异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_30000), BNteErrorConstant.SCF_BAS_NTE_30000);
		}
		return bNteNoticeMtg;
	}

	/**
	 * 通过APPNO查找通知书票据信息
	 * 
	 * @param appno
	 * @return
	 */
	@Override
	public List<BNteNoticeMtg> findBNteNoticeMtgByAppno(String appno) throws ScubeBizException {
		List<BNteNoticeMtg> list = new ArrayList<BNteNoticeMtg>();
		BNteNoticeMtg bNteNoticeMtg = null;
		List<com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg> listdal = bNteNoticeMtgDAO.findBNteNoticeMtgByAppno(appno);
		for (com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg info : listdal) {
			bNteNoticeMtg = new BNteNoticeMtg();
			try {
				BeanUtils.copyProperties(info, bNteNoticeMtg);
			} catch (BeansException e) {
				log.error("通知书关联押品信息转换异常！");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_30000),
						BNteErrorConstant.SCF_BAS_NTE_30000);
			}
			list.add(bNteNoticeMtg);
		}
		return list;
	}

	/*
	 * 
	 * 根据pid查询通知书押品关联表TblNoticeMortgageInfo 一级二级押品名称转译
	 * 
	 */
	@Override
	public Page findBNteNoticeMtgByPid(int pageNo, int pageSize, String pid) throws ScubeBizException {
		if (pid == null || "".equals(pid)) {
			return null;
		}
		Page page = new Page(pageSize, pageNo, 0);
		BNteNoticeMtgExample bNteNoticeMtgExample = new BNteNoticeMtgExample();
		bNteNoticeMtgExample.createCriteria().andPidEqualTo(pid);
		List<com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg> bNteNoticeMtgList = bNteNoticeMtgDAO.selectByPage(bNteNoticeMtgExample, page);
		for (com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg bNteNoticeMtg1 : bNteNoticeMtgList) {
			// 一级押品名称转译
			BPbcMtgClass MortgageLevelOne = bPbcMtgClassService.translateMortgageNameByCode(bNteNoticeMtg1.getMortgageLevelOne());
			if (MortgageLevelOne != null) {
				bNteNoticeMtg1.setMortgageLevelOneNm(MortgageLevelOne.getMortgageName());
			}
			// 二级押品民称转译
			BPbcMtgClass MortgageLevelTwo = bPbcMtgClassService.translateMortgageNameByCode(bNteNoticeMtg1.getMortgageLevelTwo());
			if (MortgageLevelTwo != null) {
				bNteNoticeMtg1.setMortgageLevelTwoNm(MortgageLevelTwo.getMortgageName());
			}

		}
		page.setRecords(bNteNoticeMtgList);
		return page;
	}

	/**
	 * 根据押品编号查询发货通知押品信息
	 */
	@Override
	public Page getDeliveryNotifyMortList(String deliveryNo, String mortgageNo, int pageNo, int pageSize) throws ScubeBizException {
		// TODO Auto-generated method stub
		Page page = new Page(pageSize, pageNo, 0);

		HashMap<String, Object> map = new HashMap<String, Object>();
		List<String> deliveryNos = new ArrayList<String>();
		List<String> mortgageNos = new ArrayList<String>();
		if (StringUtil.isStrNotEmpty(deliveryNo)) {
			if (deliveryNo.indexOf("/f") != -1) {
				String[] deliveryNostr = mortgageNo.split("/f");
				if (deliveryNostr != null && deliveryNostr.length > 0) {
					for (String no : deliveryNostr) {
						deliveryNos.add(no);
					}
				}
			} else {
				deliveryNos.add(deliveryNo);
			}
			map.put(DELIVERYNOS, deliveryNos);
		}
		if (StringUtil.isStrNotEmpty(mortgageNo)) {
			if (mortgageNo.indexOf("/f") != -1) {
				String[] mortgageNostr = mortgageNo.split("/f");
				if (mortgageNostr != null && mortgageNostr.length > 0) {
					for (String no : mortgageNostr) {
						mortgageNos.add(no);
					}
				}
			} else {
				mortgageNos.add(mortgageNo);
			}
			map.put(MORTGAGENOS, mortgageNos);
		}
		extBNteDAO.getDeliveryNotifyMortList(map, page);

		return page;
	}

	/**
	 * DESCRIPTION:出质入库押品价格确定调整通知书信息---押品列表
	 * 
	 * @param noticeId
	 * @param appno
	 * @param mortgageList
	 * @param mortgageType
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void addConfirmPriceNoticeMortInfo(String noticeId, String appno, List<BPbcAppliMtgInfo> mortgageList, String mortgageType)
			throws ScubeBizException {
		if (mortgageList != null && mortgageList.size() > 0) {
			for (int i = 0; i < mortgageList.size(); i++) {
				BPbcAppliMtgInfo mortgageBaseInfo = (BPbcAppliMtgInfo) mortgageList.get(i);
				BNteNoticeMtg bNteNoticeMtg = new BNteNoticeMtg();
				BeanUtils.copyProperties(mortgageBaseInfo, bNteNoticeMtg);
				bNteNoticeMtg.setAppno(appno);
				bNteNoticeMtg.setMortgageType(mortgageType);// 货物类型
															// 0：表示新入库。1:表示解除抵押，出库。
				bNteNoticeMtg.setPid(noticeId);
				bNteNoticeMtg.setId(null);
				this.addBNteNoticeMtg(bNteNoticeMtg);
			}
		}
	}

	/**
	 * DESCRIPTION:添加到货出质入库押品清单信息
	 * 
	 * @author Guixiu.Liu
	 * @date 2012-11-14 addPledgeNoticeMortInfo
	 * @param noticeId
	 * @param appno
	 * @param appMortgageList
	 * @param mortgageType
	 * @throws CommonException
	 * @param
	 * @return
	 */
	@Transactional
	@Override
	public void addPledgeNoticeMortInfo(String noticeId, String appno, List<BPbcAppliMtgInfo> appMortgageList, String mortgageType)
			throws ScubeBizException {
		if (appMortgageList != null && appMortgageList.size() > 0) {
			for (int i = 0; i < appMortgageList.size(); i++) {
				BPbcAppliMtgInfo mortgageBaseInfo = (BPbcAppliMtgInfo) appMortgageList.get(i);
				BNteNoticeMtg bNteNoticeMtg = new BNteNoticeMtg();
				BeanUtils.copyProperties(mortgageBaseInfo, bNteNoticeMtg);
				bNteNoticeMtg.setMortgageType(mortgageType);// 货物类型
															// 0：表示新入库。1:表示解除抵押，出库。
				bNteNoticeMtg.setPid(noticeId);
				bNteNoticeMtg.setId(null);
				this.addBNteNoticeMtg(bNteNoticeMtg);
			}
		}
	}

	/**
	 * 根据APPNO AND PID 查询
	 * 
	 * @param appno
	 * @param pid
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月27日下午1:35:46
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getMortgageListByAppnoAndPid(String appno, String pid) throws ScubeBizException {
		BNteNoticeMtgExample example = new BNteNoticeMtgExample();
		BNteNoticeMtgExample.Criteria cri = example.createCriteria();
		if (!StringUtil.isEmpty(appno)) {
			cri.andAppnoEqualTo(appno);
		}
		if (!StringUtil.isEmpty(pid)) {
			cri.andPidEqualTo(pid);
		}
		List list = bNteNoticeMtgDAO.selectByExample(example);
		return list;
	}

	/**
	 * DESCRIPTION:保兑仓提货申请通知书保存押品信息(线下)
	 * 
	 * @author zhoujun.hou
	 * @date 2013-4-26 deliveryNoticeMortListSave 方法
	 * @param appno
	 * @param id
	 * @throws CommonException
	 * @param commonQueryVO
	 * @return
	 */
	@Transactional
	public void deliveryNoticeMortListSave(String appno, String id) throws ScubeBizException {
		// 1、获得已存在押品列表
		List<BPbcAppliMtgInfo> mortList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(appno);
		// 2、校验通知书押品列表--删除重新写入
		List<BNteNoticeMtg> list = this.findBNteNoticeMtgByAppno(appno);
		for (int i = 0; i < list.size(); i++) {
			BNteNoticeMtg bean = (BNteNoticeMtg) list.get(i);
			this.deleteBNteNoticeMtg(bean.getId());
		}
		for (int i = 0; i < mortList.size(); i++) {
			BPbcAppliMtgInfo unitBean = (BPbcAppliMtgInfo) mortList.get(i);
			BNteNoticeMtg bNteNoticeMtg = new BNteNoticeMtg();
			BeanUtils.copyProperties(unitBean, bNteNoticeMtg);

			bNteNoticeMtg.setAppno(appno);
			bNteNoticeMtg.setPid(id);
			bNteNoticeMtg.setMortgageName(unitBean.getMortgageName());
			bNteNoticeMtg.setMortgageNo(unitBean.getMortgageNo());// 押品编号
			bNteNoticeMtg.setMortgageLevelOne(unitBean.getMortgageLevelOne());
			bNteNoticeMtg.setMortgageLevelTwo(unitBean.getMortgageLevelTwo());
			bNteNoticeMtg.setMortgageModel(unitBean.getMortgageModel());
			bNteNoticeMtg.setQuantity(unitBean.getQuantity());
			bNteNoticeMtg.setMortgageUnits(unitBean.getMortgageUnits());
			bNteNoticeMtg.setTotPrice(unitBean.getTotPrice());
			bNteNoticeMtg.setDocumentNo(unitBean.getDocumentNo());// 相关凭证号
			bNteNoticeMtg.setMemo(unitBean.getDescription());
			// bNteNoticeMtg.setId(null);
			this.addBNteNoticeMtg(bNteNoticeMtg);
		}
	}

	/*
	 *
	 */
	@Override
	@Transactional
	public int deleteBNteNoticeMtgByAppno(String appno) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			return 0;
		}
		BNteNoticeMtgExample bNteNoticeMtgExample = new BNteNoticeMtgExample();
		bNteNoticeMtgExample.createCriteria().andAppnoEqualTo(appno);
		return bNteNoticeMtgDAO.deleteByExample(bNteNoticeMtgExample);
	}
}
