package com.huateng.scf.bas.batch.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alibaba.fastjson.JSON;
import com.huateng.base.task.dao.impl.JobDaoImpl;
import com.huateng.base.task.dao.impl.TaskDaoImpl;
import com.huateng.base.task.model.AutoTask;
import com.huateng.base.task.model.JobDes;
import com.huateng.base.task.model.TaskContext;
import com.huateng.base.task.quartz.QuartzManager;
import com.huateng.base.task.service.JobDesService;
import com.huateng.base.task.service.impl.ExeServiceImpl;
import com.huateng.base.task.utils.BizIdUtil;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/com/config/applicationContext.xml" })
// @Transactional
// @TransactionConfiguration(defaultRollback=false)
public class MyJobTaskTest {

	@Autowired
	private ExeServiceImpl exeService;
	
	@Autowired
	private JobDaoImpl jobDaoImpl;
	@Autowired
	private TaskDaoImpl taskDaoImpl;
	@Autowired
	private JobDesService jobDesService;
	@Autowired
	private QuartzManager quartzManager;
	
	
	@Test
	public void testJobDesService() {
		
		String jobId = "6";
		
		JobDes jobdes1 = new JobDes();
		jobdes1.setJobId(jobId);
		jobdes1.setJobName("job"+jobId);
		
		jobdes1.setDependency(null);
		
		jobdes1.setJobMethod("spring:testTask.handle");
		jobdes1.setExecExpireMinute(1);
		jobdes1.setMaxExecTimes(1);
		
		Map context = new HashMap();
		context.put("a", "123");
		context.put("b", "456");
		jobdes1.setContext(context);
		jobdes1.setCron("*/5 * * * * ?");
		
		jobdes1.setFirstExecDelaySeconds(1);
		
		jobdes1.setJobStrategy("MIN");
		
		try {
			jobDesService.saveJobDes(jobdes1);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		List<JobDes> jobDesList = new ArrayList<JobDes>();
		try {
			jobDesList = jobDesService.getJobDeses();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int a = 0; a < jobDesList.size(); a++) {
			JobDes jobdes = jobDesList.get(a);
			System.out.println(JSON.toJSONString(jobdes));
		}

	}

	@Test
	public void testTaskDao() {
		
		String jobId = "5";
		String bizId = BizIdUtil.generateByMinute();
		
		AutoTask task = new AutoTask();
		task.setTaskType(jobId);
		task.setTaskNo(bizId);
		task.setCreateTime(new Date());
		task.setUpdateTime(new Date());
		task.setContextJson("sdfsafagfgag");
		task.setMaxExecTimes(4);
		task.setTaskMethod("spring:taskTest.handler");
		task.setNextExecTime(new Date());
		task.setExecExpireMinute(3);
		task.setExecutedTimes(1);
		task.setExecMsg("no erroreeeeeeeeeeeeeeeeeeeee");
		task.setCurExecutor("abc");
		task.setLastExecutor("cbd");
		task.setTaskState("run");
		task.setLastExecedTime(new Date());
		task.setLastExecTime(new Date());

		taskDaoImpl.saveTask(task);
		AutoTask task2 = taskDaoImpl.getTask(jobId, bizId);
		System.out.println(JSON.toJSONString(task2));
		
		//更新方法报错
//		task2.setTaskState("wait");
//		taskDaoImpl.updateTask(task2);
//		System.out.println(JSON.toJSONString(taskDaoImpl.getTask("1", bizId)));
		
		taskDaoImpl.deleteTask(jobId, bizId);

	}
	
	
	@Test
	public void testTaskContext() {
		
		String jobId = "5";
		String bizId = BizIdUtil.generateByMinute();
		
		TaskContext taskContext = new TaskContext();
		taskContext.setTaskId(jobId);
		taskContext.setBizId(bizId);
		taskContext.setCreateTime("2017");
		taskContext.setSeq(1);
		taskContext.setTaskContextJson("a:123");
		jobDaoImpl.saveTaskContext(taskContext);
		
		int max = jobDaoImpl.getMaxSeqByBizId(bizId);
		System.out.println(max);
		
		TaskContext taskContext1 = jobDaoImpl.getTaskContext(jobId, bizId);
		System.out.println(taskContext1.getTaskContextJson());
		
		TaskContext taskContext2 = jobDaoImpl.getLastTaskContext(bizId);
		System.out.println(taskContext2.getTaskContextJson());
		
		TaskContext taskContext3 = jobDaoImpl.getLaskTaskContextLikeBizId(jobId, bizId);
		System.out.println(taskContext3.getTaskContextJson());

		jobDaoImpl.deleteTaskContext(jobId, bizId);

	}
	
	
	

	
	@Test
	public void testExeJob() {
		
		String jobId = "6";
		String bizId = BizIdUtil.generateByMinute();
		
		quartzManager.addJob(jobId);
		quartzManager.addJob("8");
		
		for(int i = 0;i<1;i++){
			try {
				Thread.sleep(1 * 20 * 1000);
/*				List<JobDes> list = quartzManager.getJobRunInfo();
				for (JobDes job : list) {
					System.out.println("===job-"+job.getJobId());
					System.out.println("==="+job.getRunStatus());
				}*/
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
//			bizId = BizIdUtil.generateByMinute();
//			TaskContext taskContext=jobDaoImpl.getTaskContext(jobId, bizId);
//			System.out.println("bizId="+bizId+"=="+taskContext.getTaskContextJson());
		}
		
		
		//动态改变时间间隔无效
		//quartzManager.modifyJobTime("5", "*/10 * * * * ?");
		
//		bizId = "12345";
//		exeService.forceExe("5", bizId);
		
		
		
		
		quartzManager.removeJob(jobId);
		quartzManager.removeJob("8");
		
		
	}
	

	
	
	

}