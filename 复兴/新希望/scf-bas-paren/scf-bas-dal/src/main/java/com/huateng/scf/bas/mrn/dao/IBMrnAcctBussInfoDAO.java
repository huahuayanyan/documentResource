package com.huateng.scf.bas.mrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfoExample;
import java.util.List;

public interface IBMrnAcctBussInfoDAO {
    int countByExample(BMrnAcctBussInfoExample example);

    int deleteByExample(BMrnAcctBussInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BMrnAcctBussInfo record);

    void insertSelective(BMrnAcctBussInfo record);

    List<BMrnAcctBussInfo> selectByExample(BMrnAcctBussInfoExample example);
    
    List<BMrnAcctBussInfo> selectByAppno(String appno);

    BMrnAcctBussInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BMrnAcctBussInfo record, BMrnAcctBussInfoExample example);

    int updateByExample(BMrnAcctBussInfo record, BMrnAcctBussInfoExample example);

    int updateByPrimaryKeySelective(BMrnAcctBussInfo record);

    int updateByPrimaryKey(BMrnAcctBussInfo record);

    List<BMrnAcctBussInfo> selectByPage(BMrnAcctBussInfoExample example, Page page);
}