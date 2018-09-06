/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.mrn.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 合同VO
 *
 * @author mengjiajia
 *
 * @version Revision: 1.0 Date: 2012-7-12 下午2:14:47
 *
 */

public class OldContractVO {

	private java.lang.String contType;// 合同类型
	private java.lang.String billno;
	//同一个字段应该统一写法  保留billcode 去掉billCode
//	private java.lang.String billCode;
	private java.lang.String billcode;
	private java.lang.String exchangeName;
	private java.lang.String seatcd;
	private java.lang.String tradecd;
	private java.lang.String address;
	private java.lang.String postno;
	private java.lang.String warehouseId;
	private java.lang.String storageAddress;
	private java.lang.String phone;
	private java.lang.String fax;
	private java.lang.String standLose;
	private java.util.Date storageCostEndDate;
	private java.util.Date applyDate;
	private java.lang.String gallerycd;
	private java.lang.String galleryName;
	private java.lang.String pawneeName;
	private java.lang.String specialTradeCode;
	private java.lang.String futureCustcd;
	private java.util.Date billDueDate;
	private java.util.Date confirmDate;
	private java.lang.String piid;
	private java.lang.String appliType;
	private java.lang.String processTemplateName;
	private java.lang.String businessnoType;
	private java.lang.String businessno;
	private java.math.BigDecimal amt;
	private java.util.Date stratDate;
	private java.util.Date startTime;
	private java.lang.String appliStatus;
	private java.lang.String approveBrcode;
	private java.lang.String approver;
	private java.util.Date approveDate;
	private java.util.Date approveTime;
	private java.lang.String workflowAppno;

	private java.lang.String custClass;
	private java.lang.String creditCheckStatus;
	private java.lang.Integer creditRealId;
	private java.lang.String creditLineStatus;
	private java.math.BigDecimal creditLine;

	private java.math.BigDecimal totalAmount;// 总合同金额
	private java.lang.Integer numSum;// 总比数
	private java.math.BigDecimal totalFinAmount;// 总融资额
	private java.math.BigDecimal totalFinRemAmoun;// 总融资余额
	private java.math.BigDecimal creditAmt;
	private java.math.BigDecimal stockAmt;
	private java.math.BigDecimal riskAmt;
	// TblContBaseInfo fields
	private java.lang.String supplyChainPdId;
	private java.lang.String brcode;
	private java.lang.String curcd;
	private java.lang.String custcd;
	private java.lang.String backCustcd;
	private java.lang.String backCustName;
	private java.math.BigDecimal contAmount;// 合同金额
	private java.util.Date signDate;
	private String startDate;
	private java.util.Date dueDate;
	private java.lang.String financingType;
	private java.math.BigDecimal firstBailRatio;
	private java.lang.String assureType;
	private java.lang.String netMastId;
	private java.lang.String netSlaveId;
	private java.lang.String mastContStatus;
	private java.lang.String fivelevel;
	private java.lang.String description;
	private java.lang.Integer srvNetId;
	// tblconttradeinfo
	private java.lang.String tradeContno;// 贸易合同号数字 主键
	private java.lang.String tradeContcode; // 贸易合同号 字符
	private java.lang.String secCustcd; // 受益人客户号
	private java.lang.String secCname; // 受益人客户号
	private java.lang.String mortgageMesc;// 货物描述
	private java.lang.String countUnits; //单位
	private java.lang.String transportMode;// 运输模式
	private java.lang.String transportType;// 运输方式
	private java.lang.String checkMethod;// 检验方式
	private java.lang.String bank;// 买方账号
	private java.lang.String bankName;// 买方开户行
	private java.lang.String secBank;// 卖方账号
	private java.lang.String secBankName;// 卖方开户行
	private java.lang.String deliverGoodAddr;// 交货地点
	private java.util.Date deliverDate;// 交货日期
	private java.math.BigDecimal transportCost;
	// 广发特有属性
	private java.lang.String sfdsfcz;
	private java.lang.String supercontno;
	private java.lang.String mainassuretype;
	private java.util.Date effectivedate;
	private java.lang.Integer deadline;
	private java.util.Date zzfkr;
	private java.util.Date zzhkr;
	private java.util.Date jqrq;
	private java.math.BigDecimal ljyk;
	private java.math.BigDecimal ljhk;
	private java.lang.Integer ljhkbs;
	private java.math.BigDecimal yhbj;
	// private java.math.BigDecimal creditamt;
	private java.math.BigDecimal ljhslx;
	// private java.lang.String status;
	private java.math.BigDecimal bailamountration;
	// private java.math.BigDecimal riskamt;
	private java.lang.String lastupdoperid;
	private java.lang.String lastupdtime;
	private java.lang.String financingname;
	private java.lang.String czy;

	// TblLnciBaseInfo
	private java.lang.String debetId;
	private java.lang.String mastContno;
	private java.lang.String mastContCode;
	private java.lang.String lnciType;
	private java.lang.String lnciStatus;
	private java.math.BigDecimal lnciAmt; // 借据金额
	private java.math.BigDecimal lnciBal; // 借据余额
	// private java.lang.String fivelevel;

	private java.lang.String debetNo;
	private java.lang.String creditLoanFlag;
	private java.lang.String loanType;
	private java.lang.String loanUse;
	private java.lang.String interestType;
	private java.lang.String interestFlag;
	private java.lang.String interestMoreFlag;
	private java.lang.String dept;
	private java.lang.String mgno;
	private java.lang.String riskLevel;
	private java.lang.String baseRateType;
	private java.lang.String rateActiveFlag;
	private java.lang.String loanIndustryType;
	private java.lang.String loanIndustryType2;
	private java.lang.String loanIndustryType3;
	private java.lang.String loanIndustryType4;

	// TblContRepaymentInfo
	private java.lang.String id;
	// private java.lang.String debetId;
	private java.util.Date repaymentDate;
	private java.math.BigDecimal repayBalamt; // 还款金额
	private java.math.BigDecimal repayIntamt;

	// TblContInvoiceInfo
	private java.lang.String tradeContId;
	private java.lang.String invoiceType;
	private java.lang.String invoiceCode;
	private java.lang.String invoiceNo;
	private java.lang.String invoiceName;
	private java.math.BigDecimal invoiceAmount;
	private java.util.Date invoiceDate;
	private java.util.Date invoiceDueDate;
	private java.lang.String invoiceStartPos;
	private java.lang.String invoiceEndPos;
	private java.util.Date invoiceSendDate;
	private java.lang.String invoiceDesc;
	private java.lang.Integer invoiceNum;
	private java.math.BigDecimal invoicePrice;
	private java.math.BigDecimal invoiceTotalValue;
	// private java.lang.String description;

	// TblContMaterialInfo
	// private java.lang.Integer id;
	// private java.lang.String mastContno;
	private java.lang.String materialClassNo;
	private java.lang.Integer materialNum;
	private java.lang.String tlrcd;
	// private java.lang.String brcode;

	// TblContSlaveInfo
	private java.lang.String slaveContno;
	private java.lang.String slaveContcode;
	// private java.lang.String mastContno;
	private java.lang.String slaveContType;
	// private java.lang.String custcd;
	// private java.lang.String curcd;
	private java.math.BigDecimal slaveContAmt;
	private java.math.BigDecimal preAmt;
	// private java.util.Date signDate;
	// private java.util.Date startDate;
	private String endDate;
	// private java.lang.String description;
	private java.lang.String mortHoldDesc;
	private java.lang.String mortQualityDesc;
	private java.lang.String planMoniEnt;
	private java.util.Date planStorageDate;
	private java.math.BigDecimal credit;

	// TblContTradeInfo
	// private java.lang.String tradeContId;
	// private java.lang.String mastContno;
	private java.math.BigDecimal tradeContAmt;
	private java.lang.String buyName;
	private java.lang.String sellName;
	// private java.util.Date signDate;
	private java.lang.String loanDesc;
	private java.lang.String tradeDesc;
	// private java.lang.String description;

	// TblMutiProtBaseInfo
	private java.lang.String protocolNo;
	// private java.lang.String mastContno;
	private java.lang.String protocolType;
	// private java.util.Date signDate;
	// private java.util.Date startDate;
	// private java.util.Date endDate;
	// private java.lang.String curcd;
	private java.math.BigDecimal protAmt;
	private java.lang.String firName;
	private java.lang.String firAddress;
	private java.lang.String firLegal;
	private java.lang.String firActUbankno;
	private java.lang.String firActno;
	private java.lang.String firTel;
	private java.lang.String firRole;
	private java.lang.String secName;
	private java.lang.String secAddress;
	private java.lang.String secLegal;
	private java.lang.String secActUbankno;
	private java.lang.String secActno;
	private java.lang.String secTel;
	private java.lang.String secRole;
	private java.lang.String thrName;
	private java.lang.String thrAddress;
	private java.lang.String thrLegal;
	private java.lang.String thrActUbankno;
	private java.lang.String thrActno;
	private java.lang.String thrTel;
	private java.lang.String thrRole;
	private java.lang.String fouFirName;
	private java.lang.String fouAddress;
	private java.lang.String fouLegal;
	private java.lang.String fouActUbankno;
	private java.lang.String fouActno;
	private java.lang.String fouTel;
	private java.lang.String fouRole;
	private java.lang.String status;

	// TblMutiProtCmInfo
	// private java.lang.String protocolNo;
	private java.lang.String moniOfCustcd;
	private java.lang.String moniModel;
	private java.math.BigDecimal lowPrice;
	private java.math.BigDecimal lowPriceNew;
	private java.lang.String whetherOpen;
	private java.lang.String BuyerCustcd;
	private java.lang.String moniProtocolType;
	private java.lang.String isHighestLimit;
	private java.lang.String moniPriceModel;
	private java.lang.String moniMode;
	private java.lang.Integer deallineRate;
	// TblMutiProtCmPriceHis
	// private java.lang.Integer id;
	private java.lang.String mortgageNo;
	private java.util.Date txdate;
	// private java.math.BigDecimal lowPrice;
	private java.lang.String recordTlrcd;
	private java.lang.String recordBrcode;

	// TblCustBaseInfo
	private java.lang.String idtype;// 证件类型
	private java.lang.String idno; // 证件号
	private java.lang.String state;// 协议状态
	private java.lang.String moniCustName;//监管公司名称
	private java.lang.String dutyAssumeType;//责任承担方式
	private java.lang.Integer consignmentDays;//发货期限（天）
	private java.lang.String otherCustName;//其它参与方
	//
	private java.math.BigDecimal sumPrice;// 总价
	private java.lang.String appliStatusDtl;// 申请状态明细

	// TblCustBaseInfo
	// primary key
	// private java.lang.String custcd;

	// fields
	private java.lang.String custno;
	private java.lang.String cname;
	private java.lang.String ename;
	private java.lang.String aliasName;
	private java.lang.String orgCode;
	private java.lang.String licenseNo;
	private java.util.Date licenseDate;
	private java.lang.String lastUpdTlrcd;
	private java.util.Date lastUpdTime;
	private java.lang.String custType;
	// private java.lang.String idtype;
	// private java.lang.String idno;
	private java.util.Date openDate;
	private java.util.Date coreOpenDate;
	private java.lang.String custStatus;

	private String startBrcode; // 所属机构
	private String startTlrcd; // 客户经理

	private java.math.BigDecimal bailAmt; // 保证金余额
	private java.math.BigDecimal storTtlAmt; // 存货总价
	private java.math.BigDecimal stockPremiums; // 溢价
	private java.math.BigDecimal stockPremiumsRate; // 溢价比

	private java.lang.String mortgageModel;
	private java.lang.String mortgageClass;
	private java.math.BigDecimal useableAmount;
	private java.math.BigDecimal pricerateAmount;
	private java.math.BigDecimal userdAmount;
	private java.lang.String invoiceNumName;
	private java.lang.String sallerName;
	private java.lang.String sallerNo;
	private java.lang.String buyNo;
	private java.lang.String SECRET1;
	private java.lang.String SECRET2;

	// TblAppliPricedoenCompensate 跌价补偿申请表
	// private java.lang.String mastContno; //主合同号
	// private java.lang.String slaveContno; //从合同号
	// private java.lang.String custcd; //客户号
	// private java.util.Date startDate; //签订日期
	private java.util.Date appDate; // 录入日期
	private java.lang.String appTlrcd; // 录入人Code
	private java.lang.String appBrcode; // 录入机构Code
	// private java.lang.String description; //描述
	private java.lang.String appno; // 申请编号
	// private java.lang.String status; //状态 01已生效 00未生效
	private java.math.BigDecimal leavingContAmount; // (合同)融资余额
	// private java.math.BigDecimal contAmount; //合同金额
	private java.math.BigDecimal leavingBailAmount; // 保证金总额
	private java.math.BigDecimal mortgageAmount; // 存货总价
	private java.math.BigDecimal waitCompensateAmount;// 待补偿保证金金额
	private java.math.BigDecimal compensateAmount;// 补偿保证金金额

	// TblPricedoenCompensateInfo 跌价补偿信息表
	// private java.lang.String appno; //申请编号
	private java.lang.String appType; // 种类
	// private java.math.BigDecimal totalAmount; //总额
	private java.util.Date notifyDate; // 通知日期
	private java.lang.String notifyMan; // 通知人

	// TblPricedoenCompensateMort 补货明细表
	// private java.lang.String appno; //申请编号
	// private java.lang.String mortgageModel; //押品规格
	// private java.lang.String mortgageClass; //押品大类
	private java.lang.String mortgageSubClass; // 押品小类
	private java.math.BigDecimal quantity; // 数量
	private java.math.BigDecimal quantityAfter;
	private java.lang.String mortgageUnits; // 押品单位
	private java.math.BigDecimal price; // 价格

	// TblPricedoenCompensateBail 补保证金明细表
	// private java.lang.String appno; //申请编号
	private java.math.BigDecimal bailAmount; // 保证金金额
	private java.lang.String postCode; // 邮政编码
	private java.lang.String attnTel; // 经办人电话
	private java.lang.String bailAccount; // 保证金账户
	private java.lang.String otherprotocolNo;
	private java.lang.String firCd;
	private java.lang.String secCd;
	private java.lang.String thrCd;
	private java.lang.String fouCd;
	private java.lang.String fouName;//回购厂商
	private java.lang.String thrLegalDuties;
	private java.lang.String thrAttn;
	private java.lang.String signIn;
	private java.lang.String thrId;
	private java.lang.String thrLicense;
	private java.lang.String thrFax;
	private java.lang.String thrPostCode;
	private java.lang.String secAttnTel;
	private java.lang.String secAttn;
	private java.lang.String secFax;
	private java.lang.String secId;
	private java.lang.String secLicenseno;
	private java.lang.String secLegalDuties;
	private java.lang.String secPostCode;
	private java.lang.String firPostCode;
	private java.lang.String firFax;
	private java.lang.String firAttn;
	private java.lang.String firLegalDuties;
	private java.lang.String protocolCode;
	private java.lang.String secActCbankno;
	private java.lang.String secUactno;
	private java.lang.String secCactno;
	private java.lang.String thrActCbankno;
	private java.lang.String thrUactno;
	private java.lang.String thrCactno;
	private java.lang.String otherMessage;
	private java.lang.String logisticsMoniCondition;
	private java.lang.String warehousedress;
	private java.lang.String mortgagePayType;
	private java.lang.String specialWarehouseCondition;
	private java.lang.String thrWebsite;
	private java.lang.String thrFaxNumber;
	private java.lang.String thrMailbox;
	private java.lang.String costBear;
	private java.lang.String costStandard;
	private java.math.BigDecimal moniCost;
	private java.lang.String payWay;
	private java.lang.Integer payTime;
	private java.lang.String protectPriceType;
	private java.lang.Double protectPriceRation;
	private java.lang.String otherDes;

	/* 为了显示仓单市值管理静态数据做了几个假字段 author:Huaidong.Li */

	private java.lang.String warehouseReceiptId;// 仓单ID
	private java.lang.String goodsType;// 货物类型
	private java.lang.String brand;// 品牌
	private java.lang.String standard;// 规格
	private java.lang.String amount;// 数量
	private java.lang.String measure;// 计量单位
	private java.lang.String storagePrice;// 入库单价
	private java.lang.String maintainDate;// 维护日期
	private java.lang.String averagePrice;// 平均价格
	private java.lang.String fluctuation;// 波动率

	private java.lang.String warehousePara;// 仓单参数名
	private java.lang.String warehouseParavlaue;// 仓单参数值
	private java.lang.String currency;// 币种
	private java.lang.String date;// 日期
	private java.lang.String date1;// 日期，用于仓单管理的假数据
	// private java.lang.String measure;//

	// 押品正式表 add by saiyao.gao 2011-5-25
	private java.lang.String mortgageClassNo;
	private java.lang.String mortgageBizType;
	private java.lang.String monitorProtocolNo;
	private java.lang.String monitorProtocolCode;
	private java.lang.String otherProtocolNo;
	private java.lang.String firstAppno;
	private java.util.Date firstStorageDate;
	private java.math.BigDecimal originalPrice;
	private java.math.BigDecimal originalTotPrice;
	private java.math.BigDecimal totPrice;
	private java.lang.String stockStatus;
	private java.math.BigDecimal marketPrice;
	private java.math.BigDecimal confirmPrice;
	private java.lang.String manufacturer;
	private java.lang.String vender;
	private java.lang.String productArea;
	private java.lang.String incomeNo;
	private java.math.BigDecimal ration;
	private java.lang.String wrappage;
	private java.lang.String qualityLevel;
	private java.lang.String sn;
	private java.lang.String year;
	private java.lang.String billType;
	private java.lang.String weightAll;
	private java.math.BigDecimal upDownMoney;
	private java.lang.String upDownMoneyFlag;
	private java.lang.String mortgageLevelOne;
	private java.lang.String mortgageLevelTwo;
	private java.lang.String mortgageLevelThree;
	private java.lang.String mortgageLevelFour;
	private java.lang.String mortgageLevelFive;
	private java.lang.String mortgageLevelSix;
	private java.math.BigDecimal billQuantity;
	private java.lang.String warehouseAddress;
	private java.lang.String registrationNum;
	private java.lang.String storDeliBizType;
	private java.lang.String storOrDeli;
	private java.lang.String warnLine;
	private java.lang.String saleLine;
	private java.lang.String freightarea;
	private java.lang.String freightlot;
	private java.lang.String warehouse;

	private java.lang.String disputeResolventType;
	private java.lang.String bailaccount;
	private java.math.BigDecimal priceMaxDecline;
	private java.lang.Integer offsetDeadline;
	private java.lang.Integer breachDeadline;
	private java.lang.String isexchange;
	private java.lang.String insure;
	private java.lang.String slaveCurcd;

	private java.lang.String tlrn; // 通知人
	private java.lang.String noticeType;
	private java.lang.String slaveType;
	private java.util.Date appliDate;
	private java.lang.Integer pid;
	private java.lang.String protectPrice;
	private java.math.BigDecimal bailAmountSum;

	private java.math.BigDecimal totalPrice;
	private java.math.BigDecimal balance;
	private java.lang.String pledgeMode;

	private java.lang.String insuranceFlag;
	private java.lang.String insuranceNo;
	private java.lang.String insuranceBuyer;
	private java.lang.String insuranceBenefiter;
	private java.math.BigDecimal insuranceAmt;
	private java.util.Date insuranceStartDate;
	private java.util.Date insuranceEndDate;

	private java.lang.String warehouseType;
	private java.util.Date warehouseHireEndDate;
	private java.util.Date warehouseHireStartDate;
	private java.lang.String warehouseHireProtocol;
	private java.lang.String moniName;
	private java.lang.String moniTel;

	private java.lang.String mortgageName;
	private java.lang.String ext1;
	private java.lang.String ext2;
	private java.lang.String ext3;

	private java.lang.String moniWarehouseType;
	private java.lang.String moniAreaType;
	private java.lang.String totlePriceSum;
	private java.lang.String updateState;
	private java.util.Date updateDate;
	private java.math.BigDecimal realAmount;

	/** add by mingzhao.lan 2011-7-20 */
	private java.lang.Integer handInDate;
	private java.lang.String receiveName;
	private java.lang.String stopReason;
	private java.lang.String reasonType;
	private java.lang.String conventionNo;
	private java.lang.String faultA;
	private java.lang.String faultB;

	/** 浦发主合同新增 ADD BY ruyi.wang 2011-09-14 */
	private java.lang.String serialno;
	private java.lang.String relativeserialno;
	private java.lang.String occurdate;
	private java.lang.String customerid;
	private java.lang.String customername;
	private java.lang.String occurtype;
	private java.lang.String businesstype;
	private java.lang.String putoutorgid;
	private java.lang.String businesstypename;
	private java.lang.String artificialno;
	private java.lang.String actualartificialno;
	private java.lang.String putoutorgname;
	private java.lang.String accountNo;
	private java.lang.String loanaccountno;
	private java.lang.String secondpayaccount;
	private java.lang.String fundsource;
	private java.lang.String businesscurrency;
	private java.math.BigDecimal businesssum;
	private java.lang.String purpose;
	private java.lang.String direction;
	private java.lang.String directionname;
	private java.lang.String riskattribute;
	private java.math.BigDecimal termmonth;
	private java.math.BigDecimal termday;
	private java.math.BigDecimal businessrate;
	private java.lang.String ratefloattype;
	private java.math.BigDecimal ratefloat;
	private java.lang.String adjustratetype;
	private java.lang.String adjustrateterm;
	private java.lang.String iccyc;
	private java.math.BigDecimal fixcyc;
	private java.lang.String rateadjustcyc;
	private java.lang.String overinttype;
	private java.lang.String drawingtype;
	private java.lang.String originalputoutdate;
	private java.lang.String corpuspaymethod;
	private java.lang.String contextinfo;
	private java.lang.String paysource;
	private java.lang.String vouchtype;
	private java.lang.String vouchtypename;
	private java.lang.String vouchflag;
	private java.lang.String assureClass;
	private java.lang.String lowrisk;
	private java.math.BigDecimal riskrate;
	private java.lang.String otherarealoan;
	private java.lang.String guarantyno;
	private java.lang.String putoutdate;
	private java.lang.String maturity;
	private java.lang.String classifyresult;
	private java.lang.String classifydate;
	private java.lang.String othercondition;
	// private java.math.BigDecimal balance;
	private java.math.BigDecimal normalbalance;
	private java.math.BigDecimal overduebalance;
	private java.math.BigDecimal dullbalance;
	private java.math.BigDecimal badbalance;
	private java.math.BigDecimal overduedays;
	private java.lang.String finishtype;
	private java.lang.String finishdate;
	private java.math.BigDecimal classifyfrequency;
	private java.lang.String approveopinion;
	private java.lang.String approveuserid;
	private java.lang.String approveusername;
	private java.lang.String remark;
	private java.math.BigDecimal classifysum1;
	private java.math.BigDecimal classifysum2;
	private java.math.BigDecimal classifysum3;
	private java.math.BigDecimal classifysum4;
	private java.math.BigDecimal classifysum5;
	private java.lang.String manageuserid;
	private java.lang.String manageusername;
	private java.lang.String manageorgid;
	private java.lang.String manageorgname;
	private java.lang.String statorgid;
	private java.lang.String statorgname;
	private java.lang.String recoveryuserid;
	private java.lang.String recoveryusername;
	private java.lang.String recoveryorgid;
	private java.lang.String recoveryorgname;
	private java.lang.String operateuserid;
	private java.lang.String operateusername;
	private java.lang.String operateorgid;
	private java.lang.String operateorgname;
	private java.lang.String inputuserid;
	private java.lang.String inputusername;
	private java.lang.String inputorgid;
	private java.lang.String inputorgname;
	private java.lang.String inputdate;
	private java.lang.String updatedate;
	private java.lang.String pigeonholedate;
	private java.lang.String tempsaveflag;
	private java.math.BigDecimal cancelsum;
	private java.math.BigDecimal cancelinterest;

	// TblContractIssue
	private java.lang.String salveContno;
//	private java.lang.String slaveContno;
	private java.lang.String handleReason;
	private java.lang.String otherReason;
	private java.util.Date handleDate;
	private java.lang.String handleType;
	private java.lang.String memo;
	private java.lang.String type;

	// TblMortgageStorDeliInfo
	private java.util.Date txtime;
	private java.lang.Integer mortgageBizNo;
	// private java.lang.String bussType;
	private java.math.BigDecimal creditamt;
	private java.math.BigDecimal stockamt;
	private java.math.BigDecimal riskamt;
	private java.lang.String weightUnits;
	/*****************************************************/

	// TblBusinessProductDetail
	private java.lang.String productId;
	private java.lang.String parentId;// 父类
	private java.lang.String factType; // 保理业务类别
	private java.lang.Integer graceDays;// 融资最大宽限期(天)
	private java.lang.String rateShareType; // 利息摊提
	private java.lang.String bussTypeName;// 业务品种名称
	private java.lang.String calcRateType;// 计息方式
	private java.lang.String recoverType; // 业务类型
	private java.lang.String inout;// 境内/境外
	private java.lang.Integer debtGraceDays;//
	private java.math.BigDecimal protLowPric;// 最低价值
	private java.math.BigDecimal overDueAmount;// 逾期金额、
	// 融资手续费减免项
	private java.math.BigDecimal totalReduce;// 减免费用
	private java.math.BigDecimal receiveAmount;// 实收费用小计

	private java.lang.String phase;// 订单融资当前状态
	private java.lang.String ophase;// 订单融资目标状态
	private java.math.BigDecimal firPercent;// 订单阶段融资比例
	private java.math.BigDecimal secPercent;// 收货阶段融资比例
	private java.math.BigDecimal thrPercent;// 发票阶段融资比例
	private java.lang.String custcdBuyer;// 订单融资合同买方
	private java.lang.String custcdSeller;// 订单融资合同卖方

	//add by zhang_shishu 2012-11-24 保理
	private java.lang.String sellerType;
	private java.lang.String buyerType;
	private java.lang.String billsType;
	private String moniModeInside;
	private String moniModeThird;
	private String moniModeOwn;
	private String controlType;
	private String moniFlag;

	// TblContOrderBaseInfo
	private java.math.BigDecimal loanAmount;// 订单融资【融资金额】
	private java.math.BigDecimal loanRemainingAmount;// 订单融资【融资余额】
	private java.math.BigDecimal remainingUseableAmount;// 订单融资【可用融资余额】
	private java.math.BigDecimal rateCollectAmount;// 订单融资【应收利息总额】
	private java.math.BigDecimal ownRateCollectAmount;// 订单融资【欠利息总额】
	private java.util.Date loanEndDate;// 订单融资【融资到期日】
	private java.math.BigDecimal confirmAmount;// 确认金额
	private java.math.BigDecimal realLoanAmount;//实际tbllncibaseinfo中合同下金额
	//订单融资 还款
	private java.math.BigDecimal returnAmount;
	private java.math.BigDecimal returnCapitalAmount;
	private java.math.BigDecimal toSallerAmount;
	private java.math.BigDecimal toPoolAmount;
	private java.math.BigDecimal balanceBueAmount;
	// add by xu_hong 2012-6-26 订单融资订单信息 start
	private java.lang.String orderType;// 单据类型
	private java.lang.String orderNo;// 订单编号
	private java.util.Date orderDate;// 订单日期
	private java.util.Date issuingDate;// 发货日期
	private java.math.BigDecimal orderAmount;// 订单金额
	private java.lang.String intCode;
	private java.math.BigDecimal fixedIntrate;
	// add by xu_hong 2012-6-26 订单融资订单信息 end
	private java.lang.String procName;
	private java.lang.String actno;
	private java.lang.String bailActno;
	private java.lang.String actBankno;
	private java.lang.String tlrno;
	private java.lang.String coreNm;
	private java.lang.String sellerNm;
	private java.lang.String moniNm;
	// 承兑合同扩展表
	private java.lang.String draftCustcd;
	private java.lang.String draftAccountno;

	private String lcCustcd;// 信用证合同受益人客户号
	private java.lang.String creditno;// 授信额度编号

	// add by xu_hong 2012-8-8 借款合同信息 start
	private java.lang.String rtnDate;// 还款日
	private java.lang.String mainAssureType;// 主担保方式
	private java.math.BigDecimal pintrate;// 罚息利率比率
	private java.math.BigDecimal mispPintrate;// 挪用罚息比率
	// add by xu_hong 2012-8-8 借款合同信息 end

	private java.math.BigDecimal refundAmount;
	private java.math.BigDecimal totalRemainAmount;
	private java.math.BigDecimal totalRateAmount;
	private java.math.BigDecimal totalRateRemainAmount;
	private java.math.BigDecimal returnRateAmount;
	private java.util.Date insertDate;
	private java.lang.String loanOverdueFlag;
	private java.math.BigDecimal openAmount;//敞口金额

	private String customerBrcode;// 出票人开户银行行号
	private java.math.BigDecimal addAmount;
	private java.lang.String subContno;

	//保险
	private java.lang.String insuranceCode;//保险名称
	private java.lang.String insuranceType;//保险类型
	private java.lang.String beneficiary;//受益人

	private java.lang.String bailAccountno;
	private java.math.BigDecimal bailRate;
	private java.lang.String bailType;
	private java.lang.String initType;
	private java.lang.Boolean select;
	private java.math.BigDecimal removeAmount;
	private java.util.Date lastUpdateDate;

	private java.math.BigDecimal billsAmountView;
	private java.util.Date loanDate;
	private java.math.BigDecimal value;
	private java.lang.String accountType;//解压类型

	private java.lang.String confirmStatus;
	private String accountName;//账号名称
	private java.math.BigDecimal payAmount;
	private java.math.BigDecimal npsBailAmount;//核心保证金金额余额

	private java.lang.String loansFlag;//流动资金贷款
	private java.lang.String acceptanceFlag;
	private java.lang.String guaranteeLetterFlag;
	private java.lang.String creditrLetterFlag;
	private java.lang.String commercialDiscountFlag;

	private java.lang.String mortBillAccountNo;//质押存单账号
	private java.math.BigDecimal mortBillAmount;//质押存单金额
	private java.lang.String arrivedManageMode;//质押监管模式

	private java.lang.String autoLoan;//是否允许出账

	private java.lang.String productName;//产品名称

	private java.lang.String leaseFactoringFlag;//是否租赁保理
	private java.lang.String leasebackFlag;//是否售后回租
	private java.lang.String warnLevel;//预警等级

	private java.lang.String returnAccount;//回款帐号

	//民生特有属性

	//TblMutiProtBaseInfo关于阶段性回购添加字段
	private java.lang.String isAuthorizeSell;//是否签订委托变卖协议 1,签订;0,不签订
	private java.lang.String isInsurance;//是否购买保险 1,无需购买保险;2,购买综合保险;3,按单笔出账购买保险
	private java.lang.String mortgageManageMode;//押品对应方式 :1,一一对应;2,总量对应
	private java.lang.String condignee;//收货人
	private java.lang.String trasportationMode;//货物运输方式
	private java.lang.String deliveryPoints;//货物交付地点
	private java.lang.String destination;//目的港/站/地
	private java.lang.String deliveryTerm;//货物交付期限（天）
	private java.lang.String coreCustDuty;//上游厂商责任 33,保证发货;32,阶段性回购
	private java.util.Date arrivalDate;//到货日期
	private java.lang.String triConventions;//三方其他约定
	private java.math.BigDecimal totAmount;
	private java.lang.String sellerRegAddr;
	private java.lang.String sellerContactName;
	private java.lang.String coreRegAddr;
	private java.lang.String coreContactName;
	private java.lang.String takeMode;
	private java.lang.String goodsNm;
	private java.lang.String attn;
	//TblInsuranceBaseInfo保险信息表添加字段
	private java.lang.String insuranceAccountNo;//赔款账号
	private java.math.BigDecimal insuranceAmount;//保险金额

	/*csh*/
	private java.lang.String repayMode;//还款方式
	private java.lang.String transferMode;//通知方式
	private java.lang.String orderRepayDate;//提前还款天数
	private java.lang.String serviceType;//服务内容
	private java.lang.String paymentMode;//回款方式
	private java.math.BigDecimal totAmt;//累计出账金额
	private java.math.BigDecimal currOutAmt;//本次出账金额
	private java.lang.String flag;

	private java.lang.String sellOffFlag;//是否签订委托变卖协议
	private java.math.BigDecimal priceDropRate;//价格跌幅预警（%）


	private java.math.BigDecimal totQuantity;
	private java.lang.String checkLowPriceType;

	private java.lang.String refundAccount;//退款账号

	private java.math.BigDecimal currentCreditAmt;

	public java.math.BigDecimal getCurrentCreditAmt() {
		return currentCreditAmt;
	}
	public void setCurrentCreditAmt(java.math.BigDecimal currentCreditAmt) {
		this.currentCreditAmt = currentCreditAmt;
	}
	/**
	 * @return the repayMode
	 */
	public java.lang.String getRepayMode() {
		return repayMode;
	}
	/**
	 * @param repayMode the repayMode to set
	 */
	public void setRepayMode(java.lang.String repayMode) {
		this.repayMode = repayMode;
	}
	/**
	 * @return the transferMode
	 */
	public java.lang.String getTransferMode() {
		return transferMode;
	}
	/**
	 * @param transferMode the transferMode to set
	 */
	public void setTransferMode(java.lang.String transferMode) {
		this.transferMode = transferMode;
	}
	/**
	 * @return the orderRepayDate
	 */
	public java.lang.String getOrderRepayDate() {
		return orderRepayDate;
	}
	/**
	 * @param orderRepayDate the orderRepayDate to set
	 */
	public void setOrderRepayDate(java.lang.String orderRepayDate) {
		this.orderRepayDate = orderRepayDate;
	}
	/**
	 * @return the serviceType
	 */
	public java.lang.String getServiceType() {
		return serviceType;
	}
	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(java.lang.String serviceType) {
		this.serviceType = serviceType;
	}
	/**
	 * @return the paymentMode
	 */
	public java.lang.String getPaymentMode() {
		return paymentMode;
	}
	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(java.lang.String paymentMode) {
		this.paymentMode = paymentMode;
	}
	/*csh*/
	public java.lang.String getProductName() {
		return productName;
	}
	public void setProductName(java.lang.String productName) {
		this.productName = productName;
	}
	public java.lang.String getArrivedManageMode() {
		return arrivedManageMode;
	}
	public void setArrivedManageMode(java.lang.String arrivedManageMode) {
		this.arrivedManageMode = arrivedManageMode;
	}
	public void setLoansFlag(java.lang.String loansFlag) {
		this.loansFlag = loansFlag;
	}
	public java.lang.String getLoansFlag() {
		return loansFlag;
	}
	public java.lang.String getAcceptanceFlag() {
		return acceptanceFlag;
	}

	public void setAcceptanceFlag(java.lang.String acceptanceFlag) {
		this.acceptanceFlag = acceptanceFlag;
	}

	public String getControlType() {
		return controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public String getMoniFlag() {
		return moniFlag;
	}

	public void setMoniFlag(String moniFlag) {
		this.moniFlag = moniFlag;
	}

	public String getMoniModeInside() {
		return moniModeInside;
	}

	public void setMoniModeInside(String moniModeInside) {
		this.moniModeInside = moniModeInside;
	}

	public String getMoniModeThird() {
		return moniModeThird;
	}

	public void setMoniModeThird(String moniModeThird) {
		this.moniModeThird = moniModeThird;
	}

	public String getMoniModeOwn() {
		return moniModeOwn;
	}

	public void setMoniModeOwn(String moniModeOwn) {
		this.moniModeOwn = moniModeOwn;
	}

	public java.lang.String getSellerType() {
		return sellerType;
	}

	public void setSellerType(java.lang.String sellerType) {
		this.sellerType = sellerType;
	}

	public java.lang.String getBuyerType() {
		return buyerType;
	}

	public void setBuyerType(java.lang.String buyerType) {
		this.buyerType = buyerType;
	}

	public java.lang.String getBillsType() {
		return billsType;
	}

	public void setBillsType(java.lang.String billsType) {
		this.billsType = billsType;
	}

	public java.lang.String getGuaranteeLetterFlag() {
		return guaranteeLetterFlag;
	}

	public void setGuaranteeLetterFlag(java.lang.String guaranteeLetterFlag) {
		this.guaranteeLetterFlag = guaranteeLetterFlag;
	}

	public java.lang.String getCreditrLetterFlag() {
		return creditrLetterFlag;
	}

	public void setCreditrLetterFlag(java.lang.String creditrLetterFlag) {
		this.creditrLetterFlag = creditrLetterFlag;
	}

	public java.lang.String getCommercialDiscountFlag() {
		return commercialDiscountFlag;
	}

	public void setCommercialDiscountFlag(java.lang.String commercialDiscountFlag) {
		this.commercialDiscountFlag = commercialDiscountFlag;
	}
	public java.lang.String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(java.lang.String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public java.util.Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(java.util.Date loanDate) {
		this.loanDate = loanDate;
	}

	public java.util.Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(java.util.Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public java.math.BigDecimal getBailRate() {
		return bailRate;
	}

	public void setBailRate(java.math.BigDecimal bailRate) {
		this.bailRate = bailRate;
	}

	public java.lang.String getBailType() {
		return bailType;
	}

	public void setBailType(java.lang.String bailType) {
		this.bailType = bailType;
	}

	public OldContractVO() {
	}

	public OldContractVO(BigDecimal totPrice) {
		this.totPrice = totPrice;
	}

	public OldContractVO(String mastContno, String slaveContno, String protocolNo,
			String moniOfCustcd, BigDecimal lowPriceNew, BigDecimal totPrice,
			Date signDate) {
		this.mastContno = mastContno;
		this.slaveContno = slaveContno;
		this.protocolNo = protocolNo;
		this.moniOfCustcd = moniOfCustcd;
		this.lowPriceNew = lowPriceNew;
		this.totPrice = totPrice;
		this.signDate = signDate;

	}
//	private TblMutiProtBaseInfo tblmutiProtBaseInfo;
//	private TblMutiProtDealInfo tblMutiProtDealInfo;
//	public TblMutiProtBaseInfo getTblmutiProtBaseInfo() {
//		return tblmutiProtBaseInfo;
//	}
//	public void setTblmutiProtBaseInfo(TblMutiProtBaseInfo tblmutiProtBaseInfo) {
//		this.tblmutiProtBaseInfo = tblmutiProtBaseInfo;
//	}
//	public TblMutiProtDealInfo getTblMutiProtDealInfo() {
//		return tblMutiProtDealInfo;
//	}
//	public void setTblMutiProtDealInfo(TblMutiProtDealInfo tblMutiProtDealInfo) {
//		this.tblMutiProtDealInfo = tblMutiProtDealInfo;
//	}
//	public OldContractVO(String custcd, String balanceAccount, String bailAccount,String sellerRegAddr,
//			String sellerContactName, String coreCustcd,String coreAccount,String coreRegAddr,
//			String coreContactName,String fouCd,String refundAccount,TblMutiProtBaseInfo tblmutiProtBaseInfo,TblMutiProtDealInfo tblMutiProtDealInfo) {
//		this.custcd = custcd;
//		this.balanceAccount =balanceAccount ;
//		this.bailAccount =bailAccount ;
//		this.sellerRegAddr = sellerRegAddr ;
//		this.sellerContactName = sellerContactName;
//		this.coreCustcd =coreCustcd ;
//		this.coreAccount =coreAccount ;
//		this.coreRegAddr =coreRegAddr ;
//		this.coreContactName =coreContactName ;
//		this.fouCd =fouCd ;
//		this.refundAccount = refundAccount;
//		this.tblmutiProtBaseInfo = tblmutiProtBaseInfo;
//		this.tblMutiProtDealInfo = tblMutiProtDealInfo;
//	}

//	public OldContractVO(BigDecimal totPrice, String mastContno,
//			String slaveContno, String custcd, Date signDate,
//			BigDecimal slaveContAmt) {
//		this.totPrice = totPrice;
//		this.mastContno = mastContno;
//		this.slaveContno = slaveContno;
//		this.custcd = custcd;
//		this.signDate = signDate;
//		this.slaveContAmt = slaveContAmt;
//	}

//	public OldContractVO(String mastContno, String slaveContno, String protocolNo,
//			BigDecimal lowPriceNew, BigDecimal totPrice, Date signDate) {
//		this.mastContno = mastContno;
//		this.slaveContno = slaveContno;
//		this.protocolNo = protocolNo;
//		this.lowPriceNew = lowPriceNew;
//		this.totPrice = totPrice;
//		this.signDate = signDate;
//
//	}

	public java.lang.String getDate1() {
		return date1;
	}

	public void setDate1(java.lang.String date1) {
		this.date1 = date1;
	}

	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}

	public java.math.BigDecimal getUseableAmount() {
		return useableAmount;
	}

	public void setUseableAmount(java.math.BigDecimal useableAmount) {
		this.useableAmount = useableAmount;
	}

	public java.math.BigDecimal getPricerateAmount() {
		return pricerateAmount;
	}

	public void setPricerateAmount(java.math.BigDecimal pricerateAmount) {
		this.pricerateAmount = pricerateAmount;
	}

	public java.math.BigDecimal getUserdAmount() {
		return userdAmount;
	}

	public void setUserdAmount(java.math.BigDecimal userdAmount) {
		this.userdAmount = userdAmount;
	}

	public java.lang.String getInvoiceNumName() {
		return invoiceNumName;
	}

	public void setInvoiceNumName(java.lang.String invoiceNumName) {
		this.invoiceNumName = invoiceNumName;
	}

	public java.lang.String getSallerName() {
		return sallerName;
	}

	public void setSallerName(java.lang.String sallerName) {
		this.sallerName = sallerName;
	}

	public java.lang.String getSallerNo() {
		return sallerNo;
	}

	public void setSallerNo(java.lang.String sallerNo) {
		this.sallerNo = sallerNo;
	}

	public java.lang.String getBuyNo() {
		return buyNo;
	}

	public void setBuyNo(java.lang.String buyNo) {
		this.buyNo = buyNo;
	}

	public java.lang.String getSECRET1() {
		return SECRET1;
	}

	public void setSECRET1(java.lang.String secret1) {
		SECRET1 = secret1;
	}

	public java.lang.String getSECRET2() {
		return SECRET2;
	}

	public void setSECRET2(java.lang.String secret2) {
		SECRET2 = secret2;
	}

	/**
	 * @return the appliStatusDtl
	 */
	public java.lang.String getAppliStatusDtl() {
		return appliStatusDtl;
	}

	/**
	 * @param appliStatusDtl
	 *            the appliStatusDtl to set
	 */
	public void setAppliStatusDtl(java.lang.String appliStatusDtl) {
		this.appliStatusDtl = appliStatusDtl;
	}

	/**
	 * @return the sumPrice
	 */
	public java.math.BigDecimal getSumPrice() {
		return sumPrice;
	}

	/**
	 * @param sumPrice
	 *            the sumPrice to set
	 */
	public void setSumPrice(java.math.BigDecimal sumPrice) {
		this.sumPrice = sumPrice;
	}

	/**
	 * @return the idtype
	 */
	public java.lang.String getIdtype() {
		return idtype;
	}

	/**
	 * @param idtype
	 *            the idtype to set
	 */
	public void setIdtype(java.lang.String idtype) {
		this.idtype = idtype;
	}

	/**
	 * @return the idno
	 */
	public java.lang.String getIdno() {
		return idno;
	}

	/**
	 * @param idno
	 *            the idno to set
	 */
	public void setIdno(java.lang.String idno) {
		this.idno = idno;
	}

	public java.lang.String getTradeContId() {
		return tradeContId;
	}

	public void setTradeContId(java.lang.String tradeContId) {
		this.tradeContId = tradeContId;
	}

	public java.lang.String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(java.lang.String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public java.lang.String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(java.lang.String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public java.lang.String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(java.lang.String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public java.lang.String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(java.lang.String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(java.math.BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public java.util.Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(java.util.Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public java.util.Date getInvoiceDueDate() {
		return invoiceDueDate;
	}

	public void setInvoiceDueDate(java.util.Date invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
	}

	public java.lang.String getInvoiceStartPos() {
		return invoiceStartPos;
	}

	public void setInvoiceStartPos(java.lang.String invoiceStartPos) {
		this.invoiceStartPos = invoiceStartPos;
	}

	public java.lang.String getInvoiceEndPos() {
		return invoiceEndPos;
	}

	public void setInvoiceEndPos(java.lang.String invoiceEndPos) {
		this.invoiceEndPos = invoiceEndPos;
	}

	public java.util.Date getInvoiceSendDate() {
		return invoiceSendDate;
	}

	public void setInvoiceSendDate(java.util.Date invoiceSendDate) {
		this.invoiceSendDate = invoiceSendDate;
	}

	public java.lang.String getInvoiceDesc() {
		return invoiceDesc;
	}

	public void setInvoiceDesc(java.lang.String invoiceDesc) {
		this.invoiceDesc = invoiceDesc;
	}

	public java.lang.Integer getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(java.lang.Integer invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public java.math.BigDecimal getInvoicePrice() {
		return invoicePrice;
	}

	public void setInvoicePrice(java.math.BigDecimal invoicePrice) {
		this.invoicePrice = invoicePrice;
	}

	public java.math.BigDecimal getInvoiceTotalValue() {
		return invoiceTotalValue;
	}

	public void setInvoiceTotalValue(java.math.BigDecimal invoiceTotalValue) {
		this.invoiceTotalValue = invoiceTotalValue;
	}

	public java.lang.String getMaterialClassNo() {
		return materialClassNo;
	}

	public void setMaterialClassNo(java.lang.String materialClassNo) {
		this.materialClassNo = materialClassNo;
	}

	public java.lang.Integer getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(java.lang.Integer materialNum) {
		this.materialNum = materialNum;
	}

	public java.lang.String getTlrcd() {
		return tlrcd;
	}

	public void setTlrcd(java.lang.String tlrcd) {
		this.tlrcd = tlrcd;
	}

	public java.lang.String getSlaveContno() {
		return slaveContno;
	}

	public void setSlaveContno(java.lang.String slaveContno) {
		this.slaveContno = slaveContno;
	}

	public java.lang.String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(java.lang.String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public java.lang.String getSlaveContType() {
		return slaveContType;
	}

	public void setSlaveContType(java.lang.String slaveContType) {
		this.slaveContType = slaveContType;
	}

	public java.math.BigDecimal getSlaveContAmt() {
		return slaveContAmt;
	}

	public void setSlaveContAmt(java.math.BigDecimal slaveContAmt) {
		this.slaveContAmt = slaveContAmt;
	}

	public java.math.BigDecimal getPreAmt() {
		return preAmt;
	}

	public void setPreAmt(java.math.BigDecimal preAmt) {
		this.preAmt = preAmt;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public java.lang.String getMortHoldDesc() {
		return mortHoldDesc;
	}

	public void setMortHoldDesc(java.lang.String mortHoldDesc) {
		this.mortHoldDesc = mortHoldDesc;
	}

	public java.lang.String getMortQualityDesc() {
		return mortQualityDesc;
	}

	public void setMortQualityDesc(java.lang.String mortQualityDesc) {
		this.mortQualityDesc = mortQualityDesc;
	}

	public java.lang.String getPlanMoniEnt() {
		return planMoniEnt;
	}

	public void setPlanMoniEnt(java.lang.String planMoniEnt) {
		this.planMoniEnt = planMoniEnt;
	}

	public java.util.Date getPlanStorageDate() {
		return planStorageDate;
	}

	public void setPlanStorageDate(java.util.Date planStorageDate) {
		this.planStorageDate = planStorageDate;
	}

	public java.math.BigDecimal getTradeContAmt() {
		return tradeContAmt;
	}

	public void setTradeContAmt(java.math.BigDecimal tradeContAmt) {
		this.tradeContAmt = tradeContAmt;
	}

	public java.lang.String getBuyName() {
		return buyName;
	}

	public void setBuyName(java.lang.String buyName) {
		this.buyName = buyName;
	}

	public java.lang.String getSellName() {
		return sellName;
	}

	public void setSellName(java.lang.String sellName) {
		this.sellName = sellName;
	}

	public java.lang.String getLoanDesc() {
		return loanDesc;
	}

	public void setLoanDesc(java.lang.String loanDesc) {
		this.loanDesc = loanDesc;
	}

	public java.lang.String getTradeDesc() {
		return tradeDesc;
	}

	public void setTradeDesc(java.lang.String tradeDesc) {
		this.tradeDesc = tradeDesc;
	}

	public java.lang.String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(java.lang.String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public java.lang.String getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(java.lang.String protocolType) {
		this.protocolType = protocolType;
	}

	public java.math.BigDecimal getProtAmt() {
		return protAmt;
	}

	public void setProtAmt(java.math.BigDecimal protAmt) {
		this.protAmt = protAmt;
	}

	public java.lang.String getFirName() {
		return firName;
	}

	public void setFirName(java.lang.String firName) {
		this.firName = firName;
	}

	public java.lang.String getFirAddress() {
		return firAddress;
	}

	public void setFirAddress(java.lang.String firAddress) {
		this.firAddress = firAddress;
	}

	public java.lang.String getFirLegal() {
		return firLegal;
	}

	public void setFirLegal(java.lang.String firLegal) {
		this.firLegal = firLegal;
	}

	public java.lang.String getFirActUbankno() {
		return firActUbankno;
	}

	public void setFirActUbankno(java.lang.String firActUbankno) {
		this.firActUbankno = firActUbankno;
	}

	public java.lang.String getFirActno() {
		return firActno;
	}

	public void setFirActno(java.lang.String firActno) {
		this.firActno = firActno;
	}

	public java.lang.String getFirTel() {
		return firTel;
	}

	public void setFirTel(java.lang.String firTel) {
		this.firTel = firTel;
	}

	public java.lang.String getFirRole() {
		return firRole;
	}

	public void setFirRole(java.lang.String firRole) {
		this.firRole = firRole;
	}

	public java.lang.String getSecName() {
		return secName;
	}

	public void setSecName(java.lang.String secName) {
		this.secName = secName;
	}

	public java.lang.String getSecAddress() {
		return secAddress;
	}

	public void setSecAddress(java.lang.String secAddress) {
		this.secAddress = secAddress;
	}

	public java.lang.String getSecLegal() {
		return secLegal;
	}

	public void setSecLegal(java.lang.String secLegal) {
		this.secLegal = secLegal;
	}

	public java.lang.String getSecActUbankno() {
		return secActUbankno;
	}

	public void setSecActUbankno(java.lang.String secActUbankno) {
		this.secActUbankno = secActUbankno;
	}

	public java.lang.String getSecActno() {
		return secActno;
	}

	public void setSecActno(java.lang.String secActno) {
		this.secActno = secActno;
	}

	public java.lang.String getSecTel() {
		return secTel;
	}

	public void setSecTel(java.lang.String secTel) {
		this.secTel = secTel;
	}

	public java.lang.String getSecRole() {
		return secRole;
	}

	public void setSecRole(java.lang.String secRole) {
		this.secRole = secRole;
	}

	public java.lang.String getThrName() {
		return thrName;
	}

	public void setThrName(java.lang.String thrName) {
		this.thrName = thrName;
	}

	public java.lang.String getThrAddress() {
		return thrAddress;
	}

	public void setThrAddress(java.lang.String thrAddress) {
		this.thrAddress = thrAddress;
	}

	public java.lang.String getThrLegal() {
		return thrLegal;
	}

	public void setThrLegal(java.lang.String thrLegal) {
		this.thrLegal = thrLegal;
	}

	public java.lang.String getThrActUbankno() {
		return thrActUbankno;
	}

	public void setThrActUbankno(java.lang.String thrActUbankno) {
		this.thrActUbankno = thrActUbankno;
	}

	public java.lang.String getThrActno() {
		return thrActno;
	}

	public void setThrActno(java.lang.String thrActno) {
		this.thrActno = thrActno;
	}

	public java.lang.String getThrTel() {
		return thrTel;
	}

	public void setThrTel(java.lang.String thrTel) {
		this.thrTel = thrTel;
	}

	public java.lang.String getThrRole() {
		return thrRole;
	}

	public void setThrRole(java.lang.String thrRole) {
		this.thrRole = thrRole;
	}

	public java.lang.String getFouFirName() {
		return fouFirName;
	}

	public void setFouFirName(java.lang.String fouFirName) {
		this.fouFirName = fouFirName;
	}

	public java.lang.String getFouAddress() {
		return fouAddress;
	}

	public void setFouAddress(java.lang.String fouAddress) {
		this.fouAddress = fouAddress;
	}

	public java.lang.String getFouLegal() {
		return fouLegal;
	}

	public void setFouLegal(java.lang.String fouLegal) {
		this.fouLegal = fouLegal;
	}

	public java.lang.String getFouActUbankno() {
		return fouActUbankno;
	}

	public void setFouActUbankno(java.lang.String fouActUbankno) {
		this.fouActUbankno = fouActUbankno;
	}

	public java.lang.String getFouActno() {
		return fouActno;
	}

	public void setFouActno(java.lang.String fouActno) {
		this.fouActno = fouActno;
	}

	public java.lang.String getFouTel() {
		return fouTel;
	}

	public void setFouTel(java.lang.String fouTel) {
		this.fouTel = fouTel;
	}

	public java.lang.String getFouRole() {
		return fouRole;
	}

	public void setFouRole(java.lang.String fouRole) {
		this.fouRole = fouRole;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.lang.String getMoniOfCustcd() {
		return moniOfCustcd;
	}

	public void setMoniOfCustcd(java.lang.String moniOfCustcd) {
		this.moniOfCustcd = moniOfCustcd;
	}

	public java.lang.String getMoniModel() {
		return moniModel;
	}

	public void setMoniModel(java.lang.String moniModel) {
		this.moniModel = moniModel;
	}

	public java.math.BigDecimal getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(java.math.BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}

	public java.math.BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}

	public void setLowPriceNew(java.math.BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}

	public java.lang.String getMortgageNo() {
		return mortgageNo;
	}

	public void setMortgageNo(java.lang.String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}

	public java.util.Date getTxdate() {
		return txdate;
	}

	public void setTxdate(java.util.Date txdate) {
		this.txdate = txdate;
	}

	public java.lang.String getRecordTlrcd() {
		return recordTlrcd;
	}

	public void setRecordTlrcd(java.lang.String recordTlrcd) {
		this.recordTlrcd = recordTlrcd;
	}

	public java.lang.String getRecordBrcode() {
		return recordBrcode;
	}

	public void setRecordBrcode(java.lang.String recordBrcode) {
		this.recordBrcode = recordBrcode;
	}

	public java.lang.String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(java.lang.String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public java.lang.String getBrcode() {
		return brcode;
	}

	public void setBrcode(java.lang.String brcode) {
		this.brcode = brcode;
	}

	public java.lang.String getCurcd() {
		return curcd;
	}

	public void setCurcd(java.lang.String curcd) {
		this.curcd = curcd;
	}

	public java.lang.String getCustcd() {
		return custcd;
	}

	public void setCustcd(java.lang.String custcd) {
		this.custcd = custcd;
	}

	public java.math.BigDecimal getContAmount() {
		return contAmount;
	}

	public void setContAmount(java.math.BigDecimal contAmount) {
		this.contAmount = contAmount;
	}

	public java.util.Date getSignDate() {
		return signDate;
	}

	public void setSignDate(java.util.Date signDate) {
		this.signDate = signDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public java.util.Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(java.util.Date dueDate) {
		this.dueDate = dueDate;
	}

	public java.lang.String getFinancingType() {
		return financingType;
	}

	public void setFinancingType(java.lang.String financingType) {
		this.financingType = financingType;
	}

	public java.math.BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}

	public void setFirstBailRatio(java.math.BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}

	public java.lang.String getAssureType() {
		return assureType;
	}

	public void setAssureType(java.lang.String assureType) {
		this.assureType = assureType;
	}

	/**
	 * @return the netMastId
	 */
	public java.lang.String getNetMastId() {
		return netMastId;
	}

	/**
	 * @param netMastId
	 *            the netMastId to set
	 */
	public void setNetMastId(java.lang.String netMastId) {
		this.netMastId = netMastId;
	}

	/**
	 * @return the netSlaveId
	 */
	public java.lang.String getNetSlaveId() {
		return netSlaveId;
	}

	/**
	 * @param netSlaveId
	 *            the netSlaveId to set
	 */
	public void setNetSlaveId(java.lang.String netSlaveId) {
		this.netSlaveId = netSlaveId;
	}

	public java.lang.String getMastContStatus() {
		return mastContStatus;
	}

	public void setMastContStatus(java.lang.String mastContStatus) {
		this.mastContStatus = mastContStatus;
	}

	public java.lang.String getFivelevel() {
		return fivelevel;
	}

	public void setFivelevel(java.lang.String fivelevel) {
		this.fivelevel = fivelevel;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.String getDebetId() {
		return debetId;
	}

	public void setDebetId(java.lang.String debetId) {
		this.debetId = debetId;
	}

	public java.lang.String getMastContno() {
		return mastContno;
	}

	public void setMastContno(java.lang.String mastContno) {
		this.mastContno = mastContno;
	}

	public java.lang.String getLnciType() {
		return lnciType;
	}

	public void setLnciType(java.lang.String lnciType) {
		this.lnciType = lnciType;
	}

	public java.lang.String getLnciStatus() {
		return lnciStatus;
	}

	public void setLnciStatus(java.lang.String lnciStatus) {
		this.lnciStatus = lnciStatus;
	}

	public java.math.BigDecimal getLnciAmt() {
		return lnciAmt;
	}

	public void setLnciAmt(java.math.BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}

	public java.math.BigDecimal getLnciBal() {
		return lnciBal;
	}

	public void setLnciBal(java.math.BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.util.Date getRepaymentDate() {
		return repaymentDate;
	}

	public void setRepaymentDate(java.util.Date repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	public java.math.BigDecimal getRepayBalamt() {
		return repayBalamt;
	}

	public void setRepayBalamt(java.math.BigDecimal repayBalamt) {
		this.repayBalamt = repayBalamt;
	}

	public java.math.BigDecimal getRepayIntamt() {
		return repayIntamt;
	}

	public void setRepayIntamt(java.math.BigDecimal repayIntamt) {
		this.repayIntamt = repayIntamt;
	}

	public java.lang.String getCustno() {
		return custno;
	}

	public void setCustno(java.lang.String custno) {
		this.custno = custno;
	}

	public java.lang.String getCname() {
		return cname;
	}

	public void setCname(java.lang.String cname) {
		this.cname = cname;
	}

	public java.lang.String getEname() {
		return ename;
	}

	public void setEname(java.lang.String ename) {
		this.ename = ename;
	}

	public java.lang.String getAliasName() {
		return aliasName;
	}

	public void setAliasName(java.lang.String aliasName) {
		this.aliasName = aliasName;
	}

	public java.lang.String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(java.lang.String orgCode) {
		this.orgCode = orgCode;
	}

	public java.lang.String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(java.lang.String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public java.util.Date getLicenseDate() {
		return licenseDate;
	}

	public void setLicenseDate(java.util.Date licenseDate) {
		this.licenseDate = licenseDate;
	}

	public java.lang.String getLastUpdTlrcd() {
		return lastUpdTlrcd;
	}

	public void setLastUpdTlrcd(java.lang.String lastUpdTlrcd) {
		this.lastUpdTlrcd = lastUpdTlrcd;
	}

	public java.util.Date getLastUpdTime() {
		return lastUpdTime;
	}

	public void setLastUpdTime(java.util.Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	public java.lang.String getCustType() {
		return custType;
	}

	public void setCustType(java.lang.String custType) {
		this.custType = custType;
	}

	public java.util.Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(java.util.Date openDate) {
		this.openDate = openDate;
	}

	public java.util.Date getCoreOpenDate() {
		return coreOpenDate;
	}

	public void setCoreOpenDate(java.util.Date coreOpenDate) {
		this.coreOpenDate = coreOpenDate;
	}

	public java.lang.String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(java.lang.String custStatus) {
		this.custStatus = custStatus;
	}

	public String getStartBrcode() {
		return startBrcode;
	}

	public void setStartBrcode(String startBrcode) {
		this.startBrcode = startBrcode;
	}

	public String getStartTlrcd() {
		return startTlrcd;
	}

	public void setStartTlrcd(String startTlrcd) {
		this.startTlrcd = startTlrcd;
	}

	public java.math.BigDecimal getBailAmt() {
		return bailAmt;
	}

	public void setBailAmt(java.math.BigDecimal bailAmt) {
		this.bailAmt = bailAmt;
	}

	public java.math.BigDecimal getStorTtlAmt() {
		return storTtlAmt;
	}

	public void setStorTtlAmt(java.math.BigDecimal storTtlAmt) {
		this.storTtlAmt = storTtlAmt;
	}

	public java.math.BigDecimal getStockPremiums() {
		return stockPremiums;
	}

	public void setStockPremiums(java.math.BigDecimal stockPremiums) {
		this.stockPremiums = stockPremiums;
	}

	public java.math.BigDecimal getStockPremiumsRate() {
		return stockPremiumsRate;
	}

	public void setStockPremiumsRate(java.math.BigDecimal stockPremiumsRate) {
		this.stockPremiumsRate = stockPremiumsRate;
	}

	public java.math.BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(java.math.BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public java.lang.Integer getNumSum() {
		return numSum;
	}

	public void setNumSum(java.lang.Integer numSum) {
		this.numSum = numSum;
	}

	public java.math.BigDecimal getTotalFinAmount() {
		return totalFinAmount;
	}

	public void setTotalFinAmount(java.math.BigDecimal totalFinAmount) {
		this.totalFinAmount = totalFinAmount;
	}

	public java.math.BigDecimal getTotalFinRemAmoun() {
		return totalFinRemAmoun;
	}

	public void setTotalFinRemAmoun(java.math.BigDecimal totalFinRemAmoun) {
		this.totalFinRemAmoun = totalFinRemAmoun;
	}

	public java.lang.String getMortgageModel() {
		return mortgageModel;
	}

	public void setMortgageModel(java.lang.String mortgageModel) {
		this.mortgageModel = mortgageModel;
	}

	public java.lang.String getMortgageClass() {
		return mortgageClass;
	}

	public void setMortgageClass(java.lang.String mortgageClass) {
		this.mortgageClass = mortgageClass;
	}

	/**
	 * @return the srvNetId
	 */
	public java.lang.Integer getSrvNetId() {
		return srvNetId;
	}

	/**
	 * @param srvNetId
	 *            the srvNetId to set
	 */
	public void setSrvNetId(java.lang.Integer srvNetId) {
		this.srvNetId = srvNetId;
	}

	public java.util.Date getAppDate() {
		return appDate;
	}

	public void setAppDate(java.util.Date appDate) {
		this.appDate = appDate;
	}

	public java.lang.String getAppTlrcd() {
		return appTlrcd;
	}

	public void setAppTlrcd(java.lang.String appTlrcd) {
		this.appTlrcd = appTlrcd;
	}

	public java.lang.String getAppBrcode() {
		return appBrcode;
	}

	public void setAppBrcode(java.lang.String appBrcode) {
		this.appBrcode = appBrcode;
	}

	public java.lang.String getAppno() {
		return appno;
	}

	public void setAppno(java.lang.String appno) {
		this.appno = appno;
	}

	public java.math.BigDecimal getLeavingContAmount() {
		return leavingContAmount;
	}

	public void setLeavingContAmount(java.math.BigDecimal leavingContAmount) {
		this.leavingContAmount = leavingContAmount;
	}

	public java.math.BigDecimal getLeavingBailAmount() {
		return leavingBailAmount;
	}

	public void setLeavingBailAmount(java.math.BigDecimal leavingBailAmount) {
		this.leavingBailAmount = leavingBailAmount;
	}

	public java.math.BigDecimal getMortgageAmount() {
		return mortgageAmount;
	}

	public void setMortgageAmount(java.math.BigDecimal mortgageAmount) {
		this.mortgageAmount = mortgageAmount;
	}

	public java.lang.String getAppType() {
		return appType;
	}

	public void setAppType(java.lang.String appType) {
		this.appType = appType;
	}

	public java.util.Date getNotifyDate() {
		return notifyDate;
	}

	public void setNotifyDate(java.util.Date notifyDate) {
		this.notifyDate = notifyDate;
	}

	public java.lang.String getNotifyMan() {
		return notifyMan;
	}

	public void setNotifyMan(java.lang.String notifyMan) {
		this.notifyMan = notifyMan;
	}

	public java.lang.String getMortgageSubClass() {
		return mortgageSubClass;
	}

	public void setMortgageSubClass(java.lang.String mortgageSubClass) {
		this.mortgageSubClass = mortgageSubClass;
	}

	public java.math.BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(java.math.BigDecimal quantity) {
		this.quantity = quantity;
	}

	public java.lang.String getMortgageUnits() {
		return mortgageUnits;
	}

	public void setMortgageUnits(java.lang.String mortgageUnits) {
		this.mortgageUnits = mortgageUnits;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	public java.math.BigDecimal getBailAmount() {
		return bailAmount;
	}

	public void setBailAmount(java.math.BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}

	public java.lang.String getBailAccount() {
		return bailAccount;
	}

	public void setBailAccount(java.lang.String bailAccount) {
		this.bailAccount = bailAccount;
	}

	public java.lang.String getWarehouseReceiptId() {
		return warehouseReceiptId;
	}

	public void setWarehouseReceiptId(java.lang.String warehouseReceiptId) {
		this.warehouseReceiptId = warehouseReceiptId;
	}

	public java.lang.String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(java.lang.String goodsType) {
		this.goodsType = goodsType;
	}

	public java.lang.String getBrand() {
		return brand;
	}

	public void setBrand(java.lang.String brand) {
		this.brand = brand;
	}

	public java.lang.String getStandard() {
		return standard;
	}

	public void setStandard(java.lang.String standard) {
		this.standard = standard;
	}

	public java.lang.String getAmount() {
		return amount;
	}

	public void setAmount(java.lang.String amount) {
		this.amount = amount;
	}

	public java.lang.String getMeasure() {
		return measure;
	}

	public void setMeasure(java.lang.String measure) {
		this.measure = measure;
	}

	public java.lang.String getStoragePrice() {
		return storagePrice;
	}

	public void setStoragePrice(java.lang.String storagePrice) {
		this.storagePrice = storagePrice;
	}

	public java.lang.String getMaintainDate() {
		return maintainDate;
	}

	public void setMaintainDate(java.lang.String maintainDate) {
		this.maintainDate = maintainDate;
	}

	public java.lang.String getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(java.lang.String averagePrice) {
		this.averagePrice = averagePrice;
	}

	public java.lang.String getFluctuation() {
		return fluctuation;
	}

	public void setFluctuation(java.lang.String fluctuation) {
		this.fluctuation = fluctuation;
	}

	public java.lang.String getWarehousePara() {
		return warehousePara;
	}

	public void setWarehousePara(java.lang.String warehousePara) {
		this.warehousePara = warehousePara;
	}

	public java.lang.String getWarehouseParavlaue() {
		return warehouseParavlaue;
	}

	public void setWarehouseParavlaue(java.lang.String warehouseParavlaue) {
		this.warehouseParavlaue = warehouseParavlaue;
	}

	public java.lang.String getCurrency() {
		return currency;
	}

	public void setCurrency(java.lang.String currency) {
		this.currency = currency;
	}

	public java.lang.String getDate() {
		return date;
	}

	public void setDate(java.lang.String date) {
		this.date = date;
	}

	public java.lang.String getThrLegalDuties() {
		return thrLegalDuties;
	}

	public void setThrLegalDuties(java.lang.String thrLegalDuties) {
		this.thrLegalDuties = thrLegalDuties;
	}

	public java.lang.String getThrAttn() {
		return thrAttn;
	}

	public void setThrAttn(java.lang.String thrAttn) {
		this.thrAttn = thrAttn;
	}

	public java.lang.String getSignIn() {
		return signIn;
	}

	public void setSignIn(java.lang.String signIn) {
		this.signIn = signIn;
	}

	public java.lang.String getThrId() {
		return thrId;
	}

	public void setThrId(java.lang.String thrId) {
		this.thrId = thrId;
	}

	public java.lang.String getThrLicense() {
		return thrLicense;
	}

	public void setThrLicense(java.lang.String thrLicense) {
		this.thrLicense = thrLicense;
	}

	public java.lang.String getThrFax() {
		return thrFax;
	}

	public void setThrFax(java.lang.String thrFax) {
		this.thrFax = thrFax;
	}

	public java.lang.String getThrPostCode() {
		return thrPostCode;
	}

	public void setThrPostCode(java.lang.String thrPostCode) {
		this.thrPostCode = thrPostCode;
	}

	public java.lang.String getSecAttnTel() {
		return secAttnTel;
	}

	public void setSecAttnTel(java.lang.String secAttnTel) {
		this.secAttnTel = secAttnTel;
	}

	public java.lang.String getSecAttn() {
		return secAttn;
	}

	public void setSecAttn(java.lang.String secAttn) {
		this.secAttn = secAttn;
	}

	public java.lang.String getSecFax() {
		return secFax;
	}

	public void setSecFax(java.lang.String secFax) {
		this.secFax = secFax;
	}

	public java.lang.String getSecId() {
		return secId;
	}

	public void setSecId(java.lang.String secId) {
		this.secId = secId;
	}

	public java.lang.String getSecLicenseno() {
		return secLicenseno;
	}

	public void setSecLicenseno(java.lang.String secLicenseno) {
		this.secLicenseno = secLicenseno;
	}

	public java.lang.String getSecLegalDuties() {
		return secLegalDuties;
	}

	public void setSecLegalDuties(java.lang.String secLegalDuties) {
		this.secLegalDuties = secLegalDuties;
	}

	public java.lang.String getSecPostCode() {
		return secPostCode;
	}

	public void setSecPostCode(java.lang.String secPostCode) {
		this.secPostCode = secPostCode;
	}

	public java.lang.String getFirPostCode() {
		return firPostCode;
	}

	public void setFirPostCode(java.lang.String firPostCode) {
		this.firPostCode = firPostCode;
	}

	public java.lang.String getFirFax() {
		return firFax;
	}

	public void setFirFax(java.lang.String firFax) {
		this.firFax = firFax;
	}

	public java.lang.String getFirAttn() {
		return firAttn;
	}

	public void setFirAttn(java.lang.String firAttn) {
		this.firAttn = firAttn;
	}

	public java.lang.String getFirLegalDuties() {
		return firLegalDuties;
	}

	public void setFirLegalDuties(java.lang.String firLegalDuties) {
		this.firLegalDuties = firLegalDuties;
	}

	public java.lang.String getCustClass() {
		return custClass;
	}

	public void setCustClass(java.lang.String custClass) {
		this.custClass = custClass;
	}

	public java.lang.String getCreditCheckStatus() {
		return creditCheckStatus;
	}

	public void setCreditCheckStatus(java.lang.String creditCheckStatus) {
		this.creditCheckStatus = creditCheckStatus;
	}

	public java.lang.Integer getCreditRealId() {
		return creditRealId;
	}

	public void setCreditRealId(java.lang.Integer creditRealId) {
		this.creditRealId = creditRealId;
	}

	public java.lang.String getCreditLineStatus() {
		return creditLineStatus;
	}

	public void setCreditLineStatus(java.lang.String creditLineStatus) {
		this.creditLineStatus = creditLineStatus;
	}

	public java.math.BigDecimal getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(java.math.BigDecimal creditLine) {
		this.creditLine = creditLine;
	}

	public java.lang.String getPiid() {
		return piid;
	}

	public void setPiid(java.lang.String piid) {
		this.piid = piid;
	}

	public java.lang.String getAppliType() {
		return appliType;
	}

	public void setAppliType(java.lang.String appliType) {
		this.appliType = appliType;
	}

	public java.lang.String getProcessTemplateName() {
		return processTemplateName;
	}

	public void setProcessTemplateName(java.lang.String processTemplateName) {
		this.processTemplateName = processTemplateName;
	}

	public java.lang.String getBusinessnoType() {
		return businessnoType;
	}

	public void setBusinessnoType(java.lang.String businessnoType) {
		this.businessnoType = businessnoType;
	}

	public java.lang.String getBusinessno() {
		return businessno;
	}

	public void setBusinessno(java.lang.String businessno) {
		this.businessno = businessno;
	}

	public java.math.BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(java.math.BigDecimal amt) {
		this.amt = amt;
	}

	public java.util.Date getStratDate() {
		return stratDate;
	}

	public void setStratDate(java.util.Date stratDate) {
		this.stratDate = stratDate;
	}

	public java.util.Date getStartTime() {
		return startTime;
	}

	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}

	public java.lang.String getAppliStatus() {
		return appliStatus;
	}

	public void setAppliStatus(java.lang.String appliStatus) {
		this.appliStatus = appliStatus;
	}

	public java.lang.String getApproveBrcode() {
		return approveBrcode;
	}

	public void setApproveBrcode(java.lang.String approveBrcode) {
		this.approveBrcode = approveBrcode;
	}

	public java.lang.String getApprover() {
		return approver;
	}

	public void setApprover(java.lang.String approver) {
		this.approver = approver;
	}

	public java.util.Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(java.util.Date approveDate) {
		this.approveDate = approveDate;
	}

	public java.util.Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(java.util.Date approveTime) {
		this.approveTime = approveTime;
	}

	public java.lang.String getWorkflowAppno() {
		return workflowAppno;
	}

	public void setWorkflowAppno(java.lang.String workflowAppno) {
		this.workflowAppno = workflowAppno;
	}

	public java.lang.String getBillno() {
		return billno;
	}

	public void setBillno(java.lang.String billno) {
		this.billno = billno;
	}

	public java.lang.String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(java.lang.String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public java.lang.String getSeatcd() {
		return seatcd;
	}

	public void setSeatcd(java.lang.String seatcd) {
		this.seatcd = seatcd;
	}

	public java.lang.String getTradecd() {
		return tradecd;
	}

	public void setTradecd(java.lang.String tradecd) {
		this.tradecd = tradecd;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getPostno() {
		return postno;
	}

	public void setPostno(java.lang.String postno) {
		this.postno = postno;
	}

	public java.lang.String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(java.lang.String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public java.lang.String getStorageAddress() {
		return storageAddress;
	}

	public void setStorageAddress(java.lang.String storageAddress) {
		this.storageAddress = storageAddress;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getFax() {
		return fax;
	}

	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	public java.lang.String getStandLose() {
		return standLose;
	}

	public void setStandLose(java.lang.String standLose) {
		this.standLose = standLose;
	}

	public java.util.Date getStorageCostEndDate() {
		return storageCostEndDate;
	}

	public void setStorageCostEndDate(java.util.Date storageCostEndDate) {
		this.storageCostEndDate = storageCostEndDate;
	}

	public java.lang.String getGallerycd() {
		return gallerycd;
	}

	public void setGallerycd(java.lang.String gallerycd) {
		this.gallerycd = gallerycd;
	}

	public java.lang.String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(java.lang.String galleryName) {
		this.galleryName = galleryName;
	}

	public java.lang.String getPawneeName() {
		return pawneeName;
	}

	public void setPawneeName(java.lang.String pawneeName) {
		this.pawneeName = pawneeName;
	}

	public java.lang.String getSpecialTradeCode() {
		return specialTradeCode;
	}

	public void setSpecialTradeCode(java.lang.String specialTradeCode) {
		this.specialTradeCode = specialTradeCode;
	}

	public java.lang.String getFutureCustcd() {
		return futureCustcd;
	}

	public void setFutureCustcd(java.lang.String futureCustcd) {
		this.futureCustcd = futureCustcd;
	}

	public java.util.Date getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(java.util.Date billDueDate) {
		this.billDueDate = billDueDate;
	}

	public java.util.Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(java.util.Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public java.lang.String getMortgageClassNo() {
		return mortgageClassNo;
	}

	public void setMortgageClassNo(java.lang.String mortgageClassNo) {
		this.mortgageClassNo = mortgageClassNo;
	}

	public java.lang.String getMortgageBizType() {
		return mortgageBizType;
	}

	public void setMortgageBizType(java.lang.String mortgageBizType) {
		this.mortgageBizType = mortgageBizType;
	}

	public java.lang.String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}

	public void setMonitorProtocolNo(java.lang.String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}

	public java.lang.String getOtherprotocolNo() {
		return otherprotocolNo;
	}

	public void setOtherprotocolNo(java.lang.String otherprotocolNo) {
		this.otherprotocolNo = otherprotocolNo;
	}

	public java.lang.String getOtherProtocolNo() {
		return otherProtocolNo;
	}

	public void setOtherProtocolNo(java.lang.String otherProtocolNo) {
		this.otherProtocolNo = otherProtocolNo;
	}

	public java.lang.String getFirstAppno() {
		return firstAppno;
	}

	public void setFirstAppno(java.lang.String firstAppno) {
		this.firstAppno = firstAppno;
	}

	public java.util.Date getFirstStorageDate() {
		return firstStorageDate;
	}

	public void setFirstStorageDate(java.util.Date firstStorageDate) {
		this.firstStorageDate = firstStorageDate;
	}

	public java.math.BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(java.math.BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public java.math.BigDecimal getOriginalTotPrice() {
		return originalTotPrice;
	}

	public void setOriginalTotPrice(java.math.BigDecimal originalTotPrice) {
		this.originalTotPrice = originalTotPrice;
	}

	public java.math.BigDecimal getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(java.math.BigDecimal totPrice) {
		this.totPrice = totPrice;
	}

	public java.lang.String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(java.lang.String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public java.math.BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(java.math.BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public java.math.BigDecimal getConfirmPrice() {
		return confirmPrice;
	}

	public void setConfirmPrice(java.math.BigDecimal confirmPrice) {
		this.confirmPrice = confirmPrice;
	}

	public java.lang.String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(java.lang.String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public java.lang.String getVender() {
		return vender;
	}

	public void setVender(java.lang.String vender) {
		this.vender = vender;
	}

	public java.lang.String getProductArea() {
		return productArea;
	}

	public void setProductArea(java.lang.String productArea) {
		this.productArea = productArea;
	}

	public java.lang.String getIncomeNo() {
		return incomeNo;
	}

	public void setIncomeNo(java.lang.String incomeNo) {
		this.incomeNo = incomeNo;
	}

	public java.math.BigDecimal getRation() {
		return ration;
	}

	public void setRation(java.math.BigDecimal ration) {
		this.ration = ration;
	}

	public java.lang.String getWrappage() {
		return wrappage;
	}

	public void setWrappage(java.lang.String wrappage) {
		this.wrappage = wrappage;
	}

	public java.lang.String getQualityLevel() {
		return qualityLevel;
	}

	public void setQualityLevel(java.lang.String qualityLevel) {
		this.qualityLevel = qualityLevel;
	}

	public java.lang.String getSn() {
		return sn;
	}

	public void setSn(java.lang.String sn) {
		this.sn = sn;
	}

	public java.lang.String getYear() {
		return year;
	}

	public void setYear(java.lang.String year) {
		this.year = year;
	}

	public java.lang.String getBillType() {
		return billType;
	}

	public void setBillType(java.lang.String billType) {
		this.billType = billType;
	}

	public java.lang.String getWeightAll() {
		return weightAll;
	}

	public void setWeightAll(java.lang.String weightAll) {
		this.weightAll = weightAll;
	}

	public java.lang.String getMortgageLevelOne() {
		return mortgageLevelOne;
	}

	public void setMortgageLevelOne(java.lang.String mortgageLevelOne) {
		this.mortgageLevelOne = mortgageLevelOne;
	}

	public java.lang.String getMortgageLevelTwo() {
		return mortgageLevelTwo;
	}

	public void setMortgageLevelTwo(java.lang.String mortgageLevelTwo) {
		this.mortgageLevelTwo = mortgageLevelTwo;
	}

	public java.lang.String getMortgageLevelThree() {
		return mortgageLevelThree;
	}

	public void setMortgageLevelThree(java.lang.String mortgageLevelThree) {
		this.mortgageLevelThree = mortgageLevelThree;
	}

	public java.lang.String getMortgageLevelFour() {
		return mortgageLevelFour;
	}

	public void setMortgageLevelFour(java.lang.String mortgageLevelFour) {
		this.mortgageLevelFour = mortgageLevelFour;
	}

	public java.lang.String getMortgageLevelFive() {
		return mortgageLevelFive;
	}

	public void setMortgageLevelFive(java.lang.String mortgageLevelFive) {
		this.mortgageLevelFive = mortgageLevelFive;
	}

	public java.lang.String getMortgageLevelSix() {
		return mortgageLevelSix;
	}

	public void setMortgageLevelSix(java.lang.String mortgageLevelSix) {
		this.mortgageLevelSix = mortgageLevelSix;
	}

	public java.math.BigDecimal getBillQuantity() {
		return billQuantity;
	}

	public void setBillQuantity(java.math.BigDecimal billQuantity) {
		this.billQuantity = billQuantity;
	}

	public java.lang.String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(java.lang.String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public java.lang.String getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(java.lang.String registrationNum) {
		this.registrationNum = registrationNum;
	}

	public java.lang.String getFirCd() {
		return firCd;
	}

	public void setFirCd(java.lang.String firCd) {
		this.firCd = firCd;
	}

	public java.lang.String getSecCd() {
		return secCd;
	}

	public void setSecCd(java.lang.String secCd) {
		this.secCd = secCd;
	}

	public java.lang.String getThrCd() {
		return thrCd;
	}

	public void setThrCd(java.lang.String thrCd) {
		this.thrCd = thrCd;
	}

	public java.lang.String getFouCd() {
		return fouCd;
	}

	public void setFouCd(java.lang.String fouCd) {
		this.fouCd = fouCd;
	}

	public java.lang.String getStorDeliBizType() {
		return storDeliBizType;
	}

	public void setStorDeliBizType(java.lang.String storDeliBizType) {
		this.storDeliBizType = storDeliBizType;
	}

	public java.lang.String getStorOrDeli() {
		return storOrDeli;
	}

	public void setStorOrDeli(java.lang.String storOrDeli) {
		this.storOrDeli = storOrDeli;
	}

	public java.lang.String getWarnLine() {
		return warnLine;
	}

	public void setWarnLine(java.lang.String warnLine) {
		this.warnLine = warnLine;
	}

	public java.lang.String getSaleLine() {
		return saleLine;
	}

	public void setSaleLine(java.lang.String saleLine) {
		this.saleLine = saleLine;
	}

	public java.lang.String getSecUactno() {
		return secUactno;
	}

	public void setSecUactno(java.lang.String secUactno) {
		this.secUactno = secUactno;
	}

	public java.lang.String getSecActCbankno() {
		return secActCbankno;
	}

	public void setSecActCbankno(java.lang.String secActCbankno) {
		this.secActCbankno = secActCbankno;
	}

	public java.lang.String getSecCactno() {
		return secCactno;
	}

	public void setSecCactno(java.lang.String secCactno) {
		this.secCactno = secCactno;
	}

	public java.lang.String getOtherMessage() {
		return otherMessage;
	}

	public void setOtherMessage(java.lang.String otherMessage) {
		this.otherMessage = otherMessage;
	}

	public java.lang.String getDisputeResolventType() {
		return disputeResolventType;
	}

	public void setDisputeResolventType(java.lang.String disputeResolventType) {
		this.disputeResolventType = disputeResolventType;
	}

	public java.lang.String getBailaccount() {
		return bailaccount;
	}

	public void setBailaccount(java.lang.String bailaccount) {
		this.bailaccount = bailaccount;
	}

	public java.math.BigDecimal getPriceMaxDecline() {
		return priceMaxDecline;
	}

	public void setPriceMaxDecline(java.math.BigDecimal priceMaxDecline) {
		this.priceMaxDecline = priceMaxDecline;
	}

	public java.lang.Integer getOffsetDeadline() {
		return offsetDeadline;
	}

	public void setOffsetDeadline(java.lang.Integer offsetDeadline) {
		this.offsetDeadline = offsetDeadline;
	}

	public java.lang.Integer getBreachDeadline() {
		return breachDeadline;
	}

	public void setBreachDeadline(java.lang.Integer breachDeadline) {
		this.breachDeadline = breachDeadline;
	}

	public java.lang.String getIsexchange() {
		return isexchange;
	}

	public void setIsexchange(java.lang.String isexchange) {
		this.isexchange = isexchange;
	}

	public java.lang.String getInsure() {
		return insure;
	}

	public void setInsure(java.lang.String insure) {
		this.insure = insure;
	}

	public java.lang.String getSlaveCurcd() {
		return slaveCurcd;
	}

	public void setSlaveCurcd(java.lang.String slaveCurcd) {
		this.slaveCurcd = slaveCurcd;
	}

	public java.lang.String getTlrn() {
		return tlrn;
	}

	public void setTlrn(java.lang.String tlrn) {
		this.tlrn = tlrn;
	}

	public java.lang.String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(java.lang.String noticeType) {
		this.noticeType = noticeType;
	}

	public java.lang.String getSlaveType() {
		return slaveType;
	}

	public void setSlaveType(java.lang.String slaveType) {
		this.slaveType = slaveType;
	}

	public java.util.Date getAppliDate() {
		return appliDate;
	}

	public void setAppliDate(java.util.Date appliDate) {
		this.appliDate = appliDate;
	}

	public java.lang.Integer getPid() {
		return pid;
	}

	public void setPid(java.lang.Integer pid) {
		this.pid = pid;
	}

	public java.lang.String getProtocolCode() {
		return protocolCode;
	}

	public void setProtocolCode(java.lang.String protocolCode) {
		this.protocolCode = protocolCode;
	}

	public java.lang.String getThrActCbankno() {
		return thrActCbankno;
	}

	public void setThrActCbankno(java.lang.String thrActCbankno) {
		this.thrActCbankno = thrActCbankno;
	}

	public java.lang.String getThrUactno() {
		return thrUactno;
	}

	public void setThrUactno(java.lang.String thrUactno) {
		this.thrUactno = thrUactno;
	}

	public java.lang.String getThrCactno() {
		return thrCactno;
	}

	public void setThrCactno(java.lang.String thrCactno) {
		this.thrCactno = thrCactno;
	}

	public java.lang.String getLogisticsMoniCondition() {
		return logisticsMoniCondition;
	}

	public void setLogisticsMoniCondition(
			java.lang.String logisticsMoniCondition) {
		this.logisticsMoniCondition = logisticsMoniCondition;
	}

	public java.lang.String getWarehousedress() {
		return warehousedress;
	}

	public void setWarehousedress(java.lang.String warehousedress) {
		this.warehousedress = warehousedress;
	}

	public java.lang.String getMortgagePayType() {
		return mortgagePayType;
	}

	public void setMortgagePayType(java.lang.String mortgagePayType) {
		this.mortgagePayType = mortgagePayType;
	}

	public java.lang.String getSpecialWarehouseCondition() {
		return specialWarehouseCondition;
	}

	public void setSpecialWarehouseCondition(
			java.lang.String specialWarehouseCondition) {
		this.specialWarehouseCondition = specialWarehouseCondition;
	}

	public java.lang.String getThrWebsite() {
		return thrWebsite;
	}

	public void setThrWebsite(java.lang.String thrWebsite) {
		this.thrWebsite = thrWebsite;
	}

	public java.lang.String getThrFaxNumber() {
		return thrFaxNumber;
	}

	public void setThrFaxNumber(java.lang.String thrFaxNumber) {
		this.thrFaxNumber = thrFaxNumber;
	}

	public java.lang.String getThrMailbox() {
		return thrMailbox;
	}

	public void setThrMailbox(java.lang.String thrMailbox) {
		this.thrMailbox = thrMailbox;
	}

	public java.lang.String getCostBear() {
		return costBear;
	}

	public void setCostBear(java.lang.String costBear) {
		this.costBear = costBear;
	}

	public java.lang.String getCostStandard() {
		return costStandard;
	}

	public void setCostStandard(java.lang.String costStandard) {
		this.costStandard = costStandard;
	}

	public java.math.BigDecimal getMoniCost() {
		return moniCost;
	}

	public void setMoniCost(java.math.BigDecimal moniCost) {
		this.moniCost = moniCost;
	}

	public java.lang.String getPayWay() {
		return payWay;
	}

	public void setPayWay(java.lang.String payWay) {
		this.payWay = payWay;
	}

	public java.lang.Integer getPayTime() {
		return payTime;
	}

	public void setPayTime(java.lang.Integer payTime) {
		this.payTime = payTime;
	}

	public java.lang.String getProtectPrice() {
		return protectPrice;
	}

	public void setProtectPrice(java.lang.String protectPrice) {
		this.protectPrice = protectPrice;
	}

	public java.math.BigDecimal getBailAmountSum() {
		return bailAmountSum;
	}

	public void setBailAmountSum(java.math.BigDecimal bailAmountSum) {
		this.bailAmountSum = bailAmountSum;
	}

	public java.lang.String getInsuranceFlag() {
		return insuranceFlag;
	}

	public void setInsuranceFlag(java.lang.String insuranceFlag) {
		this.insuranceFlag = insuranceFlag;
	}

	public java.lang.String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(java.lang.String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public java.lang.String getInsuranceBuyer() {
		return insuranceBuyer;
	}

	public void setInsuranceBuyer(java.lang.String insuranceBuyer) {
		this.insuranceBuyer = insuranceBuyer;
	}

	public java.lang.String getInsuranceBenefiter() {
		return insuranceBenefiter;
	}

	public void setInsuranceBenefiter(java.lang.String insuranceBenefiter) {
		this.insuranceBenefiter = insuranceBenefiter;
	}

	public java.math.BigDecimal getInsuranceAmt() {
		return insuranceAmt;
	}

	public void setInsuranceAmt(java.math.BigDecimal insuranceAmt) {
		this.insuranceAmt = insuranceAmt;
	}

	public java.util.Date getInsuranceStartDate() {
		return insuranceStartDate;
	}

	public void setInsuranceStartDate(java.util.Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}

	public java.util.Date getInsuranceEndDate() {
		return insuranceEndDate;
	}

	public void setInsuranceEndDate(java.util.Date insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}

	public java.lang.String getWarehouseType() {
		return warehouseType;
	}

	public void setWarehouseType(java.lang.String warehouseType) {
		this.warehouseType = warehouseType;
	}

	public java.util.Date getWarehouseHireEndDate() {
		return warehouseHireEndDate;
	}

	public void setWarehouseHireEndDate(java.util.Date warehouseHireEndDate) {
		this.warehouseHireEndDate = warehouseHireEndDate;
	}

	public java.util.Date getWarehouseHireStartDate() {
		return warehouseHireStartDate;
	}

	public void setWarehouseHireStartDate(java.util.Date warehouseHireStartDate) {
		this.warehouseHireStartDate = warehouseHireStartDate;
	}

	public java.lang.String getWarehouseHireProtocol() {
		return warehouseHireProtocol;
	}

	public void setWarehouseHireProtocol(java.lang.String warehouseHireProtocol) {
		this.warehouseHireProtocol = warehouseHireProtocol;
	}

	public java.lang.String getMoniName() {
		return moniName;
	}

	public void setMoniName(java.lang.String moniName) {
		this.moniName = moniName;
	}

	public java.lang.String getMoniTel() {
		return moniTel;
	}

	public void setMoniTel(java.lang.String moniTel) {
		this.moniTel = moniTel;
	}

	public java.lang.String getMortgageName() {
		return mortgageName;
	}

	public void setMortgageName(java.lang.String mortgageName) {
		this.mortgageName = mortgageName;
	}

	public java.lang.String getExt1() {
		return ext1;
	}

	public void setExt1(java.lang.String ext1) {
		this.ext1 = ext1;
	}

	public java.lang.String getExt2() {
		return ext2;
	}

	public void setExt2(java.lang.String ext2) {
		this.ext2 = ext2;
	}

	public java.lang.String getExt3() {
		return ext3;
	}

	public void setExt3(java.lang.String ext3) {
		this.ext3 = ext3;
	}

	public java.math.BigDecimal getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(java.math.BigDecimal creditAmt) {
		this.creditAmt = creditAmt;
	}

	public java.math.BigDecimal getStockAmt() {
		return stockAmt;
	}

	public void setStockAmt(java.math.BigDecimal stockAmt) {
		this.stockAmt = stockAmt;
	}

	public java.math.BigDecimal getRiskAmt() {
		return riskAmt;
	}

	public void setRiskAmt(java.math.BigDecimal riskAmt) {
		this.riskAmt = riskAmt;
	}

	public java.lang.String getProtectPriceType() {
		return protectPriceType;
	}

	public void setProtectPriceType(java.lang.String protectPriceType) {
		this.protectPriceType = protectPriceType;
	}

	public java.lang.Double getProtectPriceRation() {
		return protectPriceRation;
	}

	public void setProtectPriceRation(java.lang.Double protectPriceRation) {
		this.protectPriceRation = protectPriceRation;
	}

	public java.lang.String getOtherDes() {
		return otherDes;
	}

	public void setOtherDes(java.lang.String otherDes) {
		this.otherDes = otherDes;
	}

	public java.lang.String getMoniWarehouseType() {
		return moniWarehouseType;
	}

	public void setMoniWarehouseType(java.lang.String moniWarehouseType) {
		this.moniWarehouseType = moniWarehouseType;
	}

	public java.lang.String getMoniAreaType() {
		return moniAreaType;
	}

	public void setMoniAreaType(java.lang.String moniAreaType) {
		this.moniAreaType = moniAreaType;
	}

	public java.math.BigDecimal getUpDownMoney() {
		return upDownMoney;
	}

	public void setUpDownMoney(java.math.BigDecimal upDownMoney) {
		this.upDownMoney = upDownMoney;
	}

	public java.lang.String getTotlePriceSum() {
		return totlePriceSum;
	}

	public void setTotlePriceSum(java.lang.String totlePriceSum) {
		this.totlePriceSum = totlePriceSum;
	}

	public java.lang.Integer getHandInDate() {
		return handInDate;
	}

	public void setHandInDate(java.lang.Integer handInDate) {
		this.handInDate = handInDate;
	}

	public java.lang.String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(java.lang.String receiveName) {
		this.receiveName = receiveName;
	}

	public java.lang.String getStopReason() {
		return stopReason;
	}

	public void setStopReason(java.lang.String stopReason) {
		this.stopReason = stopReason;
	}

	public java.lang.String getReasonType() {
		return reasonType;
	}

	public void setReasonType(java.lang.String reasonType) {
		this.reasonType = reasonType;
	}

	public java.lang.String getConventionNo() {
		return conventionNo;
	}

	public void setConventionNo(java.lang.String conventionNo) {
		this.conventionNo = conventionNo;
	}

	public java.lang.String getFaultA() {
		return faultA;
	}

	public void setFaultA(java.lang.String faultA) {
		this.faultA = faultA;
	}

	public java.lang.String getFaultB() {
		return faultB;
	}

	public void setFaultB(java.lang.String faultB) {
		this.faultB = faultB;
	}

	public java.lang.String getMastContCode() {
		return mastContCode;
	}

	public void setMastContCode(java.lang.String mastContCode) {
		this.mastContCode = mastContCode;
	}

	public java.math.BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(java.math.BigDecimal credit) {
		this.credit = credit;
	}

	private java.lang.String mgrno;

	public java.lang.String getMgrno() {
		return mgrno;
	}

	public void setMgrno(java.lang.String mgrno) {
		this.mgrno = mgrno;
	}

	private java.lang.String moniType;

	public java.lang.String getMoniType() {
		return moniType;
	}

	public void setMoniType(java.lang.String moniType) {
		this.moniType = moniType;
	}

	private java.lang.String grouped;
	private java.lang.String groupedMember;

	public java.lang.String getGrouped() {
		return grouped;
	}

	public void setGrouped(java.lang.String grouped) {
		this.grouped = grouped;
	}

	public java.lang.String getGroupedMember() {
		return groupedMember;
	}

	public void setGroupedMember(java.lang.String groupedMember) {
		this.groupedMember = groupedMember;
	}

	private java.lang.String contactTel;

	public java.lang.String getContactTel() {
		return contactTel;
	}

	public void setContactTel(java.lang.String contactTel) {
		this.contactTel = contactTel;
	}

	public java.lang.String getState() {
		return state;
	}

	public void setState(java.lang.String state) {
		this.state = state;
	}

	public java.lang.String getUpdateState() {
		return updateState;
	}

	public void setUpdateState(java.lang.String updateState) {
		this.updateState = updateState;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public java.math.BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(java.math.BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public java.math.BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(java.math.BigDecimal balance) {
		this.balance = balance;
	}

	public java.lang.String getPledgeMode() {
		return pledgeMode;
	}

	public void setPledgeMode(java.lang.String pledgeMode) {
		this.pledgeMode = pledgeMode;
	}

	public java.math.BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(java.math.BigDecimal realAmount) {
		this.realAmount = realAmount;
	}

	public java.lang.String getSerialno() {
		return serialno;
	}

	public void setSerialno(java.lang.String serialno) {
		this.serialno = serialno;
	}

	public java.lang.String getRelativeserialno() {
		return relativeserialno;
	}

	public void setRelativeserialno(java.lang.String relativeserialno) {
		this.relativeserialno = relativeserialno;
	}

	public java.lang.String getOccurdate() {
		return occurdate;
	}

	public void setOccurdate(java.lang.String occurdate) {
		this.occurdate = occurdate;
	}

	public java.lang.String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(java.lang.String customerid) {
		this.customerid = customerid;
	}

	public java.lang.String getCustomername() {
		return customername;
	}

	public void setCustomername(java.lang.String customername) {
		this.customername = customername;
	}

	public java.lang.String getOccurtype() {
		return occurtype;
	}

	public void setOccurtype(java.lang.String occurtype) {
		this.occurtype = occurtype;
	}

	public java.lang.String getBusinesstype() {
		return businesstype;
	}

	public void setBusinesstype(java.lang.String businesstype) {
		this.businesstype = businesstype;
	}

	public java.lang.String getPutoutorgid() {
		return putoutorgid;
	}

	public void setPutoutorgid(java.lang.String putoutorgid) {
		this.putoutorgid = putoutorgid;
	}

	public java.lang.String getBusinesstypename() {
		return businesstypename;
	}

	public void setBusinesstypename(java.lang.String businesstypename) {
		this.businesstypename = businesstypename;
	}

	public java.lang.String getArtificialno() {
		return artificialno;
	}

	public void setArtificialno(java.lang.String artificialno) {
		this.artificialno = artificialno;
	}

	public java.lang.String getActualartificialno() {
		return actualartificialno;
	}

	public void setActualartificialno(java.lang.String actualartificialno) {
		this.actualartificialno = actualartificialno;
	}

	public java.lang.String getPutoutorgname() {
		return putoutorgname;
	}

	public void setPutoutorgname(java.lang.String putoutorgname) {
		this.putoutorgname = putoutorgname;
	}

	public java.lang.String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(java.lang.String accountNo) {
		this.accountNo = accountNo;
	}

	public java.lang.String getLoanaccountno() {
		return loanaccountno;
	}

	public void setLoanaccountno(java.lang.String loanaccountno) {
		this.loanaccountno = loanaccountno;
	}

	public java.lang.String getSecondpayaccount() {
		return secondpayaccount;
	}

	public void setSecondpayaccount(java.lang.String secondpayaccount) {
		this.secondpayaccount = secondpayaccount;
	}

	public java.lang.String getFundsource() {
		return fundsource;
	}

	public void setFundsource(java.lang.String fundsource) {
		this.fundsource = fundsource;
	}

	public java.lang.String getBusinesscurrency() {
		return businesscurrency;
	}

	public void setBusinesscurrency(java.lang.String businesscurrency) {
		this.businesscurrency = businesscurrency;
	}

	public java.math.BigDecimal getBusinesssum() {
		return businesssum;
	}

	public void setBusinesssum(java.math.BigDecimal businesssum) {
		this.businesssum = businesssum;
	}

	public java.lang.String getPurpose() {
		return purpose;
	}

	public void setPurpose(java.lang.String purpose) {
		this.purpose = purpose;
	}

	public java.lang.String getDirection() {
		return direction;
	}

	public void setDirection(java.lang.String direction) {
		this.direction = direction;
	}

	public java.lang.String getDirectionname() {
		return directionname;
	}

	public void setDirectionname(java.lang.String directionname) {
		this.directionname = directionname;
	}

	public java.lang.String getRiskattribute() {
		return riskattribute;
	}

	public void setRiskattribute(java.lang.String riskattribute) {
		this.riskattribute = riskattribute;
	}

	public java.math.BigDecimal getTermmonth() {
		return termmonth;
	}

	public void setTermmonth(java.math.BigDecimal termmonth) {
		this.termmonth = termmonth;
	}

	public java.math.BigDecimal getTermday() {
		return termday;
	}

	public void setTermday(java.math.BigDecimal termday) {
		this.termday = termday;
	}

	public java.math.BigDecimal getBusinessrate() {
		return businessrate;
	}

	public void setBusinessrate(java.math.BigDecimal businessrate) {
		this.businessrate = businessrate;
	}

	public java.lang.String getRatefloattype() {
		return ratefloattype;
	}

	public void setRatefloattype(java.lang.String ratefloattype) {
		this.ratefloattype = ratefloattype;
	}

	public java.math.BigDecimal getRatefloat() {
		return ratefloat;
	}

	public void setRatefloat(java.math.BigDecimal ratefloat) {
		this.ratefloat = ratefloat;
	}

	public java.lang.String getAdjustratetype() {
		return adjustratetype;
	}

	public void setAdjustratetype(java.lang.String adjustratetype) {
		this.adjustratetype = adjustratetype;
	}

	public java.lang.String getAdjustrateterm() {
		return adjustrateterm;
	}

	public void setAdjustrateterm(java.lang.String adjustrateterm) {
		this.adjustrateterm = adjustrateterm;
	}

	public java.lang.String getIccyc() {
		return iccyc;
	}

	public void setIccyc(java.lang.String iccyc) {
		this.iccyc = iccyc;
	}

	public java.math.BigDecimal getFixcyc() {
		return fixcyc;
	}

	public void setFixcyc(java.math.BigDecimal fixcyc) {
		this.fixcyc = fixcyc;
	}

	public java.lang.String getRateadjustcyc() {
		return rateadjustcyc;
	}

	public void setRateadjustcyc(java.lang.String rateadjustcyc) {
		this.rateadjustcyc = rateadjustcyc;
	}

	public java.lang.String getOverinttype() {
		return overinttype;
	}

	public void setOverinttype(java.lang.String overinttype) {
		this.overinttype = overinttype;
	}

	public java.lang.String getDrawingtype() {
		return drawingtype;
	}

	public void setDrawingtype(java.lang.String drawingtype) {
		this.drawingtype = drawingtype;
	}

	public java.lang.String getOriginalputoutdate() {
		return originalputoutdate;
	}

	public void setOriginalputoutdate(java.lang.String originalputoutdate) {
		this.originalputoutdate = originalputoutdate;
	}

	public java.lang.String getCorpuspaymethod() {
		return corpuspaymethod;
	}

	public void setCorpuspaymethod(java.lang.String corpuspaymethod) {
		this.corpuspaymethod = corpuspaymethod;
	}

	public java.lang.String getContextinfo() {
		return contextinfo;
	}

	public void setContextinfo(java.lang.String contextinfo) {
		this.contextinfo = contextinfo;
	}

	public java.lang.String getPaysource() {
		return paysource;
	}

	public void setPaysource(java.lang.String paysource) {
		this.paysource = paysource;
	}

	public java.lang.String getVouchtype() {
		return vouchtype;
	}

	public void setVouchtype(java.lang.String vouchtype) {
		this.vouchtype = vouchtype;
	}

	public java.lang.String getVouchtypename() {
		return vouchtypename;
	}

	public void setVouchtypename(java.lang.String vouchtypename) {
		this.vouchtypename = vouchtypename;
	}

	public java.lang.String getVouchflag() {
		return vouchflag;
	}

	public void setVouchflag(java.lang.String vouchflag) {
		this.vouchflag = vouchflag;
	}

	public java.lang.String getLowrisk() {
		return lowrisk;
	}

	public void setLowrisk(java.lang.String lowrisk) {
		this.lowrisk = lowrisk;
	}

	public java.lang.String getAssureClass() {
		return assureClass;
	}

	public void setAssureClass(java.lang.String assureClass) {
		this.assureClass = assureClass;
	}

	public java.math.BigDecimal getRiskrate() {
		return riskrate;
	}

	public void setRiskrate(java.math.BigDecimal riskrate) {
		this.riskrate = riskrate;
	}

	public java.lang.String getOtherarealoan() {
		return otherarealoan;
	}

	public void setOtherarealoan(java.lang.String otherarealoan) {
		this.otherarealoan = otherarealoan;
	}

	public java.lang.String getGuarantyno() {
		return guarantyno;
	}

	public void setGuarantyno(java.lang.String guarantyno) {
		this.guarantyno = guarantyno;
	}

	public java.lang.String getPutoutdate() {
		return putoutdate;
	}

	public void setPutoutdate(java.lang.String putoutdate) {
		this.putoutdate = putoutdate;
	}

	public java.lang.String getMaturity() {
		return maturity;
	}

	public void setMaturity(java.lang.String maturity) {
		this.maturity = maturity;
	}

	public java.lang.String getClassifyresult() {
		return classifyresult;
	}

	public void setClassifyresult(java.lang.String classifyresult) {
		this.classifyresult = classifyresult;
	}

	public java.lang.String getClassifydate() {
		return classifydate;
	}

	public void setClassifydate(java.lang.String classifydate) {
		this.classifydate = classifydate;
	}

	public java.lang.String getOthercondition() {
		return othercondition;
	}

	public void setOthercondition(java.lang.String othercondition) {
		this.othercondition = othercondition;
	}

	public java.math.BigDecimal getNormalbalance() {
		return normalbalance;
	}

	public void setNormalbalance(java.math.BigDecimal normalbalance) {
		this.normalbalance = normalbalance;
	}

	public java.math.BigDecimal getOverduebalance() {
		return overduebalance;
	}

	public void setOverduebalance(java.math.BigDecimal overduebalance) {
		this.overduebalance = overduebalance;
	}

	public java.math.BigDecimal getDullbalance() {
		return dullbalance;
	}

	public void setDullbalance(java.math.BigDecimal dullbalance) {
		this.dullbalance = dullbalance;
	}

	public java.math.BigDecimal getBadbalance() {
		return badbalance;
	}

	public void setBadbalance(java.math.BigDecimal badbalance) {
		this.badbalance = badbalance;
	}

	public java.math.BigDecimal getOverduedays() {
		return overduedays;
	}

	public void setOverduedays(java.math.BigDecimal overduedays) {
		this.overduedays = overduedays;
	}

	public java.lang.String getFinishtype() {
		return finishtype;
	}

	public void setFinishtype(java.lang.String finishtype) {
		this.finishtype = finishtype;
	}

	public java.lang.String getFinishdate() {
		return finishdate;
	}

	public void setFinishdate(java.lang.String finishdate) {
		this.finishdate = finishdate;
	}

	public java.math.BigDecimal getClassifyfrequency() {
		return classifyfrequency;
	}

	public void setClassifyfrequency(java.math.BigDecimal classifyfrequency) {
		this.classifyfrequency = classifyfrequency;
	}

	public java.lang.String getApproveopinion() {
		return approveopinion;
	}

	public void setApproveopinion(java.lang.String approveopinion) {
		this.approveopinion = approveopinion;
	}

	public java.lang.String getApproveuserid() {
		return approveuserid;
	}

	public void setApproveuserid(java.lang.String approveuserid) {
		this.approveuserid = approveuserid;
	}

	public java.lang.String getApproveusername() {
		return approveusername;
	}

	public void setApproveusername(java.lang.String approveusername) {
		this.approveusername = approveusername;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.math.BigDecimal getClassifysum1() {
		return classifysum1;
	}

	public void setClassifysum1(java.math.BigDecimal classifysum1) {
		this.classifysum1 = classifysum1;
	}

	public java.math.BigDecimal getClassifysum2() {
		return classifysum2;
	}

	public void setClassifysum2(java.math.BigDecimal classifysum2) {
		this.classifysum2 = classifysum2;
	}

	public java.math.BigDecimal getClassifysum3() {
		return classifysum3;
	}

	public void setClassifysum3(java.math.BigDecimal classifysum3) {
		this.classifysum3 = classifysum3;
	}

	public java.math.BigDecimal getClassifysum4() {
		return classifysum4;
	}

	public void setClassifysum4(java.math.BigDecimal classifysum4) {
		this.classifysum4 = classifysum4;
	}

	public java.math.BigDecimal getClassifysum5() {
		return classifysum5;
	}

	public void setClassifysum5(java.math.BigDecimal classifysum5) {
		this.classifysum5 = classifysum5;
	}

	public java.lang.String getManageuserid() {
		return manageuserid;
	}

	public void setManageuserid(java.lang.String manageuserid) {
		this.manageuserid = manageuserid;
	}

	public java.lang.String getManageusername() {
		return manageusername;
	}

	public void setManageusername(java.lang.String manageusername) {
		this.manageusername = manageusername;
	}

	public java.lang.String getManageorgid() {
		return manageorgid;
	}

	public void setManageorgid(java.lang.String manageorgid) {
		this.manageorgid = manageorgid;
	}

	public java.lang.String getManageorgname() {
		return manageorgname;
	}

	public void setManageorgname(java.lang.String manageorgname) {
		this.manageorgname = manageorgname;
	}

	public java.lang.String getStatorgid() {
		return statorgid;
	}

	public void setStatorgid(java.lang.String statorgid) {
		this.statorgid = statorgid;
	}

	public java.lang.String getStatorgname() {
		return statorgname;
	}

	public void setStatorgname(java.lang.String statorgname) {
		this.statorgname = statorgname;
	}

	public java.lang.String getRecoveryuserid() {
		return recoveryuserid;
	}

	public void setRecoveryuserid(java.lang.String recoveryuserid) {
		this.recoveryuserid = recoveryuserid;
	}

	public java.lang.String getRecoveryusername() {
		return recoveryusername;
	}

	public void setRecoveryusername(java.lang.String recoveryusername) {
		this.recoveryusername = recoveryusername;
	}

	public java.lang.String getRecoveryorgid() {
		return recoveryorgid;
	}

	public void setRecoveryorgid(java.lang.String recoveryorgid) {
		this.recoveryorgid = recoveryorgid;
	}

	public java.lang.String getRecoveryorgname() {
		return recoveryorgname;
	}

	public void setRecoveryorgname(java.lang.String recoveryorgname) {
		this.recoveryorgname = recoveryorgname;
	}

	public java.lang.String getOperateuserid() {
		return operateuserid;
	}

	public void setOperateuserid(java.lang.String operateuserid) {
		this.operateuserid = operateuserid;
	}

	public java.lang.String getOperateusername() {
		return operateusername;
	}

	public void setOperateusername(java.lang.String operateusername) {
		this.operateusername = operateusername;
	}

	public java.lang.String getOperateorgid() {
		return operateorgid;
	}

	public void setOperateorgid(java.lang.String operateorgid) {
		this.operateorgid = operateorgid;
	}

	public java.lang.String getOperateorgname() {
		return operateorgname;
	}

	public void setOperateorgname(java.lang.String operateorgname) {
		this.operateorgname = operateorgname;
	}

	public java.lang.String getInputuserid() {
		return inputuserid;
	}

	public void setInputuserid(java.lang.String inputuserid) {
		this.inputuserid = inputuserid;
	}

	public java.lang.String getInputusername() {
		return inputusername;
	}

	public void setInputusername(java.lang.String inputusername) {
		this.inputusername = inputusername;
	}

	public java.lang.String getInputorgid() {
		return inputorgid;
	}

	public void setInputorgid(java.lang.String inputorgid) {
		this.inputorgid = inputorgid;
	}

	public java.lang.String getInputorgname() {
		return inputorgname;
	}

	public void setInputorgname(java.lang.String inputorgname) {
		this.inputorgname = inputorgname;
	}

	public java.lang.String getInputdate() {
		return inputdate;
	}

	public void setInputdate(java.lang.String inputdate) {
		this.inputdate = inputdate;
	}

	public java.lang.String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(java.lang.String updatedate) {
		this.updatedate = updatedate;
	}

	public java.lang.String getPigeonholedate() {
		return pigeonholedate;
	}

	public void setPigeonholedate(java.lang.String pigeonholedate) {
		this.pigeonholedate = pigeonholedate;
	}

	public java.lang.String getTempsaveflag() {
		return tempsaveflag;
	}

	public void setTempsaveflag(java.lang.String tempsaveflag) {
		this.tempsaveflag = tempsaveflag;
	}

	public java.math.BigDecimal getCancelsum() {
		return cancelsum;
	}

	public void setCancelsum(java.math.BigDecimal cancelsum) {
		this.cancelsum = cancelsum;
	}

	public java.math.BigDecimal getCancelinterest() {
		return cancelinterest;
	}

	public void setCancelinterest(java.math.BigDecimal cancelinterest) {
		this.cancelinterest = cancelinterest;
	}

	public java.lang.String getSalveContno() {
		return salveContno;
	}

	public void setSalveContno(java.lang.String salveContno) {
		this.salveContno = salveContno;
	}

	public java.lang.String getHandleReason() {
		return handleReason;
	}

	public void setHandleReason(java.lang.String handleReason) {
		this.handleReason = handleReason;
	}

	public java.lang.String getOtherReason() {
		return otherReason;
	}

	public void setOtherReason(java.lang.String otherReason) {
		this.otherReason = otherReason;
	}

	public java.util.Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(java.util.Date handleDate) {
		this.handleDate = handleDate;
	}

	public java.lang.String getHandleType() {
		return handleType;
	}

	public void setHandleType(java.lang.String handleType) {
		this.handleType = handleType;
	}

	public java.lang.String getMemo() {
		return memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public java.lang.String getFreightarea() {
		return freightarea;
	}

	public void setFreightarea(java.lang.String freightarea) {
		this.freightarea = freightarea;
	}

	public java.lang.String getFreightlot() {
		return freightlot;
	}

	public void setFreightlot(java.lang.String freightlot) {
		this.freightlot = freightlot;
	}

	public java.lang.String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(java.lang.String warehouse) {
		this.warehouse = warehouse;
	}

	public java.lang.String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(java.lang.String debetNo) {
		this.debetNo = debetNo;
	}

	public java.lang.String getCreditLoanFlag() {
		return creditLoanFlag;
	}

	public void setCreditLoanFlag(java.lang.String creditLoanFlag) {
		this.creditLoanFlag = creditLoanFlag;
	}

	public java.lang.String getLoanType() {
		return loanType;
	}

	public void setLoanType(java.lang.String loanType) {
		this.loanType = loanType;
	}

	public java.lang.String getLoanUse() {
		return loanUse;
	}

	public void setLoanUse(java.lang.String loanUse) {
		this.loanUse = loanUse;
	}

	public java.lang.String getInterestType() {
		return interestType;
	}

	public void setInterestType(java.lang.String interestType) {
		this.interestType = interestType;
	}

	public java.lang.String getInterestFlag() {
		return interestFlag;
	}

	public void setInterestFlag(java.lang.String interestFlag) {
		this.interestFlag = interestFlag;
	}

	public java.lang.String getInterestMoreFlag() {
		return interestMoreFlag;
	}

	public void setInterestMoreFlag(java.lang.String interestMoreFlag) {
		this.interestMoreFlag = interestMoreFlag;
	}

	public java.lang.String getDept() {
		return dept;
	}

	public void setDept(java.lang.String dept) {
		this.dept = dept;
	}

	public java.lang.String getMgno() {
		return mgno;
	}

	public void setMgno(java.lang.String mgno) {
		this.mgno = mgno;
	}

	public java.lang.String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(java.lang.String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public java.lang.String getBaseRateType() {
		return baseRateType;
	}

	public void setBaseRateType(java.lang.String baseRateType) {
		this.baseRateType = baseRateType;
	}

	public java.lang.String getRateActiveFlag() {
		return rateActiveFlag;
	}

	public void setRateActiveFlag(java.lang.String rateActiveFlag) {
		this.rateActiveFlag = rateActiveFlag;
	}

	public java.lang.String getLoanIndustryType() {
		return loanIndustryType;
	}

	public void setLoanIndustryType(java.lang.String loanIndustryType) {
		this.loanIndustryType = loanIndustryType;
	}

	public java.lang.String getLoanIndustryType2() {
		return loanIndustryType2;
	}

	public void setLoanIndustryType2(java.lang.String loanIndustryType2) {
		this.loanIndustryType2 = loanIndustryType2;
	}

	public java.lang.String getLoanIndustryType3() {
		return loanIndustryType3;
	}

	public void setLoanIndustryType3(java.lang.String loanIndustryType3) {
		this.loanIndustryType3 = loanIndustryType3;
	}

	public java.lang.String getLoanIndustryType4() {
		return loanIndustryType4;
	}

	public void setLoanIndustryType4(java.lang.String loanIndustryType4) {
		this.loanIndustryType4 = loanIndustryType4;
	}

	public java.lang.String getWhetherOpen() {
		return whetherOpen;
	}

	public void setWhetherOpen(java.lang.String whetherOpen) {
		this.whetherOpen = whetherOpen;
	}

	public java.lang.String getBuyerCustcd() {
		return BuyerCustcd;
	}

	public void setBuyerCustcd(java.lang.String buyerCustcd) {
		BuyerCustcd = buyerCustcd;
	}

	public java.util.Date getTxtime() {
		return txtime;
	}

	public void setTxtime(java.util.Date txtime) {
		this.txtime = txtime;
	}

	public java.lang.Integer getMortgageBizNo() {
		return mortgageBizNo;
	}

	public void setMortgageBizNo(java.lang.Integer mortgageBizNo) {
		this.mortgageBizNo = mortgageBizNo;
	}

	// public java.lang.String getBussType() {
	// return bussType;
	// }
	//
	// public void setBussType(java.lang.String bussType) {
	// this.bussType = bussType;
	// }

	public java.math.BigDecimal getCreditamt() {
		return creditamt;
	}

	public void setCreditamt(java.math.BigDecimal creditamt) {
		this.creditamt = creditamt;
	}

	public java.math.BigDecimal getStockamt() {
		return stockamt;
	}

	public void setStockamt(java.math.BigDecimal stockamt) {
		this.stockamt = stockamt;
	}

	public java.math.BigDecimal getRiskamt() {
		return riskamt;
	}

	public void setRiskamt(java.math.BigDecimal riskamt) {
		this.riskamt = riskamt;
	}

	public java.lang.String getWeightUnits() {
		return weightUnits;
	}

	public void setWeightUnits(java.lang.String weightUnits) {
		this.weightUnits = weightUnits;
	}

	public java.math.BigDecimal getWaitCompensateAmount() {
		return waitCompensateAmount;
	}

	public void setWaitCompensateAmount(
			java.math.BigDecimal waitCompensateAmount) {
		this.waitCompensateAmount = waitCompensateAmount;
	}

	public java.math.BigDecimal getCompensateAmount() {
		return compensateAmount;
	}

	public void setCompensateAmount(java.math.BigDecimal compensateAmount) {
		this.compensateAmount = compensateAmount;
	}

	private java.lang.String mastContcode;
	private java.lang.String bussType;
	private java.math.BigDecimal loanPercent;
	private java.lang.Integer loanDays;
	private java.lang.String balanceAccount;
	private java.math.BigDecimal compensatePercent;
	private java.lang.String compensateLimit;
	private java.lang.String dueTime;
	private java.lang.String chargeType;
	private java.lang.String costCalcType;
	private java.math.BigDecimal costPercent;
	private java.math.BigDecimal cost;
	private java.math.BigDecimal billManagedCost;
	private java.lang.String finacingDiscountType;
	private java.lang.String finacingCalcType;
	private java.math.BigDecimal finacingPercent;
	private java.math.BigDecimal finacingCost;
	private java.lang.String rateType;
	private java.lang.String rateId;
	private java.lang.String baseRate;
	private java.lang.String upDown;
	private java.lang.String upDownPercent;
	private java.lang.String executeRate;
	private java.lang.String overDueRate;
	private java.lang.String rateCollectType;
	private java.lang.String payDayMonth;
	private java.lang.String lcType;
	private java.lang.String postType;

	public java.lang.String getMastContcode() {
		return mastContcode;
	}

	public void setMastContcode(java.lang.String mastContcode) {
		this.mastContcode = mastContcode;
	}

	public java.lang.String getBussType() {
		return bussType;
	}

	public void setBussType(java.lang.String bussType) {
		this.bussType = bussType;
	}

	public java.math.BigDecimal getLoanPercent() {
		return loanPercent;
	}

	public void setLoanPercent(java.math.BigDecimal loanPercent) {
		this.loanPercent = loanPercent;
	}

	public java.lang.Integer getLoanDays() {
		return loanDays;
	}

	public void setLoanDays(java.lang.Integer loanDays) {
		this.loanDays = loanDays;
	}

	public java.lang.String getBalanceAccount() {
		return balanceAccount;
	}

	public void setBalanceAccount(java.lang.String balanceAccount) {
		this.balanceAccount = balanceAccount;
	}

	public java.math.BigDecimal getCompensatePercent() {
		return compensatePercent;
	}

	public void setCompensatePercent(java.math.BigDecimal compensatePercent) {
		this.compensatePercent = compensatePercent;
	}

	public java.lang.String getCompensateLimit() {
		return compensateLimit;
	}

	public void setCompensateLimit(java.lang.String compensateLimit) {
		this.compensateLimit = compensateLimit;
	}

	public java.lang.String getDueTime() {
		return dueTime;
	}

	public void setDueTime(java.lang.String dueTime) {
		this.dueTime = dueTime;
	}

	public java.lang.String getChargeType() {
		return chargeType;
	}

	public void setChargeType(java.lang.String chargeType) {
		this.chargeType = chargeType;
	}

	public java.lang.String getCostCalcType() {
		return costCalcType;
	}

	public void setCostCalcType(java.lang.String costCalcType) {
		this.costCalcType = costCalcType;
	}

	public java.math.BigDecimal getCostPercent() {
		return costPercent;
	}

	public void setCostPercent(java.math.BigDecimal costPercent) {
		this.costPercent = costPercent;
	}

	public java.math.BigDecimal getCost() {
		return cost;
	}

	public void setCost(java.math.BigDecimal cost) {
		this.cost = cost;
	}

	public java.math.BigDecimal getBillManagedCost() {
		return billManagedCost;
	}

	public void setBillManagedCost(java.math.BigDecimal billManagedCost) {
		this.billManagedCost = billManagedCost;
	}

	public java.lang.String getFinacingDiscountType() {
		return finacingDiscountType;
	}

	public void setFinacingDiscountType(java.lang.String finacingDiscountType) {
		this.finacingDiscountType = finacingDiscountType;
	}

	public java.lang.String getFinacingCalcType() {
		return finacingCalcType;
	}

	public void setFinacingCalcType(java.lang.String finacingCalcType) {
		this.finacingCalcType = finacingCalcType;
	}

	public java.math.BigDecimal getFinacingPercent() {
		return finacingPercent;
	}

	public void setFinacingPercent(java.math.BigDecimal finacingPercent) {
		this.finacingPercent = finacingPercent;
	}

	public java.math.BigDecimal getFinacingCost() {
		return finacingCost;
	}

	public void setFinacingCost(java.math.BigDecimal finacingCost) {
		this.finacingCost = finacingCost;
	}

	public java.lang.String getRateType() {
		return rateType;
	}

	public void setRateType(java.lang.String rateType) {
		this.rateType = rateType;
	}

	public java.lang.String getRateId() {
		return rateId;
	}

	public void setRateId(java.lang.String rateId) {
		this.rateId = rateId;
	}

	public java.lang.String getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(java.lang.String baseRate) {
		this.baseRate = baseRate;
	}

	public java.lang.String getUpDown() {
		return upDown;
	}

	public void setUpDown(java.lang.String upDown) {
		this.upDown = upDown;
	}

	public java.lang.String getUpDownPercent() {
		return upDownPercent;
	}

	public void setUpDownPercent(java.lang.String upDownPercent) {
		this.upDownPercent = upDownPercent;
	}

	public java.lang.String getExecuteRate() {
		return executeRate;
	}

	public void setExecuteRate(java.lang.String executeRate) {
		this.executeRate = executeRate;
	}

	public java.lang.String getOverDueRate() {
		return overDueRate;
	}

	public void setOverDueRate(java.lang.String overDueRate) {
		this.overDueRate = overDueRate;
	}

	public java.lang.String getRateCollectType() {
		return rateCollectType;
	}

	public void setRateCollectType(java.lang.String rateCollectType) {
		this.rateCollectType = rateCollectType;
	}

	public java.lang.String getPayDayMonth() {
		return payDayMonth;
	}

	public void setPayDayMonth(java.lang.String payDayMonth) {
		this.payDayMonth = payDayMonth;
	}

	public java.lang.String getLcType() {
		return lcType;
	}
	public void setLcType(java.lang.String lcType) {
		this.lcType = lcType;
	}
	public java.lang.String getPostType() {
		return postType;
	}
	public void setPostType(java.lang.String postType) {
		this.postType = postType;
	}

	public java.lang.String getParentId() {
		return parentId;
	}

	public void setParentId(java.lang.String parentId) {
		this.parentId = parentId;
	}

	public java.lang.String getFactType() {
		return factType;
	}

	public void setFactType(java.lang.String factType) {
		this.factType = factType;
	}

	public java.lang.Integer getGraceDays() {
		return graceDays;
	}

	public void setGraceDays(java.lang.Integer graceDays) {
		this.graceDays = graceDays;
	}

	public java.lang.String getRateShareType() {
		return rateShareType;
	}

	public void setRateShareType(java.lang.String rateShareType) {
		this.rateShareType = rateShareType;
	}

	public java.lang.String getBussTypeName() {
		return bussTypeName;
	}

	public void setBussypeTName(java.lang.String bussTypeName) {
		this.bussTypeName = bussTypeName;
	}

	public java.lang.String getCalcRateType() {
		return calcRateType;
	}

	public void setCalcRateType(java.lang.String calcRateType) {
		this.calcRateType = calcRateType;
	}

	public java.lang.String getRecoverType() {
		return recoverType;
	}

	public void setRecoverType(java.lang.String recoverType) {
		this.recoverType = recoverType;
	}

	public java.lang.String getInout() {
		return inout;
	}

	public void setInout(java.lang.String inout) {
		this.inout = inout;
	}

	public java.lang.Integer getDebtGraceDays() {
		return debtGraceDays;
	}

	public void setDebtGraceDays(java.lang.Integer debtGraceDays) {
		this.debtGraceDays = debtGraceDays;
	}

	private String commonDate;
	private java.math.BigDecimal rate;
	private java.lang.String deferStatus;
	private java.math.BigDecimal deferRate;
	private java.util.Date deferEndDate;
	private java.lang.String deferDate;

	public String getCommonDate() {
		return commonDate;
	}

	public void setCommonDate(String commonDate) {
		this.commonDate = commonDate;
	}

	public java.math.BigDecimal getRate() {
		return rate;
	}

	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}

	public java.lang.String getDeferStatus() {
		return deferStatus;
	}

	public void setDeferStatus(java.lang.String deferStatus) {
		this.deferStatus = deferStatus;
	}

	public java.math.BigDecimal getDeferRate() {
		return deferRate;
	}

	public void setDeferRate(java.math.BigDecimal deferRate) {
		this.deferRate = deferRate;
	}

	public java.util.Date getDeferEndDate() {
		return deferEndDate;
	}

	public void setDeferEndDate(java.util.Date deferEndDate) {
		this.deferEndDate = deferEndDate;
	}

	public java.lang.String getDeferDate() {
		return deferDate;
	}

	public void setDeferDate(java.lang.String deferDate) {
		this.deferDate = deferDate;
	}

	public java.math.BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(java.math.BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public java.math.BigDecimal getTotalRemainAmount() {
		return totalRemainAmount;
	}

	public void setTotalRemainAmount(java.math.BigDecimal totalRemainAmount) {
		this.totalRemainAmount = totalRemainAmount;
	}

	public java.math.BigDecimal getTotalRateAmount() {
		return totalRateAmount;
	}

	public void setTotalRateAmount(java.math.BigDecimal totalRateAmount) {
		this.totalRateAmount = totalRateAmount;
	}

	public java.math.BigDecimal getTotalRateRemainAmount() {
		return totalRateRemainAmount;
	}

	public void setTotalRateRemainAmount(
			java.math.BigDecimal totalRateRemainAmount) {
		this.totalRateRemainAmount = totalRateRemainAmount;
	}

	public java.math.BigDecimal getReturnRateAmount() {
		return returnRateAmount;
	}

	public void setReturnRateAmount(java.math.BigDecimal returnRateAmount) {
		this.returnRateAmount = returnRateAmount;
	}

	public java.util.Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(java.util.Date insertDate) {
		this.insertDate = insertDate;
	}

	public java.lang.String getLoanOverdueFlag() {
		return loanOverdueFlag;
	}

	public void setLoanOverdueFlag(java.lang.String loanOverdueFlag) {
		this.loanOverdueFlag = loanOverdueFlag;
	}

	private String coreCustcd;
	private String moniCustcd;
	private BigDecimal bailPercent;
	private String loanWay;
	private String firstBailType;
	private String coreAccount;

	public String getCoreCustcd() {
		return coreCustcd;
	}

	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}

	public String getMoniCustcd() {
		return moniCustcd;
	}

	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}

	public BigDecimal getBailPercent() {
		return bailPercent;
	}

	public void setBailPercent(BigDecimal bailPercent) {
		this.bailPercent = bailPercent;
	}

	public String getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}

	public String getFirstBailType() {
		return firstBailType;
	}

	public void setFirstBailType(String firstBailType) {
		this.firstBailType = firstBailType;
	}

	public String getCoreAccount() {
		return coreAccount;
	}

	public void setCoreAccount(String coreAccount) {
		this.coreAccount = coreAccount;
	}

	public java.lang.String getSfdsfcz() {
		return sfdsfcz;
	}

	public void setSfdsfcz(java.lang.String sfdsfcz) {
		this.sfdsfcz = sfdsfcz;
	}

	public java.lang.String getSupercontno() {
		return supercontno;
	}

	public void setSupercontno(java.lang.String supercontno) {
		this.supercontno = supercontno;
	}

	public java.lang.String getMainassuretype() {
		return mainassuretype;
	}

	public void setMainassuretype(java.lang.String mainassuretype) {
		this.mainassuretype = mainassuretype;
	}

	public java.util.Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(java.util.Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public java.lang.Integer getDeadline() {
		return deadline;
	}

	public void setDeadline(java.lang.Integer deadline) {
		this.deadline = deadline;
	}

	public java.util.Date getZzfkr() {
		return zzfkr;
	}

	public void setZzfkr(java.util.Date zzfkr) {
		this.zzfkr = zzfkr;
	}

	public java.util.Date getZzhkr() {
		return zzhkr;
	}

	public void setZzhkr(java.util.Date zzhkr) {
		this.zzhkr = zzhkr;
	}

	public java.util.Date getJqrq() {
		return jqrq;
	}

	public void setJqrq(java.util.Date jqrq) {
		this.jqrq = jqrq;
	}

	public java.math.BigDecimal getLjyk() {
		return ljyk;
	}

	public void setLjyk(java.math.BigDecimal ljyk) {
		this.ljyk = ljyk;
	}

	public java.math.BigDecimal getLjhk() {
		return ljhk;
	}

	public void setLjhk(java.math.BigDecimal ljhk) {
		this.ljhk = ljhk;
	}

	public java.lang.Integer getLjhkbs() {
		return ljhkbs;
	}

	public void setLjhkbs(java.lang.Integer ljhkbs) {
		this.ljhkbs = ljhkbs;
	}

	public java.math.BigDecimal getYhbj() {
		return yhbj;
	}

	public void setYhbj(java.math.BigDecimal yhbj) {
		this.yhbj = yhbj;
	}

	public java.math.BigDecimal getLjhslx() {
		return ljhslx;
	}

	public void setLjhslx(java.math.BigDecimal ljhslx) {
		this.ljhslx = ljhslx;
	}

	public java.math.BigDecimal getBailamountration() {
		return bailamountration;
	}

	public void setBailamountration(java.math.BigDecimal bailamountration) {
		this.bailamountration = bailamountration;
	}

	public java.lang.String getLastupdoperid() {
		return lastupdoperid;
	}

	public void setLastupdoperid(java.lang.String lastupdoperid) {
		this.lastupdoperid = lastupdoperid;
	}

	public java.lang.String getLastupdtime() {
		return lastupdtime;
	}

	public void setLastupdtime(java.lang.String lastupdtime) {
		this.lastupdtime = lastupdtime;
	}

	public java.lang.String getFinancingname() {
		return financingname;
	}

	public void setFinancingname(java.lang.String financingname) {
		this.financingname = financingname;
	}

	public java.lang.String getCzy() {
		return czy;
	}

	public void setCzy(java.lang.String czy) {
		this.czy = czy;
	}

	public java.lang.String getContType() {
		return contType;
	}

	public void setContType(java.lang.String contType) {
		this.contType = contType;
	}

	public java.math.BigDecimal getProtLowPric() {
		return protLowPric;
	}

	public void setProtLowPric(java.math.BigDecimal protLowPric) {
		this.protLowPric = protLowPric;
	}

	public java.math.BigDecimal getOverDueAmount() {
		return overDueAmount;
	}

	public void setOverDueAmount(java.math.BigDecimal overDueAmount) {
		this.overDueAmount = overDueAmount;
	}

	public java.math.BigDecimal getTotalReduce() {
		return totalReduce;
	}

	public void setTotalReduce(java.math.BigDecimal totalReduce) {
		this.totalReduce = totalReduce;
	}

	public java.math.BigDecimal getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(java.math.BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	public java.lang.String getTradeContno() {
		return tradeContno;
	}

	public void setTradeContno(java.lang.String tradeContno) {
		this.tradeContno = tradeContno;
	}

	public java.lang.String getSecCustcd() {
		return secCustcd;
	}

	public void setSecCustcd(java.lang.String secCustcd) {
		this.secCustcd = secCustcd;
	}

	public java.lang.String getSecCname() {
		return secCname;
	}

	public void setSecCname(java.lang.String secCname) {
		this.secCname = secCname;
	}

	public java.lang.String getMortgageMesc() {
		return mortgageMesc;
	}

	public void setMortgageMesc(java.lang.String mortgageMesc) {
		this.mortgageMesc = mortgageMesc;
	}

	public java.lang.String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(java.lang.String transportMode) {
		this.transportMode = transportMode;
	}

	public java.lang.String getCheckMethod() {
		return checkMethod;
	}

	public void setCheckMethod(java.lang.String checkMethod) {
		this.checkMethod = checkMethod;
	}

	public java.lang.String getDeliverGoodAddr() {
		return deliverGoodAddr;
	}

	public void setDeliverGoodAddr(java.lang.String deliverGoodAddr) {
		this.deliverGoodAddr = deliverGoodAddr;
	}

	public java.util.Date getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(java.util.Date deliverDate) {
		this.deliverDate = deliverDate;
	}

	public java.math.BigDecimal getTransportCost() {
		return transportCost;
	}

	public void setTransportCost(java.math.BigDecimal transportCost) {
		this.transportCost = transportCost;
	}

	public java.lang.String getTransportType() {
		return transportType;
	}

	public void setTransportType(java.lang.String transportType) {
		this.transportType = transportType;
	}

	public java.lang.String getTradeContcode() {
		return tradeContcode;
	}

	public void setTradeContcode(java.lang.String tradeContcode) {
		this.tradeContcode = tradeContcode;
	}

	public java.lang.String getBank() {
		return bank;
	}

	public void setBank(java.lang.String bank) {
		this.bank = bank;
	}

	public java.lang.String getBankName() {
		return bankName;
	}

	public void setBankName(java.lang.String bankName) {
		this.bankName = bankName;
	}

	public java.lang.String getSecBank() {
		return secBank;
	}

	public void setSecBank(java.lang.String secBank) {
		this.secBank = secBank;
	}

	public java.lang.String getSecBankName() {
		return secBankName;
	}

	public void setSecBankName(java.lang.String secBankName) {
		this.secBankName = secBankName;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public java.math.BigDecimal getFirPercent() {
		return firPercent;
	}

	public void setFirPercent(java.math.BigDecimal firPercent) {
		this.firPercent = firPercent;
	}

	public java.math.BigDecimal getSecPercent() {
		return secPercent;
	}

	public void setSecPercent(java.math.BigDecimal secPercent) {
		this.secPercent = secPercent;
	}

	public java.math.BigDecimal getThrPercent() {
		return thrPercent;
	}

	public void setThrPercent(java.math.BigDecimal thrPercent) {
		this.thrPercent = thrPercent;
	}

	public java.lang.String getCustcdBuyer() {
		return custcdBuyer;
	}

	public void setCustcdBuyer(java.lang.String custcdBuyer) {
		this.custcdBuyer = custcdBuyer;
	}

	public java.lang.String getCustcdSeller() {
		return custcdSeller;
	}

	public void setCustcdSeller(java.lang.String custcdSeller) {
		this.custcdSeller = custcdSeller;
	}

	public java.math.BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(java.math.BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public java.math.BigDecimal getLoanRemainingAmount() {
		return loanRemainingAmount;
	}

	public void setLoanRemainingAmount(java.math.BigDecimal loanRemainingAmount) {
		this.loanRemainingAmount = loanRemainingAmount;
	}

	public java.math.BigDecimal getRemainingUseableAmount() {
		return remainingUseableAmount;
	}

	public void setRemainingUseableAmount(
			java.math.BigDecimal remainingUseableAmount) {
		this.remainingUseableAmount = remainingUseableAmount;
	}

	public java.math.BigDecimal getRateCollectAmount() {
		return rateCollectAmount;
	}

	public void setRateCollectAmount(java.math.BigDecimal rateCollectAmount) {
		this.rateCollectAmount = rateCollectAmount;
	}

	public java.math.BigDecimal getOwnRateCollectAmount() {
		return ownRateCollectAmount;
	}

	public void setOwnRateCollectAmount(
			java.math.BigDecimal ownRateCollectAmount) {
		this.ownRateCollectAmount = ownRateCollectAmount;
	}

	public java.util.Date getLoanEndDate() {
		return loanEndDate;
	}

	public void setLoanEndDate(java.util.Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public java.math.BigDecimal getQuantityAfter() {
		return quantityAfter;
	}

	public void setQuantityAfter(java.math.BigDecimal quantityAfter) {
		this.quantityAfter = quantityAfter;
	}

	public java.math.BigDecimal getConfirmAmount() {
		return confirmAmount;
	}

	public void setConfirmAmount(java.math.BigDecimal confirmAmount) {
		this.confirmAmount = confirmAmount;
	}

	public java.util.Date getIssuingDate() {
		return issuingDate;
	}

	public void setIssuingDate(java.util.Date issuingDate) {
		this.issuingDate = issuingDate;
	}

	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setOrderAmount(java.math.BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public java.util.Date getOrderDate() {
		return orderDate;
	}

	public java.math.BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public java.lang.String getIntCode() {
		return intCode;
	}

	public void setIntCode(java.lang.String intCode) {
		this.intCode = intCode;
	}

	public java.math.BigDecimal getFixedIntrate() {
		return fixedIntrate;
	}

	public void setFixedIntrate(java.math.BigDecimal fixedIntrate) {
		this.fixedIntrate = fixedIntrate;
	}

	public java.lang.String getProcName() {
		return procName;
	}

	public void setProcName(java.lang.String procName) {
		this.procName = procName;
	}

	public java.lang.String getActno() {
		return actno;
	}

	public void setActno(java.lang.String actno) {
		this.actno = actno;
	}

	public java.lang.String getBailActno() {
		return bailActno;
	}

	public void setBailActno(java.lang.String bailActno) {
		this.bailActno = bailActno;
	}

	public java.lang.String getActBankno() {
		return actBankno;
	}

	public void setActBankno(java.lang.String actBankno) {
		this.actBankno = actBankno;
	}

	public java.lang.String getTlrno() {
		return tlrno;
	}

	public void setTlrno(java.lang.String tlrno) {
		this.tlrno = tlrno;
	}

	public java.lang.String getPostCode() {
		return postCode;
	}

	public void setPostCode(java.lang.String postCode) {
		this.postCode = postCode;
	}

	public java.lang.String getAttnTel() {
		return attnTel;
	}

	public void setAttnTel(java.lang.String attnTel) {
		this.attnTel = attnTel;
	}

	public java.lang.String getCoreNm() {
		return coreNm;
	}

	public void setCoreNm(java.lang.String coreNm) {
		this.coreNm = coreNm;
	}

	public java.lang.String getSellerNm() {
		return sellerNm;
	}

	public void setSellerNm(java.lang.String sellerNm) {
		this.sellerNm = sellerNm;
	}

	public java.lang.String getMoniNm() {
		return moniNm;
	}

	public void setMoniNm(java.lang.String moniNm) {
		this.moniNm = moniNm;
	}

	public java.lang.String getDraftCustcd() {
		return draftCustcd;
	}

	public void setDraftCustcd(java.lang.String draftCustcd) {
		this.draftCustcd = draftCustcd;
	}

	public java.lang.String getDraftAccountno() {
		return draftAccountno;
	}

	public void setDraftAccountno(java.lang.String draftAccountno) {
		this.draftAccountno = draftAccountno;
	}

	public String getLcCustcd() {
		return lcCustcd;
	}

	public void setLcCustcd(String lcCustcd) {
		this.lcCustcd = lcCustcd;
	}

	public java.lang.String getCreditno() {
		return creditno;
	}

	public void setCreditno(java.lang.String creditno) {
		this.creditno = creditno;
	}

	public java.lang.String getRtnDate() {
		return rtnDate;
	}

	public void setRtnDate(java.lang.String rtnDate) {
		this.rtnDate = rtnDate;
	}

	public java.lang.String getMainAssureType() {
		return mainAssureType;
	}

	public void setMainAssureType(java.lang.String mainAssureType) {
		this.mainAssureType = mainAssureType;
	}

	public java.math.BigDecimal getPintrate() {
		return pintrate;
	}

	public void setPintrate(java.math.BigDecimal pintrate) {
		this.pintrate = pintrate;
	}

	public java.math.BigDecimal getMispPintrate() {
		return mispPintrate;
	}

	public void setMispPintrate(java.math.BigDecimal mispPintrate) {
		this.mispPintrate = mispPintrate;
	}

	/**
	 * @return the productId
	 */
	public java.lang.String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(java.lang.String productId) {
		this.productId = productId;
	}

	public String getCustomerBrcode() {
		return customerBrcode;
	}

	public void setCustomerBrcode(String customerBrcode) {
		this.customerBrcode = customerBrcode;
	}

	public java.math.BigDecimal getOpenAmount() {
		return openAmount;
	}

	public void setOpenAmount(java.math.BigDecimal openAmount) {
		this.openAmount = openAmount;
	}

	public java.math.BigDecimal getAddAmount() {
		return addAmount;
	}

	public void setAddAmount(java.math.BigDecimal addAmount) {
		this.addAmount = addAmount;
	}

	public java.lang.String getBailAccountno() {
		return bailAccountno;
	}

	public void setBailAccountno(java.lang.String bailAccountno) {
		this.bailAccountno = bailAccountno;
	}

	public java.lang.String getSubContno() {
		return subContno;
	}

	public void setSubContno(java.lang.String subContno) {
		this.subContno = subContno;
	}

	public java.lang.String getInitType() {
		return initType;
	}

	public void setInitType(java.lang.String initType) {
		this.initType = initType;
	}

	public java.math.BigDecimal getBillsAmountView() {
		return billsAmountView;
	}

	public void setBillsAmountView(java.math.BigDecimal billsAmountView) {
		this.billsAmountView = billsAmountView;
	}

	public java.math.BigDecimal getValue() {
		return value;
	}

	public void setValue(java.math.BigDecimal value) {
		this.value = value;
	}

	public java.lang.Boolean getSelect() {
		return select;
	}

	public void setSelect(java.lang.Boolean select) {
		this.select = select;
	}

	public java.math.BigDecimal getRemoveAmount() {
		return removeAmount;
	}

	public void setRemoveAmount(java.math.BigDecimal removeAmount) {
		this.removeAmount = removeAmount;
	}

	public java.lang.String getAccountType() {
		return accountType;
	}

	public void setAccountType(java.lang.String accountType) {
		this.accountType = accountType;
	}

	public java.math.BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(java.math.BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public java.math.BigDecimal getNpsBailAmount() {
		return npsBailAmount;
	}

	public void setNpsBailAmount(java.math.BigDecimal npsBailAmount) {
		this.npsBailAmount = npsBailAmount;
	}
	public java.lang.String getInsuranceCode() {
		return insuranceCode;
	}
	public void setInsuranceCode(java.lang.String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}
	public java.lang.String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(java.lang.String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public java.lang.String getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(java.lang.String beneficiary) {
		this.beneficiary = beneficiary;
	}
	public String getMortBillAccountNo() {
		return mortBillAccountNo;
	}
	public void setMortBillAccountNo(String mortBillAccountNo) {
		this.mortBillAccountNo = mortBillAccountNo;
	}
	public BigDecimal getMortBillAmount() {
		return mortBillAmount;
	}
	public void setMortBillAmount(BigDecimal mortBillAmount) {
		this.mortBillAmount = mortBillAmount;
	}
	public java.lang.String getAutoLoan() {
		return autoLoan;
	}
	public void setAutoLoan(java.lang.String autoLoan) {
		this.autoLoan = autoLoan;
	}
	/**
	 * @return the realLoanAmount
	 */
	public java.math.BigDecimal getRealLoanAmount() {
		return realLoanAmount;
	}
	/**
	 * @param realLoanAmount the realLoanAmount to set
	 */
	public void setRealLoanAmount(java.math.BigDecimal realLoanAmount) {
		this.realLoanAmount = realLoanAmount;
	}
	/**
	 * @return the ophase
	 */
	public java.lang.String getOphase() {
		return ophase;
	}
	/**
	 * @param ophase the ophase to set
	 */
	public void setOphase(java.lang.String ophase) {
		this.ophase = ophase;
	}
	public java.lang.String getMoniProtocolType() {
		return moniProtocolType;
	}
	public void setMoniProtocolType(java.lang.String moniProtocolType) {
		this.moniProtocolType = moniProtocolType;
	}
	/**
	 * @return the returnAmount
	 */
	public java.math.BigDecimal getReturnAmount() {
		return returnAmount;
	}
	/**
	 * @param returnAmount the returnAmount to set
	 */
	public void setReturnAmount(java.math.BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}
	/**
	 * @return the returnCapitalAmount
	 */
	public java.math.BigDecimal getReturnCapitalAmount() {
		return returnCapitalAmount;
	}
	/**
	 * @param returnCapitalAmount the returnCapitalAmount to set
	 */
	public void setReturnCapitalAmount(java.math.BigDecimal returnCapitalAmount) {
		this.returnCapitalAmount = returnCapitalAmount;
	}
	/**
	 * @return the toSallerAmount
	 */
	public java.math.BigDecimal getToSallerAmount() {
		return toSallerAmount;
	}
	/**
	 * @param toSallerAmount the toSallerAmount to set
	 */
	public void setToSallerAmount(java.math.BigDecimal toSallerAmount) {
		this.toSallerAmount = toSallerAmount;
	}
	/**
	 * @return the toPoolAmount
	 */
	public java.math.BigDecimal getToPoolAmount() {
		return toPoolAmount;
	}
	/**
	 * @param toPoolAmount the toPoolAmount to set
	 */
	public void setToPoolAmount(java.math.BigDecimal toPoolAmount) {
		this.toPoolAmount = toPoolAmount;
	}
	/**
	 * @return the balanceBueAmount
	 */
	public java.math.BigDecimal getBalanceBueAmount() {
		return balanceBueAmount;
	}
	/**
	 * @param balanceBueAmount the balanceBueAmount to set
	 */
	public void setBalanceBueAmount(java.math.BigDecimal balanceBueAmount) {
		this.balanceBueAmount = balanceBueAmount;
	}
	public java.lang.String getBillcode() {
		return billcode;
	}
	public void setBillcode(java.lang.String billcode) {
		this.billcode = billcode;
	}
	public java.lang.String getLeaseFactoringFlag() {
		return leaseFactoringFlag;
	}
	public void setLeaseFactoringFlag(java.lang.String leaseFactoringFlag) {
		this.leaseFactoringFlag = leaseFactoringFlag;
	}
	public java.lang.String getLeasebackFlag() {
		return leasebackFlag;
	}
	public void setLeasebackFlag(java.lang.String leasebackFlag) {
		this.leasebackFlag = leasebackFlag;
	}

	public java.lang.String getWarnLevel() {
		return warnLevel;
	}
	public void setWarnLevel(java.lang.String warnLevel) {
		this.warnLevel = warnLevel;
	}
	public String getReturnAccount() {
		return returnAccount;
	}
	public void setReturnAccount(String returnAccount) {
		this.returnAccount = returnAccount;
	}
	public void setBussTypeName(java.lang.String bussTypeName) {
		this.bussTypeName = bussTypeName;
	}
	public java.lang.String getMonitorProtocolCode() {
		return monitorProtocolCode;
	}
	public void setMonitorProtocolCode(java.lang.String monitorProtocolCode) {
		this.monitorProtocolCode = monitorProtocolCode;
	}
	public java.lang.String getUpDownMoneyFlag() {
		return upDownMoneyFlag;
	}
	public void setUpDownMoneyFlag(java.lang.String upDownMoneyFlag) {
		this.upDownMoneyFlag = upDownMoneyFlag;
	}
	public java.lang.String getMortgageManageMode() {
		return mortgageManageMode;
	}
	public void setMortgageManageMode(java.lang.String mortgageManageMode) {
		this.mortgageManageMode = mortgageManageMode;
	}
	public java.lang.String getIsAuthorizeSell() {
		return isAuthorizeSell;
	}
	public void setIsAuthorizeSell(java.lang.String isAuthorizeSell) {
		this.isAuthorizeSell = isAuthorizeSell;
	}
	public java.lang.String getIsInsurance() {
		return isInsurance;
	}
	public void setIsInsurance(java.lang.String isInsurance) {
		this.isInsurance = isInsurance;
	}
	public java.lang.String getCondignee() {
		return condignee;
	}
	public void setCondignee(java.lang.String condignee) {
		this.condignee = condignee;
	}
	public java.lang.String getTrasportationMode() {
		return trasportationMode;
	}
	public void setTrasportationMode(java.lang.String trasportationMode) {
		this.trasportationMode = trasportationMode;
	}
	public java.lang.String getDeliveryPoints() {
		return deliveryPoints;
	}
	public void setDeliveryPoints(java.lang.String deliveryPoints) {
		this.deliveryPoints = deliveryPoints;
	}
	public java.lang.String getDestination() {
		return destination;
	}
	public void setDestination(java.lang.String destination) {
		this.destination = destination;
	}
	public java.lang.String getDeliveryTerm() {
		return deliveryTerm;
	}
	public void setDeliveryTerm(java.lang.String deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}
	public java.lang.String getCoreCustDuty() {
		return coreCustDuty;
	}
	public void setCoreCustDuty(java.lang.String coreCustDuty) {
		this.coreCustDuty = coreCustDuty;
	}
	public java.util.Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(java.util.Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public java.lang.String getTriConventions() {
		return triConventions;
	}
	public void setTriConventions(java.lang.String triConventions) {
		this.triConventions = triConventions;
	}
	public java.math.BigDecimal getTotAmount() {
		return totAmount;
	}
	public void setTotAmount(java.math.BigDecimal totAmount) {
		this.totAmount = totAmount;
	}
	public java.lang.String getInsuranceAccountNo() {
		return insuranceAccountNo;
	}
	public void setInsuranceAccountNo(java.lang.String insuranceAccountNo) {
		this.insuranceAccountNo = insuranceAccountNo;
	}
	public java.math.BigDecimal getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(java.math.BigDecimal insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
	public java.lang.String getSellerRegAddr() {
		return sellerRegAddr;
	}
	public void setSellerRegAddr(java.lang.String sellerRegAddr) {
		this.sellerRegAddr = sellerRegAddr;
	}
	public java.lang.String getSellerContactName() {
		return sellerContactName;
	}
	public void setSellerContactName(java.lang.String sellerContactName) {
		this.sellerContactName = sellerContactName;
	}
	public java.lang.String getCoreRegAddr() {
		return coreRegAddr;
	}
	public void setCoreRegAddr(java.lang.String coreRegAddr) {
		this.coreRegAddr = coreRegAddr;
	}
	public java.lang.String getCoreContactName() {
		return coreContactName;
	}
	public void setCoreContactName(java.lang.String coreContactName) {
		this.coreContactName = coreContactName;
	}
	public java.lang.String getTakeMode() {
		return takeMode;
	}
	public void setTakeMode(java.lang.String takeMode) {
		this.takeMode = takeMode;
	}
	public java.lang.String getGoodsNm() {
		return goodsNm;
	}
	public void setGoodsNm(java.lang.String goodsNm) {
		this.goodsNm = goodsNm;
	}

	public java.lang.String getAttn() {
		return attn;
	}
	public void setAttn(java.lang.String attn) {
		this.attn = attn;
	}
	public java.lang.String getFouName() {
		return fouName;
	}
	public void setFouName(java.lang.String fouName) {
		this.fouName = fouName;
	}
	public java.lang.String getIsHighestLimit() {
		return isHighestLimit;
	}
	public void setIsHighestLimit(java.lang.String isHighestLimit) {
		this.isHighestLimit = isHighestLimit;
	}
	public java.lang.String getMoniPriceModel() {
		return moniPriceModel;
	}
	public void setMoniPriceModel(java.lang.String moniPriceModel) {
		this.moniPriceModel = moniPriceModel;
	}
	public java.lang.String getMoniMode() {
		return moniMode;
	}
	public void setMoniMode(java.lang.String moniMode) {
		this.moniMode = moniMode;
	}
	public java.lang.Integer getDeallineRate() {
		return deallineRate;
	}
	public void setDeallineRate(java.lang.Integer deallineRate) {
		this.deallineRate = deallineRate;
	}
	public java.util.Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(java.util.Date applyDate) {
		this.applyDate = applyDate;
	}
	public java.math.BigDecimal getTotAmt() {
		return totAmt;
	}
	public void setTotAmt(java.math.BigDecimal totAmt) {
		this.totAmt = totAmt;
	}
	public java.math.BigDecimal getCurrOutAmt() {
		return currOutAmt;
	}
	public void setCurrOutAmt(java.math.BigDecimal currOutAmt) {
		this.currOutAmt = currOutAmt;
	}

	public java.lang.String getFlag() {
		return flag;
	}
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}

	public java.math.BigDecimal getTotQuantity() {
		return totQuantity;
	}
	public void setTotQuantity(java.math.BigDecimal totQuantity) {
		this.totQuantity = totQuantity;
	}
	public java.lang.String getCheckLowPriceType() {
		return checkLowPriceType;
	}
	public void setCheckLowPriceType(java.lang.String checkLowPriceType) {
		this.checkLowPriceType = checkLowPriceType;
	}

	public java.lang.String getRefundAccount() {
		return refundAccount;
	}
	public void setRefundAccount(java.lang.String refundAccount) {
		this.refundAccount = refundAccount;
	}
	public java.lang.String getCountUnits() {
		return countUnits;
	}
	public void setCountUnits(java.lang.String countUnits) {
		this.countUnits = countUnits;
	}
	public java.lang.String getBackCustcd() {
		return backCustcd;
	}
	public void setBackCustcd(java.lang.String backCustcd) {
		this.backCustcd = backCustcd;
	}
	public java.lang.String getBackCustName() {
		return backCustName;
	}
	public void setBackCustName(java.lang.String backCustName) {
		this.backCustName = backCustName;
	}
	public java.lang.String getMoniCustName() {
		return moniCustName;
	}
	public void setMoniCustName(java.lang.String moniCustName) {
		this.moniCustName = moniCustName;
	}
	public java.lang.String getDutyAssumeType() {
		return dutyAssumeType;
	}
	public void setDutyAssumeType(java.lang.String dutyAssumeType) {
		this.dutyAssumeType = dutyAssumeType;
	}
	public java.lang.Integer getConsignmentDays() {
		return consignmentDays;
	}
	public void setConsignmentDays(java.lang.Integer consignmentDays) {
		this.consignmentDays = consignmentDays;
	}
	public java.lang.String getOtherCustName() {
		return otherCustName;
	}
	public void setOtherCustName(java.lang.String otherCustName) {
		this.otherCustName = otherCustName;
	}
	public java.lang.String getSellOffFlag() {
		return sellOffFlag;
	}
	public void setSellOffFlag(java.lang.String sellOffFlag) {
		this.sellOffFlag = sellOffFlag;
	}
	public java.math.BigDecimal getPriceDropRate() {
		return priceDropRate;
	}
	public void setPriceDropRate(java.math.BigDecimal priceDropRate) {
		this.priceDropRate = priceDropRate;
	}

}
