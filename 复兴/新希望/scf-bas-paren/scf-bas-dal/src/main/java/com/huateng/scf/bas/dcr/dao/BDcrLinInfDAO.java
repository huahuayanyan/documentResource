package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.model.BDcrLinInf;
import com.huateng.scf.bas.dcr.model.BDcrLinInfExample;

import java.util.List;

public interface BDcrLinInfDAO {
    int countByExample(BDcrLinInfExample example);

    int deleteByExample(BDcrLinInfExample example);

    int deleteByPrimaryKey(String linId);

    void insert(BDcrLinInf record);

    void insertSelective(BDcrLinInf record);

    List<BDcrLinInf> selectByExample(BDcrLinInfExample example);

    BDcrLinInf selectByPrimaryKey(String linId);

    int updateByExampleSelective(BDcrLinInf record, BDcrLinInfExample example);

    int updateByExample(BDcrLinInf record, BDcrLinInfExample example);

    int updateByPrimaryKeySelective(BDcrLinInf record);

    int updateByPrimaryKey(BDcrLinInf record);

    List<BDcrLinInf> selectByPage(BDcrLinInfExample example, Page page);
}