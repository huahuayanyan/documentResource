package com.huateng.scf.bas.brp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.model.BBrpFileParam;
import com.huateng.scf.bas.brp.dao.model.BBrpFileParamExample;
import java.util.List;

public interface IBBrpFileParamDAO {
    int countByExample(BBrpFileParamExample example);

    int deleteByExample(BBrpFileParamExample example);

    int deleteByPrimaryKey(String id);

    void insert(BBrpFileParam record);

    void insertSelective(BBrpFileParam record);

    List<BBrpFileParam> selectByExample(BBrpFileParamExample example);

    BBrpFileParam selectByPrimaryKey(String id);

    int updateByExampleSelective(BBrpFileParam record, BBrpFileParamExample example);

    int updateByExample(BBrpFileParam record, BBrpFileParamExample example);

    int updateByPrimaryKeySelective(BBrpFileParam record);

    int updateByPrimaryKey(BBrpFileParam record);

    List<BBrpFileParam> selectByPage(BBrpFileParamExample example, Page page);
}