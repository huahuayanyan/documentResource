package com.huateng.scf.rec.bcp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;

public interface IRBcpDebtBaseInfoDAO {
	int countByExample(RBcpDebtBaseInfoExample example);

	int countys();

	int deleteByExample(RBcpDebtBaseInfoExample example);

	int deleteByPrimaryKey(String id);

	void insert(RBcpDebtBaseInfo record);

	void insertSelective(RBcpDebtBaseInfo record);

	List<RBcpDebtBaseInfo> selectByExample(RBcpDebtBaseInfoExample example);

	RBcpDebtBaseInfo selectByPrimaryKey(String id);

	int updateByExampleSelective(RBcpDebtBaseInfo record, RBcpDebtBaseInfoExample example);

	int updateByExample(RBcpDebtBaseInfo record, RBcpDebtBaseInfoExample example);

	int updateByPrimaryKeySelective(RBcpDebtBaseInfo record);

	int updateByPrimaryKey(RBcpDebtBaseInfo record);

	List<RBcpDebtBaseInfo> selectByPage(RBcpDebtBaseInfoExample example, Page page);

	List<RBcpDebtBaseInfo> selectys(Map map, Page page);

	void lockDebtBaseInfo(String debetNo, String appno);

	void releaseDebtBaseInfo(String debtNo);

	public void invoiceOutpoolAddSave(List insertDebtList, DebtBussInfoVO debtVO);

	List selectByArgsSallerBuyerAndContno(Map<String, Object> map);

	Page getInvoiceDebtBackAddQry(HashMap<String, Object> omap);

	List<RBcpDebtBaseInfo> getDebtInfoQuery(Map map, Page page);

	/**
	 * 查询未核销的应收账款
	 * 
	 * @param map
	 * @return
	 */
	List<RBcpDebtBaseInfo> queryValidDebtBaseInfo(Map<String, Object> map);

	/***
	 * 催收待添加发票信息查询
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	List<RBcpDebtBaseInfo> getDebtInvoiceInfoPressing(Map<String, Object> map, Page page);

	/***
	 * 应收账款转让新增按钮对应的单据信息帅选
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	List<RBcpDebtBaseInfo> getDebtInvoiceInfoTransfer(Map<String, Object> map, Page page);

	/***
	 * 应收账款商纠登记新增按钮对应的单据信息帅选
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	List<RBcpDebtBaseInfo> getDebtInvoiceInfoRegister(Map<String, Object> map, Page page);

	/***
	 * 应收账款商纠解除新增按钮对应的单据信息帅选
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	List<RBcpDebtBaseInfo> getDebtInvoiceInfoRemove(Map<String, Object> map, Page page);

	/***
	 * 出池待添加发票信息查询
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	List<RBcpDebtBaseInfo> getInvoiceOut(Map<String, Object> map, Page page);

	Page getInvoiceSelectedQuery(String id_Q, int pageIndex, int pageSize, List<String> orderFileds);

	/**
	 * 回款专户入账查询
	 */
	public List<DebtBillsInfoVO> getDebtBackActImpInfoQuery(Map<String, Object> parameters, Page page);

	/**
	 * 
	 * @param omap
	 * @return
	 */
	public Page getInvoiceAdd(HashMap<String, Object> omap);

	/**
	 * 回款专户入账记录数
	 */
	public Integer getDebtBackActImpInfoQueryCount(Map<String, Object> parameters);

	List selectDebtInfoByPerson(int pageNo, int pageSize, Map<String, Object> parameters);

	Integer selectDebtInfoByPersonCount(Map<String, Object> parameters);

	List<RBcpDebtBaseInfo> selectDisputeInvoiceForAdding(Map<String, Object> params, Page page);

	Integer selectDisputeInvoiceForAddingCount(Map<String, Object> params);
	public RBcpDebtBaseInfo selectByBillsNo(String billsNo);

}