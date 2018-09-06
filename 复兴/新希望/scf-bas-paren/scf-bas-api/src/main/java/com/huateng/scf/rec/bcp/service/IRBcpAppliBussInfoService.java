/**
 * 
 */
package com.huateng.scf.rec.bcp.service;

import java.util.ArrayList;
import java.util.List;

import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliCostOut;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月23日下午8:03:02
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月23日下午8:03:02	      新增
 *
 *            </pre>
 */
public interface IRBcpAppliBussInfoService {
	public static final String BEAN_ID = "rBcpAppliBussInfoService";

	// 新增应收账款申请转让信息（新增基本信息，再新增费用信息，再新增明细信息,改变对应的应收账款基本信息状态。）
	public RBcpAppliBussInfo addBcpAppliBussInfo(@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpAppliBussInfo,
			@ScubeParam("rBcpAppliCostOut") RBcpAppliCostOut rBcpAppliCostOut,
			@ScubeParam("rBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds,
			@ScubeParam("processModel") ProcessModel processModel);

	// 删除应收账款申请转让信息（根据申请号,ID等）
	public int deleteRBcpAppliBussInfo(@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpAppliBussInfo);

	// 修改应收账款申请转让信息（修改基本信息，再修改费用信息，再全部删除对应明细信息，修改对应的应收账款基本信息锁定状态，再新增页面的的明细信息，
	// 再改变对应的应收账款基本信息的锁定状态。）
	public int updateRBcpAppliBussInfo(@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpDebtBaseInfo,
			@ScubeParam("rBcpAppliCostOut") RBcpAppliCostOut rBcpAppliCostOut,
			@ScubeParam("rBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds);

	// 根据申请号查询应收账款申请转让信息
	public RBcpAppliBussInfo findBcpAppliBussInfoByKey(
			@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpDebtBaseInfo);

	// 页面提交按钮的对应点击事件，会直接保存页面信息，再将对应信息改为提交状态
	public void submitRBcpAppliBussInfo(@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpDebtBaseInfo,
			@ScubeParam("rBcpAppliCostOut") RBcpAppliCostOut rBcpAppliCostOut,
			@ScubeParam("rBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds);

	// 应收账款池融资入池
	public void inPool(@ScubeParam("rBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds,
			@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtVO) throws ScubeBizException;

	/**
	 * @param debtVO
	 */
	public void saveOrUpdateDebtAppliBussInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO) throws ScubeBizException;

	/**
	 * @param appno
	 * @return
	 */
	public List getTblAppliBussInfo(@ScubeParam("appno") String appno);

	/**
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo findByAppno(@ScubeParam("appno") String appno);

	/**
	 * 应收账款回购/反转让，发票信息保存
	 * 
	 * @param debtVO
	 *            DebtBussInfoVO
	 * @return debtId String-应收账款单据表主键
	 * @throws ScubeBizException
	 */
	public String saveDebtBackAppliBussInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO) throws ScubeBizException;

	public List<RBcpAppliBussInfo> queryAppliBussInfoBillsNo(@ScubeParam("appno") String appno);

	public void save(@ScubeParam("tblAppliBussInfo") RBcpAppliBussInfo tblAppliBussInfo) throws ScubeBizException;

	public List<RBcpAppliBussInfo> findByProperty(@ScubeParam("appno") String appno);

	public void update(@ScubeParam("tblAppliBussInfo") RBcpAppliBussInfo tblAppliBussInfo) throws ScubeBizException;

}
