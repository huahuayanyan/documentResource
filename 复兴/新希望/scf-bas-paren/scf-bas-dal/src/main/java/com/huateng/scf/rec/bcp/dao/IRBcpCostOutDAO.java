package com.huateng.scf.rec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.RBcpCostOut;
import com.huateng.scf.rec.bcp.dao.model.RBcpCostOutExample;
import java.util.List;

public interface IRBcpCostOutDAO {
    int countByExample(RBcpCostOutExample example);

    int deleteByExample(RBcpCostOutExample example);

    int deleteByPrimaryKey(String id);

    void insert(RBcpCostOut record);

    void insertSelective(RBcpCostOut record);

    List<RBcpCostOut> selectByExample(RBcpCostOutExample example);

    RBcpCostOut selectByPrimaryKey(String id);

    int updateByExampleSelective(RBcpCostOut record, RBcpCostOutExample example);

    int updateByExample(RBcpCostOut record, RBcpCostOutExample example);

    int updateByPrimaryKeySelective(RBcpCostOut record);

    int updateByPrimaryKey(RBcpCostOut record);

    List<RBcpCostOut> selectByPage(RBcpCostOutExample example, Page page);
}