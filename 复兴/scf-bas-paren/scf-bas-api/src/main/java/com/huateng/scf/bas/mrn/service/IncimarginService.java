package com.huateng.scf.bas.mrn.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * 
 * <p>IncimarginService接口类</p>
 *
 * @author 	yangdong
 * @date 	2016年12月8日下午8:23:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月8日下午8:23:11	     新增
 *
 * </pre>
 */
public interface IncimarginService {

	public Page findBLanLnciBaseList(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bLanLnciBase") BLanLnciBase bLanLnciBase);


	public  String marginApplySaveUpdate(@ScubeParam("bmrnAppliAcctInfo") BMrnAppliAcctInfo bmrnAppliAcctInfo);
	
	public BLanLnciBase queryIncimarginLoan(@ScubeParam("appno") String appno) ;
	
	public BMrnAppliAcctInfo queryIncimargin(@ScubeParam("appno")String appno);
	
	public void marginApplySubmit(@ScubeParam("bmrnAppliAcctInfo") BMrnAppliAcctInfo bmrnAppliAcctInfo) ;
	
	public void saveBailTransferApplySingle(@ScubeParam("bmrnAppliAcctInfo") BMrnAppliAcctInfo bmrnAppliAcctInfo);
}
