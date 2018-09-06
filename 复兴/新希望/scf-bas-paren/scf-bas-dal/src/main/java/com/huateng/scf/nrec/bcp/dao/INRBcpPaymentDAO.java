package com.huateng.scf.nrec.bcp.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;

public interface INRBcpPaymentDAO {

	public static final String BeanId = "NRBcpPaymentDAOImpl";

	List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> findBPrdInfoByVO(Map<String, Object> infoVO);

	List<BPbcAppliBaseInfo> findBPbcAppliBaseInfoByPage(Page p, Map<String, Object> value);

	List<BCrmBaseInfo> findBCrmBaseByPage(Map<String, Object> value, Page p);

	List<BCntBcpInfo> findBCntBcpInfoByPage(Map<String, Object> param, Page p);

	BCrmBaseInfo findBCrmBaseInfoByKey(String custcd);

	List findCancelRBcpDebtBaseInfoByPage(Map rBcpDebtBaseInfo, Page p);

	List<RBcpDebtInfo> findCancelRBcpDebtBaseInfoByPage2(Map rBcpDebtBaseInfo, Page p);

}
