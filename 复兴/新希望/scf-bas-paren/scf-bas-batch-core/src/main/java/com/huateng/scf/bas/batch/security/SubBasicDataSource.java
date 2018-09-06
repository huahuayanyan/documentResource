/**
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2007-2008 Huateng Software System.  All rights
 * reserved.
 * @author Maik.chen
 * create time :2008-02-11 18:23:38
 * ==================================================================
 */
package com.huateng.scf.bas.batch.security;



import org.apache.commons.dbcp.BasicDataSource;

import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.security.CryptionData;

/**
 * @author Administrator
 *
 */
public class SubBasicDataSource extends BasicDataSource {

	  /**
     * The connection password to be passed to our JDBC driver to establish
     * a connection.
     */
    //private String password ;
//    protected boolean restartNeeded;

    /**
     * Returns the password passed to the JDBC driver to establish connections.
     *
     * @return the connection password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * <p>Sets the {@link #password}.</p>
     * <p>Title ����--����
     * <p>
     * Note: this method currently has no effect once the pool has been
     * initialized.  The pool is initialized the first time one of the
     * following methods is invoked: <code>getConnection, setLogwriter,
     * setLoginTimeout, getLoginTimeout, getLogWriter.</code></p>
     *
     * @param password new value for the password
     */
    public  void setPassword(String password) {
    	CryptionData cryptionData =new CryptionData(BatchConstant.DEFAULT_PASSWORD_KEY);
        try {
			this.password =password; //cryptionData.DecryptionStringData(password).trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //this.restartNeeded = true;
    }





}
