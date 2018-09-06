/**
 * 
 */
package com.huateng.scf.ods.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.qry.dao.model.PostLoanWarnVO;
import com.huateng.scf.ods.dao.model.CooperPartnerInfo;
import com.huateng.scf.ods.dao.model.FundTransferVO;
import com.huateng.scf.ods.dao.model.OCooperPartner;
import com.huateng.scf.ods.dao.model.OFinaStaAnalysis;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月8日下午5:31:56
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月8日下午5:31:56              新增
 *
 * </pre>
 */
public interface ExtOdsDAO {
	//获得合作伙伴信息
	public List<OCooperPartner> getCooperPartnerInfoList(HashMap<String, Object> omap);

	//获得合作伙伴月度信息
	public List<OCooperPartner> getCooperPartnerMonthList(HashMap<String, Object> omap);
	
	//获取各类型项目的融资金额
	
	public List<OFinaStaAnalysis> getProjectAmountList(HashMap<String, Object> omap);
	
	//获取各类型的融资总额
	public List<OFinaStaAnalysis> getFinaTypeAmountList(HashMap<String, Object> omap);

	/**
	 *  通过类型获取 项目，金额，日期
	 * @param omap
	 * @return
	 * @return List<OFinaStaAnalysis>
	 */
	
	List<OFinaStaAnalysis> getProjectDateAmountList(HashMap<String, Object> omap);

	/**
	 * 通过类型获取 项目，金额，日期，备注
	 * @param omap
	 * @return
	 * @return List<OFinaStaAnalysis>
	 */
	
	List<OFinaStaAnalysis> getProjectInfoList(HashMap<String, Object> omap);
	
	/**
	 * 统计各客户下的业务和财务指标风险预警数
	 * @param omap
	 * @return
	 */
	List<PostLoanWarnVO> getPostLoanWarnStaList(HashMap<String, Object> omap,Page page);
	
	/**
	 * 查询客户的业务预警明细列表
	 * @param omap
	 * @param page
	 * @return
	 */
	List<PostLoanWarnVO> getPostLoanWarnDtlList(HashMap<String, Object> omap,Page page);
	
	/**
	 * 查询客户的财务指标预警明细列表
	 * @param omap
	 * @param page
	 * @return
	 */
	List<PostLoanWarnVO> getPostLoanFinWarnDtlList(HashMap<String, Object> omap,Page page);
	
	
	/**
	 *  资金迁徙-地图分布 虚线 
	 * @param map
	 * @return
	 */
	public List<FundTransferVO> queryFundTransferLineList(Map<String, Object> map);
	
	/**
	 *  资金迁徙-地图分布 实线 
	 * @param map
	 * @return
	 */
	public List<FundTransferVO> queryFundTransferRouteList(Map<String, Object> map);
	
	/**
	 * 查询客户的合作类型及其合作伙伴总数
	 * @param omap
	 * @return
	 */
	int countqueryCoopTypeList(Map<String, Object> omap);
	
	/**
	 * 查询客户的合作类型及其合作伙伴
	 * @param omap
	 * @param page
	 * @return
	 */
	List<CooperPartnerInfo> queryCoopTypeList(Map<String, Object> omap,Page page);
	
	/**
	 * 查询客户的合作类型及其合作伙伴的明细信息
	 * @param omap
	 * @return
	 */
	List<CooperPartnerInfo> queryCoopTypeDtlList(Map<String, Object> omap);
	
}
