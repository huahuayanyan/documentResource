package com.huateng.scf.bas.batch.common.log;

import java.io.File;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Log4j logger name define
 *
 * @author weikun wang
 *
 */

public class LoggerConstants {
	static{
		//PropertyConfigurator.configure(LoggerConstants.class.getResource("log4j.properties"));
		PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
	}

	public static Logger getBatchLogger( String logFilePathName)
			throws Exception {
			String[] str=logFilePathName.split("\\\\");
			String fileName=str[str.length-1];
			Logger tempLogger=Logger.getLogger("temp");

			Logger batchLogger=Logger.getLogger(fileName);
			batchLogger.setLevel(tempLogger.getLevel());
			FileAppender batchAppender = (FileAppender)batchLogger.getAppender(fileName);
			if(batchAppender==null){
				FileAppender tempAppender=(FileAppender)tempLogger.getAppender("tempfileout");
				batchAppender=new org.apache.log4j.FileAppender();
				batchAppender.setName(fileName);
				batchAppender.setLayout(tempAppender.getLayout());
				File file = new File(logFilePathName);
				batchAppender.setFile(file.toString());
				batchLogger.addAppender(batchAppender);
				batchAppender.activateOptions();
			}else{
				File file = new File(logFilePathName);
				batchAppender.setFile(file.toString());
				batchAppender.activateOptions();
			}

			return batchLogger;
	}

}
