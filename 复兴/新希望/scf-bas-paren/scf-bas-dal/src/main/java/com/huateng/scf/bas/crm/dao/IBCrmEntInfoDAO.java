package com.huateng.scf.bas.crm.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfoExample;
import java.util.List;

public interface IBCrmEntInfoDAO {
    int countByExample(BCrmEntInfoExample example);

    int deleteByExample(BCrmEntInfoExample example);

    int deleteByPrimaryKey(String custcd);

    void insert(BCrmEntInfo record);

    void insertSelective(BCrmEntInfo record);

    List<BCrmEntInfo> selectByExample(BCrmEntInfoExample example);

    BCrmEntInfo selectByPrimaryKey(String custcd);

    int updateByExampleSelective(BCrmEntInfo record, BCrmEntInfoExample example);

    int updateByExample(BCrmEntInfo record, BCrmEntInfoExample example);

    int updateByPrimaryKeySelective(BCrmEntInfo record);

    int updateByPrimaryKey(BCrmEntInfo record);

    List<BCrmEntInfo> selectByPage(BCrmEntInfoExample example, Page page);
}