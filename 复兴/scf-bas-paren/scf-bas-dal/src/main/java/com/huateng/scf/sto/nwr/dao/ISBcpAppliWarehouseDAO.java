package com.huateng.scf.sto.nwr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliWarehouse;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliWarehouseExample;
import java.util.List;

public interface ISBcpAppliWarehouseDAO {
    int countByExample(SBcpAppliWarehouseExample example);

    int deleteByExample(SBcpAppliWarehouseExample example);

    int deleteByPrimaryKey(String appno);

    void insert(SBcpAppliWarehouse record);

    void insertSelective(SBcpAppliWarehouse record);

    List<SBcpAppliWarehouse> selectByExample(SBcpAppliWarehouseExample example);

    SBcpAppliWarehouse selectByPrimaryKey(String appno);

    int updateByExampleSelective(SBcpAppliWarehouse record, SBcpAppliWarehouseExample example);

    int updateByExample(SBcpAppliWarehouse record, SBcpAppliWarehouseExample example);

    int updateByPrimaryKeySelective(SBcpAppliWarehouse record);

    int updateByPrimaryKey(SBcpAppliWarehouse record);

    List<SBcpAppliWarehouse> selectByPage(SBcpAppliWarehouseExample example, Page page);
}