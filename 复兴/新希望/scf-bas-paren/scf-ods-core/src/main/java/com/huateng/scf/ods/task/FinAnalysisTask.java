package com.huateng.scf.ods.task;

import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huateng.base.task.vo.TaskExecContext;
import com.huateng.base.task.vo.TaskExecResult;
import com.huateng.scf.ods.util.OdsUtils;

public class FinAnalysisTask {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private OdsUtils uitls=OdsUtils.getUtils();

	public TaskExecResult handle(TaskExecContext context) {
		logger.info("==========the timed task has been invoked=={}============", context.getContext().get("test"));
		TaskExecResult tr = new TaskExecResult(true);
		try {
			
			String[] params = { "C20170329000219", "B" }; // 传递参数
			this.runJob(uitls.getConn(), params, "融资分析", "/融资分析");
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
			job.setVariable("custcd", params[0]);
			job.setVariable("value", params[1]);
			job.start();
			job.waitUntilFinished();
			if (job.getErrors() > 0) {
				throw new Exception("There are errors during job exception!(执行job发生异常)");
			}
		} catch (Exception e) {
			logger.error("执行job["+jobName+"]失败！",e);
		}
	}
	
	/**
	 * 运行转换文件方法
	 * 
	 * @param params
	 *            多个参数变量值
	 * @param ktrPath
	 *            转换文件的路径，后缀ktr
	 */
	public void runTransfer(KettleDatabaseRepository rep,String[] params, String transName,String dirpath) {
		Trans trans = null;
		try {
			RepositoryDirectoryInterface dir=rep.findDirectory(dirpath);
			TransMeta transMeta=rep.loadTransformation(transName, dir, null, true,null);
			// 转换
			trans = new Trans(transMeta);
			trans.setVariable("custcd", params[0]);
			// 执行转换
			trans.execute(null);
			// 等待转换执行结束
			trans.waitUntilFinished();
			// 抛出异常
			if (trans.getErrors() > 0) {
				throw new Exception("There are errors during transformation exception!(传输过程中发生异常)");
			}
		} catch (Exception e) {
			logger.error("执行trans["+transName+"]失败！",e);
		}
	}
	
	public static void main(String[] args) throws Exception {
		OdsUtils uitls=OdsUtils.getUtils();
		String[] params = { "C20170329000219", "B" }; // 传递参数
		//执行job
		//new FinAnalysisTask().runJob(uitls.getConn(), params, "融资分析", "/融资分析");
		//执行transfer
		new FinAnalysisTask().runTransfer(uitls.getConn(), params, "资信分析", "/融资分析");
	}
}
