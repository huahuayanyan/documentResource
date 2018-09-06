/**
 * 
 */
package com.huateng.scf.ods.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.qry.dao.model.PostLoanWarnVO;
import com.huateng.scf.ods.dao.model.CooperPartnerInfo;
import com.huateng.scf.ods.dao.model.FundTransferVO;
import com.huateng.scf.ods.dao.model.OCooperPartner;
import com.huateng.scf.ods.dao.model.OFinaStaAnalysis;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月8日下午5:32:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月8日下午5:32:43              新增
 *
 * </pre>
 */
@Repository("ExtOdsDAO")
public class ExtOdsDAOImpl extends IbatisDaoAnnotation4Template implements ExtOdsDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;
	
	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}
	@SuppressWarnings("unchecked")
	public List<OCooperPartner> getCooperPartnerInfoList(HashMap<String, Object> omap) {
        List<OCooperPartner> list = getSqlMapClientTemplate().queryForList("EXT_ODS.getCooperPartnerInfoList", omap);
        return list;
    }
	/* (non-Javadoc)
	 * @see com.huateng.scf.ods.dao.ext.ExtOdsDAO#getCooperPartnerMonthList(java.util.HashMap)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OCooperPartner> getCooperPartnerMonthList(HashMap<String, Object> omap) {
		// TODO Auto-generated method stub
		 List<OCooperPartner> list = getSqlMapClientTemplate().queryForList("EXT_ODS.getCooperPartnerMonthList", omap);
	     return list;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.ods.dao.ext.ExtOdsDAO#getProjectAmountList(java.util.HashMap)
	 */
	@Override
	public List<OFinaStaAnalysis> getProjectAmountList(HashMap<String, Object> omap) {
		// TODO Auto-generated method stub
		 List<OFinaStaAnalysis> list = getSqlMapClientTemplate().queryForList("EXT_ODS.getProjectAmountList", omap);
	     return list;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.ods.dao.ext.ExtOdsDAO#getFinaTypeAmountList(java.util.HashMap)
	 */
	@Override
	public List<OFinaStaAnalysis> getFinaTypeAmountList(HashMap<String, Object> omap) {
		// TODO Auto-generated method stub
		 List<OFinaStaAnalysis> list = getSqlMapClientTemplate().queryForList("EXT_ODS.getFinaTypeAmountList", omap);
	     return list;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.ods.dao.ext.ExtOdsDAO#getProjectAmountList(java.util.HashMap)
	 */
	@Override
	public List<OFinaStaAnalysis> getProjectDateAmountList(HashMap<String, Object> omap) {
		// TODO Auto-generated method stub
		 List<OFinaStaAnalysis> list = getSqlMapClientTemplate().queryForList("EXT_ODS.getProjectDateAmountList", omap);
	     return list;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.ods.dao.ext.ExtOdsDAO#getProjectAmountList(java.util.HashMap)
	 */
	@Override
	public List<OFinaStaAnalysis> getProjectInfoList(HashMap<String, Object> omap) {
		// TODO Auto-generated method stub
		 List<OFinaStaAnalysis> list = getSqlMapClientTemplate().queryForList("EXT_ODS.getProjectInfoList", omap);
	     return list;
	}
	/**
	 * 统计各客户下的业务风险预警数
	 */
	@Override
	public List<PostLoanWarnVO> getPostLoanWarnStaList(HashMap<String, Object> omap,Page page) {
		// TODO Auto-generated method stub
		List<PostLoanWarnVO>  list = this.searchListPageMyObject("EXT_ODS.getPostLoanWarnStaList", omap,page);
		return list;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.ods.dao.ext.ExtOdsDAO#getPostLoanWarnDtlList(java.util.HashMap, com.huateng.base.common.beans.Page)
	 */
	@Override
	public List<PostLoanWarnVO> getPostLoanWarnDtlList(HashMap<String, Object> omap, Page page) {
		// TODO Auto-generated method stub
		List<PostLoanWarnVO>  list = this.searchListPageMyObject("EXT_ODS.getPostLoanWarnDtlList", omap,page);
		return list;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.ods.dao.ext.ExtOdsDAO#getPostLoanFinWarnDtlList(java.util.HashMap, com.huateng.base.common.beans.Page)
	 */
	@Override
	public List<PostLoanWarnVO> getPostLoanFinWarnDtlList(HashMap<String, Object> omap, Page page) {
		// TODO Auto-generated method stub
		List<PostLoanWarnVO>  list = this.searchListPageMyObject("EXT_ODS.getPostLoanFinWarnDtlList", omap,page);
		return list;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.ods.dao.ext.ExtOdsDAO#queryFundTransferLineList(java.util.Map)
	 */
	@Override
	public List<FundTransferVO> queryFundTransferLineList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<FundTransferVO> list = getSqlMapClientTemplate().queryForList("EXT_ODS.queryFundTransferLineList", map);
	    return list;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.ods.dao.ext.ExtOdsDAO#queryFundTransferRouteList(java.util.Map)
	 */
	@Override
	public List<FundTransferVO> queryFundTransferRouteList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<FundTransferVO> list = getSqlMapClientTemplate().queryForList("EXT_ODS.queryFundTransferRouteList", map);
		return list;
	}
	
	/**
	 * 查询客户的合作类型及其合作伙伴总数
	 * @param omap
	 * @return
	 */
	@Override
	public int countqueryCoopTypeList(Map<String, Object> omap)
	{
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_ODS.countqueryCoopTypeList", omap);
		return count;
	}
	/**
	 * 查询客户的合作类型及其合作伙伴
	 * @param omap
	 * @param page
	 * @return
	 */
	@Override
	public List<CooperPartnerInfo> queryCoopTypeList(Map<String, Object> omap, Page page) {
		// TODO Auto-generated method stub
		List<CooperPartnerInfo>  list = this.searchListPageMyObject("EXT_ODS.queryCoopTypeList", omap,page);
		return list;
	}
	/**
	 * 查询客户的合作类型及其合作伙伴的明细信息
	 * @param omap
	 * @param page
	 * @return
	 */
	@Override
	public List<CooperPartnerInfo> queryCoopTypeDtlList(Map<String, Object> omap) {
		// TODO Auto-generated method stub
		List<CooperPartnerInfo>  list = getSqlMapClientTemplate().queryForList("EXT_ODS.queryCoopTypeDtlList", omap);
		return list;
	}
	
}
