package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.nte.model.BNteNoticeMtg;
import com.huateng.scf.bas.nte.service.IBNteNoticeMtgService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.ext.ExtIBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfoExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfoExample.Criteria;
import com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.model.MortgageQryVO;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStockDtlService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStorDeliService;
import com.huateng.scf.bas.pbc.vo.MortgageBaseInfoVO;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.sto.nwr.dao.ISBcpMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageQryVO;
import com.huateng.scf.sto.nwr.vo.BillstandardQryVO;
import com.huateng.scf.sto.smp.model.MortgageSumPriceQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月14日下午5:25:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月14日下午5:25:31	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BPbcMtgBaseInfoServiceImpl")
public class BPbcMtgBaseInfoServiceImpl implements IBPbcMtgBaseInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO ibPbcMtgBaseInfoDAO;

	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO ibCrrDuebillAppDAO;

	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;

	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO ibCrrGntyConDAO;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;

	@Resource(name = "ExtBPbcMtgBaseInfoDAO")
	ExtIBPbcMtgBaseInfoDAO extibpbcmtgbaseinfodao;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;

	// 业务申请信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;

	// 业务申请押品信息
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bPbcAppliMtgInfoService;

	// 通知书关联押品信息
	@Resource(name = "BNteNoticeMtgServiceImpl")
	IBNteNoticeMtgService bNteNoticeMtgService;

	// 押品变更流水信息
	@Resource(name = "BPbcMtgStorDeliServiceImpl")
	IBPbcMtgStorDeliService bPbcMtgStorDeliService;

	// 押品信息变更明细
	@Resource(name = "BPbcMtgStockDtlServiceImpl")
	IBPbcMtgStockDtlService bPbcMtgStockDtlService;

	// 监管协议/担保提货协议/先票(款)后货协议信息
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bCntMprotBaseInfoService;

	@Resource(name = "BPbcMtgClassServiceImpl")
	IBPbcMtgClassService bPbcMtgClassService; // 押品种类信息

	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;

	@Resource(name = "ISBcpMortBillNormalDAO")
	ISBcpMortBillNormalDAO sbcpmortbillnormaldao;

	@Transactional
	@Override
	public void addBPbcMtgBaseInfo(BPbcMtgBaseInfo bPbcMtgBaseInfo) throws ScubeBizException {
		// ScfCommonUtil.setCommonField(bPbcMtgBaseInfo);//设置公共字段 add by
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo bPbcMtgBaseInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo();
		try {
			BeanUtils.copyProperties(bPbcMtgBaseInfo, bPbcMtgBaseInfodal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品库存基本信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20004), BPbcErrorConstant.SCF_BAS_PBC_20004);
		}
		try {
			// TODO
			ibPbcMtgBaseInfoDAO.insertSelective(bPbcMtgBaseInfodal);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("押品库存基本信息插入异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20005), BPbcErrorConstant.SCF_BAS_PBC_20005);
		}
	}

	@Transactional
	@Override
	public int updateBPbcMtgBaseInfo(BPbcMtgBaseInfo bPbcMtgBaseInfo) throws ScubeBizException {
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo bPbcMtgBaseInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo();
		try {
			BeanUtils.copyProperties(bPbcMtgBaseInfo, bPbcMtgBaseInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("押品库存基本信息转换异常！" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20004), BPbcErrorConstant.SCF_BAS_PBC_20004);
		}
		int i = 0;
		try {
			i = ibPbcMtgBaseInfoDAO.updateByPrimaryKey(bPbcMtgBaseInfodal);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("押品库存基本信息更新异常！" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20006), BPbcErrorConstant.SCF_BAS_PBC_20006);
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteBPbcMtgBaseInfo(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = ibPbcMtgBaseInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品库存基本信息删除异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20007), BPbcErrorConstant.SCF_BAS_PBC_20007);
		}
		return i;
	}

	@Transactional
	@Override
	public BPbcMtgBaseInfo findBPbcMtgBaseInfoByKey(String key) throws ScubeBizException {
		BPbcMtgBaseInfo bPbcMtgBaseInfo = null;
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo bPbcMtgBaseInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo();
		bPbcMtgBaseInfodal = ibPbcMtgBaseInfoDAO.selectByPrimaryKey(key);
		try {
			if (bPbcMtgBaseInfodal != null) {
				bPbcMtgBaseInfo = new BPbcMtgBaseInfo();
				BeanUtils.copyProperties(bPbcMtgBaseInfodal, bPbcMtgBaseInfo);
			}
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品库存基本信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_20004), BPbcErrorConstant.SCF_BAS_PBC_20004);
		}
		return bPbcMtgBaseInfo;
	}

	@Override
	public Page findBPbcMtgBaseInfoByPage(int pageNo, int pageSize, String appno) {
		BCrrDuebillApp bCrrDuebillApp = ibCrrDuebillAppDAO.selectByPrimaryKey(appno);
		String mastContno = bCrrDuebillApp.getAppId();
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		String vidNo = "";
		if (bCrrLnCon != null) {
			vidNo = bCrrLnCon.getVidNo();// 供应链业务合同号
		}
		BCrrGntyCon bCrrGntyCon = ibCrrGntyConDAO.selectByPrimaryKey(vidNo);// 合同流水号--主键
		String slaveContno = "";// 押品表里面的从合同好--slave_contno
		if (bCrrGntyCon != null) {
			slaveContno = bCrrGntyCon.getConId();
		}
		BPbcMtgBaseInfo bPbcMtgBaseInfo = new BPbcMtgBaseInfo();
		bPbcMtgBaseInfo.setSlaveContno(slaveContno);

		// 查询开始
		BPbcMtgBaseInfoExample example = new BPbcMtgBaseInfoExample();
		Criteria cri = example.createCriteria();
		cri.andSlaveContnoEqualTo(bPbcMtgBaseInfo.getSlaveContno());
		example.setOrderByClause("MORTGAGE_NO DESC");

		int total = ibPbcMtgBaseInfoDAO.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		List<BPbcMtgBaseInfoVO> arrayList = new ArrayList<BPbcMtgBaseInfoVO>();
		BPbcMtgBaseInfoVO vo = null;
		List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo> list = ibPbcMtgBaseInfoDAO.selectByPage(example, p);
		if (list != null && list.size() > 0) {
			for (com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo info : list) {
				vo = new BPbcMtgBaseInfoVO();
				BeanUtils.copyProperties(info, vo);
				// 押品名称翻译
				String mortgageLevelOne = vo.getMortgageLevelOne();
				String mortgageLevelTwo = vo.getMortgageLevelTwo();
				if (StringUtil.isStrNotEmpty(mortgageLevelOne)) {
					BPbcMtgClass one = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelOne);
					vo.setMortgageLevelOneName(one.getMortgageName());
				}
				if (StringUtil.isStrNotEmpty(mortgageLevelTwo)) {
					BPbcMtgClass two = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelTwo);
					vo.setMortgageLevelTwoName(two.getMortgageName());
				}
				arrayList.add(vo);
			}
		}
		p.setRecords(arrayList);
		log.info("p.toString()=" + p.toString());
		return p;
	}

	/**
	 * 通过仓单编号查询押品信息
	 * 
	 * @param billno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月13日下午5:44:02
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getBillstandardMorgByBillno(String billno) {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("billno", billno);
		List list = extibpbcmtgbaseinfodao.getBillstandardMorgByBillno(omap, null, false);
		for (int i = 0; i < list.size(); i++) {
			BPbcMtgBaseInfoVO baseInfoVO = (BPbcMtgBaseInfoVO) list.get(i);
			baseInfoVO.setCname(bcrmbaseinfodao.selectById(baseInfoVO.getCustcd()).getCname());
		}
		return list;
	}

	/**
	 * 仓单押品保存
	 * 
	 * @param baseInfo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月13日下午7:47:10
	 */
	@Override
	public void saveMorgBaseInfo(BPbcMtgBaseInfo baseInfo) throws ScubeBizException {
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo morgBaseInfo = new com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo(); // 目标对象
		BeanUtils.copyProperties(baseInfo, morgBaseInfo);
		if (StringUtil.isEmpty(baseInfo.getMortgageNo())) {// 若押品编号为空则由系统生成，否则用传过来的
			String mortgageNo = ibSysSerialNoService.genSerialNo("MORTGAGE_NO");
			morgBaseInfo.setMortgageNo(mortgageNo); // 押品编号
		}
		morgBaseInfo.setBillQuantity(morgBaseInfo.getBillQuantity()); // 仓单数量

		morgBaseInfo.setOldConfirmPrice(morgBaseInfo.getConfirmPrice());// 原始核定价格
		if (StringUtil.isEmpty(morgBaseInfo.getChannelFlag())) {// 若渠道标识为空，则默认为供应链
			morgBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);
		}
		morgBaseInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		morgBaseInfo.setLastUpdTime(new Date());
		// 保存操作
		ibPbcMtgBaseInfoDAO.insertSelective(morgBaseInfo);
	}

	/**
	 * 仓单下是否存在押品信息
	 * 
	 * @param billno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月17日下午3:56:32
	 */
	@Override
	public boolean isBillstandardMorgNoExist(String billno) {
		BPbcMtgBaseInfoExample example = new BPbcMtgBaseInfoExample();
		BPbcMtgBaseInfoExample.Criteria cri = example.createCriteria();
		cri.andBillnoEqualTo(billno);
		List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo> list = ibPbcMtgBaseInfoDAO.selectByExample(example);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 获取押品总价格
	 * 
	 * @param mastContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月18日上午9:52:35
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BigDecimal getMortgageSumPriceByBillMastno(String mastContno) {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		BigDecimal sumPrice = BigDecimal.ZERO;
		List<String> statusList = new ArrayList<String>();
		statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
		statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_IN);
		omap.put("statusList", statusList);
		if (!StringUtil.isEmpty(mastContno)) {
			omap.put("mastContno", mastContno);
		}
		List list = extibpbcmtgbaseinfodao.getMortgageSumPriceByBillMastno(omap);
		if (list.size() > 0) {
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			sumPrice = BigDecimal.valueOf(Double.valueOf(map.get("totPrice").toString()));
		}
		return sumPrice;
	}

	/**
	 * @Description: 获取押品列表（分页）押品明细查询(数量大于0)
	 * @param mortgageQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page getMortgageBaseInfoPageByParam(int pageNo, int pageSize, MortgageQryVO mortgageQryVO) throws ScubeBizException {
		// TODO Auto-generated method stub
		Page page = new Page(pageSize, pageNo, 0);
		BPbcMtgBaseInfoExample example = new BPbcMtgBaseInfoExample();
		BPbcMtgBaseInfoExample.Criteria cri = example.createCriteria();
		if (null != mortgageQryVO) {
			if (StringUtil.isStrNotEmpty(mortgageQryVO.getMastContno())) {// 主合同号
				cri.andMastContnoEqualTo(mortgageQryVO.getMastContno());
			}
			if (StringUtil.isStrNotEmpty(mortgageQryVO.getProtocolNo())) { // 从协议号
				cri.andOtherProtocolNoEqualTo(mortgageQryVO.getProtocolNo());
			}
			if (StringUtil.isStrNotEmpty(mortgageQryVO.getSlaveContno())) {// 担保合同号
				cri.andSlaveContnoEqualTo(mortgageQryVO.getSlaveContno());
			}
			if (StringUtil.isStrNotEmpty(mortgageQryVO.getMonitorProtocolNo())) {// 监管协议号
				cri.andMonitorProtocolNoEqualTo(mortgageQryVO.getMonitorProtocolNo());
			}
			if (StringUtil.isStrNotEmpty(mortgageQryVO.getSupplyChainPdId())) {// 供应链产品ID
				cri.andSupplyChainPdIdEqualTo(mortgageQryVO.getSupplyChainPdId());

			}
			if (StringUtil.isStrNotEmpty(mortgageQryVO.getBillno())) {// 仓单号
				cri.andBillnoEqualTo(mortgageQryVO.getBillno());
			}
			if (StringUtil.isStrNotEmpty(mortgageQryVO.getCustcd())) {// 客户号
				cri.andCustcdEqualTo(mortgageQryVO.getCustcd());
			}

			// 增加机构控制查询 得到所有下属机构列表(包含自己)start
			String brCode = mortgageQryVO.getBrcode();
			if (StringUtil.isStrNotEmpty(mortgageQryVO.getBrcode())) {// 机构号
				List<BctlVO> bctList = scubeUserService.getBrListByBrNo(brCode, ScfCommonUtil.getBrManagerNo(scubeUserService));
				ArrayList<String> arrBr = new ArrayList<String>();
				for (BctlVO bctlVO : bctList) {
					String brNo = bctlVO.getBrNo();
					arrBr.add(brNo);
				}
				cri.andBrcodeIn(arrBr);
			}
			// 增加机构控制查询 end
		}
		cri.andQuantityGreaterThan(BigDecimal.ZERO);// 数量>0
		example.setOrderByClause("MORTGAGE_NO DESC");
		ibPbcMtgBaseInfoDAO.selectByPage(example, page);
		List<BPbcMtgBaseInfoVO> arrayList = new ArrayList<BPbcMtgBaseInfoVO>();
		BPbcMtgBaseInfoVO vo = null;
		List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo> list = page.getRecords();
		if (list != null && list.size() > 0) {
			for (com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo info : list) {
				vo = new BPbcMtgBaseInfoVO();
				BeanUtils.copyProperties(info, vo);
				String billno = vo.getBillno();
				SBcpMortBillNormal billNormal = sbcpmortbillnormaldao.selectByPrimaryKey(billno);
				if (billNormal != null) {
					String billcode = billNormal.getBillcode();
					vo.setBillcode(billcode);
				} else {
					vo.setBillcode(billno);
				}
				// 押品名称翻译
				String mortgageLevelOne = vo.getMortgageLevelOne();
				String mortgageLevelTwo = vo.getMortgageLevelTwo();
				if (StringUtil.isStrNotEmpty(mortgageLevelOne)) {
					BPbcMtgClass one = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelOne);
					vo.setMortgageLevelOneName(one.getMortgageName());
				}
				if (StringUtil.isStrNotEmpty(mortgageLevelTwo)) {
					BPbcMtgClass two = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelTwo);
					vo.setMortgageLevelTwoName(two.getMortgageName());
				}
				arrayList.add(vo);
			}
		}
		page.setRecords(arrayList);
		return page;
	}

	/**
	 * 获取押品总价格
	 * 
	 * @Date 2011-7-1
	 */
	public BigDecimal getMortgageSumPriceByParam(HashMap<String, Object> omap) throws ScubeBizException {
		BigDecimal sumPrice = BigDecimal.ZERO;

		List<Map<String, Object>> list = extibpbcmtgbaseinfodao.getMortgageSumPriceByParam(omap);
		if (list != null && list.size() > 0) {
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			sumPrice = (BigDecimal) map.get("totPrice");
		}

		return sumPrice;
	}

	/**
	 * 修改押品信息
	 * 
	 * @param baseInfo
	 * @author mengjiajia
	 * @date 2017年4月18日下午4:25:12
	 */
	@Override
	public void update(BPbcMtgBaseInfo bPbcMtgBaseInfo) throws ScubeBizException {
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo bPbcMtgBaseInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo();
		try {
			BeanUtils.copyProperties(bPbcMtgBaseInfo, bPbcMtgBaseInfodal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		try {
			ibPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(bPbcMtgBaseInfodal);
		} catch (BeansException e) {
			throw new ScubeBizException("更新异常");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService#
	 * findBPbcMtgBaseInfoBySlaveContno(java.lang.String)
	 */
	@Override
	public List<BPbcMtgBaseInfo> findBPbcMtgBaseInfoBySlaveContno(String slaveContno) throws ScubeBizException {
		if (slaveContno == null || "".equals(slaveContno)) {
			return null;
		}
		BPbcMtgBaseInfoExample bPbcMtgBaseInfoExample = new BPbcMtgBaseInfoExample();
		bPbcMtgBaseInfoExample.createCriteria().andSlaveContnoEqualTo(slaveContno);
		ArrayList<BPbcMtgBaseInfo> arrayList = new ArrayList<BPbcMtgBaseInfo>();
		List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo> bPbcMtgBaseInfoList = ibPbcMtgBaseInfoDAO.selectByExample(bPbcMtgBaseInfoExample);
		if (bPbcMtgBaseInfoList != null && bPbcMtgBaseInfoList.size() > 0) {
			for (com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo bPbcMtgBaseInfo1 : bPbcMtgBaseInfoList) {
				BPbcMtgBaseInfo bPbcMtgBaseInfo = new BPbcMtgBaseInfo();
				BeanUtils.copyProperties(bPbcMtgBaseInfo1, bPbcMtgBaseInfo);
				// 押品名称翻译
				String mortgageLevelOne = bPbcMtgBaseInfo.getMortgageLevelOne();
				String mortgageLevelTwo = bPbcMtgBaseInfo.getMortgageLevelTwo();
				String mortgageLevelThree = bPbcMtgBaseInfo.getMortgageLevelThree();
				if (StringUtil.isStrNotEmpty(mortgageLevelOne)) {
					BPbcMtgClass one = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelOne);
					bPbcMtgBaseInfo.setMortgageLevelOneName(one.getMortgageName());
				}
				if (StringUtil.isStrNotEmpty(mortgageLevelTwo)) {
					BPbcMtgClass two = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelTwo);
					bPbcMtgBaseInfo.setMortgageLevelTwoName(two.getMortgageName());
				}
				if (StringUtil.isStrNotEmpty(mortgageLevelThree)) {
					BPbcMtgClass three = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelThree);
					bPbcMtgBaseInfo.setMortgageLevelThreeName(three.getMortgageName());
				}
				arrayList.add(bPbcMtgBaseInfo);
			}
		}
		return arrayList;
	}

	/**
	 * 获取押品总价值
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月21日下午4:00:47
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page getEffectTotPrice(AppliMortgageBaseQryVO commonQueryVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(commonQueryVO.getSlaveContno())) {
			omap.put("slaveContno", commonQueryVO.getSlaveContno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getMonitorProtocolNo())) {
			omap.put("monitorProtocolNo", commonQueryVO.getMonitorProtocolNo());
		}
		// 表中无该字段
		// if(!StringUtil.isEmpty(commonQueryVO.getIsSlExibition()))
		// {
		// omap.put("isSlExibition", commonQueryVO.getIsSlExibition());
		// }
		omap.put("status", ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
		List list = extibpbcmtgbaseinfodao.getEffectTotPrice(omap);
		List<MortgageBaseInfoVO> pageList = new ArrayList<MortgageBaseInfoVO>();
		Page pageQueryResult = new Page();
		if (list.size() > 0 && list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = (Map<String, Object>) list.get(i);
				MortgageBaseInfoVO mortgageBaseInfoVO = new MortgageBaseInfoVO();
				mortgageBaseInfoVO.setTotalPrice((BigDecimal) map.get("totPrice"));
				pageList.add(mortgageBaseInfoVO);
			}
		}
		pageQueryResult.setRecords(pageList);
		pageQueryResult.setTotalRecord(pageList.size());
		return pageQueryResult;
	}

	/**
	 * 四方到货出质入库押品正式表及流水信息表写入&&更新购销合同已出质金额
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public void fhPledgeAppMortInfoDtlRecord(String appno) throws ScubeBizException {
		// TODO Auto-generated method stub
		// 1、 查询主申请信息
		BPbcAppliBaseInfo appBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		if (appBaseInfo == null) {
			log.error("业务申请记录丢失,无法操作！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10004), BPbcErrorConstant.SCF_BAS_PBC_10004);
		}

		// 2、押品申请信息查询
		List<BPbcAppliMtgInfo> appListTemp = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(appno);
		List<BPbcAppliMtgInfo> appMorgInfoList = new ArrayList<BPbcAppliMtgInfo>();

		// 3、押品编号处理---新入库的需要重新生成押品编号；已在库的不做处理
		if (appListTemp.size() > 0 && appListTemp != null) {
			for (int i = 0; i < appListTemp.size(); i++) {
				BPbcAppliMtgInfo bPbcAppliMtgInfo = (BPbcAppliMtgInfo) appListTemp.get(i);
				// 更新发货通知押品中的剩余库存数量
				String mortgageNo = bPbcAppliMtgInfo.getMortgageNo();
				String deliveryNo = bPbcAppliMtgInfo.getDeliveryNum();
				if (StringUtil.isStrNotEmpty(mortgageNo)) {
					Page page = bNteNoticeMtgService.getDeliveryNotifyMortList(deliveryNo, mortgageNo, 1, 10000);
					List<com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExt> list = page.getRecords();
					Iterator<com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExt> it = list.iterator();
					while (it.hasNext()) {
						com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExt obj = (com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExt) it.next();
						BNteNoticeMtg mortgageInfo = new BNteNoticeMtg();
						BeanUtils.copyProperties(obj, mortgageInfo);
						BigDecimal balQuantity = mortgageInfo.getBalQuantity();
						// 剩余库存数量=当前库存数量-本次出质入库数量
						mortgageInfo.setBalQuantity(
								balQuantity.subtract(bPbcAppliMtgInfo.getQuantity() == null ? BigDecimal.ZERO : bPbcAppliMtgInfo.getQuantity()));
						bNteNoticeMtgService.updateBNteNoticeMtg(mortgageInfo);
					}
				}
				// 在发货通知录入保存押品的时候即生成新的押品编号 modity by changhao.huang @2013-9-4
				// appliMortgageBaseInfo.setMortgageNo(DAOUtils.getTblAppliMortgageBaseInfoDAO().getMortgageNo());
				appMorgInfoList.add(bPbcAppliMtgInfo);
			}
		}

		// 4、TBL_MORTGAGE_STOR_DELI_INFO[业务流水信息表]写入
		// String storDeliInfoId = addTblMortgageStorDeliInfo(appBaseInfo,
		// SCFConstants.STOR_DELI_BIZ_TYPE_PLEDGE, SCFConstants.STOR_OR_DELI_IN,
		// appMorgInfoList);
		String storDeliInfoId = bPbcMtgStorDeliService.addMortgageStorDeliInfo(appBaseInfo, ScfBasConstant.STOR_DELI_BIZ_TYPE_PLEDGE,
				ScfBasConstant.STOR_OR_DELI_IN, appMorgInfoList);
		// 5、保存押品信息变更明细表
		for (int i = 0; i < appMorgInfoList.size(); i++) {
			BPbcAppliMtgInfo appliMtgInfo = (BPbcAppliMtgInfo) appMorgInfoList.get(i);
			BPbcAppliMtgInfoVO appliMtgInfoVO = new BPbcAppliMtgInfoVO();
			BeanUtils.copyProperties(appliMtgInfo, appliMtgInfoVO);
			// 填充质押合同号
			appliMtgInfoVO.setSlaveContno(appBaseInfo.getSlaveContno());
			bPbcMtgStockDtlService.addTblMortgageStockInfoByAppliInfo(appliMtgInfoVO, storDeliInfoId, ScfBasConstant.MORT_BIZ_TYPE_PLEDGE_IN,
					ScfBasConstant.STOR_DELI_BIZ_TYPE_PLEDGE, appBaseInfo.getSupplyChainPdId());
		}
		// 押品流水查询无需查询调价流水，出质入库核价旨在确定价格 modify by changhao.huang 2013-8-21 begin
		/*
		 * //6、写入调价流水信息---总表 TblMortgageStorDeliInfo tblMortgageStorDeliInfo=new
		 * TblMortgageStorDeliInfo();
		 * tblMortgageStorDeliInfo.setAppno(appno);//申请编号
		 * tblMortgageStorDeliInfo.setTxdate(DateUtil.getDate());
		 * tblMortgageStorDeliInfo.setTxtime(DateUtil.getDate());
		 * tblMortgageStorDeliInfo.setTlrcd(appBaseInfo.getStartTlrcd());
		 * tblMortgageStorDeliInfo.setStorDeliBizType(SCFConstants.
		 * STOR_DELI_BIZ_TYPE_ADJUST_PRICE);//阶段性调价
		 * tblMortgageStorDeliInfo.setBussType(appBaseInfo.getSupplyChainPdId())
		 * ;//产品类型
		 * tblMortgageStorDeliInfo.setStorOrDeli(SCFConstants.STOR_OR_DELI_CHECK
		 * );//类型 tblMortgageStorDeliInfo.setCurcd(appBaseInfo.getCurcd());//币种
		 * //监管协议号保存 before：appBaseInfo.getProtocolNo()
		 * tblMortgageStorDeliInfo.setMonitorProtocolNo(appBaseInfo.
		 * getOtherProtocolNo());//监管协议号
		 * tblMortgageStorDeliInfo.setOtherProtocolNo(appBaseInfo.getBusinessno(
		 * ));//阶段性协议 String fid=DAOUtils.getTblMortgageStorDeliInfoDAO().save(
		 * tblMortgageStorDeliInfo);
		 * 
		 * //7、写入调价流水信息---明细表 for (int i = 0; i < appMorgInfoList.size(); i++) {
		 * TblAppliMortgageBaseInfo appliMortgageBaseInfo =
		 * (TblAppliMortgageBaseInfo)appMorgInfoList.get(i); //流水明细表
		 * TblMortgageStockInfo tblMortgageStockInfo=new TblMortgageStockInfo();
		 * CommonFunction.copyProperties(tblMortgageStockInfo,
		 * appliMortgageBaseInfo); //参与调价的数量 BigDecimal quantity =
		 * appliMortgageBaseInfo.getQuantity(); //调整单价 BigDecimal price =
		 * appliMortgageBaseInfo.getPrice();
		 * 
		 * tblMortgageStockInfo.setOldConfirmPrice(appliMortgageBaseInfo.
		 * getOriginalPrice());//原始核定价
		 * tblMortgageStockInfo.setConfirmPrice(appliMortgageBaseInfo.
		 * getConfirmPrice());//核定价
		 * tblMortgageStockInfo.setOriginalTotPrice(quantity.multiply(
		 * appliMortgageBaseInfo.getOriginalPrice()));//原始总价
		 * tblMortgageStockInfo.setTotPrice(quantity.multiply(
		 * appliMortgageBaseInfo.getConfirmPrice()));//总价
		 * tblMortgageStockInfo.setBussType(SCFConstants.
		 * MORT_BIZ_TYPE_ADJUST_PRICE);//业务类型
		 * tblMortgageStockInfo.setType(SCFConstants.STOR_DELI_BIZ_TYPE_CHANGE);
		 * tblMortgageStockInfo.setSupplyChainPdId(appBaseInfo.
		 * getSupplyChainPdId());//产品类型 tblMortgageStockInfo.setPid(fid);
		 * tblMortgageStockInfo.setId(null);
		 * DAOUtils.getTblMortgageStockInfoDAO().save(tblMortgageStockInfo);
		 * //押品历史表 TblMortgageBaseInfoHis tblMortgageBaseInfoHis=new
		 * TblMortgageBaseInfoHis();
		 * CommonFunction.copyProperties(tblMortgageBaseInfoHis,
		 * appliMortgageBaseInfo);
		 * tblMortgageBaseInfoHis.setOldConfirmPrice(appliMortgageBaseInfo.
		 * getOriginalPrice()); tblMortgageBaseInfoHis.setId(null);
		 * DAOUtils.getTblMortgageBaseInfoHisDAO().save(tblMortgageBaseInfoHis);
		 * }
		 */
		// modify by changhao.huang 2013-8-21 end
		// 8、操作押品---押品正式表写入

		for (int i = 0; i < appMorgInfoList.size(); i++) {
			BPbcAppliMtgInfo bPbcAppliMtgInfo = (BPbcAppliMtgInfo) appMorgInfoList.get(i);
			// 押品申请表设置质押合同信息
			bPbcAppliMtgInfo.setSlaveContno(appBaseInfo.getSlaveContno());
			// 记押品基础信息表
			this.addMortgageBaseInfoByAppliInfo(bPbcAppliMtgInfo, appBaseInfo);
		}

		// 先票/款后货协议的更新提到发货通知录入时更新 modify by changhao.huang 2013-9-3

		/*
		 * //8、更新协议已出质金额 TblMutiProtDealInfoDAO
		 * tblMutiProtDealInfoDao=DAOUtils.getTblMutiProtDealInfoDAO();
		 * BigDecimal amountIn = new BigDecimal("0"); for (int i = 0; i <
		 * appMorgInfoList.size(); i++) { TblAppliMortgageBaseInfo
		 * appliMortgageBaseInfo =
		 * (TblAppliMortgageBaseInfo)appMorgInfoList.get(i); amountIn =
		 * amountIn.add(appliMortgageBaseInfo.getOriginalTotPrice());
		 * 
		 * } //获得协议 if(!SCFStringUtil.isEmpty(appBaseInfo.getBusinessno())){
		 * TblMutiProtDealInfo tblMutiProtDealInfo =
		 * tblMutiProtDealInfoDao.get(appBaseInfo.getBusinessno());
		 * if(tblMutiProtDealInfo!=null){ BigDecimal amount =
		 * (tblMutiProtDealInfo.getPledgeAmt()==null?new
		 * BigDecimal("0"):tblMutiProtDealInfo.getPledgeAmt()).add(amountIn);
		 * tblMutiProtDealInfo.setPledgeAmt(amount);//累计已发货金额
		 * tblMutiProtDealInfoDao.update(tblMutiProtDealInfo); } }
		 */
	}

	/**
	 * 押品基础信息
	 * 
	 * @param appliMortgageBaseInfo
	 * @param appBaseInfo
	 * @throws ScubeBizException
	 */
	@Transactional
	public void addMortgageBaseInfoByAppliInfo(BPbcAppliMtgInfo appliMortgageBaseInfo, BPbcAppliBaseInfo appBaseInfo) throws ScubeBizException {
		// 判断是更新还是新增
		BPbcMtgBaseInfo bPbcMtgBaseInfo = this.findBPbcMtgBaseInfoByKey(appliMortgageBaseInfo.getMortgageNo());
		UserInfo user = ContextHolder.getUserInfo();
		if (bPbcMtgBaseInfo == null) {// 新增
			BPbcMtgBaseInfo morgInfo = new BPbcMtgBaseInfo(); // 目标对象
			BeanUtils.copyProperties(appliMortgageBaseInfo, morgInfo);
			morgInfo.setTradeContno(appliMortgageBaseInfo.getTradeContno());
			morgInfo.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL); // 存货库存状态
			morgInfo.setFirstAppno(appBaseInfo.getAppno());// 首次入库编号
			morgInfo.setFirstStorageDate(ScfDateUtil.formatDate(new Date())); // 首次入库日期
			morgInfo.setOriginalPrice(appliMortgageBaseInfo.getPrice()); // 原始单价
			morgInfo.setOriginalTotPrice(appliMortgageBaseInfo.getTotPrice()); // 原始总价
			morgInfo.setLastUpdTlrcd(user.getTlrNo()); // 最后修改人
			morgInfo.setLastUpdTime(new Date()); // 最后修改日期
			morgInfo.setSupplyChainPdId(appBaseInfo.getSupplyChainPdId());// 产品ID
			morgInfo.setSlaveContno(appBaseInfo.getSlaveContno());// 抵质押合同
			morgInfo.setOtherProtocolNo(appBaseInfo.getBusinessno());// 四方协议
			// 监管协议号保存 before：appBaseInfo.getProtocolNo()
			morgInfo.setMonitorProtocolNo(appBaseInfo.getOtherProtocolNo());// 监管协议
			// 存入监管公司客户号
			String moniCustcd = bCntMprotBaseInfoService.getMoniCustcdByMoniProtocolNo(appBaseInfo.getOtherProtocolNo());
			if (StringUtil.isStrNotEmpty(moniCustcd)) {
				morgInfo.setMoniOfCustcd(moniCustcd);
			}
			morgInfo.setBrcode(appBaseInfo.getStartBrcode());// 押品机构信息
			// 保存时需存入客户号CUSTCD
			morgInfo.setCustcd(appBaseInfo.getCustcd());
			if (appliMortgageBaseInfo.getMemo() != null) {
				morgInfo.setExt1(appliMortgageBaseInfo.getMemo());
			} else {
				if (StringUtil.isEmpty(appliMortgageBaseInfo.getMonitorProtocolNo())) {

					morgInfo.setExt1(ScfBasConstant.MORTGAGE_STATUS_UNSALE);// 出质入库时押品属于未销售状态(三方汽车金融，后面会在汽车销售登记中将状态改为
																			// MORTGAGE_STATUS_UNPAID
																			// =“未还款”)
				} else {
					morgInfo.setExt1(ScfBasConstant.MORTGAGE_STATUS_SALED);// 出质入库时押品属于未还款状态(四方汽车金融）
				}
			}
			morgInfo.setExt2(appliMortgageBaseInfo.getConfirmAccording());// 出厂日期
			this.addBPbcMtgBaseInfo(morgInfo);
		} else {// 更新
			BeanUtils.copyProperties(appliMortgageBaseInfo, bPbcMtgBaseInfo);
			bPbcMtgBaseInfo.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL); // 存货库存状态
			bPbcMtgBaseInfo.setLastUpdTlrcd(user.getTlrNo()); // 最后修改人
			bPbcMtgBaseInfo.setLastUpdTime(new Date()); // 最后修改日期
			bPbcMtgBaseInfo.setSlaveContno(appBaseInfo.getSlaveContno());// 抵质押合同
			bPbcMtgBaseInfo.setOtherProtocolNo(appBaseInfo.getBusinessno());// 四方协议
			bPbcMtgBaseInfo.setMonitorProtocolNo(appBaseInfo.getProtocolNo());// 监管协议
			bPbcMtgBaseInfo.setSupplyChainPdId(appBaseInfo.getSupplyChainPdId());// 产品ID
			bPbcMtgBaseInfo.setExt1(appliMortgageBaseInfo.getMemo());
			this.updateBPbcMtgBaseInfo(bPbcMtgBaseInfo);
		}
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public void addMortgageBaseInfoByAppli(BPbcAppliMtgInfo appliMortgageBaseInfo, BPbcAppliBaseInfo appBaseInfo) throws ScubeBizException {
		// 判断是更新还是新增
		BPbcMtgBaseInfo bPbcMtgBaseInfo = this.findBPbcMtgBaseInfoByKey(appliMortgageBaseInfo.getMortgageNo());
		UserInfo user = ContextHolder.getUserInfo();
		if (bPbcMtgBaseInfo == null) {// 新增
			BPbcMtgBaseInfo morgInfo = new BPbcMtgBaseInfo(); // 目标对象
			BeanUtils.copyProperties(appliMortgageBaseInfo, morgInfo);
			morgInfo.setTradeContno(appliMortgageBaseInfo.getTradeContno());
			morgInfo.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL); // 存货库存状态
			morgInfo.setFirstAppno(appBaseInfo.getAppno());// 首次入库编号
			morgInfo.setFirstStorageDate(ScfDateUtil.formatDate(new Date())); // 首次入库日期
			morgInfo.setOriginalPrice(appliMortgageBaseInfo.getPrice()); // 原始单价
			morgInfo.setOriginalTotPrice(appliMortgageBaseInfo.getTotPrice()); // 原始总价
			morgInfo.setLastUpdTlrcd(user.getTlrNo()); // 最后修改人
			morgInfo.setLastUpdTime(new Date()); // 最后修改日期
			morgInfo.setSupplyChainPdId(appBaseInfo.getSupplyChainPdId());// 产品ID
			morgInfo.setSlaveContno(appBaseInfo.getSlaveContno());// 抵质押合同
			morgInfo.setOtherProtocolNo(appBaseInfo.getBusinessno());// 四方协议
			// 监管协议号保存 before：appBaseInfo.getProtocolNo()
			morgInfo.setMonitorProtocolNo(appBaseInfo.getOtherProtocolNo());// 监管协议
			// 存入监管公司客户号
			String moniCustcd = bCntMprotBaseInfoService.getMoniCustcdByMoniProtocolNo(appBaseInfo.getOtherProtocolNo());
			if (StringUtil.isStrNotEmpty(moniCustcd)) {
				morgInfo.setMoniOfCustcd(moniCustcd);
			}
			morgInfo.setBrcode(appBaseInfo.getStartBrcode());// 押品机构信息
			// 保存时需存入客户号CUSTCD
			morgInfo.setCustcd(appBaseInfo.getCustcd());
			if (appliMortgageBaseInfo.getMemo() != null) {
				morgInfo.setExt1(appliMortgageBaseInfo.getMemo());
			} else {
				if (StringUtil.isEmpty(appliMortgageBaseInfo.getMonitorProtocolNo())) {

					morgInfo.setExt1(ScfBasConstant.MORTGAGE_STATUS_UNSALE);// 出质入库时押品属于未销售状态(三方汽车金融，后面会在汽车销售登记中将状态改为
																			// MORTGAGE_STATUS_UNPAID
																			// =“未还款”)
				} else {
					morgInfo.setExt1(ScfBasConstant.MORTGAGE_STATUS_SALED);// 出质入库时押品属于未还款状态(四方汽车金融）
				}
			}
			morgInfo.setExt2(appliMortgageBaseInfo.getConfirmAccording());// 出厂日期
			this.addBPbcMtgBaseInfo(morgInfo);
		} else {// 与上方方法不一样的地方主要是在转让出质状态等数据修改的不同
			BeanUtils.copyProperties(appliMortgageBaseInfo, bPbcMtgBaseInfo);
			bPbcMtgBaseInfo.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL); // 存货库存状态
			bPbcMtgBaseInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo()); // 最后修改人
			bPbcMtgBaseInfo.setLastUpdTime(new Date()); // 最后修改日期
			bPbcMtgBaseInfo.setSupplyChainPdId(appBaseInfo.getSupplyChainPdId());// 产品ID
			bPbcMtgBaseInfo.setExt1(appliMortgageBaseInfo.getMemo());
			BigDecimal confirmPrice = bPbcMtgBaseInfo.getConfirmPrice();
			if (confirmPrice.compareTo(new BigDecimal(0)) == 0) {
				throw new ScubeBizException("出质入库失败！");
			}
			BigDecimal totalPrice = confirmPrice.multiply(bPbcMtgBaseInfo.getInvQuantity());
			bPbcMtgBaseInfo.setTotPrice(totalPrice);// 总金额为核定单价与原始数量乘积
			bPbcMtgBaseInfo.setOriginalTotPrice(new BigDecimal(0));
			bPbcMtgBaseInfo.setQuantity(bPbcMtgBaseInfo.getInvQuantity());// 出质数量为原来未出质数量
			bPbcMtgBaseInfo.setInvQuantity(new BigDecimal(0)); // 未出质的数量置为0；
			bPbcMtgBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
			bPbcMtgBaseInfo.setExt3(ScfBasConstant.MORT_STATUS_PLEDGED);// 已出质
			bPbcMtgBaseInfo.setLockAppno(null);
			this.updateBPbcMtgBaseInfo(bPbcMtgBaseInfo);
		}

	}

	/**
	 * 预付类，批量调价，关联抵质押合同
	 * 
	 * @param 一级二级三级和业务种类参数
	 * @throws ScubeBizException
	 */
	@Override
	public Page getPriceAdjustSlaveContGetter(int pageNo, int pageSize, BPbcMtgBaseInfo bPbcMtgBaseInfo) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		if (bPbcMtgBaseInfo == null) {
			return page;
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		String supplyChainPdId = bPbcMtgBaseInfo.getSupplyChainPdId();
		String mortgageLevelOne = bPbcMtgBaseInfo.getMortgageLevelOne();
		String mortgageLevelTwo = bPbcMtgBaseInfo.getMortgageLevelTwo();
		String mortgageLevelThree = bPbcMtgBaseInfo.getMortgageLevelThree();
		String taskName = bPbcMtgBaseInfo.getChannelFlag();// 存储当前页面的流程名称
		map.put("supplyChainPdId", supplyChainPdId);
		map.put("mortgageLevelOne", mortgageLevelOne);
		map.put("mortgageLevelTwo", mortgageLevelTwo);
		map.put("mortgageLevelThree", mortgageLevelThree);
		if (taskName != null && !"".equals(taskName)) {
			map.put("taskName", taskName);
		} else {
			map.put("taskName", "");
		}
		extibpbcmtgbaseinfodao.getPriceAdjustSlaveContGetter(map, page);
		return page;
	}

	@Override
	public List<BPbcMtgBaseInfo> getMortgageInfoByMortgageLevels(BPbcMtgBaseInfo bPbcMtgBaseInfo) throws ScubeBizException {
		if (bPbcMtgBaseInfo == null) {
			return null;
		}
		BPbcMtgBaseInfoExample bPbcMtgBaseInfoExample = new BPbcMtgBaseInfoExample();
		Criteria criteria = bPbcMtgBaseInfoExample.createCriteria();
		if (bPbcMtgBaseInfo.getMortgageLevelOne() != null && !bPbcMtgBaseInfo.getMortgageLevelOne().equals(""))
			criteria.andMortgageLevelOneEqualTo(bPbcMtgBaseInfo.getMortgageLevelOne());
		if (bPbcMtgBaseInfo.getMortgageLevelTwo() != null && !bPbcMtgBaseInfo.getMortgageLevelTwo().equals(""))
			criteria.andMortgageLevelTwoEqualTo(bPbcMtgBaseInfo.getMortgageLevelTwo());
		if (bPbcMtgBaseInfo.getMortgageLevelThree() != null && !bPbcMtgBaseInfo.getMortgageLevelThree().equals(""))
			criteria.andMortgageLevelThreeEqualTo(bPbcMtgBaseInfo.getMortgageLevelThree());
		if (bPbcMtgBaseInfo.getJoinBatch() != null && !bPbcMtgBaseInfo.getJoinBatch().equals("")) {
			criteria.andJoinBatchEqualTo(bPbcMtgBaseInfo.getJoinBatch());
		}
		if (bPbcMtgBaseInfo.getSlaveContno() != null && !bPbcMtgBaseInfo.getSlaveContno().equals("")) {
			criteria.andSlaveContnoEqualTo(bPbcMtgBaseInfo.getSlaveContno());
		}
		if (bPbcMtgBaseInfo.getSupplyChainPdId() != null && !bPbcMtgBaseInfo.getSupplyChainPdId().equals("")) {
			criteria.andSupplyChainPdIdEqualTo(bPbcMtgBaseInfo.getSupplyChainPdId());
		}
		if (bPbcMtgBaseInfo.getMortgageNo() != null && !bPbcMtgBaseInfo.getMortgageNo().equals(""))
			criteria.andMortgageNoEqualTo(bPbcMtgBaseInfo.getMortgageNo());
		ArrayList<BPbcMtgBaseInfo> arrayList = new ArrayList<BPbcMtgBaseInfo>();
		List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo> bPbcMtgBaseInfoList = ibPbcMtgBaseInfoDAO.selectByExample(bPbcMtgBaseInfoExample);
		if (bPbcMtgBaseInfoList != null && bPbcMtgBaseInfoList.size() > 0) {
			for (com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo bPbcMtgBaseInfo1 : bPbcMtgBaseInfoList) {
				BPbcMtgBaseInfo bPbcMtgBaseInfo2 = new BPbcMtgBaseInfo();
				BeanUtils.copyProperties(bPbcMtgBaseInfo1, bPbcMtgBaseInfo2);
				arrayList.add(bPbcMtgBaseInfo2);
			}
		}
		return arrayList;
	}

	/**
	 * @Description: 押品加锁
	 * @author xiong_xiaolong
	 * @Created 2013-4-16下午3:52:04
	 * @param id
	 *            押品主键
	 * @param lockAppno
	 *            加锁业务编号
	 * @throws CommonException
	 */
	@Override
	@Transactional
	public void lockMortgageBaseInfo(String mortgageNo, String appno) throws ScubeBizException {
		try {
			com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo bPbcMtgBaseInfo = ibPbcMtgBaseInfoDAO.selectByPrimaryKey(mortgageNo);
			if (bPbcMtgBaseInfo != null) {
				bPbcMtgBaseInfo.setIsLocked(ScfBasConstant.LOCKED);
				bPbcMtgBaseInfo.setLockAppno(appno);
				ibPbcMtgBaseInfoDAO.updateByPrimaryKey(bPbcMtgBaseInfo);
			} else {
				throw new ScubeBizException("押品锁定失败！");
			}
		} catch (Exception e) {
			throw new ScubeBizException("押品锁定失败！");
		}
	}

	/**
	 * 统计质押合同下 质押仓单押品金额
	 * 
	 * @param slaveContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月26日下午1:49:59
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List calBillPledgePriceBySlaveContno(String slaveContno) {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("slaveContno", slaveContno);
		omap.put("status", ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
		List list = extibpbcmtgbaseinfodao.getEffectTotPrice(omap);
		return list;
	}

	/**
	 * 统计质押合同下 仓单所有押品金额
	 * 
	 * @param slaveContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月26日下午1:53:46
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List calBillAllPriceBySlaveContno(String slaveContno) {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("slaveContno", slaveContno);
		List<String> statusList = new ArrayList<String>();
		statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_DELIVERY);
		statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_ADJUST);
		omap.put("statusList", statusList);// not in
		List list = extibpbcmtgbaseinfodao.getEffectTotPrice(omap);
		return list;
	}

	/**
	 * 根据billno获得未锁定押品
	 * 
	 * @param mortgageQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月26日下午3:04:21
	 */
	@Override
	public Page getBillNormalUnlockedByBillno(BillNormalMortgageQryVO mortgageQryVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(mortgageQryVO.getBillno())) {
			omap.put("billno", mortgageQryVO.getBillno());
		}
		omap.put("isLocked", ScfBasConstant.UNLOCKED);
		if (!StringUtil.isEmpty(mortgageQryVO.getAppno())) {
			omap.put("lockAppno", mortgageQryVO.getAppno());
		}

		int total = extibpbcmtgbaseinfodao.countBillNormalUnlockedByBillno(omap);
		Page page = new Page(mortgageQryVO.getPageSize(), mortgageQryVO.getPageIndex(), total);
		page.setRecords(extibpbcmtgbaseinfodao.getBillNormalUnlockedByBillno(omap, page));
		return page;
	}

	/**
	 * 押品解锁
	 * 
	 * @param id
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月26日下午5:54:36
	 */
	@Override
	@Transactional
	public void releaseMortgageBaseInfo(String mortgageNo) throws ScubeBizException {
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo mortgageBaseInfo = ibPbcMtgBaseInfoDAO.selectByPrimaryKey(mortgageNo);
		if (mortgageBaseInfo != null) {
			mortgageBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
			mortgageBaseInfo.setLockAppno(null);
			try {
				ibPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(mortgageBaseInfo);
			} catch (Exception e) {
				throw new ScubeBizException("押品解锁失败！");
			}
		} else {
			throw new ScubeBizException("押品信息不存在！");
		}
	}

	/**
	 * 根据仓单号查询该仓单下批次号下临时押品表价值总和
	 * 
	 * @param billno
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月3日上午9:28:57
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getAppliReceiptPledgeAmountBybillno(String billno) {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("billno", billno);

		List list = extibpbcmtgbaseinfodao.getAppliReceiptPledgeAmountBybillno(omap);
		return list;
	}

	/**
	 * 修改被解压押品的数量
	 * 
	 * @param mortgageNo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月8日上午9:21:12
	 */
	@Override
	@Transactional
	public void resetMortQuantity(String mortgageNo) throws ScubeBizException {
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo tblMortgageBaseInfo = ibPbcMtgBaseInfoDAO.selectByPrimaryKey(mortgageNo);
		int temp = 0;
		BigDecimal Zero = new BigDecimal(temp);
		tblMortgageBaseInfo.setQuantity(Zero);
		tblMortgageBaseInfo.setTotPrice(Zero);
		ibPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(tblMortgageBaseInfo);
	}

	/**
	 * 获取抵制押合同下押品总价值
	 * 
	 * @param slaveContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月10日下午2:50:18
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BigDecimal getSumPriceByslaveContno(String slaveContno) {
		BigDecimal sumPrice = null;
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(slaveContno)) {
			omap.put("slaveContno", slaveContno);
		}

		List list = extibpbcmtgbaseinfodao.getSumPriceByslaveContno(omap);
		if (list.size() > 0) {
			Map<String, BigDecimal> map = (Map<String, BigDecimal>) list.get(0);
			sumPrice = map.get("totPrice");
		}
		if (null == sumPrice) {
			sumPrice = new BigDecimal(0.00);
		}
		return sumPrice;
	}

	/**
	 * 单表获取押品基本信息
	 * 
	 * @param billstandardQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月11日上午11:23:51
	 */
	@Override
	public Page getMortgageBaseInfoByPara(BillstandardQryVO billstandardQryVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		// 仓单编号
		if (!StringUtil.isEmpty(billstandardQryVO.getBillno())) {
			omap.put("billno", billstandardQryVO.getBillno());
		}
		if (!StringUtil.isEmpty(billstandardQryVO.getMortgageNo())) {
			omap.put("mortgageNo", billstandardQryVO.getMortgageNo());
		}

		int total = extibpbcmtgbaseinfodao.countBillstandardMortgageQuery(omap);
		Page page = new Page(billstandardQryVO.getPageSize(), billstandardQryVO.getPageIndex(), total);
		page.setRecords(extibpbcmtgbaseinfodao.getBillstandardMorgByBillno(omap, page, true));
		return page;
	}

	/**
	 * 查找从合同下押品总价
	 * 
	 * @param appliMortgageBaseQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月15日下午3:28:11
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public List getTotPriceByParam(AppliMortgageBaseQryVO appliMortgageBaseQryVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getSlaveContno())) {
			omap.put("slaveContno", appliMortgageBaseQryVO.getSlaveContno());
		}
		if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getMonitorProtocolNo())) {
			omap.put("monitorProtocolNo", appliMortgageBaseQryVO.getMonitorProtocolNo());
		}
		if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getIsSlExibition())) {
			omap.put("isSlExibition", appliMortgageBaseQryVO.getIsSlExibition());
		}
		List list = extibpbcmtgbaseinfodao.getTotPriceByParam(omap);
		return list;
	}

	/**
	 * 获取押品总价格
	 * 
	 * @param commonQueryVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月16日下午2:21:29
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BigDecimal getMortgageSumPriceByParam(MortgageSumPriceQryVO commonQueryVO) {
		BigDecimal sumPrice = BigDecimal.ZERO;
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno())) {
			omap.put("mastContno", commonQueryVO.getMastContno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getSlaveContno())) {
			omap.put("slaveContno", commonQueryVO.getSlaveContno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getMonitorProtocolNo())) {
			omap.put("monitorProtocolNo", commonQueryVO.getMonitorProtocolNo());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getOtherProtocolNo())) {
			omap.put("otherProtocolNo", commonQueryVO.getOtherProtocolNo());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getStatus())) {// 库存状态
			omap.put("stockStatus", commonQueryVO.getStatus());
		}
		List list = extibpbcmtgbaseinfodao.getMortgageSumPriceByParam(omap);
		if (list.size() > 0) {
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			sumPrice = (BigDecimal) map.get("totPrice");
		}
		return sumPrice;
	}

	/**
	 * 根据押品编号查询押品表
	 * 
	 * @param mortgageNo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月16日下午2:36:06
	 */
	@Override
	public Page queryDeliveryMortgageByMortgageNo(String mortgageNo, int pageNo, int pageSize) throws ScubeBizException {
		BPbcMtgBaseInfoExample example = new BPbcMtgBaseInfoExample();
		BPbcMtgBaseInfoExample.Criteria cri = example.createCriteria();
		List<String> mortgageNoList = new ArrayList<String>();
		if (!StringUtil.isEmpty(mortgageNo)) {
			if (mortgageNo.indexOf("/f") != -1) {
				String[] id = mortgageNo.split("/f");
				for (int i = 0; i < id.length - 1; i++) {
					mortgageNoList.add(id[i]);
				}
				if (mortgageNoList.size() > 0) {
					cri.andMortgageNoIn(mortgageNoList);
				}
			} else {
				cri.andMortgageNoEqualTo(mortgageNo);
			}
		}

		int total = ibPbcMtgBaseInfoDAO.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		BPbcMtgBaseInfoVO vo = null;
		List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo> list = ibPbcMtgBaseInfoDAO.selectByPage(example, page);
		List<BPbcMtgBaseInfoVO> result = new ArrayList<BPbcMtgBaseInfoVO>();
		if (list != null && list.size() > 0) {
			for (com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo info : list) {
				vo = new BPbcMtgBaseInfoVO();
				BeanUtils.copyProperties(info, vo);
				// 押品名称翻译
				String mortgageLevelOne = vo.getMortgageLevelOne();
				String mortgageLevelTwo = vo.getMortgageLevelTwo();
				if (StringUtil.isStrNotEmpty(mortgageLevelOne)) {
					BPbcMtgClass one = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelOne);
					vo.setMortgageLevelOneName(one.getMortgageName());
				}
				if (StringUtil.isStrNotEmpty(mortgageLevelTwo)) {
					BPbcMtgClass two = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelTwo);
					vo.setMortgageLevelTwoName(two.getMortgageName());
				}
				result.add(vo);
			}
		}
		page.setRecords(result);

		return page;
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public void releaseMortgageBaseInfoByAppno(String appno) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			throw new ScubeBizException("押品解锁失败！");
		}
		BPbcMtgBaseInfoExample bPbcMtgBaseInfoExample = new BPbcMtgBaseInfoExample();
		bPbcMtgBaseInfoExample.createCriteria().andLockAppnoEqualTo(appno);
		List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo> bPbcMtgBaseInfoList = ibPbcMtgBaseInfoDAO.selectByExample(bPbcMtgBaseInfoExample);
		if (bPbcMtgBaseInfoList != null && bPbcMtgBaseInfoList.size() > 0) {
			for (com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo bPbcMtgBaseInfo : bPbcMtgBaseInfoList) {
				bPbcMtgBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
				bPbcMtgBaseInfo.setLockAppno(null);
				try {
					ibPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(bPbcMtgBaseInfo);
				} catch (Exception e) {
					throw new ScubeBizException("押品解锁失败！");
				}
			}
		}
		return;
	}
}
