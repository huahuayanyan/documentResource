package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdCostBind;
import com.huateng.scf.bas.prd.dao.model.BPrdCostBindExample;
import java.util.List;

public interface IBPrdCostBindDAO {
    int countByExample(BPrdCostBindExample example);

    int deleteByExample(BPrdCostBindExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdCostBind record);

    void insertSelective(BPrdCostBind record);

    List<BPrdCostBind> selectByExample(BPrdCostBindExample example);

    BPrdCostBind selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdCostBind record, BPrdCostBindExample example);

    int updateByExample(BPrdCostBind record, BPrdCostBindExample example);

    int updateByPrimaryKeySelective(BPrdCostBind record);

    int updateByPrimaryKey(BPrdCostBind record);

    List<BPrdCostBind> selectByPage(BPrdCostBindExample example, Page page);
}