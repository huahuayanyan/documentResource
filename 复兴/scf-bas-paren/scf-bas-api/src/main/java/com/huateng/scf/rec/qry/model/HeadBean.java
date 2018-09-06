package com.huateng.scf.rec.qry.model;

/**
 * 文件名：HeadBean.java
 * 功能描述：公用报文头BEAN
 * JDK版本: <1.5.0>
 * 修改历史 <br>
 *  date           | author  | desc <br>
 */
public class HeadBean {
	private String verNo;	//版本号
	private String bankId;	//机构号
	private String sndChnlNo;	//发起方渠道代码
	private String rcvChnlNo;	//接收方渠道代码
	private String extTxnNo;	//外部交易码
	private String chnlDt;	//渠道日期
	private String hostDt;	//主机日期
	private String chnlTm;	//渠道时间
	private String hostTm;	//主机时间
	private String chnlSeq;	//渠道流水号
	private String hostSeq;	//主机流水号
	private String rspNo;	//返回码
	private String rspMsg;	//返回信息

	public HeadBean(){}

	public String getVerNo() {
		return verNo;
	}

	public void setVerNo(String verNo) {
		this.verNo = verNo;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getSndChnlNo() {
		return sndChnlNo;
	}

	public void setSndChnlNo(String sndChnlNo) {
		this.sndChnlNo = sndChnlNo;
	}

	public String getRcvChnlNo() {
		return rcvChnlNo;
	}

	public void setRcvChnlNo(String rcvChnlNo) {
		this.rcvChnlNo = rcvChnlNo;
	}

	public String getExtTxnNo() {
		return extTxnNo;
	}

	public void setExtTxnNo(String extTxnNo) {
		this.extTxnNo = extTxnNo;
	}

	public String getChnlDt() {
		return chnlDt;
	}

	public void setChnlDt(String chnlDt) {
		this.chnlDt = chnlDt;
	}

	public String getHostDt() {
		return hostDt;
	}

	public void setHostDt(String hostDt) {
		this.hostDt = hostDt;
	}

	public String getChnlTm() {
		return chnlTm;
	}

	public void setChnlTm(String chnlTm) {
		this.chnlTm = chnlTm;
	}

	public String getHostTm() {
		return hostTm;
	}

	public void setHostTm(String hostTm) {
		this.hostTm = hostTm;
	}

	public String getChnlSeq() {
		return chnlSeq;
	}

	public void setChnlSeq(String chnlSeq) {
		this.chnlSeq = chnlSeq;
	}

	public String getHostSeq() {
		return hostSeq;
	}

	public void setHostSeq(String hostSeq) {
		this.hostSeq = hostSeq;
	}

	public String getRspNo() {
		return rspNo;
	}

	public void setRspNo(String rspNo) {
		this.rspNo = rspNo;
	}

	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

}
