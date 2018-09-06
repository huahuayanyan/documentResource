package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.model.BDcrLin;
import com.huateng.scf.bas.dcr.model.BDcrLinExample;
import java.util.List;

public interface BDcrLinDAO {
    int countByExample(BDcrLinExample example);

    int deleteByExample(BDcrLinExample example);

    int deleteByPrimaryKey(String bcCrId);

    void insert(BDcrLin record);

    void insertSelective(BDcrLin record);

    List<BDcrLin> selectByExample(BDcrLinExample example);

    BDcrLin selectByPrimaryKey(String bcCrId);

    int updateByExampleSelective(BDcrLin record, BDcrLinExample example);

    int updateByExample(BDcrLin record, BDcrLinExample example);

    int updateByPrimaryKeySelective(BDcrLin record);

    int updateByPrimaryKey(BDcrLin record);

    List<BDcrLin> selectByPage(BDcrLinExample example, Page page);
}