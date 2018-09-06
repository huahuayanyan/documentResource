/**
 * 
 */
package com.huateng.scf.adv.bcp.constant;

/**
 * <p>预付类业务组件模块异常常量类</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月22日下午8:02:03	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月22日下午8:02:03              新增
 *
 * </pre>
 */
public class ABcpErrorConstant {
	//预付款业务申请流水信息
	public static final String SCF_ADV_BCP_10000 = "scf.adv.bcp.10000";// 预付款业务申请流水转换异常！
	public static final String SCF_ADV_BCP_10001 = "scf.adv.bcp.10001";// 预付款业务申请流水插入异常！
	public static final String SCF_ADV_BCP_10002 = "scf.adv.bcp.10002";// 预付款业务申请流水更新异常！
	public static final String SCF_ADV_BCP_10003 = "scf.adv.bcp.10003";// 预付款业务申请流水删除异常！
	
	//预付款业务流水表
	public static final String SCF_ADV_BCP_10005 = "scf.adv.bcp.10005";// 预付款业务流水转换异常！
	public static final String SCF_ADV_BCP_10006 = "scf.adv.bcp.10006";// 预付款业务流水插入异常！
	public static final String SCF_ADV_BCP_10007 = "scf.adv.bcp.10007";// 预付款业务流水更新异常！
	public static final String SCF_ADV_BCP_10008 = "scf.adv.bcp.10008";// 预付款业务流水删除异常！
	
	/** 公共相关错误码 begin SCF0000~SCF1200 **/
	public static final String ERROR_CODE_SYSTEM = "999999"; // 接口(系统)错误
	public static final String ERROR_CODE_UNKNOWN = "SCF0000"; // 未知错误
	public static final String RECORD_NOT_EXIST = "SCF0001"; // 记录不存在
	public static final String RECORD_HAS_EXIST = "SCF0002"; // 记录已存在
	public static final String ERROR_CODE_DATA_TYPE_ERR = "SCF0003"; // 数据类型错误
	public static final String ERROR_CODE_DATA_INPUT_ERR = "SCF0004"; // 数据输入错误
	public static final String ERROR_CODE_PARAM_NOT_EXIST = "SCF0005"; // 参数不存在
	public static final String ERROR_CODE_EMPTY_CHECK_FAILED = "SCF0006"; // 非空校验失败
	public static final String ERROR_CODE_APPINFO_ERROR = "SCF0007"; // 申请信息错误
	public static final String ERROR_CODE_STATE_LOSE = "SCF0008";// 状态失效
	public static final String ERROR_CODE_INFO_DTL = "SCF0009";// 信息记录错误
	public static final String ERROR_CODE_CANNOT_DEL = "SCF0010";// 不能删除
	public static final String ERROR_CODE_DATA_NOT_EQUAL = "SCF0011";// 一致性检查未通过
	public static final String ERROR_CODE_COPY_PROP = "SCF0012";// 对象复制错误
	public static final String ERROR_CODE_FLOW_LNCI_DUP = "SCF0013";// 该借据正在被其他流程处理
	public static final String ERROR_CODE_FILE_DOWNLOAD_FAILED = "SCF0014";// 下载文件失败
	public static final String ERROR_CODE_NOTICE_GEN_FAILED = "SCF0015";// 通知书生成失败
	public static final String ERROR_CODE_PWD_INVALID = "SCF0016";// 用户密码错误
	public static final String ERROR_CODE_TLRNO_PSWD_ERR_THREE_TIMES = "SCF0017";// 操作员连续三次密码错误
	public static final String ERROR_CODE_TLRNO_STATUS_INVALID = "SCF0018";// 用户状态无效
	public static final String ERROR_CODE_TLRNO_PSWD_ERR_SIX_TIMES = "SCF0019";// 操作员当日累计六次密码错误
	public static final String ERROR_CODE_GEN_CHECK_STOCKNO_FAILED = "SCF0020";// 核库编号生成失败
	public static final String ERROR_CODE_CANNOT_UPDATE = "SCF0021";// 不能更新
	public static final String ERROR_CODE_NETWORK_ERROR = "SCF0022";// 通讯异常
	public static final String ERROR_CODE_FILE_UPLOAD_FAILED = "SCF0023";// 上传文件失败
	
	//发货对账
	public static final String SCF_ADV_BCP_20000 = "scf.adv.bcp.20000";// 担保提货协议信息丢失,通知书生成失败!
	public static final String SCF_ADV_BCP_20001 = "scf.adv.bcp.20001";// 申请基本信息:通知书信息丢失
}
