package com.huateng.scf.ods.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.ods.dao.model.OFinaStaAnalysis;
import com.huateng.scf.ods.dao.model.OFinaStaAnalysisExample;
import java.util.List;

public interface IOFinaStaAnalysisDAO {
    int countByExample(OFinaStaAnalysisExample example);

    int deleteByExample(OFinaStaAnalysisExample example);

    int deleteByPrimaryKey(String id);

    void insert(OFinaStaAnalysis record);

    void insertSelective(OFinaStaAnalysis record);

    List<OFinaStaAnalysis> selectByExample(OFinaStaAnalysisExample example);

    OFinaStaAnalysis selectByPrimaryKey(String id);

    int updateByExampleSelective(OFinaStaAnalysis record, OFinaStaAnalysisExample example);

    int updateByExample(OFinaStaAnalysis record, OFinaStaAnalysisExample example);

    int updateByPrimaryKeySelective(OFinaStaAnalysis record);

    int updateByPrimaryKey(OFinaStaAnalysis record);

    List<OFinaStaAnalysis> selectByPage(OFinaStaAnalysisExample example, Page page);
}