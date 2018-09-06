package com.huateng.scf.rec.bcp.dao.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.model.DebtContVO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtPoolDAO;
import com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPoolExample;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("RBcpDebtPoolDAO")
public class RBcpDebtPoolDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpDebtPoolDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public RBcpDebtPoolDAOImpl() {
		super();
	}

	public int countByExample(RBcpDebtPoolExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_POOL.countByExample", example);
		return count;
	}

	public int deleteByExample(RBcpDebtPoolExample example) {
		int rows = getSqlMapClientTemplate().delete("R_BCP_DEBT_POOL.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		RBcpDebtPool _key = new RBcpDebtPool();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("R_BCP_DEBT_POOL.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(RBcpDebtPool record) {
		getSqlMapClientTemplate().insert("R_BCP_DEBT_POOL.insert", record);
	}

	public void insertSelective(RBcpDebtPool record) {
		getSqlMapClientTemplate().insert("R_BCP_DEBT_POOL.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<RBcpDebtPool> selectByExample(RBcpDebtPoolExample example) {
		List<RBcpDebtPool> list = getSqlMapClientTemplate().queryForList("R_BCP_DEBT_POOL.selectByExample", example);
		return list;
	}

	public RBcpDebtPool selectByPrimaryKey(String id) {
		RBcpDebtPool _key = new RBcpDebtPool();
		_key.setId(id);
		RBcpDebtPool record = (RBcpDebtPool) getSqlMapClientTemplate().queryForObject("R_BCP_DEBT_POOL.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(RBcpDebtPool record, RBcpDebtPoolExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_POOL.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(RBcpDebtPool record, RBcpDebtPoolExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_POOL.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(RBcpDebtPool record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_POOL.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(RBcpDebtPool record) {
		int rows = getSqlMapClientTemplate().update("R_BCP_DEBT_POOL.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<RBcpDebtPool> selectByPage(RBcpDebtPoolExample example, Page page) {
		List<RBcpDebtPool> list = this.searchListPageMyObject("R_BCP_DEBT_POOL.selectByExample", example, page);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<RBcpDebtPool> getInpoolInfo(Map map) {
		List<RBcpDebtPool> list = getSqlMapClientTemplate().queryForList("R_BCP_DEBT_POOL.getInpoolInfo", map);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends RBcpDebtPoolExample {
		private Object record;

		public UpdateByExampleParms(Object record, RBcpDebtPoolExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	// ext
	/**
	 * 根据合同号判断额度融资池是否存在
	 * 
	 * @param mastContno
	 * @return
	 */
	public List<RBcpDebtPool> checkPoolIsExist(String mastContno) {
		List<RBcpDebtPool> list = getSqlMapClientTemplate().queryForList("EXT_R_BCP_DEBT_POOL.checkPoolIsExist", mastContno);
		return list;
	}

	/**
	 * 根据合同代码查询折让发票池
	 * 
	 * @date 2011-10-11 queryDebtPollByMastContno 方法
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtPool> queryDebtPollByMastContno(String mastContno, String custcdSaller) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("mastContno", mastContno);
		parameter.put("custcdSaller", custcdSaller);
		List<RBcpDebtPool> list = getSqlMapClientTemplate().queryForList("EXT_R_BCP_DEBT_POOL.queryDebtPollByMastContno", parameter);
		return list;
	}

	@Override
	public RBcpDebtPool get(String id) {
		return this.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public void updateOutpoolInfo(DebtBussInfoVO debtVO, List Contlist) {
		// 融资利率
		BigDecimal loanPercent = null;
		Iterator it = Contlist.iterator();
		while (it.hasNext()) {
			DebtContVO vo = (DebtContVO) it.next();
			loanPercent = vo.getLoanPercent();
		}
		List list = this.queryDebtPollByMastContno(debtVO.getMastContno(), debtVO.getCustcdSaller());
		if (list != null && list.size() > 0) {
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				RBcpDebtPool poolDebtVo = (RBcpDebtPool) iter.next();
				RBcpDebtPool tblDebtPool = this.get(poolDebtVo.getId());
				// 发票池金额
				BigDecimal totalDebtAmount_P = poolDebtVo.getTotalDebtAmount() == null ? new BigDecimal("0") : poolDebtVo.getTotalDebtAmount();
				// 本次发票出池金额
				// BigDecimal totalAmount = debtVO.getTotalAmount()==null? new
				// BigDecimal("0"):debtVO.getTotalAmount();
				BigDecimal totalAmount = debtVO.getTotalBillsAmount() == null ? new BigDecimal(0) : debtVO.getTotalBillsAmount();
				tblDebtPool.setTotalDebtAmount(totalDebtAmount_P.subtract(totalAmount));
				// 池发票余额
				BigDecimal totalDebtRemainAmount_p = poolDebtVo.getTotalDebtRemainAmount() == null ? new BigDecimal("0")
						: poolDebtVo.getTotalDebtRemainAmount();
				tblDebtPool.setTotalDebtRemainAmount(totalDebtRemainAmount_p.subtract(totalAmount));
				// 池可融资余额
				BigDecimal poolUseableAmount_p = poolDebtVo.getPoolUseableAmount() == null ? new BigDecimal("0") : poolDebtVo.getPoolUseableAmount();
				loanPercent = loanPercent == null ? new BigDecimal("0") : loanPercent;

				tblDebtPool.setPoolUseableAmount(
						poolUseableAmount_p.subtract(totalAmount.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));
				// 发票池份数
				Integer debtNum_P = (poolDebtVo.getDebtNum() == null ? new Integer("0") : poolDebtVo.getDebtNum()).intValue();
				Integer debtNum = debtVO.getTotalNum() == null ? new Integer("0") : debtVO.getTotalNum();
				BigDecimal num = new BigDecimal(debtNum_P - debtNum);
				tblDebtPool.setDebtNum(num);
				// 插入日期
				tblDebtPool.setInsertDate(debtVO.getInpoolDate());

				// this.update(tblDebtPool);
				this.updateByPrimaryKeySelective(tblDebtPool);
			}
		}

	}
}