/**
 * 
 */
package com.huateng.scf.bas.common.startup;

import com.huateng.scf.bas.common.constant.ScfBasConstant;

/**
 * <p></p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月7日下午7:40:54
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月7日下午7:40:54	                                 新增
 *
 * </pre>
 */
public class ScfBaseData {
	private static ScfBaseData baseData = null;
	private String msg_file_path;
	private static  String sign_config_file_name = null;//签名图片配置文件
	private static String scf_trans_file_name=null;//供应链接口配置文件 add by huangshuidan 2015.08.14
	private static String scfIp=null;//供应链接口-IP地址
	private static String scfPort=null;//供应链接口-端口
	private static String loanWayFlag;//出账方式
	private static ScfGlobalInfo scfGlobalInfo;//全局信息对象
	private static ScfNoticeTypeData scfNoticeTypeData;//通知书类型
	
	private static ScfDbConnInfo scfDbConnInfo;//数据源

	public static ScfBaseData getInstance() {
		if (baseData == null) {
			baseData = new ScfBaseData();
		}
		return baseData;
	}
	/**
	 * 取系统全局信息
	 * 1.优先从ScfBaseData
	 * 2.ScfBaseData没有取到，从缓存取
	 * @return
	 */
	public static ScfGlobalInfo getScfGlobalInfoData(){
		ScfGlobalInfo scfGlobalInfo=null;
		scfGlobalInfo=ScfBaseData.getInstance().getScfGlobalInfo();
		if(null==scfGlobalInfo){
			scfGlobalInfo=ScfMcachedUtil.getObject(ScfBasConstant.SCF_CACHE_PUT_KEY_SCFGLOBALINFO);
			//TODO 如果为空从数据库查询,再存放到缓存
		}
		return scfGlobalInfo;
	}

	public String getMsg_file_path() {
		return msg_file_path;
	}

	public void setMsg_file_path(String msg_file_path) {
		this.msg_file_path = msg_file_path;
	}

	/**
	 * @return the sign_config_file_name
	 */
	public static String getSign_config_file_name() {
		return sign_config_file_name;
	}

	/**
	 * @param sign_config_file_name the sign_config_file_name to set
	 */
	public static void setSign_config_file_name(String sign_config_file_name) {
		ScfBaseData.sign_config_file_name = sign_config_file_name;
	}

	/**
	 * @return the scf_trans_file_name
	 */
	public static String getScf_trans_file_name() {
		return scf_trans_file_name;
	}

	/**
	 * @param scf_trans_file_name the scf_trans_file_name to set
	 */
	public static void setScf_trans_file_name(String scf_trans_file_name) {
		ScfBaseData.scf_trans_file_name = scf_trans_file_name;
	}

	/**
	 * @return the scfIp
	 */
	public static String getScfIp() {
		return scfIp;
	}

	/**
	 * @param scfIp the scfIp to set
	 */
	public static void setScfIp(String scfIp) {
		ScfBaseData.scfIp = scfIp;
	}

	/**
	 * @return the scfPort
	 */
	public static String getScfPort() {
		return scfPort;
	}

	/**
	 * @param scfPort the scfPort to set
	 */
	public static void setScfPort(String scfPort) {
		ScfBaseData.scfPort = scfPort;
	}

	/**
	 * @return the scfGlobalInfo
	 */
	public static ScfGlobalInfo getScfGlobalInfo() {
		return scfGlobalInfo;
	}

	/**
	 * @param scfGlobalInfo the scfGlobalInfo to set
	 */
	public static void setScfGlobalInfo(ScfGlobalInfo scfGlobalInfo) {
		ScfBaseData.scfGlobalInfo = scfGlobalInfo;
	}
	/**
	 * @return the loanWayFlag
	 */
	public static String getLoanWayFlag() {
		return loanWayFlag;
	}
	/**
	 * @param loanWayFlag the loanWayFlag to set
	 */
	public static void setLoanWayFlag(String loanWayFlag) {
		ScfBaseData.loanWayFlag = loanWayFlag;
	}
	/**
	 * @return the scfNoticeTypeData
	 */
	public static ScfNoticeTypeData getScfNoticeTypeData() {
		return scfNoticeTypeData;
	}
	/**
	 * @param scfNoticeTypeData the scfNoticeTypeData to set
	 */
	public static void setScfNoticeTypeData(ScfNoticeTypeData scfNoticeTypeData) {
		ScfBaseData.scfNoticeTypeData = scfNoticeTypeData;
	}
	/**
	 * @return the scfDbConnInfo
	 */
	public static ScfDbConnInfo getScfDbConnInfo() {
		return scfDbConnInfo;
	}
	/**
	 * @param scfDbConnInfo the scfDbConnInfo to set
	 */
	public static void setScfDbConnInfo(ScfDbConnInfo scfDbConnInfo) {
		ScfBaseData.scfDbConnInfo = scfDbConnInfo;
	}
	

}
