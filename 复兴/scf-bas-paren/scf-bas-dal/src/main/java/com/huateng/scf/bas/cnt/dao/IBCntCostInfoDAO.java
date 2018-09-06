package com.huateng.scf.bas.cnt.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntCostInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntCostInfoExample;
import java.util.List;

public interface IBCntCostInfoDAO {
    int countByExample(BCntCostInfoExample example);

    int deleteByExample(BCntCostInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCntCostInfo record);

    void insertSelective(BCntCostInfo record);

    List<BCntCostInfo> selectByExample(BCntCostInfoExample example);

    BCntCostInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BCntCostInfo record, BCntCostInfoExample example);

    int updateByExample(BCntCostInfo record, BCntCostInfoExample example);

    int updateByPrimaryKeySelective(BCntCostInfo record);

    int updateByPrimaryKey(BCntCostInfo record);

    List<BCntCostInfo> selectByPage(BCntCostInfoExample example, Page page);
    //EXT
    //根据关联号/关联号和关联类型获取费用信息
    BCntCostInfo findCostInfoByContno(BCntCostInfo bCntCostInfo);
}