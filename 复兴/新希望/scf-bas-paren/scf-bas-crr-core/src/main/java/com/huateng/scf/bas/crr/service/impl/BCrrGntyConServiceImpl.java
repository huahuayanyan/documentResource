package com.huateng.scf.bas.crr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.model.WarnQryVO;
import com.huateng.scf.bas.cnt.dao.ext.ExtIBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.model.BCntInsuranceBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntSlaveMtgRel;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.cnt.service.IBCntInsuranceBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.cnt.service.IBCntSlaveMtgRelService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.dao.ext.ICommonQueryDAO;
import com.huateng.scf.bas.common.service.ICustomerService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyRelaDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnAppRelaDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.ext.ExtBCrrDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConExample;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConExample.Criteria;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConVO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrGntyConDetail;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.pbc.dao.IBPbcWhseInspectDAO;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * BCrrGntyCon接口实现类
 * </p>
 *
 * @author mengjiajia
 * @date 2016年11月14日下午8:29:30
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:29:30	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCrrGntyConServiceImpl")
public class BCrrGntyConServiceImpl implements IBCrrGntyConService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "orgService")
	OrgService orgService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;

	@Resource(name = "IBCrrGntyRelaDAO")
	IBCrrGntyRelaDAO bcrrgntyreladao;

	@Resource(name = "IBCrrGntyInfoDAO")
	IBCrrGntyInfoDAO bcrrgntyinfodao;

	@Resource(name = "IBCrrLnAppDAO")
	IBCrrLnAppDAO bcrrlnappdao;

	@Resource(name = "IBCrrLnAppRelaDAO")
	IBCrrLnAppRelaDAO bcrrlnappreladao;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;

	@Resource(name = "ExtBCrrDAO")
	ExtBCrrDAO extbcrrdao;

	@Resource(name = "BCntSlaveMtgRelServiceImpl")
	IBCntSlaveMtgRelService bcntslavemtgrelservice;

	@Resource(name = "BCntInsuranceBaseInfoServiceImpl")
	IBCntInsuranceBaseInfoService bcntinsurancebaseinfoservice;

	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;

	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bPbcMtgBaseInfoService;

	@Resource(name = "BPbcWhseInspectDAO")
	IBPbcWhseInspectDAO ibPbcWhseInspectDAO;
	
	@Resource(name = "commonQueryDAO")
	ICommonQueryDAO commonQueryDAO;
	/**
	 * 监管合同信息查询开始
	 */
	@Resource(name = "ExtBCntMprotBaseInfoDAO")
	ExtIBCntMprotBaseInfoDAO extIBCntMprotBaseInfoDAO;

	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bCntMprotPartInfoService;

	@Autowired
	ScubeUserService scubeUserService;
	/**
	 * 监管合同信息查询结束
	 */
	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO ibCrrDuebillAppDAO;

	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;

	// 申请基本信息表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;

	@Resource(name = "CustomerServiceImpl")
	ICustomerService customerservice;
	
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bCntMprotBaseInfoService;

	@Override
	@Transactional
	public BCrrGntyCon add(BCrrGntyCon bCrrGntyCon) {
		String conId = ibSysSerialNoService.genSerialNo("GNTY_CON_NO");
		bCrrGntyCon.setConId(conId);
		BCrrModelCommonUtil.setAddField(bCrrGntyCon);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrGntyCon bCrrGntyCondal = new com.huateng.scf.bas.crr.dao.model.BCrrGntyCon();
		try {
			BeanUtils.copyProperties(bCrrGntyCon, bCrrGntyCondal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		try {
			bcrrgntycondao.insertSelective(bCrrGntyCondal);
		} catch (BeansException e) {
			throw new ScubeBizException("插入异常");
		}
		return bCrrGntyCon;
	}

	@Override
	@Transactional
	public int update(BCrrGntyCon bCrrGntyCon) {
		BCrrModelCommonUtil.setUpdateField(bCrrGntyCon);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrGntyCon bCrrGntyCondal = new com.huateng.scf.bas.crr.dao.model.BCrrGntyCon();
		try {
			BeanUtils.copyProperties(bCrrGntyCon, bCrrGntyCondal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		if(!StringUtil.isEmpty(bCrrGntyCondal.getPrtclNo()))
		{
			BCntMprotBaseInfo baseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(bCrrGntyCondal.getPrtclNo());
			bCrrGntyCondal.setMoniMd(baseInfo.getMoniType());
		}
		int i;
		try
		{
			i = bcrrgntycondao.updateByPrimaryKeySelective(bCrrGntyCondal);
		}
		catch (BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		bcntslavemtgrelservice.add(null);
		bcntinsurancebaseinfoservice.add(null);
		return i;
	}

	@Override
	@Transactional
	public int delete(BCrrGntyCon bCrrGntyCon, HashMap<String, String> value) {
		log.info("删除信息:" + bCrrGntyCon);
		int i = 0;
		if (!bCrrGntyCon.getIsRelate().equals("02") && bCrrGntyCon.getIsRelate() != "02") {
			// 如果不是引入担保合同，则删除担保合同担保物及其关联信息
			// 根据担保合同conId获取担保物关联信息表
			List<BCrrGntyRela> relalist = bcrrgntyreladao.selectBySerialno(bCrrGntyCon.getConId());
			if (relalist.size() > 0) {
				for (BCrrGntyRela bcrrgntyrela : relalist) {
					// 获取担保物gntyId
					String gntyId = bcrrgntyrela.getRltNo();
					try {
						// 删除担保物信息
						bcrrgntyinfodao.deleteByPrimaryKey(gntyId);
					} catch (BeansException e) {
						throw new ScubeBizException("删除担保物信息异常");
					}
					try {
						// 删除担保物关联信息
						bcrrgntyreladao.deleteByRltNo(gntyId);
					} catch (BeansException e) {
						throw new ScubeBizException("删除担保关联信息异常");
					}
					try {
						// 删除担保合同信息
						i = bcrrgntycondao.deleteByPrimaryKey(bCrrGntyCon.getConId());
					} catch (BeansException e) {
						throw new ScubeBizException("删除异常");
					}
				}
			}
		}
		BCrrLnAppRelaExample example = new BCrrLnAppRelaExample();
		com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample.Criteria cri = example.createCriteria();
		cri.andSerialnoEqualTo(value.get("appId"));
		cri.andRltNoEqualTo(bCrrGntyCon.getConId());
		try {
			// 删除业务关联信息
			bcrrlnappreladao.deleteByExample(example);
		} catch (BeansException e) {
			throw new ScubeBizException("删除业务关联信息异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(List<BCrrGntyCon> list, HashMap<String, String> value) {
		log.info("批量删除开始");
		int rows = 0;
		if (list.size() > 0 && value != null && value.get("appId") != null) {
			for (BCrrGntyCon bCrrGntyCon : list) {
				rows += delete(bCrrGntyCon, value);
			}
		}
		return rows;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page findBCrrGntyConByPage(int pageNo, int pageSize, BCrrGntyCon bCrrGntyCon) {

		BCrrGntyConExample example = new BCrrGntyConExample();
		Criteria cri = example.createCriteria();

		if (bCrrGntyCon != null) {
			// 业务申请主键
			if (bCrrGntyCon.getConId() != null && bCrrGntyCon.getConId().length() > 0) {
				cri.andConIdLike("%" + bCrrGntyCon.getConId() + "%");
			}
			// 担保类型
			if (bCrrGntyCon.getGutyTyp() != null && bCrrGntyCon.getGutyTyp().length() > 0) {
				cri.andGutyTypEqualTo(bCrrGntyCon.getGutyTyp());
			}
			// 担保客户名称
			if (bCrrGntyCon.getGutNm() != null && bCrrGntyCon.getGutNm().length() > 0) {
				cri.andGutNmLike("%" + bCrrGntyCon.getGutNm() + "%");
			}
			// 担保客户ID
			if (bCrrGntyCon.getGutId() != null && bCrrGntyCon.getGutId().length() > 0) {
				cri.andGutIdEqualTo(bCrrGntyCon.getGutId());
			}
			// 最低控货价值筛选 1.业务品种，2.原最低控货价值
			if (bCrrGntyCon.getVidPrdId() != null && bCrrGntyCon.getVidPrdId().length() > 0) {
				cri.andVidPrdIdEqualTo(bCrrGntyCon.getVidPrdId());
			}
			//原最低控货价值指的是LowPriceNew这个字段，并不是LowPrice,因为LowPrice并未存任何值
			if (bCrrGntyCon.getLowPriceNew() != null) {
				cri.andLowPriceNewIsNotNull();
			}
			// 合同状态
			if (bCrrGntyCon.getConStat() != null && bCrrGntyCon.getConStat().length() > 0) {
				cri.andConStatEqualTo(bCrrGntyCon.getConStat());
			}
			// 业务合同号
			if (bCrrGntyCon.getPrtclNo() != null && bCrrGntyCon.getPrtclNo().length() > 0) {
				if (bCrrGntyCon.getPrtclNo().equals("#")) {
					cri.andPrtclNoIsNotNull();
				} else {
					cri.andPrtclNoLike(bCrrGntyCon.getPrtclNo());
				}
			}
			if (!StringUtil.isEmpty(bCrrGntyCon.getPrtclBrNm())) {
				cri.andPrtclBrNmLike("%" + bCrrGntyCon.getPrtclBrNm() + "%");
			}
		}

		example.setOrderByClause("INP_DT desc");

		int total = bcrrgntycondao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		Page result = new Page();
		result.setRecords(bcrrgntycondao.selectByPage(example, p));
		List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> listdal = result.getRecords();
		List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> list = new ArrayList<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon>();
		if (listdal.size() > 0) {
			for (com.huateng.scf.bas.crr.dao.model.BCrrGntyCon gntycon : listdal) {
				String productId = gntycon.getVidPrdId();
				String productNm = "";
				if (StringUtil.isStrNotEmpty(productId)) {
					BPrdInfo bPrdInfo = new BPrdInfo();
					bPrdInfo.setProductId(productId);
					productNm = bprdinfoservice.findBPrdInfoByKey(bPrdInfo).getProductName();
				}
				gntycon.setVidPrdNm(productNm);
				list.add(gntycon);
			}
		}

		p.setRecords(list);
		log.info("p.toString()=" + p.toString());
		return p;
	}

	@Override
	public Page findAppBCrrGntyConByPage(int pageNo, int pageSize, BCrrGntyCon bCrrGntyCon) {
		HashMap<String, String> omap = new HashMap<String, String>();
		if (bCrrGntyCon != null) {
			// 业务申请主键
			if (bCrrGntyCon.getAppId() != null && bCrrGntyCon.getAppId().length() > 0) {
				omap.put("appId", bCrrGntyCon.getAppId().trim());
			}
		}

		int total = extbcrrdao.countAppByExample(omap);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());
		p.setRecords(extbcrrdao.selectAppByPage(omap, p));
		log.info("p.toString()=" + p.toString());
		return p;
	}

	@Override
	public Page findConBCrrGntyConByPage(int pageNo, int pageSize, BCrrGntyCon bCrrGntyCon) {
		HashMap<String, String> omap = new HashMap<String, String>();
		if (bCrrGntyCon != null) {
			// 业务申请主键
			if (bCrrGntyCon.getAppId() != null && bCrrGntyCon.getAppId().length() > 0) {
				omap.put("appId", bCrrGntyCon.getAppId().trim());
			}
		}

		int total = extbcrrdao.countConByExample(omap);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());
		p.setRecords(extbcrrdao.selectConByPage(omap, p));
		log.info("p.toString()=" + p.toString());
		return p;
	}

	/**
	 * 用于待办任务以及贷款申请时查看或编辑担保合同信息
	 */
	@Override
	public BCrrGntyCon findBCrrGntyConByConId(String conId) {
		com.huateng.scf.bas.crr.dao.model.BCrrGntyCon bCrrGntyCondal = bcrrgntycondao.selectByPrimaryKey(conId);
		// VO转PO 展现层对象转换DAO层对象
		BCrrGntyCon bCrrGntyCon = new BCrrGntyCon();
		try {
			BeanUtils.copyProperties(bCrrGntyCondal, bCrrGntyCon);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		String productId = bCrrGntyCon.getVidPrdId();
		String productNm = "";
		if (StringUtil.isStrNotEmpty(productId)) {
			BPrdInfo bPrdInfo = new BPrdInfo();
			bPrdInfo.setProductId(productId);
			productNm = bprdinfoservice.findBPrdInfoByKey(bPrdInfo).getProductName();
		}
		bCrrGntyCon.setVidPrdNm(productNm);
		return bCrrGntyCon;
	}

	@Override
	public Page findBCrrGntyConRelateByPage(int pageNo, int pageSize, HashMap<String, String> value) {
		Page p = new Page();
		p = new Page(pageSize, pageNo, 0);
		// 获取当前业务引入的担保合同流水号
		BCrrLnAppRelaExample relaexample = new BCrrLnAppRelaExample();
		com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample.Criteria relacri = relaexample.createCriteria();
		relacri.andSerialnoEqualTo(value.get("appId"));
		List<BCrrLnAppRela> relalist = bcrrlnappreladao.selectByExample(relaexample);
		if (value != null && value.get("custId") != null && value.get("conTyp") != null) {
			// 业务申请人为担保人的最高额担保合同
			BCrrGntyConExample gntyexample = new BCrrGntyConExample();
			BCrrGntyConExample.Criteria gntycri = gntyexample.createCriteria();
			gntycri.andGutIdEqualTo(value.get("custId"));
			gntycri.andConTypEqualTo(value.get("conTyp"));
			gntycri.andConStatEqualTo("1");
			List<String> conIds = new ArrayList<String>();
			if (relalist.size() > 0) {
				for (BCrrLnAppRela appRela : relalist) {
					String conId = appRela.getRltNo();
					conIds.add(conId);
				}
			}
			if (conIds.size() > 0) {
				gntycri.andConIdNotIn(conIds);
			}
			gntycri.andConIdNotLike("ZY%");
			List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> gntylist = bcrrgntycondao.selectByExample(gntyexample);
			if (gntylist.size() == 0) {
				p.setRecords(null);
			} else {
				int total = bcrrgntycondao.countByExample(gntyexample);
				p = new Page(pageSize, pageNo, total);
				p.setRecords(gntylist);
			}
		} else {
			p.setRecords(null);
		}
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());
		log.info("p.toString()=" + p.toString());
		return p;
	}

	@Override
	public Page queryMonitorProtocolListByPageForGntyCon(int pageNo, int pageSize, HashMap<String, String> value) {
		Page p = new Page();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		if (StringUtil.isEmpty(value.get("productId"))) {
			throw new ScubeBizException("业务品种不能为空！");
		}
		if (value != null && StringUtil.isStrNotEmpty(value.get("productId"))) {
			String suppProductName = value.get("productId").toString().trim();// 业务品种
			value.put("suppProductName", suppProductName);
		}
		if (value != null && StringUtil.isStrNotEmpty(value.get("secName"))) {
			String secName = value.get("secName").toString().trim();// 出质人名称
			value.put("secName", secName);
		}
		if (value != null && StringUtil.isStrNotEmpty(value.get("protocolCode"))) {
			String protocolCode = value.get("protocolCode").toString().trim();// 监管合同号
			value.put("protocolCode", protocolCode);
		}
		if (value != null && StringUtil.isStrNotEmpty(value.get("state"))) {
			String state = value.get("state").toString().trim();// 合同状态
			value.put("state", state);
		}

		value.put("roleCredit", "03");
		Page resultPage = extIBCntMprotBaseInfoDAO.queryMonitorProtocolList(p, value, true);// 分页查询
		resultPage.setTotalRecord(extIBCntMprotBaseInfoDAO.countMonitorProtocolList(value));
		if (null != resultPage) {
			log.info("=====================TotalPage>>>" + resultPage.getTotalPage());
			log.info("=====================TotalRecord>>>" + resultPage.getTotalRecord());
		}

		return resultPage;
	}

	/**
	 * @author liph 现货抵押--出账申请--抵/质押品合同查询
	 */
	@Override
	@Transactional
	public BCrrGntyConDetail findGntyConInfoByAppno(String appno) {
		BCrrDuebillApp bCrrDuebillApp = ibCrrDuebillAppDAO.selectByPrimaryKey(appno);
		com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bCrrDuebillApp.getAppId());
		String vidNo = "";
		BCrrGntyConDetail bCrrGntyConDetail = new BCrrGntyConDetail();
		if (bCrrLnCon != null) {
			vidNo = bCrrLnCon.getVidNo();
			com.huateng.scf.bas.crr.dao.model.BCrrGntyCon bCrrGntyCon = bcrrgntycondao.selectByPrimaryKey(vidNo);
			if (bCrrGntyCon == null) {
				log.info("担保合同不能为空！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20032),
						BLanErrorConstant.SCF_BAS_LAN_20032);
			}
			BeanUtils.copyProperties(bCrrGntyCon, bCrrGntyConDetail);
			bCrrGntyConDetail.setCzr(bCrrGntyCon.getGutNm());
			bCrrGntyConDetail.setKhjl(bCrrGntyCon.getTlrNm());
			bCrrGntyConDetail.setJbjg(bCrrGntyCon.getBrNm());
			/*
			 * Map map = new HashMap(); map.put("conid", vidNo);
			 * List<BPbcHkDetail> list = ibPbcWhseInspectDAO.findHkInfo(map); if
			 * (list!=null&&list.size() > 0) { BPbcHkDetail bPbcHkDetail =
			 * list.get(0); bCrrGntyConDetail.setCzr(bPbcHkDetail.getCname());
			 * bCrrGntyConDetail.setKhjl(bPbcHkDetail.getTlrcd());
			 * bCrrGntyConDetail.setJbjg(bPbcHkDetail.getBrname()); }
			 */
		}
		return bCrrGntyConDetail;
	}

	/**
	 * 根据协议号查询从合同信息
	 */
	@Override
	public List<BCrrGntyCon> getContSlaveByProtocolNo(String protocolNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		BCrrGntyConExample example = new BCrrGntyConExample();
		BCrrGntyConExample.Criteria criteria = example.createCriteria();

		if (StringUtil.isStrNotEmpty(protocolNo)) {
			criteria.andPrtclNoEqualTo(protocolNo);
		}
		criteria.andConStatEqualTo("1"); // TODO
		List<BCrrGntyCon> list = new ArrayList<BCrrGntyCon>();
		BCrrGntyCon bCrrGntyCon = new BCrrGntyCon();
		List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> listdal = bcrrgntycondao.selectByExample(example);
		if (listdal != null && listdal.size() > 0) {
			for (com.huateng.scf.bas.crr.dao.model.BCrrGntyCon info : listdal) {
				BeanUtils.copyProperties(info, bCrrGntyCon);
				list.add(bCrrGntyCon);
			}
		}
		return list;
	}

	/**
	 * @Description: 查询质押合同信息
	 * @author mengjiajia
	 * @Created 2013-9-18下午2:23:41
	 * @param mastContQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getContSlaveBaseInfo(MastContQryVO mastContQryVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("conStat", "1");

		if (ScfBasConstant.FLAG_ON.equals(mastContQryVO.getFlag())) {// 若有效期校验开，则要求合同到期日不能小于当前日期
			omap.put("endDate", ScfDateUtil.getStringDate(new Date()));
		}

		if (!StringUtil.isEmpty(mastContQryVO.getCustcd())) {
			omap.put("custcd", mastContQryVO.getCustcd());
		}

		if (!StringUtil.isEmpty(mastContQryVO.getCname())) {
			omap.put("cname", mastContQryVO.getCname());
		}

		if (!StringUtil.isEmpty(mastContQryVO.getSlaveContno())) { // 从合同编号
			omap.put("slaveContno", mastContQryVO.getSlaveContno());
		}

		if (!StringUtil.isEmpty(mastContQryVO.getProtocolNo())) {// 抵/质押监管协议号
			omap.put("protocolNo", mastContQryVO.getProtocolNo());
		}

		// 增加业务品种的控制 add by fengjinfu 20130710
		if (!StringUtil.isEmpty(mastContQryVO.getSupplyChainPdId())) {
			omap.put("supplyChainPdId", mastContQryVO.getSupplyChainPdId());
		}

		if (!StringUtil.isEmpty(mastContQryVO.getMoniModel())) {// 动静态
			omap.put("moniModel", mastContQryVO.getMoniModel());
		}

		if (!StringUtil.isEmpty(mastContQryVO.getBrcode())) {
			omap.put("parentBrcode", mastContQryVO.getBrcode());
			omap.put("affiliationType", ScfBasConstant.BCTL_AFFILIATION_BELONG);
		}

		Page page = new Page(mastContQryVO.getPageSize(), mastContQryVO.getPageIndex(), 0);
		page.setRecords(extbcrrdao.getContSlaveBaseInfo(omap, page));
		page.setTotalRecord(extbcrrdao.countContSlaveBaseInfo(omap));

		return page;
	}

	/**
	 * 存货类查询抵质押合同信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrGntyCon
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月12日上午11:08:59
	 */
	@Override
	public Page findBCrrGntyConByPageForCHL(int pageNo, int pageSize, BCrrGntyCon bCrrGntyCon) {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (bCrrGntyCon != null) {
			if (bCrrGntyCon.getVidPrdId() != null && bCrrGntyCon.getVidPrdId().length() > 0) {
				omap.put("vidPrdId", bCrrGntyCon.getVidPrdId());
			}
			// 合同状态
			if (bCrrGntyCon.getConStat() != null && bCrrGntyCon.getConStat().length() > 0) {
				omap.put("conStat", bCrrGntyCon.getConStat());
			}
			// 业务申请主键
			if (bCrrGntyCon.getConId() != null && bCrrGntyCon.getConId().length() > 0) {
				omap.put("conId", bCrrGntyCon.getConId());
			}
			// 担保客户名称
			if (bCrrGntyCon.getGutNm() != null && bCrrGntyCon.getGutNm().length() > 0) {
				omap.put("gutNm", bCrrGntyCon.getGutNm());
			}
			// 担保客户ID
			if (bCrrGntyCon.getGutId() != null && bCrrGntyCon.getGutId().length() > 0) {
				omap.put("gutId", bCrrGntyCon.getGutId());
			}
			if (!StringUtil.isEmpty(bCrrGntyCon.getPrtclBrNm())) {
				omap.put("prtclBrNm", bCrrGntyCon.getPrtclBrNm());
			}
		}

		int total = extbcrrdao.countBCrrGntyConForCHL(omap);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> listdal = extbcrrdao.findBCrrGntyConForCHL(omap, p);
		List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> list = new ArrayList<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon>();
		if (listdal.size() > 0) {
			for (com.huateng.scf.bas.crr.dao.model.BCrrGntyCon gntycon : listdal) {
				String productId = gntycon.getVidPrdId();
				String productNm = "";
				if (StringUtil.isStrNotEmpty(productId)) {
					BPrdInfo bPrdInfo = new BPrdInfo();
					bPrdInfo.setProductId(productId);
					productNm = bprdinfoservice.findBPrdInfoByKey(bPrdInfo).getProductName();
				}
				gntycon.setVidPrdNm(productNm);
				list.add(gntycon);
			}
		}

		p.setRecords(list);
		log.info("p.toString()=" + p.toString());
		return p;
	}

	/**
	 * 根据出质人查询质押合同编号信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月12日上午11:08:59
	 */
	@Override
	public Page findSlaveContnoByPageForCHL(int pageNo, int pageSize, HashMap<String, Object> value) {
		if (value == null || StringUtil.isEmpty(value.get("gutId"))) {
			throw new ScubeBizException("出质人名称不能为空，请重新选择！");
		}

		int total = extbcrrdao.countSlaveContnoByPageForCHL(value);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> listdal = extbcrrdao.findSlaveContnoByPageForCHL(value, p);
		List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> list = new ArrayList<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon>();
		if (listdal.size() > 0) {
			for (com.huateng.scf.bas.crr.dao.model.BCrrGntyCon gntycon : listdal) {
				String productId = gntycon.getVidPrdId();
				String productNm = "";
				if (StringUtil.isStrNotEmpty(productId)) {
					BPrdInfo bPrdInfo = new BPrdInfo();
					bPrdInfo.setProductId(productId);
					productNm = bprdinfoservice.findBPrdInfoByKey(bPrdInfo).getProductName();
				}
				gntycon.setVidPrdNm(productNm);
				list.add(gntycon);
			}
		}

		p.setRecords(list);
		log.info("p.toString()=" + p.toString());
		return p;
	}

	/*
	 * 预付类 抵/质押合同页面查询方法
	 * 
	 */
	@Override
	public Page getSlaveContList(int pageNo, int pageSize, BCrrGntyCon bCrrGntyCon, String sqlId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Page scfPage = new Page(pageSize, pageNo, 0);
		if (null != bCrrGntyCon) {
			String conId = bCrrGntyCon.getConId();// 抵/质押合同号
			String gutNm = bCrrGntyCon.getGutNm();// 出质人名称
			String gutId = bCrrGntyCon.getGutId();// 出质人客户号
			String vidPrdId = bCrrGntyCon.getVidPrdId();// 业务品种
			String prtclBrNm = bCrrGntyCon.getPrtclBrNm();// 监管公司名称

			String strtDtFrom = bCrrGntyCon.getStrtDtFrom();// 合同生效日从
			String strtDtTo = bCrrGntyCon.getStrtDtTo();// 合同生效日到
			String conTyp = bCrrGntyCon.getConTyp();// 担保类型

			if (StringUtil.isStrNotEmpty(conId)) {
				map.put("conId", conId);
			}
			if (StringUtil.isStrNotEmpty(gutNm)) {
				map.put("gutNm", gutNm);
			}
			if (StringUtil.isStrNotEmpty(gutId)) {
				map.put("gutId", gutId);
			}
			if (StringUtil.isStrNotEmpty(vidPrdId)) {
				map.put("vidPrdId", vidPrdId);
			}
			if (StringUtil.isStrNotEmpty(prtclBrNm)) {
				map.put("prtclBrNm", prtclBrNm);
			}
			if (StringUtil.isStrNotEmpty(strtDtFrom)) {
				map.put("strtDtFrom", strtDtFrom);
			}
			if (StringUtil.isStrNotEmpty(strtDtTo)) {
				map.put("strtDtTo", strtDtTo);
			}
			if (StringUtil.isStrNotEmpty(conTyp)) {
				map.put("conTyp", conTyp);
			}
			if(StringUtil.isStrNotEmpty(bCrrGntyCon.getBrCd()))
				map.put("brcode", bCrrGntyCon.getBrCd());
		}
		try {
			if(StringUtil.isStrNotEmpty(sqlId)){
				commonQueryDAO.selectByPage(sqlId, map, scfPage);
			}else{
				bcrrgntycondao.getSlaveContList(map, scfPage);// 分页查询
			}
		} catch (Exception e) {
			throw new ScubeBizException("抵/质押合同分页条件查询失败!");
		}
		return scfPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 */
	@Override
	@Transactional
	public BCrrGntyCon addGntyConAndMortAndInsu(List<BCntSlaveMtgRel> bCntSlaveMtgRel, List<BCntInsuranceBaseInfo> bCntInsuranceBaseInfo,
			BCrrGntyCon bCrrGntyCon) throws ScubeBizException {
		// 1.数据校验
		if (bCrrGntyCon == null) {
			throw new ScubeBizException("所传参数无效！");
		}
		// 2.查选对应的监管合同有没有被关联
		if (bCrrGntyCon.getPrtclNo() == null || "".equals(bCrrGntyCon.getPrtclNo())) {
			throw new ScubeBizException("所传参数无效！");
		} else {
			BCrrGntyConExample bCrrGntyConExample = new BCrrGntyConExample();
			bCrrGntyConExample.createCriteria().andPrtclNoEqualTo(bCrrGntyCon.getPrtclNo());
			List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> bCrrGntyConList = bcrrgntycondao.selectByExample(bCrrGntyConExample);
			if (bCrrGntyConList != null && bCrrGntyConList.size() > 0) {
				throw new ScubeBizException("该监管合同已被关联，请重新选择监管合同号！");
			}
		}
		// 3.新增操作
		// 抵/质押合同信息
		String conId = ibSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_ZY_CONT_NO);
		bCrrGntyCon.setConId(conId);
		BCrrModelCommonUtil.setAddField(bCrrGntyCon);
		bCrrGntyCon.setMoniMd("2");// 默认静态
		com.huateng.scf.bas.crr.dao.model.BCrrGntyCon bCrrGntyCondal = new com.huateng.scf.bas.crr.dao.model.BCrrGntyCon();
		BeanUtils.copyProperties(bCrrGntyCon, bCrrGntyCondal);
		try {
			bcrrgntycondao.insert(bCrrGntyCondal);
		} catch (BeansException e) {
			log.debug(e.getMessage());
			throw new ScubeBizException("抵/质押合同信息新增失败！");
		}
		// 押品信息
		if (bCntSlaveMtgRel != null && bCntSlaveMtgRel.size() > 0) {
			bcntslavemtgrelservice.batchAddSlaveMtgRel(bCntSlaveMtgRel, conId);
		}
		// 合同下保险信息
		if (bCntInsuranceBaseInfo != null && bCntInsuranceBaseInfo.size() > 0) {
			bcntinsurancebaseinfoservice.batchAddBCntInsurance(bCntInsuranceBaseInfo, conId);
		}
		return bCrrGntyCon;
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public BCrrGntyCon updateGntyConAndMortAndInsu(List<BCntSlaveMtgRel> bCntSlaveMtgRel, List<BCntInsuranceBaseInfo> bCntInsuranceBaseInfo,
			BCrrGntyCon bCrrGntyCon) throws ScubeBizException {
		// 1.校验数据
		if (bCrrGntyCon == null || bCrrGntyCon.getConId() == null) {
			throw new ScubeBizException("所传参数无效！");
		}
		// 2.查选对应的监管合同有没有被关联
		if (bCrrGntyCon.getPrtclNo() == null || "".equals(bCrrGntyCon.getPrtclNo())) {
			throw new ScubeBizException("所传参数无效！");
		} else {
			BCrrGntyConExample bCrrGntyConExample = new BCrrGntyConExample();
			bCrrGntyConExample.createCriteria().andPrtclNoEqualTo(bCrrGntyCon.getPrtclNo());
			List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> bCrrGntyConList = bcrrgntycondao.selectByExample(bCrrGntyConExample);
			// 已经被关联的合同不是本合同才提示已经被关联了，如果是本合同是可以修改的
			if (bCrrGntyConList != null && bCrrGntyConList.size() == 1 && !(bCrrGntyConList.get(0).getConId().equals(bCrrGntyCon.getConId()))) {
				throw new ScubeBizException("该监管合同已被关联，请重新选择监管合同号！");
			} else if (bCrrGntyConList != null && bCrrGntyConList.size() > 1) {
				throw new ScubeBizException("该监管合同已被关联，请重新选择监管合同号！");
			}
		}
		// 3.修改数据
		com.huateng.scf.bas.crr.dao.model.BCrrGntyCon bCrrGntyCondal = new com.huateng.scf.bas.crr.dao.model.BCrrGntyCon();
		BeanUtils.copyProperties(bCrrGntyCon, bCrrGntyCondal);
		try {
			bcrrgntycondao.updateByPrimaryKey(bCrrGntyCondal);
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException("抵/质押合同信息修改失败！");
		}
		// 押品信息（先删除原有的，后新增）
		String slaveContno = bCrrGntyCon.getConId();
		bcntslavemtgrelservice.deleteMtgRelBySlaveContno(slaveContno);
		if (bCntSlaveMtgRel != null && bCntSlaveMtgRel.size() > 0) {
			bcntslavemtgrelservice.batchAddSlaveMtgRel(bCntSlaveMtgRel, slaveContno);
		}
		// 合同下保险信息（先删除原有的，后新增）
		bcntinsurancebaseinfoservice.deleteInsuranceBySlaveContno(slaveContno);
		if (bCntInsuranceBaseInfo != null && bCntInsuranceBaseInfo.size() > 0) {
			bcntinsurancebaseinfoservice.batchAddBCntInsurance(bCntInsuranceBaseInfo, slaveContno);
		}
		return bCrrGntyCon;
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public BCrrGntyCon deleteGntyConAndMortAndInsu(String conId) throws ScubeBizException {
		// 1.删除前校验
		// 1.1关联监管合同的不可删除 "该质押合同已关联监管合同，不能进行删除操作!"（前台页面已经校验）
		// 1.2关联申请任务的不可删除 "该质押合同已发生出质业务，不能进行删除操作!"
		int SlaveContnoNum = bPbcAppliBaseInfoService.getListBySlaveContno(conId);
		if (SlaveContnoNum > 0) {
			throw new ScubeBizException("该质押合同已发生出质业务，不能进行删除操作!");
		}
		// 1.3"该质押合同已录入押品，请先删除关联的货物信息!"
		BCntSlaveMtgRel bCntSlaveMtgRel = new BCntSlaveMtgRel();
		bCntSlaveMtgRel.setSlaveContno(conId);
		Page findBPbcMtgClassForMortage = bcntslavemtgrelservice.findBPbcMtgClassForMortage(1, 10, bCntSlaveMtgRel);
		if (findBPbcMtgClassForMortage.getRecords() != null && findBPbcMtgClassForMortage.getRecords().size() > 0) {
			throw new ScubeBizException("该质押合同已录入押品，请先删除关联的货物信息!");
		}
		// 2.数据删除
		bcrrgntycondao.deleteByPrimaryKey(conId);
		return null;
	}

	/*
	 * 预付类价值管理-跌价补偿-查询待补偿合同列表
	 */
	@Override
	public Page getWarnDropCtlInfoByParamForCompensate(int pageNo, int pageSize, WarnQryVO warnQryVO) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (warnQryVO != null) {
			String slaveContcode = warnQryVO.getSlaveContcode_Q();// 抵/质押合同
			String paramId = warnQryVO.getParamId_Q();// 预警编号
			String cname = warnQryVO.getCname_Q();// 出质人名称
			String vidPrdId = warnQryVO.getBussType_Q();// 业务品种
			map.put("slaveContcode", slaveContcode);
			map.put("paramId", vidPrdId + paramId);
			map.put("cname", cname);
			map.put("vidPrdId", vidPrdId);
		}
		List<BCrrGntyConVO> bCrrGntyConVOList = bcrrgntycondao.getWarnDropCtlInfoByParamForCompensate(map, page);
		for (BCrrGntyConVO bCrrGntyConVO1 : bCrrGntyConVOList) {
			// 1.监管公司名称翻译(兼客户号)
			String moniCname = bCntMprotPartInfoService.findCnameByProAndRole(bCrrGntyConVO1.getPrtclNo(), "02", "CNAME");
			String moniCustcd = bCntMprotPartInfoService.findCnameByProAndRole(bCrrGntyConVO1.getPrtclNo(), "02", "CUSTCD");
			bCrrGntyConVO1.setMoniCname(moniCname);
			bCrrGntyConVO1.setMoniCustcd(moniCustcd);
			// 2.押品总价值计算(根据抵质押合同号查询对应押品信息，计算押品总价值。实际上预警跌价信息表中应该有对应信息，但是老代码没有用这种方法。)
			List<BPbcMtgBaseInfo> bPbcMtgBaseInfoList = bPbcMtgBaseInfoService.findBPbcMtgBaseInfoBySlaveContno(bCrrGntyConVO1.getConId());
			BigDecimal mortAmt = new BigDecimal(0);
			if (bPbcMtgBaseInfoList != null && bPbcMtgBaseInfoList.size() > 0) {
				for (BPbcMtgBaseInfo bPbcMtgBaseInfo : bPbcMtgBaseInfoList) {
					BigDecimal totPrice = bPbcMtgBaseInfo.getTotPrice() == null ? BigDecimal.ZERO : bPbcMtgBaseInfo.getTotPrice();
					mortAmt = mortAmt.add(totPrice);
				}
			}
			bCrrGntyConVO1.setMortAmt(mortAmt);
			// 3.价值差额计算 mortBalance
			BigDecimal mortBalance = new BigDecimal(0);
			if (bCrrGntyConVO1.getMoniMd() != null && !"".equals(bCrrGntyConVO1.getMoniMd())) {
				if (ScfBasConstant.MONI_MODEL_DYNAMIC.equals(bCrrGntyConVO1.getMoniMd())) {
					// 动态：价值差额 = 当前最低控货价值 - 货物总价值
					if (bCrrGntyConVO1.getLowPriceNew() == null) {
						bCrrGntyConVO1.setLowPriceNew(new BigDecimal(0));
					}
					mortBalance = bCrrGntyConVO1.getLowPriceNew().subtract(bCrrGntyConVO1.getMortAmt());
				} else if (ScfBasConstant.MONI_MODEL_STATIC.equals(bCrrGntyConVO1.getMoniMd())) {
					BigDecimal diffAmount = new BigDecimal(0);
					// 静态：价值差额 = 敞口余额/质押率 – 货物总价值
					if (bCrrGntyConVO1.getRation() == null || bCrrGntyConVO1.getRation().compareTo(new BigDecimal(0)) == 0
							|| bCrrGntyConVO1.getRiskBal() == null || bCrrGntyConVO1.getRiskBal().compareTo(new BigDecimal(0)) == 0) {
						diffAmount = new BigDecimal(0);
					} else {
						diffAmount = bCrrGntyConVO1.getRiskBal().multiply(new BigDecimal("100.00")).divide(bCrrGntyConVO1.getRation(), 2,
								java.math.BigDecimal.ROUND_HALF_UP);
					}
					mortBalance = diffAmount.subtract(bCrrGntyConVO1.getMortAmt());
				}
			}
			bCrrGntyConVO1.setMortBalance(mortBalance);
			// 4.页面字段转译
			if (bCrrGntyConVO1.getTlrNo() != null && !"".equals(bCrrGntyConVO1.getTlrNo())) {
				// 翻译，创建人tlrcd，经办机构brcode，
				UserInfo userInfo1 = new UserInfo();
				userInfo1.setTlrNo(bCrrGntyConVO1.getTlrNo());// 搜索创建人对应的名称。
				List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
				if (userList != null && userList.size() == 1) {
					bCrrGntyConVO1.setTlrNm(userList.get(0).getTlrName());
				}
			}
			if (bCrrGntyConVO1.getBrCd() != null && !"".equals(bCrrGntyConVO1.getBrCd())) {
				// 经办机构brName
				BctlVO bctlVO = new BctlVO();
				bctlVO.setBrNo(bCrrGntyConVO1.getBrCd());
				List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
				if (bctlVOList != null && bctlVOList.size() == 1) {
					bCrrGntyConVO1.setBrNm(bctlVOList.get(0).getBrName());
				}
			}
		}
		page.setRecords(bCrrGntyConVOList);
		return page;
	}

	/**
	 * 查询抵质押合同列表
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月10日上午11:21:15
	 */
	@Override
	public Page getSlaveContList2(ContSlaveQryVO contSlaveQryVO) throws ScubeBizException {
		List<String> custcdList = new ArrayList<String>();
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("role", ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		if (!StringUtil.isEmpty(contSlaveQryVO.getCustcd())) {
			omap.put("custcd", contSlaveQryVO.getCustcd());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getCname())) {
			omap.put("cname", contSlaveQryVO.getCname());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getSlaveContno())) { // 从合同编号
			omap.put("slaveContno", contSlaveQryVO.getSlaveContno());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getMastContno())) { // 主合同号
			omap.put("mastContno", contSlaveQryVO.getMastContno());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getSlaveContcode_Q())) {
			omap.put("slaveContcode", contSlaveQryVO.getSlaveContcode_Q());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getSupplyChainPdId_Q())) {
			omap.put("supplyChainPdId", contSlaveQryVO.getSupplyChainPdId_Q());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getMoniCname_Q())) {
			omap.put("monicname", contSlaveQryVO.getMoniCname_Q());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getAssureType_Q())) {
			omap.put("assureType", contSlaveQryVO.getAssureType_Q());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getBrName_Q())) {
			omap.put("brname", contSlaveQryVO.getBrName_Q());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getStartDate1_Q())) { // 开始日期
			omap.put("startDate", contSlaveQryVO.getStartDate1_Q());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getStartDate2_Q())) { // 发票登记日期
			omap.put("endDate", contSlaveQryVO.getStartDate2_Q());
		}

		if (!StringUtil.isEmpty(contSlaveQryVO.getProtocolCode())) {
			omap.put("protocolCode", contSlaveQryVO.getProtocolCode());
		}

		String tlrno = ContextHolder.getUserInfo().getTlrNo();
		String brno = ContextHolder.getOrgInfo().getBrNo();
		// 增加合同隶属客户经理条件限制 add by xiaolong.xiong 2012-11-05
		if (ScfBasConstant.QUERY_TYPE_SELF.equals(contSlaveQryVO.getFlag())) {
			omap.put("mgrno", tlrno);
		}

		// 综合查询时采用机构过滤 add by xiaolong.xiong 2012-11-07
		if (ScfBasConstant.QUERY_TYPE_ALL.equals(contSlaveQryVO.getFlag())) {
			omap.put("parentBrcode", brno);
			omap.put("affiliationType", ScfBasConstant.BCTL_AFFILIATION_BELONG);
		}

		// 抵质押合同管理时，合同对所有管理客户可见 add by xiaolong.xiong 2013-04-18
		if (ScfBasConstant.QUERY_TYPE_MAG_ALL.equals(contSlaveQryVO.getFlag())) {
			custcdList = customerservice.getCustcdsQueryCondition("CSI.CUSTCD", ScfBasConstant.QUERY_TYPE_MAG_ALL,
					ContextHolder.getUserInfo().getTlrNo());
		}
		if (custcdList != null && custcdList.size() > 0) {
			omap.put("custcdList", custcdList);
		}

		int total = extbcrrdao.countSlaveContList(omap);
		Page page = new Page(contSlaveQryVO.getPageSize(), contSlaveQryVO.getPageIndex(), total);
		page.setRecords(extbcrrdao.getSlaveContList(omap, page));
		return page;
	}
	
	/**
	 * 保存时验证质押合同是否已被其他供应链产品抢占,未抢占则更新质押合同的产品ID
	 * @param slaveContno
	 * @param supplyChainPdId
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午4:08:01
	 */
	@Override
	public void checkUpdateSlaveContractBySupplyChainPdId(String slaveContno, String supplyChainPdId) throws ScubeBizException
	{
		com.huateng.scf.bas.crr.dao.model.BCrrGntyCon contSlaveInfo = bcrrgntycondao.selectByPrimaryKey(slaveContno);
		if(contSlaveInfo==null)
		{
			throw new ScubeBizException("合同编号为【" + slaveContno + "】的质押合同记录丢失，无法生成相关信息");
		}
		if(!StringUtil.isEmpty(contSlaveInfo.getVidPrdId()))
		{
		//	if(!supplyChainPdId.equals(contSlaveInfo.getSupplyChainPdId())){
		//		ExceptionUtil.throwCommonException("质押合同已被其他供应链产品选择!");
		//	}
		}
		else
		{
			contSlaveInfo.setVidPrdId(supplyChainPdId);
			bcrrgntycondao.updateByPrimaryKeySelective(contSlaveInfo);
		}
	}
}
