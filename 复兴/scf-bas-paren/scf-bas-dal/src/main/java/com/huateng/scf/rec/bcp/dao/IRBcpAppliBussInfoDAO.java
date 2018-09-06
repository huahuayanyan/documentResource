package com.huateng.scf.rec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample;
import com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO;

import java.util.List;

public interface IRBcpAppliBussInfoDAO {
    int countByExample(RBcpAppliBussInfoExample example);

    int deleteByExample(RBcpAppliBussInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(RBcpAppliBussInfo record);

    void insertSelective(RBcpAppliBussInfo record);

    List<RBcpAppliBussInfo> selectByExample(RBcpAppliBussInfoExample example);

    RBcpAppliBussInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(RBcpAppliBussInfo record, RBcpAppliBussInfoExample example);

    int updateByExample(RBcpAppliBussInfo record, RBcpAppliBussInfoExample example);

    int updateByPrimaryKeySelective(RBcpAppliBussInfo record);

    int updateByPrimaryKey(RBcpAppliBussInfo record);

    List<RBcpAppliBussInfo> selectByPage(RBcpAppliBussInfoExample example, Page page);

    RBcpAppliBussInfo selectByAppno(String appno);

	List<RBcpAppliBussInfo> selectAppliBussInfoBillsNo(String appno);
}