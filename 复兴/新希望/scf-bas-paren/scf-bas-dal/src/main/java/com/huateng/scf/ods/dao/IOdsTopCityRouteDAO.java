package com.huateng.scf.ods.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.ods.dao.model.OdsTopCityRoute;
import com.huateng.scf.ods.dao.model.OdsTopCityRouteExample;
import java.util.List;

public interface IOdsTopCityRouteDAO {
    int countByExample(OdsTopCityRouteExample example);

    int deleteByExample(OdsTopCityRouteExample example);

    int deleteByPrimaryKey(String id);

    void insert(OdsTopCityRoute record);

    void insertSelective(OdsTopCityRoute record);

    List<OdsTopCityRoute> selectByExample(OdsTopCityRouteExample example);

    OdsTopCityRoute selectByPrimaryKey(String id);

    int updateByExampleSelective(OdsTopCityRoute record, OdsTopCityRouteExample example);

    int updateByExample(OdsTopCityRoute record, OdsTopCityRouteExample example);

    int updateByPrimaryKeySelective(OdsTopCityRoute record);

    int updateByPrimaryKey(OdsTopCityRoute record);

    List<OdsTopCityRoute> selectByPage(OdsTopCityRouteExample example, Page page);
}