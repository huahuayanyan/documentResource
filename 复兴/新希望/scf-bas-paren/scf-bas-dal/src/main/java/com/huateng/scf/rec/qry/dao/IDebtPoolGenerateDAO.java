package com.huateng.scf.rec.qry.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;

public interface IDebtPoolGenerateDAO {
	/**
	 * ***/
	List<Map<String, String>> getFourProtocolTotalLnciAmtByProtocolNo(Map<String,String> map);
   /**
	 * 应收账款单据信息查询R_BCP_DEBT_BASE_INFO
	 */
   List<RBcpDebtBaseInfo> getDebtInfoQuery(Map<String,String> param,Page page);

}
