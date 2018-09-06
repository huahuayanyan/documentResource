package com.huateng.scf.ods.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.ods.dao.model.OdsTopCity;
import com.huateng.scf.ods.dao.model.OdsTopCityExample;
import java.util.List;

public interface IOdsTopCityDAO {
    int countByExample(OdsTopCityExample example);

    int deleteByExample(OdsTopCityExample example);

    int deleteByPrimaryKey(String id);

    void insert(OdsTopCity record);

    void insertSelective(OdsTopCity record);

    List<OdsTopCity> selectByExample(OdsTopCityExample example);

    OdsTopCity selectByPrimaryKey(String id);

    int updateByExampleSelective(OdsTopCity record, OdsTopCityExample example);

    int updateByExample(OdsTopCity record, OdsTopCityExample example);

    int updateByPrimaryKeySelective(OdsTopCity record);

    int updateByPrimaryKey(OdsTopCity record);

    List<OdsTopCity> selectByPage(OdsTopCityExample example, Page page);
}