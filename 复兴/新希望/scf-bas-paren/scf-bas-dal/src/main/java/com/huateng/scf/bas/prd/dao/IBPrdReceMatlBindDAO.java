package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBindExample;
import java.util.List;

public interface IBPrdReceMatlBindDAO {
    int countByExample(BPrdReceMatlBindExample example);

    int deleteByExample(BPrdReceMatlBindExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdReceMatlBind record);

    void insertSelective(BPrdReceMatlBind record);

    List<BPrdReceMatlBind> selectByExample(BPrdReceMatlBindExample example);

    BPrdReceMatlBind selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdReceMatlBind record, BPrdReceMatlBindExample example);

    int updateByExample(BPrdReceMatlBind record, BPrdReceMatlBindExample example);

    int updateByPrimaryKeySelective(BPrdReceMatlBind record);

    int updateByPrimaryKey(BPrdReceMatlBind record);

    List<BPrdReceMatlBind> selectByPage(BPrdReceMatlBindExample example, Page page);
}