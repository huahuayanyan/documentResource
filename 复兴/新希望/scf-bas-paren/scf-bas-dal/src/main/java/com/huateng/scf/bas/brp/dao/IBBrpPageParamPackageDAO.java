package com.huateng.scf.bas.brp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackage;
import com.huateng.scf.bas.brp.dao.model.BBrpPageParamPackageExample;
import java.util.List;

public interface IBBrpPageParamPackageDAO {
    int countByExample(BBrpPageParamPackageExample example);

    int deleteByExample(BBrpPageParamPackageExample example);

    int deleteByPrimaryKey(String id);

    void insert(BBrpPageParamPackage record);

    void insertSelective(BBrpPageParamPackage record);

    List<BBrpPageParamPackage> selectByExample(BBrpPageParamPackageExample example);

    BBrpPageParamPackage selectByPrimaryKey(String id);

    int updateByExampleSelective(BBrpPageParamPackage record, BBrpPageParamPackageExample example);

    int updateByExample(BBrpPageParamPackage record, BBrpPageParamPackageExample example);

    int updateByPrimaryKeySelective(BBrpPageParamPackage record);

    int updateByPrimaryKey(BBrpPageParamPackage record);

    List<BBrpPageParamPackage> selectByPage(BBrpPageParamPackageExample example, Page page);
}