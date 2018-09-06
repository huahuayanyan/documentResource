package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.prd.dao.model.BPrdInfoExample;
import java.util.List;

public interface IBPrdInfoDAO {
    int countByExample(BPrdInfoExample example);

    int deleteByExample(BPrdInfoExample example);

    int deleteByPrimaryKey(String productId);

    void insert(BPrdInfo record);

    void insertSelective(BPrdInfo record);

    List<BPrdInfo> selectByExample(BPrdInfoExample example);

    BPrdInfo selectByPrimaryKey(String productId);

    int updateByExampleSelective(BPrdInfo record, BPrdInfoExample example);

    int updateByExample(BPrdInfo record, BPrdInfoExample example);

    int updateByPrimaryKeySelective(BPrdInfo record);

    int updateByPrimaryKey(BPrdInfo record);

    List<BPrdInfo> selectByPage(BPrdInfoExample example, Page page);
}