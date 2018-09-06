package com.huateng.scf.bas.crm.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfoExample;
import java.util.List;

public interface IBCrmMoniEvaInfoDAO {
    int countByExample(BCrmMoniEvaInfoExample example);

    int deleteByExample(BCrmMoniEvaInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCrmMoniEvaInfo record);

    void insertSelective(BCrmMoniEvaInfo record);

    List<BCrmMoniEvaInfo> selectByExample(BCrmMoniEvaInfoExample example);

    BCrmMoniEvaInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BCrmMoniEvaInfo record, BCrmMoniEvaInfoExample example);

    int updateByExample(BCrmMoniEvaInfo record, BCrmMoniEvaInfoExample example);

    int updateByPrimaryKeySelective(BCrmMoniEvaInfo record);

    int updateByPrimaryKey(BCrmMoniEvaInfo record);

    List<BCrmMoniEvaInfo> selectByPage(BCrmMoniEvaInfoExample example, Page page);
}