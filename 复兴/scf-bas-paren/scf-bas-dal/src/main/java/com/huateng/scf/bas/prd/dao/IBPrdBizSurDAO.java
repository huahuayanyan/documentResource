package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSur;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSurExample;
import java.util.List;

public interface IBPrdBizSurDAO {
    int countByExample(BPrdBizSurExample example);

    int deleteByExample(BPrdBizSurExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdBizSur record);

    void insertSelective(BPrdBizSur record);

    List<BPrdBizSur> selectByExample(BPrdBizSurExample example);

    BPrdBizSur selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdBizSur record, BPrdBizSurExample example);

    int updateByExample(BPrdBizSur record, BPrdBizSurExample example);

    int updateByPrimaryKeySelective(BPrdBizSur record);

    int updateByPrimaryKey(BPrdBizSur record);

    List<BPrdBizSur> selectByPage(BPrdBizSurExample example, Page page);
    
}