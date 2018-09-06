/**
 * 
 */
package com.huateng.scf.ods.task;

import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huateng.base.task.vo.TaskExecContext;
import com.huateng.base.task.vo.TaskExecResult;
import com.huateng.scf.ods.util.OdsUtils;

/**
 * <p>
 * 供应链授信客户业务月报任务调度
 * </p>
 *
 * @author huangshuidan
 * @date 2017年6月7日上午10:34:15
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年6月7日上午10:34:15             新增
 *
 * </pre>
 */
public class ScfCreditCustBusinTask {
private Logger logger = LoggerFactory.getLogger(getClass());
	
	private OdsUtils uitls=OdsUtils.getUtils();

	public TaskExecResult handle(TaskExecContext context) {
		logger.info("==========the timed task has been invoked=={}============", context.getContext().get("test"));
		TaskExecResult tr = new TaskExecResult(true);
		try {
			
			String[] params = { "", "" }; // 传递参数
			this.runJob(uitls.getConn(), params, "scf-credit-cust-busin-job", "/ODS_LNCI");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return tr;
	}
	
	/**
	 * @param rep kettle资源库连接
	 * @param params 需要传入的参数
	 * @param jobName job的名称
	 * @param dirpath job的目录
	 */
	public void runJob(KettleDatabaseRepository rep,String[] params, String jobName,String dirpath) {
		try {
			RepositoryDirectoryInterface dir=rep.findDirectory(dirpath);
			JobMeta jobMeta=rep.loadJob(jobName, dir, null, null);
			
			Job job = new Job(rep, jobMeta);
//			job.setVariable("custcd", params[0]);
//			job.setVariable("value", params[1]);
			job.start();
			job.waitUntilFinished();
			if (job.getErrors() > 0) {
				throw new Exception("There are errors during job exception!(执行job发生异常)");
			}
		} catch (Exception e) {
			logger.error("执行job["+jobName+"]失败！",e);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		OdsUtils uitls=OdsUtils.getUtils();
		String[] params = { "", "" }; // 传递参数
		//执行job
		new ScfFactoringFreeTask().runJob(uitls.getConn(), params, "scf-credit-cust-busin-job", "/ODS_LNCI");
		System.out.println("执行job.....end!");
	}
}
