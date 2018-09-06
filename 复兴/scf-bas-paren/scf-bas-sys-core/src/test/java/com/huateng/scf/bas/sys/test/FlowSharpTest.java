/**
 * 
 */
package com.huateng.scf.bas.sys.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.api.ITaskService;
import com.huateng.flowsharp.api.IWebsiteService;
import com.huateng.flowsharp.entity.NodeEntity;
import com.huateng.scf.bas.sys.dao.model.BSysTask;

/**
 * <p>工作流程接口测试类</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月9日下午5:00:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月9日下午5:00:43	                                 新增
 *
 * </pre>
 */

public class FlowSharpTest {
	private final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 发起流程
	 * @throws Exception
	 */
	@Test
	public void startProcess() throws Exception{
	//	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
	//	ScubeClientCall.setCtx(ctx);
	//	IProcessService processService =  ctx.getBean("processService", IProcessService.class);
		String modelId="FactoringLeaseBuyBackApply";
		String processName="应收租金反转让申请";
		String nodeId="Write";
		String startedUserId="ytsm04";
		String bizId="scf2016111903";
		//扩展业务信息
		String appNo=bizId;//业务申请号
		String custCd="Cust003";//客户号
		String custName="广州格力空调有限公司";//客户名称
		//流程模板id
		
//		ProcessEntity processEntity=null;
//		processEntity=processService.startProcess(modelId, processName, nodeId, startedUserId, bizId,new String[]{appNo,custCd,custName,modelId});
//		log.info("processEntity:"+processEntity);
//		log.info("processEntity processId:"+processEntity.getProcessId());
		//0640819473a6400e829f755b3a6349f6
		
	}
	/**
	 * 待办任务查询
	 * @throws Exception
	 */
	@Test
	public void getUnTakeTask() throws Exception{
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
		//ScubeClientCall.setCtx(ctx);
	//	ITaskService taskService =  ctx.getBean("taskService", ITaskService.class);
		String userId="001";
		String processId="";
		int pageNo=1;
		int pageSize=10;//
		String modelId="FactoringLeaseBuyBackApply";
		String processName="应收租金反转让申请";
		String nodeId="Write";
		String startedUserId="ytsm04";
		String bizId="scf2016111501";
		//扩展业务信息
		String appNo=bizId;//业务申请号
		String custCd="Cust001";//客户号
		String custName="广州格力空调有限公司";//客户名称
//		Page page=taskService.getUnTakeTask(userId, processId, pageNo, pageSize);
		Page page=null;
	//	page=taskService.getUnTakeTask(userId, processId, pageNo, pageSize,new String[]{appNo,"","",modelId});
		if(null!=page){
			System.out.println("=======================page:"+page.getRecords());
			List list=page.getRecords();
			if(null!=list && list.size()>0){
				for(int i=0;i<list.size();i++){
//					log.info("=========================Record:"+list.get(i));
				//	BSysTask bSysTask=JSON.parseObject(list.get(i).toString(), new TypeReference<BSysTask>(){});
//					log.info("=========================流程编号:"+bSysTask.getProcessId());//流程编号
//					log.info("=========================申请编号:"+bSysTask.getName1());//申请编号
//					log.info("=========================任务名称:"+bSysTask.getTaskName());//任务名称
//					log.info("=========================客户名称:"+bSysTask.getName3());//客户名称
//					log.info("=========================发起机构:");//发起机构
//					log.info("=========================发起时间:"+bSysTask.getCreateTime());//发起时间
//					Map<String, String> map = JSON.parseObject(res, new TypeReference<Map<String, String>>() {});
				}
				
			}
			log.info("=========================page TotalRecord:"+page.getTotalRecord());
		}

		
	}

	/**
	 * 领取任务
	 * @throws Exception
	 */
	@Test
	public void takeTask() throws Exception{
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
		//ScubeClientCall.setCtx(ctx);
	//	ITaskService taskService =  ctx.getBean("taskService", ITaskService.class);
//		String userId="scf_user1";
//		String processId="0640819473a6400e829f755b3a6349f6";
//		String taskId="Write_task1";
		int takeTaskCount=0;
//		takeTaskCount=taskService.takeTask(taskId, processId, userId);
		System.out.println("=======================成功领取任务数takeTaskCount:"+takeTaskCount);
		log.info("takeTaskCount:"+takeTaskCount);
		int pageNo=1;
		int pageSize=10;
//		BSysTask bSysTask;
		String userId ="qinwei"; 
		String processId = "";
		String appNo ="";
		String custName ="";
		String modelId ="";
	//	Page taskPage=taskService.getUnTakeTask(userId, processId, pageNo, pageSize,new String[]{appNo,"",custName,modelId});
	//	List records = taskPage.getRecords();
		
	}
	
	/**
	 * 任务提交
	 * @throws Exception
	 */
	@Test
	public void completeTask() throws Exception{
	//	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
		//ScubeClientCall.setCtx(ctx);
//		ITaskService taskService =  ctx.getBean("taskService", ITaskService.class);
		String userId="scf_user1";
		String processId="0640819473a6400e829f755b3a6349f6";
		String taskId="Write_task1";
		String comment="完成任务";
		int complenteTaskCount=0;
//		complenteTaskCount=taskService.completeTask(taskId, processId, userId, comment);
		System.out.println("=======================成功领取任务数complenteTaskCount:"+complenteTaskCount);
		log.info("=================complenteTaskCount:"+complenteTaskCount);
	}
	/**
	 * 节点转移
	 * @throws Exception
	 */
	@Test
	public void signal() throws Exception{
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
	//	ScubeClientCall.setCtx(ctx);
	//	IProcessService processService =  ctx.getBean("processService", IProcessService.class);
		String nodeId="Approve";
		String pid="0640819473a6400e829f755b3a6349f6";
//		processService.signal(pid, nodeId);
		log.info("=================signal");
	}
	/**
	 * 取消流程
	 * @throws Exception
	 */
	@Test
	public void cancelProcess() throws Exception{
	//	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
	//	ScubeClientCall.setCtx(ctx);
//		IProcessService processService =  ctx.getBean("processService", IProcessService.class);
		String processId="c911303ad7cc4c3ca5d19270d0bfc1df";
		log.info("=================cancelProcess Start");
//		processService.cancelProcess(processId);
		log.info("=================cancelProcess End");
	}
	
	@Test
	public void getUnTakedTask(){
	//	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
		//ScubeClientCall.setCtx(ctx);
//		ITaskService taskService =  ctx.getBean("taskService", ITaskService.class);
		String userId="qinwei";
		String processId="";
		int pageNo=0;
		int pageSize=0;
		String appNo="";
		String modelId="";
	//	Page page=taskService.getUnTakeTask(userId, processId, pageNo, pageSize,new String[]{appNo,"","",modelId});
	//	List list =page.getRecords();
	}
	/**
	 * 查询已经完成的流程任务
	 * @throws Exception
	 */
	@Test
	public void getDoneTask() throws Exception{
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
//		ScubeClientCall.setCtx(ctx);
//		ITaskService taskService =  ctx.getBean("taskService", ITaskService.class);
//		String userId="";
//		String processId="";
//		int pageNo=1;
//		int pageSize=10;
//		BSysTask bSysTask;
////		String userId ="qinwei"; 
////		String processId = "";
//		String appNo ="";
//		String custName ="";
//		String modelId ="";
//		Page taskPage=taskService.getDoneTask(userId, processId, pageNo, pageSize,new String[]{appNo,"",custName,modelId});
////		Page taskPage=taskService.getUnTakeTask(userId, processId, pageNo, pageSize,new String[]{appNo,"",custName,modelId});
//		List records = taskPage.getRecords();
//		log.info("records:"+records);
//		log.info("TotalRecord:"+taskPage.getTotalRecord());
		
	}
	/**
	 * 查看任务待办人员
	 * @throws Exception
	 */
	@Test
	public void getTaskDes() throws Exception{
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
//		ScubeClientCall.setCtx(ctx);
//		IWebsiteService websiteService =  ctx.getBean("websiteService", IWebsiteService.class);
//		ITaskService taskService =  ctx.getBean("taskService", ITaskService.class);
//		String userId="";
//		String processId="";
//		int pageNo=1;
//		int pageSize=10;
//		BSysTask bSysTask;
//		String appNo ="";
//		String custName ="";
//		String modelId ="";
//		Page untp=taskService.getUnTakeTask(userId, processId, pageNo, pageSize,new String[]{appNo,"",custName,modelId});
//		log.info("untp records:"+untp.getRecords().get(0));
//		log.info("untp TotalRecord:"+untp.getTotalRecord());
////		Page taskPage=taskService.getDoneTask(userId, processId, pageNo, pageSize,new String[]{appNo,"",custName,modelId});
//		processId="61dcaf14f852469a8ae5060cd5e2fb82";
//		Page tp=taskService.getUnTakeTask(userId, processId, pageNo, pageSize,new String[]{appNo,"",custName,modelId});
//		modelId="FactoringAccountRepurApply";
//		String taskDesId="Write_task";
//		String taskName="";
//		String nodeId="Write";
//		Map<String,Object> taskDesMap=websiteService.getTaskDes(pageNo, pageSize, taskDesId, taskName, modelId, nodeId);
//		List records = tp.getRecords();
//		log.info("records:"+records.get(0));
//		log.info("TotalRecord:"+tp.getTotalRecord());
//		log.info("map:"+taskDesMap);
//		if(null!=taskDesMap && taskDesMap.size()>0){
//			List<Map<String,String>> list=(List<Map<String,String>>)taskDesMap.get("records");
//			if(null!=list && list.size()>0){
//				String users=list.get(0).get("userIds");
//				log.info("======================>>>users:"+users);
//			}
//		}
		
	}
	@Test
	public void getRunTrail() throws Exception{
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
//		ScubeClientCall.setCtx(ctx);
//		IProcessService processService =  ctx.getBean("processService", IProcessService.class);
//		IWebsiteService websiteService =  ctx.getBean("websiteService", IWebsiteService.class);
//		ITaskService taskService =  ctx.getBean("taskService", ITaskService.class);
//		String processId="";
//		int pageNo=1;
//		int pageSize=10;
//
//		//流程模板id
////		List<String> processList=processService.getRunTrail(processId);
////		log.info("processList:"+processList);
//		Page page=processService.getProcessByNames(pageNo, pageSize, false);
//		log.info("records:"+page.getRecords().get(0));
//		log.info("TotalRecord:"+page.getTotalRecord());
//		if(null!=page){
//			System.out.println("=======================page:"+page.getRecords());
//			List list=page.getRecords();
//			if(null!=list && list.size()>0){
//				for(int i=0;i<list.size();i++){
////					log.info("=========================Record:"+list.get(i));
//					Map processMap=(Map)list.get(i);
//					log.info("=========================客户名称:");//客户名称
//					log.info("=========================申请编号:"+processMap.get("BIZ_ID"));//申请编号
//					log.info("=========================流程编号:"+processMap.get("PROCESS_ID"));//流程编号
//					log.info("=========================流程名称名称:"+processMap.get("PROCESS_NAME"));//流程名称名称
//					log.info("=========================流程状态:"+processMap.get("END_DATE"));//流程状态
//					log.info("=========================发起时间:"+processMap.get("START_DATE"));//发起时间
//					log.info("=========================发起人:"+processMap.get("STARTED_USER"));//发起人
//					log.info("=========================发起机构:");//发起机构
//					processId=null!=processMap.get("PROCESS_ID")?processMap.get("PROCESS_ID").toString():"";
//					Page taskPage=taskService.getUnTakeTask("", processId, pageNo, pageSize);
//					if(null!=taskPage&&taskPage.getRecords().size()>0){
//						BSysTask bSysTask=JSON.parseObject(taskPage.getRecords().get(0).toString(), new TypeReference<BSysTask>(){});
//						if(null!=bSysTask){
//							String taskDesId=bSysTask.getTaskId();
//							log.info("=========================>>>当前任务taskDesId:"+taskDesId);
//							String taskName="";
//							String modelId="";
//							String nodeId="";
//							NodeEntity nodeEntity=processService.getCurrentNodeEntity(bSysTask.getProcessId());//根据processId取出节点ID
//							if(null!=nodeEntity){
//								nodeId=nodeEntity.getId();
//								log.info("=========================>>>当前节点nodeId:"+nodeId);
//							}
//							Map<String,Object> taskDesMap=websiteService.getTaskDes(pageNo, pageSize, taskDesId, taskName, modelId, nodeId);
//							if(null!=taskDesMap && taskDesMap.size()>0){
//								List<Map<String,String>> taskDesList=(List<Map<String,String>>)taskDesMap.get("records");
//								if(null!=taskDesList && taskDesList.size()>0){
//									String users=taskDesList.get(0).get("userIds");
//									log.info("=========================>>>待办人员:"+users);
//								}
//							}
//						}
//						
//					}
//					
//
//				}
//				
//			}
//			log.info("=========================page TotalRecord:"+page.getTotalRecord());
//		}
		
	}
}
