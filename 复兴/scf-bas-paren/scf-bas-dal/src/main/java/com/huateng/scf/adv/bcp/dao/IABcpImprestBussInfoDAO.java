package com.huateng.scf.adv.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfo;
import com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfoExample;
import java.util.List;

public interface IABcpImprestBussInfoDAO {
    int countByExample(ABcpImprestBussInfoExample example);

    int deleteByExample(ABcpImprestBussInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(ABcpImprestBussInfo record);

    void insertSelective(ABcpImprestBussInfo record);

    List<ABcpImprestBussInfo> selectByExample(ABcpImprestBussInfoExample example);

    ABcpImprestBussInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(ABcpImprestBussInfo record, ABcpImprestBussInfoExample example);

    int updateByExample(ABcpImprestBussInfo record, ABcpImprestBussInfoExample example);

    int updateByPrimaryKeySelective(ABcpImprestBussInfo record);

    int updateByPrimaryKey(ABcpImprestBussInfo record);

    List<ABcpImprestBussInfo> selectByPage(ABcpImprestBussInfoExample example, Page page);
}