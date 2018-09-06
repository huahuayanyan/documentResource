package com.huateng.scf.nbas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.dao.model.BPrdChkdirInfo;
import com.huateng.scf.nbas.prd.dao.model.BPrdChkdirInfoExample;
import java.util.List;

public interface IBPrdChkdirInfoDAO {
    int countByExample(BPrdChkdirInfoExample example);

    int deleteByExample(BPrdChkdirInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdChkdirInfo record);

    void insertSelective(BPrdChkdirInfo record);

    List<BPrdChkdirInfo> selectByExample(BPrdChkdirInfoExample example);

    BPrdChkdirInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdChkdirInfo record, BPrdChkdirInfoExample example);

    int updateByExample(BPrdChkdirInfo record, BPrdChkdirInfoExample example);

    int updateByPrimaryKeySelective(BPrdChkdirInfo record);

    int updateByPrimaryKey(BPrdChkdirInfo record);

    List<BPrdChkdirInfo> selectByPage(BPrdChkdirInfoExample example, Page page);
}