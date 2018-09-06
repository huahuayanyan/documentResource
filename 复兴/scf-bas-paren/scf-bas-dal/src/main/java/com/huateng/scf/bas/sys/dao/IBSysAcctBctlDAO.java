package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctlExample;
import java.util.List;

public interface IBSysAcctBctlDAO {
    int countByExample(RSysAcctBctlExample example);

    int deleteByExample(RSysAcctBctlExample example);

    int deleteByPrimaryKey(String brcode);

    void insert(RSysAcctBctl record);

    void insertSelective(RSysAcctBctl record);

    List<RSysAcctBctl> selectByExample(RSysAcctBctlExample example);

    RSysAcctBctl selectByPrimaryKey(String brcode);

    int updateByExampleSelective(RSysAcctBctl record, RSysAcctBctlExample example);

    int updateByExample(RSysAcctBctl record, RSysAcctBctlExample example);

    int updateByPrimaryKeySelective(RSysAcctBctl record);

    int updateByPrimaryKey(RSysAcctBctl record);

    List<RSysAcctBctl> selectByPage(RSysAcctBctlExample example, Page page);
}