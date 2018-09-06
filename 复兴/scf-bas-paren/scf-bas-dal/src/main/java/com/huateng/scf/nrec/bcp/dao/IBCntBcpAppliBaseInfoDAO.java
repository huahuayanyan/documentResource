package com.huateng.scf.nrec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpAppliBaseInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpAppliBaseInfoExample;
import java.util.List;

public interface IBCntBcpAppliBaseInfoDAO {
    int countByExample(BCntBcpAppliBaseInfoExample example);

    int deleteByExample(BCntBcpAppliBaseInfoExample example);

    int deleteByPrimaryKey(String appno);

    void insert(BCntBcpAppliBaseInfo record);

    void insertSelective(BCntBcpAppliBaseInfo record);

    List<BCntBcpAppliBaseInfo> selectByExample(BCntBcpAppliBaseInfoExample example);

    BCntBcpAppliBaseInfo selectByPrimaryKey(String appno);

    int updateByExampleSelective(BCntBcpAppliBaseInfo record, BCntBcpAppliBaseInfoExample example);

    int updateByExample(BCntBcpAppliBaseInfo record, BCntBcpAppliBaseInfoExample example);

    int updateByPrimaryKeySelective(BCntBcpAppliBaseInfo record);

    int updateByPrimaryKey(BCntBcpAppliBaseInfo record);

    List<BCntBcpAppliBaseInfo> selectByPage(BCntBcpAppliBaseInfoExample example, Page page);
}