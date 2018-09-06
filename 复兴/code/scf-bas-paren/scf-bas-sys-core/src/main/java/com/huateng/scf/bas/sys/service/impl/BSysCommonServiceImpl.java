/**
 * 
 */
package com.huateng.scf.bas.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.RoleInfoVO;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.RoleService;
import com.huateng.base.common.beans.Page;
import com.huateng.data.dto.DataItem;
import com.huateng.data.util.BDDataUtil;
import com.huateng.scf.bas.acc.constant.BAccConstant;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample;
import com.huateng.scf.bas.prd.dao.IBPrdWkflowCopDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdWkflowCopExample;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.dao.IBSysCommonDao;
import com.huateng.scf.bas.sys.dao.ext.ExtIBSysCommonDao;
import com.huateng.scf.bas.sys.service.IBSysCommonService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>公用接口实现</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月28日.下午6:08:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月28日.下午6:08:11	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BSysCommonServiceImpl")
public class BSysCommonServiceImpl implements IBSysCommonService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "bSysCommonDaoImpl")
	IBSysCommonDao bSysCommonDao;
	@Resource(name = "extIBSysCommonDaoImpl")
	ExtIBSysCommonDao extIBSysCommonDao;
	@Resource(name = "BPrdWkflowCopDAO")
	IBPrdWkflowCopDAO bPrdWkflowCopDao;
	@Autowired
	private OrgService orgService;

	@Autowired
	private RoleService roleService;
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;

	/**
	 * 业务品种筛选
	 */
	@Override
	public Page selectBusinessType(int pageNo, int pageSize, Map<String, String> value)
	{
		log.debug("selectBusinessType传递参数,value=" + value);
		Page p = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		String tFactType = "";
		if(value != null)
		{
			tFactType = value.get("tFactType");
		}

		List<String> factTypes = new ArrayList<String>();
		if(BCntBizConstant.T_FINANCING_TYPE_INVOICE.equals(tFactType))
		{// 应收账款融资 产品
			factTypes.add(BCntBizConstant.FACT_TYPE_INLAND);
			factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE);
			factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);
		}
		else if(BCntBizConstant.T_FINANCING_TYPE_POOL.equals(tFactType))
		{// 应收账款池
			factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);
			factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);
			factTypes.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);
		}
		else if(BCntBizConstant.T_FINANCING_TYPE_CREDIT.equals(tFactType))
		{// 信保保理
			factTypes.add(BCntBizConstant.FACT_TYPE_CREDIT_FACT);
		}
		else if(BCntBizConstant.T_FINANCING_TYPE_DOUBLE.equals(tFactType))
		{// 国内双保理
			factTypes.add(BCntBizConstant.FACT_TYPE_DOUBLE_FACT);
		}
		else if(BCntBizConstant.T_FINANCING_TYPE_LEASE.equals(tFactType))
		{// 租赁保理
			factTypes.add(BCntBizConstant.FACT_TYPE_LEASE_FACT);
		}
		else if(BCntBizConstant.T_FINANCING_TYPE_EF.equals(tFactType))
		{// 国际出口保理
			factTypes.add(BCntBizConstant.FACT_TYPE_EF);
		}
		else if(BCntBizConstant.T_FINANCING_TYPE_IF.equals(tFactType))
		{// 国际进口保理
			factTypes.add(BCntBizConstant.FACT_TYPE_IF);
		}
		else
		{

		}
		if(factTypes.size() > 0)
		{
			map.put("factTypes", factTypes);
		}
		if(value != null && value.get("productId") != null)
		{
			map.put("productId", value.get("productId").toString().trim());
		}
		if(value != null && value.get("parentId") != null)
		{
			map.put("parentId", value.get("parentId").toString().trim());
		}
		if(value != null && value.get("productName") != null)
		{
			map.put("productName", value.get("productName").toString().trim());
		}

		bSysCommonDao.selectBusinessType(map, p);
		return p;
	}

	/**
	 * 账户筛选(结算账号,回款保证金账号,回款专户) 
	 */
	@Override
	public Page selectAccountNo(int pageNo, int pageSize, Map<String, String> value)
	{
		log.debug("selectAccountNo传递参数,value=" + value);
		Page p = new Page(pageSize, pageNo, 0);
		Map<String, String> map = new HashMap<String, String>();
		if(value != null && value.get("accountType").equals(BAccConstant.ACCOUNT_TYPE_BALANCE))
		{ // 结算账户
			map.put("accountType", value.get("accountType").toString().trim());
		}
		else if(value != null && value.get("accountType").equals(BAccConstant.ACCOUNT_TYPE_RETURN))
		{ // 回款账户
			map.put("accountType", value.get("accountType").toString().trim());
		}
		else if(value != null && value.get("accountType").equals(BAccConstant.ACCOUNT_TYPE_BAIL))
		{ // 保证金账号
			map.put("accountType", value.get("accountType").toString().trim());
		}

		if(value != null && value.get("custcd") != null)
		{
			map.put("custcd", value.get("custcd").toString().trim());
		}
		if(value != null && value.get("curcd") != null)
		{
			map.put("curcd", value.get("curcd").toString().trim());
		}
		if(value != null && value.get("accountNo") != null)
		{
			map.put("accountNo", value.get("accountNo").toString().trim());
		}
		map.put("status", BSysConstant.FLAG_VALID);

		bSysCommonDao.selectAccountNo(map, p);
		return p;
	}

	/**
	 * 经办机构
	 * @param pageNo
	 * @param pageSize
	 * @param bctlVO
	 * @return
	 */
	public Page selectBranchInfo(int pageNo, int pageSize, BctlVO bctlVO)
	{
		Page p = new Page(pageSize, pageNo, 0);
		p = orgService.select(pageNo, pageSize, bctlVO);
		return p;
	}

	/**
	 * 合作机构
	 * @param pageNo
	 * @param pageSize
	 * @param bctlVO
	 * @return
	 */
	public Page selectCooperationBranch(int pageNo, int pageSize, BctlVO bctlVO)
	{
		Page p = new Page(pageSize, pageNo, 0);
		List<BctlVO> list = orgService.selectByExample(bctlVO);
		if(list != null && list.size() > 0)
		{
			int size = list.size();
			p.setTotal(size);
			while(pageSize * (pageNo - 1) > size)
			{
				--pageNo;
			}
			p.setRecords(list.subList(pageSize * (pageNo - 1), Math.min(pageSize * pageNo, size)));
		}
		return p;
	}

	/**
	 * 业务品种筛选2
	 */
	@Override
	public Page selectBusinessTypeByPage(int pageNo, int pageSize, Map<String, String> value)
	{
		log.debug("selectBusinessType传递参数,value=" + value);
		Page p = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> factTypes = new ArrayList<String>();// 应收账款融资 产品
		if(value != null && value.get("tFactType").equals(BCntBizConstant.T_FINANCING_TYPE_INVOICE))
		{
			factTypes.add(BCntBizConstant.FACT_TYPE_INLAND);
			factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE);
			factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);
			map.put("factTypes", factTypes);
		}
		if(value != null && value.get("productId") != null)
		{
			map.put("productId", value.get("productId").toString().trim());
		}
		if(value != null && value.get("productName") != null)
		{
			map.put("productName", value.get("productName").toString().trim());
		}

		extIBSysCommonDao.selectBusinessType(map, p);
		return p;
	}

	/**
	 * 流程筛选*/
	@Override
	public Page selectWKFlowByPage(int pageNo, int pageSize, Map<String, Object> value)
	{
		Page p = new Page(pageSize, pageNo, 0);
		BPrdWkflowCopExample example = new BPrdWkflowCopExample();
		BPrdWkflowCopExample.Criteria criteria = example.createCriteria();
		if(value != null && null != value.get("flowCopId") && !"".equals(value.get("flowCopId")))
		{
			criteria.andFlowCopIdLike("%" + value.get("flowCopId").toString().trim() + "%");
		}
		if(value != null && null != value.get("flowName") && !"".equals(value.get("flowName")))
		{
			criteria.andFlowNameLike("%" + value.get("flowName").toString().trim() + "%");
		}
		example.setOrderByClause("FLOW_COP_ID");
		bPrdWkflowCopDao.selectByPage(example, p);
		return p;
	}

	/**
	 * 角色筛选
	 * @param pageNo
	 * @param pageSize
	 * @param bctlVO
	 * @return
	 */
	public Page selectRoleInfo(int pageNo, int pageSize, RoleInfoVO roleInfoVO)
	{
		Page p = new Page(pageSize, pageNo, 0);
		p = roleService.select(pageNo, pageSize, roleInfoVO);
		return p;
	}

	/**
	 * 通知书类型筛选
	 * 不能根据名称查询：接口不支持	 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	@Override
	public Page selectNoticeType(int pageNo, int pageSize, Map<String, String> value)
	{
		log.debug("selectNoticeType传递参数,value=" + value);
		Page p = new Page(pageSize, pageNo, 0);
		String noticeTypeVal = "";
		List<DataItem> dataLists = BDDataUtil.getDefaultDateItems(ScfBasConstant.DICT_CODE_NTETYPE);
		List<DataItem> dataList = new ArrayList<DataItem>();
		if(value != null && value.get("noticeType") != null)
		{
		}
		else if(value != null && value.get("noticeTypeVal") != null)
		{
			noticeTypeVal = value.get("noticeTypeVal").toString().trim();
		}
		if(StringUtil.isEmpty(noticeTypeVal))
		{
			dataList = dataLists;
		}
		else
		{
			if(dataLists!=null&&dataLists.size()>0)
			{
				for(DataItem item:dataLists)
				{
					String dataTrsVal = item.getDataTrsVal();
					if(dataTrsVal.contains(noticeTypeVal))
					{
						dataList.add(item);
					}
				}
			}
		}
		// 根据返回的list 分页
		int totalRecord = dataList.size(); // 总条数
		int t = totalRecord / pageSize;
		int totalPage = totalRecord % pageSize != 0 ? ++t : t; // 总页数
		List<DataItem> list = new ArrayList<DataItem>();
		if(totalRecord > 0)
		{
			if(pageNo <= totalPage)
			{
				if(pageNo == 1)
				{
					if(totalRecord <= pageSize)
					{
						list = dataList.subList(0, totalRecord);
					}
					else
					{
						list = dataList.subList(0, pageSize);
					}
				}
				else
				{
					int start = (pageNo - 1) * pageSize;
					int end = pageNo * pageSize;
					if((totalRecord - end) % pageSize >= 0)
					{
						end = pageNo * pageSize;
					}
					else
					{
						end = (pageNo - 1) * pageSize + totalRecord % pageSize;
					}
					if(totalRecord >= end)
					{
						list = dataList.subList(start, end);
					}
					else
					{
						list = null;
					}

				}

			}
		}
		p.setRecords(list);
		p.setTotal(totalRecord);
		p.setTotalPage(totalPage);
		return p;
	}

	/**
	 * 保险公司信息（适用于保理公司查询）
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月13日上午11:20:15
	 */
	@Override
	public Page selectBCrmBaseInfo(int pageNo, int pageSize, Map<String, Object> value) throws ScubeBizException
	{
		BCrmBaseInfoExample example = new BCrmBaseInfoExample();
		BCrmBaseInfoExample.Criteria cri = example.createCriteria();
		// 客户类型：1-法人;2-自然人;3-同业
		if(value != null && value.get("custType") != null && value.get("custType") != "")
		{
			cri.andCustTypeEqualTo(value.get("custType").toString());
		}
		// CREDIT_FLAG 授信客户标识：0-否、1-是
		if(value != null && value.get("creditFlag") != null && value.get("creditFlag") != "")
		{
			cri.andCreditFlagEqualTo(value.get("creditFlag").toString());
		}
		// CORE_FLAG 是否核心厂商：0-否、1-是
		if(value != null && value.get("coreFlag") != null && value.get("coreFlag") != "")
		{
			cri.andCoreFlagEqualTo(value.get("coreFlag").toString());
		}
		// MONI_FLAG 是否监管公司：0-否、1-是
		if(value != null && value.get("moniFlag") != null && value.get("moniFlag") != "")
		{
			cri.andMoniFlagEqualTo(value.get("moniFlag").toString());
		}
		// FUTURES_FLAG 是否期货经纪公司：0-否、1-是
		if(value != null && value.get("futuresFlag") != null && value.get("futuresFlag") != "")
		{
			cri.andFuturesFlagEqualTo(value.get("futuresFlag").toString());
		}
		// FLC_FLAG 是否金融租赁公司：0-否、1-是
		if(value != null && value.get("flcFlag") != null && value.get("flcFlag") != "")
		{
			cri.andFlcFlagEqualTo(value.get("flcFlag").toString());
		}
		// INSURE_FLAG 是否保险公司：0-否、1-是
		if(value != null && value.get("insureFlag") != null && value.get("insureFlag") != "")
		{
			cri.andInsureFlagEqualTo(value.get("insureFlag").toString());
		}
		// FACTOR_FLAG 是否保理商：0-否、1-是
		if(value != null && value.get("factorFlag") != null && value.get("factorFlag") != "")
		{
			cri.andFactorFlagEqualTo(value.get("factorFlag").toString());
		}
		// IMPORTANT_FLAG 是否贸融重点客户：0-否、1-是
		if(value != null && value.get("importantFlag") != null && value.get("importantFlag") != "")
		{
			cri.andImportantFlagEqualTo(value.get("importantFlag").toString());
		}
		// COMMERCIAL_FALG 是否贸易对手：0-否、1-是
		if(value != null && value.get("commercialFalg") != null && value.get("commercialFalg") != "")
		{
			cri.andCommercialFalgEqualTo(value.get("commercialFalg").toString());
		}
		// OVERSEAS_FLAG 是否境外：0-否、1-是
		if(value != null && value.get("overseasFlag") != null && value.get("overseasFlag") != "")
		{
			cri.andOverseasFlagEqualTo(value.get("overseasFlag").toString());
		}
		// BANKS_CUST_FLAG 是否是本行客户：0-否、1-是
		if(value != null && value.get("banksCustFlag") != null && value.get("banksCustFlag") != "")
		{
			cri.andBanksCustFlagEqualTo(value.get("banksCustFlag").toString());
		}
		// EF_BUYER_FLAG 是否是EF进口商：0-否、1-是
		if(value != null && value.get("efBuyerFlag") != null && value.get("efBuyerFlag") != "")
		{
			cri.andEfBuyerFlagEqualTo(value.get("efBuyerFlag").toString());
		}
		// IF_SELLER_FLAG 是否是IF出口商：0-否、1-是
		if(value != null && value.get("ifSellerFlag") != null && value.get("ifSellerFlag") != "")
		{
			cri.andIfSellerFlagEqualTo(value.get("ifSellerFlag").toString());
		}
		// IS_BANK 是否是银行：0-否、1-是
		if(value != null && value.get("isBank") != null && value.get("isBank") != "")
		{
			cri.andIsBankEqualTo(value.get("isBank").toString());
		}
		// IS_INTL 是否国际保理客户
		if(value != null && value.get("isIntl") != null && value.get("isIntl") != "")
		{
			cri.andIsIntlEqualTo(value.get("isIntl").toString());
		}
		if(value != null && value.get("custcd") != null && value.get("custcd") != "")
		{
			cri.andCustcdEqualTo(value.get("custcd").toString());
		}
		if(value != null && value.get("cname") != null && value.get("cname") != "")
		{
			cri.andCnameEqualTo(value.get("cname").toString());
		}
		int total = bcrmbaseinfodao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(bcrmbaseinfodao.selectByPage(example, page));
		return page;
	}
}
