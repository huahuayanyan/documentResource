package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysRegion;
import com.huateng.scf.bas.sys.dao.model.BSysRegionExample;
import java.util.List;

public interface IBSysRegionDAO {
    int countByExample(BSysRegionExample example);

    int deleteByExample(BSysRegionExample example);

    int deleteByPrimaryKey(String id);

    void insert(BSysRegion record);

    void insertSelective(BSysRegion record);

    List<BSysRegion> selectByExample(BSysRegionExample example);

    BSysRegion selectByPrimaryKey(String id);

    int updateByExampleSelective(BSysRegion record, BSysRegionExample example);

    int updateByExample(BSysRegion record, BSysRegionExample example);

    int updateByPrimaryKeySelective(BSysRegion record);

    int updateByPrimaryKey(BSysRegion record);

    List<BSysRegion> selectByPage(BSysRegionExample example, Page page);
}