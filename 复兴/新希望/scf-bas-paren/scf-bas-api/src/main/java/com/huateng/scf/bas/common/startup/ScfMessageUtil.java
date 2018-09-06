/**
 * 
 */
package com.huateng.scf.bas.common.startup;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.huateng.scf.bas.common.util.ContextUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.sys.service.IBSysQueryLimitsService;
import com.huateng.scube.exception.ScubeBizException;

/**
 * <p>全局消息工具类</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月10日上午10:53:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月10日上午10:53:46	                                 新增
 *
 * </pre>
 */
public class ScfMessageUtil {
	/**
	 * 根据消息Key和传入的参数，返回翻译后的错误消息。
	 * @param messageKey
	 * 		 String-该消息在scf_bas_error.properties文件中定义的key
	 * @param params
	 * 		Object[]-该消息需要的参数
	 * @return 翻译后的错误消息
	 */
	public static String transErrMsgByKeyParams(String messageKey, Object params[]) {
		Properties systemErrorProps=ScfBaseEnv.getInstance().getSystemErrorProps();
		if(null==systemErrorProps) {
			return messageKey;
		}
		String errMsg=systemErrorProps.getProperty(messageKey);
		MessageFormat messageFormat = new MessageFormat(errMsg);
		String resutlMsg=null;
		if(null==params){
			return errMsg;
		}
		resutlMsg=messageFormat.format(params);
		return resutlMsg;
	}
	/**
	 * 根据消息Key，返回对应中文的错误消息。
	 * @param messageKey
	 * @return 翻译后的错误消息
	 */
	public static String transErrMsgByKey(String messageKey) {
		Properties systemErrorProps=ScfBaseEnv.getInstance().getSystemErrorProps();
		if(null==systemErrorProps) {
			return messageKey;
		}
		String errMsg=systemErrorProps.getProperty(messageKey);
		return StringUtil.isStrEmpty(errMsg) ? messageKey : errMsg;
	}
	/**
	 * 根据消息Key，返回对应配置信息
	 * @param messageKey
	 * @return 对应配置信息
	 */
	public static String transSysMsgByKey(String messageKey) {
		Properties systemProps=ScfBaseEnv.getInstance().getSystemProps();
		if(null==systemProps) {
			return messageKey;
		}
		String sysMsg=systemProps.getProperty(messageKey);
		return StringUtil.isStrEmpty(sysMsg) ? messageKey : sysMsg;
	}

	@SuppressWarnings("rawtypes")
	public static HashMap<String, List<String>> transSysParamByKey(String messageKey)
	{
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		Properties systemProps=ScfBaseEnv.getInstance().getSystemProps();
		if(null==systemProps) {
			return null;
		}
		String sysMsg = systemProps.getProperty(messageKey);
		if(StringUtil.isEmpty(sysMsg))
		{
			return null;
		}
		try
		{
			Class c = Class.forName(sysMsg);
			IBSysQueryLimitsService ser=(IBSysQueryLimitsService)ContextUtil.getBean(c.getSimpleName());
			map = ser.getTlrNoListByRoleModel();//获取参数信息
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			throw new ScubeBizException(e);
		}
		return map;
	}
}
