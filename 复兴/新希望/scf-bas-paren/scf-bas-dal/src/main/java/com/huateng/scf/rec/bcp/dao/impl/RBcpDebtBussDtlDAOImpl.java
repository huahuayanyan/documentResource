package com.huateng.scf.rec.bcp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussInfo;

@Repository("IRBcpDebtBussDtlDAO")
public class RBcpDebtBussDtlDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpDebtBussDtlDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public RBcpDebtBussDtlDAOImpl() {
		super();
	}

	public int countByExample(RBcpDebtBussDtlExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_BUSS_DTL.countByExample",
				example);
		return count;
	}

	public int deleteByExample(RBcpDebtBussDtlExample example) {
		int rows = getSqlMapClientTemplate().delete("R_BCP_DEBT_BUSS_DTL.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		RBcpDebtBussDtl _key = new RBcpDebtBussDtl();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("R_BCP_DEBT_BUSS_DTL.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(RBcpDebtBussDtl record) {
		getSqlMapClientTemplate().insert("R_BCP_DEBT_BUSS_DTL.insert", record);
	}

	public void insertSelective(RBcpDebtBussDtl record) {
		getSqlMapClientTemplate().insert("R_BCP_DEBT_BUSS_DTL.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<RBcpDebtBussDtl> selectByExample(RBcpDebtBussDtlExample example) {
		List<RBcpDebtBussDtl> list = getSqlMapClientTemplate().queryForList("R_BCP_DEBT_BUSS_DTL.selectByExample",
				example);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<RBcpDebtBussDtl> selectByAppno(String appno) {
		List<RBcpDebtBussDtl> list = getSqlMapClientTemplate().queryForList("R_BCP_DEBT_BUSS_DTL.selectByAppno",appno);
		return list;
	}

	public RBcpDebtBussDtl selectByPrimaryKey(String id) {
		RBcpDebtBussDtl _key = new RBcpDebtBussDtl();
		_key.setId(id);
		RBcpDebtBussDtl record = (RBcpDebtBussDtl) getSqlMapClientTemplate()
				.queryForObject("R_BCP_DEBT_BUSS_DTL.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(RBcpDebtBussDtl record, RBcpDebtBussDtlExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BUSS_DTL.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(RBcpDebtBussDtl record, RBcpDebtBussDtlExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BUSS_DTL.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(RBcpDebtBussDtl record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BUSS_DTL.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(RBcpDebtBussDtl record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_BUSS_DTL.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<RBcpDebtBussDtl> selectByPage(RBcpDebtBussDtlExample example, Page page) {
		List<RBcpDebtBussDtl> list = this.searchListPageMyObject("R_BCP_DEBT_BUSS_DTL.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends RBcpDebtBussDtlExample {
		private Object record;

		public UpdateByExampleParms(Object record, RBcpDebtBussDtlExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public RBcpDebtBussInfo saveDebtChargeBussInfo(DebtBussInfoVO debtVO) {
////		GlobalInfo gb = GlobalInfo.getCurrentInstance();
//		ContextHolder.getUserInfo().getTlrNo()
//		RBcpDebtBussInfo debtBussInfo = new RBcpDebtBussInfo();
//		try {
//			BeanUtils.copyProperties(debtBussInfo, debtVO);
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
//		debtBussInfo.setId(this.getUUID());
//		debtBussInfo.setAppno(String.valueOf(this.getSeqPK(SCFConstants.VALUE_NO_SEQ_TBL_ID, SCFConstants.VALUE_INDEX_APPLIBASEINFO_ID)));
//		debtBussInfo.setCostAccount(debtVO.getBalanceAccount());
//		debtBussInfo.setAccountNo(debtVO.getAccountNo());
//		debtBussInfo.setDebtNum(debtVO.getTotalNum());
//		debtBussInfo.setTlrcd(gb.getTlrno());
//		debtBussInfo.setBrcode(GlobalInfo.getCurrentInstance().getBrcode());
//		debtBussInfo.setOtherReason(debtVO.getOtherReason());
//		debtBussInfo.setCostAccount(debtVO.getBalanceAccount());
//		debtBussInfo.setPurchaseDate(debtVO.getPurchaseDate());
//		debtBussInfo.setAppDate(DateUtil.getDate());
//		debtBussInfo.setApplyType(DebtConstants.APPLY_TYPE_AFTER_COST_CHARGE);
//		this.save(debtBussInfo);
//		return debtBussInfo;
		return null;
	}

	/**
	 *
	 * @Description:根据appno,busstype查询TblAppliBussInfo表
	 * @author jialei.zhang
	 * @Created 2012-7-26下午02:59:45
	 * @param appno
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtBussDtl> queryAppliBussDetailByAppno(String appno,String bussType)
	{
		RBcpDebtBussDtl key = new RBcpDebtBussDtl();
		key.setAppno(appno);
		key.setBussType(bussType);
		List<RBcpDebtBussDtl> list = getSqlMapClientTemplate().queryForList("EXT_R_BCP.queryAppliBussDetailByAppno", key);
		return list;
	}
}