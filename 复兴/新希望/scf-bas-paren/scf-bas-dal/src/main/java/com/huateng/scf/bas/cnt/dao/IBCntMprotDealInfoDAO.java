package com.huateng.scf.bas.cnt.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfoExample;
import java.util.List;

public interface IBCntMprotDealInfoDAO {
    int countByExample(BCntMprotDealInfoExample example);

    int deleteByExample(BCntMprotDealInfoExample example);

    int deleteByPrimaryKey(String protocolNo);

    void insert(BCntMprotDealInfo record);

    void insertSelective(BCntMprotDealInfo record);

    List<BCntMprotDealInfo> selectByExample(BCntMprotDealInfoExample example);

    BCntMprotDealInfo selectByPrimaryKey(String protocolNo);

    int updateByExampleSelective(BCntMprotDealInfo record, BCntMprotDealInfoExample example);

    int updateByExample(BCntMprotDealInfo record, BCntMprotDealInfoExample example);

    int updateByPrimaryKeySelective(BCntMprotDealInfo record);

    int updateByPrimaryKey(BCntMprotDealInfo record);

    List<BCntMprotDealInfo> selectByPage(BCntMprotDealInfoExample example, Page page);
}