package com.huateng.scf.sto.nwr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormalExample;
import java.util.List;

public interface ISBcpAppliMortBillNormalDAO {
    int countByExample(SBcpAppliMortBillNormalExample example);

    int deleteByExample(SBcpAppliMortBillNormalExample example);

    int deleteByPrimaryKey(String id);

    void insert(SBcpAppliMortBillNormal record);

    void insertSelective(SBcpAppliMortBillNormal record);

    List<SBcpAppliMortBillNormal> selectByExample(SBcpAppliMortBillNormalExample example);

    SBcpAppliMortBillNormal selectByPrimaryKey(String id);

    int updateByExampleSelective(SBcpAppliMortBillNormal record, SBcpAppliMortBillNormalExample example);

    int updateByExample(SBcpAppliMortBillNormal record, SBcpAppliMortBillNormalExample example);

    int updateByPrimaryKeySelective(SBcpAppliMortBillNormal record);

    int updateByPrimaryKey(SBcpAppliMortBillNormal record);

    List<SBcpAppliMortBillNormal> selectByPage(SBcpAppliMortBillNormalExample example, Page page);
}