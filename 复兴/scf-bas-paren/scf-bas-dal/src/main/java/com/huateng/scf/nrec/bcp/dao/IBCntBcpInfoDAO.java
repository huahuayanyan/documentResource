package com.huateng.scf.nrec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfoExample;
import java.util.List;

public interface IBCntBcpInfoDAO {
    int countByExample(BCntBcpInfoExample example);

    int deleteByExample(BCntBcpInfoExample example);

    int deleteByPrimaryKey(String mastContno);

    void insert(BCntBcpInfo record);

    void insertSelective(BCntBcpInfo record);

    List<BCntBcpInfo> selectByExample(BCntBcpInfoExample example);

    BCntBcpInfo selectByPrimaryKey(String mastContno);

    int updateByExampleSelective(BCntBcpInfo record, BCntBcpInfoExample example);

    int updateByExample(BCntBcpInfo record, BCntBcpInfoExample example);

    int updateByPrimaryKeySelective(BCntBcpInfo record);

    int updateByPrimaryKey(BCntBcpInfo record);

    List<BCntBcpInfo> selectByPage(BCntBcpInfoExample example, Page page);
}