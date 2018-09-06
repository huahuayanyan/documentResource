package com.huateng.scf.bas.mrn.dao.ext;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnBussInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;

/**
 * 
 * <p>BMrnAppliAcctInfo数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月13日上午9:44:36
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月13日上午9:44:36	     新增
 *
 * </pre>
 */
public interface ExtBMrnDAO {

	List<BMrnAppliAcctInfo> queryMrnAppli(HashMap<String, String> omap, Page page);

	int countMrnAppli(HashMap<String, String> omap);

	List<BMrnAcctBussInfo> getTblCustAccountBussInfoByParam(HashMap<String, Object> omap, Page page);
	
	List<RBcpAppliBussInfo> getBailTransferQuery(HashMap<String, Object> omap, Page page);

	int countBailTransferQuery(HashMap<String, Object> omap);

	List<BMrnAcctBussInfo> queryAcctBussInfoList(HashMap<String, Object> omap);

	List<BMrnAcctBussInfo> getBillCustAccountInfoByParam(HashMap<String, Object> omap, Page page);

	int countBillCustAccountInfoByParam(HashMap<String, Object> omap);

	List<BMrnBussInfo> getBailTransferSerialQuery(HashMap<String, Object> omap, Page page);

	int countBailTransferSerialQuery(HashMap<String, Object> omap);

	int countAddBailAmountListByAppno(HashMap<String, Object> omap);

	@SuppressWarnings("rawtypes")
	List getAddBailAmountListByAppno(HashMap<String, Object> omap, Page page);

	int countWareMnAddByPara(HashMap<String, Object> omap);

	@SuppressWarnings("rawtypes")
	List getWareMnAddByPara(HashMap<String, Object> omap, Page page);

}