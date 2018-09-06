package com.huateng.scf.nrec.bcp.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoBussQryDAO;
import com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO;
import com.huateng.scf.nrec.bcp.dao.domodel.RBcpDebtBussInfoDO;
import com.huateng.scf.nrec.bcp.dao.domodel.RBcpDebtInfoDO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;

/**
* <p>Title:</p>
* <p>Descriprion:</p>
* <p>Company:</p>
* @date
* @author
 */
@Repository(IBCntBcpInfoBussQryDAO.BeanId)
public class BCntBcpInfoBussQryDAOImpl extends IbatisDaoAnnotation4Template implements IBCntBcpInfoBussQryDAO {

	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BCntBcpInfoDO> findBCntBcpInfoDOByPage(Map<String, Object> param, Page page) {
		List<BCntBcpInfoDO> list = this.searchListPageMyObject("EXT_NREC_BUSS_QRY.selectBCntBcpInfoDOByPage", param, page);
		return list;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtBussInfoDO> findDebtRepaymentInfo(Map<String, Object> param, Page page) {
		List<RBcpDebtBussInfoDO> debtRepaymentInfos = this.searchListPageMyObject("EXT_NREC_BUSS_QRY.selectDebtRepaymentInfo", param, page);
		return debtRepaymentInfos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtInfoDO> getDebtInfoByPerson(Map<String, Object> param, Page page) {
		List<RBcpDebtInfoDO> results = this.searchListPageByMap("EXT_NREC_BUSS_QRY.selectDebtInfoByPerson", param, page);
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, String>> getFourProtocolTotalLnciAmtByProtocolNo(Map<String, String> param) {
		List<Map<String, String>> result = getSqlMapClientTemplate().queryForList("EXT_NREC_BUSS_QRY.selectTotalLnciAmtByProtocolNo", param);
	    return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpDebtBaseInfo> getDebtInfoQuery(Map<String, String> paramMap, Page page) {
		List<RBcpDebtBaseInfo> result = this.searchListPageMyObject("EXT_NREC_BUSS_QRY.selectDebtInfoQuery", paramMap, page);
	    return result;
	}

	@Override
	public int countDebtInfoByPerson(Map<String, Object> commonQueryVO) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_BUSS_QRY.countDebtInfoByPerson", commonQueryVO);
		return count;
	}

}
