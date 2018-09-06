/**
 * 
 */
package com.huateng.scf.bas.qry.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.qry.model.CooperPartnerInfo;
import com.huateng.scf.bas.qry.model.CustAnalysisInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年7月7日上午9:35:25
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年7月7日上午9:35:25              新增
 *
 * </pre>
 */
public interface ICoopPartnerMngService {

	public static final String BEAN_ID = "coopPartnerMngService";
	public void addCooperPartnerInfo(@ScubeParam("cooperPartnerInfo") CooperPartnerInfo cooperPartnerInfo) throws ScubeBizException;
	/**
	 * @param CooperPartnerInfo
	 * @return
	 */
	public void updateCooperPartnerInfo(@ScubeParam("cooperPartnerInfo") CooperPartnerInfo cooperPartnerInfo) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public void deleteCooperPartnerInfo(@ScubeParam("key") String key) throws ScubeBizException;
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param CooperPartnerInfo
	 * @return
	 */
	public Page findCooperPartnerInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("cooperPartnerInfo") CooperPartnerInfo cooperPartnerInfo) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public CooperPartnerInfo findCooperPartnerInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;
	
	/**
	 * 查询客户的合作类型及其合作伙伴
	 * @param pageNo
	 * @param pageSize
	 * @param cooperPartnerInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findCoopTypeListByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("cooperPartnerInfo") CooperPartnerInfo cooperPartnerInfo) throws ScubeBizException;
	

	/**
	 * 查询客户的合作类型及其合作伙伴的明细信息
	 * @param cooperPartnerInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public List<CooperPartnerInfo>  findCoopTypeDtlList(@ScubeParam("cooperPartnerInfo") CooperPartnerInfo cooperPartnerInfo) throws ScubeBizException;
	
	/**
	 * 客户关联合作伙伴
	 * @param pageNo
	 * @param pageSize
	 * @param cooperPartnerInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public void addCustRelCoop(@ScubeParam("cooperPartnerInfo") CooperPartnerInfo cooperPartnerInfo,@ScubeParam("list") List<CooperPartnerInfo> list) throws ScubeBizException;
	
	/**
	 * 删除客户关联合作伙伴的相关信息
	 * @param pageNo
	 * @param pageSize
	 * @param cooperPartnerInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public void deleteCustRelCoop(@ScubeParam("cooperPartnerInfo") CooperPartnerInfo cooperPartnerInfo) throws ScubeBizException;
	
	
	/**
	 * 查询客户分析信息
	 * @param pageNo
	 * @param pageSize
	 * @param custAnalysisInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public Page findCrmAnalyListByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("custAnalysisInfo") CustAnalysisInfo custAnalysisInfo) throws ScubeBizException;
	
	
	/**
	 * 客户关联客户分析信息
	 * @param custAnalysisInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public void addCustRelCrmAnaly(@ScubeParam("custAnalysisInfo") CustAnalysisInfo custAnalysisInfo) throws ScubeBizException;
	
	
	/**
	 * 删除客户关联客户分析信息
	 * @param custAnalysisInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public void deleteCustRelCrmAnaly(@ScubeParam("custAnalysisInfo") CustAnalysisInfo custAnalysisInfo) throws ScubeBizException;
	
	
	
	
}
