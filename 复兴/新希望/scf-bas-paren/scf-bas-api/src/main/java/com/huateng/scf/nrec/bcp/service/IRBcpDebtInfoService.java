package com.huateng.scf.nrec.bcp.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>
 * 应收账款管理 接口类
 * </p>
 *
 * @author mengjiajia
 * @date 2017年5月22日下午3:37:32
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月22日下午3:37:32	     新增
 *
 *            </pre>
 */
public interface IRBcpDebtInfoService {
	public static final String BEAN_ID = "rbcpDebtInfoService";

	// 客户名称下拉菜单
	public Page selectBCrmBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCrmBaseInfo value);

	public String addRBcpDebtInfo(@ScubeParam("rBcpDebtInfoVO") RBcpDebtInfoVO rBcpDebtInfoVO);

	public int deleteRBcpDebtInfo(@ScubeParam("list") List<RBcpDebtInfoVO> list);

	public int updateRBcpDebtInfo(@ScubeParam("rBcpDebtInfoVO") RBcpDebtInfoVO rBcpDebtInfoVO);

	public Page findRBcpDebtInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") HashMap<String, Object> value) throws ScubeBizException;

	public void setContStatus(@ScubeParam("rBcpDebtInfoVO") RBcpDebtInfoVO rBcpDebtInfoVO);

	/**
	 * 根据主键获取信息
	 * 
	 * @param id
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月1日上午9:23:29
	 */
	public RBcpDebtInfoVO queryRBcpDebtInfoById(@ScubeParam("key") String id);

	// 应收类转让新增单据筛选
	public Page findRBcpDebtBaseInfoPageForTransfer(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtInfoVO rBcpDebtBaseInfo, @ScubeParam("list") List<RBcpDebtInfoVO> insertDebtList) throws ScubeBizException;

	/**
	 * rbcpdebtinfodao
	 * 
	 * @param debtId
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日上午10:01:57
	 */
	public void releaseDebtBaseInfo(@ScubeParam("debtId") String debtId) throws ScubeBizException;

	/**
	 *
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年5月24日上午10:01:57
	 */
	public void releaseDebtInfoByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 锁定
	 * 
	 * @param debtId
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日上午10:13:34
	 */
	public void lockDebtBaseInfo(@ScubeParam("debtId") String debtId, @ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 获取选择的应收账款列表
	 * 
	 * @param commonQueryVO
	 * @param orderFileds
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月24日下午2:13:45
	 */
	public Page getInvoiceSelectedQuery(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO,
			@ScubeParam("orderFileds") List<String> orderFileds);

	/**
	 * 发票融资申请发票添加
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日下午4:25:29
	 */
	public Page getInvoiceFinancingAddQry(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

	/**
	 * 应收账款单据信息查询
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月25日下午8:23:42
	 */
	Page getDebtInfoQuery(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO,@ScubeParam("flag") boolean flag) throws ScubeBizException;

	public RBcpDebtInfoVO findRBcpDebtInfoByKey(@ScubeParam("value") RBcpDebtInfoVO rBcpDebtInfoVO) throws ScubeBizException;

	/**
	 * 催收待添加发票信息查询
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月27日下午3:11:18
	 */
	public Page getDebtInvoiceInfoPressing(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO);

	/**
	 * 商纠登记选择单据
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDebtInfoVO
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月20日下午7:25:25
	 */
	public Page findRBcpDebtInfoForPRegister(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtInfoVO rBcpDebtInfoVO, @ScubeParam("list") List<RBcpDebtInfoVO> list) throws ScubeBizException;

	/**
	 * 商纠登记解除选择单据
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDebtInfoVO
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月20日下午7:25:39
	 */
	public Page findRBcpDebtInfoForRegisterRemove(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtInfoVO rBcpDebtInfoVO, @ScubeParam("list") List<RBcpDebtInfoVO> list) throws ScubeBizException;

	/**
	 * 出/入池单据新增筛选
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDebtInfoVO
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月20日下午7:26:40
	 */
	public Page findRBcpDebtInfoForInPoolOrOutPool(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtInfoVO rBcpDebtInfoVO, @ScubeParam("list") List<RBcpDebtInfoVO> list) throws ScubeBizException;

	/**
	 * 催收发票列表
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月31日上午10:53:27
	 */
	public Page getDebtPressInvoicesInfo(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

	/**
	 * 回购申请审批通过
	 * 
	 * @param insertDebtList
	 * @param tblDebtBussInfo
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月1日上午10:48:50
	 */
	public List<NDebtBillsInfoVO> factoringDebtBackAddApply(@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList,
			@ScubeParam("tblDebtBussInfo") RBcpDebtBussInfo tblDebtBussInfo) throws ScubeBizException;

	/**
	 * 还款时，为已核销的发票添加业务流水信息
	 * 
	 * @param insertDebtList
	 * @param debtBaseVO
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月1日上午10:50:29
	 */
	public void saveDebtBussInfoWhenCanceled(@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList,
			@ScubeParam("debtBaseVO") DebtBussInfoVO debtBaseVO) throws ScubeBizException;

	/**
	 * 核销申请发票添加
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月2日下午3:25:05
	 */
	public Page getInvoiceChargeOffAddQry(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO)
			throws ScubeBizException;

	/**
	 * 核销申请审批通过
	 * 
	 * @param insertDebtList
	 * @param bcpDebtBussInfo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月2日下午4:07:53
	 */
	public void factoringChargeOffAddSave(@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList,
			@ScubeParam("bcpDebtBussInfo") RBcpDebtBussInfo bcpDebtBussInfo) throws ScubeBizException;

	/**
	 * 根据id查询应收账款列表
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日上午10:37:15
	 */
	public Page getAcquisitionsInformation(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

	/**
	 * 减值申请发票添加查询
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日上午11:01:06
	 */
	public Page getInvoiceAllowanceAddQry(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO, @ScubeParam("flag") boolean flag)
			throws ScubeBizException;

	/**
	 * 折让申请审批通过
	 * 
	 * @param insertDebtList
	 * @param bcpDebtBussInfo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日下午2:58:49
	 */
	public void factoringAllowanceAddApply(@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList,
			@ScubeParam("bcpDebtBussInfo") RBcpDebtBussInfo bcpDebtBussInfo) throws ScubeBizException;

	/**
	 * 通过锁定的appno查询对应的锁定单据
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月30日下午3:47:42
	 */
	public List<RBcpDebtInfoVO> findRBcpDebtInfoListByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 根据合同编号查询应收账款金额总值
	 * @param mastContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年7月5日上午9:52:33
	 */
	public RBcpDebtInfoVO findSumRBcpDebtInfoByMastContno(@ScubeParam("mastContno") String mastContno,@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 根据合同编号查询应收账款金额总值(非本次业务的已锁定应收账款)
	 * @param mastContno
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年7月18日下午4:43:49
	 */
	public RBcpDebtInfoVO findOtherSumRBcpDebtInfoByMastContno(@ScubeParam("mastContno") String mastContno,@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 将获取到的列表信息分页
	 * @param pageNo
	 * @param pageSize
	 * @param list
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月19日下午4:42:18
	 */
	@SuppressWarnings("rawtypes")
	public Page getListByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("list") List list);

	/**
	 * 回购申请发票添加
	 * @param commonQueryVO
	 * @param flag
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年7月21日上午10:46:55
	 */
	public Page getInvoiceDebtBackAddQry(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO) throws ScubeBizException;
}
