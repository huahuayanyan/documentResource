package com.huateng.scf.bas.crm.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRelExample;
import java.util.List;

public interface IBCrmTagCloudRelDAO {
    int countByExample(BCrmTagCloudRelExample example);

    int deleteByExample(BCrmTagCloudRelExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCrmTagCloudRel record);

    void insertSelective(BCrmTagCloudRel record);

    List<BCrmTagCloudRel> selectByExample(BCrmTagCloudRelExample example);

    BCrmTagCloudRel selectByPrimaryKey(String id);

    int updateByExampleSelective(BCrmTagCloudRel record, BCrmTagCloudRelExample example);

    int updateByExample(BCrmTagCloudRel record, BCrmTagCloudRelExample example);

    int updateByPrimaryKeySelective(BCrmTagCloudRel record);

    int updateByPrimaryKey(BCrmTagCloudRel record);

    List<BCrmTagCloudRel> selectByPage(BCrmTagCloudRelExample example, Page page);
}