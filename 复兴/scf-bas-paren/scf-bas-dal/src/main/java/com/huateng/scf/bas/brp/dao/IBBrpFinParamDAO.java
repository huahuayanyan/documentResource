package com.huateng.scf.bas.brp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.model.BBrpFinParam;
import com.huateng.scf.bas.brp.dao.model.BBrpFinParamExample;
import java.util.List;

public interface IBBrpFinParamDAO {
    int countByExample(BBrpFinParamExample example);

    int deleteByExample(BBrpFinParamExample example);

    int deleteByPrimaryKey(String subjId);

    void insert(BBrpFinParam record);

    void insertSelective(BBrpFinParam record);

    List<BBrpFinParam> selectByExample(BBrpFinParamExample example);

    BBrpFinParam selectByPrimaryKey(String subjId);

    int updateByExampleSelective(BBrpFinParam record, BBrpFinParamExample example);

    int updateByExample(BBrpFinParam record, BBrpFinParamExample example);

    int updateByPrimaryKeySelective(BBrpFinParam record);

    int updateByPrimaryKey(BBrpFinParam record);

    List<BBrpFinParam> selectByPage(BBrpFinParamExample example, Page page);
}