package com.huateng.scf.bas.autotask.model;

import com.huateng.base.task.model.JobDes;

public class JobDesDto extends JobDes{
    //private String busiDate;//营业日期
	private String startTime;//开始时间
	private int sucCount;//成功条数
	private int errorCount;//失败条数
	private String jobDependsId;//依赖ID
	private String jobStart;//状态
	private String week;
	private String day;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getSucCount() {
		return sucCount;
	}
	public void setSucCount(int sucCount) {
		this.sucCount = sucCount;
	}
	public int getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}
	public String getJobDependsId() {
		return jobDependsId;
	}
	public void setJobDependsId(String jobDependsId) {
		this.jobDependsId = jobDependsId;
	}
	public String getJobStart() {
		return jobStart;
	}
	public void setJobStart(String jobStart) {
		this.jobStart = jobStart;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
	
}
