package com.huateng.scf.nrec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfoExample;
import java.util.List;

public interface IRBcpDebtInfoDAO {
    int countByExample(RBcpDebtInfoExample example);

    int deleteByExample(RBcpDebtInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(RBcpDebtInfo record);

    void insertSelective(RBcpDebtInfo record);

    List<RBcpDebtInfo> selectByExample(RBcpDebtInfoExample example);

    RBcpDebtInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(RBcpDebtInfo record, RBcpDebtInfoExample example);

    int updateByExample(RBcpDebtInfo record, RBcpDebtInfoExample example);

    int updateByPrimaryKeySelective(RBcpDebtInfo record);

    int updateByPrimaryKey(RBcpDebtInfo record);

    List<RBcpDebtInfo> selectByPage(RBcpDebtInfoExample example, Page page);
}