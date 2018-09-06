package com.huateng.scf.nbas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.dao.model.BPrdFlow;
import com.huateng.scf.nbas.prd.dao.model.BPrdFlowExample;
import java.util.List;

public interface IBPrdFlowDAO {
    int countByExample(BPrdFlowExample example);

    int deleteByExample(BPrdFlowExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdFlow record);

    void insertSelective(BPrdFlow record);

    List<BPrdFlow> selectByExample(BPrdFlowExample example);

    BPrdFlow selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdFlow record, BPrdFlowExample example);

    int updateByExample(BPrdFlow record, BPrdFlowExample example);

    int updateByPrimaryKeySelective(BPrdFlow record);

    int updateByPrimaryKey(BPrdFlow record);

    List<BPrdFlow> selectByPage(BPrdFlowExample example, Page page);
}