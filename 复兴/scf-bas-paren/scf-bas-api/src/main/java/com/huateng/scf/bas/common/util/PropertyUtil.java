/**
 * 
 */
package com.huateng.scf.bas.common.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import com.huateng.scf.bas.common.startup.ScfBaseData;

/**
 * <p>properties文件操作工具类</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月7日下午7:33:03
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月7日下午7:33:03	                                 新增
 *
 * </pre>
 */
public class PropertyUtil {
	public static final String PROPERTY_LIST_SIZE_KEY = "size";
	public static final String PROPERTY_NAME_KEY = "name";
	public static final String PROPERTY_VALUE_KEY = "value";

	public static synchronized Properties init(String sPropFile) {
		Properties props = new Properties();
		ResourceBundle bundle = ResourceBundle.getBundle(sPropFile);
		Enumeration enums = bundle.getKeys();
		Object key = null;
		Object value = null;
		while (enums.hasMoreElements()) {
			key = enums.nextElement();
			value = bundle.getString(key.toString());
			props.put(key, value);
		}
		bundle = null;
		return props;
	}

	public static ArrayList loadIndexedProperties(Properties props,
			String propKey, boolean isNameValuePair) {
		ArrayList propList = null;
		try {
			String cursorKey = propKey + "." + "size";
			String propSize = props.getProperty(cursorKey);
			if (propSize == null) {
				return null;
			}

			int size = Integer.parseInt(propSize);
			if (size <= 0) {
				return null;
			}

			propList = new ArrayList();
			String[] strCodes = new String[size];
			String[] strNames = new String[size];
			String cursorValue = null;

			if (!isNameValuePair) {
				for (int i = 0; i < size; i++) {
					cursorKey = propKey + "." + i;
					cursorValue = props.getProperty(cursorKey);
					if (cursorValue != null) {
						strCodes[i] = cursorValue;
						strNames[i] = cursorValue;
					} else {
						System.out.println("cannot get value for property:"
								+ cursorKey);
						strCodes[i] = "";
						strNames[i] = "";
					}
				}
			} else {
				String cursorName = null;
				for (int i = 0; i < size; i++) {
					cursorKey = propKey + "." + "value" + "." + i;
					cursorName = props.getProperty(cursorKey);

					cursorKey = propKey + "." + "name" + "." + i;
					cursorValue = props.getProperty(cursorKey);

					if ((cursorName != null) && (cursorValue != null)) {
						strCodes[i] = cursorName;
						strNames[i] = cursorValue;
					} else {
						System.out.println("cannot get value for property:"
								+ propKey + "[" + i + "]");
						strCodes[i] = "";
						strNames[i] = "";
					}
				}
			}
			propList.add(strCodes);
			propList.add(strNames);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return propList;
	}

	protected static String parserFileName(String name) {
		if ((name == null) || (name.trim().length() == 0))
			return null;
		String[] splits = name.split("_");
		if ((splits == null) || (splits.length < 3)) {
			return null;
		}
		return splits[1].toLowerCase();
	}



	public static String getPropertyByKey(String msgkey, Locale locale) {
		String _fileDir = ScfBaseData.getInstance().getMsg_file_path();
		String filepath = _fileDir.replace('.', '/') + "/";
		return ReadJarFileUtil.getMessageByJar(filepath,
				"msg-"
						+ parserFileName(msgkey)
						+ "_"
						+ (locale != null ? locale.toString() : Locale
								.getDefault().toString()), ".properties",
				msgkey);
	}
//	public static void main(String[] args){
//		PropertyUtil pro=new PropertyUtil();
//		String serverPath=pro.getClass().getClassLoader().getResource("").getPath();
//		System.out.println("=========================>>serverPath0:"+serverPath);
//		if(serverPath.endsWith("/")||serverPath.endsWith(".xml")){
//			serverPath=serverPath.substring(0, serverPath.indexOf("WEB-INF")-1);
//		}else{
//			serverPath=serverPath.substring(0, serverPath.indexOf("WEB-INF"));
//		}
//		System.out.println("=========================>>serverPath1:"+serverPath);
//		Thread.currentThread().getContextClassLoader().getResource("");
//		InputStream is = pro.getClass().getResourceAsStream("/config/log/log4j_config.xml");
//		System.out.println("=======================>>is:"+is);
//	}
}
