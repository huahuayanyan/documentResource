/**
 * 
 */
package com.huateng.scf.bas.lan.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.CommonQryVO;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>借据基本信息接口</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月14日.上午11:13:52
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月14日.上午11:13:52	     新增
 *
 * </pre>
 */

@SuppressWarnings("deprecation")
public interface IIfspBLanLnciBaseService {
	
	/**
	 * 根据借据号查询借据信息
	 * @param debtId
	 * @return
	 * @throws ScubeBizException
	 */
	public BLanLnciBase findBLanLnciBaseByDebtId(@ScubeParam("debtId") String debtId) throws ScubeBizException;

	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getLnciBaseInfoByParamGetter(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;
	
}
