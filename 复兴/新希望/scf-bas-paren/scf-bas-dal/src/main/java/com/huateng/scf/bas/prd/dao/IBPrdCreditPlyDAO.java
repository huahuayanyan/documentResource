package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditPly;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditPlyExample;
import java.util.List;

public interface IBPrdCreditPlyDAO {
    int countByExample(BPrdCreditPlyExample example);

    int deleteByExample(BPrdCreditPlyExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdCreditPly record);

    void insertSelective(BPrdCreditPly record);

    List<BPrdCreditPly> selectByExample(BPrdCreditPlyExample example);

    BPrdCreditPly selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdCreditPly record, BPrdCreditPlyExample example);

    int updateByExample(BPrdCreditPly record, BPrdCreditPlyExample example);

    int updateByPrimaryKeySelective(BPrdCreditPly record);

    int updateByPrimaryKey(BPrdCreditPly record);

    List<BPrdCreditPly> selectByPage(BPrdCreditPlyExample example, Page page);
}