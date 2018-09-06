package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysQueryLimits;
import com.huateng.scf.bas.sys.dao.model.BSysQueryLimitsExample;
import java.util.List;

public interface IBSysQueryLimitsDAO {
    int countByExample(BSysQueryLimitsExample example);

    int deleteByExample(BSysQueryLimitsExample example);

    int deleteByPrimaryKey(String roleId);

    void insert(BSysQueryLimits record);

    void insertSelective(BSysQueryLimits record);

    List<BSysQueryLimits> selectByExample(BSysQueryLimitsExample example);

    BSysQueryLimits selectByPrimaryKey(String roleId);

    int updateByExampleSelective(BSysQueryLimits record, BSysQueryLimitsExample example);

    int updateByExample(BSysQueryLimits record, BSysQueryLimitsExample example);

    int updateByPrimaryKeySelective(BSysQueryLimits record);

    int updateByPrimaryKey(BSysQueryLimits record);

    List<BSysQueryLimits> selectByPage(BSysQueryLimitsExample example, Page page);
}