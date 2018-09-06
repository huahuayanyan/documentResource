package com.huateng.scf.nrec.bcp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.nrec.bcp.dao.INRBcpPaymentDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;

@Repository(INRBcpPaymentDAO.BeanId)
public class NRBcpPaymentDAOImpl extends IbatisDaoAnnotation4Template implements INRBcpPaymentDAO {

	@Resource(name = "sqlMapClientTemplate")
	IbatisTemplate template;

	@SuppressWarnings("unchecked")
	@Override
	public List<BPrdInfo> findBPrdInfoByVO(Map<String, Object> infoVO) {
		List<BPrdInfo> list = this.getSqlMapClientTemplate().queryForList("EXT_NREC_PAYMENT.selectBPrdInfoByVO", infoVO);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BPbcAppliBaseInfo> findBPbcAppliBaseInfoByPage(Page p, Map<String, Object> value) {
		List<BPbcAppliBaseInfo> list = this.searchListPageByMap("EXT_NREC_PAYMENT.selectBPbcAppliBaseInfoList", value, p);
		return list;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	@Override
	public List<BCrmBaseInfo> findBCrmBaseByPage(Map<String, Object> value, Page p) {
		List<BCrmBaseInfo> list = this.searchListPageByMap("EXT_NREC_PAYMENT.selectBCrmBaseByPage", value, p);
		return list;
	}

	@Override
	public List<BCntBcpInfo> findBCntBcpInfoByPage(Map<String, Object> param, Page p) {
		List<BCntBcpInfo> list = this.searchListPageByMap("EXT_NREC_PAYMENT.selectBCntBcpInfoByPage", param, p);
		return list;
	}

	@Override
	public BCrmBaseInfo findBCrmBaseInfoByKey(String custcd) {
		Map<String, Object> param = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(custcd)) {
			param.put("custcd", custcd);
		}
		BCrmBaseInfo bcrmbaseInfo = (BCrmBaseInfo) this.getSqlMapClientTemplate().queryForObject("EXT_NREC_PAYMENT.selectBCrmBaseInfoByKey", param);
		return bcrmbaseInfo;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<RBcpDebtInfo> findCancelRBcpDebtBaseInfoByPage(Map param, Page p) {
		List<RBcpDebtInfo> list = this.searchListPageByMap("EXT_NREC_PAYMENT.selectInvoiceChargeOffAddQry", param, p);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RBcpDebtInfo> findCancelRBcpDebtBaseInfoByPage2(Map rBcpDebtBaseInfo, Page p) {
		List<RBcpDebtInfo> list = this.searchListPageByMap("EXT_NREC_PAYMENT.selectInvoiceChargeOffAddQry2", rBcpDebtBaseInfo, p);
		return null;
	}
}
