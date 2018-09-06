package com.huateng.scf.adv.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss;
import com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBussExample;
import java.util.List;

public interface IABcpAppliImprestBussDAO {
    int countByExample(ABcpAppliImprestBussExample example);

    int deleteByExample(ABcpAppliImprestBussExample example);

    int deleteByPrimaryKey(String id);

    void insert(ABcpAppliImprestBuss record);

    void insertSelective(ABcpAppliImprestBuss record);

    List<ABcpAppliImprestBuss> selectByExample(ABcpAppliImprestBussExample example);

    ABcpAppliImprestBuss selectByPrimaryKey(String id);

    int updateByExampleSelective(ABcpAppliImprestBuss record, ABcpAppliImprestBussExample example);

    int updateByExample(ABcpAppliImprestBuss record, ABcpAppliImprestBussExample example);

    int updateByPrimaryKeySelective(ABcpAppliImprestBuss record);

    int updateByPrimaryKey(ABcpAppliImprestBuss record);

    List<ABcpAppliImprestBuss> selectByPage(ABcpAppliImprestBussExample example, Page page);
    
    //EXT
    /**
     * 根据申请编号查询预付款流水表
     * @param appno
     * @return
     */
    ABcpAppliImprestBuss queryAppliImprestBussByAppno(String appno);
    
}