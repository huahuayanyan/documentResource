package com.huateng.scf.bas.cnt.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmPriceHis;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmPriceHisExample;

import java.util.List;

public interface IBCntMprotCmPriceHisDAO {
    int countByExample(BCntMprotCmPriceHisExample example);

    int deleteByExample(BCntMprotCmPriceHisExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCntMprotCmPriceHis record);

    void insertSelective(BCntMprotCmPriceHis record);

    List<BCntMprotCmPriceHis> selectByExample(BCntMprotCmPriceHisExample example);

    BCntMprotCmPriceHis selectByPrimaryKey(String id);

    int updateByExampleSelective(BCntMprotCmPriceHis record, BCntMprotCmPriceHisExample example);

    int updateByExample(BCntMprotCmPriceHis record, BCntMprotCmPriceHisExample example);

    int updateByPrimaryKeySelective(BCntMprotCmPriceHis record);

    int updateByPrimaryKey(BCntMprotCmPriceHis record);

    List<BCntMprotCmPriceHis> selectByPage(BCntMprotCmPriceHisExample example, Page page);
}