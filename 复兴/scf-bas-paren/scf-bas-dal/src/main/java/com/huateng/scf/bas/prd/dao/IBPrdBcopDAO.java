package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdBcop;
import com.huateng.scf.bas.prd.dao.model.BPrdBcopExample;
import java.util.List;

public interface IBPrdBcopDAO {
    int countByExample(BPrdBcopExample example);

    int deleteByExample(BPrdBcopExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdBcop record);

    void insertSelective(BPrdBcop record);

    List<BPrdBcop> selectByExample(BPrdBcopExample example);

    BPrdBcop selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdBcop record, BPrdBcopExample example);

    int updateByExample(BPrdBcop record, BPrdBcopExample example);

    int updateByPrimaryKeySelective(BPrdBcop record);

    int updateByPrimaryKey(BPrdBcop record);

    List<BPrdBcop> selectByPage(BPrdBcopExample example, Page page);
    
    int batchDelete(List<String> idList);
}