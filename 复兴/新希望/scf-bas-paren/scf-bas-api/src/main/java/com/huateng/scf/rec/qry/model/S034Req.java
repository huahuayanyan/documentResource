package com.huateng.scf.rec.qry.model;


/**
 * 文件名：S034Req.java
 * 功能描述：核心前台账号入账查询－输入信息
 * 创建日期: 2013-7-13
 * 创建人: zhonghuabin
 * JDK版本: <1.5.0>
 * 程序版本: SupplyChainSysPortal <1.0> <br>
 * 修改历史 <br>
 *  date           | author  | desc <br>
 */
public class S034Req {
	private HeadBean headBean;
	private S034ReqData data;

	public HeadBean getHeadBean() {
		return headBean;
	}
	public void setHeadBean(HeadBean headBean) {
		this.headBean = headBean;
	}
	public S034ReqData getData() {
		return data;
	}
	public void setData(S034ReqData data) {
		this.data = data;
	}

}
