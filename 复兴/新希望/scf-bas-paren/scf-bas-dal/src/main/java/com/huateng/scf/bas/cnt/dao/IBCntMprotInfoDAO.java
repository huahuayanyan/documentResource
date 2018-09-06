package com.huateng.scf.bas.cnt.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotInfoExample;
import java.util.List;

public interface IBCntMprotInfoDAO {
    int countByExample(BCntMprotInfoExample example);

    int deleteByExample(BCntMprotInfoExample example);
    
    int deleteByObject(BCntMprotInfo bCntMprotInfo);

    int deleteByPrimaryKey(String mortgageNo);

    void insert(BCntMprotInfo record);

    void insertSelective(BCntMprotInfo record);

    List<BCntMprotInfo> selectByExample(BCntMprotInfoExample example);

    BCntMprotInfo selectByPrimaryKey(String mortgageNo);

    int updateByExampleSelective(BCntMprotInfo record, BCntMprotInfoExample example);

    int updateByExample(BCntMprotInfo record, BCntMprotInfoExample example);

    int updateByPrimaryKeySelective(BCntMprotInfo record);

    int updateByPrimaryKey(BCntMprotInfo record);

    List<BCntMprotInfo> selectByPage(BCntMprotInfoExample example, Page page);
}