package com.huateng.scf.ods.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.ods.dao.model.OCrmTag;
import com.huateng.scf.ods.dao.model.OCrmTagExample;
import java.util.List;

public interface IOCrmTagDAO {
    int countByExample(OCrmTagExample example);

    int deleteByExample(OCrmTagExample example);

    int deleteByPrimaryKey(String id);

    void insert(OCrmTag record);

    void insertSelective(OCrmTag record);

    List<OCrmTag> selectByExample(OCrmTagExample example);

    OCrmTag selectByPrimaryKey(String id);

    int updateByExampleSelective(OCrmTag record, OCrmTagExample example);

    int updateByExample(OCrmTag record, OCrmTagExample example);

    int updateByPrimaryKeySelective(OCrmTag record);

    int updateByPrimaryKey(OCrmTag record);

    List<OCrmTag> selectByPage(OCrmTagExample example, Page page);
}