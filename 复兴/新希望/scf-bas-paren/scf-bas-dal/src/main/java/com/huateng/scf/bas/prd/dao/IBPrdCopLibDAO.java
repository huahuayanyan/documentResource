package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLib;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLibExample;
import java.util.List;

public interface IBPrdCopLibDAO {
    int countByExample(BPrdCopLibExample example);

    int deleteByExample(BPrdCopLibExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdCopLib record);

    void insertSelective(BPrdCopLib record);

    List<BPrdCopLib> selectByExample(BPrdCopLibExample example);

    BPrdCopLib selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdCopLib record, BPrdCopLibExample example);

    int updateByExample(BPrdCopLib record, BPrdCopLibExample example);

    int updateByPrimaryKeySelective(BPrdCopLib record);

    int updateByPrimaryKey(BPrdCopLib record);

    List<BPrdCopLib> selectByPage(BPrdCopLibExample example, Page page);
}