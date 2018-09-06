/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import java.math.BigDecimal;
import java.util.List;

import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
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
public interface INRBcpDebtPoolService {

	public static final String BEAN_ID = "NRBcpDebtPoolServiceImpl";

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
	public void updateInpoolInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO, @ScubeParam("contlist") List<BCntBcpInfoVO> contlist)
			throws ScubeBizException;

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
	 * 回购、核销更新池的发票总余额和可融资余额
	 * @param debtPool
	 * @param baseInfo
	 * @param invokPhase
	 * @author 	mengjiajia
	 * @date 	2017年7月5日下午1:40:28
	 */
	public void updatePoolRemainAmount(@ScubeParam("debtPool") RBcpDebtPool debtPool, @ScubeParam("baseInfo") BCntBcpInfoVO baseInfo,
			@ScubeParam("invokPhase") String invokPhase);

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

	/**
	 * 折让池更新
	 * 
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日下午3:00:15
	 */
	public void updateDebtPoolInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO) throws ScubeBizException;

	/**
	 * 新应收类出池信息修改
	 * 
	 * @param list（出池的应收账款信息（单据信息）
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月30日下午3:05:34
	 */
	public void NUpdateOutpoolInfo(@ScubeParam("list") List<RBcpDebtInfoVO> list) throws ScubeBizException;

	/**
	 * 新应收类入池信息修改
	 * 
	 * @param list（出池的应收账款信息（单据信息）
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月30日下午3:05:34
	 */
	public void NUpdateInpoolInfo(@ScubeParam("list") List<RBcpDebtInfoVO> list) throws ScubeBizException;

	/**
	 * 计算对应合同号下池信息（计算入池单据的总应收账款余额等）
	 * 
	 * @param mastContno
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年7月4日下午7:14:38
	 */
	public void NUpdatePoolInfoByMastContno(@ScubeParam("mastContno") String mastContno,@ScubeParam("money") BigDecimal money,@ScubeParam("flag") String flag) throws ScubeBizException;

	/**
	 * 减值、反转让、核销后对池信息更新
	 * @param bcpDebtPool
	 * @param debtInfoVO
	 * @param loanPercent
	 * @param invokPhase
	 * @author 	mengjiajia
	 * @date 	2017年7月5日下午2:45:00
	 */
	public void updateRBcpDebtPoolDebtAmount(@ScubeParam("bcpDebtPool") RBcpDebtPool bcpDebtPool,@ScubeParam("debtInfoVO") RBcpDebtInfoVO debtInfoVO,
			@ScubeParam("loanPercent") BigDecimal loanPercent, @ScubeParam("invokPhase") String invokPhase);

	/**
	 * 
	 * @param appNo
	 * @param invokPhase
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月18日下午3:08:02
	 */
	public String getPoolMessage(@ScubeParam("appNo") String appNo,@ScubeParam("invokPhase") String invokPhase);
}
