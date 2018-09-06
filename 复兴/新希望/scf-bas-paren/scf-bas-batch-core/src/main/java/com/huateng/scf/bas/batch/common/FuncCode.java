/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.batch.common;

/**
 * @author annie
 * @date 2004-11-29
 * @usage: define error code
 */
public class FuncCode {

	/**
	 * 档案管理功能代码
	 */
	//档案登记，支行档案管理岗
	public static final int FUNC_CODE_ARCH_REGISTER = 1010101;
	//档案上缴，支行档案管理岗
	public static final int FUNC_CODE_ARCH_SUBMIT = 1010102;
	//档案接收，分行档案管理岗
	public static final int FUNC_CODE_ARCH_RECEIVE = 1010103;
	//档案移交，支行档案管理岗，分行档案管理岗
	public static final int FUNC_CODE_ARCH_TRANSFER = 1010104;
	//档案修改，支行档案管理岗，分行档案管理岗
	public static final int FUNC_CODE_ARCH_MODIFY = 1010105;
	//档案调阅，支行档案管理岗，分行档案管理岗
	public static final int FUNC_CODE_ARCH_CONSULT = 1010106;
	//档案销毁申请，支行档案管理岗，分行档案管理岗
	public static final int FUNC_CODE_ARCH_DSTRYAPPLY = 1010107;
	//档案销毁审批，分行档案管理岗
	public static final int FUNC_CODE_ARCH_DSTRYAPPROVE = 1010108;
	//未上缴档案查询，支行档案管理岗，分行档案管理岗
	public static final int FUNC_CODE_ARCH_UNSUBMITQUERY = 1010109;
	//档案操作查询，支行档案管理岗，分行档案管理岗
	public static final int FUNC_CODE_ARCH_OPRQUERY = 1010110;
	//根据贷款合同号或者授信号，查询贷款信息或授信额度信息
	public static final int FUNC_CODE_ARCH_INQBYLNNO = 1010111;
	//根据档案编号查询档案基本信息、贷款信息及借款人信息
	public static final int FUNC_CODE_ARCH_INQDETAIL = 1010112;
	//根据组合查询条件，查询档案信息列表
	public static final int FUNC_CODE_ARCH_INQLIST = 1010113;
	//档案编号和状态查询
	public static final int FUNC_CODE_ARCH_NO_QUERY = 1010114;
	//档案调阅归还
	public static final int FUNC_CODE_ARCH_CONSULT_RETURN = 1010115;
	//档案批量移交
	public static final int FUNC_CODE_ARCH_BATCH_TRANSFER = 1010116;
	//档案登记，分行档案管理岗
	public static final int FUNC_CODE_ARCH_REGISTER_BRANCH = 1010117;
    //档案退回，分行档案管理岗
    public static final int FUNC_CODE_ARCH_BACK = 1010118;

	/**
	 * 权利品管理功能代码
	 */
	//权利品登记，支行档案管理岗
	public static final int FUNC_CODE_GUA_REG = 1010201;
	//权利品上缴，支行档案管理岗
	public static final int FUNC_CODE_GUA_SUBMIT = 1010202;
	//权利品接收，分行档案管理岗
	public static final int FUNC_CODE_GUA_RECEIVE = 1010203;
	//权利品移交，支行档案管理岗，分行档案管理岗
	public static final int FUNC_CODE_GUA_TRANSFER = 1010204;
	//权利品入库，支行档案管理岗，分行档案管理岗
	public static final int FUNC_CODE_GUA_STORAGE = 1010205;
	//权利品领取申请，支行档案管理岗，分行档案管理岗
	public static final int FUNC_CODE_GUA_DRAW = 1010206;
	//权利品领取审批，分行档案管理岗
	public static final int FUNC_CODE_GUA_DRAW_APP = 1010207;
	//根据合同号或者授信号查询权利品相关信息
	public static final int FUNC_CODE_GUA_INQ_BY_LNNO = 1010208;
	//权利品操作查询
	public static final int FUNC_CODE_GUA_OPR_INQ = 1010209;
	//权利品上缴查询
	public static final int FUNC_CODE_GUA_UNSUBMIT_INQ_LIST = 1010210;
	//权利品登记查询
	public static final int FUNC_CODE_GUA_REG_INQ = 1010211;
	//权利品上缴查询
	public static final int FUNC_CODE_GUA_SUBMIT_INQ = 1010212;
	//权利品模糊查询
	public static final int FUNC_CODE_GUA_BLUR_INQ_LIST = 1010213;
	//权利品接收查询
	public static final int FUNC_CODE_GUA_RECEIVE_INQ = 1010214;
	//权利品移交查询
	public static final int FUNC_CODE_GUA_TRANSFER_INQ = 1010215;
	//权利品入库查询
	public static final int FUNC_CODE_GUA_STORAGE_INQ = 1010216;
	//权利品领取查询
	public static final int FUNC_CODE_GUA_DRAW_INQ = 1010217;
	//权利品领取审批查询
	public static final int FUNC_CODE_GUA_DRAW_APPROVE_INQ = 1010218;
	//权利品处理抵质押物查询
	public static final int FUNC_CODE_GUA_SETTLE_IMP_MORT_INQ = 1010219;
	//权利品上缴明细查询
	public static final int FUNC_CODE_GUA_INQ_DETAIL = 1010220;
	//权利品状态查询
	public static final int FUNC_CODE_GUA_STATUS_INQ = 1010221;
	//权利品状态查询抵制押查询
	public static final int FUNC_CODE_GUA_OPR_MORT = 1010222;
	//权利品联机置状态
	public static final int FUNC_CODE_GUA_SETTLE_ONLINE = 1010223;
	//权利品批量移交
	public static final int FUNC_CODE_GUA_BATCH_TRANSFER = 1010224;
	//权利品登记，分行档案管理岗
	public static final int FUNC_CODE_GUA_REG_BRANCH = 1010225;
    //权利品退回，分行档案管理岗
    public static final int FUNC_CODE_GUA_BACK = 1010226;
    //权利品补入库
	public static final int FUNC_CODE_GUA_RERUG = 1010227;

	/**档案管理的MQ交易
	 * 
	 */
	//代保管品记账MQ交易
	public static final int FUNC_CODE_CORE_COMM_ACCOUNT_ENTER = 1010301;
	//代保管品销账MQ交易
	public static final int FUNC_CODE_CORE_COMM_ACCOUNT_REMOVE = 1010302;
	//代保管品记帐抹帐MQ交易
	public static final int FUNC_CODE_CORE_COMM_ACCOUNT_ENTER_CANCEL = 1010303;
	//代保管品销账抹帐MQ交易
	public static final int FUNC_CODE_CORE_COMM_ACCOUNT_REMOVE_CANCEL = 1010304;

	/**
	 * 法人客户维护
	 */
	//法人客户建立查询
	public static final int FUNC_CODE_CORP_CUST_CREATE_QUERY = 1020101;
	//法人客户基本信息建立
	public static final int FUNC_CODE_CORP_CUST_BASE_INFO_CREATE = 1020102;
	//法人客户维护列表查询
	public static final int FUNC_CODE_CORP_CUST_MNTN_LST_QUERY = 1020103;
	//法人客户基本信息查询
	public static final int FUNC_CODE_CORP_CUST_BASE_INFO_QUERY = 1020104;
	//法人客户详细信息查询
	public static final int FUNC_CODE_CORP_CUST_EXT_INFO_QUERY = 1020105;
	//法人客户财务信息查询
	public static final int FUNC_CODE_CORP_CUST_FINANCE_INFO_QUERY = 1020106;
	//法人客户投资购成信息查询
	public static final int FUNC_CODE_CORP_CUST_INVEST_INFO_QUERY = 1020107;
	//法人客户大事信息查询
	public static final int FUNC_CODE_CORP_CUST_GREAT_EVENT_INFO_QUERY =
		1020108;
	//法人客户违规记录信息查询
	public static final int FUNC_CODE_CORP_CUST_INFRACT_INFO_QUERY = 1020109;
	//法人客户社会信用信息查询
	public static final int FUNC_CODE_CORP_CUST_CREDIT_INFO_QUERY = 1020110;
	//法人客户基本信息修改
	public static final int FUNC_CODE_CORP_CUST_BASE_INFO_MODIFY = 1020111;
	//法人客户详细信息修改
	public static final int FUNC_CODE_CORP_CUST_EXT_INFO_MODIFY = 1020112;
	//法人客户财务信息修改
	public static final int FUNC_CODE_CORP_CUST_FINANCE_INFO_MODIFY = 1020113;
	//法人客户投资购成信息修改
	public static final int FUNC_CODE_CORP_CUST_INVEST_INFO_MODIFY = 1020114;
	//法人客户大事信息修改
	public static final int FUNC_CODE_CORP_CUST_GREAT_EVENT_MODIFY = 1020115;
	//法人客户违规记录信息修改
	public static final int FUNC_CODE_CORP_CUST_INFRACT_INFO_MODIFY = 1020116;
	//法人客户社会信用信息修改
	public static final int FUNC_CODE_CORP_CUST_CREDIT_INFO_MODIFY = 1020117;
	//法人客户财务信息删除
	public static final int FUNC_CODE_CORP_CUST_FINANCE_INFO_DELETE = 1020118;
	//法人客户投资购成信息删除
	public static final int FUNC_CODE_CORP_CUST_INVEST_INFO_DELETE = 1020119;
	//法人大事信息删除
	public static final int FUNC_CODE_CORP_CUST_GREAT_EVENT_DELETE = 1020120;
	//合作商对公客户号修改 2006-06-09 Farly.yu
	public static final int FUNC_CODE_CORP_CUST_NO_MODIFY = 1020130;

	/**
	 * 法人客户大事信息删除
	 */
	//法人客户违规记录信息删除
	public static final int FUNC_CODE_CORP_CUST_INFRACT_INFO_DELETE = 1020121;
	//法人客户社会信用信息删除
	public static final int FUNC_CODE_CORP_CUST_CREDIT_INFO_DELETE = 1020122;
	//法人客户财务信息列表查询
	public static final int FUNC_CODE_CORP_CUST_FINANCE_LST_QUERY = 1020123;
	//法人客户投资购成信息列表查询
	public static final int FUNC_CODE_CORP_CUST_INVEST_LST_QUERY = 1020124;
	//法人客户大事信息列表查询
	public static final int FUNC_CODE_CORP_CUST_GREAT_EVENT_LST_QUERY = 1020125;
	//法人客户违规记录信息列表查询
	public static final int FUNC_CODE_CORP_CUST_INFRACT_LST_QUERY = 1020126;
	//法人客户社会信用信息列表查询
	public static final int FUNC_CODE_CORP_CUST_CREDIT_LST_QUERY = 1020127;
	//法人客户删除
	public static final int FUNC_CODE_CORP_CUST_DELETE = 1020128;
	//保险公司业务信息查询
	public static final int FUNC_CODE_INSURANCE_BIZ_QUERY = 1020129;

	/**
	 * 合作项目
	 */
	//合作项目建立客户列表查询
	public static final int FUNC_CODE_COOP_PROJ_CREATE_CUSTLST_QUERY = 1020301;
	//合作项目基本信息建立
	public static final int FUNC_CODE_COOP_PROJ_BASE_INFO_CREATE = 1020302;
	//合作项目购房贷款信息修改
	public static final int FUNC_CODE_COOP_PROJ_HOUSE_INFO_MODIFY = 1020354;
	//合作项目汽车信息信息建立
	public static final int FUNC_CODE_COOP_PROJ_AUTO_INFO_CREATE = 1020303;
	//合作项目助学贷款信息建立
	public static final int FUNC_CODE_COOP_PROJ_EDU_INFO_CREATE = 1020304;
	//合作项目旅游贷款信息建立
	public static final int FUNC_CODE_COOP_PROJ_TOUR_INFO_CREATE = 1020305;
	//合作项目耐用消费品贷款信息建立
	public static final int FUNC_CODE_COOP_PROJ_CON_INFO_CREATE = 1020306;
	//合作项目基本信息查询
	public static final int FUNC_CODE_COOP_PROJ_BASE_INFO_QUERY = 1020307;
	//合作项目购房贷款信息查询
	public static final int FUNC_CODE_COOP_PROJ_HOUSE_INFO_QUERY = 1020308;
	//合作项目汽车信息信息查询
	public static final int FUNC_CODE_COOP_PROJ_AUTO_INFO_QUERY = 1020309;
	//合作项目助学贷款信息查询
	public static final int FUNC_CODE_COOP_PROJ_EDU_INFO_QUERY = 1020310;
	//合作项目旅游贷款信息查询
	public static final int FUNC_CODE_COOP_PROJ_TOUR_INFO_QUERY = 1020311;
	//合作项目耐用消费品贷款信息查询
	public static final int FUNC_CODE_COOP_PROJ_CON_INFO_QUERY = 1020312;
	//合作项目基本信息修改
	public static final int FUNC_CODE_COOP_PROJ_BASE_INFO_MODIFY = 1020313;
	//合作项目汽车信息信息修改
	public static final int FUNC_CODE_COOP_PROJ_AUTO_INFO_MODIFY = 1020314;
	//合作项目助学贷款信息修改
	public static final int FUNC_CODE_COOP_PROJ_EDU_INFO_MODIFY = 1020315;
	//合作项目旅游贷款信息修改
	public static final int FUNC_CODE_COOP_PROJ_TOUR_INFO_MODIFY = 1020316;
	//合作项目耐用消费品贷款信息修改
	public static final int FUNC_CODE_COOP_PROJ_CON_INFO_MODIFY = 1020317;
	//合作项目汽车信息信息删除
	public static final int FUNC_CODE_COOP_PROJ_AUTO_INFO_DELETE = 1020318;
	//合作项目助学贷款信息删除
	public static final int FUNC_CODE_COOP_PROJ_EDU_INFO_DELETE = 1020319;
	//合作项目旅游贷款信息删除
	public static final int FUNC_CODE_COOP_PROJ_TOUR_INFO_DELETE = 1020320;
	//合作项目耐用消费品贷款信息删除
	public static final int FUNC_CODE_COOP_PROJ_CON_INFO_DELETE = 1020321;
	//合作项目汽车信息信息列表查询
	public static final int FUNC_CODE_COOP_PROJ_AUTO_LIST_QUERY = 1020322;
	//合作项目助学贷款信息列表查询
	public static final int FUNC_CODE_COOP_PROJ_EDU_LIST_QUERY = 1020323;
	//合作项目旅游贷款信息列表查询
	public static final int FUNC_CODE_COOP_PROJ_TOUR_LIST_QUERY = 1020324;
	//合作项目耐用消费品贷款信息列表查询
	public static final int FUNC_CODE_COOP_PROJ_CON_LIST_QUERY = 1020325;
	//合作项目上传
	public static final int FUNC_CODE_COOP_PROJ_WF_APPLY = 1020326;
	//合作项目审查
	public static final int FUNC_CODE_COOP_PROJ_WF_AUDIT = 1020328;
	//合作项目审批
	public static final int FUNC_CODE_COOP_PROJ_WF_APPROVE = 1020329;
	//合作项目中止上传
	public static final int FUNC_CODE_COOP_PROJ_TERM_WF_APPLY = 1020330;
	//合作项目中止审查
	public static final int FUNC_CODE_COOP_PROJ_TERM_WF_AUDIT = 1020331;
	//合作项目中止审批
	public static final int FUNC_CODE_COOP_PROJ_TERM_WF_APPROVE = 1020332;
	//合作项目退回修改
	public static final int FUNC_CODE_COOP_PROJ_WF_MODIFY = 1020333;
	//合作项目审查工作项查询
	public static final int FUNC_CODE_COOP_PROJ_WF_AUDIT_LST_QUERY = 1020334;
	//合作项目审批工作项查询
	public static final int FUNC_CODE_COOP_PROJ_WF_APPROVE_LST_QUERY = 1020335;
	//合作项目中止上传工作项查询
	public static final int FUNC_CODE_COOP_PROJ_TERM_WF_APPLY_LST_QUERY =
		1020336;
	//合作项目中止审查工作项查询
	public static final int FUNC_CODE_COOP_PROJ_TERM_WF_AUDIT_LST_QUERY =
		1020337;
	//合作项目中止审批工作项查询
	public static final int FUNC_CODE_COOP_PROJ_TERM_WF_APPROVE_LST_QUERY =
		1020338;
	//合作项目退回修改工作项查询
	public static final int FUNC_CODE_COOP_PROJ_WF_MODIFY_LST_QUERY = 1020339;
	//合作项目审查声明
	public static final int FUNC_CODE_COOP_PROJ_WF_AUDIT_CLAIM = 1020340;
	//合作项目审批声明
	public static final int FUNC_CODE_COOP_PROJ_WF_APPROVE_CLAIM = 1020341;
	//合作项目中止审查声明
	public static final int FUNC_CODE_COOP_PROJ_TERM_WF_AUDIT_CLAIM = 1020342;
	//合作项目中止审批声明
	public static final int FUNC_CODE_COOP_PROJ_TERM_WF_APPROVE_CLAIM = 1020343;
	//合作项目退回修改声明
	public static final int FUNC_CODE_COOP_PROJ_WF_MODIFY_CLAIM = 1020344;
	//合作项目审查取消声明
	public static final int FUNC_CODE_COOP_PROJ_WF_AUDIT_CANCEL = 1020345;
	//合作项目审批取消声明
	public static final int FUNC_CODE_COOP_PROJ_WF_APPROVE_CANCEL = 1020346;
	//合作项目中止审查取消声明
	public static final int FUNC_CODE_COOP_PROJ_TERM_WF_AUDIT_CANCEL = 1020347;
	//合作项目中止审批取消声明
	public static final int FUNC_CODE_COOP_PROJ_TERM_WF_APPROVE_CANCEL =
		1020348;
	//合作项目退回修改取消声明
	public static final int FUNC_CODE_COOP_PROJ_WF_MODIFY_CANCEL = 1020349;
	//合作项目上传列表查询
	public static final int FUNC_CODE_COOP_PROJ_APPLY_LST_QUERY = 1020350;
	//合作项目中止列表查询
	public static final int FUNC_CODE_COOP_PROJ_TERM_LST_QUERY = 1020351;
	//合作项目维护列表查询
	public static final int FUNC_CODE_COOP_PROJ_MNT_LST_QUERY = 1020352;
	//合作项目查询
	public static final int FUNC_CODE_COOP_PROT_INFO_QUERY = 1020353;

	//合作协议上传
	public static final int FUNC_CODE_COOP_PROT_WF_APPLY = 1020401;
	//合作协议审查
	public static final int FUNC_CODE_COOP_PROT_WF_AUDIT = 1020402;
	//合作协议审批
	public static final int FUNC_CODE_COOP_PROT_WF_APPROVE = 1020403;
	//合作协议中止上传
	public static final int FUNC_CODE_COOP_PROT_TERM_WF_APPLY = 1020404;
	//合作协议中止审查
	public static final int FUNC_CODE_COOP_PROT_TERM_WF_AUDIT = 1020405;
	//合作协议中止审批
	public static final int FUNC_CODE_COOP_PROT_TERM_WF_APPROVE = 1020406;
	//合作协议退回修改
	public static final int FUNC_CODE_COOP_PROT_WF_MODIFY = 1020408;
	//合作协议审查工作项查询
	public static final int FUNC_CODE_COOP_PROT_WF_AUDIT_LST_QUERY = 1020409;
	//合作协议审批工作项查询
	public static final int FUNC_CODE_COOP_PROT_WF_APPROVE_LST_QUERY = 1020410;
	//合作协议中止上传工作项查询
	public static final int FUNC_CODE_COOP_PROT_TERM_WF_APPLY_LST_QUERY =
		1020411;
	//合作协议中止审查工作项查询
	public static final int FUNC_CODE_COOP_PROT_TERM_WF_AUDIT_LST_QUERY =
		1020412;
	//合作协议中止审批工作项查询
	public static final int FUNC_CODE_COOP_PROT_TERM_WF_APPROVE_LST_QUERY =
		1020413;
	//合作协议退回修改工作项查询
	public static final int FUNC_CODE_COOP_PROT_WF_MODIFY_LST_QUERY = 1020414;
	//合作协议审查声明
	public static final int FUNC_CODE_COOP_PROT_WF_AUDIT_CLAIM = 1020415;
	//合作协议审批声明
	public static final int FUNC_CODE_COOP_PROT_WF_APPROVE_CLAIM = 1020416;
	//合作协议中止审查声明
	public static final int FUNC_CODE_COOP_PROT_TERM_WF_AUDIT_CLAIM = 1020417;
	//合作协议中止审批声明
	public static final int FUNC_CODE_COOP_PROT_TERM_WF_APPROVE_CLAIM = 1020418;
	//合作协议退回修改声明
	public static final int FUNC_CODE_COOP_PROT_WF_MODIFY_CLAIM = 1020419;
	//合作协议审查取消声明
	public static final int FUNC_CODE_COOP_PROT_WF_AUDIT_CANCEL = 1020420;
	//合作协议审批取消声明
	public static final int FUNC_CODE_COOP_PROT_WF_APPROVE_CANCEL = 1020421;
	//合作协议中止审查取消声明
	public static final int FUNC_CODE_COOP_PROT_TERM_WF_AUDIT_CANCEL = 1020422;
	//合作协议中止审批取消声明
	public static final int FUNC_CODE_COOP_PROT_TERM_WF_APPROVE_CANCEL =
		1020423;
	//合作协议退回修改取消声明
	public static final int FUNC_CODE_COOP_PROT_WF_MODIFY_CANCEL = 1020424;
	//合作协议上传列表查询
	public static final int FUNC_CODE_COOP_PROT_APPLY_LST_QUERY = 1020425;
	//合作协议中止列表查询
	public static final int FUNC_CODE_COOP_PROT_TERM_LST_QUERY = 1020426;


	
	
	
	/**
	 * 自然人交易
	 */
	//自然人基本信息建立
	public static final int FUNC_CODE_CUSTINDV_BASE_CREATE = 1030101;
	//自然人基本信息建立查询
	public static final int FUNC_CODE_CUSTINDV_BASE_CREATE_QUERY = 1030102;
	//自然人基本信息删除
	public static final int FUNC_CODE_CUSTINDV_BASE_DELETE = 1030103;
	//自然人基本信息修改
	public static final int FUNC_CODE_CUSTINDV_BASE_MODIFY = 1030104;
	//自然人基本信息列表查询
	public static final int FUNC_CODE_CUSTINDV_QUERY_BLUR = 1030105;
	//自然人基本信息精确查询
	public static final int FUNC_CODE_CUSTINDV_QUERY_EXACT = 1030106;
	//自然人经营财务信息建立
	public static final int FUNC_CODE_CUSTINDV_MANAGE_CREATE = 1030107;
	//自然人经营财务信息查询
	public static final int FUNC_CODE_CUSTINDV_MANAGE_QUERY = 1030108;
	//自然人经营财务信息修改
	public static final int FUNC_CODE_CUSTINDV_MANAGE_MODIFY = 1030109;
	//自然人经营财务信息删除
	public static final int FUNC_CODE_CUSTINDV_MANAGE_DELETE = 1030110;
	//自然人家庭财务信息建立
	public static final int FUNC_CODE_CUSTINDV_HOME_CREATE = 1030111;
	//自然人家庭财务信息查询
	public static final int FUNC_CODE_CUSTINDV_HOME_QUERY = 1030112;
	//自然人家庭财务信息修改
	public static final int FUNC_CODE_CUSTINDV_HOME_MODIFY = 1030113;
	//自然人家庭财务信息删除
	public static final int FUNC_CODE_CUSTINDV_HOME_DELETE = 1030114;
	//自然人大事记建立
	public static final int FUNC_CODE_CUSTINDV_GREAT_CREATE = 1030115;
	//自然人大事记查询
	public static final int FUNC_CODE_CUSTINDV_GREAT_QUERY = 1030116;
	//自然人大事记修改
	public static final int FUNC_CODE_CUSTINDV_GREAT_MODIFY = 1030117;
	//自然人大事记删除
	public static final int FUNC_CODE_CUSTINDV_GREAT_DELETE = 1030118;
	//自然人违规记录建立
	public static final int FUNC_CODE_CUSTINDV_INFRAC_CREATE = 1030119;
	//自然人违规记录查询
	public static final int FUNC_CODE_CUSTINDV_INFRAC_QUERY = 1030120;
	//自然人违规记录修改
	public static final int FUNC_CODE_CUSTINDV_INFRAC_MODIFY = 1030121;
	//自然人违规记录删除
	public static final int FUNC_CODE_CUSTINDV_INFRAC_DELETE = 1030122;
	//自然人信用评估建立、修改
	public static final int FUNC_CODE_CUSTINDV_CREDIT = 1030123;
	//自然人信用评估查询
	public static final int FUNC_CODE_CUSTINDV_CREDIT_QUERY = 1030124;
	//自然人配偶信息建立或修改
	public static final int FUNC_CODE_CUSTINDV_MARRY = 1030125;
	//自然人配偶信息查询
	public static final int FUNC_CODE_CUSTINDV_MARRY_QUERY = 1030126;
	//自然人配偶信息查询
	public static final int FUNC_CODE_CUSTINDV_MARRY_QUERY_BUTTON = 1030127;
	//自然人基本信息恢复
	public static final int FUNC_CODE_CUSTINDV_BASE_RESUME = 1030128;
	//自然人基本信息同步查询
	public static final int FUNC_CODE_CUSTINDV_SYNCH_QUERY = 1030129;
	//自然人基本信息同步
	public static final int FUNC_CODE_CUSTINDV_SYNCH = 1030130;


	/**
	 * 参贷人信息
	 */
	//参贷人信息列表查询
	public static final int FUNC_CODE_LA_PARTLIST_QUERY = 1030141;
	//参贷人信息建立
	public static final int FUNC_CODE_LA_PART_CREATE = 1030142;
	//参贷人信息修改
	public static final int FUNC_CODE_LA_PART_MODIFY = 1030143;
	//参贷人信息删除
	public static final int FUNC_CODE_LA_PART_DELETE = 1030144;
	//参贷人信息明细查询
	public static final int FUNC_CODE_LA_PART_QUERY = 1030145;

	//助学贷款催收销账确认
	public static final int FUNC_CODE_EDUCOLLECT_CONFIRM = 1030151;
	//助学贷款查询打印催收通知单
	public static final int FUNC_CODE_EDUCOLLECT_LIST_PRINT = 1030152;
	//助学贷款查询催收销账合计
	public static final int FUNC_CODE_EDUCOLLECT_QUERY_TOT =1030153;
	//助学贷款打印催收通知单
	public static final int FUNC_CODE_EDUCOLLECT_PRINT=1030154;
	//助学贷款催收销账模糊查询
	public static final int FUNC_CODE_EDUCOLLECT_QUERY=1030155;
	//助学贷款催收入账确认
	public static final int FUNC_CODE_EDUCOLLECT_APPC=1030156;
	//助学贷款催收入账抹账
	public static final int FUNC_CODE_EDUCOLLECT_CANCEL=1030157;
	
	/*
	 * 下岗失业贷款贴息催收
	 */
	
	//下岗失业贷款贴息催收
	public static final int FUNC_CODE_LOSTJOBCOLLECT_DUN_QUERY = 1030158;
	//下岗失业贷款贴息催收通知单
	public static final int FUNC_CODE_LOSTJOBCOLLECT_DUN_PRINT = 1030159;
	//下岗失业贷款贴息催收销账APPC
	public static final int FUNC_CODE_LOSTJOBCOLLECT_APPC =1030160;
	//下岗失业贷款贴息催收销账模糊查询
	public static final int FUNC_CODE_LOSTJOBCOLLECT_QUERY = 1030161;
	//下岗失业贷款贴息催收通知单
	public static final int FUNC_CODE_LOSTJOBCOLLECT_LIST_PRINT = 1030162;
	//下岗失业贷款贴息催收入账确认
	public static final int FUNC_CODE_LOSTJOBCOLLECT_CONFIRM =1030163;
	//下岗失业贷款贴息催收入账抹账
	public static final int FUNC_CODE_LOSTJOBCOLLECT_CANCEL=1030164;
	
	/**
	 * 贷款公共交易
	 */
	//贷款模糊查询定位
	public static final int FUNC_CODE_LOAN_POSITION = 1040701;
	//查询贷款基本信息
	public static final int FUNC_CODE_SHOW_LOAN_BASIC_INFO = 1040702;
	//查询贷款申请审批任务列表
	public static final int FUNC_CODE_QUERY_LOAN_APP_TASK_LIST = 1040703;
	//查询贷后审批任务列表
	public static final int FUNC_CODE_QUERY_POST_LOAN_TASK_LIST = 1040704;
	//主机收费交易
	public static final int FUNC_CODE_CORE_CHARGE = 1040705;
	//主机收费抹帐
	public static final int FUNC_CODE_CORE_CHARGE_CANCEL = 1040706;
	//审查审批历史查询
	public static final int FUNC_CODE_APPLY_DTL_QUERY = 1040707;	

	/**
	 * 贷款申请
	 */
	//普通贷款申请入口
	public static final int FUNC_CODE_LA_COMMLOAN_ENTRY = 1040101;
	//普通贷款申请资料建立
	public static final int FUNC_CODE_LA_COMMLOAN_CREATE = 1040102;
	//普通贷款申请资料修改
	public static final int FUNC_CODE_LA_COMMLOAN_MODIFY = 1040103;
	//贷款上传           
	public static final int FUNC_CODE_LA_SENDED = 1040105;
	//贷款申请检查
	public static final int FUNC_CODE_LA_LOANAPPLY_CHECK = 1040106;
	//还款账号检查
	public static final int FUNC_CODE_LA_ACCOUNT_GET = 1040107;

	//组合贷款申请入口
	public static final int FUNC_CODE_LA_COMBLOAN_ENTRY = 1040111;
	//组合贷款申请资料建立
	public static final int FUNC_CODE_LA_COMBLOAN_CREATE = 1040112;
	//组合贷款申请资料修改
	public static final int FUNC_CODE_LA_COMBLOAN_MODIFY = 1040113;
	//组合贷款抵押合同信息建立
	public static final int FUNC_CODE_LA_COMBLOAN_MORT_CREATE = 1040114;
	//组合贷款抵押合同信息修改
	public static final int FUNC_CODE_LA_COMBLOAN_MORT_MODIFY = 1040115;
	//加按贷款申请入口
	public static final int FUNC_CODE_LA_ADDLOAN_ENTRY = 1040121;
	//加按贷款申请资料建立
	public static final int FUNC_CODE_LA_ADDLOAN_CREATE = 1040122;
	//加按贷款申请资料修改
	public static final int FUNC_CODE_LA_ADDLOAN_MODIFY = 1040123;
	//转按贷款申请入口
	public static final int FUNC_CODE_LA_RELOAN_ENTRY = 1040131;
	//转按贷款申请资料建立
	public static final int FUNC_CODE_LA_RELOAN_CREATE = 1040132;
	//转按贷款申请资料修改
	public static final int FUNC_CODE_LA_RELOAN_MODIFY = 1040133;

	//展期申请入口                      
	public static final int FUNC_CODE_LA_EXTEND_LOAN_ENTRY = 1040141;
	//展期申请资料建立                  
	public static final int FUNC_CODE_LA_EXTEND_LOAN_CREATE = 1040142;
	//展期申请资料修改                  
	public static final int FUNC_CODE_LA_EXTEND_LOAN_MODIFY = 1040143;
	//多次发放申请入口                  
	public static final int FUNC_CODE_LA_MULTI_GRANT_ENTRY = 1040151;
	//多次发放申请资料建立              
	public static final int FUNC_CODE_LA_MULTI_GRANT_CREATE = 1040152;
	//多次发放申请资料修改              
	public static final int FUNC_CODE_LA_MULTI_GRANT_MODIFY = 1040153;
	
	//助学贷款离校期申请入口
	public static final int FUNC_CODE_LA_EDUAFTER_ENTRY = 1040161;
	//助学贷款离校期申请资料建立
	public static final int FUNC_CODE_LA_EDUAFTER_CREATE = 1040162;
	//助学贷款离校期申请资料修改
	public static final int FUNC_CODE_LA_EDUAFTER_MODIFY = 1040163;

	//贷款审查           
	public static final int FUNC_CODE_LA_AUDIT = 1040201;
	//贷款审批           
	public static final int FUNC_CODE_LA_APPROVE = 1040202;
	//贷款终审发放(首次) 
	public static final int FUNC_CODE_LA_FIRST_GRANT = 1040203;
	//贷款发放(非首次放款)
	public static final int FUNC_CODE_LA_GRANT = 1040204;
	//贷款发放撤销
	public static final int FUNC_CODE_LA_CANCEL = 1040205;
	//贷款退回修改
	public static final int FUNC_CODE_LA_UPDATE = 1040206;
	//待上传合同列表查询                
	public static final int FUNC_CODE_LA_LOAN_SUBMITLIST_QUERY = 1040207;
	//贷款审查审批详细信息查询        
	public static final int FUNC_CODE_LA_LOAN_LOAN_AUTHDTL_QUERY = 1040208;
	//贷款发放撤销                      
	public static final int FUNC_CODE_LA_LOAN_RETRACT = 1040209;
	//贷款发放再申请列表查询            
	public static final int FUNC_CODE_LA_REGRANT_LIST_QUERY = 1040210;
	//贷款再次发放                      
	public static final int FUNC_CODE_LA_REGRANT_APPROVE = 1040211;
	//贷款申请工作项取消声明
	public static final int FUNC_CODE_LA_CANCEL_WOREITEM = 1040212;
	//贷款申请工作项申明
	public static final int FUNC_CODE_LA_CLAIM_WOREITEM = 1040213;
	//贷款申请工作项查询
	public static final int FUNC_CODE_LA_QUERY_WORK_ITEM = 1040214;
	//贷款发放撤销入口
	public static final int FUNC_CODE_LA_LOAN_RETRACT_ENTRY = 1040215;
	//
	public static final int FUNC_CODE_LA_GRANT_TYPE_QUERY = 1040216;
	//合作协议信息建立
	public static final int FUNC_CODE_COOP_PROT_INFO_CREATE = 1020427;
	//合作协议建立客户列表查询
	public static final int FUNC_CODE_COOP_PROT_CREATE_CUSTLST_QUERY = 1020428;
	//合作协议修改
	public static final int FUNC_CODE_COOP_PROT_INFO_MODIFY = 1020429;
	//合作协议维护列表查询
	public static final int FUNC_CODE_COOP_PROT_MNTN_LIST_QUERY = 1020430;

	//保险费用结算
	public static final int FUNC_CODE_INSURANCE_FEE = 1040301;
	//录入保单信息
	public static final int FUNC_CODE_INSURANCE_INPUT = 1040302;
	//保险精确查询
	public static final int FUNC_CODE_INSURANCE_QUERY = 1040303;
	//保险模糊查询定位
	public static final int FUNC_CODE_INSURANCE_QUERY_LIST = 1040304;
	//保险查询打印
	public static final int FUNC_CODE_INSURANCE_PRINT_LIST = 1040305;

	//办理抵押资料录入提交
	public static final int FUNC_CODE_MORTAGAGE_INPUT = 1040311;
	//抵押精确查询
	public static final int FUNC_CODE_MORTAGAGE_QUERY = 1040312;
	//办理抵押模糊查询定位
	public static final int FUNC_CODE_MORTAGAGE_QUERY_LIST = 1040313;
	//办理抵押提交
	public static final int FUNC_CODE_MORTAGAGE_SUBMIT = 1040314;
	//抵押未成功提交
	public static final int FUNC_CODE_MORTAGAGE_SUBMIT_FAIL = 1040315;
	//抵押成功提交
	public static final int FUNC_CODE_MORTAGAGE_SUBMIT_SUCCESS = 1040316;

	//办理公证资料录入提交
	public static final int FUNC_CODE_NOTARIZATION_INPUT = 1040321;
	//办理公证资料录入模糊查询定位
	public static final int FUNC_CODE_NOTARIZATION_INOUT_QUERY_LIST = 1040322;
	//公证精确查询
	public static final int FUNC_CODE_NOTARIZATION_QUERY = 1040323;
	//办理公证模糊查询定位
	public static final int FUNC_CODE_NOTARIZATION_QUERY_LIST = 1040324;
	//办理公证送交
	public static final int FUNC_CODE_NOTARIZATION_SUBMIT = 1040325;
	//公证收回的公证未成功提交
	public static final int FUNC_CODE_NOTARIZATION_SUBMIT_SUCCESS = 1040326;
	//公证收回的公证成功提交
	public static final int FUNC_CODE_NOTARIZATION_SUBMIT_FAIL = 1040327;
	//公证信息查询
	public static final int FUNC_CODE_NOTARIZATION_QUERY_FOR_MODIFY = 1040328;
	//公证信息修改
	public static final int FUNC_CODE_NOTARIZATION_MODIFY = 1040329;

	//授信额度信息增加
	public static final int FUNC_CODE_CREDIT_CREATE = 1040401;
	//授信额度信息查询
	public static final int FUNC_CODE_CREDIT_QUERY = 1040402;
	//授信额度信息修改
	public static final int FUNC_CODE_CREDIT_MODIFY = 1040403;
	//授信额度保证人信息增加
	public static final int FUNC_CODE_CREDIT_ASSU_CREATE = 1040404;
	//授信额度保证人信息删除
	public static final int FUNC_CODE_CREDIT_ASSU_DELETE = 1040405;
	//授信额度保证人信息查询
	public static final int FUNC_CODE_CREDIT_ASSU_QUERY = 1040406;
	//授信额度保证人信息修改
	public static final int FUNC_CODE_CREDIT_ASSU_MODIFY = 1040407;
	//授信额度抵押信息增加
	public static final int FUNC_CODE_CREDIT_MORT_CREATE = 1040408;
	//授信额度抵押信息删除
	public static final int FUNC_CODE_CREDIT_MORT_DELETE = 1040409;
	//授信额度抵押信息查询
	public static final int FUNC_CODE_CREDIT_MORT_QUERY = 1040410;
	//授信额度抵押信息修改
	public static final int FUNC_CODE_CREDIT_MORT_MODIFY = 1040411;
	//授信额度质押信息增加
	public static final int FUNC_CODE_CREDIT_IMPAWN_CREATE = 1040412;
	//授信额度质押信息删除
	public static final int FUNC_CODE_CREDIT_IMPAWN_DELETE = 1040413;
	//授信额度质押信息查询
	public static final int FUNC_CODE_CREDIT_IMPAWN_QUERY = 1040414;
	//授信额度质押信息修改
	public static final int FUNC_CODE_CREDIT_IMPAWN_MODIFY = 1040415;
	//授信额度申请资料检查
	public static final int FUNC_CODE_CREDIT_CHECKINFO = 1040416;
	//授信额度申请上传
	public static final int FUNC_CODE_CREDIT_UPLOAD = 1040417;
	//授信额度申请审查
	public static final int FUNC_CODE_CREDIT_AUDIT = 1040418;
	//授信额度质押审批
	public static final int FUNC_CODE_CREDIT_APPROVE = 1040419;
	//授信额度质押终审
	public static final int FUNC_CODE_CREDIT_LAST_APPROVE = 1040420;
	//授信额度质押退回修改
	public static final int FUNC_CODE_CREDIT_REJECT_MODIFY = 1040421;
	//授信额度收回申请
	public static final int FUNC_CODE_CREDIT_REVOKE_APPLY = 1040422;
	//授信额度收回审批
	public static final int FUNC_CODE_CREDIT_REVOKE_APPROVE = 1040423;
	//授信额度缩减申请
	public static final int FUNC_CODE_CREDIT_DECREASE_APPLY = 1040424;
	//授信额度缩减审批
	public static final int FUNC_CODE_CREDIT_DECREASE_APPROVE = 1040425;
	//授信额度冻结申请
	public static final int FUNC_CODE_CREDIT_FREEZE_APPLY = 1040426;
	//授信额度冻结审批
	public static final int FUNC_CODE_CREDIT_FREEZE_APPROVE = 1040427;
	//授信额度解冻申请
	public static final int FUNC_CODE_CREDIT_UNFREEZE_APPLY = 1040428;
	//授信额度解冻审批
	public static final int FUNC_CODE_CREDIT_UNFREEZE_APPROVE = 1040429;
	//授信额度循环贷款信息查询
	public static final int FUNC_CODE_CREDIT_LOANINFO_QUERY = 1040430;
	//授信额度申请打印
	public static final int FUNC_CODE_CREDIT_APPLY_PRINT = 1040431;
	//授信额度工作流申明
	public static final int FUNC_CODE_CREDIT_CLAIM = 1040432;
	//授信额度工作流申明取消
	public static final int FUNC_CODE_CREDIT_CLAIM_CANCLE = 1040433;
	//授信额度本地修复
	public static final int FUNC_CODE_CREDIT_RESTORE = 1040434;
    //授信交易补打凭证
	public static final int FUNC_CODE_CREDIT_PRINT = 1040435;

	
	//银信通
	public static final int FUNC_CODE_BANK_SMS = 1040500;
	//银信通管理
	public static final int FUNC_CODE_BANK_SMS_MNG = 1040501;
	//银信通管理查询
	public static final int FUNC_CODE_BANK_SMS_MNG_INQ = 1040502;
	//银信通管理维护
	public static final int FUNC_CODE_BANK_SMS_MNG_MODIFY = 1040503;

	//MQ展期管理类
	//普通贷款展期
	public static final int FUNC_CODE_CORE_COMMLOAN_EXTEND = 1040801;
	//小额质押贷款展期
	public static final int FUNC_CODE_CORE_LITTLE_LOAN_IMPAWN_EXTEND = 1040802;
	//外汇宝质押贷款展期
	public static final int FUNC_CODE_CORE_WHBLOAN_EXTEND = 1040803;

	//MQ放款类
	//普通贷款首次会计发放
	public static final int FUNC_CODE_CORE_COMM_LOAN_FIRST_GRANT = 1040804;
	//普通贷款首次会计抹帐
	public static final int FUNC_CODE_CORE_COMM_LOAN_FIRST_CANCEL = 1040805;
	//普通贷款首次会计冲帐
	public static final int FUNC_CODE_CORE_COMM_LOAN_FIRST_REVERSE = 1040806;
	//普通贷款非首次会计发放
	public static final int FUNC_CODE_CORE_COMM_LOAN_NO_FIRST_GRANT = 1040807;
	//普通贷款非首次会计抹帐
	public static final int FUNC_CODE_CORE_COMM_LOAN_NO_FIRST_CANCEL = 1040808;
	//柜面循环贷款发放
	public static final int FUNC_CODE_CORE_COUNTER_CIRCLE_LOAN_GRANT = 1040809;
	//柜面循环贷款发放抹帐
	public static final int FUNC_CODE_CORE_COUNTER_CIRCLE_LOAN_CANCEL = 1040810;
	//自助循环贷款发放
	public static final int FUNC_CODE_CORE_SELF_CIRCLE_LOAN_GRANT = 1040811;
	//柜面小额质押贷款发放
	public static final int FUNC_CODE_CORE_COUNTER_LITTLE_LOAN_IMPAWN_GRANT =
		1040812;
	//柜面小额质押贷款抹帐
	public static final int FUNC_CODE_CORE_COUNTER_LITTLE_LOAN_IMPAWN_CANCEL =
		1040813;
	//柜面小额质押贷款冲帐
	public static final int FUNC_CODE_CORE_COUNTER_LITTLE_LOAN_IMPAWN_REVERSE =
		1040814;
	//自助小额质押贷款发放
	public static final int FUNC_CODE_CORE_SELF_LITTLE_LOAN_IMPAWN_GRANT =
		1040815;
	//外汇宝质押贷款发放
	public static final int FUNC_CODE_CORE_WHB_LOAN_IMPAWN_GRANT = 1040816;
	//外汇宝小额质押贷款抹帐
	public static final int FUNC_CODE_CORE_WHB_LOAN_IMPAWN_CANCEL = 1040817;
	//外汇宝质押贷款冲帐
	public static final int FUNC_CODE_CORE_WHB_LOAN_IMPAWN_REVERSE = 1040818;
	//代理公积金贷款发放
	public static final int FUNC_CODE_CORE_AT_FUND_PAY = 1040819;
	//代理公积金贷款发放抹帐
	public static final int FUNC_CODE_CORE_AT_FUND_PAY_CANCEL = 1040820;

	//贷款合作商查询
	public static final int FUNC_CODE_LA_COOPQUERY = 1040901;
	//合作商信息关联建立
	public static final int FUNC_CODE_LA_COOPCREATE = 1040902;
	//合作商信息关联修改
	public static final int FUNC_CODE_LA_COOPMODIFY = 1040903;
	//合作项目明细信息建立
	public static final int FUNC_CODE_LA_PJTDTL_CREATE = 1040904;
	//合作项目明细信息修改
	public static final int FUNC_CODE_LA_PJTDTL_MODIFY = 1040905;
	//合作项目明细信息查询
	public static final int FUNC_CODE_LA_PJTDTL_QUERY = 1040906;
	//贷款保证合同列表查询
	public static final int FUNC_CODE_LA_ASSLIST_QUERY = 1040907;
	//担保合同信息建立
	public static final int FUNC_CODE_LA_ASS_CREATE = 1040908;
	//担保合同信息修改
	public static final int FUNC_CODE_LA_ASS_MODIFY = 1040909;
	//担保合同信息删除
	public static final int FUNC_CODE_LA_ASS_DELETE = 1040910;
	//担保合同信息查询
	public static final int FUNC_CODE_LA_ASS_QUERY = 1040911;
	//贷款抵押合同列表查询
	public static final int FUNC_CODE_LA_MORTLIST_QUERY = 1040912;
	//抵押合同信息建立
	public static final int FUNC_CODE_LA_MORT_CREATE = 1040913;
	//抵押合同信息修改
	public static final int FUNC_CODE_LA_MORT_MODIFY = 1040914;
	//抵押合同信息删除
	public static final int FUNC_CODE_LA_MORT_DELETE = 1040915;
	//抵押合同信息查询
	public static final int FUNC_CODE_LA_MORT_QUERY = 1040916;
	//贷款质押合同列表查询
	public static final int FUNC_CODE_LA_IMPAWNLIST_QUERY = 1040917;
	//质押合同信息建立
	public static final int FUNC_CODE_LA_IMPAWN_CREATE = 1040918;
	//质押合同信息修改
	public static final int FUNC_CODE_LA_IMPAWN_MODIFY = 1040919;
	//质押合同信息删除
	public static final int FUNC_CODE_LA_IMPAWN_DELETE = 1040920;
	//质押合同信息查询
	public static final int FUNC_CODE_LA_IMPAWN_QUERY = 1040921;
	//贷款申请资料查询 
	public static final int FUNC_CODE_LA_LOANAPPLY_QUERY = 1040922;
	//贷款查询 
	public static final int FUNC_CODE_LA_LOANQUERY_ENTRY = 1040923;
	//贷款移交查询 
	public static final int FUNC_CODE_DEVOLVE_LOAN_LIST = 1040924;
	// 贷款单笔移交
	public static final int FUNC_CODE_DEVOLVE_LOAN_SINGLE = 1040925;
	// 贷款全部移交
	public static final int FUNC_CODE_DEVOLVE_LOAN_ALL = 1040926;
	// 收费查询
	public static final int FUNC_CODE_LOAN_FEE_LIST_QUERY = 1040927;
	// 贷款合同查询
	public static final int FUNC_CODE_LOAN_CONTRACTDTL_QUERY = 1040928;
	// 贷款关联合同查询
	public static final int FUNC_CODE_LA_RELATIVE_LOAN_LIST_QUERY = 1040929;
	//合同贴息表查询
	public static final int FUNC_CODE_LOAN_SUBSIDY_INFO_QUERY = 1040930;
	//新建合同贴息新纪录
	public static final int FUNC_CODE_LOAN_SUBSIDY_INFO_CREATE = 1040931;
	//修改合同贴息记录
	public static final int FUNC_CODE_LOAN_SUBSIDY_INFO_MODIFY = 1040932;
	//贷款清理列表查询
	public static final int FUNC_CODE_LOAN_CLEAR_LIST_QUERY = 1040933;
	//贷款清理
	public static final int FUNC_CODE_LOAN_CLEAR = 1040934;


	/**
	 * 五级分类
	 */
	//五级分类方式单笔修改
	public static final int FUNC_CODE_SINGLE_CLS_TYPE_CHG = 1050201;
	//五级分类单笔初分
	public static final int FUNC_CODE_SINGLE_CLS_APPLY = 1050202;
	//五级分类单笔初分修改
	public static final int FUNC_CODE_SINGLE_CLS_APPLY_UPD = 1050203;
	//五级分类单笔初审
	public static final int FUNC_CODE_SINGLE_CLS_AUDIT = 1050204;
	//五级分类单笔复审
	public static final int FUNC_CODE_SINGLE_CLS_REAUDIT = 1050205;
	//五级分类单笔审定
	public static final int FUNC_CODE_SINGLE_CLS_APPROVE = 1050206;
	//五级分类单笔审批时查询申请信息及历史审批意见
	public static final int FUNC_CODE_SHOW_CLS_APPLY_INFO = 1050207;
	//五级分类单笔工作项声明
	public static final int FUNC_CODE_SINGLE_CLS_CLAIM = 1050208;
	//五级分类单笔工作项取消声明
	public static final int FUNC_CODE_SINGLE_CLS_CANCEL = 1050209;

	//贷款五级分类方式批量修改
	public static final int FUNC_CODE_MULTI_CLS_TYPE_CHG = 1050211;
	//五级分类批量初分
	public static final int FUNC_CODE_MULTI_CLS_APPLY = 1050212;
	//五级分类批量初分修改
	public static final int FUNC_CODE_MULTI_CLS_APPLY_UPD = 1050213;
	//五级分类批量初审
	public static final int FUNC_CODE_MULTI_CLS_AUDIT = 1050214;
	//五级分类批量复审
	public static final int FUNC_CODE_MULTI_CLS_REAUDIT = 1050215;
	//五级分类批量审定
	public static final int FUNC_CODE_MULTI_CLS_APPROVE = 1050216;
	//查询批量五级分类的合同列表
	public static final int FUNC_CODE_MULTI_CLS_LOAN_POSITION = 1050217;
	//查询批量五级分类的任务列表
	public static final int FUNC_CODE_QUERY_MULTI_CLS_TASK_LIST = 1050218;
	//五级分类批量工作项声明
	public static final int FUNC_CODE_SINGLE_MULTI_CLAIM = 1050219;
	//五级分类批量工作项取消声明
	public static final int FUNC_CODE_SINGLE_MULTI_CANCEL = 1050220;

	/**
	 * 还款计划变更
	 */
	//还款计划变更申请
	public static final int FUNC_CODE_RTN_PLAN_CHG_APPLY = 1050301;
	//还款计划变更审批
	public static final int FUNC_CODE_RTN_PLAN_CHG_APPROVE = 1050302;
	//还款计划变更主机确认
	public static final int FUNC_CODE_RTN_PLAN_CHG_CORE_AFFIRM = 1050303;
	//还款计划变更申请时查询贷款信息
	public static final int FUNC_CODE_SHOW_RTN_PLAN_CHG_LOAN_INFO = 1050304;
	//还款计划变更审批时查询申请信息
	public static final int FUNC_CODE_SHOW_RTN_PLAN_CHG_APPLY_INFO = 1050305;

	//还款帐号变更申请
	public static final int FUNC_CODE_RTN_ACTNO_CHG_APPLY = 1050311;
	//还款帐号变更审批
	public static final int FUNC_CODE_RTN_ACTNO_CHG_APPROVE = 1050312;
	//还款帐号变更主机确认
	public static final int FUNC_CODE_RTN_ACTNO_CHG_CORE_AFFIRM = 1050313;
	//还款帐号变更审批时查询申请信息
	public static final int FUNC_CODE_SHOW_RTN_ACTNO_CHG_APPLY_INFO = 1050314;

	/**
	 * 贷款形态转换
	 */
	//个人贷款手工转呆帐申请
	public static final int FUNC_CODE_LOAN_TO_BAD_APPLY = 1050401;
	//个人贷款手工转呆帐审批
	public static final int FUNC_CODE_LOAN_TO_BAD_APPROVE = 1050402;
	//主机个人贷款手工转呆帐确认
	public static final int FUNC_CODE_LOAN_TO_BAD_CORE_AFFIRM = 1050403;
	//主机个人贷款手工转呆帐抹帐
	public static final int FUNC_CODE_LOAN_TO_BAD_CORE_CANCEL = 1050404;
	//个人贷款手工转呆帐审批时查询申请信息
	public static final int FUNC_CODE_SHOW_LOAN_TO_BAD_APPLY_INFO = 1050405;

	//呆帐贷款核销申请
	public static final int FUNC_CODE_LOAN_TO_LOSS_APPLY = 1050406;
	//呆帐贷款核销审批
	public static final int FUNC_CODE_LOAN_TO_LOSS_APPROVE = 1050407;
	//主机呆帐贷款核销确认
	public static final int FUNC_CODE_LOAN_TO_LOSS_CORE_AFFIRM = 1050408;
	//主机呆帐贷款核销抹帐
	public static final int FUNC_CODE_LOAN_TO_LOSS_CORE_CANCEL = 1050409;
	//呆帐贷款核销审批时查询申请信息
	public static final int FUNC_CODE_SHOW_LOAN_TO_LOSS_APPLY_INFO = 1050410;

	//核销资产类别转换申请
	public static final int FUNC_CODE_LOSS_TYPE_CHG_APPLY = 1050411;
	//核销资产类别转换审批
	public static final int FUNC_CODE_LOSS_TYPE_CHG_APPROVE = 1050412;
	//主机核销资产类别转换确认
	public static final int FUNC_CODE_LOSS_TYPE_CHG_CORE_AFFIRM = 1050413;
	//主机核销资产类别转换抹帐
	public static final int FUNC_CODE_LOSS_TYPE_CHG_CORE_CANCEL = 1050414;
	//核销资产类别转换审批时查询申请信息
	public static final int FUNC_CODE_SHOW_LOSS_TYPE_CHG_APPLY_INFO = 1050415;

	/**
	 * 贷款还款
	 */
	//部分提前还款申请
	public static final int FUNC_CODE_PART_ADV_RTN_APPLY = 1050501;
	//部分提前还款审批
	public static final int FUNC_CODE_PART_ADV_RTN_APPROVE = 1050502;
	//部分提前还款主机确认
	public static final int FUNC_CODE_PART_ADV_RTN_CORE_AFFIRM = 1050503;
	//部分提前还款主机抹帐
	public static final int FUNC_CODE_PART_ADV_RTN_CORE_CANCEL = 1050504;
	//部分提前还款申请时查询贷款信息
	public static final int FUNC_CODE_SHOW_ADV_RTN_LOAN_INFO = 1050505;
	//部分提前还款利息试算
	public static final int FUNC_CODE_PART_ADV_RTN_PRE_CALC = 1050506;
	//部分提前还款审批时查询申请信息
	public static final int FUNC_CODE_SHOW_ADV_RTN_APPLY_INFO = 1050507;

	//全部提前还款申请
	public static final int FUNC_CODE_ALL_ADV_RTN_APPLY = 1050508;
	//全部提前还款审批
	public static final int FUNC_CODE_ALL_ADV_RTN_APPROVE = 1050509;
	//全部提前还款主机确认
	public static final int FUNC_CODE_ALL_ADV_RTN_CORE_AFFIRM = 1050510;
	//全部提前还款主机抹帐
	public static final int FUNC_CODE_ALL_ADV_RTN_CORE_CANCEL = 1050511;

	//核心贷款部分提前还款登记
	public static final int FUNC_CODE_CORE_PART_ADV_RTN_CORE_AFFIRM = 1050512;
	//核心贷款部分提前还款抹帐
	public static final int FUNC_CODE_CORE_PART_ADV_RTN_CORE_CANCEL = 1050513;

	//核心贷款全部提前还款登记
	public static final int FUNC_CODE_CORE_ALL_ADV_RTN_CORE_AFFIRM = 1050514;
	//核心贷款全部提前还款抹帐
	public static final int FUNC_CODE_CORE_ALL_ADV_RTN_CORE_CANCEL = 1050515;

	//到期贷款还款登记
	public static final int FUNC_CODE_OVERDUE_RTN_CORE_AFFIRM = 1050516;
	//到期贷款还款抹帐
	public static final int FUNC_CODE_OVERDUE_RTN_CORE_CANCEL = 1050517;
	//到期贷款还款冲帐
	public static final int FUNC_CODE_OVERDUE_RTN_CORE_REVERSE = 1050518;

	//欠息挂帐
	public static final int FUNC_CODE_CORE_INTR = 1050519;
	//欠息挂帐抹帐
	public static final int FUNC_CODE_CORE_INTR_CANCEL = 1050520;
	
	//代理公积金贷款还款
	public static final int FUNC_CODE_CORE_AT_FUND_RTN = 1050521;
	//代理公积金贷款还款抹帐
	public static final int FUNC_CODE_CORE_AT_FUND_RTN_CANCEL = 1050522;
	//代理公积金批扣后本金/利息入账
	public static final int FUNC_CODE_CORE_AT_FUND_BAT_RTN = 1050523;
	//代理公积金批扣后本金/利息入账抹帐
	public static final int FUNC_CODE_CORE_AT_FUND_BATCH_RTN_CANCEL = 1050524;

	/**
	 * 担保信息变更
	 */
	//合同担保信息变更改
	public static final int FUNC_CODE_GUAT_INFO_CHANGE_APPLY = 1050601;
	//合同担保信息变更改查询
	public static final int FUNC_CODE_GUAT_INFO_SHOW_CHANGE_APPLY = 1050602;
	//合同担保信息变更检查
	public static final int FUNC_CODE_GUAT_INFO_CHANGE_CHECK = 1050603;
	//授信担保信息变更改
	public static final int FUNC_CODE_CREDIT_GUAT_INFO_CHANGE_APPLY = 1050604;
	//授信担保信息变更改查询
	public static final int FUNC_CODE_CREDIT_GUAT_INFO_SHOW_CHANGE_APPLY = 1050605;
	//授信担保信息变更检查
	public static final int FUNC_CODE_CREDIT_GUAT_INFO_CHANGE_CHECK = 1050606;

	/**
	 * 贷后审批工作流
	 */
	//贷后审批工作流声明
	public static final int FUNC_CODE_POST_LOAN_APPLY_CLAIM = 1050701;
	//贷后审批工作流取消声明
	public static final int FUNC_CODE_POST_LOAN_APPLY_CANCEL = 1050702;


	/**
	 * 贷后通知
	 */
	//逾期催缴通知查询
	public static final int FUNC_CODE_OVERDUE_URGE = 1060101;
	//逾期催缴通知打印
	public static final int FUNC_CODE_OVERDUE_URGE_PRINT = 1060102;
	//债务提前到期通知查询
	public static final int FUNC_CODE_DEBT_AHEAD_TERM = 1060103;
	//处置抵质押品通知查询
	public static final int FUNC_CODE_DEAL_GAGE = 1060104;
	//逾期清单查询
	public static final int FUNC_CODE_OVERDUE_LIST = 1060105;
	//欠款明细查询
	public static final int FUNC_CODE_ARREARAGE_DETAIL = 1060106;
	//催缴打印
	public static final int FUNC_CODE_HASTEN = 1060107;
	//逾期打印清单查询
	public static final int FUNC_CODE_OVERDUE_PRINT_LIST = 1060108;
	//债务提前到期打印
	public static final int FUNC_CODE_LOANADVDUENOTIFY = 1060109;
	//债务提前到期查询
	public static final int FUNC_CODE_LOANADVDUENOTIFY_PRINT_LIST = 1060110;
	//处置抵质押品打印
	public static final int FUNC_CODE_PROCLEDGENTC = 1060111;
	//处置抵质押品查询
	public static final int FUNC_CODE_PROCLEDGENTC_PRINT_LIST = 1060112;



	/**
	 * 贷后管理
	 */
	//贷后检查查询贷款详细信息
	public static final int FUNC_CODE_POST_LOAN_CHECK_QUERY = 1070102;
	//贷后检查
	public static final int FUNC_CODE_POST_LOAN_CHECK = 1070103;
	//诉讼理赔列表记录查询
	public static final int FUNC_CODE_LAW_SUIT_LIST_QUERY = 1070104;
	//诉讼理赔登记记录
	public static final int FUNC_CODE_LAW_SUIT_MNG = 1070106;
	//追帐管理列表记录查询
	public static final int FUNC_CODE_TRACE_DEBT_LIST_QUERY = 1070107;
	//追帐管理登记记录
	public static final int FUNC_CODE_TRACE_DEBT_MNG = 1070109;
	//贷款情况查询
	public static final int FUNC_CODE_LOAN_QUERY = 1070111;
	//单笔贷款情况查询
	public static final int FUNC_CODE_SINGLE_LOAN_QUERY = 1070123;
	//逾期贷款查询
	public static final int FUNC_CODE_OVERDUE_LOAN_QUERY = 1070112;
	//批量扣款查询－－被移到查询打印模块中去了
	public static final int FUNC_CODE_BATCH_REPAY_QUERY = 1070113;
	//查询保险公司出险明细
	public static final int FUNC_CODE_INSURER_INDEMNIFY_DTL = 1070114;
	//查询保险公司已理赔明细
	public static final int FUNC_CODE_INSURER_INDEMNIFIED_DTL = 1070115;
	//贷后管理查询
	public static final int FUNC_CODE_POSTLOANMNG_QUERY = 1070116;
	//贷后管理撤销
	public static final int FUNC_CODE_POSTLOANMNG_CANCLE = 1070117;
	//贷后检查申请模糊查询
	public static final int FUNC_CODE_POST_LOAN_CHECK_BLUR_QUERY = 1070118;
	//贷后检查审查模糊查询
	public static final int FUNC_CODE_POST_LOAN_CHECK_APPR_BLUR_QUERY = 1070119;
	//贷后检查审查
	public static final int FUNC_CODE_POST_LOAN_CHECK_APPR = 1070120;
	//撤销主机交易
	public static final int FUNC_CODE_CANCLE_HOME = 1070121;
    //挪用罚息交易
    public static final int FUNC_CODE_RCV_PINTRATE = 1070122;
	//生成查询报表
	public static final int FUNC_CODE_BHREPORT_CREAT = 1070125;
	//报表的数量
	public static final int FUNC_CODE_BHREPORT_QUERY_LIST = 1070126;
	//修改报表
	public static final int FUNC_CODE_BHREPORT_MODIFY = 1070127;
	//删除报表
	public static final int FUNC_CODE_BHREPORT_DELETE = 1070128;
	//报表单条查询
	public static final int FUNC_CODE_BHREPORT_QUERY = 1070129;

	

	/**
	 * 统计分析
	 */
	//客户分析
	public static final int FUNC_CODE_CLIENT_ANALYSE = 1080101;
	//合作商模糊查询
	public static final int FUNC_CODE_COOP_QUERY_ANALYSE = 1080102;
	//合作商详细查询
	public static final int FUNC_CODE_COOP_DTL_ANALYSE = 1080103;
	//保险公司查询
	public static final int FUNC_CODE_INSURANCE_QUERY_ANALYSE = 1080104;
	//全行个贷结构分析
	public static final int FUNC_CODE_BANK_LN_STRUCT_ANLS = 1080105;
	//个贷结构分析
	public static final int FUNC_CODE_LN_STRUCT_ANLS = 1080106;
	//个贷占比分析
	public static final int FUNC_CODE_LN_PROPORTION_ANLS = 1080107;
	//个贷品种期限结构分析
	public static final int FUNC_CODE_LN_LMT_STRUCT_ANLS = 1080108;
	//个贷担保方式分析
	public static final int FUNC_CODE_LN_GUAT_STRUCT_ANLS = 1080109;
	//个贷还款方式分析
	public static final int FUNC_CODE_LN_RTN_TYPE_ANLS = 1080110;
	//个贷还款途径分析
	public static final int FUNC_CODE_LN_RTN_ROUTE_ANLS = 1080111;
	//贷款盈利能力分析
	public static final int FUNC_CODE_LN_PAYOFF_ANLS = 1080112;
	//同指标不同时点分析
	public static final int FUNC_CODE_SAME_ANLS = 1080113;
	//某一指标发展趋势分析
	public static final int FUNC_CODE_DEVELOP_ANLS = 1080114;
	//绩效考核列表查询
	public static final int FUNC_CODE_PERFORM_ASS_QUERY_ANLS = 1080115;
	//绩效考核明细查询
	public static final int FUNC_CODE_PERFORM_ASS_DTL_ANLS = 1080116;

	/**
	 * 系统管理
	 */
	//机构信息查询
	public static final int FUNC_CODE_BRANCH_QUERY = 11001011;
	//机构列表信息查询
	public static final int FUNC_CODE_BRANCH_LIST_QUERY = 11001012;

	//操作员增加
	public static final int FUNC_CODE_TELLER_CREATE = 1100201;
	//操作员修改
	public static final int FUNC_CODE_TELLER_MODIFY = 11002021;
	//操作员查询
	public static final int FUNC_CODE_TELLER_QUERY = 11002022;
	//操作员删除
	public static final int FUNC_CODE_TELLER_DELETE = 11002023;
	//操作员列表查询
	public static final int FUNC_CODE_TELLER_QUERY_LIST = 11002024;
	//操作员密码重置
	public static final int FUNC_CODE_TELLER_PSWD_RESET = 1100203;
	//操作员登录
	public static final int FUNC_CODE_TELLER_LOGIN = 1100204;
	//操作员签退
	public static final int FUNC_CODE_TELLER_LOGOUT = 1100205;
	//操作员修改密码
	public static final int FUNC_CODE_TELLER_PSWD_CHANGE = 1100206;
	//电子柜员增加
	public static final int FUNC_CODE_PL_TLRNO_ADD = 1100207;
	//电子柜员删除
	public static final int FUNC_CODE_PL_TLRNO_DELETE = 1100208;
	//电子柜员查询
	public static final int FUNC_CODE_PL_TLRNO_QUERY = 1100209;
		

	//岗位列表查询
	public static final int FUNC_CODE_POST_QUERY_LIST = 11003011;
	//岗位查询
	public static final int FUNC_CODE_POST_QUERY = 11003012;
	//岗位增加
	public static final int FUNC_CODE_POST_CREATE = 11003013;
	//岗位修改
	public static final int FUNC_CODE_POST_MODIFY = 11003014;
	//岗位删除
	public static final int FUNC_CODE_POST_DELETE = 11003015;
	//岗位功能列表查询
	public static final int FUNC_CODE_POST_FUNC_QUERY = 11003016;
	//岗位功能列表维护
	public static final int FUNC_CODE_POST_FUNC_MODIFY = 11003017;

	//总行贷款产品参数增加
	public static final int FUNC_CODE_LOAN_PARAM_HEAD_INSERT = 1100401;
	//总行贷款产品参数查询
	public static final int FUNC_CODE_LOAN_PARAM_HEAD_QUERY = 11004021;
	//总行贷款产品参数维护
	public static final int FUNC_CODE_LOAN_PARAM_HEAD_MODIFY = 11004022;
	//总行贷款产品参数修复
	public static final int FUNC_CODE_LOAN_PARAM_HEAD_ADD_REPAIR = 11004023;
	//分行贷款产品参数增加(暂时不用)
	public static final int FUNC_CODE_LOAN_PARAM_BRANCH_INSERT = 1100403;
	//分行贷款产品参数查询
	public static final int FUNC_CODE_LOAN_PARAM_BRANCH_QUERY = 11004041;
	//分行贷款产品参数维护
	public static final int FUNC_CODE_LOAN_PARAM_BRANCH_MODIFY = 11004042;
	//总行查询分行贷款产品参数
	public static final int FUNC_CODE_LOAN_PARAM_HEAD_2_BRANCH_QUERY = 11004901;
	//总行维护分行贷款参数
	public static final int FUNC_CODE_LOAN_PARAM_HEAD_2_BRANCH_MODIFY = 11004902;

	//机构开办贷款产品列表查询
	public static final int FUNC_CODE_TRANS_PARAM_QUERY_LIST = 11004051;
	//机构开办贷款产品查询
	public static final int FUNC_CODE_TRANS_PARAM_QUERY = 11004052;
	//机构开办贷款产品增加
	public static final int FUNC_CODE_TRANS_PARAM_CREATE = 11004053;
	//机构开办贷款产品修改
	public static final int FUNC_CODE_TRANS_PARAM_MODIFY = 11004054;
	//机构开办贷款产品删除
	public static final int FUNC_CODE_TRANS_PARAM_DELETE = 11004055;

	//贷款产品机构开办列表查询
	public static final int FUNC_CODE_TRANS_PARAM_BY_LNID_QUERY_LIST = 11004061;
	//贷款产品机构开办查询
	public static final int FUNC_CODE_TRANS_PARAM_BY_LNID_QUERY = 11004062;
	//贷款产品机构开办增加
	public static final int FUNC_CODE_TRANS_PARAM_BY_LNID_CREATE = 11004063;
	//贷款产品机构开办修改
	public static final int FUNC_CODE_TRANS_PARAM_BY_LNID_MODIFY = 11004064;
	//贷款产品机构开办删除
	public static final int FUNC_CODE_TRANS_PARAM_BY_LNID_DELETE = 11004065;

	//操作员审批权限列表查询
	public static final int FUNC_CODE_LIMIT_PARAM_QUERY_LIST = 11004071;
	//操作员审批权限查询
	public static final int FUNC_CODE_LIMIT_PARAM_QUERY = 11004072;
	//操作员审批权限增加
	public static final int FUNC_CODE_LIMIT_PARAM_CREATE = 11004073;
	//操作员审批权限修改
	public static final int FUNC_CODE_LIMIT_PARAM_MODIFY = 11004074;
	//操作员审批权限删除
	public static final int FUNC_CODE_LIMIT_PARAM_DELETE = 11004075;

	//合作项目开办列表查询
	public static final int FUNC_CODE_PROJ_PARAM_QUERY_LIST = 11004081;
	//合作项目开办查询
	public static final int FUNC_CODE_PROJ_PARAM_QUERY = 11004082;
	//合作项目开办增加
	public static final int FUNC_CODE_PROJ_PARAM_CREATE = 11004083;
	//合作项目开办修改
	public static final int FUNC_CODE_PROJ_PARAM_MODIFY = 11004084;
	//合作项目开办删除（暂时不用）
	public static final int FUNC_CODE_PROJ_PARAM_DELETE = 11004085;

	//五级分类开办列表查询
	public static final int FUNC_CODE_GRADE_CLS_QUERY_LIST = 11004091;
	//五级分类开办查询
	public static final int FUNC_CODE_GRADE_CLS_QUERY = 11004092;
	//五级分类开办增加
	public static final int FUNC_CODE_GRADE_CLS_CREATE = 11004093;
	//五级分类开办修改
	public static final int FUNC_CODE_GRADE_CLS_MODIFY = 11004094;
	//五级分类开办删除（暂时不用）
	public static final int FUNC_CODE_GRADE_CLS_DELETE = 11004095;

	//贷款管理参数查询
	public static final int FUNC_CODE_MANAGE_PARAM_QUERY = 11004101;
	//贷款管理参数修改
	public static final int FUNC_CODE_MANAGE_PARAM_MODIFY = 11004102;

	//档案要素列表查询
	public static final int FUNC_CODE_ARCH_ITEM_PARAM_QUERY_LIST = 11004111;
	//档案要素增加
	public static final int FUNC_CODE_ARCH_ITEM_PARAM_CREATE = 11004112;
	//档案要素列表修改
	public static final int FUNC_CODE_ARCH_ITEM_PARAM_MODIFY = 11004113;

	//贷款子参数列表查询 
	public static final int FUNC_CODE_SUB_LNID_PARAM_QUERY_LIST = 11004121;
	//贷款子参数查询     
	public static final int FUNC_CODE_SUB_LNID_PARAM_QUERY = 11004122;
	//贷款子参数增加     
	public static final int FUNC_CODE_SUB_LNID_PARAM_CREATE = 11004123;
	//贷款子参数修改     
	public static final int FUNC_CODE_SUB_LNID_PARAM_MODIFY = 11004124;
	//贷款子参数删除     
	public static final int FUNC_CODE_SUB_LNID_PARAM_DELETE = 11004125;

	//担保额度参数列表查询 
	public static final int FUNC_CODE_GUAT_LIMIT_PARAM_QUERY_LIST = 11004131;
	//担保额度子参数查询   
	public static final int FUNC_CODE_GUAT_LIMIT_PARAM_QUERY = 11004132;
	//担保额度子参数增加   
	public static final int FUNC_CODE_GUAT_LIMIT_PARAM_CREATE = 11004133;
	//担保额度子参数修改   
	public static final int FUNC_CODE_GUAT_LIMIT_PARAM_MODIFY = 11004134;
	//担保额度子参数删除   
	public static final int FUNC_CODE_GUAT_LIMIT_PARAM_DELETE = 11004135;

	//工作流业务模型配置参数列表查询 
	public static final int FUNC_CODE_WORKFLOW_BIZ_DEFINE_QUERY_LIST = 11004141;
	//工作流业务模型配置参数查询     
	public static final int FUNC_CODE_WORKFLOW_BIZ_DEFINE_QUERY = 11004142;
	//工作流业务模型配置参数增加     
	public static final int FUNC_CODE_WORKFLOW_BIZ_DEFINE_CREATE = 11004143;
	//工作流业务模型配置参数修改     
	public static final int FUNC_CODE_WORKFLOW_BIZ_DEFINE_MODIFY = 11004144;
	//工作流业务模型配置参数删除     
	public static final int FUNC_CODE_WORKFLOW_BIZ_DEFINE_DELETE = 11004145;

	//由我创建
	public static final int FUNC_CODE_PROCESS_CREATE = 1100501;
	//由我管理
	public static final int FUNC_CODE_PROCESS_MANAGE = 1100502;
	//取消办理
	public static final int FUNC_CODE_PROCESS_CANCEL = 1100503;
	//任务迁移
	public static final int FUNC_CODE_PROCESS_TRANSFER = 1100504;
	//工作项查询
	public static final int FUNC_CODE_PROCESS_QUERY = 1100505;

	//批量换日
	public static final int FUNC_CODE_SWITCH_DAY = 1100601;
	//启动批量
	public static final int FUNC_CODE_START_BATCH = 1100602;
	//启动联机
	public static final int FUNC_CODE_START_ONLINE = 1100603;
	//批量监控运行步骤列表查询
	public static final int FUNC_CODE_MONITOR_BATCHES = 1100604;
	//中止一个批量子步骤
	public static final int FUNC_CODE_STOP_SUBSTEP = 1100605;
	//当日临时取消运行一个批量子步骤
	public static final int FUNC_CODE_CANCEL_SUBSTEP = 1100606;
	//中止当前作业
	public static final int FUNC_CODE_STOP_BATCH = 1100607;
	//单独启动一个批量子步骤
	public static final int FUNC_CODE_START_SUBSTEP_ONLY = 1100608;
	//批量维护运行步骤列表查询
	public static final int FUNC_CODE_BATCH_STEPS_MAINTENANCE = 1100609;
	//增加一个批量子步骤
	public static final int FUNC_CODE_ADD_SUBSTEP = 1100610;
	//修改一个批量子步骤
	public static final int FUNC_CODE_MODIFY_SUBSTEP = 1100611;
	//删除一个批量子步骤
	public static final int FUNC_CODE_DELETE_SUBSTEP = 1100612;
	//查询一个批量子步骤详细信息
	public static final int FUNC_CODE_QUERY_SUBSTEP_DETAIL = 1100613;
	//启动批量
	public static final int FUNC_CODE_START_ONE_STEP_BATCH = 1100614;
	//换日查询
	public static final int FUNC_CODE_SWITCH_DAY_QUERY = 1100615;

	// 报表下载
	public static final int FUNC_CODE_BATCH_REPORT_DOWNLOAD = 1100620;
	
	// 文件上传
	public static final int FUNC_CODE_FILE_UPLOAD = 1100625;

	// DES加密
	public static final int FUNC_CODE_CRYPTION_DATA_DES = 1100630;



	/**
	 * 查询打印
	 */
	//理财试算
	public static final int FUNC_CODE_REPAY_PLAN_CALC = 1100701;
	//贷款还款计划表查询
	public static final int FUNC_CODE_REPAY_PLAN_QUERY = 1100702;
	//任务列表查询
	public static final int FUNC_CODE_WORK_ITEM_LIST_QUERY = 1100703;
	//业务流水查询
	public static final int FUNC_CODE_BIZ_LOG_QUERY = 1100704;
	//业务监控
	public static final int FUNC_CODE_TX_MONITOR = 1100705;
	//预警信息查询
	public static final int FUNC_CODE_FORECAST_INFO_QUERY = 1100706;
	//查询还款明细
	public static final int FUNC_CODE_QUERY_REPAY_DTL = 1100707;
	//查询欠款明细
	public static final int FUNC_CODE_QUERY_LNOWE_DTL = 1100708;
	//查询追帐记录
	public static final int FUNC_CODE_QUERY_TRACE_DTL = 1100709;
	//贷款明细查询
	public static final int FUNC_CODE_QUERY_LOAN_DETAIL = 1100710;
	//合同打印分析
	public static final int FUNC_CODE_PRINT_LOANAPPLY_PRINTDOC_ANALYZE =
		1100711;
	//批量扣款查询
	public static final int FUNC_CODE_BATCH_CUT_QUERY = 1100712;
	//批量扣款查询打印
	public static final int FUNC_CODE_BATCH_CUT_QUERY_PRINT = 1100713;
	//发放打印分析
	public static final int FUNC_CODE_PRINT_LOANGRANT_PRINTDOC_ANALYZE = 1100714;
	//贷款发放打印
	public static final int FUNC_CODE_PRINT_LOANGRANT_RECEIPT_PRINT = 1100715;
	//新旧合同号查询
	public static final int FUNC_CODE_QUERY_NEW_OLD_CONTRACTNO = 1100716;
	//多次发放贷款模糊查询
	public static final int FUNC_CODE_QUERY_LN_MULTI_TIMES_GRANT_LIST = 1100717;
	//多次发放贷款精确查询
	public static final int FUNC_CODE_QUERY_LN_MULTI_TIMES_GRANT_DTL = 1100718;
	//贷款利率查询
	public static final int FUNC_CODE_LOAN_RATE_QUERY = 1100719;
	//冲还贷查询
	public static final int FUNC_CODE_FUND_PAY_LN_INQ = 1100720;
	//查询贷款大事
	public static final int FUNC_CODE_QUERY_GREAT_DTL = 1100721;


	//MQ交易补录
	public static final int FUNC_CODE_MQ_REWRITE = 1100801;

	/**
	 * 走马灯
	 */
	// 紧急通知查询	
	public static final int FUNC_CODE_MARQUE_QUE = 1100901;
	// 紧急通知添加	
	public static final int FUNC_CODE_MARQUE_ADD = 1100902;
	// 紧急通知修改	
	public static final int FUNC_CODE_MARQUE_MOD = 1100903;
	// 紧急通知删除
	public static final int FUNC_CODE_MARQUE_DEL = 1100904;

	/**
	 * 电话银行
	 */
	// 某个授信序号下自助循环贷款查询
	public static final int FUNC_CODE_TELE_CYCLE_LOAN = 1110101;
	// 客户还款记录明细查询
	public static final int FUNC_CODE_TELE_REPAY_DETAIL = 1110102;
	// 客户查询所有贷款交易
	public static final int FUNC_CODE_TELE_LOAN_TX = 1110103;
	// 查询客户单项贷款余额
	public static final int FUNC_CODE_TELE_LOAN_BAL = 1110104;
	// 电话传真还款计划表功能	
	public static final int FUNC_CODE_TELE_REPAY_PLAN = 1110105;

	/**
	 * 天津分行公积金
	 */
	//天津分行公积金主贷信息建立
	public static final int FUNC_CODE_TIJIAN_FUND_LOAN = 1110200;
	//天津分行公积金抹帐交易
	public static final int FUNC_CODE_TIJIAN_FUND_LOAN_CANCEL = 1110201;
	//天津分行公积金客户建立
	public static final int FUNC_CODE_TIJIAN_FUND_CUSTOMER = 1110202;
	//天津分行公积金抵押信息和保险信息的建立
	public static final int FUNC_CODE_TIJIAN_FUND_MORT = 1110203;
	//天津分行公积金质押信息建立
	public static final int FUNC_CODE_TIJIAN_FUND_IMPAWN = 1110204;
	//天津分行公积金担保信息建立
	public static final int FUNC_CODE_TIJIAN_FUND_ASSUREINFO = 1110205;
	
	/**
	 * 网上银行
	 */
	// 客户查询所有贷款交易
	public static final int FUNC_CODE_EBANK_LOAN_LIST_QUERY = 1110301;
	// 客户查询贷款基本信息交易
	public static final int FUNC_CODE_EBANK_LOAN_DETAIL_QUERY = 1110302;
	// 查询还款计划表交易	
	public static final int FUNC_CODE_EBANK_REPAY_PLAN = 1110303;
	// 小额质押额度查询(沃德网银)
	public static final int FUNC_CODE_OTO_IMPAWN_LNBAL_QUERY = 1110304;
	// 小额质押贷款合同查询(沃德网银)
	public static final int FUNC_CODE_OTO_IMPAWN_LIST_QUERY = 1110305;
	// 循环贷款额度查询(沃德网银)
	public static final int FUNC_CODE_OTO_CREDIT_LIST_QUERY = 1110306;
	// 循环贷款合同查询(沃德网银)
	public static final int FUNC_CODE_OTO_CREDIT_LOAN_LIST_QUERY = 1110307;
	
	
	/**
	 * 沃德自动贷款查询
	 */
	//沃德自动贷款查询
	public static final int FUNC_CODE_OTOAUTOLOAN = 1200900;
	//沃德自动贷款查询
	public static final int FUNC_CODE_OTOAUTOLOAN_QUERY = 1200901;
	//沃德贷款客户查询
	public static final int FUNC_CODE_OTOAUTOLOAN_CUSTINFO = 1200902;
	//沃德贷款客户修改
	public static final int FUNC_CODE_OTOCUSTINFO_EDIT = 1200903;
	//沃德贷款－小额质押
	public static final int FUNC_CODE_OTOAUTOLOAN_CITLMTL = 1200904;
	//沃德贷款－循环贷款	
	public static final int FUNC_CODE_OTOAUTOLOAN_CREDIT = 1200905;	
	
	/**
	 * 批量交易
	 */
	// 五级分类
	public static final int FUNC_CODE_BATCH_CLR = 2010101;
	// 批量计提
	public static final int FUNC_CODE_BH_LOAN_INTR = 2010102;
	// 批量扣款
	public static final int FUNC_CODE_BH_LOAN_RTN = 2010103;
	// 转逾期
	public static final int FUNC_CODE_BH_TRM = 2010104;
	//批量公积金余额法部分提前还款
	public static final int FUNC_CODE_BH_PART_ADVRTN = 2010105;
	//批量公积金余额法全部提前还款
	public static final int FUNC_CODE_BH_ALL_ADVRTN = 2010106;
	// 批量放款沃德
	public static final int FUNC_CODE_BH_LOAN = 2010107;
	
	/**
	 * 风险监控参数维护
	 * add by YJB
	 */
	 //风险监控参数表维护 总行系统管理岗和分行系统管理岗
	 public static final int FUNC_CODE_RISK_FILTER_PARAM_MNG = 11005020;
	 // 风险监控小额贷款参数表维护 总行系统管理岗和分行系统管理岗
	 public static final int FUNC_CODE_RISK_FILTER_LOAN_AMOUNT = 11005021;

	 // 风控增加标志申报 分行追帐岗
	 public static final int FUNC_CODE_RISK_FILTER_ADD_APPLY = 1300010;
	 // 风控增加标志审批 分行个贷中心主任                                            
	 public static final int FUNC_CODE_RISK_FILTER_ADD_APPROVE = 1300011;
	 // 风控删除标志申报 分行追帐岗
	 public static final int FUNC_CODE_RISK_FILTER_DEL_APPLY = 1300013;
	 // 风控删除标志审批 分行个贷中心主任                                            
	 public static final int FUNC_CODE_RISK_FILTER_DEL_APPROVE = 1300014;
	
	/**
	 * 风险监控查询交易
	 * add by ZSY
	 */
	//风险监控列表查询
	public static final int FUNC_CODE_RISK_LIST_QUERY = 1300070;
	//风险监控合计查询
	public static final int FUNC_CODE_RISK_SUM_QUERY = 1300071;
}