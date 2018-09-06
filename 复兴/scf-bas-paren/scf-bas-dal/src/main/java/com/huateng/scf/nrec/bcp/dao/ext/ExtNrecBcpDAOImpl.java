package com.huateng.scf.nrec.bcp.dao.ext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
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

@Repository("ExtNrecBcpDAO")
public class ExtNrecBcpDAOImpl extends IbatisDaoAnnotation4Template implements ExtNrecBcpDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	@Override
	public int countBCntBcpInfoByPage(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countBCntBcpInfoByPage", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCntBcpInfoDO> queryBCntBcpInfoByPage(HashMap<String, Object> omap, Page page, boolean flag) {
		List<BCntBcpInfoDO> list = new ArrayList<BCntBcpInfoDO>();
		if (flag) {
			list = this.searchListPageMyObject("EXT_NREC_BCP.queryBCntBcpInfoByPage", omap, page);
		} else {
			list = getSqlMapClientTemplate().queryForList("EXT_NREC_BCP.queryBCntBcpInfoByPage", omap);
		}
		return list;
	}

	@Override
	public int countRBcpDuebillApp(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countRBcpDuebillApp", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDuebillAppDO> queryRBcpDuebillApp(HashMap<String, Object> omap, Page page) {
		List<RBcpDuebillAppDO> list = this.searchListPageMyObject("EXT_NREC_BCP.queryRBcpDuebillApp", omap, page);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCrmBaseInfo> queryBCrmBaseInfoSource(Map<String, Object> omap, Page page) {
		List<BCrmBaseInfo> list = this.searchListPageMyObject("EXT_NREC_BCP.queryBCrmBaseInfoSource", omap, page);
		return list;
	}

	@Override
	public int countBCrmBaseInfoSource(Map<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countBCrmBaseInfoSource", omap);
		return count;
	}
	
	@Override
	public int countBCrmBaseBusinessInfo(Map<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countBCrmBaseBusinessInfo", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCrmBaseInfo> queryBCrmBaseBusinessInfo(Map<String, Object> omap, Page page) {
		List<BCrmBaseInfo> list = this.searchListPageMyObject("EXT_NREC_BCP.queryBCrmBaseBusinessInfo", omap, page);
		return list;
	}

	/**
	 * 应收类转让添加发票信息查询
	 */
	@SuppressWarnings("unchecked")
	public List<RBcpDebtInfo> getDebtInvoiceInfoNTransfer(Map<String, Object> map, Page page) {
		List<RBcpDebtInfo> list = this.searchListPageMyObject("EXT_R_BCP_DEBT_INFO.getDebtInvoiceInfoNTransfer", map, page);
		return list;
	}

	@Override
	public int countCustBIcrInfo(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countCustBIcrInfo", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BDcrLinInf> queryCustBIcrInfo(HashMap<String, Object> omap, Page page) {
		List<BDcrLinInf> list = this.searchListPageMyObject("EXT_NREC_BCP.queryCustBIcrInfo", omap, page);
		return list;
	}

	@Override
	public int countInvoiceFinancingAddQry(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countInvoiceFinancingAddQry", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtInfo> getInvoiceFinancingAddQry(HashMap<String, Object> omap, Page page) {
		List<RBcpDebtInfo> list = this.searchListPageMyObject("EXT_NREC_BCP.getInvoiceFinancingAddQry", omap, page);
		return list;
	}

	@Override
	public int countRBcpDuebillRegister(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countRBcpDuebillRegister", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDuebillRegisterDO> queryRBcpDuebillRegister(HashMap<String, Object> omap, Page page) {
		List<RBcpDuebillRegisterDO> list = this.searchListPageMyObject("EXT_NREC_BCP.queryRBcpDuebillRegister", omap, page);
		return list;
	}

	@Override
	public int countDebtInfoQuery(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countDebtInfoQuery", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtInfo> getDebtInfoQuery(HashMap<String, Object> omap, Page page, boolean flag) {
		List<RBcpDebtInfo> list = new ArrayList<RBcpDebtInfo>();
		if (flag) {
			list = this.searchListPageMyObject("EXT_NREC_BCP.getDebtInfoQuery", omap, page);
		} else {
			list = getSqlMapClientTemplate().queryForList("EXT_NREC_BCP.getDebtInfoQuery", omap);
		}
		return list;
	}

	@Override
	public int countDebtInvoiceInfoPressing(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countDebtInvoiceInfoPressing", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtInfo> getDebtInvoiceInfoPressing(HashMap<String, Object> omap, Page page) {
		List<RBcpDebtInfo> list = this.searchListPageMyObject("EXT_NREC_BCP.getDebtInvoiceInfoPressing", omap, page);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RBcpDebtInfo> getDebtInvoiceInfoRegister(Map<String, Object> map, Page page) {
		List<RBcpDebtInfo> list = this.searchListPageMyObject("EXT_R_BCP_DEBT_INFO.getDebtInvoiceInfoRegister", map, page);
		return list;
	}

	@Override
	public int countInvoiceDebtBackAddQry(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countInvoiceDebtBackAddQry", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtInfo> getInvoiceDebtBackAddQry(HashMap<String, Object> omap, Page page, boolean flag) {
		List<RBcpDebtInfo> list = new ArrayList<RBcpDebtInfo>();
		if (flag) {
			list = this.searchListPageMyObject("EXT_NREC_BCP.getInvoiceDebtBackAddQry", omap, page);
		} else {
			list = getSqlMapClientTemplate().queryForList("EXT_NREC_BCP.getInvoiceDebtBackAddQry", omap);
		}
		return list;
	}

	@Override
	public int countInvoiceChargeOffAddQry(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countInvoiceChargeOffAddQry", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtInfo> getInvoiceChargeOffAddQry(HashMap<String, Object> omap, Page page, boolean flag) {
		List<RBcpDebtInfo> list = new ArrayList<RBcpDebtInfo>();
		if (flag) {
			list = this.searchListPageMyObject("EXT_NREC_BCP.getInvoiceChargeOffAddQry", omap, page);
		} else {
			list = getSqlMapClientTemplate().queryForList("EXT_NREC_BCP.getInvoiceChargeOffAddQry", omap);
		}
		return list;
	}

	@Override
	public int countInvoiceAllowanceAddQry(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countInvoiceAllowanceAddQry", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtInfo> getInvoiceAllowanceAddQry(HashMap<String, Object> omap, Page page, boolean flag) {
		List<RBcpDebtInfo> list = new ArrayList<RBcpDebtInfo>();
		if (flag) {
			list = this.searchListPageMyObject("EXT_NREC_BCP.getInvoiceAllowanceAddQry", omap, page);
		} else {
			list = getSqlMapClientTemplate().queryForList("EXT_NREC_BCP.getInvoiceAllowanceAddQry", omap);
		}
		return list;
	}

	// 商纠解除
	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtInfo> getDebtInvoiceInfoRemove(Map<String, Object> map, Page page) {
		List<RBcpDebtInfo> list = this.searchListPageMyObject("EXT_R_BCP_DEBT_INFO.getDebtInvoiceInfoRemove", map, page);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBase> queryLnciInfoByMastContno(HashMap<String, Object> omap) {
		List<BLanLnciBase> list = getSqlMapClientTemplate().queryForList("EXT_NREC_BCP.queryLnciInfoByMastContno", omap);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, Object>> getFlowRiskAmtByMastContno(HashMap<String, Object> omap) {
		List<HashMap<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_NREC_BCP.getFlowRiskAmtByMastContno", omap);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RBcpDebtInfo> getDebtInvoiceInfoForPoolManage(Map<String, Object> map, Page page) {
		List<RBcpDebtInfo> list = this.searchListPageMyObject("EXT_R_BCP_DEBT_INFO.getDebtInvoiceInfoForPoolManage", map, page);
		return list;
	}

	/**
	 * 连表查询额度信息
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午1:57:23
	 */
	@Override
	public int countTblCreditInfoByCreditQryVO(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countTblCreditInfoByCreditQryVO", omap);
		return count;
	}
	
	/**
	 * 连表查询额度信息
	 * @param omap
	 * @param page
	 * @param pageFlag
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午1:57:32
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BIcrInfoDO> getTblCreditInfoByCreditQryVO(HashMap<String, Object> omap, Page page, boolean flag) {
		List<BIcrInfoDO> list = new ArrayList<BIcrInfoDO>();
		if (flag) {
			list = this.searchListPageMyObject("EXT_NREC_BCP.getTblCreditInfoByCreditQryVO", omap, page);
		} else {
			list = getSqlMapClientTemplate().queryForList("EXT_NREC_BCP.getTblCreditInfoByCreditQryVO", omap);
		}
		return list;
	}

	/**
	 * 根据合同编号查询应收账款金额总值
	 * @param mastContno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月5日上午9:21:53
	 */
	@Override
	public RBcpDebtInfo findSumRBcpDebtInfoByMastContno(RBcpDebtInfo bcpDebtInfo) {
		 RBcpDebtInfo record = (RBcpDebtInfo) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.findSumRBcpDebtInfoByMastContno", bcpDebtInfo);
		 return record;
	}

	@Override
	public int countBCntBcpAppliBaseInfoByPage(HashMap<String, Object> omap)
	{
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countBCntBcpAppliBaseInfoByPage", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCntBcpAppliBaseInfoDO> findBCntBcpAppliBaseInfoByPage(HashMap<String, Object> omap, Page page)
	{
		List<BCntBcpAppliBaseInfoDO> list = this.searchListPageMyObject("EXT_NREC_BCP.findBCntBcpAppliBaseInfoByPage", omap, page);
		return list;
	}

	/**
	 * 根据业务申请类型及其它参数获取业务申请信息（条数）
	 * @param value
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月12日下午3:41:51
	 */
	@Override
	public int countBPbcAppliBaseInfoByParam(HashMap<String, Object> value)
	{
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countBPbcAppliBaseInfoByParam", value);
		return count;
	}

	/**
	 * 根据业务申请类型及其它参数获取业务申请信息
	 * @param value
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月12日下午3:42:19
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BPbcAppliBaseInfoDO> findBPbcAppliBaseInfoByParam(HashMap<String, Object> value, Page page)
	{
		List<BPbcAppliBaseInfoDO> list = this.searchListPageMyObject("EXT_NREC_BCP.findBPbcAppliBaseInfoByParam", value, page);
		return list;
	}

	@Override
	public int countRBcpDebtInfo(HashMap<String, Object> omap)
	{
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BCP.countRBcpDebtInfo", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtInfo> findRBcpDebtInfoByPage(HashMap<String, Object> omap, Page page)
	{
		List<RBcpDebtInfo> list = this.searchListPageMyObject("EXT_NREC_BCP.findRBcpDebtInfoByPage", omap, page);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtInfo> findInDuebillAppFlowRBcpDebtInfoByParam(HashMap<String, Object> omap)
	{
		List<RBcpDebtInfo> list = getSqlMapClientTemplate().queryForList("EXT_NREC_BCP.findInDuebillAppFlowRBcpDebtInfoByParam", omap);
		return list;
	}
}
