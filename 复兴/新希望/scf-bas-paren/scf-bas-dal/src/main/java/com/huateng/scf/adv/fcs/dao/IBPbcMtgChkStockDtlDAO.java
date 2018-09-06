package com.huateng.scf.adv.fcs.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.fcs.model.BPbcMtgChkStockDtl;
import com.huateng.scf.adv.fcs.model.BPbcMtgChkStockDtlExample;

import java.util.List;

public interface IBPbcMtgChkStockDtlDAO {
    int countByExample(BPbcMtgChkStockDtlExample example);

    int deleteByExample(BPbcMtgChkStockDtlExample example);

    int deleteByPrimaryKey(String id);
    
    int deleteByTblId(String tblId);

    void insert(BPbcMtgChkStockDtl record);

    void insertSelective(BPbcMtgChkStockDtl record);

    List<BPbcMtgChkStockDtl> selectByExample(BPbcMtgChkStockDtlExample example);

    BPbcMtgChkStockDtl selectByPrimaryKey(String id);

    int updateByExampleSelective(BPbcMtgChkStockDtl record, BPbcMtgChkStockDtlExample example);

    int updateByExample(BPbcMtgChkStockDtl record, BPbcMtgChkStockDtlExample example);

    int updateByPrimaryKeySelective(BPbcMtgChkStockDtl record);

    int updateByPrimaryKey(BPbcMtgChkStockDtl record);

    List<BPbcMtgChkStockDtl> selectByPage(BPbcMtgChkStockDtlExample example, Page page);
}