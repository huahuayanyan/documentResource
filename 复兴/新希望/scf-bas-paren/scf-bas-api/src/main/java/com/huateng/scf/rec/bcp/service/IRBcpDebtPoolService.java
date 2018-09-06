/**
 * 
 */
package com.huateng.scf.rec.bcp.service;

import java.math.BigDecimal;
import java.util.List;

import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 应收账款池信息接口
 * </p>
 *
 * @author shangxiujuan
 * @date 2017年1月11日下午5:23:28
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年1月11日下午5:23:28              新增
 *
 *            </pre>
 */
public interface IRBcpDebtPoolService {

	public static final String BEAN_ID = "rBcpDebtPoolService";

	public void addRBcpDebtPool(@ScubeParam("rBcpDebtPool") RBcpDebtPool rBcpDebtPool) throws ScubeBizException;

	/**
	 * @param rBcpDebtPool
	 * @return
	 */
	public int updateRBcpDebtPool(@ScubeParam("rBcpDebtPool") RBcpDebtPool rBcpDebtPool) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteRBcpDebtPool(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public RBcpDebtPool findRBcpDebtPoolByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public RBcpDebtPool findRBcpDebtPoolByMastContno(@ScubeParam("mastContno") String mastContno) throws ScubeBizException;

	/**
	 * 根据合同号判断额度融资池是否存在
	 * 
	 * @param mastContno
	 * @return
	 */
	boolean checkPoolIsExist(@ScubeParam("mastContno") String mastContno) throws ScubeBizException;

	/**
	 * 
	 * 修改出池信息
	 * 
	 * @param debtVO
	 * @param contlist
	 * @throws ScubeBizException
	 */
	public void updateOutpoolInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO, @ScubeParam("contlist") List<DebtContVO> contlist)
			throws ScubeBizException;

	/**
	 * 修改入池信息
	 * 
	 * @param mastContno
	 * @return
	 */
	public void updateInpoolInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO, @ScubeParam("contlist") List contlist) throws ScubeBizException;

	/**
	 * 根据合同代码查询折让发票池
	 * 
	 * @param mastContno
	 *            String-合同号
	 * @param custcdSaller
	 *            String-卖方客户号
	 * @return
	 * @throws ScubeBizException
	 */
	List<RBcpDebtPool> queryDebtPollByMastContno(@ScubeParam("mastContno") String mastContno, @ScubeParam("custcdSaller") String custcdSaller)
			throws ScubeBizException;

	/**
	 * 
	 * @param debtPool
	 * @param baseInfo
	 * @param amount
	 */
	public void updatePoolRemainAmount(@ScubeParam("debtPool") RBcpDebtPool debtPool, @ScubeParam("baseInfo") BCntDebtInfo baseInfo,
			@ScubeParam("amount") BigDecimal amount);

	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public List<RBcpDebtPool> getInPoolInfo(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO) throws ScubeBizException;

	/**
	 * 根据合同号查询已入池的发票池信息
	 * 
	 * @param mastContno
	 *            String-合同号
	 * @return RBcpDebtPool
	 * @throws ScubeBizException
	 */
	public RBcpDebtPool queryInPoolInfoByMastContno(@ScubeParam("mastContno") String mastContno) throws ScubeBizException;
}
