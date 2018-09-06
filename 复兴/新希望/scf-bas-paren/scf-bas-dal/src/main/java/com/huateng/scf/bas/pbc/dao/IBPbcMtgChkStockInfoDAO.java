package com.huateng.scf.bas.pbc.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgChkStockInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgChkStockInfoExample;
import java.util.List;

public interface IBPbcMtgChkStockInfoDAO {
    int countByExample(BPbcMtgChkStockInfoExample example);

    int deleteByExample(BPbcMtgChkStockInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPbcMtgChkStockInfo record);

    void insertSelective(BPbcMtgChkStockInfo record);

    List<BPbcMtgChkStockInfo> selectByExample(BPbcMtgChkStockInfoExample example);

    BPbcMtgChkStockInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BPbcMtgChkStockInfo record, BPbcMtgChkStockInfoExample example);

    int updateByExample(BPbcMtgChkStockInfo record, BPbcMtgChkStockInfoExample example);

    int updateByPrimaryKeySelective(BPbcMtgChkStockInfo record);

    int updateByPrimaryKey(BPbcMtgChkStockInfo record);

    List<BPbcMtgChkStockInfo> selectByPage(BPbcMtgChkStockInfoExample example, Page page);
}