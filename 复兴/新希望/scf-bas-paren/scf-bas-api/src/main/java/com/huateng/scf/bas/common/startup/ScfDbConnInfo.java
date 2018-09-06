/**
 * 
 */
package com.huateng.scf.bas.common.startup;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年5月17日上午9:50:40
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年5月17日上午9:50:40              新增
 *
 * </pre>
 */
public class ScfDbConnInfo {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	
	public ScfDbConnInfo() {
		
	}
	public ScfDbConnInfo(String driverClassName, String url, String username, String password,
			String noticeType_88) {
		this.driverClassName = driverClassName;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	/**
	 * @return the driverClassName
	 */
	public String getDriverClassName() {
		return driverClassName;
	}
	/**
	 * @param driverClassName the driverClassName to set
	 */
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

}
