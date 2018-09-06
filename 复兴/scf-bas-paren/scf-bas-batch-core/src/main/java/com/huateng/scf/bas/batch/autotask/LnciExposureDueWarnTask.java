package com.huateng.scf.bas.batch.autotask;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huateng.base.task.vo.TaskExecContext;
import com.huateng.base.task.vo.TaskExecResult;
import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.control.GeneralControl;
import com.huateng.util.ContextUtil;

/**
 * <p>Title:借据到期敞口未结清预警 定时任务</p>
 * <p>Description: </p>
 * @author fangquan
 * @version:2017-05-27 15:31:11
 */
public class LnciExposureDueWarnTask{
	public LnciExposureDueWarnTask(){};
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public TaskExecResult handle(TaskExecContext context){
		logger.info("借据到期敞口未结清预警 定时任务。。。。每晚零点执行"+new Date());
	    TaskExecResult tr= new TaskExecResult(true);
	    try {
	    	GeneralControl.startJob(BatchConstant.GENERAL_CONTROL_THREAD_NAME, 99);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return tr;
	}
	
}
