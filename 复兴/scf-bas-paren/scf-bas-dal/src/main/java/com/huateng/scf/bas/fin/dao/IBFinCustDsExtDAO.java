package com.huateng.scf.bas.fin.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExt;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExtExample;
import java.util.List;

public interface IBFinCustDsExtDAO {
    int countByExample(BFinCustDsExtExample example);

    int deleteByExample(BFinCustDsExtExample example);

    int deleteByPrimaryKey(String id);

    void insert(BFinCustDsExt record);

    void insertSelective(BFinCustDsExt record);

    List<BFinCustDsExt> selectByExample(BFinCustDsExtExample example);

    BFinCustDsExt selectByPrimaryKey(String id);

    int updateByExampleSelective(BFinCustDsExt record, BFinCustDsExtExample example);

    int updateByExample(BFinCustDsExt record, BFinCustDsExtExample example);

    int updateByPrimaryKeySelective(BFinCustDsExt record);

    int updateByPrimaryKey(BFinCustDsExt record);

    List<BFinCustDsExt> selectByPage(BFinCustDsExtExample example, Page page);
}