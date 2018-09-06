package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLibBindExample;
import java.util.List;

public interface IBPrdCopLibBindDAO {
    int countByExample(BPrdCopLibBindExample example);

    int deleteByExample(BPrdCopLibBindExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdCopLibBind record);

    void insertSelective(BPrdCopLibBind record);

    List<BPrdCopLibBind> selectByExample(BPrdCopLibBindExample example);

    BPrdCopLibBind selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdCopLibBind record, BPrdCopLibBindExample example);

    int updateByExample(BPrdCopLibBind record, BPrdCopLibBindExample example);

    int updateByPrimaryKeySelective(BPrdCopLibBind record);

    int updateByPrimaryKey(BPrdCopLibBind record);

    List<BPrdCopLibBind> selectByPage(BPrdCopLibBindExample example, Page page);
}