package com.huateng.scf.bas.autotask.service;

import java.util.List;

import com.huateng.base.task.model.JobDes;
import com.huateng.scf.bas.autotask.model.JobDesDto;
import com.huateng.scube.server.annotation.ScubeParam;

public interface BatchFileService {
	//获取任务列表
	public List<JobDes> queryJobDesList();
	//修改任务
	public void updateJobDes(@ScubeParam("jobDes") JobDes jobDes);
	//新增任务
	public void addJobDes(@ScubeParam("jobDes") JobDes jobDes);
	//删除任务
	public void delJobDes(@ScubeParam("jobId") String jobId) ;
	//启动任务
	public void  startJob(@ScubeParam("jobId") String jobId);
	//停止任务
	public void  stopJob(@ScubeParam("jobId") String jobId);
	//立即启动任务   
	public void  startJobNow(@ScubeParam("jobId") String jobId);

}
