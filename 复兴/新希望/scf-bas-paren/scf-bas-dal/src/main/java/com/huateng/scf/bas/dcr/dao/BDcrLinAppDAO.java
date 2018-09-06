package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.model.BDcrLinApp;
import com.huateng.scf.bas.dcr.model.BDcrLinAppExample;
import java.util.List;

public interface BDcrLinAppDAO {
    int countByExample(BDcrLinAppExample example);

    int deleteByExample(BDcrLinAppExample example);

    int deleteByPrimaryKey(String appCrId);

    void insert(BDcrLinApp record);

    void insertSelective(BDcrLinApp record);

    List<BDcrLinApp> selectByExample(BDcrLinAppExample example);

    BDcrLinApp selectByPrimaryKey(String appCrId);

    int updateByExampleSelective(BDcrLinApp record, BDcrLinAppExample example);

    int updateByExample(BDcrLinApp record, BDcrLinAppExample example);

    int updateByPrimaryKeySelective(BDcrLinApp record);

    int updateByPrimaryKey(BDcrLinApp record);

    List<BDcrLinApp> selectByPage(BDcrLinAppExample example, Page page);
}