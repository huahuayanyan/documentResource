package com.huateng.scf.nrec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillApp;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillAppExample;
import java.util.List;

public interface IRBcpDuebillAppDAO {
    int countByExample(RBcpDuebillAppExample example);

    int deleteByExample(RBcpDuebillAppExample example);

    int deleteByPrimaryKey(String appno);

    void insert(RBcpDuebillApp record);

    void insertSelective(RBcpDuebillApp record);

    List<RBcpDuebillApp> selectByExample(RBcpDuebillAppExample example);

    RBcpDuebillApp selectByPrimaryKey(String appno);

    int updateByExampleSelective(RBcpDuebillApp record, RBcpDuebillAppExample example);

    int updateByExample(RBcpDuebillApp record, RBcpDuebillAppExample example);

    int updateByPrimaryKeySelective(RBcpDuebillApp record);

    int updateByPrimaryKey(RBcpDuebillApp record);

    List<RBcpDuebillApp> selectByPage(RBcpDuebillAppExample example, Page page);
}