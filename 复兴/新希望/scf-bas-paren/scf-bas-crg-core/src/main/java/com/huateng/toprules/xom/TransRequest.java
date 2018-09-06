package com.huateng.toprules.xom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.huateng.toprules.core.annotation.ModelField;
import com.huateng.toprules.core.annotation.ModelInstance;
import com.huateng.toprules.core.annotation.ModelMethod;
import com.huateng.toprules.xom.domain.DynamicElement;
import com.huateng.toprules.xom.domain.DynamicElementB;

@ModelInstance(description="业务数据")
public class TransRequest implements Serializable {

	private static final long serialVersionUID = 3975785986525279714L;

	@ModelField(name="控制信息", bindDomain="")
	private List<ControlInfo> results = new ArrayList<ControlInfo>();

	@ModelField(name="动态类", bindDomain="")
	private DynamicElement dynamicElement;
	
	@ModelField(name="动态类B", bindDomain="")
	private DynamicElementB dynamicElementB;
	
	@ModelField(name="公共模型", bindDomain="")
	private PersonInfo personInfo;
	
	public TransRequest(){
		this.dynamicElement = new DynamicElement();
		this.dynamicElementB = new DynamicElementB();
		this.personInfo = new PersonInfo();
	}
	
	public DynamicElementB getDynamicElementB() {
		return dynamicElementB;
	}


	public void setDynamicElementB(DynamicElementB dynamicElementB) {
		this.dynamicElementB = dynamicElementB;
	}


	public DynamicElement getDynamicElement() {
		return dynamicElement;
	}


	public void setDynamicElement(DynamicElement dynamicElement) {
		this.dynamicElement = dynamicElement;
	}


	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public void setResults(List<ControlInfo> results) {
		this.results = results;
	}

	public List<ControlInfo> getResults() {
		return results;
	}

	@ModelMethod(name="设置(this)的规则信息为(#1,&lt;规则ID&gt;),(#2,&lt;处理标识&gt;),(#3,&lt;风险评分&gt;)")
	public void addResults(String ruleId, String dealFlag, int grade){
		results.add(new ControlInfo(ruleId,dealFlag,grade));
	}

}
