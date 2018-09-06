package com.huateng.scf.bas.crm.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfoExample;
import java.util.List;

public interface IBCrmMoniEntInfoDAO {
    int countByExample(BCrmMoniEntInfoExample example);

    int deleteByExample(BCrmMoniEntInfoExample example);

    void insert(BCrmMoniEntInfo record);

    void insertSelective(BCrmMoniEntInfo record);

    List<BCrmMoniEntInfo> selectByExample(BCrmMoniEntInfoExample example);
    
    BCrmMoniEntInfo selectByPrimaryKey(String custcd);

    int updateByExampleSelective(BCrmMoniEntInfo record, BCrmMoniEntInfoExample example);

    int updateByExample(BCrmMoniEntInfo record, BCrmMoniEntInfoExample example);

    List<BCrmMoniEntInfo> selectByPage(BCrmMoniEntInfoExample example, Page page);
}