package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatl;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatlExample;

import java.nio.channels.SelectableChannel;
import java.util.List;

public interface IBPrdReceMatlDAO {
    int countByExample(BPrdReceMatlExample example);

    int deleteByExample(BPrdReceMatlExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdReceMatl record);

    void insertSelective(BPrdReceMatl record);

    List<BPrdReceMatl> selectByExample(BPrdReceMatlExample example);

    BPrdReceMatl selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdReceMatl record, BPrdReceMatlExample example);

    int updateByExample(BPrdReceMatl record, BPrdReceMatlExample example);

    int updateByPrimaryKeySelective(BPrdReceMatl record);

    int updateByPrimaryKey(BPrdReceMatl record);

    List<BPrdReceMatl> selectByPage(BPrdReceMatlExample example, Page page);
   //批量查询
    List<BPrdReceMatl> selectByIdList(List<String> idList);

}