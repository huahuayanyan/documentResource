package com.huateng.scf.bas.crg.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
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
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.NodeDes;
import com.huateng.flowsharp.entity.NodeEntity;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.common.adapter.impl.ScfCustBaseInfoAdapterInput;
import com.huateng.scf.bas.common.adapter.impl.ScfCustBaseInfoAdapterOutput;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfTopRulesService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crg.constant.BCrgEvalConstant;
import com.huateng.scf.bas.crg.dao.BCrgEvalRecDAO;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalRec;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalRecExample;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalRecExample.Criteria;
import com.huateng.scf.bas.crg.model.ExtBCrgEval;
import com.huateng.scf.bas.crg.service.IBCrgEvalRecService;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.IBCrmEntInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfo;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.dao.IBSysApplyDtlDAO;
import com.huateng.scf.bas.sys.dao.IBSysFlowUrlRelDAO;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtl;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
import com.huateng.toprules.core.browse.entity.Rule;
import com.huateng.toprules.core.project.entity.Project;
import com.huateng.toprules.scube.common.TopRulesScubeRuntimeException;
import com.huateng.toprules.scube.service.ITopRuleScubeService;
import com.huateng.toprules.scube.service.ITopRulesUserScubeService;
import com.huateng.toprules.xom.PersonInfo;
import com.huateng.toprules.xom.ScfCustBaseInfo;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

//import net.sf.json.JSON;
//import net.sf.json.JSONObject;
//import net.sf.json.xml.XMLSerializer;

@ScubeService
@Service("BCrgEvalRecServiceImpl")
public class BCrgEvalRecServiceImpl implements IBCrgEvalRecService,DealEndFlowService{

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BCrgEvalRecDAO")
	BCrgEvalRecDAO bCrgEvalRecDAO;
	
//	private static String projectName = "DEFAULT_PROJECT";
//	
//	private static String ruleset = "Default_RuleSet";
//
//	private ITaskService taskService;
//	
//	private static String processId ="";
	
	@Resource(name = "BSysFlowUrlRelDAO")
	IBSysFlowUrlRelDAO BSysFlowUrlRelDAO;
	
	@Resource(name= "BSysApplyDtlDAO")
	IBSysApplyDtlDAO iBSysApplyDtlDAO;
	
	@Resource(name = "IBCrmEntInfoDAO")
	IBCrmEntInfoDAO iBCrmEntInfoDAO;
	
	@Autowired
	private IProcessService processService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrgService orgService;

//	@Autowired
//	private CacheService cacheService;
	
	@Autowired
	ITopRuleScubeService topRuleScubeService;
	
	@Autowired
	ITopRulesUserScubeService topRulesUserScubeService;
	
	@Autowired
	private ScubeUserService scubeUserService;
	
	@Resource(name="IBCrmBaseInfoDAO")
	private IBCrmBaseInfoDAO bCrmBaseInfoDAO;
	
	@Resource(name="IBCrmEntInfoDAO")
	private IBCrmEntInfoDAO bCrmEntInfoDAO;
	
	@Resource(name=IScfWorkFlowService.BEAN_ID)
	private IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Autowired
	IProcessService iProcessService;
	
	@Resource(name="BSysSerialNoServiceImpl")
	IBSysSerialNoService bSysSerialNoService;
	
	@Resource(name = "scfTopRulesService")
	IScfTopRulesService scfTopRulesService;
	
	@Override
	public String getString(String s) {
		return null;
	}
	
	@Transactional
	@Override
	public String add(BCrgEvalRec record) {
		
		BCrgEvalRec bCrgEvalRecDal = new BCrgEvalRec();
		
		try {
			BeanUtils.copyProperties(record, bCrgEvalRecDal);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}
		if(StringUtils.isEmpty(record.getEvalId())){
			//4+8+6+14
			//String id = "XYPJ"+ScfDateUtil.formatDate(new Date(), "yyyyMMddHHmmssSSS")+UUIDGeneratorUtil.generate(record).substring(0,14);
			String  id = ibSysSerialNoService.genSerialNo("XYPJ_NO");
			
			bCrgEvalRecDal.setEvalId(id);
		}
		bCrgEvalRecDal.setStat(WorkflowConstant.APPLI_STATUS_DTL_WRITING);
		bCrgEvalRecDal.setIsVld(BCrgEvalConstant.UNVld);
		if(StringUtils.isEmpty(record.getRltTyp())){
			if(StringUtils.isNotEmpty(record.getRltId())){
				BCrmBaseInfo bCrmBaseInfo =bCrmBaseInfoDAO.selectById(record.getRltId());
				if(StringUtils.isNotBlank(bCrmBaseInfo.getCustType())){
					bCrgEvalRecDal.setRltTyp(bCrmBaseInfo.getCustType());
				}
			}
		}
		try {
			bCrgEvalRecDAO.insert(bCrgEvalRecDal);
		} catch (Exception e) {
			log.warn("插入异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50001),BSysErrorConstant.SCF_BAS_DCR_50001);
		}
		return bCrgEvalRecDal.getEvalId();
	}

	/* 
	 * 
	 */
	@Transactional
	@Override
	public int update(BCrgEvalRec record) {
		
		record.setLastUpdTlr(ContextHolder.getUserInfo().getTlrNo());
		record.setLstUpdBrCd(ContextHolder.getOrgInfo().getBrNo());
		record.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
		
		BCrgEvalRec bCrgEvalRec = new BCrgEvalRec();		
		try {
			BeanUtils.copyProperties(record, bCrgEvalRec);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}
		int i;
		try {
			i = bCrgEvalRecDAO.updateByPrimaryKeySelective(bCrgEvalRec);
		} catch (Exception e) {
			log.warn("更新异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50005),BSysErrorConstant.SCF_BAS_DCR_50005);

		}
		return i;
	}

	@Transactional
	@Override
	public int delete(String evalId) {
		
		log.debug("delete传递参数,evalId="+evalId);
		int i;
		try {
			i = bCrgEvalRecDAO.deleteByPrimaryKey(evalId);
		} catch (Exception e) {
			log.warn("删除异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50003),BSysErrorConstant.SCF_BAS_DCR_50003);
		}
		return i;
	}

	@Override
	public Page findCrgEvalRecByPage(int pageNo, int pageSize, BCrgEvalRec record) 
	{
		BCrgEvalRecExample example = new BCrgEvalRecExample();
		Criteria cri = example.createCriteria();
		if (record != null) {
			if (!StringUtil.isEmpty(record.getEvalId())) {
				cri.andEvalIdLike("%" + record.getEvalId() + "%");
			}

			if (!StringUtil.isEmpty(record.getMdlId())) {
				cri.andMdlIdEqualTo(record.getMdlId());
			}
			if (!StringUtil.isEmpty(record.getMdlNm())) {
				cri.andMdlNmEqualTo(record.getMdlNm());
			}
		}
		example.setOrderByClause("EVAL_ID DESC");
		
		int total = bCrgEvalRecDAO.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());
		List<BCrgEvalRec> list = bCrgEvalRecDAO.selectByPage(example, p);
		List<ExtBCrgEval> result = new ArrayList<ExtBCrgEval>();
		if(list.size()>0)
		{
			for(BCrgEvalRec bCrgEvalRec:list)
			{
				ExtBCrgEval extCrgEval = new ExtBCrgEval();
				BeanUtils.copyProperties(bCrgEvalRec, extCrgEval);
				if(null!=extCrgEval){
					String custcd = extCrgEval.getRltId();
					BCrmBaseInfo bCrmBaseInfo = bCrmBaseInfoDAO.selectById(custcd);
					if(null!=bCrmBaseInfo){
						extCrgEval.setCname(bCrmBaseInfo.getCname());
					}
					result.add(extCrgEval);
				}
			}
		}
		p.setRecords(result);
		p.setTotalRecord(total);
		log.info("p.toString()=" + p.toString());
		return p;
	}

	@Override
	public BCrgEvalRec findCrgEvalRecByKey(String evalId) {
		
		log.debug("findCrgEvalRecByKey传递参数,evalId="+evalId);
		if(StringUtils.isBlank(evalId)){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004),BSysErrorConstant.SCF_BAS_DCR_50004);		
		}
		
		BCrgEvalRec record = bCrgEvalRecDAO.selectByPrimaryKey(evalId);
		
		BCrgEvalRec bCrgEvalRec = new BCrgEvalRec();
		
		try {
			BeanUtils.copyProperties(record, bCrgEvalRec);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}

		return bCrgEvalRec;
	}
	
	
	public ExtBCrgEval findExtBCrgEvalByKey(String evalId) {
		ExtBCrgEval extBCrgEval = new ExtBCrgEval();
		BCrgEvalRec crgEvalRec =this.findCrgEvalRecByKey(evalId);
		BeanUtils.copyProperties(crgEvalRec, extBCrgEval);
		String tlrNo = extBCrgEval.getTlrNo();
		String brCd = extBCrgEval.getBrCd();
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setTlrNo(tlrNo);// 搜索创建人对应的名称。
		List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
		if (userList != null && userList.size() == 1) {
			extBCrgEval.setTlrNm(userList.get(0).getTlrName());
		}

		// 经办机构brName
		BctlVO bctlVO = new BctlVO();
		bctlVO.setBrNo(brCd);
		List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
		if (bctlVOList != null && bctlVOList.size() == 1) {
			extBCrgEval.setBrNm(bctlVOList.get(0).getBrName());
		}
		//最后更新经办人经办机构
		String lastUpdTlrNo = extBCrgEval.getLastUpdTlr();
		String lastUpdBrCd = extBCrgEval.getLstUpdBrCd();
		userInfo1.setTlrNo(lastUpdTlrNo);// 搜索创建人对应的名称。
		List<TlrInfoVO> userList2 = userService.selectByExample(userInfo1);
		if (userList2 != null && userList2.size() == 1) {
			extBCrgEval.setLastUpdTlrNm(userList2.get(0).getTlrName());
		}
		
		// 经办机构brName
		bctlVO.setBrNo(lastUpdBrCd);
		List<BctlVO> bctlVOList2 = orgService.selectByExample(bctlVO);
		if (bctlVOList2 != null && bctlVOList2.size() == 1) {
			extBCrgEval.setLstUpdBrNm(bctlVOList2.get(0).getBrName());
		}
		return extBCrgEval;
	}
	

	@Override
	public List<BCrgEvalRec> selectByBCrgEvalRec(BCrgEvalRec bCrgEvalRec) {
		BCrgEvalRecExample example = new BCrgEvalRecExample();
		Criteria criteria = example.createCriteria();
		Field[] fields = bCrgEvalRec.getClass().getDeclaredFields();
		for(Field f:fields){
			String name = f.getName();
			name = name.substring(0,1).toUpperCase()+name.substring(1);
			String type = f.getGenericType().toString();
			if(StringUtils.isNotBlank(type)){
				
				if(("class java.lang.String").equals(type)){
					
					if(name.contains("Id")|| name.contains("ID")||name.contains("No")|| name.contains("No")||name.contains("Cd")|| name.contains("CD")){
						try {
							Method method =bCrgEvalRec.getClass().getMethod("get"+name);
							String obj = (String) method.invoke(bCrgEvalRec);
							
							Method setMthd = criteria.getClass().getMethod("and"+name+"EqualTo");
							setMthd.invoke(example, obj);
						} catch (Exception e) {
							e.printStackTrace();
						} 
					}else{
						
						try {
							Method method =bCrgEvalRec.getClass().getMethod("get"+name);
							String obj = (String) method.invoke(bCrgEvalRec);
							
							Method setMthd = criteria.getClass().getMethod("and"+name+"Like");
							setMthd.invoke(example, "%"+obj+"%");
						} catch (Exception e) {
							e.printStackTrace();
						} 
						
					}

				}
				
				if(("class java.math.BigDecimal").equals(type)){
					try {
						Method method =bCrgEvalRec.getClass().getMethod("get"+name);
						String obj = (String) method.invoke(bCrgEvalRec);
						
						Method setMthd = criteria.getClass().getMethod("and"+name+"EqualTo");
						setMthd.invoke(example, obj);
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
			
		}
		
		List<BCrgEvalRec> crgEvalRecDalList = bCrgEvalRecDAO.selectByExample(example);
		return crgEvalRecDalList;
	}
	
	
	/* 
	 * 启动审批流程
	 */
	@Override
	public BCrgEvalRec submit(BCrgEvalRec bCrgEvalRec,ProcessModel processModel)throws Exception{
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		BCrgEvalRec bCrgEvalRecNew = new BCrgEvalRec();
		BeanUtils.copyProperties(bCrgEvalRec, bCrgEvalRecNew);
		if(StringUtils.isBlank(bCrgEvalRec.getEvalId())){	
			String evalId = add(bCrgEvalRec);
			bCrgEvalRecNew.setEvalId(evalId);
		}

		// 2.发起流程
		String appno = bCrgEvalRecNew.getEvalId();
		processModel.setStartedUserId(tlrcd);
		String processId = "";
		try {
			processModel.setBizId(appno);
			processModel.getBizData()[0] = appno;
			ProcessEntity processEntity = iProcessService.startProcess(processModel.getModelId(),
					processModel.getProcessName(), processModel.getNodeId(), processModel.getStartedUserId(),
					processModel.getBizId(), processModel.getBizData());
			processId = processEntity.getProcessId();
			bCrgEvalRecNew.setProcessId(processId);
		} catch (Exception e) {// SCF_REC_BCP_10022,发起流程失败
			log.error("" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
					RBcpErrorConstant.SCF_REC_BCP_10022);
		}
		
		String appStat = WorkflowConstant.APPLI_STATUS_DTL_APPROVING;		
		bCrgEvalRecNew.setStat(appStat);
	    bCrgEvalRecNew.setLastUpdTlr(tlrcd);
	    bCrgEvalRecNew.setLstUpdBrCd(brcode);
	    bCrgEvalRecNew.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
	    this.update(bCrgEvalRecNew);
		return bCrgEvalRecNew;	
	}
	
	/* 
	 * 获取该任务的当前节点的运行状态
	 * 0 未领取
	 * 1 已领取
	 * 2 已完成
	 */
	@Override
	public String getEvalStat(String processId)throws Exception{
		NodeEntity  nodeEntity= processService.getCurrentNodeEntity(processId);
		int req = nodeEntity.getSeq();
		return String.valueOf(req);
	}
	
//	private String getUserId()throws Exception{
//		UserInfo userInfo =ContextHolder. getUserInfo();  
//		return userInfo.getTlrName();
//	}	
	
//	/* 
//	 * 领取任务
//	 */
//	@Override
//	public int takeTask(String processId,String taskId) throws Exception{
//		String userId= getUserId();
//		int takeTaskCode=taskService.takeTask(taskId, processId, userId);		
//		return takeTaskCode;
//	}

	
//	/* 
//	 * 完成任务
//	 */
//	@Override
//	public int completeTask(String processId,String taskId) throws Exception{
//		String userId= getUserId();
//		String comment = "complete "+ taskId;
//		int code = taskService.completeTask(taskId, processId, userId, comment);
//		return code;
//	}
	
	
//	/* 
//	 * 进入下一个节点
//	 */
//	@Override
//	public void goToNextNode(String processId,String nodeId) throws Exception{
//		log.info("=================signal");
//		processService.signal(processId, nodeId);	
//		TimeUnit.MILLISECONDS.sleep(500);
//	
//	}
	

	
	/* 
	 * 获取下一个节点Id
	 */
//	@Override
//	public String getNextNodeId(String processId)throws Exception{
//		NodeEntity  nodeEntity = processService.getNextNode(processId);
//		String nodeId = nodeEntity.getId();
//		return nodeId;
//	}
	
	
	/* 
	 * 获取上一个节点ID
	 */
	@Override
	public String getPrevNodeId(String processId,String currNodeId)throws Exception{
		List<String> list =processService.getRunTrail(processId);
		String prevNodeId = null;
		if(list!=null&&list.contains(currNodeId)){
			for(int i=0;i<list.size();i++){
				if(list.get(i).equals(currNodeId)){
					if(i>0){
						prevNodeId = list.get(i-1);
					}			
				}
			}
		}
		return prevNodeId;
	}
	
	
	/* 
	 * 通过@processId获取当前的审批详情
	 */
	@Override
	public BCrgEvalRec getEntityByProcessId(String processId){
		BCrgEvalRec entity = bCrgEvalRecDAO.selectByProcessId(processId);
		return entity;
	}

	/* 
	 * 保存审批意见
	 */
	@Override
	public String saveBSysApplyDtl(BSysApplyDtl bSysApplyDtl) throws Exception{
		String id =UUIDGeneratorUtil.generate(bSysApplyDtl);
		bSysApplyDtl.setId(id);
		iBSysApplyDtlDAO.insert(bSysApplyDtl);
		return id;
	}
	

	
	/**
	 * 模版ID
	 */	private static final  String MODEL_ID="creditEvalPrcssCreate";
	
	
	/* 
	 * 获取最后节点ID
	 */
	@Override
	public String getFinlNodeId() throws Exception{
		List<NodeDes> list =processService.getNodeDesByModelId(MODEL_ID);
		int index = list.size()-1;
		NodeDes nodeDes = list.get(index);
		String finlNodeName = nodeDes.getNodeId();
		return finlNodeName;
	}
	
	
	/* 
	 * 是否跳转成功
	 */
	@Override
	public boolean isSignalSucceed(String processId,String nextNodeId)throws Exception{
		boolean result = false; 
		NodeEntity nodeEntity = processService.getCurrentNodeEntity(processId);
		String currNodeId = nodeEntity.getId();
		if(currNodeId.equals(nextNodeId)){
			result = true;
		}else{
			result = false;
		}
		
		return result;
	}

	/* 
	 * 通过节点编号获取任务编号
	 */
	@Override
	public String getTaskIdByNodeId(String ndoeId) throws Exception{
		return null;
	}
	
	
	/**
	 * @throws TopRulesScubeRuntimeException
	 */
	public String[] executeRules(double salary) throws Exception{
//		Map<String, Object> inputParameters = new HashMap<String, Object>();
		PersonInfo personinfo = new PersonInfo();
		personinfo.setSalary(salary);
//TODO		TransRequest[] trans = new TransRequest[1];
//			TransRequest tran = new TransRequest();
//			trans[0]=tran;
//			inputParameters.put("personinfo", personinfo);
//			inputParameters.put("trans", trans);
//			TopRulesScubeRequest topRulesRequest = new TopRulesScubeRequest(projectName);
//			topRulesRequest.setInputParameters(inputParameters);
//			topRulesRequest.setRuleSetName("Default_RuleSet");
//			TopRulesScubeResponse response =topRuleScubeService.executeRules(topRulesRequest);
//			Map<String, Object> outParameters =response.getOutputParameters();
//			PersonInfo result =(PersonInfo) outParameters.get("personinfo");

//			evalResult[0]=result.getCustLevel();
//			evalResult[1]=result.getCuststatus();
//			System.out.println(evalResult);
		
		String[] evalResult = new String[2];
		
		if(0<salary && salary<7000.0){
			evalResult[0]="F";
			evalResult[1]="55";
		}
		else if(7000.0<=salary && salary<9000.0){
			evalResult[0]="E";
			evalResult[1]="65";
		}
		else if(9000.0<=salary && salary<12000.0){
			evalResult[0]="D";
			evalResult[1]="75";
		}
		else if(12000.0<=salary && salary<18000.0){
			evalResult[0]="C";
			evalResult[1]="85";
		}
		else if(18000.0<=salary && salary<25000.0){
			evalResult[0]="B";
			evalResult[1]="95";
		}else if(25000.0<=salary) {
			evalResult[0]="A";
			evalResult[1]="100";
		}
		return evalResult;
	}

	@Override
	public void doWorkForPass(String appNo) {
		BCrgEvalRec bCrgEvalRec = findCrgEvalRecByKey(appNo);
		bCrgEvalRec.setStat(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		bCrgEvalRec.setIsVld(BCrgEvalConstant.ISVld);
		
		//更新客户信息
		if(!StringUtil.isStrEmpty(bCrgEvalRec.getRltId())){
			BCrmEntInfo bCrmEntInfo = iBCrmEntInfoDAO.selectByPrimaryKey(bCrgEvalRec.getRltId());
			if(!StringUtil.isStrEmpty(bCrgEvalRec.getCognRslt()) && bCrgEvalRec.getCognScr() != null){
				//手评
				bCrmEntInfo.setCreditLevel(bCrgEvalRec.getCognRslt());
				bCrmEntInfo.setCreditScr(bCrgEvalRec.getCognScr());
			}else{
				//机评
				bCrmEntInfo.setCreditLevel(bCrgEvalRec.getEvalRslt());
				bCrmEntInfo.setCreditScr(bCrgEvalRec.getEvalScr());
			}
			bCrmEntInfo.setCreditDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
			bCrmEntInfo.setCreditId(bCrgEvalRec.getEvalId());
			iBCrmEntInfoDAO.updateByPrimaryKeySelective(bCrmEntInfo);
		}
		
		update(bCrgEvalRec);
		
	}

	@Override
	public void doWorkForReject(String appNo) {
		BCrgEvalRec bCrgEvalRec = findCrgEvalRecByKey(appNo);
		bCrgEvalRec.setStat(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		bCrgEvalRec.setIsVld(BCrgEvalConstant.UNVld);
		update(bCrgEvalRec);
	}

	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public ExtBCrgEval getBrNo() {
		ExtBCrgEval bCrgEval = new ExtBCrgEval();
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		UserInfo userInfo = ContextHolder.getUserInfo();
		String brcd = bctlVO.getBrNo();
		String brnm = bctlVO.getBrName();
		bCrgEval.setBrCd(brcd);
		bCrgEval.setBrNm(brnm);
		bCrgEval.setLstUpdBrCd(brcd);
		bCrgEval.setLstUpdBrNm(brnm);
		bCrgEval.setEvalDt(ScfDateUtil.formatDate(new Date()));
		
		String tlrno = userInfo.getTlrNo();
		String tlrnm = userInfo.getTlrName();
		bCrgEval.setTlrNo(tlrno);
		bCrgEval.setTlrNm(tlrnm);
		bCrgEval.setLastUpdTlr(tlrno);
		bCrgEval.setLastUpdTlrNm(tlrnm);
		bCrgEval.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
		return bCrgEval;
	}
	
	/**
	 * 获取信用评级的创建人及更新人信息
	 * @param bCrgEvalRec
	 * @return
	 */
	@Override
	public ExtBCrgEval findExtBcrgEvalInfo(ExtBCrgEval extBCrgEval)
	{
		String tlrNo = extBCrgEval.getTlrNo();
		String lstTlrNo = extBCrgEval.getLastUpdTlr();
		UserInfo userInfo = scubeUserService.selectUserByTlrNo(tlrNo, ScfCommonUtil.getBrManagerNo(scubeUserService));
		UserInfo lstUserInfo = scubeUserService.selectUserByTlrNo(lstTlrNo, ScfCommonUtil.getBrManagerNo(scubeUserService));
		if(null!=userInfo)
		{
			extBCrgEval.setTlrNm(userInfo.getTlrName());
		}
		if(null!=lstUserInfo)
		{
			extBCrgEval.setLastUpdTlrNm(lstUserInfo.getTlrName());
		}
		String brCd = extBCrgEval.getBrCd();
		String lstBrCd = extBCrgEval.getLstUpdBrCd();
		BctlVO bctlVO = scubeUserService.selectBctlByBrNo(brCd, ScfCommonUtil.getBrManagerNo(scubeUserService));
		BctlVO lstBctlVO = scubeUserService.selectBctlByBrNo(lstBrCd, ScfCommonUtil.getBrManagerNo(scubeUserService));
		if(null!=bctlVO)
		{
			extBCrgEval.setBrNm(bctlVO.getBrName());
		}
		if(null!=lstBctlVO)
		{
			extBCrgEval.setLstUpdBrNm(lstBctlVO.getBrName());
		}
		return extBCrgEval;
	}
	
	public ScfCustBaseInfo findScfCustBaseInfo(){
		ScfCustBaseInfo scfCustBaseInfo=new ScfCustBaseInfo();
		scfCustBaseInfo.setAnnualTurnoverAmt(new BigDecimal(80000000));//年营业额
		scfCustBaseInfo.setAnnualPurchaseAmt(new BigDecimal(40000000));//年采购额
		scfCustBaseInfo.setTurnoverRate(new BigDecimal(0.8));//营业额增长率
		scfCustBaseInfo.setEarningPower("盈利且同比正增长");//盈利能力
		scfCustBaseInfo.setCreditRecord("公司及法人从未有逾期");//征信记录
		scfCustBaseInfo.setPerformanceRate("水电费、增值税或工资缴纳及发放及时且稳定（不减少或增长）");//履约率
		scfCustBaseInfo.setFinCondtion(new BigDecimal(20000000));//资产状况
		scfCustBaseInfo.setCashFlow("企业及关联企业以及企业主个人账户银行对账单交易连续且稳定增长");//现金流
		scfCustBaseInfo.setCourtDoc("有诉讼记录，败诉");//诉讼记录
		scfCustBaseInfo.setProofOfCredit(3);//资信实力证明
		scfCustBaseInfo.setCooperative(5);//合作年限
		scfCustBaseInfo.setStablityOftrad("较好");//交易稳定性
		scfCustBaseInfo.setMainProduct("主推XX产品");//主营产品
		scfCustBaseInfo.setPaymengTimeliness(new BigDecimal(0));//付款及时性
		scfCustBaseInfo.setFinancial("是");//账务往来
		scfCustBaseInfo.setIndustryExperi(6);//行业经验
		scfCustBaseInfo.setChlCapacity("电商");//渠道能力
		scfCustBaseInfo.setOrderMng("最近一年没有取消或修改订单");//订单管理
		scfCustBaseInfo.setLocalSales(new BigDecimal(40000000));//当地销售份额
		scfCustBaseInfo.setOperatorQuality("好");//经营者素质
		return scfCustBaseInfo;
	}
	

	@Override
	public String findBCrgEvalLevelInfo(String custNo) {
		BCrmBaseInfo bCrmBaseInfo =bCrmBaseInfoDAO.selectById(custNo);
		if(bCrmBaseInfo==null){
			throw new ScubeBizException("客户号为["+custNo+"]的客户信息丢失，请重新选择！");
		}
		String custType="";
		if("1".equals(bCrmBaseInfo.getCoreFlag())){
			custType="04";
		}else if("1".equals(bCrmBaseInfo.getMoniFlag())){
			custType="03";
		}else if("1".equals(bCrmBaseInfo.getCreditFlag())){
			BCrmEntInfo ent=bCrmEntInfoDAO.selectByPrimaryKey(custNo);
			if(ent!=null){
				if("1".equals(ent.getUpFlag())){
					custType="01";
				}else if("1".equals(ent.getDownFlag())){
					custType="02";
				}
			}
		}
		Project ppp=scfTopRulesService.getProjectByName(ScfBasConstant.RULES_PROJECT_NAME);
		List<Rule> rrrlist=scfTopRulesService.getProjectRules(ppp.getUuid(), new String[]{"3"});
		JSON sss=null;
		for (Rule rule : rrrlist) {
			String[] infos=rule.getRuleName().split("_");
			if(infos.length>=2&&custType.equals(infos[1])){
				sss=new XMLSerializer().read(rule.getContent());
				break;
			}
		}
		if(sss==null){
			throw new ScubeBizException("无此客户对应的评分模型，请重新选择！");
		}
		return sss.toString();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String getCrgEvalLevel(String totalScore) {
		Map<String, Object> inputParameters = new HashMap<String, Object>();
		//评级结果规则-begin
		ScfCustBaseInfo scfCustBaseInfo=new ScfCustBaseInfo();
		scfCustBaseInfo.setTotalScore(Integer.parseInt(totalScore));//设置评级分值
		inputParameters.put(ScfBasConstant.RULES_TYPE, ScfBasConstant.RULES_TYPE_VALUE_3);//评级结果规则
		ScfCustBaseInfoAdapterInput scfCustBaseInfoInput=new ScfCustBaseInfoAdapterInput();
		scfCustBaseInfoInput.setScfCustBaseInfo(scfCustBaseInfo);
		scfCustBaseInfoInput.setInputParams(inputParameters);
		List outList=scfTopRulesService.executeRules(scfCustBaseInfoInput,inputParameters);//调用评级结果规则
		String custLevel=null;
		if(null!=outList && outList.size()>0){
			ScfCustBaseInfoAdapterOutput scfCustBaseInfoOutput=(ScfCustBaseInfoAdapterOutput)outList.get(0);
			ScfCustBaseInfo scfCustBaseInfoOut=scfCustBaseInfoOutput.getScfCustBaseInfo();
			if(null!=scfCustBaseInfoOut){
				custLevel=scfCustBaseInfoOut.getCustLevel();
				log.info("-----------------------custLevel>>>:"+custLevel);
			}
		}
		//评级结果规则-end
		return custLevel;
	}
	
	public static void main(String[] args) {
		System.out.println(new BigDecimal(Math.random()*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		
		
	}
}
