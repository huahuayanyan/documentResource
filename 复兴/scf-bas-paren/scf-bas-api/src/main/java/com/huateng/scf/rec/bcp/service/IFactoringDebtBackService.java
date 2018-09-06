/**
 * 
 */
package com.huateng.scf.rec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.rec.bcp.model.AppliBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 应收账款反转让接口
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月28日 下午4:09:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月28日下午4:09:17             新增
 *
 *            </pre>
 */
public interface IFactoringDebtBackService {
	public static final String BEAN_ID = "factoringDebtBackService";
	/**
	 * 查询合同列表
	 * 
	 * @param pageNo
	 *            int-当前页码
	 * @param pageSize
	 *            int-每页大小
	 * @param debtBussInfoVO
	 *            DebtBussInfoVO对象
	 * @return Page对象
	 * @throws ScubeBizException
	 */
	public Page queryContDebtListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO) throws ScubeBizException;
	/**
	 * 应收账款反转让申请保存
	 * @param debtBussInfoVO
	 * 		DebtBussInfoVO对象
	 * @return appNo业务流水号
	 * @throws ScubeBizException
	 */
	public String debtBackApplySave(@ScubeParam("appliBussInfoVO") AppliBussInfoVO appliBussInfoVO,@ScubeParam("insertDebtList") List<RBcpDebtBaseInfo> insertDebtList) throws ScubeBizException;
	/**
	 * 应收账款反转让申请提交
	 * @param debtBussInfoVO
	 * 		DebtBussInfoVO对象
	 * @return appNo业务流水号
	 * @throws ScubeBizException
	 */
	public void debtBackApplySubmit(@ScubeParam("appliBussInfoVO") AppliBussInfoVO appliBussInfoVO,@ScubeParam("insertDebtList") List<RBcpDebtBaseInfo> insertDebtList,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;
	/**
	 * 应收账款回购申请流程回执
	 * @param debtBussInfoVO
	 * 		DebtBussInfoVO对象
	 * @return appNo业务流水号
	 * @throws ScubeBizException
	 */
	public void debtBackApplyPassSubmit(@ScubeParam("appliBussInfoVO") AppliBussInfoVO appliBussInfoVO,@ScubeParam("insertDebtList") List<RBcpDebtBaseInfo> insertDebtList,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param commonQueryVO
	 * @return
	 */
	public Page getLanLnciInfoByContno(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("appliBussInfo") RBcpAppliBussInfo appliBussInfo);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param appno
	 * @param bussType
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getRBcpDebtBussDtl(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpAppliBussInfo,@ScubeParam("cache") String cache) throws ScubeBizException;
	/**
	 * 
	 * @param debtBussInfoVO
	 * @return
	 * @throws ScubeBizException
	 */
	public DebtBussInfoVO getDebtBussInfo(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO) throws ScubeBizException;
	/**
	 * 缓存
	 * @param list
	 */
	public void cacheAdd(@ScubeParam("list") List<RBcpAppliBussDtl> list);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDebtBussInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page queryRBcpDebtBaseInfo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO,@ScubeParam("list") List<RBcpAppliBussDtl> list) throws ScubeBizException;
	/**
	 * 获取任务信息
	 * @param appno
	 * @return
	 */
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno,@ScubeParam("factType") String factType);
	/**
	 * 
	 * @param list
	 * @return
	 */
	public int batchDeleteRBcpDebtBaseInfo(@ScubeParam("list") List<RBcpAppliBussDtl> list,@ScubeParam("appno") String appno);
	/**
	 * 
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 */
	public void debtBackApplyBackToModify(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;
	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public DebtBussInfoVO getContDebtInfoByMastContno(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO) throws ScubeBizException;
	/**
	 * 
	 * @param appno
	 * @param bussType
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	public List getTblAppliBussDetail(@ScubeParam("appno") String appno,@ScubeParam("bussType") String bussType) throws ScubeBizException;
}
