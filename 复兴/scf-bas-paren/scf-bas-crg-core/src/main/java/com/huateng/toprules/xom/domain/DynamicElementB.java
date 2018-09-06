package com.huateng.toprules.xom.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.huateng.toprules.core.annotation.ModelInstance;

/**
 * 动态要素  用在某些需要实时动态变动要素属性的场景.
 * @author FKY
 *Nov 11, 2015
 */
@SuppressWarnings("serial")
@ModelInstance(description="动态类B")
public class DynamicElementB implements Serializable{

	/**
	 * 动态数据.
	 */
	private Map<String,Object> dynamicData = new HashMap<String, Object>();
	

	/**
	 * 返回动态要素数据结果集.
	 */
	private Map<String,Object> resultMap = new HashMap<String, Object>();

	
	public String getDmString(String key) {
		if(this.dynamicData.containsKey(key)){
			return this.dynamicData.get(key).toString();
		}
		return "";
	}

	public void setDmString(String key,String value ) {
		this.resultMap.put(key, value);
	}

	public int getDmInteger(String key) {
		if(this.dynamicData.containsKey(key)){
			return ((Integer)this.dynamicData.get(key));
		}
		return Integer.valueOf(-1);
	}

	public void setDmInteger(String key,int value) {
		this.resultMap.put(key, value);
	}

	public double getDmDouble(String key) {
		if(this.dynamicData.containsKey(key)){
			return ((Double)this.dynamicData.get(key));
		}
		return Double.valueOf(-1);
	}

	public void setDmDouble(String key,double value) {
		this.resultMap.put(key, value);
	}

	public Date getDmDate(String key) {
		if(this.dynamicData.containsKey(key)){
			return (Date) this.dynamicData.get(key);
		}
		return null;
	}

	public void setDmDate(String key,Date value) {
		this.resultMap.put(key, value);
		
	}
	

	public Map<String, Object> getResultMap() {
		return resultMap;
	}


	public void setDynamicData(Map<String, Object> dynamicData) {
		this.dynamicData = dynamicData;
	}

	public Map<String, Object> getDynamicData() {
		return dynamicData;
	}
	
	
}
