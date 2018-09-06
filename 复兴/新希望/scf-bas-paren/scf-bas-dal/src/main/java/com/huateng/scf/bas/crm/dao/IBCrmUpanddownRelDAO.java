package com.huateng.scf.bas.crm.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel;
import com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRelExample;
import java.util.List;

public interface IBCrmUpanddownRelDAO {
    int countByExample(BCrmUpanddownRelExample example);

    int deleteByExample(BCrmUpanddownRelExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCrmUpanddownRel record);

    void insertSelective(BCrmUpanddownRel record);

    List<BCrmUpanddownRel> selectByExample(BCrmUpanddownRelExample example);

    BCrmUpanddownRel selectByPrimaryKey(String id);

    int updateByExampleSelective(BCrmUpanddownRel record, BCrmUpanddownRelExample example);

    int updateByExample(BCrmUpanddownRel record, BCrmUpanddownRelExample example);

    int updateByPrimaryKeySelective(BCrmUpanddownRel record);

    int updateByPrimaryKey(BCrmUpanddownRel record);

    List<BCrmUpanddownRel> selectByPage(BCrmUpanddownRelExample example, Page page);
}