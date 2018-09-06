/**
 * 
 */
package com.huateng.scf.bas.cnt.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.huateng.authority.service.OrgService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpCostParam;
import com.huateng.scf.bas.brp.service.IBBrpCostParamService;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.cnt.dao.IBCntCostInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntDebtExtInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoExample.Criteria;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntCostInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CommonQryVO;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.constant.BCrmBaseConstants;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConExample;
import com.huateng.scf.bas.icr.constant.BIcrConstant;
import com.huateng.scf.bas.icr.dao.IBIcrBusiRelDAO;
import com.huateng.scf.bas.icr.dao.IBIcrTypeDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrBusiRel;
import com.huateng.scf.bas.icr.dao.model.BIcrType;
import com.huateng.scf.bas.icr.model.BIcrDtl;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.service.IBIcrDtlService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年11月28日下午4:54:29
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月28日下午4:54:29	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCntDebtInfoServiceImpl")
public class BCntDebtInfoServiceImpl implements IBCntDebtInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private static final String BUSINESSNO = "businessNo";
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;
	@Resource(name = "orgService")
	OrgService orgService;
	@Resource(name = "BCntDebtExtInfoDAO")
	IBCntDebtExtInfoDAO iBCntDebtExtInfoDAO;
	@Resource(name = "BCntCostInfoDAO")
	IBCntCostInfoDAO iBCntCostInfoDAO;
	@Resource(name = "BSysSerialNoServiceImpl")
	private IBSysSerialNoService bSysSerialNoService;// 流水号生成服务
	@Resource(name = "BIcrDtlServiceImpl")
	IBIcrDtlService bIcrDtlService;
	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bIcrInfoService;
	@Resource(name = IRBcpDebtPoolService.BEAN_ID)
	IRBcpDebtPoolService rBcpDebtPoolService;
	@Resource(name = IBLanLnciBaseService.BEAN_ID)
	IBLanLnciBaseService bLanLnciBaseService;
	@Resource(name = IRBcpDebtBaseInfoService.BEAN_ID)
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;

	@Resource(name = "BIcrBusiRelDAO")
	IBIcrBusiRelDAO iBIcrBusiRelDAO; // 额度业务关联
	@Resource(name = "BIcrTypeDAO")
	IBIcrTypeDAO iBIcrTypeDAO; // 额度种类DAO
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bPrdInfoDAO;
	// 存货（抵制压合同）
	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO iBCntMprotBaseInfoDAO;
	// 预付类（担保提货）
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;

	// 费用参数
	@Resource(name = IBBrpCostParamService.BEAN_ID)
	IBBrpCostParamService bBrpCostParamService;

	private static final String CNAME = "cname";
	private static final String BUYERNAME = "buyerName";
	private static final String CONTSTATUS = "contStatus";
	private static final String DEBTCONTNO = "debtContno";

	private static final String MGRNO = "mgrno";
	private static final String FINANCINGTYPE = "financingType";
	private static final String FACTTYPES = "factTypes";

	@Override
	@Transactional
	public BCntDebtInfo addBCntDebtInfo(BCntDebtInfo bCntDebtInfo) throws ScubeBizException {
		ScfCommonUtil.setCommonField(bCntDebtInfo);// 设置公共字段 a
		// 获取机构信息
		BctlVO BctlVO = ContextHolder.getOrgInfo();
		String brcode = BctlVO.getBrNo();
		bCntDebtInfo.setBrcode(brcode);
		bCntDebtInfo.setContStatus(BCntBizConstant.MAST_CONT_STATUS_VALID); // 合同状态
		// 设置业务合同号
		String debtContno = "";
		// 应收账款合同
		if (BCntBizConstant.FACT_TYPE_INLAND.equals(bCntDebtInfo.getFactType())) {// 国内保理GNBL+yyyyMMdd+5位业务号
			debtContno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YS_GNBL_CONT_NO);
		} else if (BCntBizConstant.FACT_TYPE_REVERSE.equals(bCntDebtInfo.getFactType())) {// 反向
																							// 保理合同号：FXBL+yyyyMMdd+5位业务号
			debtContno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YS_FXBL_CONT_NO);
		} else if (BCntBizConstant.FACT_TYPE_DEBT_PLEDGE.equals(bCntDebtInfo.getFactType())) {// 应收账款质押合同号：YSZY+yyyyMMdd+5位业务号
			debtContno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YS_YSZY_CONT_NO);
		}
		// 应收账款池合同
		else if (BCntBizConstant.FACT_TYPE_DEBT_POOL.equals(bCntDebtInfo.getFactType())) {// 国内池
																							// 合同号:BLC+yyyyMMdd+5位业务号
			debtContno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YS_GNBLC_CONT_NO);
		} else if (BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(bCntDebtInfo.getFactType())) {// 应收账款质押池
																									// 合同号:ZYC+yyyyMMdd+5位业务号
			debtContno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YS_YSZYC_CONT_NO);
		} else if (BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(bCntDebtInfo.getFactType())) {// 出口退税池
																										// 合同号：TSC+yyyyMMdd+5位业务号
			debtContno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YS_CKTSC_CONT_NO);
		} /*
			 * else
			 * if(BCntBizConstant.FACT_TYPE_DOUBLE_FACT.equals(bCntDebtInfo.
			 * getFactType())){//双保理 debtContno =
			 * bSysSerialNoService.genSerialNo(ScfBasConstant.
			 * BUSSNO_TYPE_FACTDOUBLECONTRACT_NO); }else
			 * if(BCntBizConstant.FACT_TYPE_LEASE_FACT.equals(bCntDebtInfo.
			 * getFactType())){//租赁保理 debtContno =
			 * bSysSerialNoService.genSerialNo(ScfBasConstant.
			 * BUSSNO_TYPE_FACTLEASECONTRACT_NO); }else
			 * if(BCntBizConstant.FACT_TYPE_CREDIT_FACT.equals(bCntDebtInfo.
			 * getFactType())){//信保 debtContno =
			 * bSysSerialNoService.genSerialNo(ScfBasConstant.
			 * BUSSNO_TYPE_FACTCREDITCONTRACT_NO); }
			 */

		bCntDebtInfo.setDebtContno(debtContno);
		com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo();
		try {
			BeanUtils.copyProperties(bCntDebtInfo, bCntDebtInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("保理合同基本信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_10000), BCntErrorConstant.SCF_BAS_CNT_10000);
		}
		try {
			iBCntDebtInfoDAO.insert(bCntDebtInfodal);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("保理合同基本信息插入异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_10001), BCntErrorConstant.SCF_BAS_CNT_10001);
		}
		return bCntDebtInfo;

	}

	@Override
	@Transactional
	public int updateBCntDebtInfo(BCntDebtInfo bCntDebtInfo) throws ScubeBizException {
		com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo();
		try {
			BeanUtils.copyProperties(bCntDebtInfo, bCntDebtInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("保理合同基本信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_10000), BCntErrorConstant.SCF_BAS_CNT_10000);
		}
		int i = 0;
		try {
			// TODO 最后更新人==
			i = iBCntDebtInfoDAO.updateByPrimaryKeySelective(bCntDebtInfodal);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("保理合同基本信息更新异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_10002), BCntErrorConstant.SCF_BAS_CNT_10002);
		}
		return i;
	}

	@Override
	@Transactional
	public int deleteBCntDebtInfo(String key) throws ScubeBizException {
		int i = 0;
		try {
			i = iBCntDebtInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("保理合同基本信息删除异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_10003), BCntErrorConstant.SCF_BAS_CNT_10003);
		}
		return i;
	}

	@Override
	@Transactional
	public int deleteByBCntDebtInfo(BCntDebtInfo bCntDebtInfo) throws ScubeBizException {
		BCntDebtInfoExample example = new BCntDebtInfoExample();
		int i = 0;
		if (bCntDebtInfo != null) {
			Criteria criteria = example.createCriteria();
			if (bCntDebtInfo.getChargeType() != null) {
				criteria.andChargeTypeEqualTo(bCntDebtInfo.getChargeType());
			}
			try {
				i = iBCntDebtInfoDAO.deleteByExample(example);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("保理合同基本信息删除异常！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_10003),
						BCntErrorConstant.SCF_BAS_CNT_10003);
			}
		}
		return i;
	}

	@Override
	public Page findBCntDebtInfoByPage(int pageNo, int pageSize, BCntDebtInfo bCntDebtInfo) throws ScubeBizException {
		BCntDebtInfoExample example = new BCntDebtInfoExample();
		Page p = new Page(pageSize, pageNo, 0);
		// 查询条件
		if (bCntDebtInfo != null) {
			Criteria criteria = example.createCriteria();
			if (bCntDebtInfo.getChargeType() != null) {
				criteria.andChargeTypeEqualTo(bCntDebtInfo.getChargeType());
			}
			p.setRecords(iBCntDebtInfoDAO.selectByPage(example, p));

		}
		return p;
	}

	/**
	 * 应收账款合同查询列表
	 */
	@Override
	public Page queryBCntDebtInfoListByPage(int pageNo, int pageSize, MastContQryVO mastContQryVO) throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();

		if (null != mastContQryVO) {
			String cname = mastContQryVO.getCname();// 卖方名称
			String buyerName = mastContQryVO.getBuyerName();// 买方名称
			String debtContno = mastContQryVO.getMastContCode();// 主合同号
			String contStatus = mastContQryVO.getConStatus();// 合同状态
			String factType = mastContQryVO.getFactType(); // 融资类型
			String financingType = mastContQryVO.getFinancingType(); // 融资模式
			String roleType = mastContQryVO.getFlag();// 客户类型
			String mgrno = "";
			List<String> factTypes = new ArrayList<String>();
			if (StringUtil.isEmpty(factType)) {
				factTypes.add(BCntBizConstant.FACT_TYPE_INLAND);// 国内保理
				factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE);// 反向保理
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);// 应收账款质押
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);// 应收账款质押池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);// 保理池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);// 出口退税池质押融资
			} else {
				if (factType.equals(BCntBizConstant.T_FINANCING_TYPE_INVOICE)) {// 应收账款融资
					factTypes.add(BCntBizConstant.FACT_TYPE_INLAND);
					factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE);
					factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);
				} else if (factType.equals(BCntBizConstant.T_FINANCING_TYPE_POOL)) {// 应收账款池融资
					factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);// 应收账款质押池融资
					factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);// 保理池融资
					factTypes.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);// 出口退税池质押融资
				}
			}
			map.put(FACTTYPES, factTypes);
			UserInfo user = ContextHolder.getUserInfo();
			if (StringUtil.isStrEmpty(roleType)) {
				String roleFlag = "0"; // 岗位标志位

				List<String> roleList = user.getRoleList();
				if (null != roleList && roleList.size() > 0) {
					for (int i = 0; i < roleList.size(); i++) {
						Object role = roleList.get(i);
						// 判断方式：当前角色当中包含有除客户经理外的其它岗位，Flag为1
						if (!ScfBasConstant.ROLE_ID_MANAGER.equals(String.valueOf(role))) {
							roleFlag = "1";
							break;
						} else {
							roleFlag = "0";
						}
					}
				}

				if ("0".equals(roleFlag)) {
					mastContQryVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER);
				} else {
					mastContQryVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_BCTL);
				}
			}
			if (ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER.equals(mastContQryVO.getFlag())) {
				mgrno = user.getTlrNo();
			}
			if (StringUtil.isStrNotEmpty(mgrno)) {
				map.put(MGRNO, mgrno);
			}
			if (StringUtil.isStrNotEmpty(cname)) {
				map.put(CNAME, cname);
			}
			if (StringUtil.isStrNotEmpty(financingType)) {
				map.put(FINANCINGTYPE, financingType);
			}

			if (StringUtil.isStrNotEmpty(contStatus)) {
				map.put(CONTSTATUS, contStatus);
			}
			if (StringUtil.isStrNotEmpty(debtContno)) {
				map.put(DEBTCONTNO, debtContno);
			}
			if (StringUtil.isStrNotEmpty(buyerName)) {
				map.put(BUYERNAME, buyerName);
			}

		}
		List<com.huateng.scf.bas.cnt.dao.model.DebtContVO> list = iBCntDebtInfoDAO.selectBCntDebtInfoList(map, p);
		// List<com.huateng.scf.bas.cnt.dao.model.DebtContVO> listDebtContVO
		// =iBCntDebtInfoDAO.selectBCntDebtInfoList(map, p);
		/*
		 * List list = new ArrayList(); Iterator iter =
		 * listDebtContVO.iterator(); DebtContVO vo = null;
		 * while(iter.hasNext()){ Object[] obj = (Object[]) iter.next(); vo =
		 * new DebtContVO();
		 * 
		 * if(debtMngService.checkDealInvoiceIsExist(vo.getDebtContno())){
		 * vo.setDealFlag(SCFConstants.FLAG_ON); } list.add(vo); }
		 */
		p.setRecords(list);
		p.setTotalRecord(list.size());
		return p;
	}

	/**
	 * 应收账款合同新增初始化
	 */
	@Override
	public BCntDebtInfo initBCntDebtInfo() throws ScubeBizException {
		// TODO Auto-generated method stub
		BCntDebtInfo bcntDebtInfo = new BCntDebtInfo();
		// 获取当前用户
		UserInfo user = ContextHolder.getUserInfo();
		bcntDebtInfo.setMgrnoNm(user.getTlrName());
		bcntDebtInfo.setMgrno(user.getTlrNo());
		;
		// 获取机构信息
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		bcntDebtInfo.setBrcode(bctlVO.getBrNo());
		bcntDebtInfo.setBrcodeName(bctlVO.getBrName());
		// 获得机构集
		List<BctlVO> listBctl = orgService.selectByExample(bctlVO);
		bcntDebtInfo.setListBctl(listBctl);
		return bcntDebtInfo;
	}

	/**
	 * 交易对手买方名称的选择列表:移除列表中已有的
	 */
	@Override
	public Page findBCrmBaseInfoListByPage(int pageNo, int pageSize, Map<String, String> value, List<BCntDebtExtInfo> list) {
		// TODO Auto-generated method stub
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.putAll(value);
		if (value != null && value.get("custcd") != null) {
			map.put("custcd", value.get("custcd").toString().trim());
		}
		if (value != null && value.get("custStatus") != null) {
			map.put("custStatus", value.get("custStatus").toString().trim());
		} else {
			map.put("custStatus", BCrmBaseConstants.CUST_STATUS_VALID); // 有效
		}
		if (value != null && value.get("custType") != null) {
			map.put("custType", value.get("custType").toString().trim());
		} else {
			map.put("custType", BCrmBaseConstants.CUST_TYPE_CORP); // 法人
		}

		/*
		 * if (BSysConstant.FLAG_ON.equals(value.get("commercialFlag"))){ //
		 * 贸易对手 map.put("commercialFlag", BSysConstant.FLAG_ON); }
		 * 
		 * if (BSysConstant.FLAG_ON.equals(value.get("creditFlag"))){ // 授信客户
		 * map.put("creditFlag", BSysConstant.FLAG_ON); } if
		 * (BSysConstant.FLAG_ON.equals(value.get("creditFlag"))){ // 授信客户
		 * map.put("creditFlag", BSysConstant.FLAG_ON); }
		 */
		if (BSysConstant.FLAG_ON.equals(value.get("coreFlag"))) {
			// 核心企业
			map.put("coreFlag", BSysConstant.FLAG_ON);
		}
		// map.put("coreFlag", BSysConstant.FLAG_ON);
		map.put("coreRelationFlg", BCrmBaseConstants.CORE_RELATION_FLG_UP);
		// 列表已有的
		List<String> selectList = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (BCntDebtExtInfo info : list) {
				selectList.add(info.getBuyerCustcd());
			}
			// 以下一行代码移入list判断里面，否则新增是，报sql异常 modify by huangshuidan 2017-04-13
			map.put("buyerCustcds", selectList);
		}

		iBCntDebtInfoDAO.findCustBaseInfoList(map, page);
		/*
		 * List listResult = page.getRecords(); int total =
		 * page.getTotalRecord(); List<RBcpDebtBaseInfo> result = new
		 * ArrayList<RBcpDebtBaseInfo>(); result.addAll(listResult); //列表已有的
		 * List<String> selectList = new ArrayList<String>();
		 * if(list!=null&&list.size()>0){ for(BCntDebtExtInfo info:list){
		 * //selectList.add("'"+info.getBuyerCustcd()+"'");
		 * selectList.add(info.getBuyerCustcd());
		 * 
		 * } } //移除 if(listResult!=null&&listResult.size()>0){ for(int
		 * i=0;i<listResult.size();i++){ Map mapInfo = (Map) listResult.get(i);
		 * String buyerCustcd
		 * =mapInfo.get("buyerCustcd")==null?"":mapInfo.get("buyerCustcd").
		 * toString(); if(selectList!=null&&selectList.size()>0){ for(String
		 * str:selectList){ if(str.equals(buyerCustcd)){ result.remove(mapInfo);
		 * total--; } } } } } page.setRecords(result);
		 * page.setTotalRecord(total);
		 */
		return page;
	}

	/**
	 * 应收账款合同保存
	 */
	@Override
	@Transactional
	public void saveCntDebtInfoAdd(DebtContVO debtContVO, List<BCntCostInfo> costInfoList, List<BCntDebtExtInfo> debtExtInfoList)
			throws ScubeBizException {
		// 保存tblcontdebtinfo表
		BCntDebtInfo bCntDebtInfo = new BCntDebtInfo();
		BeanUtils.copyProperties(debtContVO, bCntDebtInfo);
		BigDecimal loanPercent = (bCntDebtInfo.getLoanPercent() != null ? bCntDebtInfo.getLoanPercent() : new BigDecimal(0));
		bCntDebtInfo.setLoanPercent(loanPercent);
		String serviceContent = bCntDebtInfo.getServiceContent();
		String loanWay = bCntDebtInfo.getLoanWay();
		bCntDebtInfo.setServiceContent(StringUtil.formatCheckBoxValue(serviceContent));
		bCntDebtInfo.setLoanWay(StringUtil.formatCheckBoxValue(loanWay));
		bCntDebtInfo = this.addBCntDebtInfo(bCntDebtInfo);
		String mastContno = bCntDebtInfo.getDebtContno();
		// 保存TblContDebtExtInfo表
		BCntDebtExtInfo bCntDebtExtInfo = new BCntDebtExtInfo();
		if (debtExtInfoList != null && debtExtInfoList.size() > 0) {
			for (int i = 0; i < debtExtInfoList.size(); i++) {
				bCntDebtExtInfo = debtExtInfoList.get(i);
				bCntDebtExtInfo.setBusinessNo(mastContno);
				// bCntDebtExtInfo.setBatchNumber(batchNumber);//
				this.addBCntDebtExtInfo(bCntDebtExtInfo);
			}
		}

		// 单笔收费保存费用信息TblCostInfo表
		if (bCntDebtInfo.getChargeType().equals(BCntBizConstant.CONT_CHARGE_TYPE_NUM)) {
			for (BCntCostInfo vo : costInfoList) {
				vo.setRelaNo(mastContno);
				vo.setRelaType(BCntBizConstant.COST_INFO_RELA_TYPE_PROT);// 1协议类型2合同类型
				vo.setRelaType(BCntBizConstant.COST_INFO_RELA_TYPE_PROT);// 1协议类型2合同类型
				// 校验费用比率是否在费用参数的最小比率和最大比率之间
				this.ischeckCostRate(vo);
				addBCntCostInfo(vo);
			}
		}
		// 买方信用限额保存 无追索
		this.saveCreditLimitOfBuyerInfo(bCntDebtInfo, debtExtInfoList);
		// TODO Auto-generated method stub

		if (BCntBizConstant.FINANCING_TYPE_POOL.equals(bCntDebtInfo.getFinancingType())) {
			this.debtPoolSaveOrUpdate(debtContVO, mastContno);
		}

	}

	/**
	 * 根据合同编号查询合同信息
	 */
	public DebtContVO queryBCntDebtInfoByContno(DebtContVO debtContVO) throws ScubeBizException {
		Map<String, String> map = new HashMap<String, String>();
		if (null != debtContVO) {
			String debtContno = debtContVO.getDebtContno();
			if (StringUtil.isStrNotEmpty(debtContno)) {
				map.put("debtContno", debtContno);
			} else {
				log.error("合同编号丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30000),
						BCntErrorConstant.SCF_BAS_CNT_30000);
			}
		}
		DebtContVO reDebtContVO = new DebtContVO();
		com.huateng.scf.bas.cnt.dao.model.DebtContVO daoDebtContVO = new com.huateng.scf.bas.cnt.dao.model.DebtContVO();
		daoDebtContVO = iBCntDebtInfoDAO.queryBCntDebtInfoByContno(map);
		BeanUtils.copyProperties(daoDebtContVO, reDebtContVO);

		String serviceContent = daoDebtContVO.getServiceContent();// 服务内容
		if (StringUtil.isStrNotEmpty(serviceContent)) {
			serviceContent = StringUtil.reCheckBoxValue(serviceContent);
		}
		String loanWay = daoDebtContVO.getLoanWay();// 出账方式
		if (StringUtil.isStrNotEmpty(loanWay)) {
			loanWay = StringUtil.reCheckBoxValue(loanWay);
		}
		reDebtContVO.setServiceContent(serviceContent);
		reDebtContVO.setLoanWay(loanWay);
		UserInfo userInfo = scubeUserService.selectUserByTlrNo(reDebtContVO.getMgrno(), ScfCommonUtil.getBrManagerNo(scubeUserService));
		if (userInfo != null) {
			reDebtContVO.setMgrnoNm(userInfo.getTlrName());
		}
		BctlVO bctlVO = scubeUserService.selectBctlByBrNo(reDebtContVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
		List<BctlVO> listBctl = new ArrayList<BctlVO>();
		listBctl.add(bctlVO);
		reDebtContVO.setListBctl(listBctl);
		if (StringUtil.isStrNotEmpty(reDebtContVO.getCooperationBrcode())) {
			BctlVO CoopbctlVO = scubeUserService.selectBctlByBrNo(reDebtContVO.getCooperationBrcode(),
					ScfCommonUtil.getBrManagerNo(scubeUserService));
			if (CoopbctlVO != null) {
				reDebtContVO.setCooperationBrcodeNm(CoopbctlVO.getBrName());
			}
		}

		return reDebtContVO;

	}

	/**
	 * 根据合同编号查询交易对手基本信息
	 */
	public Page queryBCntDebtExtInfoByContno(int pageNo, int pageSize, DebtContVO debtContVO) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, String> map = new HashMap<String, String>();
		if (null != debtContVO) {
			String debtContno = debtContVO.getDebtContno();
			if (StringUtil.isStrNotEmpty(debtContno)) {
				map.put("businessNo", debtContno);
			} else {
				log.error("合同编号丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30000),
						BCntErrorConstant.SCF_BAS_CNT_30000);
			}
		}
		iBCntDebtExtInfoDAO.findDebtExtInfoByContno(map, page);
		return page;

	}

	@Override
	@Transactional
	public void saveCntDebtInfoModify(DebtContVO debtContVO, List<BCntCostInfo> costInfoList, List<BCntDebtExtInfo> debtExtInfoList)
			throws ScubeBizException {
		BCntDebtInfo bCntDebtInfo = new BCntDebtInfo();
		BeanUtils.copyProperties(debtContVO, bCntDebtInfo);
		// 更新tblcontdebtinfo表
		BigDecimal loanPercent = (bCntDebtInfo.getLoanPercent() != null ? bCntDebtInfo.getLoanPercent() : new BigDecimal("0"));
		bCntDebtInfo.setLoanPercent(loanPercent);
		String serviceContent = bCntDebtInfo.getServiceContent();
		String loanWay = bCntDebtInfo.getLoanWay();
		bCntDebtInfo.setServiceContent(StringUtil.formatCheckBoxValue(serviceContent));
		bCntDebtInfo.setLoanWay(StringUtil.formatCheckBoxValue(loanWay));
		// String productId= bCntDebtInfo.getSupplyChainPdId();
		this.updateBCntDebtInfo(bCntDebtInfo);
		String mastContno = bCntDebtInfo.getDebtContno();
		Map<String, String> map = new HashMap<String, String>();
		// 更新TblContDebtExtInfo表 先删除，再新增
		if (StringUtil.isStrNotEmpty(mastContno)) {
			map.put(BUSINESSNO, mastContno);
			// bCntCostInfodal.setRelaNo(debtContno);
		} else {
			log.error("合同编号丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30000), BCntErrorConstant.SCF_BAS_CNT_30000);
		}
		iBCntDebtExtInfoDAO.deleteDebtExtInfoByContno(map);
		BCntDebtExtInfo bCntDebtExtInfo = new BCntDebtExtInfo();
		if (debtExtInfoList != null && debtExtInfoList.size() > 0) {
			for (int i = 0; i < debtExtInfoList.size(); i++) {
				bCntDebtExtInfo = debtExtInfoList.get(i);
				bCntDebtExtInfo.setBusinessNo(mastContno);
				// bCntDebtExtInfo.setBatchNumber(batchNumber);//
				this.addBCntDebtExtInfo(bCntDebtExtInfo);
			}
		}

		// 单笔收费更新费用信息TblCostInfo表
		if (bCntDebtInfo.getChargeType().equals(BCntBizConstant.CONT_CHARGE_TYPE_NUM)) {
			for (BCntCostInfo vo : costInfoList) {
				vo.setRelaNo(mastContno);
				vo.setRelaType(BCntBizConstant.COST_INFO_RELA_TYPE_PROT);// 1协议类型2合同类型
				// 校验费用比率是否在费用参数的最小比率和最大比率之间
				this.ischeckCostRate(vo);
				this.updateOrSaveBCntCostInfo(vo);
			}
		} else { // 删除费用
			// 若是按年的时候是没有费用的，这个时候
			MastContQryVO mastContQryVO = new MastContQryVO();
			mastContQryVO.setMastContCode(mastContno);
			BCntCostInfo bCntCostInfo = findCostInfoByContno(mastContQryVO);
			if (bCntCostInfo != null) {
				String id = bCntCostInfo.getId();
				iBCntCostInfoDAO.deleteByPrimaryKey(id);
			}
		}
		// TODO 修改时买方信用限额保存 无追索
		// 池融资
		if (BCntBizConstant.FINANCING_TYPE_POOL.equals(bCntDebtInfo.getFinancingType())) {
			if (!rBcpDebtPoolService.checkPoolIsExist(mastContno)) {
				this.debtPoolSaveOrUpdate(debtContVO, mastContno);
			}
		}
	}

	/**
	 * 应收账款合同删除，更改为无效
	 */
	@Transactional
	@Override
	public void saveCntDebtInfoDelete(List<DebtContVO> debtContVOList) throws ScubeBizException {
		// TODO Auto-generated method stub
		DebtContVO debtContVO = new DebtContVO();
		CommonQryVO commonQryVO = new CommonQryVO();
		DebtCommonQryVO debtCommonQryVO = new DebtCommonQryVO();
		for (int i = 0; i < debtContVOList.size(); i++) {
			debtContVO = (DebtContVO) debtContVOList.get(i);

			// TODO 检查是否存在未结清的借据
			commonQryVO.setMastContno(debtContVO.getDebtContno());
			List<BLanLnciBase> lnciResult = bLanLnciBaseService.queryValidLnciBaseInfo(commonQryVO);
			if (lnciResult != null && lnciResult.size() > 0) {
				log.error("合同下存在未结清借据！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30003),
						BCntErrorConstant.SCF_BAS_CNT_30003);
			}
			// TODO 检查是否存在未核销的应收账款
			debtCommonQryVO.setMastContno(debtContVO.getDebtContno());
			List<RBcpDebtBaseInfo> debtResult = rBcpDebtBaseInfoService.queryValidDebtBaseInfo(debtCommonQryVO);
			if (debtResult != null && debtResult.size() > 0) {
				log.error("合同下存在未核销的应收账款！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30004),
						BCntErrorConstant.SCF_BAS_CNT_30004);
			}

			// 更新合同状态
			BCntDebtInfo bCntDebtInfo = new BCntDebtInfo();
			BeanUtils.copyProperties(debtContVO, bCntDebtInfo);
			bCntDebtInfo.setContStatus(BCntBizConstant.MAST_CONT_STATUS_INVALID);
			this.updateBCntDebtInfo(bCntDebtInfo);
		}
	}

	/**
	 * 校验费用比率是否在费用参数管理中设置的最小比率、最大比率之间
	 * 
	 * @param bCntCostInfo
	 * @return
	 */
	@Transactional
	public void ischeckCostRate(BCntCostInfo bCntCostInfo) throws ScubeBizException {
		BigDecimal CostRate = BigDecimal.ZERO;
		String costCode = "";
		if (bCntCostInfo != null) {
			String costCalcType = bCntCostInfo.getCostCalcType();
			// 按比率
			if (StringUtil.isStrNotEmpty(costCalcType) && costCalcType.equals(BCntBizConstant.COST_CALC_TYPE_RATE)) {
				CostRate = bCntCostInfo.getCostRate();
				costCode = bCntCostInfo.getCostCode();
				BBrpCostParam bBrpCostParam = new BBrpCostParam();
				bBrpCostParam.setCostCode(costCode);
				BBrpCostParam costParam = bBrpCostParamService.findBBrpCostParamByKey(bBrpCostParam);
				BigDecimal minRate = costParam.getMinRate(); // 最小比率
				BigDecimal maxRate = costParam.getMaxRate(); // 最大比率
				if (CostRate.compareTo(minRate) < 0 || CostRate.compareTo(maxRate) > 0) {
					String errMsg = "请重新输入费用比率，费用比率不在费用参数管理中设置的最小比率" + minRate + "和最大比率" + maxRate + "之间";
					log.error(errMsg);
					throw new ScubeBizException(errMsg);
				}
			}

		}
	}

	/************************************* 交易对手begin **********************************/
	/**
	 * 交易对手保存
	 * 
	 * @param bCntDebtExtInfo
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	public BCntDebtExtInfo addBCntDebtExtInfo(BCntDebtExtInfo bCntDebtExtInfo) throws ScubeBizException {
		ScfCommonUtil.setCommonField(bCntDebtExtInfo);// 设置公共字段 a
		bCntDebtExtInfo.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo bCntDebtExtInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo();
		try {
			BeanUtils.copyProperties(bCntDebtExtInfo, bCntDebtExtInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		try {
			iBCntDebtExtInfoDAO.insertSelective(bCntDebtExtInfodal);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("保存新增信息失败！");
			throw new ScubeBizException("保存新增信息失败！", e);
		}
		return bCntDebtExtInfo;

	}

	// 买方信用限额新增保存
	@Transactional
	public void saveCreditLimitOfBuyerInfo(BCntDebtInfo bCntDebtInfo, List<BCntDebtExtInfo> debtExtInfoList) throws ScubeBizException {
		String mastContno = bCntDebtInfo.getDebtContno();
		String curcd = bCntDebtInfo.getCurcd();
		String custcd = bCntDebtInfo.getCurcd();
		String startDate = bCntDebtInfo.getStartDate();
		String endDate = bCntDebtInfo.getEndDate();
		String Term = ScfDateUtil.getTenOr(ScfDateUtil.numberToDate(startDate), ScfDateUtil.numberToDate(endDate));// 账期的计算
		// 额度品种查询
		BIcrType bIcrType = new BIcrType();
		bIcrType.setCreditClass(BIcrConstant.CREDIT_CLASS_LIMIT_BUYER);
		List<BIcrType> typeList = iBIcrTypeDAO.findBIcrTypeByBIcrType(bIcrType);
		String creditType = ""; // 买方信用限额额度品种
		if (typeList != null && typeList.size() > 0) {
			bIcrType = typeList.get(0);
			creditType = bIcrType.getCreditType();
		}
		// 获得买方信用限额的额度种类编号
		BCntDebtExtInfo bCntDebtExtInfo = new BCntDebtExtInfo();
		if (debtExtInfoList != null && debtExtInfoList.size() > 0) {
			for (int i = 0; i < debtExtInfoList.size(); i++) {
				bCntDebtExtInfo = debtExtInfoList.get(i);
				if (BCntBizConstant.RECOVER_TYPE_WITHOUT_RECOURSE.equals(bCntDebtExtInfo.getRecoverType())) {
					// 2-无追索
					// 保存额度流水信息 B_ICR_DTL
					BIcrDtl bIcrDtl = new BIcrDtl();
					String creditNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_CREDIT_LIMIT_BUYER_NO);
					bIcrDtl.setCreditNo(creditNo);
					bIcrDtl.setAppno(creditNo);
					bIcrDtl.setOperType(BIcrConstant.CREDIT_TRADE_TYPE_INPUT);// 生效
					bIcrDtl.setBusinessno(mastContno);
					bIcrDtl.setRelaType(BIcrConstant.CREDIT_RELA_TYPE_CONT); // 关联类型
					bIcrDtl.setCustcd(bCntDebtExtInfo.getBuyerCustcd());
					bIcrDtl.setAmount(bCntDebtExtInfo.getCreditAmt());
					bIcrDtl.setCreditAmount(new BigDecimal("0"));
					bIcrDtl.setPreUsedAmount(new BigDecimal("0"));
					bIcrDtl.setUsedAmount(new BigDecimal("0"));
					bIcrDtl.setFrzAmount(new BigDecimal("0"));
					bIcrDtl.setCreditUsableAmount(new BigDecimal("0"));
					bIcrDtl.setCommonAmount(bCntDebtExtInfo.getCreditAmt());
					bIcrDtlService.add(bIcrDtl);

					// 额度信息新增B_ICR_INFO
					BIcrInfo bIcrInfo = new BIcrInfo();
					bIcrInfo.setCreditNo(creditNo);
					bIcrInfo.setCreditClass(BIcrConstant.CREDIT_CLASS_LIMIT_BUYER); // 买方信用限额
					bIcrInfo.setCreditType(creditType);
					bIcrInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_ROOT);
					bIcrInfo.setUpCreditNo(null);
					bIcrInfo.setCustcd(custcd);
					bIcrInfo.setOtherCustcd(bCntDebtExtInfo.getBuyerCustcd());
					bIcrInfo.setCurcd(curcd);
					bIcrInfo.setControlType(BIcrConstant.CREDIT_CLASS_CYCLE);
					bIcrInfo.setCreditAmount(bCntDebtExtInfo.getCreditAmt());
					bIcrInfo.setCreditUsableAmount(bCntDebtExtInfo.getCreditAmt());
					bIcrInfo.setPreUsedAmount(new BigDecimal("0"));
					bIcrInfo.setUsedAmount(new BigDecimal("0"));
					bIcrInfo.setFrzAmount(new BigDecimal("0"));
					bIcrInfo.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL);
					bIcrInfo.setStartDate(bCntDebtInfo.getStartDate());
					bIcrInfo.setEndDate(bCntDebtInfo.getEndDate());
					bIcrInfo.setTerm(Term);
					bIcrInfo.setValidDate(BSysConstant.WORKDATE);
					bIcrInfoService.addBIcrInfo(bIcrInfo);
					// 额度关联信息新增B_ICR_BUSI_REL
					BIcrBusiRel bIcrBusiRel = new BIcrBusiRel();
					bIcrBusiRel.setId(UUIDGeneratorUtil.generate());
					bIcrBusiRel.setRelaType(BIcrConstant.CREDIT_RELA_TYPE_CONT);
					bIcrBusiRel.setBusinessNo(mastContno);
					bIcrBusiRel.setCreditNo(creditNo);
					try {
						iBIcrBusiRelDAO.insertSelective(bIcrBusiRel);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new ScubeBizException("额度关联信息", e);
					}
				}

			}
		}
	}
	/************************************* 交易对手end **********************************/

	/************************************* 费用信息相关begin **********************************/
	/**
	 * 根据业务品种获得费用信息
	 */
	@Override
	public Page findCostInfoByProduct(Map<String, String> value) {
		// TODO Auto-generated method stub
		Page page = new Page();
		if (value != null && value.get("productId") != null) {
			value.put("productId", value.get("productId").toString().trim());
		}
		List<?> list = iBCntDebtInfoDAO.findCostInfoByProduct(value, page);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, String> map = (Map<String, String>) list.get(i);
				// 费用收取种类,收取方式，扣取方式,计算方式 的处理
				String costClass = map.get("costClass"); // 第1位-整体、第2位-单张
				String costType = map.get("costType"); // 第1位-先收；第2位-后收；第3位-免收
				String chargeType = map.get("chargeType"); // 先收时使用第1位-外扣，第2位-内收
				String costCalcType = map.get("costCalcType"); // 第1位-固定、第2位-按比率
				if (costClass.trim().length() == 2) {
					String o1 = costClass.substring(0, 1);
					String o2 = costClass.substring(1, 2);
					if (o1.equals("1")) {
						costClass = BCntBizConstant.COST_CLASS_WHOLE;
					} else if (o2.equals("1")) {
						costClass = BCntBizConstant.COST_CLASS_SINGLE;
					}
					map.put("costClass", costClass);
				}
				if (costType.trim().length() == 3) {
					String o1 = costType.substring(0, 1);
					String o2 = costType.substring(1, 2);
					String o3 = costType.substring(2, 3);
					if (o1.equals("1")) {
						costType = BCntBizConstant.COST_TYPE_FIRST;
					} else if (o2.equals("1")) {
						costType = BCntBizConstant.COST_TYPE_LAST;
					} else if (o3.equals("1")) {
						costType = BCntBizConstant.COST_TYPE_FREE;
					}
					map.put("costType", costType);
				}
				if (chargeType.trim().length() == 2) {
					String o1 = chargeType.substring(0, 1);
					String o2 = chargeType.substring(1, 2);
					if (o1.equals("1")) {
						chargeType = BCntBizConstant.CHARGE_TYPE_OUT;
					} else if (o2.equals("1")) {
						chargeType = BCntBizConstant.CHARGE_TYPE_IN;
					}
					map.put("chargeType", chargeType);
				}
				if (costCalcType.trim().length() == 2) {
					String o1 = costCalcType.substring(0, 1);
					String o2 = costCalcType.substring(1, 2);
					if (o1.equals("1")) {
						costCalcType = BCntBizConstant.COST_CALC_TYPE_FIX;
					} else if (o2.equals("1")) {
						costCalcType = BCntBizConstant.COST_CALC_TYPE_RATE;
					}
					map.put("costCalcType", costCalcType);
				}
			}
		}

		return page;
	}

	/**
	 * 费用信息新增
	 * 
	 * @param bCntCostInfo
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	public BCntCostInfo addBCntCostInfo(BCntCostInfo bCntCostInfo) throws ScubeBizException {
		ScfCommonUtil.setCommonField(bCntCostInfo);// 设置公共字段 a
		bCntCostInfo.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.bas.cnt.dao.model.BCntCostInfo bCntCostInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntCostInfo();
		try {
			BeanUtils.copyProperties(bCntCostInfo, bCntCostInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		try {
			iBCntCostInfoDAO.insertSelective(bCntCostInfodal);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("保存新增信息失败！");
			throw new ScubeBizException("保存新增信息失败！", e);
		}
		return bCntCostInfo;

	}

	/**
	 * 费用信息修改 修改的时候如果由按年改为单笔的时候是新增费用
	 * 
	 * @param bCntCostInfo
	 * @throws ScubeBizException
	 */
	@Transactional
	public void updateOrSaveBCntCostInfo(BCntCostInfo bCntCostInfo) throws ScubeBizException {
		com.huateng.scf.bas.cnt.dao.model.BCntCostInfo bCntCostInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntCostInfo();
		BeanUtils.copyProperties(bCntCostInfo, bCntCostInfodal);
		bCntCostInfodal = iBCntCostInfoDAO.findCostInfoByContno(bCntCostInfodal);
		if (bCntCostInfodal != null) {
			BeanUtils.copyProperties(bCntCostInfo, bCntCostInfodal);
			iBCntCostInfoDAO.updateByPrimaryKey(bCntCostInfodal);
		} else {
			this.addBCntCostInfo(bCntCostInfo);
		}

	}

	// 根据关联号/关联号和关联类型获取费用信息
	public List<BCntCostInfo> findCostInfoListByContno(MastContQryVO mastContQryVO) throws ScubeBizException {
		List<BCntCostInfo> list = new ArrayList<BCntCostInfo>();
		BCntCostInfo bCntCostInfo = new BCntCostInfo();
		bCntCostInfo = this.findCostInfoByContno(mastContQryVO);
		list.add(bCntCostInfo);
		return list;

	}

	// 根据关联号/关联号和关联类型获取费用信息
	public BCntCostInfo findCostInfoByContno(MastContQryVO mastContQryVO) throws ScubeBizException {
		BCntCostInfo bCntCostInfo = null;
		com.huateng.scf.bas.cnt.dao.model.BCntCostInfo bCntCostInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntCostInfo();
		if (null != mastContQryVO) {
			String debtContno = mastContQryVO.getMastContCode();
			if (StringUtil.isStrNotEmpty(debtContno)) {
				bCntCostInfodal.setRelaNo(debtContno);
			} else {
				log.error("合同编号丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30000),
						BCntErrorConstant.SCF_BAS_CNT_30000);
			}
		}

		bCntCostInfodal = iBCntCostInfoDAO.findCostInfoByContno(bCntCostInfodal);
		if (bCntCostInfodal != null) {
			bCntCostInfo = new BCntCostInfo();
			BeanUtils.copyProperties(bCntCostInfodal, bCntCostInfo);
		}
		return bCntCostInfo;

	}
	/************************************* 费用信息相关END **********************************/

	/************************************* 应收账款池BEGIN **********************************/
	/**
	 * DESCRIPTION:保存应收账款池信息
	 * 
	 * @author zhoujun.hou
	 * @date 2013-6-20 debtPoolSaveOrUpdate 方法
	 * @param contractVO
	 * @param mastContno
	 * @throws CommonException
	 * @param commonQueryVO
	 * @return
	 */
	public void debtPoolSaveOrUpdate(DebtContVO debtContVO, String mastContno) throws ScubeBizException {
		RBcpDebtPool rBcpDebtPool = new RBcpDebtPool();
		rBcpDebtPool.setMastContno(mastContno);
		rBcpDebtPool.setCustcdSaller(debtContVO.getCustcd());
		rBcpDebtPool.setInsertDate(BSysConstant.WORKDATE);
		rBcpDebtPool.setCurcd(debtContVO.getCurcd());
		rBcpDebtPool.setBussType(debtContVO.getBussType());
		rBcpDebtPool.setDebtNum(BigDecimal.ZERO);
		rBcpDebtPool.setTotalDebtAmount(new BigDecimal("0"));
		rBcpDebtPool.setTotalDebtRemainAmount(new BigDecimal("0"));
		rBcpDebtPool.setTotalCashAmount(new BigDecimal("0"));
		rBcpDebtPool.setPoolRemainingAmount(new BigDecimal("0"));
		rBcpDebtPool.setPoolUseableAmount(new BigDecimal("0"));
		rBcpDebtPool.setTotalCapitalAmount(new BigDecimal("0"));
		rBcpDebtPool.setTotalRateAmount(new BigDecimal("0"));
		rBcpDebtPool.setTotalRateRemainAmount(new BigDecimal("0"));
		rBcpDebtPool.setRefundAmount(new BigDecimal("0"));
		rBcpDebtPool.setReturnRateAmount(new BigDecimal("0"));
		// debtPool.setId(UUIDGeneratorUtil.generate());
		rBcpDebtPoolService.addRBcpDebtPool(rBcpDebtPool);
	}

	/************************************* 应收账款池END **********************************/
	// 页面下拉菜单查询保理合同基本信息（根据卖方客户号和业务合同号，业务品种翻译成业务品种名称）
	@Override
	public Page selectBCntDebtInfoByPage(int pageNo, int pageSize, BCntDebtInfo bCntDebtInfo) throws ScubeBizException {
		if (bCntDebtInfo == null || StringUtils.isEmpty(bCntDebtInfo.getCustcd())) {
			throw new ScubeBizException("请先选择卖方客户！");
		}
		List<String> factTypes = new ArrayList<String>();
		if (StringUtil.isEmpty(bCntDebtInfo.getFactType())) {
			factTypes.add(BCntBizConstant.FACT_TYPE_INLAND);// 国内保理
			factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE);// 反向保理
			factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);// 应收账款质押
			factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);// 应收账款质押池融资
			factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);// 保理池融资
			factTypes.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);// 出口退税池质押融资
		} else {
			if (bCntDebtInfo.getFactType().equals(BCntBizConstant.T_FINANCING_TYPE_INVOICE)) {// 应收账款融资
				factTypes.add(BCntBizConstant.FACT_TYPE_INLAND);
				factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE);
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);
			} else if (bCntDebtInfo.getFactType().equals(BCntBizConstant.T_FINANCING_TYPE_POOL)) {// 应收账款池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);// 应收账款质押池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);// 保理池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);// 出口退税池质押融资
			}
		}
		BCntDebtInfoExample example = new BCntDebtInfoExample();
		Page p = new Page(pageSize, pageNo, 0);
		BCntDebtInfoExample.Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(bCntDebtInfo.getMgrnoNm())){
			criteria.andMgrnoEqualTo(ContextHolder.getUserInfo().getTlrNo());
		}
		// 客户号
		criteria.andCustcdEqualTo(bCntDebtInfo.getCustcd());
		// debtContno 业务合同号，模糊查询
		if (bCntDebtInfo.getDebtContno() != null && bCntDebtInfo.getDebtContno().length() > 0) {
			criteria.andDebtContnoLike("%" + bCntDebtInfo.getDebtContno() + "%");
		}
		// contStatus 合同状态
		if (bCntDebtInfo.getContStatus() != null && bCntDebtInfo.getContStatus().length() > 0) {
			criteria.andContStatusEqualTo(bCntDebtInfo.getContStatus());
		}
		// financingType 融资模式：1-发票融资;2-池融资
		if (bCntDebtInfo.getFinancingType() != null && !"".equals(bCntDebtInfo.getFinancingType())) {
			criteria.andFinancingTypeEqualTo(bCntDebtInfo.getFinancingType());
		}
		if (factTypes.size() > 0) {
			criteria.andFactTypeIn(factTypes);
		}
		try {
			example.setOrderByClause("DEBT_CONTNO DESC");
			List<com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo> bCntDebtInfoList = iBCntDebtInfoDAO.selectByPage(example, p);
			try {
				for (com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfo1 : bCntDebtInfoList) {
					// 查询对应的业务产品名称 supplyChainPdId是对应的业务品种编号 业务品种名称
					// bussTypeName
					BPrdInfo bPrdInfo = bPrdInfoDAO.selectByPrimaryKey(bCntDebtInfo1.getSupplyChainPdId());
					bCntDebtInfo1.setBussTypeName(bPrdInfo.getProductName());
				}
			} catch (Exception e) {
				throw new ScubeBizException("保理合同基本信息分页条件查询，转译业务品种名称失败！");
			}
			p.setRecords(bCntDebtInfoList);
			return p;
		} catch (Exception e) {
			throw new ScubeBizException("保理合同基本信息分页条件查询失败！");
		}

	}

	@Override
	public List findBCntDebtInfoByPage(Map<String, Object> map, Page p) {
		List<com.huateng.scf.bas.cnt.dao.model.DebtContVO> list = iBCntDebtInfoDAO.selectBCntDebtInfoList(map, p);
		return list;
	}

	@Override
	public DebtContVO queryContInfoByMastContno(String mastContno) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("debtContno", mastContno);
		com.huateng.scf.bas.cnt.dao.model.DebtContVO bCntDebtInfoDal = iBCntDebtInfoDAO.queryBCntDebtInfoByContno(map);
		DebtContVO bCntDebtInfo = new DebtContVO();
		BeanUtils.copyProperties(bCntDebtInfoDal, bCntDebtInfo);
		return bCntDebtInfo;
	}

	@Override
	public BCntDebtInfo findBCntDebtInfoByKey(String key) throws ScubeBizException {
		BCntDebtInfo bCntDebtInfo = new BCntDebtInfo();
		try {
			com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfoDal = iBCntDebtInfoDAO.selectByPrimaryKey(key);
			BeanUtils.copyProperties(bCntDebtInfoDal, bCntDebtInfo);
			BPrdInfo bPrdInfo = bPrdInfoDAO.selectByPrimaryKey(bCntDebtInfo.getSupplyChainPdId());
			bCntDebtInfo.setBussTypeName(bPrdInfo.getProductName());
		} catch (Exception e) {
			throw new ScubeBizException("查询具体合同信息失败");
		}
		return bCntDebtInfo;
	}

	// 页面信贷合同管理关联业务合同号下拉菜单查询
	@Override
	@Transactional
	public Page selectContNoByPage(int pageNo, int pageSize, BCntDebtInfo bCntDebtInfo) {
		// debtContno,业务合同号
		int n = 0;
		ArrayList<BCntDebtInfo> list = new ArrayList<BCntDebtInfo>();
		if (bCntDebtInfo.getSupplyChainPdId() == null || "".equals(bCntDebtInfo.getSupplyChainPdId())) {
			throw new ScubeBizException("请选择业务品种！");
		}

		// 存货类
		if (bCntDebtInfo.getParentId().equals(ScfBasConstant.PRODUCT_TYPE_MORT)) {
			BCrrGntyConExample bCrrGntyConExample = new BCrrGntyConExample();
			com.huateng.scf.bas.crr.dao.model.BCrrGntyConExample.Criteria createCriteria = bCrrGntyConExample.createCriteria();
			if (bCntDebtInfo.getDebtContno() != null && !"".equals(bCntDebtInfo.getDebtContno())) {
				createCriteria.andConIdLike("%" + bCntDebtInfo.getDebtContno() + "%");
			}
			// vidPrdId
			if (bCntDebtInfo.getSupplyChainPdId() != null && !"".equals(bCntDebtInfo.getSupplyChainPdId())) {
				createCriteria.andVidPrdIdEqualTo(bCntDebtInfo.getSupplyChainPdId());
			}
			// 担保人编号
			if (bCntDebtInfo.getCustcd() != null && !"".equals(bCntDebtInfo.getCustcd())) {
				createCriteria.andGutIdEqualTo(bCntDebtInfo.getCustcd());
			}
			createCriteria.andConStatEqualTo("1");// 有效
			bCrrGntyConExample.setOrderByClause("CON_ID desc");
			try {
				List<BCrrGntyCon> bCrrGntyConList = bcrrgntycondao.selectByExample(bCrrGntyConExample);
				for (BCrrGntyCon bCrrGntyCon1 : bCrrGntyConList) {
					BCntDebtInfo debtInfo2 = new BCntDebtInfo();
					debtInfo2.setDebtContno(bCrrGntyCon1.getConId());
					list.add(debtInfo2);
					n = n + 1;
				}
			} catch (Exception e) {
				throw new ScubeBizException("存货类合同号查询失败！");
			}
		}
		// 预付类
		if (bCntDebtInfo.getParentId().equals(ScfBasConstant.PRODUCT_TYPE_PREP)) {
			Map<String, String> map = new HashMap<String, String>();
			// protocolNo productId custcd

			if ("".equals(bCntDebtInfo.getDebtContno())) {
				bCntDebtInfo.setDebtContno(null);
			}
			// 如果是预付类，先票款后货则应查四方保兑仓的信息，否则则查三方保兑仓的信息。
			if (ScfBasConstant.PRODUCT_TYPE_XPHH.equals(bCntDebtInfo.getSupplyChainPdId())) {
				map.put("protocolType", "02");
			} else {
				map.put("protocolType", "07");
			}
			map.put("protocolNo", bCntDebtInfo.getDebtContno());
			map.put("productId", bCntDebtInfo.getSupplyChainPdId());
			map.put("custcd", bCntDebtInfo.getCustcd());
			map.put("role", ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
			try {
				List<BCntMprotBaseInfo> bCntMprotBaseInfoList = iBCntMprotBaseInfoDAO.selectForRelateAdvanced(map);
				if (bCntMprotBaseInfoList != null && bCntMprotBaseInfoList.size() > 0) {
					for (BCntMprotBaseInfo bCntMprotBaseInfo1 : bCntMprotBaseInfoList) {
						BCntDebtInfo bCntDebtInfo2 = new BCntDebtInfo();
						bCntDebtInfo2.setDebtContno(bCntMprotBaseInfo1.getProtocolNo());
						list.add(bCntDebtInfo2);
						n = n + 1;
					}
				}
			} catch (Exception e) {
				throw new ScubeBizException("预付类合同号查询失败！");
			}
		}
		// 应收类（应收类还要细分下，看得更清楚）
		if (bCntDebtInfo.getParentId().equals(ScfBasConstant.PRODUCT_TYPE_ACCR)) {
			BCntDebtInfoExample bCntDebtInfoExample = new BCntDebtInfoExample();
			Criteria createCriteria = bCntDebtInfoExample.createCriteria();
			if (bCntDebtInfo.getDebtContno() != null && !"".equals(bCntDebtInfo.getDebtContno())) {
				createCriteria.andDebtContnoLike("%" + bCntDebtInfo.getDebtContno() + "%");
			}
			// 这里如果页面还传了具体的保理种类，则再细分下展示的合同号给页面
			if (bCntDebtInfo.getSupplyChainPdId() != null && !"".equals(bCntDebtInfo.getSupplyChainPdId())) {
				createCriteria.andSupplyChainPdIdEqualTo(bCntDebtInfo.getSupplyChainPdId());
			}
			if (bCntDebtInfo.getCustcd() != null && !"".equals(bCntDebtInfo.getCustcd())) {
				createCriteria.andCustcdEqualTo(bCntDebtInfo.getCustcd());
			}
			createCriteria.andContStatusEqualTo("01");// 有效合同
			bCntDebtInfoExample.setOrderByClause("DEBT_CONTNO DESC");
			try {
				List<com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo> list1 = iBCntDebtInfoDAO.selectByExample(bCntDebtInfoExample);
				for (com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfo2 : list1) {
					BCntDebtInfo debtInfo2 = new BCntDebtInfo();
					debtInfo2.setDebtContno(bCntDebtInfo2.getDebtContno());
					list.add(debtInfo2);
					n = n + 1;
				}
			} catch (Exception e) {
				throw new ScubeBizException("应收类合同号查询失败！");
			}
		}
		try {
			Page p = new Page(pageSize, pageNo, n);
			p.setRecords(list);
			return p;
		} catch (Exception e) {
			throw new ScubeBizException("（下拉框）条件分页查询业务合同号失败！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.cnt.service.IBCntDebtInfoService#
	 * queryContDebtInfoByMastContno(com.huateng.scf.rec.bcp.model.
	 * DebtCommonQryVO)
	 */
	@Override
	public DebtBussInfoVO queryContDebtInfoByMastContno(DebtCommonQryVO commonQueryVO) throws ScubeBizException {
		BCntDebtInfo bCntDebtInfo = null;
		if (null != commonQueryVO && StringUtil.isStrNotEmpty(commonQueryVO.getMastContno())) {
			bCntDebtInfo = queryContInfoByMastContno(commonQueryVO.getMastContno());
		} else {
			log.error("合同号丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30000), BCntErrorConstant.SCF_BAS_CNT_30000);
		}
		if (bCntDebtInfo == null) {
			log.error("保理合同信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30002), BCntErrorConstant.SCF_BAS_CNT_30002);
		}
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(bCntDebtInfo, debtVO);
		debtVO.setCustcdBuyer(commonQueryVO.getCustcdBuyer_Q());
		debtVO.setCustcdSaller(bCntDebtInfo.getCustcd());
		debtVO.setBussType(bCntDebtInfo.getSupplyChainPdId());
		if (StringUtil.isEmpty(debtVO.getBalanceAccount())) {
			debtVO.setBalanceAccount(debtVO.getAccountNo());
		} else if (StringUtil.isEmpty(debtVO.getAccountNo())) {
			debtVO.setAccountNo(debtVO.getBalanceAccount());
		}
		debtVO.setAppno(commonQueryVO.getAppno_Q());
		BigDecimal loanpercent = new BigDecimal(0);
		if (bCntDebtInfo.getLoanPercent() == null) {
			debtVO.setLoanPercent(loanpercent);
		}
		return debtVO;
	}

	@Override
	public List<BCntDebtInfo> findBcntDebtInfoList(BCntDebtInfo bCntDebtInfo) {
		BCntDebtInfoExample example = new BCntDebtInfoExample();
		BCntDebtInfoExample.Criteria e = example.createCriteria();
		if (!(bCntDebtInfo.getCustcd() == null && bCntDebtInfo.getCustcd().equals(""))) {
			e.andCustcdEqualTo(bCntDebtInfo.getCustcd());
		}
		List<com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo> info = iBCntDebtInfoDAO.selectByExample(example);
		List<BCntDebtInfo> list = new ArrayList<BCntDebtInfo>();
		BeanUtils.copyProperties(info, list);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.cnt.service.IBCntDebtInfoService#
	 * queryBCntDebtInfoListForDispute(int, int,
	 * com.huateng.scf.bas.cnt.model.MastContQryVO)
	 */
	@Override
	public Page queryBCntDebtInfoListForDispute(int pageNo, int pageSize, MastContQryVO mastContQryVO) throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		if (mastContQryVO != null) {
			String cname = mastContQryVO.getCname();// 卖方名称
			String debtContno = mastContQryVO.getMastContCode();// 主合同号
			String contStatus = mastContQryVO.getConStatus();// 合同状态
			String financingType = mastContQryVO.getFinancingType(); // 融资模式
			String creditFlag = mastContQryVO.getCreditFlag();// 授信标识
			// 卖方名称
			if (StringUtil.isStrNotEmpty(cname)) {
				map.put(CNAME, cname);
			}
			// 融资模式
			if (StringUtil.isStrNotEmpty(financingType)) {
				map.put(FINANCINGTYPE, financingType);
			}
			// 合同状态
			if (StringUtil.isStrNotEmpty(contStatus)) {
				map.put(CONTSTATUS, contStatus);
			}
			// 合同号
			if (StringUtil.isStrNotEmpty(debtContno)) {
				map.put(DEBTCONTNO, debtContno);
			}
			// 授信标识
			if (StringUtil.isStrNotEmpty(creditFlag)) {
				map.put("creditFlag", creditFlag);
			}
		}
		iBCntDebtInfoDAO.selectBCntDebtInfoListForDispute(map, p);
		return p;
	}

	/**
	 * @Description: 根据指定条件查询保理合同信息列表
	 * @author mengjiajia
	 * @Created 2013-8-1下午8:35:18
	 * @param commonQueryVO
	 * @return
	 * @throws CommonException
	 */
	@Override
	public Page getTblContDebtInfoList(DebtCommonQryVO commonQueryVO) throws ScubeBizException {
		BCntDebtInfoExample example = new BCntDebtInfoExample();
		BCntDebtInfoExample.Criteria cri = example.createCriteria();
		if (!StringUtil.isEmpty(commonQueryVO.getBussContno())) {
			cri.andDebtContnoLike(commonQueryVO.getBussContno());
		}

		if (!StringUtil.isEmpty(commonQueryVO.getCustcd())) {
			cri.andCustcdEqualTo(commonQueryVO.getCustcd());
		}

		int total = iBCntDebtInfoDAO.countByExample(example);
		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), 0);

		page.setRecords(iBCntDebtInfoDAO.selectByPage(example, page));
		page.setTotal(total);
		return page;
	}

}
