package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.model.BDcrChkDir;
import com.huateng.scf.bas.dcr.model.BDcrChkDirExample;
import java.util.List;

public interface BDcrChkDirDAO {
    int countByExample(BDcrChkDirExample example);

    int deleteByExample(BDcrChkDirExample example);

    int deleteByPrimaryKey(String chkDirId);

    void insert(BDcrChkDir record);

    void insertSelective(BDcrChkDir record);

    List<BDcrChkDir> selectByExample(BDcrChkDirExample example);

    BDcrChkDir selectByPrimaryKey(String chkDirId);

    int updateByExampleSelective(BDcrChkDir record, BDcrChkDirExample example);

    int updateByExample(BDcrChkDir record, BDcrChkDirExample example);

    int updateByPrimaryKeySelective(BDcrChkDir record);

    int updateByPrimaryKey(BDcrChkDir record);

    List<BDcrChkDir> selectByPage(BDcrChkDirExample example, Page page);
}