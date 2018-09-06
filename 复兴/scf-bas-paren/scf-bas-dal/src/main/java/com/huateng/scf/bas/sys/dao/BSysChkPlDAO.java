package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysChkPl;
import com.huateng.scf.bas.sys.dao.model.BSysChkPlExample;

import java.util.List;

public interface BSysChkPlDAO {
    int countByExample(BSysChkPlExample example);

    int deleteByExample(BSysChkPlExample example);

    int deleteByPrimaryKey(String chkPlId);

    String insert(BSysChkPl record);

    String insertSelective(BSysChkPl record);

    List<BSysChkPl> selectByExample(BSysChkPlExample example);

    BSysChkPl selectByPrimaryKey(String chkPlId);

    int updateByExampleSelective(BSysChkPl record, BSysChkPlExample example);

    int updateByExample(BSysChkPl record, BSysChkPlExample example);

    int updateByPrimaryKeySelective(BSysChkPl record);

    int updateByPrimaryKey(BSysChkPl record);

    List<BSysChkPl> selectByPage(BSysChkPlExample example, Page page);
}