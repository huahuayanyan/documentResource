package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdBaseInfo;
import com.huateng.scf.bas.prd.dao.model.BPrdBaseInfoExample;
import java.util.List;

public interface IBPrdBaseInfoDAO {
    int countByExample(BPrdBaseInfoExample example);

    int deleteByExample(BPrdBaseInfoExample example);

    int deleteByPrimaryKey(String productId);

    void insert(BPrdBaseInfo record);

    void insertSelective(BPrdBaseInfo record);

    List<BPrdBaseInfo> selectByExample(BPrdBaseInfoExample example);

    BPrdBaseInfo selectByPrimaryKey(String productId);

    int updateByExampleSelective(BPrdBaseInfo record, BPrdBaseInfoExample example);

    int updateByExample(BPrdBaseInfo record, BPrdBaseInfoExample example);

    int updateByPrimaryKeySelective(BPrdBaseInfo record);

    int updateByPrimaryKey(BPrdBaseInfo record);

    List<BPrdBaseInfo> selectByPage(BPrdBaseInfoExample example, Page page);
}