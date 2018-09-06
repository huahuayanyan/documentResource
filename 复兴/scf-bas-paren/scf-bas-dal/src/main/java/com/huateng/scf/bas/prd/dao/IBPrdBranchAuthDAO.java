package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdBranchAuth;
import com.huateng.scf.bas.prd.dao.model.BPrdBranchAuthExample;

import java.util.List;

public interface IBPrdBranchAuthDAO {
    int countByExample(BPrdBranchAuthExample example);

    int deleteByExample(BPrdBranchAuthExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdBranchAuth record);

    void insertSelective(BPrdBranchAuth record);

    List<BPrdBranchAuth> selectByExample(BPrdBranchAuthExample example);

    BPrdBranchAuth selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdBranchAuth record, BPrdBranchAuthExample example);

    int updateByExample(BPrdBranchAuth record, BPrdBranchAuthExample example);

    int updateByPrimaryKeySelective(BPrdBranchAuth record);

    int updateByPrimaryKey(BPrdBranchAuth record);

    List<BPrdBranchAuth> selectByPage(BPrdBranchAuthExample example, Page page);
}