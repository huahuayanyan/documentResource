package com.huateng.scf.adv.bcp.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huateng.base.task.vo.TaskExecContext;
import com.huateng.base.task.vo.TaskExecResult;

public class TimedTask {
private Logger logger = LoggerFactory.getLogger(getClass());
	
	private Integer count = 0;
	
	public TaskExecResult handle(TaskExecContext context){
		logger.info("==========the timed task has been invoked=={}============" , context.getContext().get("test"));
		count ++;
		System.out.println("供应链定时调度任务开始执行。。。。"+new Date());
	    TaskExecResult tr= new TaskExecResult(true);
		return tr;
	}
	
	public void clear(){
		count = 0;
	}
	
	public Integer getCount(){
		return count;
	}
}
