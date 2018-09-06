package com.huateng.scf.bas.lan.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfoExample;
import java.util.List;

public interface IBLanLnciBuyInfoDAO {
    int countByExample(BLanLnciBuyInfoExample example);

    int deleteByExample(BLanLnciBuyInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BLanLnciBuyInfo record);

    void insertSelective(BLanLnciBuyInfo record);

    List<BLanLnciBuyInfo> selectByExample(BLanLnciBuyInfoExample example);

    BLanLnciBuyInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BLanLnciBuyInfo record, BLanLnciBuyInfoExample example);

    int updateByExample(BLanLnciBuyInfo record, BLanLnciBuyInfoExample example);

    int updateByPrimaryKeySelective(BLanLnciBuyInfo record);

    int updateByPrimaryKey(BLanLnciBuyInfo record);

    List<BLanLnciBuyInfo> selectByPage(BLanLnciBuyInfoExample example, Page page);
}