package com.huateng.scf.bas.mrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.dao.model.BMrnBussInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnBussInfoExample;
import java.util.List;

public interface IBMrnBussInfoDAO {
    int countByExample(BMrnBussInfoExample example);

    int deleteByExample(BMrnBussInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BMrnBussInfo record);

    void insertSelective(BMrnBussInfo record);

    List<BMrnBussInfo> selectByExample(BMrnBussInfoExample example);

    BMrnBussInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BMrnBussInfo record, BMrnBussInfoExample example);

    int updateByExample(BMrnBussInfo record, BMrnBussInfoExample example);

    int updateByPrimaryKeySelective(BMrnBussInfo record);

    int updateByPrimaryKey(BMrnBussInfo record);

    List<BMrnBussInfo> selectByPage(BMrnBussInfoExample example, Page page);
}