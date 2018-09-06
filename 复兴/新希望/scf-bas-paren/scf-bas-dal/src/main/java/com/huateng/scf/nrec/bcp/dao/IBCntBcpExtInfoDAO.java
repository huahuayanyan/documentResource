package com.huateng.scf.nrec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfoExample;
import java.util.List;

public interface IBCntBcpExtInfoDAO {
    int countByExample(BCntBcpExtInfoExample example);

    int deleteByExample(BCntBcpExtInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCntBcpExtInfo record);

    void insertSelective(BCntBcpExtInfo record);

    List<BCntBcpExtInfo> selectByExample(BCntBcpExtInfoExample example);

    BCntBcpExtInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BCntBcpExtInfo record, BCntBcpExtInfoExample example);

    int updateByExample(BCntBcpExtInfo record, BCntBcpExtInfoExample example);

    int updateByPrimaryKeySelective(BCntBcpExtInfo record);

    int updateByPrimaryKey(BCntBcpExtInfo record);

    List<BCntBcpExtInfo> selectByPage(BCntBcpExtInfoExample example, Page page);
}