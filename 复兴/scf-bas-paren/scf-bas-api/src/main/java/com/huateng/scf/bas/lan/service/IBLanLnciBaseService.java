/**
 * 
 */
package com.huateng.scf.bas.lan.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.common.model.CommonQryVO;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 借据基本信息接口
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月14日.上午11:13:52
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月14日.上午11:13:52	     新增
 *
 *            </pre>
 */

@SuppressWarnings("deprecation")
public interface IBLanLnciBaseService {
	public static final String BEAN_ID = "bLanLnciBaseService";

	public void addBLanLnciBase(@ScubeParam("bLanLnciBase") BLanLnciBase bLanLnciBase) throws ScubeBizException;

	/**
	 * @param bLanLnciBase
	 * @return
	 */
	public int updateBLanLnciBase(@ScubeParam("bLanLnciBase") BLanLnciBase bLanLnciBase) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBLanLnciBase(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public BLanLnciBase findBLanLnciBaseByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 借据锁定
	 * 
	 * @param debetNo
	 * @param lockAppno
	 * @throws ScubeBizException
	 */
	public void lockDebtBaseInfo(@ScubeParam("debetNo") String debetNo, @ScubeParam("lockAppno") String lockAppno) throws ScubeBizException;

	/**
	 * 借据解锁
	 * 
	 * @param debetNo
	 * @throws ScubeBizException
	 */
	public void releaseDebtBaseInfo(@ScubeParam("debetNo") String debetNo) throws ScubeBizException;

	/**
	 * 根据借据号查询借据信息
	 * 
	 * @param debtId
	 * @return
	 * @throws ScubeBizException
	 */
	public BLanLnciBase findBLanLnciBaseByDebtId(@ScubeParam("debtId") String debtId) throws ScubeBizException;

	/**
	 * 查询未结清且有效的借据
	 * 
	 * @param commonQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BLanLnciBase> queryValidLnciBaseInfo(@ScubeParam("commonQueryVO") CommonQryVO commonQryVO) throws ScubeBizException;

	/**
	 * 根据借据编号查询借据信息
	 * 
	 * @param debetNo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<BLanLnciBase> queryLnciBaseInfoByDebetNo(@ScubeParam("debtNo") String debetNo, @ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize);

	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 */
	public Page getLnciBaseInfoByDebetNo(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO);

	public Page findBLanLnciBasePageByDebtId(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("debtNos") List<String> debtNos);
	
	/**
	 * 提货借据更新(线下)
	 * @param bLanLnciBase
	 * @param abcpAppliImprestBuss
	 * @throws ScubeBizException
	 */
	public void updateTblLnciBaseInfo(@ScubeParam("bLanLnciBase") BLanLnciBase bLanLnciBase,@ScubeParam("abcpAppliImprestBuss") ABcpAppliImprestBuss abcpAppliImprestBuss)
			throws ScubeBizException;
	
	/**
	 * 
	 * @param lnciQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page queryLnciInfoByBusinessNo(@ScubeParam("lnciQryVO") DebtLnciQryVO lnciQryVO) throws ScubeBizException;

	/**
	 * 如果敞口为零将借据置为已结清状态
	 * 
	 * @param bLanLnciBase
	 * @throws ScubeBizException
	 */
	public void setLnciIsSettle(@ScubeParam("bLanLnciBase") BLanLnciBase bLanLnciBase) throws ScubeBizException;

	public Page findBLanLnciBaseListForBLanLnciBase(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bLanLnciBase") BLanLnciBase bLanLnciBase);

	/**
	 * 
	 * @param mastContno
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List calSumCashAndBailByMastContno(@ScubeParam("mastContno") String mastContno);

	/**
	 * 
	 * @param debetNo
	 * @param debetId
	 * @param mastContno
	 * @param custcd
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	public List getLnciBaseInfo(@ScubeParam("debetNo") String debetNo, @ScubeParam("debetId") String debetId,
			@ScubeParam("mastContno") String mastContno, @ScubeParam("custcd") String custcd) throws ScubeBizException;

	public void releaseDebtBaseInfoByLockAppno(@ScubeParam("lockAppno") String lockAppno) throws ScubeBizException;

	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getLnciBaseInfoByWriteParamGetter(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getLnciBaseInfoByParamGetter(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getAppliLnciBaseInfo(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;

	/**
	 * 
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	public void updateAll(@ScubeParam("list") List list);

	/**
	 * 根据关联协议号查询对应非删除状态借据信息 获得对应的未结清的借据金额
	 * 
	 * @param debtId
	 * @return
	 * @throws ScubeBizException
	 */
	public BigDecimal queryLnciBalByProtocolNo(@ScubeParam("protocolNo") String protocolNo) throws ScubeBizException;

	
	/**
	 * 获取协议下的融资金额，融资余额，初始保证金金额，追加保证金金额，初始现金等价物金额，追加现金等价物金额
	 * @param protocolNo
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BLanLnciBase> getDebetAmtOfSum(@ScubeParam("protocolNo") String protocolNo) throws ScubeBizException;
	/**
	 * 
	 * @param mastContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月18日上午9:48:27
	 */
	public HashMap<String, Object> getLnciSumByParam(@ScubeParam("mastContno") String mastContno) throws ScubeBizException;

	/**
	 * 查询质押合同下所有借据
	 * @param slaveContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午2:03:27
	 */
	@SuppressWarnings("rawtypes")
	public List getLnciBaseInfoListBySlaveContno(@ScubeParam("slaveContno") String slaveContno) throws ScubeBizException;

	/**
	 * 根据申请号查询借据信息（主要用于提货申请关联借据信息的场景）
	 * @param appNo
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午3:48:38
	 */
	public BLanLnciBase getTblLnciBaseInfoByBussAppNo(@ScubeParam("appNo") String appNo) throws ScubeBizException;

	/**
	 * 根据借据编号查询借据信息
	 * @param debetNo
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午9:15:49
	 */
	public Page getLnciBaseInfoByDebetNo(@ScubeParam("debetNo") String debetNo,@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize) throws ScubeBizException;

	/**
	 * 根据质押合同号查询借据列表
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午10:21:42
	 */
	public Page getDebetList(@ScubeParam("deliveryQryVO") DeliveryQryVO deliveryQryVO) throws ScubeBizException;

	/**
	 * 根据协议号查询借据信息
	 * @param protocolNo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午10:43:02
	 */
	public Page getLnciBaseInfoByProtocolNo(@ScubeParam("protocolNo") String protocolNo,@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize) throws ScubeBizException;

	/**
	 * 质押合同下出账总金额
	 * @param slaveContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午2:40:38
	 */
	public BigDecimal queryLnciAmtBySlaveContno(@ScubeParam("slaveContno") String slaveContno) throws ScubeBizException;

	/**
	 * 查询质押合同下所有借据
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午5:18:07
	 */
	public Page getLnciBaseInfoListBySlaveContno(@ScubeParam("contSlaveQryVO") ContSlaveQryVO contSlaveQryVO) throws ScubeBizException;
}
