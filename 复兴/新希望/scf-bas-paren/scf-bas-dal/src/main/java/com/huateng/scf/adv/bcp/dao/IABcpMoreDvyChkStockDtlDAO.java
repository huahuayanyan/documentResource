package com.huateng.scf.adv.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStockDtl;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStockDtlExample;
import java.util.List;

public interface IABcpMoreDvyChkStockDtlDAO {
    int countByExample(ABcpMoreDvyChkStockDtlExample example);

    int deleteByExample(ABcpMoreDvyChkStockDtlExample example);

    int deleteByPrimaryKey(String id);

    void insert(ABcpMoreDvyChkStockDtl record);

    void insertSelective(ABcpMoreDvyChkStockDtl record);

    List<ABcpMoreDvyChkStockDtl> selectByExample(ABcpMoreDvyChkStockDtlExample example);

    ABcpMoreDvyChkStockDtl selectByPrimaryKey(String id);

    int updateByExampleSelective(ABcpMoreDvyChkStockDtl record, ABcpMoreDvyChkStockDtlExample example);

    int updateByExample(ABcpMoreDvyChkStockDtl record, ABcpMoreDvyChkStockDtlExample example);

    int updateByPrimaryKeySelective(ABcpMoreDvyChkStockDtl record);

    int updateByPrimaryKey(ABcpMoreDvyChkStockDtl record);

    List<ABcpMoreDvyChkStockDtl> selectByPage(ABcpMoreDvyChkStockDtlExample example, Page page);
    List<ABcpMoreDvyChkStockDtl> selectUninByStock(String appno);
}