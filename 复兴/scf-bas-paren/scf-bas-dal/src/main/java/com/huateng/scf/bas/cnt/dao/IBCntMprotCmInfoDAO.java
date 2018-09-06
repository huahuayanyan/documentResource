package com.huateng.scf.bas.cnt.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmInfoExample;
import java.util.List;

public interface IBCntMprotCmInfoDAO {
    int countByExample(BCntMprotCmInfoExample example);

    int deleteByExample(BCntMprotCmInfoExample example);

    int deleteByPrimaryKey(String protocolNo);

    void insert(BCntMprotCmInfo record);

    void insertSelective(BCntMprotCmInfo record);

    List<BCntMprotCmInfo> selectByExample(BCntMprotCmInfoExample example);

    BCntMprotCmInfo selectByPrimaryKey(String protocolNo);

    int updateByExampleSelective(BCntMprotCmInfo record, BCntMprotCmInfoExample example);

    int updateByExample(BCntMprotCmInfo record, BCntMprotCmInfoExample example);

    int updateByPrimaryKeySelective(BCntMprotCmInfo record);

    int updateByPrimaryKey(BCntMprotCmInfo record);

    List<BCntMprotCmInfo> selectByPage(BCntMprotCmInfoExample example, Page page);
}