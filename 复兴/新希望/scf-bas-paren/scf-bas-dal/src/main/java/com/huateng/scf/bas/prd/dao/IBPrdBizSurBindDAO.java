package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSurBindExample;
import java.util.List;

public interface IBPrdBizSurBindDAO {
    int countByExample(BPrdBizSurBindExample example);

    int deleteByExample(BPrdBizSurBindExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdBizSurBind record);

    void insertSelective(BPrdBizSurBind record);

    List<BPrdBizSurBind> selectByExample(BPrdBizSurBindExample example);

    BPrdBizSurBind selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdBizSurBind record, BPrdBizSurBindExample example);

    int updateByExample(BPrdBizSurBind record, BPrdBizSurBindExample example);

    int updateByPrimaryKeySelective(BPrdBizSurBind record);

    int updateByPrimaryKey(BPrdBizSurBind record);

    List<BPrdBizSurBind> selectByPage(BPrdBizSurBindExample example, Page page);
}