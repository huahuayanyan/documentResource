/**
 * 
 */
package com.huateng.scf.bas.common.util;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * <p>读取jar包工具类</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月7日下午7:34:58
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月7日下午7:34:58	                                 新增
 *
 * </pre>
 */
public class ReadJarFileUtil {
	public static String getMessageByJar(String classpath, String filename,
			String subfix, String key, Object[] arguments) {
		ReadJarFileUtil rjf = new ReadJarFileUtil();
		String qualifiedfileName = classpath + filename + subfix;
		InputStream inCfg = rjf.getClass().getClassLoader()
				.getResourceAsStream(qualifiedfileName);
		Properties prop = new Properties();
		try {
			prop.load(inCfg);
		} catch (Exception e) {
		}
		String value = prop.getProperty(key.toUpperCase());
		if ((arguments != null) && (arguments.length > 0)) {
			value = MessageFormat.format(value, arguments);
		}

		return value;
	}

	public static String getMessageByJar(String classpath, String filename,
			String subfix, String key) {
		return getMessageByJar(classpath, filename, subfix, key, null);
	}
}
