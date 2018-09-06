package com.huateng.scf.nbas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.dao.model.BPrdPrintInfo;
import com.huateng.scf.nbas.prd.dao.model.BPrdPrintInfoExample;
import java.util.List;

public interface IBPrdPrintInfoDAO {
    int countByExample(BPrdPrintInfoExample example);

    int deleteByExample(BPrdPrintInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdPrintInfo record);

    void insertSelective(BPrdPrintInfo record);

    List<BPrdPrintInfo> selectByExampleWithBLOBs(BPrdPrintInfoExample example);

    List<BPrdPrintInfo> selectByExampleWithoutBLOBs(BPrdPrintInfoExample example);

    BPrdPrintInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdPrintInfo record, BPrdPrintInfoExample example);

    int updateByExampleWithBLOBs(BPrdPrintInfo record, BPrdPrintInfoExample example);

    int updateByExampleWithoutBLOBs(BPrdPrintInfo record, BPrdPrintInfoExample example);

    int updateByPrimaryKeySelective(BPrdPrintInfo record);

    int updateByPrimaryKeyWithBLOBs(BPrdPrintInfo record);

    int updateByPrimaryKeyWithoutBLOBs(BPrdPrintInfo record);

    List<BPrdPrintInfo> selectByPage(BPrdPrintInfoExample example, Page page);
}