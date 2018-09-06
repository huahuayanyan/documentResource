package com.huateng.scf.nrec.bcp.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.dcr.model.BDcrLinInf;
import com.huateng.scf.bas.icr.dao.domodel.BIcrInfoDO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.pbc.dao.model.ext.BPbcAppliBaseInfoDO;
import com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpAppliBaseInfoDO;
import com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO;
import com.huateng.scf.nrec.bcp.dao.domodel.RBcpDuebillAppDO;
import com.huateng.scf.nrec.bcp.dao.domodel.RBcpDuebillRegisterDO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;

public interface ExtNrecBcpDAO {

	int countBCntBcpInfoByPage(HashMap<String, Object> omap);

	List<BCntBcpInfoDO> queryBCntBcpInfoByPage(HashMap<String, Object> omap, Page page, boolean flag);

	int countRBcpDuebillApp(HashMap<String, Object> omap);

	List<RBcpDuebillAppDO> queryRBcpDuebillApp(HashMap<String, Object> omap, Page page);

	List<BCrmBaseInfo> queryBCrmBaseInfoSource(Map<String, Object> omap, Page page);

	int countBCrmBaseInfoSource(Map<String, Object> omap);

	/***
	 * 应收账款转让新增按钮对应的单据信息筛选
	 */
	List<RBcpDebtInfo> getDebtInvoiceInfoNTransfer(Map<String, Object> map, Page page);

	/***
	 * 应收类商纠解除
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	List<RBcpDebtInfo> getDebtInvoiceInfoRemove(Map<String, Object> map, Page page);

	/***
	 * 商纠登记
	 */
	List<RBcpDebtInfo> getDebtInvoiceInfoRegister(Map<String, Object> map, Page page);

	/**
	 * 出池入合并
	 * 
	 * @param map
	 * @param page
	 * @return
	 * @author lihao
	 * @date 2017年6月20日下午7:34:49
	 */
	List<RBcpDebtInfo> getDebtInvoiceInfoForPoolManage(Map<String, Object> map, Page page);

	int countCustBIcrInfo(HashMap<String, Object> omap);

	List<BDcrLinInf> queryCustBIcrInfo(HashMap<String, Object> omap, Page page);

	int countInvoiceFinancingAddQry(HashMap<String, Object> omap);

	List<RBcpDebtInfo> getInvoiceFinancingAddQry(HashMap<String, Object> omap, Page page);

	int countRBcpDuebillRegister(HashMap<String, Object> omap);

	List<RBcpDuebillRegisterDO> queryRBcpDuebillRegister(HashMap<String, Object> omap, Page page);

	int countDebtInfoQuery(HashMap<String, Object> omap);

	List<RBcpDebtInfo> getDebtInfoQuery(HashMap<String, Object> omap, Page page, boolean flag);

	int countDebtInvoiceInfoPressing(HashMap<String, Object> omap);

	List<RBcpDebtInfo> getDebtInvoiceInfoPressing(HashMap<String, Object> omap, Page page);

	int countInvoiceDebtBackAddQry(HashMap<String, Object> omap);

	List<RBcpDebtInfo> getInvoiceDebtBackAddQry(HashMap<String, Object> omap, Page page, boolean flag);

	int countInvoiceChargeOffAddQry(HashMap<String, Object> omap);

	List<RBcpDebtInfo> getInvoiceChargeOffAddQry(HashMap<String, Object> omap, Page page, boolean flag);

	int countInvoiceAllowanceAddQry(HashMap<String, Object> omap);

	List<RBcpDebtInfo> getInvoiceAllowanceAddQry(HashMap<String, Object> omap, Page page, boolean flag);

	List<BLanLnciBase> queryLnciInfoByMastContno(HashMap<String, Object> omap);

	List<HashMap<String, Object>> getFlowRiskAmtByMastContno(HashMap<String, Object> omap);

	int countBCrmBaseBusinessInfo(Map<String, Object> omap);

	List<BCrmBaseInfo> queryBCrmBaseBusinessInfo(Map<String, Object> omap, Page page);

	/**
	 * 连表查询额度信息
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午1:57:23
	 */
	int countTblCreditInfoByCreditQryVO(HashMap<String, Object> omap);

	/**
	 * 连表查询额度信息
	 * @param omap
	 * @param page
	 * @param pageFlag
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午1:57:32
	 */
	List<BIcrInfoDO> getTblCreditInfoByCreditQryVO(HashMap<String, Object> omap, Page page, boolean flag);

	/**
	 * 根据合同编号查询应收账款金额总值
	 * @param mastContno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月5日上午9:21:53
	 */
	RBcpDebtInfo findSumRBcpDebtInfoByMastContno(RBcpDebtInfo bcpDebtInfo);

	/**
	 * 查询业务申请总数
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月7日下午2:45:36
	 */
	int countBCntBcpAppliBaseInfoByPage(HashMap<String, Object> omap);

	/**
	 * 查询业务申请列表信息
	 * @param omap
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月7日下午2:45:26
	 */
	List<BCntBcpAppliBaseInfoDO> findBCntBcpAppliBaseInfoByPage(HashMap<String, Object> omap, Page page);

	/**
	 * 根据业务申请类型及其它参数获取业务申请信息（条数）
	 * @param value
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月12日下午3:41:51
	 */
	int countBPbcAppliBaseInfoByParam(HashMap<String, Object> value);

	/**
	 * 根据业务申请类型及其它参数获取业务申请信息
	 * @param value
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月12日下午3:42:19
	 */
	List<BPbcAppliBaseInfoDO> findBPbcAppliBaseInfoByParam(HashMap<String, Object> value, Page page);

	/**
	 * 根据条件查询应收账款信息（个数）
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月19日下午3:18:23
	 */
	int countRBcpDebtInfo(HashMap<String, Object> omap);

	/**
	 * 根据条件查询应收账款信息
	 * @param omap
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月19日下午3:19:05
	 */
	List<RBcpDebtInfo> findRBcpDebtInfoByPage(HashMap<String, Object> omap, Page page);

	/**
	 * 查询池融资放款流程中的应收账款信息
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月20日下午4:48:47
	 */
	List<RBcpDebtInfo> findInDuebillAppFlowRBcpDebtInfoByParam(HashMap<String, Object> omap);
}
