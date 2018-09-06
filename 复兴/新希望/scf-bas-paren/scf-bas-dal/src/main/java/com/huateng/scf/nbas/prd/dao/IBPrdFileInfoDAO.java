package com.huateng.scf.nbas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.dao.model.BPrdFileInfo;
import com.huateng.scf.nbas.prd.dao.model.BPrdFileInfoExample;
import java.util.List;

public interface IBPrdFileInfoDAO {
    int countByExample(BPrdFileInfoExample example);

    int deleteByExample(BPrdFileInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdFileInfo record);

    void insertSelective(BPrdFileInfo record);

    List<BPrdFileInfo> selectByExample(BPrdFileInfoExample example);

    BPrdFileInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdFileInfo record, BPrdFileInfoExample example);

    int updateByExample(BPrdFileInfo record, BPrdFileInfoExample example);

    int updateByPrimaryKeySelective(BPrdFileInfo record);

    int updateByPrimaryKey(BPrdFileInfo record);

    List<BPrdFileInfo> selectByPage(BPrdFileInfoExample example, Page page);
}