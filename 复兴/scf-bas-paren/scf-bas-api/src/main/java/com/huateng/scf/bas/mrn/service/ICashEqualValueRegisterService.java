package com.huateng.scf.bas.mrn.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.model.BCrrLnConCash;
import com.huateng.scf.bas.mrn.vo.CashEqualValueContractVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>现金等价物质押接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月13日下午3:56:45
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月13日下午3:56:45	     新增
 *
 * </pre>
 */
public interface ICashEqualValueRegisterService {
	/**
	 * 
	 * @param appno
	 * @return
	 */
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(@ScubeParam("appno") String appno);
	/**
	 * 
	 * @param bCrrLnConCash
	 * @return
	 * @throws ScubeBizException
	 */
	public Page ContractorQryGetter(@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash) throws ScubeBizException;
	/**
	 * 
	 * @param bCrrLnConCash
	 * @return
	 */
	public Page CashEqualValueLnciWriteGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash);
	/**
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public Page CashEqualAddInfoGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("appno") String appno) throws ScubeBizException;
	/**
	 * 
	 * @param bCrrLnConCash
	 * @return
	 */
	public Page AccountInfoEqualCashGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash);
	/**
	 * 
	 * @param bCrrLnConCash
	 * @param lnciBaseInfoForCash
	 * @param cashEqualValueInfo
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	public String CashEqualValueInfoSinglesUpdate(@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash,@ScubeParam("lnciBaseInfoForCash") List lnciBaseInfoForCash,@ScubeParam("cashEqualValueInfo") List cashEqualValueInfo) throws ScubeBizException;
	/**
	 * 
	 * @param bCrrLnConCash
	 * @param lnciBaseInfoForCash
	 * @param cashEqualValueInfo
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	public String CashEqualValueInfoWriteSubmitUpdate(@ScubeParam("bCrrLnConCash") BCrrLnConCash bCrrLnConCash,@ScubeParam("lnciBaseInfoForCash") List lnciBaseInfoForCash,@ScubeParam("cashEqualValueInfo") List cashEqualValueInfo,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;
	/**
	 * 
	 * @param appno
	 */
	public void CashEqualValueRegCheckUpdateBack(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess);
	/**
	 * 
	 * @param appno
	 */
	public void CashEqualValueRegCheckUpdateAgree(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess);
	/**
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public List<CashEqualValueContractVO> getChoosedLnciInfo(@ScubeParam("appno") String appno) throws ScubeBizException;
}
