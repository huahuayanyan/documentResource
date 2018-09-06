package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.acc.dao.IBAccAccountInfoDAO;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.dao.IRBcpDuebillAppDAO;
import com.huateng.scf.nrec.bcp.dao.IRBcpDuebillRegisterDAO;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillApp;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillAppExample;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillRegister;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillRegisterExample;
import com.huateng.scf.nrec.bcp.model.RBcpDuebillRegisterVO;
import com.huateng.scf.nrec.bcp.service.IRBcpDuebillRegisterService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>出账登记	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月26日下午1:20:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月26日下午1:20:27	     新增
 *
 * </pre>
 */
@ScubeService
@Service("RBcpDuebillRegisterServiceImpl")
public class RBcpDuebillRegisterServiceImpl implements IRBcpDuebillRegisterService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IRBcpDuebillRegisterDAO")
	IRBcpDuebillRegisterDAO rbcpduebillregisterdao;

	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;
	
	@Resource(name = "IRBcpDuebillAppDAO")
	IRBcpDuebillAppDAO rbcpduebillappdao;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "BAccAccountInfoDAO")
	IBAccAccountInfoDAO baccaccountinfodao;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;//业务编号生成器
	
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO blanlncibasedao;
	
	/**
	 * 出账登记列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDuebillRegisterVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午2:08:31
	 */
	@Override
	public Page queryRBcpDuebillRegisterByPage(int pageNo, int pageSize, RBcpDuebillRegisterVO rBcpDuebillRegisterVO) {
		log.debug("出账登记列表查询===========================");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (rBcpDuebillRegisterVO != null) {
			//融资企业
			if(!StringUtil.isEmpty(rBcpDuebillRegisterVO.getCname()))
			{
				omap.put("cname", rBcpDuebillRegisterVO.getCname());
			}
			//贸易对手
			if(!StringUtil.isEmpty(rBcpDuebillRegisterVO.getBusinessName()))
			{
				omap.put("businessName", rBcpDuebillRegisterVO.getBusinessName());
			}
			//出账凭证号
			if(!StringUtil.isEmpty(rBcpDuebillRegisterVO.getReceiveNo()))
			{
				omap.put("receiveNo", rBcpDuebillRegisterVO.getReceiveNo());
			}
			//合同编号
			if(!StringUtil.isEmpty(rBcpDuebillRegisterVO.getMastContno()))
			{
				omap.put("mastContno", rBcpDuebillRegisterVO.getMastContno());
			}
			//放款编号
			if(!StringUtil.isEmpty(rBcpDuebillRegisterVO.getAppno()))
			{
				omap.put("appno", rBcpDuebillRegisterVO.getAppno());
			}
			//业务品种
			if(!StringUtil.isEmpty(rBcpDuebillRegisterVO.getSupplyChainPdId()))
			{
				omap.put("supplyChainPdId", rBcpDuebillRegisterVO.getSupplyChainPdId());
			}
			//状态
			if(!StringUtil.isEmpty(rBcpDuebillRegisterVO.getState()))
			{
				omap.put("state", rBcpDuebillRegisterVO.getState());
			}
			//开始日期
			if(!StringUtil.isEmpty(rBcpDuebillRegisterVO.getStartDate()))
			{
				omap.put("startDate", rBcpDuebillRegisterVO.getStartDate());
			}
			//结束日期
			if(!StringUtil.isEmpty(rBcpDuebillRegisterVO.getEndDate()))
			{
				omap.put("endDate", rBcpDuebillRegisterVO.getEndDate());
			}
		}
		//查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		omap.putAll(map);
		int total = extnrecbcpdao.countRBcpDuebillRegister(omap);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(extnrecbcpdao.queryRBcpDuebillRegister(omap,page));
		page.setTotalRecord(total);
		return page;
	}
	
	/**
	 * 根据融资客户筛选放款信息
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午2:36:45
	 */
	@Override
	public Page getAppnoByCustcd(int pageNo, int pageSize, HashMap<String, String> value) throws ScubeBizException
	{
		RBcpDuebillAppExample example = new RBcpDuebillAppExample();
		RBcpDuebillAppExample.Criteria cri = example.createCriteria();
		if (value!=null)
		{
			if(!StringUtil.isEmpty(value.get("custcd")))
			{
				cri.andCustcdEqualTo(value.get("custcd").toString().trim());
			}
			if(!StringUtil.isEmpty(value.get("appno")))
			{
				cri.andAppnoEqualTo(value.get("appno").toString().trim());
			}
		}
		else
		{
			throw new ScubeBizException("请先选择融资客户！");
		}
		//放款通过
		cri.andAppStatEqualTo(WorkflowConstant.APPLI_STATUS_APPROVED);
		//放款申请余额大于0
		cri.andLnSumGreaterThan(BigDecimal.ZERO);
		int total = rbcpduebillappdao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(rbcpduebillappdao.selectByPage(example, page));
		page.setTotalRecord(total);
		return page;
	}
	
	/**
	 * 根据主键或放款编号查询信息
	 * @param rBcpDuebillRegisterVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午2:51:01
	 */
	@Override
	public RBcpDuebillRegisterVO findRBcpDuebillRegisterByAppno(RBcpDuebillRegisterVO rBcpDuebillRegisterVO)
	{
		RBcpDuebillRegisterVO registerVO = null;
		if(!StringUtil.isEmpty(rBcpDuebillRegisterVO.getId()))
		{
			RBcpDuebillRegister duebillRegister = rbcpduebillregisterdao.selectByPrimaryKey(rBcpDuebillRegisterVO.getId());
			if(duebillRegister!=null)
			{
				registerVO = new RBcpDuebillRegisterVO();
				BeanUtils.copyProperties(duebillRegister, registerVO);
			}
			RBcpDuebillApp bcpDuebillApp = rbcpduebillappdao.selectByPrimaryKey(duebillRegister.getAppno());
			registerVO.setDueAmount(bcpDuebillApp.getLnSum());
		}
		else
		{
			String appno = rBcpDuebillRegisterVO.getAppno();
			if(!StringUtil.isEmpty(appno))
			{
				RBcpDuebillApp bcpDuebillApp = rbcpduebillappdao.selectByPrimaryKey(appno);
				if(bcpDuebillApp!=null)
				{
					registerVO = new RBcpDuebillRegisterVO();
					BeanUtils.copyProperties(bcpDuebillApp, registerVO);
					registerVO.setStartDate("");
					registerVO.setEndDate("");
					registerVO.setDueAmount(bcpDuebillApp.getLnSum());
					registerVO.setLnAmt(bcpDuebillApp.getLnSum());
				}
			}
		}
		if(registerVO!=null)
		{
			registerVO.setCname(bcrmbaseinfodao.selectById(registerVO.getCustcd()).getCname());
			registerVO.setBusinessName(bcrmbaseinfodao.selectById(registerVO.getBusinessCustcd()).getCname());
			
			if(!StringUtil.isEmpty(registerVO.getActBrCd()))
			{
				registerVO.setActBrNm(bcrmbaseinfodao.selectById(registerVO.getActBrCd()).getCname());
			}
			BAccAccountInfoExample example1 = new BAccAccountInfoExample();
			BAccAccountInfoExample.Criteria cri = example1.createCriteria();
			//结算账号、收款账号信息
			cri.andAccountNoEqualTo(registerVO.getAccountNo());
			cri.andAccountTypeEqualTo("1");
			cri.andCustcdEqualTo(registerVO.getCustcd());
			List<BAccAccountInfo> list1 = baccaccountinfodao.selectByExample(example1);
			if(list1!=null&&list1.size()>0)
			{
				BAccAccountInfo accountInfo = list1.get(0);
				registerVO.setAccountName(accountInfo.getAccountName());
				registerVO.setAccountBank(accountInfo.getOpenAccBankNm());
			}
			//回款账号信息
			BAccAccountInfoExample example2 = new BAccAccountInfoExample();
			cri = example2.createCriteria();
			cri.andAccountNoEqualTo(registerVO.getReturnAccount());
			cri.andAccountTypeEqualTo("2");
			cri.andCustcdEqualTo(registerVO.getCustcd());
			List<BAccAccountInfo> list2 = baccaccountinfodao.selectByExample(example2);
			if(list2!=null&&list2.size()>0)
			{
				BAccAccountInfo accountInfo = list2.get(0);
				registerVO.setReturnAccountName(accountInfo.getAccountName());
				registerVO.setReturnAccountBank(accountInfo.getOpenAccBankNm());
			}
			//资金提供方账号信息
			if(!StringUtil.isEmpty(registerVO.getPayActNo()))
			{
				BAccAccountInfoExample example3 = new BAccAccountInfoExample();
				cri = example3.createCriteria();
				cri.andAccountNoEqualTo(registerVO.getPayActNo());
				cri.andAccountTypeEqualTo("1");
				cri.andCustcdEqualTo(registerVO.getActBrCd());
				List<BAccAccountInfo> list3 = baccaccountinfodao.selectByExample(example3);
				if(list3!=null&&list3.size()>0)
				{
					BAccAccountInfo accountInfo = list3.get(0);
					registerVO.setPayActName(accountInfo.getAccountName());
					registerVO.setPayActBank(accountInfo.getOpenAccBankNm());
				}
			}
			registerVO.setFeeAmt(registerVO.getActInt().multiply(registerVO.getLnAmt()).divide(new BigDecimal(100)));
		}
		return registerVO;
	}
	
	/**
	 * 保存或修改出账登记信息
	 * @param rBcpDuebillRegisterVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午4:25:04
	 */
	@Override
	@Transactional
	public String saveAndUpdate(RBcpDuebillRegisterVO rBcpDuebillRegisterVO)
	{
		String id = rBcpDuebillRegisterVO.getId();
		RBcpDuebillRegister register = new RBcpDuebillRegister();
		try
		{
			BeanUtils.copyProperties(rBcpDuebillRegisterVO, register);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		if(!StringUtil.isEmpty(id))
		{
			if(rBcpDuebillRegisterVO.getState().equals(ScfBasConstant.DUE_REGISTERSTATE_1))
			{
				register.setState(rBcpDuebillRegisterVO.getState());
				RBcpDuebillApp bcpDuebillApp = rbcpduebillappdao.selectByPrimaryKey(register.getAppno());
				bcpDuebillApp.setLnSum(bcpDuebillApp.getLnSum().subtract(register.getLnAmt()));
				rbcpduebillappdao.updateByPrimaryKeySelective(bcpDuebillApp);
			}
			try
			{
				rbcpduebillregisterdao.updateByPrimaryKeySelective(register);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("出账登记信息更新异常");
			}
		}
		else
		{
			if(rBcpDuebillRegisterVO.getState().equals(ScfBasConstant.DUE_REGISTERSTATE_1))
			{
				register.setState(rBcpDuebillRegisterVO.getState());
				RBcpDuebillApp bcpDuebillApp = rbcpduebillappdao.selectByPrimaryKey(register.getAppno());
				bcpDuebillApp.setLnSum(bcpDuebillApp.getLnSum().subtract(register.getLnAmt()));
				rbcpduebillappdao.updateByPrimaryKeySelective(bcpDuebillApp);
			}
			id = ibSysSerialNoService.genSerialNo("FCZ_APP_NO");
			register.setId(id);
			try
			{
				rbcpduebillregisterdao.insertSelective(register);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("出账登记信息保存异常");
			}
		}
		return id;
	}
	
	/**
	 * 删除出账登记信息
	 * @param rBcpDuebillRegisterVO
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午4:25:48
	 */
	@Override
	@Transactional
	public void delete(RBcpDuebillRegisterVO rBcpDuebillRegisterVO)
	{
		try
		{
			rbcpduebillregisterdao.deleteByPrimaryKey(rBcpDuebillRegisterVO.getId());
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("出账登记信息删除异常");
		}
	}
	
	/**
	 * 出账确认
	 * @param rBcpDuebillRegisterVO
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午5:12:55
	 */
	@Override
	public void submit(RBcpDuebillRegisterVO rBcpDuebillRegisterVO)
	{
		//更新放款申请剩余金额
		RBcpDuebillApp bcpDuebillApp = rbcpduebillappdao.selectByPrimaryKey(rBcpDuebillRegisterVO.getAppno());
		bcpDuebillApp.setLnSum(bcpDuebillApp.getLnSum().subtract(rBcpDuebillRegisterVO.getLnAmt()));
		rbcpduebillappdao.updateByPrimaryKeySelective(bcpDuebillApp);
		
		RBcpDuebillRegister register = new RBcpDuebillRegister();
		register.setId(rBcpDuebillRegisterVO.getId());
		register.setState(ScfBasConstant.DUE_REGISTERSTATE_1);
		try
		{
			rbcpduebillregisterdao.updateByPrimaryKeySelective(register);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("出账登记信息更新异常");
		}
	}
	
	/**
	 * 根据receiveNo查询出账登记信息
	 * @param receiveNo
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月8日下午7:54:07
	 */
	@Override
	public RBcpDuebillRegisterVO findRBcpDuebillRegisterByReceiveNo(String receiveNo)
	{
		RBcpDuebillRegisterVO registerVO = null;
		if(!StringUtil.isEmpty(receiveNo))
		{
			RBcpDuebillRegister duebillRegister = rbcpduebillregisterdao.selectByPrimaryKey(receiveNo);
			if(duebillRegister!=null)
			{
				registerVO = new RBcpDuebillRegisterVO();
				BeanUtils.copyProperties(duebillRegister, registerVO);
			}
			else
			{
				RBcpDuebillRegisterExample example = new RBcpDuebillRegisterExample();
				RBcpDuebillRegisterExample.Criteria cri = example.createCriteria();
				cri.andReceiveNoEqualTo(receiveNo);
				List<RBcpDuebillRegister> list = rbcpduebillregisterdao.selectByExample(example);
				if(list!=null&&list.size()>0)
				{
					registerVO = new RBcpDuebillRegisterVO();
					BeanUtils.copyProperties(list.get(0), registerVO);
				}
			}
		}
		if(registerVO!=null)
		{
			registerVO.setCname(bcrmbaseinfodao.selectById(registerVO.getCustcd()).getCname());
			registerVO.setBusinessName(bcrmbaseinfodao.selectById(registerVO.getBusinessCustcd()).getCname());
			
			if(!StringUtil.isEmpty(registerVO.getActBrCd()))
			{
				registerVO.setActBrNm(bcrmbaseinfodao.selectById(registerVO.getActBrCd()).getCname());
			}
			BAccAccountInfoExample example1 = new BAccAccountInfoExample();
			BAccAccountInfoExample.Criteria cri = example1.createCriteria();
			//结算账号、收款账号信息
			cri.andAccountNoEqualTo(registerVO.getAccountNo());
			cri.andAccountTypeEqualTo("1");
			cri.andCustcdEqualTo(registerVO.getCustcd());
			List<BAccAccountInfo> list1 = baccaccountinfodao.selectByExample(example1);
			if(list1!=null&&list1.size()>0)
			{
				BAccAccountInfo accountInfo = list1.get(0);
				registerVO.setAccountName(accountInfo.getAccountName());
				registerVO.setAccountBank(accountInfo.getOpenAccBankNm());
			}
			//回款账号信息
			BAccAccountInfoExample example2 = new BAccAccountInfoExample();
			cri = example2.createCriteria();
			cri.andAccountNoEqualTo(registerVO.getReturnAccount());
			cri.andAccountTypeEqualTo("2");
			cri.andCustcdEqualTo(registerVO.getCustcd());
			List<BAccAccountInfo> list2 = baccaccountinfodao.selectByExample(example2);
			if(list2!=null&&list2.size()>0)
			{
				BAccAccountInfo accountInfo = list2.get(0);
				registerVO.setReturnAccountName(accountInfo.getAccountName());
				registerVO.setReturnAccountBank(accountInfo.getOpenAccBankNm());
			}
			//资金提供方账号信息
			if(!StringUtil.isEmpty(registerVO.getPayActNo()))
			{
				BAccAccountInfoExample example3 = new BAccAccountInfoExample();
				cri = example3.createCriteria();
				cri.andAccountNoEqualTo(registerVO.getPayActNo());
				cri.andAccountTypeEqualTo("1");
				cri.andCustcdEqualTo(registerVO.getActBrCd());
				List<BAccAccountInfo> list3 = baccaccountinfodao.selectByExample(example3);
				if(list3!=null&&list3.size()>0)
				{
					BAccAccountInfo accountInfo = list3.get(0);
					registerVO.setPayActName(accountInfo.getAccountName());
					registerVO.setPayActBank(accountInfo.getOpenAccBankNm());
				}
			}
//			registerVO.setFeeAmt(registerVO.getActInt().multiply(registerVO.getLnAmt()).divide(new BigDecimal(100)));
		}
		return registerVO;
	}
	
	/**
	 * 模拟银行返回凭证编号
	 * @param rBcpDuebillRegisterVO
	 * @author 	mengjiajia
	 * @date 	2017年6月26日下午5:23:04
	 */
	@Override
	public void BankCheckAndSendBillNo(RBcpDuebillRegisterVO rBcpDuebillRegisterVO)
	{
		//1.接收到的银行发送的凭证编号
		String receiveNo = ibSysSerialNoService.genSerialNo("FBK_APP_NO");
		RBcpDuebillRegister bcpDuebillRegister = new RBcpDuebillRegister();
		bcpDuebillRegister.setReceiveNo(receiveNo);
		bcpDuebillRegister.setId(rBcpDuebillRegisterVO.getId());
		bcpDuebillRegister.setState(ScfBasConstant.DUE_REGISTERSTATE_2);
		try
		{
			rbcpduebillregisterdao.updateByPrimaryKeySelective(bcpDuebillRegister);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("出账登记信息更新异常");
		}
		//2.修改借据状态为正常状态
		BLanLnciBase base = new BLanLnciBase();
		base.setState(ScfBasConstant.LNCI_STATE_0);//借据状态正常
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(rBcpDuebillRegisterVO.getAppno());
		try
		{
			blanlncibasedao.updateByExampleSelective(base, example);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("借据信息更新异常");
		}
		//3.修改放款申请为放款通过状态
//		RBcpDuebillApp bcpDuebillApp = new RBcpDuebillApp();
//		bcpDuebillApp.setAppno(rBcpDuebillRegisterVO.getAppno());
//		bcpDuebillApp.setAppStat(WorkflowConstant.APPLI_STATUS_CCMS_AGREE);
//		try
//		{
//			rbcpduebillappdao.updateByPrimaryKeySelective(bcpDuebillApp);
//		}
//		catch(BeansException e)
//		{
//			throw new ScubeBizException("放款申请信息更新异常");
//		}
	}
}
