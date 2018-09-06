package com.huateng.scf.bas.brp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.model.BBrpCostParam;
import com.huateng.scf.bas.brp.dao.model.BBrpCostParamExample;
import java.util.List;

public interface IBBrpCostParamDAO {
    int countByExample(BBrpCostParamExample example);

    int deleteByExample(BBrpCostParamExample example);

    int deleteByPrimaryKey(String id);

    void insert(BBrpCostParam record);

    void insertSelective(BBrpCostParam record);

    List<BBrpCostParam> selectByExample(BBrpCostParamExample example);

    BBrpCostParam selectByPrimaryKey(String id);

    int updateByExampleSelective(BBrpCostParam record, BBrpCostParamExample example);

    int updateByExample(BBrpCostParam record, BBrpCostParamExample example);

    int updateByPrimaryKeySelective(BBrpCostParam record);

    int updateByPrimaryKey(BBrpCostParam record);

    List<BBrpCostParam> selectByPage(BBrpCostParamExample example, Page page);
}