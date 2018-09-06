package com.huateng.scf.bas.crm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author htrad0055
 *
 */
public class BCrmInsureInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * VARCHAR(15) 必填<br>
	 * 客户号
	 */
	private String custcd;

	/**
	 * VARCHAR(50)<br>
	 * 核心客户号
	 */
	private String custno;


	/**
	 * VARCHAR(80) 必填<br>
	 * 客户名称
	 */
	private String cname;


	/**
	 * VARCHAR(50)<br>
	 * 信贷客户号
	 */
	private String ccmsCustcd;

	/**
	 * VARCHAR(10) 必填<br>
	 * 组织机构代码
	 */
	private String orgCode;

	/**
	 * VARCHAR(10)<br>
	 * 国标行业分类名称
	 */
	private String industryTypeName;
	
	
	/**
	 * VARCHAR(10)<br>
	 * 国标行业分类
	 */
	private String industryType;


	/**
	 * VARCHAR(2)<br>
	 * 企业规模
	 */
	private String enterpriseScope;

	/**
	 * VARCHAR(10)<br>
	 * 是否上市公司
	 */
	private String isMarketCorp;

	/**
	 * CHAR(8)<br>
	 * 企业成立时间
	 */
	private String establishDate;

	/**
	 * DECIMAL(16,2)<br>
	 * 注册资本
	 */
	private BigDecimal regCapital;

	/**
	 * VARCHAR(100)<br>
	 * 省份、直辖市、自治区
	 */
	private String area;


	/**
	 * 
	 * 创建人姓名
	 */
	private String tlrName;

	/**
	 * 
	 * 经办机构名称
	 */
	private String brName;

	/**
	 * CHAR(1)<br>
	 * 是否保险公司：0-否、1-是
	 */
	private String insureFlag;

	/**
	 * VARCHAR(120)<br>
	 * 客户英文名
	 */
	private String ename;

	/**
	 * VARCHAR(50) 必填<br>
	 * 法定代表人
	 */
	private String legal;

	/**
	 * VARCHAR(80)<br>
	 * 联系人
	 */
	private String contactName;

	/**
	 * VARCHAR(30)<br>
	 * 联系电话
	 */
	private String contactTel;

	/**
	 * VARCHAR(30)<br>
	 * 传真号码
	 */
	private String fax;

	/**
	 * VARCHAR(300)<br>
	 * 注册地址
	 */
	private String regAddr;
	
	
	/**
	 * 客户状态
	 */
	private String custStatus;
	
	/**
	 * 联系地址
	 */
	private String contactAddr;

	public String getCustcd() {
		return custcd;
	}

	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	public String getCustno() {
		return custno;
	}

	public void setCustno(String custno) {
		this.custno = custno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCcmsCustcd() {
		return ccmsCustcd;
	}

	public void setCcmsCustcd(String ccmsCustcd) {
		this.ccmsCustcd = ccmsCustcd;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getIndustryTypeName() {
		return industryTypeName;
	}

	public void setIndustryTypeName(String industryTypeName) {
		this.industryTypeName = industryTypeName;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getEnterpriseScope() {
		return enterpriseScope;
	}

	public void setEnterpriseScope(String enterpriseScope) {
		this.enterpriseScope = enterpriseScope;
	}

	public String getIsMarketCorp() {
		return isMarketCorp;
	}

	public void setIsMarketCorp(String isMarketCorp) {
		this.isMarketCorp = isMarketCorp;
	}

	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}

	public BigDecimal getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(BigDecimal regCapital) {
		this.regCapital = regCapital;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public String getInsureFlag() {
		return insureFlag;
	}

	public void setInsureFlag(String insureFlag) {
		this.insureFlag = insureFlag;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getLegal() {
		return legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getRegAddr() {
		return regAddr;
	}

	public void setRegAddr(String regAddr) {
		this.regAddr = regAddr;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public String getContactAddr() {
		return contactAddr;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((brName == null) ? 0 : brName.hashCode());
		result = prime * result + ((ccmsCustcd == null) ? 0 : ccmsCustcd.hashCode());
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((contactAddr == null) ? 0 : contactAddr.hashCode());
		result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((contactTel == null) ? 0 : contactTel.hashCode());
		result = prime * result + ((custStatus == null) ? 0 : custStatus.hashCode());
		result = prime * result + ((custcd == null) ? 0 : custcd.hashCode());
		result = prime * result + ((custno == null) ? 0 : custno.hashCode());
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + ((enterpriseScope == null) ? 0 : enterpriseScope.hashCode());
		result = prime * result + ((establishDate == null) ? 0 : establishDate.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((industryType == null) ? 0 : industryType.hashCode());
		result = prime * result + ((industryTypeName == null) ? 0 : industryTypeName.hashCode());
		result = prime * result + ((insureFlag == null) ? 0 : insureFlag.hashCode());
		result = prime * result + ((isMarketCorp == null) ? 0 : isMarketCorp.hashCode());
		result = prime * result + ((legal == null) ? 0 : legal.hashCode());
		result = prime * result + ((orgCode == null) ? 0 : orgCode.hashCode());
		result = prime * result + ((regAddr == null) ? 0 : regAddr.hashCode());
		result = prime * result + ((regCapital == null) ? 0 : regCapital.hashCode());
		result = prime * result + ((tlrName == null) ? 0 : tlrName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BCrmInsureInfo other = (BCrmInsureInfo) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (brName == null) {
			if (other.brName != null)
				return false;
		} else if (!brName.equals(other.brName))
			return false;
		if (ccmsCustcd == null) {
			if (other.ccmsCustcd != null)
				return false;
		} else if (!ccmsCustcd.equals(other.ccmsCustcd))
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (contactAddr == null) {
			if (other.contactAddr != null)
				return false;
		} else if (!contactAddr.equals(other.contactAddr))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (contactTel == null) {
			if (other.contactTel != null)
				return false;
		} else if (!contactTel.equals(other.contactTel))
			return false;
		if (custStatus == null) {
			if (other.custStatus != null)
				return false;
		} else if (!custStatus.equals(other.custStatus))
			return false;
		if (custcd == null) {
			if (other.custcd != null)
				return false;
		} else if (!custcd.equals(other.custcd))
			return false;
		if (custno == null) {
			if (other.custno != null)
				return false;
		} else if (!custno.equals(other.custno))
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		if (enterpriseScope == null) {
			if (other.enterpriseScope != null)
				return false;
		} else if (!enterpriseScope.equals(other.enterpriseScope))
			return false;
		if (establishDate == null) {
			if (other.establishDate != null)
				return false;
		} else if (!establishDate.equals(other.establishDate))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (industryType == null) {
			if (other.industryType != null)
				return false;
		} else if (!industryType.equals(other.industryType))
			return false;
		if (industryTypeName == null) {
			if (other.industryTypeName != null)
				return false;
		} else if (!industryTypeName.equals(other.industryTypeName))
			return false;
		if (insureFlag == null) {
			if (other.insureFlag != null)
				return false;
		} else if (!insureFlag.equals(other.insureFlag))
			return false;
		if (isMarketCorp == null) {
			if (other.isMarketCorp != null)
				return false;
		} else if (!isMarketCorp.equals(other.isMarketCorp))
			return false;
		if (legal == null) {
			if (other.legal != null)
				return false;
		} else if (!legal.equals(other.legal))
			return false;
		if (orgCode == null) {
			if (other.orgCode != null)
				return false;
		} else if (!orgCode.equals(other.orgCode))
			return false;
		if (regAddr == null) {
			if (other.regAddr != null)
				return false;
		} else if (!regAddr.equals(other.regAddr))
			return false;
		if (regCapital == null) {
			if (other.regCapital != null)
				return false;
		} else if (!regCapital.equals(other.regCapital))
			return false;
		if (tlrName == null) {
			if (other.tlrName != null)
				return false;
		} else if (!tlrName.equals(other.tlrName))
			return false;
		return true;
	}
	
	
}