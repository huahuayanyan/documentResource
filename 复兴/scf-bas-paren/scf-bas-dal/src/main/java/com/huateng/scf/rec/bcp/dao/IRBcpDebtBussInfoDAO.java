package com.huateng.scf.rec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussInfoExample;
import java.util.List;
import java.util.Map;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;

public interface IRBcpDebtBussInfoDAO {
    int countByExample(RBcpDebtBussInfoExample example);

    int deleteByExample(RBcpDebtBussInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(RBcpDebtBussInfo record);

    void insertSelective(RBcpDebtBussInfo record);

    List<RBcpDebtBussInfo> selectByExample(RBcpDebtBussInfoExample example);

    RBcpDebtBussInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(RBcpDebtBussInfo record, RBcpDebtBussInfoExample example);

    int updateByExample(RBcpDebtBussInfo record, RBcpDebtBussInfoExample example);

    int updateByPrimaryKeySelective(RBcpDebtBussInfo record);

    int updateByPrimaryKey(RBcpDebtBussInfo record);

    List<RBcpDebtBussInfo> selectByPage(RBcpDebtBussInfoExample example, Page page);

	List<DebtBillsInfoVO> queryDebtRepaymentInfo(Map<String, Object> parameters, int pageSize, int pageNo);

	Integer queryDebtRepaymentInfoCount(Map<String, Object> parameters);


}