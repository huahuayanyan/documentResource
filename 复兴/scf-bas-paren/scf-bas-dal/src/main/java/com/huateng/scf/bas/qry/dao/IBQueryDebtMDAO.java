package com.huateng.scf.bas.qry.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.qry.dao.model.BQueryDebtM;
import com.huateng.scf.bas.qry.dao.model.BQueryDebtMExample;
import java.util.List;

public interface IBQueryDebtMDAO {
    int countByExample(BQueryDebtMExample example);

    int deleteByExample(BQueryDebtMExample example);

    int deleteByPrimaryKey(String id);

    void insert(BQueryDebtM record);

    void insertSelective(BQueryDebtM record);

    List<BQueryDebtM> selectByExample(BQueryDebtMExample example);

    BQueryDebtM selectByPrimaryKey(String id);

    int updateByExampleSelective(BQueryDebtM record, BQueryDebtMExample example);

    int updateByExample(BQueryDebtM record, BQueryDebtMExample example);

    int updateByPrimaryKeySelective(BQueryDebtM record);

    int updateByPrimaryKey(BQueryDebtM record);

    List<BQueryDebtM> selectByPage(BQueryDebtMExample example, Page page);
}