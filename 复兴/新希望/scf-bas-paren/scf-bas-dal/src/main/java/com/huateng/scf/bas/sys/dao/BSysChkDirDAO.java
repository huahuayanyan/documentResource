package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysChkDir;
import com.huateng.scf.bas.sys.dao.model.BSysChkDirExample;

import java.util.List;

public interface BSysChkDirDAO {
    int countByExample(BSysChkDirExample example);

    int deleteByExample(BSysChkDirExample example);

    int deleteByPrimaryKey(String mdlId);

    String insert(BSysChkDir record);

    String insertSelective(BSysChkDir record);

    List<BSysChkDir> selectByExample(BSysChkDirExample example);

    BSysChkDir selectByPrimaryKey(String mdlId);

    int updateByExampleSelective(BSysChkDir record, BSysChkDirExample example);

    int updateByExample(BSysChkDir record, BSysChkDirExample example);

    int updateByPrimaryKeySelective(BSysChkDir record);

    int updateByPrimaryKey(BSysChkDir record);

    List<BSysChkDir> selectByPage(BSysChkDirExample example, Page page);
}