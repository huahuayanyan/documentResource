package com.huateng.scf.rec.qry.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.qry.dao.IRBcpPoolDebtDetalInfoQryDao;
import com.huateng.scf.rec.qry.dao.model.DebtCommonQryVO;

@Repository("IRBcpPoolDebtDetalInfoQryDao")
public class RBcpPoolDebtDetalInfoQryDaoImpl extends IbatisDaoAnnotation4Template implements IRBcpPoolDebtDetalInfoQryDao {
	
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;
	
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page selectInvoiceCourseInfo(DebtCommonQryVO commonQueryVO, int pageSize, int pageNo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(commonQueryVO.getId_Q())){
			parameters.put("id_Q", commonQueryVO.getId_Q());
		}else if(StringUtils.isNotBlank(commonQueryVO.getBillsNo_Q())){
			parameters.put("billsNo_Q", commonQueryVO.getBillsNo_Q());
		}
		
		Page page = new Page(pageSize, pageNo, 0);
		List<RBcpDebtBussDtl> listResult = this.searchListPageByMap("EXT_QRY_POOLDBTDQUERY.selectInvoiceCourseInfo", parameters, page);
		Page pageResult = new Page(pageSize, pageNo, 0);
		pageResult.setRecords(listResult);
		pageResult.setTotalRecord(listResult.size());
		return pageResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DebtBillsInfoVO> getDebtInfoByPerson(DebtCommonQryVO commonQueryVO, int pageSize, int pageNo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(commonQueryVO.getCustcdSaller_Q())){
			parameters.put("custcdSaller_Q", commonQueryVO.getCustcdSaller_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getCustcdBuyer_Q())){
			parameters.put("custcdBuyer_Q", commonQueryVO.getCustcdBuyer_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getMastContno())){
			parameters.put("mastContno", commonQueryVO.getMastContno());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getBussType_Q())){
			parameters.put("bussType_Q", commonQueryVO.getBussType_Q());
		}		
		if(StringUtils.isNotBlank(commonQueryVO.getBillsNo_Q())){
			parameters.put("billsNo_Q", commonQueryVO.getBillsNo_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getBillsType_Q())){
			parameters.put("billsType_Q", commonQueryVO.getBillsType_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getStart_Q())){
			parameters.put("start_Q", commonQueryVO.getStart_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getEnd_Q())){
			parameters.put("end_Q", commonQueryVO.getEnd_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getDebtEnd_from_Q())){
			parameters.put("debtEnd_from_Q", commonQueryVO.getDebtEnd_from_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getDebtEnd_to_Q())){
			parameters.put("debtEnd_to_Q", commonQueryVO.getDebtEnd_to_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getStatus_Q())){
			parameters.put("status_Q", commonQueryVO.getStatus_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getLoanWay_Q())){
			parameters.put("LoanWay_Q", commonQueryVO.getLoanWay_Q());
		}	
		if(StringUtils.isNotBlank(commonQueryVO.getBrcode())){
			parameters.put("brcode", commonQueryVO.getBrcode());
		}
		Page page = new Page(pageSize, pageNo, 0);
		List<DebtBillsInfoVO> listResult= this.searchListPageByMap("EXT_QRY_POOLDBTDQUERY.selectDebtInfoByPerson", parameters,page);
		
//		Page pageResult = new Page(pageSize, pageNo, 0);
//		Integer count = this.getDebtCountByPerson(commonQueryVO);
//		pageResult.setTotalRecord(count);
//		pageResult.setRecords(listResult);
		return listResult;
	}

	@Override
	public int selectInvoiceCourseCount(DebtCommonQryVO commonQueryVO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(commonQueryVO.getId_Q())){
			parameters.put("id_Q", commonQueryVO.getId_Q());
		}else if(StringUtils.isNotBlank(commonQueryVO.getBillsNo_Q())){
			parameters.put("billsNo_Q", commonQueryVO.getBillsNo_Q());
		}
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("EXT_QRY_POOLDBTDQUERY.selectInvoiceCourseCount", parameters);
		return count;
	}

	@Override
	public Integer getDebtCountByPerson(DebtCommonQryVO commonQueryVO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(commonQueryVO.getCustcdSaller_Q())){
			parameters.put("custcdSaller_Q", commonQueryVO.getCustcdSaller_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getCustcdBuyer_Q())){
			parameters.put("custcdBuyer_Q", commonQueryVO.getCustcdBuyer_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getMastContno())){
			parameters.put("mastContno", commonQueryVO.getMastContno());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getBussType_Q())){
			parameters.put("bussType_Q", commonQueryVO.getBussType_Q());
		}		
		if(StringUtils.isNotBlank(commonQueryVO.getBillsNo_Q())){
			parameters.put("billsNo_Q", commonQueryVO.getBillsNo_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getBillsType_Q())){
			parameters.put("billsType_Q", commonQueryVO.getBillsType_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getStart_Q())){
			parameters.put("start_Q", commonQueryVO.getStart_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getEnd_Q())){
			parameters.put("end_Q", commonQueryVO.getEnd_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getDebtEnd_from_Q())){
			parameters.put("debtEnd_from_Q", commonQueryVO.getDebtEnd_from_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getDebtEnd_to_Q())){
			parameters.put("debtEnd_to_Q", commonQueryVO.getDebtEnd_to_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getStatus_Q())){
			parameters.put("status_Q", commonQueryVO.getStatus_Q());
		}
		if(StringUtils.isNotBlank(commonQueryVO.getLoanWay_Q())){
			parameters.put("LoanWay_Q", commonQueryVO.getLoanWay_Q());
		}	
		if(StringUtils.isNotBlank(commonQueryVO.getBrcode())){
			parameters.put("brcode", commonQueryVO.getBrcode());
		}
		Integer count= (Integer) this.getSqlMapClientTemplate().queryForObject("EXT_QRY_POOLDBTDQUERY.selectDebtCountByPerson", parameters);
		return count;
	}
	


}
