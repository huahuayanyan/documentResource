package com.huateng.scf.rec.qry.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.qry.dao.IDebtPoolGenerateDAO;

@Repository("DebtPoolGenerateDAO")
public class DebtPoolGenerateDAOImpl extends IbatisDaoAnnotation4Template implements IDebtPoolGenerateDAO {
	 @Resource(name="sqlMapClientTemplate")
	   private IbatisTemplate template;
	  public IbatisTemplate getSqlMapClientTemplate() {
			// TODO Auto-generated method stub
	        return this.template;

		}
	  
	@Override
	public List<Map<String, String>> getFourProtocolTotalLnciAmtByProtocolNo(Map<String, String> map) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> result = getSqlMapClientTemplate().queryForList("EXT_QRY_DEBTPOOLGENERATEQUERY.getTotalLnciAmtByProtocolNo", map);
	    return result;
	}

	@Override
	public List<RBcpDebtBaseInfo> getDebtInfoQuery(Map<String, String> param,Page page) {
		@SuppressWarnings("unchecked")
		List<RBcpDebtBaseInfo> list = this.searchListPageMyObject("EXT_QRY_DEBTPOOLGENERATEQUERY.getDebtInfoQuery", param,page);
		return list;
	}
	 

}
