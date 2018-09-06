package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdMort;
import com.huateng.scf.bas.prd.dao.model.BPrdMortExample;

import java.util.List;

public interface IBPrdMortDAO {
    int countByExample(BPrdMortExample example);

    int deleteByExample(BPrdMortExample example);

    int deleteByPrimaryKey(String productId);

    void insert(BPrdMort record);

    void insertSelective(BPrdMort record);

    List<BPrdMort> selectByExample(BPrdMortExample example);

    BPrdMort selectByPrimaryKey(String productId);

    int updateByExampleSelective(BPrdMort record, BPrdMortExample example);

    int updateByExample(BPrdMort record, BPrdMortExample example);

    int updateByPrimaryKeySelective(BPrdMort record);

    int updateByPrimaryKey(BPrdMort record);

    List<BPrdMort> selectByPage(BPrdMortExample example, Page page);
}