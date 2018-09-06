package com.huateng.scf.bas.crm.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmContactsInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmContactsInfoExample;
import java.util.List;

public interface IBCrmContactsInfoDAO {
    int countByExample(BCrmContactsInfoExample example);

    int deleteByExample(BCrmContactsInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCrmContactsInfo record);

    void insertSelective(BCrmContactsInfo record);

    List<BCrmContactsInfo> selectByExample(BCrmContactsInfoExample example);

    BCrmContactsInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BCrmContactsInfo record, BCrmContactsInfoExample example);

    int updateByExample(BCrmContactsInfo record, BCrmContactsInfoExample example);

    int updateByPrimaryKeySelective(BCrmContactsInfo record);

    int updateByPrimaryKey(BCrmContactsInfo record);

    List<BCrmContactsInfo> selectByPage(BCrmContactsInfoExample example, Page page);
}