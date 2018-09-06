package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.cnt.dao.IBCntCostInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntCostInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntCostInfoExample;
import com.huateng.scf.bas.cnt.service.IBCntCostInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.ICreditLimitOfBuyerService;
import com.huateng.scf.bas.common.service.ICreditServiceService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.icr.constant.BIcrConstant;
import com.huateng.scf.bas.icr.dao.IBIcrBusiRelDAO;
import com.huateng.scf.bas.icr.dao.IBIcrTypeDAO;
import com.huateng.scf.bas.icr.dao.domodel.BIcrInfoDO;
import com.huateng.scf.bas.icr.dao.model.BIcrType;
import com.huateng.scf.bas.icr.dao.model.BIcrTypeExample;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.CreditLimitOfBuyerDealVO;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.bas.icr.service.IBIcrDtlService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nbas.prd.model.BCntCostInfoVO;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpExtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoDAO;
import com.huateng.scf.nrec.bcp.dao.IBCntInsuranceContInfoDAO;
import com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfoExample;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfoExample;
import com.huateng.scf.nrec.bcp.dao.model.BCntInsuranceContInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntInsuranceContInfoExample;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpAppliBaseInfoService;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INFactFinanceBaseService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtPoolDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPoolExample;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * 应收类合同管理 接口实现类
 * </p>
 *
 * @author mengjiajia
 * @date 2017年5月19日下午3:50:44
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月19日下午3:50:44	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCntBcpInfoServiceImpl")
public class BCntBcpInfoServiceImpl implements IBCntBcpInfoService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCntBcpInfoDAO")
	IBCntBcpInfoDAO bcntbcpinfodao;

	@Resource(name = "RBcpDebtPoolDAO")
	IRBcpDebtPoolDAO rBcpDebtPoolDAO;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;

	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;

	@Autowired
	ScubeUserService scubeUserService;

	@Resource(name = "BCntBcpAppliBaseInfoServiceImpl")
	IBCntBcpAppliBaseInfoService bcntbcpapplibaseinfoserviceimpl;

	@Resource(name = "IBCntBcpExtInfoDAO")
	IBCntBcpExtInfoDAO bcntbcpextinfodao;

	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bPrdInfoDAO;

	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nrbcpdebtpoolservice;

	@Resource(name = "NFactFinanceBaseServiceImpl")
	INFactFinanceBaseService nfactfinancebaseservice;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;// 业务编号生成器

	@Resource(name = "BIcrBusiRelDAO")
	IBIcrBusiRelDAO iBIcrBusiRelDAO; // 额度业务关联

	@Resource(name = "BIcrTypeDAO")
	IBIcrTypeDAO iBIcrTypeDAO; // 额度种类DAO

	@Resource(name = "BIcrDtlServiceImpl")
	IBIcrDtlService bIcrDtlService;

	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bIcrInfoService;

	@Resource(name = "IBCntInsuranceContInfoDAO")
	IBCntInsuranceContInfoDAO bcntinsurancecontinfodao;

	// 费用信息
	@Resource(name = "BCntCostInfoServiceImpl")
	IBCntCostInfoService bcntcostinfoservice;

	@Resource(name = "BCntCostInfoDAO")
	IBCntCostInfoDAO iBCntCostInfoDAO;

	@Resource(name = "CreditServiceServiceImpl")
	ICreditServiceService creditserviceservice;

	@Resource(name = "CreditLimitOfBuyerServiceImpl")
	ICreditLimitOfBuyerService creditlimitofbuyerservice;

	/**
	 * 查询业务申请列表信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCntBcpAppliBaseInfo
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月19日上午10:53:05
	 */
	@Override
	public Page queryBCntBcpInfoByPage(int pageNo, int pageSize, BCntBcpInfoVO bCntBcpInfoVO)
	{
		log.debug("业务合同列表查询=============");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		// 合同编号
		if(!StringUtil.isEmpty(bCntBcpInfoVO.getMastContno()))
		{
			omap.put("mastContno", bCntBcpInfoVO.getMastContno());
		}
		// 业务品种
		if(!StringUtil.isEmpty(bCntBcpInfoVO.getSupplyChainPdId()))
		{
			omap.put("supplyChainPdId", bCntBcpInfoVO.getSupplyChainPdId());
		}
		// 融资企业
		if(!StringUtil.isEmpty(bCntBcpInfoVO.getCname()))
		{
			omap.put("cname", bCntBcpInfoVO.getCname());
		}
		// 贸易对手
		if(!StringUtil.isEmpty(bCntBcpInfoVO.getBusinessName()))
		{
			omap.put("businessName", bCntBcpInfoVO.getBusinessName());
		}
		// 合同状态
		if(!StringUtil.isEmpty(bCntBcpInfoVO.getContStatus()))
		{
			omap.put("contStatus", bCntBcpInfoVO.getContStatus());
		}
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		omap.putAll(map);
		int total = extnrecbcpdao.countBCntBcpInfoByPage(omap);
		Page page = new Page(pageSize, pageNo, total);
		List<BCntBcpInfoDO> result = extnrecbcpdao.queryBCntBcpInfoByPage(omap, page, true);
		if(result != null && result.size() > 0)
		{
			for(BCntBcpInfoDO bcpInfoDO : result)
			{
				UserInfo info = scubeUserService.selectUserByTlrNo(bcpInfoDO.getTlrcd(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(info != null)
				{
					bcpInfoDO.setTlrnm(info.getTlrName());
				}
				BctlVO bctl = scubeUserService.selectBctlByBrNo(bcpInfoDO.getBrcode(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(bctl != null)
				{
					bcpInfoDO.setBrname(bctl.getBrName());
				}
				bcpInfoDO.setInpDt(ScfDateUtil.getStringDate(bcpInfoDO.getCrtTime()));
			}
		}
		page.setRecords(result);
		page.setTotalRecord(total);
		return page;
	}

	/**
	 * 查询合同详情信息，双保理业务贸易对手保理商信息，信保保理保险信息
	 * 
	 * @param bCntBcpInfoVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月13日下午2:41:38
	 */
	@Override
	public BCntBcpInfoVO findBCntBcpInfoByMastContno(BCntBcpInfoVO bCntBcpInfoVO)
	{
		if(!StringUtil.isEmpty(bCntBcpInfoVO.getFactoringBrcode()))
		{
			bCntBcpInfoVO
					.setFactoringBrcodeName(bcrmbaseinfodao.selectById(bCntBcpInfoVO.getFactoringBrcode()).getCname());
		}
		BCntInsuranceContInfoExample example = new BCntInsuranceContInfoExample();
		BCntInsuranceContInfoExample.Criteria cri = example.createCriteria();
		cri.andMastContnoEqualTo(bCntBcpInfoVO.getMastContno());
		List<BCntInsuranceContInfo> list = bcntinsurancecontinfodao.selectByExample(example);
		if(list != null && list.size() > 0)
		{
			BeanUtils.copyProperties(list.get(0), bCntBcpInfoVO);
			bCntBcpInfoVO.setInsuranceName(bcrmbaseinfodao.selectById(bCntBcpInfoVO.getInsuranceCustcd()).getCname());
		}
		bCntBcpInfoVO.setInpDt(ScfDateUtil.getStringDate(bCntBcpInfoVO.getCrtTime()));
		return bCntBcpInfoVO;
	}

	/**
	 * 修改合同信息与贸易对手信息
	 * 
	 * @param bcntBcpInfoVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月22日上午10:45:46
	 */
	@Override
	@Transactional
	public void saveOrUpdateBCntBcpInfo(BCntBcpInfoVO bcntBcpInfoVO, BCntCostInfoVO bCntCostInfoVO)
			throws ScubeBizException
	{
		// 合同基本信息
		BCntBcpInfo bcntBcpInfo = new BCntBcpInfo();
		BeanUtils.copyProperties(bcntBcpInfoVO, bcntBcpInfo);
		bcntBcpInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		bcntBcpInfo.setLastUpdTime(new Date());
		bcntBcpInfo.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		// 更新合同信息
		bcntbcpinfodao.updateByPrimaryKeySelective(bcntBcpInfo);
		// 贸易对手信息
		BCntBcpExtInfo bcpExtInfo = new BCntBcpExtInfo();
		BeanUtils.copyProperties(bcntBcpInfoVO, bcpExtInfo);
		bcpExtInfo.setBusinessNo(bcntBcpInfoVO.getMastContno());
		if(!StringUtil.isEmpty(bcpExtInfo.getId()))
		{
			// 更新贸易对手信息
			bcntbcpextinfodao.updateByPrimaryKeySelective(bcpExtInfo);
		}
		else
		{
			BCntBcpExtInfoExample example = new BCntBcpExtInfoExample();
			BCntBcpExtInfoExample.Criteria cri = example.createCriteria();
			cri.andBusinessNoEqualTo(bcntBcpInfoVO.getMastContno());
			cri.andBusinessCustcdEqualTo(bcntBcpInfoVO.getBusinessCustcd());
			List<BCntBcpExtInfo> list = bcntbcpextinfodao.selectByExample(example);
			if(list != null && list.size() > 0)
			{
				String id = list.get(0).getId();
				bcpExtInfo.setId(id);
				bcntbcpextinfodao.updateByPrimaryKeySelective(bcpExtInfo);
			}
			else
			{
				String id = UUIDGeneratorUtil.generate();
				bcpExtInfo.setId(id);
				bcntbcpextinfodao.insertSelective(bcpExtInfo);
			}
		}
		// 费用信息
		if(bCntCostInfoVO != null)
		{
			BCntCostInfoVO infoVO = bcntcostinfoservice.findBCntCostInfoByRelaNo(bcntBcpInfoVO.getMastContno());
			if(infoVO == null)
			{// 不存在，新增
				bCntCostInfoVO.setRelaNo(bcntBcpInfoVO.getMastContno());
				bcntcostinfoservice.addBCntCostInfo(bCntCostInfoVO);
			}
			else
			{// 存在，修改
				bCntCostInfoVO.setId(infoVO.getId());
				bcntcostinfoservice.updateBCntCostInfo(bCntCostInfoVO);
			}
		}
		// 保险公司信息
		if(!StringUtil.isEmpty(bcntBcpInfoVO.getInsuranceCustcd()))
		{
			// 检验是否有保险信息 信保保理保险合同信息表
			BCntInsuranceContInfo cntInsuranceContInfo = bcntinsurancecontinfodao
					.selectByPrimaryKey(bcntBcpInfoVO.getMastContno());
			BCntInsuranceContInfo contInfo = new BCntInsuranceContInfo();
			BeanUtils.copyProperties(bcntBcpInfoVO, contInfo);
			if(cntInsuranceContInfo != null)
			{// 保险信息存在则修改
				contInfo.setInsuranceNo(cntInsuranceContInfo.getInsuranceNo());
				bcntinsurancecontinfodao.updateByPrimaryKeySelective(contInfo);
			}
			else
			{// 不存在则新增
				contInfo.setInsuranceNo(bcntBcpInfoVO.getMastContno());
				contInfo.setCumulativeReparationAmt(BigDecimal.ZERO);
				bcntinsurancecontinfodao.insertSelective(contInfo);
			}

		}
		// 买方信用限额保存 无追索
		this.saveCreditLimitOfBuyerInfo(bcntBcpInfoVO);

		if(BCntBizConstant.FINANCING_TYPE_POOL.equals(bcntBcpInfo.getFinancingType()))
		{
			if(!nrbcpdebtpoolservice.checkPoolIsExist(bcntBcpInfo.getMastContno()))
			{
				this.debtPoolSaveOrUpdate(bcntBcpInfoVO, bcntBcpInfo.getMastContno());
			}
		}
	}

	/**
	 * 未生效合同信息生效
	 * 
	 * @param bcntBcpInfoVO
	 * @author mengjiajia
	 * @date 2017年5月22日下午1:39:57
	 */
	@Override
	@Transactional
	public void setContStatus(BCntBcpInfoVO bcntBcpInfoVO)
	{
		BCntBcpInfo bCntBcpInfo = new BCntBcpInfo();
		bCntBcpInfo.setContStatus(bcntBcpInfoVO.getContStatus());
		bCntBcpInfo.setMastContno(bcntBcpInfoVO.getMastContno());
		bcntbcpinfodao.updateByPrimaryKeySelective(bCntBcpInfo);
	}

	/**
	 * 业务编号筛选
	 * 
	 * @param custcd
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月23日下午3:41:49
	 */
	public Page getMastContno(int pageNo, int pageSize, HashMap<String, String> value) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();

		if(value != null)
		{
			if(!StringUtil.isEmpty(value.get("custcd")))
			{
				omap.put("custcd", value.get("custcd").toString().trim());
			}
			else
			{
				throw new ScubeBizException("请选择融资企业");
			}
			if(!StringUtil.isEmpty(value.get("mastContno")))
			{
				omap.put("mastContno", value.get("mastContno").toString().trim());
			}
		}
		omap.put("contStatus", "1");
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		omap.putAll(map);
		int total = extnrecbcpdao.countBCntBcpInfoByPage(omap);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(extnrecbcpdao.queryBCntBcpInfoByPage(omap, page, true));
		page.setTotalRecord(total);
		return page;
	}

	@Override
	public BCntBcpInfoVO queryBCntBcpInfoByMastContno(String mastContno) throws ScubeBizException
	{
		if(StringUtils.isEmpty(mastContno))
		{
			return null;
		}
		BCntBcpInfoVO bCntBcpInfoVO = new BCntBcpInfoVO();
		try
		{
			BCntBcpInfo bCntBcpInfo = bcntbcpinfodao.selectByPrimaryKey(mastContno);
			if(bCntBcpInfo == null)
			{
				return null;
			}
			BeanUtils.copyProperties(bCntBcpInfo, bCntBcpInfoVO);
		}catch (Exception e)
		{
			throw new ScubeBizException("查询应收账款合同失败！");
		}
		BCntBcpExtInfoExample bCntBcpExtInfoExample = new BCntBcpExtInfoExample();
		BCntBcpExtInfoExample.Criteria cri = bCntBcpExtInfoExample.createCriteria();
		cri.andBusinessNoEqualTo(mastContno);
		List<BCntBcpExtInfo> bCntBcpExtInfoList = bcntbcpextinfodao.selectByExample(bCntBcpExtInfoExample);
		if(bCntBcpExtInfoList != null && bCntBcpExtInfoList.size() == 1)
		{
			BCntBcpExtInfo bCntBcpExtInfo = bCntBcpExtInfoList.get(0);
			// 买方名称
			com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo = bcrmbaseinfodao
					.selectById(bCntBcpExtInfo.getBusinessCustcd());
			if(bCrmBaseInfo != null)
			{
				bCntBcpInfoVO.setCnameBuyer(bCrmBaseInfo.getCname());
				bCntBcpInfoVO.setBusinessCustcd(bCrmBaseInfo.getCustcd());
			}
			bCntBcpInfoVO.setLoanDays(bCntBcpExtInfo.getLoanDays());// 账期
			bCntBcpInfoVO.setDebtGraceDays(bCntBcpExtInfo.getDebtGraceDays());// 宽限期
		}
		else
		{
			throw new ScubeBizException("贸易对手信息查询失败！");
		}
		// 卖方名称
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo4 = bcrmbaseinfodao
				.selectById(bCntBcpInfoVO.getCustcd());
		if(bCrmBaseInfo4 != null)
		{
			bCntBcpInfoVO.setCname(bCrmBaseInfo4.getCname());
		}
		// 业务品种名称
		BPrdInfo bPrdInfo = bPrdInfoDAO.selectByPrimaryKey(bCntBcpInfoVO.getSupplyChainPdId());
		if(bPrdInfo != null)
		{
			bCntBcpInfoVO.setSupplyChainPdName(bPrdInfo.getProductName());
		}
		if(StringUtils.isNotBlank(bCntBcpInfoVO.getTlrcd()))
		{
			UserInfo userinfo = scubeUserService.selectUserByTlrNo(bCntBcpInfoVO.getTlrcd(),
					ScfCommonUtil.getBrManagerNo(scubeUserService));
			bCntBcpInfoVO.setTlrcd(userinfo.getTlrName());
		}
		if(StringUtils.isNotBlank(bCntBcpInfoVO.getBrcode()))
		{
			BctlVO bctlVO = scubeUserService.selectBctlByBrNo(bCntBcpInfoVO.getBrcode(),
					ScfCommonUtil.getBrManagerNo(scubeUserService));
			bCntBcpInfoVO.setBrcode(bctlVO.getBrName());
		}
		// 池合同则需要查询对应的池敞口余额和池应收账款余额
		if(bCntBcpInfoVO.getFinancingType().equals("2"))
		{
			RBcpDebtPoolExample rBcpDebtPoolExample = new RBcpDebtPoolExample();
			RBcpDebtPoolExample.Criteria crea = rBcpDebtPoolExample.createCriteria();
			crea.andMastContnoEqualTo(mastContno);
			List<RBcpDebtPool> rBcpDebtPoolList = rBcpDebtPoolDAO.selectByExample(rBcpDebtPoolExample);
			if(rBcpDebtPoolList != null && rBcpDebtPoolList.size() == 1)
			{
				bCntBcpInfoVO.setTotalDebtRemainAmount(rBcpDebtPoolList.get(0).getTotalDebtRemainAmount());
				bCntBcpInfoVO.setPoolUseableAmount(rBcpDebtPoolList.get(0).getPoolUseableAmount());
				bCntBcpInfoVO
						.setPoolRiskAmt(nfactfinancebaseservice.calculatePoolRiskAvailableAmtByBusinessNo(mastContno));// 池敞口余额
			}
		}
		return bCntBcpInfoVO;
	}

	@Override
	public BCntBcpInfoVO queryOnlyBCntBcpInfoByMastContno(String mastContno)
	{
		if(StringUtils.isEmpty(mastContno))
		{
			return null;
		}
		BCntBcpInfoVO bCntBcpInfoVO = new BCntBcpInfoVO();
		try
		{
			BCntBcpInfo bCntBcpInfo = bcntbcpinfodao.selectByPrimaryKey(mastContno);
			if(bCntBcpInfo == null)
			{
				return null;
			}
			BeanUtils.copyProperties(bCntBcpInfo, bCntBcpInfoVO);
		}catch (Exception e)
		{
			throw new ScubeBizException("查询应收账款合同失败！");
		}
		return bCntBcpInfoVO;
	}

	@Override
	public Page queryBCntBcpInfoForSelect(int pageNo, int pageSize, BCntBcpInfoVO bCntBcpInfoVO)
			throws ScubeBizException
	{
		if(bCntBcpInfoVO == null || StringUtils.isEmpty(bCntBcpInfoVO.getCustcd()))
		{
			throw new ScubeBizException("请先选择融资客户！");
		}
		Page page = new Page(pageSize, pageNo, 0);

		BCntBcpInfoExample bCntBcpInfoExample = new BCntBcpInfoExample();
		BCntBcpInfoExample.Criteria criteria = bCntBcpInfoExample.createCriteria();
		// 客户号
		criteria.andCustcdEqualTo(bCntBcpInfoVO.getCustcd());
		// 合同号是模糊查询
		if(StringUtils.isNotEmpty(bCntBcpInfoVO.getMastContno()))
		{
			criteria.andMastContnoLike("%" + bCntBcpInfoVO.getMastContno() + "%");
		}
		// contStatus 合同状态
		if(StringUtils.isNotEmpty(bCntBcpInfoVO.getContStatus()))
		{
			criteria.andContStatusEqualTo(bCntBcpInfoVO.getContStatus());
		}
		// financingType 融资模式：1-发票融资;2-池融资
		if(StringUtils.isNotEmpty(bCntBcpInfoVO.getFinancingType()))
		{
			criteria.andFinancingTypeEqualTo(bCntBcpInfoVO.getFinancingType());
		}
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		if(!StringUtil.isEmpty(map.get("tlrNoList")))
		{
			criteria.andTlrcdIn(map.get("tlrNoList"));
		}
		if(!StringUtil.isEmpty(map.get("brNoList")))
		{
			criteria.andBrcodeIn(map.get("brNoList"));
		}
		try
		{
			bCntBcpInfoExample.setOrderByClause("MAST_CONTNO DESC");
			List<BCntBcpInfo> bCntBcpInfoList = bcntbcpinfodao.selectByPage(bCntBcpInfoExample, page);
			ArrayList<BCntBcpInfoVO> arrayList = new ArrayList<BCntBcpInfoVO>();
			if(bCntBcpInfoList != null && bCntBcpInfoList.size() > 0)
			{
				for(BCntBcpInfo bCntBcpInfo : bCntBcpInfoList)
				{
					BCntBcpInfoVO bCntBcpInfoVO2 = new BCntBcpInfoVO();
					BeanUtils.copyProperties(bCntBcpInfo, bCntBcpInfoVO2);
					// 业务品种
					BPrdInfo bPrdInfo = bPrdInfoDAO.selectByPrimaryKey(bCntBcpInfoVO2.getSupplyChainPdId());
					if(bPrdInfo != null)
					{
						bCntBcpInfoVO2.setSupplyChainPdName(bPrdInfo.getProductName());
					}
					// 买方客户名称
					BCntBcpInfoVO bCntBcpInfoVO3 = queryBCntBcpInfoByMastContno(bCntBcpInfoVO2.getMastContno());
					bCntBcpInfoVO2.setCnameBuyer(bCntBcpInfoVO3.getCnameBuyer());
					bCntBcpInfoVO2.setBusinessCustcd(bCntBcpInfoVO3.getBusinessCustcd());
					arrayList.add(bCntBcpInfoVO2);
				}
			}
			page.setRecords(arrayList);
			return page;
		}catch (Exception e)
		{
			throw new ScubeBizException("保理合同基本信息分页条件查询失败！");
		}
	}

	/**
	 * 买方信用限额新增保存
	 * 
	 * @param bCntDebtInfo
	 * @param debtExtInfoList
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月1日下午5:33:42
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public void saveCreditLimitOfBuyerInfo(BCntBcpInfoVO bCntBcpInfoVO) throws ScubeBizException
	{
		String mastContno = bCntBcpInfoVO.getMastContno();
		String factType = bCntBcpInfoVO.getFactType();
		String custcd = bCntBcpInfoVO.getCustcd();// 融资企业
		String otherCustcd = bCntBcpInfoVO.getBusinessCustcd();// 贸易对手
		// 额度品种查询
		BIcrTypeExample example = new BIcrTypeExample();
		BIcrTypeExample.Criteria cri = example.createCriteria();
		cri.andCreditClassEqualTo(BIcrConstant.CREDIT_CLASS_LIMIT_BUYER);
		List<BIcrType> typeList = iBIcrTypeDAO.selectByExample(example);
		String creditType = ""; // 买方信用限额额度品种
		if(typeList != null && typeList.size() > 0)
		{
			creditType = typeList.get(0).getCreditType();
		}
		boolean flag = true;
		if((ScfBasConstant.FACT_TYPE_INLAND.equals(factType) || ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
				|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType))
				&& ScfBasConstant.CREDIT_TYPE_WITH_RECOURSE.equals(bCntBcpInfoVO.getRecoverType()))
		{
			flag = false;
		}
		if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)
				&& ScfBasConstant.CREDIT_TYPE_WITH_RECOURSE.equals(bCntBcpInfoVO.getRecoverType()))
		{
			flag = false;
		}
		if(ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType))
		{
			flag = false;
		}
		if(ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType))
		{
			flag = false;
		}
		if(ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType))
		{
			flag = false;
		}
		CreditQryVO cqv = null;
		if(flag)
		{
			cqv = new CreditQryVO();
			cqv.setBusinessNo_Q(mastContno);
			cqv.setCustcd(custcd);
			cqv.setCreditType_Q(creditType);
			cqv.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_LIMIT_BUYER);
			cqv.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
			cqv.setFlag(ScfBasConstant.FLAG_ON);
			cqv.setPageIndex(1);
			cqv.setPageSize(Integer.MAX_VALUE);
			cqv.setOtherCustcd_Q(otherCustcd);
			cqv.setPageFlag(false);
			Page page = creditserviceservice.getTblCreditInfoByCreditQryVO(cqv);
			List<BIcrInfoDO> list = page.getRecords();
			if(list == null || list.size() == 0)
			{// 新增买方信用限额额度
				CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO = new CreditLimitOfBuyerDealVO();
				creditLimitOfBuyerDealVO.setOperType(ScfBasConstant.CREDIT_TRADE_TYPE_INPUT);
				creditLimitOfBuyerDealVO.setCreditType(creditType);
				creditLimitOfBuyerDealVO.setBusinessNo(mastContno);
				creditLimitOfBuyerDealVO.setCustcd(custcd);
				creditLimitOfBuyerDealVO.setOtherCustcd(otherCustcd);
				creditLimitOfBuyerDealVO.setAmount(bCntBcpInfoVO.getCreditAmt());
				creditlimitofbuyerservice.addOrModifyCreditLimitInfoOfBuyer(creditLimitOfBuyerDealVO);
			}
			else
			{// 修改买方信用限额额度
				CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO = new CreditLimitOfBuyerDealVO();
				creditLimitOfBuyerDealVO.setOperType(ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE);
				creditLimitOfBuyerDealVO.setCreditType(creditType);
				creditLimitOfBuyerDealVO.setBusinessNo(mastContno);
				creditLimitOfBuyerDealVO.setCustcd(custcd);
				creditLimitOfBuyerDealVO.setOtherCustcd(otherCustcd);
				creditLimitOfBuyerDealVO.setAmount(bCntBcpInfoVO.getCreditAmt());
				creditlimitofbuyerservice.addOrModifyCreditLimitInfoOfBuyer(creditLimitOfBuyerDealVO);
			}
		}

		// 查询获取已存在买方信用限额
		cqv = new CreditQryVO();
		cqv.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_LIMIT_BUYER);
		cqv.setBusinessNo_Q(mastContno);
		cqv.setCustcd(custcd);
		cqv.setCreditType_Q(creditType);
		cqv.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
		cqv.setFlag(ScfBasConstant.FLAG_ON);
		cqv.setPageIndex(1);
		cqv.setPageSize(Integer.MAX_VALUE);
		cqv.setPageFlag(false);
		Page pqrExists = creditserviceservice.getTblCreditInfoByCreditQryVO(cqv);
		List<BIcrInfoDO> creditExists = pqrExists.getRecords();
		List<String> delList = new ArrayList<String>();
		for(int i = 0; i < creditExists.size(); i++)
		{
			BIcrInfoDO bIcrInfoDO = creditExists.get(i);
			String otherCustcdExist = bIcrInfoDO.getOtherCustcd();
			int num = 0;
			if(otherCustcdExist.equalsIgnoreCase(otherCustcd))
			{
				num = 1;
				break;
			}
			if(num == 0)
			{
				delList.add(bIcrInfoDO.getCreditNo());
			}
		}
		// 删除将买方信用限额额度置为无效
		if(delList != null && delList.size() > 0)
		{
			for(String creditNo : delList)
			{
				BIcrInfo bIcrInfo = bIcrInfoService.findBIcrInfoByCreditNo(creditNo);
				if(bIcrInfo.getUsedAmount() != null && (bIcrInfo.getUsedAmount().compareTo(new BigDecimal(0)) != 0))
				{
					throw new ScubeBizException("客户号为" + bIcrInfo.getOtherCustcd() + "的买方信用限额额度已经在业务中使用，不允许删除！",
							RBcpErrorConstant.ERROR_CODE_CANNOT_DEL);
				}
				bIcrInfo.setStatus(ScfBasConstant.CREDIT_STATUS_TERMINATE);
				bIcrInfoService.updateBIcrInfo(bIcrInfo);
			}
		}
	}

	/************************************* 应收账款池BEGIN **********************************/
	/**
	 * 保存应收账款池信息
	 * 
	 * @param debtContVO
	 * @param mastContno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月1日下午5:34:23
	 */
	@Transactional
	public void debtPoolSaveOrUpdate(BCntBcpInfoVO bcntBcpInfoVO, String mastContno) throws ScubeBizException
	{
		RBcpDebtPool rBcpDebtPool = new RBcpDebtPool();
		rBcpDebtPool.setMastContno(mastContno);
		rBcpDebtPool.setCustcdSaller(bcntBcpInfoVO.getCustcd());
		rBcpDebtPool.setCustcdBuyer(bcntBcpInfoVO.getBusinessCustcd());
		rBcpDebtPool.setInsertDate(BSysConstant.WORKDATE);
		rBcpDebtPool.setCurcd(bcntBcpInfoVO.getCurcd());
		rBcpDebtPool.setBussType(bcntBcpInfoVO.getSupplyChainPdId());
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
		com.huateng.scf.rec.bcp.model.RBcpDebtPool rBcpDebtPool2 = new com.huateng.scf.rec.bcp.model.RBcpDebtPool();
		BeanUtils.copyProperties(rBcpDebtPool, rBcpDebtPool2);
		nrbcpdebtpoolservice.addRBcpDebtPool(rBcpDebtPool2);
	}

	/************************************* 应收账款池END **********************************/
	@Override
	public BCntCostInfoVO queryCntCostInfoByMastContno(String mastContno) throws ScubeBizException
	{
		if(StringUtils.isEmpty(mastContno))
		{
			return null;
		}
		BCntCostInfoExample bCntCostInfoExample = new BCntCostInfoExample();
		BCntCostInfoExample.Criteria createCriteria = bCntCostInfoExample.createCriteria();
		createCriteria.andRelaNoEqualTo(mastContno);
		List<BCntCostInfo> bCntCostInfoList = iBCntCostInfoDAO.selectByExample(bCntCostInfoExample);
		if(bCntCostInfoList != null && bCntCostInfoList.size() > 0)
		{
			BCntCostInfoVO bCntCostInfoVO = new BCntCostInfoVO();
			BeanUtils.copyProperties(bCntCostInfoList.get(0), bCntCostInfoVO);
			return bCntCostInfoVO;
		}
		else
		{
			return null;
		}
	}

}
