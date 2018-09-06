package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdWkflowCop;
import com.huateng.scf.bas.prd.dao.model.BPrdWkflowCopExample;
import java.util.List;

public interface IBPrdWkflowCopDAO {
    int countByExample(BPrdWkflowCopExample example);

    int deleteByExample(BPrdWkflowCopExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdWkflowCop record);

    void insertSelective(BPrdWkflowCop record);

    List<BPrdWkflowCop> selectByExample(BPrdWkflowCopExample example);

    BPrdWkflowCop selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdWkflowCop record, BPrdWkflowCopExample example);

    int updateByExample(BPrdWkflowCop record, BPrdWkflowCopExample example);

    int updateByPrimaryKeySelective(BPrdWkflowCop record);

    int updateByPrimaryKey(BPrdWkflowCop record);

    List<BPrdWkflowCop> selectByPage(BPrdWkflowCopExample example, Page page);
}