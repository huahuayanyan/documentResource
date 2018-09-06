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
 * 
 * <p>统计分析：融资统计分析  定时任务</p>
 *
 * @author 	shangxiujuan
 * @date 2017年7月5日上午10:42:44
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年7月5日上午10:42:44              新增
 *
 * </pre>
 */
public class OdsFinaStaAnalysisTask{
	public OdsFinaStaAnalysisTask(){};
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public TaskExecResult handle(TaskExecContext context){
		logger.info("融资统计分析定时任务。。。。每晚零点执行"+new Date());
	    TaskExecResult tr= new TaskExecResult(true);
	    try {
	    	GeneralControl.startJob(BatchConstant.GENERAL_CONTROL_THREAD_NAME, 101);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return tr;
	}
	
}
