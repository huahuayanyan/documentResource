package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.model.BDcrLinCnfg;
import com.huateng.scf.bas.dcr.model.BDcrLinCnfgExample;
import java.util.List;

public interface BDcrLinCnfgDAO {
    int countByExample(BDcrLinCnfgExample example);

    int deleteByExample(BDcrLinCnfgExample example);

    int deleteByPrimaryKey(String typId);

    void insert(BDcrLinCnfg record);

    void insertSelective(BDcrLinCnfg record);

    List<BDcrLinCnfg> selectByExample(BDcrLinCnfgExample example);

    BDcrLinCnfg selectByPrimaryKey(String typId);

    int updateByExampleSelective(BDcrLinCnfg record, BDcrLinCnfgExample example);

    int updateByExample(BDcrLinCnfg record, BDcrLinCnfgExample example);

    int updateByPrimaryKeySelective(BDcrLinCnfg record);

    int updateByPrimaryKey(BDcrLinCnfg record);

    List<BDcrLinCnfg> selectByPage(BDcrLinCnfgExample example, Page page);
}