package com.huateng.scf.nrec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface INBLanLnciBaseService {

	public static final String BeanId = "NBLanLnciBaseServiceImpl";

	Page queryLnciInfoByBusinessNo(@ScubeParam("lnciQryVO") DebtLnciQryVO lnciQryVO) throws ScubeBizException;

	/**
	 * 分页条件查询借据信息
	 * 
	 * @param debtId
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月13日 下午8:13:11
	 */
	public Page selectBLanLnciBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BLanLnciBase bLanLnciBase) throws ScubeBizException;

	/**
	 * 通过页面所穿借据号查询对应借据信息（可以是多个借据号） 应收账款（单笔）回款根据对应单据的借据号查询对应的借据信息
	 * 
	 * 
	 * @author lihao
	 * @date 2017年6月14日 下午8:13:11
	 */
	public List<DebtLnciBaseInfoVO> selectBLanLnciBaseListByDebetId(@ScubeParam("list") List<RBcpDebtInfoVO> list) throws ScubeBizException;

	/**
	 * 新增对应的回款信息并锁定对应借据信息
	 * 
	 * @param bLanLnciBase
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月15日 下午8:14:13
	 */
	public void addRepayInfoAndLockLnciBase(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo,
			@ScubeParam("list") List<BLanLnciBase> bLanLnciBaseList) throws ScubeBizException;

	/**
	 * 删除对应的回款信息并解锁对应借据信息
	 * 
	 * @param bLanLnciBase
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月15日 下午8:14:13
	 */
	public void deleteRepayInfoAndReleaseLnciBase(@ScubeParam("key") String appno) throws ScubeBizException;

	/**
	 * 锁定对应的借据信息
	 * 
	 * @param bLanLnciBase
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月15日 下午8:14:13
	 */
	public void lockBLanLnciBase(@ScubeParam("key") String appno, @ScubeParam("bLanLnciBase") List<BLanLnciBase> bLanLnciBaseList)
			throws ScubeBizException;

	/**
	 * 解锁对应借据信息
	 * 
	 * @param bLanLnciBase
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月15日 下午8:14:13
	 */
	public void releaseBLanLnciBase(@ScubeParam("key") String appno) throws ScubeBizException;

	/**
	 * 根据借据号查询借据信息
	 * 
	 * @param debtId
	 * @return
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年6月2日 下午8:13:11
	 */
	public BLanLnciBase findBLanLnciBaseByDebtId(@ScubeParam("debtId") String debtId) throws ScubeBizException;

	/**
	 * 如果敞口为零将借据置为已结清状态
	 * 
	 * @param bLanLnciBase
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年6月2日 下午8:14:13
	 */
	public void setLnciIsSettle(@ScubeParam("bLanLnciBase") BLanLnciBase bLanLnciBase) throws ScubeBizException;

	/**
	 * 
	 * @param bLanLnciBase
	 * @return
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年6月2日 下午8:15:03
	 */
	public int updateBLanLnciBase(@ScubeParam("bLanLnciBase") BLanLnciBase bLanLnciBase) throws ScubeBizException;

	/**
	 * 根据应收账款ID获取借据信息
	 * @param commonQueryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月5日下午4:06:29
	 */
	public Page getLnciBaseInfoByDebtId(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO);

}
