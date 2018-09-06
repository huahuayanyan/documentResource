package com.huateng.scf.rec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussInfo;

import java.util.List;

public interface IRBcpDebtBussDtlDAO {
    int countByExample(RBcpDebtBussDtlExample example);

    int deleteByExample(RBcpDebtBussDtlExample example);

    int deleteByPrimaryKey(String id);

    void insert(RBcpDebtBussDtl record);

    void insertSelective(RBcpDebtBussDtl record);

    List<RBcpDebtBussDtl> selectByExample(RBcpDebtBussDtlExample example);

    RBcpDebtBussDtl selectByPrimaryKey(String id);

    int updateByExampleSelective(RBcpDebtBussDtl record, RBcpDebtBussDtlExample example);

    int updateByExample(RBcpDebtBussDtl record, RBcpDebtBussDtlExample example);

    int updateByPrimaryKeySelective(RBcpDebtBussDtl record);

    int updateByPrimaryKey(RBcpDebtBussDtl record);

    List<RBcpDebtBussDtl> selectByPage(RBcpDebtBussDtlExample example, Page page);

	RBcpDebtBussInfo saveDebtChargeBussInfo(DebtBussInfoVO debtVO);
	
	List<RBcpDebtBussDtl> selectByAppno(String appno);

	List<RBcpDebtBussDtl> queryAppliBussDetailByAppno(String appno, String bussType);
	
}