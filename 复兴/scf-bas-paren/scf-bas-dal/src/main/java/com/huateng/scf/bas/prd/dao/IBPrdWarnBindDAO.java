package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdWarnBind;
import com.huateng.scf.bas.prd.dao.model.BPrdWarnBindExample;
import java.util.List;

public interface IBPrdWarnBindDAO {
    int countByExample(BPrdWarnBindExample example);

    int deleteByExample(BPrdWarnBindExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdWarnBind record);

    void insertSelective(BPrdWarnBind record);

    List<BPrdWarnBind> selectByExample(BPrdWarnBindExample example);

    BPrdWarnBind selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdWarnBind record, BPrdWarnBindExample example);

    int updateByExample(BPrdWarnBind record, BPrdWarnBindExample example);

    int updateByPrimaryKeySelective(BPrdWarnBind record);

    int updateByPrimaryKey(BPrdWarnBind record);

    List<BPrdWarnBind> selectByPage(BPrdWarnBindExample example, Page page);
}