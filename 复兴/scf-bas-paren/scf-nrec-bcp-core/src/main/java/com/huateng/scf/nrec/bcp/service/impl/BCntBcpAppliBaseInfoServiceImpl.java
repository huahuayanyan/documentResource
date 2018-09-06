package com.huateng.scf.nrec.bcp.service.impl;

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
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.cnt.model.DataItemsVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.constant.BCrmBaseConstants;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.prd.dao.model.BPrdInfoExample;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.model.BSysUploadFileVO;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.bas.sys.service.IBSysUploadFileService;
import com.huateng.scf.nbas.prd.dao.domodel.BPrdFileInfoDO;
import com.huateng.scf.nbas.prd.dao.ext.ExtNBPrdDAO;
import com.huateng.scf.nbas.prd.service.IBPrdFlowService;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpAppliBaseInfoDAO;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpExtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoDAO;
import com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpAppliBaseInfoDO;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpAppliBaseInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpAppliBaseInfoExample;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.model.BCntBcpAppliBaseInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpAppliBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>应收类业务申请 接口实现类</p>
 *
 * @author mengjiajia
 * @date 2017年5月19日下午3:50:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月19日下午3:50:51	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCntBcpAppliBaseInfoServiceImpl")
public class BCntBcpAppliBaseInfoServiceImpl
		implements IBCntBcpAppliBaseInfoService, DealEndFlowService, DealInFlowService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCntBcpAppliBaseInfoDAO")
	IBCntBcpAppliBaseInfoDAO bcntbcpapplibaseinfodao;

	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;

	@Autowired
	ScubeUserService scubeUserService;

	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bprdinfodao;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;// 业务编号生成器

	// 自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	// 业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;

	// 应收类合同管理表
	@Resource(name = "IBCntBcpInfoDAO")
	IBCntBcpInfoDAO bcntbcpinfodao;

	// 交易对手
	@Resource(name = "IBCntBcpExtInfoDAO")
	IBCntBcpExtInfoDAO bcntbcpextinfodao;

	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bbrpprdfactoringservice;

	// 产品流程绑定
	@Resource(name = "BPrdFlowServiceImpl")
	IBPrdFlowService bprdflowservice;

	@Resource(name = "ExtNBPrdDAO")
	ExtNBPrdDAO extnbprddao;

	@Resource(name = "BSysUploadFileServiceImpl")
	IBSysUploadFileService bsysuploadfileservice;

	/**
	 * 新增
	 * 
	 * @param bCntBcpAppliBaseInfoVO
	 * @author mengjiajia
	 * @date 2017年5月19日下午1:08:58
	 */
	@Override
	@Transactional
	public String add(BCntBcpAppliBaseInfoVO bCntBcpAppliBaseInfoVO)
	{
		String appno = ibSysSerialNoService.genSerialNo("FCNT_APP_NO");
		bCntBcpAppliBaseInfoVO.setAppno(appno);
		UserInfo user = ContextHolder.getUserInfo();
		String tlrNo = user.getTlrNo();
		String brCode = user.getBrNo();
		// 设置公共字段
		bCntBcpAppliBaseInfoVO.setAppBrcode(brCode);// 登记机构
		bCntBcpAppliBaseInfoVO.setApprover(tlrNo);
		bCntBcpAppliBaseInfoVO.setApproveTime(new Date());
		bCntBcpAppliBaseInfoVO.setAppDate(ScfDateUtil.getStringDate(new Date())); // 登记时间
		bCntBcpAppliBaseInfoVO.setAppTlrcd(tlrNo);// 登记人
		bCntBcpAppliBaseInfoVO.setExt1(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL);// 保存出账方式，默认流贷
		bCntBcpAppliBaseInfoVO.setStartTime(new Date()); // 流程启动时间
		if(StringUtil.isEmpty(bCntBcpAppliBaseInfoVO.getStratDate()))
		{
			bCntBcpAppliBaseInfoVO.setStratDate(ScfDateUtil.getStringDate(new Date())); // 流程启动日期
		}

		BCntBcpAppliBaseInfo appliBaseInfo = new BCntBcpAppliBaseInfo();
		try
		{
			BeanUtils.copyProperties(bCntBcpAppliBaseInfoVO, appliBaseInfo);
		}catch (BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcntbcpapplibaseinfodao.insertSelective(appliBaseInfo);
		}catch (BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return appno;
	}

	/**
	 * 修改
	 * 
	 * @param bCntBcpAppliBaseInfoVO
	 * @author mengjiajia
	 * @date 2017年5月19日下午1:08:58
	 */
	@Override
	@Transactional
	public void update(BCntBcpAppliBaseInfoVO bCntBcpAppliBaseInfoVO)
	{
		BCntBcpAppliBaseInfo appliBaseInfo = new BCntBcpAppliBaseInfo();
		try
		{
			BeanUtils.copyProperties(bCntBcpAppliBaseInfoVO, appliBaseInfo);
		}catch (BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcntbcpapplibaseinfodao.updateByPrimaryKeySelective(appliBaseInfo);
		}catch (BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
	}

	/**
	 * 删除
	 * 
	 * @param appno
	 * @author mengjiajia
	 * @date 2017年5月19日下午1:36:43
	 */
	@Override
	public List<String> delete(String appno)
	{
		// 1.删除文件信息
		List<String> picIds = new ArrayList<String>();
		List<BSysUploadFileVO> list = bsysuploadfileservice.findBSysUploadFileByAppno(appno);
		if(list != null && list.size() > 0)
		{
			for(BSysUploadFileVO fileVO : list)
			{
				picIds.add(fileVO.getId());
				bsysuploadfileservice.deleteBSysUploadById(fileVO.getId());
			}
		}
		// 2.删除业务申请信息
		try
		{
			bcntbcpapplibaseinfodao.deleteByPrimaryKey(appno);
		}catch (BeansException e)
		{
			throw new ScubeBizException("删除异常");
		}
		return picIds;
	}

	/**
	 * 提交并发起工作流
	 * 
	 * @param bCntBcpAppliBaseInfoVO
	 * @author mengjiajia
	 * @date 2017年5月19日下午2:06:34
	 */
	@Override
	@Transactional
	public void submitAndUpdate(BCntBcpAppliBaseInfoVO bCntBcpAppliBaseInfoVO)
	{
		bCntBcpAppliBaseInfoVO.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		bCntBcpAppliBaseInfoVO.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
		this.update(bCntBcpAppliBaseInfoVO);

		// 流程发起参数配置
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("modelId", WorkflowConstant.PROCNAME_FACTORING_CONT_APPLY);
		paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());

		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice
				.findBPbcAppliBaseInfoByKey(bCntBcpAppliBaseInfoVO.getAppno());
		if(appliBaseInfo == null)
		{
			appliBaseInfo = new BPbcAppliBaseInfo();// 通用业务申请表对象
			try
			{
				BeanUtils.copyProperties(bCntBcpAppliBaseInfoVO, appliBaseInfo);
			}catch (BeansException e)
			{
				throw new ScubeBizException("转换异常");
			}
			appliBaseInfo.setMoniCustcd(bCntBcpAppliBaseInfoVO.getBusinessCustcd());
			// 在通用业务申请表保存一笔数据，用于发起工作流
			bpbcapplibaseinfoservice.addBPbcAppliBaseInfo(appliBaseInfo);
		}
		scfWorkFlowService.FactoringProcessDone(appliBaseInfo);
		BCntBcpAppliBaseInfo baseInfo = bcntbcpapplibaseinfodao.selectByPrimaryKey(bCntBcpAppliBaseInfoVO.getAppno());
		appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(bCntBcpAppliBaseInfoVO.getAppno());
		if(StringUtil.isEmpty(baseInfo.getPiid()) && !StringUtil.isEmpty(appliBaseInfo.getPiid()))
		{
			baseInfo.setPiid(appliBaseInfo.getPiid());
			baseInfo.setExt2(appliBaseInfo.getExt2());
			bcntbcpapplibaseinfodao.updateByPrimaryKeySelective(baseInfo);
		}
	}

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
	public Page findBCntBcpAppliBaseInfoByPage(int pageNo, int pageSize, HashMap<String, Object> value)
	{
		log.debug("业务信息列表查询=============");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(value!=null)
		{
			omap.putAll(value);
		}
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		omap.putAll(map);
		int total = extnrecbcpdao.countBCntBcpAppliBaseInfoByPage(omap);
		Page page = new Page(pageSize, pageNo, total);
		List<BCntBcpAppliBaseInfoDO> result = extnrecbcpdao.findBCntBcpAppliBaseInfoByPage(omap, page);
		if(result != null && result.size() > 0)
		{
			for(BCntBcpAppliBaseInfoDO baseInfoDO : result)
			{
				UserInfo info = scubeUserService.selectUserByTlrNo(baseInfoDO.getStartTlrcd(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(info != null)
				{
					baseInfoDO.setStartTlrNm(info.getTlrName());
				}
				BctlVO bctl = scubeUserService.selectBctlByBrNo(baseInfoDO.getStartBrcode(),
						ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(bctl != null)
				{
					baseInfoDO.setStartBrName(bctl.getBrName());
				}
			}
		}
		page.setRecords(result);
		page.setTotalRecord(total);
		return page;
	}

	/**
	 * 获取客户信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月23日下午3:28:41
	 */
	@Override
	public Page queryBCrmBaseInfoSource(int pageNo, int pageSize, Map<String, String> value)
	{
		log.debug("传递参数,value=" + value);

		Map<String, Object> omap = new HashMap<String, Object>();
		if(value != null && !StringUtil.isEmpty(value.get("custcd")) && !StringUtil.isEmpty(value.get("cname")))
		{
			omap.put("custcd", value.get("custcd").trim());
			omap.put("cname", value.get("cname").trim());
		}
		if(value != null && !StringUtil.isEmpty(value.get("flag")))
		{
			omap.put("flag", value.get("flag").trim());
		}
		// flag2用于买方下拉菜单查询（筛选出只存在与贸易对手信息表中的客户）
		if(value != null && !StringUtil.isEmpty(value.get("flag2")))
		{
			omap.put("flag2", value.get("flag2").trim());
		}
		if(value != null && !StringUtil.isEmpty(value.get("isBank")))
		{
			omap.put("isBank", value.get("isBank").trim());
		}
		// 查询权限设置
//		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
//		omap.putAll(map);
		int total = extnrecbcpdao.countBCrmBaseInfoSource(omap);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(extnrecbcpdao.queryBCrmBaseInfoSource(omap, page));
		page.setTotalRecord(total);
		return page;
	}

	/**
	 * 获取贸易对手信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月22日下午3:53:19
	 */
	@Override
	public Page queryBCrmBaseBusinessInfo(int pageNo, int pageSize, Map<String, String> value)
	{
		log.debug("传递参数,value=" + value);
		if(value == null || StringUtil.isEmpty(value))
		{
			throw new ScubeBizException("融资企业未选择");
		}
		if(StringUtil.isEmpty(value.get("custcd")))
		{
			throw new ScubeBizException("融资企业未选择");
		}
		Map<String, Object> omap = new HashMap<String, Object>();
		if(!StringUtil.isEmpty(value.get("custcd")))
		{
			omap.put("custcd", value.get("custcd").toString().trim());
		}
		if(!StringUtil.isEmpty(value.get("businessCustcd")) && !StringUtil.isEmpty(value.get("businessCname")))
		{
			omap.put("businessCustcd", value.get("businessCustcd").toString().trim());
			omap.put("businessCname", value.get("businessCname").toString().trim());
		}
		omap.put("custStatus", BCrmBaseConstants.CUST_STATUS_VALID); // 有效
		if(BSysConstant.FLAG_ON.equals(value.get("coreFlag")))
		{
			// 核心企业
			omap.put("coreFlag", BSysConstant.FLAG_ON);
		}
		if(value != null && value.get("custType") != null)
		{
			omap.put("custType", value.get("custType").toString().trim());
		}
		omap.put("coreRelationFlg", BCrmBaseConstants.CORE_RELATION_FLG_UP);
		int total = extnrecbcpdao.countBCrmBaseBusinessInfo(omap);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(extnrecbcpdao.queryBCrmBaseBusinessInfo(omap, page));
		page.setTotalRecord(total);
		return page;
	}

	/**
	 * 业务品种筛选
	 * 
	 * @param dataItemsDO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月19日上午11:15:21
	 */
	@Override
	public List<DataItemsVO> getProductId(com.huateng.scf.bas.prd.model.BPrdInfo bPrdInfo) throws ScubeBizException
	{
		List<DataItemsVO> dataItemsList = new ArrayList<DataItemsVO>();
		BPrdInfoExample example = new BPrdInfoExample();
		BPrdInfoExample.Criteria e = example.createCriteria();
		if(!StringUtil.isEmpty(bPrdInfo.getParentId()))
		{
			e.andParentIdEqualTo(bPrdInfo.getParentId());
		}
		if(!StringUtil.isEmpty(bPrdInfo.getProductId()))
		{
			e.andProductIdEqualTo(bPrdInfo.getProductId());
		}
		if(!StringUtil.isEmpty(bPrdInfo.getStatus()))
		{
			e.andStatusEqualTo(bPrdInfo.getStatus());
		}
		List<BPrdInfo> code = bprdinfodao.selectByExample(example);
		for(BPrdInfo info : code)
		{
			DataItemsVO dataItems = new DataItemsVO();
			dataItems.setCodeName(info.getProductName());
			dataItems.setCode(info.getProductId());
			dataItemsList.add(dataItems);
		}
		return dataItemsList;
	}

	@Override
	public BCntBcpAppliBaseInfoVO cachadd(BCntBcpAppliBaseInfoVO bCntBcpAppliBaseInfoVO)
	{
		bCntBcpAppliBaseInfoVO.setStratDate(ScfDateUtil.formatDate(new Date()));
		bCntBcpAppliBaseInfoVO.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
		bCntBcpAppliBaseInfoVO.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
		bCntBcpAppliBaseInfoVO.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
		bCntBcpAppliBaseInfoVO.setProcessTemplateName(WorkflowConstant.PROCNAME_FACTORING_CONT_APPLY);
		bCntBcpAppliBaseInfoVO.setAppliType(WorkflowConstant.APPLI_TYPE_FACTORING_CONT_APPLI);
		bCntBcpAppliBaseInfoVO.setStartBrcode(ContextHolder.getOrgInfo().getBrNo());
		bCntBcpAppliBaseInfoVO.setStartBrName(ContextHolder.getOrgInfo().getBrName());
		bCntBcpAppliBaseInfoVO.setStartTlrcd(ContextHolder.getUserInfo().getTlrNo());
		bCntBcpAppliBaseInfoVO.setStartTlrNm(ContextHolder.getUserInfo().getTlrName());
		return bCntBcpAppliBaseInfoVO;
	}

	/**
	 * 任务基本信息
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno)
	{
		String process = WorkflowConstant.PROCNAME_FACTORING_CONT_APPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}

	/**
	 * 根据appno获取信息
	 * 
	 * @param appno
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月19日下午2:35:56
	 */
	@Override
	public BCntBcpAppliBaseInfoVO findBCntAppliBaseInfoByAppno(String appno)
	{
		BCntBcpAppliBaseInfoVO baseInfoVO = new BCntBcpAppliBaseInfoVO();
		BCntBcpAppliBaseInfo appliBaseInfo = bcntbcpapplibaseinfodao.selectByPrimaryKey(appno);
		if(appliBaseInfo != null)
		{
			BeanUtils.copyProperties(appliBaseInfo, baseInfoVO);
			baseInfoVO.setCname(bcrmbaseinfodao.selectById(baseInfoVO.getCustcd()).getCname());
			baseInfoVO.setBusinessCname(bcrmbaseinfodao.selectById(baseInfoVO.getBusinessCustcd()).getCname());
			UserInfo info = scubeUserService.selectUserByTlrNo(baseInfoVO.getStartTlrcd(),
					ScfCommonUtil.getBrManagerNo(scubeUserService));
			if(info != null)
			{
				baseInfoVO.setStartTlrNm(info.getTlrName());
			}
			BctlVO bctl = scubeUserService.selectBctlByBrNo(baseInfoVO.getStartBrcode(),
					ScfCommonUtil.getBrManagerNo(scubeUserService));
			if(bctl != null)
			{
				baseInfoVO.setStartBrName(bctl.getBrName());
			}
		}
		return baseInfoVO;
	}

	/**
	 * 根据合同编号获取信息
	 * 
	 * @param mastContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月22日上午10:07:56
	 */
	@Override
	public BCntBcpAppliBaseInfoVO findBCntAppliBaseInfoByMastContno(String mastContno)
	{
		BCntBcpAppliBaseInfoVO baseInfoVO = new BCntBcpAppliBaseInfoVO();
		BCntBcpAppliBaseInfoExample example = new BCntBcpAppliBaseInfoExample();
		BCntBcpAppliBaseInfoExample.Criteria cri = example.createCriteria();
		if(StringUtil.isEmpty(mastContno))
		{
			return null;
		}
		cri.andMastContnoEqualTo(mastContno);
		List<BCntBcpAppliBaseInfo> list = bcntbcpapplibaseinfodao.selectByExample(example);
		if(list != null && list.size() > 0)
		{
			BCntBcpAppliBaseInfo appliBaseInfo = list.get(0);
			BeanUtils.copyProperties(appliBaseInfo, baseInfoVO);
			baseInfoVO.setCname(bcrmbaseinfodao.selectById(baseInfoVO.getCustcd()).getCname());
			baseInfoVO.setBusinessCname(bcrmbaseinfodao.selectById(baseInfoVO.getBusinessCustcd()).getCname());
			UserInfo info = scubeUserService.selectUserByTlrNo(baseInfoVO.getStartTlrcd(),
					ScfCommonUtil.getBrManagerNo(scubeUserService));
			if(info != null)
			{
				baseInfoVO.setStartTlrNm(info.getTlrName());
			}
			BctlVO bctl = scubeUserService.selectBctlByBrNo(baseInfoVO.getStartBrcode(),
					ScfCommonUtil.getBrManagerNo(scubeUserService));
			if(bctl != null)
			{
				baseInfoVO.setStartBrName(bctl.getBrName());
			}
		}
		else
		{
			return null;
		}
		return baseInfoVO;
	}

	@Override
	public void doWorkForPass(String appNo)
	{
		// 判断是否存在特殊调用路劲，存在则执行特殊路径，不存在则继续执行下列方法
		String invokPhase = ScfBasConstant.INVOKE_PHASE_APPLY;// 业务申请阶段
		String callerpath = "BCntBcpAppliBaseInfoServiceImpl";
		boolean flag = scfWorkFlowService.invokAnotherClasspath(appNo, invokPhase, callerpath);
		if(flag)
		{
			return;
		}
		String mastContno = ibSysSerialNoService.genSerialNo("FHT_APP_NO");
		BCntBcpAppliBaseInfoVO baseInfoVO = this.findBCntAppliBaseInfoByAppno(appNo);
		baseInfoVO.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);
		baseInfoVO.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		baseInfoVO.setIsFlowEnd("1");// 流程已结束
		baseInfoVO.setMastContno(mastContno);
		this.update(baseInfoVO);

		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appNo);
		appliBaseInfo.setMastContno(mastContno);
		appliBaseInfo.setBusinessno(mastContno);
		bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(appliBaseInfo);
		BCntBcpInfo bCntBcpInfo = new BCntBcpInfo();
		BeanUtils.copyProperties(baseInfoVO, bCntBcpInfo);
		String tlrcd = baseInfoVO.getStartTlrcd();
		String brcode = baseInfoVO.getStartBrcode();
		BBrpPrdFactoring bBrpPrdFactoring = bbrpprdfactoringservice
				.findBBrpPrdFactoringByKey(appliBaseInfo.getSupplyChainPdId());
		bCntBcpInfo.setFinancingType(bBrpPrdFactoring.getFinancingType());
		bCntBcpInfo.setFactType(bBrpPrdFactoring.getFactType());
		bCntBcpInfo.setContStatus(ScfBasConstant.PROTOCOL_STATE_INVALID);
		bCntBcpInfo.setTlrcd(tlrcd);
		bCntBcpInfo.setLastUpdTlrcd(tlrcd);
		bCntBcpInfo.setBrcode(brcode);
		bCntBcpInfo.setLastUpdBrcode(brcode);
		bCntBcpInfo.setCrtTime(new Date());
		bCntBcpInfo.setLastUpdTime(new Date());
		bCntBcpInfo.setCurcd(ScfBasConstant.RMB);
		bCntBcpInfo.setExt2(null);
		bcntbcpinfodao.insertSelective(bCntBcpInfo);
		String id = UUIDGeneratorUtil.generate();
		BCntBcpExtInfo bCntDebtExtInfo = new BCntBcpExtInfo();
		bCntDebtExtInfo.setId(id);
		bCntDebtExtInfo.setBusinessCustcd(baseInfoVO.getBusinessCustcd());
		bCntDebtExtInfo.setBusinessNo(mastContno);
		bCntDebtExtInfo.setBusinessName(bcrmbaseinfodao.selectById(baseInfoVO.getBusinessCustcd()).getCname());
		bcntbcpextinfodao.insertSelective(bCntDebtExtInfo);
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "pass");
	}

	@Override
	public void doWorkForReject(String appNo)
	{
		BCntBcpAppliBaseInfoVO baseInfoVO = this.findBCntAppliBaseInfoByAppno(appNo);
		baseInfoVO.setAppliStatus(WorkflowConstant.APPLI_STATUS_REFUSED);
		baseInfoVO.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		baseInfoVO.setIsFlowEnd("1");// 流程已结束
		this.update(baseInfoVO);
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "reject");
	}

	@Override
	public void doWorkForBack(String appNo)
	{
		BCntBcpAppliBaseInfoVO baseInfoVO = this.findBCntAppliBaseInfoByAppno(appNo);
		baseInfoVO.setAppliStatus(WorkflowConstant.APPLI_STATUS_GOBACK);
		baseInfoVO.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_GOBACK);
		this.update(baseInfoVO);
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "back");
	}

	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException
	{
		// TODO Auto-generated method stub

	}

	/**
	 * 根据产品编号获取产品绑定文件类型信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdContInfoVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月15日下午5:09:25
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List findBPrdFileInfoByProductId(String productId)
	{
		log.debug("findBPrdFileInfoByProductId================================start");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(!StringUtil.isEmpty(productId))
		{
			omap.put("productId", productId);
		}
		else
		{
			throw new ScubeBizException("业务品种编号丢失！");
		}
		List<BPrdFileInfoDO> list = extnbprddao.findBPrdFileInfoByPage(omap, null, false);
		log.debug("findBPrdFileInfoByProductId================================end");
		return list;
	}
}
