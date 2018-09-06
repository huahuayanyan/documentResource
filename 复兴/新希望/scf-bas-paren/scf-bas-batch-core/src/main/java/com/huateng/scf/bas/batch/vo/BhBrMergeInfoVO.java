/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.batch.vo;

import java.io.Serializable;
import java.util.Date;

import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.DateUtil;

/**
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 机构拆并信息对象</p>
 * @author Farly.yu
 * @version:  2006-12-18 16:09:03
 */

public class BhBrMergeInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;              //序号
	private String mergeDate;        //拆并日期
	private String branchBrcode;   //分行号
	private String oldBrcode;  //旧机构序号
	private String newBrcode;  //新机构序号
	private String tlrMrgFlg;  //柜员拆并标志  F-成功 E-失败 R-拆并中 N-未处理
	private String bsnMrgflg;  //业务卡片拆并标志
	private String stsMrgFlg;  //统计分析数据拆并标志
	private String wrkFlwFlg;  //工作流清理标志

	private String validFlag;  //记录有效标志 1-有效 0-无效
	private String timestamp;    //时间戳
	private String flag;      //合并标志
	//modify by fanrong 20110525 BMS-3016-plus begin
	private String relationId; //修改标志
	private String oldBrcodeName;//旧机构/行名称
	private String newBrcodeName;//新机构/行名称
	private String reverseFlag;//反向处理标志

	//modify by fanrong 20110525 BMS-3016-plus end

	/**
	 * default constructor
	 */
	public BhBrMergeInfoVO() {
		super();
		this.id = "";
		this.tlrMrgFlg = BatchConstant.MERGEINFO_FLAG_UNPROCESSED;  //默认为未处理
		this.bsnMrgflg = BatchConstant.MERGEINFO_FLAG_UNPROCESSED;
		this.stsMrgFlg = BatchConstant.MERGEINFO_FLAG_UNPROCESSED;
		this.wrkFlwFlg = BatchConstant.MERGEINFO_FLAG_UNPROCESSED;
		this.validFlag = BatchConstant.MERGEINFO_FLAG_INVALIDATION; //默认设为无效

		this.timestamp = DateUtil.getTimestamp();
	}

	/**
	 * full constructor
	 */
	public BhBrMergeInfoVO(
		String  MergeDate,
		String BranchBrcode,
		String OldBrcode,
		String NewBrcode,
		String TlrMrgFlg,
		String BsnMrgFlg,
		String StsMrgFlg,
		String WrkMrgFlg,
		String CrdMrgFlg,
		String ValidFlag,
		String TimeStamp) {
			this.id = "";
			this.mergeDate = MergeDate;
			this.branchBrcode = BranchBrcode;
			this.oldBrcode = OldBrcode;
			this.newBrcode = NewBrcode;
			this.tlrMrgFlg = TlrMrgFlg;
			this.bsnMrgflg = BsnMrgFlg;
			this.stsMrgFlg = StsMrgFlg;
			this.wrkFlwFlg = WrkMrgFlg;
			this.validFlag = ValidFlag;
			this.timestamp = TimeStamp;
	}

	/**
	 * @return
	 */
	public String getBranchBrcode() {
		return branchBrcode;
	}

	/**
	 * @return
	 */
	public String getBsnMrgflg() {
		return bsnMrgflg;
	}



	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getMergeDate() {
		return mergeDate;
	}

	/**
	 * @return
	 */
	public String getNewBrcode() {
		return newBrcode;
	}

	/**
	 * @return
	 */
	public String getOldBrcode() {
		return oldBrcode;
	}

	/**
	 * @return
	 */
	public String getStsMrgFlg() {
		return stsMrgFlg;
	}

	/**
	 * @return
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @return
	 */
	public String getTlrMrgFlg() {
		return tlrMrgFlg;
	}

	/**
	 * @return
	 */
	public String getWrkFlwFlg() {
		return wrkFlwFlg;
	}

	/**
	 * @param string
	 */
	public void setBranchBrcode(String string) {
		branchBrcode = string;
	}

	/**
	 * @param string
	 */
	public void setBsnMrgflg(String string) {
		bsnMrgflg = string;
	}


	/**
	 * @param l
	 */
	public void setId(String l) {
		id = l;
	}

	/**
	 * @param date
	 */
	public void setMergeDate(String date) {
		mergeDate = date;
	}

	/**
	 * @param string
	 */
	public void setNewBrcode(String string) {
		newBrcode = string;
	}

	/**
	 * @param string
	 */
	public void setOldBrcode(String string) {
		oldBrcode = string;
	}

	/**
	 * @param string
	 */
	public void setStsMrgFlg(String string) {
		stsMrgFlg = string;
	}

	/**
	 * @param date
	 */
	public void setTimestamp(String date) {
		timestamp = date;
	}

	/**
	 * @param string
	 */
	public void setTlrMrgFlg(String string) {
		tlrMrgFlg = string;
	}

	/**
	 * @param string
	 */
	public void setWrkFlwFlg(String string) {
		wrkFlwFlg = string;
	}


	/**
	 * @return
	 */
	public String getValidFlag() {
		return validFlag;
	}

	/**
	 * @param string
	 */
	public void setValidFlag(String string) {
		validFlag = string;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getOldBrcodeName() {
		return oldBrcodeName;
	}

	public void setOldBrcodeName(String oldBrcodeName) {
		this.oldBrcodeName = oldBrcodeName;
	}

	public String getNewBrcodeName() {
		return newBrcodeName;
	}

	public void setNewBrcodeName(String newBrcodeName) {
		this.newBrcodeName = newBrcodeName;
	}

	public String getReverseFlag() {
		return reverseFlag;
	}

	public void setReverseFlag(String reverseFlag) {
		this.reverseFlag = reverseFlag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}