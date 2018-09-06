package com.huateng.scf.rec.bcp.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPoolExample;

public interface IRBcpDebtPoolDAO {
	int countByExample(RBcpDebtPoolExample example);

	int deleteByExample(RBcpDebtPoolExample example);

	int deleteByPrimaryKey(String id);

	void insert(RBcpDebtPool record);

	void insertSelective(RBcpDebtPool record);

	List<RBcpDebtPool> selectByExample(RBcpDebtPoolExample example);

	RBcpDebtPool selectByPrimaryKey(String id);

	int updateByExampleSelective(RBcpDebtPool record, RBcpDebtPoolExample example);

	int updateByExample(RBcpDebtPool record, RBcpDebtPoolExample example);

	int updateByPrimaryKeySelective(RBcpDebtPool record);

	int updateByPrimaryKey(RBcpDebtPool record);

	// ext
	/**
	 * 根据合同号判断额度融资池是否存在
	 * 
	 * @param mastContno
	 * @return
	 */
	List<RBcpDebtPool> checkPoolIsExist(String mastContno);

	List<RBcpDebtPool> selectByPage(RBcpDebtPoolExample example, Page page);

	List<RBcpDebtPool> getInpoolInfo(Map map);

	List queryDebtPollByMastContno(java.lang.String mastContno, java.lang.String custcdSaller);

	RBcpDebtPool get(java.lang.String id);

	void updateOutpoolInfo(DebtBussInfoVO debtVO, List listDal);

}