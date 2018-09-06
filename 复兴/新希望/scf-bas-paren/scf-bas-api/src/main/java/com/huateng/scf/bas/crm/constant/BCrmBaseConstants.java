/**
 * 
 */
package com.huateng.scf.bas.crm.constant;

/**
 * <p>
 * 客户管理常量类
 * </p>
 *
 * @author lihao
 * @date 2016年11月3日 下午6:55:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * lihao		2016年11月3日 下午6:55:07	                                    新增
 *
 *            </pre>
 */

public class BCrmBaseConstants {

	public static final String CUST_STATUS_VALID = "01";// 有效客户状态
	public static final String CUST_STATUS_INVALID = "00";// 无效客户状态
	/** CUST_TYPE[客户类型] **/
	public static final String CUST_TYPE_CORP = "1";// 法人
	public static final String CUST_TYPE_NATU = "2";// 自然人
	public static final String CUST_TYPE_SAME = "3";// 同业客户
	/**CORE_RELATION_FLG与核心厂商关系	 **/
	public static final String CORE_RELATION_FLG_UP = "01";//01-上游
	public static final String CORE_RELATION_FLG_DOWN = "02";// 02-下游
	public static final String BAS_CUST_CD = "BAS_CUST_CD";
	
	public static final String CCMS_CUSTCD="CCMS_CUSTCD";
	// 额度类型编号
	/*
	 * // [额度节点类型] 1-根节点（1级） 2-子节点（2级） 3-子子节点（3级） public static final String
	 * CREDIT_NODE_TYPE_ROOT = "1"; public static final String
	 * CREDIT_NODE_TYPE_LEAF = "2"; public static final String
	 * CREDIT_NODE_TYPE_SUB_LEAF = "3"; // [额度类型] 1：直接授信额度；2：第三方授信额度；3：间接额度
	 * public static final String CREDIT_CLASS_DIRECT = "1";// 1-直接授信额度 public
	 * static final String CREDIT_CLASS_THIRD = "2";// 2-第三方授信额度 public static
	 * final String CREDIT_CLASS_INDIRECT="3";//3-间接额度 public static final
	 * String CREDIT_CLASS_LIMIT_BUYER="4";//4-买方信用限额
	 */}
