/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.scf.bas.batch.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigMap {
	private Map configMap = new LinkedHashMap();

	public String get(String key) {
		Object value = configMap.get(key);
		if(value == null) return "";
		return value.toString();
	}

	public Object getObject(String key) {
		return configMap.get(key);
	}

	public Map getConfigMap() {
		return configMap;
	}

	public void setConfigMap(Map configMap) {
		this.configMap = configMap;
	}
}

