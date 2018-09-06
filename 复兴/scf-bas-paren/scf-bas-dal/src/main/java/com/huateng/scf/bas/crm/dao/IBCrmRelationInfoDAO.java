package com.huateng.scf.bas.crm.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmRelationInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmRelationInfoExample;
import java.util.List;

public interface IBCrmRelationInfoDAO {
    int countByExample(BCrmRelationInfoExample example);

    int deleteByExample(BCrmRelationInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCrmRelationInfo record);

    void insertSelective(BCrmRelationInfo record);

    List<BCrmRelationInfo> selectByExample(BCrmRelationInfoExample example);

    BCrmRelationInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BCrmRelationInfo record, BCrmRelationInfoExample example);

    int updateByExample(BCrmRelationInfo record, BCrmRelationInfoExample example);

    int updateByPrimaryKeySelective(BCrmRelationInfo record);

    int updateByPrimaryKey(BCrmRelationInfo record);

    List<BCrmRelationInfo> selectByPage(BCrmRelationInfoExample example, Page page);
}