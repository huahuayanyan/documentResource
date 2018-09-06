/**
 * 
 */
package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.fcs.model.FourDeliveryQryVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliMtgInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.ext.ExtIBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfoExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfoExample;
import com.huateng.scf.bas.pbc.dao.vo.BPbcAppliMtgInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.dao.ISBcpAppliMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.ISBcpMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormalExample;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scf.sto.nwr.vo.BillStandardMortgageVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月27日下午5:31:49
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月27日下午5:31:49              新增
 *
 *            </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("BPbcAppliMtgInfoServiceImpl")
public class BPbcAppliMtgInfoServiceImpl implements IBPbcAppliMtgInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPbcAppliMtgInfoDAO")
	IBPbcAppliMtgInfoDAO bPbcAppliMtgInfoDAO;

	@Resource(name = "ExtBPbcMtgBaseInfoDAO")
	ExtIBPbcMtgBaseInfoDAO extbpbcmtgbaseinfodao;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;

	@Resource(name = "ISBcpMortBillNormalDAO")
	ISBcpMortBillNormalDAO sbcpmortbillnormaldao;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;

	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bPbcMtgBaseInfoService;

	@Resource(name = "BPbcMtgClassServiceImpl")
	IBPbcMtgClassService bPbcMtgClassService;

	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;

	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO bpbcmtgbaseinfodao;

	@Resource(name = "ISBcpAppliMortBillNormalDAO")
	ISBcpAppliMortBillNormalDAO sbcpapplimortbillnormaldao;

	@Transactional
	@Override
	public String addBPbcAppliMtgInfo(BPbcAppliMtgInfo bPbcAppliMtgInfo) throws ScubeBizException {
		// ScfCommonUtil.setCommonField(bPbcAppliMtgInfo);//设置公共字段 add by
		// huangshuidan 2016-11-11
		// 获取当前用户
		UserInfo user = ContextHolder.getUserInfo();
		String brCode = user.getBrNo();
		bPbcAppliMtgInfo.setBrcode(brCode);
		String id = UUIDGeneratorUtil.generate();
		bPbcAppliMtgInfo.setId(id);
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo bPbcAppliMtgInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo();
		try {
			BeanUtils.copyProperties(bPbcAppliMtgInfo, bPbcAppliMtgInfodal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("业务申请押品信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20000), BPbcErrorConstant.SCF_BAS_PBC_20000);
		}
		try {
			// TODO
			bPbcAppliMtgInfoDAO.insertSelective(bPbcAppliMtgInfodal);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("业务申请押品信息插入异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20001), BPbcErrorConstant.SCF_BAS_PBC_20001);
		}
		return id;
	}

	@Transactional
	@Override
	public int updateBPbcAppliMtgInfo(BPbcAppliMtgInfo bPbcAppliMtgInfo) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo bPbcAppliMtgInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo();
		try {
			BeanUtils.copyProperties(bPbcAppliMtgInfo, bPbcAppliMtgInfodal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("业务申请押品信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20000), BPbcErrorConstant.SCF_BAS_PBC_20000);
		}
		int i = 0;
		try {
			i = bPbcAppliMtgInfoDAO.updateByPrimaryKeySelective(bPbcAppliMtgInfodal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("业务申请押品信息更新异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20002), BPbcErrorConstant.SCF_BAS_PBC_20002);
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteBPbcAppliMtgInfo(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = bPbcAppliMtgInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("业务申请押品信息删除异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20003), BPbcErrorConstant.SCF_BAS_PBC_20003);
		}
		return i;
	}

	@Transactional
	@Override
	public BPbcAppliMtgInfo findBPbcAppliMtgInfoByKey(String key) throws ScubeBizException {
		BPbcAppliMtgInfo bPbcAppliMtgInfo = null;
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo bPbcAppliMtgInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo();
		bPbcAppliMtgInfodal = bPbcAppliMtgInfoDAO.selectByPrimaryKey(key);
		if (bPbcAppliMtgInfodal != null) {
			bPbcAppliMtgInfo = new BPbcAppliMtgInfo();
			try {
				BeanUtils.copyProperties(bPbcAppliMtgInfodal, bPbcAppliMtgInfo);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("业务申请押品信息转换异常！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20000),
						BPbcErrorConstant.SCF_BAS_PBC_20000);
			}
		}
		return bPbcAppliMtgInfo;
	}

	/**
	 * 根据appno查询押品申请表信息
	 */
	@Override
	public List<BPbcAppliMtgInfo> findBPbcAppliMtgInfoByAppno(String appno) throws ScubeBizException {
		List<BPbcAppliMtgInfo> list = new ArrayList<BPbcAppliMtgInfo>();
		BPbcAppliMtgInfo bPbcAppliMtgInfo = null;
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> listdal = bPbcAppliMtgInfoDAO.selectByAppno(appno);
		for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo info : listdal) {
			bPbcAppliMtgInfo = new BPbcAppliMtgInfo();
			BeanUtils.copyProperties(info, bPbcAppliMtgInfo);
			// 押品名称转译
			// 一级
			BPbcMtgClass bPbcMtgClassOne = bPbcMtgClassService.translateMortgageNameByCode(bPbcAppliMtgInfo.getMortgageLevelOne());
			if (bPbcMtgClassOne != null) {
				bPbcAppliMtgInfo.setMortgageLevelOneNm(bPbcMtgClassOne.getMortgageName());
			}
			// 二级
			BPbcMtgClass bPbcMtgClassTwo = bPbcMtgClassService.translateMortgageNameByCode(bPbcAppliMtgInfo.getMortgageLevelTwo());
			if (bPbcMtgClassTwo != null) {
				bPbcAppliMtgInfo.setMortgageLevelTwoNm(bPbcMtgClassTwo.getMortgageName());
			}
			// 三级
			BPbcMtgClass bPbcMtgClassThree = bPbcMtgClassService.translateMortgageNameByCode(bPbcAppliMtgInfo.getMortgageLevelThree());
			if (bPbcMtgClassThree != null) {
				bPbcAppliMtgInfo.setMortgageLevelThreeNm(bPbcMtgClassThree.getMortgageName());
			}
			list.add(bPbcAppliMtgInfo);
		}
		return list;
	}

	/**
	 * 根据appno获取本次申请下的购销合同已提货金额
	 */
	@Override
	public List<BPbcAppliMtgInfo> getTradeAppliTotPriceByAppno(String appno) throws ScubeBizException {
		// TODO Auto-generated method stub
		List<BPbcAppliMtgInfo> list = new ArrayList<BPbcAppliMtgInfo>();
		BPbcAppliMtgInfo bPbcAppliMtgInfo = null;
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> listdal = bPbcAppliMtgInfoDAO.getTradeAppliTotPriceByAppno(appno);
		for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo info : listdal) {
			bPbcAppliMtgInfo = new BPbcAppliMtgInfo();
			try {
				BeanUtils.copyProperties(info, bPbcAppliMtgInfo);
			} catch (BeansException e) {
				log.error("业务申请押品信息转换异常！");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20000),
						BPbcErrorConstant.SCF_BAS_PBC_20000);
			}
			list.add(bPbcAppliMtgInfo);
		}
		return list;
	}

	/**
	 * 获取申请中押品列表（分页 公共方法）
	 * 
	 * @param appliMortgageBaseQryVO
	 * @return
	 * @throws CommonException
	 * @author mengjiajia
	 * @date 2017年4月13日下午5:04:54
	 */
	@Override
	public Page getTblAppliMortgageBaseInfoByPara(AppliMortgageBaseQryVO appliMortgageBaseQryVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		List<String> billnoList = new ArrayList<String>();
		if (appliMortgageBaseQryVO != null) {
			if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getAppno_Q())) {
				omap.put("appno", appliMortgageBaseQryVO.getAppno_Q());
			}
			if (appliMortgageBaseQryVO.getSelectFlag() != null && appliMortgageBaseQryVO.getSelectFlag() == true) {
				if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getBillno())) {
					if (appliMortgageBaseQryVO.getBillno().indexOf("/f") == -1) {
						omap.put("billno", appliMortgageBaseQryVO.getBillno());
					} else {
						String[] ids = appliMortgageBaseQryVO.getBillno().split("/f");
						for (int i = 0; i < ids.length; i++) {
							if (!StringUtil.isEmpty(ids[i])) {
								billnoList.add("'" + ids[i].trim() + "'");
							}
						}
					}
				} else {
					omap.put("flag", "1");
				}
			}
			if (billnoList.size() > 0) {
				omap.put("billnoList", billnoList);
			}
			if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getMastContno())) {
				omap.put("mastContno", appliMortgageBaseQryVO.getMastContno());
			}
			if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getSlaveContno())) {
				omap.put("slaveContno", appliMortgageBaseQryVO.getSlaveContno());
			}
			if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getAppliMortBizType())) {
				omap.put("appliMortBizType", appliMortgageBaseQryVO.getAppliMortBizType());
			}
			if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getStatus())) {
				omap.put("status", appliMortgageBaseQryVO.getStatus());
			}
			if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getId())) {
				omap.put("id", appliMortgageBaseQryVO.getId());
			}
		}

		int total = extbpbcmtgbaseinfodao.countTblAppliMortgageBaseInfoByPara(omap);
		Page pageQueryResult = new Page(appliMortgageBaseQryVO.getPageSize(), appliMortgageBaseQryVO.getPageIndex(), total);
		List<BPbcAppliMtgInfoVO> list = extbpbcmtgbaseinfodao.getTblAppliMortgageBaseInfoByPara(omap, pageQueryResult);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				BPbcAppliMtgInfoVO baseInfoVO = list.get(i);
				baseInfoVO.setCname(bcrmbaseinfodao.selectById(baseInfoVO.getCustcd()).getCname());
				String billno = baseInfoVO.getBillno();
				SBcpMortBillNormal bcpMortBillNormal = sbcpmortbillnormaldao.selectByPrimaryKey(billno);
				if (bcpMortBillNormal != null) {
					baseInfoVO.setBillcode(bcpMortBillNormal.getBillcode());
				}
			}
		}
		pageQueryResult.setRecords(list);
		return pageQueryResult;
	}

	/**
	 * 
	 * @param billno
	 * @return
	 * @throws BeansException
	 * @author mengjiajia
	 * @date 2017年4月13日下午5:41:17
	 */
	@Override
	public boolean queryAppliMortgageByBillno(String billno) throws BeansException {
		BPbcAppliMtgInfoExample example = new BPbcAppliMtgInfoExample();
		BPbcAppliMtgInfoExample.Criteria cri = example.createCriteria();
		cri.andBillnoEqualTo(billno);
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> list = bPbcAppliMtgInfoDAO.selectByExample(example);
		if (list != null && list.size() > 0) {
			return false;
		}
		return true;
	}

	/**
	 * 方法 根据对象多个属性值查询 po对象list列表,查询不到抛异常
	 * 
	 * @param poName
	 * @param poMap
	 * @param errorMsg
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日下午5:18:30
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findByConditionException(String poName, HashMap<String, Object> poMap, String errorMsg) throws ScubeBizException {
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> resultLst = extbpbcmtgbaseinfodao.findByConditionException(poMap);
		List<BPbcAppliMtgInfo> list = new ArrayList<BPbcAppliMtgInfo>();
		if (resultLst == null || resultLst.size() <= 0) {
			throw new ScubeBizException(errorMsg, RBcpErrorConstant.RECORD_NOT_EXIST);
		} else {
			for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo appliMtgInfo : resultLst) {
				BPbcAppliMtgInfo bPbcAppliMtgInfo = new BPbcAppliMtgInfo();
				BeanUtils.copyProperties(appliMtgInfo, bPbcAppliMtgInfo);
				list.add(bPbcAppliMtgInfo);
			}
		}
		return list;
	}

	/**
	 * 得到现货类的押品总价
	 * 
	 * @param commonQueryVo
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日下午5:50:49
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BigDecimal getAppliMortgageTotalPrice(AppliMortgageBaseQryVO commonQueryVo) throws ScubeBizException {
		BigDecimal sumPrice = BigDecimal.ZERO;
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(commonQueryVo.getAppno_Q())) {
			omap.put("appno", commonQueryVo.getAppno_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVo.getAppliMortBizType())) {
			omap.put("appliMortBizType", commonQueryVo.getAppliMortBizType());
		}

		if (!StringUtil.isEmpty(commonQueryVo.getSlaveContno())) {
			omap.put("slaveContno", commonQueryVo.getSlaveContno());

		}

		List list = extbpbcmtgbaseinfodao.getAppliMortgageTotalPrice(omap);

		if (list.size() > 0 && list != null) {
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			sumPrice = (BigDecimal) map.get("totPrice");
		}
		if (null == sumPrice) {
			sumPrice = new BigDecimal("0.00");
		}
		return sumPrice;
	}

	/**
	 * 根据ApplyVO保存TblAppliMortgageBaseInfo【押品列表申请信息】
	 * 
	 * @param applyVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日下午7:37:28
	 */
	@Override
	public String saveAppMorgInfoByApplyVO(BillStandardMortgageVO applyVO) throws ScubeBizException {
		BPbcAppliMtgInfo appMorgBaseInfo = new BPbcAppliMtgInfo(); // 目标对象

		BeanUtils.copyProperties(applyVO, appMorgBaseInfo);
		appMorgBaseInfo.setId(null); // 清空PK
		appMorgBaseInfo.setAppno(applyVO.getAppno());
		if (StringUtil.isEmpty(applyVO.getMortgageNo())) {// 若押品编号为空则由系统生成，否则用传过来的
															// modify by
															// xiaolong.xiong
			appMorgBaseInfo.setMortgageNo(ibSysSerialNoService.genSerialNo("MORTGAGE_NO")); // 押品编号
		}
		appMorgBaseInfo.setBalQuantity(appMorgBaseInfo.getQuantity()); // 剩余数量
		appMorgBaseInfo.setBillQuantity(appMorgBaseInfo.getBillQuantity()); // 仓单数量
		// add by hui.liu 2011-06-09
		appMorgBaseInfo.setOldConfirmPrice(appMorgBaseInfo.getOldConfirmPrice());// 原始核定价格

		// 保存操作
		String id = this.addBPbcAppliMtgInfo(appMorgBaseInfo);
		return id;
	}

	/**
	 * 根据ApplyVO更新TblAppliMortgageBaseInfo【押品列表申请信息】
	 * 
	 * @param appMorgBaseInfo
	 * @param applyVO
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日下午7:44:02
	 */
	@Override
	public void updateAppMorgInfoByApplyVO(BPbcAppliMtgInfo appMorgBaseInfo, BillStandardMortgageVO applyVO) throws ScubeBizException {
		try {
			BeanUtils.copyProperties(applyVO, appMorgBaseInfo);
			appMorgBaseInfo.setAppno(applyVO.getAppno());
			appMorgBaseInfo.setBalQuantity(appMorgBaseInfo.getQuantity()); // 剩余数量
		} catch (Exception e) {
			e.printStackTrace();
			log.error("------updateAppMorgInfoByApplyVO方法遇到错误：" + e);
			throw new ScubeBizException(e.getMessage(), e);
		}

		// 更新操作
		this.updateBPbcAppliMtgInfo(appMorgBaseInfo);
	}

	/**
	 * 获取押品出质清单押品列表
	 */
	@Override
	public List<BPbcAppliMtgInfo> getQualityNoticeMortList(FourDeliveryQryVO fourDeliveryQryVO) throws ScubeBizException {
		// TODO Auto-generated method stub
		List<BPbcAppliMtgInfo> list = new ArrayList<BPbcAppliMtgInfo>();
		BPbcAppliMtgInfoExample example = new BPbcAppliMtgInfoExample();
		BPbcAppliMtgInfoExample.Criteria cri = example.createCriteria();
		if (fourDeliveryQryVO != null) {
			if (StringUtil.isStrNotEmpty(fourDeliveryQryVO.getAppno())) { // 申请编号
				cri.andAppnoEqualTo(fourDeliveryQryVO.getAppno());
			}
			if (StringUtil.isStrNotEmpty(fourDeliveryQryVO.getAppliMortBizType())) {// 申请业务押品清单业务类型
				cri.andAppliMortBizTypeEqualTo(fourDeliveryQryVO.getAppliMortBizType());
			}
			if (StringUtil.isStrNotEmpty(fourDeliveryQryVO.getSlaveContno())) {// 担保合同号
				cri.andSlaveContnoEqualTo(fourDeliveryQryVO.getSlaveContno());
			}
			if (StringUtil.isStrNotEmpty(fourDeliveryQryVO.getMortgageNo())) { // 押品号
				cri.andMortgageNoEqualTo(fourDeliveryQryVO.getMortgageNo());
			}
			if (StringUtil.isStrNotEmpty(fourDeliveryQryVO.getBillno())) { // 仓单号
				cri.andBillnoEqualTo(fourDeliveryQryVO.getBillno());
			}
			cri.andQuantityGreaterThan(BigDecimal.ZERO);
			example.setOrderByClause("MORTGAGE_NO desc");
			List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> listdal = bPbcAppliMtgInfoDAO.selectByExample(example);
			BPbcAppliMtgInfo bPbcAppliMtgInfo = null;
			if (listdal != null && listdal.size() > 0) {
				for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo info : listdal) {
					bPbcAppliMtgInfo = new BPbcAppliMtgInfo();
					try {
						BeanUtils.copyProperties(info, bPbcAppliMtgInfo);
					} catch (BeansException e) {
						log.error("业务申请押品信息转换异常！");
						e.printStackTrace();
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20000),
								BPbcErrorConstant.SCF_BAS_PBC_20000);
					}
					list.add(bPbcAppliMtgInfo);
				}
			}
		}
		return list;
	}

	/**
	 * DESCRIPTION:到货出质入库核价信息保存 pledgeAppPricing
	 * 
	 * @param appno
	 * @param appliMtgInfoList
	 * @throws ScubeBizException
	 * @param
	 * @return
	 */
	@Transactional
	@Override
	public void pledgeAppPricing(String appno, List<BPbcAppliMtgInfo> appliMtgInfoList) throws ScubeBizException {
		// TODO Auto-generated method stub
		for (Iterator<BPbcAppliMtgInfo> it = appliMtgInfoList.iterator(); it.hasNext();) {
			BPbcAppliMtgInfo mortgageVO = (BPbcAppliMtgInfo) it.next(); // 源对象
			// 查询押品信息申请表
			BPbcAppliMtgInfo bPbcAppliMtgInfo = this.findBPbcAppliMtgInfoByKey(mortgageVO.getId());
			if (bPbcAppliMtgInfo == null) {
				log.error("押品编号为【" + mortgageVO.getMortgageNo() + "】的押品信息申请不存在!");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20008),
						BPbcErrorConstant.SCF_BAS_PBC_20008);
			}
			BigDecimal confirmPrice = new BigDecimal(0.00);
			if (mortgageVO.getConfirmPrice() == null || confirmPrice.compareTo(mortgageVO.getConfirmPrice()) >= 0) {
				log.error("押品编号为：【" + mortgageVO.getMortgageNo() + "】的核定价不能低于0.00!");
				throw new ScubeBizException("押品编号为：【" + mortgageVO.getMortgageNo() + "】的核定价不能低于0.00!");
			}
			if (StringUtil.isEmpty(mortgageVO.getConfirmAccording())) {
				log.error("押品编号为：【" + mortgageVO.getMortgageNo() + "】的核准依据未录入!");
				throw new ScubeBizException("押品编号为：【" + mortgageVO.getMortgageNo() + "】的核准依据未录入!");
			}
			// 由于IE6显示有误，故直接使用下拉 去除判断 modify by changhao.huang 2013-10-18
			bPbcAppliMtgInfo.setJoinBatch(mortgageVO.getJoinBatch());
			/*
			 * if("true".equalsIgnoreCase(mortgageVO.getJoinBatch())){
			 * appMorgBaseInfo.setJoinBatch(SCFConstants.JOIN_BATCH_YES); }else
			 * if("false".equalsIgnoreCase(mortgageVO.getJoinBatch())){
			 * appMorgBaseInfo.setJoinBatch(SCFConstants.JOIN_BATCH_NO); }
			 */
			confirmPrice = mortgageVO.getConfirmPrice();
			bPbcAppliMtgInfo.setOldConfirmPrice(bPbcAppliMtgInfo.getConfirmPrice());
			bPbcAppliMtgInfo.setOriginalTotPrice(bPbcAppliMtgInfo.getOriginalTotPrice());
			bPbcAppliMtgInfo.setOriginalPrice(bPbcAppliMtgInfo.getPrice());
			BigDecimal totPrice = null;
			BigDecimal quality = null;
			quality = bPbcAppliMtgInfo.getQuantity();
			totPrice = confirmPrice.multiply(quality);
			bPbcAppliMtgInfo.setTotPrice(totPrice);
			bPbcAppliMtgInfo.setConfirmPrice(confirmPrice);
			bPbcAppliMtgInfo.setMarketPrice(mortgageVO.getMarketPrice());// 市场价格
			bPbcAppliMtgInfo.setFixMortgageNo(mortgageVO.getFixMortgageNo());// 价格行情编号
			bPbcAppliMtgInfo.setConfirmAccording(mortgageVO.getConfirmAccording());
			bPbcAppliMtgInfo.setPrice(mortgageVO.getPrice()); // 设置押品单价
			bPbcAppliMtgInfo.setMemo(mortgageVO.getMemo()); // 备注
			this.updateBPbcAppliMtgInfo(bPbcAppliMtgInfo);
		}
	}

	/**
	 * 根据appno查询押品申请表Map
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public Map<String, Object> queryAppliMortgageByAppno(String appno) throws ScubeBizException {
		List<BPbcAppliMtgInfo> list = this.findBPbcAppliMtgInfoByAppno(appno);
		Map<String, Object> map = new HashMap<String, Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				BPbcAppliMtgInfo bPbcAppliMtgInfo = (BPbcAppliMtgInfo) list.get(i);
				String mortgageNo = bPbcAppliMtgInfo.getMortgageNo() == null ? "" : bPbcAppliMtgInfo.getMortgageNo();
				if (StringUtil.isStrNotEmpty(mortgageNo)) {
					map.put(mortgageNo, bPbcAppliMtgInfo);
				}
			}
		}
		return map;
	}

	@Override
	@Transactional
	public void updateMutiPriceAdjustInfo(BPbcAppliMtgInfo bPbcAppliMtgInfo) throws ScubeBizException {
		// 1.校验数据
		if (bPbcAppliMtgInfo == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 2.保存调价信息
		BPbcAppliMtgInfoExample bPbcAppliMtgInfoExample = new BPbcAppliMtgInfoExample();
		bPbcAppliMtgInfoExample.createCriteria().andAppnoEqualTo(bPbcAppliMtgInfo.getAppno());
		bPbcAppliMtgInfoDAO.deleteByExample(bPbcAppliMtgInfoExample);
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo bPbcAppliMtgInfo2 = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo();
		bPbcAppliMtgInfo2.setId(UUIDGeneratorUtil.generate());
		bPbcAppliMtgInfo2.setAppno(bPbcAppliMtgInfo.getAppno());
		bPbcAppliMtgInfo2.setMortgageLevelOne(bPbcAppliMtgInfo.getMortgageLevelOne());
		bPbcAppliMtgInfo2.setMortgageLevelTwo(bPbcAppliMtgInfo.getMortgageLevelTwo());
		bPbcAppliMtgInfo2.setMortgageLevelThree(bPbcAppliMtgInfo.getMortgageLevelThree());
		bPbcAppliMtgInfo2.setConfirmPrice(bPbcAppliMtgInfo.getConfirmPrice());
		bPbcAppliMtgInfo2.setDescription(bPbcAppliMtgInfo.getDescription());
		bPbcAppliMtgInfo2.setStatus(ScfBasConstant.APPLI_MORT_STATUS_APPROVE);
		bPbcAppliMtgInfoDAO.insert(bPbcAppliMtgInfo2);
		// 3.锁定押品信息(如果被本申请号锁定则不操作，不被本申请号锁定则报错，未被锁定则修改锁定。)
		com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo bPbcMtgBaseInfo = new com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo();
		bPbcMtgBaseInfo.setSupplyChainPdId(bPbcAppliMtgInfo.getProductId());
		bPbcMtgBaseInfo.setMortgageLevelOne(bPbcAppliMtgInfo.getMortgageLevelOne());
		bPbcMtgBaseInfo.setMortgageLevelTwo(bPbcAppliMtgInfo.getMortgageLevelTwo());
		bPbcMtgBaseInfo.setMortgageLevelThree(bPbcAppliMtgInfo.getMortgageLevelThree());
		bPbcMtgBaseInfo.setJoinBatch("1");
		List<BPbcMtgBaseInfo> bPbcMtgBaseInfoList = bPbcMtgBaseInfoService.getMortgageInfoByMortgageLevels(bPbcMtgBaseInfo);
		if (bPbcMtgBaseInfoList == null || bPbcMtgBaseInfoList.size() == 0) {
			throw new ScubeBizException("无对应押品信息，押品信息锁定失败！");
		}
		for (BPbcMtgBaseInfo bPbcMtgBaseInfo1 : bPbcMtgBaseInfoList) {
			if (bPbcMtgBaseInfo1.getIsLocked() != null && bPbcMtgBaseInfo1.getIsLocked().equals("1")) {
				if (bPbcMtgBaseInfo1.getLockAppno() != null && bPbcMtgBaseInfo1.getLockAppno().equals(bPbcAppliMtgInfo.getAppno())) {
					return;
				} else {
					throw new ScubeBizException("页面押品已被锁定，请重新选择押品信息！");
				}
			} else {// 页面押品信息锁定
				bPbcMtgBaseInfoService.lockMortgageBaseInfo(bPbcMtgBaseInfo1.getMortgageNo(), bPbcAppliMtgInfo.getAppno());
			}
		}
	}

	/**
	 * 保存押品申请信息
	 * 
	 * @param pbcAppliMtgInfo
	 * @author mengjiajia
	 * @date 2017年4月26日下午5:28:43
	 */
	@Override
	public void save(BPbcAppliMtgInfo pbcAppliMtgInfo) {
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo appliMtgInfo = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo();
		try {
			BeanUtils.copyProperties(pbcAppliMtgInfo, appliMtgInfo);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		if (StringUtil.isEmpty(appliMtgInfo.getId())) {
			appliMtgInfo.setId(UUIDGeneratorUtil.generate());
			bPbcAppliMtgInfoDAO.insertSelective(appliMtgInfo);
		} else {
			bPbcAppliMtgInfoDAO.updateByPrimaryKeySelective(appliMtgInfo);
		}
	}

	/**
	 * 根据appno删除表中数据
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月26日下午5:45:39
	 */
	@Override
	public void delAppliMortgageListByAppno(String appno) throws ScubeBizException {
		List<BPbcAppliMtgInfo> list = this.findBPbcAppliMtgInfoByAppno(appno);
		if (list != null && list.size() > 0) {
			for (BPbcAppliMtgInfo vo : list) {
				if (vo != null && vo.getId() != null) {
					com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo tblAppliMortgageBaseInfo = bPbcAppliMtgInfoDAO.selectByPrimaryKey(vo.getId());
					if (!StringUtil.isEmpty(tblAppliMortgageBaseInfo.getMortgageNo())) {
						bpbcmtgbaseinfoservice.releaseMortgageBaseInfo(tblAppliMortgageBaseInfo.getMortgageNo());
					}
					bPbcAppliMtgInfoDAO.deleteByPrimaryKey(vo.getId());
				}
			}
		}
	}

	/**
	 * updateMortgageAppOutStorage 普通仓单解押(置换) 根据仓单号增加、删除、修改仓单下对应的押品申请信息
	 * 
	 * @param appno
	 * @param outInsertList
	 * @param outUpdateList
	 * @param outDelList
	 * @param appliMortBizType
	 *            1302 普通仓单解押出库 ; 1502 普通仓单置换出库
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日下午1:59:39
	 */
	@Override
	public void updatebillNoramlMortgageAppOutStorage(String appno, List<BillNormalAppVO> outInsertList, List<BillNormalAppVO> outUpdateList,
			List<BillNormalAppVO> outDelList) throws ScubeBizException {
		// 增加操作 业务申请用押品基本信息清单
		Map<String, String> insertMap = new HashMap<String, String>();

		BPbcAppliMtgInfoExample example = new BPbcAppliMtgInfoExample();
		BPbcAppliMtgInfoExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);

		for (BillNormalAppVO applyVO : outInsertList) {
			String billno = applyVO.getBillno();
			insertMap.put(billno, billno);
			cri.andBillnoEqualTo(billno);
			List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> outlist = bPbcAppliMtgInfoDAO.selectByExample(example);
			if (outlist != null && outlist.size() > 0) {
				continue;
			}
			BPbcMtgBaseInfoExample infoExample = new BPbcMtgBaseInfoExample();
			BPbcMtgBaseInfoExample.Criteria infocri = infoExample.createCriteria();
			infocri.andBillnoEqualTo(billno);
			// 查询该仓单下的押品信息
			List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo> list = bpbcmtgbaseinfodao.selectByExample(infoExample);
			if (list != null && list.size() > 0) {
				for (com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo baseInfo : list) {
					BPbcAppliMtgInfo appliMtgInfo = new BPbcAppliMtgInfo();
					try {
						BeanUtils.copyProperties(baseInfo, appliMtgInfo);
						appliMtgInfo.setAppno(appno); // 申请编号
						appliMtgInfo.setAppliMortBizType(ScfBasConstant.MORT_BIZ_TYPE_NORMAL_RECEIPT_OUT); // 申请业务押品清单业务类型：解押出库

					} catch (BeansException e) {
						throw new ScubeBizException("转换异常");
					}
					this.save(appliMtgInfo);
				}
			}
		}
		for (BillNormalAppVO applyVO : outUpdateList) {
			String billno = applyVO.getBillno();
			insertMap.put(billno, billno);
			cri.andBillnoEqualTo(billno);
			List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> outlist = bPbcAppliMtgInfoDAO.selectByExample(example);
			for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo appliMtgInfo : outlist) {
				// 删除申请号为appno下仓单号为 billno的押品申请信息
				bPbcAppliMtgInfoDAO.deleteByPrimaryKey(appliMtgInfo.getId());
			}
			BPbcMtgBaseInfoExample infoExample = new BPbcMtgBaseInfoExample();
			BPbcMtgBaseInfoExample.Criteria infocri = infoExample.createCriteria();
			infocri.andBillnoEqualTo(billno);
			// 查询该仓单下的押品信息
			List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo> list = bpbcmtgbaseinfodao.selectByExample(infoExample);
			if (list != null && list.size() > 0) {
				for (com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo baseInfo : list) {
					BPbcAppliMtgInfo appliMtgInfo = new BPbcAppliMtgInfo();
					try {
						BeanUtils.copyProperties(baseInfo, appliMtgInfo);
						appliMtgInfo.setAppno(appno); // 申请编号
						appliMtgInfo.setAppliMortBizType(ScfBasConstant.MORT_BIZ_TYPE_NORMAL_RECEIPT_OUT); // 申请业务押品清单业务类型：解押出库

					} catch (BeansException e) {
						throw new ScubeBizException("转换异常");
					}
					this.save(appliMtgInfo);
				}
			}
		}

		// 删除操作.
		for (BillNormalAppVO applyVO : outDelList) {
			String billno = applyVO.getBillno();
			if (insertMap.containsKey(billno)) {
				continue;
			}
			cri.andBillnoEqualTo(billno);
			List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> outlist = bPbcAppliMtgInfoDAO.selectByExample(example);
			for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo appliMtgInfo : outlist) {
				// 删除申请号为appno下仓单号为 billno的押品申请信息
				bPbcAppliMtgInfoDAO.deleteByPrimaryKey(appliMtgInfo.getId());
			}

		}
	}

	/**
	 * 按条件查询押品LIST
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日下午4:21:47
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getApplyMortgageList(AppliMortgageBaseQryVO commonQueryVO) throws ScubeBizException {
		BPbcAppliMtgInfoExample example = new BPbcAppliMtgInfoExample();
		BPbcAppliMtgInfoExample.Criteria cri = example.createCriteria();
		if (!StringUtil.isEmpty(commonQueryVO.getAppno())) { // 申请编号
			cri.andAppnoEqualTo(commonQueryVO.getAppno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getAppliMortBizType())) {// 申请业务押品清单业务类型
			cri.andAppliMortBizTypeEqualTo(commonQueryVO.getAppliMortBizType());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getSlaveContno())) {// 担保合同号
			cri.andSlaveContnoEqualTo(commonQueryVO.getSlaveContno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getMortgageNo())) { // 押品号
			cri.andMortgageNoEqualTo(commonQueryVO.getMortgageNo());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillno())) { // 仓单号
			cri.andBillnoEqualTo(commonQueryVO.getBillno());
		}

		List list = bPbcAppliMtgInfoDAO.selectByExample(example);
		return list;
	}

	/**
	 * 置换管理仓单押品列表的获取---普通仓单
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月8日上午9:04:03
	 */
	@Override
	public Page getBillMortListByParam(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		BPbcAppliMtgInfoExample example = new BPbcAppliMtgInfoExample();
		BPbcAppliMtgInfoExample.Criteria cri = example.createCriteria();
		String temp = commonQueryVO.getAppType_Q();
		if (!StringUtil.isEmpty(commonQueryVO.getAppno_Q())) {
			cri.andAppnoEqualTo(commonQueryVO.getAppno_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getAppliType())) {
			cri.andAppliMortBizTypeEqualTo(commonQueryVO.getAppliMortBizType_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillno_Q())) {
			cri.andBillnoEqualTo(commonQueryVO.getBillno_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getSlaveContno_Q())) {
			cri.andSlaveContnoEqualTo(commonQueryVO.getSlaveContno_Q());
		}
		List<String> billnoList = new ArrayList<String>();
		if (temp != null) {
			// 非标仓单业务申请信息
			SBcpAppliMortBillNormalExample normal = new SBcpAppliMortBillNormalExample();
			SBcpAppliMortBillNormalExample.Criteria normalcri = normal.createCriteria();

			if (!StringUtil.isEmpty(commonQueryVO.getAppno_Q())) {
				normalcri.andAppnoEqualTo(commonQueryVO.getAppno_Q());
			}
			if (!StringUtil.isEmpty(commonQueryVO.getState_Q())) {
				normalcri.andStatusEqualTo(commonQueryVO.getState_Q());
			}
			if (!StringUtil.isEmpty(commonQueryVO.getMastContno_Q())) {
				normalcri.andMastContnoEqualTo(commonQueryVO.getMastContno_Q());
			}
			if (!StringUtil.isEmpty(commonQueryVO.getSlaveContno_Q())) {
				normalcri.andSlaveContnoEqualTo(commonQueryVO.getSlaveContno_Q());
			}
			if ("normal".equals(commonQueryVO.getAppType_Q())) {
				List<SBcpAppliMortBillNormal> list = sbcpapplimortbillnormaldao.selectByExample(normal);
				if (list != null && list.size() > 0) {
					for (SBcpAppliMortBillNormal appliMortBillNormal : list) {
						billnoList.add(appliMortBillNormal.getBillno());
					}
				}
			}
			if ("standard".equals(commonQueryVO.getAppType_Q())) {
				// hql.append(" TblAppliMortgageBillStand b ");
			}
		}
		if (billnoList != null && billnoList.size() > 0) {
			cri.andBillnoIn(billnoList);
		}
		if (!StringUtil.isEmpty(commonQueryVO.getId_Q())) {
			cri.andIdEqualTo(commonQueryVO.getId_Q());
		}

		int total = bPbcAppliMtgInfoDAO.countByExample(example);
		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), total);
		page.setRecords(bPbcAppliMtgInfoDAO.selectByExample(example));
		return page;
	}

	/**
	 * 获取申请下押品列表
	 * 
	 * @param bussAppno
	 * @param appliMortBizType
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月9日上午10:48:25
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getAppliMortgageByAppliMortBizType(String bussAppno, String appliMortBizType) throws ScubeBizException {
		BPbcAppliMtgInfoExample example = new BPbcAppliMtgInfoExample();
		BPbcAppliMtgInfoExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(bussAppno);
		if (!StringUtil.isEmpty(appliMortBizType)) {
			cri.andAppliMortBizTypeEqualTo(appliMortBizType);
		}
		List list = bPbcAppliMtgInfoDAO.selectByExample(example);
		return list;
	}

	/**
	 * 获取非标准仓单置换押品总价值。
	 * 
	 * @param commonQueryVo
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月9日下午1:26:35
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BigDecimal getExchangeTotalPrice(AppliMortgageBaseQryVO commonQueryVo) throws ScubeBizException {
		BigDecimal sumPrice = null;
		HashMap<String, Object> omap = new HashMap<String, Object>();

		if (!StringUtil.isEmpty(commonQueryVo.getAppno())) {
			omap.put("appno", commonQueryVo.getAppno());
		}
		if (!StringUtil.isEmpty(commonQueryVo.getAppliMortBizType())) {
			omap.put("appliMortBizType", commonQueryVo.getAppliMortBizType());
		}
		if (!StringUtil.isEmpty(commonQueryVo.getStatus())) {
			omap.put("status", commonQueryVo.getStatus());
		}
		if (!StringUtil.isEmpty(commonQueryVo.getSlaveContno())) {
			omap.put("slaveContno", commonQueryVo.getSlaveContno());
		}

		List list = extbpbcmtgbaseinfodao.getExchangeTotalPrice(omap);

		if (list != null && list.size() > 0) {
			Map<String, BigDecimal> map = (Map<String, BigDecimal>) list.get(0);
			sumPrice = map.get("totPrice");
		}
		if (null == sumPrice) {
			sumPrice = new BigDecimal("0.00");
		}
		return sumPrice;
	}

	/**
	 * 置换管理仓单押品列表的获取---普通仓单
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月9日下午3:27:55
	 */
	@Override
	public Page getBillMortListByParam(BillNormalVO commonQueryVO) throws ScubeBizException {
		BPbcAppliMtgInfoExample example = new BPbcAppliMtgInfoExample();
		BPbcAppliMtgInfoExample.Criteria cri = example.createCriteria();
		String temp = commonQueryVO.getAppType();
		if (!StringUtil.isEmpty(commonQueryVO.getAppno())) {
			cri.andAppnoEqualTo(commonQueryVO.getAppno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getAppliType())) {
			cri.andAppliMortBizTypeEqualTo(commonQueryVO.getAppliMortBizType());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillno())) {
			cri.andBillnoEqualTo(commonQueryVO.getBillno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getSlaveContno())) {
			cri.andSlaveContnoEqualTo(commonQueryVO.getSlaveContno());
		}
		List<String> billnoList = new ArrayList<String>();
		if (temp != null) {
			// 非标仓单业务申请信息
			SBcpAppliMortBillNormalExample normal = new SBcpAppliMortBillNormalExample();
			SBcpAppliMortBillNormalExample.Criteria normalcri = normal.createCriteria();

			if (!StringUtil.isEmpty(commonQueryVO.getAppno())) {
				normalcri.andAppnoEqualTo(commonQueryVO.getAppno());
			}
			if ("normal".equals(commonQueryVO.getAppType())) {
				List<SBcpAppliMortBillNormal> list = sbcpapplimortbillnormaldao.selectByExample(normal);
				if (list != null && list.size() > 0) {
					for (SBcpAppliMortBillNormal appliMortBillNormal : list) {
						billnoList.add(appliMortBillNormal.getBillno());
					}
				}
			}
			if ("standard".equals(commonQueryVO.getAppType())) {
				// hql.append(" TblAppliMortgageBillStand b ");
			}
		}
		if (billnoList != null && billnoList.size() > 0) {
			cri.andBillnoIn(billnoList);
		}
		if (!StringUtil.isEmpty(commonQueryVO.getId())) {
			cri.andIdEqualTo(commonQueryVO.getId());
		}

		int total = bPbcAppliMtgInfoDAO.countByExample(example);
		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), total);
		page.setRecords(bPbcAppliMtgInfoDAO.selectByExample(example));
		return page;
	}

	/*
	 * 页面上的申请出质入库的押品信息字段quantity字段需要改为invQuantity
	 */
	@Override
	public Page queryNotifyMortgageListByAppno(int pageNo, int pageSize, String appno) throws BeansException {
		Page page = new Page(pageSize, pageNo, 0);
		if (StringUtils.isEmpty(appno)) {
			return page;
		}
		BPbcAppliMtgInfoExample bPbcAppliMtgInfoExample = new BPbcAppliMtgInfoExample();
		bPbcAppliMtgInfoExample.createCriteria().andAppnoEqualTo(appno);
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> bPbcAppliMtgInfoList = bPbcAppliMtgInfoDAO.selectByPage(bPbcAppliMtgInfoExample,
				page);
		ArrayList<BPbcAppliMtgInfoVO> arrayList = new ArrayList<BPbcAppliMtgInfoVO>();
		if (bPbcAppliMtgInfoList != null && bPbcAppliMtgInfoList.size() > 0) {
			for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo bPbcAppliMtgInfo1 : bPbcAppliMtgInfoList) {
				BPbcAppliMtgInfoVO bPbcAppliMtgInfoVO = new BPbcAppliMtgInfoVO();
				BeanUtils.copyProperties(bPbcAppliMtgInfo1, bPbcAppliMtgInfoVO);
				bPbcAppliMtgInfoVO.setInvQuantity(bPbcAppliMtgInfo1.getQuantity());
				if (StringUtils.isNotEmpty(bPbcAppliMtgInfoVO.getMortgageLevelOne())) {
					BPbcMtgClass bPbcMtgClassOne = bPbcMtgClassService.translateMortgageNameByCode(bPbcAppliMtgInfoVO.getMortgageLevelOne());
					bPbcAppliMtgInfoVO.setMortgageLevelOneName(bPbcMtgClassOne.getMortgageName());
				}
				if (StringUtils.isNotEmpty(bPbcAppliMtgInfoVO.getMortgageLevelTwo())) {
					BPbcMtgClass bPbcMtgClassTwo = bPbcMtgClassService.translateMortgageNameByCode(bPbcAppliMtgInfoVO.getMortgageLevelTwo());
					bPbcAppliMtgInfoVO.setMortgageLevelTwoName(bPbcMtgClassTwo.getMortgageName());
				}
				arrayList.add(bPbcAppliMtgInfoVO);
			}
			page.setRecords(arrayList);
		}
		return page;
	}
	
	/**
	 * 增加/追加押品信息
	 * @param appBaseInfo
	 * @param mortgageApplyVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午3:39:59
	 */
	@Override
	@Transactional
	public void addAppMortgageVO(BPbcAppliBaseInfo appBaseInfo,MortgageApplyVO mortgageApplyVO) throws ScubeBizException
	{
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo appliMtgInfo = 
				new com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo();
		BeanUtils.copyProperties(mortgageApplyVO, appliMtgInfo);
		appliMtgInfo.setId(UUIDGeneratorUtil.generate());
		appliMtgInfo.setAppno(appBaseInfo.getAppno()); // 申请编号
		if(StringUtil.isEmpty(appliMtgInfo.getMortgageNo()))
		{
			appliMtgInfo.setMortgageNo(ibSysSerialNoService.genSerialNo("MORTGAGE_NO"));
		}
		appliMtgInfo.setSlaveContno(appBaseInfo.getSlaveContno());// 担保合同号
		appliMtgInfo.setCustcd(appBaseInfo.getCustcd());
		appliMtgInfo.setMoniOfCustcd(appBaseInfo.getMoniCustcd());
		appliMtgInfo.setMastContno(appBaseInfo.getMastContno());
		appliMtgInfo.setMonitorProtocolNo(appBaseInfo.getProtocolNo());// 监管协议号
		appliMtgInfo.setFlag(ScfBasConstant.MORTGAGE_FLAG_CAN_USE);// FLAG 01 可用
		appliMtgInfo.setStatus(ScfBasConstant.STATUS_VALID);// 状态 01 可用
		appliMtgInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());
		bPbcAppliMtgInfoDAO.insertSelective(appliMtgInfo);
	}
}
