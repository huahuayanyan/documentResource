package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysGlobalInfo;
import com.huateng.scf.bas.sys.dao.model.BSysGlobalInfoExample;
import java.util.List;

public interface IBSysGlobalInfoDAO {
    int countByExample(BSysGlobalInfoExample example);

    int deleteByExample(BSysGlobalInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BSysGlobalInfo record);

    void insertSelective(BSysGlobalInfo record);

    List<BSysGlobalInfo> selectByExample(BSysGlobalInfoExample example);

    BSysGlobalInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BSysGlobalInfo record, BSysGlobalInfoExample example);

    int updateByExample(BSysGlobalInfo record, BSysGlobalInfoExample example);

    int updateByPrimaryKeySelective(BSysGlobalInfo record);

    int updateByPrimaryKey(BSysGlobalInfo record);

    List<BSysGlobalInfo> selectByPage(BSysGlobalInfoExample example, Page page);
}