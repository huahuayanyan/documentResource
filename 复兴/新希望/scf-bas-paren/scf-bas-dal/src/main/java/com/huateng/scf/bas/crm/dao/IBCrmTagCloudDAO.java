package com.huateng.scf.bas.crm.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloud;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloudExample;
import java.util.List;

public interface IBCrmTagCloudDAO {
    int countByExample(BCrmTagCloudExample example);

    int deleteByExample(BCrmTagCloudExample example);

    int deleteByPrimaryKey(String custCd);

    void insert(BCrmTagCloud record);

    void insertSelective(BCrmTagCloud record);

    List<BCrmTagCloud> selectByExample(BCrmTagCloudExample example);

    BCrmTagCloud selectByPrimaryKey(String custCd);

    int updateByExampleSelective(BCrmTagCloud record, BCrmTagCloudExample example);

    int updateByExample(BCrmTagCloud record, BCrmTagCloudExample example);

    int updateByPrimaryKeySelective(BCrmTagCloud record);

    int updateByPrimaryKey(BCrmTagCloud record);

    List<BCrmTagCloud> selectByPage(BCrmTagCloudExample example, Page page);
}