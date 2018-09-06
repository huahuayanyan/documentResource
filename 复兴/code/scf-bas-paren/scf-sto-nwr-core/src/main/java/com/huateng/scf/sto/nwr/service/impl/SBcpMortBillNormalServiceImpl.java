package com.huateng.scf.sto.nwr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IQualityApplyService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.dao.ISBcpMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.ext.ExtSBcpNwrDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormalExample;
import com.huateng.scf.sto.nwr.model.SBcpMortBillNormalVO;
import com.huateng.scf.sto.nwr.service.IBillStandardPledgeAppService;
import com.huateng.scf.sto.nwr.service.ISBcpAppliMortBillNormalService;
import com.huateng.scf.sto.nwr.service.ISBcpBillNormalInOutService;
import com.huateng.scf.sto.nwr.service.ISBcpMortBillNormalService;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scf.sto.nwr.vo.BillStandardMortgageBaseVO;
import com.huateng.scf.sto.nwr.vo.BillstandardMortgageQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>非标仓单管理	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月12日下午4:05:56
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月12日下午4:05:56	     新增
 *
 * </pre>
 */
@ScubeService
@Service("SBcpMortBillNormalServiceImpl")
public class SBcpMortBillNormalServiceImpl implements ISBcpMortBillNormalService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ISBcpMortBillNormalDAO")
	ISBcpMortBillNormalDAO sbcpmortbillnormaldao;
	
	@Resource(name = "ExtSBcpNwrDAO")
	ExtSBcpNwrDAO extsbcpnwrdao;
	
	//仓单质押申请
	@Resource(name = "BillStandardPledgeAppServiceImpl")
	IBillStandardPledgeAppService billstandardpledgeappservice;
	
	//产品公共类
	@Resource(name = "ProductServiceImpl")
	IProductService productService;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	//出质入库申请
	@Resource(name = "QualityApplyServiceImpl")
	IQualityApplyService qualityapplyservice;
	
	@Resource(name = "SBcpAppliMortBillNormalServiceImpl")
	ISBcpAppliMortBillNormalService sbcpapplimortbillnormalservice;
	
	@Resource(name = "SBcpBillNormalInOutServiceImpl")
	ISBcpBillNormalInOutService sbcpbillnormalinoutservice;
	
	/**
	 * 新增仓单信息
	 * @param billNormalVO
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午3:09:47
	 */
	@Override
	@Transactional
	public String save(SBcpMortBillNormalVO billNormalVO)
	{
		SBcpMortBillNormal bcpMortBillNormal = new SBcpMortBillNormal();
		try
		{
			BeanUtils.copyProperties(billNormalVO, bcpMortBillNormal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常",RBcpErrorConstant.SCF_REC_BCP_10001);
		}
		try
		{
			sbcpmortbillnormaldao.insertSelective(bcpMortBillNormal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return billNormalVO.getBillno();
	}
	
	/**
	 * 修改仓单基本信息
	 * @param bcpMortBillNormalVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午4:11:25
	 */
	@Override
	@Transactional
	public int update(SBcpMortBillNormalVO billNormalVO)
	{
		int i=0;
		SBcpMortBillNormal bcpMortBillNormal = new SBcpMortBillNormal();
		try
		{
			BeanUtils.copyProperties(billNormalVO, bcpMortBillNormal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			sbcpmortbillnormaldao.updateByPrimaryKeySelective(bcpMortBillNormal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		return i;
	}
	
	/**
	 * 删除仓单基本信息
	 * @param list
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午4:22:01
	 */
	@Override
	@Transactional
	public int batchDelete(List<SBcpMortBillNormalVO> list)
	{
		int x = 0;
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				String billno = list.get(i).getBillno();
				x += sbcpmortbillnormaldao.deleteByPrimaryKey(billno);
			}
		}
		return x;
	}
	
	/**
	 * 查询仓单列表信息
	 * @param pageNo
	 * @param pageSize
	 * @param sbcpMortBillNormalVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月12日下午4:10:15
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page findSBcpMortBillNormalByPage(int pageNo, int pageSize, BillNormalVO billNormalVO)
	{
		log.debug("仓单信息列表查询=============");
		billNormalVO.setPageIndex(pageNo);
		billNormalVO.setPageSize(pageSize);
		String supplyChainPdId=productService.getBillByMidProductId(ScfBasConstant.BILL_TYPE_NORMAL);
		billNormalVO.setSupplyChainPdId(supplyChainPdId);//设置业务品种
		
		Page p = billstandardpledgeappservice.getNormalList(billNormalVO);
		List list = p.getRecords();
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				HashMap<String, Object> map = (HashMap<String, Object>) list.get(i);
				String signDate = map.get("signDate")==null?"": map.get("signDate").toString();
				map.put("signDate", signDate);
			}
		}
		p.setRecords(list);
		return p;
	}
	
	/**
	 * 获取机构号
	 * @param brcode
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午1:43:50
	 */
	@Override
	public String getBrName(String brcode)
	{
		String brcodename = "";
		if(StringUtil.isEmpty(brcode))
		{
			brcodename = ContextHolder.getOrgInfo().getBrName();
		}
		else
		{
			BctlVO bctlvo = scubeUserService.selectBctlByBrNo(brcode, ScfCommonUtil.getBrManagerNo(scubeUserService));
			if(bctlvo!=null)
			{
				brcodename = bctlvo.getBrName();
			}
		}
		return brcodename;
	}
	
	/**
	 * 标准仓单添加
	 * @param billNormal
	 * @param insertList
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午2:11:07
	 */
	@Override
	public void BillNormalSaveUpdate(BillNormalVO billNormal,List<SBcpMortBillNormalVO> insertList)
	{
		billstandardpledgeappservice.billnormalAdd(billNormal, insertList);
	}
	
	/**
	 * 标准仓单押品查询
	 * @param mortgageQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午4:43:35
	 */
	@Override
	public Page BillstandardMortgageBaseGetter(int pageNo, int pageSize, BillstandardMortgageQryVO mortgageQryVO)
	{
		String billno_Q = mortgageQryVO.getBillno();// 仓单号
		String appno_Q = mortgageQryVO.getAppno();
		Page pageQueryResult=new Page(pageSize, pageNo, 0);

		if(!StringUtil.isEmpty(appno_Q))
		{
			AppliMortgageBaseQryVO appliMortgageBaseQryVO=new AppliMortgageBaseQryVO();
			appliMortgageBaseQryVO.setAppno_Q(appno_Q);
			appliMortgageBaseQryVO.setBillno(billno_Q);
			appliMortgageBaseQryVO.setPageIndex(pageNo);
			appliMortgageBaseQryVO.setPageSize(pageSize);
			appliMortgageBaseQryVO.setSelectFlag(true);
			pageQueryResult = qualityapplyservice.getApplyMortgageList(appliMortgageBaseQryVO);
			if(pageQueryResult.getTotalRecord()>0&&pageQueryResult!=null){
				return pageQueryResult;
			}
		}
		mortgageQryVO.setPageIndex(pageNo);
		mortgageQryVO.setPageSize(pageSize);
		pageQueryResult = billstandardpledgeappservice.billstandardMortgageQuery(mortgageQryVO);
		return pageQueryResult;
	}
	
	/**
	 * 仓单押品保存与修改
	 * @param mortgageBaseVO 填装押品列表信息
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午7:29:23
	 */
	@Override
	public void BillstandardMortgageSaveUpdate(BillStandardMortgageBaseVO mortgageBaseVO)
	{
		String slaveContno = mortgageBaseVO.getSlaveContno();// 担保合同编号
		String flag = mortgageBaseVO.getFlag();
		if("add".equals(flag)){
			// 新增出质清单（押品列表）
			billstandardpledgeappservice.billstandardMorgAdd(slaveContno, mortgageBaseVO);
		}
		else if("update".equals(flag))
		{
			// 修改出质清单（押品列表）
			billstandardpledgeappservice. billstandardMorgModity(slaveContno,mortgageBaseVO);
		}
		else if("delete".equals(flag)){
			billstandardpledgeappservice.billstandardMorgDelete(mortgageBaseVO.getMortgageNo());
		}
	}
	
	/**
	 * 查询S_BCP_MORT_BILL_NORMAL表记录
	 * @param mortgageQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午2:36:25
	 */
	@Override
	public Page queryMortgageBillNormal(BillNormalMortgageQryVO mortgageQryVO) throws ScubeBizException 
	{
		SBcpMortBillNormalExample example = new SBcpMortBillNormalExample();
		SBcpMortBillNormalExample.Criteria cri = example.createCriteria();
		if (!StringUtil.isEmpty(mortgageQryVO.getStatus())) 
		{
			cri.andStatusEqualTo(mortgageQryVO.getStatus());
		}
		if (!StringUtil.isEmpty(mortgageQryVO.getSlaveContno())) 
		{ // 从合同号
			cri.andSlaveContnoEqualTo(mortgageQryVO.getSlaveContno());
		}
		if (!StringUtil.isEmpty(mortgageQryVO.getBillno())) 
		{
			cri.andBillnoEqualTo(mortgageQryVO.getBillno());
		}
		int total = sbcpmortbillnormaldao.countByExample(example);
		Page page = new Page(mortgageQryVO.getPageSize(), mortgageQryVO.getPageIndex(), total);
		page.setRecords(sbcpmortbillnormaldao.selectByPage(example, page));
		return page;
	}
	

	/**
	 * 获取在押仓单清单列表信息
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日上午9:13:59
	 */
	@Override
	public Page getBillNormalBasicListPQResult(BillNormalAppVO billNormalAppVO) throws ScubeBizException 
	{
		SBcpMortBillNormalExample example = new SBcpMortBillNormalExample();
		SBcpMortBillNormalExample.Criteria cri = example.createCriteria();
		List<String> statusList = new ArrayList<String>();
		//质押  status 为1 是质押
		statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
		statusList.add(ScfBasConstant.BILL_MANAGE_STATUS_IN);

		if (!StringUtil.isEmpty(billNormalAppVO.getMastContno()))
		{
			cri.andMastContnoEqualTo(billNormalAppVO.getMastContno());
		}
		if (!StringUtil.isEmpty(billNormalAppVO.getSlaveContno())) 
		{
			cri.andSlaveContnoEqualTo(billNormalAppVO.getSlaveContno());
		}
		if(statusList!=null&&statusList.size()>0)
		{
			cri.andStatusIn(statusList);
		}
		int total = sbcpmortbillnormaldao.countByExample(example);
		Page page = new Page(billNormalAppVO.getPageSize(), billNormalAppVO.getPageIndex(), total);
		page.setRecords(sbcpmortbillnormaldao.selectByPage(example, page));
		page.setTotalRecord(total);
		return page;
	}
	
	/**
	 * 解押出库申请：复制业务申请用仓单申请基本信息 到 更新仓单基本信息表、新增出入库信息表（工作流用到）
	 * @param bussAppno
	 * @param pid
	 * @param appBaseInfo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午4:55:50
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void copyNormalUpledgeAppInfoToBill(String appno,String pid,BPbcAppliBaseInfo appBaseInfo) throws ScubeBizException
	{
		List<SBcpAppliMortBillNormal> appliStandardBillList = sbcpapplimortbillnormalservice.findByProperty(appno);
		if(appliStandardBillList!=null&&appliStandardBillList.size()>0)
		{
			for (SBcpAppliMortBillNormal appliMortBillNormal:appliStandardBillList) 
			{
				// 仓单基本信息表
				SBcpMortBillNormal bcpMortBillNormal = sbcpmortbillnormaldao.selectByPrimaryKey(appliMortBillNormal.getBillno());
				SBcpMortBillNormalVO billNormalVO = new SBcpMortBillNormalVO();
				BeanUtils.copyProperties(bcpMortBillNormal, billNormalVO);
				//新增标准仓单流水信息表信息
				sbcpbillnormalinoutservice.addTblBillNormalInOutInfo(billNormalVO, appno, pid, ScfBasConstant.IN_OUT_STATUS_DELIVERY);
				billNormalVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE); // 状态更新
				this.update(billNormalVO);//更新仓单信息（状态置为解押）
			}
		}
	}
	
	/**
	 * 置换管理仓单信息获取--普通预入库
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日下午3:20:34
	 */
	@Override
	public Page getBillInfoForUnplrdgeListByParam(BillNormalVO commonQueryVO) throws ScubeBizException
	{
		SBcpMortBillNormalExample example = new SBcpMortBillNormalExample();
		SBcpMortBillNormalExample.Criteria cri = example.createCriteria();
		if (!StringUtil.isEmpty(commonQueryVO.getBillno()))
		{
			cri.andBillnoEqualTo(commonQueryVO.getBillno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno()))
		{
			cri.andMastContnoEqualTo(commonQueryVO.getMastContno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getSlaveContno()))
		{
			cri.andSlaveContnoEqualTo(commonQueryVO.getSlaveContno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getStatus()))
		{
			cri.andStatusEqualTo(commonQueryVO.getStatus());
		}
		
		int total = sbcpmortbillnormaldao.countByExample(example);
		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), total);
		page.setRecords(sbcpmortbillnormaldao.selectByPage(example, page));
		return page;
	}
}
