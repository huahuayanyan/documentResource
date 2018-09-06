package com.huateng.scf.ods.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.ods.dao.model.OdsTopCityLine;
import com.huateng.scf.ods.dao.model.OdsTopCityLineExample;
import java.util.List;

public interface IOdsTopCityLineDAO {
    int countByExample(OdsTopCityLineExample example);

    int deleteByExample(OdsTopCityLineExample example);

    int deleteByPrimaryKey(String id);

    void insert(OdsTopCityLine record);

    void insertSelective(OdsTopCityLine record);

    List<OdsTopCityLine> selectByExample(OdsTopCityLineExample example);

    OdsTopCityLine selectByPrimaryKey(String id);

    int updateByExampleSelective(OdsTopCityLine record, OdsTopCityLineExample example);

    int updateByExample(OdsTopCityLine record, OdsTopCityLineExample example);

    int updateByPrimaryKeySelective(OdsTopCityLine record);

    int updateByPrimaryKey(OdsTopCityLine record);

    List<OdsTopCityLine> selectByPage(OdsTopCityLineExample example, Page page);
}