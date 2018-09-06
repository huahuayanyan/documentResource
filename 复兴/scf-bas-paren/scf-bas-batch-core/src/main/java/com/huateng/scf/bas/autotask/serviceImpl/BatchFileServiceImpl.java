package com.huateng.scf.bas.autotask.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.base.task.dao.impl.JobDaoImpl;
import com.huateng.base.task.dao.impl.TaskDaoImpl;
import com.huateng.base.task.model.JobDes;
import com.huateng.base.task.quartz.QuartzManager;
import com.huateng.base.task.service.JobDesService;
import com.huateng.base.task.service.impl.ExeServiceImpl;
import com.huateng.base.task.vo.TaskExecContext;
import com.huateng.scf.bas.autotask.service.BatchFileService;
import com.huateng.scf.bas.common.util.ContextUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BatchFileServiceImpl")
public class BatchFileServiceImpl implements BatchFileService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
		
	@Autowired
	private JobDesService jobDesService;
	
	@Autowired
	private TaskDaoImpl taskDaoImpl;
	
	@Autowired
	private JobDaoImpl jobDaoImpl;
	
	@Autowired
	private QuartzManager quartzManager;
	
	@Autowired
	private ExeServiceImpl exeService;
    
	@Override
	public List<JobDes> queryJobDesList() {
		List<JobDes> jobDesList=new ArrayList<JobDes>();
		try {
			jobDesList=quartzManager.getJobRunInfo();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ScubeBizException("获取任务列表出错");
		}
		return jobDesList;
	}


	@Override
	public void updateJobDes(JobDes jobDes) {
		if(jobDes ==null){
			throw new ScubeBizException("参数不能为空");
		}
		try {
			jobDesService.updateJobDes(jobDes);
			quartzManager.modifyJobTime(jobDes.getJobId(), jobDes.getCron());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ScubeBizException("修改任务出错");
		}
	}

	@Override
	public void addJobDes(JobDes jobDes) {
		if(jobDes == null){
			throw new ScubeBizException("参数不能为空");
		}
		try {
			jobDesService.saveJobDes(jobDes);//添加配置信息
			//quartzManager.addJob(jobDes.getJobId()); //启动
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ScubeBizException("添加任务失败！");
		}	
	}

	@Override
	public void delJobDes(String jobId) {
		if(StringUtils.isEmpty(jobId)){
			throw new ScubeBizException("参数不能为空");
		}
		try {
			jobDesService.deleteJobDes(jobId);
			JobDes jobDes=jobDesService.getJobDes(jobId);
			if(jobDes!=null){
				jobDesService.deleteDependency(jobDes.getDependency().getFrontDependencyId());
			}
			quartzManager.removeJob(jobId);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ScubeBizException("删除任务出错");
		}
	}

	@Override
	public void startJob(String jobId) {
		if(StringUtils.isEmpty(jobId)){
			throw new ScubeBizException("参数不能为空!");
		}
		try {
			quartzManager.addJob(jobId);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ScubeBizException("启动任务出错!");
		}
	}
	
	@Override
	public void stopJob(String jobId) {
		if(StringUtils.isEmpty(jobId)){
			throw new ScubeBizException("参数不能为空!");
		}
		try {
			quartzManager.removeJob(jobId);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ScubeBizException("停止任务出错!");
		}
	}
    
	@SuppressWarnings({ "unused", "rawtypes" })
	@Override
	public void startJobNow(String jobId) {
		 try {
			JobDes  jobDes = jobDesService.getJobDes(jobId);
			String jobMethod = jobDes.getJobMethod();
			int beginIndex = jobMethod.indexOf(":");
			int endIndex = jobMethod.indexOf(".");
			String method = "";
			StringBuffer sb = new StringBuffer();
			if(beginIndex != -1 && endIndex != -1){
				String  beanId = jobMethod.substring(beginIndex+1,endIndex);
				String  funcId = jobMethod.substring(endIndex+1);
				
				Class<? extends Object> c = ContextUtil.getBean(beanId).getClass();
				TaskExecContext context=new TaskExecContext();
				Map map=new HashMap();
				context.setContext(map);
				c.getDeclaredMethod(funcId,TaskExecContext.class).invoke(ContextUtil.getBean(beanId),context);
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
}
