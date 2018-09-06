package com.huateng.scf.bas.crm.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmAnalInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmAnalInfoExample;
import java.util.List;

public interface IBCrmAnalInfoDAO {
    int countByExample(BCrmAnalInfoExample example);

    int deleteByExample(BCrmAnalInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCrmAnalInfo record);

    void insertSelective(BCrmAnalInfo record);

    List<BCrmAnalInfo> selectByExample(BCrmAnalInfoExample example);

    BCrmAnalInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BCrmAnalInfo record, BCrmAnalInfoExample example);

    int updateByExample(BCrmAnalInfo record, BCrmAnalInfoExample example);

    int updateByPrimaryKeySelective(BCrmAnalInfo record);

    int updateByPrimaryKey(BCrmAnalInfo record);

    List<BCrmAnalInfo> selectByPage(BCrmAnalInfoExample example, Page page);
    
}