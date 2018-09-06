package com.huateng.scf.bas.pbc.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgPriceHis;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgPriceHisExample;
import java.util.List;

public interface IBPbcMtgPriceHisDAO {
    int countByExample(BPbcMtgPriceHisExample example);

    int deleteByExample(BPbcMtgPriceHisExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPbcMtgPriceHis record);

    void insertSelective(BPbcMtgPriceHis record);

    List<BPbcMtgPriceHis> selectByExample(BPbcMtgPriceHisExample example);

    BPbcMtgPriceHis selectByPrimaryKey(String id);

    int updateByExampleSelective(BPbcMtgPriceHis record, BPbcMtgPriceHisExample example);

    int updateByExample(BPbcMtgPriceHis record, BPbcMtgPriceHisExample example);

    int updateByPrimaryKeySelective(BPbcMtgPriceHis record);

    int updateByPrimaryKey(BPbcMtgPriceHis record);

    List<BPbcMtgPriceHis> selectByPage(BPbcMtgPriceHisExample example, Page page);
}