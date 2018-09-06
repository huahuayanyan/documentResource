package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysChkRec;
import com.huateng.scf.bas.sys.dao.model.BSysChkRecExample;

import java.util.List;

public interface BSysChkRecDAO {
    int countByExample(BSysChkRecExample example);

    int deleteByExample(BSysChkRecExample example);

    int deleteByPrimaryKey(String recId);

    String insert(BSysChkRec record);

    String insertSelective(BSysChkRec record);

    List<BSysChkRec> selectByExample(BSysChkRecExample example);

    BSysChkRec selectByPrimaryKey(String recId);

    int updateByExampleSelective(BSysChkRec record, BSysChkRecExample example);

    int updateByExample(BSysChkRec record, BSysChkRecExample example);

    int updateByPrimaryKeySelective(BSysChkRec record);

    int updateByPrimaryKey(BSysChkRec record);

    List<BSysChkRec> selectByPage(BSysChkRecExample example, Page page);
    
    List<BSysChkRec> findAllBSysChkRecs();
}