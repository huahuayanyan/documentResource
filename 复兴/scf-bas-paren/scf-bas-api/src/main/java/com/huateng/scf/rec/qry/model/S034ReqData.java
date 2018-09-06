package com.huateng.scf.rec.qry.model;


/**
 * 文件名：S034ReqData.java
 * 功能描述：核心前台账号入账查询－输入报文体信息
 * JDK版本: <1.5.0>
 * 程序版本: SupplyChainSysPortal <1.0> <br>
 * 修改历史 <br>
 *  date           | author  | desc <br>
 */
public class S034ReqData {
	private String jymmbz;	//密码校验方式
	private String mimaaa;	//密码
	private String kehhao;	//客户号
	private String cuacno;	//客户账号
	private String chiser;	//子账户序号
	private String huobdh;	//货币代号
	private String qishrq;	//起始日期
	private String daoqrq;	//到期日期
	private int qishbs;	//起始笔数
	private int cxunbs;	//查询笔数
	private String jiedbz;	//借贷标志

	public String getJymmbz() {
		return jymmbz;
	}
	public void setJymmbz(String jymmbz) {
		this.jymmbz = jymmbz;
	}
	public String getMimaaa() {
		return mimaaa;
	}
	public void setMimaaa(String mimaaa) {
		this.mimaaa = mimaaa;
	}
	public String getKehhao() {
		return kehhao;
	}
	public void setKehhao(String kehhao) {
		this.kehhao = kehhao;
	}
	public String getCuacno() {
		return cuacno;
	}
	public void setCuacno(String cuacno) {
		this.cuacno = cuacno;
	}
	public String getChiser() {
		return chiser;
	}
	public void setChiser(String chiser) {
		this.chiser = chiser;
	}
	public String getHuobdh() {
		return huobdh;
	}
	public void setHuobdh(String huobdh) {
		this.huobdh = huobdh;
	}
	public String getQishrq() {
		return qishrq;
	}
	public void setQishrq(String qishrq) {
		this.qishrq = qishrq;
	}
	public String getDaoqrq() {
		return daoqrq;
	}
	public void setDaoqrq(String daoqrq) {
		this.daoqrq = daoqrq;
	}
	public int getQishbs() {
		return qishbs;
	}
	public void setQishbs(int qishbs) {
		this.qishbs = qishbs;
	}
	public int getCxunbs() {
		return cxunbs;
	}
	public void setCxunbs(int cxunbs) {
		this.cxunbs = cxunbs;
	}
	public String getJiedbz() {
		return jiedbz;
	}
	public void setJiedbz(String jiedbz) {
		this.jiedbz = jiedbz;
	}

}
