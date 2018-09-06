package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.model.BDcrLinTyp;
import com.huateng.scf.bas.dcr.model.BDcrLinTypExample;
import java.util.List;

public interface BDcrLinTypDAO {
    int countByExample(BDcrLinTypExample example);

    int deleteByExample(BDcrLinTypExample example);

    int deleteByPrimaryKey(String crId);

    void insert(BDcrLinTyp record);

    void insertSelective(BDcrLinTyp record);

    List<BDcrLinTyp> selectByExample(BDcrLinTypExample example);

    BDcrLinTyp selectByPrimaryKey(String crId);

    int updateByExampleSelective(BDcrLinTyp record, BDcrLinTypExample example);

    int updateByExample(BDcrLinTyp record, BDcrLinTypExample example);

    int updateByPrimaryKeySelective(BDcrLinTyp record);

    int updateByPrimaryKey(BDcrLinTyp record);

    List<BDcrLinTyp> selectByPage(BDcrLinTypExample example, Page page);
}