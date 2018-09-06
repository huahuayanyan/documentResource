/**
 * 
 */
package com.huateng.scf.bas.icr.service;

import java.math.BigDecimal;
import java.util.List;

import com.huateng.authority.entity.BctlVO;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.CreditInterParamBean;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>额度信息接口</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月3日.下午4:24:18
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月3日.下午4:24:18	     新增
 *
 * </pre>
 */

public interface IBIcrInfoService {
	public static final String BEAN_ID = "bIcrInfoService";
	public void addBIcrInfo(@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	/**
	 * @param bIcrInfo
	 * @return
	 */
	public int updateBIcrInfo(@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public int deleteBIcrInfo(@ScubeParam("key") String key) throws ScubeBizException;
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrInfo
	 * @return
	 */
	public Page findBIcrInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public BIcrInfo findBIcrInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;
	
	/**
	 * 
	 * @param bIcrInfo
	 * @return
	 */
	public int deleteByBIcrInfo(@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo)throws ScubeBizException;
	/**
	 * 获得额度信息的初始化信息
	 */
	
	public BIcrInfo initBIcrInfo() throws ScubeBizException;
	
	/**
	 * 查询额度信息列表
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrInfo
	 * @return
	 */
	public Page findBIcrInfoListByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	/**
	 * 已领用生效额度列表
	 * @param pageNo
	 * @param pageSize
	 * @param creditNo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findBIcrDrawInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("creditNo") String creditNo) throws ScubeBizException;
	/**
	 * 已领用间接额度查询(包括总额度，分项额度，子额度)
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findBIcrDrawInfoListByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	/**
	 * 额度分项信息查询
	 * @param pageNo
	 * @param pageSize
	 * @param creditNo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findBIcrSubInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("creditNo") String creditNo) throws ScubeBizException;
	
	/**
	 * 通过额度编号获得额度信息
	 * @param creditNo
	 * @return
	 */
	public BIcrInfo findBIcrInfoByCreditNo(@ScubeParam("creditNo") String creditNo) throws ScubeBizException;
	
	
	/**
	 * 额度维护新增保存
	 * @param bIcrInfo
	 * @param subBIcrInfoList
	 * @return
	 * @throws ScubeBizException
	 */
	public BIcrInfo saveAddInfo(@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo,@ScubeParam("subBIcrInfoList") List<BIcrInfo> subBIcrInfoList) throws ScubeBizException;
	
	/**
	 * 额度维护修改保存
	 * @param bIcrInfo
	 * @param subBIcrInfoList
	 * @return
	 * @throws ScubeBizException
	 */
	public BIcrInfo saveUpdateInfo(@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo,@ScubeParam("delCreditNo") String delCreditNo,@ScubeParam("subBIcrInfoList") List<BIcrInfo> subBIcrInfoList) throws ScubeBizException;
	
	/**
	 * 通过额度编号获得分项额度信息及额度信息
	 * @param creditNo
	 * @return
	 */
	public BIcrInfo findBIcrInfoOrUpByCreditNo(@ScubeParam("creditNo") String creditNo) throws ScubeBizException;
	/**
	 * 额度终止：根据额度编号更新额度状态和分项额度状态,领用额度状态
	 * @param bIcrInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public void updateBIcrInfoStatus(@ScubeParam("creditNos") String creditNos) throws ScubeBizException;
	
	/**
	 * 选择机构测试
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findOrgByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bctlVO") BctlVO bctlVO) throws ScubeBizException;
	/*****************间接额度领用查询begin************************/
	/**
	 * 可以领用间接额度查询
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findBIcrInfoDrawByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	/**
	 * 根据额度编号查询额度信息
	 * @param creditNo
	 * @return
	 * @throws ScubeBizException
	 */
	public BIcrInfo findBIcrInfoMainByCreditNo(@ScubeParam("creditNo") String creditNo) throws ScubeBizException;
	/**
	 * 额度领用（不审批）保存
	 * @param bIcrInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public void BIcrInfoDrawSaveUpdate(@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	/*****************间接额度领用查询end************************/
	/*****************间接额度回收Recover begin************************/
	/**
	 * 查询列表
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findBIcrInfoRecoverByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	/**
	 * 间接额度回收保存（暂无申请）
	 * @param bIcrInfo
	 * @throws ScubeBizException
	 */
	public void BIcrInfoRecoverSaveUpdate(@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	/*****************间接额度回收 Recover end************************/
	/*****************间接额度流水查询 ************************/
	/**
	 * 间接额度使用流水查询
	 * @param pageNo
	 * @param pageSize
	 * @param bIcrInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findBIcrInfoFlowQryByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bIcrInfo") BIcrInfo bIcrInfo) throws ScubeBizException;
	
	
	public void indirectCreditAppliCommonProcess(@ScubeParam("appno")String appno,@ScubeParam("debitNo")String debitNo,@ScubeParam("operType")String operType,@ScubeParam("amt")BigDecimal amt) throws ScubeBizException;
	/**
	 * 
	 * @return
	 * @throws ScubeBizException
	 */
	public String getCreditNoOfLimitBuyer() throws ScubeBizException;
	
	/**
	 * 额度检查
	 * @param custcd
	 * 		String-客户号
	 * @param otherCustcd
	 * 		String-贸易对手客户号
	 * @param creditType
	 * 		String-额度类型
	 * @return List
	 * @throws ScubeBizException
	 */
	public List checkCredit(@ScubeParam("custcd") String custcd, @ScubeParam("otherCustcd") String otherCustcd,
			@ScubeParam("creditType") String creditType) throws ScubeBizException;
	
	/**
	 * 当前日期所在区间额度查询
	 * @param creditQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午4:13:23
	 */
	public Page getCurrenyEffectiveTblCreditInfoByCreditQryVO(@ScubeParam("creditQryVO") CreditQryVO creditQryVO) throws ScubeBizException;
	/**
	 * 检查额度操作时数据正确性
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param amount
	 * @param type
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午3:44:44
	 */
	public void checkCreditOpInfo(@ScubeParam("custcd") String custcd,@ScubeParam("otherCustcd") String otherCustcd, 
			@ScubeParam("creditType") String creditType,@ScubeParam("amount") BigDecimal amount,@ScubeParam("type") String type)
			throws ScubeBizException;
	/**
	 * 额度操作接口-增加额度信息
	 * @param creditInterParamBean
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param type
	 * @param amount
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午4:06:32
	 */
	public void addCreditInfo(@ScubeParam("creditInterParamBean") CreditInterParamBean creditInterParamBean, 
			@ScubeParam("custcd") String custcd,@ScubeParam("otherCustcd") String otherCustcd,
			@ScubeParam("creditType") String creditType,@ScubeParam("type") String type,
			@ScubeParam("amount") BigDecimal amount) throws ScubeBizException;
	/**
	 * 额度接口操作-修改融资额度信息
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param type
	 * @param amount
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午4:15:19
	 */
	public void modifyCreditInfo(@ScubeParam("custcd") String custcd,@ScubeParam("otherCustcd") String otherCustcd,
			@ScubeParam("creditType") String creditType,@ScubeParam("type") String type,
			@ScubeParam("amount") BigDecimal amount) throws ScubeBizException;
}
