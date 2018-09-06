package com.huateng.scf.rec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOutExample;
import java.util.List;

public interface IRBcpAppliCostOutDAO {
    int countByExample(RBcpAppliCostOutExample example);

    int deleteByExample(RBcpAppliCostOutExample example);

    int deleteByPrimaryKey(String id);

    void insert(RBcpAppliCostOut record);

    void insertSelective(RBcpAppliCostOut record);

    List<RBcpAppliCostOut> selectByExample(RBcpAppliCostOutExample example);

    RBcpAppliCostOut selectByPrimaryKey(String id);

    int updateByExampleSelective(RBcpAppliCostOut record, RBcpAppliCostOutExample example);

    int updateByExample(RBcpAppliCostOut record, RBcpAppliCostOutExample example);

    int updateByPrimaryKeySelective(RBcpAppliCostOut record);

    int updateByPrimaryKey(RBcpAppliCostOut record);

    List<RBcpAppliCostOut> selectByPage(RBcpAppliCostOutExample example, Page page);
}