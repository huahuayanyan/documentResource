/*
 * 创建日期 2007-5-10
 *
 * 更改所生成文件模板为
 * 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
package com.huateng.scf.bas.batch.common;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.security.auth.Subject;

/**

 * <p>@Title: 交通银行个人贷款管理系统</p>

 * <p>@Description:

 * <t>@描述：</t></p>

 * <p>@Created time: 2007-5-10</p>

 * <p>@Company:上海华腾软件系统有限公司</p>

 * <p>@author ShaoZhiGang</p>

 * <p>2007-5-10</p>

 */
public class GlobalInfo implements Serializable {



	public static String KEY_GLOBAL_INFO = "GLOBAL_INFO";



	private String tlrNo = null; //操作员号

	private Vector userRoles = null; //操作员岗位号

	private String brCode = null; //机构号

	private String upBrCode = null; //所属分行号

	private String tlsrNo = null; //流水号

	private String tlsrNoPr = null ; //主流水号

	private String tlsrNoEx = null; //次流水号

	private long tlsrIndex = 0 ; //次流水索引

	private Date txDate = null; //会计日期

	private Time txTime = null; //时间

	private int funcCode = BatchConstant.FUNC_CODE ; //功能号

	private Subject subject = null; //CUR的context的SUBJECT

	private String ip = null ;//IP

	private String errCode = null ;//返回码

	private String contractno = null; //合同号

	private String custcd = null; //客户号

	private String appno = null; //申请标号

	private double txamt = 0; //金额

	private String authNo = null; //授权主管号

	private String authPasswd =null;//授权主管密码

	private String channel=null;//渠道

	private String sessionID = null; //session id


	public GlobalInfo() {

	}



	/**

	 * @return

	 */

	public String getBrCode() {

		return brCode;

	}



	/**

	 * @return

	 */

	public int getFuncCode() {

		return funcCode;

	}



	/**

	 * @return

	 */

	public String getIp() {

		return ip;

	}



	/**

	 * @return

	 */

	public String getErrCode() {

		return errCode;

	}



	/**

	 * @return

	 */

	public Subject getSubject() {

		return subject;

	}



	/**

	 * @return

	 */

	public String getTlrNo() {

		return tlrNo;

	}



	/**

	 * @return

	 */

	public String getTlsrNo() {

		return tlsrNo;

	}



	/**

	 * 获取业务流水号，流水规则：主流水号（6）+次流水号（4）

	 *

	 * @param

	 * 		String tlsrNoEx	:	次流水号（4）

	 *

	 * @return

	 * 		返回业务流水号

	 *

	 */

	public String getTlsrNoByTlsrNoEx(String newTlsrNoEx) {

		tlsrNoEx = newTlsrNoEx ;

		tlsrNo = tlsrNoPr + tlsrNoEx ;

		tlsrIndex = Long.parseLong(newTlsrNoEx) ;

		return tlsrNo ;

	}



	/**

	 * 获取下一个业务流水号，流水规则：主流水号（6）+次流水号（4）

	 *

	 * @param

	 *

	 *

	 * @return

	 * 		返回业务流水号

	 *

	 */

	public String getNextTlsrNo() {



		DecimalFormat df = new DecimalFormat("0000");

		tlsrNoEx = df.format(tlsrIndex);

		tlsrNo = tlsrNoPr + tlsrNoEx ;

		tlsrIndex ++ ;

		if(9999 < tlsrIndex)

			tlsrIndex = 0 ;

		return tlsrNo ;

	}





	/**

	 * @return

	 */

	public String getTlsrNoEx() {

		return tlsrNoEx;

	}



	/**

	 * @return

	 */

	public String getTlsrNoPr() {

		return tlsrNoPr;

	}



	/**

	 * @return

	 */

	public Date getTxDate() {

		return txDate;

	}



	/**

	 * @return

	 */

	public Time getTxTime() {

		return txTime;

	}



	/**

	 * @return

	 */

	public String getUpBrCode() {

		return upBrCode;

	}



	/**

	 * @return

	 */

	public Vector getUserRoles() {

		return userRoles;

	}



	/**

	 * @param string

	 */

	public void setBrCode(String string) {

		brCode = string;

	}



	/**

	 * @param string

	 */

	public void setFuncCode(int d) {

		funcCode = d;

	}



	/**

	 * @param string

	 */

	public void setIp(String string) {

		ip = string;

	}



	/**

	 * @param string

	 */

	public void setErrCode(String string) {

		errCode = string;

	}



	/**

	 * @param subject

	 */

	public void setSubject(Subject subject) {

		this.subject = subject;

	}



	/**

	 * @param string

	 */

	public void setTlrNo(String string) {

		tlrNo = string;

	}



	/**

	 * @param string

	 */

	public void setTlsrNo(String string) {

		tlsrNo = string;

	}



	/**

	 * @param string

	 */

	public void setTlsrNoEx(String string) {

		tlsrNoEx = string;

	}



	/**

	 * @param string

	 */

	public void setTlsrNoPr(String string) {

		tlsrNoPr = string;

	}



	/**

	 * @param date

	 */

	public void setTxDate(Date date) {

		txDate = date;

	}



	/**

	 * @param time

	 */

	public void setTxTime(Time time) {

		txTime = time;

	}



	/**

	 * @param string

	 */

	public void setUpBrCode(String string) {

		upBrCode = string;

	}



	/**

	 * @param vector

	 */

	public void setUserRoles(Vector vector) {

		userRoles = vector;

	}



	/**

	 * @return

	 */

	public String getAppno() {

		return appno;

	}



	/**

	 * @return

	 */

	public String getContractno() {

		return contractno;

	}



	/**

	 * @return

	 */

	public String getCustcd() {

		return custcd;

	}



	/**

	 * @return

	 */

	public double getTxamt() {

		return txamt;

	}



	/**

	 * @param string

	 */

	public void setAppno(String string) {

		appno = string;

	}



	/**

	 * @param string

	 */

	public void setContractno(String string) {

		contractno = string;

	}



	/**

	 * @param string

	 */

	public void setCustcd(String string) {

		custcd = string;

	}



	/**

	 * @param string

	 */

	public void setTxamt(double amt) {

		txamt = amt;

	}



	/**

	 * @return

	 */

	public String getSessionID() {

		return sessionID;

	}



	/**

	 * @param string

	 */

	public void setSessionID(String string) {

		sessionID = string;

	}



	/**

	 * @Title:

	 * @Description:

	 * @return

	 * @author Ranger.Mao

	 * @Created time: Mar 3, 2005 4:26:38 PM

	 */

	public String getAuthNo() {

		return authNo;

	}



	/**

	 * @Title:

	 * @Description:

	 * @return

	 * @author Ranger.Mao

	 * @Created time: Mar 3, 2005 4:26:39 PM

	 */

	public String getAuthPasswd() {

		return authPasswd;

	}



	/**

	 * @Title:

	 * @Description:

	 * @param string

	 * @author Ranger.Mao

	 * @Created time: Mar 3, 2005 4:26:39 PM

	 */

	public void setAuthNo(String string) {

		authNo = string;

	}



	/**

	 * @Title:

	 * @Description:

	 * @param string

	 * @author Ranger.Mao

	 * @Created time: Mar 3, 2005 4:26:39 PM

	 */

	public void setAuthPasswd(String string) {

		authPasswd = string;

	}



	/**

	 * @return

	 */

	public String getChannel() {

		return channel;

	}



	/**

	 * @param string

	 */

	public void setChannel(String string) {

		channel = string;

	}

}
