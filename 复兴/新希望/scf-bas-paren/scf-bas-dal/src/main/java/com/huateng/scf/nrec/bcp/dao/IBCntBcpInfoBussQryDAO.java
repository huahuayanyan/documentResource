package com.huateng.scf.nrec.bcp.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO;
import com.huateng.scf.nrec.bcp.dao.domodel.RBcpDebtBussInfoDO;
import com.huateng.scf.nrec.bcp.dao.domodel.RBcpDebtInfoDO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;

public interface IBCntBcpInfoBussQryDAO {
	
	public static final String BeanId ="IBCntBcpInfoBussQryDAO";
	
	public List<BCntBcpInfoDO> findBCntBcpInfoDOByPage(Map<String, Object> param, Page page);

	public List<RBcpDebtBussInfoDO> findDebtRepaymentInfo(Map<String, Object> bcntbcpinfo, Page page);

	public List<RBcpDebtInfoDO> getDebtInfoByPerson(Map<String, Object> commonQueryVO, Page page);

	public List<Map<String, String>> getFourProtocolTotalLnciAmtByProtocolNo(Map<String, String> param);

	public List<RBcpDebtBaseInfo> getDebtInfoQuery(Map<String, String> paramMap, Page page);

	public int countDebtInfoByPerson(Map<String, Object> commonQueryVO);

}
