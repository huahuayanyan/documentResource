package com.huateng.scf.bas.batch.common;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanCopyUtil extends BeanUtilsBean {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	private static final BeanCopyUtil util=new BeanCopyUtil();
	
	private BeanCopyUtil(){
	}
	
	public static BeanCopyUtil getInstance(){
		return util;
	}
	
	/* 
	 * 从orig值copy到dest
	 */
	public  void copyProperties(Object dest, Object orig)
	        throws IllegalAccessException, InvocationTargetException {

	        // Validate existence of the specified beans
	        if (dest == null) {
	            throw new IllegalArgumentException
	                    ("No destination bean specified");
	        }
	        if (orig == null) {
	            throw new IllegalArgumentException("No origin bean specified");
	        }
	        if (log.isDebugEnabled()) {
	            log.debug("BeanUtils.copyProperties(" + dest + ", " +
	                      orig + ")");
	        }

	        // Copy the properties, converting as necessary
	        if (orig instanceof DynaBean) {
	            DynaProperty[] origDescriptors =
	                ((DynaBean) orig).getDynaClass().getDynaProperties();
	            for (int i = 0; i < origDescriptors.length; i++) {
	                String name = origDescriptors[i].getName();
	                // Need to check isReadable() for WrapDynaBean
	                // (see Jira issue# BEANUTILS-61)
	                if (getPropertyUtils().isReadable(orig, name) &&
	                    getPropertyUtils().isWriteable(dest, name)) {
	                    Object value = ((DynaBean) orig).get(name);
	                    if(value!=null){
	                    	copyProperty(dest, name, value);
	                    }
	                }
	            }
	        } else if (orig instanceof Map) {
	            Iterator entries = ((Map) orig).entrySet().iterator();
	            while (entries.hasNext()) {
	                Map.Entry entry = (Map.Entry) entries.next();
	                String name = (String)entry.getKey();
	                if (getPropertyUtils().isWriteable(dest, name)) {
	                    copyProperty(dest, name, entry.getValue());
	                }
	            }
	        } else /* if (orig is a standard JavaBean) */ {
	            PropertyDescriptor[] origDescriptors =
	                getPropertyUtils().getPropertyDescriptors(orig);
	            for (int i = 0; i < origDescriptors.length; i++) {
	                String name = origDescriptors[i].getName();
	                if ("class".equals(name)) {
	                    continue; // No point in trying to set an object's class
	                }
	                if (getPropertyUtils().isReadable(orig, name) &&
	                    getPropertyUtils().isWriteable(dest, name)) {
	                    try {
	                        Object value =
	                            getPropertyUtils().getSimpleProperty(orig, name);
	                        if(value!=null){
		                    	copyProperty(dest, name, value);
		                    }
	                    } catch (NoSuchMethodException e) {
	                        // Should not happen
	                    }
	                }
	            }
	        }

	    }
}
