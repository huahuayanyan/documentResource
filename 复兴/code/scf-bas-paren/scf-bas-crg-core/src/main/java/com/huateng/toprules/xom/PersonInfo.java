package com.huateng.toprules.xom;

import java.io.Serializable;
import java.util.Date;

import com.huateng.toprules.core.annotation.ModelField;
import com.huateng.toprules.core.annotation.ModelInstance;

@SuppressWarnings("serial")
@ModelInstance(description="公共模型")
public class PersonInfo implements Serializable {
	
	@ModelField(name="姓名", bindDomain="")
	private String name = "";
	
	@ModelField(name="家庭地址邮编", bindDomain="")
	private String homeAddressPost = "";
	
	@ModelField(name="家庭家庭电话", bindDomain="")
	private String homeTelephone = "";
	
	@ModelField(name="电子邮件", bindDomain="")
	private String email = "";
	
	@ModelField(name="紧急联系人", bindDomain="")
	private String urgencyConnPerson = "";
	
	@ModelField(name="紧急联系人地址", bindDomain="")
	private String urgencyConnPersonAddress = "";
	
	@ModelField(name="紧急联系人手机", bindDomain="")
	private String urgencyConnPersonPhone = "";
	
	@ModelField(name="个人月收入总额", bindDomain="")
	private double singleMonthSalary = 0.0;
	
	@ModelField(name="家庭月收入", bindDomain="")
	private double homeMonthSalary = 0.0;
	
	@ModelField(name="家庭总资产", bindDomain="")
	private double homeProperty = 0.0;
	
	@ModelField(name="家庭总负债", bindDomain="")
	private double homeDebt = 0.0;
	
	@ModelField(name="账单寄往", bindDomain="")
	private String billsend = "";
	
	@ModelField(name="客户评级", bindDomain="")
	private String custLevel = "";
	
	@ModelField(name="客户状态", bindDomain="")
	private String custstatus = "";
	
	@ModelField(name="证件类型", bindDomain="")
	private String credityType = "";
	
	@ModelField(name="证件号码", bindDomain="")
	private String credityNumber = "";
	
	@ModelField(name="出生日期", bindDomain="")
	private Date birthday = new Date();
	
	@ModelField(name="民族", bindDomain="")
	private String nation = "";
	
	@ModelField(name="居住状况", bindDomain="")
	private String liveStatus = "";
	
	@ModelField(name="年龄", bindDomain="")
	private int age = 0;
	
	@ModelField(name="户籍地址", bindDomain="")
	private String province = "";
	
	@ModelField(name="工资", bindDomain="")
	private double salary = 0.0;
	
	@ModelField(name="家庭地址", bindDomain="")
	private String homeAddress = "";
	
	@ModelField(name="性别", bindDomain="")
	private String sex = "";
	
	@ModelField(name="教育程度", bindDomain="")
	private String education = "";
	
	@ModelField(name="手机号码", bindDomain="")
	private String mobilephone = "";
	
	@ModelField(name="婚姻状况", bindDomain="")
	private String hunyin = "";
	
	@ModelField(name="政治面貌", bindDomain="")
	private String zhengzhimianmao = "";
	
	@ModelField(name="公司地址", bindDomain="")
	private String companyAddress = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomeAddressPost() {
		return homeAddressPost;
	}

	public void setHomeAddressPost(String homeAddressPost) {
		this.homeAddressPost = homeAddressPost;
	}

	public String getHomeTelephone() {
		return homeTelephone;
	}

	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrgencyConnPerson() {
		return urgencyConnPerson;
	}

	public void setUrgencyConnPerson(String urgencyConnPerson) {
		this.urgencyConnPerson = urgencyConnPerson;
	}

	public String getUrgencyConnPersonAddress() {
		return urgencyConnPersonAddress;
	}

	public void setUrgencyConnPersonAddress(String urgencyConnPersonAddress) {
		this.urgencyConnPersonAddress = urgencyConnPersonAddress;
	}

	public String getUrgencyConnPersonPhone() {
		return urgencyConnPersonPhone;
	}

	public void setUrgencyConnPersonPhone(String urgencyConnPersonPhone) {
		this.urgencyConnPersonPhone = urgencyConnPersonPhone;
	}

	public double getSingleMonthSalary() {
		return singleMonthSalary;
	}

	public void setSingleMonthSalary(double singleMonthSalary) {
		this.singleMonthSalary = singleMonthSalary;
	}

	public double getHomeMonthSalary() {
		return homeMonthSalary;
	}

	public void setHomeMonthSalary(double homeMonthSalary) {
		this.homeMonthSalary = homeMonthSalary;
	}

	public double getHomeProperty() {
		return homeProperty;
	}

	public void setHomeProperty(double homeProperty) {
		this.homeProperty = homeProperty;
	}

	public double getHomeDebt() {
		return homeDebt;
	}

	public void setHomeDebt(double homeDebt) {
		this.homeDebt = homeDebt;
	}

	public String getBillsend() {
		return billsend;
	}

	public void setBillsend(String billsend) {
		this.billsend = billsend;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCuststatus() {
		return custstatus;
	}

	public void setCuststatus(String custstatus) {
		this.custstatus = custstatus;
	}

	public String getCredityType() {
		return credityType;
	}

	public void setCredityType(String credityType) {
		this.credityType = credityType;
	}

	public String getCredityNumber() {
		return credityNumber;
	}

	public void setCredityNumber(String credityNumber) {
		this.credityNumber = credityNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getLiveStatus() {
		return liveStatus;
	}

	public void setLiveStatus(String liveStatus) {
		this.liveStatus = liveStatus;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getHunyin() {
		return hunyin;
	}

	public void setHunyin(String hunyin) {
		this.hunyin = hunyin;
	}

	public String getZhengzhimianmao() {
		return zhengzhimianmao;
	}

	public void setZhengzhimianmao(String zhengzhimianmao) {
		this.zhengzhimianmao = zhengzhimianmao;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	
	
}
