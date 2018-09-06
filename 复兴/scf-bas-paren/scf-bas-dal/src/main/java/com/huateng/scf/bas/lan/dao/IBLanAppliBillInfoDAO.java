package com.huateng.scf.bas.lan.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.dao.model.BLanAppliBillInfo;
import com.huateng.scf.bas.lan.dao.model.BLanAppliBillInfoExample;
import java.util.List;

public interface IBLanAppliBillInfoDAO {
    int countByExample(BLanAppliBillInfoExample example);

    int deleteByExample(BLanAppliBillInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BLanAppliBillInfo record);

    void insertSelective(BLanAppliBillInfo record);

    List<BLanAppliBillInfo> selectByExample(BLanAppliBillInfoExample example);

    List<BLanAppliBillInfo> selectByAppno(String appno);
    
    BLanAppliBillInfo selectByPrimaryKey(String id);
    
    BLanAppliBillInfo selectByBillId(String billid);

    int updateByExampleSelective(BLanAppliBillInfo record, BLanAppliBillInfoExample example);

    int updateByExample(BLanAppliBillInfo record, BLanAppliBillInfoExample example);

    int updateByPrimaryKeySelective(BLanAppliBillInfo record);

    int updateByPrimaryKey(BLanAppliBillInfo record);

    List<BLanAppliBillInfo> selectByPage(BLanAppliBillInfoExample example, Page page);
}